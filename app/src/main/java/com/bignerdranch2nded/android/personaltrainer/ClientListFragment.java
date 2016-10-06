package com.bignerdranch2nded.android.personaltrainer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientListFragment extends Fragment {
    private static final String TAG = "ClientListFragment";
    private RecyclerView mClientRecyclerView;
    private ClientAdapter mAdapter;
    private ClientListActivity mClientActivity = new ClientListActivity();

    private static final String DIALOG_LOG_OFF = "DialogLogOff";

    private File mPhotoFile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client_list, container, false);

        mClientRecyclerView = (RecyclerView) view.findViewById(R.id.client_recycler_view);
        mClientRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_client_list, menu);

        String userSubtitle = getString(R.string.user_logged_in, "jdoe1");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(userSubtitle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager manager = getFragmentManager();
        switch (item.getItemId()) {
            case R.id.menu_item_new_client:  //add a new crime to the list of crimes in the CrimeListFragment
                Client client = new Client();
                ClientLab.get(getActivity()).addClient(client);
                Intent intent = ClientActivity.newIntent(getActivity(), client.getClientId());
                startActivity(intent);
                return true;
            case R.id.menu_item_logout:
                LogOffFragment dialog = new LogOffFragment();
                dialog.show(manager, DIALOG_LOG_OFF);
                //mClientActivity.taskDone();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void updateUI() {
        ClientLab clientLab = ClientLab.get(getActivity());
        List<Client> clients = clientLab.getClients();
        if (mAdapter == null) {
            mAdapter = new ClientAdapter(clients);
            mClientRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ClientHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mProfileImageView;
        private TextView mNameTextView;
        private TextView mNextSessionDateTextView;

        private Client mClient;

        public ClientHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mProfileImageView = (ImageView) itemView.findViewById(R.id.list_item_profile_image);
            mNameTextView = (TextView) itemView.findViewById(R.id.list_item_client_name_text_view);
            mNextSessionDateTextView = (TextView) itemView.findViewById(R.id.list_item_client_next_session_date_text_view);
        }

        public void bindClient(Client client) {
            mClient = client;
            mNameTextView.setText(mClient.getName());
            //mNextSessionDateTextView.setText(mClient.getDate().toString());
            Bitmap clientPhoto = ClientLab.get(getActivity()).getBitMap();
        }

        @Override
        public void onClick(View v) {
            Intent intent = ClientActivity.newIntent(getActivity(), mClient.getClientId());
            startActivity(intent);
        }
    }

    private class ClientAdapter extends RecyclerView.Adapter<ClientHolder> {

        private List<Client> mClients;

        public ClientAdapter(List<Client> clients) {
            mClients = clients;
        }

        @Override
        public ClientHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_client, parent, false);
            return new ClientHolder(view);
        }

        @Override
        public void onBindViewHolder(ClientHolder holder, int position) {
            Client client = mClients.get(position);
            holder.bindClient(client);
        }

        @Override
        public int getItemCount() {
            return mClients.size();
        }
    }
}
