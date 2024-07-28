package net.one97.paytm.recharge.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.c.a.a;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ALERT_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class l extends k implements a.C1166a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = null;
    private final NestedScrollView l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private long o;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public l(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, j, k));
    }

    private l(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[7], objArr[4], objArr[2], objArr[1], objArr[3], objArr[5]);
        this.o = -1;
        this.f60347a.setTag((Object) null);
        this.f60348b.setTag((Object) null);
        this.f60349c.setTag((Object) null);
        this.f60350d.setTag((Object) null);
        this.f60351e.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.f60352f.setTag((Object) null);
        this.f60353g.setTag((Object) null);
        setRootTag(view);
        this.m = new a(this, 2);
        this.n = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.o != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.recharge.a.f60180a == i2) {
            a((CJRUtilityAlertV2) obj);
        } else if (net.one97.paytm.recharge.a.f60181b != i2) {
            return false;
        } else {
            a((net.one97.paytm.recharge.common.fragment.e) obj);
        }
        return true;
    }

    public final void a(CJRUtilityAlertV2 cJRUtilityAlertV2) {
        this.f60354h = cJRUtilityAlertV2;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.recharge.a.f60180a);
        super.requestRebind();
    }

    public final void a(net.one97.paytm.recharge.common.fragment.e eVar) {
        this.f60355i = eVar;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(net.one97.paytm.recharge.a.f60181b);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r26 = this;
            r1 = r26
            monitor-enter(r26)
            long r2 = r1.o     // Catch:{ all -> 0x016d }
            r4 = 0
            r1.o = r4     // Catch:{ all -> 0x016d }
            monitor-exit(r26)     // Catch:{ all -> 0x016d }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2 r0 = r1.f60354h
            r6 = 5
            long r8 = r2 & r6
            r10 = 0
            r11 = 1
            r12 = 0
            int r13 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x005b
            if (r0 == 0) goto L_0x0033
            java.lang.String r10 = r0.getHeading()
            java.util.List r8 = r0.getRich_message()
            java.lang.String r9 = r0.getPositive_btn_txt()
            java.lang.String r14 = r0.getMessage()
            java.lang.String r15 = r0.getCheck_box_text()
            r25 = r10
            r10 = r8
            r8 = r25
            goto L_0x0037
        L_0x0033:
            r8 = r10
            r9 = r8
            r14 = r9
            r15 = r14
        L_0x0037:
            if (r10 != 0) goto L_0x003c
            r16 = 1
            goto L_0x003e
        L_0x003c:
            r16 = 0
        L_0x003e:
            if (r13 == 0) goto L_0x0049
            if (r16 == 0) goto L_0x0045
            r17 = 64
            goto L_0x0047
        L_0x0045:
            r17 = 32
        L_0x0047:
            long r2 = r2 | r17
        L_0x0049:
            r13 = r16 ^ 1
            long r17 = r2 & r6
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0062
            if (r13 == 0) goto L_0x0056
            r17 = 16
            goto L_0x0058
        L_0x0056:
            r17 = 8
        L_0x0058:
            long r2 = r2 | r17
            goto L_0x0062
        L_0x005b:
            r8 = r10
            r9 = r8
            r14 = r9
            r15 = r14
            r13 = 0
            r16 = 0
        L_0x0062:
            r17 = 40
            long r19 = r2 & r17
            r21 = 1024(0x400, double:5.06E-321)
            int r23 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0085
            if (r0 == 0) goto L_0x0072
            java.util.List r10 = r0.getRich_message()
        L_0x0072:
            if (r10 == 0) goto L_0x0077
            r19 = 1
            goto L_0x0079
        L_0x0077:
            r19 = 0
        L_0x0079:
            if (r23 == 0) goto L_0x0087
            if (r19 == 0) goto L_0x0080
            long r2 = r2 | r21
            goto L_0x0087
        L_0x0080:
            r23 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r23
            goto L_0x0087
        L_0x0085:
            r19 = 0
        L_0x0087:
            long r20 = r2 & r21
            int r22 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x0099
            if (r10 == 0) goto L_0x0094
            int r10 = r10.size()
            goto L_0x0095
        L_0x0094:
            r10 = 0
        L_0x0095:
            if (r10 != 0) goto L_0x0099
            r10 = 1
            goto L_0x009a
        L_0x0099:
            r10 = 0
        L_0x009a:
            long r17 = r2 & r17
            int r20 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x00a3
            if (r19 == 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r10 = 0
        L_0x00a4:
            long r17 = r2 & r6
            r19 = 256(0x100, double:1.265E-321)
            r21 = 8
            int r22 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x00de
            if (r13 == 0) goto L_0x00b2
            r13 = 1
            goto L_0x00b3
        L_0x00b2:
            r13 = r10
        L_0x00b3:
            if (r16 == 0) goto L_0x00b6
            r10 = 1
        L_0x00b6:
            if (r22 == 0) goto L_0x00c1
            if (r13 == 0) goto L_0x00bd
            r16 = 16384(0x4000, double:8.0948E-320)
            goto L_0x00bf
        L_0x00bd:
            r16 = 8192(0x2000, double:4.0474E-320)
        L_0x00bf:
            long r2 = r2 | r16
        L_0x00c1:
            long r16 = r2 & r6
            int r11 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00d8
            if (r10 == 0) goto L_0x00cf
            long r2 = r2 | r19
            r16 = 262144(0x40000, double:1.295163E-318)
            goto L_0x00d6
        L_0x00cf:
            r16 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r16
            r16 = 131072(0x20000, double:6.47582E-319)
        L_0x00d6:
            long r2 = r2 | r16
        L_0x00d8:
            if (r13 == 0) goto L_0x00db
            goto L_0x00df
        L_0x00db:
            r11 = 8
            goto L_0x00e0
        L_0x00de:
            r10 = 0
        L_0x00df:
            r11 = 0
        L_0x00e0:
            r16 = 262400(0x40100, double:1.29643E-318)
            long r16 = r2 & r16
            int r13 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00f6
            boolean r0 = net.one97.paytm.recharge.common.fragment.e.a((net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2) r0)
            long r16 = r2 & r19
            int r13 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00f7
            r13 = r0 ^ 1
            goto L_0x00f8
        L_0x00f6:
            r0 = 0
        L_0x00f7:
            r13 = 0
        L_0x00f8:
            long r16 = r2 & r6
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x012e
            if (r10 == 0) goto L_0x0101
            goto L_0x0102
        L_0x0101:
            r13 = 0
        L_0x0102:
            if (r10 == 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r0 = 0
        L_0x0106:
            if (r18 == 0) goto L_0x0111
            if (r13 == 0) goto L_0x010d
            r16 = 4096(0x1000, double:2.0237E-320)
            goto L_0x010f
        L_0x010d:
            r16 = 2048(0x800, double:1.0118E-320)
        L_0x010f:
            long r2 = r2 | r16
        L_0x0111:
            long r16 = r2 & r6
            int r10 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0122
            if (r0 == 0) goto L_0x011d
            r16 = 65536(0x10000, double:3.2379E-319)
            goto L_0x0120
        L_0x011d:
            r16 = 32768(0x8000, double:1.61895E-319)
        L_0x0120:
            long r2 = r2 | r16
        L_0x0122:
            if (r13 == 0) goto L_0x0126
            r10 = 0
            goto L_0x0128
        L_0x0126:
            r10 = 8
        L_0x0128:
            if (r0 == 0) goto L_0x012b
            goto L_0x012f
        L_0x012b:
            r12 = 8
            goto L_0x012f
        L_0x012e:
            r10 = 0
        L_0x012f:
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0157
            android.widget.CheckBox r0 = r1.f60347a
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
            android.widget.Button r0 = r1.f60348b
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            android.widget.LinearLayout r0 = r1.f60349c
            r0.setVisibility(r12)
            android.widget.TextView r0 = r1.f60351e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
            com.paytm.utility.RoboTextView r0 = r1.f60352f
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
            com.paytm.utility.RoboTextView r0 = r1.f60352f
            r0.setVisibility(r10)
            androidx.recyclerview.widget.RecyclerView r0 = r1.f60353g
            r0.setVisibility(r11)
        L_0x0157:
            r6 = 4
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x016c
            android.widget.Button r0 = r1.f60348b
            android.view.View$OnClickListener r2 = r1.m
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.f60350d
            android.view.View$OnClickListener r2 = r1.n
            r0.setOnClickListener(r2)
        L_0x016c:
            return
        L_0x016d:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x016d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.b.l.executeBindings():void");
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            net.one97.paytm.recharge.common.fragment.e eVar = this.f60355i;
            if (eVar != null) {
                z = true;
            }
            if (z) {
                eVar.dismiss();
            }
        } else if (i2 == 2) {
            net.one97.paytm.recharge.common.fragment.e eVar2 = this.f60355i;
            if (!(eVar2 != null)) {
                return;
            }
            if (eVar2.f61163d != null) {
                com.paytm.b.a.a a2 = ax.a(eVar2.getActivity().getApplicationContext());
                if (eVar2.f61162c.f60347a.isChecked()) {
                    a2.a(eVar2.f61161b, true, true);
                }
                if (eVar2.getArguments() != null) {
                    eVar2.f61163d.b(eVar2.getArguments().getBoolean("Verify", false));
                } else {
                    eVar2.f61163d.b(false);
                }
                eVar2.dismiss();
                return;
            }
            d dVar = d.f64967a;
            CJRRechargeErrorModel a3 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            if (a3.getFlowName() == null) {
                a3.setFlowName(new CRUFlowModel());
            }
            a3.getFlowName().setActionType(ACTION_TYPE.CLP_PROCEED.name());
            a3.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
            a3.getFlowName().setAlertType(ALERT_TYPE.PRE_VERIFY_PROCEED.name());
            if (eVar2.getContext() != null) {
                a3.setErrorMsg(eVar2.getContext().getString(R.string.pre_verify_proceed_listener_null, new Object[]{net.one97.paytm.recharge.common.fragment.e.class.getSimpleName(), "onProceedClickListener"}));
                az azVar = az.f61525a;
                az.a(a3);
            }
        }
    }
}
