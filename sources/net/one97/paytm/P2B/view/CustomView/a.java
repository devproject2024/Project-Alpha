package net.one97.paytm.p2b.view.CustomView;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import java.io.Serializable;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2b.view.c.g;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12883a = new a();

    private a() {
    }

    public static void a(j jVar, View view, List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list, String str, StoreFrontGAHandler storeFrontGAHandler) {
        k.c(jVar, "fragmentManager");
        k.c(view, "container");
        k.c(list, "rvWidgets");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(storeFrontGAHandler, "gaHandler");
        Fragment c2 = jVar.c(view.getId());
        if (c2 == null) {
            g.a aVar = g.f12998b;
            k.c(list, "views");
            k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
            g gVar = new g();
            Bundle bundle = new Bundle();
            bundle.putSerializable(gVar.f13001d, (Serializable) list);
            bundle.putString(gVar.f13002e, str);
            gVar.setArguments(bundle);
            c2 = gVar;
        }
        if (c2 instanceof g) {
            k.c(storeFrontGAHandler, "gaHandler");
            ((g) c2).f12999a = storeFrontGAHandler;
        }
        if (!c2.isAdded()) {
            q a2 = jVar.a();
            k.a((Object) a2, "fragmentManager.beginTransaction()");
            a2.a(view.getId(), c2);
            a2.c();
        }
    }
}
