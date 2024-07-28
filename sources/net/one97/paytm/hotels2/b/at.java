package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class at extends as {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29189f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29190g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f29191h;

    /* renamed from: i  reason: collision with root package name */
    private long f29192i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29190g = sparseIntArray;
        sparseIntArray.put(R.id.generic_cta, 4);
    }

    public at(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29189f, f29190g));
    }

    private at(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[3], objArr[2], objArr[1]);
        this.f29192i = -1;
        this.f29185b.setTag((Object) null);
        this.f29186c.setTag((Object) null);
        this.f29187d.setTag((Object) null);
        this.f29191h = objArr[0];
        this.f29191h.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29192i = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29192i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f29088c != i2) {
            return false;
        }
        a((ErrorDialogViewModel) obj);
        return true;
    }

    public final void a(ErrorDialogViewModel errorDialogViewModel) {
        this.f29188e = errorDialogViewModel;
        synchronized (this) {
            this.f29192i |= 2;
        }
        notifyPropertyChanged(a.f29088c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29192i |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r7 = this;
            monitor-enter(r7)
            long r0 = r7.f29192i     // Catch:{ all -> 0x0045 }
            r2 = 0
            r7.f29192i = r2     // Catch:{ all -> 0x0045 }
            monitor-exit(r7)     // Catch:{ all -> 0x0045 }
            net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel r4 = r7.f29188e
            r5 = 7
            long r0 = r0 & r5
            r5 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0031
            if (r4 == 0) goto L_0x0019
            com.travel.utils.l r0 = r4.getErrorObject()
            goto L_0x001a
        L_0x0019:
            r0 = r5
        L_0x001a:
            r1 = 0
            r7.updateLiveDataRegistration(r1, r0)
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.hotel4.utils.b$a r0 = (net.one97.paytm.hotel4.utils.b.a) r0
            goto L_0x0028
        L_0x0027:
            r0 = r5
        L_0x0028:
            if (r0 == 0) goto L_0x0031
            java.lang.String r5 = r0.f28636b
            java.lang.String r1 = r0.f28635a
            java.lang.String r0 = r0.f28637c
            goto L_0x0033
        L_0x0031:
            r0 = r5
            r1 = r0
        L_0x0033:
            if (r6 == 0) goto L_0x0044
            android.widget.TextView r2 = r7.f29185b
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r0)
            android.widget.TextView r0 = r7.f29186c
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
            android.widget.TextView r0 = r7.f29187d
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r1)
        L_0x0044:
            return
        L_0x0045:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0045 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.at.executeBindings():void");
    }
}
