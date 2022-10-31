package com.hint.menu.Options;

import com.hint.menu.Menu;
import com.hint.program.Competition;

import java.util.Scanner;

public class AddCompetitorOption implements MenuOption{

    private final Competition competition;
    private final Scanner scanner = new Scanner(System.in);
    private final Menu menu;

    public AddCompetitorOption(Competition competition, Menu menu){
        this.competition = competition;
        this.menu = menu;
    }

    @Override
    public void execute() {
        System.out.println("flarmId: ");
        String flarmId = scanner.nextLine();
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("LastName: ");
        String lastName = scanner.nextLine();

        competition.registerCompetitor(flarmId,name,lastName);
        menu.show();

    }

    @Override
    public String getName() {
        return "Add Competitors";
    }
}
