package com.paytm.network;

import android.content.Context;
import com.android.volley.RetryPolicy;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f42877a;

    /* renamed from: b  reason: collision with root package name */
    public a.c f42878b;

    /* renamed from: c  reason: collision with root package name */
    public a.C0715a f42879c;

    /* renamed from: d  reason: collision with root package name */
    public String f42880d;

    /* renamed from: e  reason: collision with root package name */
    public String f42881e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f42882f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f42883g;

    /* renamed from: h  reason: collision with root package name */
    public String f42884h;

    /* renamed from: i  reason: collision with root package name */
    public IJRPaytmDataModel f42885i;
    public com.paytm.network.listener.b j;
    public boolean k = true;
    public boolean l = true;
    boolean m;
    public a.b n;
    public String o;
    public String p;
    public RetryPolicy q;
    public boolean r;
    String s;
    public JSONObject t;
    public boolean u = true;
    public String v;
    public int w;
    public int x = -1;
    public boolean y = true;
    public boolean z = true;

    public final com.paytm.network.listener.b a() {
        return this.j;
    }

    public final a.C0715a b() {
        return this.f42879c;
    }

    public final String c() {
        return this.f42880d;
    }

    public final Map<String, String> d() {
        return this.f42882f;
    }

    public final String e() {
        return this.f42884h;
    }

    public final b a(boolean z2) {
        this.k = z2;
        return this;
    }

    public final b f() {
        this.l = true;
        return this;
    }

    public final IJRPaytmDataModel g() {
        return this.f42885i;
    }

    public final b a(Context context) {
        this.f42877a = context;
        return this;
    }

    public final b a(a.c cVar) {
        this.f42878b = cVar;
        return this;
    }

    public final b a(a.C0715a aVar) {
        this.f42879c = aVar;
        return this;
    }

    public final b a(String str) {
        this.f42880d = str;
        return this;
    }

    public final b h() {
        this.f42881e = null;
        return this;
    }

    public final b a(Map<String, String> map) {
        this.f42882f = map;
        return this;
    }

    public final b b(Map map) {
        this.f42883g = map;
        return this;
    }

    public final b b(String str) {
        this.f42884h = str;
        return this;
    }

    public final b a(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f42885i = iJRPaytmDataModel;
        return this;
    }

    public final b a(com.paytm.network.listener.b bVar) {
        this.j = bVar;
        return this;
    }

    public final b a(JSONObject jSONObject) {
        this.t = jSONObject;
        return this;
    }

    public final b c(String str) {
        this.o = str;
        return this;
    }

    public final b a(a.b bVar) {
        this.n = bVar;
        return this;
    }

    public final b d(String str) {
        this.s = str;
        return this;
    }

    public final b a(int i2) {
        this.x = i2;
        return this;
    }

    public final b b(int i2) {
        this.w = i2;
        return this;
    }

    public final b i() {
        this.z = false;
        return this;
    }

    public final b j() {
        this.y = false;
        return this;
    }

    public final String k() {
        return this.v;
    }

    public final b e(String str) {
        this.v = str;
        return this;
    }

    public a l() {
        return new a(this);
    }
}
