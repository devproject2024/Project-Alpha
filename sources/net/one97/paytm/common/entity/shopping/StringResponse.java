package net.one97.paytm.common.entity.shopping;

import net.one97.paytm.common.entity.CJRDataModelItem;

public class StringResponse extends CJRDataModelItem {
    private String response;

    public String getName() {
        return StringResponse.class.getName();
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String str) {
        this.response = str;
    }
}
