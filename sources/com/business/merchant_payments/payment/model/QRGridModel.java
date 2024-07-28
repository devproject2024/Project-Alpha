package com.business.merchant_payments.payment.model;

import java.util.List;
import kotlin.g.b.k;
import org.greenrobot.eventbus.c;

public final class QRGridModel {
    public final List<GridItem> items;

    public static /* synthetic */ QRGridModel copy$default(QRGridModel qRGridModel, List<GridItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = qRGridModel.items;
        }
        return qRGridModel.copy(list);
    }

    public final List<GridItem> component1() {
        return this.items;
    }

    public final QRGridModel copy(List<GridItem> list) {
        k.d(list, "items");
        return new QRGridModel(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof QRGridModel) && k.a((Object) this.items, (Object) ((QRGridModel) obj).items);
        }
        return true;
    }

    public final int hashCode() {
        List<GridItem> list = this.items;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "QRGridModel(items=" + this.items + ")";
    }

    public QRGridModel(List<GridItem> list) {
        k.d(list, "items");
        this.items = list;
    }

    public final List<GridItem> getItems() {
        return this.items;
    }

    public final void openDeeplink(GridItem gridItem) {
        k.d(gridItem, "item");
        String deeplink = gridItem.getDeeplink();
        if (!(deeplink == null || deeplink.length() == 0)) {
            c.a().c(new QRGridItemClickEvent(gridItem.getDeeplink()));
        }
    }
}
