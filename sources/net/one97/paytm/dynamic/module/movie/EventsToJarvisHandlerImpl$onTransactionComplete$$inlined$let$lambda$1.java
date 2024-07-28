package net.one97.paytm.dynamic.module.movie;

import android.content.Context;
import android.graphics.Point;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.cashback.posttxn.a;
import net.one97.paytm.cashback.posttxn.e;

public final class EventsToJarvisHandlerImpl$onTransactionComplete$$inlined$let$lambda$1 implements a {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ String $orderId$inlined;
    final /* synthetic */ e $postTxnCashBackHelper$inlined;
    final /* synthetic */ SFWidget $sfWidget$inlined;
    final /* synthetic */ net.one97.paytm.utils.b.a $transactionType$inlined;

    EventsToJarvisHandlerImpl$onTransactionComplete$$inlined$let$lambda$1(net.one97.paytm.utils.b.a aVar, e eVar, Context context, String str, SFWidget sFWidget) {
        this.$transactionType$inlined = aVar;
        this.$postTxnCashBackHelper$inlined = eVar;
        this.$context$inlined = context;
        this.$orderId$inlined = str;
        this.$sfWidget$inlined = sFWidget;
    }

    public final void onAnimationEnd(String str) {
        k.c(str, "p0");
        SFWidget sFWidget = this.$sfWidget$inlined;
        if (sFWidget != null) {
            ((IStaticWidget) sFWidget).AnimateView(str);
            return;
        }
        throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget");
    }

    public final Point getFloatingWidgetPos(String str) {
        k.c(str, "p0");
        SFWidget sFWidget = this.$sfWidget$inlined;
        if (sFWidget != null) {
            ((IStaticWidget) sFWidget).getViewPoint(str);
            return null;
        }
        throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget");
    }
}
