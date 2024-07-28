package net.one97.paytm.oauth.utils;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.asynctask.EncryptedTokenWorker;
import net.one97.paytm.oauth.models.TokenV3ResModel;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final a f56802a;

    public interface a {
        void a();

        void b();
    }

    public w(a aVar) {
        k.c(aVar, "tokeRefreshListener");
        this.f56802a = aVar;
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f56804a;

        public c(w wVar) {
            this.f56804a = wVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "resModel");
            if (iJRPaytmDataModel instanceof TokenV3ResModel) {
                l.a((TokenV3ResModel) iJRPaytmDataModel);
                net.one97.paytm.oauth.b b2 = OauthModule.b();
                k.a((Object) b2, "OauthModule.getOathDataProvider()");
                String sSOToken = b2.getSSOToken();
                q qVar = q.f56798a;
                String u = q.u();
                if (TextUtils.isEmpty(sSOToken) && !TextUtils.isEmpty(u)) {
                    OauthModule.b().saveSSOToken(u);
                    sSOToken = u;
                }
                long currentTimeMillis = System.currentTimeMillis();
                q qVar2 = q.f56798a;
                if (currentTimeMillis >= q.t() || TextUtils.isEmpty(sSOToken)) {
                    w wVar = this.f56804a;
                    q qVar3 = q.f56798a;
                    net.one97.paytm.oauth.b.b.b(q.r(), (com.paytm.network.listener.b) new b(wVar));
                    return;
                }
                this.f56804a.f56802a.a();
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56804a.f56802a.b();
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f56803a;

        b(w wVar) {
            this.f56803a = wVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "resModel");
            if (iJRPaytmDataModel instanceof TokenV3ResModel) {
                l.a((TokenV3ResModel) iJRPaytmDataModel);
                EncryptedTokenWorker.a aVar = EncryptedTokenWorker.f52567a;
                EncryptedTokenWorker.a.a();
                this.f56803a.f56802a.a();
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56803a.f56802a.b();
        }
    }
}
