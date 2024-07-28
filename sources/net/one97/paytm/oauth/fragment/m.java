package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class m implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56604a = new HashMap();

    private m() {
    }

    public static m fromBundle(Bundle bundle) {
        m mVar = new m();
        bundle.setClassLoader(m.class.getClassLoader());
        if (bundle.containsKey("stateCode")) {
            mVar.f56604a.put("stateCode", bundle.getString("stateCode"));
        }
        if (bundle.containsKey("mobile")) {
            mVar.f56604a.put("mobile", bundle.getString("mobile"));
        }
        if (bundle.containsKey("verifierId")) {
            mVar.f56604a.put("verifierId", bundle.getString("verifierId"));
        }
        if (bundle.containsKey("lastFourDigit")) {
            mVar.f56604a.put("lastFourDigit", bundle.getString("lastFourDigit"));
        }
        return mVar;
    }

    public final String a() {
        return (String) this.f56604a.get("stateCode");
    }

    public final String b() {
        return (String) this.f56604a.get("mobile");
    }

    public final String c() {
        return (String) this.f56604a.get("verifierId");
    }

    public final String d() {
        return (String) this.f56604a.get("lastFourDigit");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f56604a.containsKey("stateCode") != mVar.f56604a.containsKey("stateCode")) {
            return false;
        }
        if (a() == null ? mVar.a() != null : !a().equals(mVar.a())) {
            return false;
        }
        if (this.f56604a.containsKey("mobile") != mVar.f56604a.containsKey("mobile")) {
            return false;
        }
        if (b() == null ? mVar.b() != null : !b().equals(mVar.b())) {
            return false;
        }
        if (this.f56604a.containsKey("verifierId") != mVar.f56604a.containsKey("verifierId")) {
            return false;
        }
        if (c() == null ? mVar.c() != null : !c().equals(mVar.c())) {
            return false;
        }
        if (this.f56604a.containsKey("lastFourDigit") != mVar.f56604a.containsKey("lastFourDigit")) {
            return false;
        }
        return d() == null ? mVar.d() == null : d().equals(mVar.d());
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = ((((((a() != null ? a().hashCode() : 0) + 31) * 31) + (b() != null ? b().hashCode() : 0)) * 31) + (c() != null ? c().hashCode() : 0)) * 31;
        if (d() != null) {
            i2 = d().hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "AccountUnblockSavedCardFragmentArgs{stateCode=" + a() + ", mobile=" + b() + ", verifierId=" + c() + ", lastFourDigit=" + d() + "}";
    }
}
