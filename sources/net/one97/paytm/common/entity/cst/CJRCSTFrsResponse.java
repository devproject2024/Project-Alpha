package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.cst.cstWidget.CJRCSTWidgetResponse;

public class CJRCSTFrsResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "level")
    private String level;
    @b(a = "response")
    private CJRCSTWidgetResponse response;
    @b(a = "type")
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public CJRCSTWidgetResponse getResponse() {
        return this.response;
    }

    public void setResponse(CJRCSTWidgetResponse cJRCSTWidgetResponse) {
        this.response = cJRCSTWidgetResponse;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String str) {
        this.level = str;
    }
}
