package net.one97.paytm.p2mNewDesign.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import net.one97.paytm.i.h;
import net.one97.paytm.p2mNewDesign.d.b;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.f.a;

public class c extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f51061a;

    /* renamed from: b  reason: collision with root package name */
    private View f51062b;

    /* renamed from: c  reason: collision with root package name */
    private Button f51063c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f51064d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f51065e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f51066f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f51067g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f51068h;

    public static c a(a aVar) {
        c cVar = new c();
        cVar.f51061a = aVar;
        return cVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z = false;
        this.f51062b = layoutInflater.inflate(R.layout.d_cvv_help, viewGroup, false);
        this.f51063c = (Button) this.f51062b.findViewById(R.id.btn_proceed);
        this.f51063c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (c.this.f51061a != null) {
                    c.this.f51061a.a();
                }
            }
        });
        this.f51064d = (TextView) this.f51062b.findViewById(R.id.tv_cvv_desc);
        this.f51065e = (ImageView) this.f51062b.findViewById(R.id.iv_card_image);
        this.f51066f = (ImageView) this.f51062b.findViewById(R.id.iv_close_icon);
        this.f51066f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (c.this.f51061a != null) {
                    c.this.f51061a.a();
                }
            }
        });
        this.f51067g = getArguments().getBoolean(b.a.AMEX.name(), false);
        if (getArguments().getBoolean(b.a.NON_AMEX.name(), false) || getArguments().getBoolean(b.a.ALL.name(), false)) {
            z = true;
        }
        this.f51068h = z;
        if (this.f51067g) {
            this.f51064d.setText(getString(R.string.cvv_desc_amex));
            this.f51065e.setImageDrawable(androidx.core.content.b.a(getContext(), R.drawable.cvv_help_amex));
        } else {
            this.f51064d.setText(getString(R.string.cvv_desc));
            this.f51065e.setImageDrawable(androidx.core.content.b.a(getContext(), R.drawable.cvv_help));
        }
        return this.f51062b;
    }
}
