package com.example.dtassignment;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

//class for downloading file
public class FileLoader {

    private static String myTag = "ads";

    public static void DownloadFromUrl(String URL, FileOutputStream fos) {
        try {

                URL url = new URL(URL) ;
                URLConnection ucon = url.openConnection();

                InputStream is = ucon.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                Log.i(myTag, "Got InputStream and BufferedInputStream");

                BufferedOutputStream bos = new BufferedOutputStream(fos);
                Log.i(myTag, "Got FileOutputStream and BufferedOutputStream");

                byte data[] = new byte[1024];
                int count;
                while ((count = bis.read(data)) != -1) {

                    bos.write(data, 0, count);
                }
                bos.flush();
                bos.close();

        } catch (IOException e) {
            Log.d(myTag, "Error: " + e);
        }
    }
}
