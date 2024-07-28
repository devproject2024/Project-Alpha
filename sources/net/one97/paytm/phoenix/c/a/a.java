package net.one97.paytm.phoenix.c.a;

import java.util.Map;
import kotlin.g.b.k;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final C1146a f59384g = new C1146a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f59385i = "GET";
    private static final String j = j;
    private static final String k = k;
    private static final String l = l;

    /* renamed from: a  reason: collision with root package name */
    public String f59386a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f59387b = 0;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f59388c = new JSONObject();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f59389d;

    /* renamed from: e  reason: collision with root package name */
    public String f59390e;

    /* renamed from: f  reason: collision with root package name */
    public String f59391f;

    /* renamed from: h  reason: collision with root package name */
    private JSONArray f59392h = new JSONArray();

    public a(String str, Integer num, JSONArray jSONArray, JSONObject jSONObject, Map<String, String> map, String str2, String str3) {
        k.c(jSONArray, "headersArray");
        k.c(jSONObject, "headerJsonOb");
        this.f59386a = str;
        this.f59387b = num;
        this.f59392h = jSONArray;
        this.f59388c = jSONObject;
        this.f59389d = map;
        this.f59390e = str2;
        this.f59391f = str3;
    }

    public final String toString() {
        return "HttpRequest{url='" + this.f59386a + "', timeoutMs=" + this.f59387b + ", headersArray=" + this.f59392h + ", headerJsonOb=" + this.f59388c + ", headersMap=" + this.f59389d + ", method='" + this.f59390e + "', data='" + this.f59391f + "'}";
    }

    /* renamed from: net.one97.paytm.phoenix.c.a.a$a  reason: collision with other inner class name */
    public static final class C1146a {
        private C1146a() {
        }

        public /* synthetic */ C1146a(byte b2) {
            this();
        }
    }
}
