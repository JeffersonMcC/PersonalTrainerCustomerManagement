package com.bignerdranch2nded.android.personaltrainer;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.File;
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

    private PictureUtils mPictureUtils = new PictureUtils();

    private Bitmap mClientPhoto;

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
        Log.d(TAG, "setName started");
        mName = name;
    }

    public String getName(){
        Log.d(TAG, "getName started");

        return mName;
    }

    public String getPhotoFilename(){
        return "IMG_" + getClientId().toString() + ".jpg";
    }

    public void setBitMap(Bitmap bm){
        Log.d(TAG, "setBitMap started");
        mClientPhoto =  bm;
    }

    public Bitmap getBitMap(){
        Log.d(TAG, "getBitMap started");

        return mClientPhoto;
    }

    public String getStringBitMap(){
        return mPictureUtils.BitMapToString(mClientPhoto);
    }
}
