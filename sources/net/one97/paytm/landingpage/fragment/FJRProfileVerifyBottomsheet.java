package net.one97.paytm.landingpage.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import java.util.HashMap;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRUserDefaultInfo;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.wallet.VerifyProfileCardResponse;
import net.one97.paytm.i.f;
import net.one97.paytm.landingpage.R;
import org.json.JSONException;
import org.json.JSONObject;

public class FJRProfileVerifyBottomsheet extends f implements View.OnClickListener, b {
    private TextView bottomsheetbutton;
    private ImageView bottomsheetclose;
    private TextView doitlaterbutton;
    private TextView emailadd;
    private TextView emailedit;
    private String mEmail = null;
    private String mMobile = null;
    private CJRUserInfoV2 mUserInfo;
    private TextView mobileedit;
    private TextView verifyEmail;
    private TextView verifyEmail2;
    private TextView verifymobile;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.profile_verify_bottomsheet, viewGroup, false);
        initViews(inflate);
        return inflate;
    }

    public void show(j jVar, String str) {
        try {
            q a2 = jVar.a();
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException unused) {
        }
    }

    private void initViews(View view) {
        this.bottomsheetclose = (ImageView) view.findViewById(R.id.iv_close);
        this.doitlaterbutton = (TextView) view.findViewById(R.id.do_it_later);
        this.verifymobile = (TextView) view.findViewById(R.id.verify_mobile_text2);
        this.verifyEmail = (TextView) view.findViewById(R.id.verify_email_text);
        this.verifyEmail2 = (TextView) view.findViewById(R.id.verify_email_text2);
        this.emailedit = (TextView) view.findViewById(R.id.email_edit);
        this.emailadd = (TextView) view.findViewById(R.id.email_add);
        this.mobileedit = (TextView) view.findViewById(R.id.mobile_edit);
        this.bottomsheetbutton = (TextView) view.findViewById(R.id.bottomsheetbuttonconfirm);
        this.mMobile = a.b(getActivity().getApplicationContext());
        this.mEmail = a.c(getActivity().getApplicationContext());
        this.mUserInfo = new CJRUserInfoV2();
        CJRUserDefaultInfo cJRUserDefaultInfo = new CJRUserDefaultInfo();
        cJRUserDefaultInfo.setPhone(this.mMobile);
        cJRUserDefaultInfo.setEmail(this.mEmail);
        this.mUserInfo.setUserDefaultInfo(cJRUserDefaultInfo);
        this.mUserInfo.setUserId(a.a((Context) getActivity()));
        if (this.mMobile != null) {
            TextView textView = this.verifymobile;
            textView.setText("+91 " + this.mMobile);
            this.verifymobile.setTextColor(getResources().getColor(R.color.color_222222));
        }
        if (this.mEmail != null) {
            this.verifyEmail.setVisibility(0);
            this.verifyEmail2.setText(this.mEmail);
            this.verifyEmail2.setTextColor(getResources().getColor(R.color.color_222222));
        } else {
            this.emailadd.setVisibility(0);
            this.emailedit.setVisibility(8);
        }
        this.bottomsheetclose.setOnClickListener(this);
        this.doitlaterbutton.setOnClickListener(this);
        this.emailedit.setOnClickListener(this);
        this.emailadd.setOnClickListener(this);
        this.mobileedit.setOnClickListener(this);
        this.bottomsheetbutton.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_close) {
            dismiss();
        } else if (id == R.id.do_it_later) {
            dismiss();
        } else if (id == R.id.email_edit) {
            callprofileemailedit();
        } else if (id == R.id.mobile_edit) {
            callprofilemobileedit();
        } else if (id == R.id.email_add) {
            callprofileemailadd();
        } else if (id == R.id.bottomsheetbuttonconfirm) {
            confirmApiCall();
            dismiss();
        }
    }

    public void callprofileemailedit() {
        Intent a2 = d.a().a((Context) getActivity());
        a2.putExtra(AppConstants.KEY_EMAIL, this.mEmail);
        a2.putExtra("extra_home_data", this.mUserInfo);
        a2.putExtra("mobile_email", AppConstants.KEY_EMAIL);
        getActivity().startActivityForResult(a2, 211);
    }

    public void callprofileemailadd() {
        Intent a2 = d.a().a((Context) getActivity());
        a2.putExtra(AppConstants.KEY_EMAIL, this.mUserInfo.getUserDefaultInfo().getEmail());
        a2.putExtra("extra_home_data", this.mUserInfo);
        a2.putExtra("mobile_email", AppConstants.KEY_EMAIL);
        a2.putExtra("verify_mobile_email", "emailadd");
        getActivity().startActivityForResult(a2, 211);
    }

    public void callprofilemobileedit() {
        Intent a2 = d.a().a((Context) getActivity());
        a2.putExtra("mobileNumber", this.mMobile);
        a2.putExtra("extra_home_data", this.mUserInfo);
        a2.putExtra("mobile_email", "mobile");
        getActivity().startActivityForResult(a2, 211);
    }

    public void confirmApiCall() {
        String str = getagreedDetails();
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", a.a((Context) getActivity()));
        } catch (JSONException e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("session_token", d.a().b((Context) getActivity()));
        hashMap2.put("Authorization", com.paytm.utility.b.m());
        String jSONObject2 = jSONObject.toString();
        if (a.m(getActivity())) {
            d.a(getActivity(), str, new b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    WebLogin.RESPONSE_CODE_SUCCESS.equalsIgnoreCase(((VerifyProfileCardResponse) iJRPaytmDataModel).getResponseCode());
                }
            }, hashMap2, hashMap, a.C0715a.POST, jSONObject2, new VerifyProfileCardResponse(), a.c.HOME, a.b.SILENT);
        }
    }

    private String getagreedDetails() {
        net.one97.paytm.common.b.a b2 = d.b();
        getActivity();
        return b2.a("agreeddetails");
    }
}
