package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime-id";
    private Client mClient;

    public static ClientFragment newInstance(UUID clientId){
        Bundle args = new Bundle();

        args.putSerializable(ARG_CRIME_ID, clientId);

        ClientFragment fragment = new ClientFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        UUID clientId = (UUID)getArguments().getSerializable(ARG_CRIME_ID);

        mClient = ClientLab.get(getActivity()).getClient(clientId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_client, container, false);
        return v;
    }
}
