package net.one97.paytm.common.entity.insurance;

import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRDataModelItem;

public final class InsuranceBuyPayOptionModel extends CJRDataModelItem {
    private final String deeplink;
    private final String icon_url;
    private final String subtitle;
    private final String title;

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public InsuranceBuyPayOptionModel(String str, String str2, String str3, String str4) {
        this.title = str;
        this.deeplink = str2;
        this.subtitle = str3;
        this.icon_url = str4;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getName() {
        String str = this.deeplink;
        String a2 = str != null ? p.a(str, (CharSequence) "paytmmp://") : null;
        if (a2 == null) {
            k.a();
        }
        return a2;
    }
}
