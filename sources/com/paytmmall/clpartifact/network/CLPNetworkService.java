package com.paytmmall.clpartifact.network;

import android.content.Context;
import android.text.TextUtils;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.o;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.TimeUtils;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import java.util.HashMap;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public class CLPNetworkService {
    private static final String TAG = "CLPNetworkService";

    public interface Callback<T> {
        void onError();

        void onSuccess();
    }

    public interface IResponseListener {
        void onError(VolleyError volleyError);

        void onSuccess(String str, o oVar);
    }

    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    public void fetch(Context context, final String str, int i2, String str2, HashMap<String, String> hashMap, final IResponseListener iResponseListener) {
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        String str3 = "";
        String sSOToken = communicationListener != null ? communicationListener.getSSOToken(context) : str3;
        if (communicationListener != null) {
            str3 = communicationListener.getUserId(context);
        }
        if (!TextUtils.isEmpty(sSOToken) && i2 == 0) {
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put("user_id", str3);
        }
        b bVar = new b();
        bVar.f42877a = context;
        bVar.f42878b = a.c.MALL;
        bVar.f42879c = getMethod(i2);
        bVar.n = a.b.SILENT;
        bVar.o = context.getClass().getSimpleName();
        bVar.f42880d = str;
        bVar.f42885i = new StringResponseModel();
        bVar.f42884h = str2;
        bVar.f42882f = hashMap;
        bVar.j = new com.paytm.network.listener.b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof StringResponseModel) {
                    CLPNetworkService.this.handleSuccessResponse((StringResponseModel) iJRPaytmDataModel, iResponseListener, str);
                }
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                CLPNetworkService.this.handleErrorResponse(iResponseListener, networkCustomError);
            }
        };
        a l = bVar.l();
        l.f42859c = false;
        l.a();
    }

    /* access modifiers changed from: private */
    public void handleErrorResponse(IResponseListener iResponseListener, NetworkCustomError networkCustomError) {
        if (iResponseListener != null) {
            iResponseListener.onError(getVolleyError(networkCustomError));
        }
    }

    private VolleyError getVolleyError(NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            return new VolleyError(getNetworkResponse(networkCustomError.networkResponse));
        }
        return null;
    }

    private NetworkResponse getNetworkResponse(com.paytm.network.model.NetworkResponse networkResponse) {
        if (networkResponse != null) {
            return new NetworkResponse(networkResponse.statusCode, networkResponse.data, networkResponse.headers, networkResponse.notModified, networkResponse.networkTimeMs);
        }
        return null;
    }

    private a.C0715a getMethod(int i2) {
        if (i2 == 0) {
            return a.C0715a.GET;
        }
        if (i2 != 1) {
            return a.C0715a.GET;
        }
        return a.C0715a.POST;
    }

    private Response.ErrorListener getErrorResponseListener(IResponseListener iResponseListener) {
        return new Response.ErrorListener(iResponseListener) {
            private final /* synthetic */ CLPNetworkService.IResponseListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onErrorResponse(VolleyError volleyError) {
                CLPNetworkService.this.lambda$getErrorResponseListener$0$CLPNetworkService(this.f$1, volleyError);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: handleErrorResponse */
    public void lambda$getErrorResponseListener$0$CLPNetworkService(VolleyError volleyError, IResponseListener iResponseListener) {
        if (iResponseListener != null) {
            iResponseListener.onError(volleyError);
        }
    }

    /* access modifiers changed from: private */
    public void handleSuccessResponse(StringResponseModel stringResponseModel, IResponseListener iResponseListener, String str) {
        com.paytm.network.model.NetworkResponse networkResponse = stringResponseModel.getNetworkResponse();
        if (!(networkResponse == null || networkResponse.headers == null || !networkResponse.headers.containsKey(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR))) {
            TimeUtils.setServerTime(networkResponse.headers.get(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR));
        }
        if (iResponseListener != null) {
            iResponseListener.onSuccess(stringResponseModel.getRawResponse(), new o());
        }
    }
}
