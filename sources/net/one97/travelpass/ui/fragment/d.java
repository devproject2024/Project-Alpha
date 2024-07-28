package net.one97.travelpass.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.travelpass.R;
import net.one97.travelpass.e.b;
import net.one97.travelpass.model.PassData;
import net.one97.travelpass.model.TPPromoVerifyData;
import net.one97.travelpass.model.TravelPassCheckoutModel;
import net.one97.travelpass.model.TravelPassMetaData;
import net.one97.travelpass.ui.TPOffersListActivity;
import org.json.JSONObject;

public final class d extends f implements com.paytm.network.listener.b {
    private final String A = "mid";
    private final String B = "nativeSdkEnabled";
    private ProgressDialog C;
    private HashMap D;

    /* renamed from: a  reason: collision with root package name */
    TravelPassMetaData.TncData f30697a;

    /* renamed from: b  reason: collision with root package name */
    private String f30698b = "PurchaseBottomSheetFragment";

    /* renamed from: c  reason: collision with root package name */
    private PassData f30699c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30700d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f30701e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f30702f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f30703g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f30704h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f30705i;
    private TextView j;
    private String k;
    private RelativeLayout l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private RelativeLayout p;
    private RelativeLayout q;
    private ImageView r;
    private ImageView s;
    private RelativeLayout t;
    private TextView u;
    private TextView v;
    private int w = 1;
    private double x;
    private final String y = "txnToken";
    private final String z = "orderid";

