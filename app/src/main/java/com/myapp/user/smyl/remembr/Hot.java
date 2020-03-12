package com.myapp.user.smyl.remembr;

/**
 * Created by nabesh-riska on 5/3/17.
 */
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class Hot extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.hot, container, false);

        return rootView;
    }

}
