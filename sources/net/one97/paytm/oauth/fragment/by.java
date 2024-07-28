package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.HashMap;

public class by implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56556a = new HashMap();

    private by() {
    }

    public static by fromBundle(Bundle bundle) {
        by byVar = new by();
        bundle.setClassLoader(by.class.getClassLoader());
        if (bundle.containsKey("stateToken")) {
            byVar.f56556a.put("stateToken", bundle.getString("stateToken"));
        }
        if (bundle.containsKey(AppConstants.KEY_EMAIL)) {
            byVar.f56556a.put(AppConstants.KEY_EMAIL, bundle.getString(AppConstants.KEY_EMAIL));
        }
        if (bundle.containsKey("previous_screen_name")) {
            byVar.f56556a.put("previous_screen_name", bundle.getString("previous_screen_name"));
        }
        return byVar;
    }

    public final String a() {
        return (String) this.f56556a.get("stateToken");
    }

    public final String b() {
        return (String) this.f56556a.get(AppConstants.KEY_EMAIL);
    }

    public final String c() {
        return (String) this.f56556a.get("previous_screen_name");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        by byVar = (by) obj;
        if (this.f56556a.containsKey("stateToken") != byVar.f56556a.containsKey("stateToken")) {
            return false;
        }
        if (a() == null ? byVar.a() != null : !a().equals(byVar.a())) {
            return false;
        }
        if (this.f56556a.containsKey(AppConstants.KEY_EMAIL) != byVar.f56556a.containsKey(AppConstants.KEY_EMAIL)) {
            return false;
        }
        if (b() == null ? byVar.b() != null : !b().equals(byVar.b())) {
            return false;
        }
        if (this.f56556a.containsKey("previous_screen_name") != byVar.f56556a.containsKey("previous_screen_name")) {
            return false;
        }
        return c() == null ? byVar.c() == null : c().equals(byVar.c());
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = ((((a() != null ? a().hashCode() : 0) + 31) * 31) + (b() != null ? b().hashCode() : 0)) * 31;
        if (c() != null) {
            i2 = c().hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "VerifyEmailOtpFragmentArgs{stateToken=" + a() + ", email=" + b() + ", previousScreenName=" + c() + "}";
    }
}
