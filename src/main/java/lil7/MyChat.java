package lil7;

import Chat.ClientConsole;
import java.lang.String;

import static java.lang.Thread.sleep;


public class MyChat {
    public static ClientConsole chat;
    public static String lastMSG ;

    public static void sendMSG(String msg)
    {
        chat.accept(msg);
    }

    public static String getMSG()
    {
        try {
            sleep(3000);
        }
        catch(InterruptedException e) {}

        while(lastMSG.length()==0)
        {}
        String tmp = lastMSG;
        lastMSG = "";
        return tmp;
    }
    public static void putResponse(String msg)
    {
        while(MyChat.lastMSG.length() != 0)
        {
        }
        MyChat.lastMSG = msg;
    }
}
