package com.bignerdranch2nded.android.personaltrainer;

import android.util.Log;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class Client {

    private UUID mId;
    private String mName;
    private String mDrawableName;
    private int profileImageResourceId;
    private Date mSessionDate = new Date();

    public static final String TAG = "Client";

    public Client(){
        this(UUID.randomUUID());
//        mId = UUID.randomUUID();
//        mSessionDate = new Date();
    }

    public Client(UUID id){
        mId = id;
        mSessionDate = new Date();
    }

    public UUID getClientId(){
        return mId;
    }

    public void setName(String name){
        mName = name;
    }

    public String getName(){
        return mName;
    }

}
