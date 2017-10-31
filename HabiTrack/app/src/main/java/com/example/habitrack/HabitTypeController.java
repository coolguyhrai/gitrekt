package com.example.habitrack;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by sshussai on 10/21/17.
 */

public class HabitTypeController implements HabitController {
    private ArrayList<HabitType> habitTypeArrayList = new ArrayList<HabitType>();

    private static final HabitTypeController htController = new HabitTypeController();

    private HabitTypeController(){}

    public static HabitTypeController getInstance(){
        return htController;
    }

    @Override
    public void addNew(String title, String reason) {
        HabitType habitType = new HabitType(generateID());
        habitType.setTitle(title);
        habitType.setReason(reason);
        habitTypeArrayList.add(habitType);


    }

    public HabitType getHabitType(Integer index){
        return habitTypeArrayList.get(index);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void viewDetails(Integer id) {

    }

    @Override
    public void changeTitle(Integer id) {

    }

    @Override
    public void changeText(Integer id) {

    }

    @Override
    public Integer generateID() {
        return 5;
    }
}
