package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class f extends e implements b.a {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f29679i = null;
    private static final SparseIntArray j;
    private final ImageView A;
    private final LinearLayout B;
    private final ImageView C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private final View.OnClickListener G;
    private final View.OnClickListener H;
    private final View.OnClickListener I;
    private long J;
    private final RelativeLayout k;
    private final ImageView l;
    private final LinearLayout m;
    private final ImageView n;
    private final ImageView o;
    private final LinearLayout p;
    private final ImageView q;
    private final ImageView r;
    private final View s;
    private final View t;
    private final TextView u;
    private final LinearLayout v;
    private final ImageView w;
    private final ImageView x;
    private final LinearLayout y;
    private final ImageView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.iv_hotelRoomCard, 21);
        j.put(R.id.txt_view_options1, 22);
        j.put(R.id.txt_view_options2, 23);
        j.put(R.id.txt_view_options3, 24);
        j.put(R.id.txt_view_options4, 25);
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 26, f29679i, j));
    }

    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[21], objArr[22], objArr[23], objArr[24], objArr[25], objArr[20]);
        this.J = -1;
        this.f29555a.setTag((Object) null);
        this.k = objArr[0];
        this.k.setTag((Object) null);
        this.l = objArr[10];
        this.l.setTag((Object) null);
        this.m = objArr[11];
        this.m.setTag((Object) null);
        this.n = objArr[12];
        this.n.setTag((Object) null);
        this.o = objArr[13];
        this.o.setTag((Object) null);
        this.p = objArr[14];
        this.p.setTag((Object) null);
        this.q = objArr[15];
        this.q.setTag((Object) null);
        this.r = objArr[16];
        this.r.setTag((Object) null);
        this.s = objArr[17];
        this.s.setTag((Object) null);
        this.t = objArr[18];
        this.t.setTag((Object) null);
        this.u = objArr[19];
        this.u.setTag((Object) null);
        this.v = objArr[2];
        this.v.setTag((Object) null);
        this.w = objArr[3];
        this.w.setTag((Object) null);
        this.x = objArr[4];
        this.x.setTag((Object) null);
        this.y = objArr[5];
        this.y.setTag((Object) null);
        this.z = objArr[6];
        this.z.setTag((Object) null);
        this.A = objArr[7];
        this.A.setTag((Object) null);
        this.B = objArr[8];
        this.B.setTag((Object) null);
        this.C = objArr[9];
        this.C.setTag((Object) null);
        this.f29561g.setTag((Object) null);
        setRootTag(view);
        this.D = new b(this, 2);
        this.E = new b(this, 3);
        this.F = new b(this, 1);
        this.G = new b(this, 4);
        this.H = new b(this, 6);
        this.I = new b(this, 5);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.J = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.J != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.s != i2) {
            return false;
        }
        a((CancelOrderViewModel) obj);
        return true;
    }

    public final void a(CancelOrderViewModel cancelOrderViewModel) {
        this.f29562h = cancelOrderViewModel;
        synchronized (this) {
            this.J |= 2;
        }
        notifyPropertyChanged(a.s);
        super.requestRebind();
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
            this.J |= 1;
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
        int i17;
        int i18;
        long j3;
        int i19;
        LinearLayout linearLayout;
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
        synchronized (this) {
            j2 = this.J;
            this.J = 0;
        }
        CancelOrderViewModel cancelOrderViewModel = this.f29562h;
        int i20 = ((j2 & 7) > 0 ? 1 : ((j2 & 7) == 0 ? 0 : -1));
        if (i20 != 0) {
            Integer num = null;
            y<Integer> selectedCancelReason = cancelOrderViewModel != null ? cancelOrderViewModel.getSelectedCancelReason() : null;
            updateLiveDataRegistration(0, selectedCancelReason);
            if (selectedCancelReason != null) {
                num = selectedCancelReason.getValue();
            }
            int safeUnbox = ViewDataBinding.safeUnbox(num);
            boolean z2 = true;
            boolean z3 = safeUnbox == 4;
            boolean z4 = safeUnbox == 5;
            boolean z5 = safeUnbox == 1;
            boolean z6 = safeUnbox == 2;
            if (safeUnbox != 3) {
                z2 = false;
            }
            if (i20 != 0) {
                if (z3) {
                    j13 = j2 | 16 | 16777216;
                    j12 = 67108864;
                } else {
                    j13 = j2 | 8 | 8388608;
                    j12 = 33554432;
                }
                j2 = j13 | j12;
            }
            if ((j2 & 7) != 0) {
                if (z4) {
                    j11 = j2 | 1024 | 4096;
                    j10 = 268435456;
                } else {
                    j11 = j2 | 512 | 2048;
                    j10 = 134217728;
                }
                j2 = j11 | j10;
            }
            if ((j2 & 7) != 0) {
                if (z5) {
                    j9 = j2 | 256 | 65536;
                    j8 = 262144;
                } else {
                    j9 = j2 | 128 | 32768;
                    j8 = 131072;
                }
                j2 = j9 | j8;
            }
            if ((j2 & 7) != 0) {
                if (z6) {
                    j7 = j2 | 1048576 | 4194304;
                    j6 = 4294967296L;
                } else {
                    j7 = j2 | 524288 | 2097152;
                    j6 = 2147483648L;
                }
                j2 = j7 | j6;
            }
            if ((j2 & 7) != 0) {
                if (z2) {
                    j5 = j2 | 64 | 16384;
                    j4 = 1073741824;
                } else {
                    j5 = j2 | 32 | 8192;
                    j4 = 536870912;
                }
                j2 = j5 | j4;
            }
            i8 = z3 ? 8 : 0;
            int colorFromResource = z3 ? getColorFromResource(this.m, R.color.color_e5f6fd) : getColorFromResource(this.m, R.color.hotel_white);
            i11 = z3 ? 0 : 8;
            i4 = z4 ? 8 : 0;
            int i21 = z4 ? 0 : 8;
            i9 = z4 ? getColorFromResource(this.p, R.color.color_e5f6fd) : getColorFromResource(this.p, R.color.hotel_white);
            i13 = z5 ? getColorFromResource(this.v, R.color.color_e5f6fd) : getColorFromResource(this.v, R.color.hotel_white);
            i12 = z5 ? 0 : 8;
            i7 = z5 ? 8 : 0;
            int colorFromResource2 = z6 ? getColorFromResource(this.y, R.color.color_e5f6fd) : getColorFromResource(this.y, R.color.hotel_white);
            int i22 = z6 ? 0 : 8;
            i6 = z6 ? 8 : 0;
            int i23 = z2 ? 8 : 0;
            int i24 = colorFromResource;
            if (z2) {
                linearLayout = this.B;
                j3 = j2;
                i19 = R.color.color_e5f6fd;
            } else {
                j3 = j2;
                linearLayout = this.B;
                i19 = R.color.hotel_white;
            }
            int colorFromResource3 = getColorFromResource(linearLayout, i19);
            int i25 = z2 ? 0 : 8;
            i10 = i22;
            i2 = i23;
            i3 = i24;
            j2 = j3;
            i5 = colorFromResource3;
            i14 = colorFromResource2;
            i16 = i25;
            i15 = i21;
        } else {
            i16 = 0;
            i15 = 0;
            i14 = 0;
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
        if ((j2 & 4) != 0) {
            i18 = i5;
            i17 = i10;
            this.f29555a.setOnClickListener(this.F);
            this.m.setOnClickListener(this.I);
            this.p.setOnClickListener(this.H);
            this.v.setOnClickListener(this.D);
            this.y.setOnClickListener(this.E);
            this.B.setOnClickListener(this.G);
        } else {
            i17 = i10;
            i18 = i5;
        }
        if ((j2 & 7) != 0) {
            this.l.setVisibility(i16);
            androidx.databinding.a.e.a((View) this.m, (Drawable) androidx.databinding.a.b.a(i3));
            this.n.setVisibility(i8);
            this.o.setVisibility(i11);
            androidx.databinding.a.e.a((View) this.p, (Drawable) androidx.databinding.a.b.a(i9));
            this.q.setVisibility(i4);
            this.r.setVisibility(i15);
            this.s.setVisibility(i15);
            this.t.setVisibility(i4);
            this.u.setVisibility(i15);
            androidx.databinding.a.e.a((View) this.v, (Drawable) androidx.databinding.a.b.a(i13));
            this.w.setVisibility(i7);
            this.x.setVisibility(i12);
            androidx.databinding.a.e.a((View) this.y, (Drawable) androidx.databinding.a.b.a(i14));
            this.z.setVisibility(i6);
            this.A.setVisibility(i17);
            androidx.databinding.a.e.a((View) this.B, (Drawable) androidx.databinding.a.b.a(i18));
            this.C.setVisibility(i2);
            this.f29561g.setVisibility(i15);
        }
    }

    public final void a(int i2) {
        boolean z2 = false;
        switch (i2) {
            case 1:
                CancelOrderViewModel cancelOrderViewModel = this.f29562h;
                if (cancelOrderViewModel != null) {
                    z2 = true;
                }
                if (z2) {
                    cancelOrderViewModel.closeButtonClickHandler();
                    return;
                }
                return;
            case 2:
                CancelOrderViewModel cancelOrderViewModel2 = this.f29562h;
                if (cancelOrderViewModel2 != null) {
                    z2 = true;
                }
                if (z2) {
                    cancelOrderViewModel2.setSelectedOptions(1);
                    return;
                }
                return;
            case 3:
                CancelOrderViewModel cancelOrderViewModel3 = this.f29562h;
                if (cancelOrderViewModel3 != null) {
                    z2 = true;
                }
                if (z2) {
                    cancelOrderViewModel3.setSelectedOptions(2);
                    return;
                }
                return;
            case 4:
                CancelOrderViewModel cancelOrderViewModel4 = this.f29562h;
                if (cancelOrderViewModel4 != null) {
                    z2 = true;
                }
                if (z2) {
                    cancelOrderViewModel4.setSelectedOptions(3);
                    return;
                }
                return;
            case 5:
                CancelOrderViewModel cancelOrderViewModel5 = this.f29562h;
                if (cancelOrderViewModel5 != null) {
                    z2 = true;
                }
                if (z2) {
                    cancelOrderViewModel5.setSelectedOptions(4);
                    return;
                }
                return;
            case 6:
                CancelOrderViewModel cancelOrderViewModel6 = this.f29562h;
                if (cancelOrderViewModel6 != null) {
                    z2 = true;
                }
                if (z2) {
                    cancelOrderViewModel6.setSelectedOptions(5);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
