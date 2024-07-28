package net.one97.paytm.wallet.c;

import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.h;
import net.one97.paytm.helper.a;
import net.one97.paytm.i.f;

public class k extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f70059a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f70060b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f70061c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f70062d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f70063e;

    /* renamed from: f  reason: collision with root package name */
    private String f70064f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f70065g = null;

    /* renamed from: h  reason: collision with root package name */
    private Spanned f70066h;

    /* renamed from: i  reason: collision with root package name */
    private View f70067i;
    private CheckBox j;
    private View.OnClickListener k = null;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.gift_voucher_bottomsheet_addmoney, viewGroup, false);
        this.f70059a = (ImageView) inflate.findViewById(R.id.iv_close);
        this.f70060b = (TextView) inflate.findViewById(R.id.tv_gift_heading);
        this.f70061c = (TextView) inflate.findViewById(R.id.tv_gift_desc);
        this.f70062d = (TextView) inflate.findViewById(R.id.bottomsheetbutton);
        this.f70067i = inflate.findViewById(R.id.vwSeparator);
        this.j = (CheckBox) inflate.findViewById(R.id.checkbox);
        this.f70059a.setOnClickListener(this);
        if (this.f70063e) {
            this.f70067i.setVisibility(8);
            this.j.setVisibility(0);
            this.f70062d.setEnabled(false);
            this.f70062d.setVisibility(0);
            this.f70062d.setOnClickListener(this.k);
            String str = this.f70064f;
            if (str != null) {
                this.f70060b.setText(str);
            }
            Spanned spanned = this.f70066h;
            if (spanned != null) {
                this.f70061c.setText(spanned);
            } else {
                this.f70061c.setText(String.format(getString(R.string.paytm_gift_voucher_balance), new Object[]{a.b().l()}));
            }
            String str2 = this.f70065g;
            if (str2 != null) {
                this.f70062d.setText(str2);
            }
        } else {
            this.f70067i.setVisibility(8);
            this.j.setVisibility(8);
            this.f70062d.setVisibility(0);
            this.f70062d.setOnClickListener(this.k);
            String str3 = this.f70064f;
            if (str3 != null) {
                this.f70060b.setText(str3);
            }
            Spanned spanned2 = this.f70066h;
            if (spanned2 != null) {
                this.f70061c.setText(spanned2);
            } else {
                this.f70061c.setText(String.format(getString(R.string.paytm_gift_voucher_balance), new Object[]{a.b().l()}));
            }
            String str4 = this.f70065g;
            if (str4 != null) {
                this.f70062d.setText(str4);
            }
        }
        this.j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    k.this.f70062d.setEnabled(true);
                    h.a(k.this.getContext().getApplicationContext()).a("show_confirmation_sheet", true, false);
                    return;
                }
                k.this.f70062d.setEnabled(false);
                h.a(k.this.getContext().getApplicationContext()).a("show_confirmation_sheet", false, false);
            }
        });
        return inflate;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_close) {
            dismiss();
        }
    }
}
