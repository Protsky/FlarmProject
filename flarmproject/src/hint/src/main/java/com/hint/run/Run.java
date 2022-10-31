package com.hint.run;

import com.hint.menu.Menu;
import com.hint.menu.Options.AddCompetitorOption;
import com.hint.menu.Options.AddMySelf;
import com.hint.menu.Options.RunScanner;
import com.hint.menu.Options.ConnectToOgn;
import com.hint.program.Competition;
import com.hint.menu.Options.PrintCompetitorsOption;


public class Run {
    public final Competition competition;
    public final Menu menu;

    public Run(){
        competition = new Competition();
        menu = new Menu();
        menu.setTitle("Main menu");
        menu.addOption(new AddCompetitorOption(this.competition, this.menu));
        menu.addOption(new RunScanner(this.competition, this.menu));
        menu.addOption(new PrintCompetitorsOption(this.competition,this.menu));
        menu.addOption(new ConnectToOgn(competition, this.menu));
        menu.addOption(new AddMySelf(competition, this.menu));
    }

    public void startProgram(){
        menu.show();
    }

    public static void main(String[] args) {
        Run run = new Run();
        run.startProgram();
    }

}
