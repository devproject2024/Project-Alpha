package net.one97.paytm.common;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRawDataModel extends IJRPaytmDataModel implements IJRDataModel {
    private Map<String, String> headers;
    protected String rawContent;

    public String getRawContent() {
        return this.rawContent;
    }

    public void setRawContent(String str) {
        this.rawContent = str;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }
}
