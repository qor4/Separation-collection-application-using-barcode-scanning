package com.example.wastesortingapp.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wastesortingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link paperpack#newInstance} factory method to
 * create an instance of this fragment.
 */
public class paperpack extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paperpack, container, false);
    }
}