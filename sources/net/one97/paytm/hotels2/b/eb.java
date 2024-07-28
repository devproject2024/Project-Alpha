package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.service.model.details.RoomOption;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.utils.g;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;
import net.one97.paytm.hotels2.c.a.d;

public final class eb extends ea implements b.a, d.a {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f29570h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f29571i = null;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private final Runnable l;
    private long m;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public eb(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29570h, f29571i));
    }

    private eb(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[3], objArr[1], objArr[2]);
        this.m = -1;
        this.f29563a.setTag((Object) null);
        this.f29564b.setTag((Object) null);
        this.f29565c.setTag((Object) null);
        this.f29566d.setTag((Object) null);
        setRootTag(view);
        this.j = new b(this, 2);
        this.k = new b(this, 3);
        this.l = new d(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.Y == i2) {
            a((RoomOption) obj);
        } else if (a.af == i2) {
            a((SubRoomOptions) obj);
        } else if (a.t != i2) {
            return false;
        } else {
            a((RoomSelectionViewModel) obj);
        }
        return true;
    }

    public final void a(RoomOption roomOption) {
        this.f29569g = roomOption;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(a.Y);
        super.requestRebind();
    }

    public final void a(SubRoomOptions subRoomOptions) {
        this.f29568f = subRoomOptions;
        synchronized (this) {
            this.m |= 2;
        }
        notifyPropertyChanged(a.af);
        super.requestRebind();
    }

    public final void a(RoomSelectionViewModel roomSelectionViewModel) {
        this.f29567e = roomSelectionViewModel;
        synchronized (this) {
            this.m |= 4;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.m;
            this.m = 0;
        }
        if ((j2 & 8) != 0) {
            this.f29564b.setOnClickListener(this.k);
            g.a(this.f29565c, this.l);
            this.f29566d.setOnClickListener(this.j);
        }
    }

    public final void a(int i2) {
        boolean z = true;
        if (i2 == 2) {
            RoomOption roomOption = this.f29569g;
            SubRoomOptions subRoomOptions = this.f29568f;
            RoomSelectionViewModel roomSelectionViewModel = this.f29567e;
            if (roomSelectionViewModel == null) {
                z = false;
            }
            if (z) {
                roomSelectionViewModel.onRoomSelect(subRoomOptions, roomOption);
            }
        } else if (i2 == 3) {
            RoomOption roomOption2 = this.f29569g;
            SubRoomOptions subRoomOptions2 = this.f29568f;
            RoomSelectionViewModel roomSelectionViewModel2 = this.f29567e;
            if (roomSelectionViewModel2 == null) {
                z = false;
            }
            if (z) {
                roomSelectionViewModel2.addRoomSelected(subRoomOptions2, roomOption2);
            }
        }
    }

    public final void b(int i2) {
        RoomOption roomOption = this.f29569g;
        SubRoomOptions subRoomOptions = this.f29568f;
        RoomSelectionViewModel roomSelectionViewModel = this.f29567e;
        if (roomSelectionViewModel != null) {
            roomSelectionViewModel.reduceRoomSelected(subRoomOptions, roomOption);
        }
    }
}
