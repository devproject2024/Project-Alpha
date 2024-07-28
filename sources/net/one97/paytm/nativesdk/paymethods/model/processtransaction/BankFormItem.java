package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import java.io.Serializable;
import kotlin.g.b.k;

public final class BankFormItem implements Serializable {
    private String actionUrl;
    private Object content;
    private Object encType;
    private Object headers;
    private String method;
    private String type;

    public static /* synthetic */ BankFormItem copy$default(BankFormItem bankFormItem, String str, String str2, String str3, Object obj, Object obj2, Object obj3, int i2, Object obj4) {
        if ((i2 & 1) != 0) {
            str = bankFormItem.actionUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = bankFormItem.method;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = bankFormItem.type;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            obj = bankFormItem.headers;
        }
        Object obj5 = obj;
        if ((i2 & 16) != 0) {
            obj2 = bankFormItem.encType;
        }
        Object obj6 = obj2;
        if ((i2 & 32) != 0) {
            obj3 = bankFormItem.content;
        }
        return bankFormItem.copy(str, str4, str5, obj5, obj6, obj3);
    }

    public final String component1() {
        return this.actionUrl;
    }

    public final String component2() {
        return this.method;
    }

    public final String component3() {
        return this.type;
    }

    public final Object component4() {
        return this.headers;
    }

    public final Object component5() {
        return this.encType;
    }

    public final Object component6() {
        return this.content;
    }

    public final BankFormItem copy(String str, String str2, String str3, Object obj, Object obj2, Object obj3) {
        return new BankFormItem(str, str2, str3, obj, obj2, obj3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankFormItem)) {
            return false;
        }
        BankFormItem bankFormItem = (BankFormItem) obj;
        return k.a((Object) this.actionUrl, (Object) bankFormItem.actionUrl) && k.a((Object) this.method, (Object) bankFormItem.method) && k.a((Object) this.type, (Object) bankFormItem.type) && k.a(this.headers, bankFormItem.headers) && k.a(this.encType, bankFormItem.encType) && k.a(this.content, bankFormItem.content);
    }

    public final int hashCode() {
        String str = this.actionUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.method;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Object obj = this.headers;
        int hashCode4 = (hashCode3 + (obj != null ? obj.hashCode() : 0)) * 31;
        Object obj2 = this.encType;
        int hashCode5 = (hashCode4 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object obj3 = this.content;
        if (obj3 != null) {
            i2 = obj3.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "BankFormItem(actionUrl=" + this.actionUrl + ", method=" + this.method + ", type=" + this.type + ", headers=" + this.headers + ", encType=" + this.encType + ", content=" + this.content + ")";
    }

    public BankFormItem(String str, String str2, String str3, Object obj, Object obj2, Object obj3) {
        this.actionUrl = str;
        this.method = str2;
        this.type = str3;
        this.headers = obj;
        this.encType = obj2;
        this.content = obj3;
    }

    public final String getActionUrl() {
        return this.actionUrl;
    }

    public final void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public final String getMethod() {
        return this.method;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final Object getHeaders() {
        return this.headers;
    }

    public final void setHeaders(Object obj) {
        this.headers = obj;
    }

    public final Object getEncType() {
        return this.encType;
    }

    public final void setEncType(Object obj) {
        this.encType = obj;
    }

    public final Object getContent() {
        return this.content;
    }

    public final void setContent(Object obj) {
        this.content = obj;
    }

    public BankFormItem() {
        this((String) null, (String) null, (String) null, (Object) null, (Object) null, (Object) null);
    }
}
