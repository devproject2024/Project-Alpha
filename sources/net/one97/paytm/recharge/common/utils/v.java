package net.one97.paytm.recharge.common.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.fragment.app.Fragment;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJROrderItems;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.model.rechargeutility.UnsubscribeApiResponse;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class v implements ai {

    /* renamed from: a  reason: collision with root package name */
    a f61766a;

    /* renamed from: b  reason: collision with root package name */
    private Context f61767b;

    /* renamed from: c  reason: collision with root package name */
    private String f61768c = "automatic_my_paymentn_button_visibility";

    public interface a {
        void a();

        void a(int i2, CJRFrequentOrder cJRFrequentOrder);
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
    }

    public v(Context context, a aVar) {
        this.f61767b = context;
        this.f61766a = aVar;
    }

    public final void a(final Context context, final CJRFrequentOrder cJRFrequentOrder) {
        d dVar = d.f64967a;
        CJRRechargeErrorModel a2 = d.a(ACTION_TYPE.DELETE_RECENT, ERROR_TYPE.UNDEFINED);
        c cVar = c.f62654a;
        String u = c.u();
        String a3 = com.paytm.utility.c.a(context, true);
        CJRFrequentOrderList cJRFrequentOrderList = new CJRFrequentOrderList();
        if (b.c(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            String a4 = a(cJRFrequentOrder);
            if (TextUtils.isEmpty(a4) || TextUtils.isEmpty(u)) {
                this.f61766a.a();
                a(ACTION_TYPE.DELETE_RECENT);
                return;
            }
            net.one97.paytm.recharge.common.f.d.a();
            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("delete_recents", u + a3, (ai) new ai() {
                public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                    v.a(v.this, context, cJRFrequentOrder);
                }

                public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                    v.this.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
                }
            }, (IJRPaytmDataModel) cJRFrequentOrderList, (Map<String, String>) null, (Map<String, String>) hashMap, a4, (Object) a2));
        }
    }

    public final void b(final Context context, final CJRFrequentOrder cJRFrequentOrder) {
        c cVar = c.f62654a;
        String z = c.z();
        if (!URLUtil.isValidUrl(z)) {
            this.f61766a.a();
        } else if (b.c(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(AppConstants.SSO_TOKEN, CJRRechargeUtilities.INSTANCE.getSSOToken(context));
            hashMap.put("content-type", "application/json");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(StringSet.operator, cJRFrequentOrder.getOperator());
                jSONObject.put("rechargeNumber", cJRFrequentOrder.getRechargeNumber());
                jSONObject.put("notificationStatus", 0);
                jSONObject.put("stopBillFetch", true);
                jSONObject.put("customerId", b.n(context));
                jSONObject.put(AppConstants.SSO_TOKEN, CJRRechargeUtilities.INSTANCE.getSSOToken(context));
            } catch (JSONException e2) {
                q.d(e2.getMessage());
            }
            net.one97.paytm.recharge.common.f.d.a();
            AnonymousClass2 r4 = new ai() {
                public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                    if (iJRPaytmDataModel == null) {
                        return;
                    }
                    if (((UnsubscribeApiResponse) iJRPaytmDataModel).getStatus().intValue() == 200) {
                        v.a(v.this, context, cJRFrequentOrder);
                    } else {
                        v.this.f61766a.a();
                    }
                }

                public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                    v.this.f61766a.a();
                }
            };
            UnsubscribeApiResponse unsubscribeApiResponse = new UnsubscribeApiResponse();
            String jSONObject2 = jSONObject.toString();
            a.C0715a aVar = a.C0715a.PUT;
            d dVar = d.f64967a;
            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("consent_unsubscribe", z, (ai) r4, (IJRPaytmDataModel) unsubscribeApiResponse, (Map<String, String>) hashMap, jSONObject2, aVar, (Object) d.a(ACTION_TYPE.BILL_CONSENT, ERROR_TYPE.UNDEFINED)));
        } else {
            this.f61766a.a();
            a(ACTION_TYPE.BILL_CONSENT);
        }
    }

    private static String a(CJRFrequentOrder cJRFrequentOrder) {
        JSONArray jSONArray = new JSONArray();
        if (cJRFrequentOrder != null) {
            try {
                jSONArray.put(0, cJRFrequentOrder.getFavOrderId());
            } catch (JSONException e2) {
                q.d(e2.getMessage());
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("favLabelId", jSONArray);
            jSONObject.put("channel", "android");
            jSONObject.put("version", 2);
            return jSONObject.toString();
        } catch (JSONException e3) {
            q.d(e3.getMessage());
            return "";
        }
    }

    private void a(ACTION_TYPE action_type) {
        a aVar = this.f61766a;
        if (aVar != null) {
            aVar.a();
        }
        az azVar = az.f61525a;
        az.a(this.f61767b, ERROR_TYPE.NO_CONNECTION, action_type, this.f61767b.getString(R.string.no_connection), this.f61767b.getString(R.string.no_internet));
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        a aVar = this.f61766a;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this.f61766a;
        if (aVar2 != null) {
            aVar2.a();
        }
        if (networkCustomError != null) {
            if (networkCustomError.getMessage() != null) {
                q.d(networkCustomError.getMessage());
            }
            CJRRechargeUtilities.INSTANCE.handleError(str, (Activity) this.f61767b, (Fragment) null, networkCustomError, true, 3, obj);
        }
    }

    public final void a(final Context context, String str, final String str2) {
        c cVar = c.f62654a;
        String c2 = c.c();
        String b2 = ax.a(context.getApplicationContext()).b(e.aQ, "", true);
        if ((!(!z.a(context)) && !false) && !TextUtils.isEmpty(b2)) {
            String str3 = (c2 + "?cust_id=" + b2) + "&rech_num=" + str;
            if (URLUtil.isValidUrl(str3)) {
                String s = b.s(context, str3);
                HashMap<String, String> a2 = b.a((HashMap<String, String>) new HashMap(), context);
                if (b.c(context)) {
                    net.one97.paytm.recharge.common.f.d.a();
                    AnonymousClass4 r4 = new ai() {
                        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                            if (iJRPaytmDataModel instanceof CJRAutomaticSubscriptionCheckModel) {
                                try {
                                    v.a(v.this, context, (CJRAutomaticSubscriptionCheckModel) iJRPaytmDataModel, str2);
                                } catch (Exception e2) {
                                    q.d(e2.getMessage());
                                }
                            }
                        }

                        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                            v.this.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
                        }
                    };
                    CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel = new CJRAutomaticSubscriptionCheckModel();
                    d dVar = d.f64967a;
                    net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b("check_subscription", s, r4, cJRAutomaticSubscriptionCheckModel, a2, d.a(ACTION_TYPE.RECENT_SUBSCRIPTION_STATUS, ERROR_TYPE.UNDEFINED)));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x a(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", b.n(context));
        hashMap.put("automatic_button_visible_yes_or_no", H5AppHandler.CHECK_VALUE);
        hashMap.put("recharge_utilities_service_type", str);
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(this.f61768c, (HashMap<String, Object>) hashMap, context);
        return null;
    }

    public static CJROrderItems a(List<CJROrderItems> list, String str) {
        if (!(list == null || str == null)) {
            for (CJROrderItems next : list) {
                if (next.getProduct() != null && String.valueOf(next.getProduct().getProductId()).equalsIgnoreCase(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    static /* synthetic */ void a(v vVar, final Context context, final CJRFrequentOrder cJRFrequentOrder) {
        if (b.c(context)) {
            c cVar = c.f62654a;
            String b2 = c.b();
            if (b2 != null && URLUtil.isValidUrl(b2)) {
                net.one97.paytm.recharge.common.f.d.a();
                AnonymousClass3 r6 = new ai() {
                    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                        if (iJRPaytmDataModel instanceof CJRFrequentOrderList) {
                            CJRFrequentOrderList cJRFrequentOrderList = (CJRFrequentOrderList) iJRPaytmDataModel;
                            Context context = context;
                            if (context != null && context.getApplicationContext() != null && v.this.f61766a != null) {
                                try {
                                    if (context == null || context.getApplicationContext() == null) {
                                        v.this.f61766a.a();
                                        return;
                                    }
                                    CJRRechargeUtilities.INSTANCE.setFrequentOrderList(cJRFrequentOrderList);
                                    v.this.f61766a.a(1007, cJRFrequentOrder);
                                } catch (Exception e2) {
                                    q.d(e2.getMessage());
                                    v.this.f61766a.a();
                                }
                            }
                        }
                    }

                    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                        v.this.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
                    }
                };
                CJRFrequentOrderList cJRFrequentOrderList = new CJRFrequentOrderList();
                HashMap<String, String> ah = b.ah(context);
                d dVar = d.f64967a;
                net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b("frequent_api", b2 + com.paytm.utility.c.a(context, false), r6, cJRFrequentOrderList, ah, d.a(ACTION_TYPE.FETCH_RECENTS, ERROR_TYPE.UNDEFINED)));
                return;
            }
            return;
        }
        vVar.a(ACTION_TYPE.FETCH_RECENTS);
    }

    static /* synthetic */ void a(v vVar, Context context, CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel, String str) {
        if (cJRAutomaticSubscriptionCheckModel.getStatus().intValue() == 0) {
            net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(context, str) {
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final Object invoke() {
                    return v.this.a(this.f$1, this.f$2);
                }
            });
            vVar.f61766a.a(1001, (CJRFrequentOrder) null);
        }
    }
}
