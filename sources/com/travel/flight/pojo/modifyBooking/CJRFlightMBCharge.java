package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;

public final class CJRFlightMBCharge extends IJRPaytmDataModel {
    @b(a = "adult")
    private CJRFlightMBTravelerCharges adult;
    @b(a = "child")
    private CJRFlightMBTravelerCharges child;
    @b(a = "infant")
    private CJRFlightMBTravelerCharges infant;
    @b(a = "info")
    private List<CJRFlightMBImgNote> info;
    @b(a = "notes")
    private List<String> notes;
    @b(a = "title")
    private String title;

    public CJRFlightMBCharge() {
        this((String) null, (CJRFlightMBTravelerCharges) null, (CJRFlightMBTravelerCharges) null, (CJRFlightMBTravelerCharges) null, (List) null, (List) null, 63, (g) null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final CJRFlightMBTravelerCharges getAdult() {
        return this.adult;
    }

    public final void setAdult(CJRFlightMBTravelerCharges cJRFlightMBTravelerCharges) {
        this.adult = cJRFlightMBTravelerCharges;
    }

    public final CJRFlightMBTravelerCharges getChild() {
        return this.child;
    }

    public final void setChild(CJRFlightMBTravelerCharges cJRFlightMBTravelerCharges) {
        this.child = cJRFlightMBTravelerCharges;
    }

    public final CJRFlightMBTravelerCharges getInfant() {
        return this.infant;
    }

    public final void setInfant(CJRFlightMBTravelerCharges cJRFlightMBTravelerCharges) {
        this.infant = cJRFlightMBTravelerCharges;
    }

    public final List<CJRFlightMBImgNote> getInfo() {
        return this.info;
    }

    public final void setInfo(List<CJRFlightMBImgNote> list) {
        this.info = list;
    }

    public CJRFlightMBCharge(String str, CJRFlightMBTravelerCharges cJRFlightMBTravelerCharges, CJRFlightMBTravelerCharges cJRFlightMBTravelerCharges2, CJRFlightMBTravelerCharges cJRFlightMBTravelerCharges3, List<CJRFlightMBImgNote> list, List<String> list2) {
        this.title = str;
        this.adult = cJRFlightMBTravelerCharges;
        this.child = cJRFlightMBTravelerCharges2;
        this.infant = cJRFlightMBTravelerCharges3;
        this.info = list;
        this.notes = list2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRFlightMBCharge(java.lang.String r6, com.travel.flight.pojo.modifyBooking.CJRFlightMBTravelerCharges r7, com.travel.flight.pojo.modifyBooking.CJRFlightMBTravelerCharges r8, com.travel.flight.pojo.modifyBooking.CJRFlightMBTravelerCharges r9, java.util.List r10, java.util.List r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.pojo.modifyBooking.CJRFlightMBCharge.<init>(java.lang.String, com.travel.flight.pojo.modifyBooking.CJRFlightMBTravelerCharges, com.travel.flight.pojo.modifyBooking.CJRFlightMBTravelerCharges, com.travel.flight.pojo.modifyBooking.CJRFlightMBTravelerCharges, java.util.List, java.util.List, int, kotlin.g.b.g):void");
    }

    public final List<String> getNotes() {
        return this.notes;
    }

    public final void setNotes(List<String> list) {
        this.notes = list;
    }
}
