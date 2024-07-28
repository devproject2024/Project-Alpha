package c.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.c;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

final class l<T> implements n, Callback {

    /* renamed from: a  reason: collision with root package name */
    private Handler f5587a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private String f5588b;

    /* renamed from: c  reason: collision with root package name */
    private p f5589c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a<T> f5590d;

    /* renamed from: e  reason: collision with root package name */
    private Headers f5591e;

    /* renamed from: f  reason: collision with root package name */
    private String f5592f;

    /* renamed from: g  reason: collision with root package name */
    private h f5593g;

    /* renamed from: h  reason: collision with root package name */
    private OkHttpClient f5594h;

    public l(h hVar, String str, p pVar, OkHttpClient.Builder builder, a<T> aVar) {
        this.f5593g = hVar;
        this.f5588b = str;
        this.f5590d = aVar;
        if (pVar == null) {
            this.f5589c = new p();
        } else {
            this.f5589c = pVar;
        }
        this.f5592f = this.f5589c.f5615d;
        String str2 = this.f5592f;
        if (str2 == null || str2.isEmpty()) {
            this.f5592f = "default_http_task_key";
        }
        g.a();
        g.a(this.f5592f, this);
        this.f5594h = builder.build();
    }

    /* access modifiers changed from: protected */
    public final void a() {
        if (this.f5589c.f5612a != null) {
            this.f5591e = this.f5589c.f5612a.build();
        }
        try {
            String str = this.f5588b;
            Request.Builder builder = new Request.Builder();
            switch (this.f5593g) {
                case GET:
                    this.f5588b = r.a(this.f5588b, this.f5589c.f5613b, this.f5589c.f5616e);
                    builder.get();
                    break;
                case DELETE:
                    this.f5588b = r.a(this.f5588b, this.f5589c.f5613b, this.f5589c.f5616e);
                    builder.delete();
                    break;
                case HEAD:
                    this.f5588b = r.a(this.f5588b, this.f5589c.f5613b, this.f5589c.f5616e);
                    builder.head();
                    break;
                case POST:
                    this.f5588b = r.a(this.f5588b);
                    RequestBody a2 = this.f5589c.a();
                    if (a2 != null) {
                        builder.post(new o(a2, this));
                        break;
                    }
                    break;
                case PUT:
                case PATCH:
                    this.f5588b = r.a(this.f5588b);
                    RequestBody a3 = this.f5589c.a();
                    if (a3 != null) {
                        builder.put(new o(a3, this));
                        break;
                    }
                    break;
            }
            if (this.f5589c.f5617f != null) {
                builder.cacheControl(this.f5589c.f5617f);
            }
            this.f5588b = b.e((Context) c.a(), this.f5588b);
            builder.url(this.f5588b).tag(str).headers(this.f5591e);
            Request build = builder.build();
            if (b.f5552a) {
                q.d("url=" + str + "?" + this.f5589c.toString() + "\n header=" + this.f5591e.toString());
            }
            Call newCall = this.f5594h.newCall(build);
            i a4 = i.a();
            String str2 = this.f5588b;
            if (!(newCall == null || str2 == null || str2.isEmpty())) {
                a4.f5565a.put(str2, newCall);
            }
            FirebasePerfOkHttpClient.enqueue(newCall, this);
        } catch (Exception unused) {
        }
    }

    public final void a(int i2, long j, boolean z) {
        final int i3 = i2;
        final long j2 = j;
        final boolean z2 = z;
        this.f5587a.post(new Runnable() {
            public final void run() {
                if (l.this.f5590d != null) {
                    a unused = l.this.f5590d;
                }
            }
        });
    }

    public final void onFailure(Call call, IOException iOException) {
        q qVar = new q();
        if (iOException instanceof SocketTimeoutException) {
            qVar.f5622b = true;
        } else if ((iOException instanceof InterruptedIOException) && TextUtils.equals(iOException.getMessage(), H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT)) {
            qVar.f5622b = true;
        }
        a(qVar, (Response) null);
    }

    public final void onResponse(Call call, Response response) throws IOException {
        a(new q(), response);
    }

    /* access modifiers changed from: protected */
    public final void a(q qVar) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        i a2 = i.a();
        String str = this.f5588b;
        if (str != null && !str.isEmpty()) {
            a2.f5565a.remove(str);
        }
        g.a();
        if (g.a(this.f5592f)) {
            a<T> aVar = this.f5590d;
            if (aVar != null) {
                aVar.a(qVar.f5627g);
            }
            int i2 = qVar.f5623c;
            String str2 = qVar.f5624d;
            if (qVar.f5621a) {
                if (b.f5552a) {
                    q.d("url=" + this.f5588b + "\n response failure code=" + i2 + " msg=" + str2);
                }
                a<T> aVar2 = this.f5590d;
                if (aVar2 != null) {
                    aVar2.a(i2, str2);
                }
            } else if (qVar.f5626f) {
                String str3 = qVar.f5625e;
                if (b.f5552a) {
                    Headers headers = qVar.f5627g;
                    q.d("url=" + this.f5588b + "\n result=" + str3 + "\n header=" + (headers != null ? headers.toString() : ""));
                }
                a<T> aVar3 = this.f5590d;
                if (aVar3 != null) {
                    String str4 = qVar.f5625e;
                    if (str4 == null || str4.isEmpty()) {
                        q.b("response empty!!!");
                    }
                    if (aVar3.f5546a == String.class) {
                        aVar3.a(str4);
                        return;
                    }
                    Object obj = null;
                    if (aVar3.f5546a == JSONObject.class) {
                        try {
                            jSONObject = (JSONObject) new f().a(str4, JSONObject.class);
                        } catch (Exception unused) {
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            aVar3.a(jSONObject);
                            return;
                        }
                    } else if (aVar3.f5546a == JSONArray.class) {
                        try {
                            jSONArray = (JSONArray) new f().a(str4, JSONArray.class);
                        } catch (Exception unused2) {
                            jSONArray = null;
                        }
                        if (jSONArray != null) {
                            aVar3.a(jSONArray);
                            return;
                        }
                    } else {
                        try {
                            obj = new f().a(str4, aVar3.f5546a);
                        } catch (Exception unused3) {
                        }
                        if (obj != null) {
                            aVar3.a(obj);
                            return;
                        }
                    }
                    aVar3.a(1002, "Data parse exception");
                }
            } else {
                if (b.f5552a) {
                    q.d("url=" + this.f5588b + "\n response failure code=" + i2 + " msg=" + str2);
                }
                a<T> aVar4 = this.f5590d;
                if (aVar4 != null) {
                    aVar4.a(i2, str2);
                }
            }
        }
    }

    private void a(final q qVar, Response response) {
        String str;
        if (response != null) {
            qVar.f5621a = false;
            qVar.f5623c = response.code();
            qVar.f5624d = response.message();
            qVar.f5626f = response.isSuccessful();
            try {
                str = response.body().string();
            } catch (IOException unused) {
                str = "";
            }
            qVar.f5625e = str;
            qVar.f5627g = response.headers();
        } else {
            qVar.f5621a = true;
            qVar.f5623c = 1003;
            if (qVar.f5622b) {
                qVar.f5624d = "request timeout";
            } else {
                qVar.f5624d = "http exception";
            }
        }
        qVar.f5628h = response;
        this.f5587a.post(new Runnable() {
            public final void run() {
                l.this.a(qVar);
            }
        });
    }
}
