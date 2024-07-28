package net.one97.paytm.paymentsBank.nach.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.l;
import net.one97.paytm.paymentsBank.model.nach.NachMandateResponse;
import net.one97.paytm.paymentsBank.model.nach.Payload;
import net.one97.paytm.paymentsBank.nach.landing.PBNachRequestListActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCPasscodePinActivity;

public class a extends l implements View.OnClickListener, g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    private LottieAnimationView f18553a;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f18554c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18555d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f18556e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18557f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f18558g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f18559h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f18560i;
    private TextView j;
    private Payload k;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_fragment_nach_mandate_awaiting, viewGroup, false);
        inflate.findViewById(R.id.statusTv);
        this.f18555d = (TextView) inflate.findViewById(R.id.bankNameTv);
        this.f18556e = (TextView) inflate.findViewById(R.id.frequencyTv);
        this.f18557f = (TextView) inflate.findViewById(R.id.requestRupeesTv);
        this.f18558g = (TextView) inflate.findViewById(R.id.dateTv);
        View findViewById = inflate.findViewById(R.id.acceptBtn);
        View findViewById2 = inflate.findViewById(R.id.rejectBtn);
        View findViewById3 = inflate.findViewById(R.id.viewAllBtn);
        this.j = (TextView) inflate.findViewById(R.id.previousAmountTitle);
        this.f18559h = (TextView) inflate.findViewById(R.id.prevfrequencyTv);
        this.f18560i = (TextView) inflate.findViewById(R.id.prevrequestRupeesTv);
        findViewById.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById3.setOnClickListener(this);
        this.f18554c = (ViewGroup) inflate.findViewById(R.id.normalLayout);
        this.f18553a = (LottieAnimationView) inflate.findViewById(R.id.nach_loader);
        inflate.findViewById(R.id.lineAboveBtns).setVisibility(8);
        View findViewById4 = inflate.findViewById(R.id.mandateCard);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById4.getLayoutParams();
        layoutParams.topMargin = 0;
        findViewById4.setLayoutParams(layoutParams);
        findViewById4.setBackgroundResource(0);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        if (getUserVisibleHint() && b.r(getActivity().getApplicationContext())) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f c2 = net.one97.paytm.paymentsBank.b.a.c(getActivity(), this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
            if (!b.c((Context) getActivity()) || c2 == null) {
                a(this.f18553a);
                return;
            }
            getActivity();
            new c();
            c.a(c2);
        }
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (isAdded()) {
            a(this.f18553a);
            if (iJRPaytmDataModel instanceof NachMandateResponse) {
                Payload payload = null;
                List<Payload> payload2 = ((NachMandateResponse) iJRPaytmDataModel).getPayload();
                Intent intent = new Intent("PENDING");
                if (payload2 != null && payload2.size() > 0) {
                    intent.putExtra("PENDING", true);
                    Iterator<Payload> it2 = payload2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Payload next = it2.next();
                        if ("PENDING".equalsIgnoreCase(next.getStatus())) {
                            payload = next;
                            break;
                        }
                    }
                } else {
                    intent.putExtra("PENDING", false);
                }
                androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(intent);
                if (payload != null) {
                    this.f18554c.setVisibility(0);
                    this.k = payload;
                    this.f18555d.setText(this.k.getCorporate());
                    String string = getString(R.string.pb_nach_until_cancelled);
                    String str = "";
                    if (this.k.getAmend().booleanValue()) {
                        this.f18559h.setVisibility(0);
                        this.j.setVisibility(0);
                        this.f18560i.setVisibility(0);
                        if ("VARIABLE".equals(this.k.getCurrentAmountType())) {
                            this.f18560i.setText(getString(R.string.pb_nach_upto_rupee, net.one97.paytm.bankCommon.mapping.a.ac(this.k.getCurrentAmount())));
                        } else {
                            this.f18560i.setText(getString(R.string.pb_nach_rupee, net.one97.paytm.bankCommon.mapping.a.ac(this.k.getCurrentAmount())));
                        }
                        if ("VARIABLE".equals(this.k.getNewAmountType())) {
                            this.f18557f.setText(getString(R.string.pb_nach_upto_rupee, net.one97.paytm.bankCommon.mapping.a.ac(this.k.getNewAmount())));
                        } else {
                            this.f18557f.setText(getString(R.string.pb_nach_rupee, net.one97.paytm.bankCommon.mapping.a.ac(this.k.getNewAmount())));
                        }
                        if (TextUtils.isEmpty(this.k.getCurrentRecurringCode())) {
                            this.f18559h.setText(this.k.getCurrentFrequency());
                        } else if ("OOFF".equals(this.k.getCurrentRecurringCode())) {
                            this.f18559h.setText(R.string.pb_nach_one_time);
                        } else {
                            this.f18559h.setText(this.k.getCurrentFrequency());
                        }
                        if (TextUtils.isEmpty(this.k.getNewRecurringCode())) {
                            this.f18556e.setText(this.k.getNewFrequency());
                        } else if ("OOFF".equals(this.k.getNewRecurringCode())) {
                            this.f18556e.setText(R.string.pb_nach_one_time);
                        } else {
                            this.f18556e.setText(this.k.getNewFrequency());
                        }
                        if (!TextUtils.isEmpty(this.k.getNewEndDate())) {
                            string = getString(R.string.pb_nach_to, this.k.getNewEndDate());
                        }
                        TextView textView = this.f18558g;
                        int i2 = R.string.pb_nach_to_from;
                        Object[] objArr = new Object[2];
                        if (!TextUtils.isEmpty(this.k.getNewStartDate())) {
                            str = this.k.getNewStartDate();
                        }
                        objArr[0] = str;
                        objArr[1] = string;
                        textView.setText(getString(i2, objArr));
                        return;
                    }
                    if ("VARIABLE".equals(this.k.getCurrentAmountType())) {
                        this.f18557f.setText(getString(R.string.pb_nach_upto_rupee, net.one97.paytm.bankCommon.mapping.a.ac(this.k.getCurrentAmount())));
                    } else {
                        this.f18557f.setText(getString(R.string.pb_nach_rupee, net.one97.paytm.bankCommon.mapping.a.ac(this.k.getCurrentAmount())));
                    }
                    if (TextUtils.isEmpty(this.k.getCurrentRecurringCode())) {
                        this.f18556e.setText(this.k.getCurrentFrequency());
                    } else if ("OOFF".equals(this.k.getCurrentRecurringCode())) {
                        this.f18556e.setText(R.string.pb_nach_one_time);
                    } else {
                        this.f18556e.setText(this.k.getCurrentFrequency());
                    }
                    if (!TextUtils.isEmpty(this.k.getCurrentEndDate())) {
                        string = getString(R.string.pb_nach_to, this.k.getCurrentEndDate());
                    }
                    TextView textView2 = this.f18558g;
                    int i3 = R.string.pb_nach_to_from;
                    Object[] objArr2 = new Object[2];
                    if (!TextUtils.isEmpty(this.k.getCurrentStartDate())) {
                        str = this.k.getCurrentStartDate();
                    }
                    objArr2[0] = str;
                    objArr2[1] = string;
                    textView2.setText(getString(i3, objArr2));
                    return;
                }
                this.f18554c.setVisibility(8);
                return;
            }
            super.onResponse(iJRPaytmDataModel);
        }
    }

    private static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (isAdded()) {
            a(this.f18553a);
            super.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.acceptBtn) {
            Intent intent = new Intent(getActivity(), PDCPasscodePinActivity.class);
            intent.putExtra("ENTER_HEADER", "verifyPasscodeAndSendConsent");
            intent.putExtra("desc", getString(R.string.pb_nach_passcode_desc_for_consent_accept, this.k.getCorporate()));
            intent.putExtra("postParams", net.one97.paytm.bankCommon.utils.f.a(this.k.getAmend().booleanValue(), true, this.k.getUmrn()));
            intent.putExtra("isAcceptingMandate", true);
            startActivity(intent);
        } else if (id == R.id.rejectBtn) {
            Intent intent2 = new Intent(getActivity(), PDCPasscodePinActivity.class);
            intent2.putExtra("ENTER_HEADER", "verifyPasscodeAndSendConsent");
            intent2.putExtra("desc", getString(R.string.pb_nach_passcode_desc_for_consent_reject, this.k.getCorporate()));
            intent2.putExtra("postParams", net.one97.paytm.bankCommon.utils.f.a(this.k.getAmend().booleanValue(), false, this.k.getUmrn()));
            intent2.putExtra("isAcceptingMandate", false);
            startActivity(intent2);
        } else if (id == R.id.viewAllBtn) {
            startActivity(new Intent(getActivity(), PBNachRequestListActivity.class));
        }
    }
}
