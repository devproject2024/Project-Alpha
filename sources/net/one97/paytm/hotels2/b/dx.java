package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class dx extends dw implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29542f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29543g = null;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f29544h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f29545i;
    private final View.OnClickListener j;
    private long k;

    public dx(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29542f, f29543g));
    }

    private dx(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[2], objArr[4]);
        this.k = -1;
        this.f29537a.setTag((Object) null);
        this.f29538b.setTag((Object) null);
        this.f29544h = objArr[0];
        this.f29544h.setTag((Object) null);
        this.f29539c.setTag((Object) null);
        this.f29540d.setTag((Object) null);
        setRootTag(view);
        this.f29545i = new b(this, 2);
        this.j = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.k != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((RoomSelectionViewModel) obj);
        return true;
    }

    public final void a(RoomSelectionViewModel roomSelectionViewModel) {
        this.f29541e = roomSelectionViewModel;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return c(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.k     // Catch:{ all -> 0x0079 }
            r2 = 0
            r14.k = r2     // Catch:{ all -> 0x0079 }
            monitor-exit(r14)     // Catch:{ all -> 0x0079 }
            net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel r4 = r14.f29541e
            r5 = 15
            long r5 = r5 & r0
            r7 = 14
            r9 = 13
            r11 = 0
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x004e
            long r5 = r0 & r9
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0031
            if (r4 == 0) goto L_0x0023
            androidx.lifecycle.y r5 = r4.get_title()
            goto L_0x0024
        L_0x0023:
            r5 = r11
        L_0x0024:
            r6 = 0
            r14.updateLiveDataRegistration(r6, r5)
            if (r5 == 0) goto L_0x0031
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0032
        L_0x0031:
            r5 = r11
        L_0x0032:
            long r12 = r0 & r7
            int r6 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x004f
            if (r4 == 0) goto L_0x003f
            androidx.lifecycle.y r4 = r4.get_subHeaderText()
            goto L_0x0040
        L_0x003f:
            r4 = r11
        L_0x0040:
            r6 = 1
            r14.updateLiveDataRegistration(r6, r4)
            if (r4 == 0) goto L_0x004f
            java.lang.Object r4 = r4.getValue()
            r11 = r4
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x004f
        L_0x004e:
            r5 = r11
        L_0x004f:
            r12 = 8
            long r12 = r12 & r0
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0064
            android.widget.ImageView r4 = r14.f29537a
            android.view.View$OnClickListener r6 = r14.j
            r4.setOnClickListener(r6)
            android.widget.ImageView r4 = r14.f29538b
            android.view.View$OnClickListener r6 = r14.f29545i
            r4.setOnClickListener(r6)
        L_0x0064:
            long r9 = r9 & r0
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x006e
            android.widget.TextView r4 = r14.f29539c
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r5)
        L_0x006e:
            long r0 = r0 & r7
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0078
            android.widget.TextView r0 = r14.f29540d
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x0078:
            return
        L_0x0079:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0079 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.dx.executeBindings():void");
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            RoomSelectionViewModel roomSelectionViewModel = this.f29541e;
            if (roomSelectionViewModel != null) {
                z = true;
            }
            if (z) {
                roomSelectionViewModel.onBackPressed();
            }
        } else if (i2 == 2) {
            RoomSelectionViewModel roomSelectionViewModel2 = this.f29541e;
            if (roomSelectionViewModel2 != null) {
                z = true;
            }
            if (z) {
                roomSelectionViewModel2.onEditPressed();
            }
        }
    }
}
