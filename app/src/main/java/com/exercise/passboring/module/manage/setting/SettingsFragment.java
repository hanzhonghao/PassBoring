package com.exercise.passboring.module.manage.setting;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exercise.passboring.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {
    public static final String NO_IMAGE_KEY = "setting_no_image";
    public static final String SAVE_PATH_KEY = "setting_save_path";

    public static final String DEFAULT_SAVE_PATH = "/storage/emulated/0/MvpApp";


    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

}
