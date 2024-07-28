package net.one97.paytm.o2o.amusementpark.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.android.volley.toolbox.NetworkImageView;
import com.business.merchant_payments.utility.StringUtility;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.b.h;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.c;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.amPark.CJRInputMetaDataModel;
import net.one97.paytm.common.entity.amPark.CJRInputSeatInfo;
import net.one97.paytm.common.entity.amPark.CJRInputStaticMetaDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJROtherTaxes;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.utils.d;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.y;
import org.json.JSONException;
import org.json.JSONObject;

public class AmParkOrderSummary extends PaytmActivity implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f73356a = AmParkOrderSummary.class.getSimpleName();
    private int A;
    private ProgressBar B;
    private Handler C;
    private FrameLayout D;
    /* access modifiers changed from: private */
    public m E;

    /* renamed from: b  reason: collision with root package name */
    private final int f73357b = 3;

    /* renamed from: c  reason: collision with root package name */
    private CJRItem f73358c;

    /* renamed from: d  reason: collision with root package name */
    private String f73359d;

    /* renamed from: e  reason: collision with root package name */
    private String f73360e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, Object> f73361f = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f73362g;

    /* renamed from: h  reason: collision with root package name */
    private y f73363h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f73364i;
    private CJRParcelTrackingInfo j;
    private String k;
    private boolean l;
    /* access modifiers changed from: private */
    public CJROrderSummary m;
    private String n;
    private LinearLayout o;
    private ImageView p;
    private TextView q;
    /* access modifiers changed from: private */
    public ArrayList<String> r;
    private ArrayList<String> s;
    /* access modifiers changed from: private */
    public Dialog t;
    /* access modifiers changed from: private */
    public Dialog u;
    /* access modifiers changed from: private */
    public int v;
    /* access modifiers changed from: private */
    public CJRInputStaticMetaDataModel w = null;
    /* access modifiers changed from: private */
    public CJRInputMetaDataModel x = null;
    /* access modifiers changed from: private */
    public Float y;
    /* access modifiers changed from: private */
    public Float z;

    public AmParkOrderSummary() {
        Float valueOf = Float.valueOf(0.0f);
        this.y = valueOf;
        this.z = valueOf;
        this.C = new Handler() {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (!AmParkOrderSummary.this.isFinishing() && !AmParkOrderSummary.this.isDestroyed() && message.what == 1) {
                    AmParkOrderSummary amParkOrderSummary = AmParkOrderSummary.this;
                    amParkOrderSummary.b(amParkOrderSummary.f73362g);
                }
            }
        };
    }

    public static int a(ListView listView) {
        if (Build.VERSION.SDK_INT >= 11) {
            return listView.getCheckedItemCount();
        }
        int i2 = 0;
        for (int count = listView.getCount() - 1; count >= 0; count--) {
            if (listView.isItemChecked(count)) {
                i2++;
            }
        }
        return i2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.park_order_summary_home);
        this.E = new m() {
            public final void show() {
                AmParkOrderSummary amParkOrderSummary = AmParkOrderSummary.this;
                amParkOrderSummary.a((Context) amParkOrderSummary);
            }

            public final void dismiss() {
                AmParkOrderSummary.this.a();
            }
        };
        this.A = 0;
        if (!(getIntent() == null || getIntent() == null)) {
            if (getIntent().hasExtra(UpiConstants.FROM)) {
                this.f73360e = getIntent().getStringExtra(UpiConstants.FROM);
            }
            if (getIntent().hasExtra("order_id")) {
                this.f73362g = getIntent().getStringExtra("order_id");
            }
            if (getIntent().hasExtra("is_deep_linking_data")) {
                this.l = getIntent().getBooleanExtra("is_deep_linking_data", false);
            }
            if (getIntent().hasExtra("Recharge")) {
                this.f73364i = getIntent().getBooleanExtra("Recharge", false);
            }
            if (getIntent().hasExtra("tracking_info")) {
                this.j = (CJRParcelTrackingInfo) getIntent().getParcelableExtra("tracking_info");
            }
            if (getIntent().hasExtra("referralSource")) {
                this.k = getIntent().getStringExtra("referralSource");
            }
            if (getIntent().hasExtra("intent_extra_wallet_paytm_assist_gtmevents")) {
                this.f73363h = (y) getIntent().getSerializableExtra("intent_extra_wallet_paytm_assist_gtmevents");
            }
        }
        this.B = (ProgressBar) findViewById(R.id.event_order_summary_progress_bar);
        this.o = (LinearLayout) findViewById(R.id.event_order_summary_container);
        this.p = (ImageView) findViewById(R.id.back_arrow);
        this.q = (RoboTextView) findViewById(R.id.top_title);
        this.q.setText("Ticket Summary");
        this.p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AmParkOrderSummary.this.onBackPressed();
            }
        });
        if (getIntent() == null || !this.l || this.f73362g.isEmpty()) {
            if (getIntent() != null && getIntent().hasExtra("extra_home_data")) {
                this.f73358c = (CJRItem) getIntent().getExtras().getSerializable("extra_home_data");
                CJRItem cJRItem = this.f73358c;
                if (cJRItem != null) {
                    this.f73361f.put("search_type", cJRItem.getSearchType());
                    this.f73361f.put("search_category", cJRItem.getSearchCategory());
                    this.f73361f.put("search_term", cJRItem.getSearchTerm());
                    this.f73361f.put("search_result_type", cJRItem.getSearchResultType());
                }
                this.f73359d = this.f73358c.getURL();
                this.f73360e = "Deep Linking";
                if (!TextUtils.isEmpty(this.f73359d)) {
                    a(this.f73359d);
                    return;
                }
                return;
            } else if (!(getIntent() == null || getIntent().getData() == null || TextUtils.isEmpty(getIntent().getData().getQueryParameter("url")))) {
                this.f73359d = getIntent().getData().getQueryParameter("url");
                this.f73360e = "Deep Linking";
                a(this.f73359d);
                return;
            }
        }
        b(this.f73362g);
    }

    public void onBackPressed() {
        if (!TextUtils.isEmpty(this.f73360e) && !this.f73360e.equalsIgnoreCase("Order_history")) {
            new CJRHomePageItem().setUrl(net.one97.paytm.o2o.amusementpark.f.a.a(getApplicationContext()).b("home_url", "", true));
            Intent intent = new Intent(this, net.one97.paytm.o2o.amusementpark.a.a().getMainActivity());
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.setFlags(536870912);
            intent.putExtra("CLEAR_MOBILE_DATA", true);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            if (!TextUtils.isEmpty(this.f73360e) && this.f73360e.equalsIgnoreCase("Payment")) {
                intent.putExtra("Reset_fast_farward", true);
            }
            startActivity(intent);
            finish();
        }
        super.onBackPressed();
    }

    private void a(String str) {
        String str2;
        if (str == null || TextUtils.isEmpty(str)) {
            b();
        } else if (!TextUtils.isEmpty(net.one97.paytm.o2o.amusementpark.f.a.a(getApplicationContext()).b("sso_token=", "", true))) {
            String b2 = c.b(str, (Context) this);
            if (TextUtils.isEmpty(this.f73360e) || (!this.f73360e.equalsIgnoreCase("Payment") && !this.f73360e.equalsIgnoreCase("paytm_automatic"))) {
                str2 = b2 + "&actions=1";
            } else {
                str2 = b2 + "&actions=0";
            }
            HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), (Context) this);
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.AM_PARK;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = str2;
            bVar.f42881e = null;
            bVar.f42882f = a2;
            bVar.f42883g = null;
            bVar.f42884h = null;
            bVar.f42885i = new CJROrderSummary();
            bVar.n = a.b.USER_FACING;
            bVar.o = "AmPark";
            bVar.j = this;
            bVar.t = f();
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            l2.a();
            a((Context) this);
        } else {
            c(str);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        try {
            this.f73359d = net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("orderdetail") + str;
        } catch (Exception unused) {
        }
        a(this.f73359d);
    }

    private void b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.error));
        builder.setMessage(getResources().getString(R.string.msg_invalid_url)).setCancelable(false).setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AmParkOrderSummary.this.finish();
            }
        });
        builder.create().show();
    }

    private void c(String str) {
        Intent intent = new Intent(this, net.one97.paytm.o2o.amusementpark.a.a().getLoginActivity());
        intent.putExtra("resultant activity", net.one97.paytm.o2o.amusementpark.a.a().getNameForAJROrderSummaryActivity());
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

    private void c() {
        String str;
        ArrayList<CJRInputSeatInfo> arrayList;
        int i2;
        String[] strArr;
        String str2;
        String[] strArr2;
        String str3;
        char c2;
        String str4;
        int i3;
        this.f73362g = this.m.getId();
        LinearLayout linearLayout = this.o;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        String str5 = this.n;
        char c3 = 65535;
        int hashCode = str5.hashCode();
        if (hashCode != -1149187101) {
            if (hashCode != 907287315) {
                if (hashCode == 2066319421 && str5.equals("FAILED")) {
                    c3 = 1;
                }
            } else if (str5.equals("PROCESSING")) {
                c3 = 2;
            }
        } else if (str5.equals("SUCCESS")) {
            c3 = 0;
        }
        String str6 = "";
        if (c3 == 0) {
            View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.park_success_card, (ViewGroup) null);
            if (inflate != null) {
                this.o.addView(inflate);
            }
            ArrayList<CJROrderedCart> orderedCartList = this.m.getOrderedCartList();
            View inflate2 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.park_success_ticket_event_detail, (ViewGroup) null);
            if (inflate2 != null) {
                if (orderedCartList != null && orderedCartList.size() > 0) {
                    CJRInputStaticMetaDataModel cJRInputStaticMetaDataModel = this.w;
                    if (cJRInputStaticMetaDataModel != null) {
                        str3 = cJRInputStaticMetaDataModel.getImageUrl();
                        str2 = this.w.getEntityName();
                        strArr = this.w.getStartTime().split(" ");
                        strArr2 = this.w.getEndTime().split(" ");
                        i2 = this.w.getTicketCount();
                        arrayList = this.w.getseatInfo();
                        str = this.w.getAddress();
                    } else {
                        CJRInputMetaDataModel cJRInputMetaDataModel = this.x;
                        if (cJRInputMetaDataModel != null) {
                            str3 = cJRInputMetaDataModel.getImageUrl();
                            str2 = this.x.getEntityName();
                            strArr = this.x.getStartTime().split(" ");
                            strArr2 = this.x.getEndTime().split(" ");
                            i2 = this.x.getTicketCount();
                            arrayList = this.x.getseatInfo();
                            str = this.x.getAddress();
                        } else {
                            str3 = str6;
                            str2 = str3;
                            str = str2;
                            strArr2 = null;
                            strArr = null;
                            arrayList = null;
                            i2 = 0;
                        }
                    }
                    ((NetworkImageView) inflate2.findViewById(R.id.event_imageview_thumb_nail)).setImageUrl(str3, h.INSTANCE.getImageLoader());
                    if (!(orderedCartList.get(0) == null || orderedCartList.get(0).getFullFillmentOject() == null || TextUtils.isEmpty(orderedCartList.get(0).getFullFillmentOject().getFulfillmentResponse()))) {
                        str6 = d(orderedCartList.get(0).getFullFillmentOject().getFulfillmentResponse());
                    }
                    TextView textView = (TextView) inflate2.findViewById(R.id.event_booking_id_textview);
                    if (TextUtils.isEmpty(str6)) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(getResources().getString(R.string.booking_id) + StringUtility.NEW_LINE + str6);
                    }
                    ((TextView) inflate2.findViewById(R.id.event_name)).setText(str2);
                    TextView textView2 = (TextView) inflate2.findViewById(R.id.event_date);
                    TextView textView3 = (TextView) inflate2.findViewById(R.id.event_time);
                    if (strArr == null || strArr.length != 2) {
                        c2 = 1;
                        str4 = null;
                    } else {
                        String b2 = d.b(getApplicationContext(), strArr[0]);
                        c2 = 1;
                        str4 = d.a(getApplicationContext(), strArr[1]);
                        textView2.setText(b2);
                    }
                    String a2 = (strArr2 == null || strArr2.length != 2) ? null : d.a(getApplicationContext(), strArr2[c2]);
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(a2)) {
                        textView3.setText(str4 + getString(R.string.to) + a2);
                    }
                    TextView textView4 = (TextView) inflate2.findViewById(R.id.event_ticket_summary);
                    if (arrayList != null) {
                        StringBuilder sb = new StringBuilder();
                        if (i2 > 0) {
                            sb.append("Visitor Count : ".concat(String.valueOf(i2)));
                        }
                        Iterator<CJRInputSeatInfo> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            CJRInputSeatInfo next = it2.next();
                            sb.append(StringUtility.NEW_LINE);
                            sb.append(next.getSeatType());
                            String packageType = next.getPackageType();
                            if (!TextUtils.isEmpty(packageType)) {
                                sb.append(", ".concat(String.valueOf(packageType)));
                            }
                            int count = next.getCount();
                            StringBuilder sb2 = new StringBuilder(" : ");
                            sb2.append(count);
                            sb2.append(count > 1 ? " Ticket(s)" : " Ticket");
                            sb.append(sb2.toString());
                        }
                        textView4.setText(sb.toString());
                        i3 = 8;
                    } else {
                        i3 = 8;
                        textView4.setVisibility(8);
                    }
                    TextView textView5 = (TextView) inflate2.findViewById(R.id.event_address_name);
                    if (!TextUtils.isEmpty(str)) {
                        textView5.setText(str);
                    } else {
                        textView5.setVisibility(i3);
                    }
                }
                TextView textView6 = (TextView) inflate2.findViewById(R.id.txt_events_view_more);
                if (this.y.floatValue() == 0.0f || this.z.floatValue() == 0.0f) {
                    textView6.setVisibility(8);
                }
                textView6.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AmParkOrderSummary.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.com/maps?daddr=" + AmParkOrderSummary.this.y + AppConstants.COMMA + AmParkOrderSummary.this.z)));
                    }
                });
                this.o.addView(inflate2);
            }
            b(this.m.getOrderedCartList());
            d();
            e();
            try {
                if (TextUtils.isEmpty(this.f73360e)) {
                    return;
                }
                if (this.f73360e.equalsIgnoreCase("Payment") || this.f73360e.equalsIgnoreCase("paytm_automatic")) {
                    net.one97.paytm.o2o.amusementpark.a.a().sendTransactionBetaOutForWallet(this, "amusement", String.valueOf(this.m.getSubTotal()), this.m.getId(), this.n);
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        } else if (c3 == 1) {
            View inflate3 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.park_failed_card_new, (ViewGroup) null);
            if (inflate3 != null) {
                ((TextView) inflate3.findViewById(R.id.try_again_btn)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                        cJRHomePageItem.setUrlType("amusement");
                        if (AmParkOrderSummary.this.w != null) {
                            cJRHomePageItem.setmParkName(AmParkOrderSummary.this.w.getEntityName());
                            cJRHomePageItem.setmParkProviderId(AmParkOrderSummary.this.w.getProviderId());
                            cJRHomePageItem.setmParkCategory(AmParkOrderSummary.this.w.getCategory());
                            cJRHomePageItem.setmParkCityName(AmParkOrderSummary.this.w.getEntityCity());
                        } else if (AmParkOrderSummary.this.x != null) {
                            cJRHomePageItem.setmParkName(AmParkOrderSummary.this.x.getEntityName());
                            cJRHomePageItem.setmParkProviderId(AmParkOrderSummary.this.x.getProviderId());
                            cJRHomePageItem.setmParkCategory(AmParkOrderSummary.this.x.getCategory());
                            cJRHomePageItem.setmParkCityName(AmParkOrderSummary.this.x.getEntityCity());
                        }
                        Intent intent = new Intent(AmParkOrderSummary.this, AmParkVerticalActivity.class);
                        intent.putExtra("extra_home_data", cJRHomePageItem);
                        intent.addFlags(67108864);
                        intent.addFlags(268435456);
                        intent.setFlags(536870912);
                        intent.putExtra("extra_url_type", "amusement");
                        AmParkOrderSummary.this.startActivity(intent);
                        AmParkOrderSummary.this.finish();
                    }
                });
                this.o.addView(inflate3);
            }
            a(this.m.getOrderedCartList());
            d();
            e();
        } else if (c3 == 2) {
            ArrayList<CJROrderedCart> orderedCartList2 = this.m.getOrderedCartList();
            View inflate4 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.park_pending_card, (ViewGroup) null);
            if (inflate4 != null) {
                ((TextView) inflate4.findViewById(R.id.events_pending_my_order)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AmParkOrderSummary.i(AmParkOrderSummary.this);
                    }
                });
                if (orderedCartList2 != null && orderedCartList2.size() > 0) {
                    CJRInputStaticMetaDataModel cJRInputStaticMetaDataModel2 = this.w;
                    if (cJRInputStaticMetaDataModel2 != null) {
                        str6 = cJRInputStaticMetaDataModel2.getEntityName();
                        this.w.getStartTime();
                    } else {
                        CJRInputMetaDataModel cJRInputMetaDataModel2 = this.x;
                        if (cJRInputMetaDataModel2 != null) {
                            str6 = cJRInputMetaDataModel2.getEntityName();
                            this.x.getStartTime();
                        }
                    }
                    if (!TextUtils.isEmpty(str6)) {
                        ((TextView) inflate4.findViewById(R.id.pending_header_text)).setText("Your Booking is yet to be confirmed by ".concat(String.valueOf(str6)));
                    }
                }
                this.o.addView(inflate4);
            }
            a(this.m.getOrderedCartList());
            b(this.m.getOrderedCartList());
            d();
            e();
            if (this.C != null && this.A < 3) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                this.C.sendMessageDelayed(obtain, 10000);
                this.A++;
            }
        }
    }

    private void d() {
        if (!TextUtils.isEmpty(this.f73360e) && !this.f73360e.equalsIgnoreCase("Order_history")) {
            if (this.D == null) {
                this.D = new FrameLayout(this);
                this.D.setId(net.one97.paytm.o2o.amusementpark.a.a().getDealContentId());
                Fragment postPaymentDealsFragment = net.one97.paytm.o2o.amusementpark.a.a().getPostPaymentDealsFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("deal_type", net.one97.paytm.o2o.amusementpark.a.a().getEntertainmentDealTypeValue());
                postPaymentDealsFragment.setArguments(bundle);
                getSupportFragmentManager().a().a(net.one97.paytm.o2o.amusementpark.a.a().getDealContentId(), postPaymentDealsFragment, net.one97.paytm.o2o.amusementpark.a.a().getPostPaymentDealsFragmentTagValue()).b();
            }
            this.o.addView(this.D);
        }
    }

    private void a(ArrayList<CJROrderedCart> arrayList) {
        String str;
        String[] split;
        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.park_order_summary_pending_failed_desc, (ViewGroup) null);
        if (inflate != null) {
            if (arrayList != null && arrayList.size() > 0) {
                arrayList.get(0).getMetaDataResponse();
                CJRInputStaticMetaDataModel cJRInputStaticMetaDataModel = this.w;
                String str2 = "";
                if (cJRInputStaticMetaDataModel != null) {
                    str2 = cJRInputStaticMetaDataModel.getEntityName();
                    str = this.w.getStartTime();
                } else {
                    CJRInputMetaDataModel cJRInputMetaDataModel = this.x;
                    if (cJRInputMetaDataModel != null) {
                        str2 = cJRInputMetaDataModel.getEntityName();
                        str = this.x.getStartTime();
                    } else {
                        str = str2;
                    }
                }
                TextView textView = (TextView) inflate.findViewById(R.id.event_order_summary_pending_title);
                TextView textView2 = (TextView) inflate.findViewById(R.id.event_order_summary_pending_date);
                TextView textView3 = (TextView) inflate.findViewById(R.id.event_order_summary_pending_time);
                if (textView != null) {
                    textView.setText(str2);
                }
                if (!TextUtils.isEmpty(str) && (split = str.split(" ")) != null && split.length == 2) {
                    String b2 = d.b(getApplicationContext(), split[0]);
                    String a2 = d.a(getApplicationContext(), split[1]);
                    if (textView2 != null) {
                        textView2.setText(b2);
                    }
                    if (textView3 != null) {
                        textView3.setText(a2);
                    }
                }
            }
            this.o.addView(inflate);
        }
    }

    private void b(ArrayList<CJROrderedCart> arrayList) {
        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.park_order_summary_payment_details_card, (ViewGroup) null);
        if (inflate != null) {
            ((ImageView) inflate.findViewById(R.id.img_convenience_info)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AmParkOrderSummary amParkOrderSummary = AmParkOrderSummary.this;
                    AmParkOrderSummary.a(amParkOrderSummary, (ArrayList) amParkOrderSummary.m.getOtherTaxes());
                }
            });
            a(inflate, arrayList);
            this.o.addView(inflate);
        }
    }

    private void e() {
        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.park_order_summary_payment_footer, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.paytm_contact_us)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AmParkOrderSummary.l(AmParkOrderSummary.this);
            }
        });
        if (inflate != null) {
            this.o.addView(inflate);
        }
    }

    private void a(View view, ArrayList<CJROrderedCart> arrayList) {
        ArrayList<CJROrderSummaryPayment> paymentInfo;
        String str;
        int i2;
        if (arrayList != null && arrayList.size() > 0) {
            CJROrderedCart cJROrderedCart = arrayList.get(0);
            if ((this.x != null || this.w != null) && (paymentInfo = this.m.getPaymentInfo()) != null && paymentInfo.size() > 0) {
                ((TextView) view.findViewById(R.id.event_paytm_order_id)).setText("Paytm order ID: " + this.m.getId());
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.event_payment_type_netbanking_layout);
                linearLayout.setVisibility(8);
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.event_payment_type_paytm_cash_layout);
                linearLayout2.setVisibility(8);
                Iterator<CJROrderSummaryPayment> it2 = paymentInfo.iterator();
                while (it2.hasNext()) {
                    CJROrderSummaryPayment next = it2.next();
                    if (next.getPaymentMethod() != null && next.getPaymentMethod().equalsIgnoreCase("NB")) {
                        ((TextView) view.findViewById(R.id.event_paytm_netbanking_amount)).setText(String.valueOf(next.getPgAmount()));
                        TextView textView = (TextView) view.findViewById(R.id.event_order_summary_netbanking_txn);
                        String bankTransactionId = next.getBankTransactionId();
                        if (TextUtils.isEmpty(bankTransactionId)) {
                            textView.setVisibility(8);
                        } else {
                            textView.setText("Transaction ID #".concat(String.valueOf(bankTransactionId)));
                        }
                        linearLayout.setVisibility(0);
                    }
                    if (next.getPaymentMethod() != null && next.getPaymentMethod().equalsIgnoreCase("Paytm Cash")) {
                        ((TextView) view.findViewById(R.id.event_paytm_cash)).setText(String.valueOf(next.getPgAmount()));
                        String bankTransactionId2 = next.getBankTransactionId();
                        TextView textView2 = (TextView) view.findViewById(R.id.event_paytm_cash_amount);
                        if (TextUtils.isEmpty(bankTransactionId2)) {
                            textView2.setVisibility(8);
                        } else {
                            textView2.setText("Transaction ID #".concat(String.valueOf(bankTransactionId2)));
                        }
                        linearLayout2.setVisibility(0);
                    }
                }
                TextView textView3 = (TextView) view.findViewById(R.id.event_num_of_tickets_title);
                CJRInputStaticMetaDataModel cJRInputStaticMetaDataModel = this.w;
                String str2 = "";
                if (cJRInputStaticMetaDataModel != null) {
                    i2 = cJRInputStaticMetaDataModel.getTicketCount();
                    str2 = this.w.getTotalTicketPrice();
                    this.w.getConvFee();
                    str = this.w.getTotalCommision();
                } else {
                    CJRInputMetaDataModel cJRInputMetaDataModel = this.x;
                    if (cJRInputMetaDataModel != null) {
                        i2 = cJRInputMetaDataModel.getTicketCount();
                        str2 = this.x.getTotalTicketPrice();
                        this.x.getConvFee();
                        str = this.x.getTotalCommision();
                    } else {
                        str = str2;
                        i2 = 1;
                    }
                }
                if (i2 == 1) {
                    textView3.setText(i2 + " Ticket");
                } else {
                    textView3.setText(i2 + " Tickets");
                }
                ((TextView) view.findViewById(R.id.event_num_of_tickets_value)).setText(getString(R.string.rupees) + " " + str2);
                ((TextView) view.findViewById(R.id.event_taxes_and_fees_value)).setText(getString(R.string.rupees) + " " + str);
                ((TextView) view.findViewById(R.id.event_order_total_value)).setText(getString(R.string.rupees) + " " + this.m.getSubTotal());
                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.event_summary_payment_details_promo_layout);
                if (!TextUtils.isEmpty(cJROrderedCart.getPromoCode())) {
                    linearLayout3.setVisibility(0);
                    ((TextView) view.findViewById(R.id.txt_events_applied_promo)).setText(cJROrderedCart.getPromoCode());
                    ((TextView) view.findViewById(R.id.txt_events_applied_promo_desc)).setText(cJROrderedCart.getPromoText());
                    return;
                }
                linearLayout3.setVisibility(8);
            }
        }
    }

    private static String d(String str) {
        try {
            return new JSONObject(str).getString("bookingId");
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Context context) {
        ProgressBar progressBar;
        if (!isFinishing() && !isDestroyed()) {
            if ((context != null || isFinishing()) && (progressBar = this.B) != null) {
                progressBar.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        ProgressBar progressBar;
        if (!isFinishing() && !isDestroyed() && (progressBar = this.B) != null) {
            progressBar.setVisibility(8);
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (!isFinishing()) {
            a();
            if (iJRPaytmDataModel instanceof CJROrderSummary) {
                this.m = (CJROrderSummary) iJRPaytmDataModel;
                try {
                    if (this.m != null) {
                        this.n = this.m.getPaymentStatus();
                        net.one97.paytm.o2o.amusementpark.a.b().sendPaytmAssistGAEvents(net.one97.paytm.o2o.amusementpark.b.a.a.a(this.m), net.one97.paytm.o2o.amusementpark.b.a.a.a(this.f73363h), this);
                        String a2 = new f().a(this.m.getOrderedCartList().get(0).mMetaDataResponse);
                        if (new JSONObject(a2).get("passenger") instanceof JSONObject) {
                            this.w = (CJRInputStaticMetaDataModel) new f().a(a2, CJRInputStaticMetaDataModel.class);
                        } else {
                            this.x = (CJRInputMetaDataModel) new f().a(a2, CJRInputMetaDataModel.class);
                        }
                        if (this.w != null && this.w.getLatitude() != null && this.w.getLongitude() != null) {
                            this.y = Float.valueOf(Float.parseFloat(this.w.getLatitude()));
                            this.z = Float.valueOf(Float.parseFloat(this.w.getLongitude()));
                        } else if (!(this.x == null || this.x.getLatitude() == null || this.x.getLongitude() == null)) {
                            this.y = Float.valueOf(Float.parseFloat(this.x.getLatitude()));
                            this.z = Float.valueOf(Float.parseFloat(this.x.getLongitude()));
                        }
                        c();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a();
    }

    private static JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "AmParkOrderSummary");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void attachBaseContext(Context context) {
        if (net.one97.paytm.o2o.amusementpark.a.a() == null) {
            new net.one97.paytm.o2o.amusementpark.utils.m();
            net.one97.paytm.o2o.amusementpark.utils.m.a();
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(net.one97.paytm.o2o.amusementpark.a.a().getBaseContext(context));
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private LayoutInflater f73379b;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public a(Context context) {
            this.f73379b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public final int getCount() {
            return AmParkOrderSummary.this.r.size();
        }

        public final Object getItem(int i2) {
            return Integer.valueOf(i2);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            if (view == null) {
                bVar = new b();
                view2 = this.f73379b.inflate(R.layout.park_contact_all_reason_single_item, (ViewGroup) null);
                bVar.f73380a = (CheckedTextView) view2.findViewById(R.id.singleItem);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            bVar.f73380a.setText((CharSequence) AmParkOrderSummary.this.r.get(i2));
            return view2;
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        CheckedTextView f73380a;

        b() {
        }
    }

    static /* synthetic */ void i(AmParkOrderSummary amParkOrderSummary) {
        Intent intent = new Intent(amParkOrderSummary, net.one97.paytm.o2o.amusementpark.a.a().getItemLevelOrderClass());
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        amParkOrderSummary.startActivity(intent);
        amParkOrderSummary.finish();
    }

    static /* synthetic */ void a(AmParkOrderSummary amParkOrderSummary, ArrayList arrayList) {
        try {
            AlertDialog create = new AlertDialog.Builder(amParkOrderSummary).create();
            View inflate = amParkOrderSummary.getLayoutInflater().inflate(R.layout.park_tax_breakdown_layout, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.price_break_up_container);
            ((TextView) inflate.findViewById(R.id.container_header)).setText(amParkOrderSummary.getResources().getString(R.string.tax_breakup));
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJROtherTaxes cJROtherTaxes = (CJROtherTaxes) it2.next();
                    String value = cJROtherTaxes.getValue();
                    String label = cJROtherTaxes.getLabel();
                    if (label != null && !TextUtils.isEmpty(label) && !label.equalsIgnoreCase("null") && value != null && !TextUtils.isEmpty(value) && !value.equalsIgnoreCase("null")) {
                        RelativeLayout relativeLayout = (RelativeLayout) amParkOrderSummary.getLayoutInflater().inflate(R.layout.park_cart_price_break_up_field, (ViewGroup) null);
                        ((TextView) relativeLayout.findViewById(R.id.break_up_field_label)).setText(label);
                        ((TextView) relativeLayout.findViewById(R.id.break_up_field)).setText(amParkOrderSummary.getResources().getString(R.string.rs) + " " + value);
                        linearLayout.addView(relativeLayout);
                    }
                }
            }
            create.setView(inflate);
            create.setCancelable(true);
            create.setCanceledOnTouchOutside(true);
            create.show();
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void l(AmParkOrderSummary amParkOrderSummary) {
        if (amParkOrderSummary.m != null) {
            amParkOrderSummary.r = new ArrayList<>();
            amParkOrderSummary.s = new ArrayList<>();
            for (int i2 = 0; i2 < amParkOrderSummary.m.getOrderedCartList().size(); i2++) {
                amParkOrderSummary.r.add(amParkOrderSummary.m.getOrderedCartList().get(i2).getName());
                amParkOrderSummary.s.add(amParkOrderSummary.m.getOrderedCartList().get(i2).getName());
            }
            if (amParkOrderSummary.m.getOrderedCartList().size() >= 2) {
                AlertDialog.Builder builder = new AlertDialog.Builder(amParkOrderSummary);
                TextView textView = new TextView(amParkOrderSummary);
                textView.setText(amParkOrderSummary.getResources().getString(R.string.contact_us_title_query_regarding));
                textView.setPadding(10, 10, 10, 10);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setTextColor(androidx.core.content.b.c(amParkOrderSummary.getApplicationContext(), R.color.color_33b5e5));
                final ListView listView = new ListView(amParkOrderSummary);
                listView.setChoiceMode(1);
                listView.setAdapter(new a(amParkOrderSummary));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        if (AmParkOrderSummary.this.t.isShowing()) {
                            int unused = AmParkOrderSummary.this.v = i2;
                        }
                    }
                });
                builder.setCustomTitle(textView);
                builder.setCancelable(false);
                builder.setInverseBackgroundForced(true);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        Resources resources = AmParkOrderSummary.this.getResources();
                        if (AmParkOrderSummary.a(listView) == 0) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AmParkOrderSummary.this);
                            TextView textView = new TextView(AmParkOrderSummary.this);
                            textView.setText(AmParkOrderSummary.this.getResources().getString(R.string.error));
                            textView.setPadding(10, 10, 10, 10);
                            textView.setGravity(17);
                            textView.setTextSize(20.0f);
                            textView.setTextColor(androidx.core.content.b.c(AmParkOrderSummary.this.getApplicationContext(), R.color.color_33b5e5));
                            builder.setCustomTitle(textView);
                            builder.setMessage(AmParkOrderSummary.this.getResources().getString(R.string.contact_us_select_item_message));
                            builder.setPositiveButton(resources.getString(R.string.ok), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AmParkOrderSummary.this.u.dismiss();
                                    AmParkOrderSummary.this.t.show();
                                }
                            });
                            Dialog unused = AmParkOrderSummary.this.u = builder.create();
                            AmParkOrderSummary.this.u.show();
                            return;
                        }
                        AmParkOrderSummary.this.t.dismiss();
                        CJROrderedCart cJROrderedCart = AmParkOrderSummary.this.m.getOrderedCartList().get(AmParkOrderSummary.this.v);
                        cJROrderedCart.setOrderId(AmParkOrderSummary.this.m.getId());
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
                        a.b a2 = net.one97.paytm.o2o.amusementpark.a.a();
                        AmParkOrderSummary amParkOrderSummary = AmParkOrderSummary.this;
                        a2.getUpdatedCstOrderIssueIntent(amParkOrderSummary, bundle, amParkOrderSummary.E);
                    }
                });
                builder.setView(listView);
                amParkOrderSummary.t = builder.create();
                amParkOrderSummary.v = 0;
                amParkOrderSummary.t.show();
                return;
            }
            CJROrderedCart cJROrderedCart = amParkOrderSummary.m.getOrderedCartList().get(0);
            cJROrderedCart.setOrderId(amParkOrderSummary.m.getId());
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
            net.one97.paytm.o2o.amusementpark.a.a().getUpdatedCstOrderIssueIntent(amParkOrderSummary, bundle, amParkOrderSummary.E);
        }
    }
}
