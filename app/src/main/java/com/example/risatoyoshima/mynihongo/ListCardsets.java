package com.example.risatoyoshima.mynihongo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListCardsets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cardset1);

        getFragmentManager().beginTransaction()
                .replace(R.id.container, new List()).commit();
    }
}
