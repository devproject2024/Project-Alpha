package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class au implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56385a = new HashMap();

    private au() {
    }

    public static au fromBundle(Bundle bundle) {
        au auVar = new au();
        bundle.setClassLoader(au.class.getClassLoader());
        if (bundle.containsKey("mobileNo")) {
            auVar.f56385a.put("mobileNo", bundle.getString("mobileNo"));
        }
        if (bundle.containsKey("previous_screen_name")) {
            auVar.f56385a.put("previous_screen_name", bundle.getString("previous_screen_name"));
        }
        if (bundle.containsKey("stateToken")) {
            auVar.f56385a.put("stateToken", bundle.getString("stateToken"));
        }
        if (bundle.containsKey("verifyFlow")) {
            auVar.f56385a.put("verifyFlow", bundle.getString("verifyFlow"));
        }
        return auVar;
    }

    public final String a() {
        return (String) this.f56385a.get("mobileNo");
    }

    private String d() {
        return (String) this.f56385a.get("previous_screen_name");
    }

    public final String b() {
        return (String) this.f56385a.get("stateToken");
    }

    public final String c() {
        return (String) this.f56385a.get("verifyFlow");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        au auVar = (au) obj;
        if (this.f56385a.containsKey("mobileNo") != auVar.f56385a.containsKey("mobileNo")) {
            return false;
        }
        if (a() == null ? auVar.a() != null : !a().equals(auVar.a())) {
            return false;
        }
        if (this.f56385a.containsKey("previous_screen_name") != auVar.f56385a.containsKey("previous_screen_name")) {
            return false;
        }
        if (d() == null ? auVar.d() != null : !d().equals(auVar.d())) {
            return false;
        }
        if (this.f56385a.containsKey("stateToken") != auVar.f56385a.containsKey("stateToken")) {
            return false;
        }
        if (b() == null ? auVar.b() != null : !b().equals(auVar.b())) {
            return false;
        }
        if (this.f56385a.containsKey("verifyFlow") != auVar.f56385a.containsKey("verifyFlow")) {
            return false;
        }
        return c() == null ? auVar.c() == null : c().equals(auVar.c());
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = ((((((a() != null ? a().hashCode() : 0) + 31) * 31) + (d() != null ? d().hashCode() : 0)) * 31) + (b() != null ? b().hashCode() : 0)) * 31;
        if (c() != null) {
            i2 = c().hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "NewNumberOtpFragmentArgs{mobileNo=" + a() + ", previousScreenName=" + d() + ", stateToken=" + b() + ", verifyFlow=" + c() + "}";
    }
}
