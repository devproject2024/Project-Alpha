package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.CJRError;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCartStatus implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "code")
    private String mCode;
    @b(a = "message")
    private CJRError mMessage;
    @b(a = "result")
    private String mResult;

    public void setmResult(String str) {
        this.mResult = str;
    }

    public String getResult() {
        return this.mResult;
    }

    public CJRError getMessage() {
        return this.mMessage;
    }

    public String getCode() {
        return this.mCode;
    }
}