    public final void a() {
        HashMap hashMap = this.D;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final void onActivityCreated(Bundle bundle) {
        Window window;
        WindowManager.LayoutParams attributes;
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.windowAnimations = R.style.TPBottomSheet;
        }
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CharSequence charSequence;
        CharSequence charSequence2;
        List<String> applicableOn;
        Boolean operatorPass;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.purchase_bottom_sheet, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        Serializable serializable = arguments.getSerializable("pass-data");
        String str = null;
        if (!(serializable instanceof PassData)) {
            serializable = null;
        }
        this.f30699c = (PassData) serializable;
        Serializable serializable2 = arguments.getSerializable("pass_tnc");
        if (!(serializable2 instanceof TravelPassMetaData.TncData)) {
            serializable2 = null;
        }
        this.f30697a = (TravelPassMetaData.TncData) serializable2;
        PassData passData = this.f30699c;
        if (passData != null) {
            if (passData == null) {
                k.a();
            }
            this.x = passData.getPrice();
        }
        k.a((Object) inflate, "view");
        this.f30700d = (TextView) inflate.findViewById(R.id.pricePerItem);
        this.f30701e = (TextView) inflate.findViewById(R.id.quantity);
        this.f30702f = (TextView) inflate.findViewById(R.id.total_price);
        this.f30705i = (TextView) inflate.findViewById(R.id.proceedToPay);
        this.j = (TextView) inflate.findViewById(R.id.promo);
        this.f30703g = (TextView) inflate.findViewById(R.id.start_date_value);
        this.f30704h = (TextView) inflate.findViewById(R.id.end_date_value);
        this.l = (RelativeLayout) inflate.findViewById(R.id.promo_container);
        this.m = (TextView) inflate.findViewById(R.id.promocode_value);
        this.n = (TextView) inflate.findViewById(R.id.promo_description);
        this.o = (ImageView) inflate.findViewById(R.id.promo_cancel_btn);
        this.r = (ImageView) inflate.findViewById(R.id.plus_icon);
        this.s = (ImageView) inflate.findViewById(R.id.minus_icon);
        this.p = (RelativeLayout) inflate.findViewById(R.id.plus_view);
        this.q = (RelativeLayout) inflate.findViewById(R.id.minus_view);
        this.t = (RelativeLayout) inflate.findViewById(R.id.operator_content);
        this.u = (TextView) inflate.findViewById(R.id.operator_values);
        this.v = (TextView) inflate.findViewById(R.id.tnc_text);
        ResourceUtils.loadTPassImagesFromCDN$default(this.o, "close_1.png", false, true, (n.a) null, 16, (Object) null);
        PassData passData2 = this.f30699c;
        Boolean valueOf = passData2 != null ? Boolean.valueOf(passData2.isPromoApplicable()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (!valueOf.booleanValue()) {
            TextView textView = this.j;
            if (textView != null) {
                textView.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.l;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        }
        PassData passData3 = this.f30699c;
        if ((passData3 == null || (operatorPass = passData3.getOperatorPass()) == null) ? false : operatorPass.booleanValue()) {
            RelativeLayout relativeLayout2 = this.t;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            TextView textView2 = this.v;
            if (textView2 != null) {
                textView2.setOnClickListener(new b(this));
            }
            TextView textView3 = this.u;
            if (textView3 != null) {
                PassData passData4 = this.f30699c;
                textView3.setText((passData4 == null || (applicableOn = passData4.getApplicableOn()) == null) ? null : kotlin.a.k.a((Iterable) applicableOn, (CharSequence) AppConstants.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62));
            }
        }
        ImageView imageView = this.r;
        if (imageView == null) {
            k.a();
        }
        imageView.setOnClickListener(new c(this));
        ImageView imageView2 = this.s;
        if (imageView2 == null) {
            k.a();
        }
        imageView2.setOnClickListener(new C0523d(this));
        RelativeLayout relativeLayout3 = this.p;
        if (relativeLayout3 == null) {
            k.a();
        }
        relativeLayout3.setOnClickListener(new e(this));
        RelativeLayout relativeLayout4 = this.q;
        if (relativeLayout4 == null) {
            k.a();
        }
        relativeLayout4.setOnClickListener(new f(this));
        TextView textView4 = this.f30705i;
        if (textView4 == null) {
            k.a();
        }
        textView4.setOnClickListener(new g(this));
        TextView textView5 = this.j;
        if (textView5 != null) {
            textView5.setOnClickListener(new h(this));
        }
        ImageView imageView3 = this.o;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new i(this));
        }
        new net.one97.travelpass.e.k();
        PassData passData5 = this.f30699c;
        if (passData5 == null) {
            k.a();
        }
        String a2 = net.one97.travelpass.e.k.a(passData5.getPrice());
        TextView textView6 = this.f30700d;
        if (textView6 == null) {
            k.a();
        }
        textView6.setText(getString(R.string.text_with_rupee, a2));
        TextView textView7 = this.f30702f;
        if (textView7 == null) {
            k.a();
        }
        textView7.setText(getString(R.string.text_with_rupee, a2));
        TextView textView8 = this.f30703g;
        if (textView8 == null) {
            k.a();
        }
        PassData passData6 = this.f30699c;
        if ((passData6 != null ? passData6.getStartDate() : null) != null) {
            PassData passData7 = this.f30699c;
            charSequence = passData7 != null ? passData7.getStartDate() : null;
        } else {
            charSequence = "";
        }
        textView8.setText(charSequence);
        TextView textView9 = this.f30704h;
        if (textView9 == null) {
            k.a();
        }
        PassData passData8 = this.f30699c;
        if ((passData8 != null ? passData8.getEndDate() : null) != null) {
            PassData passData9 = this.f30699c;
            if (passData9 != null) {
                str = passData9.getEndDate();
            }
            charSequence2 = str;
        } else {
            charSequence2 = "";
        }
        textView9.setText(charSequence2);
        TextView textView10 = this.f30701e;
        if (textView10 == null) {
            k.a();
        }
        textView10.setText(String.valueOf(this.w));
        String string = getString(R.string.proceed_to_text_with_string, a2);
        k.a((Object) string, "getString(R.string.proce…h_string, formattedPrice)");
        TextView textView11 = this.f30705i;
        if (textView11 == null) {
            k.a();
        }
        textView11.setText(string);
        return inflate;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c();
        super.a(Integer.valueOf(i2), iJRPaytmDataModel, networkCustomError);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        TravelPassCheckoutModel.CartBody body;
        TravelPassCheckoutModel.CartResponse resp;
        TravelPassCheckoutModel.CartBody body2;
        String status;
        TravelPassCheckoutModel.CartBody body3;
        c();
        boolean z2 = iJRPaytmDataModel instanceof TravelPassCheckoutModel;
        if (z2) {
            String str = null;
            TravelPassCheckoutModel travelPassCheckoutModel = (TravelPassCheckoutModel) (!z2 ? null : iJRPaytmDataModel);
            if (((travelPassCheckoutModel == null || (body3 = travelPassCheckoutModel.getBody()) == null) ? null : body3.getStatus()) != null) {
                Boolean valueOf = (travelPassCheckoutModel == null || (body2 = travelPassCheckoutModel.getBody()) == null || (status = body2.getStatus()) == null) ? null : Boolean.valueOf(p.a(status, "SUCCESS", true));
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.booleanValue()) {
                    if (!(travelPassCheckoutModel == null || (body = travelPassCheckoutModel.getBody()) == null || (resp = body.getResp()) == null)) {
                        str = resp.getNativeWithdraw();
                    }
                    if (p.a(str, "1", false)) {
                        CJRRechargePayment a2 = a(travelPassCheckoutModel);
                        k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
                        net.one97.travelpass.d.b().a(getContext(), a2, (FetchPayOptionsListener) new a(this, a2));
                        return;
                    }
                    a(a(travelPassCheckoutModel));
                    return;
                }
            }
            a(-1, iJRPaytmDataModel, (NetworkCustomError) null);
        } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
            k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
            String a3 = net.one97.travelpass.d.b().a((CJRPGTokenList) iJRPaytmDataModel);
            if (a3 != null) {
                a(a3);
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30708a;

        b(d dVar) {
            this.f30708a = dVar;
        }

        public final void onClick(View view) {
            d dVar = this.f30708a;
            TravelPassMetaData.TncData tncData = dVar.f30697a;
            ArrayList<String> arrayList = null;
            Collection tncContent = tncData != null ? tncData.getTncContent() : null;
            if (!(tncContent == null || tncContent.isEmpty())) {
                c cVar = new c();
                Bundle bundle = new Bundle();
                TravelPassMetaData.TncData tncData2 = dVar.f30697a;
                if (tncData2 != null) {
                    arrayList = tncData2.getTncContent();
                }
                bundle.putSerializable("dataList", arrayList);
                cVar.setArguments(bundle);
                if (dVar.getActivity() != null) {
                    FragmentActivity activity = dVar.getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    k.a((Object) activity, "activity!!");
                    cVar.show(activity.getSupportFragmentManager(), cVar.getTag());
                }
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30709a;

        c(d dVar) {
            this.f30709a = dVar;
        }

        public final void onClick(View view) {
            d.a(this.f30709a);
        }
    }

    /* renamed from: net.one97.travelpass.ui.fragment.d$d  reason: collision with other inner class name */
    static final class C0523d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30710a;

        C0523d(d dVar) {
            this.f30710a = dVar;
        }

        public final void onClick(View view) {
            d.b(this.f30710a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30711a;

        e(d dVar) {
            this.f30711a = dVar;
        }

        public final void onClick(View view) {
            d.a(this.f30711a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30712a;

        f(d dVar) {
            this.f30712a = dVar;
        }

        public final void onClick(View view) {
            d.b(this.f30712a);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30713a;

        g(d dVar) {
            this.f30713a = dVar;
        }

        public final void onClick(View view) {
            if (this.f30713a.getContext() != null) {
                b.a aVar = net.one97.travelpass.e.b.f30322a;
                Context context = this.f30713a.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                k.c(context, "context");
                b.a.a(context, net.one97.travelpass.e.b.l, net.one97.travelpass.e.b.A, (String) null, (String) null, (String) null, (String) null, net.one97.travelpass.e.b.f30328g, (String) null, 376);
            }
            d dVar = this.f30713a;
            new net.one97.travelpass.e.k();
            if (net.one97.travelpass.e.k.a(dVar.getContext())) {
                k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
                String a2 = net.one97.travelpass.d.b().a(dVar.getContext());
                if (!TextUtils.isEmpty(a2)) {
                    k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
                    if (net.one97.travelpass.d.b().b(dVar.getContext())) {
                        if (a2 == null) {
                            k.a();
                        }
                        dVar.a(a2);
                        return;
                    }
                }
                k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
                net.one97.travelpass.d.b().a((Activity) dVar.getActivity(), (com.paytm.network.listener.b) dVar);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("VERTICAL_NAME", "BusTicket");
            k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
            net.one97.travelpass.d.b().a(dVar.getContext(), intent, 4);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30714a;

        h(d dVar) {
            this.f30714a = dVar;
        }

        public final void onClick(View view) {
            d.c(this.f30714a);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30715a;

        i(d dVar) {
            this.f30715a = dVar;
        }

        public final void onClick(View view) {
            this.f30715a.b();
        }
    }

    private final void a(boolean z2) {
        if (z2) {
            RelativeLayout relativeLayout = this.p;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundResource(R.drawable.tp_rounded_enabled);
            }
            ImageView imageView = this.r;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.add_enabled);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.p;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(R.drawable.tp_rounded_disabled);
        }
        ImageView imageView2 = this.r;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.add_disabled);
        }
    }

    private final void b(boolean z2) {
        if (z2) {
            RelativeLayout relativeLayout = this.q;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundResource(R.drawable.tp_rounded_enabled);
            }
            ImageView imageView = this.s;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.remove_enabled);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.q;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(R.drawable.tp_rounded_disabled);
        }
        ImageView imageView2 = this.s;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.remove_disabled);
        }
    }

    private static CJRRechargePayment a(TravelPassCheckoutModel travelPassCheckoutModel) {
        TravelPassCheckoutModel.CartBody body;
        TravelPassCheckoutModel.CartResponse resp;
        TravelPassCheckoutModel.CartNativeWithdrawDetails nativeWithdrawDetails;
        TravelPassCheckoutModel.CartBody body2;
        TravelPassCheckoutModel.CartResponse resp2;
        TravelPassCheckoutModel.CartBody body3;
        TravelPassCheckoutModel.CartBody body4;
        TravelPassCheckoutModel.CartBody body5;
        TravelPassCheckoutModel.CartResponse resp3;
        TravelPassCheckoutModel.CartBody body6;
        TravelPassCheckoutModel.CartResponse resp4;
        TravelPassCheckoutModel.CartBody body7;
        TravelPassCheckoutModel.CartResponse resp5;
        CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
        String str = null;
        Integer valueOf = travelPassCheckoutModel != null ? Integer.valueOf(travelPassCheckoutModel.getCode()) : null;
        if (valueOf == null) {
            k.a();
        }
        cJRRechargePayment.setmCode(valueOf.intValue());
        cJRRechargePayment.setmError(travelPassCheckoutModel.getErrorMessage());
        cJRRechargePayment.setmMID((travelPassCheckoutModel == null || (body7 = travelPassCheckoutModel.getBody()) == null || (resp5 = body7.getResp()) == null) ? null : resp5.getMID());
        cJRRechargePayment.setmOrderId(String.valueOf((travelPassCheckoutModel == null || (body6 = travelPassCheckoutModel.getBody()) == null || (resp4 = body6.getResp()) == null) ? null : Long.valueOf(resp4.getCartOrderId())));
        cJRRechargePayment.setmPGParams(travelPassCheckoutModel.getPGParams());
        cJRRechargePayment.setmPGUrlToHit((travelPassCheckoutModel == null || (body5 = travelPassCheckoutModel.getBody()) == null || (resp3 = body5.getResp()) == null) ? null : resp3.getPgUrlToHit());
        cJRRechargePayment.setmResult((travelPassCheckoutModel == null || (body4 = travelPassCheckoutModel.getBody()) == null) ? null : body4.getStatus());
        cJRRechargePayment.setmStatus((travelPassCheckoutModel == null || (body3 = travelPassCheckoutModel.getBody()) == null) ? null : body3.getStatus());
        cJRRechargePayment.setmNativeEnabled((travelPassCheckoutModel == null || (body2 = travelPassCheckoutModel.getBody()) == null || (resp2 = body2.getResp()) == null) ? null : resp2.getNativeWithdraw());
        if (!(travelPassCheckoutModel == null || (body = travelPassCheckoutModel.getBody()) == null || (resp = body.getResp()) == null || (nativeWithdrawDetails = resp.getNativeWithdrawDetails()) == null)) {
            str = nativeWithdrawDetails.getTxnToken();
        }
        cJRRechargePayment.setmTxnToken(str);
        return cJRRechargePayment;
    }

    /* access modifiers changed from: private */
    public final void a(CJRRechargePayment cJRRechargePayment) {
        Intent intent = new Intent();
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra("intent_extra_is_from_travel_pass", true);
        intent.putExtra("vertical_name", a.c.TRAVEL_PASS);
        String c2 = c(cJRRechargePayment);
        if (!TextUtils.isEmpty(c2)) {
            intent.putExtra("price", c2);
            if (b(cJRRechargePayment)) {
                intent.putExtra(this.y, cJRRechargePayment.getmTxnToken());
                intent.putExtra(this.A, cJRRechargePayment.getMID());
                intent.putExtra(this.z, cJRRechargePayment.getOrderId());
                intent.putExtra(this.B, true);
            } else {
                intent.putExtra(this.B, false);
            }
        }
        dismiss();
        k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
        net.one97.travelpass.d.b().a((Context) getActivity(), intent);
    }

    private static boolean b(CJRRechargePayment cJRRechargePayment) {
        k.c(cJRRechargePayment, "rechargePayment");
        return p.a("1", cJRRechargePayment.isNativeEnabled(), true);
    }

    public static final class a implements FetchPayOptionsListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30706a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRRechargePayment f30707b;

        public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
            k.c(cJPayMethodResponse, "cjPayMethodResponse");
        }

