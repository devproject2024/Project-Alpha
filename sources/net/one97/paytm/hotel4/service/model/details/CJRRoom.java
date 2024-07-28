package net.one97.paytm.hotel4.service.model.details;

import com.google.gson.a.c;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRRoom extends IJRPaytmDataModel {
    @c(a = "num_of_adults")
    private int adultCount;
    @c(a = "child_ages")
    private ArrayList<Integer> childrenAges;
    @c(a = "num_of_children")
    private int childrenCount;
    private int guestCount;
    private transient String roomDetails;
    private transient String roomPrice;
    private transient String roomTitle;

    public CJRRoom() {
        this(0, 0, 0, (ArrayList) null, (String) null, (String) null, (String) null, 127, (g) null);
    }

    public final int getAdultCount() {
        return this.adultCount;
    }

    public final void setAdultCount(int i2) {
        this.adultCount = i2;
    }

    public final int getChildrenCount() {
        return this.childrenCount;
    }

    public final void setChildrenCount(int i2) {
        this.childrenCount = i2;
    }

    public final int getGuestCount() {
        return this.guestCount;
    }

    public final void setGuestCount(int i2) {
        this.guestCount = i2;
    }

    public final ArrayList<Integer> getChildrenAges() {
        return this.childrenAges;
    }

    public final void setChildrenAges(ArrayList<Integer> arrayList) {
        this.childrenAges = arrayList;
    }

    public final String getRoomTitle() {
        return this.roomTitle;
    }

    public final void setRoomTitle(String str) {
        this.roomTitle = str;
    }

    public final String getRoomPrice() {
        return this.roomPrice;
    }

    public final void setRoomPrice(String str) {
        this.roomPrice = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRRoom(int r6, int r7, int r8, java.util.ArrayList r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, kotlin.g.b.g r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L_0x0007
            r14 = 0
            goto L_0x0008
        L_0x0007:
            r14 = r6
        L_0x0008:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x000e
            r1 = 0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r8
        L_0x0015:
            r6 = r13 & 8
            r7 = 0
            if (r6 == 0) goto L_0x001c
            r2 = r7
            goto L_0x001d
        L_0x001c:
            r2 = r9
        L_0x001d:
            r6 = r13 & 16
            if (r6 == 0) goto L_0x0023
            r3 = r7
            goto L_0x0024
        L_0x0023:
            r3 = r10
        L_0x0024:
            r6 = r13 & 32
            if (r6 == 0) goto L_0x002a
            r4 = r7
            goto L_0x002b
        L_0x002a:
            r4 = r11
        L_0x002b:
            r6 = r13 & 64
            if (r6 == 0) goto L_0x0031
            r13 = r7
            goto L_0x0032
        L_0x0031:
            r13 = r12
        L_0x0032:
            r6 = r5
            r7 = r14
            r8 = r1
            r9 = r0
            r10 = r2
            r11 = r3
            r12 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.details.CJRRoom.<init>(int, int, int, java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getRoomDetails() {
        return this.roomDetails;
    }

    public final void setRoomDetails(String str) {
        this.roomDetails = str;
    }

    public CJRRoom(int i2, int i3, int i4, ArrayList<Integer> arrayList, String str, String str2, String str3) {
        this.adultCount = i2;
        this.childrenCount = i3;
        this.guestCount = i4;
        this.childrenAges = arrayList;
        this.roomTitle = str;
        this.roomPrice = str2;
        this.roomDetails = str3;
    }

    public final String toString() {
        String a2 = new f().a((Object) this);
        k.a((Object) a2, "Gson().toJson(this)");
        return a2;
    }
}
