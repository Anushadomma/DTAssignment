package com.example.dtassignment;

public class AppData {

    private String appId;
    private String averageRatingImageURL;
    private String bidRate;
    private String billingTypeId;
    private String callToAction;
    private String campaignDisplayOrder;
    private String campaignId;
    private String campaignTypeId;
    private String categoryName;
    private String clickProxyURL;
    private String creativeId;
    private String externalMetadata;
    private String homeScreen;
    private String impressionTrackingURL;
    private String isRandomPick;
    private String numberOfRatings;
    private String productDescription;
    private String productId;
    private String productName;
    private String productThumbnail;
    private String rating;
    private String numberOfDownloads;
    private String tstiEligible;
    private String stiEnabled;


    public String getAppId(){
        return appId;
    }

    public void setAppId(String appId){
        this.appId = appId;
    }
    public String getAverageRatingImageURL(){
        return averageRatingImageURL;
    }

    public void setAverageRatingImageURL(String averageRatingImageURL){
        this.averageRatingImageURL = averageRatingImageURL;
    }
    public String getBidRate(){
        return bidRate;
    }

    public void setBidRate(String bidRate){
        this.bidRate = bidRate;
    }
    public String getBillingTypeId(){
        return billingTypeId;
    }

    public void setBillingTypeId(String billingTypeId){
        this.billingTypeId = billingTypeId;
    }
    public String getCallToAction(){
        return callToAction;
    }

    public void setCallToAction(String callToAction){
        this.callToAction = callToAction;
    }
    public String getCampaignDisplayOrder(){
        return campaignDisplayOrder;
    }

    public void setCampaignDisplayOrder(String campaignDisplayOrder){
        this.campaignDisplayOrder = campaignDisplayOrder;
    }

    public String getCampaignId(){
        return campaignId;
    }

    public void setCampaignId(String campaignId){
        this.campaignId = campaignId;
    }
    public String getCampaignTypeId(){
        return campaignTypeId;
    }

    public void setCampaignTypeId(String campaignTypeId){
        this.campaignTypeId = campaignTypeId;
    }
    public String getCategoryName(){
        return categoryName;
    }

    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
    public String getClickProxyURL(){
        return clickProxyURL;
    }

    public void setClickProxyURL(String clickProxyURL){
        this.clickProxyURL = clickProxyURL;
    }
    public String getCreativeId(){
        return creativeId;
    }

    public void setCreativeId(String creativeId){
        this.creativeId = creativeId;
    }
    public String getExternalMetadata(){
        return externalMetadata;
    }

    public void setExternalMetadata(String externalMetadata){
        this.externalMetadata = externalMetadata;
    }
    public String getHomeScreen(){
        return homeScreen;
    }

    public void setHomeScreen(String homeScreen){
        this.homeScreen = homeScreen;
    }
    public String getImpressionTrackingURL(){
        return impressionTrackingURL;
    }

    public void setImpressionTrackingURL(String impressionTrackingURL){
        this.impressionTrackingURL = impressionTrackingURL;
    }
    public String getIsRandomPick(){
        return isRandomPick;
    }

    public void setIsRandomPick(String isRandomPick){
        this.isRandomPick = isRandomPick;
    }
    public String getNumberOfRatings(){
        return numberOfRatings;
    }

    public void setNumberOfRatings(String numberOfRatings){
        this.numberOfRatings = numberOfRatings;
    }
    public String getProductDescription(){
        return productDescription;
    }

    public void setProductDescription(String productDescription){
        this.productDescription = productDescription;
    }
    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getProductThumbline(){
        return productThumbnail;
    }

    public void setProductThumbline(String productThumbline){
        this.productThumbnail = productThumbline;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String rating){
        this.rating = rating;
    }
    public String getNumberOfDownloads(){
        return numberOfDownloads;
    }

    public void setNumberOfDownloads(String numberOfDownloads){
        this.numberOfDownloads = numberOfDownloads;
    }
    public String getTstiEligible(){
        return tstiEligible;
    }

    public void setTstiEligible(String tstiEligible){
        this.tstiEligible = tstiEligible;
    }
    public String getStiEnabled(){
        return stiEnabled;
    }

    public void setStiEnabled(String stiEnabled){
        this.stiEnabled = stiEnabled;
    }
   @Override
    public String toString() {
        return "AppData [productName=" + productName + ", productThumbline=" + productThumbnail + ", rating=" + rating + "]";
    }
}
