package com.travel.sale.data.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CampaignDetailsResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private CampaignDetails body;
    @b(a = "code")
    private int code;
    @b(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }

    public CampaignDetails getBody() {
        return this.body;
    }

    public class CampaignDetails extends IJRPaytmDataModel {
        @b(a = "addToCalendarText")
        private String addToCalendarText;
        @b(a = "addedReminderText")
        private String addedReminderText;
        @b(a = "addedToCalendarText")
        private String addedToCalendarText;
        @b(a = "calendarButtonHeader")
        private String calendarButtonHeader;
        @b(a = "calendarButtonText")
        private String calendarButtonText;
        @b(a = "calendarDescription")
        private String calendarDescription;
        @b(a = "calendarIconUrl")
        private String calendarIconUrl;
        @b(a = "calendarTitle")
        private String calendarTitle;
        @b(a = "campaignDeepLink")
        private String campaignDeepLink;
        @b(a = "campaignName")
        private String campaignName;
        @b(a = "currentTimestamp")
        private Long currentTimestamp;
        @b(a = "disabledCampaignHeading")
        private String disabledCampaignHeading;
        @b(a = "disabledCampaignIconUrl")
        private String disabledCampaignIconUrl;
        @b(a = "disabledCampaignText")
        private String disabledCampaignText;
        @b(a = "displayAddToCalendar")
        private boolean displayAddToCalendar;
        @b(a = "endDateOn")
        private String endDateOn;
        @b(a = "endEpoch")
        private Long endEpoch;
        @b(a = "endTimeOn")
        private String endTimeOn;
        @b(a = "endsInText")
        private String endsInText;
        @b(a = "endsOnText")
        private String endsOnText;
        @b(a = "error")
        private String error;
        @b(a = "getReminderText")
        private String getReminderText;
        @b(a = "interestedCustomerCount")
        private long interestedCustomerCount;
        @b(a = "isActive")
        private boolean isActive;
        @b(a = "isAddedToCalendar")
        private boolean isAddedToCalendar;
        @b(a = "isInterested")
        private boolean isInterested;
        @b(a = "isSaleLive")
        private boolean isSaleLive;
        @b(a = "mainImageOrVideoType")
        private String mainImageOrVideoType;
        @b(a = "mainImageOrVideoUrl")
        private String mainImageOrVideoUrl;
        @b(a = "message")
        private String message;
        @b(a = "registeredText")
        private String registeredText;
        @b(a = "registeredUsersIconUrl")
        private String registeredUsersIconUrl;
        @b(a = "saleLiveText")
        private String saleLiveText;
        @b(a = "salesCampaignId")
        private String salesCampaignId;
        @b(a = "shareButtonHeader")
        private String shareButtonHeader;
        @b(a = "shareButtonText")
        private String shareButtonText;
        @b(a = "shareCTAText")
        private String shareCTAText;
        @b(a = "shareHeader")
        private String shareHeader;
        @b(a = "shareIcon")
        private String shareIcon;
        @b(a = "shareText")
        private String shareText;
        @b(a = "startDateOn")
        private String startDateOn;
        @b(a = "startEpoch")
        private Long startEpoch;
        @b(a = "startTimeOn")
        private String startTimeOn;
        @b(a = "startsOnText")
        private String startsOnText;
        @b(a = "status")
        private String status;
        @b(a = "storefrontUrl")
        private String storefrontUrl;
        @b(a = "successfullySubscribedHeading")
        private String successfullySubscribedHeading;
        @b(a = "successfullySubscribedIconUrl")
        private String successfullySubscribedIconUrl;
        @b(a = "successfullySubscribedText")
        private String successfullySubscribedText;
        @b(a = "videoUrl")
        private String videoUrl;

        public CampaignDetails() {
        }

        public String getCampaignName() {
            return this.campaignName;
        }

        public String getStorefrontUrl() {
            return this.storefrontUrl;
        }

        public String getMainImageOrVideoUrl() {
            return this.mainImageOrVideoUrl;
        }

        public String getMainImageOrVideoType() {
            return this.mainImageOrVideoType;
        }

        public String getStartDateOn() {
            return this.startDateOn;
        }

        public String getStartTimeOn() {
            return this.startTimeOn;
        }

        public String getEndDateOn() {
            return this.endDateOn;
        }

        public String getEndTimeOn() {
            return this.endTimeOn;
        }

        public void setIsActive(boolean z) {
            this.isActive = z;
        }

        public boolean isActive() {
            return this.isActive;
        }

        public long getInterestedCustomerCount() {
            return this.interestedCustomerCount;
        }

        public String getDisabledCampaignIconUrl() {
            return this.disabledCampaignIconUrl;
        }

        public String getDisabledCampaignHeading() {
            return this.disabledCampaignHeading;
        }

        public String getDisabledCampaignText() {
            return this.disabledCampaignText;
        }

        public String getSuccessfullySubscribedIconUrl() {
            return this.successfullySubscribedIconUrl;
        }

        public String getSuccessfullySubscribedHeading() {
            return this.successfullySubscribedHeading;
        }

        public String getSuccessfullySubscribedText() {
            return this.successfullySubscribedText;
        }

        public void setDisplayAddToCalendar(boolean z) {
            this.displayAddToCalendar = z;
        }

        public boolean isDisplayAddToCalendar() {
            return this.displayAddToCalendar;
        }

        public void setIsInterested(boolean z) {
            this.isInterested = z;
        }

        public boolean isInterested() {
            return this.isInterested;
        }

        public String getRegisteredUsersIconUrl() {
            return this.registeredUsersIconUrl;
        }

        public String getStartsOnText() {
            return this.startsOnText;
        }

        public String getEndsOnText() {
            return this.endsOnText;
        }

        public String getCalendarIconUrl() {
            return this.calendarIconUrl;
        }

        public void setInterested(boolean z) {
            this.isInterested = z;
        }

        public String getMessage() {
            return this.message;
        }

        public String getError() {
            return this.error;
        }

        public String getStatus() {
            return this.status;
        }

        public String getShareHeader() {
            return this.shareHeader;
        }

        public String getShareText() {
            return this.shareText;
        }

        public String getShareIcon() {
            return this.shareIcon;
        }

        public String getSalesCampaignId() {
            return this.salesCampaignId;
        }

        public void setCalendarTitle(String str) {
            this.calendarTitle = str;
        }

        public String getCalendarTitle() {
            return this.calendarTitle;
        }

        public void setCalendarDescription(String str) {
            this.calendarDescription = str;
        }

        public String getCalendarDescription() {
            return this.calendarDescription;
        }

        public void setStartEpoch(Long l) {
            this.startEpoch = l;
        }

        public Long getStartEpoch() {
            return this.startEpoch;
        }

        public void setEndEpoch(Long l) {
            this.endEpoch = l;
        }

        public Long getEndEpoch() {
            return this.endEpoch;
        }

        public boolean isAddedToCalendar() {
            return this.isAddedToCalendar;
        }

        public void setAddedToCalendar(boolean z) {
            this.isAddedToCalendar = z;
        }

        public boolean isSaleLive() {
            return this.isSaleLive;
        }

        public Long getCurrentTimestamp() {
            return this.currentTimestamp;
        }

        public String getGetReminderText() {
            return this.getReminderText;
        }

        public String getAddedReminderText() {
            return this.addedReminderText;
        }

        public String getCampaignDeepLink() {
            return this.campaignDeepLink;
        }

        public String getSaleLiveText() {
            return this.saleLiveText;
        }

        public void setSaleLive(boolean z) {
            this.isSaleLive = z;
        }

        public String getAddToCalendarText() {
            return this.addToCalendarText;
        }

        public void setAddToCalendarText(String str) {
            this.addToCalendarText = str;
        }

        public String getShareButtonText() {
            return this.shareButtonText;
        }

        public void setShareButtonText(String str) {
            this.shareButtonText = str;
        }

        public String getShareCTAText() {
            return this.shareCTAText;
        }

        public void setShareCTAText(String str) {
            this.shareCTAText = str;
        }

        public String getRegisteredText() {
            return this.registeredText;
        }

        public void setRegisteredText(String str) {
            this.registeredText = str;
        }

        public String getCalendarButtonHeader() {
            return this.calendarButtonHeader;
        }

        public void setCalendarButtonHeader(String str) {
            this.calendarButtonHeader = str;
        }

        public String getCalendarButtonText() {
            return this.calendarButtonText;
        }

        public void setCalendarButtonText(String str) {
            this.calendarButtonText = str;
        }

        public String getAddedToCalendarText() {
            return this.addedToCalendarText;
        }

        public void setAddedToCalendarText(String str) {
            this.addedToCalendarText = str;
        }

        public String getShareButtonHeader() {
            return this.shareButtonHeader;
        }

        public void setShareButtonHeader(String str) {
            this.shareButtonHeader = str;
        }

        public String getVideoUrl() {
            return this.videoUrl;
        }

        public void setVideoUrl(String str) {
            this.videoUrl = str;
        }

        public void setMainImageOrVideoUrl(String str) {
            this.mainImageOrVideoUrl = str;
        }

        public void setMainImageOrVideoType(String str) {
            this.mainImageOrVideoType = str;
        }

        public void setActive(boolean z) {
            this.isActive = z;
        }

        public String getEndsInText() {
            return this.endsInText;
        }

        public void setEndsInText(String str) {
            this.endsInText = str;
        }

        public void setInterestedCustomerCount(long j) {
            this.interestedCustomerCount = j;
        }
    }
}
