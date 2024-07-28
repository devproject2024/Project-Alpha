package net.one97.paytm.hotel4.service.model.details;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;

public final class RoomOption {
    private String bedType;
    private Facilities facilities;
    private Images images;
    private String paytmRoomName;
    @b(a = "rooms")
    private List<SubRoomOptions> subRoomOptionses;

    public RoomOption() {
        this((String) null, (String) null, (Images) null, (List) null, (Facilities) null, 31, (g) null);
    }

    public RoomOption(String str, String str2, Images images2, List<SubRoomOptions> list, Facilities facilities2) {
        this.paytmRoomName = str;
        this.bedType = str2;
        this.images = images2;
        this.subRoomOptionses = list;
        this.facilities = facilities2;
    }

    public final String getPaytmRoomName() {
        return this.paytmRoomName;
    }

    public final void setPaytmRoomName(String str) {
        this.paytmRoomName = str;
    }

    public final String getBedType() {
        return this.bedType;
    }

    public final void setBedType(String str) {
        this.bedType = str;
    }

    public final Images getImages() {
        return this.images;
    }

    public final void setImages(Images images2) {
        this.images = images2;
    }

    public final List<SubRoomOptions> getSubRoomOptionses() {
        return this.subRoomOptionses;
    }

    public final void setSubRoomOptionses(List<SubRoomOptions> list) {
        this.subRoomOptionses = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RoomOption(java.lang.String r5, java.lang.String r6, net.one97.paytm.hotel4.service.model.details.Images r7, java.util.List r8, net.one97.paytm.hotel4.service.model.details.Facilities r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.details.RoomOption.<init>(java.lang.String, java.lang.String, net.one97.paytm.hotel4.service.model.details.Images, java.util.List, net.one97.paytm.hotel4.service.model.details.Facilities, int, kotlin.g.b.g):void");
    }

    public final Facilities getFacilities() {
        return this.facilities;
    }

    public final void setFacilities(Facilities facilities2) {
        this.facilities = facilities2;
    }
}
