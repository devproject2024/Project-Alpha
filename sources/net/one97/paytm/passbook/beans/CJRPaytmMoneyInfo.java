package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRPaytmMoneyInfo extends IJRDataModel {
    @b(a = "data")
    public DataInfo data;
    @b(a = "meta")
    public MetaInfo meta;

    public static class DataInfo {
        @b(a = "currentValue")
        public String currentValue;
        @b(a = "deeplink")
        public String deeplink;
    }

    public static class MetaInfo {
        @b(a = "code")
        public String code;
        @b(a = "message")
        public String message;
        @b(a = "requestId")
        public String requestId;
        @b(a = "responseId")
        public String responseId;
    }
}
