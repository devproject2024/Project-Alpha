package net.one97.paytm.upgradeKyc.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.s;
import java.util.HashMap;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.upgradeKyc.DigilockerInfo;
import net.one97.paytm.common.entity.upgradeKyc.DigilockerOTP;
import net.one97.paytm.common.utility.f;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.KycSmsReceiver;
import net.one97.paytm.upgradeKyc.utils.l;

public class b extends Dialog implements KycSmsReceiver.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextView f65605a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f65606b;

    /* renamed from: c  reason: collision with root package name */
    private TextInputEditText f65607c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextInputLayout f65608d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f65609e;

    /* renamed from: f  reason: collision with root package name */
    private String f65610f = "";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f65611g = "";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public a f65612h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f65613i;
    private KycSmsReceiver j;
    private TextWatcher k = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            b.this.f65608d.setError((CharSequence) null);
            b.this.f65608d.setErrorEnabled(false);
        }
    };

    public b(Activity activity, a aVar) {
        super(activity);
        setOwnerActivity(activity);
        this.f65609e = activity;
        this.f65610f = String.format(this.f65609e.getResources().getString(R.string.digilocker_otp_message), new Object[]{com.paytm.utility.b.l(this.f65609e)});
        this.f65612h = aVar;
        a(false);
        try {
            if ((!s.a() || s.d(this.f65609e)) && this.j == null) {
                this.j = new KycSmsReceiver();
                this.j.f66314a = this;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                intentFilter.setPriority(1000);
                this.f65609e.registerReceiver(this.j, intentFilter);
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" : register");
                com.paytm.utility.b.j();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.digilocker_otp_dialog);
        this.f65613i = (ProgressBar) findViewById(R.id.digilocker_otp_dialog_progress_resend);
        this.f65606b = (TextView) findViewById(R.id.confirm_otp_benef);
        this.f65605a = (TextView) findViewById(R.id.resend_otp_benef);
        this.f65607c = (TextInputEditText) findViewById(R.id.edit_enter_otp);
        this.f65608d = (TextInputLayout) findViewById(R.id.lyt_enter_otp);
        this.f65607c.addTextChangedListener(this.k);
        ((TextView) findViewById(R.id.dialog_message)).setText(this.f65610f);
        this.f65606b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.c(view);
            }
        });
        this.f65605a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        ((TextView) findViewById(R.id.cancel_benef)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
        ((TextView) findViewById(R.id.mobile_based_tv)).setText(this.f65609e.getString(R.string.verify_mobile_number, new Object[]{com.paytm.utility.b.l(this.f65609e)}));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    private void a(final boolean z) {
        String str;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("digiLockerGenOtp");
        } else {
            str = null;
        }
        if (!URLUtil.isValidUrl(str)) {
            Context context = this.f65609e;
            com.paytm.utility.b.b(context, context.getResources().getString(R.string.error), this.f65609e.getResources().getString(R.string.msg_invalid_url));
            return;
        }
        String e2 = com.paytm.utility.b.e(this.f65609e, str);
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", a.q(this.f65609e));
        String e3 = com.paytm.utility.b.e();
        String f2 = com.paytm.utility.b.f();
        try {
            e.a aVar3 = e.f66028b;
            String c2 = e.a.b().c();
            hashMap.put("x-keyiv", f.a(c2, e3 + ':' + f2));
        } catch (Exception unused) {
        }
        DigilockerOTP digilockerOTP = new DigilockerOTP();
        digilockerOTP.setIv(f2);
        digilockerOTP.setKey(e3);
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a2 = a.C1317a.a();
        a2.f42877a = getContext();
        a2.f42879c = a.C0715a.POST;
        a2.f42882f = hashMap;
        a2.f42885i = digilockerOTP;
        a2.f42884h = "";
        a2.f42880d = e2;
        a2.o = b.class.getName();
        a2.n = a.b.USER_FACING;
        a2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (b.this.getOwnerActivity() != null && !b.this.getOwnerActivity().isFinishing() && !b.this.getOwnerActivity().isDestroyed()) {
                    b.this.f65613i.setVisibility(8);
                    b.this.f65605a.setVisibility(0);
                    DigilockerOTP digilockerOTP = (DigilockerOTP) iJRPaytmDataModel;
                    if (!TextUtils.isEmpty(digilockerOTP.getErrorMessage())) {
                        com.paytm.utility.b.b(b.this.f65609e, b.this.f65609e.getString(R.string.error), digilockerOTP.getErrorMessage());
                    } else if (!TextUtils.isEmpty(digilockerOTP.getErrorErrorMessage())) {
                        com.paytm.utility.b.b(b.this.f65609e, b.this.f65609e.getString(R.string.error), digilockerOTP.getErrorErrorMessage());
                    } else if (!TextUtils.isEmpty(digilockerOTP.getStatusCode()) && digilockerOTP.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                        String unused = b.this.f65611g = digilockerOTP.getReferenceNumber();
                        if (z) {
                            b bVar = b.this;
                            b.a(bVar, bVar.f65605a);
                        }
                    }
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (b.this.getOwnerActivity() != null) {
                    l.a();
                    if (!l.a((Context) b.this.getOwnerActivity(), networkCustomError)) {
                        b.this.f65613i.setVisibility(8);
                        b.this.f65605a.setVisibility(0);
                        if (b.this.f65612h != null) {
                            b.this.f65612h.a(networkCustomError);
                        }
                    }
                }
            }
        };
        com.paytm.network.a l = a2.l();
        if (com.paytm.utility.b.c(this.f65609e)) {
            if (z) {
                this.f65613i.setVisibility(0);
                this.f65605a.setVisibility(8);
            }
            l.a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(TextView textView) {
        try {
            if (isShowing()) {
                textView.setTextColor(androidx.core.content.b.c(this.f65609e, R.color.color_00b9f5));
                textView.setText(R.string.kyc_resend_otp);
            }
        } catch (Exception unused) {
        }
    }

    private void a() {
        try {
            if (this.j != null) {
                this.f65609e.unregisterReceiver(this.j);
                this.j.f66314a = null;
                this.j = null;
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" : unregister");
                com.paytm.utility.b.j();
            }
        } catch (Exception unused) {
        }
    }

    public final void a(String str, String str2) {
        String e2 = com.paytm.utility.b.e(str, str2);
        if (e2 != null) {
            this.f65607c.setText(e2);
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        a();
        super.onStop();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        boolean z;
        if (TextUtils.isEmpty(this.f65607c.getText().toString()) || this.f65607c.getText().toString().length() != 6) {
            this.f65608d.setError(this.f65609e.getResources().getString(R.string.kyc_valid_otp));
            z = false;
        } else {
            z = true;
        }
        if (z) {
            com.paytm.utility.b.a(this.f65609e, (View) this.f65607c);
            String obj = this.f65607c.getText().toString();
            if (TextUtils.isEmpty(this.f65611g)) {
                this.f65608d.setError(this.f65609e.getResources().getString(R.string.kyc_valid_otp));
                return;
            }
            String str = null;
            d.a aVar = d.f66026a;
            if (d.a.a() != null) {
                d.a aVar2 = d.f66026a;
                d.a.a();
                str = d.a("getDigilockerInfo");
            }
            if (!URLUtil.isValidUrl(str)) {
                Context context = this.f65609e;
                com.paytm.utility.b.b(context, context.getResources().getString(R.string.error), this.f65609e.getResources().getString(R.string.msg_invalid_url));
                return;
            }
            String e2 = com.paytm.utility.b.e(this.f65609e, str);
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", com.paytm.utility.a.q(this.f65609e));
            hashMap.put("reference_number", this.f65611g);
            hashMap.put("otp", obj);
            String e3 = com.paytm.utility.b.e();
            String f2 = com.paytm.utility.b.f();
            try {
                e.a aVar3 = e.f66028b;
                String c2 = e.a.b().c();
                hashMap.put("x-keyiv", f.a(c2, e3 + ':' + f2));
            } catch (Exception unused) {
            }
            DigilockerInfo digilockerInfo = new DigilockerInfo();
            digilockerInfo.setIv(f2);
            digilockerInfo.setKey(e3);
            a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.b a2 = a.C1317a.a();
            a2.f42877a = getContext();
            a2.f42879c = a.C0715a.POST;
            a2.f42882f = hashMap;
            a2.f42885i = digilockerInfo;
            a2.f42884h = "";
            a2.o = getClass().getName();
            a2.f42878b = a.c.KYC;
            a2.f42880d = e2;
            a2.n = a.b.USER_FACING;
            a2.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    com.paytm.utility.b.p();
                    DigilockerInfo digilockerInfo = (DigilockerInfo) iJRPaytmDataModel;
                    if (!TextUtils.isEmpty(digilockerInfo.getErrorErrorMessage())) {
                        b.this.f65608d.setErrorEnabled(true);
                        b.this.f65608d.setError(digilockerInfo.getErrorErrorMessage());
                        return;
                    }
                    if (b.this.f65612h != null) {
                        b.this.f65612h.a(digilockerInfo);
                    }
                    b.this.dismiss();
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (b.this.getOwnerActivity() != null) {
                        l.a();
                        if (!l.a((Context) b.this.getOwnerActivity(), networkCustomError)) {
                            com.paytm.utility.b.p();
                            if (b.this.f65612h != null) {
                                b.this.f65612h.a(networkCustomError);
                            }
                            b.this.dismiss();
                        }
                    }
                }
            };
            com.paytm.network.a l = a2.l();
            if (com.paytm.utility.b.c(this.f65609e)) {
                Context context2 = this.f65609e;
                com.paytm.utility.b.k(context2, context2.getResources().getString(R.string.please_wait));
                l.a();
                return;
            }
            com.paytm.utility.b.b(this.f65609e, this.f65606b.getResources().getString(R.string.network_error_heading), this.f65606b.getResources().getString(R.string.network_error_message));
        }
    }

    static /* synthetic */ void a(b bVar, TextView textView) {
        textView.setTextColor(androidx.core.content.b.c(bVar.f65609e, R.color.color_009453));
        textView.setText(R.string.otp_sent);
        new Handler().postDelayed(new Runnable(textView) {
            private final /* synthetic */ TextView f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                b.this.a(this.f$1);
            }
        }, 5000);
    }
}
