package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.a.ae;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public final class al extends ak implements a.C0456a {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f23597g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f23598h;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private final View.OnClickListener G;
    private long H;

    /* renamed from: i  reason: collision with root package name */
    private final ImageView f23599i;
    private final LinearLayout j;
    private final RoboTextView k;
    private final ImageView l;
    private final LinearLayout m;
    private final RoboTextView n;
    private final ImageView o;
    private final LinearLayout p;
    private final RoboTextView q;
    private final ImageView r;
    private final LinearLayout s;
    private final RoboTextView t;
    private final ImageView u;
    private final LinearLayout v;
    private final RoboTextView w;
    private final ImageView x;
    private final LinearLayout y;
    private final RoboTextView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23598h = sparseIntArray;
        sparseIntArray.put(R.id.sort_lyt, 20);
        f23598h.put(R.id.domestic_onward_sort_title, 21);
        f23598h.put(R.id.transparent_padding, 22);
    }

    public al(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 23, f23597g, f23598h));
    }

    private al(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[21], objArr[1], objArr[0], objArr[20], objArr[22]);
        this.H = -1;
        this.f23592b.setTag((Object) null);
        this.f23593c.setTag((Object) null);
        this.f23599i = objArr[10];
        this.f23599i.setTag((Object) null);
        this.j = objArr[11];
        this.j.setTag((Object) null);
        this.k = objArr[12];
        this.k.setTag((Object) null);
        this.l = objArr[13];
        this.l.setTag((Object) null);
        this.m = objArr[14];
        this.m.setTag((Object) null);
        this.n = objArr[15];
        this.n.setTag((Object) null);
        this.o = objArr[16];
        this.o.setTag((Object) null);
        this.p = objArr[17];
        this.p.setTag((Object) null);
        this.q = objArr[18];
        this.q.setTag((Object) null);
        this.r = objArr[19];
        this.r.setTag((Object) null);
        this.s = objArr[2];
        this.s.setTag((Object) null);
        this.t = objArr[3];
        this.t.setTag((Object) null);
        this.u = objArr[4];
        this.u.setTag((Object) null);
        this.v = objArr[5];
        this.v.setTag((Object) null);
        this.w = objArr[6];
        this.w.setTag((Object) null);
        this.x = objArr[7];
        this.x.setTag((Object) null);
        this.y = objArr[8];
        this.y.setTag((Object) null);
        this.z = objArr[9];
        this.z.setTag((Object) null);
        setRootTag(view);
        this.A = new a(this, 1);
        this.B = new a(this, 4);
        this.C = new a(this, 2);
        this.D = new a(this, 5);
        this.E = new a(this, 3);
        this.F = new a(this, 6);
        this.G = new a(this, 7);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.H = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.H != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.j != i2) {
            return false;
        }
        a((SRPSharedViewModel) obj);
        return true;
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.f23596f = sRPSharedViewModel;
        synchronized (this) {
            this.H |= 2;
        }
        notifyPropertyChanged(com.travel.flight.a.j);
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
            this.H |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        RoboTextView roboTextView;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        synchronized (this) {
            j2 = this.H;
            this.H = 0;
        }
        SRPSharedViewModel sRPSharedViewModel = this.f23596f;
        int i17 = ((j2 & 7) > 0 ? 1 : ((j2 & 7) == 0 ? 0 : -1));
        if (i17 != 0) {
            ae aeVar = null;
            y<ae> oneWaySortOption = sRPSharedViewModel != null ? sRPSharedViewModel.getOneWaySortOption() : null;
            updateLiveDataRegistration(0, oneWaySortOption);
            if (oneWaySortOption != null) {
                aeVar = oneWaySortOption.getValue();
            }
            if (aeVar != null) {
                i15 = aeVar.a();
            } else {
                i15 = 0;
            }
            boolean z2 = i15 == 6;
            boolean z3 = i15 == 1;
            boolean z4 = i15 == 5;
            boolean z5 = i15 == 4;
            boolean z6 = i15 == 3;
            boolean z7 = i15 == 2;
            if (i17 != 0) {
                if (z2) {
                    j14 = j2 | 262144;
                    j13 = 4194304;
                } else {
                    j14 = j2 | 131072;
                    j13 = 2097152;
                }
                j2 = j14 | j13;
            }
            if ((j2 & 7) != 0) {
                if (z3) {
                    j12 = j2 | 256;
                    j11 = 67108864;
                } else {
                    j12 = j2 | 128;
                    j11 = 33554432;
                }
                j2 = j12 | j11;
            }
            if ((j2 & 7) != 0) {
                if (z4) {
                    j10 = j2 | 65536;
                    j9 = 1048576;
                } else {
                    j10 = j2 | 32768;
                    j9 = 524288;
                }
                j2 = j10 | j9;
            }
            if ((j2 & 7) != 0) {
                if (z5) {
                    j8 = j2 | 1024;
                    j7 = 16777216;
                } else {
                    j8 = j2 | 512;
                    j7 = 8388608;
                }
                j2 = j8 | j7;
            }
            if ((j2 & 7) != 0) {
                if (z6) {
                    j6 = j2 | 16;
                    j5 = 4096;
                } else {
                    j6 = j2 | 8;
                    j5 = 2048;
                }
                j2 = j6 | j5;
            }
            if ((j2 & 7) != 0) {
                if (z7) {
                    j4 = j2 | 64;
                    j3 = 16384;
                } else {
                    j4 = j2 | 32;
                    j3 = 8192;
                }
                j2 = j4 | j3;
            }
            i7 = z2 ? 0 : 8;
            if (z2) {
                roboTextView = this.q;
                i16 = R.color.color_000000;
            } else {
                roboTextView = this.q;
                i16 = R.color.color_8c8c8c;
            }
            i8 = getColorFromResource(roboTextView, i16);
            i13 = z3 ? getColorFromResource(this.t, R.color.color_000000) : getColorFromResource(this.t, R.color.color_8c8c8c);
            i5 = z3 ? 0 : 8;
            i4 = z4 ? 0 : 8;
            i6 = z4 ? getColorFromResource(this.n, R.color.color_000000) : getColorFromResource(this.n, R.color.color_8c8c8c);
            i3 = z5 ? 0 : 8;
            i10 = z5 ? getColorFromResource(this.k, R.color.color_000000) : getColorFromResource(this.k, R.color.color_8c8c8c);
            i9 = z6 ? 0 : 8;
            i2 = getColorFromResource(this.z, z6 ? R.color.color_000000 : R.color.color_8c8c8c);
            i12 = z7 ? getColorFromResource(this.w, R.color.color_000000) : getColorFromResource(this.w, R.color.color_8c8c8c);
            i11 = z7 ? 0 : 8;
        } else {
            i13 = 0;
            i12 = 0;
            i11 = 0;
            i10 = 0;
            i9 = 0;
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        if ((4 & j2) != 0) {
            i14 = i2;
            this.f23592b.setOnClickListener(this.A);
            this.j.setOnClickListener(this.D);
            this.m.setOnClickListener(this.F);
            this.p.setOnClickListener(this.G);
            this.s.setOnClickListener(this.C);
            this.v.setOnClickListener(this.E);
            this.y.setOnClickListener(this.B);
        } else {
            i14 = i2;
        }
        if ((j2 & 7) != 0) {
            this.f23599i.setVisibility(i9);
            this.k.setTextColor(i10);
            this.l.setVisibility(i3);
            this.n.setTextColor(i6);
            this.o.setVisibility(i4);
            this.q.setTextColor(i8);
            this.r.setVisibility(i7);
            this.t.setTextColor(i13);
            this.u.setVisibility(i5);
            this.w.setTextColor(i12);
            this.x.setVisibility(i11);
            this.z.setTextColor(i14);
        }
    }

    public final void a(int i2, View view) {
        boolean z2 = false;
        switch (i2) {
            case 1:
                SRPSharedViewModel sRPSharedViewModel = this.f23596f;
                if (sRPSharedViewModel != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel.onBackPressed();
                    return;
                }
                return;
            case 2:
                SRPSharedViewModel sRPSharedViewModel2 = this.f23596f;
                if (sRPSharedViewModel2 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel2.onOneWaySortOptionSelected(1);
                    return;
                }
                return;
            case 3:
                SRPSharedViewModel sRPSharedViewModel3 = this.f23596f;
                if (sRPSharedViewModel3 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel3.onOneWaySortOptionSelected(2);
                    return;
                }
                return;
            case 4:
                SRPSharedViewModel sRPSharedViewModel4 = this.f23596f;
                if (sRPSharedViewModel4 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel4.onOneWaySortOptionSelected(3);
                    return;
                }
                return;
            case 5:
                SRPSharedViewModel sRPSharedViewModel5 = this.f23596f;
                if (sRPSharedViewModel5 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel5.onOneWaySortOptionSelected(4);
                    return;
                }
                return;
            case 6:
                SRPSharedViewModel sRPSharedViewModel6 = this.f23596f;
                if (sRPSharedViewModel6 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel6.onOneWaySortOptionSelected(5);
                    return;
                }
                return;
            case 7:
                SRPSharedViewModel sRPSharedViewModel7 = this.f23596f;
                if (sRPSharedViewModel7 != null) {
                    z2 = true;
                }
                if (z2) {
                    sRPSharedViewModel7.onOneWaySortOptionSelected(6);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
