package net.one97.paytm.games.fragment.a;

import android.app.Application;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.games.model.CJRGenerateAuthAccessToken;

public final class e extends a {

    /* renamed from: h  reason: collision with root package name */
    public com.paytm.network.a f35653h;

    /* renamed from: i  reason: collision with root package name */
    public y<o<Integer, CJRGenerateAuthAccessToken>> f35654i = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Application application) {
        super(application);
        k.c(application, "application");
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f35655a;

        public a(e eVar) {
            this.f35655a = eVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r2.f35655a.f35654i.setValue(kotlin.t.a(5, null));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
            net.one97.paytm.games.fragment.a.e.a(r2.f35655a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
            throw r3;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0045 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleErrorCode(int r3, com.paytm.network.model.IJRPaytmDataModel r4, com.paytm.network.model.NetworkCustomError r5) {
            /*
                r2 = this;
                r3 = 0
                r0 = 5
                if (r5 != 0) goto L_0x0007
                kotlin.g.b.k.a()     // Catch:{ all -> 0x0045 }
            L_0x0007:
                if (r4 == 0) goto L_0x003d
                net.one97.paytm.games.model.CJRGenerateAuthAccessToken r4 = (net.one97.paytm.games.model.CJRGenerateAuthAccessToken) r4     // Catch:{ all -> 0x0045 }
                net.one97.paytm.games.model.GpCommonBaseResponse r4 = (net.one97.paytm.games.model.GpCommonBaseResponse) r4     // Catch:{ all -> 0x0045 }
                java.lang.Class<net.one97.paytm.games.model.CJRGenerateAuthAccessToken> r1 = net.one97.paytm.games.model.CJRGenerateAuthAccessToken.class
                net.one97.paytm.games.model.GpCommonBaseResponse r4 = net.one97.paytm.games.e.f.a((com.paytm.network.model.NetworkCustomError) r5, r4, r1)     // Catch:{ all -> 0x0045 }
                net.one97.paytm.games.model.CJRGenerateAuthAccessToken r4 = (net.one97.paytm.games.model.CJRGenerateAuthAccessToken) r4     // Catch:{ all -> 0x0045 }
                if (r4 == 0) goto L_0x0028
                net.one97.paytm.games.fragment.a.e r5 = r2.f35655a     // Catch:{ all -> 0x0045 }
                androidx.lifecycle.y<kotlin.o<java.lang.Integer, net.one97.paytm.games.model.CJRGenerateAuthAccessToken>> r5 = r5.f35654i     // Catch:{ all -> 0x0045 }
                r1 = 6
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0045 }
                kotlin.o r4 = kotlin.t.a(r1, r4)     // Catch:{ all -> 0x0045 }
                r5.setValue(r4)     // Catch:{ all -> 0x0045 }
                goto L_0x0037
            L_0x0028:
                net.one97.paytm.games.fragment.a.e r4 = r2.f35655a     // Catch:{ all -> 0x0045 }
                androidx.lifecycle.y<kotlin.o<java.lang.Integer, net.one97.paytm.games.model.CJRGenerateAuthAccessToken>> r4 = r4.f35654i     // Catch:{ all -> 0x0045 }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0045 }
                kotlin.o r5 = kotlin.t.a(r5, r3)     // Catch:{ all -> 0x0045 }
                r4.setValue(r5)     // Catch:{ all -> 0x0045 }
            L_0x0037:
                net.one97.paytm.games.fragment.a.e r3 = r2.f35655a
                r3.f35653h = null
                return
            L_0x003d:
                kotlin.u r4 = new kotlin.u     // Catch:{ all -> 0x0045 }
                java.lang.String r5 = "null cannot be cast to non-null type net.one97.paytm.games.model.CJRGenerateAuthAccessToken"
                r4.<init>(r5)     // Catch:{ all -> 0x0045 }
                throw r4     // Catch:{ all -> 0x0045 }
            L_0x0045:
                net.one97.paytm.games.fragment.a.e r4 = r2.f35655a     // Catch:{ all -> 0x0055 }
                androidx.lifecycle.y<kotlin.o<java.lang.Integer, net.one97.paytm.games.model.CJRGenerateAuthAccessToken>> r4 = r4.f35654i     // Catch:{ all -> 0x0055 }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0055 }
                kotlin.o r3 = kotlin.t.a(r5, r3)     // Catch:{ all -> 0x0055 }
                r4.setValue(r3)     // Catch:{ all -> 0x0055 }
                goto L_0x0037
            L_0x0055:
                r3 = move-exception
                net.one97.paytm.games.fragment.a.e r4 = r2.f35655a
                r4.f35653h = null
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.fragment.a.e.a.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRGenerateAuthAccessToken) {
                this.f35655a.f35654i.setValue(new o(6, iJRPaytmDataModel));
            } else {
                this.f35655a.f35654i.setValue(new o(5, null));
            }
            this.f35655a.f35653h = null;
        }
    }

    public final void onCleared() {
        super.onCleared();
        com.paytm.network.a aVar = this.f35653h;
        if (aVar != null) {
            aVar.b();
        }
    }
}
