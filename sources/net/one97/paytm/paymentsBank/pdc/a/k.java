package net.one97.paytm.paymentsBank.pdc.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import net.one97.paytm.bankCommon.d.c;
import net.one97.paytm.bankCommon.model.SetPasscodeModel;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.a.e;
import net.one97.paytm.paymentsBank.fragment.l;
import net.one97.paytm.upi.util.UpiUtils;

public class k extends l implements View.OnClickListener, c.b {

    /* renamed from: a  reason: collision with root package name */
    private TextView f18631a;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f18632c;

    /* renamed from: d  reason: collision with root package name */
    private c f18633d;

    /* renamed from: e  reason: collision with root package name */
    private c f18634e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18635f;

    /* renamed from: g  reason: collision with root package name */
    private String f18636g;

    /* renamed from: h  reason: collision with root package name */
    private RoboTextView f18637h;

    /* renamed from: i  reason: collision with root package name */
    private c.b f18638i;

    public final void a(boolean z) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_pdc_set_atm_pin, (ViewGroup) null);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f18631a = (TextView) getView().findViewById(R.id.payment_bank_set_passcode_tv_title);
        this.f18637h = (RoboTextView) getView().findViewById(R.id.tv_passcode_desc);
        this.f18632c = (ViewPager) getView().findViewById(R.id.payment_bank_set_passcode_pager_passcode);
        this.f18635f = (TextView) getView().findViewById(R.id.set_passcode_tv_error_msg);
        e eVar = new e(getFragmentManager());
        this.f18632c.setAdapter(eVar);
        this.f18633d = (c) eVar.getItem(0);
        this.f18634e = (c) eVar.getItem(1);
        this.f18633d.f16236a = this;
        this.f18634e.f16236a = this;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.set_passcode_img_close) {
            if (getActivity() != null && (getActivity() instanceof net.one97.paytm.bankCommon.f.e)) {
                getActivity().onBackPressed();
            }
            d();
        }
    }

    public final void a(String str, c cVar) {
        c cVar2 = this.f18633d;
        if (cVar == cVar2) {
            cVar2.a();
            this.f18634e.b();
            this.f18631a.setText(R.string.confirm_atm_pin);
            this.f18637h.setVisibility(4);
            this.f18632c.setCurrentItem(1);
            this.f18636g = str;
            return;
        }
        c cVar3 = this.f18634e;
        if (cVar == cVar3) {
            cVar3.b();
            if (!this.f18636g.equals(str)) {
                this.f18635f.setVisibility(0);
                this.f18634e.a(true);
                return;
            }
            d();
            this.f18634e.a(false);
            c.b bVar = this.f18638i;
            if (bVar != null) {
                bVar.a(str, this.f18634e);
            }
        }
    }

    public final void b() {
        this.f18631a.setText(R.string.set_your_atm_pin);
        this.f18637h.setVisibility(0);
        this.f18635f.setVisibility(8);
        this.f18632c.setCurrentItem(0);
        this.f18633d.a();
        this.f18634e.a();
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onResponse(iJRPaytmDataModel);
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof SetPasscodeModel)) {
            c();
            SetPasscodeModel setPasscodeModel = (SetPasscodeModel) iJRPaytmDataModel;
            if (TextUtils.isEmpty(setPasscodeModel.status)) {
                return;
            }
            if ((!setPasscodeModel.status.equalsIgnoreCase("success") || !setPasscodeModel.responseCode.equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) && !TextUtils.isEmpty(setPasscodeModel.message) && getActivity() != null) {
                b.b((Context) getActivity(), getString(R.string.error), setPasscodeModel.message);
            }
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c();
        if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage())) {
            if (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401)) {
                f.a((Activity) getActivity(), (Exception) networkCustomError, (String) null);
            }
        }
    }
}
