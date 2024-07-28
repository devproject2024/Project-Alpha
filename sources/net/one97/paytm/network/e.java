package net.one97.paytm.network;

import android.net.Uri;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.android.volley.toolbox.HttpClientStack;
import com.google.gson.f;
import com.paytm.network.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f55786a = {"_id", "requestDate", "tookMs", "method", H5Param.HOST, H5TabbarUtils.MATCH_TYPE_PATH, "scheme", "requestContentLength", "responseCode", "error", "responseContentLength"};

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f55787b = new SimpleDateFormat("HH:mm:ss", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    private Date f55788c;

    /* renamed from: d  reason: collision with root package name */
    private Date f55789d;

    /* renamed from: e  reason: collision with root package name */
    private Long f55790e;

    /* renamed from: f  reason: collision with root package name */
    private String f55791f;

    /* renamed from: g  reason: collision with root package name */
    private String f55792g;

    /* renamed from: h  reason: collision with root package name */
    private String f55793h;

    /* renamed from: i  reason: collision with root package name */
    private String f55794i;
    private String j;
    private String k;
    private String l;
    private String m;
    private boolean n = true;
    private Integer o;
    private Long p;
    private String q;
    private boolean r = true;

    public final void a(Date date) {
        this.f55788c = date;
    }

    public final void b(Date date) {
        this.f55789d = date;
    }

    public final void a(a.C0715a aVar) {
        if (aVar == a.C0715a.GET) {
            this.f55791f = H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD;
        } else if (aVar == a.C0715a.DELETE) {
            this.f55791f = "DELETE";
        } else if (aVar == a.C0715a.POST) {
            this.f55791f = "POST";
        } else if (aVar == a.C0715a.PUT) {
            this.f55791f = "PUT";
        } else if (aVar == a.C0715a.HEAD) {
            this.f55791f = "HEAD";
        } else if (aVar == a.C0715a.OPTIONS) {
            this.f55791f = "OPTIONS";
        } else if (aVar == a.C0715a.PATCH) {
            this.f55791f = HttpClientStack.HttpPatch.METHOD_NAME;
        } else if (aVar == a.C0715a.TRACE) {
            this.f55791f = "TRACE";
        }
    }

    public final void a(String str) {
        this.m = str;
    }

    public final void b(String str) {
        this.k = str;
    }

    public final void c(String str) {
        this.q = str;
    }

    public final void a(Integer num) {
        this.o = num;
    }

    public final void a(Long l2) {
        this.p = l2;
    }

    public final void b(Long l2) {
        this.f55790e = l2;
    }

    public final void d(String str) {
        String str2;
        this.f55792g = str;
        Uri parse = Uri.parse(str);
        this.f55793h = parse.getHost();
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getPath());
        if (parse.getQuery() != null) {
            str2 = "?" + parse.getQuery();
        } else {
            str2 = "";
        }
        sb.append(str2);
        this.f55794i = sb.toString();
        this.j = parse.getScheme();
    }

    public final void a(Map<String, String> map) {
        this.l = new f().b(map);
    }
}
