package net.one97.paytm.recharge.ordersummary.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
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
import net.one97.paytm.recharge.di.helper.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public SFWidget f64548a;

    /* renamed from: b  reason: collision with root package name */
    final FragmentActivity f64549b;

    /* renamed from: c  reason: collision with root package name */
    final ViewGroup f64550c;

    /* renamed from: d  reason: collision with root package name */
    final C1271a f64551d;

    /* renamed from: net.one97.paytm.recharge.ordersummary.widget.a$a  reason: collision with other inner class name */
    public interface C1271a {
        void q();
    }

    public /* synthetic */ a(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        this(fragmentActivity, viewGroup, (C1271a) null);
    }

    public a(FragmentActivity fragmentActivity, ViewGroup viewGroup, C1271a aVar) {
        k.c(fragmentActivity, "context");
        k.c(viewGroup, "floatingBarViewGroup");
        this.f64549b = fragmentActivity;
        this.f64550c = viewGroup;
        this.f64551d = aVar;
        if (com.paytm.utility.b.c((Context) this.f64549b)) {
            c cVar = c.f62654a;
            String s = com.paytm.utility.b.s(this.f64549b, c.bG());
            k.a((Object) s, "CJRAppCommonUtility.addD…sWithoutSSO(context, url)");
            SFInterface.INSTANCE.getStoreFrontReponse(s, new HashMap(), a.c.RECHARGES, new b(this));
            return;
        }
        C1271a aVar2 = this.f64551d;
        if (aVar2 != null) {
            aVar2.q();
        }
    }

    public static final class b implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64552a;

        b(a aVar) {
            this.f64552a = aVar;
        }

        public final void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            C1271a aVar = this.f64552a.f64551d;
            if (aVar != null) {
                aVar.q();
            }
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                a aVar = this.f64552a;
                LinkedHashMap<Integer, IWidgetProvider> sfWidgets = sanitizedResponseModel.getSfWidgets();
                StoreFrontGAHandler gaListener = sanitizedResponseModel.getGaListener();
                IWidgetProvider iWidgetProvider = sfWidgets.get(104);
                aVar.f64548a = iWidgetProvider != null ? iWidgetProvider.getWidget(aVar.f64549b, gaListener) : null;
                if (aVar.f64548a instanceof IStaticWidget) {
                    ViewGroup viewGroup = aVar.f64550c;
                    SFWidget sFWidget = aVar.f64548a;
                    if (sFWidget != null) {
                        viewGroup.addView(((IStaticWidget) sFWidget).getView());
                    } else {
                        throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget");
                    }
                }
            }
            C1271a aVar2 = this.f64552a.f64551d;
            if (aVar2 != null) {
                aVar2.q();
            }
        }
    }

    public final void a() {
        ViewPropertyAnimator translationY;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator animate = this.f64550c.animate();
        if (animate != null && (translationY = animate.translationY(0.0f)) != null && (interpolator = translationY.setInterpolator(new DecelerateInterpolator(2.0f))) != null) {
            interpolator.start();
        }
    }

    public final void b() {
        ViewPropertyAnimator translationY;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator animate = this.f64550c.animate();
        if (animate != null && (translationY = animate.translationY((float) (this.f64550c.getHeight() + 100))) != null && (interpolator = translationY.setInterpolator(new AccelerateInterpolator(2.0f))) != null) {
            interpolator.start();
        }
    }
}
