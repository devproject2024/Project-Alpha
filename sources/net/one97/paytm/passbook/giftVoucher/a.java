package net.one97.paytm.passbook.giftVoucher;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.v;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.i.f;
import net.one97.paytm.passbook.beans.GiftVoucherClaimResponse;
import net.one97.paytm.passbook.beans.SubwalletStatusResponseList;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.q;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends f {
    private BottomSheetBehavior.a A = new BottomSheetBehavior.a() {
        public final void onSlide(View view, float f2) {
        }

        public final void onStateChanged(View view, int i2) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private ImageView f57517a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C1082a f57518b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f57519c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f57520d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f57521e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f57522f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f57523g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f57524h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f57525i;
    private TextView j;
    private TextView k;
    private TextView l;
    private LinearLayout m;
    private LinearLayout n;
    private LinearLayout o;
    private LottieAnimationView p;
    private LottieAnimationView q;
    private LinearLayout r;
    private LinearLayout s;
    private Button t;
    private RelativeLayout u;
    private LottieAnimationView v;
    /* access modifiers changed from: private */
    public SubwalletStatusResponseList w;
    private String x;
    private TextView y;
    private TextView z;

    /* renamed from: net.one97.paytm.passbook.giftVoucher.a$a  reason: collision with other inner class name */
    public interface C1082a {
        void a();

        void a(String str);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.f57518b = (C1082a) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context + " must implement FragmentCommunicator");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.w = (SubwalletStatusResponseList) arguments.getSerializable("subwallet_data");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
            }
        });
        return aVar;
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), net.one97.paytm.passbook.R.layout.pass_gift_voucher_dialog_fragment, (ViewGroup) null);
        dialog.setContentView(inflate);
        net.one97.paytm.passbook.mapping.f b2 = d.b();
        getActivity();
        this.x = b2.x();
        this.f57517a = (ImageView) dialog.findViewById(net.one97.paytm.passbook.R.id.iv_close);
        this.t = (Button) dialog.findViewById(net.one97.paytm.passbook.R.id.gvConfirmBtn);
        this.f57519c = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.tvGvExpiryDate);
        this.f57520d = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.tvGvVoucherCode);
        this.f57521e = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.tvGvFrom);
        this.f57522f = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.tv_recipient_name);
        this.f57523g = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.tv_amount);
        this.f57524h = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.tv_gift_message);
        this.y = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.gvAddedText);
        this.f57525i = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.tvSuccessAmount);
        this.j = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.title_tv_confirm);
        this.j.setText(String.format(getString(net.one97.paytm.passbook.R.string.gv_redeem_header), new Object[]{this.x}));
        this.y.setText(String.format(getString(net.one97.paytm.passbook.R.string.gv_added), new Object[]{this.x}));
        this.k = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.title_tv_failed);
        this.k.setText(String.format(getString(net.one97.paytm.passbook.R.string.gv_failed), new Object[]{this.x}));
        this.l = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.title_tv_success);
        this.l.setText(String.format(getString(net.one97.paytm.passbook.R.string.gv_success), new Object[]{this.x}));
        this.z = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.gvFailedLayoutText);
        TextView textView = this.z;
        String string = getString(net.one97.paytm.passbook.R.string.gv_fail_status);
        String str = this.x;
        textView.setText(String.format(string, new Object[]{str, str}));
        this.p = (LottieAnimationView) dialog.findViewById(net.one97.paytm.passbook.R.id.gv_animation_view);
        this.r = (LinearLayout) dialog.findViewById(net.one97.paytm.passbook.R.id.gv_anim_layout);
        this.q = (LottieAnimationView) dialog.findViewById(net.one97.paytm.passbook.R.id.gv_success_animation_view);
        this.s = (LinearLayout) dialog.findViewById(net.one97.paytm.passbook.R.id.gv_success_anim_layout);
        this.m = (LinearLayout) dialog.findViewById(net.one97.paytm.passbook.R.id.gvFailedLayout);
        this.n = (LinearLayout) dialog.findViewById(net.one97.paytm.passbook.R.id.gvSuccessLayout);
        this.o = (LinearLayout) dialog.findViewById(net.one97.paytm.passbook.R.id.gvConfirmLayout);
        this.u = (RelativeLayout) dialog.findViewById(net.one97.paytm.passbook.R.id.loading_threedots_view);
        this.v = (LottieAnimationView) dialog.findViewById(net.one97.paytm.passbook.R.id.loading_threedots_lav);
        this.f57517a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f57518b.a();
                a.this.dismiss();
            }
        });
        try {
            ((View) inflate.getParent()).setBackgroundColor(getResources().getColor(17170445));
        } catch (Exception unused) {
        }
        this.t.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a aVar = a.this;
                a.a(aVar, aVar.w.getTxnId());
            }
        });
        String j2 = b.j((Context) getActivity());
        if (!TextUtils.isEmpty(this.w.getIssuerName())) {
            this.f57521e.setText(String.format(getString(net.one97.paytm.passbook.R.string.gv_from), new Object[]{this.w.getIssuerName()}));
        } else if (!TextUtils.isEmpty(this.w.getIssuerPhoneNo())) {
            this.f57521e.setText(String.format(getString(net.one97.paytm.passbook.R.string.gv_from), new Object[]{this.w.getIssuerPhoneNo()}));
        }
        if (!TextUtils.isEmpty(j2)) {
            this.f57522f.setText(j2);
        } else {
            this.f57522f.setText(b.l((Context) getActivity()));
        }
        String string2 = getString(net.one97.paytm.passbook.R.string.wallet_rs);
        if (!TextUtils.isEmpty(this.w.getTxnAmount())) {
            string2 = String.format(string2, new Object[]{new DecimalFormat(q.a(Double.parseDouble(this.w.getTxnAmount())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(this.w.getTxnAmount()))});
            this.f57523g.setText(string2);
        }
        String h2 = b.h((Context) getActivity());
        if (!TextUtils.isEmpty(h2)) {
            net.one97.paytm.passbook.mapping.f b3 = d.b();
            getActivity();
            String x2 = b3.x();
            this.f57524h.setText(String.format(getString(net.one97.paytm.passbook.R.string.gv_message), new Object[]{h2, x2}));
            if (!TextUtils.isEmpty(h2)) {
                this.f57524h.setText(String.format(getString(net.one97.paytm.passbook.R.string.gv_message), new Object[]{h2, x2}));
            } else {
                this.f57524h.setText(String.format(getString(net.one97.paytm.passbook.R.string.gv_message), new Object[]{b.l((Context) getActivity()), x2}));
            }
        }
        if (!TextUtils.isEmpty(this.w.getCreateTimestamp())) {
            this.f57519c.setText(String.format(getString(net.one97.paytm.passbook.R.string.gv_expiry), new Object[]{q.a("dd-MM-yyyy", "dd MMM yyyy", this.w.getCreateTimestamp())}));
        }
        if (!TextUtils.isEmpty(this.w.getTxnAmount())) {
            this.f57525i.setText(String.format(string2, new Object[]{new DecimalFormat(q.a(Double.parseDouble(this.w.getTxnAmount())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(this.w.getTxnAmount()))}));
        }
        this.r.setVisibility(0);
        LottieAnimationView lottieAnimationView = this.p;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation(net.one97.paytm.passbook.R.raw.pass_gift_voucher);
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    private void a() {
        this.r.setVisibility(8);
        LottieAnimationView lottieAnimationView = this.p;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        c();
        if (getActivity() != null && !getActivity().isFinishing()) {
            dismiss();
        }
    }

    private void a(e eVar, Context context, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(net.one97.paytm.passbook.R.string.no_connection));
        builder.setMessage(context.getResources().getString(net.one97.paytm.passbook.R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(net.one97.paytm.passbook.R.string.network_retry_yes), new DialogInterface.OnClickListener(context, eVar, onCancelListener) {
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ e f$2;
            private final /* synthetic */ DialogInterface.OnCancelListener f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                a.this.a(this.f$1, this.f$2, this.f$3, dialogInterface, i2);
            }
        });
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Context context, e eVar, DialogInterface.OnCancelListener onCancelListener, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        c();
        b();
        if (b.c(context)) {
            context.getApplicationContext();
            c.a();
            c.b(eVar);
            return;
        }
        a(eVar, context, onCancelListener);
    }

    private void b() {
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        net.one97.paytm.passbook.utility.a.a(this.v);
    }

    private void c() {
        this.t.setVisibility(0);
        this.u.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(this.v);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IJRDataModel iJRDataModel) {
        if (getActivity() != null && !getActivity().isFinishing() && (iJRDataModel instanceof GiftVoucherClaimResponse)) {
            GiftVoucherClaimResponse giftVoucherClaimResponse = (GiftVoucherClaimResponse) iJRDataModel;
            if (giftVoucherClaimResponse.getStatus().equalsIgnoreCase("SUCCESS")) {
                this.n.setVisibility(0);
                this.o.setVisibility(8);
                this.k.setVisibility(8);
                this.j.setVisibility(8);
                this.l.setVisibility(0);
                a();
                this.s.setVisibility(0);
                LottieAnimationView lottieAnimationView = this.q;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                    lottieAnimationView.setAnimation(net.one97.paytm.passbook.R.raw.pass_gift_voucher_received_celebration);
                    lottieAnimationView.playAnimation();
                }
                this.f57518b.a(this.w.getTxnId());
            } else if (giftVoucherClaimResponse.getStatus().equalsIgnoreCase("FAILURE")) {
                this.k.setVisibility(0);
                this.m.setVisibility(0);
                this.o.setVisibility(8);
                this.j.setVisibility(8);
                if (!TextUtils.isEmpty(giftVoucherClaimResponse.getStatusMessage())) {
                    this.z.setText(giftVoucherClaimResponse.getStatusMessage());
                }
                a();
            } else {
                String string = getString(net.one97.paytm.passbook.R.string.failed_to_load_transaction_detail);
                if (!v.a(giftVoucherClaimResponse.getStatusMessage())) {
                    string = giftVoucherClaimResponse.getStatusMessage();
                }
                Toast.makeText(getActivity(), string, 0).show();
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str) {
        if (aVar.getActivity() != null && !aVar.getActivity().isFinishing()) {
            q.a(aVar.getContext(), "gift_voucher", "gv_redeem_confirm_clicked", (String) null, (String) null, "/passbook/gift-voucher-redeem", "gift_voucher");
            aVar.b();
            String a2 = d.b().a("claimGiftCard");
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", com.paytm.utility.a.q(aVar.getActivity()));
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", str);
                jSONObject.put("metadata", "Testing");
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "SALES_TO_USER_CREDIT");
                jSONObject.put("request", jSONObject2);
            } catch (JSONException unused) {
            }
            net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(a2, new i.a() {
                public final void onResponse(Object obj) {
                    a.this.a((IJRDataModel) obj);
                }
            }, new g() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    a.a(a.this, (Throwable) networkCustomError);
                }
            }, new GiftVoucherClaimResponse(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, a.class.getName());
            if (b.c((Context) aVar.getActivity())) {
                aVar.b();
                aVar.getContext();
                c.a();
                c.b(bVar);
                return;
            }
            aVar.a(bVar, aVar.getActivity(), new DialogInterface.OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.a(dialogInterface);
                }
            });
        }
    }

    static /* synthetic */ void a(a aVar, Throwable th) {
        if (aVar.getActivity() != null && !aVar.getActivity().isFinishing()) {
            aVar.c();
            FragmentActivity activity = aVar.getActivity();
            GiftVoucherRedeemActivity.class.getName();
            j.a((Activity) activity, th);
        }
    }
}
