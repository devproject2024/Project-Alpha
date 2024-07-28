package net.one97.paytm.v2.features.a;

import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.ErrorModel;
import net.one97.paytm.v2.a.f;
import net.one97.paytm.vipcashback.f.a;
import net.one97.paytm.vipcashback.f.h;

public final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20059a;

    public final void a(y<h<Object>> yVar, String str) {
        k.c(yVar, "result");
        k.c(str, "offersTag");
    }

    public final void a(y<h<Object>> yVar, String str, int i2, int i3) {
        k.c(yVar, "result");
    }

    public final void a(y<h<Object>> yVar, String str, String str2, Boolean bool) {
        k.c(yVar, "result");
    }

    public a(Context context) {
        k.c(context, "appContext");
        this.f20059a = context;
    }

    /* renamed from: net.one97.paytm.v2.features.a.a$a  reason: collision with other inner class name */
    public static final class C0355a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20060a;

        C0355a(y yVar) {
            this.f20060a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f20060a.setValue(h.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "model");
            k.c(networkCustomError, "networkError");
            this.f20060a.setValue(h.a(new ErrorModel(i2, iJRPaytmDataModel), networkCustomError));
        }
    }

    public final void a(y<h<Object>> yVar, String str, String str2) {
        k.c(yVar, "mediator");
        k.c(str, StringSet.filter);
        k.c(str2, "pageNo");
        a.C0397a aVar = net.one97.paytm.vipcashback.f.a.f20855a;
        com.paytm.network.a a2 = a.C0397a.a(new C0355a(yVar), str, str2, true);
        if (com.paytm.utility.b.c(this.f20059a)) {
            yVar.setValue(h.a());
            if (a2 != null) {
                a2.a();
                return;
            }
            return;
        }
        yVar.setValue(h.b(a2));
    }
}
