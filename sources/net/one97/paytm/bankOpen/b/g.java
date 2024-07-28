package net.one97.paytm.bankOpen.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import net.one97.paytm.bankCommon.a.a;
import net.one97.paytm.bankCommon.d.b;
import net.one97.paytm.bankCommon.d.c;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.SetPasscodeModel;
import net.one97.paytm.bankCommon.model.ValidatePasscode;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;

public class g extends b implements View.OnClickListener, c.b {

    /* renamed from: b  reason: collision with root package name */
    protected TextView f16409b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f16410c;

    /* renamed from: d  reason: collision with root package name */
    private c f16411d;

    /* renamed from: e  reason: collision with root package name */
    private c f16412e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f16413f;

    /* renamed from: g  reason: collision with root package name */
    private String f16414g = "";

    /* renamed from: h  reason: collision with root package name */
    private TextView f16415h;

    public int d() {
        return 100;
    }

    public void g() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_payment_bank_set_passcode_v2, (ViewGroup) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f16410c = (ViewPager) getView().findViewById(R.id.payment_bank_set_passcode_pager_passcode);
        this.f16413f = (TextView) getView().findViewById(R.id.set_passcode_tv_error_msg);
        a aVar = new a(getFragmentManager());
        this.f16410c.setAdapter(aVar);
        this.f16409b = (TextView) getView().findViewById(R.id.payment_bank_set_passcode_tv_title);
        this.f16415h = (TextView) getView().findViewById(R.id.text_passcode_reason);
        this.f16411d = (c) aVar.getItem(0);
        this.f16412e = (c) aVar.getItem(1);
        this.f16411d.f16236a = this;
        this.f16412e.f16236a = this;
        getView().findViewById(R.id.set_passcode_img_close).setOnClickListener(this);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                g.this.h();
            }
        }, 100);
        if (d() == 100) {
            net.one97.paytm.bankCommon.mapping.c.a("/bank/saving-account/set-passcode", CJRPGTransactionRequestUtils.PAYER_BANK_NAME, (Context) getActivity());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        InputMethodManager inputMethodManager;
        if (isAdded() && (inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method")) != null) {
            inputMethodManager.toggleSoftInput(2, 0);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.set_passcode_img_close) {
            if (getActivity() != null && (getActivity() instanceof e)) {
                getActivity().onBackPressed();
            }
            c();
        }
    }

    public void e() {
        this.f16409b.setText(R.string.pb_bo_reenter_paytm_passcode);
        this.f16415h.setText(R.string.pb_bo_confirm_passcode);
    }

    public final void a(String str, c cVar) {
        c cVar2 = this.f16411d;
        if (cVar == cVar2) {
            cVar2.a();
            e();
            this.f16410c.setCurrentItem(1);
            this.f16414g = str;
        } else if (cVar != this.f16412e) {
        } else {
            if (!this.f16414g.equals(str)) {
                this.f16413f.setVisibility(0);
                this.f16412e.a(true);
                return;
            }
            HashMap hashMap = new HashMap();
            if (d() == 100) {
                net.one97.paytm.bankCommon.mapping.c.a("bank_saving_account_confirm_passcode", (Map<String, Object>) hashMap, (Context) getActivity());
            }
            c();
            this.f16412e.a(false);
            String str2 = this.f16414g;
            try {
                net.one97.paytm.bankCommon.utils.g gVar = net.one97.paytm.bankCommon.utils.g.f16329a;
                FragmentActivity activity = getActivity();
                d.b();
                String a2 = com.paytm.e.a.b.a(d.a("pb_passcode_rsa_key"), str2);
                d.b();
                f a3 = net.one97.paytm.bankCommon.utils.g.a(activity, a2, com.paytm.e.a.b.a(d.a("pb_passcode_rsa_key"), str), String.valueOf(System.currentTimeMillis()), new g.b<IJRPaytmDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
                        if (g.this.isResumed()) {
                            g.this.W_();
                            if (iJRPaytmDataModel instanceof ValidatePasscode) {
                                ValidatePasscode validatePasscode = (ValidatePasscode) iJRPaytmDataModel;
                                g.this.c();
                                if (validatePasscode == null) {
                                    return;
                                }
                                if (validatePasscode.getStatus() != null && validatePasscode.getStatus().equalsIgnoreCase("SUCCESS")) {
                                    net.one97.paytm.bankCommon.h.b.a((Context) g.this.getActivity(), true);
                                    if (g.this.d() != 100) {
                                        g.this.g();
                                    } else if (g.this.getActivity() != null && (g.this.getActivity() instanceof e)) {
                                        net.one97.paytm.bankOpen.d.b.a(g.this.getActivity(), (e) g.this.getActivity());
                                    }
                                } else if (!TextUtils.isEmpty(validatePasscode.getMessage()) && g.this.getActivity() != null) {
                                    com.paytm.utility.b.b((Context) g.this.getActivity(), g.this.getString(R.string.error), validatePasscode.getMessage());
                                }
                            }
                        }
                    }
                }, new g.a() {
                    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (g.this.isResumed()) {
                            g.this.W_();
                            net.one97.paytm.bankCommon.utils.f.a((Activity) g.this.getActivity(), (Exception) networkCustomError, getClass().getSimpleName());
                        }
                    }
                }, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName());
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    a(getActivity(), getString(R.string.please_wait));
                    net.one97.paytm.bankOpen.f.a().getApplicationContext();
                    new net.one97.paytm.bankCommon.g.c();
                    net.one97.paytm.bankCommon.g.c.a(a3);
                    return;
                }
                net.one97.paytm.bankOpen.d.d dVar = net.one97.paytm.bankOpen.d.d.f16427a;
                net.one97.paytm.bankOpen.d.d.a(a3, getActivity());
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (NoSuchPaddingException e3) {
                e3.printStackTrace();
            } catch (InvalidKeyException e4) {
                e4.printStackTrace();
            } catch (IllegalBlockSizeException e5) {
                e5.printStackTrace();
            } catch (BadPaddingException e6) {
                e6.printStackTrace();
            } catch (InvalidKeySpecException e7) {
                e7.printStackTrace();
            }
        }
    }

    public void b() {
        this.f16409b.setText(R.string.set_paytm_passcode);
        f();
    }

    public final void a(boolean z) {
        if (z) {
            this.f16413f.setVisibility(0);
        } else {
            this.f16413f.setVisibility(8);
        }
    }

    public final void f() {
        this.f16413f.setVisibility(8);
        this.f16410c.setCurrentItem(0);
        this.f16411d.a();
        this.f16412e.a();
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (isResumed()) {
            super.onResponse(iJRPaytmDataModel);
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof SetPasscodeModel)) {
                W_();
                SetPasscodeModel setPasscodeModel = (SetPasscodeModel) iJRPaytmDataModel;
                if (TextUtils.isEmpty(setPasscodeModel.status)) {
                    return;
                }
                if (setPasscodeModel.status.equalsIgnoreCase("success") && setPasscodeModel.responseCode.equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                    net.one97.paytm.bankCommon.h.b.a((Context) getActivity(), true);
                    if (getActivity() != null && (getActivity() instanceof e)) {
                        net.one97.paytm.bankOpen.d.b.a(getActivity(), (e) getActivity());
                    }
                } else if (!TextUtils.isEmpty(setPasscodeModel.message) && getActivity() != null) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), setPasscodeModel.message);
                }
            }
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (isResumed()) {
            W_();
            if (networkCustomError != null) {
                net.one97.paytm.bankCommon.utils.f.a((Context) getActivity(), networkCustomError, i2);
            }
        }
    }
}
