package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRMovieHomeListItem extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "appCvrPath")
    private String appCvrPath;
    @b(a = "appImgPath")
    private String appImgPath;
    @b(a = "censor")
    private String censor;
    @b(a = "contentId")
    private Integer contentId;
    @b(a = "cvrPath")
    private String cvrPath;
    @b(a = "duration")
    private Integer duration;
    @b(a = "edgeBanner")
    private String edgeBanner;
    @b(a = "frmtId")
    private String frmtId;
    @b(a = "grn")
    private ArrayList<String> grn;
    @b(a = "id")
    private String id;
    @b(a = "imgPath")
    private String imgPath;
    @b(a = "isNew")
    private boolean isNew;
    @b(a = "itemViewed")
    private boolean itemViewed;
    @b(a = "label")
    private String label;
    @b(a = "lang")
    private String lang;
    private CJRMetricInfoDataItem likeDislikeInfo;
    @b(a = "rnr")
    private RNR rnr;
    @b(a = "scrnFmt")
    private String scrnFmt;
    @b(a = "scrnFmtList")
    private ArrayList<GroupFormatObject> scrnFmtList;
    @b(a = "sndFmt")
    private String sndFmt;
    @b(a = "thumbnail")
    private String thumbnail;
    @b(a = "totalSessionCount")
    private int totalSessionCount;
    @b(a = "trailer")
    private String trailer;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            String str;
            ArrayList arrayList2;
            Parcel parcel2 = parcel;
            k.c(parcel2, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(readInt);
                while (true) {
                    str = readString11;
                    if (readInt == 0) {
                        break;
                    }
                    arrayList3.add(parcel.readString());
                    readInt--;
                    readString11 = str;
                }
                arrayList = arrayList3;
            } else {
                str = readString11;
                arrayList = null;
            }
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            RNR rnr = parcel.readInt() != 0 ? (RNR) RNR.CREATOR.createFromParcel(parcel2) : null;
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList4.add((GroupFormatObject) GroupFormatObject.CREATOR.createFromParcel(parcel2));
                    readInt2--;
                }
                arrayList2 = arrayList4;
            } else {
                arrayList2 = null;
            }
            return new CJRMovieHomeListItem(readString, readString2, readString3, valueOf, readString4, readString5, readString6, readString7, readString8, readString9, readString10, str, readString12, valueOf2, arrayList, readString13, readString14, rnr, z, z2, arrayList2, parcel.readInt(), parcel.readInt() != 0 ? (CJRMetricInfoDataItem) CJRMetricInfoDataItem.CREATOR.createFromParcel(parcel2) : null);
        }

        public final Object[] newArray(int i2) {
            return new CJRMovieHomeListItem[i2];
        }
    }

    public static /* synthetic */ CJRMovieHomeListItem copy$default(CJRMovieHomeListItem cJRMovieHomeListItem, String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num2, ArrayList arrayList, String str13, String str14, RNR rnr2, boolean z, boolean z2, ArrayList arrayList2, int i2, CJRMetricInfoDataItem cJRMetricInfoDataItem, int i3, Object obj) {
        CJRMovieHomeListItem cJRMovieHomeListItem2 = cJRMovieHomeListItem;
        int i4 = i3;
        return cJRMovieHomeListItem.copy((i4 & 1) != 0 ? cJRMovieHomeListItem2.id : str, (i4 & 2) != 0 ? cJRMovieHomeListItem2.label : str2, (i4 & 4) != 0 ? cJRMovieHomeListItem2.frmtId : str3, (i4 & 8) != 0 ? cJRMovieHomeListItem2.contentId : num, (i4 & 16) != 0 ? cJRMovieHomeListItem2.imgPath : str4, (i4 & 32) != 0 ? cJRMovieHomeListItem2.appImgPath : str5, (i4 & 64) != 0 ? cJRMovieHomeListItem2.cvrPath : str6, (i4 & 128) != 0 ? cJRMovieHomeListItem2.appCvrPath : str7, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRMovieHomeListItem2.thumbnail : str8, (i4 & 512) != 0 ? cJRMovieHomeListItem2.edgeBanner : str9, (i4 & TarConstants.EOF_BLOCK) != 0 ? cJRMovieHomeListItem2.trailer : str10, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRMovieHomeListItem2.lang : str11, (i4 & 4096) != 0 ? cJRMovieHomeListItem2.censor : str12, (i4 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRMovieHomeListItem2.duration : num2, (i4 & 16384) != 0 ? cJRMovieHomeListItem2.grn : arrayList, (i4 & 32768) != 0 ? cJRMovieHomeListItem2.scrnFmt : str13, (i4 & 65536) != 0 ? cJRMovieHomeListItem2.sndFmt : str14, (i4 & 131072) != 0 ? cJRMovieHomeListItem2.rnr : rnr2, (i4 & 262144) != 0 ? cJRMovieHomeListItem2.isNew : z, (i4 & 524288) != 0 ? cJRMovieHomeListItem2.itemViewed : z2, (i4 & 1048576) != 0 ? cJRMovieHomeListItem2.scrnFmtList : arrayList2, (i4 & 2097152) != 0 ? cJRMovieHomeListItem2.totalSessionCount : i2, (i4 & 4194304) != 0 ? cJRMovieHomeListItem2.likeDislikeInfo : cJRMetricInfoDataItem);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.edgeBanner;
    }

    public final String component11() {
        return this.trailer;
    }

    public final String component12() {
        return this.lang;
    }

    public final String component13() {
        return this.censor;
    }

    public final Integer component14() {
        return this.duration;
    }

    public final ArrayList<String> component15() {
        return this.grn;
    }

    public final String component16() {
        return this.scrnFmt;
    }

    public final String component17() {
        return this.sndFmt;
    }

    public final RNR component18() {
        return this.rnr;
    }

    public final boolean component19() {
        return this.isNew;
    }

    public final String component2() {
        return this.label;
    }

    public final boolean component20() {
        return this.itemViewed;
    }

    public final ArrayList<GroupFormatObject> component21() {
        return this.scrnFmtList;
    }

    public final int component22() {
        return this.totalSessionCount;
    }

    public final CJRMetricInfoDataItem component23() {
        return this.likeDislikeInfo;
    }

    public final String component3() {
        return this.frmtId;
    }

    public final Integer component4() {
        return this.contentId;
    }

    public final String component5() {
        return this.imgPath;
    }

    public final String component6() {
        return this.appImgPath;
    }

    public final String component7() {
        return this.cvrPath;
    }

    public final String component8() {
        return this.appCvrPath;
    }

    public final String component9() {
        return this.thumbnail;
    }

    public final CJRMovieHomeListItem copy(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num2, ArrayList<String> arrayList, String str13, String str14, RNR rnr2, boolean z, boolean z2, ArrayList<GroupFormatObject> arrayList2, int i2, CJRMetricInfoDataItem cJRMetricInfoDataItem) {
        return new CJRMovieHomeListItem(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, str12, num2, arrayList, str13, str14, rnr2, z, z2, arrayList2, i2, cJRMetricInfoDataItem);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "CJRMovieHomeListItem(id=" + this.id + ", label=" + this.label + ", frmtId=" + this.frmtId + ", contentId=" + this.contentId + ", imgPath=" + this.imgPath + ", appImgPath=" + this.appImgPath + ", cvrPath=" + this.cvrPath + ", appCvrPath=" + this.appCvrPath + ", thumbnail=" + this.thumbnail + ", edgeBanner=" + this.edgeBanner + ", trailer=" + this.trailer + ", lang=" + this.lang + ", censor=" + this.censor + ", duration=" + this.duration + ", grn=" + this.grn + ", scrnFmt=" + this.scrnFmt + ", sndFmt=" + this.sndFmt + ", rnr=" + this.rnr + ", isNew=" + this.isNew + ", itemViewed=" + this.itemViewed + ", scrnFmtList=" + this.scrnFmtList + ", totalSessionCount=" + this.totalSessionCount + ", likeDislikeInfo=" + this.likeDislikeInfo + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.label);
        parcel.writeString(this.frmtId);
        Integer num = this.contentId;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.imgPath);
        parcel.writeString(this.appImgPath);
        parcel.writeString(this.cvrPath);
        parcel.writeString(this.appCvrPath);
        parcel.writeString(this.thumbnail);
        parcel.writeString(this.edgeBanner);
        parcel.writeString(this.trailer);
        parcel.writeString(this.lang);
        parcel.writeString(this.censor);
        Integer num2 = this.duration;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        ArrayList<String> arrayList = this.grn;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (String writeString : arrayList) {
                parcel.writeString(writeString);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.scrnFmt);
        parcel.writeString(this.sndFmt);
        RNR rnr2 = this.rnr;
        if (rnr2 != null) {
            parcel.writeInt(1);
            rnr2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.isNew ? 1 : 0);
        parcel.writeInt(this.itemViewed ? 1 : 0);
        ArrayList<GroupFormatObject> arrayList2 = this.scrnFmtList;
        if (arrayList2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList2.size());
            for (GroupFormatObject writeToParcel : arrayList2) {
                writeToParcel.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.totalSessionCount);
        CJRMetricInfoDataItem cJRMetricInfoDataItem = this.likeDislikeInfo;
        if (cJRMetricInfoDataItem != null) {
            parcel.writeInt(1);
            cJRMetricInfoDataItem.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final String getFrmtId() {
        return this.frmtId;
    }

    public final void setFrmtId(String str) {
        this.frmtId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRMovieHomeListItem(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.Integer r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.Integer r41, java.util.ArrayList r42, java.lang.String r43, java.lang.String r44, net.one97.paytm.o2o.movies.common.movies.search.RNR r45, boolean r46, boolean r47, java.util.ArrayList r48, int r49, net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem r50, int r51, kotlin.g.b.g r52) {
        /*
            r27 = this;
            r0 = r51
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r28
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0013
        L_0x0011:
            r5 = r29
        L_0x0013:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0019
            r6 = r2
            goto L_0x001b
        L_0x0019:
            r6 = r30
        L_0x001b:
            r1 = r0 & 8
            r3 = 0
            if (r1 == 0) goto L_0x0026
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r7 = r1
            goto L_0x0028
        L_0x0026:
            r7 = r31
        L_0x0028:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002e
            r8 = r2
            goto L_0x0030
        L_0x002e:
            r8 = r32
        L_0x0030:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0036
            r9 = r2
            goto L_0x0038
        L_0x0036:
            r9 = r33
        L_0x0038:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x003e
            r10 = r2
            goto L_0x0040
        L_0x003e:
            r10 = r34
        L_0x0040:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0046
            r11 = r2
            goto L_0x0048
        L_0x0046:
            r11 = r35
        L_0x0048:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004e
            r12 = r2
            goto L_0x0050
        L_0x004e:
            r12 = r36
        L_0x0050:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0056
            r13 = r2
            goto L_0x0058
        L_0x0056:
            r13 = r37
        L_0x0058:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005e
            r14 = r2
            goto L_0x0060
        L_0x005e:
            r14 = r38
        L_0x0060:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0066
            r15 = r2
            goto L_0x0068
        L_0x0066:
            r15 = r39
        L_0x0068:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x006f
            r16 = r2
            goto L_0x0071
        L_0x006f:
            r16 = r40
        L_0x0071:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007c
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r17 = r1
            goto L_0x007e
        L_0x007c:
            r17 = r41
        L_0x007e:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0085
            r18 = r2
            goto L_0x0087
        L_0x0085:
            r18 = r42
        L_0x0087:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0090
            r19 = r2
            goto L_0x0092
        L_0x0090:
            r19 = r43
        L_0x0092:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009a
            r20 = r2
            goto L_0x009c
        L_0x009a:
            r20 = r44
        L_0x009c:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a4
            r21 = r2
            goto L_0x00a6
        L_0x00a4:
            r21 = r45
        L_0x00a6:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ae
            r22 = 0
            goto L_0x00b0
        L_0x00ae:
            r22 = r46
        L_0x00b0:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b8
            r23 = 0
            goto L_0x00ba
        L_0x00b8:
            r23 = r47
        L_0x00ba:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00c2
            r26 = r2
            goto L_0x00c4
        L_0x00c2:
            r26 = r50
        L_0x00c4:
            r3 = r27
            r24 = r48
            r25 = r49
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.util.ArrayList, java.lang.String, java.lang.String, net.one97.paytm.o2o.movies.common.movies.search.RNR, boolean, boolean, java.util.ArrayList, int, net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem, int, kotlin.g.b.g):void");
    }

    public final Integer getContentId() {
        return this.contentId;
    }

    public final void setContentId(Integer num) {
        this.contentId = num;
    }

    public final String getImgPath() {
        return this.imgPath;
    }

    public final void setImgPath(String str) {
        this.imgPath = str;
    }

    public final String getAppImgPath() {
        return this.appImgPath;
    }

    public final void setAppImgPath(String str) {
        this.appImgPath = str;
    }

    public final String getCvrPath() {
        return this.cvrPath;
    }

    public final void setCvrPath(String str) {
        this.cvrPath = str;
    }

    public final String getAppCvrPath() {
        return this.appCvrPath;
    }

    public final void setAppCvrPath(String str) {
        this.appCvrPath = str;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public final String getEdgeBanner() {
        return this.edgeBanner;
    }

    public final void setEdgeBanner(String str) {
        this.edgeBanner = str;
    }

    public final String getTrailer() {
        return this.trailer;
    }

    public final void setTrailer(String str) {
        this.trailer = str;
    }

    public final String getLang() {
        return this.lang;
    }

    public final void setLang(String str) {
        this.lang = str;
    }

    public final String getCensor() {
        return this.censor;
    }

    public final void setCensor(String str) {
        this.censor = str;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final void setDuration(Integer num) {
        this.duration = num;
    }

    public final ArrayList<String> getGrn() {
        return this.grn;
    }

    public final void setGrn(ArrayList<String> arrayList) {
        this.grn = arrayList;
    }

    public final String getScrnFmt() {
        return this.scrnFmt;
    }

    public final void setScrnFmt(String str) {
        this.scrnFmt = str;
    }

    public final String getSndFmt() {
        return this.sndFmt;
    }

    public final void setSndFmt(String str) {
        this.sndFmt = str;
    }

    public final RNR getRnr() {
        return this.rnr;
    }

    public final void setRnr(RNR rnr2) {
        this.rnr = rnr2;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final void setNew(boolean z) {
        this.isNew = z;
    }

    public final boolean getItemViewed() {
        return this.itemViewed;
    }

    public final void setItemViewed(boolean z) {
        this.itemViewed = z;
    }

    public final ArrayList<GroupFormatObject> getScrnFmtList() {
        return this.scrnFmtList;
    }

    public final void setScrnFmtList(ArrayList<GroupFormatObject> arrayList) {
        this.scrnFmtList = arrayList;
    }

    public final int getTotalSessionCount() {
        return this.totalSessionCount;
    }

    public final void setTotalSessionCount(int i2) {
        this.totalSessionCount = i2;
    }

    public final CJRMetricInfoDataItem getLikeDislikeInfo() {
        return this.likeDislikeInfo;
    }

    public final void setLikeDislikeInfo(CJRMetricInfoDataItem cJRMetricInfoDataItem) {
        this.likeDislikeInfo = cJRMetricInfoDataItem;
    }

    public CJRMovieHomeListItem(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num2, ArrayList<String> arrayList, String str13, String str14, RNR rnr2, boolean z, boolean z2, ArrayList<GroupFormatObject> arrayList2, int i2, CJRMetricInfoDataItem cJRMetricInfoDataItem) {
        this.id = str;
        this.label = str2;
        this.frmtId = str3;
        this.contentId = num;
        this.imgPath = str4;
        this.appImgPath = str5;
        this.cvrPath = str6;
        this.appCvrPath = str7;
        this.thumbnail = str8;
        this.edgeBanner = str9;
        this.trailer = str10;
        this.lang = str11;
        this.censor = str12;
        this.duration = num2;
        this.grn = arrayList;
        this.scrnFmt = str13;
        this.sndFmt = str14;
        this.rnr = rnr2;
        this.isNew = z;
        this.itemViewed = z2;
        this.scrnFmtList = arrayList2;
        this.totalSessionCount = i2;
        this.likeDislikeInfo = cJRMetricInfoDataItem;
    }

    public final boolean equals(Object obj) {
        if (!k.a((Object) obj != null ? obj.getClass() : null, (Object) getClass())) {
            return false;
        }
        if (obj != null) {
            return p.a(this.frmtId, ((CJRMovieHomeListItem) obj).frmtId, false);
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem");
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
