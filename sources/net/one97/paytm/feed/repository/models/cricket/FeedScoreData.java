package net.one97.paytm.feed.repository.models.cricket;

import easypay.manager.Constants;
import java.util.HashMap;
import kotlin.g.b.k;

public final class FeedScoreData {
    public static final FeedScoreData INSTANCE;
    private static HashMap<Integer, FeedTeam> data = new HashMap<>();

    static {
        FeedScoreData feedScoreData = new FeedScoreData();
        INSTANCE = feedScoreData;
        feedScoreData.initialize();
    }

    private FeedScoreData() {
    }

    public final HashMap<Integer, FeedTeam> getData() {
        return data;
    }

    public final void setData(HashMap<Integer, FeedTeam> hashMap) {
        k.c(hashMap, "<set-?>");
        data = hashMap;
    }

    public final void initialize() {
        data.put(4340, new FeedTeam(4340, "RCB", "Royal Challengers Bangalore", "https://d1nejz19gvza86.cloudfront.net//root/image/335970.png"));
        data.put(4344, new FeedTeam(4344, Constants.EASYPAY_PAYTYPE_DEBIT_CARD, "Delhi Capitals", "https://d1nejz19gvza86.cloudfront.net//root/image/335975.png"));
        data.put(4343, new FeedTeam(4343, "CSK", "Chennai Super Kings", "https://d1nejz19gvza86.cloudfront.net//root/image/335974.png"));
        data.put(4345, new FeedTeam(4345, "RR", "Rajasthan Royals", "https://d1nejz19gvza86.cloudfront.net//root/image/335977.png"));
        data.put(4341, new FeedTeam(4341, "KKR", "Kolkata Knight Riders", "https://d1nejz19gvza86.cloudfront.net//root/image/335971.png"));
        data.put(4342, new FeedTeam(4342, "KXIP", "Kings XI Punjab", "https://d1nejz19gvza86.cloudfront.net//root/image/335973.png"));
        data.put(4346, new FeedTeam(4346, "MI", "Mumbai Indians", "https://d1nejz19gvza86.cloudfront.net//root/image/335978.png"));
        data.put(5143, new FeedTeam(5143, "SRH", "Sunrisers Hyderabad", "https://d1nejz19gvza86.cloudfront.net//root/image/628333.png"));
    }
}
