package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.SRPModifyViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.b;

public final class at extends as implements a.C0456a {
    private static final ViewDataBinding.b M = null;
    private static final SparseIntArray N;
    private final LinearLayout O;
    private final View.OnClickListener P;
    private final View.OnClickListener Q;
    private final View.OnClickListener R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private final View.OnClickListener U;
    private final View.OnClickListener V;
    private final View.OnClickListener W;
    private final View.OnClickListener X;
    private final View.OnClickListener Y;
    private long Z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        N = sparseIntArray;
        sparseIntArray.put(R.id.label_depart_on, 31);
        N.put(R.id.label_travellers, 32);
        N.put(R.id.label_class, 33);
        N.put(R.id.separator, 34);
        N.put(R.id.flight_non_stop_checkbox, 35);
        N.put(R.id.seat_type_text, 36);
    }

    public at(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 37, M, N));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private at(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[27], objArr[6], objArr[14], objArr[15], objArr[16], objArr[17], objArr[11], objArr[12], objArr[10], objArr[20], objArr[3], objArr[28], objArr[35], objArr[2], objArr[4], objArr[33], objArr[31], objArr[19], objArr[32], objArr[0], objArr[25], objArr[5], objArr[29], objArr[18], objArr[22], objArr[21], objArr[23], objArr[24], objArr[36], objArr[13], objArr[34], objArr[9], objArr[7], objArr[8], objArr[1], objArr[26]);
        this.Z = -1;
        this.f23627a.setTag((Object) null);
        this.f23628b.setTag((Object) null);
        this.f23629c.setTag((Object) null);
        this.f23630d.setTag((Object) null);
        this.f23631e.setTag((Object) null);
        this.f23632f.setTag((Object) null);
        this.f23633g.setTag((Object) null);
        this.f23634h.setTag((Object) null);
        this.f23635i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.r.setTag(this.r.getResources().getString(R.string.flight_select_return_date));
        this.t.setTag((Object) null);
        this.O = objArr[30];
        this.O.setTag((Object) null);
        this.u.setTag((Object) null);
        this.v.setTag((Object) null);
        this.w.setTag((Object) null);
        this.x.setTag((Object) null);
        this.y.setTag((Object) null);
        this.z.setTag((Object) null);
        this.A.setTag((Object) null);
        this.B.setTag((Object) null);
        this.D.setTag((Object) null);
        this.F.setTag((Object) null);
        this.G.setTag((Object) null);
        this.H.setTag((Object) null);
        this.I.setTag((Object) null);
        this.J.setTag((Object) null);
        setRootTag(view);
        this.P = new a(this, 6);
        this.Q = new a(this, 2);
        this.R = new a(this, 9);
        this.S = new a(this, 5);
        this.T = new a(this, 1);
        this.U = new a(this, 8);
        this.V = new a(this, 4);
        this.W = new a(this, 10);
        this.X = new a(this, 7);
        this.Y = new a(this, 3);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.Z = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.Z != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.s == i2) {
            a((SRPSharedViewModel) obj);
        } else if (com.travel.flight.a.f23479c != i2) {
            return false;
        } else {
            a((SRPModifyViewModel) obj);
        }
        return true;
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.K = sRPSharedViewModel;
        synchronized (this) {
            this.Z |= 2;
        }
        notifyPropertyChanged(com.travel.flight.a.s);
        super.requestRebind();
    }

    public final void a(SRPModifyViewModel sRPModifyViewModel) {
        this.L = sRPModifyViewModel;
        synchronized (this) {
            this.Z |= 4;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.Z |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        CJRFlightSearchInput cJRFlightSearchInput;
        String str5;
        int i3;
        String str6;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        long j2;
        long j3;
        synchronized (this) {
            j = this.Z;
            this.Z = 0;
        }
        SRPSharedViewModel sRPSharedViewModel = this.K;
        String str7 = null;
        int i4 = ((j & 11) > 0 ? 1 : ((j & 11) == 0 ? 0 : -1));
        if (i4 != 0) {
            y<CJRFlightSearchInput> copiedSearchInput = sRPSharedViewModel != null ? sRPSharedViewModel.getCopiedSearchInput() : null;
            updateLiveDataRegistration(0, copiedSearchInput);
            CJRFlightSearchInput value = copiedSearchInput != null ? copiedSearchInput.getValue() : null;
            if (value != null) {
                bVar4 = value.getDestination();
                bVar3 = value.getSource();
                bVar2 = value.getDestination();
                str3 = value.getReturnDate();
                bVar = value.getSource();
                str6 = value.getDate();
            } else {
                bVar4 = null;
                bVar3 = null;
                bVar2 = null;
                str3 = null;
                bVar = null;
                str6 = null;
            }
            str5 = bVar4 != null ? bVar4.getCityName() : null;
            String cityName = bVar3 != null ? bVar3.getCityName() : null;
            if (bVar2 != null) {
                str4 = bVar2.getShortCityName();
            } else {
                str4 = null;
            }
            boolean z = str3 != null;
            if (i4 != 0) {
                if (z) {
                    j3 = j | 32;
                    j2 = 128;
                } else {
                    j3 = j | 16;
                    j2 = 64;
                }
                j = j3 | j2;
            }
            if (bVar != null) {
                str7 = bVar.getShortCityName();
            }
            i2 = z ? 0 : 4;
            str2 = cityName;
            str = str7;
            str7 = str6;
            cJRFlightSearchInput = value;
            i3 = z ? 8 : 0;
        } else {
            str5 = null;
            cJRFlightSearchInput = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
        }
        if ((j & 8) != 0) {
            this.f23627a.setOnClickListener(this.U);
            this.f23628b.setOnClickListener(this.Q);
            this.f23629c.setOnClickListener(this.S);
            this.f23635i.setOnClickListener(this.V);
            this.o.setOnClickListener(this.T);
            this.O.setOnClickListener(this.W);
            this.u.setOnClickListener(this.X);
            this.w.setOnClickListener(this.R);
            this.x.setOnClickListener(this.P);
            this.G.setOnClickListener(this.Y);
        }
        if ((j & 11) != 0) {
            SRPModifyViewModel.setFlightJourneyDates(this.f23630d, str7, 0);
            SRPModifyViewModel.setFlightJourneyDates(this.f23631e, str7, 1);
            SRPModifyViewModel.setFlightJourneyDates(this.f23632f, str7, 2);
            d.a((TextView) this.f23633g, (CharSequence) str4);
            d.a((TextView) this.f23634h, (CharSequence) str5);
            this.j.setVisibility(i3);
            d.a((TextView) this.k, (CharSequence) str5);
            SRPModifyViewModel.setClassInfo(this.l, cJRFlightSearchInput);
            SRPModifyViewModel.setRouteHeader(this.n, cJRFlightSearchInput);
            this.r.setVisibility(i2);
            c.a((TextView) this.v, cJRFlightSearchInput);
            SRPModifyViewModel.setFlightJourneyDates(this.y, str3, 0);
            this.z.setVisibility(i2);
            SRPModifyViewModel.setFlightJourneyDates(this.A, str3, 1);
            SRPModifyViewModel.setFlightJourneyDates(this.B, str3, 2);
            SRPModifyViewModel.setRouteSeparator(this.D, cJRFlightSearchInput);
            String str8 = str2;
            d.a((TextView) this.F, (CharSequence) str8);
            d.a((TextView) this.H, (CharSequence) str);
            d.a((TextView) this.I, (CharSequence) str8);
            SRPModifyViewModel.setPaxInfo(this.J, cJRFlightSearchInput);
        }
    }

    public final void a(int i2, View view) {
        boolean z = true;
        switch (i2) {
            case 1:
                SRPSharedViewModel sRPSharedViewModel = this.K;
                if (sRPSharedViewModel == null) {
                    z = false;
                }
                if (z) {
                    sRPSharedViewModel.onBackPressed();
                    return;
                }
                return;
            case 2:
                SRPSharedViewModel sRPSharedViewModel2 = this.K;
                if (sRPSharedViewModel2 == null) {
                    z = false;
                }
                if (z) {
                    sRPSharedViewModel2.onBackPressed();
                    return;
                }
                return;
            case 3:
                SRPModifyViewModel sRPModifyViewModel = this.L;
                if (sRPModifyViewModel == null) {
                    z = false;
                }
                if (z) {
                    sRPModifyViewModel.onSourceCityClick();
                    return;
                }
                return;
            case 4:
                SRPModifyViewModel sRPModifyViewModel2 = this.L;
                if (sRPModifyViewModel2 == null) {
                    z = false;
                }
                if (z) {
                    sRPModifyViewModel2.onDestinationCityClick();
                    return;
                }
                return;
            case 5:
                SRPModifyViewModel sRPModifyViewModel3 = this.L;
                if (sRPModifyViewModel3 == null) {
                    z = false;
                }
                if (z && view != null) {
                    view.getContext();
                    sRPModifyViewModel3.onDepartureDateClick(view.getContext());
                    return;
                }
                return;
            case 6:
                SRPModifyViewModel sRPModifyViewModel4 = this.L;
                if (sRPModifyViewModel4 == null) {
                    z = false;
                }
                if (z) {
                    sRPModifyViewModel4.onReturnDateClick();
                    return;
                }
                return;
            case 7:
                SRPModifyViewModel sRPModifyViewModel5 = this.L;
                if (sRPModifyViewModel5 == null) {
                    z = false;
                }
                if (z && view != null) {
                    view.getContext();
                    sRPModifyViewModel5.onPassengerInfoClick(view.getContext());
                    return;
                }
                return;
            case 8:
                SRPModifyViewModel sRPModifyViewModel6 = this.L;
                if (sRPModifyViewModel6 == null) {
                    z = false;
                }
                if (z && view != null) {
                    view.getContext();
                    sRPModifyViewModel6.onPassengerInfoClick(view.getContext());
                    return;
                }
                return;
            case 9:
                SRPModifyViewModel sRPModifyViewModel7 = this.L;
                if (sRPModifyViewModel7 == null) {
                    z = false;
                }
                if (z) {
                    sRPModifyViewModel7.onSearchFlightClick(getRoot().getContext());
                    return;
                }
                return;
            case 10:
                SRPSharedViewModel sRPSharedViewModel3 = this.K;
                if (sRPSharedViewModel3 == null) {
                    z = false;
                }
                if (z) {
                    sRPSharedViewModel3.onBackPressed();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
