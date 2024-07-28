package net.one97.paytm.wallet.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entitiy.offline_pg.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.common.entity.wallet.CJRObdResponse;
import net.one97.paytm.i.f;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

public class o extends f implements View.OnClickListener, b {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f70094a;

    /* renamed from: b  reason: collision with root package name */
    private View f70095b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f70096c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f70097d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f70098e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f70099f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f70100g;

    /* renamed from: h  reason: collision with root package name */
    private FrameLayout f70101h;

    /* renamed from: i  reason: collision with root package name */
    private CoordinatorLayout f70102i;
    private BottomSheetBehavior<FrameLayout> j;
    private RelativeLayout k;
    private TextView l;
    private TextView m;
    private boolean n;
    private boolean o;
    private RelativeLayout p;
    private RelativeLayout q;
    private TextView r;
    private Context s;
    private boolean t;

    public void onAttach(Context context) {
        super.onAttach(context);
        this.s = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f70095b = layoutInflater.inflate(R.layout.lyt_resend_confirmation, viewGroup, false);
        this.f70096c = (ImageView) this.f70095b.findViewById(R.id.iv_close_resend_sheet);
        this.f70097d = (ImageView) this.f70095b.findViewById(R.id.iv_close_resend_conf_resp);
        this.f70099f = (RelativeLayout) this.f70095b.findViewById(R.id.rl_call);
        this.f70099f.setOnClickListener(this);
        this.f70100g = (RelativeLayout) this.f70095b.findViewById(R.id.rl_sms);
        this.f70100g.setOnClickListener(this);
        this.k = (RelativeLayout) this.f70095b.findViewById(R.id.rl_resend_conf_response);
        this.p = (RelativeLayout) this.f70095b.findViewById(R.id.rl_try_again);
        this.p.setOnClickListener(this);
        this.m = (TextView) this.f70095b.findViewById(R.id.tv_send_sms_or_call);
        this.l = (TextView) this.f70095b.findViewById(R.id.tv_could_not_initiate_call);
        this.f70098e = (ImageView) this.f70095b.findViewById(R.id.iv_conf_resp_image);
        this.q = (RelativeLayout) this.f70095b.findViewById(R.id.rl_call_or_sms);
        this.q.setOnClickListener(this);
        this.r = (TextView) this.f70095b.findViewById(R.id.tv_resend_payment_conf_to_merchant_name);
        this.r.setText(String.format(getString(R.string.ask_paytm_to_call_sms_merchant, getArguments().getString("merchant_name")), new Object[0]));
        this.f70096c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.b(view);
            }
        });
        this.f70097d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.a(view);
            }
        });
        return this.f70095b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (isAdded()) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (isAdded()) {
            dismiss();
        }
    }

    private void a() {
        f();
        c.a();
        String u = c.u();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("ssotoken", t.b((Context) getActivity()));
        d.a(getContext(), u, this, hashMap, hashMap2, a.C0715a.POST, b(), new CJRObdResponse(), a.c.PAYMENTS, a.b.SILENT).a();
    }

    private String b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("txnId", getArguments().getString(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, (String) null));
            jSONObject.put("request", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return jSONObject.toString();
        } catch (Throwable unused) {
            return jSONObject.toString();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                o.this.a(dialogInterface);
            }
        });
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return o.this.a(dialogInterface, i2, keyEvent);
            }
        });
        return onCreateDialog;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
        this.f70102i = (CoordinatorLayout) aVar.findViewById(R.id.coordinator);
        this.f70101h = (FrameLayout) aVar.findViewById(R.id.design_bottom_sheet);
        this.j = BottomSheetBehavior.from(this.f70101h);
        BottomSheetBehavior.from(this.f70101h).setState(3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !isAdded()) {
            return false;
        }
        dismiss();
        return false;
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (getActivity() != null) {
            new Handler(getActivity().getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    o.this.h();
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        g();
        e();
    }

    private void c() {
        f();
        c.a();
        String a2 = c.a("paymentConfirmationSmsURL", (String) null);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        String str = com.paytm.utility.b.v(this.s) + System.currentTimeMillis();
        try {
            jSONObject2.put(l.f69745a, "market-app");
            jSONObject2.put(net.one97.paytm.common.utility.b.aT, getArguments().getString("merchant_id", ""));
            jSONObject2.put(l.f69747c, str);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put(l.f69748d, t.b(getContext()));
            jSONObject2.put(l.f69749e, com.paytm.utility.b.a().toUpperCase());
            jSONObject2.put(l.f69750f, "9.1.3");
            jSONObject3.put("orderId", getArguments().getString("order_id", ""));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("messageId", str);
            jSONObject4.put("mobileNo", getArguments().getString("mobileNumber", ""));
            jSONObject4.put("content", "random text");
            jSONObject4.put("priority", "4");
            jSONObject3.put("smsRequest", jSONObject4);
            jSONObject.put(l.f69752h, jSONObject2);
            jSONObject.put(l.f69753i, jSONObject3);
        } catch (JSONException unused) {
        }
        d.a(getContext(), a2, this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJPayMethodResponse(), a.c.PAYMENTS, a.b.SILENT).a();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        g();
        if (iJRPaytmDataModel instanceof CJRObdResponse) {
            CJRObdResponse cJRObdResponse = (CJRObdResponse) iJRPaytmDataModel;
            if (cJRObdResponse.getStatusCode() == null || !cJRObdResponse.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                e();
            } else {
                d();
            }
        } else if (iJRPaytmDataModel instanceof CJPayMethodResponse) {
            CJPayMethodResponse cJPayMethodResponse = (CJPayMethodResponse) iJRPaytmDataModel;
            if (cJPayMethodResponse == null || cJPayMethodResponse.getCjrPayMethods() == null || !cJPayMethodResponse.getCjrPayMethods().getResultInfo().getResultStatus().equalsIgnoreCase("S")) {
                e();
            } else {
                d();
            }
        }
    }

    private void d() {
        this.f70095b.findViewById(R.id.ll_retry_layout).setVisibility(8);
        this.f70097d.setVisibility(8);
        this.f70096c.setVisibility(8);
        this.f70098e.setImageDrawable(androidx.core.content.b.a(this.s, (int) R.drawable.gree_tick_icon));
        if (this.n) {
            this.l.setText(getString(R.string.conf_call_initiated_successfully));
        }
        if (this.o) {
            this.l.setText(getString(R.string.conf_sms_sent_successfully));
        }
        this.j.setState(4);
        this.k.setVisibility(0);
        this.f70095b.findViewById(R.id.rl_resend_conf).setVisibility(8);
        this.j.setState(3);
    }

    private void e() {
        if (this.n) {
            this.m.setText(getString(R.string.or_send_sms));
            this.l.setText(getString(R.string.we_could_not_initiate_conf_call));
        }
        if (this.o) {
            this.m.setText(getString(R.string.or_call));
            this.l.setText(getString(R.string.we_could_not_initiate_conf_sms));
        }
        if (!this.t) {
            this.j.setState(4);
            this.k.setVisibility(0);
            this.f70095b.findViewById(R.id.rl_resend_conf).setVisibility(8);
            this.j.setState(3);
            this.f70098e.setImageDrawable(androidx.core.content.b.a(this.s, (int) R.drawable.resend_conf_failed));
        }
    }

    private void f() {
        try {
            if (this.f70094a == null) {
                this.f70094a = net.one97.paytm.wallet.utility.a.b((Activity) getActivity());
            }
            if (this.f70094a != null && !this.f70094a.isShowing()) {
                this.f70094a.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void g() {
        try {
            if (this.f70094a != null && this.f70094a.isShowing()) {
                this.f70094a.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_call:
                this.n = true;
                a();
                return;
            case R.id.rl_call_or_sms:
                if (this.n) {
                    this.n = false;
                    break;
                } else {
                    this.n = true;
                    this.o = false;
                    a();
                    return;
                }
            case R.id.rl_sms:
                break;
            case R.id.rl_try_again:
                this.t = true;
                if (this.n) {
                    a();
                    return;
                } else {
                    c();
                    return;
                }
            default:
                return;
        }
        this.o = true;
        c();
    }
}
