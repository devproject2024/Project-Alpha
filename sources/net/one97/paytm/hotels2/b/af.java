package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class af extends ae implements b.a {
    private static final ViewDataBinding.b m = null;
    private static final SparseIntArray n;
    private final ConstraintLayout o;
    private final View.OnClickListener p;
    private long q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 4);
        n.put(R.id.iv_close, 5);
        n.put(R.id.rv_room_config, 6);
        n.put(R.id.v_line, 7);
        n.put(R.id.tv_tax, 8);
        n.put(R.id.rv_room_config_tax, 9);
        n.put(R.id.v_line_one, 10);
        n.put(R.id.tv_total_text, 11);
    }

    public af(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 12, m, n));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private af(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[5], objArr[6], objArr[9], objArr[1], objArr[8], objArr[4], objArr[11], objArr[2], objArr[7], objArr[10]);
        this.q = -1;
        this.f29122a.setTag((Object) null);
        this.o = objArr[0];
        this.o.setTag((Object) null);
        this.f29126e.setTag((Object) null);
        this.f29130i.setTag((Object) null);
        setRootTag(view);
        this.p = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.q = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.q != 0) {
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
        this.l = roomSelectionViewModel;
        synchronized (this) {
            this.q |= 4;
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
            this.q |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.q |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.q;
            this.q = 0;
        }
        double d2 = 0.0d;
        RoomSelectionViewModel roomSelectionViewModel = this.l;
        String str = null;
        if ((15 & j) != 0) {
            if ((j & 13) != 0) {
                y<Double> yVar = roomSelectionViewModel != null ? roomSelectionViewModel.get_selectedRoomFinalPriceWithTax() : null;
                updateLiveDataRegistration(0, yVar);
                d2 = ViewDataBinding.safeUnbox(yVar != null ? yVar.getValue() : null);
            }
            if ((j & 14) != 0) {
                y<String> yVar2 = roomSelectionViewModel != null ? roomSelectionViewModel.get_selectedRoomOptionTitle() : null;
                updateLiveDataRegistration(1, yVar2);
                if (yVar2 != null) {
                    str = yVar2.getValue();
                }
            }
        }
        if ((8 & j) != 0) {
            this.f29122a.setOnClickListener(this.p);
        }
        if ((j & 14) != 0) {
            d.a(this.f29126e, (CharSequence) str);
        }
        if ((j & 13) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29130i, d2);
        }
    }

    public final void a(int i2) {
        RoomSelectionViewModel roomSelectionViewModel = this.l;
        if (roomSelectionViewModel != null) {
            roomSelectionViewModel.onContinuePressed();
        }
    }
}
