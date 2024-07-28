package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRPostcardCreateEvent extends CJRWalletDataModel implements IJRDataModel {
    public static final String STATUS_SUCCESS = "EMC_0000";
    @b(a = "lifafaKey")
    private String lifafaKey;
    @b(a = "lifafaId")
    private long mLifafaId;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;
    @b(a = "qrCodeId")
    private String qrCodeId;

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public void setmStatusMessage(String str) {
        this.mStatusMessage = str;
    }

    public long getLifafaId() {
        return this.mLifafaId;
    }

    public void setLifafaId(long j) {
        this.mLifafaId = j;
    }

    public String getQrCodeId() {
        return this.qrCodeId;
    }

    public void setQrCodeId(String str) {
        this.qrCodeId = str;
    }

    public String getLifafaKey() {
        return this.lifafaKey;
    }

    public void setLifafaKey(String str) {
        this.lifafaKey = str;
    }
}
