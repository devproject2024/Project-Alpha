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

public final class f extends a {

    /* renamed from: a  reason: collision with root package name */
    TextView f52378a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public String f52379b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public q f52380c;

    /* renamed from: e  reason: collision with root package name */
    private Button f52381e;

    /* renamed from: f  reason: collision with root package name */
    private EditText f52382f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public View f52383g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f52384h;

    /* renamed from: i  reason: collision with root package name */
    private String f52385i;
    private String j;
    private String k;
    private String l;

    public f(Activity activity, String str, String str2, String str3, q qVar) {
        super(activity);
        this.f52385i = str;
        this.f52379b = str2;
        this.f52380c = qVar;
        this.l = str3;
        this.k = activity.getResources().getString(R.string.resend_otp);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.lyt_mobile_otp_dialog);
        if (!TextUtils.isEmpty(this.f52385i)) {
            this.j = getContext().getResources().getString(R.string.enter_OTP_old_text) + " " + b.y(this.f52385i);
            ((TextView) findViewById(R.id.txt_msg)).setText(this.f52385i);
            ((TextView) findViewById(R.id.txt_title)).setText(this.j);
        }
        this.f52382f = (EditText) findViewById(R.id.edit_otp);
        this.f52383g = findViewById(R.id.otp_separator);
        this.f52382f.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    f.this.f52383g.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    f.this.f52383g.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
        this.f52384h = (TextView) findViewById(R.id.txt_resend_otp);
        this.f52384h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.a();
                f.this.b(false);
                if (f.this.f52380c != null) {
                    f.this.f52380c.b(f.this.f52379b);
                }
            }
        });
        this.f52378a = (TextView) findViewById(R.id.txt_error_msg);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.dismiss();
            }
        });
        this.f52381e = (Button) findViewById(R.id.btn_verify);
        this.f52381e.setText(getContext().getResources().getString(R.string.confirm));
        this.f52381e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.e(f.this);
            }
        });
    }

    public final void a(boolean z) {
        Button button = this.f52381e;
        if (button != null) {
            button.setEnabled(z);
        }
    }

    public final void b(boolean z) {
        String str;
        TextView textView = this.f52384h;
        if (textView != null) {
            textView.setEnabled(z);
            if (!z || (str = this.k) == null) {
                this.f52384h.setText(R.string.sending);
            } else {
                this.f52384h.setText(str);
            }
        }
    }

    public final void a(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f52378a) != null) {
            textView.setVisibility(0);
            this.f52378a.setTextColor(androidx.core.content.b.c(getContext(), R.color.red));
            this.f52378a.setText(str);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        TextView textView = this.f52378a;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    static /* synthetic */ void e(f fVar) {
        String obj = fVar.f52382f.getText().toString();
        if (TextUtils.isEmpty(obj) || obj.trim().length() <= 0) {
            fVar.a(fVar.getContext().getResources().getString(R.string.enter_valid_otp));
            return;
        }
        fVar.a(false);
        fVar.a();
        try {
            ((InputMethodManager) fVar.getContext().getSystemService("input_method")).hideSoftInputFromWindow(fVar.f52382f.getWindowToken(), 0);
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
        q qVar = fVar.f52380c;
        if (qVar != null) {
            qVar.a(fVar.l, obj, fVar.f52379b);
        }
    }
}
