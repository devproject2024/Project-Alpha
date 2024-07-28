package net.one97.paytm.common.entity.auth;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class TncData implements IJRDataModel {
    @b(a = "code")
    private String code;
    @b(a = "description")
    private String description;
    @b(a = "status")
    private String status;
    @b(a = "url")
    private String url;
    @b(a = "version")
    private int version;

    public String getDescription() {
        return this.description;
    }

    public String getCode() {
        return this.code;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersion() {
        return this.version;
    }

    public String getStatus() {
        return this.status;
    }
}
