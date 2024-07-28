package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterLocalityAndHotelChainViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.c.a.b;

public final class an extends am implements b.a {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f29166i = null;
    private static final SparseIntArray j;
    private final RelativeLayout k;
    private final TextView l;
    private final EditText m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private a q;
    private long r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.search_layout, 7);
        j.put(R.id.filter_list, 8);
        j.put(R.id.bottom_bar, 9);
    }

    public an(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, f29166i, j));
    }

    private an(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[9], objArr[5], objArr[6], objArr[8], objArr[1], objArr[7], objArr[2]);
        this.r = -1;
        this.f29159b.setTag((Object) null);
        this.f29160c.setTag((Object) null);
        this.f29162e.setTag((Object) null);
        this.k = objArr[0];
        this.k.setTag((Object) null);
        this.l = objArr[3];
        this.l.setTag((Object) null);
        this.m = objArr[4];
        this.m.setTag((Object) null);
        this.f29164g.setTag((Object) null);
        setRootTag(view);
        this.n = new b(this, 3);
        this.o = new b(this, 1);
        this.p = new b(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.r = 4;
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
        if (net.one97.paytm.hotels2.a.t != i2) {
            return false;
        }
        a((SRPFilterLocalityAndHotelChainViewModel) obj);
        return true;
    }

    public final void a(SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel) {
        this.f29165h = sRPFilterLocalityAndHotelChainViewModel;
        synchronized (this) {
            this.r |= 2;
        }
        notifyPropertyChanged(net.one97.paytm.hotels2.a.t);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return b(i3);
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.hotels2.a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.r |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.r     // Catch:{ all -> 0x00f0 }
            r4 = 0
            r1.r = r4     // Catch:{ all -> 0x00f0 }
            monitor-exit(r18)     // Catch:{ all -> 0x00f0 }
            net.one97.paytm.hotel4.viewmodel.filter.SRPFilterLocalityAndHotelChainViewModel r0 = r1.f29165h
            r6 = 7
            long r8 = r2 & r6
            r10 = 6
            r12 = 16
            r14 = 1
            r15 = 0
            r6 = 0
            int r7 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0068
            if (r0 == 0) goto L_0x0022
            com.travel.utils.l r8 = r0.getFilterCount()
            goto L_0x0023
        L_0x0022:
            r8 = r6
        L_0x0023:
            r1.updateLiveDataRegistration(r15, r8)
            if (r8 == 0) goto L_0x002f
            java.lang.Object r8 = r8.getValue()
            java.lang.Integer r8 = (java.lang.Integer) r8
            goto L_0x0030
        L_0x002f:
            r8 = r6
        L_0x0030:
            int r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r8)
            if (r8 <= 0) goto L_0x0038
            r9 = 1
            goto L_0x0039
        L_0x0038:
            r9 = 0
        L_0x0039:
            if (r7 == 0) goto L_0x0043
            if (r9 == 0) goto L_0x003f
            long r2 = r2 | r12
            goto L_0x0043
        L_0x003f:
            r16 = 8
            long r2 = r2 | r16
        L_0x0043:
            long r16 = r2 & r10
            int r7 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0064
            if (r0 == 0) goto L_0x0064
            java.lang.String r7 = r0.getTitle()
            net.one97.paytm.hotels2.b.an$a r15 = r1.q
            if (r15 != 0) goto L_0x005a
            net.one97.paytm.hotels2.b.an$a r15 = new net.one97.paytm.hotels2.b.an$a
            r15.<init>()
            r1.q = r15
        L_0x005a:
            r15.f29167a = r0
            if (r0 != 0) goto L_0x005f
            r15 = r6
        L_0x005f:
            java.lang.String r0 = r0.getHint()
            goto L_0x006d
        L_0x0064:
            r0 = r6
            r7 = r0
            r15 = r7
            goto L_0x006d
        L_0x0068:
            r0 = r6
            r7 = r0
            r15 = r7
            r8 = 0
            r9 = 0
        L_0x006d:
            long r12 = r12 & r2
            int r17 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x009f
            java.lang.String r12 = java.lang.String.valueOf(r8)
            if (r8 != r14) goto L_0x007b
            r16 = 1
            goto L_0x007d
        L_0x007b:
            r16 = 0
        L_0x007d:
            if (r17 == 0) goto L_0x0087
            if (r16 == 0) goto L_0x0084
            r13 = 64
            goto L_0x0086
        L_0x0084:
            r13 = 32
        L_0x0086:
            long r2 = r2 | r13
        L_0x0087:
            android.widget.TextView r8 = r1.f29164g
            android.content.res.Resources r8 = r8.getResources()
            if (r16 == 0) goto L_0x0092
            int r13 = net.one97.paytm.hotels2.R.string.hotels_msg_filter_applied
            goto L_0x0094
        L_0x0092:
            int r13 = net.one97.paytm.hotels2.R.string.hotels_msg_filters_applied
        L_0x0094:
            java.lang.String r8 = r8.getString(r13)
            if (r12 == 0) goto L_0x009f
            java.lang.String r8 = r12.concat(r8)
            goto L_0x00a0
        L_0x009f:
            r8 = r6
        L_0x00a0:
            r12 = 7
            long r12 = r12 & r2
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00b7
            if (r9 == 0) goto L_0x00aa
            goto L_0x00b8
        L_0x00aa:
            android.widget.TextView r8 = r1.f29164g
            android.content.res.Resources r8 = r8.getResources()
            int r9 = net.one97.paytm.hotels2.R.string.h4_empty
            java.lang.String r8 = r8.getString(r9)
            goto L_0x00b8
        L_0x00b7:
            r8 = r6
        L_0x00b8:
            r12 = 4
            long r12 = r12 & r2
            int r9 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00d4
            android.widget.TextView r9 = r1.f29159b
            android.view.View$OnClickListener r12 = r1.p
            r9.setOnClickListener(r12)
            android.widget.Button r9 = r1.f29160c
            android.view.View$OnClickListener r12 = r1.n
            r9.setOnClickListener(r12)
            android.widget.TextView r9 = r1.l
            android.view.View$OnClickListener r12 = r1.o
            r9.setOnClickListener(r12)
        L_0x00d4:
            long r2 = r2 & r10
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00e8
            android.widget.TextView r2 = r1.f29162e
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r7)
            android.widget.EditText r2 = r1.m
            r2.setHint(r0)
            android.widget.EditText r0 = r1.m
            androidx.databinding.a.d.a(r0, r15, r6, r6)
        L_0x00e8:
            if (r14 == 0) goto L_0x00ef
            android.widget.TextView r0 = r1.f29164g
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x00ef:
            return
        L_0x00f0:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x00f0 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.an.executeBindings():void");
    }

    public static class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        SRPFilterLocalityAndHotelChainViewModel f29167a;

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f29167a.onPasswordTextChanged(charSequence, i2, i3, i4);
        }
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = this.f29165h;
            if (sRPFilterLocalityAndHotelChainViewModel != null) {
                z = true;
            }
            if (z) {
                sRPFilterLocalityAndHotelChainViewModel.onClearClick();
            }
        } else if (i2 == 2) {
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel2 = this.f29165h;
            if (sRPFilterLocalityAndHotelChainViewModel2 != null) {
                z = true;
            }
            if (z) {
                sRPFilterLocalityAndHotelChainViewModel2.onCancelClick();
            }
        } else if (i2 == 3) {
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel3 = this.f29165h;
            if (sRPFilterLocalityAndHotelChainViewModel3 != null) {
                z = true;
            }
            if (z) {
                sRPFilterLocalityAndHotelChainViewModel3.onSaveClick();
            }
        }
    }
}
