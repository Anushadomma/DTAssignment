package com.example.dtassignment;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AppXmlPullParser {

    public static List<AppData> getStackSitesFromFile(Context ctx) {

        List<AppData> appData;
        appData = new ArrayList<AppData>();

        AppData curAppData = null;
        String curText = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();

            FileInputStream fis = ctx.openFileInput("echtestsession&totalCampaignsRequested=10");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            xpp.setInput(reader);

            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = xpp.getName();

                //different event types
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase(Constants.KEY_AD)) {
                            curAppData = new AppData();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        curText = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase(Constants.KEY_AD)) {
                            appData.add(curAppData);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_APP_ID)){
                            curAppData.setAppId(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_AVAERAGE_RATING_IMAGE_URL)){
                            curAppData.setAverageRatingImageURL(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_BID_RATE)) {
                            curAppData.setBidRate(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_Billing_TYPE_ID)){
                            curAppData.setBillingTypeId(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_CALL_TO_ACTION)){
                            curAppData.setCallToAction(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_CAMPAIGN_DISPLAY_ORDER)){
                            curAppData.setCampaignDisplayOrder(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_CAMPAIGN_ID)){
                            curAppData.setCampaignId(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_CAMPAIGN_TYPE_ID)){
                            curAppData.setCampaignTypeId(curText);

                        } else if (tagname.equalsIgnoreCase(Constants.KEY_CATEGORY_NAME)) {
                            curAppData.setCategoryName(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_CLICK_PROXY_URL)){
                            curAppData.setClickProxyURL(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_CREATIVE_ID)){
                            curAppData.setCreativeId(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_EXTERNAL_META_DATA)){
                            curAppData.setExternalMetadata(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_HOME_SCREEN)){
                            curAppData.setHomeScreen(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_IMPRESSION_TRACKING_URL)){
                            curAppData.setImpressionTrackingURL(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_IS_RANDOM_PICK)){
                            curAppData.setIsRandomPick(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_NUMBER_OF_RATINGS)){
                            curAppData.setNumberOfRatings(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_PRODUCT_DESCRIPTION)){
                            curAppData.setProductDescription(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_PRODUCT_ID)){
                            curAppData.setProductId(curText);

                        } else if (tagname.equalsIgnoreCase(Constants.KEY_PRODUCT_NAME)) {
                            curAppData.setProductName(curText);

                        } else if (tagname.equalsIgnoreCase(Constants.KEY_PRODUCT_THUMBNAIL)) {
                            curAppData.setProductThumbline(curText);

                        } else if (tagname.equalsIgnoreCase(Constants.KEY_RATING)) {
                            curAppData.setRating(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_NUMBER_OF_DOWNLOADS)){
                            curAppData.setNumberOfDownloads(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_TSTI_ELIGIBLE)){
                            curAppData.setTstiEligible(curText);

                        } else if(tagname.equalsIgnoreCase(Constants.KEY_STI_ENABLED)){
                            curAppData.setStiEnabled(curText);
                        }
                        break;

                    default:
                        break;
                }
                //next iteration
                eventType = xpp.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // return list
        return appData;
    }
}
