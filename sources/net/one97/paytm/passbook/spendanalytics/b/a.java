package net.one97.paytm.passbook.spendanalytics.b;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.HashMap;

public final class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private int f58556a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f58557b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f58558c;

    public a() {
    }

    public a(int i2, ArrayList<String> arrayList) {
        this.f58556a = i2;
        this.f58557b = arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002e, code lost:
        r5 = kotlin.m.p.a((java.lang.CharSequence) (r5 = r5.get(r2.f58556a)), new java.lang.String[]{com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA});
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r3, android.view.ViewGroup r4, android.os.Bundle r5) {
        /*
            r2 = this;
            java.lang.String r5 = "inflater"
            kotlin.g.b.k.c(r3, r5)
            int r5 = net.one97.paytm.passbook.R.layout.pass_fragment_spend_analytics_home
            r0 = 0
            android.view.View r3 = r3.inflate(r5, r4, r0)
            java.lang.String r4 = "view"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            int r4 = net.one97.paytm.passbook.R.id.tvMonth
            android.view.View r4 = r3.findViewById(r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            java.lang.String r5 = "view.tvMonth"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.util.ArrayList<java.lang.String> r5 = r2.f58557b
            if (r5 == 0) goto L_0x0043
            int r1 = r2.f58556a
            java.lang.Object r5 = r5.get(r1)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0043
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r1 = ","
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.util.List r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.String[]) r1)
            if (r5 == 0) goto L_0x0043
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0044
        L_0x0043:
            r5 = 0
        L_0x0044:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.b.a.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f58558c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
