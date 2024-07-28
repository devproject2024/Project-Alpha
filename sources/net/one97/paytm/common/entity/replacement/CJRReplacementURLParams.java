package net.one97.paytm.common.entity.replacement;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRReplacementURLParams implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private CJRURLParamsBody mData;
    @b(a = "method")
    private String mMethod;
    @b(a = "url")
    private String mUrl;

    public String getUrl() {
        return this.mUrl;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public CJRURLParamsBody getData() {
        return this.mData;
    }
}