        public final void onVpaReceived(VpaFetch vpaFetch) {
            k.c(vpaFetch, "vpaFetch");
        }

        a(d dVar, CJRRechargePayment cJRRechargePayment) {
            this.f30706a = dVar;
            this.f30707b = cJRRechargePayment;
        }

        public final void onRequestStart() {
            d dVar = this.f30706a;
            Context context = dVar.getContext();
            String string = this.f30706a.getResources().getString(R.string.please_wait_progress_msg);
            k.a((Object) string, "resources.getString(R.st…please_wait_progress_msg)");
            dVar.a(context, string);
        }

        public final void onPaymentOptionsError() {
            this.f30706a.c();
            this.f30706a.a(this.f30707b);
        }

        public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
            PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
            this.f30706a.c();
            this.f30706a.a(this.f30707b);
        }
    }

    private static String c(CJRRechargePayment cJRRechargePayment) {
        k.c(cJRRechargePayment, "payment");
        if (cJRRechargePayment.getmPGParams() == null || !cJRRechargePayment.getmPGParams().containsKey("TXN_AMOUNT")) {
            return null;
        }
        return String.valueOf(cJRRechargePayment.getmPGParams().get("TXN_AMOUNT"));
    }

    public final void b() {
        PassData passData = this.f30699c;
        Boolean valueOf = passData != null ? Boolean.valueOf(passData.isPromoApplicable()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            TextView textView = this.j;
            if (textView != null) {
                textView.setVisibility(0);
            }
            RelativeLayout relativeLayout = this.l;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            this.k = null;
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 200 && intent != null && intent.hasExtra("promo_data")) {
            Serializable serializableExtra = intent.getSerializableExtra("promo_data");
            String str = null;
            if (!(serializableExtra instanceof TPPromoVerifyData)) {
                serializableExtra = null;
            }
            TPPromoVerifyData tPPromoVerifyData = (TPPromoVerifyData) serializableExtra;
            if (tPPromoVerifyData != null) {
                TPPromoVerifyData.PromoVerifyBody body = tPPromoVerifyData.getBody();
                CharSequence promoCode = body != null ? body.getPromoCode() : null;
                boolean z2 = true;
                if (!(promoCode == null || promoCode.length() == 0) && tPPromoVerifyData != null) {
                    TPPromoVerifyData.PromoVerifyBody body2 = tPPromoVerifyData.getBody();
                    CharSequence promoCode2 = body2 != null ? body2.getPromoCode() : null;
                    if (!(promoCode2 == null || promoCode2.length() == 0)) {
                        z2 = false;
                    }
                    if (!z2) {
                        TextView textView = this.j;
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                        RelativeLayout relativeLayout = this.l;
                        if (relativeLayout != null) {
                            relativeLayout.setVisibility(0);
                        }
                        TextView textView2 = this.m;
                        if (textView2 != null) {
                            TPPromoVerifyData.PromoVerifyBody body3 = tPPromoVerifyData.getBody();
                            textView2.setText(body3 != null ? body3.getPromoCode() : null);
                        }
                        TextView textView3 = this.n;
                        if (textView3 != null) {
                            TPPromoVerifyData.PromoVerifyBody body4 = tPPromoVerifyData.getBody();
                            textView3.setText(body4 != null ? body4.getPromoStatusText() : null);
                        }
                        TPPromoVerifyData.PromoVerifyBody body5 = tPPromoVerifyData.getBody();
                        if (body5 != null) {
                            str = body5.getPromoCode();
                        }
                        this.k = str;
                    }
                }
            }
        }
    }

    public final void a(String str) {
        k.c(str, "walletToken");
        k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
        String a2 = net.one97.travelpass.d.b().a("tpassCheckout");
        String a3 = com.paytm.utility.d.a(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a3);
        hashMap.put("wallet_token", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("native_withdraw", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a3);
        CharSequence charSequence = this.k;
        if (!(charSequence == null || charSequence.length() == 0)) {
            jSONObject.put(PayUtility.PROMO_CODE, this.k);
        }
        PassData passData = this.f30699c;
        String str2 = null;
        jSONObject.put("campaignId", passData != null ? passData.getCampaignId() : null);
        jSONObject.put("quantity", this.w);
        PassData passData2 = this.f30699c;
        jSONObject.put("price", passData2 != null ? Double.valueOf(passData2.getPrice()) : null);
        PassData passData3 = this.f30699c;
        jSONObject.put("pass_id", passData3 != null ? passData3.getTravelPassId() : null);
        PassData passData4 = this.f30699c;
        if (passData4 != null) {
            str2 = passData4.getCategory();
        }
        jSONObject.put("subCategory", str2);
        StringBuilder sb = new StringBuilder("Wallet Token ---- ");
        k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
        sb.append(net.one97.travelpass.d.b().a((Context) getActivity()));
        a(getContext(), "Please wait");
        new com.paytm.network.b().a(a.C0715a.POST).a((Context) getActivity()).a(a2).a((Map<String, String>) hashMap).b((Map) hashMap2).b(jSONObject.toString()).a(a.c.TRAVEL_PASS).a(a.b.SILENT).c("PurchaseBottomSheet").a((IJRPaytmDataModel) new TravelPassCheckoutModel()).a((com.paytm.network.listener.b) this).l().a();
    }

    public final void a(Context context, String str) {
        k.c(str, "message");
        if (context != null) {
            ProgressDialog progressDialog = this.C;
            if (progressDialog != null) {
                Boolean valueOf = progressDialog != null ? Boolean.valueOf(progressDialog.isShowing()) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.booleanValue()) {
                    return;
                }
            }
            this.C = new ProgressDialog(context);
            try {
                ProgressDialog progressDialog2 = this.C;
                if (progressDialog2 != null) {
                    progressDialog2.setProgressStyle(0);
                }
                ProgressDialog progressDialog3 = this.C;
                if (progressDialog3 != null) {
                    progressDialog3.setMessage(str);
                }
                ProgressDialog progressDialog4 = this.C;
                if (progressDialog4 != null) {
                    progressDialog4.setCancelable(false);
                }
                ProgressDialog progressDialog5 = this.C;
                if (progressDialog5 != null) {
                    progressDialog5.setCanceledOnTouchOutside(false);
                }
                ProgressDialog progressDialog6 = this.C;
                if (progressDialog6 != null) {
                    progressDialog6.show();
                }
            } catch (IllegalArgumentException e2) {
                q.c(e2.getMessage());
            } catch (Exception unused) {
            }
        }
    }

    public final void c() {
        ProgressDialog progressDialog = this.C;
        if (progressDialog != null) {
            Boolean valueOf = progressDialog != null ? Boolean.valueOf(progressDialog.isShowing()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.booleanValue()) {
                ProgressDialog progressDialog2 = this.C;
                if (progressDialog2 != null) {
                    progressDialog2.dismiss();
                }
                this.C = null;
            }
        }
    }

    public static final /* synthetic */ void a(d dVar) {
        PassData passData = dVar.f30699c;
        Integer num = null;
        if (passData != null) {
            int i2 = dVar.w;
            Integer valueOf = passData != null ? Integer.valueOf(passData.getMaxPurchaseCount()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (i2 < valueOf.intValue()) {
                dVar.w++;
                TextView textView = dVar.f30701e;
                if (textView == null) {
                    k.a();
                }
                textView.setText(String.valueOf(dVar.w));
                double d2 = (double) dVar.w;
                PassData passData2 = dVar.f30699c;
                if (passData2 == null) {
                    k.a();
                }
                dVar.x = d2 * passData2.getPrice();
                new net.one97.travelpass.e.k();
                String a2 = net.one97.travelpass.e.k.a(dVar.x);
                TextView textView2 = dVar.f30705i;
                if (textView2 == null) {
                    k.a();
                }
                textView2.setText(dVar.getString(R.string.proceed_to_text_with_string, a2));
                TextView textView3 = dVar.f30702f;
                if (textView3 == null) {
                    k.a();
                }
                textView3.setText(dVar.getString(R.string.text_with_rupee, a2));
                int i3 = dVar.w;
                if (i3 > 0) {
                    PassData passData3 = dVar.f30699c;
                    Integer valueOf2 = passData3 != null ? Integer.valueOf(passData3.getMaxPurchaseCount()) : null;
                    if (valueOf2 == null) {
                        k.a();
                    }
                    if (i3 < valueOf2.intValue()) {
                        dVar.a(true);
                        dVar.b(true);
                        dVar.b();
                        return;
                    }
                }
                int i4 = dVar.w;
                if (i4 == 1) {
                    dVar.b(false);
                    int i5 = dVar.w;
                    PassData passData4 = dVar.f30699c;
                    if (passData4 != null) {
                        num = Integer.valueOf(passData4.getMaxPurchaseCount());
                    }
                    if (num == null) {
                        k.a();
                    }
                    if (i5 == num.intValue()) {
                        dVar.a(false);
                    } else {
                        dVar.a(true);
                    }
                } else {
                    PassData passData5 = dVar.f30699c;
                    if (passData5 != null) {
                        num = Integer.valueOf(passData5.getMaxPurchaseCount());
                    }
                    if (num == null) {
                        k.a();
                    }
                    if (i4 >= num.intValue()) {
                        dVar.a(false);
                        dVar.b(true);
                    }
                }
                dVar.b();
                return;
            }
        }
        Context context = dVar.getContext();
        int i6 = R.string.max_pass_error_hint;
        Object[] objArr = new Object[1];
        PassData passData6 = dVar.f30699c;
        if (passData6 != null) {
            num = Integer.valueOf(passData6.getMaxPurchaseCount());
        }
        if (num == null) {
            k.a();
        }
        objArr[0] = num;
        Toast.makeText(context, dVar.getString(i6, objArr), 0).show();
    }

    public static final /* synthetic */ void b(d dVar) {
        int i2 = dVar.w;
        if (i2 > 1) {
            dVar.w = i2 - 1;
            TextView textView = dVar.f30701e;
            if (textView == null) {
                k.a();
            }
            textView.setText(String.valueOf(dVar.w));
            double d2 = (double) dVar.w;
            PassData passData = dVar.f30699c;
            if (passData == null) {
                k.a();
            }
            dVar.x = d2 * passData.getPrice();
            new net.one97.travelpass.e.k();
            String a2 = net.one97.travelpass.e.k.a(dVar.x);
            TextView textView2 = dVar.f30705i;
            if (textView2 == null) {
                k.a();
            }
            textView2.setText(dVar.getString(R.string.proceed_to_text_with_string, a2));
            TextView textView3 = dVar.f30702f;
            if (textView3 == null) {
                k.a();
            }
            textView3.setText(dVar.getString(R.string.text_with_rupee, a2));
            int i3 = dVar.w;
            Integer num = null;
            if (i3 > 1) {
                PassData passData2 = dVar.f30699c;
                Integer valueOf = passData2 != null ? Integer.valueOf(passData2.getMaxPurchaseCount()) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (i3 < valueOf.intValue()) {
                    dVar.a(true);
                    dVar.b(true);
                    dVar.b();
                }
            }
            int i4 = dVar.w;
            if (i4 == 1) {
                dVar.b(false);
                int i5 = dVar.w;
                PassData passData3 = dVar.f30699c;
                if (passData3 != null) {
                    num = Integer.valueOf(passData3.getMaxPurchaseCount());
                }
                if (num == null) {
                    k.a();
                }
                if (i5 == num.intValue()) {
                    dVar.a(false);
                } else {
                    dVar.a(true);
                }
            } else {
                PassData passData4 = dVar.f30699c;
                if (passData4 != null) {
                    num = Integer.valueOf(passData4.getMaxPurchaseCount());
                }
                if (num == null) {
                    k.a();
                }
                if (i4 >= num.intValue()) {
                    dVar.a(false);
                    dVar.b(true);
                }
            }
            dVar.b();
        }
    }

    public static final /* synthetic */ void c(d dVar) {
        if (dVar.f30699c != null) {
            Intent intent = new Intent(dVar.getActivity(), TPOffersListActivity.class);
            PassData passData = dVar.f30699c;
            String str = null;
            intent.putExtra("pass_id", passData != null ? passData.getTravelPassId() : null);
            PassData passData2 = dVar.f30699c;
            intent.putExtra("categoryId", passData2 != null ? Integer.valueOf(passData2.getCategoryId()) : null);
            intent.putExtra("quantity", dVar.w);
            PassData passData3 = dVar.f30699c;
            intent.putExtra("price", passData3 != null ? Double.valueOf(passData3.getPrice()) : null);
            PassData passData4 = dVar.f30699c;
            if (passData4 != null) {
                str = passData4.getCategory();
            }
            intent.putExtra("subCategory", str);
            dVar.startActivityForResult(intent, 200);
        }
    }
}
