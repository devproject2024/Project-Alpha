package net.one97.paytm.addmoney.common.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.helper.a;

public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public EditText f48429b;

    /* renamed from: c  reason: collision with root package name */
    private String f48430c;

    /* renamed from: d  reason: collision with root package name */
    private String f48431d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public View f48432e;

    /* renamed from: f  reason: collision with root package name */
    private Button f48433f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.addmoney.c.b f48434g;

    public b(Activity activity, String str, String str2, net.one97.paytm.wallet.newdesign.addmoney.c.b bVar) {
        super(activity);
        this.f48430c = str;
        this.f48431d = str2;
        this.f48434g = bVar;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.ly_promocode_dialog);
        TextView textView = (TextView) findViewById(R.id.txt_title);
        String str = this.f48430c;
        if (str != null) {
            textView.setText(str);
        }
        this.f48429b = (EditText) findViewById(R.id.edit_promo_code);
        this.f48432e = findViewById(R.id.promo_code_separator);
        this.f48429b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (b.this.f48432e == null) {
                    return;
                }
                if (z) {
                    b.this.f48432e.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    b.this.f48432e.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
        this.f48433f = (Button) findViewById(R.id.btn_apply);
        this.f48433f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.b(b.this);
            }
        });
        if (TextUtils.isEmpty(this.f48431d)) {
            this.f48431d = getContext().getResources().getString(R.string.apply);
        }
        this.f48433f.setText(this.f48431d);
    }

    public final void a(String str) {
        String str2;
        b(str);
        Button button = this.f48433f;
        if (button != null && (str2 = this.f48431d) != null) {
            button.setText(str2);
            this.f48433f.setEnabled(true);
        }
    }

    public final void a() {
        this.f48429b.setText("");
        this.f48433f.setEnabled(true);
        this.f48433f.setText(this.f48431d);
        c();
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            TextView textView = (TextView) findViewById(R.id.txt_apply_error_msg);
            textView.setVisibility(0);
            textView.setText(str);
            try {
                a.b().b("wallet_invalid_promo_code", "BOTTOM NAV", getContext());
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void c() {
        TextView textView = (TextView) findViewById(R.id.txt_apply_error_msg);
        if (textView.getVisibility() == 0) {
            textView.setVisibility(4);
        }
    }

    public final String b() {
        EditText editText = this.f48429b;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    public final void a(String str, String str2) {
        ((LinearLayout) findViewById(R.id.lyt_apply_promo_code)).setVisibility(8);
        ((LinearLayout) findViewById(R.id.lyt_promo_code_applied)).setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            ((TextView) findViewById(R.id.txt_promo_code)).setText(str.toUpperCase());
        }
        if (!TextUtils.isEmpty(str2)) {
            ((TextView) findViewById(R.id.txt_promo_status)).setText(str2);
        }
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.dismiss();
            }
        });
        com.paytm.utility.b.a(getContext(), (View) this.f48429b);
    }

    static /* synthetic */ void b(b bVar) {
        String obj = bVar.f48429b.getText().toString();
        if (TextUtils.isEmpty(obj) || obj.trim().length() <= 0) {
            bVar.b(bVar.getContext().getResources().getString(R.string.empty_promo_code));
        } else if (!com.paytm.utility.b.c(bVar.getContext())) {
            AlertDialog.Builder builder = new AlertDialog.Builder(bVar.getContext());
            builder.setTitle(bVar.getContext().getResources().getString(R.string.no_connection));
            builder.setMessage(bVar.getContext().getResources().getString(R.string.no_internet));
            builder.setPositiveButton(bVar.getContext().getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    b.b(b.this);
                }
            });
            builder.show();
        } else {
            bVar.f48433f.setText(R.string.applying);
            bVar.f48433f.setEnabled(false);
            bVar.c();
            net.one97.paytm.wallet.newdesign.addmoney.c.b bVar2 = bVar.f48434g;
            if (bVar2 != null) {
                bVar2.a(obj);
            }
            try {
                a.b().a("wallet_promo_code_entered", "BOTTOM NAV", "PROMO_CODE", obj, bVar.getContext());
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
