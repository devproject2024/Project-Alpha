package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class k implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56601a = new HashMap();

    private k() {
    }

    public static k fromBundle(Bundle bundle) {
        k kVar = new k();
        bundle.setClassLoader(k.class.getClassLoader());
        if (bundle.containsKey("mobileNumber")) {
            kVar.f56601a.put("mobileNumber", bundle.getString("mobileNumber"));
        }
        return kVar;
    }

    public final String a() {
        return (String) this.f56601a.get("mobileNumber");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f56601a.containsKey("mobileNumber") != kVar.f56601a.containsKey("mobileNumber")) {
            return false;
        }
        return a() == null ? kVar.a() == null : a().equals(kVar.a());
    }

    public int hashCode() {
        return (a() != null ? a().hashCode() : 0) + 31;
    }

    public String toString() {
        return "AccountUnblockMobileNumberFragmentArgs{mobileNumber=" + a() + "}";
    }
}
