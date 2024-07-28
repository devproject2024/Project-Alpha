package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class o implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56607a = new HashMap();

    private o() {
    }

    public static o fromBundle(Bundle bundle) {
        o oVar = new o();
        bundle.setClassLoader(o.class.getClassLoader());
        if (bundle.containsKey("mobile")) {
            oVar.f56607a.put("mobile", bundle.getString("mobile"));
        }
        return oVar;
    }

    public final String a() {
        return (String) this.f56607a.get("mobile");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f56607a.containsKey("mobile") != oVar.f56607a.containsKey("mobile")) {
            return false;
        }
        return a() == null ? oVar.a() == null : a().equals(oVar.a());
    }

    public int hashCode() {
        return (a() != null ? a().hashCode() : 0) + 31;
    }

    public String toString() {
        return "AccountUnblockSuccessFragmentArgs{mobile=" + a() + "}";
    }
}
