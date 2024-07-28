package net.one97.paytm.acceptPayment.model.onBoarding;

import kotlin.g.b.k;

public final class DownloadQRModel {
    private final String deepLink;
    private final String displayName;
    private final String qrCodeId;
    private final String qrType;

    public static /* synthetic */ DownloadQRModel copy$default(DownloadQRModel downloadQRModel, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = downloadQRModel.displayName;
        }
        if ((i2 & 2) != 0) {
            str2 = downloadQRModel.qrCodeId;
        }
        if ((i2 & 4) != 0) {
            str3 = downloadQRModel.qrType;
        }
        if ((i2 & 8) != 0) {
            str4 = downloadQRModel.deepLink;
        }
        return downloadQRModel.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.displayName;
    }

    public final String component2() {
        return this.qrCodeId;
    }

    public final String component3() {
        return this.qrType;
    }

    public final String component4() {
        return this.deepLink;
    }

    public final DownloadQRModel copy(String str, String str2, String str3, String str4) {
        k.d(str, "displayName");
        k.d(str2, "qrCodeId");
        k.d(str3, "qrType");
        k.d(str4, "deepLink");
        return new DownloadQRModel(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadQRModel)) {
            return false;
        }
        DownloadQRModel downloadQRModel = (DownloadQRModel) obj;
        return k.a((Object) this.displayName, (Object) downloadQRModel.displayName) && k.a((Object) this.qrCodeId, (Object) downloadQRModel.qrCodeId) && k.a((Object) this.qrType, (Object) downloadQRModel.qrType) && k.a((Object) this.deepLink, (Object) downloadQRModel.deepLink);
    }

    public final int hashCode() {
        String str = this.displayName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.qrCodeId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.qrType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.deepLink;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "DownloadQRModel(displayName=" + this.displayName + ", qrCodeId=" + this.qrCodeId + ", qrType=" + this.qrType + ", deepLink=" + this.deepLink + ")";
    }

    public DownloadQRModel(String str, String str2, String str3, String str4) {
        k.d(str, "displayName");
        k.d(str2, "qrCodeId");
        k.d(str3, "qrType");
        k.d(str4, "deepLink");
        this.displayName = str;
        this.qrCodeId = str2;
        this.qrType = str3;
        this.deepLink = str4;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getQrCodeId() {
        return this.qrCodeId;
    }

    public final String getQrType() {
        return this.qrType;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }
}
