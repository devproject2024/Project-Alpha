package net.one97.paytm.o2o.movies.storefront;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.common.f;
import net.one97.paytm.o2o.movies.storefront.model.StorefrontResponse;
import net.one97.paytm.o2o.movies.utils.c;

public final class a {

    public static final class b<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f75873a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f75874b;

        public b(String str, Context context) {
            this.f75873a = str;
            this.f75874b = context;
        }

        public final void subscribe(z<StorefrontResponse> zVar) {
            try {
                c cVar = new c();
                cVar.f42877a = this.f75874b;
                cVar.f42880d = "https://storefront.paytm.com/v2/h/" + this.f75873a + "?plateform_version=S2(New)";
                cVar.f42879c = a.C0715a.POST;
                cVar.f42885i = new StorefrontResponse();
                cVar.f42884h = "{}";
                cVar.f42878b = a.c.MOVIES;
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.j = new C1498a(zVar);
                cVar.l().a();
            } catch (Exception e2) {
                k.a((Object) zVar, "emitter");
                if (!zVar.isDisposed()) {
                    zVar.onError(new f(-1, new StorefrontResponse(), new NetworkCustomError((Throwable) e2)));
                }
            }
        }

        /* renamed from: net.one97.paytm.o2o.movies.storefront.a$b$a  reason: collision with other inner class name */
        public static final class C1498a implements com.paytm.network.listener.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f75875a;

            C1498a(z zVar) {
                this.f75875a = zVar;
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                k.c(iJRPaytmDataModel, "dataModel");
                k.c(networkCustomError, "error");
                net.one97.paytm.o2o.movies.common.a.c.a(this.f75875a, (Throwable) new f(i2, iJRPaytmDataModel, networkCustomError));
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                k.c(iJRPaytmDataModel, "dataModel");
                net.one97.paytm.o2o.movies.common.a.c.a(this.f75875a, (StorefrontResponse) iJRPaytmDataModel);
            }
        }
    }

    public static final y<SanitizedResponseModel> a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "sfName");
        y a2 = y.a(new C1497a(str, context));
        k.a((Object) a2, "Single.create { emitter …kError())\n        }\n    }");
        y<SanitizedResponseModel> a3 = a2.b(io.reactivex.rxjava3.i.a.d()).a(io.reactivex.rxjava3.android.b.a.a());
        k.a((Object) a3, "observable.subscribeOn(S…dSchedulers.mainThread())");
        return a3;
    }

    /* renamed from: net.one97.paytm.o2o.movies.storefront.a$a  reason: collision with other inner class name */
    static final class C1497a<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f75870a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f75871b;

        C1497a(String str, Context context) {
            this.f75870a = str;
            this.f75871b = context;
        }

        public final void subscribe(final z<SanitizedResponseModel> zVar) {
            try {
                StringBuilder sb = new StringBuilder("https://storefront.paytm.com/v2/h/" + this.f75870a);
                sb.append(com.paytm.utility.c.a(this.f75871b, false));
                sb.append("&device=android");
                sb.append("&resolution=" + com.paytm.utility.a.v(this.f75871b));
                String sb2 = sb.toString();
                k.a((Object) sb2, "StringBuilder(\"https://s…              .toString()");
                net.one97.paytm.o2o.movies.utils.a aVar = net.one97.paytm.o2o.movies.utils.a.f75896a;
                net.one97.paytm.o2o.movies.utils.a.a(sb2, new SFCallbackListener() {
                    public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
                        zVar.onSuccess(sanitizedResponseModel);
                    }

                    public final void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        zVar.onError(new f(i2, iJRPaytmDataModel, networkCustomError));
                    }
                });
            } catch (Exception unused) {
                k.a((Object) zVar, "emitter");
                if (!zVar.isDisposed()) {
                    zVar.onError(new f(0, (IJRPaytmDataModel) null, (NetworkCustomError) null, 7, (g) null));
                }
            }
        }
    }
}
