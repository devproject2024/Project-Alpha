package net.one97.paytm.fastag.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.c;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.fastag.BaseActivity;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.d.g;
import net.one97.paytm.fastag.dependencies.a;
import net.one97.paytm.fastag.dependencies.f;
import net.one97.paytm.fastag.dependencies.i;
import net.one97.paytm.fastag.dependencies.l;
import net.one97.paytm.fastag.f.h;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.fastag.model.CJRTrackingParams;
import net.one97.paytm.fastag.ui.c.d;
import net.one97.paytm.fastag.ui.c.e;

public class FasTagPostPaymentActivity extends AppCompatActivity implements g.a<IJRPaytmDataModel>, l {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13815b = FasTagPostPaymentActivity.class.getName();

    /* renamed from: a  reason: collision with root package name */
    boolean f13816a;

    /* renamed from: c  reason: collision with root package name */
    private i f13817c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13818d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13819e = true;

    /* renamed from: f  reason: collision with root package name */
    private Intent f13820f = null;

    /* renamed from: g  reason: collision with root package name */
    private NestedScrollView f13821g;

    /* renamed from: h  reason: collision with root package name */
    private String f13822h;

    /* renamed from: i  reason: collision with root package name */
    private String f13823i;
    private boolean j = false;
    private boolean k = false;
    private LinearLayout l;
    private View m;
    /* access modifiers changed from: private */
    public LinearLayout n;
    private LinearLayout o;
    private RecyclerView p;
    private TextView q;
    private AlertDialog r;

