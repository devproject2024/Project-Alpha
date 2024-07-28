package net.one97.paytm.o2o.movies.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.reactivex.rxjava3.a.r;
import kotlin.g.b.k;

public final class OrderTimerManagerKt$observeBroadcasts$observable$1$receiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f74983a;

    OrderTimerManagerKt$observeBroadcasts$observable$1$receiver$1(r rVar) {
        this.f74983a = rVar;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        r rVar = this.f74983a;
        k.a((Object) rVar, "observer");
        if (!rVar.isDisposed()) {
            this.f74983a.onNext(intent);
        }
    }
}
