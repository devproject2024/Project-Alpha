package com.alibaba.wireless.security.a;

import com.alibaba.wireless.security.a.a.c;
import java.io.File;
import org.json.JSONObject;

public final class f {

    /* renamed from: b  reason: collision with root package name */
    private static String f14609b = "version";

    /* renamed from: c  reason: collision with root package name */
    private static String f14610c = "lib_dep_version";

    /* renamed from: d  reason: collision with root package name */
    private static String f14611d = "lib_dep_arch";

    /* renamed from: e  reason: collision with root package name */
    private static String f14612e = "target_plugin";

    /* renamed from: a  reason: collision with root package name */
    JSONObject f14613a;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14614f = true;

    /* renamed from: g  reason: collision with root package name */
    private int f14615g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14616h = true;

    /* renamed from: i  reason: collision with root package name */
    private String f14617i = "";
    private boolean j = true;
    private String k = "";

    private f(JSONObject jSONObject) {
        this.f14613a = jSONObject;
    }

    public static f a(File file) {
        if (!file.exists()) {
            return null;
        }
        try {
            String a2 = c.a(file);
            if (a2 == null || a2.length() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(a2);
            if ("1.0".equals(jSONObject.getString(f14609b))) {
                return new f(jSONObject);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final int a() {
        int i2;
        if (this.f14614f) {
            try {
                i2 = Integer.parseInt(this.f14613a.getString(f14610c));
            } catch (Exception unused) {
                i2 = 0;
            }
            this.f14615g = i2;
            this.f14614f = false;
        }
        return this.f14615g;
    }

    public final String b() {
        String str;
        if (this.f14616h) {
            try {
                str = this.f14613a.getString(f14611d);
            } catch (Exception unused) {
                str = "";
            }
            this.f14617i = str;
            this.f14616h = false;
        }
        return this.f14617i;
    }

    public final String c() {
        String str;
        if (this.j) {
            try {
                str = this.f14613a.getString(f14612e);
            } catch (Exception unused) {
                str = "";
            }
            this.k = str;
            this.j = false;
        }
        return this.k;
    }

    public final String a(String str) {
        try {
            return this.f14613a.getString(str);
        } catch (Exception unused) {
            return "";
        }
    }
}
