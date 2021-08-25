package lrn.io;

import java.io.Console;
import java.util.Arrays;

public class Password {
    public static void main(String[] args) {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console");
            System.exit(1);
        }

        String login = c.readLine("Enter your login: ");
        char [] oldPassword = c.readPassword("Enter your old password: ");

        if (veriry(login, oldPassword)) {
            boolean noMatch;
            do  {
                char[] newPassword1 = c.readPassword("Enter your new password: ");
                char[] newPassword2 = c.readPassword("Enter new password again: ");
                noMatch = !Arrays.equals(newPassword1, newPassword2);
                if (noMatch) {
                    c.format("Password don't match Try again %n");
                } else {
                    change(login, newPassword1);
                    c.format("Password for %s changed %n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            } while (noMatch);
        }
        Arrays.fill(oldPassword, ' ');
    }

    static boolean veriry(String login, char[] password) {
        return login.equals("default") && Arrays.equals(password, "123456".toCharArray());
    }

    static void change(String login, char[] password) {
        System.out.println("has changed login with new password!");
    }
}
