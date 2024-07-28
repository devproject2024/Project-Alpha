package com.alipay.mobile.rome.syncsdk.d.b;

import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.p;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {

    /* renamed from: h  reason: collision with root package name */
    private static final String f15019h = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected byte f15020a;

    /* renamed from: b  reason: collision with root package name */
    protected byte f15021b;

    /* renamed from: c  reason: collision with root package name */
    protected byte f15022c;

    /* renamed from: d  reason: collision with root package name */
    protected int f15023d;

    /* renamed from: e  reason: collision with root package name */
    protected byte f15024e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected byte[] f15025f;

    /* renamed from: g  reason: collision with root package name */
    protected byte[] f15026g;

    public abstract void c(byte[] bArr);

    public abstract byte[] g();

    protected a() {
    }

    public final int a() {
        return this.f15021b;
    }

    public final void a(int i2) {
        this.f15021b = (byte) i2;
    }

    public final int b() {
        return this.f15022c;
    }

    public final void b(int i2) {
        this.f15022c = (byte) i2;
    }

    public final int c() {
        return this.f15023d;
    }

    public final int d() {
        return this.f15024e;
    }

    public final byte[] e() {
        return this.f15026g;
    }

    public final void a(byte[] bArr) {
        this.f15026g = bArr;
        this.f15023d = bArr.length;
    }

    public final void b(byte[] bArr) {
        this.f15026g = p.b(bArr);
        this.f15023d = bArr.length;
        this.f15024e = 0;
    }

    public final String f() {
        byte[] bArr = this.f15026g;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, AppConstants.UTF_8);
            } catch (UnsupportedEncodingException e2) {
                String str = f15019h;
                h.d(str, "getDataStr: [ Exception " + e2 + " ]");
            }
        }
        return "";
    }

    public final void a(String str) {
        if (str == null || str.length() <= 0) {
            this.f15026g = null;
            this.f15023d = 0;
            return;
        }
        try {
            a(str.getBytes(AppConstants.UTF_8));
        } catch (UnsupportedEncodingException e2) {
            String str2 = f15019h;
            h.d(str2, "setDataStr: [ Exception " + e2 + " ]");
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f15020a);
            jSONObject.put("packetType", this.f15021b);
            jSONObject.put("packetReqOrRep", this.f15022c);
            jSONObject.put("dataLen", this.f15023d);
            jSONObject.put("isDataGziped", this.f15024e);
            jSONObject.put("extField", this.f15025f);
            jSONObject.put("dataStr", f());
            return jSONObject.toString();
        } catch (JSONException e2) {
            String str = f15019h;
            h.d(str, "toString: [ Exception " + e2 + " ]");
            return "Pakcet toString failed";
        }
    }

    public static boolean a(a aVar) {
        return aVar.f15020a == b.f15028b;
    }
}
