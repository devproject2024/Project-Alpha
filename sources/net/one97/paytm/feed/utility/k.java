package net.one97.paytm.feed.utility;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public enum k {
    DEFAULT("DEFAULT"),
    CATEGORY("CATEGORY"),
    NEWS("NEWS"),
    LIVETV("LIVETV"),
    VIDEOS("VIDEO"),
    GAMEPIND("GAMEPIND"),
    SHEROES(AppConstants.SHEROES),
    TWITTERMOMENT("TWITTERMOMENT"),
    MERCHANTSTOREFRONT("MERCHANTENTRY"),
    MERCHANTDEAL("MERCHANTDEAL"),
    TOGETU("TOGETU"),
    COMMENTS("COMMENTS"),
    PROGRESS("PROGRESS"),
    SCORECARD("SCORECARD_V2"),
    PROMOBANNERS("PROMOBANNERS"),
    PROMOCARDS("PROMOTION"),
    PROMONEWS("PROMONEWS"),
    PROMOVIDEOS("PROMOVIDEO"),
    PROMOTWITTERMOMENT("PROMOTWITTERMOMENT"),
    TRENDING("TRENDING"),
    TRAIN("PNRCHECK"),
    GENERIC("GENERIC"),
    RECOMMENDEDAPPS("RECOMMENDEDAPPS"),
    RECOMMENDEDAPPS_2("RECOMMENDEDAPPS_2"),
    RECOMMENDEDPOSTS("RECOMMENDEDPOSTS"),
    RECOMMENDEDPOSTS_2("RECOMMENDEDPOSTS_2"),
    WEATHERCARD("WEATHER"),
    HIGHLIGHTS("HIGHLIGHTS"),
    COVERAGE("COVERAGE"),
    STORIES("STORIES"),
    BANNERS("BANNERS"),
    POLLS("POLLS"),
    POSTER("POSTER"),
    PUBLISHER("PUBLISHER"),
    TOPVIDEOS("TOPVIDEOS"),
    LANGUAGE("LANGUAGE"),
    GREETING("GREETING");
    
    private String type;

    private k(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        kotlin.g.b.k.c(str, "<set-?>");
        this.type = str;
    }
}
