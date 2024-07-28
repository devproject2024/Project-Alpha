package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56398a = new HashMap();

    private b() {
    }

    public static b fromBundle(Bundle bundle) {
        b bVar = new b();
        bundle.setClassLoader(b.class.getClassLoader());
        if (bundle.containsKey("meta")) {
            bVar.f56398a.put("meta", bundle.getString("meta"));
        }
        if (bundle.containsKey("logout")) {
            bVar.f56398a.put("logout", Boolean.valueOf(bundle.getBoolean("logout")));
        }
        if (bundle.containsKey("mobile")) {
            bVar.f56398a.put("mobile", bundle.getString("mobile"));
        }
        return bVar;
    }

    private String c() {
        return (String) this.f56398a.get("meta");
    }

    public final boolean a() {
        return ((Boolean) this.f56398a.get("logout")).booleanValue();
    }

    public final String b() {
        return (String) this.f56398a.get("mobile");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f56398a.containsKey("meta") != bVar.f56398a.containsKey("meta")) {
            return false;
        }
        if (c() == null ? bVar.c() != null : !c().equals(bVar.c())) {
            return false;
        }
        if (this.f56398a.containsKey("logout") == bVar.f56398a.containsKey("logout") && a() == bVar.a() && this.f56398a.containsKey("mobile") == bVar.f56398a.containsKey("mobile")) {
            return b() == null ? bVar.b() == null : b().equals(bVar.b());
        }
        return false;
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = ((((c() != null ? c().hashCode() : 0) + 31) * 31) + (a() ? 1 : 0)) * 31;
        if (b() != null) {
            i2 = b().hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "AccountBlockConfirmedFragmentArgs{meta=" + c() + ", logout=" + a() + ", mobile=" + b() + "}";
    }
}
