package net.one97.paytm.hotel4.service.model.details;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;

public final class Data {
    private Address address;
    private String description;
    private Facilities facilities;
    private HotelPolicy hotelPolicy;
    @b(a = "_id")
    private String id;
    private String name;
    @b(a = "paytm_images")
    private final PaytmImages paytmImages;
    private List<RoomOption> roomOptions;
    private boolean showAddGstin;
    private TnC tnc;

    public Data() {
        this((String) null, (String) null, (PaytmImages) null, (Address) null, (Facilities) null, (String) null, (HotelPolicy) null, (List) null, (TnC) null, false, 1023, (g) null);
    }

    public Data(String str, String str2, PaytmImages paytmImages2, Address address2, Facilities facilities2, String str3, HotelPolicy hotelPolicy2, List<RoomOption> list, TnC tnC, boolean z) {
        this.id = str;
        this.name = str2;
        this.paytmImages = paytmImages2;
        this.address = address2;
        this.facilities = facilities2;
        this.description = str3;
        this.hotelPolicy = hotelPolicy2;
        this.roomOptions = list;
        this.tnc = tnC;
        this.showAddGstin = z;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final PaytmImages getPaytmImages() {
        return this.paytmImages;
    }

    public final Address getAddress() {
        return this.address;
    }

    public final void setAddress(Address address2) {
        this.address = address2;
    }

    public final Facilities getFacilities() {
        return this.facilities;
    }

    public final void setFacilities(Facilities facilities2) {
        this.facilities = facilities2;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final HotelPolicy getHotelPolicy() {
        return this.hotelPolicy;
    }

    public final void setHotelPolicy(HotelPolicy hotelPolicy2) {
        this.hotelPolicy = hotelPolicy2;
    }

    public final List<RoomOption> getRoomOptions() {
        return this.roomOptions;
    }

    public final void setRoomOptions(List<RoomOption> list) {
        this.roomOptions = list;
    }

    public final TnC getTnc() {
        return this.tnc;
    }

    public final void setTnc(TnC tnC) {
        this.tnc = tnC;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Data(java.lang.String r12, java.lang.String r13, net.one97.paytm.hotel4.service.model.details.PaytmImages r14, net.one97.paytm.hotel4.service.model.details.Address r15, net.one97.paytm.hotel4.service.model.details.Facilities r16, java.lang.String r17, net.one97.paytm.hotel4.service.model.details.HotelPolicy r18, java.util.List r19, net.one97.paytm.hotel4.service.model.details.TnC r20, boolean r21, int r22, kotlin.g.b.g r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r2
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r2 = r20
        L_0x0046:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            r0 = 0
            goto L_0x004e
        L_0x004c:
            r0 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r2
            r22 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.details.Data.<init>(java.lang.String, java.lang.String, net.one97.paytm.hotel4.service.model.details.PaytmImages, net.one97.paytm.hotel4.service.model.details.Address, net.one97.paytm.hotel4.service.model.details.Facilities, java.lang.String, net.one97.paytm.hotel4.service.model.details.HotelPolicy, java.util.List, net.one97.paytm.hotel4.service.model.details.TnC, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean getShowAddGstin() {
        return this.showAddGstin;
    }

    public final void setShowAddGstin(boolean z) {
        this.showAddGstin = z;
    }
}
