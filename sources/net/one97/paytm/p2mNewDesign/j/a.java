package net.one97.paytm.p2mNewDesign.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import java.util.ArrayList;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.utils.ad;
import net.one97.paytm.wallet.R;

public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f13364a;

    /* renamed from: b  reason: collision with root package name */
    public View f13365b;

    /* renamed from: c  reason: collision with root package name */
    public InstrumentInfo f13366c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f13367d;

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.p2mNewDesign.b.a f13368e;

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.p2mNewDesign.b.a f13369f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<InstrumentInfo> f13370g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13371h;

    /* renamed from: i  reason: collision with root package name */
    private g f13372i;

    public a(Context context, g gVar) {
        this.f13364a = context;
        this.f13372i = gVar;
        this.f13368e = gVar.g();
        this.f13369f = gVar.h();
    }

    public final void onClick(View view) {
        b.f();
        String str = "";
        if (!b.q("emi")) {
            g gVar = this.f13372i;
            if ("0".equalsIgnoreCase(b.f().A)) {
                str = "This merchant can not accept payment through Paytm Balance at the moment, so please pay with other options.";
            }
            gVar.a(str, false, false);
        } else if (view.getId() == R.id.tv_select_emi) {
            if (!(b.f().n == null || !TextUtils.isEmpty(b.f().n.getBankCode()) || this.f13366c == null)) {
                b.f().n.setBankCode(this.f13366c.getBankCode());
            }
            if (!(b.f().n == null || !TextUtils.isEmpty(b.f().n.getBankName()) || this.f13366c == null)) {
                b.f().n.setBankName(this.f13366c.getBankName());
            }
            if (!(b.f().n == null || b.f().n.getSelectedEMIPlan() != null || this.f13366c == null)) {
                b.f().n.setSelectedEMIPlan(this.f13366c.getSelectedEMIPlan());
            }
            b.f().n.setPaymodeType(this.f13366c.getCardType());
            a(this.f13365b);
            this.f13372i.a((InstrumentInfo) null, "openEMIPlanBottomSheet");
        } else if (view.getId() != R.id.tv_select_bank) {
        } else {
            if (d() == ad.EMI_OUT_OF_RANGE.getEMIAvailability()) {
                this.f13365b.setAlpha(0.4f);
                if (b.f().w() != null) {
                    g gVar2 = this.f13372i;
                    Context context = this.f13364a;
                    int i2 = R.string.emi_range_mismatch;
                    Object[] objArr = new Object[1];
                    if (b.f().w() != null) {
                        str = com.paytm.utility.b.S(String.valueOf(b.f().w().getValue()));
                    }
                    objArr[0] = str;
                    gVar2.a(String.format(context.getString(i2, objArr), new Object[0]), true, true);
                    return;
                }
                return;
            }
            this.f13370g = b.f().o(this.f13372i.d());
            ArrayList<InstrumentInfo> arrayList = this.f13370g;
            if (arrayList == null || arrayList.size() == 0) {
                this.f13371h = true;
                a();
                return;
            }
            this.f13372i.a((InstrumentInfo) null, "openEMIBankList");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r4 = this;
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r4.f13366c
            java.lang.String r1 = "Select EMI"
            r2 = 8
            if (r0 == 0) goto L_0x0063
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r4.f13366c
            net.one97.paytm.p2mNewDesign.f.g r3 = r4.f13372i
            java.lang.String r3 = r3.d()
            boolean r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0, (java.lang.String) r3)
            if (r0 == 0) goto L_0x0063
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            if (r0 == 0) goto L_0x0094
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r4.f13366c
            java.lang.String r0 = r0.getDisplaySecondaryInfo()
            if (r0 == 0) goto L_0x0094
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getDisplaySecondaryInfo()
            if (r0 == 0) goto L_0x0094
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r4.f13366c
            java.lang.String r0 = r0.getDisplaySecondaryInfo()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            java.lang.String r3 = r3.getDisplaySecondaryInfo()
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 != 0) goto L_0x0094
            android.view.View r0 = r4.f13365b
            int r3 = net.one97.paytm.wallet.R.id.tv_select_emi
            android.view.View r0 = r0.findViewById(r3)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setText(r1)
            android.widget.LinearLayout r0 = r4.f13367d
            r0.removeAllViews()
            android.widget.LinearLayout r0 = r4.f13367d
            r0.setVisibility(r2)
            goto L_0x0094
        L_0x0063:
            android.view.View r0 = r4.f13365b
            int r3 = net.one97.paytm.wallet.R.id.tv_select_emi
            android.view.View r0 = r0.findViewById(r3)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setText(r1)
            android.view.View r0 = r4.f13365b
            int r1 = net.one97.paytm.wallet.R.id.tv_select_bank
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "Select Bank"
            r0.setText(r1)
            android.widget.LinearLayout r0 = r4.f13367d
            r0.removeAllViews()
            android.widget.LinearLayout r0 = r4.f13367d
            r0.setVisibility(r2)
            android.view.View r0 = r4.f13365b
            int r1 = net.one97.paytm.wallet.R.id.tv_select_emi
            android.view.View r0 = r0.findViewById(r1)
            r0.setVisibility(r2)
        L_0x0094:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            if (r0 == 0) goto L_0x00b6
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            java.lang.String r1 = "emi"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x00b6
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            r4.f13366c = r0
        L_0x00b6:
            boolean r0 = r4.c()
            if (r0 != 0) goto L_0x00c4
            android.view.View r0 = r4.f13365b
            r1 = 1065353216(0x3f800000, float:1.0)
            r0.setAlpha(r1)
            return
        L_0x00c4:
            android.view.View r0 = r4.f13365b
            r1 = 1053609165(0x3ecccccd, float:0.4)
            r0.setAlpha(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.j.a.a():void");
    }

    public final void b() {
        this.f13370g = b.f().o(this.f13372i.d());
        ArrayList<InstrumentInfo> arrayList = this.f13370g;
        if (arrayList == null || arrayList.size() == 0) {
            this.f13371h = true;
            a();
            return;
        }
        a();
        this.f13365b.setAlpha(1.0f);
    }

    public final boolean c() {
        return b.f().o(this.f13372i.d()).size() == 0;
    }

    public final int d() {
        String d2 = this.f13372i.d();
        ArrayList<InstrumentInfo> o = b.f().o(this.f13372i.d());
        if (TextUtils.isEmpty(d2) || d2.equalsIgnoreCase("0")) {
            return ad.AMOUNT_NOT_ENTERED.getEMIAvailability();
        }
        if (o.size() == 0) {
            return ad.EMI_OUT_OF_RANGE.getEMIAvailability();
        }
        return ad.EMI_AVAILABLE.getEMIAvailability();
    }

    public final void a(View view) {
        Context context = this.f13364a;
        if (context != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (view != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
