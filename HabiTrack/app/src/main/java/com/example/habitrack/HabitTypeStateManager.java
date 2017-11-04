package com.example.habitrack;

import java.util.Calendar;

import java.util.ArrayList;

/**
 * Created by sshussai on 11/4/17.
 */

public class HabitTypeStateManager {

    private static Integer habitTypeID;

    public static HabitTypeStateManager htManager = new HabitTypeStateManager();

    private Calendar cal = Calendar.getInstance();

    private static final ArrayList<HabitType> ALL_HABITTYPES = new ArrayList<HabitType>();
    private static final ArrayList<HabitType> HABITTYPES_FOR_TODAY = new ArrayList<HabitType>();


    private HabitTypeStateManager(){
        this.habitTypeID = 0;
    }

    public static HabitTypeStateManager getHTStateManager(){
        return htManager;
    }

    public void calculateHabitsForToday(){
        this.HABITTYPES_FOR_TODAY.clear();
        for(Integer count = 0; count < ALL_HABITTYPES.size(); count++){
            Calendar currCal = ALL_HABITTYPES.get(count).getStartDate();
            if(currCal.get(Calendar.DAY_OF_WEEK) == cal.get(Calendar.DAY_OF_WEEK)){
                HABITTYPES_FOR_TODAY.add(ALL_HABITTYPES.get(count));
            }
        }
    }

    public void storeHabitType(HabitType ht){
        ALL_HABITTYPES.add(ht);
    }

    public HabitType getHabitType(Integer requestedID){
        for(Integer count = 0; count < ALL_HABITTYPES.size(); count++){
            if(ALL_HABITTYPES.get(count).getID() == requestedID){
                return ALL_HABITTYPES.get(count);
            }
        }
        return null;
        //HabitType ht = new HabitType(-1);
        //return ht;
    }


    public void removeHabitType(Integer requestedID){
        for(Integer count = 0; count < ALL_HABITTYPES.size(); count++){
            if(ALL_HABITTYPES.get(count).getID() == requestedID){
                ALL_HABITTYPES.remove(count);
            }
        }
    }

    public Integer getHabitTypeID(){
        HabitTypeStateManager.habitTypeID++;
        return HabitTypeStateManager.habitTypeID;
    }
}
