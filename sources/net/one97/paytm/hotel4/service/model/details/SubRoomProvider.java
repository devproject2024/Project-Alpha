package net.one97.paytm.hotel4.service.model.details;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.o;
import java.util.List;
import kotlin.g.b.g;

public final class SubRoomProvider {
    @b(a = "book_params")
    private o bookParams;
    private List<String> includes;
    private String name;
    private Otas ota;
    private PriceData priceData;

    public SubRoomProvider() {
        this((String) null, (List) null, (PriceData) null, (Otas) null, (o) null, 31, (g) null);
    }

    public SubRoomProvider(String str, List<String> list, PriceData priceData2, Otas otas, o oVar) {
        this.name = str;
        this.includes = list;
        this.priceData = priceData2;
        this.ota = otas;
        this.bookParams = oVar;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final List<String> getIncludes() {
        return this.includes;
    }

    public final void setIncludes(List<String> list) {
        this.includes = list;
    }

    public final PriceData getPriceData() {
        return this.priceData;
    }

    public final void setPriceData(PriceData priceData2) {
        this.priceData = priceData2;
    }

    public final Otas getOta() {
        return this.ota;
    }

    public final void setOta(Otas otas) {
        this.ota = otas;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubRoomProvider(java.lang.String r5, java.util.List r6, net.one97.paytm.hotel4.service.model.details.PriceData r7, net.one97.paytm.hotel4.service.model.details.Otas r8, com.google.gsonhtcfix.o r9, int r10, kotlin.g.b.g r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.details.SubRoomProvider.<init>(java.lang.String, java.util.List, net.one97.paytm.hotel4.service.model.details.PriceData, net.one97.paytm.hotel4.service.model.details.Otas, com.google.gsonhtcfix.o, int, kotlin.g.b.g):void");
    }

    public final o getBookParams() {
        return this.bookParams;
    }

    public final void setBookParams(o oVar) {
        this.bookParams = oVar;
    }
}
