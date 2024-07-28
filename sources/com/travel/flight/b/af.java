package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel;

public final class af extends ae implements a.C0456a {
    private static final ViewDataBinding.b V = null;
    private static final SparseIntArray W;
    private final NestedScrollView X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private final View.OnClickListener aa;
    private final View.OnClickListener ab;
    private final View.OnClickListener ac;
    private g ad;
    private long ae;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        W = sparseIntArray;
        sparseIntArray.put(R.id.text_view_refundable_flights_header, 22);
        W.put(R.id.view_separator_1, 23);
        W.put(R.id.text_view_stops_header, 24);
        W.put(R.id.text_view_non_stop_header, 25);
        W.put(R.id.text_view_non_stop_sub, 26);
        W.put(R.id.text_view_one_stop_header, 27);
        W.put(R.id.text_view_one_stop_sub, 28);
        W.put(R.id.text_view_all_flights_header, 29);
        W.put(R.id.view_separator_6, 30);
        W.put(R.id.text_view_flights_duration_title, 31);
        W.put(R.id.text_view_duration_up_to, 32);
        W.put(R.id.layout_duration_seek_bar, 33);
        W.put(R.id.text_view_price_header, 34);
        W.put(R.id.layout_price_seek_bar, 35);
        W.put(R.id.text_view_price_start_rupee, 36);
        W.put(R.id.text_view_price_end_rupee, 37);
        W.put(R.id.view_separator_3, 38);
        W.put(R.id.layout_departure_seek_bar, 39);
        W.put(R.id.view_separator_4, 40);
        W.put(R.id.layout_arrival_seek_bar, 41);
        W.put(R.id.view_separator_5, 42);
        W.put(R.id.text_view_airline_header, 43);
        W.put(R.id.view_airline_search_background, 44);
        W.put(R.id.img_view_airline_search_icon, 45);
    }

    public af(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 46, V, W));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private af(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[20], objArr[45], objArr[19], objArr[7], objArr[41], objArr[39], objArr[33], objArr[5], objArr[1], objArr[3], objArr[35], objArr[8], objArr[4], objArr[6], objArr[21], objArr[43], objArr[29], objArr[18], objArr[16], objArr[17], objArr[15], objArr[13], objArr[14], objArr[9], objArr[32], objArr[31], objArr[25], objArr[26], objArr[27], objArr[28], objArr[37], objArr[12], objArr[34], objArr[36], objArr[11], objArr[22], objArr[24], objArr[44], objArr[23], objArr[10], objArr[38], objArr[40], objArr[42], objArr[30]);
        this.ad = new g() {
            public final void onChange() {
                String a2 = d.a((TextView) af.this.f23564b);
                FlightFilterViewModel flightFilterViewModel = af.this.T;
                boolean z = true;
                if (flightFilterViewModel != null) {
                    y<String> airlineFilterText = flightFilterViewModel.getAirlineFilterText();
                    if (airlineFilterText == null) {
                        z = false;
                    }
                    if (z) {
                        airlineFilterText.setValue(a2);
                    }
                }
            }
        };
        this.ae = -1;
        this.f23563a.setTag((Object) null);
        this.f23564b.setTag((Object) null);
        this.f23566d.setTag((Object) null);
        this.f23567e.setTag((Object) null);
        this.f23571i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.X = objArr[0];
        this.X.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        this.s.setTag((Object) null);
        this.t.setTag((Object) null);
        this.u.setTag((Object) null);
        this.v.setTag((Object) null);
        this.w.setTag((Object) null);
        this.x.setTag((Object) null);
        this.y.setTag((Object) null);
        this.G.setTag((Object) null);
        this.J.setTag((Object) null);
        this.O.setTag((Object) null);
        setRootTag(view);
        this.Y = new a(this, 5);
        this.Z = new a(this, 3);
        this.aa = new a(this, 4);
        this.ab = new a(this, 1);
        this.ac = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.ae = 65536;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.ae != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.A == i2) {
            a((FlightFilterViewModel) obj);
        } else if (com.travel.flight.a.O != i2) {
            return false;
        } else {
            a((FlightFilterHomeViewModel) obj);
        }
        return true;
    }

    public final void a(FlightFilterViewModel flightFilterViewModel) {
        this.T = flightFilterViewModel;
        synchronized (this) {
            this.ae |= 16384;
        }
        notifyPropertyChanged(com.travel.flight.a.A);
        super.requestRebind();
    }

    public final void a(FlightFilterHomeViewModel flightFilterHomeViewModel) {
        this.U = flightFilterHomeViewModel;
        synchronized (this) {
            this.ae |= 32768;
        }
        notifyPropertyChanged(com.travel.flight.a.O);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return a(i3);
            case 1:
                return b(i3);
            case 2:
                return c(i3);
            case 3:
                return d(i3);
            case 4:
                return e(i3);
            case 5:
                return f(i3);
            case 6:
                return g(i3);
            case 7:
                return h(i3);
            case 8:
                return i(i3);
            case 9:
                return j(i3);
            case 10:
                return k(i3);
            case 11:
                return l(i3);
            case 12:
                return m(i3);
            case 13:
                return n(i3);
            default:
                return false;
        }
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 32;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 64;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 128;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 256;
        }
        return true;
    }

    private boolean j(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 512;
        }
        return true;
    }

    private boolean k(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 1024;
        }
        return true;
    }

    private boolean l(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 2048;
        }
        return true;
    }

    private boolean m(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 4096;
        }
        return true;
    }

    private boolean n(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.ae |= 8192;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r49 = this;
            r1 = r49
            monitor-enter(r49)
            long r2 = r1.ae     // Catch:{ all -> 0x0455 }
            r4 = 0
            r1.ae = r4     // Catch:{ all -> 0x0455 }
            monitor-exit(r49)     // Catch:{ all -> 0x0455 }
            com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel r0 = r1.T
            com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel r6 = r1.U
            r7 = 131071(0x1ffff, double:6.47577E-319)
            long r7 = r7 & r2
            r11 = 81944(0x14018, double:4.04857E-319)
            r15 = 81924(0x14004, double:4.0476E-319)
            r17 = 81922(0x14002, double:4.0475E-319)
            r19 = 81921(0x14001, double:4.04744E-319)
            r21 = 4194304(0x400000, double:2.0722615E-317)
            r25 = 114688(0x1c000, double:5.66634E-319)
            r14 = 1
            r13 = 0
            int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x02b8
            long r7 = r2 & r19
            int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x004a
            if (r0 == 0) goto L_0x0037
            androidx.lifecycle.y r7 = r0.getSelectedPriceMax()
            goto L_0x0038
        L_0x0037:
            r7 = 0
        L_0x0038:
            r1.updateLiveDataRegistration(r13, r7)
            if (r7 == 0) goto L_0x0044
            java.lang.Object r7 = r7.getValue()
            java.lang.Integer r7 = (java.lang.Integer) r7
            goto L_0x0045
        L_0x0044:
            r7 = 0
        L_0x0045:
            int r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r7)
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            long r28 = r2 & r17
            int r8 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0065
            if (r0 == 0) goto L_0x0058
            androidx.lifecycle.y r8 = r0.getFilteredAirlineList()
            goto L_0x0059
        L_0x0058:
            r8 = 0
        L_0x0059:
            r1.updateLiveDataRegistration(r14, r8)
            if (r8 == 0) goto L_0x0065
            java.lang.Object r8 = r8.getValue()
            java.util.List r8 = (java.util.List) r8
            goto L_0x0066
        L_0x0065:
            r8 = 0
        L_0x0066:
            long r28 = r2 & r15
            r10 = 2
            int r30 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x00af
            if (r0 == 0) goto L_0x0076
            androidx.lifecycle.y r28 = r0.getAirlineFilterText()
            r13 = r28
            goto L_0x0077
        L_0x0076:
            r13 = 0
        L_0x0077:
            r1.updateLiveDataRegistration(r10, r13)
            if (r13 == 0) goto L_0x0083
            java.lang.Object r13 = r13.getValue()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0084
        L_0x0083:
            r13 = 0
        L_0x0084:
            if (r13 == 0) goto L_0x008b
            int r29 = r13.length()
            goto L_0x008d
        L_0x008b:
            r29 = 0
        L_0x008d:
            if (r29 <= 0) goto L_0x0092
            r29 = 1
            goto L_0x0094
        L_0x0092:
            r29 = 0
        L_0x0094:
            if (r30 == 0) goto L_0x00a1
            if (r29 == 0) goto L_0x009c
            r30 = 16777216(0x1000000, double:8.289046E-317)
            goto L_0x009f
        L_0x009c:
            r30 = 8388608(0x800000, double:4.144523E-317)
        L_0x009f:
            long r2 = r2 | r30
        L_0x00a1:
            if (r29 == 0) goto L_0x00a6
            r29 = 0
            goto L_0x00a8
        L_0x00a6:
            r29 = 8
        L_0x00a8:
            r48 = r29
            r29 = r13
            r13 = r48
            goto L_0x00b2
        L_0x00af:
            r13 = 0
            r29 = 0
        L_0x00b2:
            r30 = 82456(0x14218, double:4.07387E-319)
            long r30 = r2 & r30
            int r32 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x00d2
            if (r0 == 0) goto L_0x00c4
            androidx.lifecycle.y r30 = r0.getSelectedArrivalTimeZone()
            r9 = r30
            goto L_0x00c5
        L_0x00c4:
            r9 = 0
        L_0x00c5:
            r15 = 3
            r1.updateLiveDataRegistration(r15, r9)
            if (r9 == 0) goto L_0x00d2
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x00d3
        L_0x00d2:
            r9 = 0
        L_0x00d3:
            long r15 = r2 & r11
            int r33 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r33 == 0) goto L_0x00ee
            if (r0 == 0) goto L_0x00e0
            androidx.lifecycle.y r15 = r0.getSelectedArrivalMax()
            goto L_0x00e1
        L_0x00e0:
            r15 = 0
        L_0x00e1:
            r11 = 4
            r1.updateLiveDataRegistration(r11, r15)
            if (r15 == 0) goto L_0x00ee
            java.lang.Object r11 = r15.getValue()
            java.lang.Long r11 = (java.lang.Long) r11
            goto L_0x00ef
        L_0x00ee:
            r11 = 0
        L_0x00ef:
            r15 = 81984(0x14040, double:4.05055E-319)
            long r34 = r2 & r15
            int r12 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0113
            if (r0 == 0) goto L_0x00ff
            androidx.lifecycle.y r12 = r0.getSelectedPriceMin()
            goto L_0x0100
        L_0x00ff:
            r12 = 0
        L_0x0100:
            r15 = 6
            r1.updateLiveDataRegistration(r15, r12)
            if (r12 == 0) goto L_0x010d
            java.lang.Object r12 = r12.getValue()
            java.lang.Integer r12 = (java.lang.Integer) r12
            goto L_0x010e
        L_0x010d:
            r12 = 0
        L_0x010e:
            int r12 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r12)
            goto L_0x0114
        L_0x0113:
            r12 = 0
        L_0x0114:
            r15 = 83072(0x14480, double:4.1043E-319)
            long r15 = r15 & r2
            int r34 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x0131
            if (r0 == 0) goto L_0x0123
            androidx.lifecycle.y r15 = r0.getSelectedDepartureMax()
            goto L_0x0124
        L_0x0123:
            r15 = 0
        L_0x0124:
            r14 = 7
            r1.updateLiveDataRegistration(r14, r15)
            if (r15 == 0) goto L_0x0131
            java.lang.Object r14 = r15.getValue()
            java.lang.Long r14 = (java.lang.Long) r14
            goto L_0x0132
        L_0x0131:
            r14 = 0
        L_0x0132:
            r34 = 114720(0x1c020, double:5.6679E-319)
            long r34 = r2 & r34
            int r15 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0158
            if (r0 == 0) goto L_0x0142
            boolean r15 = r0.isOnward()
            goto L_0x0143
        L_0x0142:
            r15 = 0
        L_0x0143:
            long r34 = r2 & r25
            int r36 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r36 == 0) goto L_0x0159
            r34 = r15 ^ 1
            if (r36 == 0) goto L_0x015b
            if (r34 == 0) goto L_0x0152
            long r2 = r2 | r21
            goto L_0x015b
        L_0x0152:
            r35 = 2097152(0x200000, double:1.0361308E-317)
            long r2 = r2 | r35
            goto L_0x015b
        L_0x0158:
            r15 = 0
        L_0x0159:
            r34 = 0
        L_0x015b:
            r35 = 83200(0x14500, double:4.11063E-319)
            long r35 = r2 & r35
            int r37 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x017e
            if (r0 == 0) goto L_0x016f
            androidx.lifecycle.y r35 = r0.getSelectedDepartureMin()
            r10 = r35
            r4 = 8
            goto L_0x0172
        L_0x016f:
            r4 = 8
            r10 = 0
        L_0x0172:
            r1.updateLiveDataRegistration(r4, r10)
            if (r10 == 0) goto L_0x0180
            java.lang.Object r5 = r10.getValue()
            java.lang.Long r5 = (java.lang.Long) r5
            goto L_0x0181
        L_0x017e:
            r4 = 8
        L_0x0180:
            r5 = 0
        L_0x0181:
            r38 = 82440(0x14208, double:4.0731E-319)
            long r38 = r2 & r38
            r36 = 0
            int r10 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r10 == 0) goto L_0x01a2
            if (r0 == 0) goto L_0x0193
            androidx.lifecycle.y r10 = r0.getSelectedArrivalMin()
            goto L_0x0194
        L_0x0193:
            r10 = 0
        L_0x0194:
            r4 = 9
            r1.updateLiveDataRegistration(r4, r10)
            if (r10 == 0) goto L_0x01a2
            java.lang.Object r4 = r10.getValue()
            java.lang.Long r4 = (java.lang.Long) r4
            goto L_0x01a3
        L_0x01a2:
            r4 = 0
        L_0x01a3:
            r38 = 83328(0x14580, double:4.11695E-319)
            long r38 = r2 & r38
            r36 = 0
            int r10 = (r38 > r36 ? 1 : (r38 == r36 ? 0 : -1))
            if (r10 == 0) goto L_0x01c8
            if (r0 == 0) goto L_0x01b7
            androidx.lifecycle.y r10 = r0.getSelectedDepartureTimeZone()
            r38 = r4
            goto L_0x01ba
        L_0x01b7:
            r38 = r4
            r10 = 0
        L_0x01ba:
            r4 = 10
            r1.updateLiveDataRegistration(r4, r10)
            if (r10 == 0) goto L_0x01ca
            java.lang.Object r4 = r10.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01cb
        L_0x01c8:
            r38 = r4
        L_0x01ca:
            r4 = 0
        L_0x01cb:
            r39 = 83968(0x14800, double:4.14857E-319)
            long r39 = r2 & r39
            r36 = 0
            int r10 = (r39 > r36 ? 1 : (r39 == r36 ? 0 : -1))
            if (r10 == 0) goto L_0x01f0
            if (r0 == 0) goto L_0x01df
            androidx.lifecycle.y r10 = r0.getSelectedDuration()
            r39 = r4
            goto L_0x01e2
        L_0x01df:
            r39 = r4
            r10 = 0
        L_0x01e2:
            r4 = 11
            r1.updateLiveDataRegistration(r4, r10)
            if (r10 == 0) goto L_0x01f2
            java.lang.Object r4 = r10.getValue()
            java.lang.Integer r4 = (java.lang.Integer) r4
            goto L_0x01f3
        L_0x01f0:
            r39 = r4
        L_0x01f2:
            r4 = 0
        L_0x01f3:
            r40 = 81952(0x14020, double:4.04897E-319)
            long r40 = r2 & r40
            r36 = 0
            int r10 = (r40 > r36 ? 1 : (r40 == r36 ? 0 : -1))
            if (r10 == 0) goto L_0x021f
            if (r0 == 0) goto L_0x0205
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r10 = r0.getParentViewModel()
            goto L_0x0206
        L_0x0205:
            r10 = 0
        L_0x0206:
            if (r10 == 0) goto L_0x020f
            androidx.lifecycle.y r10 = r10.getSearchInput()
            r40 = r4
            goto L_0x0212
        L_0x020f:
            r40 = r4
            r10 = 0
        L_0x0212:
            r4 = 5
            r1.updateLiveDataRegistration(r4, r10)
            if (r10 == 0) goto L_0x0221
            java.lang.Object r4 = r10.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r4 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r4
            goto L_0x0222
        L_0x021f:
            r40 = r4
        L_0x0221:
            r4 = 0
        L_0x0222:
            r23 = 86016(0x15000, double:4.24976E-319)
            long r41 = r2 & r23
            r36 = 0
            int r10 = (r41 > r36 ? 1 : (r41 == r36 ? 0 : -1))
            if (r10 == 0) goto L_0x024d
            if (r0 == 0) goto L_0x0236
            androidx.lifecycle.y r10 = r0.getHideNonRefundableFlights()
            r41 = r4
            goto L_0x0239
        L_0x0236:
            r41 = r4
            r10 = 0
        L_0x0239:
            r4 = 12
            r1.updateLiveDataRegistration(r4, r10)
            if (r10 == 0) goto L_0x0247
            java.lang.Object r4 = r10.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x0248
        L_0x0247:
            r4 = 0
        L_0x0248:
            boolean r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r4)
            goto L_0x0250
        L_0x024d:
            r41 = r4
            r4 = 0
        L_0x0250:
            r42 = 90112(0x16000, double:4.4521E-319)
            long r42 = r2 & r42
            r36 = 0
            int r10 = (r42 > r36 ? 1 : (r42 == r36 ? 0 : -1))
            if (r10 == 0) goto L_0x02a0
            if (r0 == 0) goto L_0x0264
            androidx.lifecycle.y r10 = r0.getSelectedFlightStopType()
            r42 = r2
            goto L_0x0267
        L_0x0264:
            r42 = r2
            r10 = 0
        L_0x0267:
            r2 = 13
            r1.updateLiveDataRegistration(r2, r10)
            if (r10 == 0) goto L_0x0275
            java.lang.Object r2 = r10.getValue()
            java.lang.Integer r2 = (java.lang.Integer) r2
            goto L_0x0276
        L_0x0275:
            r2 = 0
        L_0x0276:
            int r2 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r2)
            r3 = 3
            if (r2 != r3) goto L_0x027f
            r3 = 1
            goto L_0x0280
        L_0x027f:
            r3 = 0
        L_0x0280:
            r10 = 2
            r35 = r3
            r3 = 1
            if (r2 != r10) goto L_0x0288
            r10 = 1
            goto L_0x0289
        L_0x0288:
            r10 = 0
        L_0x0289:
            if (r2 != r3) goto L_0x028d
            r2 = 1
            goto L_0x028e
        L_0x028d:
            r2 = 0
        L_0x028e:
            r44 = r5
            r46 = r7
            r47 = r12
            r3 = r35
            r12 = r38
            r45 = r40
            r7 = r41
            r5 = r2
            r2 = r29
            goto L_0x02b3
        L_0x02a0:
            r42 = r2
            r44 = r5
            r46 = r7
            r47 = r12
            r2 = r29
            r12 = r38
            r45 = r40
            r7 = r41
            r3 = 0
            r5 = 0
            r10 = 0
        L_0x02b3:
            r29 = r14
            r14 = r39
            goto L_0x02d3
        L_0x02b8:
            r42 = r2
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r29 = 0
            r34 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
        L_0x02d3:
            long r21 = r42 & r21
            r35 = 0
            int r38 = (r21 > r35 ? 1 : (r21 == r35 ? 0 : -1))
            if (r38 == 0) goto L_0x02e9
            if (r6 == 0) goto L_0x02e2
            boolean r21 = r6.isDomestic()
            goto L_0x02e4
        L_0x02e2:
            r21 = 0
        L_0x02e4:
            r16 = 1
            r16 = r21 ^ 1
            goto L_0x02eb
        L_0x02e9:
            r16 = 0
        L_0x02eb:
            long r21 = r42 & r25
            r38 = 1048576(0x100000, double:5.180654E-318)
            r35 = 0
            int r40 = (r21 > r35 ? 1 : (r21 == r35 ? 0 : -1))
            if (r40 == 0) goto L_0x0308
            if (r34 == 0) goto L_0x02f9
            goto L_0x02fb
        L_0x02f9:
            r16 = 0
        L_0x02fb:
            if (r40 == 0) goto L_0x030a
            if (r16 == 0) goto L_0x0302
            long r42 = r42 | r38
            goto L_0x030a
        L_0x0302:
            r21 = 524288(0x80000, double:2.590327E-318)
            long r42 = r42 | r21
            goto L_0x030a
        L_0x0308:
            r16 = 0
        L_0x030a:
            long r21 = r42 & r38
            r34 = 0
            int r36 = (r21 > r34 ? 1 : (r21 == r34 ? 0 : -1))
            if (r36 == 0) goto L_0x0319
            if (r6 == 0) goto L_0x0319
            boolean r6 = r6.isRoundTrip()
            goto L_0x031a
        L_0x0319:
            r6 = 0
        L_0x031a:
            long r21 = r42 & r25
            int r38 = (r21 > r34 ? 1 : (r21 == r34 ? 0 : -1))
            if (r38 == 0) goto L_0x033b
            if (r16 == 0) goto L_0x0323
            goto L_0x0324
        L_0x0323:
            r6 = 0
        L_0x0324:
            if (r38 == 0) goto L_0x0331
            if (r6 == 0) goto L_0x032c
            r21 = 262144(0x40000, double:1.295163E-318)
            goto L_0x032f
        L_0x032c:
            r21 = 131072(0x20000, double:6.47582E-319)
        L_0x032f:
            long r42 = r42 | r21
        L_0x0331:
            if (r6 == 0) goto L_0x0336
            r27 = 8
            goto L_0x0338
        L_0x0336:
            r27 = 0
        L_0x0338:
            r6 = r27
            goto L_0x033c
        L_0x033b:
            r6 = 0
        L_0x033c:
            r21 = 86016(0x15000, double:4.24976E-319)
            long r21 = r42 & r21
            r23 = 0
            int r16 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r16 == 0) goto L_0x034f
            r16 = r6
            android.widget.CheckBox r6 = r1.f23563a
            androidx.databinding.a.a.a(r6, r4)
            goto L_0x0351
        L_0x034f:
            r16 = r6
        L_0x0351:
            r21 = 81924(0x14004, double:4.0476E-319)
            long r21 = r42 & r21
            int r4 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r4 == 0) goto L_0x0364
            android.widget.EditText r4 = r1.f23564b
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r2)
            android.widget.ImageView r2 = r1.f23566d
            r2.setVisibility(r13)
        L_0x0364:
            r21 = 65536(0x10000, double:3.2379E-319)
            long r21 = r42 & r21
            int r2 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r2 == 0) goto L_0x0398
            android.widget.EditText r2 = r1.f23564b
            androidx.databinding.g r4 = r1.ad
            r6 = 0
            androidx.databinding.a.d.a(r2, r6, r6, r4)
            android.widget.ImageView r2 = r1.f23566d
            android.view.View$OnClickListener r4 = r1.Y
            r2.setOnClickListener(r4)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r1.f23567e
            android.view.View$OnClickListener r4 = r1.aa
            r2.setOnClickListener(r4)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r1.f23571i
            android.view.View$OnClickListener r4 = r1.Z
            r2.setOnClickListener(r4)
            android.widget.LinearLayout r2 = r1.j
            android.view.View$OnClickListener r4 = r1.ab
            r2.setOnClickListener(r4)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r1.k
            android.view.View$OnClickListener r4 = r1.ac
            r2.setOnClickListener(r4)
        L_0x0398:
            r21 = 90112(0x16000, double:4.4521E-319)
            long r21 = r42 & r21
            r23 = 0
            int r2 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r2 == 0) goto L_0x03b2
            android.widget.RadioButton r2 = r1.m
            androidx.databinding.a.a.a(r2, r3)
            android.widget.RadioButton r2 = r1.n
            androidx.databinding.a.a.a(r2, r5)
            android.widget.RadioButton r2 = r1.o
            androidx.databinding.a.a.a(r2, r10)
        L_0x03b2:
            long r2 = r42 & r17
            int r4 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r4 == 0) goto L_0x03bd
            androidx.recyclerview.widget.RecyclerView r2 = r1.p
            com.travel.flight.flightSRPV2.c.c.a((androidx.recyclerview.widget.RecyclerView) r2, (java.util.List<com.travel.flight.flightSRPV2.a.d>) r8, (com.travel.flight.flightSRPV2.viewModel.FlightFilterViewModel) r0)
        L_0x03bd:
            r2 = 81944(0x14018, double:4.04857E-319)
            long r2 = r42 & r2
            int r0 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r0 == 0) goto L_0x03cb
            android.widget.TextView r0 = r1.s
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (java.lang.Long) r11, (java.lang.String) r9)
        L_0x03cb:
            r2 = 81952(0x14020, double:4.04897E-319)
            long r2 = r42 & r2
            int r0 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r0 == 0) goto L_0x03ea
            android.widget.TextView r0 = r1.t
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r15)
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r7, (java.lang.Boolean) r2, (java.lang.Boolean) r3)
            android.widget.TextView r0 = r1.w
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r15)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r7, (java.lang.Boolean) r2, (java.lang.Boolean) r3)
        L_0x03ea:
            r2 = 82440(0x14208, double:4.0731E-319)
            long r2 = r42 & r2
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x03fa
            android.widget.TextView r0 = r1.u
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (java.lang.Long) r12, (java.lang.String) r9)
        L_0x03fa:
            r2 = 83072(0x14480, double:4.1043E-319)
            long r2 = r42 & r2
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x040a
            android.widget.TextView r0 = r1.v
            r2 = r29
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (java.lang.Long) r2, (java.lang.String) r14)
        L_0x040a:
            r2 = 83200(0x14500, double:4.11063E-319)
            long r2 = r42 & r2
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x041a
            android.widget.TextView r0 = r1.x
            r2 = r44
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (java.lang.Long) r2, (java.lang.String) r14)
        L_0x041a:
            r2 = 83968(0x14800, double:4.14857E-319)
            long r2 = r42 & r2
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x042a
            android.widget.TextView r0 = r1.y
            r2 = r45
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (java.lang.Integer) r2)
        L_0x042a:
            long r2 = r42 & r19
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0437
            android.widget.TextView r0 = r1.G
            r7 = r46
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r7)
        L_0x0437:
            r2 = 81984(0x14040, double:4.05055E-319)
            long r2 = r42 & r2
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0447
            android.widget.TextView r0 = r1.J
            r12 = r47
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r12)
        L_0x0447:
            long r2 = r42 & r25
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0454
            android.view.View r0 = r1.O
            r2 = r16
            r0.setVisibility(r2)
        L_0x0454:
            return
        L_0x0455:
            r0 = move-exception
            monitor-exit(r49)     // Catch:{ all -> 0x0455 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.af.executeBindings():void");
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            FlightFilterViewModel flightFilterViewModel = this.T;
            if (flightFilterViewModel != null) {
                z = true;
            }
            if (z) {
                flightFilterViewModel.toggleHideNonRefundableFlights();
            }
        } else if (i2 == 2) {
            FlightFilterViewModel flightFilterViewModel2 = this.T;
            if (flightFilterViewModel2 != null) {
                z = true;
            }
            if (z) {
                flightFilterViewModel2.onFlightStopsSelected(1);
            }
        } else if (i2 == 3) {
            FlightFilterViewModel flightFilterViewModel3 = this.T;
            if (flightFilterViewModel3 != null) {
                z = true;
            }
            if (z) {
                flightFilterViewModel3.onFlightStopsSelected(2);
            }
        } else if (i2 == 4) {
            FlightFilterViewModel flightFilterViewModel4 = this.T;
            if (flightFilterViewModel4 != null) {
                z = true;
            }
            if (z) {
                flightFilterViewModel4.onFlightStopsSelected(3);
            }
        } else if (i2 == 5) {
            FlightFilterViewModel flightFilterViewModel5 = this.T;
            if (flightFilterViewModel5 != null) {
                z = true;
            }
            if (z) {
                flightFilterViewModel5.clearAirlineFilterText();
            }
        }
    }
}
