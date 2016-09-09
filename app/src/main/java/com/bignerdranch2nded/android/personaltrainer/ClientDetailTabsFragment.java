package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/9/2016.
 */
public class ClientDetailTabsFragment extends Fragment {

    public static ClientDetailProfileFragment newInstance(){
        return new ClientDetailProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_client_tabs, container, false);
        return v;
    }
}
