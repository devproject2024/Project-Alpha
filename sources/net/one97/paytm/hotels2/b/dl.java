package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class dl extends dk implements b.a {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f29491i;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private final TextView l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private long o;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(9);
        f29491i = bVar;
        bVar.a(0, new String[]{"h4_rb_promo_code_apply"}, new int[]{5}, new int[]{R.layout.h4_rb_promo_code_apply});
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.lottieAnim, 6);
        j.put(R.id.tv_title, 7);
        j.put(R.id.line_one, 8);
    }

    public dl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, f29491i, j));
    }

    private dl(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[8], objArr[6], objArr[1], objArr[2], objArr[7], objArr[3], objArr[5]);
        this.o = -1;
        this.k = objArr[0];
        this.k.setTag((Object) null);
        this.l = objArr[4];
        this.l.setTag((Object) null);
        this.f29485c.setTag((Object) null);
        this.f29486d.setTag((Object) null);
        this.f29488f.setTag((Object) null);
        setRootTag(view);
        this.m = new b(this, 2);
        this.n = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 16;
        }
        this.f29489g.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f29489g.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.o     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.hotels2.b.di r0 = r6.f29489g
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.dl.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((ReviewViewModel) obj);
        return true;
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.f29490h = reviewViewModel;
        synchronized (this) {
            this.o |= 8;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f29489g.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b(i3);
        }
        if (i2 == 1) {
            return c(i3);
        }
        if (i2 != 2) {
            return false;
        }
        return d(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.o |= 4;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        int i2;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.o;
            this.o = 0;
        }
        ReviewViewModel reviewViewModel = this.f29490h;
        String str = null;
        int i3 = 0;
        if ((27 & j2) != 0) {
            int i4 = ((j2 & 25) > 0 ? 1 : ((j2 & 25) == 0 ? 0 : -1));
            if (i4 != 0) {
                y<Boolean> yVar = reviewViewModel != null ? reviewViewModel.get_isApplyPromoCodeViewVisible() : null;
                updateLiveDataRegistration(0, yVar);
                boolean safeUnbox = ViewDataBinding.safeUnbox(yVar != null ? yVar.getValue() : null);
                if (i4 != 0) {
                    if (safeUnbox) {
                        j4 = j2 | 64;
                        j3 = 256;
                    } else {
                        j4 = j2 | 32;
                        j3 = 128;
                    }
                    j2 = j4 | j3;
                }
                int i5 = 8;
                i2 = safeUnbox ? 0 : 8;
                if (!safeUnbox) {
                    i5 = 0;
                }
                i3 = i5;
            } else {
                i2 = 0;
            }
            if ((j2 & 26) != 0) {
                y<String> morePromocodeText = reviewViewModel != null ? reviewViewModel.getMorePromocodeText() : null;
                updateLiveDataRegistration(1, morePromocodeText);
                if (morePromocodeText != null) {
                    str = morePromocodeText.getValue();
                }
            }
        } else {
            i2 = 0;
        }
        if ((16 & j2) != 0) {
            this.l.setOnClickListener(this.m);
            this.f29486d.setOnClickListener(this.n);
        }
        if ((j2 & 25) != 0) {
            this.l.setVisibility(i3);
            this.f29485c.setVisibility(i3);
            this.f29486d.setVisibility(i3);
            this.f29488f.setVisibility(i3);
            this.f29489g.getRoot().setVisibility(i2);
        }
        if ((j2 & 26) != 0) {
            d.a(this.f29486d, (CharSequence) str);
        }
        if ((j2 & 24) != 0) {
            this.f29489g.a(reviewViewModel);
        }
        executeBindingsOn(this.f29489g);
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            ReviewViewModel reviewViewModel = this.f29490h;
            if (reviewViewModel != null) {
                z = true;
            }
            if (z) {
                reviewViewModel.onMorePromoCodePressed();
            }
        } else if (i2 == 2) {
            ReviewViewModel reviewViewModel2 = this.f29490h;
            if (reviewViewModel2 != null) {
                z = true;
            }
            if (z) {
                reviewViewModel2.onMorePromoCodePressed();
            }
        }
    }
}
