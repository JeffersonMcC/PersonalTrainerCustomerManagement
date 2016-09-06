package com.bignerdranch2nded.android.personaltrainer;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientListFragment extends Fragment {
    private RecyclerView mClientRecyclerView;
    private ClientAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_client_list, container, false);

        mClientRecyclerView = (RecyclerView)view.findViewById(R.id.client_recycler_view);
        mClientRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();

        updateUI();
    }


    public void updateUI(){
        ClientLab clientLab = ClientLab.get(getActivity());
        List<Client> clients = clientLab.getClients();
        if(mAdapter == null){
            mAdapter = new ClientAdapter(clients);
            mClientRecyclerView.setAdapter(mAdapter);
        } else{
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ClientHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mProfileImageView;
        private TextView mNameTextView;
        private TextView mNextSessionDateTextView;

        private Client mClient;

        public ClientHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            mProfileImageView = (ImageView)itemView.findViewById(R.id.list_item_client_profile_image_text_view);
            mNameTextView = (TextView)itemView.findViewById(R.id.list_item_client_name_text_view);
            mNextSessionDateTextView = (TextView)itemView.findViewById(R.id.list_item_client_next_session_date_text_view);
        }

        public void bindClient(Client client){
            mClient = client;
            mNameTextView.setText(mClient.getName());
            mNextSessionDateTextView.setText(mClient.getSessionDate().toString());
            //mProfileImageView.setImageDrawable(mClient.getProfileImage);
        }

        @Override
        public void onClick(View v){
            Intent intent = ClientActivity.newIntent(getActivity(), mClient.getId());

            startActivity(intent);
        }
    }

    private class ClientAdapter extends RecyclerView.Adapter<ClientHolder>{

        private List<Client> mClients;

        public ClientAdapter(List<Client> clients){
            mClients = clients;
        }

        @Override
        public ClientHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_client, parent, false);
            return new ClientHolder(view);
        }

        @Override
        public void onBindViewHolder(ClientHolder holder, int postion){
            Client client = mClients.get(postion);
            holder.bindClient(client);
        }

        @Override
        public int getItemCount(){
            return mClients.size();
        }
    }
}
