package net.one97.paytm.wallet.newdesign.addbeneficiary;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;

public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    public Context f70612a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f70613b;

    /* renamed from: c  reason: collision with root package name */
    private Button f70614c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f70615d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f70616e;

    public static d a() {
        return new d();
    }

    public final void a(Activity activity) {
        this.f70612a = activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ab_limit_alert_bottom_sheet_fragment, viewGroup, false);
        this.f70613b = (ImageView) inflate.findViewById(R.id.iv_dismiss);
        this.f70614c = (Button) inflate.findViewById(R.id.btn_dismiss);
        this.f70615d = (TextView) inflate.findViewById(R.id.tv_title_message);
        this.f70616e = (TextView) inflate.findViewById(R.id.tv_detail_message);
        if (this.f70612a != null) {
            String stringFromGTM = b.a().getStringFromGTM(this.f70612a, "p2pBeneficiaryCoolingAmt");
            String stringFromGTM2 = b.a().getStringFromGTM(this.f70612a, "p2pBeneficiaryCoolingPeriod");
            if (!TextUtils.isEmpty(stringFromGTM)) {
                this.f70615d.setText(this.f70612a.getString(R.string.add_beneficiary_limit_alert_title, new Object[]{stringFromGTM}));
            } else {
                this.f70615d.setText(this.f70612a.getString(R.string.add_beneficiary_limit_alert_title, new Object[]{"20,000"}));
            }
            if (TextUtils.isEmpty(stringFromGTM) || TextUtils.isEmpty(stringFromGTM2)) {
                this.f70616e.setText(this.f70612a.getString(R.string.add_bene_success_message, new Object[]{"15 minutes", "20,000"}));
            } else {
                this.f70616e.setText(this.f70612a.getString(R.string.add_bene_success_message, new Object[]{stringFromGTM2, stringFromGTM}));
            }
        }
        this.f70613b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.b(view);
            }
        });
        this.f70614c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }
}
