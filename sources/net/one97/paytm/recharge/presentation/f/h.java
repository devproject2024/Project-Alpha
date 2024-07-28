package net.one97.paytm.recharge.presentation.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.squareup.picasso.w;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRPaymentModes;
import net.one97.paytm.recharge.presentation.d.d;

public final class h extends f {

    /* renamed from: a  reason: collision with root package name */
    final RadioButton f64874a = ((RadioButton) this.f64879f.findViewById(R.id.radio_btn));

    /* renamed from: b  reason: collision with root package name */
    final d f64875b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f64876c = ((TextView) this.f64879f.findViewById(R.id.txt_bank_name));

    /* renamed from: d  reason: collision with root package name */
    private final TextView f64877d = ((TextView) this.f64879f.findViewById(R.id.bank_number));

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f64878e = ((ImageView) this.f64879f.findViewById(R.id.ic_bank_logo));

    /* renamed from: f  reason: collision with root package name */
    private final View f64879f;

    /* renamed from: g  reason: collision with root package name */
    private String f64880g;

    /* renamed from: h  reason: collision with root package name */
    private final String f64881h;

    /* renamed from: i  reason: collision with root package name */
    private final String f64882i;
    private String j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(View view, d dVar, String str, String str2, String str3, String str4) {
        super(view);
        k.c(view, "mItemView");
        this.f64879f = view;
        this.f64875b = dVar;
        this.f64880g = str;
        this.f64881h = str2;
        this.f64882i = str3;
        this.j = str4;
    }

    public final <T> void a(T t) {
        String str = null;
        if (!TextUtils.isEmpty(this.j)) {
            RadioButton radioButton = this.f64874a;
            k.a((Object) radioButton, "radioBtn");
            radioButton.setChecked(true);
            this.j = null;
        } else if (t instanceof CJRPaymentModes) {
            if (((CJRPaymentModes) t).isSelected()) {
                RadioButton radioButton2 = this.f64874a;
                k.a((Object) radioButton2, "radioBtn");
                radioButton2.setChecked(true);
            } else {
                RadioButton radioButton3 = this.f64874a;
                k.a((Object) radioButton3, "radioBtn");
                radioButton3.setChecked(false);
                TextView textView = this.f64876c;
                k.a((Object) textView, "tvBankName");
                textView.setEnabled(false);
                this.f64879f.requestFocus();
                RadioButton radioButton4 = this.f64874a;
                k.a((Object) radioButton4, "radioBtn");
                radioButton4.setClickable(false);
            }
        }
        TextView textView2 = this.f64876c;
        k.a((Object) textView2, "tvBankName");
        Context context = this.f64879f.getContext();
        if (context != null) {
            str = context.getString(R.string.paytm_e_mandate_with_bank_name, new Object[]{this.f64880g});
        }
        textView2.setText(str);
        if (!TextUtils.isEmpty(this.f64882i)) {
            w.a().a(this.f64882i).a(this.f64878e);
            ImageView imageView = this.f64878e;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            ImageView imageView2 = this.f64878e;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        TextView textView3 = this.f64877d;
        if (textView3 != null) {
            textView3.setText(this.f64881h);
        }
        this.f64879f.setOnClickListener(new a(this, t));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f64883a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f64884b;

        a(h hVar, Object obj) {
            this.f64883a = hVar;
            this.f64884b = obj;
        }

        public final void onClick(View view) {
            RadioButton radioButton = this.f64883a.f64874a;
            k.a((Object) radioButton, "radioBtn");
            if (!radioButton.isChecked()) {
                RadioButton radioButton2 = this.f64883a.f64874a;
                k.a((Object) radioButton2, "radioBtn");
                radioButton2.setChecked(true);
                Object obj = this.f64884b;
                if (obj instanceof CJRPaymentModes) {
                    if (obj != null) {
                        ((CJRPaymentModes) obj).setSelected(true);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRPaymentModes");
                    }
                }
                d dVar = this.f64883a.f64875b;
                if (dVar != null) {
                    dVar.a(0, 5);
                }
            }
        }
    }
}
