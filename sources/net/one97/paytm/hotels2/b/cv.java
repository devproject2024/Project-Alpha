package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.c.a.a;

public final class cv extends cu implements a.C0508a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29416e;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29417f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29418g;

    /* renamed from: h  reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f29419h;

    /* renamed from: i  reason: collision with root package name */
    private long f29420i;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(4);
        f29416e = bVar;
        bVar.a(0, new String[]{"h4_rb_gst_info"}, new int[]{2}, new int[]{R.layout.h4_rb_gst_info});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29417f = sparseIntArray;
        sparseIntArray.put(R.id.line, 3);
    }

    public cv(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29416e, f29417f));
    }

    private cv(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[2]);
        this.f29420i = -1;
        this.f29412a.setTag((Object) null);
        this.f29418g = objArr[0];
        this.f29418g.setTag((Object) null);
        setRootTag(view);
        this.f29419h = new a(this);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29420i = 8;
        }
        this.f29414c.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f29414c.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.f29420i     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.hotels2.b.cw r0 = r6.f29414c
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.cv.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.hotels2.a.t != i2) {
            return false;
        }
        a((ReviewViewModel) obj);
        return true;
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.f29415d = reviewViewModel;
        synchronized (this) {
            this.f29420i |= 4;
        }
        notifyPropertyChanged(net.one97.paytm.hotels2.a.t);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f29414c.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return b(i3);
    }

    private boolean a(int i2) {
        if (i2 != net.one97.paytm.hotels2.a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29420i |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.hotels2.a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29420i |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        int i2;
        int i3;
        CheckBox checkBox;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f29420i;
            this.f29420i = 0;
        }
        ReviewViewModel reviewViewModel = this.f29415d;
        int i4 = 0;
        int i5 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
        if (i5 != 0) {
            Boolean bool = null;
            y<Boolean> yVar = reviewViewModel != null ? reviewViewModel.get_hotelGSTUserEnabled() : null;
            updateLiveDataRegistration(0, yVar);
            if (yVar != null) {
                bool = yVar.getValue();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i5 != 0) {
                if (safeUnbox) {
                    j3 = j | 32;
                    j2 = 128;
                } else {
                    j3 = j | 16;
                    j2 = 64;
                }
                j = j3 | j2;
            }
            if (!safeUnbox) {
                i4 = 8;
            }
            if (safeUnbox) {
                checkBox = this.f29412a;
                i3 = R.color.color_00aced;
            } else {
                checkBox = this.f29412a;
                i3 = R.color.color_222222;
            }
            i2 = getColorFromResource(checkBox, i3);
        } else {
            i2 = 0;
        }
        if ((13 & j) != 0) {
            this.f29412a.setTextColor(i2);
            this.f29414c.getRoot().setVisibility(i4);
        }
        if ((8 & j) != 0) {
            this.f29412a.setOnCheckedChangeListener(this.f29419h);
        }
        if ((j & 12) != 0) {
            this.f29414c.a(reviewViewModel);
        }
        executeBindingsOn(this.f29414c);
    }

    public final void a(boolean z) {
        ReviewViewModel reviewViewModel = this.f29415d;
        if (reviewViewModel != null) {
            reviewViewModel.isUserGSTEnabled(z);
        }
    }
}
