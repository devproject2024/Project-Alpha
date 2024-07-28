package net.one97.paytm.recharge.coupons.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.x;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.common.widgets.SmartViewPager;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

@Deprecated
public class DealDetail extends CJRRechargeBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    protected CJRDetailProduct f62258a;

    /* renamed from: b  reason: collision with root package name */
    private Resources f62259b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f62260c;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        ArrayList arrayList;
        int i2;
        String imageUrl;
        super.onCreate(bundle);
        this.f62259b = getResources();
        b.j();
        setContentView(R.layout.layout_pop_up_pdt_detail);
        this.f62258a = (CJRDetailProduct) getIntent().getSerializableExtra("product_detail");
        this.f62260c = (ArrayList) getIntent().getSerializableExtra("coupon_id");
        this.s = true;
        setTitle(this.f62258a.getBrand());
        final CJRDetailProduct cJRDetailProduct = this.f62258a;
        d dVar = d.f64967a;
        d.a(ACTION_TYPE.DEAL_CLICK, ERROR_TYPE.UNDEFINED);
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.text_price);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lyt_price);
        findViewById(R.id.lyt_pop_up_root);
        if (cJRDetailProduct == null || (imageUrl = cJRDetailProduct.getImageUrl()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(imageUrl.trim());
            ArrayList<String> arrayList2 = cJRDetailProduct.getmOtherMedia();
            if (arrayList2 != null) {
                Iterator<String> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (next != null) {
                        arrayList.add(next.trim());
                    }
                }
            }
        }
        SmartViewPager smartViewPager = (SmartViewPager) findViewById(R.id.pager);
        smartViewPager.setAdapter(new net.one97.paytm.recharge.coupons.a.b(this, arrayList));
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) findViewById(R.id.page_indicator);
        circlePageIndicator.setViewPager(smartViewPager);
        if (arrayList == null || arrayList.size() <= 1) {
            circlePageIndicator.setVisibility(8);
        } else {
            circlePageIndicator.setVisibility(0);
        }
        a(cJRDetailProduct);
        ArrayList<String> arrayList3 = this.f62260c;
        if (arrayList3 == null || !arrayList3.contains(cJRDetailProduct.getmProductID())) {
            try {
                i2 = Integer.parseInt(cJRDetailProduct.getmDiscountedPrice());
            } catch (Exception e2) {
                q.d(e2.getMessage());
                i2 = 0;
            }
            if (i2 == 0) {
                roboTextView.setText(getString(R.string.get_for_free_txt));
            } else {
                roboTextView.setText(String.valueOf(getString(R.string.copoun_pick_for_rs_txt, new Object[]{b.x(String.valueOf(i2))})));
            }
        } else {
            roboTextView.setText(this.f62259b.getString(R.string.okay_got_it));
            roboTextView.setCompoundDrawablePadding(15);
            roboTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (DealDetail.this.f62260c == null || !DealDetail.this.f62260c.contains(cJRDetailProduct.getmProductID())) {
                    net.one97.paytm.recharge.widgets.c.b.a(new a() {
                        public final Object invoke() {
                            return DealDetail.this.b();
                        }
                    });
                    Intent intent = new Intent();
                    intent.putExtra("selected_position", DealDetail.this.getIntent().getIntExtra("selected_position", -1));
                    DealDetail.this.setResult(-1, intent);
                } else {
                    DealDetail.this.setResult(0);
                }
                DealDetail.this.finish();
            }
        });
        net.one97.paytm.recharge.widgets.c.b.a(new a(cJRDetailProduct) {
            private final /* synthetic */ CJRDetailProduct f$1;

            {
                this.f$1 = r2;
            }

            public final Object invoke() {
                return DealDetail.this.b(this.f$1);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x b(CJRDetailProduct cJRDetailProduct) {
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(cJRDetailProduct, this);
        return null;
    }

    private void a(CJRDetailProduct cJRDetailProduct) {
        int applyDimension = (int) TypedValue.applyDimension(1, 35.0f, getResources().getDisplayMetrics());
        if (cJRDetailProduct.getmLongRichDesc() != null && cJRDetailProduct.getmLongRichDesc().size() > 0) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.product_detail_desc_lyt);
            linearLayout.removeAllViews();
            int i2 = 0;
            for (int i3 = 0; i3 < cJRDetailProduct.getmLongRichDesc().size(); i3++) {
                ViewGroup viewGroup = null;
                View inflate = getLayoutInflater().inflate(R.layout.lyt_product_desc_detail, (ViewGroup) null);
                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.product_detail_attributes_layout);
                int i4 = applyDimension / 2;
                linearLayout2.setPadding(i4, i2, i4, i2);
                Map<String, String> map = cJRDetailProduct.getmLongRichDesc().get(i3).getmAttributes();
                for (String next : map.keySet()) {
                    String str = map.get(next).toString();
                    "key ".concat(String.valueOf(next));
                    b.j();
                    "value ".concat(String.valueOf(str));
                    b.j();
                    View inflate2 = getLayoutInflater().inflate(R.layout.lyt_pdt_desc, viewGroup);
                    TextView textView = (TextView) inflate2.findViewById(R.id.header);
                    TextView textView2 = (TextView) inflate2.findViewById(R.id.value_for_map);
                    View findViewById = inflate2.findViewById(R.id.seperatorr);
                    Map<String, String> map2 = map;
                    if (cJRDetailProduct.getmLongRichDesc().get(i3).getmDescription() == null || cJRDetailProduct.getmLongRichDesc().get(i3).getmDescription().isEmpty() || cJRDetailProduct.getmLongRichDesc().get(i3).getmDescription().equals("")) {
                        findViewById.setVisibility(8);
                    }
                    textView2.setId(net.one97.paytm.recharge.coupons.d.a.a().f62279a.decrementAndGet());
                    textView.setText(next);
                    textView2.setText(Html.fromHtml(str.trim()));
                    textView.setTextSize(13.0f);
                    textView2.setTextSize(12.0f);
                    if (b.d() >= 11) {
                        textView2.setTextIsSelectable(true);
                    } else {
                        textView2.setFocusable(true);
                        textView2.setFocusableInTouchMode(true);
                        textView2.setClickable(true);
                        textView2.setLongClickable(true);
                    }
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    b.c(textView);
                    b.b(textView2);
                    linearLayout2.addView(inflate2);
                    map = map2;
                    viewGroup = null;
                }
                if (i3 == 0) {
                    inflate.findViewById(R.id.top_separator).setVisibility(8);
                }
                TextView textView3 = (TextView) inflate.findViewById(R.id.product_detail_title);
                textView3.setPadding(i4, i4, i4, 0);
                textView3.setText(cJRDetailProduct.getmLongRichDesc().get(i3).getmTitle());
                new StringBuilder("Title ==").append(cJRDetailProduct.getmLongRichDesc().get(i3).getmTitle());
                b.j();
                new StringBuilder("DEsc ==").append(cJRDetailProduct.getmLongRichDesc().get(i3).getmDescription());
                b.j();
                TextView textView4 = (TextView) inflate.findViewById(R.id.detail_desc);
                if (cJRDetailProduct.getmLongRichDesc().get(i3).getmDescription() == null || cJRDetailProduct.getmLongRichDesc().get(i3).getmDescription().trim().equalsIgnoreCase("")) {
                    i2 = 0;
                } else {
                    i2 = 0;
                    textView4.setPadding(i4, i4, i4, 0);
                    textView4.setText(Html.fromHtml(cJRDetailProduct.getmLongRichDesc().get(i3).getmDescription()));
                    textView4.setMovementMethod(LinkMovementMethod.getInstance());
                }
                if (i3 == 0 && getCallingActivity() != null && getCallingActivity().getClassName().contains(AJRCouponsActivityV8.class.getSimpleName())) {
                    int i5 = applyDimension / 4;
                    textView4.setPadding(i4, i5, i4, i5);
                    textView4.setText(this.f62258a.getName());
                }
                linearLayout.addView(inflate);
            }
            linearLayout.invalidate();
        }
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x b() {
        HashMap hashMap = new HashMap();
        if (getIntent().hasExtra("event_category")) {
            hashMap.put("event_category", getIntent().getStringExtra("event_category"));
        } else {
            hashMap.put("event_category", "recharge");
        }
        hashMap.put("event_action", "coupon_selected");
        hashMap.put("event_label", "pdp");
        if (!TextUtils.isEmpty(b.n((Context) this))) {
            hashMap.put("user_id", b.n((Context) this));
        }
        if (getIntent().hasExtra("vertical_name")) {
            hashMap.put("vertical_name", getIntent().getStringExtra("vertical_name"));
        } else {
            hashMap.put("vertical_name", "recharges_utilities");
        }
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, (Context) this);
        return null;
    }
}
