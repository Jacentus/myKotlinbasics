package javaintegration;

public class Logger {

    public static void logMessage(LogType logtype, String message){
        System.out.println(String.format("%s %s", logtype, message));
    }   // static aby nie robić obiektu

}
