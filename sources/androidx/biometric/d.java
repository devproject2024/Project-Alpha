package androidx.biometric;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import androidx.biometric.c;
import java.util.concurrent.Executor;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    static d f14499a;

    /* renamed from: b  reason: collision with root package name */
    int f14500b;

    /* renamed from: c  reason: collision with root package name */
    a f14501c;

    /* renamed from: d  reason: collision with root package name */
    Executor f14502d;

    /* renamed from: e  reason: collision with root package name */
    c.a f14503e;

    /* renamed from: f  reason: collision with root package name */
    boolean f14504f;

    /* renamed from: g  reason: collision with root package name */
    int f14505g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f14506h = 0;

    /* renamed from: i  reason: collision with root package name */
    private e f14507i;
    private f j;
    private DialogInterface.OnClickListener k;

    private d() {
    }

    static d a() {
        if (f14499a == null) {
            f14499a = new d();
        }
        return f14499a;
    }

    /* access modifiers changed from: package-private */
    public final void a(e eVar, f fVar) {
        this.f14507i = eVar;
        this.j = fVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(Executor executor, DialogInterface.OnClickListener onClickListener, c.a aVar) {
        f fVar;
        this.f14502d = executor;
        this.k = onClickListener;
        this.f14503e = aVar;
        if (this.f14501c == null || Build.VERSION.SDK_INT < 28) {
            e eVar = this.f14507i;
            if (eVar != null && (fVar = this.j) != null) {
                eVar.f14510c = onClickListener;
                fVar.a(executor, aVar);
                this.j.a((Handler) this.f14507i.f14508a);
                return;
            }
            return;
        }
        this.f14501c.a(executor, onClickListener, aVar);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        int i2 = this.f14506h;
        if (i2 != 2) {
            if (i2 == 1) {
                this.f14506h = 0;
                return;
            }
            this.f14500b = 0;
            this.f14501c = null;
            this.f14507i = null;
            this.j = null;
            this.f14502d = null;
            this.k = null;
            this.f14503e = null;
            this.f14505g = 0;
            this.f14504f = false;
            f14499a = null;
        }
    }
}
