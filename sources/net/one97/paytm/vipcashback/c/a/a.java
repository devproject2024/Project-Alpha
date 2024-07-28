package net.one97.paytm.vipcashback.c.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Map;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4;
import net.one97.paytm.common.entity.vipcashback.CashbackAllCards;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.f;
import net.one97.paytm.vipcashback.f.h;
import org.json.JSONObject;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineExceptionHandler f20710a = new C0379a(CoroutineExceptionHandler.Key);

    /* renamed from: b  reason: collision with root package name */
    private final Context f20711b;

    public a(Context context) {
        k.c(context, "context");
        this.f20711b = context;
    }

    public final void a(y<h<Object>> yVar, String str) {
        k.c(str, "scratchCardIds");
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String L = f.L();
        if (!TextUtils.isEmpty(L)) {
            String str2 = L + str;
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(str2);
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.a l = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new CashbackAllCards()).c("PostTxnCashback").a((com.paytm.network.listener.b) new d(yVar)).l();
            if (com.paytm.utility.b.c(this.f20711b)) {
                l.a();
            } else if (yVar != null) {
                yVar.setValue(h.b(l));
            }
        }
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20713a;

        d(y yVar) {
            this.f20713a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f20713a;
            if (yVar != null) {
                yVar.setValue(h.a(iJRPaytmDataModel, networkCustomError));
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            y yVar = this.f20713a;
            if (yVar != null) {
                yVar.setValue(h.a(iJRPaytmDataModel));
            }
        }
    }

    /* renamed from: net.one97.paytm.vipcashback.c.a.a$a  reason: collision with other inner class name */
    public static final class C0379a extends kotlin.d.a implements CoroutineExceptionHandler {
        public C0379a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            k.c(fVar, "context");
            k.c(th, "exception");
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            sb.append(" handled !");
        }
    }

    public final void b(y<h<Object>> yVar, String str) {
        k.c(str, "data");
        k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
        String M = net.one97.paytm.vipcashback.f.f.M();
        if (!TextUtils.isEmpty(M)) {
            new JSONObject();
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.POST).a(M);
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.a l = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new CashBackBaseMyOfferModalV4()).c("PostTxnCashback").b(str).b((int) AppConstants.START_OTP_FLOW).a((com.paytm.network.listener.b) new e(yVar)).l();
            if (com.paytm.utility.b.c(this.f20711b)) {
                if (yVar != null) {
                    yVar.setValue(h.a());
                }
                l.a();
            } else if (yVar != null) {
                yVar.setValue(h.b(l));
            }
        }
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20714a;

        e(y yVar) {
            this.f20714a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f20714a;
            if (yVar != null) {
                yVar.setValue(h.a(iJRPaytmDataModel, networkCustomError));
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            y yVar = this.f20714a;
            if (yVar != null) {
                yVar.setValue(h.a(iJRPaytmDataModel));
            }
        }
    }

    public final void a(y<h<Object>> yVar, int i2, int i3, String str, String str2, String str3) {
        String str4;
        k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
        String v = net.one97.paytm.vipcashback.f.f.v();
        if (!TextUtils.isEmpty(str)) {
            str4 = v + "?txn_id=" + str;
            if (!TextUtils.isEmpty(str3)) {
                str4 = str4 + str3;
            }
        } else if (!TextUtils.isEmpty(str2)) {
            str4 = v + "?order_id=" + str2;
            if (!TextUtils.isEmpty(str3)) {
                str4 = str4 + str3;
            }
        } else {
            str4 = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            String str5 = str4 + "&retryAttempt=" + i3;
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(str5);
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            com.paytm.network.a l = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new CashBackBaseMyOfferModalV4()).c("PostTxnCashback").a((com.paytm.network.listener.b) new c(yVar)).l();
            if (com.paytm.utility.b.c(this.f20711b)) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO().plus(this.f20710a), (CoroutineStart) null, new b(i2, l, (kotlin.d.d) null), 2, (Object) null);
            } else if (yVar != null) {
                yVar.setValue(h.b(l));
            }
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20712a;

        c(y yVar) {
            this.f20712a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f20712a;
            if (yVar != null) {
                yVar.setValue(h.a(iJRPaytmDataModel, networkCustomError));
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            y yVar = this.f20712a;
            if (yVar != null) {
                yVar.setValue(h.a(iJRPaytmDataModel));
            }
        }
    }

    @kotlin.d.b.a.f(b = "PostTxnRemoteDataSource.kt", c = {151, 153}, d = "invokeSuspend", e = "net/one97/paytm/vipcashback/helper/repo/PostTxnRemoteDataSource$getPostTransactionSync$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ int $interval;
        final /* synthetic */ com.paytm.network.a $networkCall;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i2, com.paytm.network.a aVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.$interval = i2;
            this.$networkCall = aVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.$interval, this.$networkCall, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                this.label = 1;
                if (DelayKt.delay((long) (this.$interval * 1000), this) == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            this.$networkCall.a();
            return x.f47997a;
        }
    }
}
