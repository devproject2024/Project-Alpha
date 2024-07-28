package net.one97.paytm.feed.repository.models.livetv;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class Channel implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String channelGenre;
    private final String channelId;
    private final String channelName;
    private final String channelThumbnailUrl;
    private String fid;
    private final String height;
    private String id;
    private final String language;
    private final String programDescription;
    private final String programEndTime;
    private final String programImageUrl;
    private final String programName;
    private final String programStartTime;
    private final String programUrl;
    private final String source;
    private final String width;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Channel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new Channel[i2];
        }
    }

    public static /* synthetic */ Channel copy$default(Channel channel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i2, Object obj) {
        Channel channel2 = channel;
        int i3 = i2;
        return channel.copy((i3 & 1) != 0 ? channel2.id : str, (i3 & 2) != 0 ? channel2.channelId : str2, (i3 & 4) != 0 ? channel2.channelName : str3, (i3 & 8) != 0 ? channel2.channelThumbnailUrl : str4, (i3 & 16) != 0 ? channel2.channelGenre : str5, (i3 & 32) != 0 ? channel2.language : str6, (i3 & 64) != 0 ? channel2.source : str7, (i3 & 128) != 0 ? channel2.programName : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? channel2.programDescription : str9, (i3 & 512) != 0 ? channel2.programUrl : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? channel2.programImageUrl : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? channel2.programStartTime : str12, (i3 & 4096) != 0 ? channel2.programEndTime : str13, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? channel2.fid : str14, (i3 & 16384) != 0 ? channel2.height : str15, (i3 & 32768) != 0 ? channel2.width : str16);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.programUrl;
    }

    public final String component11() {
        return this.programImageUrl;
    }

    public final String component12() {
        return this.programStartTime;
    }

    public final String component13() {
        return this.programEndTime;
    }

    public final String component14() {
        return this.fid;
    }

    public final String component15() {
        return this.height;
    }

    public final String component16() {
        return this.width;
    }

    public final String component2() {
        return this.channelId;
    }

    public final String component3() {
        return this.channelName;
    }

    public final String component4() {
        return this.channelThumbnailUrl;
    }

    public final String component5() {
        return this.channelGenre;
    }

    public final String component6() {
        return this.language;
    }

    public final String component7() {
        return this.source;
    }

    public final String component8() {
        return this.programName;
    }

    public final String component9() {
        return this.programDescription;
    }

    public final Channel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        String str17 = str;
        k.c(str17, "id");
        k.c(str2, "channelId");
        k.c(str3, "channelName");
        k.c(str4, "channelThumbnailUrl");
        k.c(str5, "channelGenre");
        k.c(str6, "language");
        k.c(str7, "source");
        k.c(str10, "programUrl");
        k.c(str11, "programImageUrl");
        k.c(str14, "fid");
        return new Channel(str17, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        return k.a((Object) this.id, (Object) channel.id) && k.a((Object) this.channelId, (Object) channel.channelId) && k.a((Object) this.channelName, (Object) channel.channelName) && k.a((Object) this.channelThumbnailUrl, (Object) channel.channelThumbnailUrl) && k.a((Object) this.channelGenre, (Object) channel.channelGenre) && k.a((Object) this.language, (Object) channel.language) && k.a((Object) this.source, (Object) channel.source) && k.a((Object) this.programName, (Object) channel.programName) && k.a((Object) this.programDescription, (Object) channel.programDescription) && k.a((Object) this.programUrl, (Object) channel.programUrl) && k.a((Object) this.programImageUrl, (Object) channel.programImageUrl) && k.a((Object) this.programStartTime, (Object) channel.programStartTime) && k.a((Object) this.programEndTime, (Object) channel.programEndTime) && k.a((Object) this.fid, (Object) channel.fid) && k.a((Object) this.height, (Object) channel.height) && k.a((Object) this.width, (Object) channel.width);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.channelId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.channelName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.channelThumbnailUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.channelGenre;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.language;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.source;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.programName;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.programDescription;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.programUrl;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.programImageUrl;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.programStartTime;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.programEndTime;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.fid;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.height;
        int hashCode15 = (hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.width;
        if (str16 != null) {
            i2 = str16.hashCode();
        }
        return hashCode15 + i2;
    }

    public final String toString() {
        return "Channel(id=" + this.id + ", channelId=" + this.channelId + ", channelName=" + this.channelName + ", channelThumbnailUrl=" + this.channelThumbnailUrl + ", channelGenre=" + this.channelGenre + ", language=" + this.language + ", source=" + this.source + ", programName=" + this.programName + ", programDescription=" + this.programDescription + ", programUrl=" + this.programUrl + ", programImageUrl=" + this.programImageUrl + ", programStartTime=" + this.programStartTime + ", programEndTime=" + this.programEndTime + ", fid=" + this.fid + ", height=" + this.height + ", width=" + this.width + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.channelId);
        parcel.writeString(this.channelName);
        parcel.writeString(this.channelThumbnailUrl);
        parcel.writeString(this.channelGenre);
        parcel.writeString(this.language);
        parcel.writeString(this.source);
        parcel.writeString(this.programName);
        parcel.writeString(this.programDescription);
        parcel.writeString(this.programUrl);
        parcel.writeString(this.programImageUrl);
        parcel.writeString(this.programStartTime);
        parcel.writeString(this.programEndTime);
        parcel.writeString(this.fid);
        parcel.writeString(this.height);
        parcel.writeString(this.width);
    }

    public Channel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        String str17 = str4;
        String str18 = str5;
        String str19 = str6;
        String str20 = str7;
        String str21 = str10;
        String str22 = str11;
        String str23 = str14;
        k.c(str, "id");
        k.c(str2, "channelId");
        k.c(str3, "channelName");
        k.c(str17, "channelThumbnailUrl");
        k.c(str18, "channelGenre");
        k.c(str19, "language");
        k.c(str20, "source");
        k.c(str21, "programUrl");
        k.c(str22, "programImageUrl");
        k.c(str23, "fid");
        this.id = str;
        this.channelId = str2;
        this.channelName = str3;
        this.channelThumbnailUrl = str17;
        this.channelGenre = str18;
        this.language = str19;
        this.source = str20;
        this.programName = str8;
        this.programDescription = str9;
        this.programUrl = str21;
        this.programImageUrl = str22;
        this.programStartTime = str12;
        this.programEndTime = str13;
        this.fid = str23;
        this.height = str15;
        this.width = str16;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getChannelThumbnailUrl() {
        return this.channelThumbnailUrl;
    }

    public final String getChannelGenre() {
        return this.channelGenre;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final String getProgramDescription() {
        return this.programDescription;
    }

    public final String getProgramUrl() {
        return this.programUrl;
    }

    public final String getProgramImageUrl() {
        return this.programImageUrl;
    }

    public final String getProgramStartTime() {
        return this.programStartTime;
    }

    public final String getProgramEndTime() {
        return this.programEndTime;
    }

    public final String getFid() {
        return this.fid;
    }

    public final void setFid(String str) {
        k.c(str, "<set-?>");
        this.fid = str;
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getWidth() {
        return this.width;
    }
}
