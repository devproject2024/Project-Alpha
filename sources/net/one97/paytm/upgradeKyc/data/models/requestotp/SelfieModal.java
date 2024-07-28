package net.one97.paytm.upgradeKyc.data.models.requestotp;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class SelfieModal extends IJRPaytmDataModel {
    @a
    @b(a = "error")
    private String error;
    @a
    @b(a = "errorDescription")
    private String errorDescription;
    @a
    @b(a = "keys")
    private List<String> keys;

    public final List<String> getKeys() {
        return this.keys;
    }

    public final void setKeys(List<String> list) {
        this.keys = list;
    }

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final String getErrorDescription() {
        return this.errorDescription;
    }

    public final void setErrorDescription(String str) {
        this.errorDescription = str;
    }

    public final String toString() {
        return "error==" + this.error + "desccc==" + this.errorDescription + "keyy==" + this.keys;
    }
}
