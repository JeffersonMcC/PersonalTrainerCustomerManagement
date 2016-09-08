package com.bignerdranch2nded.android.personaltrainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Jeffrow on 9/6/2016.
 */
public abstract class DoubleFragmentActivity extends FragmentActivity{

    protected abstract Fragment createFirstFragment();

    protected abstract Fragment createSecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fragmentOne = fm.findFragmentById(R.id.fragment_container_one);
        Fragment fragmentTwo = fm.findFragmentById(R.id.fragment_container_two);

        if(fragmentOne == null){
            fragmentOne = createFirstFragment();
            transaction.add(R.id.fragment_container_one, fragmentOne);
        }
        if(fragmentTwo == null){
            fragmentTwo = createSecondFragment();
            transaction.add(R.id.fragment_container_two, fragmentTwo).commit();
        }else {
            transaction.replace(R.id.fragment_container_two, fragmentTwo).addToBackStack(null).commit();
        }
    }
}
