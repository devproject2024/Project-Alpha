package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56590a = new HashMap();

    private e() {
    }

    public static e fromBundle(Bundle bundle) {
        e eVar = new e();
        bundle.setClassLoader(e.class.getClassLoader());
        if (bundle.containsKey("verifierId")) {
            eVar.f56590a.put("verifierId", bundle.getString("verifierId"));
        }
        if (bundle.containsKey("accountEncryptPublicKey")) {
            eVar.f56590a.put("accountEncryptPublicKey", bundle.getString("accountEncryptPublicKey"));
        }
        if (bundle.containsKey("accountEncryptSalt")) {
            eVar.f56590a.put("accountEncryptSalt", bundle.getString("accountEncryptSalt"));
        }
        if (bundle.containsKey("state")) {
            eVar.f56590a.put("state", bundle.getString("state"));
        }
        if (bundle.containsKey("mobile")) {
            eVar.f56590a.put("mobile", bundle.getString("mobile"));
        }
        return eVar;
    }

    public final String a() {
        return (String) this.f56590a.get("verifierId");
    }

    public final String b() {
        return (String) this.f56590a.get("accountEncryptPublicKey");
    }

    public final String c() {
        return (String) this.f56590a.get("accountEncryptSalt");
    }

    public final String d() {
        return (String) this.f56590a.get("state");
    }

    public final String e() {
        return (String) this.f56590a.get("mobile");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f56590a.containsKey("verifierId") != eVar.f56590a.containsKey("verifierId")) {
            return false;
        }
        if (a() == null ? eVar.a() != null : !a().equals(eVar.a())) {
            return false;
        }
        if (this.f56590a.containsKey("accountEncryptPublicKey") != eVar.f56590a.containsKey("accountEncryptPublicKey")) {
            return false;
        }
        if (b() == null ? eVar.b() != null : !b().equals(eVar.b())) {
            return false;
        }
        if (this.f56590a.containsKey("accountEncryptSalt") != eVar.f56590a.containsKey("accountEncryptSalt")) {
            return false;
        }
        if (c() == null ? eVar.c() != null : !c().equals(eVar.c())) {
            return false;
        }
        if (this.f56590a.containsKey("state") != eVar.f56590a.containsKey("state")) {
            return false;
        }
        if (d() == null ? eVar.d() != null : !d().equals(eVar.d())) {
            return false;
        }
        if (this.f56590a.containsKey("mobile") != eVar.f56590a.containsKey("mobile")) {
            return false;
        }
        return e() == null ? eVar.e() == null : e().equals(eVar.e());
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = ((((((((a() != null ? a().hashCode() : 0) + 31) * 31) + (b() != null ? b().hashCode() : 0)) * 31) + (c() != null ? c().hashCode() : 0)) * 31) + (d() != null ? d().hashCode() : 0)) * 31;
        if (e() != null) {
            i2 = e().hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "AccountBlockEnterPasscodeFragmentArgs{verifierId=" + a() + ", accountEncryptPublicKey=" + b() + ", accountEncryptSalt=" + c() + ", state=" + d() + ", mobile=" + e() + "}";
    }
}
