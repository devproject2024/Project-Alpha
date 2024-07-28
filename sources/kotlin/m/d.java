package kotlin.m;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;
import kotlin.g.b.k;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f47971a;

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f47972b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f47973c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f47974d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f47975e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f47976f;

    /* renamed from: g  reason: collision with root package name */
    public static final d f47977g = new d();

    static {
        Charset forName = Charset.forName(AppConstants.UTF_8);
        k.b(forName, "Charset.forName(\"UTF-8\")");
        f47971a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        k.b(forName2, "Charset.forName(\"UTF-16\")");
        f47972b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        k.b(forName3, "Charset.forName(\"UTF-16BE\")");
        f47973c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        k.b(forName4, "Charset.forName(\"UTF-16LE\")");
        f47974d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        k.b(forName5, "Charset.forName(\"US-ASCII\")");
        f47975e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        k.b(forName6, "Charset.forName(\"ISO-8859-1\")");
        f47976f = forName6;
    }

    private d() {
    }
}
