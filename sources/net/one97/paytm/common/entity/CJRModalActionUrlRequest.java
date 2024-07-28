package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;

public class CJRModalActionUrlRequest extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "ipAddress")
    private String mIpAddress;
    @b(a = "metadata")
    private String mMetadata;
    @b(a = "operationType")
    private String mOperationType;
    @b(a = "platformName")
    private String mPlatformName;
    @b(a = "request")
    private HashMap<Object, Object> mRequest;

    public String getName() {
        return null;
    }

    public HashMap<Object, Object> getRequest() {
        return this.mRequest;
    }

    public String getIpAddress() {
        return this.mIpAddress;
    }

    public String getMetadata() {
        return this.mMetadata;
    }

    public String getPlatformName() {
        return this.mPlatformName;
    }

    public String getOperationType() {
        return this.mOperationType;
    }
}
