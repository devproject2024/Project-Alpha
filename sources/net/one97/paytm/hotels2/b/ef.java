package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.hotel4.service.model.details.RoomOption;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ef extends ee implements b.a {
    private static final ViewDataBinding.b v;
    private static final SparseIntArray w;
    private long A;
    private final ConstraintLayout x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(19);
        v = bVar;
        bVar.a(1, new String[]{"h4_rs_add_reduce_room"}, new int[]{5}, new int[]{R.layout.h4_rs_add_reduce_room});
        SparseIntArray sparseIntArray = new SparseIntArray();
        w = sparseIntArray;
        sparseIntArray.put(R.id.ll_header, 6);
        w.put(R.id.iv_no_room, 7);
        w.put(R.id.rv_images, 8);
        w.put(R.id.tv_title, 9);
        w.put(R.id.tv_addon, 10);
        w.put(R.id.tv_options_refund, 11);
        w.put(R.id.tv_options_no_refund, 12);
        w.put(R.id.tv_room_optn_one, 13);
        w.put(R.id.tv_options_one, 14);
        w.put(R.id.tv_room_optn_two, 15);
        w.put(R.id.tv_price, 16);
        w.put(R.id.tv_per_night, 17);
        w.put(R.id.tv_cashback, 18);
    }

    public ef(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 19, v, w));
    }

    private ef(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[7], objArr[6], objArr[8], objArr[10], objArr[18], objArr[3], objArr[12], objArr[14], objArr[11], objArr[17], objArr[2], objArr[16], objArr[13], objArr[15], objArr[4], objArr[9], objArr[5]);
        this.A = -1;
        this.f29581a.setTag((Object) null);
        this.x = objArr[1];
        this.x.setTag((Object) null);
        this.f29587g.setTag((Object) null);
        this.l.setTag((Object) null);
        this.p.setTag((Object) null);
        setRootTag(view);
        this.y = new b(this, 1);
        this.z = new b(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.A = 16;
        }
        this.r.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.r.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.A     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.hotels2.b.ea r0 = r6.r
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.ef.hasPendingBindings():boolean");
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
        this.u = roomOption;
        synchronized (this) {
            this.A |= 2;
        }
        notifyPropertyChanged(a.Y);
        super.requestRebind();
    }

    public final void a(SubRoomOptions subRoomOptions) {
        this.t = subRoomOptions;
        synchronized (this) {
            this.A |= 4;
        }
        notifyPropertyChanged(a.af);
        super.requestRebind();
    }

    public final void a(RoomSelectionViewModel roomSelectionViewModel) {
        this.s = roomSelectionViewModel;
        synchronized (this) {
            this.A |= 8;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.r.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return b(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.A |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        RoomOption roomOption = this.u;
        SubRoomOptions subRoomOptions = this.t;
        RoomSelectionViewModel roomSelectionViewModel = this.s;
        if ((16 & j) != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29587g);
            this.l.setOnClickListener(this.y);
            this.p.setOnClickListener(this.z);
        }
        if ((20 & j) != 0) {
            this.r.a(subRoomOptions);
        }
        if ((18 & j) != 0) {
            this.r.a(roomOption);
        }
        if ((j & 24) != 0) {
            this.r.a(roomSelectionViewModel);
        }
        executeBindingsOn(this.r);
    }

    public final void a(int i2) {
        boolean z2 = false;
        if (i2 == 1) {
            SubRoomOptions subRoomOptions = this.t;
            RoomSelectionViewModel roomSelectionViewModel = this.s;
            if (roomSelectionViewModel != null) {
                z2 = true;
            }
            if (z2) {
                roomSelectionViewModel.onInclusionsPressed(subRoomOptions);
            }
        } else if (i2 == 2) {
            RoomOption roomOption = this.u;
            SubRoomOptions subRoomOptions2 = this.t;
            RoomSelectionViewModel roomSelectionViewModel2 = this.s;
            if (roomSelectionViewModel2 != null) {
                z2 = true;
            }
            if (z2) {
                roomSelectionViewModel2.onRoomSelect(subRoomOptions2, roomOption);
            }
        }
    }
}
