package net.one97.paytm.o2o.movies.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.VolleyError;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;
import net.one97.paytm.o2o.movies.utils.g;
import net.one97.paytm.o2o.movies.utils.n;

public class l extends b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public RoboTextView f75386a;

    /* renamed from: b  reason: collision with root package name */
    public RoboTextView f75387b;

    /* renamed from: c  reason: collision with root package name */
    public double f75388c = 0.0d;

    /* renamed from: d  reason: collision with root package name */
    public RoboTextView f75389d;

    /* renamed from: e  reason: collision with root package name */
    public View f75390e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f75391f;

    /* renamed from: g  reason: collision with root package name */
    private String f75392g;

    /* renamed from: h  reason: collision with root package name */
    private String f75393h;

    /* renamed from: i  reason: collision with root package name */
    private a f75394i;
    private RecyclerView j;
    private View k;
    private CJROrderSummaryMetadataResponseV2 l;
    private View m;
    private CheckBox n;
    private String o;
    private String p;
    private String q = l.class.getSimpleName();
    private LinearLayout r;
    private TextView s;
    private TextView t;
    private TextView u;

    public interface a {
        void a();

        void a(double d2, ArrayList<CJRFoodBeverageItemV2> arrayList);

        void a(ArrayList<CJRFoodBeverageItemV2> arrayList, boolean z);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = layoutInflater.inflate(R.layout.post_order_review_food_beverages, viewGroup, false);
        this.j = (RecyclerView) this.k.findViewById(R.id.foor_bev_list);
        this.f75386a = (RoboTextView) this.k.findViewById(R.id.pay_btn_rtv);
        this.f75391f = (ImageView) this.k.findViewById(R.id.activiy_back_btn);
        this.f75387b = (RoboTextView) this.k.findViewById(R.id.title);
        this.f75389d = (RoboTextView) this.k.findViewById(R.id.promocodes_bank_offers);
        this.f75390e = this.k.findViewById(R.id.lyt_promo_applied);
        this.r = (LinearLayout) this.k.findViewById(R.id.food_list_llt);
        this.s = (TextView) this.k.findViewById(R.id.total_footer_price_tv);
        this.t = (TextView) this.k.findViewById(R.id.footer_total_price_rtv);
        this.u = (TextView) this.k.findViewById(R.id.footer_total_item_count_rtv);
        ((ImageView) this.k.findViewById(R.id.img_remove_promo)).setOnClickListener(this);
        this.f75387b = (RoboTextView) this.k.findViewById(R.id.title);
        this.m = this.k.findViewById(R.id.shadow_sep);
        this.f75386a.setOnClickListener(this);
        this.f75389d.setOnClickListener(this);
        this.f75391f.setOnClickListener(this);
        this.f75391f.setOnClickListener(this);
        this.f75386a.setOnClickListener(this);
        this.l = (CJROrderSummaryMetadataResponseV2) getArguments().getSerializable("postOrderFood");
        this.f75392g = getArguments().getString("productid");
        this.o = getArguments().getString(Utility.EVENT_CATEGORY_PROMOCODE);
        this.p = getArguments().getString("promotext");
        this.f75387b.setText(getActivity().getResources().getString(R.string.review_order));
        this.n = (CheckBox) this.k.findViewById(R.id.check_box_fast_forward);
        this.n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            }
        });
        try {
            String string = getString(R.string.fast_forward);
            String string2 = getString(R.string.we_use_paytm_balance_for_this_order);
            String str = "  " + string + StringUtility.NEW_LINE + string2;
            SpannableString spannableString = new SpannableString(str);
            Drawable c2 = n.c(getActivity(), R.drawable.movie_fast_forward);
            c2.setBounds(0, 0, c2.getIntrinsicWidth(), c2.getIntrinsicHeight());
            spannableString.setSpan(new ImageSpan(c2, 1), 0, 1, 17);
            int indexOf = str.indexOf(string);
            if (b.d() >= 14) {
                spannableString.setSpan(new TypefaceSpan("sans-serif-medium"), indexOf, string.length() + indexOf, 33);
            } else {
                spannableString.setSpan(new StyleSpan(1), indexOf, string.length() + indexOf, 0);
            }
            int indexOf2 = str.indexOf(string2);
            spannableString.setSpan(new RelativeSizeSpan(0.8f), indexOf2, string2.length() + indexOf2, 0);
            spannableString.setSpan(new ForegroundColorSpan(n.b((Context) getActivity(), R.color.movie_seat_ff_sub_text_color)), indexOf2, string2.length() + indexOf2, 0);
            this.n.setText(spannableString);
            this.n.setMovementMethod(LinkMovementMethod.getInstance());
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        this.n.setChecked(false);
        c();
        if (!TextUtils.isEmpty(this.o)) {
            String str2 = this.o;
            String str3 = this.p;
            this.f75389d.setVisibility(8);
            this.f75390e.setVisibility(0);
            TextView textView = (TextView) this.f75390e.findViewById(R.id.txt_applied_promo_info);
            if (!TextUtils.isEmpty(str2)) {
                textView.setText(str2);
            } else {
                textView.setText("");
            }
            TextView textView2 = (TextView) this.f75390e.findViewById(R.id.txt_cash_back_info);
            if (!TextUtils.isEmpty(str3)) {
                textView2.setText(str3);
            } else {
                textView2.setText("");
            }
        }
        return this.k;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof a) {
            this.f75394i = (a) activity;
        }
    }

    public void onClick(View view) {
        ArrayList<CJRFoodBeverageItemV2> a2;
        int id = view.getId();
        if (id == R.id.pay_btn_rtv) {
            try {
                this.f75386a.setEnabled(false);
                this.f75386a.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        l.this.f75386a.setEnabled(true);
                        l.this.f75386a.setClickable(true);
                    }
                }, 2000);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
            if (b.r((Context) getActivity())) {
                b();
                return;
            }
            this.f75393h = "task_type_proceed_to_pay";
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.signOut(getActivity(), false, (VolleyError) null);
            startActivityForResult(new Intent(getActivity(), net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("authActivity")), 1);
        } else if (id == R.id.img_remove_promo) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(getResources().getString(R.string.remove_code_title));
            builder.setMessage(getResources().getString(R.string.remove_code_msg));
            builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    l.this.a();
                }
            });
            builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            builder.show();
        } else if (id == R.id.activiy_back_btn) {
            getActivity().onBackPressed();
        } else if (id == R.id.promocodes_bank_offers && (a2 = g.a().a(true)) != null) {
            this.f75394i.a(this.f75388c, a2);
        }
    }

    private void b() {
        ArrayList<CJRFoodBeverageItemV2> a2 = g.a().a(true);
        a aVar = this.f75394i;
        if (aVar != null && a2 != null) {
            aVar.a(a2, this.n.isChecked());
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            getActivity();
            if (i3 == -1 && b.r((Context) getActivity()) && (str = this.f75393h) != null && str.equalsIgnoreCase("task_type_proceed_to_pay")) {
                b();
            }
        }
    }

    private void c() {
        ArrayList<CJRFoodBeverageItemV2> a2 = g.a().a(true);
        this.r.removeAllViews();
        if (a2 != null && a2.size() > 0) {
            TextView textView = this.u;
            textView.setText(a2.size() + " " + getString(R.string.item));
            double d2 = 0.0d;
            Iterator<CJRFoodBeverageItemV2> it2 = a2.iterator();
            while (it2.hasNext()) {
                CJRFoodBeverageItemV2 next = it2.next();
                int i2 = next.getmFoodQauntitySelected();
                double parseDouble = Double.parseDouble(next.getmPrice());
                double d3 = ((double) i2) * parseDouble;
                d2 += d3;
                View inflate = getLayoutInflater().inflate(R.layout.order_fnb_item, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.txt_label)).setText(i2 + "x " + next.getmItemName() + " @ " + getString(R.string.rupee_symbol) + " " + b.a(parseDouble) + " " + getString(R.string.per_item));
                StringBuilder sb = new StringBuilder();
                sb.append(getString(R.string.rupee_symbol));
                sb.append(" ");
                sb.append(b.a(d3));
                ((TextView) inflate.findViewById(R.id.txt_value)).setText(sb.toString());
                this.r.addView(inflate);
                TextView textView2 = this.s;
                textView2.setText(getString(R.string.rupee_symbol) + " " + b.a(d2));
                TextView textView3 = this.t;
                textView3.setText(getString(R.string.rupee_symbol) + " " + b.a(d2));
            }
        }
    }

    public final void a() {
        a aVar = this.f75394i;
        if (aVar != null) {
            aVar.a();
        }
        this.f75390e.setVisibility(8);
        this.f75389d.setVisibility(0);
        if (this.f75388c > 0.0d) {
            RoboTextView roboTextView = this.f75386a;
            roboTextView.setText(getString(R.string.proceed_to_pay) + " " + getString(R.string.rupee_symbol) + " " + String.valueOf(this.f75388c));
        }
    }
}
