package net.one97.paytm.fastag.dependencies;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.c;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.o;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.CJRSecureSharedPreferences;
import com.paytm.utility.b;
import com.paytm.utility.h;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.replacement.CJRReplacementResponse;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.d.c;
import net.one97.paytm.fastag.d.d;
import net.one97.paytm.fastag.d.g;
import net.one97.paytm.fastag.f.c;
import net.one97.paytm.fastag.model.CJRAction;
import net.one97.paytm.fastag.model.CJRActionResponse;
import net.one97.paytm.fastag.model.CJRCourierContacts;
import net.one97.paytm.fastag.model.CJRExtendTimeModel;
import net.one97.paytm.fastag.model.CJRItemTrackingResponse;
import net.one97.paytm.fastag.model.CJROrderCancel;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderSummaryAction;
import net.one97.paytm.fastag.model.CJROrderSummaryPayment;
import net.one97.paytm.fastag.model.CJROrderSummaryProductDetail;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.fastag.model.CJRSellerCourierCard;
import net.one97.paytm.fastag.model.CJRStatusFlow;
import net.one97.paytm.fastag.model.CJRUrlParams;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.util.UpiConstants;

public final class a implements g.a<IJRPaytmDataModel>, i {

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f13607a = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getBooleanExtra("write_permission_granted", false)) {
                a aVar = a.this;
                aVar.a((Context) aVar.f13610d, a.this.f13610d.getResources().getString(R.string.please_wait_progress_msg));
                a.e(a.this);
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private l f13608b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJRAction f13609c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Activity f13610d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ProgressDialog f13611e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f13612f;

    /* renamed from: g  reason: collision with root package name */
    private String f13613g = "";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CJROrderSummary f13614h;

    /* renamed from: i  reason: collision with root package name */
    private CJROrderedCart f13615i;
    /* access modifiers changed from: private */
    public DownloadManager j;
    /* access modifiers changed from: private */
    public long k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public boolean m = false;
    private String n;
    /* access modifiers changed from: private */
    public String o = null;
    private BroadcastReceiver p = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(new long[]{extras.getLong("extra_download_id")});
            Cursor query2 = a.this.j.query(query);
            if (query2.moveToFirst()) {
                int i2 = query2.getInt(query2.getColumnIndex("status"));
                new StringBuilder().append(i2);
                a.this.a();
                a.c();
                if (i2 == 8) {
                    query2.getString(query2.getColumnIndex("title"));
                    if (longExtra == ((long) query2.getInt(0)) && longExtra == a.this.k) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            final String string = query2.getString(query2.getColumnIndex("local_uri"));
                            new Handler().postDelayed(new Runnable() {
                                public final void run() {
                                    a.this.a(string);
                                }
                            }, 10000);
                        } else {
                            a.this.a(query2.getString(query2.getColumnIndex("local_uri")));
                        }
                    }
                } else if (i2 == 16 && longExtra == ((long) query2.getInt(0)) && longExtra == a.this.k) {
                    new StringBuilder("Reason: ").append(query2.getInt(query2.getColumnIndex(Item.KEY_REASON)));
                }
            }
            a.a(query2);
        }
    };

    static /* synthetic */ void b() {
    }

    static /* synthetic */ void c() {
    }

    public final /* synthetic */ void onResponse(Object obj) {
        CJRReturnCancelError returnCancelError;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel instanceof CJRCourierContacts) {
            CJRCourierContacts cJRCourierContacts = (CJRCourierContacts) iJRPaytmDataModel;
            if (cJRCourierContacts != null && cJRCourierContacts.getContacts().size() > 0) {
                String replaceAll = cJRCourierContacts.getContacts().get(0).getPhone().replaceAll(" ", "");
                if (b(replaceAll)) {
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse("tel:".concat(String.valueOf(replaceAll))));
                    if (intent.resolveActivity(this.f13610d.getPackageManager()) != null) {
                        this.f13610d.startActivity(intent);
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRActionResponse) {
            androidx.localbroadcastmanager.a.a.a((Context) this.f13610d).a(new Intent("ACTION_UPDATE_ORDER_LIST"));
            CJRActionResponse cJRActionResponse = (CJRActionResponse) iJRPaytmDataModel;
            cJRActionResponse.setCancelType(this.n);
            if (cJRActionResponse.getStatus() == 200 && cJRActionResponse.getMessage() != null && TextUtils.isEmpty(cJRActionResponse.getMessage())) {
                l lVar = this.f13608b;
                if (lVar != null) {
                    lVar.a();
                }
                a();
            } else if (cJRActionResponse.getMessage() != null && !TextUtils.isEmpty(cJRActionResponse.getMessage())) {
                a();
                d(cJRActionResponse.getMessage());
            } else if (cJRActionResponse.getActions() != null) {
                ArrayList<CJROrderSummaryAction> actions = cJRActionResponse.getActions();
                if (actions.size() > 0) {
                    CJROrderSummaryAction cJROrderSummaryAction = actions.get(0);
                    if (!TextUtils.isEmpty(cJRActionResponse.getCancelType())) {
                        a(cJRActionResponse.getCancelType(), cJROrderSummaryAction.getUrlParams().getUrl());
                    } else if (cJROrderSummaryAction.getUiControl().equalsIgnoreCase("browser") && cJROrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJROrderSummaryAction.getUrlParams().getUrl())) {
                        new C0186a(cJROrderSummaryAction.getUrlParams().getUrl(), cJRActionResponse.getTitle()).execute(new Void[0]);
                    }
                }
            } else if (!TextUtils.isEmpty(cJRActionResponse.getError())) {
                a();
                d(cJRActionResponse.getError());
            } else {
                a();
            }
        } else if (iJRPaytmDataModel instanceof CJRReplacementResponse) {
            androidx.localbroadcastmanager.a.a.a((Context) this.f13610d).a(new Intent("ACTION_UPDATE_ORDER_LIST"));
            a();
            CJRReplacementResponse cJRReplacementResponse = (CJRReplacementResponse) iJRPaytmDataModel;
            if (!a(cJRReplacementResponse)) {
                String string = this.f13610d.getResources().getString(R.string.replacement_validate_error_message);
                Activity activity = this.f13610d;
                b.b((Context) activity, activity.getResources().getString(R.string.replacement_validate_error_heading), string);
            } else if (this.f13614h != null) {
                Intent intent2 = new Intent(this.f13610d, net.one97.paytm.fastag.c.a.a().f13559b.getReturnReplaceActivity());
                intent2.putExtra("extra_home_data", cJRReplacementResponse);
                intent2.putExtra("fragment_name", "select_reason_fragment");
                intent2.putExtra("shipping_address", this.f13614h.getShippingAddress());
                intent2.putExtra("REFUND_SOURCE_TEXT", this.f13614h.getRefundSourceText());
                CJROrderedCart cJROrderedCart = this.f13615i;
                if (!(cJROrderedCart == null || cJROrderedCart.getProductDetail() == null)) {
                    intent2.putExtra("cart_product", this.f13615i);
                    intent2.putExtra("is_child_order", this.f13615i.isReplacement());
                    if (!TextUtils.isEmpty(this.f13613g)) {
                        intent2.putExtra("extra_replace_title", this.f13613g);
                    }
                    if (!TextUtils.isEmpty(this.f13614h.getId())) {
                        intent2.putExtra("replacement_parent_id", this.f13614h.getId());
                    }
                }
                this.f13610d.startActivityForResult(intent2, 2);
            }
        } else if (iJRPaytmDataModel instanceof CJRItemTrackingResponse) {
            a();
            this.f13608b.a();
        } else if (iJRPaytmDataModel instanceof CJRExtendTimeModel) {
            androidx.localbroadcastmanager.a.a.a((Context) this.f13610d).a(new Intent("ACTION_UPDATE_ORDER_LIST"));
            a();
            CJRExtendTimeModel cJRExtendTimeModel = (CJRExtendTimeModel) iJRPaytmDataModel;
            if ("SUCCESS".equalsIgnoreCase(cJRExtendTimeModel.getmStatus()) && !TextUtils.isEmpty(cJRExtendTimeModel.getmMessage())) {
                this.f13608b.a();
            }
        } else if (iJRPaytmDataModel instanceof CJRReturnReplaceCancel) {
            androidx.localbroadcastmanager.a.a.a((Context) this.f13610d).a(new Intent("ACTION_UPDATE_ORDER_LIST"));
            a();
            CJRReturnReplaceCancel cJRReturnReplaceCancel = (CJRReturnReplaceCancel) iJRPaytmDataModel;
            if ((cJRReturnReplaceCancel == null || !cJRReturnReplaceCancel.getReturnCancelBase().get(0).getResult().equalsIgnoreCase("Success")) && (returnCancelError = cJRReturnReplaceCancel.getReturnCancelBase().get(0).getReturnCancelError()) != null) {
                b.b((Context) this.f13610d, returnCancelError.getErrorTitle(), returnCancelError.getErrorDescription());
            }
        } else if (iJRPaytmDataModel instanceof CJROrderCancel) {
            a();
            CJROrderCancel cJROrderCancel = (CJROrderCancel) iJRPaytmDataModel;
            if (cJROrderCancel.getmStatusCode() == 200) {
                cJROrderCancel.getmMessage();
            }
        }
    }

    public a(l lVar, Activity activity) {
        this.f13608b = lVar;
        this.f13610d = activity;
    }

    public final void a(CJROrderSummary cJROrderSummary, final CJRAction cJRAction, Map<String, Object> map, String str) {
        CJROrderedCart a2;
        this.o = str;
        if (cJRAction != null) {
            this.m = false;
            String type = cJRAction.getType();
            if (TextUtils.isEmpty(type)) {
                return;
            }
            if (type.equalsIgnoreCase("contactcourier")) {
                if (!(cJRAction == null || cJRAction.getUrlParams() == null)) {
                    String replace = c(cJRAction.getUrlParams().getUrl()).replace(" ", "%20");
                    c.a();
                    c.a(new net.one97.paytm.fastag.d.a(replace, this, new d() {
                        public final void onError(Throwable th) {
                            a.a(a.this, th);
                        }
                    }, new CJRCourierContacts(), (Map<String, String>) null));
                }
                a(cJROrderSummary, "item_details_contact_courier_clicked", this.o);
            } else if (type.equalsIgnoreCase("extendtime")) {
                String a3 = new f().a((Object) map);
                this.f13609c = cJRAction;
                CJRUrlParams urlParams = this.f13609c.getUrlParams();
                if (urlParams != null) {
                    String c2 = c(urlParams.getUrl());
                    if (!TextUtils.isEmpty(c2)) {
                        Activity activity = this.f13610d;
                        a((Context) activity, activity.getResources().getString(R.string.please_wait_progress_msg));
                        net.one97.paytm.fastag.d.b bVar = new net.one97.paytm.fastag.d.b(c2, this, new d() {
                            public final void onError(Throwable th) {
                                a.a(a.this, th);
                            }
                        }, new CJRExtendTimeModel(), b.n(), a3, a.C0715a.POST);
                        c.a();
                        c.a(bVar);
                    }
                }
                if (cJROrderSummary != null && (a2 = a(cJROrderSummary.getOrderedCartList(), this.o)) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("item_details_item_state", a(a2));
                    CJROrderSummaryProductDetail productDetail = a2.getProductDetail();
                    if (productDetail != null) {
                        hashMap.put("item_details_vertical_label", productDetail.getVertical() + "");
                    }
                    hashMap.put("item_details_order_id", a2.getOrderId() + "");
                    hashMap.put("item_details_item_id", a2.getId() + "");
                    hashMap.put("item_details_extended_days", hashMap.get("numberOfDays") + "");
                    net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventWithMap("item_details_extend_time_clicked", hashMap, this.f13610d);
                }
            } else {
                CJROrderedCart cJROrderedCart = null;
                if (type.equalsIgnoreCase("escalatepaytm")) {
                    try {
                        if (this.f13614h != null) {
                            cJROrderedCart = a(this.f13614h.getOrderedCartList(), str);
                            cJROrderedCart.setOrderId(this.f13614h.getId());
                        }
                        Intent intent = new Intent(net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext(), net.one97.paytm.fastag.c.a.a().f13559b.getAJRCSTOrderIssues());
                        intent.putExtra(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
                        this.f13610d.startActivity(intent);
                    } catch (Exception unused) {
                    }
                    a(cJROrderSummary, "item_details_escalate_to_paytm_clicked", this.o);
                } else if (type.equalsIgnoreCase("orderdetail")) {
                    a(cJROrderSummary, "item_details_view_order_details_clicked", this.o);
                    Intent intent2 = new Intent(this.f13610d, net.one97.paytm.fastag.c.a.a().f13559b.getOrderDetailsActivity());
                    intent2.addFlags(131072);
                    intent2.putExtra("order_id", (String) map.get("order_id"));
                    this.f13610d.startActivity(intent2);
                    this.m = true;
                } else if (type.equalsIgnoreCase("returnpolicy")) {
                    if (this.f13614h != null) {
                        CJROrderedCart a4 = a(cJROrderSummary.getOrderedCartList(), this.o);
                        if (a4 != null) {
                            String returnPolicyText = a4.getProductDetail().getReturnPolicyText();
                            if (!this.f13612f) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(this.f13610d);
                                builder.setMessage(returnPolicyText).setCancelable(false);
                                builder.setPositiveButton(this.f13610d.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        dialogInterface.cancel();
                                        boolean unused = a.this.f13612f = false;
                                    }
                                });
                                builder.show();
                                this.f13612f = true;
                            }
                        }
                        a(cJROrderSummary, "item_details_view_refund_policy_clicked", this.o);
                    }
                    this.m = true;
                } else if (type.equalsIgnoreCase("openbrowser") || type.equalsIgnoreCase("itemTrackingV2")) {
                    CJRUrlParams urlParams2 = cJRAction.getUrlParams();
                    if (urlParams2 != null) {
                        String url = urlParams2.getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            Intent intent3 = new Intent(this.f13610d, net.one97.paytm.fastag.c.a.a().f13559b.getDetailedItemTrackingClass());
                            intent3.putExtra("TRACKING_URL", url);
                            this.f13610d.startActivity(intent3);
                        }
                    }
                    a(cJROrderSummary, "item_details_view_tracking_details_clicked", this.o);
                    this.m = true;
                } else if (type.equalsIgnoreCase("rateseller")) {
                    CJROrderedCart cJROrderedCart2 = (CJROrderedCart) map.get("KEY_ORDERED_CART");
                    Intent intent4 = new Intent(this.f13610d, net.one97.paytm.fastag.c.a.a().f13559b.getAJRSellarRating());
                    intent4.putExtra("item_id", cJROrderedCart2.getId());
                    intent4.putExtra("merchant_id", cJROrderedCart2.getMerchantId());
                    this.f13610d.startActivity(intent4);
                } else if (type.equalsIgnoreCase("returnreplacev2")) {
                    a(cJROrderSummary, "item_details_return_or_replace_clicked", this.o);
                    this.f13615i = a(cJROrderSummary.getOrderedCartList(), this.o);
                    this.f13613g = cJRAction.getLabel();
                    this.m = true;
                    a(cJRAction, true, false, false);
                } else if ("installation".equalsIgnoreCase(type)) {
                    CJRUrlParams urlParams3 = cJRAction.getUrlParams();
                    Intent intent5 = new Intent(this.f13610d, net.one97.paytm.fastag.c.a.a().f13559b.getAJRInstallationDetails());
                    intent5.putExtra("intent_extra_installation_services", urlParams3.getUrl());
                    this.f13610d.startActivity(intent5);
                } else if ("cancelreturnrequest".equalsIgnoreCase(type)) {
                    this.f13615i = a(cJROrderSummary.getOrderedCartList(), this.o);
                    this.f13613g = cJRAction.getLabel();
                    this.m = true;
                    a(cJRAction, false, true, false);
                } else if (type.equalsIgnoreCase("preshipcancel") || type.equalsIgnoreCase("shipcancel")) {
                    this.n = type;
                    this.m = true;
                    a(cJRAction, false, false, false);
                } else if (type.equalsIgnoreCase("cancelpdcandreqagain")) {
                } else {
                    if ("pickupcode".equalsIgnoreCase(type)) {
                        CJROrderedCart a5 = a(cJROrderSummary.getOrderedCartList(), this.o);
                        if (a5 != null && a5.getTrackingParams() != null) {
                            String errorTitle = cJRAction.getErrorTitle();
                            String errorText = cJRAction.getErrorText();
                            String str2 = a5.getTrackingParams().getmPickupCode();
                            Activity activity2 = this.f13610d;
                            if (activity2 != null) {
                                AlertDialog.Builder builder2 = new AlertDialog.Builder(activity2);
                                View inflate = this.f13610d.getLayoutInflater().inflate(R.layout.alert_dialog_view_pickup_code_ft, (ViewGroup) null);
                                builder2.setInverseBackgroundForced(true);
                                builder2.setView(inflate);
                                final AlertDialog show = builder2.show();
                                show.setCancelable(false);
                                int i2 = (int) (((double) this.f13610d.getResources().getDisplayMetrics().widthPixels) * 0.8d);
                                if (show.getWindow() != null) {
                                    show.getWindow().setLayout(i2, -2);
                                    TextView textView = (TextView) inflate.findViewById(R.id.title);
                                    TextView textView2 = (TextView) inflate.findViewById(R.id.text_tv);
                                    TextView textView3 = (TextView) inflate.findViewById(R.id.code_tv);
                                    if (!TextUtils.isEmpty(errorTitle)) {
                                        textView.setText(errorTitle);
                                    }
                                    if (!TextUtils.isEmpty(errorText)) {
                                        textView2.setText(errorText);
                                    }
                                    if (!TextUtils.isEmpty(str2)) {
                                        textView3.setText(str2);
                                    } else {
                                        textView3.setVisibility(8);
                                        textView2.setText(R.string.pickup_code_error_msg);
                                    }
                                    inflate.findViewById(R.id.ok_tv).setOnClickListener(new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            if (show.isShowing()) {
                                                show.dismiss();
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    } else if (type.equalsIgnoreCase("cancelorderitem")) {
                        Activity activity3 = this.f13610d;
                        String string = activity3.getResources().getString(R.string.recharge_payment_cancel_order);
                        String string2 = this.f13610d.getResources().getString(R.string.order_cancel_confirm_label);
                        AnonymousClass1 r3 = new c.a() {
                            public final void a() {
                                boolean unused = a.this.m = true;
                                a aVar = a.this;
                                CJROrderSummary unused2 = aVar.f13614h;
                                String unused3 = a.this.o;
                                a.a(aVar, CommonPayParams.Builder.YES);
                                a.this.a(cJRAction, false, false, true);
                            }

                            public final void b() {
                                boolean unused = a.this.m = true;
                                a aVar = a.this;
                                CJROrderSummary unused2 = aVar.f13614h;
                                String unused3 = a.this.o;
                                a.a(aVar, CommonPayParams.Builder.NO);
                            }
                        };
                        if (!net.one97.paytm.fastag.f.c.f13765a && activity3 != null && (activity3 instanceof Activity) && !activity3.isFinishing()) {
                            h hVar = new h(activity3);
                            if (string != null) {
                                hVar.setTitle(string);
                            }
                            if (string2 != null) {
                                hVar.a(string2);
                            }
                            hVar.setCancelable(false);
                            WindowManager.LayoutParams a6 = net.one97.paytm.fastag.f.c.a(hVar);
                            hVar.a(-1, activity3.getString(R.string.ok_text), new View.OnClickListener(hVar, r3) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ h f13766a;

                                /* renamed from: b  reason: collision with root package name */
                                final /* synthetic */ a f13767b;

                                {
                                    this.f13766a = r1;
                                    this.f13767b = r2;
                                }

                                public final void onClick(View view) {
                                    this.f13766a.cancel();
                                    c.f13765a = false;
                                    a aVar = this.f13767b;
                                    if (aVar != null) {
                                        aVar.a();
                                    }
                                }
                            });
                            hVar.a(-2, activity3.getString(R.string.cancel), new View.OnClickListener(hVar, r3) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ h f13768a;

                                /* renamed from: b  reason: collision with root package name */
                                final /* synthetic */ a f13769b;

                                {
                                    this.f13768a = r1;
                                    this.f13769b = r2;
                                }

                                public final void onClick(View view) {
                                    this.f13768a.cancel();
                                    c.f13765a = false;
                                    a aVar = this.f13769b;
                                    if (aVar != null) {
                                        aVar.b();
                                    }
                                }
                            });
                            hVar.show();
                            if (a6 != null) {
                                hVar.getWindow().setAttributes(a6);
                            }
                            net.one97.paytm.fastag.f.c.f13765a = true;
                        }
                    } else if (type.equalsIgnoreCase("escalatepaytm2")) {
                        b(cJROrderSummary);
                    } else {
                        this.f13613g = cJRAction.getLabel();
                        this.m = true;
                        a(cJRAction, false, false, false);
                    }
                }
            }
        }
    }

    private static String a(CJRSellerCourierCard cJRSellerCourierCard) {
        if (!(cJRSellerCourierCard == null || cJRSellerCourierCard.getStatusFlow() == null || cJRSellerCourierCard.getStatusFlow().size() <= 0)) {
            Iterator<CJRStatusFlow> it2 = cJRSellerCourierCard.getStatusFlow().iterator();
            while (it2.hasNext()) {
                CJRStatusFlow next = it2.next();
                if (next.ismIsCurrentStatus()) {
                    return next.getText();
                }
            }
        }
        return "";
    }

    private static String a(CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart == null || cJROrderedCart.getCards() == null) {
            return "";
        }
        String a2 = a(cJROrderedCart.getCards().getSellerCard());
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return a(cJROrderedCart.getCards().getCourierCard());
    }

    private void a(CJROrderSummary cJROrderSummary, String str, String str2) {
        CJROrderedCart a2;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0 && (a2 = a(cJROrderSummary.getOrderedCartList(), str2)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_details_item_state", a(a2));
            CJROrderSummaryProductDetail productDetail = a2.getProductDetail();
            if (productDetail != null) {
                hashMap.put("item_details_vertical_label", productDetail.getVertical() + "");
            }
            hashMap.put("item_details_order_id", cJROrderSummary.getId() + "");
            hashMap.put("item_details_item_id", a2.getId() + "");
            net.one97.paytm.fastag.c.b bVar = net.one97.paytm.fastag.c.a.a().f13559b;
            bVar.sendCustomEventWithMap(str + "", hashMap, this.f13610d);
        }
    }

    public final void a(CJROrderSummary cJROrderSummary, CJROrderedCart cJROrderedCart, CJROrderSummaryAction cJROrderSummaryAction) {
        if (cJROrderSummaryAction != null && "Replace_Item".equalsIgnoreCase(cJROrderSummaryAction.getActionName())) {
            this.f13615i = cJROrderedCart;
            this.f13614h = cJROrderSummary;
            try {
                if (cJROrderSummaryAction.getUrlParams() == null || cJROrderSummaryAction.getUrlParams().getMethod() == null || !cJROrderSummaryAction.getUrlParams().getMethod().equalsIgnoreCase("POST")) {
                    this.f13613g = cJROrderSummaryAction.getLabel();
                    a(cJROrderSummaryAction.getUrlParams().getUrl(), true);
                    a(cJROrderSummary, "item_details_return_or_replace_clicked", this.o);
                }
                String str = null;
                if (cJROrderSummaryAction.getUrlParams().getBody() != null) {
                    str = cJROrderSummaryAction.getUrlParams().getBody().toString();
                }
                this.f13613g = cJROrderSummaryAction.getLabel();
                a(cJROrderSummaryAction.getUrlParams().getUrl(), str, true, false, false);
                a(cJROrderSummary, "item_details_return_or_replace_clicked", this.o);
            } catch (Exception e2) {
                if (b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(CJRAction cJRAction, boolean z, boolean z2, boolean z3) {
        this.f13609c = cJRAction;
        CJRUrlParams urlParams = cJRAction.getUrlParams();
        if (urlParams != null) {
            String url = urlParams.getUrl();
            String method = urlParams.getMethod();
            if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(method)) {
                if (method.equalsIgnoreCase(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD)) {
                    a(url, z);
                } else if (method.equalsIgnoreCase("POST")) {
                    o body = urlParams.getBody();
                    a(url, body != null ? body.toString() : null, z, z2, z3);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[Catch:{ Exception -> 0x003a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(net.one97.paytm.common.entity.replacement.CJRReplacementResponse r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x003f
            java.util.ArrayList r1 = r3.getL1ReasonList()     // Catch:{ Exception -> 0x003a }
            if (r1 == 0) goto L_0x003f
            java.util.ArrayList r1 = r3.getL1ReasonList()     // Catch:{ Exception -> 0x003a }
            int r1 = r1.size()     // Catch:{ Exception -> 0x003a }
            if (r1 <= 0) goto L_0x003f
            java.util.ArrayList r3 = r3.getL1ReasonList()     // Catch:{ Exception -> 0x003a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x003a }
        L_0x001b:
            boolean r1 = r3.hasNext()     // Catch:{ Exception -> 0x003a }
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r3.next()     // Catch:{ Exception -> 0x003a }
            net.one97.paytm.common.entity.replacement.CJRReplacementReason r1 = (net.one97.paytm.common.entity.replacement.CJRReplacementReason) r1     // Catch:{ Exception -> 0x003a }
            if (r1 == 0) goto L_0x003f
            java.util.ArrayList r2 = r1.getChildList()     // Catch:{ Exception -> 0x003a }
            if (r2 == 0) goto L_0x003f
            java.util.ArrayList r1 = r1.getChildList()     // Catch:{ Exception -> 0x003a }
            int r1 = r1.size()     // Catch:{ Exception -> 0x003a }
            if (r1 != 0) goto L_0x001b
            goto L_0x003f
        L_0x003a:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003e:
            r0 = 1
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.dependencies.a.a(net.one97.paytm.common.entity.replacement.CJRReplacementResponse):boolean");
    }

    private static boolean b(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (Exception | NumberFormatException unused) {
            return false;
        }
    }

    private static String c(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if (parse == null) {
            str2 = str + AppConstants.AND_SIGN;
        } else if (parse.getQuery() != null) {
            str2 = str + AppConstants.AND_SIGN;
        } else {
            str2 = str + "?";
        }
        return str2 + "sso_token=" + CJRSecureSharedPreferences.getInstance(net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext()).getString("sso_token=", "");
    }

    private void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        Activity activity = this.f13610d;
        a((Context) activity, activity.getResources().getString(R.string.please_wait_progress_msg));
        String b2 = b.b(c(str).replace(" ", "%20"), (Context) this.f13610d);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        HashMap<String, String> a2 = b.a((HashMap<String, String>) hashMap, (Context) this.f13610d);
        if (z) {
            net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext();
            net.one97.paytm.fastag.d.c.a();
            net.one97.paytm.fastag.d.c.a(new net.one97.paytm.fastag.d.b(b2, this, new d() {
                public final void onError(Throwable th) {
                    a.a(a.this, th);
                }
            }, new CJRReplacementResponse(), a2, str2, a.C0715a.POST));
        } else if (z2) {
            net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext();
            net.one97.paytm.fastag.d.c.a();
            net.one97.paytm.fastag.d.c.a(new net.one97.paytm.fastag.d.b(b2, this, new d() {
                public final void onError(Throwable th) {
                    a.a(a.this, th);
                }
            }, new CJRReturnReplaceCancel(), a2, str2, a.C0715a.POST));
        } else if (z3) {
            net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext();
            net.one97.paytm.fastag.d.c.a();
            net.one97.paytm.fastag.d.c.a(new net.one97.paytm.fastag.d.b(b2, this, new d() {
                public final void onError(Throwable th) {
                    a.a(a.this, th);
                }
            }, new CJROrderCancel(), a2, str2, a.C0715a.POST));
        } else {
            net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext();
            net.one97.paytm.fastag.d.c.a();
            net.one97.paytm.fastag.d.c.a(new net.one97.paytm.fastag.d.b(b2, this, new d() {
                public final void onError(Throwable th) {
                    a.a(a.this, th);
                }
            }, new CJRActionResponse(), a2, str2, a.C0715a.POST));
        }
    }

    private void a(String str, boolean z) {
        Activity activity = this.f13610d;
        a((Context) activity, activity.getResources().getString(R.string.please_wait_progress_msg));
        String replace = c(str).replace(" ", "%20");
        if (z) {
            net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext();
            net.one97.paytm.fastag.d.c.a();
            net.one97.paytm.fastag.d.c.a(new net.one97.paytm.fastag.d.a(replace, this, new d() {
                public final void onError(Throwable th) {
                    a.a(a.this, th);
                }
            }, new CJRReplacementResponse(), (Map<String, String>) null));
            return;
        }
        CJRActionResponse cJRActionResponse = new CJRActionResponse();
        net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext();
        net.one97.paytm.fastag.d.c.a();
        net.one97.paytm.fastag.d.c.a(new net.one97.paytm.fastag.d.a(replace, this, new d() {
            public final void onError(Throwable th) {
                a.a(a.this, th);
            }
        }, cJRActionResponse, (Map<String, String>) null));
    }

    /* renamed from: net.one97.paytm.fastag.dependencies.a$a  reason: collision with other inner class name */
    public class C0186a extends AsyncTask<Void, Void, String> {

        /* renamed from: b  reason: collision with root package name */
        private String f13635b;

        /* renamed from: c  reason: collision with root package name */
        private String f13636c;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (str != null) {
                try {
                    if (str.equalsIgnoreCase("application/pdf")) {
                        String unused = a.this.l = this.f13635b;
                        a.e(a.this);
                        return;
                    }
                } catch (Exception unused2) {
                    return;
                }
            }
            if (str == null || str.equalsIgnoreCase("application/xml")) {
                a.this.a();
                a.c();
                b.b((Context) a.this.f13610d, a.this.f13610d.getString(R.string.error), a.this.f13610d.getString(R.string.invoice_dwnld_error));
                return;
            }
            a.b();
            a.this.a();
            Intent intent = new Intent(a.this.f13610d, net.one97.paytm.fastag.c.a.a().f13559b.getAJRWebViewActivity());
            intent.putExtra("url", this.f13635b);
            if (!TextUtils.isEmpty(this.f13636c)) {
                intent.putExtra("title", this.f13636c);
            } else if (a.this.f13609c != null) {
                intent.putExtra("title", a.this.f13609c.getLabel());
            } else {
                intent.putExtra("title", "Invoice");
            }
            intent.putExtra(UpiConstants.FROM, "Order_summary");
            a.this.f13610d.startActivity(intent);
        }

        public C0186a(String str, String str2) {
            this.f13636c = str2;
            this.f13635b = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x003b A[Catch:{ Exception -> 0x0055 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String a() {
            /*
                r5 = this;
                net.one97.paytm.fastag.dependencies.a r0 = net.one97.paytm.fastag.dependencies.a.this     // Catch:{ Exception -> 0x0055 }
                android.app.ProgressDialog r0 = r0.f13611e     // Catch:{ Exception -> 0x0055 }
                r1 = 1
                if (r0 == 0) goto L_0x0012
                net.one97.paytm.fastag.dependencies.a r0 = net.one97.paytm.fastag.dependencies.a.this     // Catch:{ Exception -> 0x0055 }
                android.app.ProgressDialog r0 = r0.f13611e     // Catch:{ Exception -> 0x0055 }
                r0.setCancelable(r1)     // Catch:{ Exception -> 0x0055 }
            L_0x0012:
                java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x0055 }
                java.lang.String r2 = r5.f13635b     // Catch:{ Exception -> 0x0055 }
                r0.<init>(r2)     // Catch:{ Exception -> 0x0055 }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x0055 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0055 }
                r2 = 0
                r0.setInstanceFollowRedirects(r2)     // Catch:{ Exception -> 0x0055 }
                int r3 = r0.getResponseCode()     // Catch:{ Exception -> 0x0055 }
                r4 = 200(0xc8, float:2.8E-43)
                if (r3 == r4) goto L_0x0038
                r4 = 302(0x12e, float:4.23E-43)
                if (r3 == r4) goto L_0x0039
                r4 = 301(0x12d, float:4.22E-43)
                if (r3 == r4) goto L_0x0039
                r4 = 303(0x12f, float:4.25E-43)
                if (r3 != r4) goto L_0x0038
                goto L_0x0039
            L_0x0038:
                r1 = 0
            L_0x0039:
                if (r1 == 0) goto L_0x0050
                java.lang.String r1 = "Location"
                java.lang.String r0 = r0.getHeaderField(r1)     // Catch:{ Exception -> 0x0055 }
                r5.f13635b = r0     // Catch:{ Exception -> 0x0055 }
                java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x0055 }
                java.lang.String r1 = r5.f13635b     // Catch:{ Exception -> 0x0055 }
                r0.<init>(r1)     // Catch:{ Exception -> 0x0055 }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x0055 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0055 }
            L_0x0050:
                java.lang.String r0 = r0.getContentType()     // Catch:{ Exception -> 0x0055 }
                goto L_0x005e
            L_0x0055:
                r0 = move-exception
                boolean r1 = com.paytm.utility.b.v
                if (r1 == 0) goto L_0x005d
                r0.printStackTrace()
            L_0x005d:
                r0 = 0
            L_0x005e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.dependencies.a.C0186a.a():java.lang.String");
        }
    }

    public final void a(Context context, String str) {
        if (context != null || this.f13610d.isFinishing()) {
            ProgressDialog progressDialog = this.f13611e;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f13611e = new ProgressDialog(context);
                try {
                    this.f13611e.setProgressStyle(0);
                    this.f13611e.setMessage(str);
                    this.f13611e.setCancelable(false);
                    this.f13611e.setCanceledOnTouchOutside(false);
                    this.f13611e.show();
                } catch (IllegalArgumentException e2) {
                    if (b.v) {
                        e2.printStackTrace();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void a() {
        ProgressDialog progressDialog = this.f13611e;
        if (progressDialog != null && progressDialog.isShowing() && !this.f13610d.isFinishing()) {
            this.f13611e.dismiss();
            this.f13611e = null;
        }
    }

    private void d(String str) {
        if (!this.f13612f) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f13610d);
            builder.setMessage(str).setCancelable(false);
            builder.setPositiveButton(this.f13610d.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    boolean unused = a.this.f13612f = false;
                    a.b();
                }
            });
            builder.show();
            this.f13612f = true;
        }
    }

    private static CJROrderedCart a(ArrayList<CJROrderedCart> arrayList, String str) {
        if (arrayList == null) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (str.equalsIgnoreCase(String.valueOf(arrayList.get(i2).getId()))) {
                return arrayList.get(i2);
            }
        }
        return null;
    }

    private void b(final CJROrderSummary cJROrderSummary) {
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0) {
            if (cJROrderSummary.getOrderedCartList().size() >= 2) {
                c.a aVar = new c.a(this.f13610d);
                aVar.a((CharSequence) this.f13610d.getString(R.string.contact_us_title_query_regarding));
                ArrayAdapter arrayAdapter = new ArrayAdapter(this.f13610d, 17367058);
                for (int i2 = 0; i2 < cJROrderSummary.getOrderedCartList().size(); i2++) {
                    arrayAdapter.add(cJROrderSummary.getOrderedCartList().get(i2).getName());
                }
                aVar.b((CharSequence) this.f13610d.getString(R.string.cancel), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                aVar.a((ListAdapter) arrayAdapter, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        a.this.a(i2, cJROrderSummary);
                    }
                });
                aVar.b();
                return;
            }
            a(0, cJROrderSummary);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, CJROrderSummary cJROrderSummary) {
        CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(i2);
        cJROrderedCart.setOrderId(cJROrderSummary.getId());
        Intent intent = new Intent(net.one97.paytm.fastag.c.a.a().f13559b.getApplicationContext(), net.one97.paytm.fastag.c.a.a().f13559b.getAJRCSTOrderIssues());
        intent.putExtra(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
        this.f13610d.startActivity(intent);
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        this.f13614h = cJROrderSummary;
    }

    private void d() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f13610d);
            builder.setMessage(this.f13610d.getResources().getString(R.string.enable_download_manager_permission_alert_msg));
            builder.setPositiveButton(this.f13610d.getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f13632a = false;

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (this.f13632a) {
                        s.b((Context) a.this.f13610d);
                        a.this.f13610d.finish();
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:com.android.providers.downloads"));
                        a.this.f13610d.startActivity(intent);
                    } catch (ActivityNotFoundException e2) {
                        e2.printStackTrace();
                        a.this.f13610d.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }
            });
            builder.setNegativeButton(this.f13610d.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            builder.show();
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        android.widget.Toast.makeText(r2.f13610d, r2.f13610d.getResources().getString(net.one97.paytm.fastag.R.string.no_pdf_view_msg), 0).show();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0038
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0038 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0038 }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r1 = "application/pdf"
            r0.setDataAndType(r3, r1)     // Catch:{ Exception -> 0x0038 }
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r0.setFlags(r3)     // Catch:{ Exception -> 0x0038 }
            r3 = 1
            r0.setFlags(r3)     // Catch:{ Exception -> 0x0038 }
            android.app.Activity r3 = r2.f13610d     // Catch:{ ActivityNotFoundException -> 0x0021 }
            r3.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0021 }
            return
        L_0x0021:
            android.app.Activity r3 = r2.f13610d     // Catch:{ Exception -> 0x0038 }
            android.app.Activity r0 = r2.f13610d     // Catch:{ Exception -> 0x0038 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0038 }
            int r1 = net.one97.paytm.fastag.R.string.no_pdf_view_msg     // Catch:{ Exception -> 0x0038 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0038 }
            r1 = 0
            android.widget.Toast r3 = android.widget.Toast.makeText(r3, r0, r1)     // Catch:{ Exception -> 0x0038 }
            r3.show()     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.dependencies.a.a(java.lang.String):void");
    }

    private void a(String str, String str2) {
        CJROrderedCart cJROrderedCart;
        a();
        CJROrderSummary cJROrderSummary = this.f13614h;
        boolean z = false;
        if (cJROrderSummary != null) {
            cJROrderedCart = a(cJROrderSummary.getOrderedCartList(), this.o);
            ArrayList<CJROrderSummaryPayment> paymentInfo = this.f13614h.getPaymentInfo();
            if (paymentInfo != null && !paymentInfo.isEmpty()) {
                Iterator<CJROrderSummaryPayment> it2 = paymentInfo.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if ("COD".equalsIgnoreCase(it2.next().getPaymentMethod())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            cJROrderedCart = null;
        }
        Intent intent = new Intent(this.f13610d, net.one97.paytm.fastag.c.a.a().f13559b.getAJRCancelItemAcitivityClass());
        b bVar = new b();
        bVar.setItemId(this.o);
        bVar.setOrderId(this.f13614h.getId());
        bVar.setItemImageUrl(cJROrderedCart.getProductDetail().getThumbnail());
        bVar.setItemName(cJROrderedCart.getName());
        bVar.setProductAttributes(cJROrderedCart.getAttributes());
        bVar.setPaidAmount(cJROrderedCart.getSubTotal() + Double.valueOf(cJROrderedCart.getShippingCharge()).doubleValue());
        bVar.setCashbackModelList(cJROrderedCart.getLifafaCashbackModle());
        bVar.setRefundSourceText(this.f13614h.getRefundSourceText());
        bVar.setCashbackCreditedText(cJROrderedCart.getCashbackDescription());
        bVar.setFetchReasonAPI(str2);
        if ("preshipcancel".equalsIgnoreCase(str)) {
            bVar.setPreshipCancel(true);
        }
        intent.putExtra("KEY_CANCELED_ITEM_STATUS", bVar);
        if (!(cJROrderedCart == null || cJROrderedCart.getProductDetail() == null)) {
            intent.putExtra("cart_product", cJROrderedCart);
            intent.putExtra("COD", z);
        }
        this.f13610d.startActivity(intent);
    }

    static /* synthetic */ void a(a aVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/ordersummary");
        hashMap.put("event_category", "order_summary");
        hashMap.put("event_action", "cancel_payment_confirmation");
        hashMap.put("event_label", "cancel_".concat(String.valueOf(str)));
        net.one97.paytm.fastag.c.a.a().f13559b.sendCustomGTMEventForOrderCancel(aVar.f13610d, hashMap);
    }

    static /* synthetic */ void a(a aVar, final Throwable th) {
        aVar.a();
        aVar.f13610d.runOnUiThread(new Runnable() {
            public final void run() {
            }
        });
    }

    static /* synthetic */ void e(a aVar) {
        boolean z;
        long j2;
        if (s.a() && !s.c(aVar.f13610d)) {
            aVar.a();
            androidx.localbroadcastmanager.a.a.a((Context) aVar.f13610d).a(aVar.f13607a, new IntentFilter("write_permission"));
            s.b(aVar.f13610d);
        } else if (aVar.l != null) {
            aVar.f13610d.registerReceiver(aVar.p, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            Uri parse = Uri.parse(aVar.l);
            int applicationEnabledSetting = aVar.f13610d.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
            if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
                aVar.d();
                z = false;
            } else {
                z = true;
            }
            if (!z || !"mounted".equals(Environment.getExternalStorageState())) {
                aVar.a();
                j2 = 0;
            } else {
                aVar.j = (DownloadManager) aVar.f13610d.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                DownloadManager.Request request = new DownloadManager.Request(parse);
                request.setTitle("Invoice");
                request.setDescription("Downloading...");
                Activity activity = aVar.f13610d;
                String str = Environment.DIRECTORY_DOWNLOADS;
                request.setDestinationInExternalFilesDir(activity, str, "Invoice" + aVar.f13614h.getId() + ".pdf");
                request.setNotificationVisibility(1);
                j2 = aVar.j.enqueue(request);
                new StringBuilder("request queued at ").append(System.currentTimeMillis());
            }
            aVar.k = j2;
        }
    }

    static /* synthetic */ void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }
}
