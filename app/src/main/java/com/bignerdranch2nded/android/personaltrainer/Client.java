package com.bignerdranch2nded.android.personaltrainer;

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
    private Date mSessionDate;

    public Client(){
        mId = UUID.randomUUID();
        mSessionDate = new Date();
    }

    public Client(UUID id){
        mId = id;
        mSessionDate = new Date();
    }

    public UUID getId(){
        return mId;
    }

    public void setName(String name){
        mName = name;
    }

    public String getName(){
        return mName;
    }

    public Date getSessionDate(){
        if(mSessionDate != null){
            return mSessionDate;
        } else{
            return null;
        }
    }

    public void setSessionDate(Date date){
        mSessionDate = date;
    }


}
