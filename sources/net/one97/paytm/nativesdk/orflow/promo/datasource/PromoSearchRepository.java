package net.one97.paytm.nativesdk.orflow.promo.datasource;

import android.content.Context;
import com.alipay.mobile.h5container.api.H5Event;
import com.android.volley.DefaultRetryPolicy;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.interfaces.PromoSearchListener;
import net.one97.paytm.nativesdk.orflow.promo.datasource.PromoDataSource;
import net.one97.paytm.nativesdk.orflow.promo.model.OfferDetailModel;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoList;
import net.one97.paytm.nativesdk.orflow.promo.model.Request;

public final class PromoSearchRepository implements PromoDataSource {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static PromoSearchRepository INSTANCE;
    private final Context context;

    private PromoSearchRepository(Context context2) {
        this.context = context2;
    }

    public /* synthetic */ PromoSearchRepository(Context context2, g gVar) {
        this(context2);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoSearchRepository getInstance(Context context) {
            k.c(context, "context");
            if (PromoSearchRepository.INSTANCE == null) {
                PromoSearchRepository.INSTANCE = new PromoSearchRepository(context, (g) null);
            }
            PromoSearchRepository access$getINSTANCE$cp = PromoSearchRepository.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                k.a();
            }
            return access$getINSTANCE$cp;
        }

        public final void destroy() {
            PromoSearchRepository.INSTANCE = null;
        }
    }

    public final void getAllPromos(Request request, PromoSearchListener promoSearchListener) {
        k.c(request, "promoSearchRequest");
        k.c(promoSearchListener, H5Event.TYPE_CALL_BACK);
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(request.getRequestType(), request.getUrl(), request.getHeaders(), request.getParams(), request.getRequestBody(), new PromoSearchRepository$getAllPromos$request$1(promoSearchListener), new PromoSearchRepository$getAllPromos$request$2(promoSearchListener), String.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        executeRequest(volleyPostRequest);
    }

    public final void validatePromo(Request request, VerifyPromoResultListener verifyPromoResultListener) {
        k.c(request, "validatePromoRequest");
        k.c(verifyPromoResultListener, H5Event.TYPE_CALL_BACK);
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(request.getRequestType(), request.getUrl(), request.getHeaders(), request.getParams(), request.getRequestBody(), PromoSearchRepository$validatePromo$request$1.INSTANCE, PromoSearchRepository$validatePromo$request$2.INSTANCE, PromoList.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        executeRequest(volleyPostRequest);
    }

    public final void getOfferDetail(String str, PromoDataSource.Callback<OfferDetailModel> callback) {
        k.c(str, "url");
        k.c(callback, H5Event.TYPE_CALL_BACK);
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(0, str, (Map<String, String>) null, (Map<String, String>) null, (String) null, callback, callback, OfferDetailModel.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        executeRequest(volleyPostRequest);
    }

    private final void executeRequest(com.android.volley.Request<?> request) {
        if (SDKUtility.isNetworkAvailable(this.context)) {
            VolleyRequestQueue.getInstance(this.context).addToRequestQueue(request);
        }
    }
}
