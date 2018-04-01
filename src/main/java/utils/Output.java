package utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Output {
    private static ByteArrayOutputStream consoleStorage = new ByteArrayOutputStream();
    public static List<String> printList = new LinkedList<>();
    private static PrintStream defaultStream = System.out;

    /**
     * Redirects System.out to a new printstream object that keeps track of the messages printed
     * stores messages in PrintList
     * @param string - message to be printed
     */
    public static void print(String string){
        System.setOut(new PrintStream(consoleStorage));
        System.out.println(string);
        printList.add(string); //store value for later use (checking in tests)
        System.setOut(defaultStream); // set back to default so we can see output on screen
        System.out.println(printList.get(printList.size() - 1)); // print the last message added to printlist
    }
}
