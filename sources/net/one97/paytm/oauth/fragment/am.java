package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class am implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56348a = new HashMap();

    private am() {
    }

    public static am fromBundle(Bundle bundle) {
        am amVar = new am();
        bundle.setClassLoader(am.class.getClassLoader());
        if (bundle.containsKey("mobileNumber")) {
            amVar.f56348a.put("mobileNumber", bundle.getString("mobileNumber"));
        }
        if (bundle.containsKey("stateToken")) {
            amVar.f56348a.put("stateToken", bundle.getString("stateToken"));
        }
        return amVar;
    }

    public final String a() {
        return (String) this.f56348a.get("mobileNumber");
    }

    public final String b() {
        return (String) this.f56348a.get("stateToken");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        am amVar = (am) obj;
        if (this.f56348a.containsKey("mobileNumber") != amVar.f56348a.containsKey("mobileNumber")) {
            return false;
        }
        if (a() == null ? amVar.a() != null : !a().equals(amVar.a())) {
            return false;
        }
        if (this.f56348a.containsKey("stateToken") != amVar.f56348a.containsKey("stateToken")) {
            return false;
        }
        return b() == null ? amVar.b() == null : b().equals(amVar.b());
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = ((a() != null ? a().hashCode() : 0) + 31) * 31;
        if (b() != null) {
            i2 = b().hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ForgotEnterOtpFragmentArgs{mobileNumber=" + a() + ", stateToken=" + b() + "}";
    }
}
