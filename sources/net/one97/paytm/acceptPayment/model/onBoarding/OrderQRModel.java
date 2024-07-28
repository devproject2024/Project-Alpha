package net.one97.paytm.acceptPayment.model.onBoarding;

import kotlin.g.b.k;

public final class OrderQRModel {
    private final String link;
    private final String qrCodeId;

    public static /* synthetic */ OrderQRModel copy$default(OrderQRModel orderQRModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = orderQRModel.link;
        }
        if ((i2 & 2) != 0) {
            str2 = orderQRModel.qrCodeId;
        }
        return orderQRModel.copy(str, str2);
    }

    public final String component1() {
        return this.link;
    }

    public final String component2() {
        return this.qrCodeId;
    }

    public final OrderQRModel copy(String str, String str2) {
        k.d(str, "link");
        k.d(str2, "qrCodeId");
        return new OrderQRModel(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderQRModel)) {
            return false;
        }
        OrderQRModel orderQRModel = (OrderQRModel) obj;
        return k.a((Object) this.link, (Object) orderQRModel.link) && k.a((Object) this.qrCodeId, (Object) orderQRModel.qrCodeId);
    }

    public final int hashCode() {
        String str = this.link;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.qrCodeId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "OrderQRModel(link=" + this.link + ", qrCodeId=" + this.qrCodeId + ")";
    }

    public OrderQRModel(String str, String str2) {
        k.d(str, "link");
        k.d(str2, "qrCodeId");
        this.link = str;
        this.qrCodeId = str2;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getQrCodeId() {
        return this.qrCodeId;
    }
}
