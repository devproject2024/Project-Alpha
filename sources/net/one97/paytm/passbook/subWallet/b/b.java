package net.one97.paytm.passbook.subWallet.b;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import net.one97.paytm.common.widgets.f;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.subWallet.a;

public final class b extends a {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f58818b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EditText f58819c;

    /* renamed from: d  reason: collision with root package name */
    private String f58820d;

    public b(Activity activity, String str, a aVar) {
        super(activity);
        this.f58818b = aVar;
        this.f58820d = str;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.pass_lyt_prompt_amt_dialog);
        this.f58819c = (EditText) findViewById(R.id.edit_amount);
        try {
            String a2 = d.b().a("max_digit_paytmcash");
            int parseInt = !TextUtils.isEmpty(a2) ? Integer.parseInt(a2) : 0;
            if (parseInt <= 0) {
                parseInt = 5;
            }
            this.f58819c.setFilters(new InputFilter[]{new f(parseInt, 2)});
            this.f58819c.requestFocus();
            if (this.f58820d != null) {
                this.f58819c.setText(this.f58820d);
            }
        } catch (Exception unused) {
        }
        ((Button) findViewById(R.id.btn_left)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b bVar = b.this;
                b.a(bVar, bVar.f58819c);
                b.this.dismiss();
            }
        });
        ((Button) findViewById(R.id.btn_right)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b bVar = b.this;
                b.a(bVar, bVar.f58819c);
                if (b.this.f58818b != null) {
                    b.this.f58818b.a(b.this.f58819c.getText().toString());
                }
                b.this.dismiss();
            }
        });
    }

    static /* synthetic */ void a(b bVar, EditText editText) {
        try {
            ((InputMethodManager) bVar.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Exception unused) {
        }
    }
}
