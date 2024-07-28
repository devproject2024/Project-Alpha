package net.one97.paytm.dynamic.module.mall.emiSubvention.nativepghelper;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.google.gson.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import com.paytmmall.artifact.cart.entity.CJRCart;
import com.paytmmall.artifact.cart.entity.CJRCartProduct;
import com.paytmmall.artifact.cart.entity.CJRCategoryMap;
import com.paytmmall.artifact.cart.entity.CJRShoppingCart;
import com.paytmmall.artifact.cart.entity.ItemBreakup;
import com.paytmmall.artifact.cart.entity.StringModel;
import com.paytmmall.artifact.common.entity.WXNetworkResponse;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.w;
import com.paytmmall.b.a;
import com.paytmmall.b.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.dynamic.module.mall.emiSubvention.fragment.EMIOrderReviewFragment;
import net.one97.paytm.nativesdk.NativeSdkPromoHelper;
import net.one97.paytm.nativesdk.Utils.GzipUtils;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieApplyListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieFetchListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieJsonResponseListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieRequestListener;
import net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData;
import net.one97.paytm.nativesdk.orflow.promo.model.Freebie;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MallPGHelper {
    private static final String EVENT_PAYMENT_INSTRUMENT_MISSING = "PAYMENT_INSTRUMENT_MISSING";
    private static final String TAG = MallPGHelper.class.getSimpleName();
    private final int CUSTOM_MANUAL_ERROR_STATUS_CODE = -101;
    private final String EVENT_APPLY_PROMO_ERROR = "APPLY_PROMO_ERROR";
    private final String EVENT_CHECKOUT_ERROR = "CHECKOUT_ERROR";
    private final String EVENT_PROGRESS_DIALOG = "PROGRESS_DIALOG";
    private final String EVENT_PROMO_APPLY_SUCCESS = "APPLY_PROMO_SUCCESS";
    private final String EVENT_PROMO_FETCH_ERROR = "PROMO_ERROR";
    private final String EVENT_REMOVE_INTENT = "REMOVE_INTENT";
    private final String additionalKey = "additional_info";
    private final String closePgKey = "closePgWithoutError";
    private final String errorTitle = "Error";

    /* access modifiers changed from: private */
    public boolean isAuthError(int i2) {
        return i2 == 401 || i2 == 403 || i2 == 410;
    }

    public static void handleInvalidInstrument(w wVar) {
        if (wVar != null) {
            wVar.a(new HashMap<String, Object>() {
                {
                    put(MallPGHelper.EVENT_PAYMENT_INSTRUMENT_MISSING, new HashMap());
                }
            });
        }
    }

    public void openPromoListActivity(Activity activity, String str, String str2, double d2, String str3, w wVar, CJRCartProduct cJRCartProduct, boolean z, String str4, String str5, int i2, CJRCartProduct cJRCartProduct2) {
        w wVar2 = wVar;
        Context appContext = CJRJarvisApplication.getAppContext();
        final String ssoToken = getSsoToken(appContext);
        final String promoCode = cJRCartProduct.getPromoCode() != null ? cJRCartProduct.getPromoCode() : "";
        if (z) {
            openFreebieList(activity, str4, promoCode, wVar, str5, cJRCartProduct2);
            return;
        }
        AnonymousClass2 r15 = new HashMap<String, String>() {
            {
                if (!TextUtils.isEmpty(ssoToken)) {
                    put(AppConstants.SSO_TOKEN, ssoToken);
                }
            }
        };
        invokeCallback(wVar2, showProgress(true));
        if (!d.a((Context) activity)) {
            handlePromoAPIErrorResponse("PROMO_ERROR", wVar2, (NetworkCustomError) null);
            return;
        }
        final w wVar3 = wVar;
        final String str6 = str4;
        final int i3 = i2;
        final CJRCartProduct cJRCartProduct3 = cJRCartProduct2;
        final String str7 = str5;
        final Activity activity2 = activity;
        final String str8 = str2;
        final double d3 = d2;
        final String str9 = str3;
        a.a(appContext, a.C0216a.GET, str, (String) null, r15, new StringModel(), new b() {
            public void onApiSuccess(final IJRPaytmDataModel iJRPaytmDataModel) {
                String data = ((StringModel) iJRPaytmDataModel).getData();
                MallPGHelper mallPGHelper = MallPGHelper.this;
                mallPGHelper.invokeCallback(wVar3, mallPGHelper.showProgress(false));
                MallPGHelper.this.handlePromoListResponse(activity2, data, str8, d3, str9, new HashMap<String, Object>() {
                    {
                        put(Constants.KEY_CURRENT_PROMO, promoCode);
                        if (!(iJRPaytmDataModel.getNetworkResponse() == null || iJRPaytmDataModel.getNetworkResponse().headers == null)) {
                            put(Constants.KEY_CURRENT_TIME, iJRPaytmDataModel.getNetworkResponse().headers.get(Constants.RESPONSE_TIME_KEY));
                        }
                        put("PROMO_DATA", MallPGHelper.this.getPromoDataArray(str6, promoCode, false));
                        put(Constants.KEY_PROMO_COUNT, Integer.valueOf(i3));
                        put("NAME", cJRCartProduct3.getName());
                        put("PRODUCT_ID", cJRCartProduct3.getProductId());
                        put(Constants.KEY_CATEGORY_MAP, MallPGHelper.this.getCategoryMapData(cJRCartProduct3));
                        put(Constants.KEY_DISCOVERABILITY, MallPGHelper.this.isOnlineCart(str7));
                    }
                }, wVar3, str7);
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                MallPGHelper.this.handlePromoAPIErrorResponse("PROMO_ERROR", wVar3, networkCustomError);
            }
        });
    }

    /* access modifiers changed from: private */
    public String getSsoToken(Context context) {
        String b2 = t.b(context);
        return b2 == null ? "" : b2;
    }

    /* access modifiers changed from: private */
    public String isOnlineCart(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return "cart";
            }
            if (P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT.equalsIgnoreCase(parse.getQueryParameter(CLPConstants.DISCOVERABILITY)) || parse.getQueryParameter("storewid") != null) {
                return "offline_cart";
            }
            return "cart";
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "cart";
        }
    }

    /* access modifiers changed from: private */
    public String getCategoryMapData(CJRCartProduct cJRCartProduct) {
        CJRCategoryMap cJRCategoryMap;
        ArrayList<CJRCategoryMap> categoryMap = cJRCartProduct.getCategoryMap();
        if (categoryMap == null || categoryMap.size() <= 0 || (cJRCategoryMap = categoryMap.get(categoryMap.size() - 1)) == null) {
            return "";
        }
        return cJRCategoryMap.getUrlKey();
    }

    private void openFreebieList(Activity activity, String str, String str2, w wVar, String str3, CJRCartProduct cJRCartProduct) {
        new NativeSdkPromoHelper("", "", Utility.VERTICAL_NAME_MALL).startMallFreebieListActivity(activity, getPromoDataArray(str, str2, true), new IFreebieFetchListener() {
            public final void fetchFreebie(String str, IFreebieJsonResponseListener iFreebieJsonResponseListener) {
                MallPGHelper.this.getFreebieResponse(str, iFreebieJsonResponseListener);
            }
        }, new IFreebieRequestListener(wVar, str3) {
            private final /* synthetic */ w f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void applyBulkFreebie(List list, HashMap hashMap, IFreebieApplyListener iFreebieApplyListener) {
                MallPGHelper.this.lambda$openFreebieList$0$MallPGHelper(this.f$1, this.f$2, list, hashMap, iFreebieApplyListener);
            }
        }, getDataMap(cJRCartProduct, str3));
    }

    private HashMap<String, Object> getDataMap(final CJRCartProduct cJRCartProduct, final String str) {
        return new HashMap<String, Object>() {
            {
                put("NAME", cJRCartProduct.getName());
                put("PRODUCT_ID", cJRCartProduct.getProductId());
                put(Constants.KEY_CATEGORY_MAP, MallPGHelper.this.getCategoryMapData(cJRCartProduct));
                put(Constants.KEY_DISCOVERABILITY, MallPGHelper.this.isOnlineCart(str));
            }
        };
    }

    /* access modifiers changed from: private */
    public List<CJRPromoData> getPromoDataArray(String str, String str2, boolean z) {
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                CJRPromoData promoDataObject = RequestHelper.getPromoDataObject(jSONArray.getJSONObject(i2));
                if (z) {
                    arrayList.add(promoDataObject);
                } else if (!(promoDataObject == null || str2 == null || !str2.equalsIgnoreCase(promoDataObject.getPromocode()))) {
                    arrayList.add(promoDataObject);
                }
                i2++;
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void handlePromoAPIErrorResponse(String str, w wVar, NetworkCustomError networkCustomError) {
        HashMap<String, Object> showProgress = showProgress(false);
        showProgress.putAll(errorPromoResponse(str, networkCustomError));
        invokeCallback(wVar, showProgress);
    }

    /* access modifiers changed from: private */
    public void invokeCallback(w wVar, HashMap<String, Object> hashMap) {
        if (wVar != null) {
            wVar.b(hashMap);
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> showProgress(final boolean z) {
        return new HashMap<String, Object>() {
            {
                put("PROGRESS_DIALOG", Boolean.valueOf(z));
            }
        };
    }

    private HashMap<String, Object> errorPromoResponse(final String str, NetworkCustomError networkCustomError) {
        final WXNetworkResponse wXNetworkResponse;
        String str2;
        String alertMessage = (networkCustomError == null || networkCustomError.getStatusCode() != -101 || TextUtils.isEmpty(networkCustomError.getAlertMessage())) ? "Please try again after sometime" : networkCustomError.getAlertMessage();
        if (networkCustomError == null || networkCustomError.getStatusCode() == 0 || networkCustomError.getStatusCode() == -101) {
            wXNetworkResponse = new WXNetworkResponse(0, Collections.singletonMap("error", alertMessage));
        } else {
            int statusCode = networkCustomError.getStatusCode();
            if (networkCustomError.networkResponse == null || networkCustomError.networkResponse.data == null || networkCustomError.networkResponse.data.length <= 0) {
                str2 = networkCustomError.getAlertMessage();
            } else {
                str2 = new String(networkCustomError.networkResponse.data);
            }
            wXNetworkResponse = new WXNetworkResponse(statusCode, parseData(str2), (Map<String, String>) null);
        }
        return new HashMap<String, Object>() {
            {
                put(str, wXNetworkResponse);
            }
        };
    }

    private Object parseData(String str) {
        try {
            f fVar = new f();
            if (str == null || !str.startsWith("[")) {
                return fVar.a(str, LinkedHashMap.class);
            }
            return fVar.a(str, new com.google.gson.b.a<ArrayList<LinkedHashMap>>() {
            }.getType());
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: private */
    public void handlePromoListResponse(Activity activity, String str, String str2, double d2, String str3, HashMap<String, Object> hashMap, w wVar, String str4) {
        final w wVar2 = wVar;
        final String str5 = str4;
        String ssoToken = getSsoToken(CJRJarvisApplication.getAppContext());
        if (!TextUtils.isEmpty(str)) {
            NativeSdkPromoHelper nativeSdkPromoHelper = new NativeSdkPromoHelper(str3, ssoToken, Utility.VERTICAL_NAME_MALL);
            final String str6 = str2;
            nativeSdkPromoHelper.startMallPromoSearchActivity(activity, d2, str, new VerifyPromoCallbackListener() {
                public void onPromoSelected(String str, int i2, String str2, VerifyPromoResultListener verifyPromoResultListener) {
                    MallPGHelper.this.requestPromoApplyApi(str6, str, i2, str2, verifyPromoResultListener, wVar2, str5);
                }

                public void onPaymentIntentSelected(String str, ArrayList<PaymentIntent> arrayList, String str2, VerifyPromoResultListener verifyPromoResultListener) {
                    MallPGHelper mallPGHelper = MallPGHelper.this;
                    mallPGHelper.requestPromoApplywithPayIntent(str6, str, wVar2, mallPGHelper.getPaymentIntent(arrayList), verifyPromoResultListener, str5, false);
                }

                public void clearPromoCode(String str, final PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
                    MallPGHelper.this.removePaymentIntent(str5, wVar2, new PaytmSDKRequestClient.OtherPayOptionsListener() {
                        public void setFetchPayOptionsResponse(CJPayMethodResponse cJPayMethodResponse, double d2) {
                            PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener = applyAnotherOfferListener;
                            if (applyAnotherOfferListener != null) {
                                applyAnotherOfferListener.onSuccess();
                            }
                        }

                        public void onError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                            PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener = applyAnotherOfferListener;
                            if (applyAnotherOfferListener != null) {
                                applyAnotherOfferListener.onError(apiResponseError);
                            }
                        }
                    }, false);
                }
            }, new IFreebieFetchListener() {
                public final void fetchFreebie(String str, IFreebieJsonResponseListener iFreebieJsonResponseListener) {
                    MallPGHelper.this.getFreebieResponse(str, iFreebieJsonResponseListener);
                }
            }, hashMap, new IFreebieRequestListener(wVar2, str5) {
                private final /* synthetic */ w f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void applyBulkFreebie(List list, HashMap hashMap, IFreebieApplyListener iFreebieApplyListener) {
                    MallPGHelper.this.lambda$handlePromoListResponse$1$MallPGHelper(this.f$1, this.f$2, list, hashMap, iFreebieApplyListener);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public String getPaymentIntent(ArrayList<PaymentIntent> arrayList) {
        return new f().b(arrayList);
    }

    /* access modifiers changed from: private */
    public void requestPromoApplywithPayIntent(String str, String str2, w wVar, String str3, VerifyPromoResultListener verifyPromoResultListener, String str4, boolean z) {
        Context appContext = CJRJarvisApplication.getAppContext();
        String ssoToken = getSsoToken(appContext);
        String str5 = str;
        String str6 = str2;
        final String str7 = str3;
        JSONObject applyPromoRequestBody = RequestHelper.getApplyPromoRequestBody(true, str, str2, str7, z);
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, ssoToken);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        final w wVar2 = wVar;
        final VerifyPromoResultListener verifyPromoResultListener2 = verifyPromoResultListener;
        final String str8 = str4;
        a.a(appContext, a.C0216a.POST, str4, applyPromoRequestBody.toString(), hashMap, new StringModel(), new b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                MallPGHelper.this.handleApplyPromowithIntentResponse(((StringModel) iJRPaytmDataModel).getData(), wVar2, verifyPromoResultListener2, str7, str8);
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                MallPGHelper.this.handleApplyPromoErrorResponse(verifyPromoResultListener2, networkCustomError);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleApplyPromowithIntentResponse(String str, w wVar, VerifyPromoResultListener verifyPromoResultListener, String str2, String str3) {
        if (isEmiSuccessResponse(str)) {
            setPayIntent(str, wVar, verifyPromoResultListener, str2, str3);
        } else if (verifyPromoResultListener != null) {
            verifyPromoResultListener.onVerifyPromoError(getCartError(str));
        }
    }

    private void setPayIntent(final String str, final w wVar, final VerifyPromoResultListener verifyPromoResultListener, String str2, String str3) {
        Context appContext = CJRJarvisApplication.getAppContext();
        String ssoToken = getSsoToken(appContext);
        JSONObject payIntentRequestBody = RequestHelper.getPayIntentRequestBody(str2);
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, ssoToken);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        a.a(appContext, a.C0216a.POST, str3, payIntentRequestBody.toString(), hashMap, new StringModel(), new b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                MallPGHelper.this.handleSetIntentResponse(str, ((StringModel) iJRPaytmDataModel).getData(), wVar, verifyPromoResultListener);
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                MallPGHelper.this.handleApplyPromoErrorResponse(verifyPromoResultListener, networkCustomError);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleSetIntentResponse(String str, String str2, w wVar, VerifyPromoResultListener verifyPromoResultListener) {
        if (isEmiSuccessResponse(str2)) {
            provideCallbackForPromoApply(wVar, str2);
        } else {
            provideCallbackForPromoApply(wVar, str);
        }
        if (verifyPromoResultListener != null) {
            verifyPromoResultListener.onVerifyPromoSuccess((CJPayMethodResponse) null, true, (PaytmSDKRequestClient.VerifyResponseData) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleApplyFreebie */
    public void lambda$openFreebieList$0$MallPGHelper(List<CJRPromoData> list, HashMap<Integer, Freebie> hashMap, final IFreebieApplyListener iFreebieApplyListener, final w wVar, String str) {
        Context appContext = CJRJarvisApplication.getAppContext();
        String ssoToken = getSsoToken(appContext);
        JSONObject applyFreebieRequestBody = RequestHelper.getApplyFreebieRequestBody(list, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(AppConstants.SSO_TOKEN, ssoToken);
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("Accept-Encoding", "gzip");
        a.a(appContext, a.C0216a.POST, str, applyFreebieRequestBody.toString(), hashMap2, new StringModel(), new b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                MallPGHelper.this.handleApplyFreebieSuccessResponse(((StringModel) iJRPaytmDataModel).getData(), wVar, iFreebieApplyListener);
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                iFreebieApplyListener.onFreebieApplyFailure(networkCustomError.getAlertMessage());
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleApplyFreebieSuccessResponse(String str, w wVar, IFreebieApplyListener iFreebieApplyListener) {
        provideCallbackForPromoApply(wVar, str);
        if (isSuccessResponse(str)) {
            iFreebieApplyListener.onFreebieApplySuccess(str);
        } else {
            iFreebieApplyListener.onFreebieApplyFailure(getErrorText(str));
        }
    }

    /* access modifiers changed from: private */
    public void getFreebieResponse(String str, final IFreebieJsonResponseListener iFreebieJsonResponseListener) {
        a.a(CJRJarvisApplication.getAppContext(), a.C0216a.POST, str, (String) null, (Map<String, String>) null, new StringModel(), new b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                MallPGHelper.this.handleFreebieListSuccessResponse(((StringModel) iJRPaytmDataModel).getData(), iFreebieJsonResponseListener);
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                MallPGHelper.this.handleFreebieListErrorResponse(networkCustomError, iFreebieJsonResponseListener);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleFreebieListErrorResponse(NetworkCustomError networkCustomError, IFreebieJsonResponseListener iFreebieJsonResponseListener) {
        iFreebieJsonResponseListener.onFreebieErrorResponse(networkCustomError.getAlertMessage());
    }

    /* access modifiers changed from: private */
    public void handleFreebieListSuccessResponse(String str, IFreebieJsonResponseListener iFreebieJsonResponseListener) {
        if (iFreebieJsonResponseListener != null) {
            iFreebieJsonResponseListener.onFreebieResponse(str);
        }
    }

    /* access modifiers changed from: private */
    public void requestPromoApplyApi(String str, final String str2, int i2, String str3, final VerifyPromoResultListener verifyPromoResultListener, final w wVar, String str4) {
        JSONObject jSONObject;
        Context appContext = CJRJarvisApplication.getAppContext();
        String ssoToken = getSsoToken(appContext);
        boolean isBankOffer = isBankOffer(str3);
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        if (!isBankOffer) {
            jSONObject = RequestHelper.getApplyPromoRequestBody(z, str, str2, "");
        } else if (z) {
            str4 = getEMIApplyPromoUrl(str4);
            jSONObject = RequestHelper.getPaymentFilterRequestBody(str3);
        } else {
            jSONObject = RequestHelper.getApplyPromoRequestBody(false, str, str2, "");
        }
        String str5 = str4;
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, ssoToken);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        a.a(appContext, a.C0216a.POST, str5, jSONObject.toString(), hashMap, new StringModel(), new b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                MallPGHelper.this.handleApplyPromoSuccessResponse(((StringModel) iJRPaytmDataModel).getData(), wVar, verifyPromoResultListener, str2);
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (MallPGHelper.this.isAuthError(i2)) {
                    MallPGHelper.this.handleAuthError(wVar, networkCustomError, verifyPromoResultListener);
                } else {
                    MallPGHelper.this.handleApplyPromoErrorResponse(verifyPromoResultListener, networkCustomError);
                }
            }
        });
    }

    public static String getEMIApplyPromoUrl(String str) {
        Uri uri;
        try {
            uri = Uri.parse(str);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            uri = null;
        }
        if (uri != null) {
            try {
                return uri.buildUpon().appendQueryParameter("fetch_emi_details", "1").build().toString();
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    public void handleAuthError(w wVar, NetworkCustomError networkCustomError, VerifyPromoResultListener verifyPromoResultListener) {
        handlePromoAPIErrorResponse("APPLY_PROMO_ERROR", wVar, networkCustomError);
        verifyPromoResultListener.onVerifyPromoError(Constants.AUTH_ERROR);
    }

    private boolean isBankOffer(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* access modifiers changed from: private */
    public void handleApplyPromoErrorResponse(VerifyPromoResultListener verifyPromoResultListener, NetworkCustomError networkCustomError) {
        if (verifyPromoResultListener != null) {
            verifyPromoResultListener.onVerifyPromoError(getErrorText(getErrorResponse(networkCustomError)));
        }
    }

    /* access modifiers changed from: private */
    public void handleApplyPromoSuccessResponse(String str, w wVar, VerifyPromoResultListener verifyPromoResultListener, String str2) {
        provideCallbackForPromoApply(wVar, str);
        if (isEmiSuccessResponse(str)) {
            verifyPromoResultListener.onVerifyPromoSuccess(getPaymentInstruments(str), true, getResponseParams(str, str2));
        } else {
            verifyPromoResultListener.onVerifyPromoError(getCartError(str));
        }
    }

    private PaytmSDKRequestClient.VerifyResponseData getResponseParams(String str, String str2) {
        PaytmSDKRequestClient.VerifyResponseData verifyResponseData = new PaytmSDKRequestClient.VerifyResponseData();
        verifyResponseData.setPaytmCashBack(getCartData(str, "paytm_cashback"));
        verifyResponseData.setPaytmDiscount(getCartData(str, "paytm_discount"));
        verifyResponseData.setMid(getMId(str));
        verifyResponseData.setFreebieItems(RequestHelper.getPromoDataArray(str, str2));
        verifyResponseData.setIs8DigitBin(is8DigitBin(str));
        return verifyResponseData;
    }

    private Boolean is8DigitBin(String str) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("cart");
        if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("promoMetaData")) == null || (optJSONObject2 = optJSONObject.optJSONObject("paymentData")) == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(optJSONObject2.optBoolean("is8DigitBin"));
    }

    private double getCartData(String str, String str2) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            jSONObject = null;
        }
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("cart")) == null) {
            return 0.0d;
        }
        return Double.parseDouble(String.valueOf(optJSONObject.optInt(str2)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = r2.optJSONObject("message");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getErrorText(java.lang.String r2) {
        /*
            r1 = this;
            org.json.JSONObject r2 = r1.getResponseObject(r2)
            if (r2 == 0) goto L_0x0013
            java.lang.String r0 = "message"
            org.json.JSONObject r2 = r2.optJSONObject(r0)
            if (r2 == 0) goto L_0x0013
            java.lang.String r2 = r2.optString(r0)
            goto L_0x0015
        L_0x0013:
            java.lang.String r2 = ""
        L_0x0015:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x001d
            java.lang.String r2 = "Something went wrong"
        L_0x001d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.mall.emiSubvention.nativepghelper.MallPGHelper.getErrorText(java.lang.String):java.lang.String");
    }

    private JSONObject getResponseObject(String str) {
        JSONObject convertToJson = convertToJson(str);
        return convertToJson != null ? convertToJson.optJSONObject("status") : new JSONObject();
    }

    private boolean isSuccessResponse(String str) {
        JSONObject responseObject = getResponseObject(str);
        return responseObject != null && "success".equalsIgnoreCase(responseObject.optString("result"));
    }

    private CJPayMethodResponse getPaymentInstruments(String str) {
        return RequestHelper.getPaymentInstruments(str);
    }

    private void provideCallbackForPromoApply(w wVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("APPLY_PROMO_SUCCESS", getJSONObject(str));
        invokeCallback(wVar, hashMap);
    }

    private HashMap<String, Object> getJSONObject(String str) {
        return (HashMap) new f().a(str, new com.google.gson.b.a<HashMap<String, Object>>() {
        }.getType());
    }

    public void applyManualPromo(Activity activity, String str, String str2, w wVar, boolean z) {
        String str3 = str2;
        w wVar2 = wVar;
        final String ssoToken = getSsoToken(activity);
        JSONObject applyPromoRequestBody = RequestHelper.getApplyPromoRequestBody(true, "", str3, "", true);
        invokeCallback(wVar2, showProgress(true));
        if (!d.a((Context) activity)) {
            handlePromoAPIErrorResponse("PROMO_ERROR", wVar2, (NetworkCustomError) null);
            return;
        }
        if (z) {
            ArrayList<PaymentIntent> paymentIntent = PromoHelper.Companion.getInstance().getPaymentIntent();
            String bankOfferPromoCode = PromoHelper.Companion.getInstance().getBankOfferPromoCode();
            if (paymentIntent != null && paymentIntent.size() > 0 && str3 != null && str3.equalsIgnoreCase(bankOfferPromoCode)) {
                requestPromoApplywithPayIntent("", str2, wVar, getPaymentIntent(paymentIntent), (VerifyPromoResultListener) null, str, true);
                return;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, ssoToken);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        final String str4 = str;
        final Activity activity2 = activity;
        final w wVar3 = wVar;
        final String str5 = str2;
        Activity activity3 = activity;
        a.a(activity3, a.C0216a.POST, getEMIApplyPromoUrl(getManualPromoUrl(str4)), applyPromoRequestBody.toString(), hashMap, new StringModel(), new b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                MallPGHelper.this.onManualPromoSuccess(activity2, ((StringModel) iJRPaytmDataModel).getData(), wVar3, ssoToken, str4, str5, iJRPaytmDataModel.getNetworkResponse());
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                MallPGHelper.this.handleManualPromoError(wVar3, networkCustomError);
            }
        });
    }

    private String getManualPromoUrl(String str) {
        return Uri.parse(str).buildUpon().appendQueryParameter("manual_promocode", "1").build().toString();
    }

    /* access modifiers changed from: private */
    public void handleManualPromoError(w wVar, NetworkCustomError networkCustomError) {
        handlePromoAPIErrorResponse("APPLY_PROMO_ERROR", wVar, networkCustomError);
    }

    /* access modifiers changed from: private */
    public void onManualPromoSuccess(Activity activity, String str, w wVar, String str2, String str3, String str4, NetworkResponse networkResponse) {
        if (!isSuccessResponse(str)) {
            provideCallbackForPromoApply(wVar, str);
        } else if (getPaymentInstruments(str) == null || !isBankOffer(str, str4)) {
            provideCallbackForPromoApply(wVar, str);
        } else {
            handleBankOffer(activity, wVar, str2, str, str3, str4, networkResponse);
        }
        invokeCallback(wVar, showProgress(false));
    }

    private boolean isBankOffer(String str, String str2) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("cart");
        if (optJSONObject4 == null || (optJSONObject = optJSONObject4.optJSONObject("promoMetaData")) == null || (optJSONObject2 = optJSONObject.optJSONObject("campData")) == null || (optJSONObject3 = optJSONObject2.optJSONObject(str2.toUpperCase())) == null) {
            return false;
        }
        return Constants.BANK_OFFER_KEY.equalsIgnoreCase(optJSONObject3.optString("campaignType"));
    }

    private void handleBankOffer(Activity activity, final w wVar, String str, String str2, final String str3, final String str4, NetworkResponse networkResponse) {
        CJPayMethodResponse paymentInstruments = getPaymentInstruments(str2);
        if (paymentInstruments == null || paymentInstruments.getBody() == null || paymentInstruments.getBody().getMerchantPayOption() == null) {
            showPromoError(wVar, activity.getResources().getString(R.string.error_message_manual_promo), networkResponse);
            return;
        }
        MerchantPayOption merchantPayOption = paymentInstruments.getBody().getMerchantPayOption();
        if ((merchantPayOption.getPaymentModes() == null || merchantPayOption.getPaymentModes().isEmpty()) && ((merchantPayOption.getSavedInstruments() == null || merchantPayOption.getSavedInstruments().isEmpty()) && (merchantPayOption.getUpiProfile() == null || merchantPayOption.getUpiProfile().getRespDetails() == null || merchantPayOption.getUpiProfile().getRespDetails().getProfileDetail() == null || merchantPayOption.getUpiProfile().getRespDetails().getProfileDetail().getBankAccounts() == null))) {
            showPromoError(wVar, activity.getResources().getString(R.string.error_message_manual_promo), networkResponse);
            return;
        }
        new NativeSdkPromoHelper(getMId(str2), str, Utility.VERTICAL_NAME_MALL).openPromoPayOptionsBottomSheet(FragmentActivity.class.cast(activity).getSupportFragmentManager(), getAmount(str2), paymentInstruments, getResponseParams(str2, ""), new VerifyPromoCallbackListener() {
            public void onPromoSelected(String str, int i2, String str2, VerifyPromoResultListener verifyPromoResultListener) {
            }

            public void onPaymentIntentSelected(String str, ArrayList<PaymentIntent> arrayList, String str2, VerifyPromoResultListener verifyPromoResultListener) {
                MallPGHelper mallPGHelper = MallPGHelper.this;
                mallPGHelper.requestPromoApplywithPayIntent("", str4, wVar, mallPGHelper.getPaymentIntent(arrayList), verifyPromoResultListener, str3, true);
            }

            public void clearPromoCode(String str, final PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
                MallPGHelper.this.removePaymentIntent(str3, wVar, new PaytmSDKRequestClient.OtherPayOptionsListener() {
                    public void setFetchPayOptionsResponse(CJPayMethodResponse cJPayMethodResponse, double d2) {
                        PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener = applyAnotherOfferListener;
                        if (applyAnotherOfferListener != null) {
                            applyAnotherOfferListener.onSuccess();
                        }
                    }

                    public void onError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                        PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener = applyAnotherOfferListener;
                        if (applyAnotherOfferListener != null) {
                            applyAnotherOfferListener.onError(apiResponseError);
                        }
                    }
                }, false);
            }
        });
    }

    private void showPromoError(w wVar, String str, NetworkResponse networkResponse) {
        handlePromoAPIErrorResponse("APPLY_PROMO_ERROR", wVar, getCustomError(str, networkResponse));
    }

    private NetworkCustomError getCustomError(String str, NetworkResponse networkResponse) {
        return new NetworkCustomError(networkResponse);
    }

    private String getMId(String str) {
        JSONObject optJSONObject;
        JSONObject convertToJson = convertToJson(str);
        if (convertToJson == null || (optJSONObject = convertToJson.optJSONObject(CJRRechargeCart.KEY_PAYMENT_INFO)) == null) {
            return "";
        }
        return optJSONObject.optString("mid");
    }

    private double getAmount(String str) {
        JSONObject optJSONObject;
        JSONObject convertToJson = convertToJson(str);
        if (convertToJson == null || (optJSONObject = convertToJson.optJSONObject(CJRRechargeCart.KEY_PAYMENT_INFO)) == null) {
            return 0.0d;
        }
        return optJSONObject.optJSONObject("txnAmount").optDouble("value");
    }

    public void doCheckout(Context context, PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse, CJRRechargePayment cJRRechargePayment, w wVar) {
        String str = cJRRechargePayment != null ? cJRRechargePayment.getmDelayedOrderPayload() : "";
        if (!TextUtils.isEmpty(str)) {
            String checkoutBody = getCheckoutBody(str, getPaymentIntent(callbackData.getPaymentIntents()), callbackData.getOfferBody(), callbackData.getEmiOffers());
            String stringFromJson = getStringFromJson(str, "url");
            String stringFromJson2 = getStringFromJson(str, "methods");
            HashMap<String, String> checkoutHeaders = getCheckoutHeaders(convertToJson(str));
            if ("POST".equalsIgnoreCase(stringFromJson2)) {
                doCheckout(context, a.C0216a.POST, stringFromJson, checkoutBody, checkoutHeaders, onCheckoutResponse, wVar);
            } else {
                doCheckout(context, a.C0216a.GET, stringFromJson, (String) null, checkoutHeaders, onCheckoutResponse, wVar);
            }
        }
    }

    private void doCheckout(Context context, a.C0216a aVar, String str, String str2, Map<String, String> map, final PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse, final w wVar) {
        a.a(context, aVar, str, str2, map, new StringModel(), new b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                MallPGHelper.this.handleCheckoutSuccessResponse(((StringModel) iJRPaytmDataModel).getData(), onCheckoutResponse);
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                MallPGHelper.this.handleCheckoutErrorResponse(networkCustomError, onCheckoutResponse, wVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleCheckoutErrorResponse(NetworkCustomError networkCustomError, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse, w wVar) {
        onCheckoutResponse.onCheckoutError(getApiError(networkCustomError, true));
        wVar.b(errorPromoResponse("CHECKOUT_ERROR", networkCustomError));
    }

    /* access modifiers changed from: private */
    public void handleCheckoutSuccessResponse(String str, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
        PaytmSDKRequestClient.CheckoutResponseData checkoutResponseData = new PaytmSDKRequestClient.CheckoutResponseData();
        checkoutResponseData.setCreateOrderResponse((CreateOrderResponse) new f().a(str, CreateOrderResponse.class));
        onCheckoutResponse.onCheckoutSuccess(checkoutResponseData);
    }

    private HashMap<String, String> getCheckoutHeaders(JSONObject jSONObject) {
        HashMap<String, Object> jSONObject2;
        HashMap<String, String> hashMap = new HashMap<>();
        if (!(jSONObject == null || (jSONObject2 = getJSONObject(jSONObject.optString("headers"))) == null)) {
            for (String next : jSONObject2.keySet()) {
                hashMap.put(next, String.valueOf(jSONObject2.get(next)));
            }
        }
        return hashMap;
    }

    private String getStringFromJson(String str, String str2) {
        JSONObject convertToJson = convertToJson(str);
        return convertToJson != null ? convertToJson.optString(str2) : "";
    }

    private String getCheckoutBody(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject convertToJson = convertToJson(str);
        if (convertToJson == null) {
            return "";
        }
        JSONObject optJSONObject = convertToJson.optJSONObject("body");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                optJSONObject.put("payment_intent", new JSONArray(str2));
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        }
        if (jSONObject != null) {
            try {
                optJSONObject.put("payment_offers_applied", jSONObject);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
        }
        if (jSONObject2 != null) {
            try {
                optJSONObject.put("emi_plans", jSONObject2);
            } catch (JSONException e4) {
                q.b(e4.getMessage());
            }
        }
        return optJSONObject.toString();
    }

    private JSONObject convertToJson(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public void removePaymentIntent(String str, final w wVar, final PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener, final boolean z) {
        Context appContext = CJRJarvisApplication.getAppContext();
        String ssoToken = getSsoToken(appContext);
        JSONObject removePayIntentBody = RequestHelper.getRemovePayIntentBody();
        if (!TextUtils.isEmpty(str) && removePayIntentBody != null && !"null".equalsIgnoreCase(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, ssoToken);
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Accept-Encoding", "gzip");
            a.a(appContext, a.C0216a.POST, str, removePayIntentBody.toString(), hashMap, new StringModel(), new b() {
                public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    MallPGHelper.this.handleRemoveIntentResponse(((StringModel) iJRPaytmDataModel).getData(), otherPayOptionsListener, wVar, z);
                }

                public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    MallPGHelper.this.handleRemoveIntentErrorResponse(networkCustomError, otherPayOptionsListener, wVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void handleRemoveIntentErrorResponse(NetworkCustomError networkCustomError, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener, w wVar) {
        if (otherPayOptionsListener != null) {
            otherPayOptionsListener.onError(getApiError(networkCustomError, false));
            if (wVar != null) {
                wVar.b(errorPromoResponse("REMOVE_INTENT", networkCustomError));
            }
        }
    }

    private PaytmSDKRequestClient.ApiResponseError getApiError(NetworkCustomError networkCustomError, boolean z) {
        String str;
        JSONObject convertToJson = convertToJson(getErrorResponse(networkCustomError));
        String str2 = "";
        if (convertToJson != null) {
            str2 = convertToJson.optString("error");
            str = convertToJson.optString("error_title");
        } else {
            str = str2;
        }
        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
        apiResponseError.setShouldClosePG(z);
        apiResponseError.setStatusCode(networkCustomError.getStatusCode());
        apiResponseError.setErrorTitle(str);
        apiResponseError.setErrorMsg(str2);
        try {
            String errorResponse = errorResponse(networkCustomError);
            if (!TextUtils.isEmpty(errorResponse)) {
                JSONObject jSONObject = new JSONObject(errorResponse);
                if (jSONObject.has("additional_info")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("additional_info");
                    if (jSONObject2.has("closePgWithoutError")) {
                        apiResponseError.setClosePgWithoutError(jSONObject2.getBoolean("closePgWithoutError"));
                    }
                }
            }
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return apiResponseError;
    }

    private String errorResponse(NetworkCustomError networkCustomError) {
        if (networkCustomError == null) {
            return "";
        }
        try {
            if (networkCustomError.getNetworkResponse() == null || networkCustomError.getNetworkResponse().data == null) {
                return "";
            }
            String str = networkCustomError.getNetworkResponse().headers.get("Content-Encoding");
            if (TextUtils.isEmpty(str) || !"gzip".equalsIgnoreCase(str)) {
                return new String(networkCustomError.getNetworkResponse().data);
            }
            return GzipUtils.convertString(GzipUtils.convertReader(networkCustomError.getNetworkResponse().data));
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public void handleRemoveIntentResponse(String str, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener, w wVar, boolean z) {
        CJPayMethodResponse paymentInstruments = getPaymentInstruments(str);
        boolean z2 = paymentInstruments != null;
        if (!z || z2) {
            if (otherPayOptionsListener != null) {
                otherPayOptionsListener.setFetchPayOptionsResponse(paymentInstruments, getAmount(str));
            }
            if (wVar != null) {
                wVar.b(Collections.singletonMap("REMOVE_INTENT", getJSONObject(str)));
            }
        } else {
            otherPayOptionsListener.onError(getCustomApiError(true));
            handleInvalidInstrument(wVar);
        }
        resetPaymentIntent();
    }

    private PaytmSDKRequestClient.ApiResponseError getCustomApiError(boolean z) {
        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
        apiResponseError.setShouldClosePG(z);
        apiResponseError.setStatusCode(200);
        apiResponseError.setErrorTitle("Error");
        apiResponseError.setErrorMsg("Unable to fetchPaymentInstruments");
        return apiResponseError;
    }

    public static boolean isPaymentIntentPresent() {
        return new NativeSdkPromoHelper("", "", Utility.VERTICAL_NAME_MALL).isPaymentIntentPresent();
    }

    public static void resetPaymentIntent() {
        new NativeSdkPromoHelper("", "", Utility.VERTICAL_NAME_MALL).resetPaymentIntent();
    }

    private String getErrorResponse(NetworkCustomError networkCustomError) {
        return (networkCustomError == null || networkCustomError.networkResponse == null || networkCustomError.networkResponse.data == null) ? "" : new String(networkCustomError.networkResponse.data);
    }

    public void fetchTenures(BankData bankData, ArrayList<PaymentIntent> arrayList, JSONObject jSONObject, final ISubventionProvider.IBankTenureListener iBankTenureListener, String str, final Context context, final w wVar) {
        Context context2 = context;
        String str2 = str;
        a.a(context2, a.C0216a.POST, str2, getTenureRequestBody(bankData, arrayList, jSONObject), getHeaders(), new StringModel(), new b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                String data = ((StringModel) iJRPaytmDataModel).getData();
                if (!MallPGHelper.this.isEmiSuccessResponse(data)) {
                    iBankTenureListener.onBankError("Error", MallPGHelper.this.getCartError(data));
                } else if (!MallPGHelper.this.isTenurePresent(data)) {
                    ISubventionProvider.IBankTenureListener iBankTenureListener = iBankTenureListener;
                    if (iBankTenureListener != null) {
                        iBankTenureListener.onBankError(context.getString(R.string.no_tenure_heading), context.getString(R.string.no_tenure_content));
                    }
                } else {
                    ISubventionProvider.IBankTenureListener iBankTenureListener2 = iBankTenureListener;
                    if (iBankTenureListener2 != null) {
                        iBankTenureListener2.onBankSuccessResponse(data);
                    }
                }
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                MallPGHelper.this.handleEmiError(iBankTenureListener, networkCustomError, wVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean isTenurePresent(String str) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject convertToJson = convertToJson(str);
        if (convertToJson == null || (optJSONObject = convertToJson.optJSONObject("emi_plans")) == null || (optJSONArray = optJSONObject.optJSONArray("details")) == null || optJSONArray.length() <= 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean isEmiSuccessResponse(String str) {
        return TextUtils.isEmpty(getCartError(str));
    }

    /* access modifiers changed from: private */
    public String getCartError(String str) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            jSONObject = null;
        }
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("cart")) == null) {
            return "";
        }
        try {
            return optJSONObject.getString("error");
        } catch (NumberFormatException e3) {
            q.b(e3.getMessage());
            return "";
        } catch (JSONException e4) {
            q.b(e4.getMessage());
            return "";
        }
    }

    private String getTenureRequestBody(BankData bankData, ArrayList<PaymentIntent> arrayList, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.putOpt("action", "setemifilter");
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        if (jSONObject != null) {
            try {
                jSONObject2.putOpt("payment_offers_applied", jSONObject);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
        }
        if (bankData != null) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.putOpt("bankCode", bankData.getBankCode());
                jSONObject4.putOpt("cardType", bankData.getCardType());
                jSONObject2.putOpt("emi_filters", jSONObject4);
            } catch (JSONException e4) {
                q.b(e4.getMessage());
            }
        }
        if (arrayList != null) {
            try {
                jSONObject2.put("payment_intent", new JSONArray(new f().b(arrayList)));
            } catch (JSONException e5) {
                q.b(e5.getMessage());
            }
        }
        try {
            jSONObject3.putOpt("object", jSONObject2);
        } catch (JSONException e6) {
            q.b(e6.getMessage());
        }
        return jSONObject3.toString();
    }

    public void getBanks(final ISubventionProvider.IBankListener iBankListener, String str, final w wVar) {
        a.a(CJRJarvisApplication.getAppContext(), a.C0216a.GET, getBanksUrl(str), (String) null, getHeaders(), new StringModel(), new b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                String data = ((StringModel) iJRPaytmDataModel).getData();
                if (MallPGHelper.this.isEmiSuccessResponse(data)) {
                    ISubventionProvider.IBankListener iBankListener = iBankListener;
                    if (iBankListener != null) {
                        iBankListener.onBankSuccessResponse(data);
                        return;
                    }
                    return;
                }
                iBankListener.onBankError("Error", MallPGHelper.this.getCartError(data));
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                MallPGHelper.this.handleEmiError(iBankListener, networkCustomError, wVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleEmiError(ISubventionProvider.IBankErrorListener iBankErrorListener, NetworkCustomError networkCustomError, w wVar) {
        wVar.b(errorPromoResponse("CHECKOUT_ERROR", networkCustomError));
        iBankErrorListener.onBankNetworkError(getEmiApiError(networkCustomError));
    }

    private PaytmSDKRequestClient.ApiResponseError getEmiApiError(NetworkCustomError networkCustomError) {
        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
        apiResponseError.setShouldClosePG(true);
        apiResponseError.setStatusCode(networkCustomError.getStatusCode());
        apiResponseError.setErrorTitle(getErrorTitle(getErrorResponse(networkCustomError)));
        apiResponseError.setErrorMsg(getErrorText(getErrorResponse(networkCustomError)));
        return apiResponseError;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = r2.optJSONObject("message");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getErrorTitle(java.lang.String r2) {
        /*
            r1 = this;
            org.json.JSONObject r2 = r1.getResponseObject(r2)
            if (r2 == 0) goto L_0x0016
            java.lang.String r0 = "message"
            org.json.JSONObject r2 = r2.optJSONObject(r0)
            if (r2 == 0) goto L_0x0016
            java.lang.String r0 = "title"
            java.lang.String r2 = r2.optString(r0)
            goto L_0x0018
        L_0x0016:
            java.lang.String r2 = ""
        L_0x0018:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0020
            java.lang.String r2 = "Error"
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.mall.emiSubvention.nativepghelper.MallPGHelper.getErrorTitle(java.lang.String):java.lang.String");
    }

    private String getBanksUrl(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("emi_bank_details", "1").build().toString();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    private Map<String, String> getHeaders() {
        return new HashMap<String, String>() {
            {
                put(AppConstants.SSO_TOKEN, MallPGHelper.this.getSsoToken(CJRJarvisApplication.getAppContext()));
                put("Content-Type", "application/json");
            }
        };
    }

    public void showBottomSheet(Context context, String str, Double d2, String str2) {
        EMIOrderReviewFragment eMIOrderReviewFragment = new EMIOrderReviewFragment();
        eMIOrderReviewFragment.setArguments(EMIOrderReviewFragment.getDataBundle(str, str2, d2));
        eMIOrderReviewFragment.show(((FragmentActivity) context).getSupportFragmentManager(), eMIOrderReviewFragment.getTag());
    }

    public void validateTenurePlan(String str, String str2, final ISubventionProvider.IBankValidator iBankValidator, ArrayList<PaymentIntent> arrayList, JSONObject jSONObject, String str3, final w wVar) {
        final String str4;
        String validateTenureRequestBody = getValidateTenureRequestBody(str, str2, arrayList, jSONObject);
        try {
            str4 = getEmiCheckoutBody(validateTenureRequestBody);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            str4 = null;
        }
        a.a(CJRJarvisApplication.getAppContext(), a.C0216a.POST, str3, validateTenureRequestBody, getHeaders(), new StringModel(), new b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                String data = ((StringModel) iJRPaytmDataModel).getData();
                if (MallPGHelper.this.isEmiSuccessResponse(data)) {
                    ISubventionProvider.IBankValidator iBankValidator = iBankValidator;
                    if (iBankValidator != null) {
                        iBankValidator.onBankSuccessResponse(str4, data, MallPGHelper.this.getFinalPrice(data));
                        return;
                    }
                    return;
                }
                iBankValidator.onBankError("Error", MallPGHelper.this.getCartError(data));
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                MallPGHelper.this.handleEmiError(iBankValidator, networkCustomError, wVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public String getFinalPrice(String str) {
        CJRCart cart;
        CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) com.paytmmall.artifact.e.a.a(str, CJRShoppingCart.class);
        if (cJRShoppingCart == null || (cart = cJRShoppingCart.getCart()) == null) {
            return "";
        }
        String finalPrice = cart.getFinalPrice();
        if (TextUtils.isEmpty(finalPrice)) {
            return "";
        }
        return finalPrice;
    }

    private String getEmiCheckoutBody(String str) throws JSONException {
        JSONObject optJSONObject = new JSONObject(str).optJSONObject("object");
        JSONObject jSONObject = optJSONObject != null ? optJSONObject.getJSONObject("emi_plans") : null;
        return jSONObject != null ? jSONObject.toString() : "";
    }

    private String getValidateTenureRequestBody(String str, String str2, ArrayList<PaymentIntent> arrayList, JSONObject jSONObject) {
        HashMap<String, ItemBreakup> emiOffers;
        ItemBreakup itemBreakup;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (str2 != null) {
            try {
                jSONObject2.put("plan_id", str2);
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        }
        CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) com.paytmmall.artifact.e.a.a(str, CJRShoppingCart.class);
        ArrayList<CJRCartProduct> arrayList2 = null;
        if (!(cJRShoppingCart == null || cJRShoppingCart.getCart() == null || cJRShoppingCart.getCart().getCartItems() == null)) {
            arrayList2 = cJRShoppingCart.getCart().getCartItems();
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                if (!(arrayList2.get(i2) == null || arrayList2.get(i2).getEmiOffers() == null || (emiOffers = arrayList2.get(i2).getEmiOffers()) == null || (itemBreakup = emiOffers.get(str2)) == null)) {
                    JSONObject jSONObject4 = new JSONObject();
                    try {
                        if (itemBreakup.getOfferId() != null) {
                            jSONObject4.putOpt("offer_id", itemBreakup.getOfferId());
                        }
                        jSONObject3.putOpt(arrayList2.get(i2).getItemID(), jSONObject4);
                    } catch (JSONException e3) {
                        q.b(e3.getMessage());
                    }
                }
            }
        }
        try {
            jSONObject2.putOpt("item_map", jSONObject3);
        } catch (JSONException e4) {
            q.b(e4.getMessage());
        }
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        try {
            jSONObject5.putOpt("action", "setemiplan");
        } catch (JSONException e5) {
            q.b(e5.getMessage());
        }
        try {
            jSONObject6.put("emi_plans", jSONObject2);
        } catch (JSONException e6) {
            q.b(e6.getMessage());
        }
        if (jSONObject != null) {
            try {
                jSONObject6.putOpt("payment_offers_applied", jSONObject);
            } catch (JSONException e7) {
                q.b(e7.getMessage());
            }
        }
        if (arrayList != null) {
            try {
                jSONObject6.put("payment_intent", new JSONArray(new f().b(arrayList)));
            } catch (JSONException e8) {
                q.b(e8.getMessage());
            }
        }
        try {
            jSONObject5.put("object", jSONObject6);
        } catch (JSONException e9) {
            q.b(e9.getMessage());
        }
        return jSONObject5.toString();
    }
}
