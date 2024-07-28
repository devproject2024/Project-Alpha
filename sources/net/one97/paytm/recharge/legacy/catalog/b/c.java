package net.one97.paytm.recharge.legacy.catalog.b;

import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;

@Deprecated
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public CJROrderSummaryAction f62803a;

    /* renamed from: b  reason: collision with root package name */
    public String f62804b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f62805c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f62806d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f62807e = "";

    public c(CJROrderSummaryAction cJROrderSummaryAction) {
        this.f62803a = cJROrderSummaryAction;
    }

    public c() {
    }

    public static boolean a(Object obj) {
        if (obj != null) {
            return (obj instanceof String) && ((String) obj).trim().length() == 0;
        }
        return true;
    }
}
