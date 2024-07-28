package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.SharedPreferences;

public class x {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f73048a;

    public x(Context context) {
        this.f73048a = context.getSharedPreferences("NPCIPreferences", 0);
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor edit = this.f73048a.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public String b(String str, String str2) {
        return this.f73048a.getString(str, str2);
    }
}
