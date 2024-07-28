package org.npci.upi.security.pinactivitycomponent;

import android.app.Activity;
import android.content.Context;
import android.os.ResultReceiver;
import in.org.npci.commonlibrary.e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private Map f72968a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Context f72969b;

    /* renamed from: c  reason: collision with root package name */
    private Properties f72970c;

    /* renamed from: d  reason: collision with root package name */
    private Properties f72971d;

    /* renamed from: e  reason: collision with root package name */
    private Properties f72972e;

    /* renamed from: f  reason: collision with root package name */
    private aq f72973f;

    /* renamed from: g  reason: collision with root package name */
    private j f72974g;

    /* renamed from: h  reason: collision with root package name */
    private Locale f72975h;

    /* renamed from: i  reason: collision with root package name */
    private e f72976i;
    private Activity j;
    private v k;
    private i l;

    public c(Context context, v vVar, Activity activity) {
        this.k = vVar;
        this.f72975h = vVar.b();
        this.f72969b = context;
        this.f72976i = vVar.c();
        this.j = activity;
        this.f72972e = a(CLConstants.CL_PROPERTIES);
        this.f72970c = a(CLConstants.VALIDATION_PROPERTIES);
        this.f72971d = a(CLConstants.VERSION_PROPERTIES);
        Locale locale = this.f72975h;
        if (locale != null) {
            Map map = this.f72968a;
            String language = locale.getLanguage();
            map.put(language, a("cl-messages_" + this.f72975h.getLanguage() + ".properties"));
        } else {
            Locale locale2 = new Locale(CLConstants.DEFAULT_LANGUAGE_PREFERENCE);
            Map map2 = this.f72968a;
            String language2 = locale2.getLanguage();
            map2.put(language2, a("cl-messages_" + locale2.getLanguage() + ".properties"));
        }
        this.l = vVar.d();
        this.f72973f = new aq(this);
        if (vVar != null && vVar.c() != null && vVar.a() != null) {
            this.f72974g = new j(this.f72976i, this.l, vVar.a());
        }
    }

    public Properties a(String str) {
        Properties properties = new Properties();
        try {
            properties.load(this.f72969b.getAssets().open(str));
        } catch (IOException e2) {
            ad.a("AssetsPropertyReader", e2.toString());
        }
        return properties;
    }

    public aq a() {
        return this.f72973f;
    }

    public String b(String str) {
        Properties properties = this.f72971d;
        if (properties != null) {
            return properties.getProperty(str);
        }
        return null;
    }

    public j b() {
        v vVar;
        if (this.f72974g == null && (vVar = this.k) != null) {
            this.f72976i = vVar.c();
            this.f72974g = new j(this.k.c(), this.k.d(), this.k.a());
        }
        ad.b("Common Library", "get Encryptor");
        ad.b("Common Library", "Input Analyzer :" + this.k);
        StringBuilder sb = new StringBuilder("Input Analyzer Key Code:");
        sb.append(this.k);
        String str = null;
        ad.b("Common Library", sb.toString() == null ? null : this.k.a());
        if (("Input Analyzer Common Library:" + this.k) != null) {
            str = this.k.c().toString();
        }
        ad.b("Common Library", str);
        return this.f72974g;
    }

    public Activity c() {
        return this.j;
    }

    public ResultReceiver d() {
        v vVar = this.k;
        if (vVar == null) {
            return null;
        }
        return vVar.e();
    }
}
