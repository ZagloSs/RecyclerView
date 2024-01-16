package com.zagloss.recicleviewmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<HistoricEventModel> historicEventModels = new ArrayList<HistoricEventModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RecyclerView rv = findViewById(R.id.historicEventRecylcer);
        setHistoricEventModels();

        HistoricEventRecyclerViewAdapter adapter = new HistoricEventRecyclerViewAdapter(this, historicEventModels);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }


    private void setHistoricEventModels(){
        String[] eventNames = getResources().getStringArray(R.array.historic_event_names);
        String[] eventDates = getResources().getStringArray(R.array.historic_event_dates);
        String[] eventLocations = getResources().getStringArray(R.array.historic_event_locations);

        for (int i = 0; i< eventNames.length; i++){
            historicEventModels.add(new HistoricEventModel(eventNames[i], eventDates[i], eventLocations[i]));
        }
    }
}