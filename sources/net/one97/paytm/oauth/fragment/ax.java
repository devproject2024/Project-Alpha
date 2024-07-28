package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class ax implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56390a = new HashMap();

    private ax() {
    }

    public static ax fromBundle(Bundle bundle) {
        ax axVar = new ax();
        bundle.setClassLoader(ax.class.getClassLoader());
        if (bundle.containsKey("mobileNo")) {
            axVar.f56390a.put("mobileNo", bundle.getString("mobileNo"));
        }
        if (bundle.containsKey("previous_screen_name")) {
            axVar.f56390a.put("previous_screen_name", bundle.getString("previous_screen_name"));
        }
        if (bundle.containsKey("verifyFlow")) {
            axVar.f56390a.put("verifyFlow", bundle.getString("verifyFlow"));
        }
        return axVar;
    }

    public final String a() {
        return (String) this.f56390a.get("mobileNo");
    }

    private String c() {
        return (String) this.f56390a.get("previous_screen_name");
    }

    public final String b() {
        return (String) this.f56390a.get("verifyFlow");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ax axVar = (ax) obj;
        if (this.f56390a.containsKey("mobileNo") != axVar.f56390a.containsKey("mobileNo")) {
            return false;
        }
        if (a() == null ? axVar.a() != null : !a().equals(axVar.a())) {
            return false;
        }
        if (this.f56390a.containsKey("previous_screen_name") != axVar.f56390a.containsKey("previous_screen_name")) {
            return false;
        }
        if (c() == null ? axVar.c() != null : !c().equals(axVar.c())) {
            return false;
        }
        if (this.f56390a.containsKey("verifyFlow") != axVar.f56390a.containsKey("verifyFlow")) {
            return false;
        }
        return b() == null ? axVar.b() == null : b().equals(axVar.b());
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = ((((a() != null ? a().hashCode() : 0) + 31) * 31) + (c() != null ? c().hashCode() : 0)) * 31;
        if (b() != null) {
            i2 = b().hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "NumberUpdateSuccessFragmentArgs{mobileNo=" + a() + ", previousScreenName=" + c() + ", verifyFlow=" + b() + "}";
    }
}
