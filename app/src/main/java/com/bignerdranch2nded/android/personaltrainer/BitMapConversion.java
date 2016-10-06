package com.bignerdranch2nded.android.personaltrainer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

/**
 * Created by Jeffrow on 10/5/2016.
 */
public class BitMapConversion {
    //I got this class's code from:
    // http://stackoverflow.com/questions/13562429/how-many-ways-to-convert-bitmap-to-string-and-vice-versa
    public static final String TAG = "BitMapConversion";

    private static String temp;
    private static Bitmap bitmap;

    public static String BitMapToString(final Bitmap bitmap){
        if(bitmap == null){
            Log.d(TAG, "BitMapToString returning an empty string");
            return " ";
        } else{
            AsyncTask.execute(new Runnable() {
                ByteArrayOutputStream baos;
                byte [] b;
                @Override
                public void run() {
                    baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
                    b = baos.toByteArray();
                    temp = Base64.encodeToString(b, Base64.DEFAULT);
                }
            });
            Log.d(TAG, "BitMapToString returning a bitmap string");
            return temp;
        }
    }

    public static Bitmap StringToBitMap(final String encodedString){
        if(encodedString == " " || encodedString == null){
            Log.d(TAG, "returning null for bitmap");
            return null;
        } else{
            try {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        byte [] encodeByte=Base64.decode(encodedString,Base64.DEFAULT);
                        bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
                    }
                });
                return bitmap;
            } catch(Exception e) {
                e.getMessage();
                return null;
            }
        }
    }

}
