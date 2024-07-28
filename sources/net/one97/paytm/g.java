package net.one97.paytm;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.b;
import com.paytm.utility.q;
import net.one97.paytm.auth.a.a;
import net.one97.paytm.paytm_finance.R;

public final class g extends a {

    /* renamed from: a  reason: collision with root package name */
    EditText f52390a;

    /* renamed from: b  reason: collision with root package name */
    TextView f52391b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public String f52392c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public s f52393e;

    /* renamed from: f  reason: collision with root package name */
    private Button f52394f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public View f52395g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f52396h;

    /* renamed from: i  reason: collision with root package name */
    private String f52397i;
    private String j;
    private String k;

    public g(Activity activity, String str, String str2, s sVar) {
        super(activity);
        this.f52397i = str;
        this.f52392c = str2;
        this.f52393e = sVar;
        this.k = activity.getResources().getString(R.string.resend_otp);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.lyt_mobile_otp_dialog);
        if (!TextUtils.isEmpty(this.f52397i)) {
            String[] split = this.f52397i.split("\\s");
            this.j = getContext().getResources().getString(R.string.enter_OTP_old_text) + " " + split[8];
            ((TextView) findViewById(R.id.txt_msg)).setText(this.f52397i);
            ((TextView) findViewById(R.id.txt_title)).setText(this.j);
        }
        this.f52390a = (EditText) findViewById(R.id.edit_otp);
        this.f52395g = findViewById(R.id.otp_separator);
        this.f52390a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    g.this.f52395g.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    g.this.f52395g.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
        this.f52396h = (TextView) findViewById(R.id.txt_resend_otp);
        this.f52396h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.a();
                g.this.a(false);
                if (g.this.f52393e != null) {
                    g.this.f52393e.a(g.this.f52392c);
                }
            }
        });
        this.f52391b = (TextView) findViewById(R.id.txt_error_msg);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.dismiss();
            }
        });
        this.f52394f = (Button) findViewById(R.id.btn_verify);
        this.f52394f.setText(getContext().getResources().getString(R.string.confirm));
        this.f52394f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.e(g.this);
            }
        });
    }

    public final void a(boolean z) {
        String str;
        TextView textView = this.f52396h;
        if (textView != null) {
            textView.setEnabled(z);
            if (!z || (str = this.k) == null) {
                this.f52396h.setText(R.string.sending);
            } else {
                this.f52396h.setText(str);
            }
        }
    }

    public final void a(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f52391b) != null) {
            textView.setVisibility(0);
            this.f52391b.setTextColor(b.c(getContext(), R.color.red));
            this.f52391b.setText(str);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        TextView textView = this.f52391b;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    static /* synthetic */ void e(g gVar) {
        String obj = gVar.f52390a.getText().toString();
        if (TextUtils.isEmpty(obj) || obj.trim().length() <= 0) {
            gVar.a(gVar.getContext().getResources().getString(R.string.enter_valid_otp));
            return;
        }
        Button button = gVar.f52394f;
        if (button != null) {
            button.setEnabled(false);
        }
        gVar.a();
        try {
            ((InputMethodManager) gVar.getContext().getSystemService("input_method")).hideSoftInputFromWindow(gVar.f52390a.getWindowToken(), 0);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
        s sVar = gVar.f52393e;
        if (sVar != null) {
            sVar.a(obj, gVar.f52392c);
        }
    }
}
