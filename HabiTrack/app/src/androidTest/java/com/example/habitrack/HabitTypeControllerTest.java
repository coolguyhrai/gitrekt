package com.example.habitrack;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sshussai on 10/31/17.
 */
public class HabitTypeControllerTest extends TestCase {

    private String title;
    private String reason;

    //@Before
    public void setUp() throws Exception {
        this.title = "TestTitle";
        this.reason = "TestReason";
    }

    //@Test
    public void testAddNew() throws Exception {
        Command addCommand = new AddNew(HabitTypeController.getInstance(), this.title, this.reason);
        addCommand.execute();
        HabitType testHabit = HabitTypeController.getInstance().getHabitType(0);
        Assert.assertTrue(this.title.equals(testHabit.getTitle()));
    }

    //@After
    public void tearDown() throws Exception {}


}