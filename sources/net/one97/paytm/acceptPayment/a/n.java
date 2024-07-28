package net.one97.paytm.acceptPayment.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.acceptPayment.R;
import net.one97.paytm.acceptPayment.b;
import net.one97.paytm.acceptPayment.viewModel.c;
import net.one97.paytm.common.widgets.a;

public final class n extends m {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f52017i = null;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private long l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.nonVideoLayout, 4);
        j.put(R.id.channels_web_view, 5);
        j.put(R.id.videoLayout, 6);
        j.put(R.id.no_network_view, 7);
    }

    public n(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 8, f52017i, j));
    }

    private n(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[5], objArr[7], objArr[4], objArr[3], objArr[6], objArr[1]);
        this.l = -1;
        this.f52009a.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.k = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.f52013e.setTag((Object) null);
        this.f52015g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (b.f52043b != i2) {
            return false;
        }
        a((c) obj);
        return true;
    }

    public final void a(c cVar) {
        this.f52016h = cVar;
        synchronized (this) {
            this.l |= 8;
        }
        notifyPropertyChanged(b.f52043b);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 == 1) {
            return b(i3);
        }
        if (i2 != 2) {
            return false;
        }
        return c(i3);
    }

    private boolean a(int i2) {
        if (i2 != b.f52042a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != b.f52042a) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != b.f52042a) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        boolean z;
        int i2;
        int i3;
        y<Integer> yVar;
        y<Boolean> yVar2;
        y<Integer> yVar3;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        c cVar = this.f52016h;
        if ((31 & j2) != 0) {
            if ((j2 & 25) != 0) {
                if (cVar != null) {
                    yVar3 = cVar.f52186b;
                } else {
                    yVar3 = null;
                }
                updateLiveDataRegistration(0, yVar3);
                i2 = ViewDataBinding.safeUnbox(yVar3 != null ? yVar3.getValue() : null);
            } else {
                i2 = 0;
            }
            if ((j2 & 26) != 0) {
                if (cVar != null) {
                    yVar2 = cVar.f52187c;
                } else {
                    yVar2 = null;
                }
                updateLiveDataRegistration(1, yVar2);
                z = ViewDataBinding.safeUnbox(yVar2 != null ? yVar2.getValue() : null);
            } else {
                z = false;
            }
            if ((j2 & 28) != 0) {
                if (cVar != null) {
                    yVar = cVar.f52185a;
                } else {
                    yVar = null;
                }
                updateLiveDataRegistration(2, yVar);
                i3 = ViewDataBinding.safeUnbox(yVar != null ? yVar.getValue() : null);
            } else {
                i3 = 0;
            }
        } else {
            i3 = 0;
            i2 = 0;
            z = false;
        }
        if ((26 & j2) != 0) {
            LottieAnimationView lottieAnimationView = this.f52009a;
            if (z) {
                lottieAnimationView.setVisibility(0);
                a.a(lottieAnimationView);
            } else {
                a.b(lottieAnimationView);
                lottieAnimationView.setVisibility(8);
            }
        }
        if ((j2 & 28) != 0) {
            this.f52013e.setVisibility(i3);
        }
        if ((j2 & 25) != 0) {
            this.f52015g.setVisibility(i2);
        }
    }
}
