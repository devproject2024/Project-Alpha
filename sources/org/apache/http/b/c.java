package org.apache.http.b;

import java.util.Locale;
import org.apache.http.e.a;
import org.apache.http.g;
import org.apache.http.n;
import org.apache.http.o;
import org.apache.http.q;
import org.apache.http.r;
import org.apache.http.t;

public final class c extends a implements n {

    /* renamed from: a  reason: collision with root package name */
    private t f72492a = null;

    /* renamed from: b  reason: collision with root package name */
    private q f72493b;

    /* renamed from: c  reason: collision with root package name */
    private int f72494c;

    /* renamed from: d  reason: collision with root package name */
    private String f72495d;

    /* renamed from: e  reason: collision with root package name */
    private g f72496e;

    /* renamed from: f  reason: collision with root package name */
    private final r f72497f;

    /* renamed from: g  reason: collision with root package name */
    private Locale f72498g;

    public c(q qVar, int i2) {
        a.a(i2, "Status code");
        this.f72493b = qVar;
        this.f72494c = i2;
        this.f72495d = null;
        this.f72497f = null;
        this.f72498g = null;
    }

    public final t a() {
        if (this.f72492a == null) {
            q qVar = this.f72493b;
            if (qVar == null) {
                qVar = o.f72520c;
            }
            int i2 = this.f72494c;
            String str = this.f72495d;
            if (str == null) {
                r rVar = this.f72497f;
                if (rVar != null) {
                    if (this.f72498g == null) {
                        Locale.getDefault();
                    }
                    str = rVar.a();
                } else {
                    str = null;
                }
            }
            this.f72492a = new f(qVar, i2, str);
        }
        return this.f72492a;
    }

    public final g b() {
        return this.f72496e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(' ');
        sb.append(this.headergroup);
        if (this.f72496e != null) {
            sb.append(' ');
            sb.append(this.f72496e);
        }
        return sb.toString();
    }
}
