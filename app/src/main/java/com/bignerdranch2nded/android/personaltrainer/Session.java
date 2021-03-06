package com.bignerdranch2nded.android.personaltrainer;

import android.util.Log;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Jeffrow on 9/20/2016.
 */
public class Session {

    private UUID mId;
    private String mTitle;
    private String mDescription;
    private Date mDate;
    private boolean mCompleted;
    private UUID clientId;

    private static final String TAG = "Session";

    public Session(){
        this(UUID.randomUUID());
    }

    public Session(UUID id){
        mId = id;
        mDate = new Date();
    }

    public void setClientId(UUID clientSpecificSession){
        clientId = clientSpecificSession;
    }

    public UUID getClientId(){
        return clientId;
    }

    public UUID getSessionId(){
        return mId;
    }

    public Date getDate(){
        return mDate;
    }

    public void setDate(Date date){
        mDate = date;
    }

    public String getTitle(){
        return mTitle;
    }

    public void setTitle(String title){
        mTitle = title;
    }

    public String getDescription(){
        return mDescription;
    }

    public void setDescription(String description){
        mDescription = description;
    }

    public boolean isCompleted(){
        return mCompleted;
    }

    public void setCompleted(boolean completed){
        mCompleted = completed;
    }
}
