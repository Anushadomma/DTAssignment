package com.example.dtassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class DetailAppDataActivity extends Activity {

    ImageLoader loader;

   private TextView productNameDetail, ratingDetail, appId, bidRate, billingType, callToAction, campDisOrder, camId;
   private TextView camTypeId, categoryName, proxyUrl, craetiveId, metaData, homeScreen, trackingUrl, randomPick, numRatings,description;
   private TextView productId, numDownloads, tstEligible, stiEnable;

    ImageView productThumbnail, averageRating,back;

    int pos= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_app_data);
        productNameDetail = findViewById(R.id.textView_productNameDetails);
        ratingDetail = findViewById(R.id.textView_produtRatingDetails);
        productThumbnail = findViewById(R.id.imageView_productThumbnailDetails);
        appId = findViewById(R.id.textView_appId);
        bidRate = findViewById(R.id.textView_bidRate);
        billingType = findViewById(R.id.textView_billingType);
        callToAction = findViewById(R.id.textView_callToAction);
        campDisOrder = findViewById(R.id.textView_campaignDisplayOrder);
        camId = findViewById(R.id.textView_campaignId);
        camTypeId = findViewById(R.id.textView_campaignTypeId);
        categoryName = findViewById(R.id.textView_categoryName);
        proxyUrl = findViewById(R.id.textView_clickProxyURL);
        craetiveId = findViewById(R.id.textView_creativeId);
        metaData = findViewById(R.id.textView_externalMetadata);
        homeScreen = findViewById(R.id.textView_homeScreen);
        trackingUrl = findViewById(R.id.textView_impressionTrackingURL);
        randomPick = findViewById(R.id.textView_isRandomPick);
        numRatings = findViewById(R.id.textView_numberOfRatings);
        description = findViewById(R.id.textView_productDescription);
        productId = findViewById(R.id.textView_productId);
        numDownloads = findViewById(R.id.textView_numberOfDownloads);
        tstEligible = findViewById(R.id.textView_tstiEligible);
        stiEnable = findViewById(R.id.textView_stiEnabled);
        averageRating = findViewById(R.id.imageView_averageRating);
        back = findViewById(R.id.imageView_back_button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        loader = ImageLoader.getInstance();
        loader.init(config);

        Intent in = getIntent();
        pos = in.getExtras().getInt("position");

       CustomAppDataAdapter customAppDataAdapter = new CustomAppDataAdapter(getApplicationContext(), -1, AppXmlPullParser.getAppDataFromFile(DetailAppDataActivity.this));

        productNameDetail.setText("ProductName:  "+customAppDataAdapter.getItem(pos).getProductName());
        ratingDetail.setText("ProductRating:  "+customAppDataAdapter.getItem(pos).getRating());
        loader.displayImage(customAppDataAdapter.getItem(pos).getProductThumbline(), productThumbnail);
        appId.setText("AppId:  "+customAppDataAdapter.getItem(pos).getAppId());
        loader.displayImage(customAppDataAdapter.getItem(pos).getAverageRatingImageURL(),averageRating);
        bidRate.setText("BidRate:  "+customAppDataAdapter.getItem(pos).getBidRate());
        billingType.setText("BillingType:  "+customAppDataAdapter.getItem(pos).getBillingTypeId());
        callToAction.setText("callToAction:  "+customAppDataAdapter.getItem(pos).getCallToAction());
        campDisOrder.setText("CampaignDisplayOrder:  "+customAppDataAdapter.getItem(pos).getCampaignDisplayOrder());
        camId.setText("CampaignId:  "+customAppDataAdapter.getItem(pos).getCampaignId());
        camTypeId.setText("CampaignTypeId:  "+customAppDataAdapter.getItem(pos).getCampaignTypeId());
        categoryName.setText("CategoryName:  "+customAppDataAdapter.getItem(pos).getCategoryName());
        proxyUrl.setText("ClickProxyUrl:  "+customAppDataAdapter.getItem(pos).getClickProxyURL());
        craetiveId.setText("CreativeId:  "+customAppDataAdapter.getItem(pos).getCreativeId());
        metaData.setText("ExternalMetaData:  "+customAppDataAdapter.getItem(pos).getExternalMetadata());
        homeScreen.setText("HomeScreen:  "+customAppDataAdapter.getItem(pos).getHomeScreen());
        trackingUrl.setText("ImpressionTrackingURL:  "+customAppDataAdapter.getItem(pos).getImpressionTrackingURL());
        randomPick.setText("IsRandomPick:  "+customAppDataAdapter.getItem(pos).getIsRandomPick());
        numRatings.setText("No.of Ratings:  "+customAppDataAdapter.getItem(pos).getNumberOfRatings());
        description.setText("ProductDescription:  "+customAppDataAdapter.getItem(pos).getProductDescription());
        productId.setText("ProductId:  "+customAppDataAdapter.getItem(pos).getProductId());
        numDownloads.setText("No.of Downloads:  "+customAppDataAdapter.getItem(pos).getNumberOfDownloads());
        tstEligible.setText("TstiEligible:  "+customAppDataAdapter.getItem(pos).getTstiEligible());
        stiEnable.setText("StiEnabled:  "+customAppDataAdapter.getItem(pos).getStiEnabled());
    }
}