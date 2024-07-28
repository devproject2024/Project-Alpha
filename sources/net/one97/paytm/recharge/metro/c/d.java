package net.one97.paytm.recharge.metro.c;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gsonhtcfix.o;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.e;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.b;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.model.metro.CJRMetroRefundDescriptionModel;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.f.g;
import net.one97.paytm.recharge.ordersummary.h.b;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.UpiConstants;

public final class d extends f implements View.OnClickListener, ai, g {

    /* renamed from: a  reason: collision with root package name */
    CJRMetroRefundDescriptionModel f63304a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJRMetroRefundDescriptionModel.CJRAmountDescription> f63305b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ProgressBar f63306c;

    /* renamed from: d  reason: collision with root package name */
    RecyclerView f63307d;

    /* renamed from: e  reason: collision with root package name */
    TextView f63308e;

    /* renamed from: f  reason: collision with root package name */
    final int f63309f = 106;

    /* renamed from: g  reason: collision with root package name */
    private ProgressDialog f63310g;

    /* renamed from: h  reason: collision with root package name */
    private String f63311h;

    /* renamed from: i  reason: collision with root package name */
    private String f63312i;
    private boolean j = true;
    private boolean k;
    private final int l = 108;
    private String m;
    private String n;
    private String o;
    private net.one97.paytm.recharge.ordersummary.h.d p;
    private HashMap q;

    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        super.onCreate(bundle);
        boolean z = false;
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
        try {
            b bVar = b.f62652a;
            b.a((Context) getActivity(), "mumbai metro qr", "qr_popup", "", "", "", "utility");
        } catch (Throwable unused) {
        }
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            String str4 = null;
            this.f63311h = arguments != null ? arguments.getString(StringSet.operator) : null;
            if (!TextUtils.isEmpty(this.f63311h)) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null || arguments2.containsKey("order_id")) {
                    Bundle arguments3 = getArguments();
                    if (arguments3 == null || arguments3.containsKey(CLPConstants.PRODUCT_ID)) {
                        Bundle arguments4 = getArguments();
                        this.f63312i = arguments4 != null ? arguments4.getString("product-type") : null;
                        Bundle arguments5 = getArguments();
                        if (arguments5 == null || (str = arguments5.getString("metro_operator")) == null) {
                            str = "";
                        }
                        this.o = str;
                        if (!TextUtils.isEmpty(this.f63312i)) {
                            if (getContext() != null) {
                                Context context = getContext();
                                if (context == null) {
                                    k.a();
                                }
                                k.a((Object) context, "context!!");
                                this.p = new net.one97.paytm.recharge.ordersummary.h.d(context);
                            }
                            if (!c.e.TP.getValue().equals(this.f63312i) && !c.e.TRIP_PASS.getValue().equals(this.f63312i)) {
                                z = true;
                            }
                            this.j = z;
                            CJRMetroRefundDescriptionModel cJRMetroRefundDescriptionModel = this.f63304a;
                            if ((cJRMetroRefundDescriptionModel != null ? cJRMetroRefundDescriptionModel.getAmountDestribution() : null) != null) {
                                this.f63305b.clear();
                                ArrayList<CJRMetroRefundDescriptionModel.CJRAmountDescription> arrayList = this.f63305b;
                                CJRMetroRefundDescriptionModel cJRMetroRefundDescriptionModel2 = this.f63304a;
                                List<CJRMetroRefundDescriptionModel.CJRAmountDescription> amountDestribution = cJRMetroRefundDescriptionModel2 != null ? cJRMetroRefundDescriptionModel2.getAmountDestribution() : null;
                                if (amountDestribution == null) {
                                    k.a();
                                }
                                arrayList.addAll(amountDestribution);
                            }
                            Bundle arguments6 = getArguments();
                            if (arguments6 != null && arguments6.containsKey("metro_event_label")) {
                                Bundle arguments7 = getArguments();
                                this.n = arguments7 != null ? arguments7.getString("metro_event_label") : null;
                            }
                            Bundle arguments8 = getArguments();
                            if (arguments8 != null && arguments8.containsKey("metro_event_category")) {
                                Bundle arguments9 = getArguments();
                                if (arguments9 != null) {
                                    str4 = arguments9.getString("metro_event_category");
                                }
                                this.m = str4;
                            }
                            net.one97.paytm.recharge.ordersummary.h.d dVar = this.p;
                            if (dVar != null) {
                                String str5 = this.m;
                                if (str5 == null) {
                                    str2 = "";
                                } else {
                                    str2 = str5;
                                }
                                String str6 = this.n;
                                if (str6 == null) {
                                    str3 = "";
                                } else {
                                    str3 = str6;
                                }
                                String str7 = ab.f61496a;
                                k.a((Object) str7, "CJRRechargeUtilityConstant.UTILITY");
                                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, str2, "cancel_metro_qr_ticket_popup_loaded", "", str3, str7, (Object) null, (Object) null, 96);
                                return;
                            }
                            return;
                        }
                        throw new RuntimeException("Ticket type expected");
                    }
                    throw new RuntimeException("Ticket PRODUCT_ID expected");
                }
                throw new RuntimeException("Ticket order_id expected");
            }
            throw new RuntimeException("Ticket-QR-Codes title expected");
        }
        throw new RuntimeException("Argument expected");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_qr_cancel_bottomsheet_dialog, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        SpannableString spannableString;
        Integer num;
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.title);
        if (findViewById != null) {
            ((TextView) findViewById).setText(this.f63311h);
            View findViewById2 = view.findViewById(R.id.text_qr_ticket_info);
            if (findViewById2 != null) {
                TextView textView = (TextView) findViewById2;
                String str = this.f63312i;
                String str2 = null;
                if (k.a((Object) str, (Object) c.e.SVP.getValue()) || k.a((Object) str, (Object) c.e.STORE_VALUE.getValue())) {
                    Context context = getContext();
                    spannableString = new SpannableString(context != null ? context.getString(R.string.svp_cancel_info) : null);
                } else if (k.a((Object) str, (Object) c.e.TP.getValue()) || k.a((Object) str, (Object) c.b.TRIPPASS.getValue()) || k.a((Object) str, (Object) c.b.TRIPPASS_10.getValue()) || k.a((Object) str, (Object) c.b.TRIPPASS_30.getValue()) || k.a((Object) str, (Object) c.b.TRIPPASS_45.getValue()) || k.a((Object) str, (Object) c.e.TRIP_PASS.getValue())) {
                    Context context2 = getContext();
                    String string = context2 != null ? context2.getString(R.string.tp_cancel_info_infix) : null;
                    Context context3 = getContext();
                    String string2 = context3 != null ? context3.getString(R.string.tp_cancel_info, new Object[]{this.o}) : null;
                    if (string2 != null) {
                        CharSequence charSequence = string2;
                        if (string == null) {
                            k.a();
                        }
                        num = Integer.valueOf(p.a(charSequence, string, 0, false, 6));
                    } else {
                        num = null;
                    }
                    SpannableString spannableString2 = new SpannableString(string2);
                    if (num == null || num.intValue() != -1) {
                        StyleSpan styleSpan = new StyleSpan(1);
                        if (num == null) {
                            k.a();
                        }
                        int intValue = num.intValue();
                        Integer valueOf = string != null ? Integer.valueOf(string.length()) : null;
                        if (valueOf == null) {
                            k.a();
                        }
                        spannableString2.setSpan(styleSpan, intValue, valueOf.intValue() + num.intValue(), 33);
                    }
                    spannableString = spannableString2;
                } else {
                    Context context4 = getContext();
                    spannableString = new SpannableString(context4 != null ? context4.getString(R.string.qr_cancel_info) : null);
                }
                textView.setText(spannableString);
                View findViewById3 = view.findViewById(R.id.btn_cancel_pass);
                if (findViewById3 != null) {
                    TextView textView2 = (TextView) findViewById3;
                    textView2.setText(textView2.getContext().getString(R.string.cancel_pass, new Object[]{this.f63311h}));
                    View.OnClickListener onClickListener = this;
                    textView2.setOnClickListener(onClickListener);
                    ((ImageView) view.findViewById(R.id.close_button)).setOnClickListener(onClickListener);
                    if (!this.j) {
                        View findViewById4 = view.findViewById(R.id.recyclerView_layout);
                        if (findViewById4 != null) {
                            ((FrameLayout) findViewById4).setVisibility(8);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
                    }
                    View findViewById5 = view.findViewById(R.id.progressbar);
                    if (findViewById5 != null) {
                        this.f63306c = (ProgressBar) findViewById5;
                        View findViewById6 = view.findViewById(R.id.progressbarText);
                        if (findViewById6 != null) {
                            this.f63308e = (TextView) findViewById6;
                            View findViewById7 = view.findViewById(R.id.recyclerView);
                            if (findViewById7 != null) {
                                this.f63307d = (RecyclerView) findViewById7;
                                RecyclerView recyclerView = this.f63307d;
                                if (recyclerView != null) {
                                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                                }
                                RecyclerView recyclerView2 = this.f63307d;
                                if (recyclerView2 != null) {
                                    Context context5 = view.getContext();
                                    k.a((Object) context5, "view.context");
                                    recyclerView2.setAdapter(new net.one97.paytm.recharge.metro.a.b(context5, this.f63305b));
                                }
                                if (this.k) {
                                    c();
                                } else if (this.f63305b.isEmpty()) {
                                    TextView textView3 = this.f63308e;
                                    if (textView3 != null) {
                                        Context context6 = getContext();
                                        if (context6 != null) {
                                            str2 = context6.getString(R.string.metro_fetching_amount);
                                        }
                                        textView3.setText(str2);
                                    }
                                    TextView textView4 = this.f63308e;
                                    if (textView4 != null) {
                                        textView4.setVisibility(0);
                                    }
                                    ProgressBar progressBar = this.f63306c;
                                    if (progressBar != null) {
                                        progressBar.setVisibility(0);
                                    }
                                } else {
                                    ProgressBar progressBar2 = this.f63306c;
                                    if (progressBar2 != null) {
                                        progressBar2.setVisibility(8);
                                    }
                                    TextView textView5 = this.f63308e;
                                    if (textView5 != null) {
                                        textView5.setVisibility(8);
                                    }
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.ProgressBar");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
            } else {
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
        } else {
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final void onClick(View view) {
        List<CJROrderSummaryAction> actions;
        o body;
        String oVar;
        String authUrl;
        String method;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.close_button;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismiss();
            return;
        }
        int i3 = R.id.btn_cancel_pass;
        if (valueOf != null && valueOf.intValue() == i3) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.OS_CTA_CANCEL, ERROR_TYPE.UNDEFINED);
            if (com.paytm.utility.b.c(getContext())) {
                net.one97.paytm.recharge.ordersummary.h.d dVar2 = this.p;
                String str = "";
                if (dVar2 != null) {
                    String str2 = this.m;
                    if (str2 == null) {
                        str2 = str;
                    }
                    String str3 = this.n;
                    String str4 = str3 == null ? str : str3;
                    String str5 = ab.f61496a;
                    k.a((Object) str5, "CJRRechargeUtilityConstant.UTILITY");
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, str2, "cancel_metro_qr_ticket_via_popup", "", str4, str5, (Object) null, (Object) null, 96);
                }
                CJRMetroRefundDescriptionModel cJRMetroRefundDescriptionModel = this.f63304a;
                if (cJRMetroRefundDescriptionModel == null || (actions = cJRMetroRefundDescriptionModel.getActions()) == null || actions.isEmpty()) {
                    a();
                    return;
                }
                at_();
                b.a aVar = net.one97.paytm.recharge.ordersummary.h.b.f64312h;
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                net.one97.paytm.recharge.ordersummary.h.b a3 = b.a.a(context);
                CJRMetroRefundDescriptionModel cJRMetroRefundDescriptionModel2 = this.f63304a;
                if (cJRMetroRefundDescriptionModel2 == null) {
                    k.a();
                }
                CJROrderSummaryAction cJROrderSummaryAction = cJRMetroRefundDescriptionModel2.getActions().get(0);
                k.a((Object) cJROrderSummaryAction, "mRefundDescriptionModel!!.actions.get(0)");
                CJROrderSummaryActionURLParams urlParams = cJROrderSummaryAction.getUrlParams();
                String str6 = (urlParams == null || (method = urlParams.getMethod()) == null) ? str : method;
                CJRMetroRefundDescriptionModel cJRMetroRefundDescriptionModel3 = this.f63304a;
                if (cJRMetroRefundDescriptionModel3 == null) {
                    k.a();
                }
                CJROrderSummaryAction cJROrderSummaryAction2 = cJRMetroRefundDescriptionModel3.getActions().get(0);
                k.a((Object) cJROrderSummaryAction2, "mRefundDescriptionModel!!.actions.get(0)");
                CJROrderSummaryActionURLParams urlParams2 = cJROrderSummaryAction2.getUrlParams();
                String str7 = (urlParams2 == null || (authUrl = urlParams2.getAuthUrl()) == null) ? str : authUrl;
                CJRMetroRefundDescriptionModel cJRMetroRefundDescriptionModel4 = this.f63304a;
                if (cJRMetroRefundDescriptionModel4 == null) {
                    k.a();
                }
                CJROrderSummaryAction cJROrderSummaryAction3 = cJRMetroRefundDescriptionModel4.getActions().get(0);
                k.a((Object) cJROrderSummaryAction3, "mRefundDescriptionModel!!.actions.get(0)");
                CJROrderSummaryActionURLParams urlParams3 = cJROrderSummaryAction3.getUrlParams();
                if (!(urlParams3 == null || (body = urlParams3.getBody()) == null || (oVar = body.toString()) == null)) {
                    str = oVar;
                }
                a3.a("metro_ticket_cancel", str6, str7, str, this, new CJROSActionResponseV2(), a2);
                String str8 = this.f63311h;
                if (str8 == null) {
                    return;
                }
                if (p.a(str8, "Metro QR Ticket", false)) {
                    a("/mumbai-metro/qr", "mumbai_metro_qr", "cancel_ticket_confirm_clicked");
                } else if (p.a(str8, "Trip Pass", false)) {
                    a("/mumbai-metro/tp", "mumbai_metro_tp", "cancel_ticket_confirm_clicked");
                } else if (p.a(str8, "Store Value Pass", false)) {
                    a("/mumbai-metro/svp", "mumbai_metro_svp", "cancel_ticket_confirm_clicked");
                }
            } else {
                NetworkCustomError networkCustomError = new NetworkCustomError();
                networkCustomError.mErrorType = NetworkCustomError.ErrorType.NoConnectionError;
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                }
                a("metro_ticket_cancel", 0, (IJRPaytmDataModel) null, networkCustomError, a2);
            }
        }
    }

    private final void a() {
        at_();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        String str = null;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName == null) {
            flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (kotlin.g.b.g) null);
        }
        a2.setFlowName(flowName);
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName3 = a2.getFlowName();
        if (flowName3 != null) {
            flowName3.setActionType(ACTION_TYPE.METRO_TICKET_CANCEL.name());
        }
        CRUFlowModel flowName4 = a2.getFlowName();
        if (flowName4 != null) {
            flowName4.setVariantType(this.f63311h + "/" + this.f63312i);
        }
        Context context = getContext();
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("order_id");
        }
        net.one97.paytm.recharge.metro.f.a.b("metro_ticket_cancel", context, str, (ai) this, (Object) a2);
    }

    public final void a(Context context, j jVar) {
        if (context != null) {
            a(context);
            if (!isAdded() && !isVisible() && jVar != null) {
                super.show(jVar, d.class.getSimpleName());
            }
        }
    }

    public final void at_() {
        ProgressDialog progressDialog = this.f63310g;
        if (progressDialog == null) {
            this.f63310g = ProgressDialog.show(getContext(), "", getString(R.string.please_wait), true);
        } else if (progressDialog != null) {
            progressDialog.show();
        }
    }

    public final void o() {
        try {
            ProgressDialog progressDialog = this.f63310g;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (IllegalStateException e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    private final void a(Context context) {
        if (context != null) {
            if (com.paytm.utility.b.c(context)) {
                TextView textView = this.f63308e;
                if (textView != null) {
                    textView.setText(context.getString(R.string.metro_fetching_amount));
                }
                TextView textView2 = this.f63308e;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                ProgressBar progressBar = this.f63306c;
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                String str = null;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.METRO_REFUND_DETAILS.name());
                }
                CRUFlowModel flowName3 = a2.getFlowName();
                if (flowName3 != null) {
                    flowName3.setVariantType(this.f63311h + '/' + this.f63312i);
                }
                Bundle arguments = getArguments();
                if (arguments != null) {
                    str = arguments.getString("order_id");
                }
                net.one97.paytm.recharge.metro.f.a.a("fetch_metro_amount_refund", context, str, (ai) new a(this, context), (Object) a2);
                return;
            }
            this.k = true;
            c();
        }
    }

    public static final class a implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63313a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f63314b;

        a(d dVar, Context context) {
            this.f63313a = dVar;
            this.f63314b = context;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                Activity activity = this.f63313a.getActivity();
                Fragment fragment = this.f63313a;
                if (networkCustomError == null) {
                    k.a();
                }
                CJRRechargeUtilities.handleError$default(cJRRechargeUtilities, str, activity, fragment, networkCustomError, false, this.f63313a.f63309f, obj, 16, (Object) null);
            } else if (networkCustomError == null || networkCustomError.getStatusCode() != 422 || networkCustomError.getAlertMessage() == null) {
                TextView textView = this.f63313a.f63308e;
                if (textView != null) {
                    textView.setText(this.f63314b.getString(R.string.metro_fetching_amount_error));
                }
                ProgressBar progressBar = this.f63313a.f63306c;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                TextView textView2 = this.f63313a.f63308e;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                if (obj instanceof CJRRechargeErrorModel) {
                    az azVar = az.f61525a;
                    az.a((CJRRechargeErrorModel) obj);
                }
            } else {
                new Handler().postDelayed(new C1225a(this, obj, networkCustomError), 500);
            }
        }

        /* renamed from: net.one97.paytm.recharge.metro.c.d$a$a  reason: collision with other inner class name */
        static final class C1225a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f63315a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f63316b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ NetworkCustomError f63317c;

            C1225a(a aVar, Object obj, NetworkCustomError networkCustomError) {
                this.f63315a = aVar;
                this.f63316b = obj;
                this.f63317c = networkCustomError;
            }

            public final void run() {
                CJRRechargeErrorModel cJRRechargeErrorModel;
                ACTION_TYPE action_type;
                ERROR_TYPE error_type;
                Object obj = this.f63316b;
                String str = null;
                if (obj instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj;
                    ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
                    CRUFlowModel flowName = cJRRechargeErrorModel2.getFlowName();
                    if (flowName != null) {
                        str = flowName.getActionType();
                    }
                    cJRRechargeErrorModel = cJRRechargeErrorModel2;
                    action_type = companion.getActionType(str, ACTION_TYPE.METRO_TICKET);
                } else {
                    action_type = null;
                    cJRRechargeErrorModel = null;
                }
                az azVar = az.f61525a;
                Context activity = this.f63315a.f63313a.getActivity();
                if (cJRRechargeErrorModel == null || (error_type = cJRRechargeErrorModel.getErrorType()) == null) {
                    error_type = ERROR_TYPE.UNDEFINED;
                }
                az.a(activity, error_type, action_type, this.f63317c.getAlertTitle(), this.f63317c.getAlertMessage(), false, cJRRechargeErrorModel, false, 1504);
                this.f63315a.f63313a.dismiss();
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            RecyclerView.a adapter;
            k.c(str, "tag");
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRMetroRefundDescriptionModel)) {
                CJRMetroRefundDescriptionModel cJRMetroRefundDescriptionModel = (CJRMetroRefundDescriptionModel) iJRPaytmDataModel;
                List<CJRMetroRefundDescriptionModel.CJRAmountDescription> amountDestribution = cJRMetroRefundDescriptionModel.getAmountDestribution();
                k.a((Object) amountDestribution, "response.amountDestribution");
                if (!amountDestribution.isEmpty()) {
                    d dVar = this.f63313a;
                    dVar.f63304a = cJRMetroRefundDescriptionModel;
                    ArrayList<CJRMetroRefundDescriptionModel.CJRAmountDescription> arrayList = dVar.f63305b;
                    arrayList.clear();
                    arrayList.addAll(cJRMetroRefundDescriptionModel.getAmountDestribution());
                    RecyclerView recyclerView = this.f63313a.f63307d;
                    if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
                        adapter.notifyDataSetChanged();
                    }
                }
            }
            ProgressBar progressBar = this.f63313a.f63306c;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            TextView textView = this.f63313a.f63308e;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    private final void c() {
        TextView textView = this.f63308e;
        if (textView != null) {
            Context context = getContext();
            textView.setText(context != null ? context.getString(R.string.metro_fetching_amount_error) : null);
        }
        ProgressBar progressBar = this.f63306c;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        TextView textView2 = this.f63308e;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        String str2;
        k.c(str, "tag");
        if (!(iJRPaytmDataModel instanceof CJROSActionResponseV2) || ((CJROSActionResponseV2) iJRPaytmDataModel).getStatus() != 0) {
            a(str, 0, (IJRPaytmDataModel) null, new NetworkCustomError(), obj);
            return;
        }
        CJRRechargeCart cJRRechargeCart = new CJRRechargeCart();
        CJRCart cJRCart = new CJRCart();
        CJRCartProduct cJRCartProduct = new CJRCartProduct();
        CJRProductAttributes cJRProductAttributes = new CJRProductAttributes();
        Map hashMap = new HashMap();
        String str3 = ab.f61497b;
        k.a((Object) str3, "CJRRechargeUtilityConstant.KEY_CATEGORY_ID");
        String str4 = e.z;
        k.a((Object) str4, "CJRParamConstants.METRO_CATEGORY_ID");
        hashMap.put(str3, str4);
        ArrayList arrayList = new ArrayList();
        cJRProductAttributes.setOperatorDisplayLabel("Mumbai Metro");
        cJRProductAttributes.setPayTypeDisplayLabel(this.f63311h);
        Bundle arguments = getArguments();
        if (arguments == null || (str2 = String.valueOf(arguments.getLong(CLPConstants.PRODUCT_ID))) == null) {
            str2 = "";
        }
        cJRCartProduct.setProductId(str2);
        cJRCartProduct.setmProductAttrubutes(cJRProductAttributes);
        cJRCartProduct.setmRechargeConfigList(hashMap);
        arrayList.add(cJRCartProduct);
        cJRCart.setCartItems(arrayList);
        cJRRechargeCart.setmCart(cJRCart);
        Intent intent = new Intent(getContext(), AJRechargeOrderSummaryActivity.class);
        intent.putExtra(UpiConstants.FROM, "ticketCancelledOS");
        Bundle arguments2 = getArguments();
        String str5 = null;
        intent.putExtra("order_id", arguments2 != null ? arguments2.getString("order_id") : null);
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str5 = arguments3.getString("reference_id");
        }
        intent.putExtra("reference_id", str5);
        intent.putExtra("recharge cart", cJRRechargeCart);
        intent.putExtra(AppConstants.IS_CANCEL, true);
        Context context = getContext();
        if (context != null) {
            context.startActivity(intent);
        }
        c.a aVar = c.f63576a;
        Bundle arguments4 = getArguments();
        if (arguments4 == null) {
            k.a();
        }
        long j2 = arguments4.getLong(CLPConstants.PRODUCT_ID);
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        k.a((Object) context2, "context!!");
        c.a.a(j2, context2);
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        ACTION_TYPE action_type;
        ERROR_TYPE error_type;
        ERROR_TYPE error_type2;
        NetworkCustomError networkCustomError2 = networkCustomError;
        Object obj2 = obj;
        k.c(str, "tag");
        o();
        if ((iJRPaytmDataModel instanceof CJROSActionResponseV2) && CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError2)) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            Activity activity = getActivity();
            Fragment fragment = this;
            if (networkCustomError2 == null) {
                k.a();
            }
            cJRRechargeUtilities.handleError(str, activity, fragment, networkCustomError, true, this.l, obj);
        } else if (networkCustomError2 != null) {
            boolean z = obj2 instanceof CJRRechargeErrorModel;
            String str2 = null;
            if (z) {
                CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj2;
                ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
                CRUFlowModel flowName = cJRRechargeErrorModel2.getFlowName();
                cJRRechargeErrorModel = cJRRechargeErrorModel2;
                action_type = companion.getActionType(flowName != null ? flowName.getActionType() : null, ACTION_TYPE.METRO_TICKET);
            } else {
                action_type = null;
                cJRRechargeErrorModel = null;
            }
            if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError2)) {
                CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, getActivity(), (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
            } else if (networkCustomError.getAlertMessage() != null) {
                az azVar = az.f61525a;
                Context activity2 = getActivity();
                if (cJRRechargeErrorModel == null || (error_type2 = cJRRechargeErrorModel.getErrorType()) == null) {
                    error_type2 = ERROR_TYPE.UNDEFINED;
                }
                az.a(activity2, error_type2, action_type, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage(), false, cJRRechargeErrorModel, false, 1504);
            } else if (networkCustomError.getErrorType() == NetworkCustomError.ErrorType.NoConnectionError) {
                az azVar2 = az.f61525a;
                Context context = getContext();
                if (cJRRechargeErrorModel == null || (error_type = cJRRechargeErrorModel.getErrorType()) == null) {
                    error_type = ERROR_TYPE.NO_CONNECTION;
                }
                ERROR_TYPE error_type3 = error_type;
                Context context2 = getContext();
                String string = context2 != null ? context2.getString(R.string.no_connection) : null;
                Context context3 = getContext();
                if (context3 != null) {
                    str2 = context3.getString(R.string.no_internet);
                }
                az.a(context, error_type3, action_type, string, str2, false, cJRRechargeErrorModel, false, 1504);
            } else {
                if (z) {
                    az azVar3 = az.f61525a;
                    az.a((CJRRechargeErrorModel) obj2);
                }
                Context context4 = getContext();
                Context context5 = getContext();
                if (context5 != null) {
                    str2 = context5.getString(R.string.error_try_again);
                }
                Toast.makeText(context4, str2, 1).show();
            }
        }
    }

    private void a(String str, String str2, String str3) {
        k.c(str, "screen_name");
        k.c(str2, "category");
        k.c(str3, "event_action");
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", str2);
            hashMap.put("event_action", str3);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
            hashMap.put("vertical_name", "recharges_utilities");
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
        } catch (Throwable unused) {
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f63309f) {
            if (i3 != 0) {
                a(getContext());
                return;
            }
            ay ayVar = ay.f61523a;
            ay.a(this.f63309f);
        } else if (i2 != this.l) {
        } else {
            if (i3 != 0) {
                a();
                return;
            }
            ay ayVar2 = ay.f61523a;
            ay.a(this.l);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.q;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
