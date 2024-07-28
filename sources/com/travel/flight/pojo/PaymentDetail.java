package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;

public final class PaymentDetail extends IJRPaytmDataModel {
    @a
    @b(a = "header")
    private Header header;
    @a
    @b(a = "isBold")
    private boolean isBold;
    private transient boolean isHeaderValid;
    @a
    @b(a = "items")
    private List<Item> items;
    private transient boolean itemsExpanded;

    public PaymentDetail() {
        this(false, (Header) null, (List) null, false, false, 31, (g) null);
    }

    public final boolean isBold() {
        return this.isBold;
    }

    public final void setBold(boolean z) {
        this.isBold = z;
    }

    public final Header getHeader() {
        return this.header;
    }

    public final void setHeader(Header header2) {
        this.header = header2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentDetail(boolean r4, com.travel.flight.pojo.Header r5, java.util.List r6, boolean r7, boolean r8, int r9, kotlin.g.b.g r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = 0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000d
            r5 = 0
        L_0x000d:
            r1 = r5
            r4 = r9 & 4
            if (r4 == 0) goto L_0x001a
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r0)
            r6 = r4
            java.util.List r6 = (java.util.List) r6
        L_0x001a:
            r2 = r6
            r4 = r9 & 8
            if (r4 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r0 = r7
        L_0x0021:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0028
            r8 = 1
            r9 = 1
            goto L_0x0029
        L_0x0028:
            r9 = r8
        L_0x0029:
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.pojo.PaymentDetail.<init>(boolean, com.travel.flight.pojo.Header, java.util.List, boolean, boolean, int, kotlin.g.b.g):void");
    }

    public final List<Item> getItems() {
        return this.items;
    }

    public final void setItems(List<Item> list) {
        this.items = list;
    }

    public final boolean getItemsExpanded() {
        return this.itemsExpanded;
    }

    public final void setItemsExpanded(boolean z) {
        this.itemsExpanded = z;
    }

    public PaymentDetail(boolean z, Header header2, List<Item> list, boolean z2, boolean z3) {
        this.isBold = z;
        this.header = header2;
        this.items = list;
        this.itemsExpanded = z2;
        this.isHeaderValid = z3;
    }

    public final boolean isHeaderValid() {
        return this.isHeaderValid;
    }

    public final void setHeaderValid(boolean z) {
        this.isHeaderValid = z;
    }

    public final boolean haveValidHeader() {
        if (this.header == null) {
            this.isHeaderValid = false;
        }
        Header header2 = this.header;
        if (header2 != null) {
            CharSequence title = header2.getTitle();
            if (title == null || title.length() == 0) {
                this.isHeaderValid = false;
            }
        }
        return this.isHeaderValid;
    }

    public final void updateItems() {
        List<Item> list = this.items;
        if (list != null) {
            for (Item bold : list) {
                bold.setBold(this.isBold);
            }
        }
    }
}
