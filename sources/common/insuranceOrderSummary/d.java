package common.insuranceOrderSummary;

import android.graphics.drawable.Drawable;
import java.util.List;
import kotlin.g.b.k;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public String f13445a;

    /* renamed from: b  reason: collision with root package name */
    public String f13446b;

    /* renamed from: c  reason: collision with root package name */
    public String f13447c;

    /* renamed from: d  reason: collision with root package name */
    public String f13448d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f13449e;

    /* renamed from: f  reason: collision with root package name */
    public String f13450f;

    /* renamed from: g  reason: collision with root package name */
    public String f13451g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f13452h;

    /* renamed from: i  reason: collision with root package name */
    public String f13453i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    private String u;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof d) && k.a((Object) this.u, (Object) ((d) obj).u);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.u;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "InsurancePostPaymentInfo(insuranceType=" + this.u + ")";
    }

    public d(String str) {
        this.u = str;
    }
}
