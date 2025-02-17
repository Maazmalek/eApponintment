package com.smartapponintment.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.smartapponintment.R;
import com.smartapponintment.activities.LoginActivity;

public class AdminProfileFragment extends Fragment {


    Button btnLogout;


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_admin_profile,container,false);
        btnLogout = rootview.findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("e_Appointment", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("KEY_PREF_EMAIL");
                editor.remove("KEY_PREF_Password");
                editor.commit();
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });
        return rootview;
    }


}