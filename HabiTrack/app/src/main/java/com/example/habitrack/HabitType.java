package com.example.habitrack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sshussai on 10/21/17.
 */


public class HabitType {

    private Integer ID;
    private String title; // title of the habit type
    private String reason;  // reason for the habit type
    private Date startDate; // date to start
    private ArrayList<Integer> plan; // ArrayList of ints representing day of the week for the plan
    private Integer completedCounter; // habit events currently completed
    private Integer currentMaxCounter; // total number of habits events possible so far

    public HabitType(Integer id) {
        this.ID = id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean setTitle(String title) {
        if (title.length() > 20){
            return Boolean.FALSE;
        } else {
            this.title = title;
            return Boolean.TRUE;
        }
    }

    public String getReason() {
        return reason;
    }

    public Boolean setReason(String reason) {
        if (reason.length() > 30){
            return Boolean.FALSE;
        } else {
            this.reason = reason;
            return Boolean.TRUE;
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setDateToStart(Date dateToStart) {
        this.startDate = dateToStart;
    }

    public ArrayList<Integer> getPlan() {
        return plan;
    }

    public void setPlan(ArrayList plan) {
        this.plan = plan;
    }

    public Double getStatus(){
        return (completedCounter.doubleValue()/currentMaxCounter.doubleValue());
    }

    public void incrementCompletedCounter(){
        completedCounter++;
    }

    public void incrementMaxCounter(){
        currentMaxCounter++;
    }


}
