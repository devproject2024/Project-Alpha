package net.one97.paytm.oauth.asynctask;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.n;
import androidx.work.v;
import androidx.work.w;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.models.AuthEncryptedSSOToken;

public final class EncryptedTokenWorker extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public static final a f52567a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private Context f52568b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EncryptedTokenWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
        this.f52568b = context;
    }

    public static final class b implements com.paytm.network.listener.b {
        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }

        b() {
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof AuthEncryptedSSOToken) {
                AuthEncryptedSSOToken authEncryptedSSOToken = (AuthEncryptedSSOToken) iJRPaytmDataModel;
                OauthModule.b().saveEncryptedSSOToken(authEncryptedSSOToken.getEncSSSOToken());
                new StringBuilder().append(authEncryptedSSOToken.getEncSSSOToken());
                q.b();
            }
        }
    }

    public final ListenableWorker.a doWork() {
        net.one97.paytm.oauth.b.b.a((com.paytm.network.listener.b) new b());
        ListenableWorker.a a2 = ListenableWorker.a.a();
        k.a((Object) a2, "Result.success()");
        return a2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a() {
            w c2 = new n.a(EncryptedTokenWorker.class).c();
            k.a((Object) c2, "OneTimeWorkRequest.Build…rker::class.java).build()");
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            k.a((Object) b2, "OauthModule.getOathDataProvider()");
            v.a(b2.getApplicationContext()).a((w) (n) c2);
        }
    }
}
