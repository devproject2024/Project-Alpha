package net.one97.paytm.nativesdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.j;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.interfaces.GAEventListener;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieFetchListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieRequestListener;
import net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData;
import net.one97.paytm.nativesdk.orflow.promo.model.Request;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class NativeSdkPromoHelper implements GAEventListener, OnPromoActivityDestroyListener {
    private PromoHelper.Configuration configuration;
    private String mid;
    private OnPromoActivityDestroyListener onPromoActivityDestroyListener;
    private String ssoToken;
    private String verticalName;

    public NativeSdkPromoHelper(String str, String str2, String str3, PromoHelper.Configuration configuration2) {
        k.c(str, "mid");
        k.c(str2, "ssoToken");
        k.c(str3, "verticalName");
        k.c(configuration2, CLConstants.INPUT_KEY_CONFIGURATION);
        this.mid = str;
        this.ssoToken = str2;
        this.verticalName = str3;
        this.configuration = configuration2;
        if (TextUtils.isEmpty(this.configuration.getVerticalName())) {
            this.configuration.setVerticalName(this.verticalName);
        }
        PromoHelper.Companion.getInstance().setMultiItemEmiFlow(p.a(Utility.VERTICAL_NAME_MALL, this.verticalName, true));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NativeSdkPromoHelper(String str, String str2, String str3) {
        this(str, str2, str3, new PromoHelper.Configuration().setServer(Server.PRODUCTION));
        k.c(str, "mid");
        k.c(str2, "ssoToken");
        k.c(str3, "verticalName");
    }

    public final void startPromoSearchActivity(Context context, Double d2, String str, VerifyPromoCallbackListener verifyPromoCallbackListener) {
        k.c(context, "context");
        k.c(str, "promoSearchResponse");
        k.c(verifyPromoCallbackListener, "listener");
        PromoHelper.Companion.getInstance().setGaEventListener(this);
        PromoHelper.Companion.getInstance().setOnPromoActivityDestroyListener(this);
        PromoHelper instance = PromoHelper.Companion.getInstance();
        if (d2 == null) {
            k.a();
        }
        instance.startPromoSearchActivity(context, d2.doubleValue(), this.mid, this.ssoToken, str, this.configuration, verifyPromoCallbackListener);
    }

    public final void startPromoSearchActivityWithoutData(Context context, Double d2, Request request, VerifyPromoCallbackListener verifyPromoCallbackListener) {
        k.c(context, "context");
        k.c(request, "promoSearchRequest");
        k.c(verifyPromoCallbackListener, "listener");
        PromoHelper.Companion.getInstance().setGaEventListener(this);
        PromoHelper.Companion.getInstance().setOnPromoActivityDestroyListener(this);
        PromoHelper instance = PromoHelper.Companion.getInstance();
        if (d2 == null) {
            k.a();
        }
        instance.startPromoSearchActivityWithoutData(context, d2.doubleValue(), this.mid, this.ssoToken, request, this.configuration, verifyPromoCallbackListener);
    }

    public final void openPromoPayOptionsBottomSheet(j jVar, double d2, CJPayMethodResponse cJPayMethodResponse, PaytmSDKRequestClient.VerifyResponseData verifyResponseData, VerifyPromoCallbackListener verifyPromoCallbackListener) {
        k.c(jVar, "fragmentManager");
        CJPayMethodResponse cJPayMethodResponse2 = cJPayMethodResponse;
        k.c(cJPayMethodResponse2, "cjPayMethodResponse");
        VerifyPromoCallbackListener verifyPromoCallbackListener2 = verifyPromoCallbackListener;
        k.c(verifyPromoCallbackListener2, "verifyPromoCallbackListener");
        PromoHelper.Companion.getInstance().setGaEventListener(this);
        PromoHelper.Companion.getInstance().setOnPromoActivityDestroyListener(this);
        PromoHelper.Companion.getInstance().openPromoPayOptionsBottomSheet(jVar, d2, this.mid, this.ssoToken, cJPayMethodResponse2, verifyResponseData, this.configuration, verifyPromoCallbackListener2);
    }

    public final void sendGAEvents(Context context, Map<String, Object> map) {
        k.c(context, "context");
        if (map != null) {
            try {
                String a2 = a.a(context);
                k.a((Object) a2, "ApplaunchUtility.getUserId(context)");
                map.put("user_id", a2);
                net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, map, context);
            } catch (Exception unused) {
            }
        }
    }

    public final void sendScreenViewEvent(Context context, String str, String str2) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public final void setOnPromoActivityDestroyListener(OnPromoActivityDestroyListener onPromoActivityDestroyListener2) {
        k.c(onPromoActivityDestroyListener2, "listener");
        this.onPromoActivityDestroyListener = onPromoActivityDestroyListener2;
    }

    public final void onPromoSearchActivityDestroy(boolean z) {
        OnPromoActivityDestroyListener onPromoActivityDestroyListener2 = this.onPromoActivityDestroyListener;
        if (onPromoActivityDestroyListener2 != null) {
            onPromoActivityDestroyListener2.onPromoSearchActivityDestroy(z);
        }
    }

    public final void startMallPromoSearchActivity(Activity activity, double d2, String str, VerifyPromoCallbackListener verifyPromoCallbackListener, IFreebieFetchListener iFreebieFetchListener, HashMap<String, Object> hashMap, IFreebieRequestListener iFreebieRequestListener) {
        Activity activity2 = activity;
        k.c(activity2, "activity");
        String str2 = str;
        k.c(str2, "jsonResponse");
        VerifyPromoCallbackListener verifyPromoCallbackListener2 = verifyPromoCallbackListener;
        k.c(verifyPromoCallbackListener2, "verifyPromoCallbackListener");
        IFreebieFetchListener iFreebieFetchListener2 = iFreebieFetchListener;
        k.c(iFreebieFetchListener2, "getFreebieResponse");
        HashMap<String, Object> hashMap2 = hashMap;
        k.c(hashMap2, Item.CTA_URL_TYPE_MAP);
        IFreebieRequestListener iFreebieRequestListener2 = iFreebieRequestListener;
        k.c(iFreebieRequestListener2, "listener");
        PromoHelper.Companion.getInstance().setGaEventListener(this);
        PromoHelper.Companion.getInstance().startMallPromoSearchActivity(activity2, d2, this.mid, this.ssoToken, str2, verifyPromoCallbackListener2, iFreebieFetchListener2, hashMap2, iFreebieRequestListener2, this.configuration);
    }

    public final void startMallFreebieListActivity(Activity activity, List<? extends CJRPromoData> list, IFreebieFetchListener iFreebieFetchListener, IFreebieRequestListener iFreebieRequestListener, HashMap<String, Object> hashMap) {
        k.c(activity, "activity");
        k.c(list, "promoDataArray");
        k.c(iFreebieFetchListener, "getFreebieResponse");
        k.c(iFreebieRequestListener, "listener");
        k.c(hashMap, "dataMap");
        PromoHelper.Companion.getInstance().setGaEventListener(this);
        PromoHelper.Companion.getInstance().startMallFreebieListActivity(activity, list, iFreebieFetchListener, iFreebieRequestListener, hashMap);
    }

    public final boolean isPaymentIntentPresent() {
        if (PromoHelper.Companion.getInstance().getPaymentIntent() == null) {
            return false;
        }
        ArrayList<PaymentIntent> paymentIntent = PromoHelper.Companion.getInstance().getPaymentIntent();
        if (paymentIntent == null) {
            k.a();
        }
        return paymentIntent.size() > 0 && p.a(Utility.VERTICAL_NAME_MALL, PromoHelper.Companion.getInstance().getVerticalName(), true);
    }

    public final void resetPaymentIntent() {
        PromoHelper.Companion.getInstance().clearPaymentIntent();
    }
}
