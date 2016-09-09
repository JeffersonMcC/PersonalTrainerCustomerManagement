package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/9/2016.
 */
public class ClientDetailProfileFragment extends Fragment {
    private static final String TAG = "ClientDetailProfileFragment";
    private static final String ARG_CLIENT_ID = "client-id";
    private Client mClient;

    public static ClientDetailProfileFragment newInstance(UUID clientId){
        Log.d(TAG, "newInstance() started");
        Bundle args = new Bundle();

        args.putSerializable(ARG_CLIENT_ID, clientId);
        Log.d(TAG, "clientId was placed as an argument in a bundle");

        ClientDetailProfileFragment fragment = new ClientDetailProfileFragment();
        Log.d(TAG, "fragment created in newInstance()");

        fragment.setArguments(args);
        Log.d(TAG, "the bundle has been attached to the fragment");

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        UUID clientId = (UUID)getArguments().getSerializable(ARG_CLIENT_ID);

        mClient = ClientLab.get(getActivity()).getClient(clientId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_client_profile, container, false);

        return v;
    }
}
