package com.travel.flight.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b.b;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightorder.j.e;
import com.travel.flight.pojo.b;
import com.travel.flight.pojo.c;
import com.travel.flight.pojo.d;

public final class dj extends di implements a.C0456a {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private final FrameLayout m;
    private final CardView n;
    private final RoboTextView o;
    private final RoboTextView p;
    private final ImageView q;
    private final RoboTextView r;
    private final ImageView s;
    private final View.OnClickListener t;
    private long u;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.img_view_hotel_rating, 11);
        l.put(R.id.separator, 12);
        l.put(R.id.layout_amenities_1, 13);
        l.put(R.id.layout_amenities_2, 14);
    }

    public dj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 15, k, l));
    }

    private dj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[11], objArr[13], objArr[14], objArr[12], objArr[3], objArr[5], objArr[6]);
        this.u = -1;
        this.f23920a.setTag((Object) null);
        this.m = objArr[0];
        this.m.setTag((Object) null);
        this.n = objArr[1];
        this.n.setTag((Object) null);
        this.o = objArr[10];
        this.o.setTag((Object) null);
        this.p = objArr[4];
        this.p.setTag((Object) null);
        this.q = objArr[7];
        this.q.setTag((Object) null);
        this.r = objArr[8];
        this.r.setTag((Object) null);
        this.s = objArr[9];
        this.s.setTag((Object) null);
        this.f23925f.setTag((Object) null);
        this.f23926g.setTag((Object) null);
        this.f23927h.setTag((Object) null);
        setRootTag(view);
        this.t = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.u = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.u != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.y == i2) {
            a((e.a) obj);
        } else if (com.travel.flight.a.M != i2) {
            return false;
        } else {
            a((b) obj);
        }
        return true;
    }

    public final void a(e.a aVar) {
        this.j = aVar;
        synchronized (this) {
            this.u |= 1;
        }
        notifyPropertyChanged(com.travel.flight.a.y);
        super.requestRebind();
    }

    public final void a(b bVar) {
        this.f23928i = bVar;
        synchronized (this) {
            this.u |= 2;
        }
        notifyPropertyChanged(com.travel.flight.a.M);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        int i2;
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        d dVar;
        c cVar;
        String[] strArr;
        String[] strArr2;
        String str8;
        boolean z;
        synchronized (this) {
            j = this.u;
            this.u = 0;
        }
        b bVar = this.f23928i;
        int i4 = 0;
        int i5 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (bVar != null) {
                cVar = bVar.f25413a;
                dVar = bVar.f25415c;
                str2 = bVar.f25416d;
                str = bVar.f25418f;
                strArr = bVar.f25417e;
            } else {
                strArr = null;
                cVar = null;
                dVar = null;
                str2 = null;
                str = null;
            }
            if (cVar != null) {
                strArr2 = cVar.f25419a;
            } else {
                strArr2 = null;
            }
            if (dVar != null) {
                str8 = dVar.f25420a;
                String str9 = dVar.f25422c;
                str3 = dVar.f25421b;
                str4 = str9;
            } else {
                str4 = null;
                str3 = null;
                str8 = null;
            }
            boolean z2 = true;
            if (strArr != null) {
                str6 = (String) getFromArray((T[]) strArr, 1);
                str7 = (String) getFromArray((T[]) strArr, 0);
            } else {
                str7 = null;
                str6 = null;
            }
            str5 = strArr2 != null ? (String) getFromArray((T[]) strArr2, 0) : null;
            if (str3 != null) {
                z = str3.equalsIgnoreCase(str8);
            } else {
                z = false;
            }
            if (i5 != 0) {
                j |= z ? 16 : 8;
            }
            boolean z3 = str6 != null;
            if (str7 == null) {
                z2 = false;
            }
            if ((j & 6) != 0) {
                j |= z3 ? 256 : 128;
            }
            if ((j & 6) != 0) {
                j |= z2 ? 64 : 32;
            }
            i2 = z ? 8 : 0;
            i3 = z3 ? 0 : 4;
            if (!z2) {
                i4 = 4;
            }
        } else {
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            i3 = 0;
            str2 = null;
            str = null;
            i2 = 0;
        }
        if ((6 & j) != 0) {
            ImageView imageView = this.f23920a;
            b.a.C0750a a2 = com.paytm.utility.b.b.a(imageView.getContext());
            a2.f43753a = str5;
            b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
            com.travel.flight.flightorder.j.e.a(this.o, str6);
            this.p.setVisibility(i2);
            com.travel.flight.flightorder.j.e.b(this.p, str3);
            this.q.setVisibility(i4);
            com.travel.flight.flightorder.j.e.a(this.r, str7);
            this.s.setVisibility(i3);
            com.travel.flight.flightorder.j.e.b(this.f23925f, str4);
            androidx.databinding.a.d.a((TextView) this.f23926g, (CharSequence) str2);
            androidx.databinding.a.d.a((TextView) this.f23927h, (CharSequence) str);
        }
        if ((j & 4) != 0) {
            this.n.setOnClickListener(this.t);
            this.p.setBackgroundResource(R.drawable.strike_through_line_white);
        }
    }

    public final void a(int i2, View view) {
        Context context;
        e.a aVar = this.j;
        if ((aVar != null) && com.travel.flight.flightorder.j.e.this.f24478b != null) {
            String str = com.travel.flight.flightorder.j.e.this.f24478b.f25414b;
            if (!TextUtils.isEmpty(str) && (context = com.travel.flight.flightorder.j.e.this.f24477a.getRoot().getContext()) != null) {
                com.travel.flight.b.a();
                com.travel.flight.b.b().a(str, context, (String) null);
            }
        }
    }
}
