package com.bignerdranch2nded.android.personaltrainer;

import android.support.v4.app.Fragment;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment(){
        return new ClientListFragment();
    }
}
