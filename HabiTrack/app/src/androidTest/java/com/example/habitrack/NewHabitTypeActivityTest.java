package com.example.habitrack;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;

/**
 * Created by sshussai on 10/31/17.
 */

public class NewHabitTypeActivityTest extends ActivityInstrumentationTestCase2<NewHabitTypeActivity> {

    private Solo solo;

    public NewHabitTypeActivityTest() {
        super(com.example.habitrack.NewHabitTypeActivity.class);
    }


    public void testStart() throws Exception {
        Activity activity = getActivity();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();


    }
}
