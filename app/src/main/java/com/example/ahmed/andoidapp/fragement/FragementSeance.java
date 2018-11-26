package com.example.ahmed.andoidapp.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmed.andoidapp.R;

/**
 * Created by ahmed on 24/11/2018.
 */

public class FragementSeance extends Fragment {

    View view;
    public FragementSeance(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.seance_fragement,container,false);
        return view;
    }
}
