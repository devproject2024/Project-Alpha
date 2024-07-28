package net.one97.paytm.wallet.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.c.d;
import net.one97.paytm.wallet.newdesign.addmoney.c.a;

public class f extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f70005a;

    /* renamed from: b  reason: collision with root package name */
    private View f70006b;

    /* renamed from: c  reason: collision with root package name */
    private Button f70007c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f70008d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f70009e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f70010f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f70011g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f70012h;

    public static f a(a aVar) {
        f fVar = new f();
        fVar.f70005a = aVar;
        return fVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z = false;
        this.f70006b = layoutInflater.inflate(R.layout.d_cvv_help_addmoney, viewGroup, false);
        this.f70007c = (Button) this.f70006b.findViewById(R.id.btn_proceed);
        this.f70007c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (f.this.f70005a != null) {
                    f.this.f70005a.a();
                }
            }
        });
        this.f70008d = (TextView) this.f70006b.findViewById(R.id.tv_cvv_desc);
        this.f70009e = (ImageView) this.f70006b.findViewById(R.id.iv_card_image);
        this.f70010f = (ImageView) this.f70006b.findViewById(R.id.iv_close_icon);
        this.f70010f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (f.this.f70005a != null) {
                    f.this.f70005a.a();
                }
            }
        });
        this.f70011g = getArguments().getBoolean(d.b.AMEX.name(), false);
        if (getArguments().getBoolean(d.b.NON_AMEX.name(), false) || getArguments().getBoolean(d.b.ALL.name(), false)) {
            z = true;
        }
        this.f70012h = z;
        if (this.f70011g) {
            this.f70008d.setText(getString(R.string.cvv_desc_amex));
            this.f70009e.setImageDrawable(b.a(getContext(), R.drawable.cvv_help_amex_addmoney));
        } else {
            this.f70008d.setText(getString(R.string.cvv_desc));
            this.f70009e.setImageDrawable(b.a(getContext(), R.drawable.cvv_help_addmomoney));
        }
        return this.f70006b;
    }
}
