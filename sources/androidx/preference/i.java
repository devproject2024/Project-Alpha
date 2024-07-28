package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    e f30885a;

    /* renamed from: b  reason: collision with root package name */
    boolean f30886b;

    /* renamed from: c  reason: collision with root package name */
    PreferenceScreen f30887c;

    /* renamed from: d  reason: collision with root package name */
    d f30888d;

    /* renamed from: e  reason: collision with root package name */
    c f30889e;

    /* renamed from: f  reason: collision with root package name */
    a f30890f;

    /* renamed from: g  reason: collision with root package name */
    b f30891g;

    /* renamed from: h  reason: collision with root package name */
    private Context f30892h;

    /* renamed from: i  reason: collision with root package name */
    private long f30893i = 0;
    private SharedPreferences j;
    private SharedPreferences.Editor k;
    private String l;
    private int m;
    private int n = 0;

    public interface a {
    }

    public interface b {
    }

    public interface c {
        boolean d_();
    }

    public static abstract class d {
        public abstract boolean a();

        public abstract boolean b();
    }

    public i(Context context) {
        this.f30892h = context;
        this.l = context.getPackageName() + "_preferences";
        this.j = null;
    }

    public final <T extends Preference> T a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f30887c;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.c(charSequence);
    }

    /* access modifiers changed from: package-private */
    public final SharedPreferences.Editor b() {
        if (this.f30885a != null) {
            return null;
        }
        if (!this.f30886b) {
            return a().edit();
        }
        if (this.k == null) {
            this.k = a().edit();
        }
        return this.k;
    }

    public final SharedPreferences a() {
        Context context;
        if (this.f30885a != null) {
            return null;
        }
        if (this.j == null) {
            if (this.n != 1) {
                context = this.f30892h;
            } else {
                context = androidx.core.content.b.d(this.f30892h);
            }
            this.j = context.getSharedPreferences(this.l, this.m);
        }
        return this.j;
    }
}
