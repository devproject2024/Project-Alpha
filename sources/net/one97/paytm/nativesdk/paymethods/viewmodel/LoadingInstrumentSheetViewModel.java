package net.one97.paytm.nativesdk.paymethods.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.FetchOptionsRequest;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.listeners.SetOnAlertButtonListeners;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.fetchMerchantInfo.Body;
import net.one97.paytm.nativesdk.common.model.fetchMerchantInfo.MerchantInfo;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.paymethods.listeners.FetchPayInstrumentsListener;

public class LoadingInstrumentSheetViewModel {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public FetchPayInstrumentsListener mFetchPayInstrumentsListener;

    public LoadingInstrumentSheetViewModel(Context context2, FetchPayInstrumentsListener fetchPayInstrumentsListener) {
        this.mFetchPayInstrumentsListener = fetchPayInstrumentsListener;
        this.context = context2;
        if (MerchantBL.getMerchantInstance().isAppInvoke()) {
            mapMerchantSSO();
        } else {
            callFetchPayAndVpa();
        }
    }

    private void mapMerchantSSO() {
        Request mappingRequest = getMappingRequest();
        mappingRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        executeRequest(mappingRequest);
    }

    /* access modifiers changed from: private */
    public void callFetchPayAndVpa() {
        callFetchPayAPI();
    }

    /* access modifiers changed from: private */
    public void executeRequest(final Request request) {
        Context context2 = this.context;
        if (context2 != null) {
            if (SDKUtility.isNetworkAvailable(context2)) {
                VolleyRequestQueue.getInstance(this.context).addToRequestQueue(request);
                return;
            }
            Context context3 = this.context;
            DialogUtility.showTwoButtonDialogNew(context3, context3.getResources().getString(R.string.no_connection), this.context.getResources().getString(R.string.no_internet), "Retry", "Exit", new SetOnAlertButtonListeners() {
                public void onPositiveClicked() {
                    LoadingInstrumentSheetViewModel.this.executeRequest(request);
                }

                public void onNegativeClicked() {
                    if (PaytmSDK.getCallbackListener() != null) {
                        PaytmSDK.getCallbackListener().networkError();
                    }
                    a.a(LoadingInstrumentSheetViewModel.this.context.getApplicationContext()).a(new Intent("kill"));
                }
            });
        }
    }

