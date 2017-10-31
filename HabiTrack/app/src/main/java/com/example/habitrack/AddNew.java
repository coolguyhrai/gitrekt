package com.example.habitrack;

/**
 * Created by sshussai on 10/30/17.
 */

public class AddNew implements Command {

    private HabitController controller;
    private String title;
    private String text;

    public AddNew(HabitController newController, String newTitle, String newText){
        this.controller = newController;
        this.title = newTitle;
        this.text = newText;
    }

    @Override
    public void execute() {
        controller.addNew(this.title, this.text);
    }
}
