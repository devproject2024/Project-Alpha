package net.one97.paytm.h5.a;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.cashback.posttxn.c;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.paytm_finance.R;

public final class o extends ad {

    /* renamed from: a  reason: collision with root package name */
    private final String f16906a = "orderId";

    /* renamed from: d  reason: collision with root package name */
    private final String f16907d = "pgTransactionId";

    /* renamed from: e  reason: collision with root package name */
    private final String f16908e = "upiTransactionId";

    /* renamed from: f  reason: collision with root package name */
    private final String f16909f = "walletTransactionId";

    /* renamed from: g  reason: collision with root package name */
    private final String f16910g = "verticalId";

    /* renamed from: h  reason: collision with root package name */
    private final String f16911h = "transactionType";

    /* renamed from: i  reason: collision with root package name */
    private final String f16912i = "categoryId";
    private final String j = "merchantCategory";
    private final String k = "eventType";
    private final String l = "eventId";
    private final String m = "eventValue";
    private final String n = "storeFrontUrl";
    private final String o = "POSTTRANSACTION";
    /* access modifiers changed from: private */
    public IStaticWidget p;
    private final b q = new b(this);

    public o() {
        super("paytmOpenScratchCard");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        boolean z;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!(!a(h5Event) || h5Event == null || (activity = h5Event.getActivity()) == null)) {
            e param = h5Event.getParam();
            String string = param.getString(this.n);
            CharSequence charSequence = string;
            boolean z2 = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                SFInterface.INSTANCE.getStoreFrontReponse(string, new HashMap(), a.c.CASHBACK, new a(this, activity));
                return true;
            }
            CharSequence string2 = param.getString(this.k);
            if (!(string2 == null || string2.length() == 0) && (activity instanceof FragmentActivity)) {
                FragmentActivity fragmentActivity = (FragmentActivity) activity;
                k.a((Object) param, "params");
                net.one97.paytm.cashback.posttxn.e a2 = c.a();
                e jSONObject = param.getJSONObject("data");
                String string3 = param.getString(this.k);
                if (string3 != null && string3.equals(this.o) && jSONObject != null) {
                    f.a aVar = new f.a();
                    CharSequence string4 = jSONObject.getString(this.f16906a);
                    if (!(string4 == null || string4.length() == 0)) {
                        aVar.f49546b = jSONObject.getString(this.f16906a);
                        z = true;
                    } else {
                        z = false;
                    }
                    CharSequence string5 = jSONObject.getString(this.f16907d);
                    if (!(string5 == null || string5.length() == 0)) {
                        aVar.f49545a = jSONObject.getString(this.f16907d);
                        z = true;
                    }
                    CharSequence string6 = jSONObject.getString(this.f16908e);
                    if (!(string6 == null || string6.length() == 0)) {
                        aVar.f49547c = jSONObject.getString(this.f16908e);
                        z = true;
                    }
                    CharSequence string7 = jSONObject.getString(this.f16909f);
                    if (!(string7 == null || string7.length() == 0)) {
                        aVar.f49548d = jSONObject.getString(this.f16909f);
                        z = true;
                    }
                    CharSequence string8 = jSONObject.getString(this.f16910g);
                    if (!(string8 == null || string8.length() == 0)) {
                        aVar.f49550f = jSONObject.getString(this.f16910g);
                    }
                    CharSequence string9 = jSONObject.getString(this.f16912i);
                    if (!(string9 == null || string9.length() == 0)) {
                        aVar.f49551g = jSONObject.getString(this.f16912i);
                    }
                    CharSequence string10 = jSONObject.getString(this.j);
                    if (!(string10 == null || string10.length() == 0)) {
                        aVar.f49552h = jSONObject.getString(this.j);
                    }
                    CharSequence string11 = jSONObject.getString(this.f16911h);
                    if (string11 == null || string11.length() == 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        aVar.f49549e = jSONObject.getString(this.f16911h);
                    }
                    if (z) {
                        a2.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) this.q);
                    }
                } else if (jSONObject != null) {
                    a2.a(fragmentActivity, this.q, jSONObject.toString());
                }
            }
        }
        return true;
    }

    public static final class b implements net.one97.paytm.cashback.posttxn.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f16915a;

        public final void onAnimationEnd(String str) {
            k.c(str, "identifier");
        }

        b(o oVar) {
            this.f16915a = oVar;
        }

        public final void a(String str, boolean z) {
            IStaticWidget a2;
            if (!(!z || str == null || (a2 = this.f16915a.p) == null)) {
                a2.AnimateView(str);
            }
            this.f16915a.a("success", (Object) Boolean.valueOf(z));
            this.f16915a.a((Object) null);
        }

        public final Point getFloatingWidgetPos(String str) {
            k.c(str, "identifier");
            IStaticWidget a2 = this.f16915a.p;
            if (a2 != null) {
                return a2.getViewPoint(str);
            }
            return null;
        }
    }

    public static final class a implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f16913a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f16914b;

        public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
        }

        a(o oVar, Activity activity) {
            this.f16913a = oVar;
            this.f16914b = activity;
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                o.a(this.f16913a, sanitizedResponseModel.getSfWidgets(), this.f16914b);
            }
        }
    }

    public static final /* synthetic */ void a(o oVar, LinkedHashMap linkedHashMap, Activity activity) {
        Window window;
        View decorView;
        if (activity instanceof FragmentActivity) {
            IWidgetProvider iWidgetProvider = (IWidgetProvider) linkedHashMap.get(104);
            Resources resources = null;
            SFWidget widget = iWidgetProvider != null ? iWidgetProvider.getWidget((FragmentActivity) activity, (IGAHandlerListener) null) : null;
            if (widget instanceof IStaticWidget) {
                IStaticWidget iStaticWidget = (IStaticWidget) widget;
                oVar.p = iStaticWidget;
                View view = iStaticWidget.getView();
                k.a((Object) view, "widget.view");
                ViewGroup viewGroup = (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : (ViewGroup) decorView.findViewById(16908290);
                if (viewGroup != null) {
                    if (activity != null) {
                        resources = activity.getResources();
                    }
                    int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.dimen_30dp);
                    if (viewGroup instanceof ConstraintLayout) {
                        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                        layoutParams.k = 0;
                        layoutParams.f2490h = 0;
                        layoutParams.f2486d = 0;
                        layoutParams.f2489g = 0;
                        layoutParams.bottomMargin = dimensionPixelOffset;
                        viewGroup.addView(view, layoutParams);
                    } else if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams2.addRule(14);
                        layoutParams2.setMargins(0, 0, 0, dimensionPixelOffset);
                        viewGroup.addView(view, layoutParams2);
                    } else if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.gravity = 81;
                        layoutParams3.setMargins(0, 0, 0, dimensionPixelOffset);
                        viewGroup.addView(view, layoutParams3);
                    } else if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams4.gravity = 1;
                        layoutParams4.setMargins(0, 0, 0, dimensionPixelOffset);
                        viewGroup.addView(view, layoutParams4);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
        }
    }
}
