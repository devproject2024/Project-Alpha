package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class SRPDataItem extends IJRPaytmDataModel {
    @b(a = "_id")
    private final String Id;
    private final Amenities amenities;
    private final Extras extras;
    private transient boolean isSelcted;
    private final double latitude;
    private final String locality;
    private final double longitude;
    private final String name;
    @b(a = "paytm_id")
    private final String paytmId;
    @b(a = "paytm_images")
    private final PaytmImages paytmImages;
    private final PriceData priceData;
    private final List<String> promos;
    @b(a = "property_tag")
    private String propertyTag;
    private final Ratings ratings;

    public final double getLatitude() {
        return this.latitude;
    }

    public final String getLocality() {
        return this.locality;
    }

    public final String getPaytmId() {
        return this.paytmId;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final PaytmImages getPaytmImages() {
        return this.paytmImages;
    }

    public final Ratings getRatings() {
        return this.ratings;
    }

    public final PriceData getPriceData() {
        return this.priceData;
    }

    public final String getName() {
        return this.name;
    }

    public final String getId() {
        return this.Id;
    }

    public final Amenities getAmenities() {
        return this.amenities;
    }

    public final List<String> getPromos() {
        return this.promos;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SRPDataItem(double r22, java.lang.String r24, java.lang.String r25, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extras r26, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.PaytmImages r27, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Ratings r28, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.PriceData r29, java.lang.String r30, java.lang.String r31, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Amenities r32, java.util.List r33, double r34, boolean r36, java.lang.String r37, int r38, kotlin.g.b.g r39) {
        /*
            r21 = this;
            r0 = r38
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r5 = r2
            goto L_0x000c
        L_0x000a:
            r5 = r22
        L_0x000c:
            r1 = r0 & 2
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x0014
            r7 = r4
            goto L_0x0016
        L_0x0014:
            r7 = r24
        L_0x0016:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x001c
            r8 = r4
            goto L_0x001e
        L_0x001c:
            r8 = r25
        L_0x001e:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0024
            r13 = r4
            goto L_0x0026
        L_0x0024:
            r13 = r30
        L_0x0026:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x002c
            r14 = r4
            goto L_0x002e
        L_0x002c:
            r14 = r31
        L_0x002e:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0035
            r17 = r2
            goto L_0x0037
        L_0x0035:
            r17 = r34
        L_0x0037:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x003f
            r0 = 0
            r19 = 0
            goto L_0x0041
        L_0x003f:
            r19 = r36
        L_0x0041:
            r4 = r21
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r15 = r32
            r16 = r33
            r20 = r37
            r4.<init>(r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem.<init>(double, java.lang.String, java.lang.String, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extras, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.PaytmImages, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Ratings, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.PriceData, java.lang.String, java.lang.String, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Amenities, java.util.List, double, boolean, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final boolean isSelcted() {
        return this.isSelcted;
    }

    public final void setSelcted(boolean z) {
        this.isSelcted = z;
    }

    public final String getPropertyTag() {
        return this.propertyTag;
    }

    public final void setPropertyTag(String str) {
        this.propertyTag = str;
    }

    public SRPDataItem(double d2, String str, String str2, Extras extras2, PaytmImages paytmImages2, Ratings ratings2, PriceData priceData2, String str3, String str4, Amenities amenities2, List<String> list, double d3, boolean z, String str5) {
        Extras extras3 = extras2;
        PaytmImages paytmImages3 = paytmImages2;
        Ratings ratings3 = ratings2;
        PriceData priceData3 = priceData2;
        String str6 = str3;
        String str7 = str4;
        k.c(str, "locality");
        k.c(str2, "paytmId");
        k.c(extras3, "extras");
        k.c(paytmImages3, "paytmImages");
        k.c(ratings3, "ratings");
        k.c(priceData3, "priceData");
        k.c(str6, "name");
        k.c(str7, "Id");
        this.latitude = d2;
        this.locality = str;
        this.paytmId = str2;
        this.extras = extras3;
        this.paytmImages = paytmImages3;
        this.ratings = ratings3;
        this.priceData = priceData3;
        this.name = str6;
        this.Id = str7;
        this.amenities = amenities2;
        this.promos = list;
        this.longitude = d3;
        this.isSelcted = z;
        this.propertyTag = str5;
    }

    public final List<String> getAmenitiesList() {
        ArrayList arrayList = new ArrayList();
        Amenities amenities2 = this.amenities;
        if (amenities2 != null) {
            if (amenities2.getBasic() != null && this.amenities.getBasic().size() > 0) {
                for (AmenitiesItemDetail next : this.amenities.getBasic()) {
                    if (next.getFacilityImageUrl() != null) {
                        arrayList.add(next.getFacilityImageUrl());
                    }
                }
            }
            if (this.amenities.getMore() != null && this.amenities.getMore().size() > 0) {
                for (AmenitiesItemDetail next2 : this.amenities.getMore()) {
                    if (next2.getFacilityImageUrl() != null) {
                        arrayList.add(next2.getFacilityImageUrl());
                    }
                }
            }
        }
        return arrayList;
    }
}
