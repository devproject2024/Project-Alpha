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
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.wallet.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends net.one97.paytm.i.f {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public AppCompatActivity f70630a;

    /* renamed from: b  reason: collision with root package name */
    WalletPaymentCallbackListener f70631b;

    /* renamed from: c  reason: collision with root package name */
    String f70632c;

    /* renamed from: d  reason: collision with root package name */
    String f70633d;

    /* renamed from: e  reason: collision with root package name */
    String f70634e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LottieAnimationView f70635f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f70636g;

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static f a() {
        return new f();
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        dialog.setCanceledOnTouchOutside(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ab_progress_bottom_sheet, viewGroup, false);
        this.f70635f = (LottieAnimationView) inflate.findViewById(R.id.lav_lottie_loader);
        a.a(this.f70635f);
        this.f70636g = (TextView) inflate.findViewById(R.id.tv_message);
        if (!TextUtils.isEmpty(this.f70632c)) {
            TextView textView = this.f70636g;
            textView.setText("Adding " + this.f70632c + " as a beneficiary");
        } else {
            TextView textView2 = this.f70636g;
            textView2.setText("Adding " + this.f70633d + " as a beneficiary");
        }
        String str = this.f70633d;
        if (b.c((Context) this.f70630a)) {
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
            if (this.f70630a != null) {
                String addBeneficiaryURL = net.one97.paytm.wallet.communicator.b.a().addBeneficiaryURL(this.f70630a);
                if (URLUtil.isValidUrl(addBeneficiaryURL)) {
                    String e2 = b.e((Context) this.f70630a, addBeneficiaryURL);
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", com.paytm.utility.a.q(this.f70630a));
                    hashMap.put("Content-Type", "text/plain");
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONArray.put(new JSONObject(new com.google.gson.f().b(beneficiaryEntity)));
                    } catch (JSONException e3) {
                        q.d(String.valueOf(e3));
                    }
                    net.one97.paytm.wallet.communicator.b.a().addBeneficiaryAPICall(this.f70630a.getApplicationContext(), e2, new h() {
                        public final void a(IJRDataModel iJRDataModel) {
                            if (!f.this.isDetached()) {
                                a.b(f.this.f70635f);
                                CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRDataModel;
                                if (f.this.isAdded() && f.this.f70630a != null) {
                                    if (cJRAddBeneficiary.getError() != null) {
                                        if (cJRAddBeneficiary.getError().getErrorMsg() != null) {
                                            net.one97.paytm.wallet.utility.a.a((Activity) f.this.f70630a, f.this.getString(R.string.error), cJRAddBeneficiary.getError().getErrorMsg());
                                        } else {
                                            net.one97.paytm.wallet.utility.a.a((Activity) f.this.f70630a, f.this.getString(R.string.error), f.this.getString(R.string.some_went_wrong));
                                        }
                                        f.this.dismissAllowingStateLoss();
                                    } else if ("1".equalsIgnoreCase(cJRAddBeneficiary.getAskOTP()) && !TextUtils.isEmpty(cJRAddBeneficiary.getReferenceNumber())) {
                                        f.a(f.this, cJRAddBeneficiary.getReferenceNumber());
                                    }
                                }
                            }
                        }

                        public final void a(NetworkCustomError networkCustomError) {
                            a.b(f.this.f70635f);
                            if (networkCustomError != null) {
                                try {
                                    if (!(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403)) {
                                        if (networkCustomError.getStatusCode() != 410) {
                                            net.one97.paytm.wallet.utility.a.a((Activity) f.this.f70630a, f.this.getString(R.string.error), f.this.getString(R.string.some_went_wrong));
                                        }
                                    }
                                    net.one97.paytm.wallet.communicator.b.a().handleSessionTimeout(f.this.f70630a, networkCustomError, (String) null, (Bundle) null, false);
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
                            f.this.dismissAllowingStateLoss();
                        }
                    }, (CJRAddBeneficiary) null, hashMap, jSONArray.toString());
                }
            }
        } else {
            b.k(this.f70630a, getString(R.string.no_internet));
        }
        return inflate;
    }

    static /* synthetic */ void a(f fVar, String str) {
        e a2 = e.a();
        AppCompatActivity appCompatActivity = fVar.f70630a;
        String str2 = fVar.f70633d;
        String str3 = fVar.f70632c;
        String str4 = fVar.f70634e;
        WalletPaymentCallbackListener walletPaymentCallbackListener = fVar.f70631b;
        a2.f70617a = appCompatActivity;
        a2.f70619c = str;
        String l = b.l((Context) appCompatActivity);
        a2.f70618b = String.format("6 digit OTP has been sent to %s", new Object[]{"XX " + l.substring(6)});
        a2.f70620d = str2;
        a2.f70621e = str3;
        a2.f70622f = str4;
        a2.f70623g = walletPaymentCallbackListener;
        if (fVar.getActivity() != null) {
            androidx.fragment.app.q a3 = fVar.getActivity().getSupportFragmentManager().a();
            a3.a((Fragment) a2, "ab_bottom_otp_sheet");
            a3.c();
        }
        fVar.dismissAllowingStateLoss();
    }
}
