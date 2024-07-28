package net.one97.paytm.recharge.metro.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.b.g;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.x;
import net.one97.paytm.recharge.common.f.b;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.metro.e.b;
import net.one97.paytm.recharge.metro.f.a;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModelV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel;
import net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel;
import net.one97.paytm.recharge.model.metro.CJRMetroPriceResponse;
import net.one97.paytm.recharge.model.metro.CJRMetroRefundDescriptionModel;
import net.one97.paytm.recharge.model.metro.CJRMetroStationListResponse;
import net.one97.paytm.recharge.model.metro.CJRMetroTnCListModel;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f63529a = a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static boolean f63530b;

    public static void a(String str, Context context, final ai aiVar, String str2, String str3, Object obj) {
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String aj = c.aj();
        if (aj.isEmpty()) {
            aiVar.a_(str, (IJRPaytmDataModel) null, obj);
            return;
        }
        if (!TextUtils.isEmpty(aj)) {
            aj = aj + "?reqType=" + str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            aj = aj + "&productType=" + str3.toUpperCase();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
        d.a();
        d.b(new b(str, aj, new ai() {
            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                if (iJRPaytmDataModel instanceof CJRMetroTnCListModel) {
                    aiVar.a_(str, iJRPaytmDataModel, obj);
                } else {
                    aiVar.a_(str, (IJRPaytmDataModel) null, obj);
                }
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                aiVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            }
        }, new CJRMetroTnCListModel(), hashMap, obj));
    }

    public static void a(String str, Context context, String str2, String str3, final ai aiVar, Object obj) {
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String ak = c.ak();
        if (!TextUtils.isEmpty(ak)) {
            Uri.Builder buildUpon = Uri.parse(ak).buildUpon();
            if (!TextUtils.isEmpty(str2)) {
                buildUpon.appendQueryParameter("productType", str2.toUpperCase());
            }
            if (!TextUtils.isEmpty(str3)) {
                buildUpon.appendQueryParameter("reqType", str3);
            }
            if (buildUpon.toString().isEmpty()) {
                aiVar.a_(str, (IJRPaytmDataModel) null, obj);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
            q.d(buildUpon.toString());
            d.a();
            d.b(new b(str, buildUpon.toString(), new ai() {
                public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                    aiVar.a_(str, iJRPaytmDataModel, obj);
                }

                public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                    aiVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
                }
            }, new CJRMetroStationListResponse(), hashMap, obj));
        }
    }

    public static <T> void a(String str, Context context, String str2, String str3, ai aiVar, String str4, Object obj) {
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String al = c.al();
        if (al.isEmpty()) {
            aiVar.a_(str, (IJRPaytmDataModel) null, obj);
            return;
        }
        Uri.Builder appendQueryParameter = Uri.parse(al + "?reqType=" + str4).buildUpon().appendQueryParameter("stationId", String.valueOf(str2)).appendQueryParameter("qrCodeId", str3);
        StringBuilder sb = new StringBuilder();
        sb.append(appendQueryParameter.toString());
        q.d(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
        d.a();
        d.b(new b(str, appendQueryParameter.toString(), aiVar, new CJRMetroPenaltyDetailsModel(), hashMap, obj));
    }

    public static void a(Activity activity, String str, CJRRechargeCart cJRRechargeCart, net.one97.paytm.recharge.common.f.c cVar, CJRItem cJRItem, String str2, String str3, String str4, ai aiVar, x xVar, Object obj) {
        Activity activity2 = activity;
        CJRRechargeErrorModel cJRRechargeErrorModel = obj;
        ay ayVar = ay.f61523a;
        ay.a("wallet_token", cJRRechargeErrorModel);
        if (cJRRechargeErrorModel instanceof CJRRechargeErrorModel) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            cJRRechargeErrorModel = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CJRRechargeErrorModel cJRRechargeErrorModel2 = cJRRechargeErrorModel;
            if (cJRRechargeErrorModel2.getFlowName() == null) {
                cJRRechargeErrorModel2.setFlowName(new CRUFlowModel());
            }
            cJRRechargeErrorModel2.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
            cJRRechargeErrorModel2.getFlowName().setErrorType(ACTION_TYPE.WALLET_TOKEN.name());
            cJRRechargeErrorModel2.getFlowName().setTag("wallet_token");
        }
        Object obj2 = cJRRechargeErrorModel;
        c cVar2 = c.f62654a;
        String t = c.t();
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", CJRRechargeUtilities.INSTANCE.getSSOToken(activity2));
        if (URLUtil.isValidUrl(t)) {
            final Activity activity3 = activity;
            final String str5 = str;
            final CJRItem cJRItem2 = cJRItem;
            final String str6 = str2;
            final String str7 = str4;
            final String str8 = str3;
            final net.one97.paytm.recharge.common.f.c cVar3 = cVar;
            final CJRRechargeCart cJRRechargeCart2 = cJRRechargeCart;
            final ai aiVar2 = aiVar;
            final x xVar2 = xVar;
            net.one97.paytm.recharge.common.f.c cVar4 = new net.one97.paytm.recharge.common.f.c("wallet_token", t, (ai) new ai() {
                public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                    a.a(activity3, str5, cJRItem2, str6, str7, str8, cVar3, cJRRechargeCart2, (CJRCashWallet) iJRPaytmDataModel, aiVar2, xVar2, obj);
                }

                public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                    aiVar2.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
                }
            }, (IJRPaytmDataModel) new CJRCashWallet(), (Map<String, String>) null, (Map<String, String>) hashMap, (String) null, obj2);
            if (com.paytm.utility.b.c((Context) activity)) {
                activity.getApplicationContext();
                d.a();
                d.b(cVar4);
                return;
            }
            a(activity2, cVar4);
            return;
        }
        a((Context) activity);
    }

    /* access modifiers changed from: private */
    public static void b(String str, ai aiVar, Object obj) {
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new NetworkCustomError((Throwable) new RuntimeException("hideProgress")), obj);
    }

    public static void a(Activity activity, String str, CJRItem cJRItem, String str2, String str3, String str4, net.one97.paytm.recharge.common.f.c cVar, CJRRechargeCart cJRRechargeCart, CJRCashWallet cJRCashWallet, CJRPGTokenList cJRPGTokenList, ai aiVar, x xVar, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        Map<String, String> map;
        String str5;
        net.one97.paytm.recharge.common.f.a aVar;
        int i2;
        Activity activity2 = activity;
        Object obj2 = obj;
        String pgToken = CJRRechargeUtilities.INSTANCE.getPgToken(cJRPGTokenList);
        String str6 = null;
        if (TextUtils.isEmpty(pgToken)) {
            b("metro_checkout", aiVar, obj2);
            CJRRechargeUtilities.INSTANCE.showSessionTimeoutAlert(activity2, (String) null, (Bundle) null, new NetworkCustomError());
        } else if (!f63530b) {
            if (obj2 == null || !(obj2 instanceof CJRRechargeErrorModel)) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                cJRRechargeErrorModel = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            } else {
                cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
            }
            CJRRechargeErrorModel cJRRechargeErrorModel2 = cJRRechargeErrorModel;
            ay ayVar = ay.f61523a;
            ay.a("metro_checkout", (Object) cJRRechargeErrorModel2);
            if (cJRRechargeErrorModel2.getFlowName() == null) {
                cJRRechargeErrorModel2.setFlowName(new CRUFlowModel());
            }
            cJRRechargeErrorModel2.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
            cJRRechargeErrorModel2.getFlowName().setActionType(ACTION_TYPE.METRO_CHECKOUT.name());
            cJRRechargeErrorModel2.getFlowName().setRequestBody(cVar.c());
            com.paytm.network.b bVar = cVar.f61099a;
            if (bVar == null) {
                k.a("mCJRCommonNetworkCallBuilder");
            }
            if (bVar != null) {
                map = bVar.f42882f;
            } else {
                map = null;
            }
            map.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(activity));
            map.put("wallet_token", pgToken);
            net.one97.paytm.f.b.a().c();
            net.one97.paytm.f.b.a().a(activity, (String) null, (String) null, false, (String) null, com.paytm.utility.b.s((Context) activity), com.paytm.utility.b.t((Context) activity));
            String d2 = net.one97.paytm.f.b.a().d();
            if (!TextUtils.isEmpty(d2)) {
                map.put("risk_extended_info", d2);
            }
            net.one97.paytm.f.b.a().c();
            try {
                c cVar2 = c.f62654a;
                str6 = c.a(new JSONObject(cVar.c()));
            } catch (JSONException e2) {
                q.d(e2.getMessage());
            }
            if (URLUtil.isValidUrl(str6)) {
                String s = com.paytm.utility.b.s(activity2, str6);
                String k = com.paytm.utility.b.k();
                if (Uri.parse(s).getQuery() != null) {
                    str5 = s + "&client_id=" + k;
                } else {
                    str5 = s + "?client_id=" + k;
                }
                String str7 = str5;
                final boolean z = false;
                if (!(cJRCashWallet == null || cJRCashWallet.getResponse() == null)) {
                    int amount = (int) cJRCashWallet.getResponse().getAmount();
                    try {
                        i2 = (int) Float.parseFloat(cJRRechargeCart.getCart().getFinalPrice());
                    } catch (Exception e3) {
                        q.d(e3.getMessage());
                        i2 = 0;
                    }
                    if (i2 <= amount) {
                        str7 = str7 + "&withdraw=1";
                        z = true;
                    } else {
                        str7 = ab.b(str7);
                    }
                }
                String d3 = com.paytm.utility.b.d(str7, "POST");
                f63530b = true;
                final ai aiVar2 = aiVar;
                final Activity activity3 = activity;
                final CJRRechargeCart cJRRechargeCart2 = cJRRechargeCart;
                final CJRItem cJRItem2 = cJRItem;
                final String str8 = str2;
                final String str9 = str3;
                final String str10 = str4;
                final x xVar2 = xVar;
                final String str11 = str;
                new net.one97.paytm.recharge.common.f.c("metro_checkout", d3, (ai) new ai() {
                    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                        x xVar;
                        boolean unused = a.f63530b = false;
                        CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                        a.b("metro_checkout", aiVar2, obj);
                        if (cJRRechargePayment.getStatus() == null || !cJRRechargePayment.getStatus().equalsIgnoreCase("SUCCESS")) {
                            if (cJRRechargePayment.getError() != null) {
                                az azVar = az.f61525a;
                                az.a(activity3, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, cJRRechargePayment.getError().getTitle(), cJRRechargePayment.getError().getMessage());
                            }
                        } else if (z) {
                            com.paytm.utility.b.j();
                            if (cJRRechargePayment.getOrderId() != null) {
                                String orderId = cJRRechargePayment.getOrderId();
                                Intent intent = new Intent(activity3, AJRechargeOrderSummaryActivity.class);
                                intent.putExtra(UpiConstants.FROM, "Payment");
                                intent.putExtra("order_id", orderId);
                                intent.putExtra("recharge cart", cJRRechargeCart2);
                                intent.putExtra(com.business.merchant_payments.common.utility.AppConstants.IS_CANCEL, false);
                                intent.addFlags(268468224);
                                intent.putExtra("recharge_ga_data_for_summary", (Serializable) a.b(cJRRechargeCart2.getCart().getFinalPrice(), cJRItem2.getName(), str8, str9, str10));
                                activity3.startActivity(intent);
                                net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(activity3) {
                                    private final /* synthetic */ Activity f$1;

                                    {
                                        this.f$1 = r2;
                                    }

                                    public final Object invoke() {
                                        return a.AnonymousClass9.a(CJRRechargeCart.this, this.f$1);
                                    }
                                });
                            }
                        } else {
                            com.paytm.utility.b.j();
                            if (!ab.a(cJRRechargePayment) || (xVar = xVar2) == null) {
                                a.a(activity3, str11, cJRRechargePayment, cJRRechargeCart2, cJRItem2, str8, str9, str10);
                                return;
                            }
                            xVar.a(cJRRechargePayment);
                            ba.a((Context) activity3, cJRRechargePayment, (FetchPayOptionsListener) xVar2);
                        }
                    }

                    /* access modifiers changed from: private */
                    public static /* synthetic */ kotlin.x a(CJRRechargeCart cJRRechargeCart, Activity activity) {
                        c cVar = c.f62654a;
                        String X = c.X();
                        List a2 = a.a(cJRRechargeCart);
                        if (a2 == null) {
                            return null;
                        }
                        String verticalLabel = ((CJRCartProduct) a2.get(0)).getVerticalLabel();
                        String lastItemInCategoryMap = ((CJRCartProduct) a2.get(0)).getLastItemInCategoryMap();
                        if (verticalLabel != null) {
                            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                            net.one97.paytm.recharge.di.helper.b.b(verticalLabel, (Context) activity, X, lastItemInCategoryMap);
                            return null;
                        }
                        net.one97.paytm.recharge.di.helper.b bVar2 = net.one97.paytm.recharge.di.helper.b.f62652a;
                        net.one97.paytm.recharge.di.helper.b.b(SDKConstants.GA_KEY_DEFAULT, (Context) activity, X, lastItemInCategoryMap);
                        return null;
                    }

                    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                        CJRRechargeErrorModel cJRRechargeErrorModel;
                        ACTION_TYPE action_type;
                        NetworkCustomError networkCustomError2 = networkCustomError;
                        Object obj2 = obj;
                        boolean unused = a.f63530b = false;
                        q.d(networkCustomError.getMessage());
                        a.b("metro_checkout", aiVar2, obj2);
                        if (TextUtils.isEmpty(networkCustomError.getMessage()) || !CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError2)) {
                            if (networkCustomError.getMessage() != null && !CJRRechargeUtilities.INSTANCE.reportError(activity3, networkCustomError2, "error.utilities@paytm.com")) {
                                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                    String string = activity3.getResources().getString(R.string.network_error_message);
                                    az azVar = az.f61525a;
                                    az.a(activity3, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, activity3.getResources().getString(R.string.network_error_heading), string);
                                    return;
                                }
                                ACTION_TYPE action_type2 = null;
                                if (obj2 instanceof CJRRechargeErrorModel) {
                                    CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj2;
                                    cJRRechargeErrorModel2.setErrorType(ERROR_TYPE.PARSING);
                                    CRUFlowModel flowName = cJRRechargeErrorModel2.getFlowName();
                                    if (flowName != null) {
                                        flowName.setErrorType(ERROR_TYPE.PARSING.name());
                                        action_type2 = ACTION_TYPE.Companion.getActionType(flowName.getActionType(), ACTION_TYPE.UNDEFINED);
                                    }
                                    cJRRechargeErrorModel = cJRRechargeErrorModel2;
                                    action_type = action_type2;
                                } else {
                                    action_type = null;
                                    cJRRechargeErrorModel = null;
                                }
                                az azVar2 = az.f61525a;
                                Activity activity = activity3;
                                ERROR_TYPE error_type = ERROR_TYPE.PARSING;
                                String url = networkCustomError.getUrl();
                                StringBuilder sb = new StringBuilder();
                                sb.append(networkCustomError.getStatusCode());
                                az.a(activity, error_type, action_type, url, sb.toString(), false, cJRRechargeErrorModel.getCategoryId(), cJRRechargeErrorModel.getScreenName(), cJRRechargeErrorModel.getProductId(), cJRRechargeErrorModel, false);
                            }
                        } else if (activity3 instanceof Activity) {
                            CJRRechargeUtilities.INSTANCE.handleError(activity3, networkCustomError, (String) null, (Bundle) null, true);
                        }
                    }
                }, (IJRPaytmDataModel) new CJRRechargePayment(), (Map<String, String>) null, map, cVar.c(), (Object) cJRRechargeErrorModel2);
                if (com.paytm.utility.b.c((Context) activity)) {
                    activity.getApplicationContext();
                    d.a();
                    d.b(aVar);
                    return;
                }
                a(activity2, aVar);
                return;
            }
            a((Context) activity);
        }
    }

    public static void a(Activity activity, String str, CJRRechargePayment cJRRechargePayment, CJRRechargeCart cJRRechargeCart, CJRItem cJRItem, String str2, String str3, String str4) {
        net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
        String str5 = str2;
        Map<String, Object> b2 = b(cJRRechargeCart.getCart().getFinalPrice(), cJRItem.getName(), str2, str3, str4);
        net.one97.paytm.recharge.di.helper.a aVar2 = net.one97.paytm.recharge.di.helper.a.f62650a;
        Class<? extends Activity> e2 = net.one97.paytm.recharge.di.helper.a.e();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.common.utils.a.a(activity, str, cJRRechargeCart, cJRRechargePayment, b2, e2, net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null), false);
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> b(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_utilities_input_field_values", str3);
        hashMap.put("recharge_utilities_group_field_values", str4);
        hashMap.put("recharge_utilities_amount", str);
        hashMap.put("recharge_utilities_service_type", str5);
        hashMap.put("recharge_utilities_business_sub_vertical", str2);
        hashMap.put("recharge_utilities_ff_state", "checked");
        return hashMap;
    }

    private static void a(Context context) {
        az azVar = az.f61525a;
        az.a(context, ERROR_TYPE.INVALID_URL, ACTION_TYPE.UNDEFINED, context.getString(R.string.error), context.getString(R.string.msg_invalid_url));
    }

    public static void a(final Context context, final net.one97.paytm.recharge.common.f.a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.no_connection));
        builder.setMessage(context.getString(R.string.no_internet));
        builder.setPositiveButton(context.getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c(context)) {
                    d.a();
                    d.b(aVar);
                    return;
                }
                a.a(context, aVar);
            }
        });
        builder.show();
    }

    public static void b(String str, Context context, String str2, String str3, final ai aiVar, String str4, Object obj) {
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String am = c.am();
        if (am.isEmpty()) {
            aiVar.a_(str, (IJRPaytmDataModel) null, obj);
            return;
        }
        Uri.Builder buildUpon = Uri.parse(am + "?reqType=" + str4).buildUpon();
        buildUpon.appendQueryParameter("source_id", String.valueOf(str2));
        buildUpon.appendQueryParameter("destination_id", String.valueOf(str3));
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, CJRRechargeUtilities.INSTANCE.getSSOToken(context));
        q.d(buildUpon.toString());
        d.a();
        d.b(new b(str, buildUpon.toString(), new ai() {
            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                if (iJRPaytmDataModel instanceof CJRMetroPriceResponse) {
                    aiVar.a_(str, (CJRMetroPriceResponse) iJRPaytmDataModel, obj);
                }
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                aiVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            }
        }, new CJRMetroPriceResponse(), hashMap, obj));
    }

    public static void a(String str, Context context, String str2, final ai aiVar, Object obj) {
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String an = c.an();
        if (an.isEmpty()) {
            aiVar.a_(str, (IJRPaytmDataModel) null, obj);
            return;
        }
        Uri.Builder buildUpon = Uri.parse(an).buildUpon();
        buildUpon.appendQueryParameter("order_id", str2);
        q.d(buildUpon.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
        d.a();
        d.b(new b(str, buildUpon.toString(), new ai() {
            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRMetroRefundDescriptionModel)) {
                    aiVar.a_(str, (IJRPaytmDataModel) null, obj);
                } else {
                    aiVar.a_(str, (CJRMetroRefundDescriptionModel) iJRPaytmDataModel, obj);
                }
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                aiVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            }
        }, new CJRMetroRefundDescriptionModel(), hashMap, obj));
    }

    public static void b(String str, Context context, String str2, final ai aiVar, Object obj) {
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String ao = c.ao();
        if (ao.isEmpty()) {
            aiVar.a_(str, (IJRPaytmDataModel) null, obj);
            return;
        }
        Uri.Builder buildUpon = Uri.parse(ao).buildUpon();
        buildUpon.appendQueryParameter("order_id", str2);
        q.d(buildUpon.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
        d.a();
        d.b(new b(str, buildUpon.toString(), new ai() {
            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                aiVar.a_(str, iJRPaytmDataModel, obj);
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                aiVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            }
        }, new CJROSActionResponseV2(), hashMap, obj));
    }

    public static void b(String str, Context context, String str2, String str3, final ai aiVar, Object obj) {
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String ap = c.ap();
        if (ap.isEmpty()) {
            aiVar.a_(str, (IJRPaytmDataModel) null, obj);
            return;
        }
        Uri.Builder buildUpon = Uri.parse(ap).buildUpon();
        buildUpon.appendQueryParameter("passId", str2);
        buildUpon.appendQueryParameter("order_id", str3);
        buildUpon.appendQueryParameter("customer_id", com.paytm.utility.b.n(context));
        q.d(buildUpon.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
        d.a();
        d.b(new b(str, buildUpon.toString(), new ai() {
            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRActiveMetroTicketModel)) {
                    aiVar.a_(str, (IJRPaytmDataModel) null, obj);
                } else {
                    aiVar.a_(str, (CJRActiveMetroTicketModel) iJRPaytmDataModel, obj);
                }
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                aiVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            }
        }, new CJRActiveMetroTicketModel(), hashMap, obj));
    }

    public static void a(String str, Context context, final ai aiVar, String str2, Object obj) {
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String ag = c.ag();
        if (TextUtils.isEmpty(ag)) {
            aiVar.a_(str, (IJRPaytmDataModel) null, obj);
            return;
        }
        Uri.Builder buildUpon = Uri.parse(ag).buildUpon();
        if (buildUpon.toString().isEmpty()) {
            aiVar.a_(str, (IJRPaytmDataModel) null, obj);
            return;
        }
        buildUpon.appendQueryParameter("reqType", str2);
        q.d(buildUpon.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
        d.a();
        d.b(new b(str, buildUpon.toString(), new ai() {
            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                CJRMetroPenaltyMessageModel cJRMetroPenaltyMessageModel;
                String str2 = iJRPaytmDataModel.getNetworkResponse().headers.get("Content-Encoding");
                String str3 = new String(iJRPaytmDataModel.getNetworkResponse().data);
                Reader a2 = (str2 == null || !str2.equals("gzip")) ? null : g.a(iJRPaytmDataModel.getNetworkResponse().data);
                if (str2 != null && str2.equals("gzip")) {
                    str3 = g.a(a2);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    Iterator<String> keys = jSONObject.keys();
                    cJRMetroPenaltyMessageModel = new CJRMetroPenaltyMessageModel();
                    while (keys.hasNext()) {
                        try {
                            String next = keys.next();
                            if (jSONObject.get(next) instanceof JSONObject) {
                                JSONObject jSONObject2 = new JSONObject(jSONObject.get(next).toString());
                                String string = jSONObject2.getString("title");
                                JSONArray jSONArray = jSONObject2.getJSONArray("message");
                                ArrayList arrayList = new ArrayList();
                                if (jSONArray != null) {
                                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                        arrayList.add(jSONArray.getString(i2));
                                    }
                                }
                                cJRMetroPenaltyMessageModel.getClass();
                                cJRMetroPenaltyMessageModel.getPenaltyMap().put(next, new CJRMetroPenaltyMessageModel.Penalty(string, arrayList));
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            q.d(e.getMessage());
                            aiVar.a_(str, cJRMetroPenaltyMessageModel, obj);
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    cJRMetroPenaltyMessageModel = null;
                    q.d(e.getMessage());
                    aiVar.a_(str, cJRMetroPenaltyMessageModel, obj);
                }
                aiVar.a_(str, cJRMetroPenaltyMessageModel, obj);
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                aiVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            }
        }, new CJRMetroPenaltyMessageModel(), hashMap, obj));
    }

    public static void a(String str, final Context context, final b.a<List<CJRActiveMetroTicketModel>> aVar, final ai aiVar, Object obj) {
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        c cVar = c.f62654a;
        String af = c.af();
        if (!TextUtils.isEmpty(af)) {
            Uri.Builder buildUpon = Uri.parse(af).buildUpon();
            if (!buildUpon.toString().isEmpty()) {
                if (!TextUtils.isEmpty("ACTIVE")) {
                    buildUpon.appendQueryParameter("status", "ACTIVE");
                }
                TextUtils.isEmpty((CharSequence) null);
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    buildUpon.appendQueryParameter("order_id", (String) null);
                }
                if (!com.paytm.utility.b.c(context)) {
                    if (!com.paytm.utility.d.c(context) && com.paytm.utility.b.n(context) != null) {
                        c.a aVar2 = c.f63576a;
                        c.a.a(context, com.paytm.utility.b.n(context));
                    }
                    c.a aVar3 = c.f63576a;
                    c.l = true;
                    c.a aVar4 = c.f63576a;
                    c.a aVar5 = c.f63576a;
                    c.f63584i = c.a.a(context);
                    c.a aVar6 = c.f63576a;
                    if (c.f63584i != null) {
                        c.a aVar7 = c.f63576a;
                        if (c.f63584i.size() > 0) {
                            c.a aVar8 = c.f63576a;
                            ((CJRActiveMetroTicketModel) c.f63584i.get(0)).setOfflineData(true);
                        }
                    }
                    if (aVar != null) {
                        c.a aVar9 = c.f63576a;
                        aVar.a(c.f63584i, true);
                    }
                } else if (com.paytm.utility.d.c(context)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
                    q.d(buildUpon.toString());
                    d.a();
                    d.b(new net.one97.paytm.recharge.common.f.b(str, buildUpon.toString(), new ai() {
                        /* JADX WARNING: Removed duplicated region for block: B:152:0x01f0  */
                        /* JADX WARNING: Removed duplicated region for block: B:153:0x020a  */
                        /* JADX WARNING: Removed duplicated region for block: B:156:0x0241  */
                        /* JADX WARNING: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void a_(java.lang.String r5, com.paytm.network.model.IJRPaytmDataModel r6, java.lang.Object r7) {
                            /*
                                r4 = this;
                                boolean r5 = r6 instanceof net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModelV2
                                r7 = 0
                                r0 = 0
                                if (r5 == 0) goto L_0x01d2
                                net.one97.paytm.recharge.metro.f.c$a r5 = net.one97.paytm.recharge.metro.f.c.f63576a
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModelV2 r6 = (net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModelV2) r6
                                java.lang.String r5 = "activeTicketAndPassesResponse"
                                kotlin.g.b.k.c(r6, r5)
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r5 = r6.getDELHI_METRO()
                                if (r5 != 0) goto L_0x0021
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r5 = r6.getMUMBAI_METRO()
                                if (r5 != 0) goto L_0x0021
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r5 = r6.getHYDERABAD_METRO()
                                if (r5 == 0) goto L_0x01d2
                            L_0x0021:
                                java.util.ArrayList r5 = new java.util.ArrayList
                                r5.<init>()
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r1 = r6.getHYDERABAD_METRO()
                                r2 = 1
                                if (r1 == 0) goto L_0x00b3
                                java.util.ArrayList r1 = new java.util.ArrayList
                                r1.<init>()
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getHYDERABAD_METRO()
                                if (r3 != 0) goto L_0x003b
                                kotlin.g.b.k.a()
                            L_0x003b:
                                java.util.List r3 = r3.getTickets()
                                if (r3 == 0) goto L_0x006d
                                java.util.Collection r3 = (java.util.Collection) r3
                                if (r3 == 0) goto L_0x004e
                                boolean r3 = r3.isEmpty()
                                if (r3 == 0) goto L_0x004c
                                goto L_0x004e
                            L_0x004c:
                                r3 = 0
                                goto L_0x004f
                            L_0x004e:
                                r3 = 1
                            L_0x004f:
                                if (r3 != 0) goto L_0x006d
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getHYDERABAD_METRO()
                                if (r3 == 0) goto L_0x005c
                                java.util.List r3 = r3.getTickets()
                                goto L_0x005d
                            L_0x005c:
                                r3 = r7
                            L_0x005d:
                                if (r3 != 0) goto L_0x0062
                                kotlin.g.b.k.a()
                            L_0x0062:
                                java.util.List r3 = net.one97.paytm.recharge.metro.f.c.a.a((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r3)
                                if (r3 == 0) goto L_0x006d
                                java.util.Collection r3 = (java.util.Collection) r3
                                r1.addAll(r3)
                            L_0x006d:
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getHYDERABAD_METRO()
                                if (r3 != 0) goto L_0x0076
                                kotlin.g.b.k.a()
                            L_0x0076:
                                java.util.List r3 = r3.getPasses()
                                if (r3 == 0) goto L_0x00a8
                                java.util.Collection r3 = (java.util.Collection) r3
                                if (r3 == 0) goto L_0x0089
                                boolean r3 = r3.isEmpty()
                                if (r3 == 0) goto L_0x0087
                                goto L_0x0089
                            L_0x0087:
                                r3 = 0
                                goto L_0x008a
                            L_0x0089:
                                r3 = 1
                            L_0x008a:
                                if (r3 != 0) goto L_0x00a8
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getHYDERABAD_METRO()
                                if (r3 == 0) goto L_0x0097
                                java.util.List r3 = r3.getPasses()
                                goto L_0x0098
                            L_0x0097:
                                r3 = r7
                            L_0x0098:
                                if (r3 != 0) goto L_0x009d
                                kotlin.g.b.k.a()
                            L_0x009d:
                                java.util.List r3 = net.one97.paytm.recharge.metro.f.c.a.b((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r3)
                                if (r3 == 0) goto L_0x00a8
                                java.util.Collection r3 = (java.util.Collection) r3
                                r1.addAll(r3)
                            L_0x00a8:
                                r3 = r1
                                java.util.List r3 = (java.util.List) r3
                                net.one97.paytm.recharge.metro.f.c.k = r3
                                java.util.Collection r1 = (java.util.Collection) r1
                                r5.addAll(r1)
                            L_0x00b3:
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r1 = r6.getDELHI_METRO()
                                if (r1 == 0) goto L_0x013f
                                java.util.ArrayList r1 = new java.util.ArrayList
                                r1.<init>()
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getDELHI_METRO()
                                if (r3 != 0) goto L_0x00c7
                                kotlin.g.b.k.a()
                            L_0x00c7:
                                java.util.List r3 = r3.getTickets()
                                if (r3 == 0) goto L_0x00f9
                                java.util.Collection r3 = (java.util.Collection) r3
                                if (r3 == 0) goto L_0x00da
                                boolean r3 = r3.isEmpty()
                                if (r3 == 0) goto L_0x00d8
                                goto L_0x00da
                            L_0x00d8:
                                r3 = 0
                                goto L_0x00db
                            L_0x00da:
                                r3 = 1
                            L_0x00db:
                                if (r3 != 0) goto L_0x00f9
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getDELHI_METRO()
                                if (r3 == 0) goto L_0x00e8
                                java.util.List r3 = r3.getTickets()
                                goto L_0x00e9
                            L_0x00e8:
                                r3 = r7
                            L_0x00e9:
                                if (r3 != 0) goto L_0x00ee
                                kotlin.g.b.k.a()
                            L_0x00ee:
                                java.util.List r3 = net.one97.paytm.recharge.metro.f.c.a.a((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r3)
                                if (r3 == 0) goto L_0x00f9
                                java.util.Collection r3 = (java.util.Collection) r3
                                r1.addAll(r3)
                            L_0x00f9:
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getDELHI_METRO()
                                if (r3 != 0) goto L_0x0102
                                kotlin.g.b.k.a()
                            L_0x0102:
                                java.util.List r3 = r3.getPasses()
                                if (r3 == 0) goto L_0x0134
                                java.util.Collection r3 = (java.util.Collection) r3
                                if (r3 == 0) goto L_0x0115
                                boolean r3 = r3.isEmpty()
                                if (r3 == 0) goto L_0x0113
                                goto L_0x0115
                            L_0x0113:
                                r3 = 0
                                goto L_0x0116
                            L_0x0115:
                                r3 = 1
                            L_0x0116:
                                if (r3 != 0) goto L_0x0134
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getDELHI_METRO()
                                if (r3 == 0) goto L_0x0123
                                java.util.List r3 = r3.getPasses()
                                goto L_0x0124
                            L_0x0123:
                                r3 = r7
                            L_0x0124:
                                if (r3 != 0) goto L_0x0129
                                kotlin.g.b.k.a()
                            L_0x0129:
                                java.util.List r3 = net.one97.paytm.recharge.metro.f.c.a.b((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r3)
                                if (r3 == 0) goto L_0x0134
                                java.util.Collection r3 = (java.util.Collection) r3
                                r1.addAll(r3)
                            L_0x0134:
                                r3 = r1
                                java.util.List r3 = (java.util.List) r3
                                net.one97.paytm.recharge.metro.f.c.j = r3
                                java.util.Collection r1 = (java.util.Collection) r1
                                r5.addAll(r1)
                            L_0x013f:
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r1 = r6.getMUMBAI_METRO()
                                if (r1 == 0) goto L_0x01c9
                                java.util.ArrayList r1 = new java.util.ArrayList
                                r1.<init>()
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getMUMBAI_METRO()
                                if (r3 != 0) goto L_0x0153
                                kotlin.g.b.k.a()
                            L_0x0153:
                                java.util.List r3 = r3.getTickets()
                                if (r3 == 0) goto L_0x0185
                                java.util.Collection r3 = (java.util.Collection) r3
                                if (r3 == 0) goto L_0x0166
                                boolean r3 = r3.isEmpty()
                                if (r3 == 0) goto L_0x0164
                                goto L_0x0166
                            L_0x0164:
                                r3 = 0
                                goto L_0x0167
                            L_0x0166:
                                r3 = 1
                            L_0x0167:
                                if (r3 != 0) goto L_0x0185
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getMUMBAI_METRO()
                                if (r3 == 0) goto L_0x0174
                                java.util.List r3 = r3.getTickets()
                                goto L_0x0175
                            L_0x0174:
                                r3 = r7
                            L_0x0175:
                                if (r3 != 0) goto L_0x017a
                                kotlin.g.b.k.a()
                            L_0x017a:
                                java.util.List r3 = net.one97.paytm.recharge.metro.f.c.a.a((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r3)
                                if (r3 == 0) goto L_0x0185
                                java.util.Collection r3 = (java.util.Collection) r3
                                r1.addAll(r3)
                            L_0x0185:
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r3 = r6.getMUMBAI_METRO()
                                if (r3 != 0) goto L_0x018e
                                kotlin.g.b.k.a()
                            L_0x018e:
                                java.util.List r3 = r3.getPasses()
                                if (r3 == 0) goto L_0x01be
                                java.util.Collection r3 = (java.util.Collection) r3
                                if (r3 == 0) goto L_0x01a0
                                boolean r3 = r3.isEmpty()
                                if (r3 == 0) goto L_0x019f
                                goto L_0x01a0
                            L_0x019f:
                                r2 = 0
                            L_0x01a0:
                                if (r2 != 0) goto L_0x01be
                                net.one97.paytm.recharge.model.CJRActiveTicketsAndPassesModel r6 = r6.getMUMBAI_METRO()
                                if (r6 == 0) goto L_0x01ad
                                java.util.List r6 = r6.getPasses()
                                goto L_0x01ae
                            L_0x01ad:
                                r6 = r7
                            L_0x01ae:
                                if (r6 != 0) goto L_0x01b3
                                kotlin.g.b.k.a()
                            L_0x01b3:
                                java.util.List r6 = net.one97.paytm.recharge.metro.f.c.a.b((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r6)
                                if (r6 == 0) goto L_0x01be
                                java.util.Collection r6 = (java.util.Collection) r6
                                r1.addAll(r6)
                            L_0x01be:
                                r6 = r1
                                java.util.List r6 = (java.util.List) r6
                                net.one97.paytm.recharge.metro.f.c.f63584i = r6
                                java.util.Collection r1 = (java.util.Collection) r1
                                r5.addAll(r1)
                            L_0x01c9:
                                int r6 = r5.size()
                                if (r6 <= 0) goto L_0x01d2
                                java.util.List r5 = (java.util.List) r5
                                goto L_0x01d3
                            L_0x01d2:
                                r5 = r7
                            L_0x01d3:
                                if (r5 == 0) goto L_0x01db
                                int r6 = r5.size()
                                if (r6 != 0) goto L_0x01dc
                            L_0x01db:
                                r5 = r7
                            L_0x01dc:
                                net.one97.paytm.recharge.metro.f.c$a r6 = net.one97.paytm.recharge.metro.f.c.f63576a
                                net.one97.paytm.recharge.metro.f.c.l = r0
                                net.one97.paytm.recharge.metro.f.c$a r6 = net.one97.paytm.recharge.metro.f.c.f63576a
                                android.content.Context r6 = r12
                                java.lang.String r7 = "context"
                                kotlin.g.b.k.c(r6, r7)
                                java.lang.String r7 = "CJRAppCommonUtility.getUserId(context)"
                                java.lang.String r1 = "context.applicationContext"
                                if (r5 != 0) goto L_0x020a
                                net.one97.paytm.recharge.common.utils.ax$a r2 = net.one97.paytm.recharge.common.utils.ax.f61521a
                                android.content.Context r2 = r6.getApplicationContext()
                                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
                                com.paytm.utility.f$a r1 = com.paytm.utility.f.a.METRO_PREF
                                com.paytm.b.a.a r1 = net.one97.paytm.recharge.common.utils.ax.a.a(r2, r1)
                                java.lang.String r6 = com.paytm.utility.b.n((android.content.Context) r6)
                                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                                r1.a((java.lang.String) r6, (boolean) r0)
                                goto L_0x023d
                            L_0x020a:
                                java.util.concurrent.CopyOnWriteArraySet r2 = new java.util.concurrent.CopyOnWriteArraySet
                                r3 = r5
                                java.util.Collection r3 = (java.util.Collection) r3
                                r2.<init>(r3)
                                net.one97.paytm.recharge.common.utils.ax$a r3 = net.one97.paytm.recharge.common.utils.ax.f61521a
                                android.content.Context r3 = r6.getApplicationContext()
                                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
                                com.paytm.utility.f$a r1 = com.paytm.utility.f.a.METRO_PREF
                                com.paytm.b.a.a r1 = net.one97.paytm.recharge.common.utils.ax.a.a(r3, r1)
                                java.lang.String r3 = com.paytm.utility.b.n((android.content.Context) r6)
                                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
                                com.google.gsonhtcfix.f r7 = new com.google.gsonhtcfix.f
                                r7.<init>()
                                java.lang.String r7 = r7.a((java.lang.Object) r2)
                                r1.a((java.lang.String) r3, (java.lang.String) r7, (boolean) r0)
                                java.lang.String r6 = com.paytm.utility.b.n((android.content.Context) r6)
                                java.lang.String r7 = "metroActiveTickets"
                                r1.a((java.lang.String) r7, (java.lang.String) r6, (boolean) r0)
                            L_0x023d:
                                net.one97.paytm.recharge.metro.e.b$a r6 = r13
                                if (r6 == 0) goto L_0x0244
                                r6.a(r5, r0)
                            L_0x0244:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.f.a.AnonymousClass1.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
                        }

                        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                            aiVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
                        }
                    }, new CJRActiveTicketsAndPassesModelV2(), hashMap, obj));
                } else {
                    c.a aVar10 = c.f63576a;
                    c.f63584i = null;
                    c.a aVar11 = c.f63576a;
                    c.j = null;
                    if (aVar != null) {
                        aVar.a(null, false);
                    }
                }
            } else if (aVar != null) {
                aVar.a(null, false);
            }
        } else if (aVar != null) {
            aVar.a(null, false);
        }
    }

    static /* synthetic */ void a(Activity activity, String str, CJRItem cJRItem, String str2, String str3, String str4, net.one97.paytm.recharge.common.f.c cVar, CJRRechargeCart cJRRechargeCart, CJRCashWallet cJRCashWallet, ai aiVar, x xVar, Object obj) {
        Activity activity2 = activity;
        ai aiVar2 = aiVar;
        Object obj2 = obj;
        if (cJRCashWallet == null) {
            b("wallet_token", aiVar2, obj2);
        } else if (TextUtils.isEmpty(ax.a(activity.getApplicationContext()).b("sso_token=", "", true))) {
            b("wallet_token", aiVar2, obj2);
        } else if (activity2 != null && (activity2 instanceof Activity)) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            Context applicationContext = activity.getApplicationContext();
            final Activity activity3 = activity;
            final String str5 = str;
            final CJRItem cJRItem2 = cJRItem;
            final String str6 = str2;
            final String str7 = str4;
            final String str8 = str3;
            final net.one97.paytm.recharge.common.f.c cVar2 = cVar;
            final CJRRechargeCart cJRRechargeCart2 = cJRRechargeCart;
            final CJRCashWallet cJRCashWallet2 = cJRCashWallet;
            final ai aiVar3 = aiVar;
            CJRRechargeUtilities cJRRechargeUtilities2 = cJRRechargeUtilities;
            AnonymousClass8 r13 = r0;
            final x xVar2 = xVar;
            AnonymousClass8 r0 = new ai() {
                public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                }

                public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                    a.a(activity3, str5, cJRItem2, str6, str7, str8, cVar2, cJRRechargeCart2, cJRCashWallet2, (CJRPGTokenList) iJRPaytmDataModel, aiVar3, xVar2, obj);
                }
            };
            cJRRechargeUtilities2.fetchWalletToken(applicationContext, new net.one97.paytm.recharge.common.e.b(r13, "wallet_token"));
        }
    }

    static /* synthetic */ List a(CJRRechargeCart cJRRechargeCart) {
        if (cJRRechargeCart.getCart() == null || cJRRechargeCart.getCart().getCartItems() == null || cJRRechargeCart.getCart().getCartItems().size() <= 0) {
            return null;
        }
        return cJRRechargeCart.getCart().getCartItems();
    }
}
