package com.example.habitrack;

/**
 * Created by sshussai on 10/30/17.
 */

public interface HabitController {

    public void addNew(String title, String text);

    public void delete(Integer id);

    public void viewDetails(Integer id);

    public void changeTitle(Integer id);

    public void changeText(Integer id);

    public Integer generateID();

}