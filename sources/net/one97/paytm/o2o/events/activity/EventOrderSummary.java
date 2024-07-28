package net.one97.paytm.o2o.events.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alipay.mobile.h5container.api.H5Event;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.network.a;
import com.paytm.network.model.CJRIllegalCodeError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.c;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.events.CJREventCancellationProtectDetail;
import net.one97.paytm.common.entity.events.CJREventsPricesModel;
import net.one97.paytm.common.entity.events.CJRInputSeatInfo;
import net.one97.paytm.common.entity.events.CJRSelectedInsiderSeats;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.common.entity.shopping.TemplateData;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.o2o.events.R;
import net.one97.paytm.o2o.events.common.CJREventCancelInsuranceResponse;
import net.one97.paytm.o2o.events.common.CJREventPreClaimInsuranceResponse;
import net.one97.paytm.o2o.events.common.CJREventTrackingInfo;
import net.one97.paytm.o2o.events.common.CJREventsDownloadTicket;
import net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2;
import net.one97.paytm.o2o.events.common.entity.events.CJRInputStaticMetaDataModel;
import net.one97.paytm.o2o.events.d.a.b.b;
import net.one97.paytm.o2o.events.e.d;
import net.one97.paytm.o2o.events.view.CJREventDeliveryView;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventOrderSummary extends PaytmActivity implements com.paytm.network.listener.b, net.one97.paytm.o2o.events.b.a, b.a, net.one97.paytm.o2o.events.view.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f73689a = EventOrderSummary.class.getSimpleName();
    private ProgressDialog A;
    private String B;
    private String C;
    /* access modifiers changed from: private */
    public ImageView D;
    private int[] E;
    /* access modifiers changed from: private */
    public Bitmap F;
    private View G;
    private Integer H;
    private AppCompatImageView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private JSONObject M;
    private String N;
    private int O;
    private List<CJREventTrackingInfo> P;
    private CJROrderedCart Q;
    private LinearLayout R;
    private boolean S = true;
    private m T;
    private LinearLayout U;
    private Handler V = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (!EventOrderSummary.this.isFinishing() && !EventOrderSummary.this.isDestroyed() && message.what == 1) {
                EventOrderSummary eventOrderSummary = EventOrderSummary.this;
                eventOrderSummary.a(eventOrderSummary.f73695g);
            }
        }
    };
    private long W = 0;
    private String X = "";

    /* renamed from: b  reason: collision with root package name */
    private final int f73690b = 3;

    /* renamed from: c  reason: collision with root package name */
    private CJRItem f73691c;

    /* renamed from: d  reason: collision with root package name */
    private String f73692d;

    /* renamed from: e  reason: collision with root package name */
    private String f73693e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, Object> f73694f = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f73695g;

    /* renamed from: h  reason: collision with root package name */
    private y f73696h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f73697i;
    private boolean j;
    private CJRParcelTrackingInfo k;
    private String l;
    private CJROrderSummary m;
    private LinearLayout n;
    private ImageView o;
    /* access modifiers changed from: private */
    public ArrayList<String> p;
    private ArrayList<String> q;
    private Dialog r;
    private Dialog s;
    private int t;
    private CJRInputStaticMetaDataModel u = null;
    private CJRInputMetaDataModelV2 v = null;
    private boolean w;
    private CJREventDeliveryView x;
    private int y;
    private boolean z = true;

    private static String a(Context context, String str) {
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            linkedList.add(str);
        }
        String Q2 = com.paytm.utility.b.Q(context);
        if (!TextUtils.isEmpty(Q2)) {
            linkedList.add(Q2);
        }
        String n2 = com.paytm.utility.b.n(context);
        if (!TextUtils.isEmpty(n2)) {
            linkedList.add(n2);
        }
        return TextUtils.join("/", linkedList);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.event_order_summary_home);
        this.y = 0;
        this.U = (LinearLayout) findViewById(R.id.progress_bar_container);
        this.T = new m() {
            public final void show() {
                EventOrderSummary.this.a();
            }

            public final void dismiss() {
                EventOrderSummary.this.b();
            }
        };
        try {
            this.R = (LinearLayout) findViewById(R.id.no_network);
            findViewById(R.id.network_retry_btn).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    EventOrderSummary.this.g(view);
                }
            });
        } catch (Exception unused) {
            q.c("");
        }
        if (!(getIntent() == null || getIntent() == null)) {
            if (getIntent().hasExtra(UpiConstants.FROM)) {
                this.f73693e = getIntent().getStringExtra(UpiConstants.FROM);
            }
            if (getIntent().hasExtra("orderItemId")) {
                this.X = getIntent().getExtras().getString("orderItemId");
            }
            if (getIntent().hasExtra("order_id")) {
                this.f73695g = getIntent().getStringExtra("order_id");
            }
            if (getIntent().hasExtra("is_deep_linking_data")) {
                this.j = getIntent().getBooleanExtra("is_deep_linking_data", false);
            }
            if (getIntent().hasExtra("Recharge")) {
                this.f73697i = getIntent().getBooleanExtra("Recharge", false);
            }
            if (getIntent().hasExtra("tracking_info")) {
                this.k = (CJRParcelTrackingInfo) getIntent().getParcelableExtra("tracking_info");
            }
            if (getIntent().hasExtra("referralSource")) {
                this.l = getIntent().getStringExtra("referralSource");
            }
            if (getIntent().hasExtra("intent_extra_wallet_paytm_assist_gtmevents")) {
                this.f73696h = (y) getIntent().getSerializableExtra("intent_extra_wallet_paytm_assist_gtmevents");
            }
        }
        this.n = (LinearLayout) findViewById(R.id.event_order_summary_container);
        this.o = (ImageView) findViewById(R.id.back_arrow);
        this.D = (ImageView) findViewById(R.id.zoomed_qr_image);
        this.D.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EventOrderSummary.this.f(view);
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EventOrderSummary.this.e(view);
            }
        });
        f();
        if (!TextUtils.isEmpty(this.f73693e) && !this.f73693e.equalsIgnoreCase("Order_history")) {
            try {
                TextUtils.isEmpty(net.one97.paytm.o2o.events.a.a().getStringFromGTMContainer4("ScratchcardUrlv2"));
                String b2 = c.b("https://storefront.paytm.com/v2/h/post-txn-page-new", (Context) this);
                $$Lambda$EventOrderSummary$zgehxoV1o1RXZ3h03zx4WorGlM4 r0 = new SFCallbackListener() {
                    public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
                    }

                    public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
                        EventOrderSummary.this.a(sanitizedResponseModel);
                    }
                };
                k.c(b2, "url");
                k.c(r0, H5Event.TYPE_CALL_BACK);
                HashMap hashMap = new HashMap();
                hashMap.put("ClientId", "paytm");
                SFInterface.INSTANCE.getStoreFrontReponse(b2, hashMap, a.c.MOVIES, r0);
            } catch (Exception e2) {
                q.b(e2.getLocalizedMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        if (com.paytm.utility.b.c(getApplicationContext())) {
            f();
        }
    }

    private void a(boolean z2) {
        LinearLayout linearLayout = this.R;
        if (linearLayout != null) {
            if (z2) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    private void f() {
        if (com.paytm.utility.b.c((Context) this)) {
            a(false);
            if (getIntent() != null && this.j && !this.f73695g.isEmpty()) {
                a(this.f73695g);
            } else if (getIntent() != null && getIntent().hasExtra("extra_home_data")) {
                this.f73691c = (CJRItem) getIntent().getExtras().getSerializable("extra_home_data");
                a(this.f73691c);
                this.f73692d = this.f73691c.getURL();
                this.f73693e = "Deep Linking";
                if (!TextUtils.isEmpty(this.f73692d)) {
                    c(this.f73692d);
                }
            } else if (getIntent() == null || getIntent().getData() == null || TextUtils.isEmpty(getIntent().getData().getQueryParameter("url"))) {
                new StringBuilder("Else order ").append(this.f73695g);
                a(this.f73695g);
            } else {
                this.f73692d = getIntent().getData().getQueryParameter("url");
                this.f73693e = "Deep Linking";
                c(this.f73692d);
            }
        } else {
            a(true);
        }
    }

    public void onBackPressed() {
        if (this.D.getVisibility() == 0) {
            i();
            return;
        }
        if (!TextUtils.isEmpty(this.f73693e) && !this.f73693e.equalsIgnoreCase("Order_history")) {
            new CJRHomePageItem().setUrl(d.a(getApplicationContext()).b("home_url", "", true));
            Intent intent = new Intent(this, net.one97.paytm.o2o.events.a.a().getMainActivity());
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.setFlags(536870912);
            intent.putExtra("CLEAR_MOBILE_DATA", true);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            if (!TextUtils.isEmpty(this.f73693e) && this.f73693e.equalsIgnoreCase("Payment")) {
                intent.putExtra("Reset_fast_farward", true);
            }
            startActivity(intent);
            finish();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        i();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        onBackPressed();
    }

    private void a(CJRItem cJRItem) {
        if (cJRItem != null) {
            this.f73694f.put("search_type", cJRItem.getSearchType());
            this.f73694f.put("search_category", cJRItem.getSearchCategory());
            this.f73694f.put("search_term", cJRItem.getSearchTerm());
            this.f73694f.put("search_result_type", cJRItem.getSearchResultType());
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            this.f73692d = net.one97.paytm.o2o.events.a.a().getStringFromGTM("orderdetail") + str;
        } catch (Exception unused) {
        }
        c(this.f73692d);
    }

    private void g() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.error));
        builder.setMessage(getResources().getString(R.string.msg_invalid_url)).setCancelable(false).setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                EventOrderSummary.this.finish();
            }
        });
        builder.create().show();
    }

    private void b(String str) {
        Intent intent = new Intent(this, net.one97.paytm.o2o.events.a.a().getLoginActivity());
        intent.putExtra("resultant activity", net.one97.paytm.o2o.events.a.a().getNameForAJROrderSummaryActivity());
        Bundle bundle = new Bundle();
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setUrlType("order_summary");
        cJRHomePageItem.setUrl(str);
        bundle.putSerializable("extra_home_data", cJRHomePageItem);
        bundle.putString("origin", "deeplinking");
        intent.putExtra("resultant activity_bundle", bundle);
        startActivity(intent);
        finish();
    }

    public final void a(int i2) {
        CJREventTrackingInfo cJREventTrackingInfo = this.P.get(i2);
        if (cJREventTrackingInfo != null && !TextUtils.isEmpty(cJREventTrackingInfo.getInfo())) {
            net.one97.paytm.o2o.events.fragment.a.a(cJREventTrackingInfo.getInfo(), cJREventTrackingInfo.getAwbNumber()).show(getSupportFragmentManager(), "");
        }
    }

    private void c(String str) {
        String str2;
        if (str == null || TextUtils.isEmpty(str)) {
            g();
        } else if (!TextUtils.isEmpty(d.a(getApplicationContext()).b("sso_token=", "", true))) {
            String b2 = c.b(str, (Context) this);
            if (TextUtils.isEmpty(this.f73693e) || (!this.f73693e.equalsIgnoreCase("Payment") && !this.f73693e.equalsIgnoreCase("paytm_automatic"))) {
                str2 = b2 + "&actions=1";
            } else {
                str2 = b2 + "&actions=0";
            }
            HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), (Context) this);
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.EVENT;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = str2;
            bVar.f42881e = null;
            bVar.f42882f = a2;
            bVar.f42883g = null;
            bVar.f42884h = null;
            bVar.f42885i = new CJROrderSummary();
            bVar.j = this;
            bVar.n = a.b.USER_FACING;
            bVar.o = EventsModuleManager.MODULE_NAME;
            bVar.t = q();
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            l2.a();
            a();
        } else {
            b(str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AdapterView adapterView, View view, int i2, long j2) {
        if (this.r.isShowing()) {
            this.t = i2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ListView listView, DialogInterface dialogInterface, int i2) {
        int i3;
        Resources resources = getResources();
        if (Build.VERSION.SDK_INT >= 11) {
            i3 = listView.getCheckedItemCount();
        } else {
            int i4 = 0;
            for (int count = listView.getCount() - 1; count >= 0; count--) {
                if (listView.isItemChecked(count)) {
                    i4++;
                }
            }
            i3 = i4;
        }
        if (i3 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            TextView textView = new TextView(this);
            textView.setText(getResources().getString(R.string.error));
            textView.setPadding(10, 10, 10, 10);
            textView.setGravity(17);
            textView.setTextSize(20.0f);
            try {
                textView.setTextColor(androidx.core.content.b.c(this, R.color.color_light_blue_33b5e5));
            } catch (Exception unused) {
            }
            builder.setCustomTitle(textView);
            builder.setMessage(getResources().getString(R.string.contact_us_select_item_message));
            builder.setPositiveButton(resources.getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    EventOrderSummary.this.c(dialogInterface, i2);
                }
            });
            this.s = builder.create();
            this.s.show();
            return;
        }
        this.r.dismiss();
        CJROrderedCart cJROrderedCart = this.m.getOrderedCartList().get(this.t);
        cJROrderedCart.setOrderId(this.m.getId());
        Bundle bundle = new Bundle();
        bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
        net.one97.paytm.o2o.events.a.a().getUpdatedCstOrderIssueIntent(this, bundle, this.T);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface, int i2) {
        this.s.dismiss();
        this.r.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, DialogInterface dialogInterface, int i3) {
        dialogInterface.cancel();
        if (i2 == 200) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.V.sendMessage(obtain);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 56 && s.a(iArr)) {
            s();
            r();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        try {
            String str = net.one97.paytm.o2o.events.a.a().getStringFromGTMContainer4("eventsInsiderDigitalTicketURL") + "?key=paytm_order_id&value=" + this.f73695g;
            HashMap hashMap = new HashMap();
            hashMap.put("ClientId", "paytm");
            hashMap.put("Content-Type", "application/json");
            if (com.paytm.utility.b.c((Context) this)) {
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = this;
                bVar.f42878b = a.c.EVENT;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = str;
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJREventsDownloadTicket();
                bVar.j = this;
                bVar.n = a.b.USER_FACING;
                bVar.o = EventsModuleManager.MODULE_NAME;
                bVar.t = q();
                com.paytm.network.a l2 = bVar.l();
                l2.f42859c = false;
                l2.a();
                s();
                return;
            }
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
        } catch (Exception unused) {
        }
    }

    private void h() {
        JSONArray jSONArray;
        try {
            if (this.M != null && this.M.has("importantPoints") && (jSONArray = this.M.getJSONArray("importantPoints")) != null) {
                jSONArray.length();
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    sb.append("\n* ");
                    sb.append(jSONArray.get(i2));
                }
                if (sb.length() > 0) {
                    View inflate = LayoutInflater.from(this).inflate(R.layout.events_order_summary_imp_info_card, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.id_event_summary_imp_info)).setText(sb);
                    this.n.addView(inflate);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        a();
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this;
        bVar.f42878b = a.c.EVENT;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = net.one97.paytm.o2o.events.a.a().getStringFromGTM("event_insurance_claim") + this.m.getId();
        bVar.f42881e = null;
        bVar.f42882f = null;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.f42885i = new CJREventCancelInsuranceResponse();
        bVar.j = this;
        bVar.n = a.b.USER_FACING;
        bVar.o = EventsModuleManager.MODULE_NAME;
        bVar.t = q();
        com.paytm.network.a l2 = bVar.l();
        l2.f42859c = false;
        l2.a();
    }

    private void i() {
        ObjectAnimator objectAnimator;
        ValueAnimator valueAnimator;
        ObjectAnimator objectAnimator2;
        ValueAnimator valueAnimator2;
        if (this.D.getVisibility() == 0) {
            valueAnimator2 = d(com.paytm.utility.b.a((Activity) this), this.G.getWidth());
            valueAnimator = c(com.paytm.utility.b.b((Activity) this), this.G.getHeight());
            objectAnimator = b(0, this.E[0]);
            objectAnimator2 = a(0, this.E[1]);
        } else {
            valueAnimator2 = d(this.G.getWidth(), com.paytm.utility.b.a((Activity) this));
            valueAnimator = c(this.G.getHeight(), com.paytm.utility.b.b((Activity) this));
            objectAnimator = b(this.E[0], 0);
            objectAnimator2 = a(this.E[1], 0);
        }
        a(valueAnimator2, valueAnimator, objectAnimator, objectAnimator2);
    }

    private ObjectAnimator a(int i2, int i3) {
        return ObjectAnimator.ofFloat(this.D, "y", new float[]{(float) i2, (float) i3});
    }

    private ObjectAnimator b(int i2, int i3) {
        return ObjectAnimator.ofFloat(this.D, "x", new float[]{(float) i2, (float) i3});
    }

    private ValueAnimator c(int i2, int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, i3});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EventOrderSummary.this.b(valueAnimator);
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        layoutParams.height = intValue;
        this.D.setLayoutParams(layoutParams);
    }

    private ValueAnimator d(int i2, int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, i3});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EventOrderSummary.this.a(valueAnimator);
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        layoutParams.width = intValue;
        this.D.setLayoutParams(layoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c A[Catch:{ Exception -> 0x00ef }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[Catch:{ Exception -> 0x00ef }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j() {
        /*
            r9 = this;
            java.lang.String r0 = "transactionId"
            java.lang.String r1 = "barcode"
            org.json.JSONObject r2 = r9.M     // Catch:{ Exception -> 0x00ef }
            boolean r2 = r2.has(r1)     // Catch:{ Exception -> 0x00ef }
            r3 = 0
            if (r2 == 0) goto L_0x0015
            org.json.JSONObject r2 = r9.M     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x0015 }
            goto L_0x0016
        L_0x0015:
            r1 = r3
        L_0x0016:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00ef }
            if (r2 == 0) goto L_0x001d
            return
        L_0x001d:
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r9)     // Catch:{ Exception -> 0x00ef }
            int r4 = net.one97.paytm.o2o.events.R.layout.events_order_summary_qr_card     // Catch:{ Exception -> 0x00ef }
            android.view.View r2 = r2.inflate(r4, r3)     // Catch:{ Exception -> 0x00ef }
            net.one97.paytm.common.entity.shopping.TemplateData r3 = r9.u()     // Catch:{ Exception -> 0x00ef }
            int r4 = net.one97.paytm.o2o.events.R.id.id_qr_text     // Catch:{ Exception -> 0x00ef }
            android.view.View r4 = r2.findViewById(r4)     // Catch:{ Exception -> 0x00ef }
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4     // Catch:{ Exception -> 0x00ef }
            r5 = 4
            if (r3 == 0) goto L_0x0052
            java.lang.String r6 = r3.getOrd_enableRedemption()     // Catch:{ Exception -> 0x00ef }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00ef }
            if (r6 != 0) goto L_0x0052
            java.lang.String r6 = "1"
            java.lang.String r7 = r3.getOrd_enableRedemption()     // Catch:{ Exception -> 0x00ef }
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x00ef }
            if (r6 == 0) goto L_0x004e
            r6 = 0
            goto L_0x004f
        L_0x004e:
            r6 = 4
        L_0x004f:
            r4.setVisibility(r6)     // Catch:{ Exception -> 0x00ef }
        L_0x0052:
            if (r3 == 0) goto L_0x0065
            java.lang.String r6 = r3.getOrd_redemptionText()     // Catch:{ Exception -> 0x00ef }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00ef }
            if (r6 != 0) goto L_0x0065
            java.lang.String r6 = r3.getOrd_redemptionText()     // Catch:{ Exception -> 0x00ef }
            r4.setText(r6)     // Catch:{ Exception -> 0x00ef }
        L_0x0065:
            org.json.JSONObject r4 = r9.M     // Catch:{ Exception -> 0x00ef }
            java.lang.String r6 = "0"
            if (r4 == 0) goto L_0x00a3
            org.json.JSONObject r4 = r9.M     // Catch:{ Exception -> 0x00ef }
            boolean r4 = r4.has(r0)     // Catch:{ Exception -> 0x00ef }
            if (r4 == 0) goto L_0x00a3
            org.json.JSONObject r4 = r9.M     // Catch:{ Exception -> 0x00ef }
            java.lang.String r0 = r4.getString(r0)     // Catch:{ Exception -> 0x00ef }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00ef }
            if (r4 != 0) goto L_0x00a3
            int r4 = net.one97.paytm.o2o.events.R.id.id_short_code     // Catch:{ Exception -> 0x00ef }
            android.view.View r4 = r2.findViewById(r4)     // Catch:{ Exception -> 0x00ef }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x00ef }
            r4.setText(r0)     // Catch:{ Exception -> 0x00ef }
            if (r3 == 0) goto L_0x00a3
            java.lang.String r0 = r3.getOrd_enableShortCode()     // Catch:{ Exception -> 0x00ef }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00ef }
            if (r0 != 0) goto L_0x00a3
            java.lang.String r0 = r3.getOrd_enableShortCode()     // Catch:{ Exception -> 0x00ef }
            boolean r0 = r6.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x00ef }
            if (r0 == 0) goto L_0x00a3
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x00ef }
        L_0x00a3:
            int r0 = net.one97.paytm.o2o.events.R.id.id_qr_ll     // Catch:{ Exception -> 0x00ef }
            android.view.View r0 = r2.findViewById(r0)     // Catch:{ Exception -> 0x00ef }
            int r4 = net.one97.paytm.o2o.events.R.id.id_image_qr     // Catch:{ Exception -> 0x00ef }
            android.view.View r4 = r2.findViewById(r4)     // Catch:{ Exception -> 0x00ef }
            android.widget.ImageView r4 = (android.widget.ImageView) r4     // Catch:{ Exception -> 0x00ef }
            com.paytm.network.b.h r7 = com.paytm.network.b.h.INSTANCE     // Catch:{ Exception -> 0x00ef }
            com.android.volley.toolbox.ImageLoader r7 = r7.getImageLoader()     // Catch:{ Exception -> 0x00ef }
            net.one97.paytm.o2o.events.activity.EventOrderSummary$4 r8 = new net.one97.paytm.o2o.events.activity.EventOrderSummary$4     // Catch:{ Exception -> 0x00ef }
            r8.<init>(r4, r0)     // Catch:{ Exception -> 0x00ef }
            r7.get(r1, r8)     // Catch:{ Exception -> 0x00ef }
            net.one97.paytm.o2o.events.activity.EventOrderSummary$5 r0 = new net.one97.paytm.o2o.events.activity.EventOrderSummary$5     // Catch:{ Exception -> 0x00ef }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00ef }
            r4.setOnClickListener(r0)     // Catch:{ Exception -> 0x00ef }
            android.widget.LinearLayout r0 = r9.n     // Catch:{ Exception -> 0x00ef }
            r0.addView(r2)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r0 = r9.N     // Catch:{ Exception -> 0x00ef }
            java.lang.String r1 = "SUCCESS"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00ef }
            if (r0 == 0) goto L_0x00ef
            if (r3 == 0) goto L_0x00ef
            java.lang.String r0 = r3.getOrd_enableQR_Code()     // Catch:{ Exception -> 0x00ef }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00ef }
            if (r0 != 0) goto L_0x00ef
            java.lang.String r0 = r3.getOrd_enableQR_Code()     // Catch:{ Exception -> 0x00ef }
            boolean r0 = r6.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x00ef }
            if (r0 == 0) goto L_0x00ef
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x00ef }
        L_0x00ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.events.activity.EventOrderSummary.j():void");
    }

    private void a(ValueAnimator valueAnimator, ValueAnimator valueAnimator2, ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(100);
        animatorSet.playTogether(new Animator[]{valueAnimator, valueAnimator2, objectAnimator, objectAnimator2});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                if (EventOrderSummary.this.D.getVisibility() == 0) {
                    EventOrderSummary.this.D.setVisibility(4);
                } else {
                    EventOrderSummary.this.D.setVisibility(0);
                }
            }
        });
        animatorSet.start();
    }

    private void k() {
        String str;
        int i2;
        int i3;
        View inflate = LayoutInflater.from(this).inflate(R.layout.event_summary_header_card, (ViewGroup) null);
        this.I = (AppCompatImageView) inflate.findViewById(R.id.movie_status_icon);
        this.J = (TextView) inflate.findViewById(R.id.movie_summary_status);
        this.K = (TextView) inflate.findViewById(R.id.movie_summary_header_card_order_id);
        this.L = (TextView) inflate.findViewById(R.id.movie_header_payment_desc);
        this.L.setVisibility(0);
        this.L.setTextColor(getResources().getColor(R.color.black));
        if (inflate != null) {
            this.n.addView(inflate);
        }
        if (this.N.equalsIgnoreCase("SUCCESS") || this.N.equalsIgnoreCase(TxNotifyData.UPI_STATUS_CANCELLED)) {
            this.I.setImageResource(net.one97.paytm.common.assets.R.drawable.ic_movie_order_success);
        } else if (this.N.equalsIgnoreCase("FAILED")) {
            this.I.setImageResource(net.one97.paytm.common.assets.R.drawable.ic_movie_order_failure);
        } else if (this.N.equalsIgnoreCase("PROCESSING")) {
            this.I.setImageResource(net.one97.paytm.common.assets.R.drawable.ic_movie_pending_icon);
        }
        int color = getResources().getColor(R.color.color_ffa400);
        String str2 = "";
        if (this.N.equalsIgnoreCase("SUCCESS") || this.N.equalsIgnoreCase(TxNotifyData.UPI_STATUS_CANCELLED)) {
            color = getResources().getColor(R.color.color_09ac63);
            if ((this.v.getInsurance() == 1 && this.O == -1) || (i3 = this.O) == 1) {
                str = getResources().getString(R.string.movie_booking_insurance_confirmed);
            } else if (i3 == 2) {
                str = getResources().getString(R.string.event_insurance_cancelled);
            } else if (this.N.equalsIgnoreCase(TxNotifyData.UPI_STATUS_CANCELLED)) {
                str = getResources().getString(R.string.movie_booking_confirmed);
            } else {
                TemplateData u2 = u();
                str = (u2 == null || TextUtils.isEmpty(u2.getOrd_confirmMsg())) ? getResources().getString(R.string.movie_booking_confirmed) : u2.getOrd_confirmMsg();
            }
        } else if (this.N.equalsIgnoreCase("FAILED")) {
            color = getResources().getColor(R.color.cancel_red_color);
            str = getResources().getString(R.string.movie_booking_failed);
        } else if (this.N.equalsIgnoreCase("PROCESSING")) {
            color = getResources().getColor(R.color.color_ffa400);
            str = getResources().getString(R.string.confirmation_pending);
        } else {
            str = str2;
        }
        this.J.setText(str);
        this.J.setTextColor(color);
        if (this.N.equalsIgnoreCase("SUCCESS") || this.N.equalsIgnoreCase(TxNotifyData.UPI_STATUS_CANCELLED)) {
            if ((this.v.getInsurance() == 1 && this.O == -1) || (i2 = this.O) == 1) {
                String string = getResources().getString(R.string.event_insurance_success_subtext);
                int length = string.length();
                a(string, length - 6, length);
                return;
            } else if (i2 == 2) {
                String string2 = getResources().getString(R.string.event_insurance_claimed_subtext);
                int length2 = string2.length();
                a(string2, length2 - 9, length2);
                return;
            } else if (this.N.equalsIgnoreCase(TxNotifyData.UPI_STATUS_CANCELLED)) {
                str2 = getResources().getString(R.string.event_order_success_status);
            } else {
                TemplateData u3 = u();
                if (u3 == null || TextUtils.isEmpty(u3.getOrd_bookingMsg())) {
                    str2 = getResources().getString(R.string.movie_booking_confirmed);
                } else {
                    str2 = u3.getOrd_bookingMsg();
                }
            }
        } else if (this.N.equalsIgnoreCase("FAILED")) {
            str2 = getResources().getString(R.string.event_order_failed_status);
        } else if (this.N.equalsIgnoreCase("PROCESSING")) {
            str2 = getResources().getString(R.string.event_order_pending_status);
        }
        this.L.setText(str2);
    }

    private void a(String str, int i2, int i3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                EventOrderSummary.a(EventOrderSummary.this, "Terms and Conditions", "https://paytm.com/offer/cancellation-protect-for-event-bookings");
            }
        }, i2, i3, 18);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.paytm_blue)), i2, i3, 18);
        this.L.setText(spannableStringBuilder);
        this.L.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void m() {
        CJRTaxInfo grantTotal;
        View inflate = LayoutInflater.from(this).inflate(R.layout.event_order_summary_payment_summary_card, (ViewGroup) null);
        CJREventsPricesModel n2 = n();
        if (n2 != null && inflate != null && (grantTotal = n2.getGrantTotal()) != null) {
            String value = grantTotal.getValue();
            if (!TextUtils.isEmpty(value)) {
                try {
                    String totalInsurancePremium = this.v.getTotalInsurancePremium();
                    if (!TextUtils.isEmpty(totalInsurancePremium)) {
                        value = com.paytm.utility.b.a(Double.parseDouble(value) + Double.parseDouble(totalInsurancePremium));
                    }
                } catch (Exception unused) {
                }
                ((RoboTextView) inflate.findViewById(R.id.id_payment_amount)).setText(getResources().getString(R.string.event_amount_in_rupees, new Object[]{value}));
                inflate.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        EventOrderSummary.this.b(view);
                    }
                });
                this.n.addView(inflate);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SanitizedResponseModel sanitizedResponseModel) {
        if (sanitizedResponseModel != null) {
            try {
                SFWidget widget = sanitizedResponseModel.getSfWidgets().get(104).getWidget(this, (IGAHandlerListener) null);
                if (widget instanceof IStaticWidget) {
                    FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
                    frameLayout.setVisibility(0);
                    frameLayout.addView(((IStaticWidget) widget).getView());
                    net.one97.paytm.o2o.events.a.a().onTransactionComplete(widget, this, this.f73695g, net.one97.paytm.utils.b.a.EVENT_TICKETS);
                }
            } catch (Exception unused) {
            }
        }
    }

    private CJREventsPricesModel n() {
        JSONObject jSONObject = this.M;
        if (jSONObject != null && jSONObject.has("prices")) {
            try {
                return (CJREventsPricesModel) new f().a(this.M.get("prices").toString(), CJREventsPricesModel.class);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private void o() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.events_order_summary_payment_footer, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.paytm_contact_us)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EventOrderSummary.this.a(view);
            }
        });
        if (inflate != null) {
            this.n.addView(inflate);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (SystemClock.elapsedRealtime() - this.W >= 1000) {
            this.W = SystemClock.elapsedRealtime();
            if (this.m != null) {
                this.p = new ArrayList<>();
                this.q = new ArrayList<>();
                for (int i2 = 0; i2 < this.m.getOrderedCartList().size(); i2++) {
                    this.p.add(this.m.getOrderedCartList().get(i2).getName());
                    this.q.add(this.m.getOrderedCartList().get(i2).getName());
                }
                if (this.m.getOrderedCartList().size() >= 2) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    TextView textView = new TextView(this);
                    try {
                        textView.setText(getResources().getString(R.string.contact_us_title_query_regarding));
                        textView.setPadding(10, 10, 10, 10);
                        textView.setGravity(17);
                        textView.setTextSize(20.0f);
                        textView.setTextColor(Color.parseColor("#33b5e5"));
                        ListView listView = new ListView(this);
                        listView.setChoiceMode(1);
                        listView.setAdapter(new a(this));
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                                EventOrderSummary.this.a(adapterView, view, i2, j);
                            }
                        });
                        builder.setCustomTitle(textView);
                        builder.setCancelable(false);
                        builder.setInverseBackgroundForced(true);
                        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(listView) {
                            private final /* synthetic */ ListView f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                EventOrderSummary.this.a(this.f$1, dialogInterface, i2);
                            }
                        });
                        builder.setView(listView);
                        this.r = builder.create();
                        this.r.setCancelable(true);
                        this.r.setCanceledOnTouchOutside(true);
                        this.t = 0;
                        this.r.show();
                    } catch (Resources.NotFoundException unused) {
                    }
                } else {
                    CJROrderedCart cJROrderedCart = this.Q;
                    cJROrderedCart.setOrderId(this.m.getId());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
                    net.one97.paytm.o2o.events.a.a().getUpdatedCstOrderIssueIntent(this, bundle, this.T);
                }
            }
        }
    }

    private void p() {
        List<CJRSelectedInsiderSeats> list;
        final float f2;
        final float f3;
        String str;
        String str2;
        ArrayList<CJRInputSeatInfo> arrayList;
        int i2;
        String str3;
        EventOrderSummary eventOrderSummary;
        String str4;
        String str5;
        String str6 = null;
        View inflate = LayoutInflater.from(this).inflate(R.layout.events_order_summary_desc_card, (ViewGroup) null);
        CJRInputStaticMetaDataModel cJRInputStaticMetaDataModel = this.u;
        String str7 = "";
        if (cJRInputStaticMetaDataModel != null) {
            str7 = cJRInputStaticMetaDataModel.getEntityName();
            str6 = this.u.getStartTime();
            str3 = this.u.getEventDateString();
            i2 = this.u.getTicketCount();
            arrayList = this.u.getseatInfo();
            str2 = this.u.getAddress();
            str = this.u.getAddressName();
            f3 = Float.parseFloat(this.u.getLatitude());
            f2 = Float.parseFloat(this.u.getLongitude());
            list = this.u.getInsiderSeats();
        } else {
            CJRInputMetaDataModelV2 cJRInputMetaDataModelV2 = this.v;
            if (cJRInputMetaDataModelV2 != null) {
                str7 = cJRInputMetaDataModelV2.getEntityName();
                str6 = this.v.getStartTime();
                str3 = this.v.getEventDateString();
                i2 = this.v.getTicketCount();
                arrayList = this.v.getseatInfo();
                str2 = this.v.getAddress();
                str = this.v.getAddressName();
                f3 = Float.parseFloat(this.v.getLatitude());
                f2 = Float.parseFloat(this.v.getLongitude());
                list = this.v.getInsiderSeats();
            } else {
                str2 = str7;
                str = str2;
                str3 = null;
                arrayList = null;
                list = null;
                i2 = 0;
                f3 = 0.0f;
                f2 = 0.0f;
            }
        }
        ((TextView) inflate.findViewById(R.id.event_summary_event_name)).setText(str7);
        if (this.B != null) {
            RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.redemption_code);
            RoboTextView roboTextView2 = (RoboTextView) inflate.findViewById(R.id.event_orderId);
            try {
                if (this.M != null && this.M.has(Constants.RISK_TRANSACTION_ID)) {
                    String string = this.M.getString(Constants.RISK_TRANSACTION_ID);
                    if (!TextUtils.isEmpty(string)) {
                        roboTextView.setVisibility(0);
                        roboTextView.setText(getString(R.string.redemtion_code) + " : " + string);
                    }
                }
            } catch (Exception unused) {
            }
            roboTextView2.setVisibility(0);
            roboTextView2.setText(getString(R.string.paytm_order_id) + ": " + this.f73695g);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.id_event_summary_date_time);
        if (TextUtils.isEmpty(str3)) {
            String[] split = str6.split(" ");
            if (split.length <= 1 || split[0].length() <= 10) {
                str4 = com.paytm.utility.b.d(str6, "yyyy-MM-dd HH:mm:ss", "EEE, d MMM yy,");
                str5 = com.paytm.utility.b.d(str6, "yyyy-MM-dd HH:mm:ss", "h:mm a");
            } else {
                str4 = net.one97.paytm.o2o.events.e.a.a(split[0]) + AppConstants.COMMA;
                str5 = com.paytm.utility.b.d(split[1], "HH:mm:ss", "h:mm a");
            }
            textView.setText(str4 + " " + str5);
        } else {
            textView.setText(str3);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.event_summary_event_ticket_summary);
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            if (i2 == 1) {
                sb.append(i2 + " Ticket");
            } else {
                sb.append(i2 + " Tickets");
            }
            sb.append(" (");
            int size = arrayList.size();
            Iterator<CJRInputSeatInfo> it2 = arrayList.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                CJRInputSeatInfo next = it2.next();
                sb.append(" ");
                sb.append(next.getCount());
                sb.append(" ");
                sb.append(next.getSeatType());
                i3++;
                if (i3 < size) {
                    sb.append(AppConstants.COMMA);
                }
            }
            sb.append(")");
            if (list != null && list.size() > 0) {
                sb.append(" - ");
                for (int i4 = 0; i4 < list.size(); i4++) {
                    if (i4 > 0) {
                        sb.append(", ");
                    }
                    sb.append(list.get(i4).getSeatId());
                }
            }
            textView2.setText(sb.toString());
        } else {
            textView2.setVisibility(8);
        }
        TextView textView3 = (TextView) inflate.findViewById(R.id.id_event_summary_address_name);
        if (!TextUtils.isEmpty(str)) {
            textView3.setText(str);
        } else {
            textView3.setVisibility(8);
        }
        TextView textView4 = (TextView) inflate.findViewById(R.id.id_event_summary_address);
        if (!TextUtils.isEmpty(str2)) {
            textView4.setText(str2);
        } else {
            textView4.setVisibility(8);
        }
        TextView textView5 = (TextView) inflate.findViewById(R.id.id_event_summary_event_direction);
        if (f3 == 0.0f || f2 == 0.0f) {
            eventOrderSummary = this;
            textView5.setVisibility(8);
        } else {
            eventOrderSummary = this;
            textView5.setOnClickListener(new View.OnClickListener() {
                /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
                    r3.f73710c.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(r4)));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:6:0x003e, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:7:0x003f, code lost:
                    r4 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
                    net.one97.paytm.o2o.events.activity.EventOrderSummary.e();
                    com.paytm.utility.q.c(r4.getMessage());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x004a, code lost:
                    return;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0030 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onClick(android.view.View r4) {
                    /*
                        r3 = this;
                        java.util.Locale r4 = java.util.Locale.getDefault()
                        r0 = 2
                        java.lang.Object[] r0 = new java.lang.Object[r0]
                        float r1 = r12
                        java.lang.Float r1 = java.lang.Float.valueOf(r1)
                        r2 = 0
                        r0[r2] = r1
                        float r1 = r13
                        java.lang.Float r1 = java.lang.Float.valueOf(r1)
                        r2 = 1
                        r0[r2] = r1
                        java.lang.String r1 = "http://maps.google.com/maps?daddr=%f,%f"
                        java.lang.String r4 = java.lang.String.format(r4, r1, r0)
                        android.content.Intent r0 = new android.content.Intent
                        android.net.Uri r1 = android.net.Uri.parse(r4)
                        java.lang.String r2 = "android.intent.action.VIEW"
                        r0.<init>(r2, r1)
                        net.one97.paytm.o2o.events.activity.EventOrderSummary r1 = net.one97.paytm.o2o.events.activity.EventOrderSummary.this     // Catch:{ Exception -> 0x0030 }
                        r1.startActivity(r0)     // Catch:{ Exception -> 0x0030 }
                        return
                    L_0x0030:
                        android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x003f }
                        android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ ActivityNotFoundException -> 0x003f }
                        r0.<init>(r2, r4)     // Catch:{ ActivityNotFoundException -> 0x003f }
                        net.one97.paytm.o2o.events.activity.EventOrderSummary r4 = net.one97.paytm.o2o.events.activity.EventOrderSummary.this     // Catch:{ ActivityNotFoundException -> 0x003f }
                        r4.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x003f }
                        return
                    L_0x003f:
                        r4 = move-exception
                        java.lang.String unused = net.one97.paytm.o2o.events.activity.EventOrderSummary.f73689a
                        java.lang.String r4 = r4.getMessage()
                        com.paytm.utility.q.c(r4)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.events.activity.EventOrderSummary.AnonymousClass8.onClick(android.view.View):void");
                }
            });
        }
        if (eventOrderSummary.N.equalsIgnoreCase("BOOKED") || eventOrderSummary.N.equalsIgnoreCase("SUCCESS")) {
            net.one97.paytm.o2o.events.a.a().loadCashBackOffersView(eventOrderSummary.m.getId(), (LinearLayout) inflate.findViewById(R.id.event_cashback_summary_lyt), eventOrderSummary.f73693e, getSupportFragmentManager(), this);
        }
        eventOrderSummary.n.addView(inflate);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        LinearLayout linearLayout = this.U;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        LinearLayout linearLayout = this.U;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private void b(boolean z2) {
        String str;
        String str2;
        if (this.m != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary/" + this.m.getPaymentStatus());
                if (com.paytm.utility.b.r((Context) this)) {
                    String n2 = com.paytm.utility.b.n((Context) this);
                    if (!TextUtils.isEmpty(n2)) {
                        hashMap.put("event_user_id", n2);
                    }
                }
                int i2 = 0;
                if (z2) {
                    ArrayList<CJROrderSummaryPayment> paymentInfo = this.m.getPaymentInfo();
                    String str3 = "";
                    if (paymentInfo != null) {
                        int size = paymentInfo.size();
                        String str4 = str3;
                        for (int i3 = 0; i3 < size; i3++) {
                            str4 = str4 + paymentInfo.get(i3).getPaymentMethod();
                            if (i3 < size - 1) {
                                str4 = str4 + " + ";
                            }
                        }
                        str3 = str4;
                    }
                    hashMap.put("event_payment_type", String.valueOf(str3));
                    if (this.m != null && !TextUtils.isEmpty(this.m.getPaymentStatus())) {
                        hashMap.put("event_payment_status", this.m.getPaymentStatus());
                    }
                    str = "event_summary_payment_status";
                } else {
                    if (this.m != null && !TextUtils.isEmpty(this.m.getPaymentStatus())) {
                        hashMap.put("event_order_status", this.m.getStatus());
                    }
                    str = "event_summary_order_status";
                }
                if (this.m != null && this.m.getOrderedCartList() != null && this.m.getOrderedCartList().size() > 0) {
                    CJROrderedCart cJROrderedCart = this.m.getOrderedCartList().get(0);
                    if (!TextUtils.isEmpty(this.f73695g)) {
                        hashMap.put("event_order_id", this.f73695g);
                    }
                    hashMap.put("event_pdp_category_name", cJROrderedCart.getProductDetail().getVertical());
                    hashMap.put("event_pdp_event_name", cJROrderedCart.getTitle());
                    if (cJROrderedCart.getProductDetail() != null) {
                        hashMap.put("event_pdp_category_name", cJROrderedCart.getProductDetail().getVertical());
                        hashMap.put(net.one97.paytm.o2o.events.e.b.r, cJROrderedCart.getProductDetail().getName());
                        hashMap.put(net.one97.paytm.o2o.events.e.b.s, cJROrderedCart.getProductDetail().getBrandName());
                        hashMap.put(net.one97.paytm.o2o.events.e.b.v, Long.valueOf(cJROrderedCart.getProductDetail().getCategoryId()));
                    }
                    String str5 = null;
                    if (this.u != null) {
                        i2 = this.u.getTicketCount();
                        str5 = this.u.getTotalTicketPrice();
                        str2 = this.u.getProductId();
                    } else if (this.v != null) {
                        i2 = this.v.getTicketCount();
                        str5 = this.v.getTotalTicketPrice();
                        str2 = this.v.getProductId();
                    } else {
                        str2 = null;
                    }
                    if (Integer.parseInt(str5) == 0 && this.m.getSubTotal() > 0.0d) {
                        str5 = String.valueOf(this.m.getSubTotal());
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put(net.one97.paytm.o2o.events.e.b.q, str2);
                    }
                    hashMap.put(net.one97.paytm.o2o.events.e.b.u, Integer.valueOf(i2));
                    if (!TextUtils.isEmpty(str5)) {
                        hashMap.put(net.one97.paytm.o2o.events.e.b.t, str5);
                    }
                    net.one97.paytm.o2o.events.a.b().sendCustomEventWithMap(str, hashMap, this);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:91|(2:93|94)|95|96|(2:98|99)) */
    /* JADX WARNING: Code restructure failed: missing block: B:165:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x0229 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x0219 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0238 A[Catch:{ Exception -> 0x035e }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0269 A[Catch:{ Exception -> 0x035e }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0310 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x032e A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4 A[Catch:{ Exception -> 0x035e }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a5 A[Catch:{ Exception -> 0x035e }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0221 A[SYNTHETIC, Splitter:B:98:0x0221] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r15) {
        /*
            r14 = this;
            java.lang.String r0 = "digitalTicketName"
            java.lang.String r1 = "insurance"
            java.lang.String r2 = "stateArray"
            boolean r3 = r14.isFinishing()
            if (r3 == 0) goto L_0x000e
            return
        L_0x000e:
            r14.b()
            boolean r3 = r15 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            r4 = 1
            if (r3 == 0) goto L_0x035f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r15
            r14.m = r15
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.m
            java.lang.String r15 = r15.getPaymentStatus()
            r14.N = r15
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.m     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x035e
            net.one97.paytm.o2o.events.a$a r15 = net.one97.paytm.o2o.events.a.b()     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r14.m     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.y r5 = r14.f73696h     // Catch:{ Exception -> 0x035e }
            r15.sendPaytmAssistGAEvents(r3, r5, r14)     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.m     // Catch:{ Exception -> 0x035e }
            java.util.ArrayList r15 = r15.getOrderedCartList()     // Catch:{ Exception -> 0x035e }
            r3 = 0
            r5 = 0
            if (r15 == 0) goto L_0x009d
            int r6 = r15.size()     // Catch:{ Exception -> 0x035e }
            if (r6 != r4) goto L_0x0048
            java.lang.Object r15 = r15.get(r5)     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r15     // Catch:{ Exception -> 0x035e }
            goto L_0x009e
        L_0x0048:
            if (r6 <= r4) goto L_0x009d
            java.lang.String r6 = r14.X     // Catch:{ Exception -> 0x035e }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x035e }
            if (r6 != 0) goto L_0x0072
            java.lang.String r6 = r14.X     // Catch:{ Exception -> 0x035e }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x035e }
            java.util.Iterator r8 = r15.iterator()     // Catch:{ Exception -> 0x035e }
        L_0x005c:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x035e }
            if (r9 == 0) goto L_0x0072
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r9 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r9     // Catch:{ Exception -> 0x035e }
            long r10 = r9.getId()     // Catch:{ Exception -> 0x035e }
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x005c
            r15 = r9
            goto L_0x009e
        L_0x0072:
            java.util.Iterator r15 = r15.iterator()     // Catch:{ Exception -> 0x035e }
        L_0x0076:
            boolean r6 = r15.hasNext()     // Catch:{ Exception -> 0x035e }
            if (r6 == 0) goto L_0x009d
            java.lang.Object r6 = r15.next()     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6     // Catch:{ Exception -> 0x035e }
            java.util.Map r7 = r6.getRechargeConfiguration()     // Catch:{ Exception -> 0x035e }
            if (r7 == 0) goto L_0x0076
            java.lang.String r8 = "is_ticket"
            java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x035e }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x035e }
            if (r7 == 0) goto L_0x0076
            java.lang.String r8 = "true"
            boolean r7 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x035e }
            if (r7 == 0) goto L_0x0076
            r15 = r6
            goto L_0x009e
        L_0x009d:
            r15 = r3
        L_0x009e:
            r14.Q = r15     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = r14.Q     // Catch:{ Exception -> 0x035e }
            if (r15 != 0) goto L_0x00a5
            return
        L_0x00a5:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = r14.Q     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r15 = r15.getFullFillmentOject()     // Catch:{ Exception -> 0x035e }
            org.json.JSONObject r15 = r15.getFullFillment()     // Catch:{ Exception -> 0x035e }
            r14.M = r15     // Catch:{ Exception -> 0x035e }
            org.json.JSONObject r15 = r14.M     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x00da
            org.json.JSONObject r15 = r14.M     // Catch:{ Exception -> 0x035e }
            boolean r15 = r15.has(r2)     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x00da
            org.json.JSONObject r15 = r14.M     // Catch:{ Exception -> 0x035e }
            org.json.JSONArray r15 = r15.getJSONArray(r2)     // Catch:{ Exception -> 0x035e }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x035e }
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x035e }
            r2.<init>()     // Catch:{ Exception -> 0x035e }
            java.lang.Class<net.one97.paytm.o2o.events.common.CJREventTrackingInfo[]> r6 = net.one97.paytm.o2o.events.common.CJREventTrackingInfo[].class
            java.lang.Object r15 = r2.a((java.lang.String) r15, r6)     // Catch:{ Exception -> 0x035e }
            java.lang.Object[] r15 = (java.lang.Object[]) r15     // Catch:{ Exception -> 0x035e }
            java.util.List r15 = java.util.Arrays.asList(r15)     // Catch:{ Exception -> 0x035e }
            r14.P = r15     // Catch:{ Exception -> 0x035e }
        L_0x00da:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = r14.Q     // Catch:{ Exception -> 0x035e }
            java.lang.Object r15 = r15.mMetaDataResponse     // Catch:{ Exception -> 0x035e }
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x035e }
            r2.<init>()     // Catch:{ Exception -> 0x035e }
            java.lang.String r15 = r2.a((java.lang.Object) r15)     // Catch:{ Exception -> 0x035e }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x035e }
            r2.<init>(r15)     // Catch:{ Exception -> 0x035e }
            java.lang.String r6 = "passenger"
            java.lang.Object r2 = r2.get(r6)     // Catch:{ Exception -> 0x035e }
            boolean r2 = r2 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x035e }
            if (r2 == 0) goto L_0x0106
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x035e }
            r2.<init>()     // Catch:{ Exception -> 0x035e }
            java.lang.Class<net.one97.paytm.o2o.events.common.entity.events.CJRInputStaticMetaDataModel> r6 = net.one97.paytm.o2o.events.common.entity.events.CJRInputStaticMetaDataModel.class
            java.lang.Object r15 = r2.a((java.lang.String) r15, r6)     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.o2o.events.common.entity.events.CJRInputStaticMetaDataModel r15 = (net.one97.paytm.o2o.events.common.entity.events.CJRInputStaticMetaDataModel) r15     // Catch:{ Exception -> 0x035e }
            r14.u = r15     // Catch:{ Exception -> 0x035e }
            goto L_0x0115
        L_0x0106:
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x035e }
            r2.<init>()     // Catch:{ Exception -> 0x035e }
            java.lang.Class<net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2> r6 = net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2.class
            java.lang.Object r15 = r2.a((java.lang.String) r15, r6)     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2 r15 = (net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2) r15     // Catch:{ Exception -> 0x035e }
            r14.v = r15     // Catch:{ Exception -> 0x035e }
        L_0x0115:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.m     // Catch:{ Exception -> 0x035e }
            java.lang.String r15 = r15.getId()     // Catch:{ Exception -> 0x035e }
            r14.f73695g = r15     // Catch:{ Exception -> 0x035e }
            android.widget.LinearLayout r15 = r14.n     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x0126
            android.widget.LinearLayout r15 = r14.n     // Catch:{ Exception -> 0x035e }
            r15.removeAllViews()     // Catch:{ Exception -> 0x035e }
        L_0x0126:
            boolean r15 = r14.S     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = "events"
            if (r15 == 0) goto L_0x0170
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ Exception -> 0x0166 }
            r15.<init>()     // Catch:{ Exception -> 0x0166 }
            java.lang.String r6 = "screenName"
            java.lang.String r7 = "Order summary"
            r15.put(r6, r7)     // Catch:{ Exception -> 0x0166 }
            java.lang.String r6 = net.one97.paytm.o2o.events.a.a.f73681b     // Catch:{ Exception -> 0x0166 }
            java.lang.String r7 = "events_order_summary"
            r15.put(r6, r7)     // Catch:{ Exception -> 0x0166 }
            java.lang.String r6 = net.one97.paytm.o2o.events.a.a.f73682c     // Catch:{ Exception -> 0x0166 }
            java.lang.String r7 = "order_summary_loaded"
            r15.put(r6, r7)     // Catch:{ Exception -> 0x0166 }
            java.lang.String r6 = net.one97.paytm.o2o.events.a.a.f73683d     // Catch:{ Exception -> 0x0166 }
            java.lang.String r7 = r14.v()     // Catch:{ Exception -> 0x0166 }
            java.lang.String r7 = a((android.content.Context) r14, (java.lang.String) r7)     // Catch:{ Exception -> 0x0166 }
            java.lang.String r7 = a((android.content.Context) r14, (java.lang.String) r7)     // Catch:{ Exception -> 0x0166 }
            r15.put(r6, r7)     // Catch:{ Exception -> 0x0166 }
            java.lang.String r6 = net.one97.paytm.o2o.events.a.a.f73685f     // Catch:{ Exception -> 0x0166 }
            r15.put(r6, r2)     // Catch:{ Exception -> 0x0166 }
            net.one97.paytm.o2o.events.a$a r6 = net.one97.paytm.o2o.events.a.b()     // Catch:{ Exception -> 0x0166 }
            java.lang.String r7 = net.one97.paytm.o2o.events.a.a.f73680a     // Catch:{ Exception -> 0x0166 }
            r6.sendCustomEventWithMap(r7, r15, r14)     // Catch:{ Exception -> 0x0166 }
            goto L_0x016e
        L_0x0166:
            r15 = move-exception
            java.lang.String r15 = r15.getMessage()     // Catch:{ Exception -> 0x035e }
            com.paytm.utility.q.b(r15)     // Catch:{ Exception -> 0x035e }
        L_0x016e:
            r14.S = r5     // Catch:{ Exception -> 0x035e }
        L_0x0170:
            net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2 r15 = r14.v     // Catch:{ Exception -> 0x035e }
            java.lang.Integer r15 = r15.getDelivery()     // Catch:{ Exception -> 0x035e }
            r14.H = r15     // Catch:{ Exception -> 0x035e }
            boolean r15 = r14.z     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x0184
            r14.b((boolean) r4)     // Catch:{ Exception -> 0x035e }
            r14.b((boolean) r5)     // Catch:{ Exception -> 0x035e }
            r14.z = r5     // Catch:{ Exception -> 0x035e }
        L_0x0184:
            java.lang.String r15 = r14.N     // Catch:{ Exception -> 0x035e }
            int r6 = r15.hashCode()     // Catch:{ Exception -> 0x035e }
            r7 = 2
            r8 = -1
            r9 = 3
            switch(r6) {
                case -1149187101: goto L_0x01af;
                case -1031784143: goto L_0x01a5;
                case 907287315: goto L_0x019b;
                case 2066319421: goto L_0x0191;
                default: goto L_0x0190;
            }     // Catch:{ Exception -> 0x035e }
        L_0x0190:
            goto L_0x01b9
        L_0x0191:
            java.lang.String r6 = "FAILED"
            boolean r15 = r15.equals(r6)     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x01b9
            r15 = 2
            goto L_0x01ba
        L_0x019b:
            java.lang.String r6 = "PROCESSING"
            boolean r15 = r15.equals(r6)     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x01b9
            r15 = 3
            goto L_0x01ba
        L_0x01a5:
            java.lang.String r6 = "CANCELLED"
            boolean r15 = r15.equals(r6)     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x01b9
            r15 = 0
            goto L_0x01ba
        L_0x01af:
            java.lang.String r6 = "SUCCESS"
            boolean r15 = r15.equals(r6)     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x01b9
            r15 = 1
            goto L_0x01ba
        L_0x01b9:
            r15 = -1
        L_0x01ba:
            if (r15 == 0) goto L_0x0205
            if (r15 == r4) goto L_0x0205
            if (r15 == r7) goto L_0x01ef
            if (r15 == r9) goto L_0x01c4
            goto L_0x035e
        L_0x01c4:
            r14.k()     // Catch:{ Exception -> 0x035e }
            r14.p()     // Catch:{ Exception -> 0x035e }
            r14.l()     // Catch:{ Exception -> 0x035e }
            r14.m()     // Catch:{ Exception -> 0x035e }
            r14.o()     // Catch:{ Exception -> 0x035e }
            android.os.Handler r15 = r14.V     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x035e
            int r15 = r14.y     // Catch:{ Exception -> 0x035e }
            if (r15 >= r9) goto L_0x035e
            android.os.Message r15 = android.os.Message.obtain()     // Catch:{ Exception -> 0x035e }
            r15.what = r4     // Catch:{ Exception -> 0x035e }
            android.os.Handler r0 = r14.V     // Catch:{ Exception -> 0x035e }
            r1 = 10000(0x2710, double:4.9407E-320)
            r0.sendMessageDelayed(r15, r1)     // Catch:{ Exception -> 0x035e }
            int r15 = r14.y     // Catch:{ Exception -> 0x035e }
            int r15 = r15 + r4
            r14.y = r15     // Catch:{ Exception -> 0x035e }
            goto L_0x035e
        L_0x01ef:
            r14.k()     // Catch:{ Exception -> 0x035e }
            r14.j()     // Catch:{ Exception -> 0x035e }
            r14.p()     // Catch:{ Exception -> 0x035e }
            r14.o()     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.o2o.events.a$a r15 = net.one97.paytm.o2o.events.a.b()     // Catch:{ Exception -> 0x035e }
            java.lang.String r0 = "/summary"
            r15.sendOpenScreenWithDeviceInfo(r0, r2, r14)     // Catch:{ Exception -> 0x035e }
            return
        L_0x0205:
            org.json.JSONObject r15 = r14.M     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x0229
            org.json.JSONObject r15 = r14.M     // Catch:{ Exception -> 0x035e }
            boolean r15 = r15.has(r1)     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x0219
            org.json.JSONObject r15 = r14.M     // Catch:{ JSONException -> 0x0219 }
            int r15 = r15.getInt(r1)     // Catch:{ JSONException -> 0x0219 }
            r14.O = r15     // Catch:{ JSONException -> 0x0219 }
        L_0x0219:
            org.json.JSONObject r15 = r14.M     // Catch:{ Exception -> 0x035e }
            boolean r15 = r15.has(r0)     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x0229
            org.json.JSONObject r15 = r14.M     // Catch:{ JSONException -> 0x0229 }
            java.lang.String r15 = r15.getString(r0)     // Catch:{ JSONException -> 0x0229 }
            r14.B = r15     // Catch:{ JSONException -> 0x0229 }
        L_0x0229:
            r14.k()     // Catch:{ Exception -> 0x035e }
            java.lang.String r15 = r14.B     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x0269
            java.lang.String r15 = r14.B     // Catch:{ Exception -> 0x035e }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x035e }
            if (r15 != 0) goto L_0x0269
            android.view.LayoutInflater r15 = android.view.LayoutInflater.from(r14)     // Catch:{ Exception -> 0x035e }
            int r0 = net.one97.paytm.o2o.events.R.layout.event_digital_ticket_ly     // Catch:{ Exception -> 0x035e }
            android.view.View r15 = r15.inflate(r0, r3)     // Catch:{ Exception -> 0x035e }
            int r0 = net.one97.paytm.o2o.events.R.id.downloadRly     // Catch:{ Exception -> 0x035e }
            android.view.View r0 = r15.findViewById(r0)     // Catch:{ Exception -> 0x035e }
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0     // Catch:{ Exception -> 0x035e }
            int r1 = net.one97.paytm.o2o.events.R.id.digital_ticketTv     // Catch:{ Exception -> 0x035e }
            android.view.View r1 = r15.findViewById(r1)     // Catch:{ Exception -> 0x035e }
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1     // Catch:{ Exception -> 0x035e }
            int r2 = net.one97.paytm.o2o.events.R.string.download_ticket     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = r14.getString(r2)     // Catch:{ Exception -> 0x035e }
            r1.setText(r2)     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.o2o.events.activity.-$$Lambda$EventOrderSummary$hbNegWKUuVSwc9qsBZBSaZ9ZkRQ r1 = new net.one97.paytm.o2o.events.activity.-$$Lambda$EventOrderSummary$hbNegWKUuVSwc9qsBZBSaZ9ZkRQ     // Catch:{ Exception -> 0x035e }
            r1.<init>()     // Catch:{ Exception -> 0x035e }
            r0.setOnClickListener(r1)     // Catch:{ Exception -> 0x035e }
            android.widget.LinearLayout r0 = r14.n     // Catch:{ Exception -> 0x035e }
            r0.addView(r15)     // Catch:{ Exception -> 0x035e }
            goto L_0x026c
        L_0x0269:
            r14.j()     // Catch:{ Exception -> 0x035e }
        L_0x026c:
            r14.p()     // Catch:{ Exception -> 0x035e }
            java.util.List<net.one97.paytm.o2o.events.common.CJREventTrackingInfo> r15 = r14.P     // Catch:{ Exception -> 0x035e }
            if (r15 == 0) goto L_0x02b8
            java.util.List<net.one97.paytm.o2o.events.common.CJREventTrackingInfo> r15 = r14.P     // Catch:{ Exception -> 0x035e }
            int r15 = r15.size()     // Catch:{ Exception -> 0x035e }
            if (r15 <= 0) goto L_0x02b8
            android.view.LayoutInflater r15 = android.view.LayoutInflater.from(r14)     // Catch:{ Exception -> 0x035e }
            int r0 = net.one97.paytm.o2o.events.R.layout.events_order_summary_tracking_card     // Catch:{ Exception -> 0x035e }
            android.view.View r15 = r15.inflate(r0, r3)     // Catch:{ Exception -> 0x035e }
            int r0 = net.one97.paytm.o2o.events.R.id.vertical_tl_view     // Catch:{ Exception -> 0x035e }
            android.view.View r0 = r15.findViewById(r0)     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.o2o.events.view.EventTrackingView r0 = (net.one97.paytm.o2o.events.view.EventTrackingView) r0     // Catch:{ Exception -> 0x035e }
            java.util.List<net.one97.paytm.o2o.events.common.CJREventTrackingInfo> r1 = r14.P     // Catch:{ Exception -> 0x035e }
            r0.z = r1     // Catch:{ Exception -> 0x035e }
            r0.A = r14     // Catch:{ Exception -> 0x035e }
            float r1 = r0.f73796i     // Catch:{ Exception -> 0x035e }
            r0.f73795h = r1     // Catch:{ Exception -> 0x035e }
            android.graphics.Point r1 = new android.graphics.Point     // Catch:{ Exception -> 0x035e }
            r1.<init>(r5, r5)     // Catch:{ Exception -> 0x035e }
            java.util.List<net.one97.paytm.o2o.events.common.CJREventTrackingInfo> r1 = r0.z     // Catch:{ Exception -> 0x035e }
            if (r1 == 0) goto L_0x02ab
            java.util.List<net.one97.paytm.o2o.events.common.CJREventTrackingInfo> r1 = r0.z     // Catch:{ Exception -> 0x035e }
            int r1 = r1.size()     // Catch:{ Exception -> 0x035e }
            if (r1 <= 0) goto L_0x02ab
            r0.a()     // Catch:{ Exception -> 0x035e }
        L_0x02ab:
            float r1 = r0.n     // Catch:{ Exception -> 0x035e }
            r0.setViewHeight(r1)     // Catch:{ Exception -> 0x035e }
            r0.invalidate()     // Catch:{ Exception -> 0x035e }
            android.widget.LinearLayout r0 = r14.n     // Catch:{ Exception -> 0x035e }
            r0.addView(r15)     // Catch:{ Exception -> 0x035e }
        L_0x02b8:
            r14.l()     // Catch:{ Exception -> 0x035e }
            r14.m()     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2 r15 = r14.v     // Catch:{ Exception -> 0x035e }
            int r15 = r15.getInsurance()     // Catch:{ Exception -> 0x035e }
            if (r15 != r4) goto L_0x02ca
            int r15 = r14.O     // Catch:{ Exception -> 0x035e }
            if (r15 == r8) goto L_0x02ce
        L_0x02ca:
            int r15 = r14.O     // Catch:{ Exception -> 0x035e }
            if (r15 != r4) goto L_0x02eb
        L_0x02ce:
            android.view.LayoutInflater r15 = android.view.LayoutInflater.from(r14)     // Catch:{ Exception -> 0x035e }
            int r0 = net.one97.paytm.o2o.events.R.layout.events_order_summary_cancel_card     // Catch:{ Exception -> 0x035e }
            android.view.View r15 = r15.inflate(r0, r3)     // Catch:{ Exception -> 0x035e }
            int r0 = net.one97.paytm.o2o.events.R.id.cancel_ticket_txt     // Catch:{ Exception -> 0x035e }
            android.view.View r0 = r15.findViewById(r0)     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.o2o.events.activity.-$$Lambda$EventOrderSummary$2ZxCrBj8nyikU4FeTkdf8DkGu94 r1 = new net.one97.paytm.o2o.events.activity.-$$Lambda$EventOrderSummary$2ZxCrBj8nyikU4FeTkdf8DkGu94     // Catch:{ Exception -> 0x035e }
            r1.<init>()     // Catch:{ Exception -> 0x035e }
            r0.setOnClickListener(r1)     // Catch:{ Exception -> 0x035e }
            android.widget.LinearLayout r0 = r14.n     // Catch:{ Exception -> 0x035e }
            r0.addView(r15)     // Catch:{ Exception -> 0x035e }
        L_0x02eb:
            r14.h()     // Catch:{ Exception -> 0x035e }
            r14.o()     // Catch:{ Exception -> 0x035e }
            net.one97.paytm.o2o.events.a$b r15 = net.one97.paytm.o2o.events.a.a()     // Catch:{  }
            java.lang.String r0 = "categorymap"
            java.lang.String r12 = r15.getStringFromGTM(r0)     // Catch:{  }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = r14.Q     // Catch:{  }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r15 = r15.getProductDetail()     // Catch:{  }
            long r0 = r15.getCategoryId()     // Catch:{  }
            java.lang.Long.toString(r0)     // Catch:{  }
            java.lang.String r11 = r15.getVertical()     // Catch:{  }
            boolean r15 = r14.w     // Catch:{  }
            if (r15 != 0) goto L_0x0326
            net.one97.paytm.o2o.events.a$a r5 = net.one97.paytm.o2o.events.a.b()     // Catch:{  }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r14.m     // Catch:{  }
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r8 = r14.k     // Catch:{  }
            java.lang.String r9 = r14.l     // Catch:{  }
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{  }
            java.lang.Long r13 = java.lang.Long.valueOf(r0)     // Catch:{  }
            r6 = r14
            r5.sendGTMOrderSummaryTag(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{  }
            r14.w = r4     // Catch:{  }
        L_0x0326:
            java.lang.String r15 = r14.f73693e     // Catch:{  }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{  }
            if (r15 != 0) goto L_0x035e
            java.lang.String r15 = r14.f73693e     // Catch:{  }
            java.lang.String r0 = "Payment"
            boolean r15 = r15.equalsIgnoreCase(r0)     // Catch:{  }
            if (r15 != 0) goto L_0x0342
            java.lang.String r15 = r14.f73693e     // Catch:{  }
            java.lang.String r0 = "paytm_automatic"
            boolean r15 = r15.equalsIgnoreCase(r0)     // Catch:{  }
            if (r15 == 0) goto L_0x035e
        L_0x0342:
            net.one97.paytm.o2o.events.a$b r0 = net.one97.paytm.o2o.events.a.a()     // Catch:{  }
            java.lang.String r2 = "events"
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.m     // Catch:{  }
            double r3 = r15.getSubTotal()     // Catch:{  }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{  }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.m     // Catch:{  }
            java.lang.String r4 = r15.getId()     // Catch:{  }
            java.lang.String r5 = r14.N     // Catch:{  }
            r1 = r14
            r0.sendTransactionBetaOutForWallet(r1, r2, r3, r4, r5)     // Catch:{  }
        L_0x035e:
            return
        L_0x035f:
            boolean r0 = r15 instanceof net.one97.paytm.o2o.events.common.CJREventCancelInsuranceResponse
            java.lang.String r1 = "(s)"
            if (r0 == 0) goto L_0x03b0
            net.one97.paytm.o2o.events.common.CJREventCancelInsuranceResponse r15 = (net.one97.paytm.o2o.events.common.CJREventCancelInsuranceResponse) r15
            int r0 = r15.getCode()
            java.lang.String r15 = r15.getMsg()
            boolean r2 = r14.isFinishing()
            if (r2 != 0) goto L_0x03af
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.res.Resources r3 = r14.getResources()
            int r4 = net.one97.paytm.o2o.events.R.string.cancel_ticket
            java.lang.String r3 = r3.getString(r4)
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            r2.<init>(r14)
            android.app.AlertDialog$Builder r1 = r2.setTitle(r1)
            r1.setMessage(r15)
            android.content.res.Resources r15 = r14.getResources()
            int r1 = net.one97.paytm.o2o.events.R.string.ok
            java.lang.String r15 = r15.getString(r1)
            net.one97.paytm.o2o.events.activity.-$$Lambda$EventOrderSummary$ky1PuWE_nrfX20tv-i3sJeoalIw r1 = new net.one97.paytm.o2o.events.activity.-$$Lambda$EventOrderSummary$ky1PuWE_nrfX20tv-i3sJeoalIw
            r1.<init>(r0)
            r2.setPositiveButton(r15, r1)
            r2.show()
        L_0x03af:
            return
        L_0x03b0:
            boolean r0 = r15 instanceof net.one97.paytm.o2o.events.common.CJREventPreClaimInsuranceResponse
            if (r0 == 0) goto L_0x0405
            net.one97.paytm.o2o.events.common.CJREventPreClaimInsuranceResponse r15 = (net.one97.paytm.o2o.events.common.CJREventPreClaimInsuranceResponse) r15
            java.lang.String r15 = r15.getMessage()
            boolean r0 = r14.isFinishing()
            if (r0 != 0) goto L_0x0404
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.res.Resources r2 = r14.getResources()
            int r3 = net.one97.paytm.o2o.events.R.string.cancel_ticket
            java.lang.String r2 = r2.getString(r3)
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
            r1.<init>(r14)
            android.app.AlertDialog$Builder r0 = r1.setTitle(r0)
            r0.setMessage(r15)
            android.content.res.Resources r15 = r14.getResources()
            int r0 = net.one97.paytm.o2o.events.R.string.ok
            java.lang.String r15 = r15.getString(r0)
            net.one97.paytm.o2o.events.activity.-$$Lambda$EventOrderSummary$o7YZnJ5RGgHcizGugG0joj_S9aY r0 = new net.one97.paytm.o2o.events.activity.-$$Lambda$EventOrderSummary$o7YZnJ5RGgHcizGugG0joj_S9aY
            r0.<init>()
            r1.setPositiveButton(r15, r0)
            net.one97.paytm.o2o.events.activity.-$$Lambda$EventOrderSummary$c1qztRndJkVbvZmuvk-oM8vW0F8 r15 = net.one97.paytm.o2o.events.activity.$$Lambda$EventOrderSummary$c1qztRndJkVbvZmuvkoM8vW0F8.INSTANCE
            java.lang.String r0 = "Cancel"
            r1.setNegativeButton(r0, r15)
            r1.setCancelable(r4)
            r1.show()
        L_0x0404:
            return
        L_0x0405:
            boolean r0 = r15 instanceof net.one97.paytm.o2o.events.common.CJREventsDownloadTicket
            if (r0 == 0) goto L_0x0427
            net.one97.paytm.o2o.events.common.CJREventsDownloadTicket r15 = (net.one97.paytm.o2o.events.common.CJREventsDownloadTicket) r15
            java.lang.String r15 = r15.getTicketUrl()
            r14.C = r15
            boolean r15 = com.paytm.utility.s.a()
            if (r15 == 0) goto L_0x0424
            boolean r15 = com.paytm.utility.s.c((android.app.Activity) r14)
            if (r15 != 0) goto L_0x0424
            r14.t()
            com.paytm.utility.s.b((android.app.Activity) r14)
            return
        L_0x0424:
            r14.r()
        L_0x0427:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.events.activity.EventOrderSummary.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, final NetworkCustomError networkCustomError) {
        b();
        if (!isFinishing()) {
            b();
            t();
            b();
            runOnUiThread(new Runnable() {
                public final void run() {
                    NetworkCustomError networkCustomError = networkCustomError;
                    if (networkCustomError != null) {
                        CJRIllegalCodeError cJRIllegalCodeError = null;
                        String str = (networkCustomError.networkResponse == null || networkCustomError.networkResponse.data == null) ? null : new String(networkCustomError.networkResponse.data);
                        if (!TextUtils.isEmpty(str)) {
                            cJRIllegalCodeError = new CJRIllegalCodeError();
                            try {
                                cJRIllegalCodeError = (CJRIllegalCodeError) new f().a(str, cJRIllegalCodeError.getClass());
                            } catch (Exception unused) {
                            }
                        }
                        String alertMessage = networkCustomError.getAlertMessage();
                        String alertTitle = networkCustomError.getAlertTitle();
                        String message = networkCustomError.getMessage();
                        if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("412")) {
                            com.paytm.utility.b.b((Context) EventOrderSummary.this, alertTitle, alertMessage);
                        } else if (!TextUtils.isEmpty(message) && (message.equalsIgnoreCase("410") || message.equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                            net.one97.paytm.o2o.events.a.a().handleError(EventOrderSummary.this, networkCustomError, net.one97.paytm.o2o.events.a.a().getMainActivityClassName(), (Bundle) null, Boolean.FALSE);
                        } else if (networkCustomError.getMessage() == null || net.one97.paytm.o2o.events.a.a().reportError(EventOrderSummary.this, networkCustomError, "error.movies@paytm.com")) {
                            if (cJRIllegalCodeError.getStatusError() != null && cJRIllegalCodeError.getStatusError().getmMessage() != null) {
                                com.paytm.utility.b.b((Context) EventOrderSummary.this, cJRIllegalCodeError.getStatusError().getmMessage().getTitle(), cJRIllegalCodeError.getStatusError().getmMessage().getMessage());
                            }
                        } else if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                            String string = EventOrderSummary.this.getResources().getString(R.string.network_error_message);
                            EventOrderSummary eventOrderSummary = EventOrderSummary.this;
                            com.paytm.utility.b.b((Context) eventOrderSummary, eventOrderSummary.getResources().getString(R.string.network_error_heading), string);
                        } else {
                            com.paytm.utility.b.d((Context) EventOrderSummary.this, networkCustomError.getUrl(), String.valueOf(networkCustomError.networkResponse.statusCode));
                        }
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private static JSONObject q() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "EventOrderSummary");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void r() {
        if (com.paytm.utility.b.c((Context) this)) {
            new net.one97.paytm.o2o.events.e.a().a((Context) this, this.C, this.f73695g, (net.one97.paytm.o2o.events.b.a) this);
            return;
        }
        t();
        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
    }

    public final void c() {
        t();
    }

    private void s() {
        if (this.A == null) {
            this.A = new ProgressDialog(this);
        }
        this.A.setMessage("please wait.");
        this.A.show();
    }

    private void t() {
        ProgressDialog progressDialog = this.A;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.A.dismiss();
        }
    }

    public final void d() {
        t();
    }

    private TemplateData u() {
        JSONObject jSONObject;
        try {
            if (this.M == null || this.M.isNull("templateData") || (jSONObject = this.M.getJSONObject("templateData")) == null) {
                return null;
            }
            return (TemplateData) new f().a(jSONObject.toString(), TemplateData.class);
        } catch (Exception unused) {
            getClass().getSimpleName();
        }
        return null;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    private String v() {
        try {
            if (this.Q == null || this.Q.mMetaDataResponse == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(new f().a(this.Q.mMetaDataResponse));
            if (jSONObject.has("entityId")) {
                return jSONObject.getString("entityId");
            }
            return "";
        } catch (Exception unused) {
            getClass().getSimpleName();
            return "";
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        CheckedTextView f73715a;

        b() {
        }
    }

    class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private LayoutInflater f73714b;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public a(Context context) {
            this.f73714b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public final int getCount() {
            return EventOrderSummary.this.p.size();
        }

        public final Object getItem(int i2) {
            return Integer.valueOf(i2);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            if (view == null) {
                bVar = new b();
                view2 = this.f73714b.inflate(R.layout.event_contact_all_reason_single_item, (ViewGroup) null);
                bVar.f73715a = (CheckedTextView) view2.findViewById(R.id.singleItem);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            bVar.f73715a.setText((CharSequence) EventOrderSummary.this.p.get(i2));
            return view2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        if (android.text.TextUtils.isEmpty(r0.getState()) == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (android.text.TextUtils.isEmpty(r4.v.getBoxOffice().getAddress()) == false) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l() {
        /*
            r4 = this;
            java.lang.Integer r0 = r4.H
            r1 = 0
            if (r0 != 0) goto L_0x0007
            goto L_0x007b
        L_0x0007:
            int r0 = r0.intValue()
            r2 = 1
            if (r0 != r2) goto L_0x005a
            net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2 r0 = r4.v
            net.one97.paytm.common.entity.events.CJREventTicketDeliveryAddress r0 = r0.getDeliveryAddress()
            if (r0 == 0) goto L_0x005a
            net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2 r0 = r4.v
            net.one97.paytm.common.entity.events.CJREventTicketDeliveryAddress r0 = r0.getDeliveryAddress()
            java.lang.String r3 = r0.getAddress1()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x007b
            java.lang.String r3 = r0.getAddress2()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x007b
            java.lang.String r3 = r0.getCity()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x007b
            java.lang.String r3 = r0.getLandmark()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x007b
            java.lang.String r3 = r0.getPincode()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x007b
            java.lang.String r0 = r0.getState()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x007b
        L_0x0058:
            r1 = 1
            goto L_0x007b
        L_0x005a:
            java.lang.Integer r0 = r4.H
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x007b
            net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2 r0 = r4.v
            net.one97.paytm.common.entity.events.CJREventPickupAddressInfo r0 = r0.getBoxOffice()
            if (r0 == 0) goto L_0x007b
            net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2 r0 = r4.v
            net.one97.paytm.common.entity.events.CJREventPickupAddressInfo r0 = r0.getBoxOffice()
            java.lang.String r0 = r0.getAddress()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x0058
        L_0x007b:
            if (r1 == 0) goto L_0x00a0
            net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2 r0 = r4.v
            net.one97.paytm.common.entity.events.CJREventTicketDeliveryAddress r0 = r0.getDeliveryAddress()
            java.lang.Integer r1 = r4.H
            int r1 = r1.intValue()
            net.one97.paytm.o2o.events.common.entity.events.CJRInputMetaDataModelV2 r2 = r4.v
            net.one97.paytm.common.entity.events.CJREventPickupAddressInfo r2 = r2.getBoxOffice()
            java.lang.String r2 = r2.getAddress()
            net.one97.paytm.o2o.events.view.CJREventDeliveryView r0 = net.one97.paytm.o2o.events.view.CJREventDeliveryView.a(r4, r0, r1, r2, r4)
            r4.x = r0
            android.widget.LinearLayout r0 = r4.n
            net.one97.paytm.o2o.events.view.CJREventDeliveryView r1 = r4.x
            r0.addView(r1)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.events.activity.EventOrderSummary.l():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        CJREventsPricesModel n2;
        if ((this.v != null || this.u != null) && (n2 = n()) != null) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("price_model", n2);
            bundle.putString(PayUtility.PROMO_CODE, this.Q.getPromoCode());
            bundle.putString("promo_text", this.Q.getPromoText());
            bundle.putString("order_id", this.f73695g);
            String totalInsurancePremium = this.v.getTotalInsurancePremium();
            if (!TextUtils.isEmpty(totalInsurancePremium)) {
                CJREventCancellationProtectDetail cJREventCancellationProtectDetail = new CJREventCancellationProtectDetail();
                cJREventCancellationProtectDetail.setInsuranceTax(this.v.getInsuranceTax());
                cJREventCancellationProtectDetail.setTotalPremium(totalInsurancePremium);
                bundle.putSerializable("cancellation_detail", cJREventCancellationProtectDetail);
            }
            aVar.setArguments(bundle);
            findViewById(R.id.id_event_summary_fragment_container).setVisibility(0);
            getSupportFragmentManager().a().a(R.id.id_event_summary_fragment_container, aVar, (String) null).a("").b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        a();
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this;
        bVar.f42878b = a.c.EVENT;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = net.one97.paytm.o2o.events.a.a().getStringFromGTM("event_insurace_pre_claim") + this.m.getId();
        bVar.f42881e = null;
        bVar.f42882f = null;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.f42885i = new CJREventPreClaimInsuranceResponse();
        bVar.j = this;
        bVar.n = a.b.USER_FACING;
        bVar.o = EventsModuleManager.MODULE_NAME;
        bVar.t = q();
        com.paytm.network.a l2 = bVar.l();
        l2.f42859c = false;
        l2.a();
    }

    static /* synthetic */ void a(EventOrderSummary eventOrderSummary, View view, Bitmap bitmap) {
        eventOrderSummary.G = view;
        eventOrderSummary.E = new int[2];
        view.getLocationOnScreen(eventOrderSummary.E);
        eventOrderSummary.D.setX((float) eventOrderSummary.E[0]);
        eventOrderSummary.D.setY((float) eventOrderSummary.E[1]);
        eventOrderSummary.D.setPivotX(0.0f);
        eventOrderSummary.D.setPivotY(0.0f);
        eventOrderSummary.D.getLayoutParams().width = view.getWidth();
        eventOrderSummary.D.getLayoutParams().height = view.getHeight();
        eventOrderSummary.D.setImageBitmap(bitmap);
        eventOrderSummary.i();
    }

    static /* synthetic */ void a(EventOrderSummary eventOrderSummary, String str, String str2) {
        Intent intent = new Intent(eventOrderSummary, net.one97.paytm.o2o.events.a.a().getEmbedWebView());
        intent.putExtra("url", str2);
        intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, str);
        eventOrderSummary.startActivity(intent);
    }
}
