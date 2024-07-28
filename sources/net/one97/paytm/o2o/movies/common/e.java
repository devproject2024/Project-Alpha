package net.one97.paytm.o2o.movies.common;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.appcompat.app.c;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import io.reactivex.rxjava3.d.f;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.o2o.movies.R;

public final class e {
    public static final void a(Context context) {
        if (context != null) {
            Intent intent = new Intent("action.order.session.expire");
            Object systemService = context.getSystemService("alarm");
            if (!(systemService instanceof AlarmManager)) {
                systemService = null;
            }
            AlarmManager alarmManager = (AlarmManager) systemService;
            if (alarmManager != null) {
                alarmManager.cancel(PendingIntent.getBroadcast(context, 868, intent, 134217728));
            }
        }
    }

    public static final p<Intent> a(Context context, String str) {
        k.c(context, "$this$observeBroadcasts");
        k.c(str, "action");
        p<Intent> observeOn = p.create(new a(context, new IntentFilter(str))).subscribeOn(io.reactivex.rxjava3.android.b.a.a()).observeOn(io.reactivex.rxjava3.android.b.a.a());
        k.a((Object) observeOn, "observable\n            .…dSchedulers.mainThread())");
        return observeOn;
    }

    static final class a<T> implements s<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f75113a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ IntentFilter f75114b;

        a(Context context, IntentFilter intentFilter) {
            this.f75113a = context;
            this.f75114b = intentFilter;
        }

        public final void subscribe(r<Intent> rVar) {
            final OrderTimerManagerKt$observeBroadcasts$observable$1$receiver$1 orderTimerManagerKt$observeBroadcasts$observable$1$receiver$1 = new OrderTimerManagerKt$observeBroadcasts$observable$1$receiver$1(rVar);
            rVar.setCancellable(new f(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f75115a;

                {
                    this.f75115a = r1;
                }

                public final void cancel() {
                    this.f75115a.f75113a.unregisterReceiver(orderTimerManagerKt$observeBroadcasts$observable$1$receiver$1);
                }
            });
            this.f75113a.registerReceiver(orderTimerManagerKt$observeBroadcasts$observable$1$receiver$1, this.f75114b);
        }
    }

    public static final void a(Activity activity, kotlin.g.a.a<x> aVar) {
        k.c(aVar, "onOkClick");
        if (activity != null) {
            try {
                c.a aVar2 = new c.a(activity);
                aVar2.a((CharSequence) activity.getString(R.string.movie_seat_selection_session_expire_alert_title));
                aVar2.b((CharSequence) activity.getString(R.string.movie_seat_selection_session_expire_alert_message));
                aVar2.a((CharSequence) activity.getString(R.string.ok), (DialogInterface.OnClickListener) new b(aVar));
                aVar2.a(false);
                aVar2.b();
            } catch (Exception unused) {
            }
        }
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.a f75117a;

        b(kotlin.g.a.a aVar) {
            this.f75117a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f75117a.invoke();
        }
    }
}
