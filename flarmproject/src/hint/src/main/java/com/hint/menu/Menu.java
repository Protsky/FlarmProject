package com.hint.menu;

import com.hint.menu.Options.MenuOption;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private final LinkedHashMap<Character, MenuOption> options;

    public Menu() {
        options = new LinkedHashMap<>();
    }

    public void addOption(MenuOption option) {
        char c = (char) (options.size() + '0');
        options.put(c, option);
    }

    public void show() {
        if (title != null) {
            System.out.println(title);
        }

        options.forEach((k, v) -> {
            System.out.println(k + " -> " + v.getName());
        });
        waitForInput();

    }

    public void waitForInput() {
        System.out.println("Select an option");
        String read = scanner.nextLine();

        if (!read.isEmpty() && read.length() == 1) {
            char firstChar = read.charAt(0);
            if (options.containsKey(firstChar)) {
                options.get(firstChar).execute();
                return;
            }
        }
        System.out.println("\033[1A\33[2K\r");
        waitForInput();
    }
}
