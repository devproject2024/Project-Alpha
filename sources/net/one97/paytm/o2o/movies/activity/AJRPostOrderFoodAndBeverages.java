package net.one97.paytm.o2o.movies.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.orflow.promo.model.Request;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.b.d;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;
import net.one97.paytm.o2o.movies.d.g;
import net.one97.paytm.o2o.movies.fragment.k;
import net.one97.paytm.o2o.movies.fragment.l;
import net.one97.paytm.o2o.movies.moviepass.a;
import net.one97.paytm.o2o.movies.utils.n;

public class AJRPostOrderFoodAndBeverages extends AppBaseActivity implements g, l.a {

    /* renamed from: a  reason: collision with root package name */
    private FrameLayout f74081a;

    /* renamed from: b  reason: collision with root package name */
    private l f74082b;

    /* renamed from: c  reason: collision with root package name */
    private final String f74083c = AJRPostOrderFoodAndBeverages.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private d f74084d;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.post_order_food_activity);
        this.f74081a = (FrameLayout) findViewById(R.id.post_order_food_container);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            String str = null;
            CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2 = extras.containsKey("postOrderFood") ? (CJROrderSummaryMetadataResponseV2) extras.getSerializable("postOrderFood") : null;
            if (extras.containsKey("parentOrderId")) {
                str = extras.getString("parentOrderId");
            }
            this.f74084d = new d(this, this, cJROrderSummaryMetadataResponseV2, str);
            this.f74082b = new l();
            this.f74082b.setArguments(extras);
            getSupportFragmentManager().a().a(R.id.post_order_food_container, this.f74082b, l.class.getSimpleName()).b();
        }
    }

    public final void a(ArrayList<CJRFoodBeverageItemV2> arrayList, boolean z) {
        d dVar = this.f74084d;
        if (dVar != null) {
            dVar.f74907d = true;
            dVar.f74908e = z;
            dVar.a(arrayList);
            if (dVar.a() == null || dVar.k || (dVar.f74911h == null && !dVar.k)) {
                dVar.b();
            } else {
                dVar.c();
            }
        }
    }

    public final void a() {
        d dVar = this.f74084d;
        if (dVar != null) {
            dVar.f74911h = null;
            dVar.j = null;
            dVar.f74912i = null;
            dVar.f74904a = null;
        }
    }

    public final void a(double d2, ArrayList<CJRFoodBeverageItemV2> arrayList) {
        c.a();
        String replace = c.a("postOrderPromoSearchUrl", (String) null).replace("v1", "v2");
        c.a();
        String a2 = c.a("postOrderPromoSearchUrlExtension", (String) null);
        c.a();
        String a3 = c.a("postFoodOrderProductId", (String) null);
        String a4 = n.a("price", Double.toString(d2), replace + a3 + a2);
        if (URLUtil.isValidUrl(a4)) {
            Request request = new Request(0, com.paytm.utility.c.b(a4, (Context) this), b.a((HashMap<String, String>) new HashMap(), (Context) this), (Map<String, String>) null, (String) null);
            this.f74084d.a(arrayList);
            net.one97.paytm.o2o.movies.moviepass.d a5 = net.one97.paytm.o2o.movies.moviepass.d.a();
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getSSOToken(this);
            a5.a(this, d2, request, this.f74084d);
        }
    }

    public final void a(String str, String str2, String str3) {
        l lVar = (l) getSupportFragmentManager().c(l.class.getSimpleName());
        if (lVar != null) {
            lVar.f75389d.setVisibility(8);
            lVar.f75390e.setVisibility(0);
            TextView textView = (TextView) lVar.f75390e.findViewById(R.id.txt_applied_promo_info);
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            } else {
                textView.setText("");
            }
            TextView textView2 = (TextView) lVar.f75390e.findViewById(R.id.txt_cash_back_info);
            if (!TextUtils.isEmpty(str2)) {
                textView2.setText(str2);
            } else {
                textView2.setText("");
            }
            try {
                if (lVar.f75388c > 0.0d) {
                    if (str3 != null) {
                        RoboTextView roboTextView = lVar.f75386a;
                        roboTextView.setText(lVar.getString(R.string.proceed_to_pay) + " " + lVar.getString(R.string.rupee_symbol) + " " + String.valueOf(lVar.f75388c - Double.parseDouble(str3)));
                    } else {
                        RoboTextView roboTextView2 = lVar.f75386a;
                        roboTextView2.setText(lVar.getString(R.string.proceed_to_pay) + " " + lVar.getString(R.string.rupee_symbol) + " " + String.valueOf(lVar.f75388c));
                    }
                }
            } catch (Exception unused) {
            }
            if (lVar.f75387b.getText().toString().equalsIgnoreCase(lVar.getActivity().getResources().getString(R.string.apply_promo_code))) {
                lVar.getActivity().onBackPressed();
            }
        }
    }

    public final void a(CJRMovieCart cJRMovieCart, boolean z, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener, ProgressDialog progressDialog) {
        net.one97.paytm.o2o.movies.moviepass.d.a().a((a) this.f74084d);
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.fetchPaymentOptions(this, progressDialog, cJRMovieCart, otherPayOptionsListener, z, (net.one97.paytm.o2o.movies.b.g) null);
    }

    public final void b() {
        l lVar = (l) getSupportFragmentManager().c(l.class.getSimpleName());
        if (lVar != null) {
            lVar.a();
        }
    }

    public final void a(String str) {
        Fragment c2 = getSupportFragmentManager().c(R.id.post_order_food_container);
        if (c2 instanceof k) {
            k kVar = (k) c2;
            kVar.f75381e.setText(str);
            kVar.f75381e.setVisibility(0);
            kVar.f75381e.setTextColor(kVar.getResources().getColor(R.color.trains_promo_error));
            kVar.f75378b.setVisibility(8);
            kVar.f75377a.setVisibility(0);
            if (kVar.f75380d != null && kVar.f75380d.size() > 0) {
                Iterator<CJROfferCode> it2 = kVar.f75380d.iterator();
                while (it2.hasNext()) {
                    it2.next().setIsOfferApplied(false);
                    if (kVar.f75379c != null) {
                        kVar.f75379c.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public void onDestroy() {
        d dVar = this.f74084d;
        dVar.f74905b = null;
        dVar.f74906c = null;
        this.f74084d = null;
        net.one97.paytm.o2o.movies.moviepass.d.a();
        net.one97.paytm.o2o.movies.moviepass.d.b();
        super.onDestroy();
    }
}
