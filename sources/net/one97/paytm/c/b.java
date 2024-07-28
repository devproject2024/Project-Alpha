package net.one97.paytm.c;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import com.google.android.play.core.appupdate.a;
import com.google.android.play.core.appupdate.c;
import com.google.android.play.core.appupdate.d;
import com.google.android.play.core.e.e;
import com.paytm.utility.f;
import net.one97.paytm.utils.ag;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f49527a = 2;

    /* renamed from: b  reason: collision with root package name */
    private c f49528b;

    /* renamed from: c  reason: collision with root package name */
    private com.google.android.play.core.appupdate.a f49529c = null;

    /* renamed from: d  reason: collision with root package name */
    private Context f49530d;

    /* renamed from: e  reason: collision with root package name */
    private int f49531e;

    /* renamed from: f  reason: collision with root package name */
    private final String f49532f = "inAppUpdate";

    /* renamed from: g  reason: collision with root package name */
    private final String f49533g = "userConsentCountImmediateUpdate";

    /* renamed from: h  reason: collision with root package name */
    private a f49534h;

    public interface a {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(e eVar) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Exception exc) {
    }

    public b(Context context) {
        this.f49530d = context;
        this.f49534h = null;
        net.one97.paytm.j.c.a();
        this.f49531e = net.one97.paytm.j.c.ap().intValue();
        this.f49528b = d.a(context);
    }

    public final void a() {
        if (this.f49529c == null) {
            c();
        } else {
            b();
        }
    }

    private void b() {
        e();
        if (d()) {
            try {
                this.f49528b.a(this.f49529c, 1, (Activity) this.f49530d, f49527a);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    private void c() {
        c cVar = this.f49528b;
        if (cVar != null) {
            cVar.a().a(new com.google.android.play.core.e.c() {
                public final void onSuccess(Object obj) {
                    b.this.a((a) obj);
                }
            }).a($$Lambda$b$loYzoDvf7Y3GQBHUdXakGyKpBeg.INSTANCE).a((com.google.android.play.core.e.b) $$Lambda$b$anbfo_ajnw6tvbsoKaYfd1SS5U.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.google.android.play.core.appupdate.a aVar) {
        if (!aVar.a(1)) {
            this.f49529c = null;
        } else if (aVar.c() == 2) {
            this.f49529c = aVar;
            b();
        } else if (aVar.c() == 3) {
            this.f49529c = aVar;
            a();
        }
    }

    private boolean d() {
        com.google.android.play.core.appupdate.a aVar = this.f49529c;
        return aVar != null && this.f49531e > 0 && aVar.b() > 720656 && g() % this.f49531e == 0;
    }

    private void e() {
        com.google.android.play.core.appupdate.a aVar = this.f49529c;
        if (aVar == null) {
            return;
        }
        if (aVar.b() == 720656) {
            a(0);
        } else if (this.f49529c.b() <= 720656) {
        } else {
            if (g() == 0) {
                a(this.f49531e);
            } else {
                f();
            }
        }
    }

    private void f() {
        a(g() + 1);
    }

    private int g() {
        return ag.a(this.f49530d, f.a.IN_APP_UPDATE).b("userConsentCountImmediateUpdate", 0, false);
    }

    private void a(int i2) {
        ag.a(this.f49530d, f.a.IN_APP_UPDATE).a("userConsentCountImmediateUpdate", i2, false);
    }
}
