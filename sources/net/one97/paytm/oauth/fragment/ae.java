package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class ae implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56308a = new HashMap();

    private ae() {
    }

    public static ae fromBundle(Bundle bundle) {
        ae aeVar = new ae();
        bundle.setClassLoader(ae.class.getClassLoader());
        if (bundle.containsKey("stateToken")) {
            aeVar.f56308a.put("stateToken", bundle.getString("stateToken"));
        }
        if (bundle.containsKey("previous_screen_name")) {
            aeVar.f56308a.put("previous_screen_name", bundle.getString("previous_screen_name"));
        }
        if (bundle.containsKey("verifyFlow")) {
            aeVar.f56308a.put("verifyFlow", bundle.getString("verifyFlow"));
        }
        return aeVar;
    }

    public final String a() {
        return (String) this.f56308a.get("stateToken");
    }

    private String c() {
        return (String) this.f56308a.get("previous_screen_name");
    }

    public final String b() {
        return (String) this.f56308a.get("verifyFlow");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ae aeVar = (ae) obj;
        if (this.f56308a.containsKey("stateToken") != aeVar.f56308a.containsKey("stateToken")) {
            return false;
        }
        if (a() == null ? aeVar.a() != null : !a().equals(aeVar.a())) {
            return false;
        }
        if (this.f56308a.containsKey("previous_screen_name") != aeVar.f56308a.containsKey("previous_screen_name")) {
            return false;
        }
        if (c() == null ? aeVar.c() != null : !c().equals(aeVar.c())) {
            return false;
        }
        if (this.f56308a.containsKey("verifyFlow") != aeVar.f56308a.containsKey("verifyFlow")) {
            return false;
        }
        return b() == null ? aeVar.b() == null : b().equals(aeVar.b());
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
        return "EnterNewNumberFragmentArgs{stateToken=" + a() + ", previousScreenName=" + c() + ", verifyFlow=" + b() + "}";
    }
}
