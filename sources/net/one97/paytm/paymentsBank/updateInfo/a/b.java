package net.one97.paytm.paymentsBank.updateInfo.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.mapping.e;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.b.a;
import net.one97.paytm.paymentsBank.updateInfo.model.ValidateEmailOtpResponse;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class b extends a implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: b  reason: collision with root package name */
    private d f19429b;

    /* renamed from: c  reason: collision with root package name */
    private Button f19430c;

    /* renamed from: d  reason: collision with root package name */
    private EditText f19431d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f19432e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f19433f;

    /* renamed from: g  reason: collision with root package name */
    private String f19434g;

    /* renamed from: h  reason: collision with root package name */
    private String f19435h;

    /* renamed from: i  reason: collision with root package name */
    private Dialog f19436i;

    public final /* synthetic */ void onResponse(Object obj) {
        ValidateEmailOtpResponse validateEmailOtpResponse = (ValidateEmailOtpResponse) ((IJRPaytmDataModel) obj);
        if (validateEmailOtpResponse.getMStatus().equalsIgnoreCase("SUCCESS")) {
            c.a(getContext(), "bank_verify_email", "input_OTP_success", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            d dVar = this.f19429b;
            if (dVar != null) {
                validateEmailOtpResponse.getMMessage();
                dVar.a(validateEmailOtpResponse.getMStatus());
            }
            dismiss();
        } else if (validateEmailOtpResponse.getMStatus().equalsIgnoreCase("FAILURE")) {
            String mMessage = TextUtils.isEmpty(validateEmailOtpResponse.getMMessage()) ? "" : validateEmailOtpResponse.getMMessage();
            c.a(getContext(), "bank_verify_email", "input_OTP_fail", mMessage, "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            Toast.makeText(getContext(), mMessage, 0).show();
        }
    }

    public b(Activity activity, String str, d dVar, String str2) {
        super(activity);
        this.f19434g = str;
        this.f19429b = dVar;
        this.f19435h = str2;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.pb_pass_lyt_mobile_otp_dialog);
        if (!TextUtils.isEmpty(this.f19434g)) {
            ((TextView) findViewById(R.id.txt_msg)).setText(this.f19434g);
        }
        this.f19431d = (EditText) findViewById(R.id.edit_otp);
        ((TextView) findViewById(R.id.txt_title)).setText(getContext().getResources().getString(R.string.pb_email_popup));
        this.f19432e = (TextView) findViewById(R.id.txt_resend_otp);
        this.f19432e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.c(view);
            }
        });
        this.f19433f = (TextView) findViewById(R.id.txt_error_msg);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        this.f19430c = (Button) findViewById(R.id.btn_verify);
        this.f19430c.setText(getContext().getResources().getString(R.string.confirm));
        this.f19430c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c.a(getContext(), "bank_verify_email", "input_OTP_fail", getContext().getString(R.string.some_went_wrong), "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        Toast.makeText(getContext(), getContext().getString(R.string.some_went_wrong), 0).show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String obj = this.f19431d.getText().toString();
        if (!TextUtils.isEmpty(obj) && obj.trim().length() > 0) {
            Button button = this.f19430c;
            if (button != null) {
                button.setEnabled(false);
            }
            TextView textView = this.f19433f;
            if (textView != null) {
                textView.setVisibility(8);
            }
            InputMethodManager inputMethodManager = null;
            try {
                if (Build.VERSION.SDK_INT >= 3) {
                    inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                }
                if (Build.VERSION.SDK_INT >= 3) {
                    inputMethodManager.hideSoftInputFromWindow(this.f19431d.getWindowToken(), 0);
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f19435h)) {
                hashMap.put("state", this.f19435h);
            }
            if (!TextUtils.isEmpty(obj)) {
                hashMap.put("currentPhoneOtp", obj);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", getClass().getSimpleName());
            f b2 = a.b(getContext(), (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap, (HashMap<String, String>) hashMap2);
            if (com.paytm.utility.b.c(getContext())) {
                try {
                    if (this.f19436i == null) {
                        this.f19436i = e.f(getOwnerActivity());
                    }
                    if (this.f19436i != null && !this.f19436i.isShowing()) {
                        this.f19436i.show();
                    }
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        e3.printStackTrace();
                    }
                }
                getContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(b2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        TextView textView = this.f19432e;
        if (textView != null) {
            textView.setEnabled(false);
            this.f19432e.setText(R.string.sending);
        }
        d dVar = this.f19429b;
        if (dVar != null) {
            dVar.a();
        }
    }
}
