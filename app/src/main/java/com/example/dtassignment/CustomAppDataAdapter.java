package com.example.dtassignment;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

public class CustomAppDataAdapter extends ArrayAdapter<AppData> {


    ImageLoader imageLoader;
    DisplayImageOptions options;

    public CustomAppDataAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<AppData> objects) {
        super(context, textViewResourceId, objects);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);

        options = new DisplayImageOptions.Builder()
                .cacheInMemory()
                .cacheOnDisc()
                .build();

    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        RelativeLayout row = (RelativeLayout) convertView;
        if (null == row) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = (RelativeLayout) inflater.inflate(R.layout.listview_row, null);
        }

        TextView lname = (TextView) row.findViewById(R.id.textView_name);
        TextView productName = (TextView) row.findViewById(R.id.textView_productName);
        TextView rating = (TextView) row.findViewById(R.id.textView_rating);
        final ProgressBar indicator = (ProgressBar) row.findViewById(R.id.progress);
        final ImageView productThumbnail = (ImageView) row.findViewById(R.id.imageView_productThumbnail);


        indicator.setVisibility(View.VISIBLE);
        ImageLoadingListener listener = new ImageLoadingListener() {


            @Override
            public void onLoadingStarted(String arg0, View arg1) {

            }

            @Override
            public void onLoadingCancelled(String arg0, View arg1) {

            }

            @Override
            public void onLoadingComplete(String arg0, View arg1, Bitmap arg2) {
                indicator.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingFailed(String arg0, View arg1, FailReason arg2) {

            }

        };

        lname.setText("Dommaraju");
        productName.setText(getItem(pos).getProductName());
        rating.setText(getItem(pos).getRating());
        imageLoader.displayImage(getItem(pos).getProductThumbline(), productThumbnail, options, listener);


        return row;

    }
}