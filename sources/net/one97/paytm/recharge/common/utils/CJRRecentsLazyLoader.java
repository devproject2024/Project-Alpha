package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.c;
import androidx.work.m;
import androidx.work.n;
import androidx.work.v;
import androidx.work.w;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class CJRRecentsLazyLoader extends ListenableWorker {

    /* renamed from: a  reason: collision with root package name */
    public static final a f61453a = new a((byte) 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRRecentsLazyLoader(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a() {
            c cVar = c.f62654a;
            w.a a2 = ((n.a) ((n.a) new n.a(CJRRecentsLazyLoader.class).a(c.br(), TimeUnit.MILLISECONDS)).a(new c.a().a(m.CONNECTED).a().b())).a(CJRRecentsLazyLoader.class.getName());
            k.a((Object) a2, "OneTimeWorkRequest.Build…yLoader::class.java.name)");
            v a3 = v.a();
            k.a((Object) a3, "WorkManager.getInstance()");
            a3.a(((n.a) a2).c());
        }
    }

    public final com.google.b.a.a.a<ListenableWorker.a> startWork() {
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        cJRRechargeUtilities.debugLog(CJRRecentsLazyLoader.class.getSimpleName() + " startWork()");
        androidx.work.impl.utils.a.c a2 = androidx.work.impl.utils.a.c.a();
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        d dVar = d.f64967a;
        CJRRechargeErrorModel a3 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        CRUFlowModel flowName = a3.getFlowName();
        if (flowName != null) {
            flowName.setActionType(ACTION_TYPE.FETCH_RECENTS.name());
        }
        CRUFlowModel flowName2 = a3.getFlowName();
        if (flowName2 != null) {
            flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        net.one97.paytm.recharge.common.b.d.a(applicationContext).c("frequent_api", new b(a2), a3);
        k.a((Object) a2, "future");
        return a2;
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.a.c f61454a;

        b(androidx.work.impl.utils.a.c cVar) {
            this.f61454a = cVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities.debugLog(CJRRecentsLazyLoader.class.getSimpleName() + " startWork() FAILED");
            this.f61454a.a(ListenableWorker.a.c());
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJRFrequentOrderList) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                cJRRechargeUtilities.debugLog(CJRRecentsLazyLoader.class.getSimpleName() + " startWork() SUCCESS");
                CJRRechargeUtilities.INSTANCE.setFrequentOrderList((CJRFrequentOrderList) iJRPaytmDataModel);
                this.f61454a.a(ListenableWorker.a.a());
            }
        }
    }
}
