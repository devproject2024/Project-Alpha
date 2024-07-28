package net.one97.paytm.wallet.newdesign.addbeneficiary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener;
import net.one97.paytm.i.f;
import net.one97.paytm.network.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.utility.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends f {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public AppCompatActivity f70617a;

    /* renamed from: b  reason: collision with root package name */
    String f70618b = "";

    /* renamed from: c  reason: collision with root package name */
    String f70619c = "";

    /* renamed from: d  reason: collision with root package name */
    String f70620d;

    /* renamed from: e  reason: collision with root package name */
    String f70621e;

    /* renamed from: f  reason: collision with root package name */
    String f70622f;

    /* renamed from: g  reason: collision with root package name */
    WalletPaymentCallbackListener f70623g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f70624h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f70625i;
    private Button j;
    private TextView k;
    private TextView l;
    private TextView m;
    /* access modifiers changed from: private */
    public PinEntryEditText n;
    private LottieAnimationView o;

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static e a() {
        return new e();
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        dialog.setCanceledOnTouchOutside(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ab_bottom_sheet_otp, viewGroup, false);
        AppCompatActivity appCompatActivity = this.f70617a;
        if (appCompatActivity != null) {
            appCompatActivity.getWindow().setSoftInputMode(32);
        }
        this.f70624h = (TextView) inflate.findViewById(R.id.tv_otp_error);
        this.f70625i = (ImageView) inflate.findViewById(R.id.iv_cancel);
        this.j = (Button) inflate.findViewById(R.id.btn_confirm_otp);
        this.k = (TextView) inflate.findViewById(R.id.tv_resend_otp);
        this.l = (TextView) inflate.findViewById(R.id.tv_label_mobile_number);
        this.l.setText(this.f70618b);
        this.m = (TextView) inflate.findViewById(R.id.tv_title);
        this.n = (PinEntryEditText) inflate.findViewById(R.id.txt_pin_entry);
        this.o = (LottieAnimationView) inflate.findViewById(R.id.lav_lottie_loader);
        if (!TextUtils.isEmpty(this.f70621e)) {
            TextView textView = this.m;
            textView.setText("Confirm OTP to add " + this.f70621e + " as a beneficiary");
        } else {
            TextView textView2 = this.m;
            textView2.setText("Confirm OTP to add " + this.f70620d + " as a beneficiary");
        }
        this.f70625i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.dismissAllowingStateLoss();
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (e.a(e.this)) {
                    e.b(e.this);
                }
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PinEntryEditText c2 = e.this.n;
                c2.f70576a = 6.0f;
                c2.invalidate();
                if (b.c((Context) e.this.f70617a)) {
                    e.e(e.this);
                } else {
                    a.a((Activity) e.this.f70617a, e.this.getString(R.string.error), e.this.getString(R.string.no_internet));
                }
            }
        });
        return inflate;
    }

    private void a(CJRAddBeneficiary cJRAddBeneficiary) {
        if (cJRAddBeneficiary == null) {
            b a2 = b.a();
            AppCompatActivity appCompatActivity = this.f70617a;
            String str = this.f70621e;
            String str2 = this.f70620d;
            String str3 = this.f70622f;
            WalletPaymentCallbackListener walletPaymentCallbackListener = this.f70623g;
            a2.f70599a = appCompatActivity;
            a2.f70600b = str;
            a2.f70601c = str2;
            a2.f70602d = str3;
            a2.f70603e = walletPaymentCallbackListener;
            walletPaymentCallbackListener.onBeneficiaryAdditionFailure();
            if (getActivity() != null) {
                a2.show(getActivity().getSupportFragmentManager(), "ab_failure_screen");
            }
            dismissAllowingStateLoss();
            return;
        }
        g a3 = g.a();
        AppCompatActivity appCompatActivity2 = this.f70617a;
        String str4 = this.f70621e;
        String str5 = this.f70620d;
        a3.f70638a = appCompatActivity2;
        a3.f70639b = str4;
        a3.f70640c = str5;
        this.f70623g.onBeneficiaryAdditionSuccess();
        if (getActivity() != null) {
            a3.show(getActivity().getSupportFragmentManager(), "ab_success_screen");
        }
        dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AppCompatActivity appCompatActivity, net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            this.j.setBackgroundColor(appCompatActivity.getResources().getColor(R.color.color_00b9f5));
            this.j.setClickable(true);
            try {
                net.one97.paytm.common.widgets.a.b(this.o);
            } catch (Exception unused) {
            }
            if (fVar.f55797b instanceof CJRAddBeneficiary) {
                CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) fVar.f55797b;
                if (cJRAddBeneficiary.getStatusCode() != null) {
                    if (!WebLogin.RESPONSE_CODE_SUCCESS.equalsIgnoreCase(cJRAddBeneficiary.getStatusCode())) {
                        a((CJRAddBeneficiary) null);
                    } else if (isAdded()) {
                        a(cJRAddBeneficiary);
                    }
                } else if (isAdded()) {
                    a((CJRAddBeneficiary) null);
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            this.j.setBackgroundColor(appCompatActivity.getResources().getColor(R.color.color_00b9f5));
            this.j.setClickable(true);
            try {
                net.one97.paytm.common.widgets.a.b(this.o);
            } catch (Exception unused2) {
            }
            b.p();
            if (isAdded()) {
                a((CJRAddBeneficiary) null);
            }
        }
    }

    static /* synthetic */ boolean a(e eVar) {
        if (!TextUtils.isEmpty(eVar.n.getText().toString()) && eVar.n.getText().toString().length() == 6) {
            return true;
        }
        eVar.f70624h.setVisibility(0);
        return false;
    }

    static /* synthetic */ void b(e eVar) {
        if (b.c((Context) eVar.f70617a)) {
            String obj = eVar.n.getText().toString();
            AppCompatActivity appCompatActivity = eVar.f70617a;
            eVar.j.setBackgroundColor(appCompatActivity.getResources().getColor(R.color.grid_offer_blue));
            eVar.j.setClickable(false);
            try {
                net.one97.paytm.common.widgets.a.a(eVar.o);
            } catch (Exception unused) {
            }
            if (appCompatActivity != null) {
                String validateBeneficiaryUrl = net.one97.paytm.wallet.communicator.b.a().getValidateBeneficiaryUrl(appCompatActivity);
                if (URLUtil.isValidUrl(validateBeneficiaryUrl)) {
                    String e2 = b.e((Context) appCompatActivity, validateBeneficiaryUrl);
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", com.paytm.utility.a.q(appCompatActivity));
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("reference_number", eVar.f70619c);
                    hashMap.put("otp", obj);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("screen_name", eVar.getClass().getSimpleName());
                    new net.one97.paytm.network.b(e2, new CJRAddBeneficiary(), hashMap2, hashMap, (String) null).c().observe(appCompatActivity, new z(appCompatActivity) {
                        private final /* synthetic */ AppCompatActivity f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onChanged(Object obj) {
                            e.this.a(this.f$1, (net.one97.paytm.network.f) obj);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        a.a((Activity) eVar.f70617a, eVar.getString(R.string.error), eVar.getString(R.string.no_internet));
    }

    static /* synthetic */ void e(e eVar) {
        String str = eVar.f70620d;
        if (b.c((Context) eVar.f70617a)) {
            BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
            BeneficiaryEntity.InstrumentPreferences instrumentPreferences = new BeneficiaryEntity.InstrumentPreferences();
            BeneficiaryEntity.Wallet wallet = new BeneficiaryEntity.Wallet();
            ArrayList<BeneficiaryEntity.WalletAccount> arrayList = new ArrayList<>();
            BeneficiaryEntity.WalletAccount walletAccount = new BeneficiaryEntity.WalletAccount();
            BeneficiaryEntity.Source source = new BeneficiaryEntity.Source();
            source.upi = "disabled";
            source.wallet = "enabled";
            source.oba = "disabled";
            ArrayList<BeneficiaryEntity.Limit> arrayList2 = new ArrayList<>();
            BeneficiaryEntity.WalletAccountDetail walletAccountDetail = new BeneficiaryEntity.WalletAccountDetail();
            walletAccountDetail.beneficiaryPhone = str;
            walletAccount.source = source;
            walletAccount.limits = arrayList2;
            walletAccount.accountDetail = walletAccountDetail;
            arrayList.add(walletAccount);
            instrumentPreferences.wallet = wallet;
            instrumentPreferences.wallet.accounts = arrayList;
            beneficiaryEntity.instrumentPreferences = instrumentPreferences;
            if (eVar.f70617a != null) {
                String addBeneficiaryURL = net.one97.paytm.wallet.communicator.b.a().addBeneficiaryURL(eVar.f70617a);
                if (URLUtil.isValidUrl(addBeneficiaryURL)) {
                    String e2 = b.e((Context) eVar.f70617a, addBeneficiaryURL);
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", com.paytm.utility.a.q(eVar.f70617a));
                    hashMap.put("Content-Type", "text/plain");
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONArray.put(new JSONObject(new com.google.gson.f().b(beneficiaryEntity)));
                    } catch (JSONException e3) {
                        q.d(String.valueOf(e3));
                    }
                    net.one97.paytm.wallet.communicator.b.a().addBeneficiaryAPICall(eVar.f70617a.getApplicationContext(), e2, new h() {
                        public final void a(IJRDataModel iJRDataModel) {
                            if ((iJRDataModel instanceof CJRAddBeneficiary) && e.this.f70617a != null && !e.this.f70617a.isFinishing() && e.this.isAdded()) {
                                CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRDataModel;
                                if (WebLogin.RESPONSE_CODE_SUCCESS.equalsIgnoreCase(cJRAddBeneficiary.getStatusCode())) {
                                    Toast.makeText(e.this.f70617a, "OTP sent", 0).show();
                                } else {
                                    a.a((Activity) e.this.f70617a, e.this.getString(R.string.error), cJRAddBeneficiary.getError().getErrorMsg());
                                }
                            }
                        }

                        public final void a(NetworkCustomError networkCustomError) {
                            if (networkCustomError != null) {
                                try {
                                    if (!(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403)) {
                                        if (networkCustomError.getStatusCode() != 410) {
                                            a.a((Activity) e.this.f70617a, e.this.getString(R.string.error), e.this.getString(R.string.some_went_wrong));
                                            return;
                                        }
                                    }
                                    net.one97.paytm.wallet.communicator.b.a().handleSessionTimeout(e.this.f70617a, networkCustomError, (String) null, (Bundle) null, false);
                                } catch (Resources.NotFoundException e2) {
                                    if (b.v) {
                                        q.d(String.valueOf(e2));
                                    }
                                } catch (Exception e3) {
                                    if (b.v) {
                                        q.d(String.valueOf(e3));
                                    }
                                }
                            }
                        }
                    }, (CJRAddBeneficiary) null, hashMap, jSONArray.toString());
                    return;
                }
                return;
            }
            return;
        }
        b.k(eVar.f70617a, eVar.getString(R.string.no_internet));
    }
}
