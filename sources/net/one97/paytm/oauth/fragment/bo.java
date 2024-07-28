package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.c;
import java.util.HashMap;

public class bo implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56502a = new HashMap();

    private bo() {
    }

    public static bo fromBundle(Bundle bundle) {
        bo boVar = new bo();
        bundle.setClassLoader(bo.class.getClassLoader());
        if (bundle.containsKey("mobileNumber")) {
            boVar.f56502a.put("mobileNumber", bundle.getString("mobileNumber"));
        }
        if (bundle.containsKey("stateToken")) {
            boVar.f56502a.put("stateToken", bundle.getString("stateToken"));
        }
        return boVar;
    }

    public final String a() {
        return (String) this.f56502a.get("mobileNumber");
    }

    public final String b() {
        return (String) this.f56502a.get("stateToken");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bo boVar = (bo) obj;
        if (this.f56502a.containsKey("mobileNumber") != boVar.f56502a.containsKey("mobileNumber")) {
            return false;
        }
        if (a() == null ? boVar.a() != null : !a().equals(boVar.a())) {
            return false;
        }
        if (this.f56502a.containsKey("stateToken") != boVar.f56502a.containsKey("stateToken")) {
            return false;
        }
        return b() == null ? boVar.b() == null : b().equals(boVar.b());
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = ((a() != null ? a().hashCode() : 0) + 31) * 31;
        if (b() != null) {
            i2 = b().hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "SetNewPasswordFragmentArgs{mobileNumber=" + a() + ", stateToken=" + b() + "}";
    }
}
