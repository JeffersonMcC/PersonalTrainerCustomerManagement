package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jeffrow on 9/7/2016.
 */
public class ClientSessionsToAddSessionsFragment extends Fragment {

    public static ClientSessionsToAddSessionsFragment newInstance(){
        return new ClientSessionsToAddSessionsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_session, container, false);

        return v;
    }
}
