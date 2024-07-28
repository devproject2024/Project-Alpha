package com.business.merchant_payments.notificationsettings.model;

import com.paytmmall.clpartifact.modal.clpCommon.Item;
import kotlin.g.b.k;

public final class Info {
    public final String cta;
    public final String cta_deeplink;

    public static /* synthetic */ Info copy$default(Info info, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = info.cta;
        }
        if ((i2 & 2) != 0) {
            str2 = info.cta_deeplink;
        }
        return info.copy(str, str2);
    }

    public final String component1() {
        return this.cta;
    }

    public final String component2() {
        return this.cta_deeplink;
    }

    public final Info copy(String str, String str2) {
        k.d(str, Item.KEY_CTA);
        k.d(str2, "cta_deeplink");
        return new Info(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Info)) {
            return false;
        }
        Info info = (Info) obj;
        return k.a((Object) this.cta, (Object) info.cta) && k.a((Object) this.cta_deeplink, (Object) info.cta_deeplink);
    }

    public final int hashCode() {
        String str = this.cta;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cta_deeplink;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Info(cta=" + this.cta + ", cta_deeplink=" + this.cta_deeplink + ")";
    }

    public Info(String str, String str2) {
        k.d(str, Item.KEY_CTA);
        k.d(str2, "cta_deeplink");
        this.cta = str;
        this.cta_deeplink = str2;
    }

    public final String getCta() {
        return this.cta;
    }

    public final String getCta_deeplink() {
        return this.cta_deeplink;
    }
}
