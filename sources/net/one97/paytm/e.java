package net.one97.paytm;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import net.one97.paytm.auth.a.a;
import net.one97.paytm.paytm_finance.R;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    EditText f52366a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public String f52367b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public p f52368c;

    /* renamed from: e  reason: collision with root package name */
    private Button f52369e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f52370f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f52371g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f52372h;

    /* renamed from: i  reason: collision with root package name */
    private String f52373i;
    private String j;

    public e(Activity activity, String str, String str2, p pVar) {
        super(activity);
        this.f52373i = str;
        this.f52367b = str2;
        this.f52368c = pVar;
        this.j = activity.getResources().getString(R.string.resend_otp);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.lyt_mobile_otp_dialog);
        if (!TextUtils.isEmpty(this.f52373i)) {
            ((TextView) findViewById(R.id.txt_msg)).setText(this.f52373i);
        }
        this.f52366a = (EditText) findViewById(R.id.edit_otp);
        this.f52370f = findViewById(R.id.otp_separator);
        this.f52366a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    e.this.f52370f.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    e.this.f52370f.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
        this.f52371g = (TextView) findViewById(R.id.txt_resend_otp);
        this.f52371g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.b(false);
                if (e.this.f52368c != null) {
                    e.this.f52368c.f(e.this.f52367b);
                }
            }
        });
        this.f52372h = (TextView) findViewById(R.id.txt_error_msg);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.dismiss();
                e.this.f52368c.c();
            }
        });
        this.f52369e = (Button) findViewById(R.id.btn_verify);
        this.f52369e.setText(getContext().getResources().getString(R.string.confirm));
        this.f52369e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.d(e.this);
            }
        });
    }

    public final void a(boolean z) {
        Button button = this.f52369e;
        if (button != null) {
            button.setEnabled(z);
        }
    }

    public final void b(boolean z) {
        String str;
        TextView textView = this.f52371g;
        if (textView != null) {
            textView.setEnabled(z);
            if (!z || (str = this.j) == null) {
                this.f52371g.setText(R.string.sending);
            } else {
                this.f52371g.setText(str);
            }
        }
    }

    public final void a(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f52372h) != null) {
            textView.setVisibility(0);
            this.f52372h.setText(str);
        }
    }

    static /* synthetic */ void d(e eVar) {
        String obj = eVar.f52366a.getText().toString();
        if (TextUtils.isEmpty(obj) || obj.trim().length() <= 0) {
            eVar.a(eVar.getContext().getResources().getString(R.string.enter_valid_otp));
            return;
        }
        eVar.a(false);
        TextView textView = eVar.f52372h;
        if (textView != null) {
            textView.setVisibility(8);
        }
        try {
            ((InputMethodManager) eVar.getContext().getSystemService("input_method")).hideSoftInputFromWindow(eVar.f52366a.getWindowToken(), 0);
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
        p pVar = eVar.f52368c;
        if (pVar != null) {
            pVar.c(obj, eVar.f52367b);
        }
    }
}
