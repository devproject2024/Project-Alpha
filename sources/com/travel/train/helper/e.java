package com.travel.train.helper;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.webkit.URLUtil;
import androidx.fragment.app.FragmentActivity;
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
import kotlin.g.b.k;
import kotlin.u;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public SFWidget f27282a;

    /* renamed from: b  reason: collision with root package name */
    final FragmentActivity f27283b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f27284c;

    /* renamed from: d  reason: collision with root package name */
    final a f27285d;

    public interface a {
        void storeFrontResponseFetched();
    }

    public e(FragmentActivity fragmentActivity, ViewGroup viewGroup, a aVar) {
        k.c(fragmentActivity, "context");
        k.c(viewGroup, "floatingBarViewGroup");
        this.f27283b = fragmentActivity;
        this.f27284c = viewGroup;
        this.f27285d = aVar;
        if (com.paytm.utility.b.c((Context) this.f27283b)) {
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            String a2 = com.travel.train.b.b().a("trainStoreFrontPostTxnUrl");
            if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
                String s = com.paytm.utility.b.s(this.f27283b, a2);
                HashMap hashMap = new HashMap();
                SFInterface sFInterface = SFInterface.INSTANCE;
                k.a((Object) s, "url");
                sFInterface.getStoreFrontReponse(s, hashMap, a.c.TRAIN, new b(this));
                return;
            }
            return;
        }
        a aVar2 = this.f27285d;
        if (aVar2 != null) {
            aVar2.storeFrontResponseFetched();
        }
    }

    public static final class b implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f27286a;

        b(e eVar) {
            this.f27286a = eVar;
        }

        public final void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            a aVar = this.f27286a.f27285d;
            if (aVar != null) {
                aVar.storeFrontResponseFetched();
            }
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                e eVar = this.f27286a;
                IWidgetProvider iWidgetProvider = sanitizedResponseModel.getSfWidgets().get(104);
                SFWidget sFWidget = null;
                if (iWidgetProvider != null) {
                    sFWidget = iWidgetProvider.getWidget(eVar.f27283b, (IGAHandlerListener) null);
                }
                eVar.f27282a = sFWidget;
                if (eVar.f27282a instanceof IStaticWidget) {
                    ViewGroup viewGroup = eVar.f27284c;
                    SFWidget sFWidget2 = eVar.f27282a;
                    if (sFWidget2 != null) {
                        viewGroup.addView(((IStaticWidget) sFWidget2).getView());
                    } else {
                        throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget");
                    }
                }
            }
            a aVar = this.f27286a.f27285d;
            if (aVar != null) {
                aVar.storeFrontResponseFetched();
            }
        }
    }

    public final void a() {
        ViewPropertyAnimator translationY;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator animate = this.f27284c.animate();
        if (animate != null && (translationY = animate.translationY((float) (this.f27284c.getHeight() + 100))) != null && (interpolator = translationY.setInterpolator(new AccelerateInterpolator(2.0f))) != null) {
            interpolator.start();
        }
    }
}
