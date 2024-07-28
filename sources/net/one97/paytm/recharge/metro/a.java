package net.one97.paytm.recharge.metro;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class a implements FetchPayOptionsListener {

    /* renamed from: a  reason: collision with root package name */
    public CJRRechargeBaseActivity f63124a;

    /* renamed from: b  reason: collision with root package name */
    public CJRMetroPenaltyDetailsModel f63125b;

    /* renamed from: c  reason: collision with root package name */
    public CJRActiveMetroTicketQRItemModel f63126c;

    /* renamed from: d  reason: collision with root package name */
    public CJRRechargeCart f63127d;

    /* renamed from: e  reason: collision with root package name */
    public CJRRechargePayment f63128e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63129f;

    /* renamed from: g  reason: collision with root package name */
    private final String f63130g;

    public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
        k.c(cJPayMethodResponse, "cjPayMethodResponse");
    }

    public final void onVpaReceived(VpaFetch vpaFetch) {
        k.c(vpaFetch, "vpaFetch");
    }

    public a(CJRRechargeBaseActivity cJRRechargeBaseActivity, String str) {
        k.c(cJRRechargeBaseActivity, "baseActivity");
        k.c(str, "categoryVerticalName");
        this.f63130g = str;
        this.f63124a = cJRRechargeBaseActivity;
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f63147a = new c();

        c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: net.one97.paytm.recharge.metro.a$a  reason: collision with other inner class name */
    public static final class C1220a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final C1220a f63131a = new C1220a();

        C1220a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63141a;

        public b(a aVar) {
            this.f63141a = aVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            if (!this.f63141a.f63124a.isFinishing()) {
                a aVar = this.f63141a;
                aVar.f63129f = false;
                aVar.f63124a.o();
                CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this.f63141a.f63124a, (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            a aVar = this.f63141a;
            aVar.f63129f = false;
            aVar.f63124a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public final void a(CJRRechargePayment cJRRechargePayment) {
        net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
        String str = this.f63130g;
        CJRRechargeCart cJRRechargeCart = this.f63127d;
        net.one97.paytm.recharge.di.helper.a aVar2 = net.one97.paytm.recharge.di.helper.a.f62650a;
        Class<? extends Activity> e2 = net.one97.paytm.recharge.di.helper.a.e();
        d dVar = d.f64967a;
        net.one97.paytm.recharge.common.utils.a.a(this.f63124a, str, cJRRechargeCart, cJRRechargePayment, (Map<String, ? extends Object>) null, e2, d.a((ACTION_TYPE) null, (ERROR_TYPE) null), false);
    }

    public final void onRequestStart() {
        CJRRechargeBaseActivity cJRRechargeBaseActivity = this.f63124a;
        cJRRechargeBaseActivity.a((Context) cJRRechargeBaseActivity, cJRRechargeBaseActivity.getString(R.string.please_wait_progress_msg_re));
    }

    public final void onPaymentOptionsError() {
        String str;
        CJRRechargePayment cJRRechargePayment = this.f63128e;
        if (cJRRechargePayment == null) {
            k.a();
        }
        a(cJRRechargePayment);
        this.f63124a.o();
        d dVar = d.f64967a;
        CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName == null) {
            flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
        }
        a2.setFlowName(flowName);
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setErrorType(ERROR_TYPE.UI_DESCRIPTION.name());
        }
        CRUFlowModel flowName3 = a2.getFlowName();
        if (flowName3 != null) {
            flowName3.setActionType(ACTION_TYPE.CLP_PROCEED.name());
        }
        CRUFlowModel flowName4 = a2.getFlowName();
        if (flowName4 != null) {
            flowName4.setTag("fetchPaymentOptions");
        }
        CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel = this.f63126c;
        if (cJRActiveMetroTicketQRItemModel == null || (str = String.valueOf(cJRActiveMetroTicketQRItemModel.getProductId())) == null) {
            str = "";
        }
        a2.setProductId(str);
        a2.setErrorMsg(this.f63124a.getString(R.string.error_message, new Object[]{"onPaymentOptionsError", a.class.getSimpleName()}));
        az azVar = az.f61525a;
        az.a(a2);
    }

    public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
        PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
        CJRRechargePayment cJRRechargePayment = this.f63128e;
        if (cJRRechargePayment == null) {
            k.a();
        }
        a(cJRRechargePayment);
        this.f63124a.o();
    }
}