    public /* bridge */ /* synthetic */ void onResponse(Object obj) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fastag_postpayment);
        findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FasTagPostPaymentActivity.this.onBackPressed();
            }
        });
        findViewById(R.id.tv_fastag_share).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FasTagPostPaymentActivity fasTagPostPaymentActivity = FasTagPostPaymentActivity.this;
                if (!s.a() || s.c((Activity) fasTagPostPaymentActivity)) {
                    fasTagPostPaymentActivity.b();
                } else {
                    s.b((Activity) fasTagPostPaymentActivity);
                }
                fasTagPostPaymentActivity.a("share_clicked", "");
            }
        });
        this.f13817c = new a(this, this);
        this.f13820f = getIntent();
        this.f13821g = (NestedScrollView) findViewById(R.id.item_detail_scrollview);
        this.f13821g.setNestedScrollingEnabled(false);
        this.l = (LinearLayout) findViewById(R.id.seal_of_trust_layout);
        this.m = findViewById(R.id.footer_strip);
        this.n = (LinearLayout) findViewById(R.id.ll_success_layout);
        this.o = (LinearLayout) findViewById(R.id.main_container_layout);
        this.p = (RecyclerView) findViewById(R.id.recycler_view);
        this.q = (TextView) findViewById(R.id.payment_detail_view);
    }

    public void onResume() {
        super.onResume();
        if (this.f13819e) {
            c();
        }
    }

    private void c() {
        this.k = this.f13820f.getBooleanExtra("order_from_fastag", false);
        String stringExtra = this.f13820f.getStringExtra("KEY_ORDER_ID_TO_TRACK");
        this.f13822h = this.f13820f.getStringExtra("KEY_ITEM_ID_TO_TRACK");
        this.f13816a = this.f13820f.getBooleanExtra("is_from_contact_us", false);
        this.f13823i = this.f13820f.getStringExtra("DeeplinkUrl");
        if (!TextUtils.isEmpty(this.f13823i)) {
            this.j = true;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            b(stringExtra, this.f13823i);
        }
        if (this.j) {
            this.f13822h = a(this.f13823i);
            b("", this.f13823i);
        }
    }

    private void b(String str, String str2) {
        String str3;
        BaseActivity.a(this, getString(R.string.please_wait));
        if (!this.j) {
            str2 = net.one97.paytm.fastag.c.a.a().f13559b.getStringFromGTM("itemdetailv2new");
        }
        if (!TextUtils.isEmpty(str2)) {
            if (!this.j) {
                String replace = str2.replace("<orderid>", str);
                str3 = c.b(replace, (Context) this) + "&single_card=true&item_tracking=1";
            } else {
                str3 = c.b(str2, (Context) this);
            }
            HashMap<String, String> a2 = b.a((HashMap<String, String>) new HashMap(), (Context) this);
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.UNKNOWN;
            bVar.f42879c = a.C0715a.GET;
            bVar.n = a.b.SILENT;
            bVar.o = FasTagPostPaymentActivity.class.getSimpleName();
            bVar.f42885i = new CJROrderSummary();
            bVar.f42882f = a2;
            bVar.f42880d = str3;
            bVar.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    FasTagPostPaymentActivity.a(FasTagPostPaymentActivity.this, iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    String str;
                    String str2;
                    BaseActivity.X_();
                    FasTagPostPaymentActivity fasTagPostPaymentActivity = FasTagPostPaymentActivity.this;
                    if (!fasTagPostPaymentActivity.isFinishing() && networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage())) {
                        if (networkCustomError.getMessage().equalsIgnoreCase("404") || networkCustomError.getMessage().equalsIgnoreCase("400") || networkCustomError.getMessage().equalsIgnoreCase("503")) {
                            String message = networkCustomError.getMessage();
                            if (message.equalsIgnoreCase("404")) {
                                str2 = fasTagPostPaymentActivity.getString(R.string.not_available);
                                str = fasTagPostPaymentActivity.getString(R.string.come_back_in_a_while);
                            } else if (message.equalsIgnoreCase("400")) {
                                str = fasTagPostPaymentActivity.getResources().getString(R.string.message_400);
                                str2 = fasTagPostPaymentActivity.getResources().getString(R.string.title_400);
                            } else {
                                str2 = fasTagPostPaymentActivity.getString(R.string.we_are_fixing_something);
                                str = fasTagPostPaymentActivity.getString(R.string.be_right_back);
                            }
                            h.a((Context) fasTagPostPaymentActivity, str2, str);
                        }
                    }
                }
            };
            com.paytm.network.a l2 = bVar.l();
            if (b.c((Context) this)) {
                l2.a();
            } else {
                a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        com.paytm.network.a.this.a();
                    }
                });
            }
        }
    }

    private static String a(String str) {
        return !TextUtils.isEmpty(str) ? Uri.parse(str).getQueryParameter("item_ID") : "";
    }

    public final void a() {
        c();
    }

    private CJROrderedCart a(ArrayList<CJROrderedCart> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String valueOf = String.valueOf(arrayList.get(i2).getId());
            String str = this.f13822h;
            if (str != null && str.equalsIgnoreCase(valueOf)) {
                return arrayList.get(i2);
            }
            if (this.k) {
                arrayList.get(i2);
            }
        }
        return null;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 56) {
            return;
        }
        if (s.a(iArr)) {
            b();
            Intent intent = new Intent("write_permission");
            intent.putExtra("write_permission_granted", true);
            androidx.localbroadcastmanager.a.a.a((Context) this).a(intent);
            return;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.write_to_sdcard_permission_alert_msg));
            builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    s.b((Context) FasTagPostPaymentActivity.this);
                }
            });
            builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
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

    /* access modifiers changed from: package-private */
    public final void b() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("image/jpeg");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            intent.putExtra("android.intent.extra.TEXT", "Paytm Fastag");
            Bitmap createBitmap = Bitmap.createBitmap(this.o.getWidth(), this.o.getHeight(), Bitmap.Config.ARGB_8888);
            this.o.draw(new Canvas(createBitmap));
            intent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.title), (String) null)));
            Intent createChooser = Intent.createChooser(intent, getString(R.string.post_payment_share_title));
            if (createChooser.resolveActivity(getPackageManager()) != null) {
                startActivity(createChooser);
            } else {
                Toast.makeText(this, getString(R.string.no_app_found), 1).show();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f13820f = intent;
        this.f13819e = true;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "fastag");
            hashMap.put("event_action", str);
            if (TextUtils.isEmpty(str2)) {
                hashMap.put("event_label", str2);
            }
            net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, this);
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    private void a(DialogInterface.OnClickListener onClickListener) {
        AlertDialog alertDialog = this.r;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.r.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), onClickListener);
        this.r = builder.create();
        this.r.show();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    static /* synthetic */ void a(FasTagPostPaymentActivity fasTagPostPaymentActivity, IJRPaytmDataModel iJRPaytmDataModel) {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderedCart a2;
        f.a aVar;
        ArrayList<CJROrderedCart> orderedCartList2;
        CJROrderedCart cJROrderedCart;
        BaseActivity.X_();
        CJROrderSummary cJROrderSummary = (CJROrderSummary) iJRPaytmDataModel;
        fasTagPostPaymentActivity.f13817c.a(cJROrderSummary);
        fasTagPostPaymentActivity.m.setVisibility(0);
        androidx.fragment.app.q a3 = fasTagPostPaymentActivity.getSupportFragmentManager().a();
        if (cJROrderSummary != null) {
            fasTagPostPaymentActivity.a("summary_page_loaded_payment_" + cJROrderSummary.getOrderStatus(), "ff_" + cJROrderSummary.getStatus());
            fasTagPostPaymentActivity.a("order_" + cJROrderSummary.getOrderStatus(), "ff_" + cJROrderSummary.getStatus());
        }
        if (cJROrderSummary != null && cJROrderSummary.getOrderStatus() == 2) {
            net.one97.paytm.fastag.ui.c.f a4 = net.one97.paytm.fastag.ui.c.f.a(cJROrderSummary, fasTagPostPaymentActivity.f13816a, fasTagPostPaymentActivity.f13822h);
            a3.b(R.id.postpayment_screen_container, a4, a4.getClass().getName()).c();
            fasTagPostPaymentActivity.l.setVisibility(0);
            fasTagPostPaymentActivity.f13821g.setOnScrollChangeListener(new NestedScrollView.b() {
                public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                    FasTagPostPaymentActivity.this.n.getY();
                    if (!(i3 <= i5)) {
                        FasTagPostPaymentActivity.this.n.setVisibility(0);
                    } else {
                        FasTagPostPaymentActivity.this.n.setVisibility(8);
                    }
                }
            });
            fasTagPostPaymentActivity.p.setVisibility(0);
            fasTagPostPaymentActivity.q.setVisibility(0);
            net.one97.paytm.fastag.ui.a.a aVar2 = new net.one97.paytm.fastag.ui.a.a(cJROrderSummary);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fasTagPostPaymentActivity.getApplicationContext());
            fasTagPostPaymentActivity.p.setLayoutManager(linearLayoutManager);
            fasTagPostPaymentActivity.p.setItemAnimator(new androidx.recyclerview.widget.g());
            fasTagPostPaymentActivity.p.setAdapter(aVar2);
            fasTagPostPaymentActivity.p.addItemDecoration(new androidx.recyclerview.widget.i(fasTagPostPaymentActivity.p.getContext(), linearLayoutManager.getOrientation()));
        } else if (cJROrderSummary != null && cJROrderSummary.getOrderStatus() == 4) {
            net.one97.paytm.fastag.ui.c.c a5 = net.one97.paytm.fastag.ui.c.c.a(cJROrderSummary, fasTagPostPaymentActivity.f13816a, fasTagPostPaymentActivity.f13822h);
            a3.b(R.id.postpayment_screen_container, a5, a5.getClass().getName()).c();
            fasTagPostPaymentActivity.l.setVisibility(8);
        } else if (cJROrderSummary != null && (cJROrderSummary.getOrderStatus() == 1 || cJROrderSummary.getOrderStatus() == 3)) {
            e a6 = e.a(cJROrderSummary, fasTagPostPaymentActivity.f13816a, fasTagPostPaymentActivity.f13822h);
            a3.b(R.id.postpayment_screen_container, a6, a6.getClass().getName()).c();
            fasTagPostPaymentActivity.l.setVisibility(8);
        }
        androidx.fragment.app.q a7 = fasTagPostPaymentActivity.getSupportFragmentManager().a();
        d a8 = d.a(cJROrderSummary, fasTagPostPaymentActivity.f13816a, fasTagPostPaymentActivity.f13822h);
        a7.b(R.id.help_item_layout_container, a8, a8.getClass().getName()).c();
        net.one97.paytm.fastag.ui.c.b bVar = null;
        if (!(cJROrderSummary == null || (orderedCartList = cJROrderSummary.getOrderedCartList()) == null || orderedCartList.size() <= 0 || (a2 = fasTagPostPaymentActivity.a(orderedCartList)) == null)) {
            if (cJROrderSummary == null || (orderedCartList2 = cJROrderSummary.getOrderedCartList()) == null || orderedCartList2.size() <= 0 || (cJROrderedCart = orderedCartList2.get(0)) == null || !cJROrderedCart.isReturnFlow()) {
                aVar = null;
            } else {
                f.a aVar3 = f.a.SERVICIABLELessThan60NSSLessThan400NLMD;
                CJRTrackingParams trackingParams = cJROrderedCart.getTrackingParams();
                boolean isLmd_merchant = trackingParams.isLmd_merchant();
                boolean isServiceable = trackingParams.isServiceable();
                double benchmarkPrice = trackingParams.getBenchmarkPrice();
                double totalPrice = cJROrderedCart.getTotalPrice();
                if (isLmd_merchant) {
                    if (isServiceable) {
                        if (totalPrice > benchmarkPrice) {
                            aVar = f.a.SERVICIABLEGreater60;
                        }
                    } else if (totalPrice > benchmarkPrice) {
                        aVar = f.a.NSSGreaterThan400;
                    }
                }
                aVar = aVar3;
            }
            if (aVar == null) {
                String itemStatus = a2.getItemStatus();
                if (!TextUtils.isEmpty(itemStatus)) {
                    int parseInt = Integer.parseInt(itemStatus);
                    bVar = (parseInt == 6 || parseInt == 8 || parseInt == 118 || parseInt == 119) ? net.one97.paytm.fastag.dependencies.e.a(cJROrderSummary, fasTagPostPaymentActivity.f13816a, fasTagPostPaymentActivity.f13822h) : net.one97.paytm.fastag.ui.c.b.a(cJROrderSummary, fasTagPostPaymentActivity.f13816a, fasTagPostPaymentActivity.f13822h);
                }
            } else {
                f a9 = f.a(cJROrderSummary, fasTagPostPaymentActivity.f13816a, fasTagPostPaymentActivity.f13822h);
                a9.f13682b = aVar;
                bVar = a9;
            }
        }
        androidx.fragment.app.q a10 = fasTagPostPaymentActivity.getSupportFragmentManager().a();
        try {
            if (fasTagPostPaymentActivity.f13818d) {
                a10.b(R.id.tracking_info_container, bVar, bVar.getClass().getName()).c();
            } else {
                fasTagPostPaymentActivity.f13818d = true;
                a10.a(R.id.tracking_info_container, bVar, bVar.getClass().getName()).c();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        HashMap hashMap = new HashMap();
        if (cJROrderSummary != null) {
            hashMap.put("item_details_item_state", cJROrderSummary.getStatus());
            net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventWithMap("item_details_screen_loaded", hashMap, fasTagPostPaymentActivity);
        }
    }
}
