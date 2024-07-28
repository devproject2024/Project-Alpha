package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class bb implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56403a = new HashMap();

    private bb() {
    }

    public static bb fromBundle(Bundle bundle) {
        bb bbVar = new bb();
        bundle.setClassLoader(bb.class.getClassLoader());
        if (bundle.containsKey("stateToken")) {
            bbVar.f56403a.put("stateToken", bundle.getString("stateToken"));
        }
        if (bundle.containsKey("verifierId")) {
            bbVar.f56403a.put("verifierId", bundle.getString("verifierId"));
        }
        if (bundle.containsKey("previous_screen_name")) {
            bbVar.f56403a.put("previous_screen_name", bundle.getString("previous_screen_name"));
        }
        return bbVar;
    }

    public final String a() {
        return (String) this.f56403a.get("stateToken");
    }

    public final String b() {
        return (String) this.f56403a.get("verifierId");
    }

    private String c() {
        return (String) this.f56403a.get("previous_screen_name");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bb bbVar = (bb) obj;
        if (this.f56403a.containsKey("stateToken") != bbVar.f56403a.containsKey("stateToken")) {
            return false;
        }
        if (a() == null ? bbVar.a() != null : !a().equals(bbVar.a())) {
            return false;
        }
        if (this.f56403a.containsKey("verifierId") != bbVar.f56403a.containsKey("verifierId")) {
            return false;
        }
        if (b() == null ? bbVar.b() != null : !b().equals(bbVar.b())) {
            return false;
        }
        if (this.f56403a.containsKey("previous_screen_name") != bbVar.f56403a.containsKey("previous_screen_name")) {
            return false;
        }
        return c() == null ? bbVar.c() == null : c().equals(bbVar.c());
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
        return "SavedCardListFragmentArgs{stateToken=" + a() + ", verifierId=" + b() + ", previousScreenName=" + c() + "}";
    }
}
