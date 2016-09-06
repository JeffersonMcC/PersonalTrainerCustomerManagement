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

    public UUID getId(){
        return mId;
    }

    public void setProfileImage(){

    }

    /*
    public int getCustomProfileImage(){
        mDrawableName = "";
        int profileImageResourceId = getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
    }
    */

    /*
    public int getDefaultProfileImage(){
        mDrawableName = "user";
        profileImageResourceId = context.getResources().getIdentifier()
    }
    */

    public String getName(){
        return mName;
    }

    public void setName(String name){
        mName = name;
    }

    public Date getSessionDate(){
        return mSessionDate;
    }

    public void setSessionDate(Date date){
        mSessionDate = date;
    }


}
