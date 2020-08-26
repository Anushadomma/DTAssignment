package com.example.dtassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.FileNotFoundException;

public class MainActivity extends Activity {

    CustomAppDataAdapter customAppDataAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Intent in = new Intent(getApplicationContext(), DetailAppDataActivity.class);
                in.putExtra("position",pos);
                startActivity(in);


            }
        });

        if(isNetworkAvailable()){
            AppDataTask download = new AppDataTask();
            download.execute();
        }else{
            customAppDataAdapter = new CustomAppDataAdapter(getApplicationContext(), -1, AppXmlPullParser.getAppDataFromFile(MainActivity.this));
            listView.setAdapter(customAppDataAdapter);
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private class AppDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {
            //Download the file
            try {
                FileLoader.DownloadFromUrl("http://ads.appia.com/getAds?id=236&password=OVUJ1DJN&siteId=10777&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=10", openFileOutput("techtestsession&totalCampaignsRequested=10", Context.MODE_PRIVATE));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            customAppDataAdapter = new CustomAppDataAdapter(MainActivity.this, -1, AppXmlPullParser.getAppDataFromFile(MainActivity.this));
            listView.setAdapter(customAppDataAdapter);
        }
    }
}