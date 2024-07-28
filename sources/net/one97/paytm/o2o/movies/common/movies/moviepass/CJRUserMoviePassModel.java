package net.one97.paytm.o2o.movies.common.movies.moviepass;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRUserMoviePassModel implements IJRDataModel {
    private String cityName;
    private String creationDate;
    private String email;
    private String expirationDate;
    private String heading;
    @b(a = "_id")
    private String id;
    private String moneySaved;
    private String name;
    private String passId;
    private String passImage;
    private String paytmCityId;
    private String paytmOrderId;
    private String phoneNumber;
    private String priceCharged;
    private List<String> promoAppliedOrders;
    private String promoCode;
    private String quotaAlloted;
    private String quotaLabel;
    private String quotaLeft;
    private String savingsLabel;
    private String userId;
    private String valadityLabel;
    private String verticalId;

    public CJRUserMoviePassModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 8388607, (g) null);
    }

    public static /* synthetic */ CJRUserMoviePassModel copy$default(CJRUserMoviePassModel cJRUserMoviePassModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, List list, int i2, Object obj) {
        CJRUserMoviePassModel cJRUserMoviePassModel2 = cJRUserMoviePassModel;
        int i3 = i2;
        return cJRUserMoviePassModel.copy((i3 & 1) != 0 ? cJRUserMoviePassModel2.id : str, (i3 & 2) != 0 ? cJRUserMoviePassModel2.paytmCityId : str2, (i3 & 4) != 0 ? cJRUserMoviePassModel2.verticalId : str3, (i3 & 8) != 0 ? cJRUserMoviePassModel2.userId : str4, (i3 & 16) != 0 ? cJRUserMoviePassModel2.passId : str5, (i3 & 32) != 0 ? cJRUserMoviePassModel2.paytmOrderId : str6, (i3 & 64) != 0 ? cJRUserMoviePassModel2.priceCharged : str7, (i3 & 128) != 0 ? cJRUserMoviePassModel2.moneySaved : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRUserMoviePassModel2.promoCode : str9, (i3 & 512) != 0 ? cJRUserMoviePassModel2.quotaAlloted : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? cJRUserMoviePassModel2.quotaLeft : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRUserMoviePassModel2.creationDate : str12, (i3 & 4096) != 0 ? cJRUserMoviePassModel2.expirationDate : str13, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRUserMoviePassModel2.name : str14, (i3 & 16384) != 0 ? cJRUserMoviePassModel2.email : str15, (i3 & 32768) != 0 ? cJRUserMoviePassModel2.phoneNumber : str16, (i3 & 65536) != 0 ? cJRUserMoviePassModel2.heading : str17, (i3 & 131072) != 0 ? cJRUserMoviePassModel2.cityName : str18, (i3 & 262144) != 0 ? cJRUserMoviePassModel2.quotaLabel : str19, (i3 & 524288) != 0 ? cJRUserMoviePassModel2.valadityLabel : str20, (i3 & 1048576) != 0 ? cJRUserMoviePassModel2.savingsLabel : str21, (i3 & 2097152) != 0 ? cJRUserMoviePassModel2.passImage : str22, (i3 & 4194304) != 0 ? cJRUserMoviePassModel2.promoAppliedOrders : list);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.quotaAlloted;
    }

    public final String component11() {
        return this.quotaLeft;
    }

    public final String component12() {
        return this.creationDate;
    }

    public final String component13() {
        return this.expirationDate;
    }

    public final String component14() {
        return this.name;
    }

    public final String component15() {
        return this.email;
    }

    public final String component16() {
        return this.phoneNumber;
    }

    public final String component17() {
        return this.heading;
    }

    public final String component18() {
        return this.cityName;
    }

    public final String component19() {
        return this.quotaLabel;
    }

    public final String component2() {
        return this.paytmCityId;
    }

    public final String component20() {
        return this.valadityLabel;
    }

    public final String component21() {
        return this.savingsLabel;
    }

    public final String component22() {
        return this.passImage;
    }

    public final List<String> component23() {
        return this.promoAppliedOrders;
    }

    public final String component3() {
        return this.verticalId;
    }

    public final String component4() {
        return this.userId;
    }

    public final String component5() {
        return this.passId;
    }

    public final String component6() {
        return this.paytmOrderId;
    }

    public final String component7() {
        return this.priceCharged;
    }

    public final String component8() {
        return this.moneySaved;
    }

    public final String component9() {
        return this.promoCode;
    }

    public final CJRUserMoviePassModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, List<String> list) {
        return new CJRUserMoviePassModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRUserMoviePassModel)) {
            return false;
        }
        CJRUserMoviePassModel cJRUserMoviePassModel = (CJRUserMoviePassModel) obj;
        return k.a((Object) this.id, (Object) cJRUserMoviePassModel.id) && k.a((Object) this.paytmCityId, (Object) cJRUserMoviePassModel.paytmCityId) && k.a((Object) this.verticalId, (Object) cJRUserMoviePassModel.verticalId) && k.a((Object) this.userId, (Object) cJRUserMoviePassModel.userId) && k.a((Object) this.passId, (Object) cJRUserMoviePassModel.passId) && k.a((Object) this.paytmOrderId, (Object) cJRUserMoviePassModel.paytmOrderId) && k.a((Object) this.priceCharged, (Object) cJRUserMoviePassModel.priceCharged) && k.a((Object) this.moneySaved, (Object) cJRUserMoviePassModel.moneySaved) && k.a((Object) this.promoCode, (Object) cJRUserMoviePassModel.promoCode) && k.a((Object) this.quotaAlloted, (Object) cJRUserMoviePassModel.quotaAlloted) && k.a((Object) this.quotaLeft, (Object) cJRUserMoviePassModel.quotaLeft) && k.a((Object) this.creationDate, (Object) cJRUserMoviePassModel.creationDate) && k.a((Object) this.expirationDate, (Object) cJRUserMoviePassModel.expirationDate) && k.a((Object) this.name, (Object) cJRUserMoviePassModel.name) && k.a((Object) this.email, (Object) cJRUserMoviePassModel.email) && k.a((Object) this.phoneNumber, (Object) cJRUserMoviePassModel.phoneNumber) && k.a((Object) this.heading, (Object) cJRUserMoviePassModel.heading) && k.a((Object) this.cityName, (Object) cJRUserMoviePassModel.cityName) && k.a((Object) this.quotaLabel, (Object) cJRUserMoviePassModel.quotaLabel) && k.a((Object) this.valadityLabel, (Object) cJRUserMoviePassModel.valadityLabel) && k.a((Object) this.savingsLabel, (Object) cJRUserMoviePassModel.savingsLabel) && k.a((Object) this.passImage, (Object) cJRUserMoviePassModel.passImage) && k.a((Object) this.promoAppliedOrders, (Object) cJRUserMoviePassModel.promoAppliedOrders);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.paytmCityId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.verticalId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.userId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.passId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.paytmOrderId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.priceCharged;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.moneySaved;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.promoCode;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.quotaAlloted;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.quotaLeft;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.creationDate;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.expirationDate;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.name;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.email;
        int hashCode15 = (hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.phoneNumber;
        int hashCode16 = (hashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.heading;
        int hashCode17 = (hashCode16 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.cityName;
        int hashCode18 = (hashCode17 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.quotaLabel;
        int hashCode19 = (hashCode18 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.valadityLabel;
        int hashCode20 = (hashCode19 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.savingsLabel;
        int hashCode21 = (hashCode20 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.passImage;
        int hashCode22 = (hashCode21 + (str22 != null ? str22.hashCode() : 0)) * 31;
        List<String> list = this.promoAppliedOrders;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode22 + i2;
    }

    public final String toString() {
        return "CJRUserMoviePassModel(id=" + this.id + ", paytmCityId=" + this.paytmCityId + ", verticalId=" + this.verticalId + ", userId=" + this.userId + ", passId=" + this.passId + ", paytmOrderId=" + this.paytmOrderId + ", priceCharged=" + this.priceCharged + ", moneySaved=" + this.moneySaved + ", promoCode=" + this.promoCode + ", quotaAlloted=" + this.quotaAlloted + ", quotaLeft=" + this.quotaLeft + ", creationDate=" + this.creationDate + ", expirationDate=" + this.expirationDate + ", name=" + this.name + ", email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", heading=" + this.heading + ", cityName=" + this.cityName + ", quotaLabel=" + this.quotaLabel + ", valadityLabel=" + this.valadityLabel + ", savingsLabel=" + this.savingsLabel + ", passImage=" + this.passImage + ", promoAppliedOrders=" + this.promoAppliedOrders + ")";
    }

    public CJRUserMoviePassModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, List<String> list) {
        this.id = str;
        this.paytmCityId = str2;
        this.verticalId = str3;
        this.userId = str4;
        this.passId = str5;
        this.paytmOrderId = str6;
        this.priceCharged = str7;
        this.moneySaved = str8;
        this.promoCode = str9;
        this.quotaAlloted = str10;
        this.quotaLeft = str11;
        this.creationDate = str12;
        this.expirationDate = str13;
        this.name = str14;
        this.email = str15;
        this.phoneNumber = str16;
        this.heading = str17;
        this.cityName = str18;
        this.quotaLabel = str19;
        this.valadityLabel = str20;
        this.savingsLabel = str21;
        this.passImage = str22;
        this.promoAppliedOrders = list;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getPaytmCityId() {
        return this.paytmCityId;
    }

    public final void setPaytmCityId(String str) {
        this.paytmCityId = str;
    }

    public final String getVerticalId() {
        return this.verticalId;
    }

    public final void setVerticalId(String str) {
        this.verticalId = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getPassId() {
        return this.passId;
    }

    public final void setPassId(String str) {
        this.passId = str;
    }

    public final String getPaytmOrderId() {
        return this.paytmOrderId;
    }

    public final void setPaytmOrderId(String str) {
        this.paytmOrderId = str;
    }

    public final String getPriceCharged() {
        return this.priceCharged;
    }

    public final void setPriceCharged(String str) {
        this.priceCharged = str;
    }

    public final String getMoneySaved() {
        return this.moneySaved;
    }

    public final void setMoneySaved(String str) {
        this.moneySaved = str;
    }

    public final String getPromoCode() {
        return this.promoCode;
    }

    public final void setPromoCode(String str) {
        this.promoCode = str;
    }

    public final String getQuotaAlloted() {
        return this.quotaAlloted;
    }

    public final void setQuotaAlloted(String str) {
        this.quotaAlloted = str;
    }

    public final String getQuotaLeft() {
        return this.quotaLeft;
    }

    public final void setQuotaLeft(String str) {
        this.quotaLeft = str;
    }

    public final String getCreationDate() {
        return this.creationDate;
    }

    public final void setCreationDate(String str) {
        this.creationDate = str;
    }

    public final String getExpirationDate() {
        return this.expirationDate;
    }

    public final void setExpirationDate(String str) {
        this.expirationDate = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final void setHeading(String str) {
        this.heading = str;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final void setCityName(String str) {
        this.cityName = str;
    }

    public final String getQuotaLabel() {
        return this.quotaLabel;
    }

    public final void setQuotaLabel(String str) {
        this.quotaLabel = str;
    }

    public final String getValadityLabel() {
        return this.valadityLabel;
    }

    public final void setValadityLabel(String str) {
        this.valadityLabel = str;
    }

    public final String getSavingsLabel() {
        return this.savingsLabel;
    }

    public final void setSavingsLabel(String str) {
        this.savingsLabel = str;
    }

    public final String getPassImage() {
        return this.passImage;
    }

    public final void setPassImage(String str) {
        this.passImage = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRUserMoviePassModel(java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.util.List r47, int r48, kotlin.g.b.g r49) {
        /*
            r24 = this;
            r0 = r48
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r25
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r26
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r27
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r28
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r29
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r30
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r31
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r32
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r33
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r34
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r35
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r36
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r37
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r38
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r39
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r40
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r41
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r42
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r43
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r44
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r45
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r46
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r23
            if (r0 == 0) goto L_0x00d0
            r0 = 0
            goto L_0x00d2
        L_0x00d0:
            r0 = r47
        L_0x00d2:
            r25 = r24
            r26 = r1
            r27 = r3
            r28 = r4
            r29 = r5
            r30 = r6
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r10
            r35 = r11
            r36 = r12
            r37 = r13
            r38 = r14
            r39 = r15
            r40 = r2
            r41 = r16
            r42 = r17
            r43 = r18
            r44 = r19
            r45 = r20
            r46 = r21
            r47 = r22
            r48 = r0
            r25.<init>(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.g.b.g):void");
    }

    public final List<String> getPromoAppliedOrders() {
        return this.promoAppliedOrders;
    }

    public final void setPromoAppliedOrders(List<String> list) {
        this.promoAppliedOrders = list;
    }

    public final String getValidity() {
        Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(this.expirationDate);
        k.a((Object) parse, "parser.parse(expirationDate)");
        String format = new SimpleDateFormat("dd-MMM").format(parse);
        k.a((Object) format, "parser1.format(expiryDate)");
        return format;
    }

    public final int daysBetween(Date date, Date date2) {
        k.c(date, "from");
        k.c(date2, "to");
        if (date2.before(date)) {
            return -1;
        }
        return ((int) TimeUnit.DAYS.convert(date2.getTime() - date.getTime(), TimeUnit.MILLISECONDS)) + 1;
    }
}
