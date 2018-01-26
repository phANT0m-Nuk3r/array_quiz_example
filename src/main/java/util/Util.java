package util;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

/** Utility class */
public class Util {

    /**
     * Prompt the user and await input of a valid character
     * @param prompt Message to prompt the user with
     * @param checks Check functions to evaluate the user's input
     * @return a Character
     */
    @NotNull
    public static Character getChar(@NotNull String prompt, @NotNull Set<Function<Character, Boolean>> checks) {
        Character value = null;

        boolean validCharInputted = true;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(prompt);
            String line = scanner.nextLine();

            // Must ensure that the user input is only 1 character long
            if (line.length() == 1) {
                Character tmp = line.charAt(0);

                // Check the character
                for (Function<Character, Boolean> check : checks) {
                    // If any check fails, set flag variable and break out of the loop
                    if(!check.apply(tmp)) {
                        validCharInputted = false;
                        System.out.println("Input failed to meet the desired conditions, please try again!");
                        break;
                    }
                }
            }else{
                validCharInputted = false;
                System.out.println("Not a character, please try again!");
            }
        } while (!validCharInputted);

        return value;
    }

    /**
     * Prompt the user and await input of a valid character
     * @param prompt Message to prompt the user with
     * @param check Check function to evaluate the user's input
     * @return a Character
     */
    @NotNull
    public static Character getChar(@NotNull String prompt, @NotNull Function<Character, Boolean> check) {
        Character value = null;

        boolean validCharInputted = true;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(prompt);
            String line = scanner.nextLine();

            // Must ensure that the user input is only 1 character long
            if (line.length() == 1) {
                Character tmp = line.charAt(0);

                // Check the Character; If the check fails, set flag variable
                if (!check.apply(tmp)) {
                    validCharInputted = false;
                    System.out.println("Input failed to meet the desired conditions, please try again!");
                }else{
                    value = tmp;
                }

            }else{
                validCharInputted = false;
                System.out.println("Not a character, please try again!");
            }
        } while (!validCharInputted);

        return value;
    }
}
