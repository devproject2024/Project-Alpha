package net.one97.paytm.p2b.view.b;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.b.d;

public final class b extends a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f12896b;

    /* renamed from: c  reason: collision with root package name */
    private d f12897c;

    /* renamed from: d  reason: collision with root package name */
    private Button f12898d;

    /* renamed from: e  reason: collision with root package name */
    private EditText f12899e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f12900f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f12901g;

    /* renamed from: h  reason: collision with root package name */
    private String f12902h;

    /* renamed from: i  reason: collision with root package name */
    private String f12903i;
    private String j;
    private String k;

    public b(Activity activity, String str, String str2, String str3, d dVar) {
        super(activity);
        this.f12902h = str;
        this.f12903i = str2;
        this.j = str3;
        this.f12897c = dVar;
        if (activity != null) {
            this.k = activity.getResources().getString(R.string.p2b_resend_otp);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.p2b_dialog_enter_otp);
        if (!TextUtils.isEmpty(this.f12902h)) {
            ((TextView) findViewById(R.id.txt_title)).setText(this.f12902h);
        }
        if (!TextUtils.isEmpty(this.f12903i)) {
            ((TextView) findViewById(R.id.txt_msg)).setText(this.f12903i);
        }
        this.f12899e = (EditText) findViewById(R.id.edit_otp);
        this.f12900f = findViewById(R.id.otp_separator);
        this.f12899e.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.f12900f.setBackgroundResource(R.drawable.p2b_edit_view_divider_selected);
                } else {
                    b.this.f12900f.setBackgroundResource(R.drawable.p2b_edit_view_divider);
                }
            }
        });
        this.f12896b = (TextView) findViewById(R.id.txt_resend_otp);
        this.f12896b.setOnClickListener(this);
        this.f12901g = (TextView) findViewById(R.id.txt_error_msg);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(this);
        this.f12898d = (Button) findViewById(R.id.btn_verify);
        this.f12898d.setOnClickListener(this);
    }

    public final void a(boolean z) {
        Button button = this.f12898d;
        if (button != null) {
            button.setEnabled(z);
            if (getContext() == null) {
                return;
            }
            if (z) {
                this.f12898d.setText(getContext().getResources().getString(R.string.p2b_verify));
            } else {
                this.f12898d.setText(getContext().getResources().getString(R.string.p2b_verifying));
            }
        }
    }

    public final void b(boolean z) {
        String str;
        TextView textView = this.f12896b;
        if (textView != null) {
            textView.setEnabled(z);
            if (!z || (str = this.k) == null) {
                this.f12896b.setText(R.string.p2b_sending);
            } else {
                this.f12896b.setText(str);
            }
        }
    }

    public final void a(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f12901g) != null) {
            textView.setVisibility(0);
            this.f12901g.setText(str);
        }
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.txt_resend_otp) {
            b(false);
            d dVar = this.f12897c;
            if (dVar != null) {
                dVar.b(this.j);
            }
        } else if (id == R.id.btn_cancel) {
            dismiss();
        } else if (id == R.id.btn_verify) {
            String obj = this.f12899e.getText().toString();
            if (TextUtils.isEmpty(obj) || obj.trim().length() <= 0) {
                a(getContext().getResources().getString(R.string.p2b_enter_valid_otp));
                return;
            }
            a(false);
            TextView textView = this.f12901g;
            if (textView != null) {
                textView.setVisibility(8);
            }
            d dVar2 = this.f12897c;
            if (dVar2 != null) {
                dVar2.a(obj, this.j);
            }
        }
    }
}
