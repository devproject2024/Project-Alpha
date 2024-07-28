package com.travel.flight.pojo.flightticket;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class FlightSellingBundleResponseData extends IJRPaytmDataModel {
    private String category;
    private String final_discount;
    private String final_price;
    private String header;
    private String image_url;
    private boolean isSelected;
    private String mid;
    private String partner_bundle_id;
    private String pid;
    private List<String> product_description;
    private double product_mrp;
    private double product_selling_price;
    private String product_subtitle;
    private String product_title;
    private String title;
    private String trip_summary_icon_url;

    public static /* synthetic */ FlightSellingBundleResponseData copy$default(FlightSellingBundleResponseData flightSellingBundleResponseData, String str, String str2, String str3, String str4, String str5, String str6, String str7, double d2, double d3, String str8, String str9, List list, boolean z, String str10, String str11, String str12, int i2, Object obj) {
        FlightSellingBundleResponseData flightSellingBundleResponseData2 = flightSellingBundleResponseData;
        int i3 = i2;
        return flightSellingBundleResponseData.copy((i3 & 1) != 0 ? flightSellingBundleResponseData2.pid : str, (i3 & 2) != 0 ? flightSellingBundleResponseData2.mid : str2, (i3 & 4) != 0 ? flightSellingBundleResponseData2.header : str3, (i3 & 8) != 0 ? flightSellingBundleResponseData2.category : str4, (i3 & 16) != 0 ? flightSellingBundleResponseData2.image_url : str5, (i3 & 32) != 0 ? flightSellingBundleResponseData2.product_subtitle : str6, (i3 & 64) != 0 ? flightSellingBundleResponseData2.product_title : str7, (i3 & 128) != 0 ? flightSellingBundleResponseData2.product_mrp : d2, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? flightSellingBundleResponseData2.product_selling_price : d3, (i3 & 512) != 0 ? flightSellingBundleResponseData2.final_price : str8, (i3 & TarConstants.EOF_BLOCK) != 0 ? flightSellingBundleResponseData2.final_discount : str9, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? flightSellingBundleResponseData2.product_description : list, (i3 & 4096) != 0 ? flightSellingBundleResponseData2.isSelected : z, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? flightSellingBundleResponseData2.title : str10, (i3 & 16384) != 0 ? flightSellingBundleResponseData2.partner_bundle_id : str11, (i3 & 32768) != 0 ? flightSellingBundleResponseData2.trip_summary_icon_url : str12);
    }

    public final String component1() {
        return this.pid;
    }

    public final String component10() {
        return this.final_price;
    }

    public final String component11() {
        return this.final_discount;
    }

    public final List<String> component12() {
        return this.product_description;
    }

    public final boolean component13() {
        return this.isSelected;
    }

    public final String component14() {
        return this.title;
    }

    public final String component15() {
        return this.partner_bundle_id;
    }

    public final String component16() {
        return this.trip_summary_icon_url;
    }

    public final String component2() {
        return this.mid;
    }

    public final String component3() {
        return this.header;
    }

    public final String component4() {
        return this.category;
    }

    public final String component5() {
        return this.image_url;
    }

    public final String component6() {
        return this.product_subtitle;
    }

    public final String component7() {
        return this.product_title;
    }

    public final double component8() {
        return this.product_mrp;
    }

    public final double component9() {
        return this.product_selling_price;
    }

    public final FlightSellingBundleResponseData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, double d2, double d3, String str8, String str9, List<String> list, boolean z, String str10, String str11, String str12) {
        return new FlightSellingBundleResponseData(str, str2, str3, str4, str5, str6, str7, d2, d3, str8, str9, list, z, str10, str11, str12);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlightSellingBundleResponseData)) {
            return false;
        }
        FlightSellingBundleResponseData flightSellingBundleResponseData = (FlightSellingBundleResponseData) obj;
        return k.a((Object) this.pid, (Object) flightSellingBundleResponseData.pid) && k.a((Object) this.mid, (Object) flightSellingBundleResponseData.mid) && k.a((Object) this.header, (Object) flightSellingBundleResponseData.header) && k.a((Object) this.category, (Object) flightSellingBundleResponseData.category) && k.a((Object) this.image_url, (Object) flightSellingBundleResponseData.image_url) && k.a((Object) this.product_subtitle, (Object) flightSellingBundleResponseData.product_subtitle) && k.a((Object) this.product_title, (Object) flightSellingBundleResponseData.product_title) && Double.compare(this.product_mrp, flightSellingBundleResponseData.product_mrp) == 0 && Double.compare(this.product_selling_price, flightSellingBundleResponseData.product_selling_price) == 0 && k.a((Object) this.final_price, (Object) flightSellingBundleResponseData.final_price) && k.a((Object) this.final_discount, (Object) flightSellingBundleResponseData.final_discount) && k.a((Object) this.product_description, (Object) flightSellingBundleResponseData.product_description) && this.isSelected == flightSellingBundleResponseData.isSelected && k.a((Object) this.title, (Object) flightSellingBundleResponseData.title) && k.a((Object) this.partner_bundle_id, (Object) flightSellingBundleResponseData.partner_bundle_id) && k.a((Object) this.trip_summary_icon_url, (Object) flightSellingBundleResponseData.trip_summary_icon_url);
    }

    public final int hashCode() {
        String str = this.pid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.header;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.category;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.image_url;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.product_subtitle;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.product_title;
        int hashCode7 = str7 != null ? str7.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.product_mrp);
        long doubleToLongBits2 = Double.doubleToLongBits(this.product_selling_price);
        int i3 = (((((hashCode6 + hashCode7) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        String str8 = this.final_price;
        int hashCode8 = (i3 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.final_discount;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        List<String> list = this.product_description;
        int hashCode10 = (hashCode9 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        int i4 = (hashCode10 + (z ? 1 : 0)) * 31;
        String str10 = this.title;
        int hashCode11 = (i4 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.partner_bundle_id;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.trip_summary_icon_url;
        if (str12 != null) {
            i2 = str12.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "FlightSellingBundleResponseData(pid=" + this.pid + ", mid=" + this.mid + ", header=" + this.header + ", category=" + this.category + ", image_url=" + this.image_url + ", product_subtitle=" + this.product_subtitle + ", product_title=" + this.product_title + ", product_mrp=" + this.product_mrp + ", product_selling_price=" + this.product_selling_price + ", final_price=" + this.final_price + ", final_discount=" + this.final_discount + ", product_description=" + this.product_description + ", isSelected=" + this.isSelected + ", title=" + this.title + ", partner_bundle_id=" + this.partner_bundle_id + ", trip_summary_icon_url=" + this.trip_summary_icon_url + ")";
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getMid() {
        return this.mid;
    }

    public final String getPid() {
        return this.pid;
    }

    public final void setHeader(String str) {
        this.header = str;
    }

    public final void setMid(String str) {
        this.mid = str;
    }

    public final void setPid(String str) {
        this.pid = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final void setImage_url(String str) {
        this.image_url = str;
    }

    public final String getProduct_subtitle() {
        return this.product_subtitle;
    }

    public final String getProduct_title() {
        return this.product_title;
    }

    public final void setProduct_subtitle(String str) {
        this.product_subtitle = str;
    }

    public final void setProduct_title(String str) {
        this.product_title = str;
    }

    public final String getFinal_price() {
        return this.final_price;
    }

    public final double getProduct_mrp() {
        return this.product_mrp;
    }

    public final double getProduct_selling_price() {
        return this.product_selling_price;
    }

    public final void setFinal_price(String str) {
        this.final_price = str;
    }

    public final void setProduct_mrp(double d2) {
        this.product_mrp = d2;
    }

    public final void setProduct_selling_price(double d2) {
        this.product_selling_price = d2;
    }

    public final String getFinal_discount() {
        return this.final_discount;
    }

    public final List<String> getProduct_description() {
        return this.product_description;
    }

    public final void setFinal_discount(String str) {
        this.final_discount = str;
    }

    public final void setProduct_description(List<String> list) {
        this.product_description = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FlightSellingBundleResponseData(java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, double r30, double r32, java.lang.String r34, java.lang.String r35, java.util.List r36, boolean r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, int r41, kotlin.g.b.g r42) {
        /*
            r22 = this;
            r0 = r41
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r23
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0013
        L_0x0011:
            r5 = r24
        L_0x0013:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0019
            r6 = r2
            goto L_0x001b
        L_0x0019:
            r6 = r25
        L_0x001b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r26
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r27
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r28
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r29
        L_0x003b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0041
            r15 = r2
            goto L_0x0043
        L_0x0041:
            r15 = r34
        L_0x0043:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004a
            r16 = r2
            goto L_0x004c
        L_0x004a:
            r16 = r35
        L_0x004c:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0053
            r17 = r2
            goto L_0x0055
        L_0x0053:
            r17 = r36
        L_0x0055:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x005d
            r1 = 0
            r18 = 0
            goto L_0x005f
        L_0x005d:
            r18 = r37
        L_0x005f:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0066
            r19 = r2
            goto L_0x0068
        L_0x0066:
            r19 = r38
        L_0x0068:
            r3 = r22
            r11 = r30
            r13 = r32
            r20 = r39
            r21 = r40
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double, double, java.lang.String, java.lang.String, java.util.List, boolean, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public FlightSellingBundleResponseData(String str, String str2, String str3, String str4, String str5, String str6, String str7, double d2, double d3, String str8, String str9, List<String> list, boolean z, String str10, String str11, String str12) {
        this.pid = str;
        this.mid = str2;
        this.header = str3;
        this.category = str4;
        this.image_url = str5;
        this.product_subtitle = str6;
        this.product_title = str7;
        this.product_mrp = d2;
        this.product_selling_price = d3;
        this.final_price = str8;
        this.final_discount = str9;
        this.product_description = list;
        this.isSelected = z;
        this.title = str10;
        this.partner_bundle_id = str11;
        this.trip_summary_icon_url = str12;
    }

    public final String getPartner_bundle_id() {
        return this.partner_bundle_id;
    }

    public final String getTrip_summary_icon_url() {
        return this.trip_summary_icon_url;
    }

    public final void setPartner_bundle_id(String str) {
        this.partner_bundle_id = str;
    }

    public final void setTrip_summary_icon_url(String str) {
        this.trip_summary_icon_url = str;
    }
}
