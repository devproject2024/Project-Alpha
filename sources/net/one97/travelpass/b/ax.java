package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class ax extends aw {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f30140i = null;
    private static final SparseIntArray j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.details_image, 1);
        j.put(R.id.header_title, 2);
        j.put(R.id.details_img1, 3);
        j.put(R.id.details_desc1, 4);
        j.put(R.id.details_img2, 5);
        j.put(R.id.details_desc2, 6);
        j.put(R.id.about_page_button, 7);
    }

    public ax(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f30140i, j));
    }

    private ax(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[7], objArr[4], objArr[6], objArr[1], objArr[3], objArr[5], objArr[2]);
        this.k = -1;
        this.f30132a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 1;
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

    public final void executeBindings() {
        synchronized (this) {
            this.k = 0;
        }
    }
}
