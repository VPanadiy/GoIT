package Java_Core.ControlStatement.Switch;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by Splayd on 23.11.2016.
 */
public class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the command: ");

        String command = scanner.nextLine();

        switch (command) {
            case "start": {
                System.out.println("Server is start...");
                break;
            }
            case "shutdown": {
                System.out.println("Server is ShutDown...");
                break;
            }
            case "pause": {
                System.out.println("Server is paused...");
                break;
            }
            default: {
                System.out.println("Unknown command " + command);
            }
        }
    }
}
