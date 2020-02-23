package Chat;

import Chat.common.*;
import Chat.ocsf.server.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.lang.String;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class EchoServer extends AbstractServer
{
    static private final String DB = "wlcjCucJm8";
    static private final String DB_URL = "jdbc:mysql://remotemysql.com/"+ DB + "?useSSL=false";
    static private final String USER = "wlcjCucJm8";
    static private final String PASS = "ono3VjFc4a";
    final public static int DEFAULT_PORT =5555;
    static private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    ChatIF serverUI;
    Connection conn = null;
    Statement stmt = null;


    public EchoServer(int port) {	super(port);	}

    public EchoServer(int port, ChatIF serverUI) throws IOException{
        super(port);
        this.serverUI = serverUI;
    }

    public void handleMessageFromClient (Object msg, ConnectionToClient client) throws SQLException, IOException
    {	runC((String)msg, client);	}

    public void handleMessageFromServerUI(String message) {runCommand(message);}

    private void runCommand(String message)
    {
        if (message.equalsIgnoreCase("quit"))
            try {
                quit();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        else if (message.equalsIgnoreCase("stop"))	stopListening();
        else if (message.equalsIgnoreCase("close"))
            try {
                close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        else if (message.toLowerCase().startsWith("setport")) {
            if (getNumberOfClients() == 0 && !isListening()){
                int newPort = Integer.parseInt(message.substring(9));
                setPort(newPort);
                serverUI.display("Server port changed to " + getPort());
            }else	serverUI.display("The server is not closed. Port cannot be changed.");
        }else
        if (message.equalsIgnoreCase("start")){
            if (!isListening()){
                try { listen(); }
                catch(Exception ex) { serverUI.display("Error - Could not listen for clients!"); }
            }
            else
                serverUI.display("The server is already listening for clients.");
        }
        else
        if (message.equalsIgnoreCase("getport"))
            serverUI.display("Currently port: " + Integer.toString(getPort()));
    }

    protected void serverStarted() {
        System.out.println("Server listening for connections on port " + getPort());
    }

    protected void serverStopped(){
        System.out.println("Server has stopped listening for connections.");
    }

    protected void clientConnected(ConnectionToClient client) {
        String msg = "A Client has connected";
        System.out.println(msg);
        //this.sendToAllClients(msg);
    }

    synchronized protected void clientDisconnected(ConnectionToClient client){
        String msg = client.getInfo("loginID").toString() + " has disconnected";
        System.out.println(msg);
        //this.sendToAllClients(msg);
    }

    synchronized protected void clientException(ConnectionToClient client, Throwable exception) {
        String msg = client.getInfo("loginID").toString() + " has disconnected";
        System.out.println(msg);
//        this.sendToAllClients(msg);
    }

    public void quit() throws IOException{
        close();
        System.exit(0);
    }







    void runC(String msg, ConnectionToClient client)  throws SQLException, IOException {

        try {	Class.forName(JDBC_DRIVER);	}
        catch (ClassNotFoundException e) {	e.printStackTrace();	}
        try {	conn = DriverManager.getConnection(DB_URL, USER, PASS);	}
        catch (SQLException e) {	e.printStackTrace();	}
        try {	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);	}
        catch (SQLException e) {	e.printStackTrace();	}


        String[] m = ((String) msg).split("#");




        if(m[0].contentEquals("addorder")) // input = "addorder#username#storeid#price#address#date#time (optional: #text)"
        {
            ////////////////////////////////date should be : dd-mm-yyyy

            String sql = "INSERT INTO orders (username, storeid, price, address, date, time, card, text)"
                    + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);

            prep_stmt.setString(1, m[1]); //username
            prep_stmt.setString(2, m[2]); // password
            prep_stmt.setString(3, m[3]); // address
            prep_stmt.setString(4, m[4]); // email
            prep_stmt.setString(5, m[5]); //phone
            prep_stmt.setString(6, m[6]); //storeid
            if(m.length > 7){
                prep_stmt.setString(7, "yes");
                prep_stmt.setString(8, m[7]);
            }else {
                prep_stmt.setString(7, "no");
                prep_stmt.setString(8, "no card");
            }
            prep_stmt.executeUpdate();
            client.sendToClient("added");
        }


        if(m[0].contentEquals("getuserorders")) // input = "getuserorders#username"
        {
            String sql = "SELECT * FROM orders WHERE NOT username = '"+m[1]+"'";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            ResultSet r = prep_stmt.executeQuery();
            String g="";
            while(r.next())
            {
                g = g +
                        r.getString(1) + "#" +
                        r.getString(2) + "#" +
                        r.getString(3) + "#" +
                        r.getString(4) + "#" +
                        r.getString(5) + "#" +
                        r.getString(6) + "#" +
                        r.getString(7) + "#" +
                        r.getString(8) + "#" +
                        r.getString(9) + "#" +
                        r.getString(10) + "/" ;
            }
            client.sendToClient(g);
        }



        if(m[0].contentEquals("getstoreordersbymonth")) // input = "getstoreordersbymonth#storeid#year#month"
        {
            String sql = "SELECT * FROM orders WHERE storeid = '"+m[1]+"'";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            ResultSet r = prep_stmt.executeQuery();
            String g="orders:\nUsername------price\n";

            while(r.next())
            {
                String tmp=r.getString(6);
                String[] d=tmp.split("-");
                if(d.length>2)
                    if(d[2].contentEquals(m[2]) && d[1].contentEquals(m[3]))
                    {

                        g = g + r.getString(2) + "-----";
                        g = g + r.getString(4) + "\n";

                    }
            }
            client.sendToClient(g);
        }



        if(m[0].contentEquals("getstorecompbymonth")) // input = "getstorecompbymonth#storeid#year#month"
        {
            String sql = "SELECT * FROM complaints WHERE storeid = '"+m[1]+"'";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            ResultSet r = prep_stmt.executeQuery();
            String g="complaints:\nusername--answered--date\n";
            while(r.next())
            {
                String tmp=r.getString(8);
                String[] d=tmp.split("-");
                if(d.length>2)
                    if(d[2].contentEquals(m[2]) && d[1].contentEquals(m[3]))
                    {

                        g = g + r.getString(2) + "-----";
                        g = g + r.getString(6) + "-----";
                        g = g +	tmp + "\n" ;

                    }
            }
            client.sendToClient(g);
        }


        if (m[0].contentEquals("deleteuser")){ // input="deleteuser#username
            String sql = "DELETE FROM `users` WHERE `username` = '"+m[1]+"'";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.executeQuery();
            client.sendToClient("deleted");
        }







        if (m[0].contentEquals("login")) { // input = "Login#username#password"

            String ret;
            String sql = "SELECT * FROM users WHERE UserName = ?";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.setString(1, m[1]);
            ResultSet r = prep_stmt.executeQuery();
            if(r.next()) {
                if(m[2].equals(r.getString("Password")))
                    if(r.getString("blocked").equals("no"))	ret= r.getString("auth");
                    else ret= "accessdenied";
                else ret= "wrongpass";
            }else  ret= "nosuchuser";
            client.sendToClient(ret);
        }


        // add user to users table
        if(m[0].contentEquals("adduser")) // input = "adduser#username#password#address#email#phone#storeid#authlevel (optional: #creditcard)"
        {
            String sql = "insert into users value (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.setString(1, m[1]); //username
            prep_stmt.setString(2, m[2]); // password
            prep_stmt.setString(3, m[3]); // address
            prep_stmt.setString(4, m[4]); // email
            prep_stmt.setString(5, m[5]); //phone
            prep_stmt.setString(8, m[6]); //storeid
            prep_stmt.setString(9, m[7]); //authlevel
            prep_stmt.setString(10, "no"); // blocked
            prep_stmt.setString(7, "0"); // credit

            if(m.length > 8){
                prep_stmt.setString(6, m[8]); //creditcard
            }else {
                prep_stmt.setString(6, "555"); //creditcard
            }
            prep_stmt.executeUpdate();
            client.sendToClient("added");
        }




        //add item to itemshaifa or itemstelaviv table
        if(m[0].contentEquals("additem")) // input = "additem#storeid#name#desc#price#sale"
        {
            String sql = "insert into items"+m[1]+" value (?,?,?,?)";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.setString(1, m[2]); // item name
            prep_stmt.setString(2, m[3]); // description
            prep_stmt.setString(3, m[4]); // price
            prep_stmt.setString(4, m[5]); // sale
            prep_stmt.executeUpdate();
            client.sendToClient("added");

        }



        if(m[0].contentEquals("deleteitem")) // input "deleteitem#storeid#itemname"
        {
            String sql = "DELETE FROM items"+m[1]+" WHERE name = '"+m[2]+"'";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.executeUpdate();
            client.sendToClient("deleted");

        }



        // apply sale to all items in store
        if(m[0].contentEquals("applyallsales")) // input = "applyallsales#storeid#sale"
        {
            String sql = "UPDATE items"+m[1]+" SET  `sale`=?"
                    + " WHERE 1";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.setString(1, m[2]); //itemname
            prep_stmt.executeUpdate();
            client.sendToClient("updated");
        }



        if(m[0].contentEquals("updateitem")) // input = "updateitem#storeid#itemname#desc#price#sale"
        {
            String sql = "UPDATE items"+m[1]+" SET  `desc`=?, `price`=?, `sale`=?"
                    + " WHERE `name`=?";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.setString(4, m[2]); //itemname
            prep_stmt.setString(1, m[3]); // desc
            prep_stmt.setString(2, m[4]); // price
            prep_stmt.setString(3, m[5]); // sale
            prep_stmt.executeUpdate();
            client.sendToClient("updated");
        }






        if(m[0].contentEquals("updateuser")) // input = "updateuser#username#password#address#email#phone#storeid#authlevel#blockstatus"
        {
            String sql = "UPDATE users SET `password`=?, `address`=?, `email`=?, `phone`=?,"
                    + " `storeid`=?, `auth`=?, `blocked`=? WHERE `username`=?";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.setString(8, m[1]); //username
            prep_stmt.setString(1, m[2]); // password
            prep_stmt.setString(2, m[3]); // address
            prep_stmt.setString(3, m[4]); // email
            prep_stmt.setString(4, m[5]); //phone
            prep_stmt.setString(5, m[6]); //storeid
            prep_stmt.setString(6, m[7]); //authlevel
            prep_stmt.setString(7, m[8]); // blocked
            prep_stmt.executeUpdate();
            client.sendToClient("updated");
        }


        if(m[0].contentEquals("getuserinfo")) // input = "getuserinfo#username"
        {
            String sql = "SELECT * FROM users WHERE UserName = ?";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.setString(1, m[1]); //username
            ResultSet r = prep_stmt.executeQuery();
            String g;
            if(r.next())
            {
                g =
                        r.getString(1) + "#" +
                                r.getString(2) + "#" +
                                r.getString(3) + "#" +
                                r.getString(4) + "#" +
                                r.getString(5) + "#" +
                                r.getString(6) + "#" +
                                r.getString(7) + "#" +
                                r.getString(8) + "#" +
                                r.getString(9) + "#" +
                                r.getString(10);
            }
            else g="nouser";
            client.sendToClient(g);
        }





        if(m[0].contentEquals("addcomplaint")) // input = "addcomplaint#complaintid#username#storeid#orderid#text"
        {
            String sql = "insert into complaints value (?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.setString(1, m[1]);
            prep_stmt.setString(2, m[2]);
            prep_stmt.setString(3, m[3]);
            prep_stmt.setString(4, m[4]);
            prep_stmt.setString(5, m[5]);
            prep_stmt.setString(6, "no");
            prep_stmt.setString(7, "Not Answered");

            String[] d=getdatetime();
            prep_stmt.setString(8, d[0]);
            prep_stmt.setString(9, d[1]);

            prep_stmt.executeUpdate();
            client.sendToClient("added");
        }





        if(m[0].contentEquals("getusercomp")) // input = "getusercomp#username"
        {
            String sql = "SELECT * FROM complaints WHERE username = '" + m[1] +"'";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            ResultSet r = prep_stmt.executeQuery();
            String g="";
            if(r.next() == false)
                g="NULL";
            else {
                while (r.next()) {
                    g +=
                            r.getString(1) + "#" +
                                    r.getString(5) + "#" +
                                    r.getString(7) + "#" +
                                    r.getString(8) + " " + r.getString(9) + "#" +
                                    r.getString(4) + "/";

                }
            }
            client.sendToClient(g);
        }


        if(m[0].contentEquals("getcompbyid")) // input = "getcompbyid#compid"
        {
            String sql = "SELECT * FROM complaints WHERE complaintid = '" + m[1] +"'";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            ResultSet r = prep_stmt.executeQuery();
            String g="";
            if(r.next())
            {
                g+=
                        r.getString(1) + "#" +
                                r.getString(5) + "#" +
                                r.getString(7);
            }else {
                g="nosuchcomplaint";
            }
            client.sendToClient(g);
        }




        if(m[0].contentEquals("answercomp")) // input = "answercomp#complaintid#answer"
        {
            String sql = "UPDATE complaints SET `answer`=?, `answered`='yes'"
                    + " WHERE `complaintid`=?";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            prep_stmt.setString(2, m[1]);
            prep_stmt.setString(1, m[2]);
            prep_stmt.executeUpdate();
        }


        if(m[0].contentEquals("getallusers")) // input = "getallusers"
        {
            String sql = "SELECT * FROM users WHERE NOT auth = 'GM'";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            ResultSet r = prep_stmt.executeQuery();
            String g="";
            while(r.next())
            {
                g = g +
                        r.getString(1) + "#" +
                        r.getString(2) + "#" +
                        r.getString(3) + "#" +
                        r.getString(4) + "#" +
                        r.getString(5) + "#" +
                        r.getString(6) + "#" +
                        r.getString(7) + "#" +
                        r.getString(8) + "#" +
                        r.getString(9) + "#" +
                        r.getString(10) + "/" ;
            }
            client.sendToClient(g);
        }


        if(m[0].contentEquals("getallworkers")) // input = "getallworkes"
        {
            String sql = "SELECT * FROM users WHERE NOT auth = 'C'";
            PreparedStatement prep_stmt = conn.prepareStatement(sql);
            ResultSet r = prep_stmt.executeQuery();
            String g="";
            while(r.next())
            {
                g = g +
                        r.getString(1) + "#" +
                        r.getString(2) + "#" +
                        r.getString(3) + "#" +
                        r.getString(4) + "#" +
                        r.getString(5) + "#" +
                        r.getString(6) + "#" +
                        r.getString(7) + "#" +
                        r.getString(8) + "#" +
                        r.getString(9) + "#" +
                        r.getString(10) + "/" ;
            }
            client.sendToClient(g);
        }


        if(m[0].contentEquals("block")) { // input"block#username" change status of user
            String sql = "SELECT * FROM users WHERE UserName = '" + m[1] +"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                String g = rs.getString("blocked");
                if(g.equals("no")) g="yes";
                else g="no";
                rs.updateString("blocked", g);
                rs.updateRow();
                client.sendToClient("updated");
            }else {
                client.sendToClient("nouser");
            }
        }


        if(m[0].contentEquals("getitems")) { //input: "getitems#storeid"
            String sql = "SELECT * FROM items"+m[1]+" WHERE 1";
            ResultSet rs = stmt.executeQuery(sql);
            String g = "";
            while(rs.next())
            {
                g = g +
                        rs.getString(1) + "#" +
                        rs.getString(2) + "#" +
                        rs.getString(3) + "#" +
                        rs.getString(4) + "/";
            }
            client.sendToClient(g);
        }

        conn.close();
    }////////////////////////////////////////////////////////////////////////

    private String[] getdatetime()
    {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        String[] date_time=formattedDate.split(" ");
        return date_time;
    }
    private String generatedate(String dd,String mm,String yy) {
        return (dd+"-"+mm+"-20"+yy);
    }


    public static void main(String[] args) {
        int port = 0; //Port to listen on
        try{
            port = Integer.parseInt(args[0]); //Get port from command line
        }
        catch(Throwable t){
            port = DEFAULT_PORT;
        }
        EchoServer sv = new EchoServer(port);
        try {
            sv.listen(); //Start listening for connections
        }
        catch (Exception ex) {
            System.out.println("ERROR - Could not listen for clients!");
        }
    }
}
