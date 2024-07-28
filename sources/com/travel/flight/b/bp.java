package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.a.ae;
import com.travel.flight.flightSRPV2.a.t;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import java.util.List;

public final class bp extends bo implements a.C0456a {
    private static final ViewDataBinding.b m = null;
    private static final SparseIntArray n;
    private final View o;
    private final View p;
    private final View.OnClickListener q;
    private long r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.view_top_shadow, 5);
        n.put(R.id.txt_sort_header, 6);
        n.put(R.id.separator1, 7);
        n.put(R.id.container_filter_options, 8);
        n.put(R.id.txt_filter_header, 9);
        n.put(R.id.separator2, 10);
        n.put(R.id.container_filter_non_stop_flights, 11);
        n.put(R.id.txt_filter_non_stop_flights, 12);
    }

    public bp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 13, m, n));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[11], objArr[8], objArr[1], objArr[0], objArr[7], objArr[10], objArr[4], objArr[9], objArr[12], objArr[6], objArr[5]);
        this.r = -1;
        this.f23723c.setTag((Object) null);
        this.f23724d.setTag((Object) null);
        this.o = objArr[2];
        this.o.setTag((Object) null);
        this.p = objArr[3];
        this.p.setTag((Object) null);
        this.f23727g.setTag((Object) null);
        setRootTag(view);
        this.q = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.r = 32;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.r != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.f23479c != i2) {
            return false;
        }
        a((DRTListViewModel) obj);
        return true;
    }

    public final void a(DRTListViewModel dRTListViewModel) {
        this.l = dRTListViewModel;
        synchronized (this) {
            this.r |= 16;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 == 1) {
            return b(i3);
        }
        if (i2 == 2) {
            return c(i3);
        }
        if (i2 != 3) {
            return false;
        }
        return d(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.r |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.r |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.r |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.r |= 8;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        List<x> list;
        ae aeVar;
        ae aeVar2;
        List<x> list2;
        y<List<x>> yVar;
        y<List<x>> yVar2;
        y<ae> yVar3;
        y<ae> yVar4;
        synchronized (this) {
            j = this.r;
            this.r = 0;
        }
        DRTListViewModel dRTListViewModel = this.l;
        List<x> list3 = null;
        if ((63 & j) != 0) {
            SRPSharedViewModel parentViewModel = dRTListViewModel != null ? dRTListViewModel.getParentViewModel() : null;
            if ((j & 57) != 0) {
                if (parentViewModel != null) {
                    yVar4 = parentViewModel.getRoundTripOnwardSortOption();
                    yVar3 = parentViewModel.getRoundTripReturnSortOption();
                } else {
                    yVar4 = null;
                    yVar3 = null;
                }
                updateLiveDataRegistration(0, yVar4);
                updateLiveDataRegistration(3, yVar3);
                aeVar2 = yVar4 != null ? yVar4.getValue() : null;
                aeVar = yVar3 != null ? yVar3.getValue() : null;
            } else {
                aeVar2 = null;
                aeVar = null;
            }
            if ((j & 54) != 0) {
                if (parentViewModel != null) {
                    yVar = parentViewModel.getReturnFilterList();
                    yVar2 = parentViewModel.getOnwardFilterList();
                } else {
                    yVar2 = null;
                    yVar = null;
                }
                updateLiveDataRegistration(1, yVar);
                updateLiveDataRegistration(2, yVar2);
                List value = yVar != null ? yVar.getValue() : null;
                if (yVar2 != null) {
                    list3 = yVar2.getValue();
                }
                list2 = t.a((List<? extends x>) value);
                list = list3;
                list3 = t.a((List<? extends x>) list3);
            } else {
                list2 = null;
                list = null;
            }
        } else {
            list2 = null;
            aeVar2 = null;
            aeVar = null;
            list = null;
        }
        if ((32 & j) != 0) {
            this.f23723c.setOnClickListener(this.q);
        }
        if ((57 & j) != 0) {
            c.a(this.o, aeVar2, aeVar);
        }
        if ((j & 54) != 0) {
            c.a(this.p, (List<? extends x>) list3, (List<? extends x>) list2);
        }
        if ((j & 52) != 0) {
            c.a((CompoundButton) this.f23727g, (List<? extends x>) list);
        }
    }

    public final void a(int i2, View view) {
        DRTListViewModel dRTListViewModel = this.l;
        boolean z = true;
        if (dRTListViewModel != null) {
            SRPSharedViewModel parentViewModel = dRTListViewModel.getParentViewModel();
            if (parentViewModel == null) {
                z = false;
            }
            if (z) {
                parentViewModel.onSortOptionsRequested(false);
            }
        }
    }
}
