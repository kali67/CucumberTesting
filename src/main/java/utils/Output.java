package utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Output {
    private static ByteArrayOutputStream consoleStorage = new ByteArrayOutputStream();
    public static List<String> printList = new LinkedList<>();
    private static PrintStream defaultStream = System.out;

    public static void print(String string){
        System.setOut(new PrintStream(consoleStorage));
        System.out.println(string);
        printList.add(string);
        System.setOut(defaultStream);
        System.out.println(printList.get(printList.size() - 1));
    }
}
