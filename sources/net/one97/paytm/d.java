package net.one97.paytm;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
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

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    Button f52353a;

    /* renamed from: b  reason: collision with root package name */
    EditText f52354b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f52355c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public o f52356e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f52357f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f52358g;

    /* renamed from: h  reason: collision with root package name */
    private String f52359h;

    /* renamed from: i  reason: collision with root package name */
    private String f52360i;
    /* access modifiers changed from: private */
    public String j;

    public d(Activity activity, String str, String str2, o oVar) {
        super(activity);
        this.f52359h = str;
        this.f52360i = str2;
        this.f52356e = oVar;
        this.j = activity.getResources().getString(R.string.resend_otp);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.lyt_mobile_otp_dialog);
        if (!TextUtils.isEmpty(this.f52359h)) {
            ((TextView) findViewById(R.id.txt_msg)).setText(this.f52359h);
        }
        this.f52354b = (EditText) findViewById(R.id.edit_otp);
        this.f52357f = findViewById(R.id.otp_separator);
        this.f52354b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    d.this.f52357f.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    d.this.f52357f.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
        this.f52355c = (TextView) findViewById(R.id.txt_resend_otp);
        this.f52355c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d dVar = d.this;
                try {
                    if (dVar.f52355c != null) {
                        dVar.f52355c.setEnabled(false);
                        dVar.f52355c.setText(R.string.sending);
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                d.this.f52355c.setEnabled(true);
                                d.this.f52355c.setText(d.this.j);
                            }
                        }, 3000);
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
                if (d.this.f52356e != null) {
                    d.this.f52356e.c();
                }
            }
        });
        this.f52358g = (TextView) findViewById(R.id.txt_error_msg);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.dismiss();
                o unused = d.this.f52356e;
            }
        });
        this.f52353a = (Button) findViewById(R.id.btn_verify);
        this.f52353a.setText(getContext().getResources().getString(R.string.confirm));
        this.f52353a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.c(d.this);
            }
        });
    }

    public final void a(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f52358g) != null) {
            textView.setVisibility(0);
            this.f52358g.setText(str);
        }
    }

    static /* synthetic */ void c(d dVar) {
        String obj = dVar.f52354b.getText().toString();
        if (TextUtils.isEmpty(obj) || obj.trim().length() <= 0) {
            dVar.a(dVar.getContext().getResources().getString(R.string.enter_valid_otp));
            return;
        }
        TextView textView = dVar.f52358g;
        if (textView != null) {
            textView.setVisibility(8);
        }
        try {
            ((InputMethodManager) dVar.getContext().getSystemService("input_method")).hideSoftInputFromWindow(dVar.f52354b.getWindowToken(), 0);
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
        o oVar = dVar.f52356e;
        if (oVar != null) {
            oVar.a(obj, dVar.f52360i);
        }
    }
}