    private Request getMappingRequest() {
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, NativeSdkGtmLoader.getMapingRequest(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()), (Map<String, String>) null, (Map<String, String>) null, APIReqtGenerator.createJsonForMerchantMapping(MerchantBL.getMerchantInstance().getOrderId(), MerchantBL.getMerchantInstance().getMid()), new Response.Listener() {
            public void onResponse(Object obj) {
                if (obj instanceof MerchantInfo) {
                    Body body = ((MerchantInfo) obj).getBody();
                    if (body == null || !body.getAppInvokeAllowed().booleanValue()) {
                        LoadingInstrumentSheetViewModel loadingInstrumentSheetViewModel = LoadingInstrumentSheetViewModel.this;
                        loadingInstrumentSheetViewModel.sendErrorMessageCallback(loadingInstrumentSheetViewModel.context.getResources().getString(R.string.invoke_error_message));
                        if (SDKUtility.isAppInvokeFlow()) {
                            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Merchant Info"));
                            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, "App Invoke not allowed"));
                            return;
                        }
                        return;
                    }
                    MerchantBL.getMerchantInstance().setCallbackUrl(body.getCallbackUrl());
                    LoadingInstrumentSheetViewModel.this.callFetchPayAndVpa();
                    MerchantBL.getMerchantInstance().setMerchantInfoResp(body.getMerchantInfoResp());
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                LoadingInstrumentSheetViewModel loadingInstrumentSheetViewModel = LoadingInstrumentSheetViewModel.this;
                loadingInstrumentSheetViewModel.sendErrorMessageCallback(loadingInstrumentSheetViewModel.context.getResources().getString(R.string.merchant_info_error_message));
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Merchant Info"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                }
            }
        }, MerchantInfo.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 2, 1.0f));
        return volleyPostRequest;
    }

    /* access modifiers changed from: private */
    public void sendNetworkErrorCallback() {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().networkError();
        }
        Context context2 = this.context;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
            return;
        }
        Intent intent = new Intent("kill");
        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
        a.a(this.context.getApplicationContext()).a(intent);
    }

    /* access modifiers changed from: private */
    public void sendErrorMessageCallback(String str) {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onTransactionCancel(str);
        }
        Context context2 = this.context;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
            return;
        }
        Intent intent = new Intent("kill");
        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
        a.a(this.context.getApplicationContext()).a(intent);
    }

    private void callFetchPayAPI() {
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    LoadingInstrumentSheetViewModel.this.sendNetworkErrorCallback();
                }
            });
            return;
        }
        if (TextUtils.isEmpty(MerchantBL.getMerchantInstance().getMid()) || TextUtils.isEmpty(MerchantBL.getMerchantInstance().getOrderId()) || TextUtils.isEmpty(MerchantBL.getMerchantInstance().getToken())) {
            sendNetworkErrorCallback();
        }
        FetchOptionsRequest fetchOptionsRequest = new FetchOptionsRequest(this.context, MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), MerchantBL.getMerchantInstance().getToken(), (FetchPayOptionsListener) new FetchPayOptionsListener() {
            public void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
            }

            public void onRequestStart() {
            }

            public void onVpaReceived(VpaFetch vpaFetch) {
            }

            public void onPaymentOptionsError() {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Pay Options"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, "Failed to communicate with Server"));
                }
                DialogUtility.showTwoButtonDialogNew(LoadingInstrumentSheetViewModel.this.context, LoadingInstrumentSheetViewModel.this.context.getResources().getString(R.string.alert), LoadingInstrumentSheetViewModel.this.context.getResources().getString(R.string.server_communication_failed), "Retry", "Exit", new SetOnAlertButtonListeners() {
                    public void onPositiveClicked() {
                        LoadingInstrumentSheetViewModel.this.callFetchPayAndVpa();
                    }

                    public void onNegativeClicked() {
                        if (PaytmSDK.getCallbackListener() != null) {
                            PaytmSDK.getCallbackListener().networkError();
                        }
                        a.a(LoadingInstrumentSheetViewModel.this.context.getApplicationContext()).a(new Intent("kill"));
                    }
                });
            }

            public void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
                PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
                LoadingInstrumentSheetViewModel.this.mFetchPayInstrumentsListener.onResponseReceived(cJPayMethodResponse);
            }
        });
        fetchOptionsRequest.setApplyPaymentOffer(true);
        fetchOptionsRequest.setFetchAllPaymentOffers(true);
        fetchOptionsRequest.executeRequest();
    }

    private void getMappingSSOV1() {
        Request merchantInfoV1 = getMerchantInfoV1();
        merchantInfoV1.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        executeRequest(merchantInfoV1);
    }

    private Request getMerchantInfoV1() {
        return new VolleyPostRequest(1, NativeSdkGtmLoader.getMapingRequestV1(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()), (Map<String, String>) null, (Map<String, String>) null, APIReqtGenerator.createJsonForMerchantMapping(MerchantBL.getMerchantInstance().getOrderId(), MerchantBL.getMerchantInstance().getMid()), new Response.Listener() {
            public void onResponse(Object obj) {
                if (obj instanceof MerchantInfo) {
                    Body body = ((MerchantInfo) obj).getBody();
                    if (body == null || !body.getAppInvokeAllowed().booleanValue()) {
                        LoadingInstrumentSheetViewModel.this.sendNetworkErrorCallback();
                        if (SDKUtility.isAppInvokeFlow()) {
                            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Merchant Info"));
                            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, "App Invoke not allowed"));
                            return;
                        }
                        return;
                    }
                    MerchantBL.getMerchantInstance().setCallbackUrl((String) null);
                    MerchantBL.getMerchantInstance().setMerchantInfoResp(body.getMerchantInfoResp());
                    LoadingInstrumentSheetViewModel.this.mFetchPayInstrumentsListener.onResponseReceived(DirectPaymentBL.getInstance().getCjPayMethodResponse());
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                LoadingInstrumentSheetViewModel.this.sendNetworkErrorCallback();
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Merchant Info"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                }
            }
        }, MerchantInfo.class);
    }
}
