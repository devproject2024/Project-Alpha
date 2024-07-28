package net.one97.paytm.newaddmoney.view;

import android.content.DialogInterface;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.i.f;

public final class g extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55957a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private TextView f55958b;

    /* renamed from: c  reason: collision with root package name */
    private String f55959c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f55960d;

    /* renamed from: e  reason: collision with root package name */
    private String f55961e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f55962f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: type inference failed for: r5v11, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r4, android.view.ViewGroup r5, android.os.Bundle r6) {
        /*
            r3 = this;
            java.lang.String r5 = "inflater"
            kotlin.g.b.k.c(r4, r5)
            int r5 = net.one97.paytm.addmoney.R.layout.layout_new_add_money_offer_detail
            r6 = 0
            android.view.View r4 = r4.inflate(r5, r6)
            android.os.Bundle r5 = r3.getArguments()
            if (r5 == 0) goto L_0x0019
            java.lang.String r0 = "OFFER_DETAIL"
            java.lang.String r5 = r5.getString(r0)
            goto L_0x001a
        L_0x0019:
            r5 = r6
        L_0x001a:
            r3.f55959c = r5
            android.os.Bundle r5 = r3.getArguments()
            if (r5 == 0) goto L_0x0029
            java.lang.String r0 = "Selected_Coupon_Index"
            java.lang.String r5 = r5.getString(r0)
            goto L_0x002a
        L_0x0029:
            r5 = r6
        L_0x002a:
            r3.f55961e = r5
            if (r4 == 0) goto L_0x0037
            int r5 = net.one97.paytm.addmoney.R.id.tv_offer_list
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            goto L_0x0038
        L_0x0037:
            r5 = r6
        L_0x0038:
            r3.f55958b = r5
            if (r4 == 0) goto L_0x0045
            int r5 = net.one97.paytm.addmoney.R.id.tv_promo
            android.view.View r5 = r4.findViewById(r5)
            r6 = r5
            android.widget.TextView r6 = (android.widget.TextView) r6
        L_0x0045:
            r3.f55960d = r6
            android.widget.TextView r5 = r3.f55958b
            if (r5 == 0) goto L_0x0052
            java.lang.String r6 = r3.f55959c
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
        L_0x0052:
            android.widget.TextView r5 = r3.f55960d
            if (r5 == 0) goto L_0x0069
            int r6 = net.one97.paytm.addmoney.R.string.promocode_value
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.String r2 = r3.f55961e
            r0[r1] = r2
            java.lang.String r6 = r3.getString(r6, r0)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
        L_0x0069:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.g.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        d.a(getContext(), "add_money", "add_money_enter_amount_have_promo_view_T&C_close", "/home-screen/add-money/", (String) null, (String) null);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f55962f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
