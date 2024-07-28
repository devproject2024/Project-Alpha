package net.one97.paytm.feed.repository.models.cricket;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class FeedCricketData implements FeedItemData {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private String awayTeamAbbr;
    private String awayTeamId;
    private String awayTeamLogo;
    private final String clickUrl;
    private final String dataUrl;
    private final String description;
    private String homeTeamAbbr;
    private String homeTeamId;
    private String homeTeamLogo;
    private final String id;
    private final String matchId;
    private final String startTime;
    private final String title;

    public static /* synthetic */ FeedCricketData copy$default(FeedCricketData feedCricketData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i2, Object obj) {
        FeedCricketData feedCricketData2 = feedCricketData;
        int i3 = i2;
        return feedCricketData.copy((i3 & 1) != 0 ? feedCricketData2.id : str, (i3 & 2) != 0 ? feedCricketData2.startTime : str2, (i3 & 4) != 0 ? feedCricketData2.title : str3, (i3 & 8) != 0 ? feedCricketData2.dataUrl : str4, (i3 & 16) != 0 ? feedCricketData2.description : str5, (i3 & 32) != 0 ? feedCricketData2.homeTeamAbbr : str6, (i3 & 64) != 0 ? feedCricketData2.awayTeamAbbr : str7, (i3 & 128) != 0 ? feedCricketData2.homeTeamLogo : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? feedCricketData2.awayTeamLogo : str9, (i3 & 512) != 0 ? feedCricketData2.homeTeamId : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? feedCricketData2.awayTeamId : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? feedCricketData2.clickUrl : str12, (i3 & 4096) != 0 ? feedCricketData2.matchId : str13);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.homeTeamId;
    }

    public final String component11() {
        return this.awayTeamId;
    }

    public final String component12() {
        return this.clickUrl;
    }

    public final String component13() {
        return this.matchId;
    }

    public final String component2() {
        return this.startTime;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.dataUrl;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.homeTeamAbbr;
    }

    public final String component7() {
        return this.awayTeamAbbr;
    }

    public final String component8() {
        return this.homeTeamLogo;
    }

    public final String component9() {
        return this.awayTeamLogo;
    }

    public final FeedCricketData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        String str14 = str;
        k.c(str14, "id");
        String str15 = str2;
        k.c(str15, "startTime");
        String str16 = str3;
        k.c(str16, "title");
        String str17 = str4;
        k.c(str17, "dataUrl");
        String str18 = str6;
        k.c(str18, "homeTeamAbbr");
        String str19 = str7;
        k.c(str19, "awayTeamAbbr");
        String str20 = str8;
        k.c(str20, "homeTeamLogo");
        String str21 = str9;
        k.c(str21, "awayTeamLogo");
        String str22 = str10;
        k.c(str22, "homeTeamId");
        String str23 = str11;
        k.c(str23, "awayTeamId");
        String str24 = str12;
        k.c(str24, "clickUrl");
        return new FeedCricketData(str14, str15, str16, str17, str5, str18, str19, str20, str21, str22, str23, str24, str13);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedCricketData)) {
            return false;
        }
        FeedCricketData feedCricketData = (FeedCricketData) obj;
        return k.a((Object) this.id, (Object) feedCricketData.id) && k.a((Object) this.startTime, (Object) feedCricketData.startTime) && k.a((Object) this.title, (Object) feedCricketData.title) && k.a((Object) this.dataUrl, (Object) feedCricketData.dataUrl) && k.a((Object) this.description, (Object) feedCricketData.description) && k.a((Object) this.homeTeamAbbr, (Object) feedCricketData.homeTeamAbbr) && k.a((Object) this.awayTeamAbbr, (Object) feedCricketData.awayTeamAbbr) && k.a((Object) this.homeTeamLogo, (Object) feedCricketData.homeTeamLogo) && k.a((Object) this.awayTeamLogo, (Object) feedCricketData.awayTeamLogo) && k.a((Object) this.homeTeamId, (Object) feedCricketData.homeTeamId) && k.a((Object) this.awayTeamId, (Object) feedCricketData.awayTeamId) && k.a((Object) this.clickUrl, (Object) feedCricketData.clickUrl) && k.a((Object) this.matchId, (Object) feedCricketData.matchId);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.startTime;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.dataUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.homeTeamAbbr;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.awayTeamAbbr;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.homeTeamLogo;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.awayTeamLogo;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.homeTeamId;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.awayTeamId;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.clickUrl;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.matchId;
        if (str13 != null) {
            i2 = str13.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "FeedCricketData(id=" + this.id + ", startTime=" + this.startTime + ", title=" + this.title + ", dataUrl=" + this.dataUrl + ", description=" + this.description + ", homeTeamAbbr=" + this.homeTeamAbbr + ", awayTeamAbbr=" + this.awayTeamAbbr + ", homeTeamLogo=" + this.homeTeamLogo + ", awayTeamLogo=" + this.awayTeamLogo + ", homeTeamId=" + this.homeTeamId + ", awayTeamId=" + this.awayTeamId + ", clickUrl=" + this.clickUrl + ", matchId=" + this.matchId + ")";
    }

    public FeedCricketData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        k.c(str, "id");
        k.c(str2, "startTime");
        k.c(str3, "title");
        k.c(str4, "dataUrl");
        k.c(str6, "homeTeamAbbr");
        k.c(str7, "awayTeamAbbr");
        k.c(str8, "homeTeamLogo");
        k.c(str9, "awayTeamLogo");
        k.c(str10, "homeTeamId");
        k.c(str11, "awayTeamId");
        k.c(str12, "clickUrl");
        this.id = str;
        this.startTime = str2;
        this.title = str3;
        this.dataUrl = str4;
        this.description = str5;
        this.homeTeamAbbr = str6;
        this.awayTeamAbbr = str7;
        this.homeTeamLogo = str8;
        this.awayTeamLogo = str9;
        this.homeTeamId = str10;
        this.awayTeamId = str11;
        this.clickUrl = str12;
        this.matchId = str13;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDataUrl() {
        return this.dataUrl;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getHomeTeamAbbr() {
        return this.homeTeamAbbr;
    }

    public final void setHomeTeamAbbr(String str) {
        k.c(str, "<set-?>");
        this.homeTeamAbbr = str;
    }

    public final String getAwayTeamAbbr() {
        return this.awayTeamAbbr;
    }

    public final void setAwayTeamAbbr(String str) {
        k.c(str, "<set-?>");
        this.awayTeamAbbr = str;
    }

    public final String getHomeTeamLogo() {
        return this.homeTeamLogo;
    }

    public final void setHomeTeamLogo(String str) {
        k.c(str, "<set-?>");
        this.homeTeamLogo = str;
    }

    public final String getAwayTeamLogo() {
        return this.awayTeamLogo;
    }

    public final void setAwayTeamLogo(String str) {
        k.c(str, "<set-?>");
        this.awayTeamLogo = str;
    }

    public final String getHomeTeamId() {
        return this.homeTeamId;
    }

    public final void setHomeTeamId(String str) {
        k.c(str, "<set-?>");
        this.homeTeamId = str;
    }

    public final String getAwayTeamId() {
        return this.awayTeamId;
    }

    public final void setAwayTeamId(String str) {
        k.c(str, "<set-?>");
        this.awayTeamId = str;
    }

    public final String getClickUrl() {
        return this.clickUrl;
    }

    public final String getMatchId() {
        return this.matchId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FeedCricketData(android.os.Parcel r16) {
        /*
            r15 = this;
            java.lang.String r0 = "parcel"
            r1 = r16
            kotlin.g.b.k.c(r1, r0)
            java.lang.String r2 = r16.readString()
            if (r2 != 0) goto L_0x0010
            kotlin.g.b.k.a()
        L_0x0010:
            java.lang.String r0 = "parcel.readString()!!"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            java.lang.String r3 = r16.readString()
            if (r3 != 0) goto L_0x001e
            kotlin.g.b.k.a()
        L_0x001e:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            java.lang.String r4 = r16.readString()
            if (r4 != 0) goto L_0x002a
            kotlin.g.b.k.a()
        L_0x002a:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            java.lang.String r5 = r16.readString()
            if (r5 != 0) goto L_0x0036
            kotlin.g.b.k.a()
        L_0x0036:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            java.lang.String r6 = r16.readString()
            java.lang.String r7 = r16.readString()
            if (r7 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            java.lang.String r8 = r16.readString()
            if (r8 != 0) goto L_0x0052
            kotlin.g.b.k.a()
        L_0x0052:
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            java.lang.String r9 = r16.readString()
            if (r9 != 0) goto L_0x005e
            kotlin.g.b.k.a()
        L_0x005e:
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            java.lang.String r10 = r16.readString()
            if (r10 != 0) goto L_0x006a
            kotlin.g.b.k.a()
        L_0x006a:
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
            java.lang.String r11 = r16.readString()
            if (r11 != 0) goto L_0x0076
            kotlin.g.b.k.a()
        L_0x0076:
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            java.lang.String r12 = r16.readString()
            if (r12 != 0) goto L_0x0082
            kotlin.g.b.k.a()
        L_0x0082:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            java.lang.String r13 = r16.readString()
            if (r13 != 0) goto L_0x008e
            kotlin.g.b.k.a()
        L_0x008e:
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
            java.lang.String r14 = r16.readString()
            r1 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.models.cricket.FeedCricketData.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.startTime);
        parcel.writeString(this.title);
        parcel.writeString(this.dataUrl);
        parcel.writeString(this.description);
        parcel.writeString(this.homeTeamAbbr);
        parcel.writeString(this.awayTeamAbbr);
        parcel.writeString(this.homeTeamLogo);
        parcel.writeString(this.awayTeamLogo);
        parcel.writeString(this.homeTeamId);
        parcel.writeString(this.awayTeamId);
        parcel.writeString(this.clickUrl);
        parcel.writeString(this.matchId);
    }

    public static final class CREATOR implements Parcelable.Creator<FeedCricketData> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final FeedCricketData createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new FeedCricketData(parcel);
        }

        public final FeedCricketData[] newArray(int i2) {
            return new FeedCricketData[i2];
        }
    }
}
