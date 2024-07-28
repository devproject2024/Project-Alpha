package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class q implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56609a = new HashMap();

    private q() {
    }

    public static q fromBundle(Bundle bundle) {
        q qVar = new q();
        bundle.setClassLoader(q.class.getClassLoader());
        if (bundle.containsKey("verifierId")) {
            qVar.f56609a.put("verifierId", bundle.getString("verifierId"));
        }
        if (bundle.containsKey("mobile")) {
            qVar.f56609a.put("mobile", bundle.getString("mobile"));
        }
        if (bundle.containsKey("stateCode")) {
            qVar.f56609a.put("stateCode", bundle.getString("stateCode"));
        }
        return qVar;
    }

    public final String a() {
        return (String) this.f56609a.get("verifierId");
    }

    public final String b() {
        return (String) this.f56609a.get("mobile");
    }

    public final String c() {
        return (String) this.f56609a.get("stateCode");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f56609a.containsKey("verifierId") != qVar.f56609a.containsKey("verifierId")) {
            return false;
        }
        if (a() == null ? qVar.a() != null : !a().equals(qVar.a())) {
            return false;
        }
        if (this.f56609a.containsKey("mobile") != qVar.f56609a.containsKey("mobile")) {
            return false;
        }
        if (b() == null ? qVar.b() != null : !b().equals(qVar.b())) {
            return false;
        }
        if (this.f56609a.containsKey("stateCode") != qVar.f56609a.containsKey("stateCode")) {
            return false;
        }
        return c() == null ? qVar.c() == null : c().equals(qVar.c());
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
        return "AccountUnblockVerifyOtpFragmentArgs{verifierId=" + a() + ", mobile=" + b() + ", stateCode=" + c() + "}";
    }
}
