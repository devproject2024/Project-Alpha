package net.one97.paytm.addmoney.common;

import net.one97.paytm.addmoney.common.paymethodresponse.HasLowSuccess;
import net.one97.paytm.addmoney.common.paymethodresponse.IsDisabled;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f48419a;

    /* renamed from: b  reason: collision with root package name */
    public String f48420b;

    /* renamed from: c  reason: collision with root package name */
    public String f48421c;

    /* renamed from: d  reason: collision with root package name */
    public String f48422d;

    /* renamed from: e  reason: collision with root package name */
    public String f48423e;

    /* renamed from: f  reason: collision with root package name */
    public String f48424f;

    /* renamed from: g  reason: collision with root package name */
    public String f48425g;

    /* renamed from: h  reason: collision with root package name */
    public IsDisabled f48426h;

    /* renamed from: i  reason: collision with root package name */
    public HasLowSuccess f48427i;
    public JSONObject j;
    public String k;

    public final boolean equals(Object obj) {
        String str;
        String str2;
        b bVar = (b) obj;
        if (bVar == null || (str = bVar.f48419a) == null || (str2 = this.f48419a) == null || this.f48420b == null || bVar.f48420b == null || bVar.f48422d == null || !str.equals(str2) || !bVar.f48420b.equalsIgnoreCase(this.f48420b) || !bVar.f48422d.equalsIgnoreCase(this.f48422d)) {
            return false;
        }
        return true;
    }
}
