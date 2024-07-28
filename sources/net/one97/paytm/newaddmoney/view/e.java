package net.one97.paytm.newaddmoney.view;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import java.io.Serializable;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.towallet.view.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f55944a = new e();

    private e() {
    }

    public static void a(j jVar, View view, List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list, String str, StoreFrontGAHandler storeFrontGAHandler) {
        k.c(jVar, "fragmentManager");
        k.c(view, "container");
        k.c(list, "rvWidgets");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(storeFrontGAHandler, "gaHandler");
        Fragment c2 = jVar.c(view.getId());
        if (c2 == null) {
            a.C0861a aVar = a.f48884b;
            k.c(list, "views");
            k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
            a aVar2 = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable(aVar2.f48887d, (Serializable) list);
            bundle.putString(aVar2.f48888e, str);
            aVar2.setArguments(bundle);
            c2 = aVar2;
        }
        if (c2 instanceof a) {
            k.c(storeFrontGAHandler, "gaHandler");
            ((a) c2).f48885a = storeFrontGAHandler;
        }
        if (!c2.isAdded()) {
            q a2 = jVar.a();
            k.a((Object) a2, "fragmentManager.beginTransaction()");
            a2.a(view.getId(), c2);
            a2.c();
        }
    }
}
