package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Jeffrow on 9/7/2016.
 */
public class ClientDetailSessionsFragment extends Fragment {
    private Button mAddSessionButton;

    public static ClientDetailSessionsFragment newInstance(){
        return new ClientDetailSessionsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_client_sessions, container, false);

        mAddSessionButton = (Button)v.findViewById(R.id.add_session_button);
        mAddSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return v;
    }
}
