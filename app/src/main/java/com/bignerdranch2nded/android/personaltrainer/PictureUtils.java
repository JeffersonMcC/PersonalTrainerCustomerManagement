package com.bignerdranch2nded.android.personaltrainer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

/**
 * Created by Jeffrow on 10/5/2016.
 */
public class PictureUtils {
    public static final String TAG = "PictureUtils";

    private static String temp;
    private static Bitmap bitmap;

    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path, size.x, size.y);
    }

    public static Bitmap getScaledBitmap(String path, int destWidth, int destHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        int inSampleSize = 1;
        if(srcHeight > destHeight || srcWidth > destWidth){
            if(srcWidth > srcHeight){
                inSampleSize = Math.round(srcHeight / destHeight);
            } else{
                inSampleSize = Math.round(srcWidth / destWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        return BitmapFactory.decodeFile(path, options);
    }

    //I got this class's code from:
    // http://stackoverflow.com/questions/13562429/how-many-ways-to-convert-bitmap-to-string-and-vice-versa
    public String BitMapToString(final Bitmap bitmap){
        if(bitmap == null){
            return " ";
        } else{
            AsyncTask.execute(new Runnable() {
                ByteArrayOutputStream baos;
                byte [] b;
                @Override
                public void run() {
                    baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG,50, baos);
                    b = baos.toByteArray();
                    temp = Base64.encodeToString(b, Base64.DEFAULT);
                }
            });
            return temp;
        }
    }

    public Bitmap StringToBitMap(final String encodedString){
        if(encodedString == " " || encodedString == null){
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
