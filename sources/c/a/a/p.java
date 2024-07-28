package c.a.a;

import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    protected final Headers.Builder f5612a;

    /* renamed from: b  reason: collision with root package name */
    final List<m> f5613b;

    /* renamed from: c  reason: collision with root package name */
    protected e f5614c;

    /* renamed from: d  reason: collision with root package name */
    String f5615d;

    /* renamed from: e  reason: collision with root package name */
    boolean f5616e;

    /* renamed from: f  reason: collision with root package name */
    protected CacheControl f5617f;

    /* renamed from: g  reason: collision with root package name */
    private final List<m> f5618g;

    /* renamed from: h  reason: collision with root package name */
    private RequestBody f5619h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5620i;
    private JSONObject j;

    public p() {
        this((byte) 0);
    }

    private p(byte b2) {
        this.f5612a = new Headers.Builder();
        this.f5613b = new ArrayList();
        this.f5618g = new ArrayList();
        this.f5614c = null;
        b();
    }

    private void b() {
        this.f5612a.add("charset", AppConstants.UTF_8);
        j b2 = j.b();
        if (b2.f5568b == null) {
            b2.a();
        }
        List<m> list = b2.f5568b.f5569a;
        if (list != null && list.size() > 0) {
            this.f5613b.addAll(list);
        }
        Headers a2 = j.b().f5568b.a();
        if (a2 != null && a2.size() > 0) {
            for (int i2 = 0; i2 < a2.size(); i2++) {
                this.f5612a.add(a2.name(i2), a2.value(i2));
            }
        }
        e eVar = this.f5614c;
        if (eVar != null) {
            this.f5615d = eVar.a();
        }
    }

    public final void a(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        m mVar = new m(str, str2);
        if (!str.isEmpty() && !this.f5613b.contains(mVar)) {
            this.f5613b.add(mVar);
        }
    }

    public final void b(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.f5612a.add(str, str2);
        }
    }

    public final void c(String str, String str2) {
        this.f5619h = RequestBody.create(MediaType.parse(str), str2);
    }

    /* access modifiers changed from: protected */
    public final RequestBody a() {
        String str;
        String str2;
        if (this.f5620i) {
            f fVar = new f();
            JSONObject jSONObject = this.j;
            if (jSONObject == null) {
                JSONObject jSONObject2 = new JSONObject();
                for (m next : this.f5613b) {
                    try {
                        jSONObject2.put(next.f5602a, next.f5603b);
                    } catch (JSONException unused) {
                    }
                }
                str2 = fVar.a((Object) jSONObject2);
            } else {
                str2 = fVar.a((Object) jSONObject);
            }
            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), str2);
        }
        RequestBody requestBody = this.f5619h;
        if (requestBody != null) {
            return requestBody;
        }
        if (this.f5618g.size() > 0) {
            boolean z = false;
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            for (m next2 : this.f5613b) {
                builder.addFormDataPart(next2.f5602a, next2.f5603b);
                z = true;
            }
            for (m next3 : this.f5618g) {
                String str3 = next3.f5602a;
                d dVar = next3.f5604c;
                if (dVar != null) {
                    if (dVar.f5560b != null) {
                        str = dVar.f5560b;
                    } else {
                        str = "nofilename";
                    }
                    builder.addFormDataPart(str3, str, RequestBody.create(dVar.f5561c, dVar.f5559a));
                    z = true;
                }
            }
            if (z) {
                return builder.build();
            }
            return null;
        }
        FormBody.Builder builder2 = new FormBody.Builder();
        for (m next4 : this.f5613b) {
            builder2.add(next4.f5602a, next4.f5603b);
        }
        return builder2.build();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (m next : this.f5613b) {
            String str = next.f5602a;
            String str2 = next.f5603b;
            if (sb.length() > 0) {
                sb.append(AppConstants.AND_SIGN);
            }
            sb.append(str);
            sb.append("=");
            sb.append(str2);
        }
        for (m mVar : this.f5618g) {
            String str3 = mVar.f5602a;
            if (sb.length() > 0) {
                sb.append(AppConstants.AND_SIGN);
            }
            sb.append(str3);
            sb.append("=");
            sb.append(StringSet.FILE);
        }
        if (this.j != null) {
            sb.append(new f().a((Object) this.j));
        }
        return sb.toString();
    }
}
