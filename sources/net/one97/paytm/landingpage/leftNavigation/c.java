package net.one97.paytm.landingpage.leftNavigation;

import android.content.Context;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.g.b.k;

public final class c {

    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f52833a;

        public a(Context context) {
            this.f52833a = context;
        }

        public final void run() {
            h hVar = h.f52857a;
            Context context = this.f52833a;
            k.c(context, "context");
            HomeResponse a2 = h.a(h.a(context), context);
            if (a2 == null) {
                a2 = h.c(context);
            }
            if (a2 != null) {
                b bVar = b.f52831a;
                b.a(SFInterface.getSanitizedResponse$default(SFInterface.INSTANCE, a2, false, 2, (Object) null));
            }
        }
    }
}
