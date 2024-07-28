package net.one97.paytm.vipcashback.g;

import android.app.Application;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.ErrorModel;
import net.one97.paytm.vipcashback.f.h;

public final class d extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public final String f21018a;

    /* renamed from: b  reason: collision with root package name */
    public final String f21019b;

    /* renamed from: c  reason: collision with root package name */
    public final String f21020c;

    /* renamed from: d  reason: collision with root package name */
    public final String f21021d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Application application, String str, String str2, String str3, String str4) {
        super(application);
        k.c(application, "application");
        k.c(str, "promoCode");
        k.c(str2, "siteId");
        this.f21018a = str;
        this.f21019b = str2;
        this.f21020c = str3;
        this.f21021d = str4;
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f21028a;

        public b(y yVar) {
            this.f21028a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f21028a.setValue(h.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "model");
            k.c(networkCustomError, "networkError");
            this.f21028a.setValue(h.a(new ErrorModel(i2, iJRPaytmDataModel), networkCustomError));
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0408a f21022a = new C0408a((byte) 0);

        /* renamed from: b  reason: collision with root package name */
        private static final String f21023b = f21023b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final String f21024c = "site_id";
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final String f21025d = "locale";
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final String f21026e = "client_id";
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final String f21027f = "type";

        /* renamed from: net.one97.paytm.vipcashback.g.d$a$a  reason: collision with other inner class name */
        public static final class C0408a {
            private C0408a() {
            }

            public /* synthetic */ C0408a(byte b2) {
                this();
            }
        }
    }
}
