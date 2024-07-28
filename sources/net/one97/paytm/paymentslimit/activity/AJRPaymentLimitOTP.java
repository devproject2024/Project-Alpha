package net.one97.paytm.paymentslimit.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentslimit.b.f;
import net.one97.paytm.paymentslimit.b.h;
import net.one97.paytm.paymentslimit.bean.CJRTransitionLimitResendOTPResponse;
import net.one97.paytm.paymentslimit.bean.CJRTransitionLimitResponse;
import net.one97.paytm.paymentslimit.utility.OTPEntryView;
import net.one97.paytm.paymentslimit.utility.a;
import net.one97.paytm.wallet.R;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRPaymentLimitOTP extends PaytmActivity implements View.OnClickListener, f, h.a<IJRPaytmDataModel> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public EditText f59283a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public EditText f59284b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EditText f59285c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public EditText f59286d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EditText f59287e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EditText f59288f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f59289g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f59290h;

    /* renamed from: i  reason: collision with root package name */
    private ProgressDialog f59291i;
    private String j;
    private OTPEntryView k;
    private View.OnKeyListener l = new View.OnKeyListener() {
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 67) {
                return false;
            }
            if (view == AJRPaymentLimitOTP.this.f59288f && AJRPaymentLimitOTP.this.f59288f.getText().length() == 0) {
                AJRPaymentLimitOTP.this.f59287e.requestFocus();
                return false;
            } else if (view == AJRPaymentLimitOTP.this.f59287e && AJRPaymentLimitOTP.this.f59287e.getText().length() == 0) {
                AJRPaymentLimitOTP.this.f59286d.requestFocus();
                return false;
            } else if (view == AJRPaymentLimitOTP.this.f59286d && AJRPaymentLimitOTP.this.f59286d.getText().length() == 0) {
                AJRPaymentLimitOTP.this.f59285c.requestFocus();
                return false;
            } else if (view == AJRPaymentLimitOTP.this.f59285c && AJRPaymentLimitOTP.this.f59285c.getText().length() == 0) {
                AJRPaymentLimitOTP.this.f59284b.requestFocus();
                return false;
            } else if (view != AJRPaymentLimitOTP.this.f59284b || AJRPaymentLimitOTP.this.f59284b.getText().length() != 0) {
                return false;
            } else {
                AJRPaymentLimitOTP.this.f59283a.requestFocus();
                return false;
            }
        }
    };
    private TextWatcher m = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (AJRPaymentLimitOTP.this.f59283a.getText().length() > 0) {
                AJRPaymentLimitOTP.this.f59284b.requestFocus();
            }
        }
    };
    private TextWatcher n = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (AJRPaymentLimitOTP.this.f59284b.getText().length() > 0) {
                AJRPaymentLimitOTP.this.f59285c.requestFocus();
            }
        }
    };
    private TextWatcher o = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (AJRPaymentLimitOTP.this.f59285c.getText().length() > 0) {
                AJRPaymentLimitOTP.this.f59286d.requestFocus();
            }
        }
    };
    private TextWatcher p = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (AJRPaymentLimitOTP.this.f59286d.getText().length() > 0) {
                AJRPaymentLimitOTP.this.f59287e.requestFocus();
            }
        }
    };
    private TextWatcher q = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (AJRPaymentLimitOTP.this.f59287e.getText().length() > 0) {
                AJRPaymentLimitOTP.this.f59288f.requestFocus();
            }
        }
    };
    private TextWatcher r = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (AJRPaymentLimitOTP.this.f59283a.getText().length() > 0 && AJRPaymentLimitOTP.this.f59284b.getText().length() > 0 && AJRPaymentLimitOTP.this.f59285c.getText().length() > 0 && AJRPaymentLimitOTP.this.f59286d.getText().length() > 0 && AJRPaymentLimitOTP.this.f59287e.getText().length() > 0 && AJRPaymentLimitOTP.this.f59288f.getText().length() > 0) {
                AJRPaymentLimitOTP.b();
            } else if (AJRPaymentLimitOTP.this.f59283a.getText().length() <= 0) {
                AJRPaymentLimitOTP.this.f59283a.requestFocus();
            } else if (AJRPaymentLimitOTP.this.f59284b.getText().length() <= 0) {
                AJRPaymentLimitOTP.this.f59284b.requestFocus();
            } else if (AJRPaymentLimitOTP.this.f59285c.getText().length() <= 0) {
                AJRPaymentLimitOTP.this.f59285c.requestFocus();
            } else if (AJRPaymentLimitOTP.this.f59286d.getText().length() <= 0) {
                AJRPaymentLimitOTP.this.f59286d.requestFocus();
            } else if (AJRPaymentLimitOTP.this.f59287e.getText().length() <= 0) {
                AJRPaymentLimitOTP.this.f59287e.requestFocus();
            } else if (AJRPaymentLimitOTP.this.f59288f.getText().length() <= 0) {
                AJRPaymentLimitOTP.this.f59288f.requestFocus();
            }
        }
    };

    static /* synthetic */ void b() {
    }

    public final /* synthetic */ void a(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        a();
        if (iJRPaytmDataModel instanceof CJRTransitionLimitResponse) {
            CJRTransitionLimitResponse cJRTransitionLimitResponse = (CJRTransitionLimitResponse) iJRPaytmDataModel;
            Toast.makeText(this, cJRTransitionLimitResponse.statusMessage, 0).show();
            if ("UDLS_0000".equalsIgnoreCase(cJRTransitionLimitResponse.statusCode)) {
                setResult(-1);
                finish();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.payment_limit_otp);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        this.k = (OTPEntryView) findViewById(R.id.otp_entry_view);
        this.f59283a = (EditText) findViewById(R.id.otp_edt1);
        this.f59284b = (EditText) findViewById(R.id.otp_edt2);
        this.f59285c = (EditText) findViewById(R.id.otp_edt3);
        this.f59286d = (EditText) findViewById(R.id.otp_edt4);
        this.f59287e = (EditText) findViewById(R.id.otp_edt5);
        this.f59288f = (EditText) findViewById(R.id.otp_edt6);
        this.f59289g = (TextView) findViewById(R.id.resend_tv);
        this.f59290h = (TextView) findViewById(R.id.confirm_tv);
        this.j = getIntent().getStringExtra("otpState");
        this.f59289g.setOnClickListener(this);
        this.f59290h.setOnClickListener(this);
        this.f59283a.addTextChangedListener(this.m);
        this.f59284b.addTextChangedListener(this.n);
        this.f59285c.addTextChangedListener(this.o);
        this.f59286d.addTextChangedListener(this.p);
        this.f59287e.addTextChangedListener(this.q);
        this.f59288f.addTextChangedListener(this.r);
        this.f59283a.setOnKeyListener(this.l);
        this.f59284b.setOnKeyListener(this.l);
        this.f59285c.setOnKeyListener(this.l);
        this.f59286d.setOnKeyListener(this.l);
        this.f59287e.setOnKeyListener(this.l);
        this.f59288f.setOnKeyListener(this.l);
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRPaymentLimitOTP.this.onBackPressed();
            }
        });
    }

    public void onClick(View view) {
        if (view == this.f59289g) {
            a aVar = new a(this, "#PIN# is your OTP. Please use this to update Payment Limits.", b.l((Context) this));
            String str = this.j;
            aVar.f59341b = new a.C1144a() {
                public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                    AJRPaymentLimitOTP.this.a();
                    if (iJRPaytmDataModel instanceof CJRTransitionLimitResendOTPResponse) {
                        CJRTransitionLimitResendOTPResponse cJRTransitionLimitResendOTPResponse = (CJRTransitionLimitResendOTPResponse) iJRPaytmDataModel;
                        Toast.makeText(AJRPaymentLimitOTP.this, cJRTransitionLimitResendOTPResponse.statusMessage, 0).show();
                        "OTP_1001".equalsIgnoreCase(cJRTransitionLimitResendOTPResponse.statusCode);
                    }
                }

                public final void a() {
                    AJRPaymentLimitOTP.this.a();
                }

                public final void b() {
                    AJRPaymentLimitOTP.this.a();
                    AJRPaymentLimitOTP aJRPaymentLimitOTP = AJRPaymentLimitOTP.this;
                    Toast.makeText(aJRPaymentLimitOTP, aJRPaymentLimitOTP.getString(R.string.failed_to_send_otp_please_try_again), 0).show();
                }
            };
            net.one97.paytm.paymentslimit.b.b a2 = aVar.a(str);
            if (b.c(aVar.f59340a)) {
                a2.f59303a.a();
            } else {
                aVar.a(a2);
            }
            a(this, getString(R.string.please_wait_sending_otp));
        } else if (view == this.f59290h) {
            if (this.k.getText().toString().length() == 6) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("state", this.j);
                    jSONObject2.put("otp", this.k.getText().toString());
                    jSONObject.put("request", jSONObject2);
                } catch (JSONException unused) {
                }
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this));
                hashMap.put("Content-Type", "application/json");
                net.one97.paytm.paymentslimit.b.b bVar = new net.one97.paytm.paymentslimit.b.b(net.one97.paytm.paymentslimit.a.b.f59274a.d(), this, this, new CJRTransitionLimitResponse(), hashMap, jSONObject.toString(), a.c.PAY, a.b.USER_FACING, AJRPaymentLimitOTP.class.getSimpleName());
                if (b.c((Context) this)) {
                    a(this, getString(R.string.please_wait));
                    bVar.f59303a.a();
                    return;
                }
                a(bVar);
                return;
            }
            Toast.makeText(this, getString(R.string.msg_please_enter_otp), 0).show();
        }
    }

    private void a(Context context, String str) {
        ProgressDialog progressDialog = this.f59291i;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.f59291i = new ProgressDialog(context);
            try {
                this.f59291i.setProgressStyle(0);
                this.f59291i.setMessage(str);
                this.f59291i.setCancelable(false);
                this.f59291i.setCanceledOnTouchOutside(false);
                this.f59291i.show();
            } catch (IllegalArgumentException e2) {
                if (b.v) {
                    q.d(String.valueOf(e2));
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a() {
        try {
            if (this.f59291i != null && this.f59291i.isShowing() && !isFinishing()) {
                this.f59291i.dismiss();
                this.f59291i = null;
            }
        } catch (Exception unused) {
        }
    }

    private void a(net.one97.paytm.paymentslimit.b.b bVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(bVar) {
            private final /* synthetic */ net.one97.paytm.paymentslimit.b.b f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRPaymentLimitOTP.this.a(this.f$1, dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.paymentslimit.b.b bVar, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (b.c((Context) this)) {
            a(bVar);
            bVar.f59303a.a();
            return;
        }
        a(bVar);
    }

    public final void a(NetworkCustomError networkCustomError) {
        a();
        net.one97.paytm.paymentslimit.utility.b.a(this, networkCustomError, getClass().getSimpleName());
    }
}
