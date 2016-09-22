package com.bignerdranch2nded.android.personaltrainer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by Jeffrow on 9/21/2016.
 */
public class SessionPagerActivity extends AppCompatActivity{
    private static final String EXTRA_SESSION_ID = "com.bignerdranch2nded.android.personaltrainer.session_id";
    private static final String EXTRA_CLIENT_ID = "com.bignerdranch2nded.android.persontrainer.client_id";

    private ViewPager mViewPager;
    private List<Session> mSessions;

    public static Intent newIntent(Context packageContext, UUID sessionId, UUID clientId){
        Intent intent = new Intent(packageContext, SessionPagerActivity.class);
        intent.putExtra(EXTRA_SESSION_ID, sessionId);
        intent.putExtra(EXTRA_CLIENT_ID, clientId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_pager);

        UUID sessionId = (UUID)getIntent().getSerializableExtra(EXTRA_SESSION_ID);
        final UUID clientId = (UUID)getIntent().getSerializableExtra(EXTRA_CLIENT_ID);

        mViewPager = (ViewPager)findViewById(R.id.activity_session_view_pager);

        mSessions = ClientLab.get(this).getSessions();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Session session = mSessions.get(position);
                return ClientSessionFragment.newInstance(clientId, session.getSessionId());
            }

            @Override
            public int getCount() {
                return mSessions.size();
            }
        });

        for(int i = 0; i < mSessions.size(); i++){
            if(mSessions.get(i).getSessionId().equals(sessionId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
