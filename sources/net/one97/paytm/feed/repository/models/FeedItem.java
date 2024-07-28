package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.feed.e.b;

public class FeedItem implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private final String TAG;
    private String buckets;
    private String contentFormat;
    private int feedItemCategoryRank;
    private int feedItemRank;
    private String feedItemType;
    private int followingRank;
    private String mlCategory;
    private String mlVersion;
    private String pid;
    private int profileRank;
    private double score;

    public static /* synthetic */ void TAG$annotations() {
    }

    public int describeContents() {
        return 0;
    }

    public FeedItem() {
        this.TAG = "FEED_ITEM";
        this.buckets = "";
        this.feedItemType = "";
        this.feedItemRank = 0;
        this.feedItemCategoryRank = 0;
        this.profileRank = 0;
        this.followingRank = 0;
        this.pid = "";
        this.score = 0.0d;
        this.mlVersion = "";
        this.contentFormat = "";
        this.mlCategory = "";
        b bVar = b.f34268c;
        b.k();
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final String getBuckets() {
        return this.buckets;
    }

    public final void setBuckets(String str) {
        k.c(str, "<set-?>");
        this.buckets = str;
    }

    public final String getFeedItemType() {
        return this.feedItemType;
    }

    public final void setFeedItemType(String str) {
        k.c(str, "<set-?>");
        this.feedItemType = str;
    }

    public final int getFeedItemRank() {
        return this.feedItemRank;
    }

    public final void setFeedItemRank(int i2) {
        this.feedItemRank = i2;
    }

    public final int getFeedItemCategoryRank() {
        return this.feedItemCategoryRank;
    }

    public final void setFeedItemCategoryRank(int i2) {
        this.feedItemCategoryRank = i2;
    }

    public final int getProfileRank() {
        return this.profileRank;
    }

    public final void setProfileRank(int i2) {
        this.profileRank = i2;
    }

    public final double getScore() {
        return this.score;
    }

    public final void setScore(double d2) {
        this.score = d2;
    }

    public final String getMlVersion() {
        return this.mlVersion;
    }

    public final void setMlVersion(String str) {
        k.c(str, "<set-?>");
        this.mlVersion = str;
    }

    public final String getContentFormat() {
        return this.contentFormat;
    }

    public final void setContentFormat(String str) {
        k.c(str, "<set-?>");
        this.contentFormat = str;
    }

    public final String getMlCategory() {
        return this.mlCategory;
    }

    public final void setMlCategory(String str) {
        k.c(str, "<set-?>");
        this.mlCategory = str;
    }

    public final int getFollowingRank() {
        return this.followingRank;
    }

    public final void setFollowingRank(int i2) {
        this.followingRank = i2;
    }

    public final String getPid() {
        return this.pid;
    }

    public final void setPid(String str) {
        k.c(str, "<set-?>");
        this.pid = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r1 = r5.readString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FeedItem(android.os.Parcel r5) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.String r0 = ""
            if (r5 == 0) goto L_0x000d
            java.lang.String r1 = r5.readString()
            if (r1 != 0) goto L_0x000e
        L_0x000d:
            r1 = r0
        L_0x000e:
            r4.buckets = r1
            if (r5 == 0) goto L_0x0018
            java.lang.String r1 = r5.readString()
            if (r1 != 0) goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            r4.feedItemType = r1
            r1 = 0
            if (r5 == 0) goto L_0x0023
            int r2 = r5.readInt()
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            r4.feedItemRank = r2
            if (r5 == 0) goto L_0x002d
            int r2 = r5.readInt()
            goto L_0x002e
        L_0x002d:
            r2 = 0
        L_0x002e:
            r4.feedItemCategoryRank = r2
            if (r5 == 0) goto L_0x0037
            int r2 = r5.readInt()
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            r4.profileRank = r2
            if (r5 == 0) goto L_0x0042
            java.lang.String r2 = r5.readString()
            if (r2 != 0) goto L_0x0043
        L_0x0042:
            r2 = r0
        L_0x0043:
            r4.pid = r2
            if (r5 == 0) goto L_0x004c
            double r2 = r5.readDouble()
            goto L_0x004e
        L_0x004c:
            r2 = 0
        L_0x004e:
            r4.score = r2
            if (r5 == 0) goto L_0x0058
            java.lang.String r2 = r5.readString()
            if (r2 != 0) goto L_0x0059
        L_0x0058:
            r2 = r0
        L_0x0059:
            r4.mlVersion = r2
            if (r5 == 0) goto L_0x0063
            java.lang.String r2 = r5.readString()
            if (r2 != 0) goto L_0x0064
        L_0x0063:
            r2 = r0
        L_0x0064:
            r4.contentFormat = r2
            if (r5 == 0) goto L_0x0070
            java.lang.String r2 = r5.readString()
            if (r2 != 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r0 = r2
        L_0x0070:
            r4.mlCategory = r0
            if (r5 == 0) goto L_0x0078
            int r1 = r5.readInt()
        L_0x0078:
            r4.followingRank = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.models.FeedItem.<init>(android.os.Parcel):void");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.buckets);
        parcel.writeString(this.feedItemType);
        parcel.writeInt(this.feedItemRank);
        parcel.writeInt(this.feedItemCategoryRank);
        parcel.writeInt(this.profileRank);
        parcel.writeString(this.pid);
        parcel.writeDouble(this.score);
        parcel.writeString(this.mlVersion);
        parcel.writeString(this.contentFormat);
        parcel.writeString(this.mlCategory);
        parcel.writeInt(this.followingRank);
    }

    public static final class CREATOR implements Parcelable.Creator<FeedItem> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final FeedItem createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new FeedItem(parcel);
        }

        public final FeedItem[] newArray(int i2) {
            return new FeedItem[i2];
        }
    }
}
