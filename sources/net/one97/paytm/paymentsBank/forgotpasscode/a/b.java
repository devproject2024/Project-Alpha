package net.one97.paytm.paymentsBank.forgotpasscode.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.utils.PinEntryView;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.forgotpasscode.model.OvdOtpSendResponse;
import net.one97.paytm.paymentsBank.fragment.p;
import net.one97.paytm.paymentsBank.pdc.b.a;

public class b extends p implements a {

    /* renamed from: a  reason: collision with root package name */
    private View f18373a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public PinEntryView f18374b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f18375c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18376d;

    /* renamed from: e  reason: collision with root package name */
    private int f18377e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public d f18378f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity().getWindow().setSoftInputMode(20);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.f18373a = layoutInflater.inflate(R.layout.pb_fragment_ovd_verify_otp_v2, (ViewGroup) null, false);
        a(R.id.iv_motif);
        ImageView imageView = (ImageView) a(R.id.iv_back);
        a(R.id.titleTv);
        TextView textView = (TextView) a(R.id.subTitleTv);
        this.f18374b = (PinEntryView) a(R.id.otpView);
        this.f18375c = (TextView) a(R.id.tv_passcode_error);
        this.f18376d = (TextView) a(R.id.tv_resent_otp);
        String l = com.paytm.utility.b.l((Context) getActivity());
        if (!TextUtils.isEmpty(l)) {
            str = "XX " + l.substring(l.length() - 4);
        } else {
            str = "";
        }
        textView.setText(getString(R.string.pb_ovd_pls_entr_otp_snt_to_updated, str));
        this.f18376d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
        this.f18374b.setOnPinEnteredListener(new PinEntryView.b() {
            public final void a(String str) {
                if (str.length() != 6) {
                    b.this.f18375c.setText(b.this.getString(R.string.enter_valid_otp));
                    b.this.a(Boolean.TRUE);
                } else if (b.this.f18378f != null) {
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("challengeType", "OTP");
                    hashMap.put("challengeVal", b.this.f18374b.getText().toString());
                    b.this.f18378f.onFragmentAction(100, hashMap);
                }
            }

            public final void af_() {
                b.this.a(Boolean.FALSE);
            }
        });
        this.f18374b.requestFocus();
        return this.f18373a;
    }

    /* access modifiers changed from: private */
    public void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.f18375c.setVisibility(0);
        } else {
            this.f18375c.setVisibility(4);
        }
        if (bool.booleanValue()) {
            int i2 = net.one97.paytm.bankOpen.R.drawable.pin_view_red_bg;
        } else {
            int i3 = R.drawable.pin_view_gray_bg;
        }
    }

    private View a(int i2) {
        return this.f18373a.findViewById(i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getActivity().onBackPressed();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f18378f = (d) getActivity();
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onResponse(iJRPaytmDataModel);
        q();
        if (iJRPaytmDataModel instanceof OvdOtpSendResponse) {
            OvdOtpSendResponse ovdOtpSendResponse = (OvdOtpSendResponse) iJRPaytmDataModel;
            if ("success".equalsIgnoreCase(ovdOtpSendResponse.getStatus())) {
                a(Boolean.FALSE);
            } else if (!TextUtils.isEmpty(ovdOtpSendResponse.getMessage())) {
                net.one97.paytm.bankCommon.mapping.a.b((Context) getActivity(), getString(R.string.error), ovdOtpSendResponse.getMessage());
            } else {
                net.one97.paytm.bankCommon.mapping.a.b((Context) getActivity(), getString(R.string.error), getString(R.string.some_went_wrong));
            }
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        super.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
    }

    public final void a(Object obj) {
        this.f18374b.a();
        a(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        d dVar = this.f18378f;
        if (dVar != null) {
            dVar.onFragmentAction(102, (Object) null);
        }
        if (this.f18377e > 1) {
            this.f18376d.setVisibility(4);
        }
    }
}
