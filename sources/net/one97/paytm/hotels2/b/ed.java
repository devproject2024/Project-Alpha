package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.service.model.details.RoomOption;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ed extends ec implements b.a {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p;
    private final ConstraintLayout q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private long t;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.tv_options, 3);
        p.put(R.id.tv_title, 4);
        p.put(R.id.tv_addon, 5);
        p.put(R.id.tv_room_optn_one, 6);
        p.put(R.id.tv_options_one, 7);
        p.put(R.id.tv_room_optn_two, 8);
        p.put(R.id.tv_price, 9);
        p.put(R.id.tv_per_night, 10);
        p.put(R.id.tv_cashback, 11);
    }

    public ed(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 12, o, p));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ed(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[11], objArr[3], objArr[7], objArr[10], objArr[9], objArr[6], objArr[8], objArr[1], objArr[2], objArr[4]);
        this.t = -1;
        this.q = objArr[0];
        this.q.setTag((Object) null);
        this.f29580i.setTag((Object) null);
        this.j.setTag((Object) null);
        setRootTag(view);
        this.r = new b(this, 2);
        this.s = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.t = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.t != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.Y == i2) {
            this.n = (RoomOption) obj;
            synchronized (this) {
                this.t |= 1;
            }
            notifyPropertyChanged(a.Y);
            super.requestRebind();
        } else if (a.af == i2) {
            this.m = (SubRoomOptions) obj;
            synchronized (this) {
                this.t |= 2;
            }
            notifyPropertyChanged(a.af);
            super.requestRebind();
        } else if (a.t != i2) {
            return false;
        } else {
            this.l = (RoomSelectionViewModel) obj;
            synchronized (this) {
                this.t |= 4;
            }
            notifyPropertyChanged(a.t);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.t;
            this.t = 0;
        }
        if ((j & 8) != 0) {
            this.f29580i.setOnClickListener(this.s);
            this.j.setOnClickListener(this.r);
        }
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            RoomOption roomOption = this.n;
            SubRoomOptions subRoomOptions = this.m;
            RoomSelectionViewModel roomSelectionViewModel = this.l;
            if (roomSelectionViewModel != null) {
                z = true;
            }
            if (z) {
                roomSelectionViewModel.onRoomSelect(subRoomOptions, roomOption);
            }
        } else if (i2 == 2) {
            RoomOption roomOption2 = this.n;
            SubRoomOptions subRoomOptions2 = this.m;
            RoomSelectionViewModel roomSelectionViewModel2 = this.l;
            if (roomSelectionViewModel2 != null) {
                z = true;
            }
            if (z) {
                roomSelectionViewModel2.onRoomSelect(subRoomOptions2, roomOption2);
            }
        }
    }
}
