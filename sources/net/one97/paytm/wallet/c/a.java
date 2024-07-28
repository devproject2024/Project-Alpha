package net.one97.paytm.wallet.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import net.one97.paytm.i.h;
import net.one97.paytm.paytm_finance.R;

public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    Switch f69977a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f69978b;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_add_money_refund, (ViewGroup) null);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityCreated(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onActivityCreated(r7)
            android.view.View r7 = r6.getView()
            r0 = 2131369210(0x7f0a1cfa, float:1.8358392E38)
            android.view.View r7 = r7.findViewById(r0)
            android.widget.Switch r7 = (android.widget.Switch) r7
            r6.f69977a = r7
            android.view.View r7 = r6.getView()
            r0 = 2131369617(0x7f0a1e91, float:1.8359217E38)
            android.view.View r7 = r7.findViewById(r0)
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            r6.f69978b = r7
            android.widget.Switch r7 = r6.f69977a
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            boolean r0 = net.one97.paytm.wallet.utility.a.e((android.content.Context) r0)
            r7.setChecked(r0)
            android.widget.Switch r7 = r6.f69977a
            net.one97.paytm.wallet.c.a$1 r0 = new net.one97.paytm.wallet.c.a$1
            r0.<init>()
            r7.setOnCheckedChangeListener(r0)
            android.widget.LinearLayout r7 = r6.f69978b
            r0 = 8
            r7.setVisibility(r0)
            com.paytm.utility.e$a[] r7 = com.paytm.utility.e.a.values()     // Catch:{ Exception -> 0x009f }
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()     // Catch:{ Exception -> 0x009f }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x009f }
            java.lang.String r0 = net.one97.paytm.wallet.utility.a.d((android.content.Context) r0)     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = ""
            r2 = 0
            r3 = r1
            r1 = 0
        L_0x0054:
            int r4 = r7.length     // Catch:{ Exception -> 0x009f }
            if (r1 >= r4) goto L_0x0076
            r4 = r7[r1]     // Catch:{ Exception -> 0x009f }
            if (r0 == 0) goto L_0x0073
            java.lang.String r5 = r4.getWalletUserState()     // Catch:{ Exception -> 0x009f }
            boolean r5 = r0.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x009f }
            if (r5 != 0) goto L_0x006f
            java.lang.String r5 = r4.getv2UserState()     // Catch:{ Exception -> 0x009f }
            boolean r5 = r0.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x009f }
            if (r5 == 0) goto L_0x0073
        L_0x006f:
            java.lang.String r3 = r4.getv2UserState()     // Catch:{ Exception -> 0x009f }
        L_0x0073:
            int r1 = r1 + 1
            goto L_0x0054
        L_0x0076:
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x009f }
            java.lang.String r7 = "AddMoneyRefundOption"
            r0 = 0
            java.lang.String r7 = net.one97.paytm.j.c.a((java.lang.String) r7, (java.lang.String) r0)     // Catch:{ Exception -> 0x009f }
            java.lang.String r0 = ","
            java.lang.String[] r7 = r7.split(r0)     // Catch:{ Exception -> 0x009f }
            if (r7 == 0) goto L_0x009f
            int r0 = r7.length     // Catch:{  }
            if (r0 <= 0) goto L_0x009f
            int r0 = r7.length     // Catch:{  }
            r1 = 0
        L_0x008d:
            if (r1 >= r0) goto L_0x009f
            r4 = r7[r1]     // Catch:{  }
            boolean r4 = r4.equalsIgnoreCase(r3)     // Catch:{  }
            if (r4 == 0) goto L_0x009c
            android.widget.LinearLayout r4 = r6.f69978b     // Catch:{  }
            r4.setVisibility(r2)     // Catch:{  }
        L_0x009c:
            int r1 = r1 + 1
            goto L_0x008d
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.c.a.onActivityCreated(android.os.Bundle):void");
    }
}
