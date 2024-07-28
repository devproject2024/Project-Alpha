package net.one97.paytm.passbook.statementDownload;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.EmailEditResponse;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.c;

public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    TextView f58657b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public d f58658c;

    /* renamed from: d  reason: collision with root package name */
    private Button f58659d;

    /* renamed from: e  reason: collision with root package name */
    private EditText f58660e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f58661f;

    /* renamed from: g  reason: collision with root package name */
    private String f58662g;

    /* renamed from: h  reason: collision with root package name */
    private String f58663h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f58664i;
    private EmailEditResponse j;
    private Dialog k;

    public b(Activity activity, String str, d dVar, EmailEditResponse emailEditResponse) {
        super(activity);
        this.f58662g = str;
        this.f58658c = dVar;
        this.f58663h = activity.getResources().getString(R.string.pass_resend_otp);
        this.j = emailEditResponse;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.pass_lyt_mobile_otp_dialog);
        if (!TextUtils.isEmpty(this.f58662g)) {
            ((TextView) findViewById(R.id.txt_msg)).setText(this.f58662g);
        }
        this.f58660e = (EditText) findViewById(R.id.edit_otp);
        this.f58664i = (TextView) findViewById(R.id.txt_title);
        this.f58664i.setText(getContext().getResources().getString(R.string.enter_otp));
        this.f58660e.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
            }
        });
        this.f58657b = (TextView) findViewById(R.id.txt_resend_otp);
        this.f58657b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b bVar = b.this;
                if (bVar.f58657b != null) {
                    bVar.f58657b.setEnabled(false);
                    bVar.f58657b.setText(R.string.sending);
                }
                if (b.this.f58658c != null) {
                    b.this.f58658c.a();
                }
            }
        });
        this.f58661f = (TextView) findViewById(R.id.txt_error_msg);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.dismiss();
            }
        });
        this.f58659d = (Button) findViewById(R.id.btn_verify);
        this.f58659d.setText(getContext().getResources().getString(R.string.confirm));
        this.f58659d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.b(b.this);
                b.this.dismiss();
            }
        });
    }

    static /* synthetic */ void b(b bVar) {
        TextView textView;
        final String obj = bVar.f58660e.getText().toString();
        if (TextUtils.isEmpty(obj) || obj.trim().length() <= 0) {
            String string = bVar.getContext().getResources().getString(R.string.enter_valid_otp);
            if (!TextUtils.isEmpty(string) && (textView = bVar.f58661f) != null) {
                textView.setVisibility(0);
                bVar.f58661f.setText(string);
                return;
            }
            return;
        }
        Button button = bVar.f58659d;
        if (button != null) {
            button.setEnabled(false);
        }
        TextView textView2 = bVar.f58661f;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        try {
            ((InputMethodManager) bVar.getContext().getSystemService("input_method")).hideSoftInputFromWindow(bVar.f58660e.getWindowToken(), 0);
        } catch (Exception unused) {
        }
        net.one97.paytm.passbook.mapping.a.b a2 = n.a(bVar.getContext(), bVar.j.state, obj, new i.a<IJRDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                EmailEditResponse emailEditResponse = (EmailEditResponse) ((IJRDataModel) obj);
                if (emailEditResponse.status.equalsIgnoreCase("SUCCESS")) {
                    if (b.this.f58658c != null) {
                        b.this.f58658c.b();
                    }
                } else if (emailEditResponse.status.equalsIgnoreCase("FAILURE")) {
                    Toast.makeText(b.this.getContext(), "Inavlid otp enetered", 0).show();
                }
            }
        }, new g() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                q.b(String.valueOf(i2));
            }
        });
        if (com.paytm.utility.b.c(bVar.getContext())) {
            try {
                if (bVar.k == null) {
                    bVar.k = c.f(bVar.getOwnerActivity());
                }
                if (bVar.k != null && !bVar.k.isShowing()) {
                    bVar.k.show();
                }
            } catch (Exception unused2) {
            }
            bVar.getContext();
            net.one97.paytm.passbook.mapping.a.c.a();
            net.one97.paytm.passbook.mapping.a.c.b(a2);
        }
    }
}
