package net.one97.paytm.wallet.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.f.k;

public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public EditText f70299b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f70300c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public k f70301d;

    /* renamed from: e  reason: collision with root package name */
    private Button f70302e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f70303f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f70304g;

    /* renamed from: h  reason: collision with root package name */
    private String f70305h;

    /* renamed from: i  reason: collision with root package name */
    private String f70306i;
    /* access modifiers changed from: private */
    public String j;
    private String k;

    public c(Activity activity, String str, String str2, String str3, k kVar) {
        super(activity);
        this.f70305h = str;
        this.f70306i = str2;
        this.j = str3;
        this.f70301d = kVar;
        if (activity != null) {
            this.k = activity.getResources().getString(R.string.resend_otp);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.lyt_wallet_otp_dialog);
        if (!TextUtils.isEmpty(this.f70305h)) {
            ((TextView) findViewById(R.id.txt_title)).setText(this.f70305h);
        }
        if (!TextUtils.isEmpty(this.f70306i)) {
            ((TextView) findViewById(R.id.txt_msg)).setText(this.f70306i);
        }
        this.f70299b = (EditText) findViewById(R.id.edit_otp);
        this.f70303f = findViewById(R.id.otp_separator);
        this.f70299b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    c.this.f70303f.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    c.this.f70303f.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
        this.f70300c = (TextView) findViewById(R.id.txt_resend_otp);
        this.f70300c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.b(false);
                if (c.this.f70301d != null) {
                    c.this.f70301d.d(c.this.j);
                }
            }
        });
        this.f70304g = (TextView) findViewById(R.id.txt_error_msg);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.f70302e = (Button) findViewById(R.id.btn_verify);
        this.f70302e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.d(c.this);
            }
        });
    }

    public final void a(boolean z) {
        Button button = this.f70302e;
        if (button != null) {
            button.setEnabled(z);
            if (getContext() == null) {
                return;
            }
            if (z) {
                this.f70302e.setText(getContext().getResources().getString(R.string.verify));
            } else {
                this.f70302e.setText(getContext().getResources().getString(R.string.verifying));
            }
        }
    }

    public final void b(boolean z) {
        String str;
        TextView textView = this.f70300c;
        if (textView != null) {
            textView.setEnabled(z);
            if (!z || (str = this.k) == null) {
                this.f70300c.setText(R.string.sending);
            } else {
                this.f70300c.setText(str);
            }
        }
    }

    public final void a(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f70304g) != null) {
            textView.setVisibility(0);
            this.f70304g.setText(str);
        }
    }

    static /* synthetic */ void d(c cVar) {
        String obj = cVar.f70299b.getText().toString();
        if (TextUtils.isEmpty(obj) || obj.trim().length() <= 0) {
            cVar.a(cVar.getContext().getResources().getString(R.string.enter_valid_otp));
            return;
        }
        cVar.a(false);
        TextView textView = cVar.f70304g;
        if (textView != null) {
            textView.setVisibility(8);
        }
        k kVar = cVar.f70301d;
        if (kVar != null) {
            kVar.a(obj, cVar.j);
        }
    }
}
