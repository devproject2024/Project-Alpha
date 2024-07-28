package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.b.b;
import com.google.android.gms.b.d;
import com.google.android.gms.flags.f;

public class FlagProviderImpl extends f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f9034a = false;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f9035b;

    public void init(b bVar) {
        Context context = (Context) d.a(bVar);
        if (!this.f9034a) {
            try {
                this.f9035b = j.a(context.createPackageContext("com.google.android.gms", 0));
                this.f9034a = true;
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf);
                } else {
                    new String("Could not retrieve sdk flags, continuing with defaults: ");
                }
            }
        }
    }

    public boolean getBooleanFlagValue(String str, boolean z, int i2) {
        if (!this.f9034a) {
            return z;
        }
        return b.a(this.f9035b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i2, int i3) {
        if (!this.f9034a) {
            return i2;
        }
        return d.a(this.f9035b, str, Integer.valueOf(i2)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i2) {
        if (!this.f9034a) {
            return j;
        }
        return f.a(this.f9035b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i2) {
        if (!this.f9034a) {
            return str2;
        }
        return h.a(this.f9035b, str, str2);
    }
}
