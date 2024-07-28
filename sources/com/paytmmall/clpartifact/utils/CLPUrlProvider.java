package com.paytmmall.clpartifact.utils;

import android.text.TextUtils;
import com.paytmmall.clpartifact.common.CLPArtifact;

public class CLPUrlProvider {
    public static String getFollowUrl() {
        String gTMUrl = CLPArtifact.getInstance().getCommunicationListener().getGTMUrl(CLPGTMConstants.STORELED_FOLLOW_URL);
        return !TextUtils.isEmpty(gTMUrl) ? gTMUrl : "https://paytm.com/api/bucket/";
    }

    public static String getRatingUrl() {
        String gTMUrl = CLPArtifact.getInstance().getCommunicationListener().getGTMUrl(CLPGTMConstants.STORELED_RATING_URL);
        return !TextUtils.isEmpty(gTMUrl) ? gTMUrl : "https://paytm.com/api/rating/rateEntityForUser";
    }

    public static String getReportUrl() {
        String gTMUrl = CLPArtifact.getInstance().getCommunicationListener().getGTMUrl(CLPGTMConstants.STORELED_REPORT_RATING);
        return !TextUtils.isEmpty(gTMUrl) ? gTMUrl : "https://paytm.com/api/rating/flagReviews/marketplace";
    }
}
