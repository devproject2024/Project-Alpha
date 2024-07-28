package net.one97.paytm.c;

import android.app.Activity;
import android.content.IntentSender;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.a.c;
import com.google.android.play.core.appupdate.d;
import com.paytm.network.b.b;
import com.paytm.utility.f;
import com.paytm.utility.q;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ag;

public final class a implements c {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public com.google.android.play.core.appupdate.c f49514a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public c f49515b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.google.android.play.core.appupdate.a f49516c = null;

    /* renamed from: d  reason: collision with root package name */
    private Activity f49517d;

    /* renamed from: e  reason: collision with root package name */
    private int f49518e;

    /* renamed from: f  reason: collision with root package name */
    private final String f49519f = "inAppUpdate";

    /* renamed from: g  reason: collision with root package name */
    private final String f49520g = "userConsentCountFlexibleUpdate";

    /* renamed from: h  reason: collision with root package name */
    private C0882a f49521h;

    /* renamed from: net.one97.paytm.c.a$a  reason: collision with other inner class name */
    public interface C0882a {
        void a(int i2);
    }

    public final /* bridge */ /* synthetic */ void onStateUpdate(Object obj) {
    }

    public a(Activity activity) {
        this.f49517d = activity;
        this.f49521h = null;
        net.one97.paytm.j.c.a();
        this.f49518e = net.one97.paytm.j.c.ap().intValue();
        this.f49514a = d.a(activity);
    }

    public final void a() {
        if (!b.a(this.f49517d)) {
            e();
            b(0);
        } else if (this.f49516c == null) {
            g();
        } else {
            b();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        d();
        if (c()) {
            try {
                this.f49514a.a(this.f49516c, 0, this.f49517d, 1);
                return;
            } catch (IntentSender.SendIntentException unused) {
            }
        }
        b(0);
    }

    private boolean c() {
        com.google.android.play.core.appupdate.a aVar = this.f49516c;
        return aVar != null && this.f49518e > 0 && aVar.b() > 720656 && f() % this.f49518e == 0;
    }

    private void d() {
        com.google.android.play.core.appupdate.a aVar = this.f49516c;
        if (aVar == null) {
            return;
        }
        if (aVar.b() == 720656) {
            a(0);
        } else if (this.f49516c.b() <= 720656) {
        } else {
            if (f() == 0) {
                a(this.f49518e);
            } else {
                e();
            }
        }
    }

    private void e() {
        a(f() + 1);
    }

    private int f() {
        return ag.a(this.f49517d, f.a.IN_APP_UPDATE).b("userConsentCountFlexibleUpdate", 0, false);
    }

    private void a(int i2) {
        ag.a(this.f49517d, f.a.IN_APP_UPDATE).a("userConsentCountFlexibleUpdate", i2, false);
    }

    private void g() {
        this.f49515b = new c() {
            public final /* synthetic */ void onStateUpdate(Object obj) {
                com.google.android.play.core.a.b bVar = (com.google.android.play.core.a.b) obj;
                if (bVar.a() == 11) {
                    a.b(a.this);
                } else if (bVar.a() == 4) {
                    a.this.f49514a.b(a.this.f49515b);
                } else {
                    new StringBuilder("installStatus = ").append(bVar.a());
                }
            }
        };
        this.f49514a.a(this.f49515b);
        this.f49514a.a().a(new com.google.android.play.core.e.c<com.google.android.play.core.appupdate.a>() {
            public final /* synthetic */ void onSuccess(Object obj) {
                com.google.android.play.core.appupdate.a aVar = (com.google.android.play.core.appupdate.a) obj;
                if (aVar.c() == 2 && aVar.a(0)) {
                    a.this.f49516c = aVar;
                    a.this.b();
                } else if (aVar.c() == 3) {
                    a.this.f49516c = aVar;
                    if (aVar.d() == 2) {
                        a.this.b(3);
                    }
                } else {
                    a.this.f49516c = null;
                    a.this.b(1);
                }
                if (aVar != null && aVar.d() == 11 && a.this.f49515b != null) {
                    a.b(a.this);
                }
            }
        }).a((com.google.android.play.core.e.b) new com.google.android.play.core.e.b() {
            public final void onFailure(Exception exc) {
                q.b(exc.getMessage());
                a.this.b(0);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        C0882a aVar = this.f49521h;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    static /* synthetic */ void b(a aVar) {
        final Snackbar a2 = Snackbar.a(aVar.f49517d.getWindow().getDecorView().getRootView(), (CharSequence) aVar.f49517d.getResources().getString(R.string.snackbar_update_message), -2);
        FrameLayout frameLayout = (FrameLayout) a2.b();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getChildAt(0).getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin + 100);
        frameLayout.getChildAt(0).setLayoutParams(layoutParams);
        a2.a((CharSequence) aVar.f49517d.getResources().getString(R.string.snackbar_restart), (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f49514a.b();
                a2.d();
            }
        });
        a2.c();
    }
}
