package com.paytmmall.clpartifact.repositories;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.a.a;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.o;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.modal.cart.CJRCartResponse;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.threading.Task;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.utils.UrlUtils;
import com.paytmmall.clpartifact.utils.ValidateViewResponse;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CLPRepository {
    private static final String TAG = "CLPRepository";
    private final Context context = CLPArtifact.getInstance().getContext();
    private final CLPNetworkService networkService = new CLPNetworkService();

    public interface IErrorResponseListener {
        void onError(String str);
    }

    public interface ISuccessResponseListener {
        void onSuccess(String str, o oVar);
    }

    private int getMethodForCLP() {
        return 1;
    }

    public void applyFollow(String str, String str2, HashMap<String, String> hashMap, final ISuccessResponseListener iSuccessResponseListener, final IErrorResponseListener iErrorResponseListener) {
        try {
            this.networkService.fetch(this.context, str, getMethodForCLP(), str2, hashMap, new CLPNetworkService.IResponseListener() {
                public void onSuccess(String str, o oVar) {
                    ISuccessResponseListener iSuccessResponseListener = iSuccessResponseListener;
                    if (iSuccessResponseListener != null) {
                        iSuccessResponseListener.onSuccess(str, oVar);
                    }
                }

                public void onError(VolleyError volleyError) {
                    IErrorResponseListener iErrorResponseListener = iErrorResponseListener;
                    if (iErrorResponseListener != null) {
                        CLPRepository cLPRepository = CLPRepository.this;
                        iErrorResponseListener.onError(cLPRepository.getErrorMessage(cLPRepository.getErrorJsonObject(volleyError)));
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void applyRating(String str, String str2, HashMap<String, String> hashMap, final ISuccessResponseListener iSuccessResponseListener, final IErrorResponseListener iErrorResponseListener) {
        try {
            this.networkService.fetch(this.context, str, getMethodForCLP(), str2, hashMap, new CLPNetworkService.IResponseListener() {
                public void onSuccess(String str, o oVar) {
                    ISuccessResponseListener iSuccessResponseListener = iSuccessResponseListener;
                    if (iSuccessResponseListener != null) {
                        iSuccessResponseListener.onSuccess(str, oVar);
                    }
                }

                public void onError(VolleyError volleyError) {
                    IErrorResponseListener iErrorResponseListener = iErrorResponseListener;
                    if (iErrorResponseListener != null) {
                        CLPRepository cLPRepository = CLPRepository.this;
                        iErrorResponseListener.onError(cLPRepository.getErrorMessage(cLPRepository.getErrorJsonObject(volleyError)));
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public String getErrorMessage(JSONObject jSONObject) {
        return jSONObject != null ? jSONObject.optString("message") : "";
    }

    /* access modifiers changed from: private */
    public JSONObject getErrorJsonObject(VolleyError volleyError) {
        if (volleyError != null) {
            try {
                if (!(volleyError.networkResponse == null || volleyError.networkResponse.data == null || volleyError.networkResponse.data.length <= 0)) {
                    return new JSONObject(new String(volleyError.networkResponse.data));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    public void fetchReviews(String str, String str2, HashMap<String, String> hashMap, final ISuccessResponseListener iSuccessResponseListener, final IErrorResponseListener iErrorResponseListener) {
        try {
            this.networkService.fetch(this.context, str, getMethodForCLP(), str2, hashMap, new CLPNetworkService.IResponseListener() {
                public void onSuccess(String str, o oVar) {
                    ISuccessResponseListener iSuccessResponseListener = iSuccessResponseListener;
                    if (iSuccessResponseListener != null) {
                        iSuccessResponseListener.onSuccess(str, oVar);
                    }
                }

                public void onError(VolleyError volleyError) {
                    IErrorResponseListener iErrorResponseListener = iErrorResponseListener;
                    if (iErrorResponseListener != null) {
                        CLPRepository cLPRepository = CLPRepository.this;
                        iErrorResponseListener.onError(cLPRepository.getErrorMessage(cLPRepository.getErrorJsonObject(volleyError)));
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void reportReview(String str, String str2, HashMap<String, String> hashMap, final ISuccessResponseListener iSuccessResponseListener, final IErrorResponseListener iErrorResponseListener) {
        try {
            this.networkService.fetch(this.context, str, getMethodForCLP(), str2, hashMap, new CLPNetworkService.IResponseListener() {
                public void onSuccess(String str, o oVar) {
                    ISuccessResponseListener iSuccessResponseListener = iSuccessResponseListener;
                    if (iSuccessResponseListener != null) {
                        iSuccessResponseListener.onSuccess(str, oVar);
                    }
                }

                public void onError(VolleyError volleyError) {
                    IErrorResponseListener iErrorResponseListener = iErrorResponseListener;
                    if (iErrorResponseListener != null) {
                        CLPRepository cLPRepository = CLPRepository.this;
                        iErrorResponseListener.onError(cLPRepository.getErrorMessage(cLPRepository.getErrorJsonObject(volleyError)));
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void search(String str, HashMap<String, String> hashMap, final ISuccessResponseListener iSuccessResponseListener, final IErrorResponseListener iErrorResponseListener) {
        try {
            this.networkService.fetch(this.context, str, 0, "", hashMap, new CLPNetworkService.IResponseListener() {
                public void onSuccess(String str, o oVar) {
                    ISuccessResponseListener iSuccessResponseListener = iSuccessResponseListener;
                    if (iSuccessResponseListener != null) {
                        iSuccessResponseListener.onSuccess(str, oVar);
                    }
                }

                public void onError(VolleyError volleyError) {
                    IErrorResponseListener iErrorResponseListener = iErrorResponseListener;
                    if (iErrorResponseListener != null) {
                        CLPRepository cLPRepository = CLPRepository.this;
                        iErrorResponseListener.onError(cLPRepository.getErrorMessage(cLPRepository.getErrorJsonObject(volleyError)));
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void loadInitial(String str, CLPNetworkService.IResponseListener iResponseListener) {
        try {
            this.networkService.fetch(this.context, UrlUtils.appendQueryParameter(UrlUtils.appendChildSiteId(str), "user_id", CLPArtifact.getInstance().getCommunicationListener().getUserId(this.context)), getMethodForCLP(), getBodyForCLP(), getHeadersForCLP(), iResponseListener);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private HashMap<String, String> getHeadersForCLP() {
        HashMap<String, String> hashMap = new HashMap<>();
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        if (communicationListener != null) {
            hashMap.put(AppConstants.SSO_TOKEN, communicationListener.getSSOToken(this.context));
        }
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    private String getBodyForCLP() {
        return CLPArtifact.getInstance().getCommunicationListener().postRequestBodyForV2();
    }

    public void getGridResponse(Context context2, String str, HashMap<String, String> hashMap, String str2, CLPNetworkService.IResponseListener iResponseListener) {
        this.networkService.fetch(context2, UrlUtils.appendQueryParameter(str, "user_id", CLPArtifact.getInstance().getCommunicationListener().getUserId(context2)), 1, str2, hashMap, iResponseListener);
    }

    public void getStoreResponse(Context context2, String str, HashMap<String, String> hashMap, String str2, CLPNetworkService.IResponseListener iResponseListener) {
        this.networkService.fetch(context2, str, 0, str2, hashMap, iResponseListener);
    }

    public void loadCartDetails(final Context context2) {
        final ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, communicationListener.getSSOToken(context2));
        this.networkService.fetch(CLPArtifact.getInstance().getContext(), UrlUtils.getCartUrl(context2), 0, (String) null, hashMap, new CLPNetworkService.IResponseListener() {
            public void onSuccess(String str, o oVar) {
                Task.runOnComputation(new Runnable(str, context2, communicationListener) {
                    private final /* synthetic */ String f$0;
                    private final /* synthetic */ Context f$1;
                    private final /* synthetic */ ICLPCommunicationListener f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        CLPRepository.AnonymousClass6.lambda$onSuccess$1(this.f$0, this.f$1, this.f$2);
                    }
                });
            }

            static /* synthetic */ void lambda$onSuccess$1(String str, Context context, ICLPCommunicationListener iCLPCommunicationListener) {
                try {
                    CJRCartResponse cJRCartResponse = (CJRCartResponse) CLPUtils.getGson().a(str, CJRCartResponse.class);
                    if (cJRCartResponse != null) {
                        CLPArtifact.getInstance().getCommunicationListener().setCartId(context, cJRCartResponse.getCart().getCartId());
                        CartUtils.setCartItem(str);
                        Task.runOnMainThread(new Runnable(context, str) {
                            private final /* synthetic */ Context f$1;
                            private final /* synthetic */ String f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                ICLPCommunicationListener.this.onCartChanged(this.f$1, this.f$2);
                            }
                        });
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            public void onError(VolleyError volleyError) {
                LogUtils.d(CLPRepository.TAG, "OnCartLoaded Failed");
            }
        });
    }

    public void updateCart(final Context context2, long j, int i2) {
        a.a(context2).a(new Intent(CLPConstants.Action.ONSTART_CART_UPDATE));
        final ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, communicationListener.getSSOToken(context2));
        hashMap.put("Content-Type", "application/json");
        o oVar = new o();
        oVar.a("action", "update");
        o oVar2 = new o();
        oVar2.a("item_id", CartUtils.getItemId(j));
        oVar2.a(CLPConstants.PRODUCT_ID, (Number) Long.valueOf(j));
        oVar2.a("quantity", (Number) Integer.valueOf(i2));
        oVar.a("object", (l) oVar2);
        this.networkService.fetch(CLPArtifact.getInstance().getContext(), UrlUtils.getCartUrl(context2), 1, oVar.toString(), hashMap, new CLPNetworkService.IResponseListener() {
            public void onSuccess(String str, o oVar) {
                LogUtils.d(CLPRepository.TAG, "onCart Update Success");
                Task.runOnComputation(new Runnable(str, context2, communicationListener) {
                    private final /* synthetic */ String f$0;
                    private final /* synthetic */ Context f$1;
                    private final /* synthetic */ ICLPCommunicationListener f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        CLPRepository.AnonymousClass7.lambda$onSuccess$1(this.f$0, this.f$1, this.f$2);
                    }
                });
            }

            static /* synthetic */ void lambda$onSuccess$1(String str, Context context, ICLPCommunicationListener iCLPCommunicationListener) {
                CLPArtifact.getInstance().getCommunicationListener().setCartId(context, ((CJRCartResponse) new f().a(str, CJRCartResponse.class)).getCart().getCartId());
                CartUtils.setCartItem(str);
                Task.runOnMainThread(new Runnable(context, str) {
                    private final /* synthetic */ Context f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        CLPRepository.AnonymousClass7.lambda$null$0(ICLPCommunicationListener.this, this.f$1, this.f$2);
                    }
                });
            }

            static /* synthetic */ void lambda$null$0(ICLPCommunicationListener iCLPCommunicationListener, Context context, String str) {
                iCLPCommunicationListener.onCartChanged(context, str);
                a.a(context).a(new Intent(CLPConstants.Action.ONSUCCESS_CART_UPDATE));
            }

            public void onError(VolleyError volleyError) {
                LogUtils.d(CLPRepository.TAG, "on Cart Update failed");
                a.a(context2).a(new Intent(CLPConstants.Action.ONFAILED_CART_UPDATE));
            }
        });
    }

    public void addItemToCart(final Context context2, long j, int i2) {
        a.a(context2).a(new Intent(CLPConstants.Action.ONSTART_CART_UPDATE));
        final ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, communicationListener.getSSOToken(context2));
        hashMap.put("Content-Type", "application/json");
        o oVar = new o();
        i iVar = new i();
        o oVar2 = new o();
        oVar2.a(CLPConstants.PRODUCT_ID, (Number) Long.valueOf(j));
        oVar2.a("quantity", (Number) Integer.valueOf(i2));
        iVar.a((l) oVar2);
        oVar.a("object", (l) iVar);
        oVar.a("action", "bulkadd");
        this.networkService.fetch(CLPArtifact.getInstance().getContext(), UrlUtils.getCartUrl(context2), 1, oVar.toString(), hashMap, new CLPNetworkService.IResponseListener() {
            public void onSuccess(String str, o oVar) {
                LogUtils.d(CLPRepository.TAG, "onItem Add Success");
                Task.runOnComputation(new Runnable(str, context2, communicationListener) {
                    private final /* synthetic */ String f$0;
                    private final /* synthetic */ Context f$1;
                    private final /* synthetic */ ICLPCommunicationListener f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        CLPRepository.AnonymousClass8.lambda$onSuccess$1(this.f$0, this.f$1, this.f$2);
                    }
                });
            }

            static /* synthetic */ void lambda$onSuccess$1(String str, Context context, ICLPCommunicationListener iCLPCommunicationListener) {
                CLPArtifact.getInstance().getCommunicationListener().setCartId(context, ((CJRCartResponse) new f().a(str, CJRCartResponse.class)).getCart().getCartId());
                CartUtils.setCartItem(str);
                Task.runOnMainThread(new Runnable(context, str) {
                    private final /* synthetic */ Context f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        CLPRepository.AnonymousClass8.lambda$null$0(ICLPCommunicationListener.this, this.f$1, this.f$2);
                    }
                });
            }

            static /* synthetic */ void lambda$null$0(ICLPCommunicationListener iCLPCommunicationListener, Context context, String str) {
                iCLPCommunicationListener.onCartChanged(context, str);
                a.a(context).a(new Intent(CLPConstants.Action.ONSUCCESS_CART_UPDATE));
            }

            public void onError(VolleyError volleyError) {
                LogUtils.d(CLPRepository.TAG, "onItem Added Failed");
                a.a(context2).a(new Intent(CLPConstants.Action.ONFAILED_CART_UPDATE));
            }
        });
    }

    public void removeItemFromCart(final Context context2, long j) {
        a.a(context2).a(new Intent(CLPConstants.Action.ONSTART_CART_UPDATE));
        final ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, communicationListener.getSSOToken(context2));
        hashMap.put("Content-Type", "application/json");
        o oVar = new o();
        oVar.a("action", "remove");
        o oVar2 = new o();
        oVar2.a(CLPConstants.PRODUCT_ID, (Number) Long.valueOf(j));
        oVar2.a("item_id", CartUtils.getItemId(j));
        oVar.a("object", (l) oVar2);
        this.networkService.fetch(CLPArtifact.getInstance().getContext(), UrlUtils.getCartUrl(context2), 1, oVar.toString(), hashMap, new CLPNetworkService.IResponseListener() {
            public void onSuccess(String str, o oVar) {
                LogUtils.d(CLPRepository.TAG, "onItem Removed Success");
                Task.runOnComputation(new Runnable(str, context2, communicationListener) {
                    private final /* synthetic */ String f$0;
                    private final /* synthetic */ Context f$1;
                    private final /* synthetic */ ICLPCommunicationListener f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        CLPRepository.AnonymousClass9.lambda$onSuccess$1(this.f$0, this.f$1, this.f$2);
                    }
                });
            }

            static /* synthetic */ void lambda$onSuccess$1(String str, Context context, ICLPCommunicationListener iCLPCommunicationListener) {
                CLPArtifact.getInstance().getCommunicationListener().setCartId(context, ((CJRCartResponse) new f().a(str, CJRCartResponse.class)).getCart().getCartId());
                CartUtils.setCartItem(str);
                Task.runOnMainThread(new Runnable(context, str) {
                    private final /* synthetic */ Context f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        CLPRepository.AnonymousClass9.lambda$null$0(ICLPCommunicationListener.this, this.f$1, this.f$2);
                    }
                });
            }

            static /* synthetic */ void lambda$null$0(ICLPCommunicationListener iCLPCommunicationListener, Context context, String str) {
                iCLPCommunicationListener.onCartChanged(context, str);
                a.a(context).a(new Intent(CLPConstants.Action.ONSUCCESS_CART_UPDATE));
            }

            public void onError(VolleyError volleyError) {
                LogUtils.d(CLPRepository.TAG, "onItem Remove Failed");
                a.a(context2).a(new Intent(CLPConstants.Action.ONFAILED_CART_UPDATE));
            }
        });
    }

    public void fetchActiveOrder(FragmentActivity fragmentActivity, String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, CLPArtifact.getInstance().getCommunicationListener().getSSOToken(this.context));
            hashMap.put("Content-Type", "application/json");
            final ArrayList arrayList = new ArrayList();
            this.networkService.fetch(fragmentActivity, str, 0, (String) null, hashMap, new CLPNetworkService.IResponseListener() {
                public void onError(VolleyError volleyError) {
                }

                public void onSuccess(String str, o oVar) {
                    LogUtils.d("activeOrder Response", str);
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            new JSONArray();
                            JSONArray optJSONArray = jSONObject.optJSONArray("orders");
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONArray optJSONArray2 = optJSONArray.getJSONObject(i2).optJSONArray("items");
                                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                        JSONObject optJSONObject = optJSONArray2.optJSONObject(i3);
                                        CLPRepository.this.setActiveOrderItem(optJSONObject.optString("status_text2"), Integer.valueOf(optJSONObject.optInt("item_status", 0)), optJSONObject.optString("item_detail_url"), optJSONObject.optJSONObject("product").optString("thumbnail"), arrayList);
                                    }
                                }
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    ValidateViewResponse.sanitizeInvalidOrder(arrayList);
                    CLPArtifact.getInstance().getCommunicationListener().setActiveOrderCache(arrayList);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setActiveOrderItem(String str, Integer num, String str2, String str3, ArrayList<Item> arrayList) {
        Item item = new Item();
        item.setName(str);
        item.setImageUrl(str3);
        item.setUrl(str2);
        item.setUrlType(CLPConstants.CONFIG_KEY_MY_ORDERS);
        item.setStatusCode(num);
        arrayList.add(item);
    }
}
