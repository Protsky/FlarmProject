package com.hint.menu.Options;

import com.hint.program.Competition;

import java.util.Scanner;

import com.hint.menu.Menu;
import com.hint.utils.Utils;


public class ConnectToOgn implements MenuOption{

    private final Competition competition;
    private final Menu menu;
    private final Utils utils;

    public ConnectToOgn(Competition competition, Menu menu){
        this.competition = competition;
        this.menu = menu;
        utils = new Utils(competition);
    }

    @Override
    public void execute() {
        try {
            System.out.println("Insert FlarmId to get data:");
            Scanner scanner = new Scanner(System.in);
            utils.searchGlider(scanner.nextLine());
        } catch (InterruptedException e) {
            System.out.print("Failed to connect to OGN network");
            e.printStackTrace();
        }
        menu.show();
    }

    @Override
    public String getName() {
        return "Connect to OGN";
    }
}
