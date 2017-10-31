package com.example.habitrack;

/**
 * Created by sshussai on 10/30/17.
 */

public class Delete implements Command {

    private HabitController controller;
    private Integer id;

    public Delete(HabitController controller, Integer id) {
        this.controller = controller;
        this.id = id;
    }

    @Override
    public void execute() {
        controller.delete(this.id);
    }
}


