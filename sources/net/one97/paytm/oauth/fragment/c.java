package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import java.util.HashMap;

public class c implements androidx.navigation.c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56558a = new HashMap();

    private c() {
    }

    public static c fromBundle(Bundle bundle) {
        c cVar = new c();
        bundle.setClassLoader(c.class.getClassLoader());
        if (bundle.containsKey("mobileNumber")) {
            cVar.f56558a.put("mobileNumber", bundle.getString("mobileNumber"));
        }
        return cVar;
    }

    public final String a() {
        return (String) this.f56558a.get("mobileNumber");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f56558a.containsKey("mobileNumber") != cVar.f56558a.containsKey("mobileNumber")) {
            return false;
        }
        return a() == null ? cVar.a() == null : a().equals(cVar.a());
    }

    public int hashCode() {
        return (a() != null ? a().hashCode() : 0) + 31;
    }

    public String toString() {
        return "AccountBlockEnterNumberFragmentArgs{mobileNumber=" + a() + "}";
    }
}
