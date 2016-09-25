package com.bignerdranch2nded.android.personaltrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jeffrow on 9/7/2016.
 */
public class CSessionsListFragment extends Fragment {
    public static final String TAG = "CSessionsListFragment";

    private RecyclerView mSessionRecyclerView;
    private SessionAdapter mAdapter;
    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE = 0;

    private Button mAddSessionButton;

    public static CSessionsListFragment newInstance(){
        return new CSessionsListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_session_list, container, false);

        mSessionRecyclerView = (RecyclerView)v.findViewById(R.id.session_recycler_view);
        mSessionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAddSessionButton = (Button)v.findViewById(R.id.add_session_button);
//        updateDate();
        mAddSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "add session button clicked");
                Session session = new Session();
                ClientLab.get(getActivity()).addSession(session);
                Intent intent = CSessionPagerActivity.newIntent(getActivity(), session.getSessionId());
                startActivity(intent);
            }
        });

        updateUI();

        return v;
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    private void updateUI(){
        ClientLab clientLab = ClientLab.get(getActivity());
        List<Session> sessions = clientLab.getSessions();
        if(mAdapter == null){
            mAdapter = new SessionAdapter(sessions);
            mSessionRecyclerView.setAdapter(mAdapter);
        } else{
            mAdapter.setSessions(sessions);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class SessionHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mDateTextView;
        private TextView mTitleTextView;
        private CheckBox mCompletedCheckBox;

        private Session mSession;

        public SessionHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            mDateTextView = (TextView)itemView.findViewById(R.id.list_item_session_date_text_view);
            mTitleTextView = (TextView)itemView.findViewById(R.id.list_item_session_title_text_view);
            mCompletedCheckBox = (CheckBox)itemView.findViewById(R.id.list_item_session_completed_check_box);
        }

        public void bindSession(Session session){
            mSession = session;
            mDateTextView.setText(mSession.getDate().toString());
            mTitleTextView.setText(mSession.getTitle());
            mCompletedCheckBox.setChecked(mSession.isCompleted());
        }

        @Override
        public void onClick(View v){
            Log.d(TAG, "Session list item has been clicked");
            Intent intent = CSessionPagerActivity.newIntent(getActivity(), mSession.getSessionId() /*, mClient.getClientId()*/);
            startActivity(intent);
        }
    }

    private class SessionAdapter extends RecyclerView.Adapter<SessionHolder>{
        private List<Session> mSessions;

        public SessionAdapter(List<Session> sessions){
            mSessions = sessions;
        }

        @Override
        public SessionHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_session, parent, false);
            return new SessionHolder(view);
        }

        @Override
        public void onBindViewHolder(SessionHolder holder, int position){
            Session session = mSessions.get(position);
            holder.bindSession(session);
        }

        @Override
        public int getItemCount(){
            return mSessions.size();
        }

        public void setSessions(List<Session> sessions){
            mSessions = sessions;
        }
    }
    /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode != Activity.RESULT_OK){
            return;
        }

        if(requestCode == REQUEST_DATE){
            Date date = (Date)data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mSession.setDate(date);
            updateDate();
        }
    }


    private void updateDate(){
        Log.d(TAG, "getSessionDate about to be started");
        //mAddSessionButton.setText(mClient.getSessionDate().toString());
    }
    */
}
