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

public final class j extends a {

    /* renamed from: a  reason: collision with root package name */
    EditText f52407a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public w f52408b;

    /* renamed from: c  reason: collision with root package name */
    private Button f52409c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public View f52410e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f52411f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f52412g;

    /* renamed from: h  reason: collision with root package name */
    private String f52413h;

    /* renamed from: i  reason: collision with root package name */
    private String f52414i;
    private TextView j;

    public j(Activity activity, String str, w wVar) {
        super(activity);
        this.f52413h = str;
        this.f52408b = wVar;
        this.f52414i = activity.getResources().getString(R.string.resend_otp);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.lyt_mobile_otp_dialog);
        if (!TextUtils.isEmpty(this.f52413h)) {
            ((TextView) findViewById(R.id.txt_msg)).setText(this.f52413h);
        }
        this.f52407a = (EditText) findViewById(R.id.edit_otp);
        this.f52410e = findViewById(R.id.otp_separator);
        this.j = (TextView) findViewById(R.id.txt_title);
        this.j.setText(getContext().getResources().getString(R.string.enter_otp));
        this.f52407a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    j.this.f52410e.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    j.this.f52410e.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
        this.f52411f = (TextView) findViewById(R.id.txt_resend_otp);
        this.f52411f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                j.this.b(false);
                if (j.this.f52408b != null) {
                    j.this.f52408b.b();
                }
            }
        });
        this.f52412g = (TextView) findViewById(R.id.txt_error_msg);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                j.this.dismiss();
            }
        });
        this.f52409c = (Button) findViewById(R.id.btn_verify);
        this.f52409c.setText(getContext().getResources().getString(R.string.confirm));
        this.f52409c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                j.c(j.this);
            }
        });
    }

    public final void a(boolean z) {
        Button button = this.f52409c;
        if (button != null) {
            button.setEnabled(z);
        }
    }

    public final void b(boolean z) {
        String str;
        TextView textView = this.f52411f;
        if (textView != null) {
            textView.setEnabled(z);
            if (!z || (str = this.f52414i) == null) {
                this.f52411f.setText(R.string.sending);
            } else {
                this.f52411f.setText(str);
            }
        }
    }

    public final void a(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f52412g) != null) {
            textView.setVisibility(0);
            this.f52412g.setText(str);
        }
    }

    static /* synthetic */ void c(j jVar) {
        String obj = jVar.f52407a.getText().toString();
        if (TextUtils.isEmpty(obj) || obj.trim().length() <= 0) {
            jVar.a(jVar.getContext().getResources().getString(R.string.enter_valid_otp));
            return;
        }
        jVar.a(false);
        TextView textView = jVar.f52412g;
        if (textView != null) {
            textView.setVisibility(8);
        }
        try {
            ((InputMethodManager) jVar.getContext().getSystemService("input_method")).hideSoftInputFromWindow(jVar.f52407a.getWindowToken(), 0);
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
        w wVar = jVar.f52408b;
        if (wVar != null) {
            wVar.e(obj);
        }
    }
}
