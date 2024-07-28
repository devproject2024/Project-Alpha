package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class dt extends ds implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29524f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29525g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29526h;

    /* renamed from: i  reason: collision with root package name */
    private long f29527i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29525g = sparseIntArray;
        sparseIntArray.put(R.id.iv_thumbs_up, 2);
        f29525g.put(R.id.tv_room_selected_popup, 3);
    }

    public dt(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29524f, f29525g));
    }

    private dt(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[1], objArr[2], objArr[3]);
        this.f29527i = -1;
        this.f29519a.setTag((Object) null);
        this.f29520b.setTag((Object) null);
        setRootTag(view);
        this.f29526h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29527i = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29527i != 0) {
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
        this.f29523e = roomSelectionViewModel;
        synchronized (this) {
            this.f29527i |= 1;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29527i;
            this.f29527i = 0;
        }
        if ((j & 2) != 0) {
            this.f29520b.setOnClickListener(this.f29526h);
        }
    }

    public final void a(int i2) {
        RoomSelectionViewModel roomSelectionViewModel = this.f29523e;
        if (roomSelectionViewModel != null) {
            roomSelectionViewModel.onRoomSelectedPopUpCancelled();
        }
    }
}
