package com.example.risatoyoshima.mynihongo;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends ListFragment {
    Intent i;

    String[] listitem = {
            "FRUITS",
            "NUMBERS",
            "ANIMALS"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1, listitem));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        switch(position){
            case 0:
                i = new Intent(getActivity(), Cardset1.class);
                break;
            case 1:
                i = new Intent(getActivity(), Cardset2.class);
                break;
            case 2:
                i = new Intent(getActivity(), Cardset3.class);
                break;
        }
        startActivity(i);
    }

}
