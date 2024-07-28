package net.one97.paytm.postpayment.a;

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
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.base.d;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.h;
import net.one97.paytm.postpayment.models.CJRObdResponse;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.common.entity.offline_pg.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.wallet.communicator.b;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f59698a;

    /* renamed from: b  reason: collision with root package name */
    private View f59699b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f59700c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f59701d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f59702e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f59703f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f59704g;

    /* renamed from: h  reason: collision with root package name */
    private FrameLayout f59705h;

    /* renamed from: i  reason: collision with root package name */
    private CoordinatorLayout f59706i;
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
        this.f59699b = layoutInflater.inflate(R.layout.lyt_resend_confirmation, viewGroup, false);
        this.f59700c = (ImageView) this.f59699b.findViewById(R.id.iv_close_resend_sheet);
        this.f59701d = (ImageView) this.f59699b.findViewById(R.id.iv_close_resend_conf_resp);
        this.f59703f = (RelativeLayout) this.f59699b.findViewById(R.id.rl_call);
        this.f59703f.setOnClickListener(this);
        this.f59704g = (RelativeLayout) this.f59699b.findViewById(R.id.rl_sms);
        this.f59704g.setOnClickListener(this);
        this.k = (RelativeLayout) this.f59699b.findViewById(R.id.rl_resend_conf_response);
        this.p = (RelativeLayout) this.f59699b.findViewById(R.id.rl_try_again);
        this.p.setOnClickListener(this);
        this.m = (TextView) this.f59699b.findViewById(R.id.tv_send_sms_or_call);
        this.l = (TextView) this.f59699b.findViewById(R.id.tv_could_not_initiate_call);
        this.f59702e = (ImageView) this.f59699b.findViewById(R.id.iv_conf_resp_image);
        this.q = (RelativeLayout) this.f59699b.findViewById(R.id.rl_call_or_sms);
        this.q.setOnClickListener(this);
        this.r = (TextView) this.f59699b.findViewById(R.id.tv_resend_payment_conf_to_merchant_name);
        this.r.setText(String.format(getString(R.string.ask_paytm_to_call_sms_merchant), new Object[]{getArguments().getString("merchant_name")}));
        this.f59700c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b(view);
            }
        });
        this.f59701d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        return this.f59699b;
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
        y<net.one97.paytm.network.f> yVar;
        g();
        String stringFromGTM = b.a().getStringFromGTM(this.s, "obdCallMerchantUrl");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("ssotoken", com.paytm.utility.a.q(getActivity()));
        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(stringFromGTM, new CJRObdResponse(), hashMap2, hashMap, b());
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(b.a().getIntegerFromGTM(this.s, "p2mGenericAPITimeOut")));
        if (com.paytm.utility.b.c(this.s)) {
            yVar = bVar.c();
        } else {
            yVar = d.f49504d.a(this.s, bVar);
        }
        if (yVar != null) {
            yVar.observeForever(new z() {
                public final void onChanged(Object obj) {
                    a.this.b((net.one97.paytm.network.f) obj);
                }
            });
        }
    }

    private String b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("txnId", getArguments().getString(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, (String) null));
            jSONObject.put("request", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return jSONObject.toString();
        } catch (Throwable unused2) {
            return jSONObject.toString();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                a.this.a(dialogInterface);
            }
        });
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return a.this.a(dialogInterface, i2, keyEvent);
            }
        });
        return onCreateDialog;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
        this.f59706i = (CoordinatorLayout) aVar.findViewById(com.google.android.material.R.id.coordinator);
        this.f59705h = (FrameLayout) aVar.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        FrameLayout frameLayout = this.f59705h;
        if (frameLayout != null) {
            this.j = BottomSheetBehavior.from(frameLayout);
            BottomSheetBehavior.from(this.f59705h).setState(3);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !isAdded()) {
            return false;
        }
        dismiss();
        return false;
    }

    private void c() {
        if (getActivity() != null) {
            new Handler(getActivity().getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    a.this.i();
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        h();
        f();
    }

    private void d() {
        y<net.one97.paytm.network.f> yVar;
        g();
        String stringFromGTM = b.a().getStringFromGTM(this.s, "paymentConfirmationSmsURL");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        String str = com.paytm.utility.b.v(this.s) + System.currentTimeMillis();
        try {
            jSONObject2.put("clientId", b.a().getClientId());
            jSONObject2.put("mid", getArguments().getString("merchant_id", ""));
            jSONObject2.put("requestId", str);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put(StringSet.token, com.paytm.utility.a.q(getContext()));
            jSONObject2.put("tokenType", com.paytm.utility.b.a().toUpperCase());
            jSONObject2.put("version", "1.0");
            jSONObject3.put("orderId", getArguments().getString("order_id", ""));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("messageId", str);
            jSONObject4.put("mobileNo", getArguments().getString("mobileNumber", ""));
            jSONObject4.put("content", "random text");
            jSONObject4.put("priority", "4");
            jSONObject3.put("smsRequest", jSONObject4);
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
        } catch (JSONException unused) {
        }
        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(stringFromGTM, new CJPayMethodResponse(), (Map<String, String>) null, (Map<String, String>) null, jSONObject.toString());
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(b.a().getIntegerFromGTM(this.s, "p2mGenericAPITimeOut")));
        if (com.paytm.utility.b.c(this.s)) {
            yVar = bVar.c();
        } else {
            yVar = d.f49504d.a(this.s, bVar);
        }
        if (yVar != null) {
            yVar.observeForever(new z() {
                public final void onChanged(Object obj) {
                    a.this.a((net.one97.paytm.network.f) obj);
                }
            });
        }
    }

    private void a(IJRPaytmDataModel iJRPaytmDataModel) {
        h();
        if (iJRPaytmDataModel instanceof CJRObdResponse) {
            CJRObdResponse cJRObdResponse = (CJRObdResponse) iJRPaytmDataModel;
            if (cJRObdResponse.getStatusCode() == null || !cJRObdResponse.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                f();
            } else {
                e();
            }
        } else if (iJRPaytmDataModel instanceof CJPayMethodResponse) {
            CJPayMethodResponse cJPayMethodResponse = (CJPayMethodResponse) iJRPaytmDataModel;
            if (cJPayMethodResponse.getCjrPayMethods() == null || !cJPayMethodResponse.getCjrPayMethods().getResultInfo().getResultStatus().equalsIgnoreCase("S")) {
                f();
            } else {
                e();
            }
        }
    }

    private void e() {
        this.f59699b.findViewById(R.id.ll_retry_layout).setVisibility(8);
        this.f59701d.setVisibility(8);
        this.f59700c.setVisibility(8);
        this.f59702e.setImageDrawable(androidx.core.content.b.a(this.s, R.drawable.gree_tick_icon));
        if (this.n) {
            this.l.setText(getString(R.string.conf_call_initiated_successfully));
        }
        if (this.o) {
            this.l.setText(getString(R.string.conf_sms_sent_successfully));
        }
        this.j.setState(4);
        this.k.setVisibility(0);
        this.f59699b.findViewById(R.id.rl_resend_conf).setVisibility(8);
        this.j.setState(3);
    }

    private void f() {
        if (this.n) {
            this.m.setText(getString(R.string.or_send_sms));
            this.l.setText(getString(R.string.we_could_not_initiate_the_confirmation_call));
        }
        if (this.o) {
            this.m.setText(getString(R.string.or_call));
            this.l.setText(getString(R.string.we_could_not_initiate_conf_sms));
        }
        if (!this.t) {
            this.j.setState(4);
            this.k.setVisibility(0);
            this.f59699b.findViewById(R.id.rl_resend_conf).setVisibility(8);
            this.j.setState(3);
            this.f59702e.setImageDrawable(androidx.core.content.b.a(this.s, R.drawable.resend_conf_failed));
        }
    }

    private void g() {
        try {
            if (this.f59698a == null) {
                this.f59698a = net.one97.paytm.wallet.utility.a.b((Activity) getActivity());
            }
            if (this.f59698a != null && !this.f59698a.isShowing()) {
                this.f59698a.show();
            }
        } catch (Exception unused) {
        }
    }

    private void h() {
        try {
            if (this.f59698a != null && this.f59698a.isShowing()) {
                this.f59698a.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rl_try_again) {
            this.t = true;
            if (this.n) {
                a();
            } else {
                d();
            }
        } else if (id == R.id.rl_call_or_sms) {
            if (this.n) {
                this.n = false;
                this.o = true;
                d();
                return;
            }
            this.n = true;
            this.o = false;
            a();
        } else if (id == R.id.rl_call) {
            this.n = true;
            a();
        } else if (id == R.id.rl_sms) {
            this.o = true;
            d();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            c();
        }
    }
}
