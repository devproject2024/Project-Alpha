package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class ca implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56559a = new HashMap();

    private ca() {
    }

    public static ca fromBundle(Bundle bundle) {
        ca caVar = new ca();
        bundle.setClassLoader(ca.class.getClassLoader());
        if (bundle.containsKey("meta")) {
            caVar.f56559a.put("meta", bundle.getString("meta"));
        }
        if (bundle.containsKey("stateToken")) {
            caVar.f56559a.put("stateToken", bundle.getString("stateToken"));
        }
        if (bundle.containsKey("mobileNo")) {
            caVar.f56559a.put("mobileNo", bundle.getString("mobileNo"));
        }
        if (bundle.containsKey("mode")) {
            String string = bundle.getString("mode");
            if (string != null) {
                caVar.f56559a.put("mode", string);
            } else {
                throw new IllegalArgumentException("Argument \"mode\" is marked as non-null but was passed a null value.");
            }
        }
        if (bundle.containsKey("is_update_email")) {
            caVar.f56559a.put("is_update_email", Boolean.valueOf(bundle.getBoolean("is_update_email")));
        }
        if (bundle.containsKey("previous_screen_name")) {
            caVar.f56559a.put("previous_screen_name", bundle.getString("previous_screen_name"));
        }
        return caVar;
    }

    public final String a() {
        return (String) this.f56559a.get("meta");
    }

    public final String b() {
        return (String) this.f56559a.get("stateToken");
    }

    public final String c() {
        return (String) this.f56559a.get("mobileNo");
    }

    public final String d() {
        return (String) this.f56559a.get("mode");
    }

    public final boolean e() {
        return ((Boolean) this.f56559a.get("is_update_email")).booleanValue();
    }

    private String f() {
        return (String) this.f56559a.get("previous_screen_name");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ca caVar = (ca) obj;
        if (this.f56559a.containsKey("meta") != caVar.f56559a.containsKey("meta")) {
            return false;
        }
        if (a() == null ? caVar.a() != null : !a().equals(caVar.a())) {
            return false;
        }
        if (this.f56559a.containsKey("stateToken") != caVar.f56559a.containsKey("stateToken")) {
            return false;
        }
        if (b() == null ? caVar.b() != null : !b().equals(caVar.b())) {
            return false;
        }
        if (this.f56559a.containsKey("mobileNo") != caVar.f56559a.containsKey("mobileNo")) {
            return false;
        }
        if (c() == null ? caVar.c() != null : !c().equals(caVar.c())) {
            return false;
        }
        if (this.f56559a.containsKey("mode") != caVar.f56559a.containsKey("mode")) {
            return false;
        }
        if (d() == null ? caVar.d() != null : !d().equals(caVar.d())) {
            return false;
        }
        if (this.f56559a.containsKey("is_update_email") == caVar.f56559a.containsKey("is_update_email") && e() == caVar.e() && this.f56559a.containsKey("previous_screen_name") == caVar.f56559a.containsKey("previous_screen_name")) {
            return f() == null ? caVar.f() == null : f().equals(caVar.f());
        }
        return false;
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = ((((((((((a() != null ? a().hashCode() : 0) + 31) * 31) + (b() != null ? b().hashCode() : 0)) * 31) + (c() != null ? c().hashCode() : 0)) * 31) + (d() != null ? d().hashCode() : 0)) * 31) + (e() ? 1 : 0)) * 31;
        if (f() != null) {
            i2 = f().hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "VerifyEmailPhoneOtpFragmentArgs{meta=" + a() + ", stateToken=" + b() + ", mobileNo=" + c() + ", mode=" + d() + ", isUpdateEmail=" + e() + ", previousScreenName=" + f() + "}";
    }
}
