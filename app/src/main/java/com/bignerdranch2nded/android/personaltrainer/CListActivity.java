package com.bignerdranch2nded.android.personaltrainer;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class CListActivity extends SingleFragmentActivity{

    private static final String EXTRA_USER_ID = "com.bignerdranch2nded.android.personaltrainer";

    @Override
    protected Fragment createFragment(){
        return new CListFragment();
    }

    public static Intent newIntent(Context packageContext, UUID userId){
        Intent i = new Intent(packageContext, CListActivity.class);

        i.putExtra(EXTRA_USER_ID, userId);

        return i;
    }

}
