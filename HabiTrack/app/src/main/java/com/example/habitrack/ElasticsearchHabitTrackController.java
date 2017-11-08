package com.example.habitrack;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by pennyfea on 11/3/17.
 */

public class ElasticsearchHabitTrackController {

    private static JestDroidClient client;


    /**
     * AsyncTask enables proper and easy use of the UI thread. This class allows you to perform background operations and publish results on the UI thread
     * This function adds habitType to elastic search
     */
    public static class AddHabitType extends AsyncTask<HabitType, Void, Void> {

        @Override
        protected Void doInBackground(HabitType... habitTypes) {
            verifySettings();
            for(HabitType habitType: habitTypes) {
                Index index = new Index.Builder(habitType).index("gitrekt_habitrack").type("habitType").build();
                try {
                    DocumentResult result = client.execute(index);
                    if(result.isSucceeded()) {
                        habitType.setId(result.getId());
                    }
                    else {
                        Log.i("Error", "Elasticsearch was not able to add the HabitType");
                    }
                } catch (IOException e) {
                    Log.i("Error", "The application failed to build and send the HabitType");
                }
            }
            return null;
        }
    }

    /**
     * This function adds habitEvent to elastic search
     */
    public static class AddHabitEvent extends AsyncTask<HabitEvent, Void, Void> {
        @Override
        protected Void doInBackground(HabitEvent... habitEvents) {
            verifySettings();
            for(HabitEvent habitEvent: habitEvents) {
                Index index = new Index.Builder(habitEvent).index("gitrekt_habitrack").type("habitEvent").build();
                try {
                    DocumentResult result = client.execute(index);
                    if(result.isSucceeded()) {
                        habitEvent.setId(result.getId());
                    }
                    else {
                        Log.i("Error", "Elasticsearch was not able to add the HabitEvent");
                    }
                } catch (IOException e) {
                    Log.i("Error", "The application failed to build and send the HabitEvent");
                }
            }
            return null;
        }
    }

    public static class GetHabitType extends AsyncTask<String, Void, ArrayList<HabitEventController>> {
        @Override
        protected ArrayList<HabitEventController> doInBackground(String... search_parameters) {
            verifySettings();

            ArrayList<HabitEventController> habitTypes = new ArrayList<>();

           String query = "{\n" +
                   "   \"query\": {\"match_all\":{} },\n" +
                   "    \"_source\": [\"title\", \"comment\", \"Calender\"], \n" +
                    "}";

            Search search = new Search.Builder(search_parameters[0])
                    .addIndex("gitrekt_habitrack")
                    .addType("habitType")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()){
                    List<HabitEventController> foundHabitType = result.getSourceAsObjectList(HabitEventController.class);
                    habitTypes.addAll(foundHabitType);
                }
                else {
                    Log.i("Error", "The search query failed to find any tweets that matched");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return habitTypes;
        }
    }

    /*
    // TODO get the habitType from the server
    public static class getHabitType(){

    }
    // TODO delete the habitevent from the server
    public static class deleteHabitEvent(){

    }
    // TODO delete the habitType from the server
    public static class deleteHabitType(){
    }
    */

    // TODO Create a queue for offline beahviour




    public static void verifySettings() {
        if (client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080/gitrekt_habitrack");
            DroidClientConfig config = builder.build();
            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }

}

