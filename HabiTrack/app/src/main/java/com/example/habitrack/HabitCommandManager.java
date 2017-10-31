package com.example.habitrack;

/**
 * Created by sshussai on 10/30/17.
 */

public class HabitCommandManager {

    private Command theCommand;

    public HabitCommandManager(Command newCommand){
        this.theCommand = newCommand;
    }

    public void run(){
        theCommand.execute();
    }

}
