package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.ui.feed.actions.b;

public final class t extends s {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f34222h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f34223i;
    private final RelativeLayout j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34223i = sparseIntArray;
        sparseIntArray.put(R.id.feedback_header, 1);
        f34223i.put(R.id.close, 2);
        f34223i.put(R.id.feedback_info, 3);
        f34223i.put(R.id.scrollview, 4);
        f34223i.put(R.id.flowlayout, 5);
        f34223i.put(R.id.sendfeedback, 6);
    }

    public t(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f34222h, f34223i));
    }

    private t(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1], objArr[3], objArr[5], objArr[4], objArr[6]);
        this.k = -1;
        this.j = objArr[0];
        this.j.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 2;
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
        if (a.q != i2) {
            return false;
        }
        this.f34221g = (b) obj;
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.k = 0;
        }
    }
}
