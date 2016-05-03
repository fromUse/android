package com.ace.utlis;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chen-gui on 16-5-3.
 */
public abstract class ImageLoader extends AsyncTask<String,Void,Bitmap> {


    private Handler handler = null;

    @Override
    protected Bitmap doInBackground(String... params) {

        String url = params[0];
        Bitmap bitmap = null;
        URL Url = null;
        try {

            Url = new URL (url);
            InputStream inputStream = Url.openStream ();
            bitmap = BitmapFactory.decodeStream (inputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        updateUI( bitmap);
    }

    protected abstract void updateUI(Bitmap bitmap);
}
