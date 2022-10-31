package com.hint.menu.Options;

import com.hint.program.Competition;
import com.hint.menu.Menu;
import com.hint.utils.Utils;


public class PrintCompetitorsOption implements MenuOption{

    private final Competition competition;
    private final Menu menu;
    private final Utils utils;

    public PrintCompetitorsOption(Competition competition, Menu menu){
        this.competition = competition;
        this.menu = menu;
        utils = new Utils(competition);
    }

    @Override
    public void execute() {
        utils.printCompetitors();
        menu.show();
    }

    @Override
    public String getName() {
        return "Print Competitors";
    }
}
