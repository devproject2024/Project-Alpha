package net.one97.paytm.landingpage.leftNavigation;

import android.content.Context;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.g.b.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    final Context f52852a;

    /* renamed from: b  reason: collision with root package name */
    private final String f52853b = "/";

    public f(Context context) {
        k.c(context, "context");
        this.f52852a = context;
    }

    public static final class a implements IGAEnableListener {
        public final boolean isGAEnabled() {
            return false;
        }

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public final SanitizedResponseModel a(HomeResponse homeResponse) {
        return SFInterface.INSTANCE.getSanitizedResponse(homeResponse, true, this.f52853b, 1005, new a());
    }
}
