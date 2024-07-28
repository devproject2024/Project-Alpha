package net.one97.paytm.managebeneficiary;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.managebeneficiary.h;

public final class b extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    String f53257a = "";

    /* renamed from: b  reason: collision with root package name */
    private TextView f53258b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f53259c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f53260d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f53261e;

    /* renamed from: f  reason: collision with root package name */
    private AppCompatEditText f53262f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextInputLayout f53263g;

    /* renamed from: h  reason: collision with root package name */
    private Context f53264h;

    /* renamed from: i  reason: collision with root package name */
    private String f53265i = "";
    private View.OnClickListener j;
    /* access modifiers changed from: private */
    public c k;
    private TextWatcher l = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            b.this.f53263g.setError((CharSequence) null);
            b.this.f53263g.setErrorEnabled(false);
        }
    };

    public b(Context context, String str, View.OnClickListener onClickListener, c cVar) {
        super(context);
        this.f53264h = context;
        this.f53257a = str;
        this.f53265i = String.format(this.f53264h.getResources().getString(R.string.pb_mb_beneficiary_otp_message), new Object[]{com.paytm.utility.b.l(this.f53264h)});
        this.j = onClickListener;
        this.k = cVar;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.beneficiary_dialog);
        this.f53261e = (TextView) findViewById(R.id.dialog_message);
        this.f53260d = (TextView) findViewById(R.id.confirm_otp_benef);
        this.f53259c = (TextView) findViewById(R.id.resend_otp_benef);
        this.f53258b = (TextView) findViewById(R.id.cancel_benef);
        this.f53262f = (AppCompatEditText) findViewById(R.id.edit_enter_otp);
        this.f53263g = (TextInputLayout) findViewById(R.id.lyt_enter_otp);
        this.f53262f.addTextChangedListener(this.l);
        this.f53261e.setText(this.f53265i);
        this.f53260d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.a(b.this)) {
                    b.b(b.this);
                }
            }
        });
        this.f53259c.setOnClickListener(this.j);
        this.f53258b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.dismiss();
            }
        });
    }

    static /* synthetic */ boolean a(b bVar) {
        if (!TextUtils.isEmpty(bVar.f53262f.getText().toString()) && bVar.f53262f.getText().toString().length() == 6) {
            return true;
        }
        bVar.f53263g.setError(bVar.f53264h.getResources().getString(R.string.enter_valid_otp));
        return false;
    }

    static /* synthetic */ void b(b bVar) {
        if (com.paytm.utility.b.c(bVar.f53264h)) {
            Context context = bVar.f53264h;
            com.paytm.utility.b.k(context, context.getResources().getString(R.string.pb_mb_resending_otp));
            String obj = bVar.f53262f.getText().toString();
            Context context2 = bVar.f53264h;
            String str = bVar.f53257a;
            AnonymousClass3 r2 = new Response.Listener<IJRPaytmDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    com.paytm.utility.b.p();
                    CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) ((IJRPaytmDataModel) obj);
                    if (cJRAddBeneficiary.getError() == null) {
                        b.this.k.a(cJRAddBeneficiary);
                        b.this.dismiss();
                    } else if (cJRAddBeneficiary.getError().getErrorMsg() == null || !cJRAddBeneficiary.getError().getErrorCode().equalsIgnoreCase("403")) {
                        b.this.k.a(cJRAddBeneficiary);
                        b.this.dismiss();
                    } else {
                        b.this.f53263g.setError(cJRAddBeneficiary.getError().getErrorMsg());
                    }
                }
            };
            AnonymousClass4 r3 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    com.paytm.utility.b.p();
                    b.this.k.a((CJRAddBeneficiary) null);
                    b.this.dismiss();
                }
            };
            if (context2 != null) {
                String validateBeneficiaryUrl = f.a().getValidateBeneficiaryUrl(context2);
                if (URLUtil.isValidUrl(validateBeneficiaryUrl)) {
                    String e2 = com.paytm.utility.b.e(context2, validateBeneficiaryUrl);
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", f.a().getSSOToken(context2));
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("reference_number", str);
                    hashMap.put("otp", obj);
                    h.AnonymousClass4 r0 = new com.paytm.network.listener.b(r2, r3) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ Response.Listener f53301a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ Response.ErrorListener f53302b;

                        {
                            this.f53301a = r1;
                            this.f53302b = r2;
                        }

                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            this.f53301a.onResponse(iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            this.f53302b.onErrorResponse((VolleyError) null);
                        }
                    };
                    a a2 = f.a(context2, e2, r0, hashMap, a.C0715a.POST, "", new CJRAddBeneficiary(), a.c.HOME, a.b.SILENT);
                    if (com.paytm.utility.b.c(context2)) {
                        a2.a();
                    } else {
                        net.one97.paytm.managebeneficiary.b.a.a(a2, context2);
                    }
                }
            }
        } else {
            com.paytm.utility.b.b(bVar.f53264h, bVar.f53260d.getResources().getString(R.string.network_error_heading), bVar.f53260d.getResources().getString(R.string.network_error_message));
        }
    }
}
