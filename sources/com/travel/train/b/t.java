package com.travel.train.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.j;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytm.network.a;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.e;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.travel.train.R;
import com.travel.train.b.ap;
import com.travel.train.fragment.m;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.j.w;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRTrainDetails;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainQuota;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.widget.CJRWrapContentViewPager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.views.ShimmerFrameLayout;

public final class t extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    ViewPager f26554a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJRTrainQuota> f26555b;

    /* renamed from: c  reason: collision with root package name */
    a f26556c;

    /* renamed from: d  reason: collision with root package name */
    ap.a f26557d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f26558e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f26559f;

    /* renamed from: g  reason: collision with root package name */
    private String f26560g;

    /* renamed from: h  reason: collision with root package name */
    private CJRTrainSearchResultsTrain f26561h;

    /* renamed from: i  reason: collision with root package name */
    private CJRTrainSearchInput f26562i;
    private Activity j;
    private j k;
    private SparseArray<Bundle> l;
    private int m;
    private SparseArray<m> n;
    private ArrayList<String> o = new ArrayList<>();

    public interface a {
        void a(CJRTrainDetailsBody cJRTrainDetailsBody, ap.a aVar, int i2);
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public t(Activity activity, j jVar, ArrayList<String> arrayList, String str, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, CJRTrainSearchInput cJRTrainSearchInput, HashMap<String, Object> hashMap, ArrayList<CJRTrainQuota> arrayList2, ViewPager viewPager, int i2, ap.a aVar, a aVar2) {
        this.j = activity;
        this.k = jVar;
        this.f26559f = arrayList;
        this.f26560g = str;
        this.f26561h = cJRTrainSearchResultsTrain;
        this.f26562i = cJRTrainSearchInput;
        this.f26558e = hashMap;
        this.f26555b = arrayList2;
        this.f26554a = viewPager;
        this.m = i2;
        this.f26557d = aVar;
        this.f26556c = aVar2;
        this.n = new SparseArray<>();
        this.l = new SparseArray<>();
    }

    public final Object instantiateItem(ViewGroup viewGroup, final int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("train_class_details", this.f26559f.get(i2));
        bundle.putString("request_id", this.f26560g);
        HashMap<String, Object> hashMap = this.f26558e;
        if (hashMap != null) {
            for (String next : hashMap.keySet()) {
                if (this.f26558e.get(next).equals(this.f26559f.get(i2))) {
                    bundle.putString("train_class_code", next);
                }
            }
        }
        bundle.putSerializable("train_detail", this.f26561h);
        bundle.putString("quota_code", n.a(this.f26555b, true));
        bundle.putString("quota_name", n.a(this.f26555b, false));
        bundle.putSerializable("intent_extra_train_search_input", this.f26562i);
        m mVar = new m();
        Activity activity = this.j;
        j jVar = this.k;
        mVar.f27051b = activity;
        mVar.q = jVar;
        mVar.f27050a = activity.getLayoutInflater().inflate(R.layout.pre_t_train_availability_fragment, (ViewGroup) null);
        mVar.B = (ShimmerFrameLayout) mVar.f27050a.findViewById(R.id.shimmer_layout);
        mVar.o = (TextView) mVar.f27050a.findViewById(R.id.error_text);
        mVar.k = (LinearLayout) mVar.f27050a.findViewById(R.id.train_detail_list);
        mVar.z = w.a(mVar.f27051b.getApplicationContext());
        if (mVar.z != null) {
            mVar.A = mVar.z.b("train_show_tip_details_view", false, false);
        }
        mVar.k.setVisibility(8);
        mVar.B.setVisibility(0);
        mVar.B.a();
        View view = mVar.f27050a;
        mVar.l = new m.b() {
            public final void a(int i2, CJRTrainDetailsBody cJRTrainDetailsBody) {
                if (!(cJRTrainDetailsBody == null || t.this.f26556c == null)) {
                    t.this.f26556c.a(cJRTrainDetailsBody, t.this.f26557d, i2);
                }
                if (i2 == t.this.f26554a.getCurrentItem()) {
                    t tVar = t.this;
                    if (i2 > 0) {
                        CJRWrapContentViewPager cJRWrapContentViewPager = (CJRWrapContentViewPager) tVar.f26554a;
                        cJRWrapContentViewPager.f28339a = i2;
                        cJRWrapContentViewPager.requestLayout();
                    }
                }
            }
        };
        this.l.put(i2, bundle);
        this.n.put(i2, mVar);
        viewGroup.addView(view);
        return view;
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        this.n.remove(i2);
        this.l.remove(i2);
        viewGroup.removeView((ViewGroup) obj);
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f26559f.get(i2);
    }

    public final int getCount() {
        return this.f26559f.size();
    }

    public final void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        m mVar = this.n.get(i2);
        Bundle bundle = this.l.get(i2);
        mVar.w = this.m;
        if (mVar.f27058i != null || mVar.m) {
            mVar.a(mVar.f27050a);
            return;
        }
        mVar.m = true;
        if (bundle != null) {
            mVar.f27057h = bundle.getString("train_class_code");
            mVar.f27056g = (CJRTrainSearchInput) bundle.getSerializable("intent_extra_train_search_input");
            mVar.f27055f = bundle.getString("request_id");
            mVar.f27054e = bundle.getString("train_class_details");
            mVar.f27052c = (CJRTrainSearchResultsTrain) bundle.getSerializable("train_detail");
            mVar.j = bundle.getString("quota_code");
            mVar.p = bundle.getString("quota_name");
            if (bundle.containsKey("train_class_code")) {
                mVar.t = bundle.getString("train_class_code");
            }
        }
        if (mVar.l != null) {
            mVar.l.a(mVar.B.getMeasuredHeight(), mVar.f27053d);
        }
        if (mVar.o != null && mVar.o.getVisibility() == 0) {
            mVar.o.setVisibility(8);
        }
        String b2 = b.b(mVar.f27052c.getDeparture(), "yyyy-mm-dd", "yyyymmdd");
        com.travel.train.b.a();
        String J = com.travel.train.b.b().J();
        "url is ".concat(String.valueOf(J));
        b.j();
        if (URLUtil.isValidUrl(J)) {
            Uri.Builder buildUpon = Uri.parse(o.b((Context) mVar.f27051b, b.s(mVar.f27051b, J))).buildUpon();
            buildUpon.appendQueryParameter("requestid", mVar.f27055f);
            buildUpon.appendQueryParameter("trainNumber", mVar.f27052c.getTrainNumber());
            buildUpon.appendQueryParameter("departureDate", b2);
            buildUpon.appendQueryParameter("source", mVar.f27052c.getSource());
            buildUpon.appendQueryParameter("destination", mVar.f27052c.getDestination());
            if (!(g.f27551a == null || g.f27551a.getTestId() == null)) {
                buildUpon.appendQueryParameter("test_id", g.f27551a.getTestId().toString());
            }
            buildUpon.appendQueryParameter("quota", mVar.j);
            buildUpon.appendQueryParameter(Item.KEY_CLASS, mVar.f27057h);
            buildUpon.appendQueryParameter("multipleDays", "true");
            buildUpon.appendQueryParameter("train_type", mVar.f27052c.getTrainType());
            com.travel.train.b.a();
            if (com.travel.train.b.a((Context) mVar.f27051b).equals(e.b.RESELLER.name())) {
                buildUpon.appendQueryParameter("reseller", "1");
            }
            String builder = buildUpon.toString();
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = mVar.f27051b;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.f27558h;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = builder;
            bVar.f42882f = n.b((Context) mVar.f27051b);
            bVar.f42885i = new CJRTrainDetails();
            bVar.j = mVar;
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            if (b.c((Context) mVar.f27051b)) {
                l2.a();
            } else {
                mVar.a(l2);
            }
        } else {
            b.b((Context) mVar.f27051b, mVar.f27051b.getString(R.string.error), mVar.f27051b.getString(R.string.msg_invalid_url_train));
        }
    }

    public final m a() {
        return this.n.get(this.f26554a.getCurrentItem());
    }

    public final View a(String str, CJRTrainQuota cJRTrainQuota, boolean z) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = str;
        boolean z2 = z;
        StringBuilder sb = null;
        View inflate = LayoutInflater.from(this.j).inflate(R.layout.pre_t_train_class_type_list_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.lyt_class_sub_inner);
        RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.class_type_text);
        RoboTextView roboTextView2 = (RoboTextView) inflate.findViewById(R.id.price_text);
        RoboTextView roboTextView3 = (RoboTextView) inflate.findViewById(R.id.seat_status_text);
        RoboTextView roboTextView4 = (RoboTextView) inflate.findViewById(R.id.tap_to_view_text);
        inflate.findViewById(R.id.updated_status_text).setVisibility(8);
        inflate.findViewById(R.id.tip_text).setVisibility(4);
        roboTextView.setVisibility(0);
        String str7 = g.ae;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f26561h.getMAvailability().size()) {
                str2 = null;
                str3 = null;
                str4 = str7;
                str5 = null;
                break;
            } else if (!this.f26561h.getMAvailability().get(i2).getClassName().equals(str6) || !cJRTrainQuota.getQuotaCode().equals(this.f26561h.getMAvailability().get(i2).getQuota())) {
                i2++;
            } else {
                str6 = str6 + " (" + this.f26561h.getMAvailability().get(i2).getClassType() + ")";
                if (!TextUtils.isEmpty(this.f26561h.getMAvailability().get(i2).getFare())) {
                    sb = new StringBuilder(this.j.getString(R.string.rs_symbols));
                    sb.append(" ");
                    sb.append(this.f26561h.getMAvailability().get(i2).getFare());
                }
                str5 = this.f26561h.getMAvailability().get(i2).getStatus();
                str4 = this.f26561h.getMAvailability().get(i2).getColour();
                str3 = this.f26561h.getMAvailability().get(i2).getTxtColour();
                str2 = this.f26561h.getMAvailability().get(i2).getBackgroundColour();
            }
        }
        if (sb != null) {
            roboTextView2.setVisibility(0);
            roboTextView3.setVisibility(0);
            roboTextView4.setVisibility(8);
        } else {
            roboTextView2.setVisibility(8);
            roboTextView3.setVisibility(8);
            roboTextView4.setVisibility(0);
        }
        roboTextView.setText(str6);
        roboTextView2.setText(sb);
        roboTextView3.setText(str5);
        if (!TextUtils.isEmpty(str3)) {
            this.o.add(str3);
            roboTextView3.setTextColor(Color.parseColor(str3));
        } else {
            this.o.add(str4);
            roboTextView3.setTextColor(this.j.getResources().getColor(n.b(str4)));
        }
        linearLayout.setSelected(z2);
        if (!z2) {
            try {
                GradientDrawable gradientDrawable = (GradientDrawable) ((DrawableContainer.DrawableContainerState) ((StateListDrawable) linearLayout.getBackground()).getConstantState()).getChildren()[1];
                if (!TextUtils.isEmpty(str2)) {
                    gradientDrawable.setColor(Color.parseColor(str2));
                } else {
                    gradientDrawable.setColor(this.j.getResources().getColor(n.c(str4)));
                }
                if (str4.equals(g.ae)) {
                    gradientDrawable.setStroke(1, this.j.getResources().getColor(R.color.color_d2d2d2));
                } else if (!TextUtils.isEmpty(str2)) {
                    gradientDrawable.setStroke(1, Color.parseColor(str2));
                } else {
                    gradientDrawable.setStroke(1, this.j.getResources().getColor(n.c(str4)));
                }
            } catch (Exception unused) {
            }
        }
        return inflate;
    }

    public final void a(TabLayout.f fVar, boolean z, CJRTrainDetailsBody cJRTrainDetailsBody) {
        try {
            ConstraintLayout constraintLayout = (ConstraintLayout) ((ConstraintLayout) fVar.f36766f).getViewById(R.id.lyt_class_inner);
            LinearLayout linearLayout = (LinearLayout) constraintLayout.getViewById(R.id.lyt_class_sub_inner);
            RoboTextView roboTextView = (RoboTextView) constraintLayout.findViewById(R.id.class_type_text);
            RoboTextView roboTextView2 = (RoboTextView) constraintLayout.findViewById(R.id.seat_status_text);
            RoboTextView roboTextView3 = (RoboTextView) constraintLayout.findViewById(R.id.price_text);
            RoboTextView roboTextView4 = (RoboTextView) constraintLayout.findViewById(R.id.tap_to_view_text);
            Drawable[] children = ((DrawableContainer.DrawableContainerState) ((StateListDrawable) linearLayout.getBackground()).getConstantState()).getChildren();
            if (fVar.e()) {
                linearLayout.setSelected(true);
                GradientDrawable gradientDrawable = (GradientDrawable) children[0];
                gradientDrawable.setColor(this.j.getResources().getColor(R.color.color_ffffff));
                gradientDrawable.setStroke(2, this.j.getResources().getColor(R.color.color_00b9f5));
                roboTextView.setSelected(true);
                roboTextView.setTextSize(11.0f);
                roboTextView3.setTextSize(11.0f);
                roboTextView3.setSelected(true);
                roboTextView2.setVisibility(8);
                roboTextView4.setVisibility(8);
            } else {
                linearLayout.setSelected(false);
                if (this.o != null && this.o.size() > 0 && fVar.f36765e >= 0 && this.o.size() > fVar.f36765e) {
                    String a2 = n.a(roboTextView2.getCurrentTextColor(), (Context) this.j);
                    GradientDrawable gradientDrawable2 = (GradientDrawable) children[1];
                    gradientDrawable2.setColor(this.j.getResources().getColor(n.c(a2)));
                    if (a2.equals(g.ae)) {
                        gradientDrawable2.setStroke(1, this.j.getResources().getColor(R.color.color_d2d2d2));
                    } else {
                        gradientDrawable2.setStroke(1, this.j.getResources().getColor(n.c(a2)));
                    }
                }
                roboTextView.setSelected(false);
                roboTextView.setTextSize(10.0f);
                roboTextView3.setTextSize(10.0f);
                roboTextView3.setSelected(false);
                roboTextView2.setVisibility(0);
            }
            if (z && cJRTrainDetailsBody != null && cJRTrainDetailsBody.getTrainFare() != null) {
                String a3 = n.a(cJRTrainDetailsBody.getmTrainAvailability().get(0).getTypeMap().values());
                this.o.add(a3);
                roboTextView2.setTextColor(this.j.getResources().getColor(n.b(a3)));
                StringBuilder sb = new StringBuilder(this.j.getString(R.string.rs_symbols));
                sb.append(" ");
                sb.append(cJRTrainDetailsBody.getTrainFare().getTotalCollectable());
                roboTextView3.setText(sb);
                roboTextView2.setText(cJRTrainDetailsBody.getmTrainAvailability().get(0).getmSttaus());
                if (fVar.e()) {
                    roboTextView2.setVisibility(8);
                } else {
                    roboTextView2.setVisibility(0);
                }
                roboTextView3.setVisibility(0);
                roboTextView4.setVisibility(8);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
    }
}
