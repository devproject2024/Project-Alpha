package net.one97.paytm.upgradeKyc.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.utility.b;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upi.util.UpiConstants;

public class d extends h {

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f65677a;

    /* renamed from: b  reason: collision with root package name */
    TextView f65678b;

    public static d a() {
        d dVar = new d();
        dVar.setArguments(new Bundle());
        return dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_kyc_exclusive_benefits, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r2, android.os.Bundle r3) {
        /*
            r1 = this;
            super.onViewCreated(r2, r3)
            int r3 = net.one97.paytm.upgradeKyc.R.id.lyt_kyc_cashback_lyt
            android.view.View r3 = r2.findViewById(r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r1.f65677a = r3
            int r3 = net.one97.paytm.upgradeKyc.R.id.kyc_yellow_strip_complete_kyc_tv
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r1.f65678b = r3
            int r3 = net.one97.paytm.upgradeKyc.R.id.kyc_exclusive_button_proceed
            android.view.View r3 = r2.findViewById(r3)
            net.one97.paytm.upgradeKyc.d.-$$Lambda$d$RjdbgtMhjfxkalnjz7IjslnPoHQ r0 = new net.one97.paytm.upgradeKyc.d.-$$Lambda$d$RjdbgtMhjfxkalnjz7IjslnPoHQ
            r0.<init>()
            r3.setOnClickListener(r0)
            net.one97.paytm.upgradeKyc.helper.d$a r3 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r3 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r3 == 0) goto L_0x0042
            net.one97.paytm.upgradeKyc.helper.d$a r3 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d.a.a()
            r3 = 1
            java.lang.String r0 = "kyc_complete_cashback_view"
            boolean r3 = net.one97.paytm.upgradeKyc.helper.d.a(r0, r3)
            if (r3 == 0) goto L_0x0042
            android.widget.RelativeLayout r3 = r1.f65677a
            r0 = 0
            r3.setVisibility(r0)
            goto L_0x0049
        L_0x0042:
            android.widget.RelativeLayout r3 = r1.f65677a
            r0 = 8
            r3.setVisibility(r0)
        L_0x0049:
            int r3 = net.one97.paytm.upgradeKyc.R.id.kyc_yellow_strip_know_more_tv
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            net.one97.paytm.upgradeKyc.d.-$$Lambda$d$fMqrUfKTvzWLA4fAxH5-lfCcCjU r3 = new net.one97.paytm.upgradeKyc.d.-$$Lambda$d$fMqrUfKTvzWLA4fAxH5-lfCcCjU
            r3.<init>()
            r2.setOnClickListener(r3)
            r2 = 0
            net.one97.paytm.upgradeKyc.helper.d$a r3 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r3 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r3 == 0) goto L_0x006d
            net.one97.paytm.upgradeKyc.helper.d$a r2 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d.a.a()
            java.lang.String r2 = "kycCashbackText"
            java.lang.String r2 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r2)
        L_0x006d:
            android.widget.TextView r3 = r1.f65678b
            r3.setText(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.d.d.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        getActivity().setResult(-1);
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String str;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        Intent intent = null;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            d.a.a();
            str = net.one97.paytm.upgradeKyc.helper.d.a("url_kyc_know_more");
        } else {
            str = null;
        }
        if (b.s(str)) {
            try {
                FragmentActivity activity = getActivity();
                e.a aVar3 = e.f66028b;
                intent = new Intent(activity, Class.forName(e.a.b().d()));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            if (intent != null) {
                intent.putExtra("url", str);
                intent.putExtra("title", getString(R.string.link_your_aadhaar));
                intent.putExtra(UpiConstants.FROM, getString(R.string.link_your_aadhaar));
                intent.putExtra("Close", true);
                startActivity(intent);
            }
        }
    }
}
