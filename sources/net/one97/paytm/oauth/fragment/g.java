package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56593a = new HashMap();

    private g() {
    }

    public static g fromBundle(Bundle bundle) {
        g gVar = new g();
        bundle.setClassLoader(g.class.getClassLoader());
        if (bundle.containsKey("meta")) {
            gVar.f56593a.put("meta", bundle.getString("meta"));
        }
        if (bundle.containsKey("state")) {
            gVar.f56593a.put("state", bundle.getString("state"));
        }
        if (bundle.containsKey("logout")) {
            gVar.f56593a.put("logout", Boolean.valueOf(bundle.getBoolean("logout")));
        }
        if (bundle.containsKey("mobile")) {
            gVar.f56593a.put("mobile", bundle.getString("mobile"));
        }
        return gVar;
    }

    private String d() {
        return (String) this.f56593a.get("meta");
    }

    public final String a() {
        return (String) this.f56593a.get("state");
    }

    public final boolean b() {
        return ((Boolean) this.f56593a.get("logout")).booleanValue();
    }

    public final String c() {
        return (String) this.f56593a.get("mobile");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f56593a.containsKey("meta") != gVar.f56593a.containsKey("meta")) {
            return false;
        }
        if (d() == null ? gVar.d() != null : !d().equals(gVar.d())) {
            return false;
        }
        if (this.f56593a.containsKey("state") != gVar.f56593a.containsKey("state")) {
            return false;
        }
        if (a() == null ? gVar.a() != null : !a().equals(gVar.a())) {
            return false;
        }
        if (this.f56593a.containsKey("logout") == gVar.f56593a.containsKey("logout") && b() == gVar.b() && this.f56593a.containsKey("mobile") == gVar.f56593a.containsKey("mobile")) {
            return c() == null ? gVar.c() == null : c().equals(gVar.c());
        }
        return false;
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = ((((((d() != null ? d().hashCode() : 0) + 31) * 31) + (a() != null ? a().hashCode() : 0)) * 31) + (b() ? 1 : 0)) * 31;
        if (c() != null) {
            i2 = c().hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "AccountBlockReasonFragmentArgs{meta=" + d() + ", state=" + a() + ", logout=" + b() + ", mobile=" + c() + "}";
    }
}
