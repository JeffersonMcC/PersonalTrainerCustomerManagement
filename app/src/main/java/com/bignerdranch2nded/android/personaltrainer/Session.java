package com.bignerdranch2nded.android.personaltrainer;

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
    private Client mClient = new Client();
    private UUID clientId;

    private static final String TAG = "Session";

    public Session(){
        this(UUID.randomUUID());
    }

    public Session(UUID id){
        mId = id;
        mDate = new Date();
    }

    public UUID getClientId(){
        return mClient.getClientId();
    }

    public UUID getSessionId(){
        return mId;
    }

    public void setClientId(UUID clientSpecificSession){
        clientId = clientSpecificSession;
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
