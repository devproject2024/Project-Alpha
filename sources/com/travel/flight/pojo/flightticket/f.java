package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import kotlin.g.b.g;

public final class f implements Serializable {
    @b(a = "distance")
    private a distance;
    private String img;
    private Boolean link;
    private String linkText;
    private String text;

    public f() {
        this((String) null, (a) null, (Boolean) null, (String) null, (String) null, 31, (g) null);
    }

    public f(String str, a aVar, Boolean bool, String str2, String str3) {
        this.img = str;
        this.distance = aVar;
        this.link = bool;
        this.linkText = str2;
        this.text = str3;
    }

    public final String getImg() {
        return this.img;
    }

    public final void setImg(String str) {
        this.img = str;
    }

    public final a getDistance() {
        return this.distance;
    }

    public final void setDistance(a aVar) {
        this.distance = aVar;
    }

    public final Boolean getLink() {
        return this.link;
    }

    public final void setLink(Boolean bool) {
        this.link = bool;
    }

    public final String getLinkText() {
        return this.linkText;
    }

    public final void setLinkText(String str) {
        this.linkText = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f(java.lang.String r5, com.travel.flight.pojo.flightticket.a r6, java.lang.Boolean r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.pojo.flightticket.f.<init>(java.lang.String, com.travel.flight.pojo.flightticket.a, java.lang.Boolean, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }
}
