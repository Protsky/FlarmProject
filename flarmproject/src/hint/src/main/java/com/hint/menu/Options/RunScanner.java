package com.hint.menu.Options;

import com.hint.menu.Menu;
import com.hint.program.Competition;
import com.hint.utils.InstanceHandler;


public class RunScanner implements MenuOption{

    private final Competition competition;
    private final Menu menu;

    public RunScanner(Competition competition, Menu menu){
        this.competition = competition;
        this.menu = menu;
    }

    @Override
    public void execute() {
        InstanceHandler instanceHandler = new InstanceHandler(competition);
        Thread thread = new Thread(instanceHandler);
        thread.start();
    }

    @Override
    public String getName() {
        return "Run Scanner";
    }
}
