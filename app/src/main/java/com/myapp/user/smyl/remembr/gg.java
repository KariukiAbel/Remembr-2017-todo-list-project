package com.myapp.user.smyl.remembr;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 5/1/2017.
 */

public class gg extends Fragment {
    public RecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.content_main,container,false);
//        recyclerView=(RecyclerView)layout.findViewById(R.id.list);
        return layout;
    }
}
