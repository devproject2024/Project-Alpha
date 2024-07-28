package net.one97.paytm.upgradeKyc.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.i.f;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upi.util.UpiConstants;

public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    Button f65656a;

    /* renamed from: b  reason: collision with root package name */
    TextView f65657b;

    /* renamed from: c  reason: collision with root package name */
    TextView f65658c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f65659d;

    /* renamed from: e  reason: collision with root package name */
    BottomSheetBehavior f65660e;

    /* renamed from: f  reason: collision with root package name */
    TextView f65661f;

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                a.this.a(dialogInterface);
            }
        });
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            this.f65660e = BottomSheetBehavior.from(frameLayout);
        }
        this.f65660e.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    d.a aVar = d.f66026a;
                    if (d.a.a() != null) {
                        d.a aVar2 = d.f66026a;
                        d.a.a();
                        if (d.a("full_kyc_pop_up_mandate", false)) {
                            a.this.f65660e.setState(3);
                        }
                    }
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r4, android.view.ViewGroup r5, android.os.Bundle r6) {
        /*
            r3 = this;
            int r6 = net.one97.paytm.upgradeKyc.R.layout.fragment_full_kyc_bottom_sheet
            r0 = 0
            android.view.View r4 = r4.inflate(r6, r5, r0)
            int r5 = net.one97.paytm.upgradeKyc.R.id.full_kyc_complete_kyc_btn
            android.view.View r5 = r4.findViewById(r5)
            android.widget.Button r5 = (android.widget.Button) r5
            r3.f65656a = r5
            int r5 = net.one97.paytm.upgradeKyc.R.id.full_kyc_do_it_later_tv
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f65657b = r5
            int r5 = net.one97.paytm.upgradeKyc.R.id.full_kyc_cross_iv
            android.view.View r5 = r4.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.f65659d = r5
            int r5 = net.one97.paytm.upgradeKyc.R.id.full_kyc_know_more_tv
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f65658c = r5
            int r5 = net.one97.paytm.upgradeKyc.R.id.full_kyc_yellow_strip_complete_kyc_tv
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f65661f = r5
            androidx.fragment.app.FragmentActivity r5 = r3.getActivity()
            r6 = 8
            r1 = 1
            if (r5 == 0) goto L_0x0061
            net.one97.paytm.upgradeKyc.helper.d$a r5 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r5 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r5 == 0) goto L_0x0061
            net.one97.paytm.upgradeKyc.helper.d$a r5 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d.a.a()
            java.lang.String r5 = "kyc_complete_cashback_view"
            boolean r5 = net.one97.paytm.upgradeKyc.helper.d.a(r5, r1)
            if (r5 == 0) goto L_0x0061
            int r5 = net.one97.paytm.upgradeKyc.R.id.full_kyc_yellow_strip_lyt
            android.view.View r5 = r4.findViewById(r5)
            r5.setVisibility(r6)
            goto L_0x006a
        L_0x0061:
            int r5 = net.one97.paytm.upgradeKyc.R.id.full_kyc_yellow_strip_lyt
            android.view.View r5 = r4.findViewById(r5)
            r5.setVisibility(r0)
        L_0x006a:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            net.one97.paytm.upgradeKyc.helper.d$a r2 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r2 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r2 == 0) goto L_0x0083
            net.one97.paytm.upgradeKyc.helper.d$a r5 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d.a.a()
            java.lang.String r5 = "full_kyc_pop_up_mandate"
            boolean r5 = net.one97.paytm.upgradeKyc.helper.d.a(r5, r0)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
        L_0x0083:
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x009c
            android.widget.ImageView r5 = r3.f65659d
            r5.setVisibility(r6)
            android.app.Dialog r5 = r3.getDialog()
            if (r5 == 0) goto L_0x00ae
            android.app.Dialog r5 = r3.getDialog()
            r5.setCanceledOnTouchOutside(r0)
            goto L_0x00ae
        L_0x009c:
            android.widget.ImageView r5 = r3.f65659d
            r5.setVisibility(r0)
            android.app.Dialog r5 = r3.getDialog()
            if (r5 == 0) goto L_0x00ae
            android.app.Dialog r5 = r3.getDialog()
            r5.setCanceledOnTouchOutside(r1)
        L_0x00ae:
            r5 = 0
            net.one97.paytm.upgradeKyc.helper.d$a r6 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r6 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r6 == 0) goto L_0x00c2
            net.one97.paytm.upgradeKyc.helper.d$a r5 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d.a.a()
            java.lang.String r5 = "kycCashbackText"
            java.lang.String r5 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r5)
        L_0x00c2:
            android.widget.TextView r6 = r3.f65661f
            r6.setText(r5)
            android.widget.Button r5 = r3.f65656a
            net.one97.paytm.upgradeKyc.d.-$$Lambda$a$ZUoR3Vuf81scZA_d-u4WpfjfDIg r6 = new net.one97.paytm.upgradeKyc.d.-$$Lambda$a$ZUoR3Vuf81scZA_d-u4WpfjfDIg
            r6.<init>()
            r5.setOnClickListener(r6)
            android.widget.ImageView r5 = r3.f65659d
            net.one97.paytm.upgradeKyc.d.-$$Lambda$a$z7kkqCb3zrMmsKQ3hSY0Q8EbisU r6 = new net.one97.paytm.upgradeKyc.d.-$$Lambda$a$z7kkqCb3zrMmsKQ3hSY0Q8EbisU
            r6.<init>()
            r5.setOnClickListener(r6)
            android.widget.TextView r5 = r3.f65658c
            net.one97.paytm.upgradeKyc.d.-$$Lambda$a$KITYRfMKXzpwGM2A-qknEvX3ljk r6 = new net.one97.paytm.upgradeKyc.d.-$$Lambda$a$KITYRfMKXzpwGM2A-qknEvX3ljk
            r6.<init>()
            r5.setOnClickListener(r6)
            net.one97.paytm.upgradeKyc.helper.e$a r5 = net.one97.paytm.upgradeKyc.helper.e.f66028b
            net.one97.paytm.upgradeKyc.helper.f r5 = net.one97.paytm.upgradeKyc.helper.e.a.b()
            androidx.fragment.app.FragmentActivity r6 = r3.getActivity()
            java.lang.String r0 = "/full-kyc/popup"
            java.lang.String r1 = "kyc"
            r5.a((java.lang.String) r0, (java.lang.String) r1, (android.content.Context) r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.d.a.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        e.a aVar = e.f66028b;
        e.a.b().a(getActivity(), "complete_full_kyc_popup", "complete_kyc_clicked", new ArrayList(), "", "/full-kyc/popup/", "kyc");
        startActivity(new Intent(getActivity(), UpgradeKycActivity.class));
        dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        e.a aVar = e.f66028b;
        e.a.b().a(getActivity(), "complete_full_kyc_popup", "popup_closed", new ArrayList(), "", "/full-kyc/popup/", "kyc");
        dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String str;
        d.a aVar = d.f66026a;
        Intent intent = null;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("url_kyc_know_more");
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
                intent.putExtra("title", getString(net.one97.paytm.upgradeKyc.R.string.link_your_aadhaar));
                intent.putExtra(UpiConstants.FROM, getString(net.one97.paytm.upgradeKyc.R.string.link_your_aadhaar));
                intent.putExtra("Close", true);
                startActivity(intent);
            }
        }
    }
}
