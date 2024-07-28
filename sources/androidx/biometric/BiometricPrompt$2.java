package androidx.biometric;

import android.os.Handler;
import androidx.biometric.c;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;

class BiometricPrompt$2 implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f14458a;

    BiometricPrompt$2(c cVar) {
        this.f14458a = cVar;
    }

    /* access modifiers changed from: package-private */
    @aa(a = k.a.ON_PAUSE)
    public void onPause() {
        c cVar = this.f14458a;
        if (!(cVar.a() != null && cVar.a().isChangingConfigurations())) {
            if (!c.c() || this.f14458a.f14486e == null) {
                if (!(this.f14458a.f14484c == null || this.f14458a.f14485d == null)) {
                    e eVar = this.f14458a.f14484c;
                    f fVar = this.f14458a.f14485d;
                    eVar.b();
                    fVar.a(0);
                }
            } else if (!this.f14458a.f14486e.d()) {
                this.f14458a.f14486e.b();
            } else if (!this.f14458a.f14487f) {
                this.f14458a.f14487f = true;
            } else {
                this.f14458a.f14486e.b();
            }
            d dVar = d.f14499a;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @aa(a = k.a.ON_RESUME)
    public void onResume() {
        d dVar;
        this.f14458a.f14486e = c.c() ? (a) this.f14458a.b().c("BiometricFragment") : null;
        if (!c.c() || this.f14458a.f14486e == null) {
            c cVar = this.f14458a;
            cVar.f14484c = (e) cVar.b().c("FingerprintDialogFragment");
            c cVar2 = this.f14458a;
            cVar2.f14485d = (f) cVar2.b().c("FingerprintHelperFragment");
            if (this.f14458a.f14484c != null) {
                this.f14458a.f14484c.f14510c = this.f14458a.f14489h;
            }
            if (this.f14458a.f14485d != null) {
                this.f14458a.f14485d.a(this.f14458a.f14482a, this.f14458a.f14483b);
                if (this.f14458a.f14484c != null) {
                    this.f14458a.f14485d.a((Handler) this.f14458a.f14484c.f14508a);
                }
            }
        } else {
            this.f14458a.f14486e.a(this.f14458a.f14482a, this.f14458a.f14489h, this.f14458a.f14483b);
        }
        c cVar3 = this.f14458a;
        if (!cVar3.f14488g && (dVar = d.f14499a) != null) {
            int i2 = dVar.f14505g;
            if (i2 == 1) {
                cVar3.f14483b.a(new c.b((c.C0197c) null));
                dVar.f14506h = 0;
                dVar.b();
            } else if (i2 == 2) {
                cVar3.f14483b.a(10, cVar3.a() != null ? cVar3.a().getString(R.string.generic_error_user_canceled) : "");
                dVar.f14506h = 0;
                dVar.b();
            }
        }
        this.f14458a.a(false);
    }
}
