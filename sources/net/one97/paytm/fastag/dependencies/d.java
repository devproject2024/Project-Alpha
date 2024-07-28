package net.one97.paytm.fastag.dependencies;

import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.model.CJRAction;
import net.one97.paytm.fastag.model.CJROrderSummary;

public class d extends DialogFragment {
    private int A;
    /* access modifiers changed from: private */
    public ViewPager B;
    /* access modifiers changed from: private */
    public ViewPager.e C = new ViewPager.e() {
        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        public final void onPageSelected(int i2) {
            String str;
            View childAt;
            int i3 = i2 + 3;
            View childAt2 = d.this.B.getChildAt(i3);
            if (d.this.y >= 0 && d.this.y < d.this.B.getChildCount() && (childAt = d.this.B.getChildAt(d.this.y)) != null) {
                Object tag = childAt.getTag();
                if (tag instanceof a.C0187a) {
                    d.a(d.this, (a.C0187a) tag, false);
                }
            }
            if (childAt2 != null) {
                Object tag2 = childAt2.getTag();
                if (tag2 instanceof a.C0187a) {
                    d.a(d.this, (a.C0187a) tag2, true);
                }
            }
            int unused = d.this.y = i3;
            d dVar = d.this;
            int unused2 = dVar.z = dVar.y - 2;
            if (d.this.z > 1) {
                str = d.this.k;
            } else {
                str = d.this.j;
            }
            d.this.p.setText(d.this.z + " " + str + " " + d.this.l);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    boolean f13649a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f13650b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public i f13651c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CJRAction f13652d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public CJROrderSummary f13653e;

    /* renamed from: f  reason: collision with root package name */
    private Calendar f13654f;

    /* renamed from: g  reason: collision with root package name */
    private String f13655g;

    /* renamed from: h  reason: collision with root package name */
    private String f13656h;

    /* renamed from: i  reason: collision with root package name */
    private String f13657i;
    /* access modifiers changed from: private */
    public String j;
    /* access modifiers changed from: private */
    public String k;
    /* access modifiers changed from: private */
    public String l;
    private String m;
    private TextView n;
    private TextView o;
    /* access modifiers changed from: private */
    public TextView p;
    /* access modifiers changed from: private */
    public String q;
    /* access modifiers changed from: private */
    public String r;
    private int s;
    private float t;
    private float u;
    private int v;
    private float w;
    private float x;
    /* access modifiers changed from: private */
    public int y;
    /* access modifiers changed from: private */
    public int z = 1;

    public d() {
    }

    public d(Activity activity, CJROrderSummary cJROrderSummary, CJRAction cJRAction, i iVar, String str, String str2, String str3, int i2) {
        this.f13650b = activity;
        this.f13655g = i.a(str3);
        this.A = i2;
        this.f13651c = iVar;
        this.f13652d = cJRAction;
        this.q = str;
        this.r = str2;
        this.f13653e = cJROrderSummary;
        this.f13656h = this.f13650b.getResources().getString(R.string.format_yyyy_mm_dd_hh_mm_ss_str);
        this.f13657i = this.f13650b.getResources().getString(R.string.format_dd_MMMM_yyyy_str);
        this.s = this.f13650b.getResources().getColor(R.color.color_494949);
        this.m = this.f13650b.getResources().getString(R.string.current_disptach_date);
        this.v = -16777216;
        this.t = this.f13650b.getResources().getDimension(R.dimen.extend_dipatch_dull_text_size_date);
        this.w = this.f13650b.getResources().getDimension(R.dimen.extend_dipatch_sel_text_size_date);
        this.u = this.f13650b.getResources().getDimension(R.dimen.extend_dipatch_dull_text_size_month);
        this.x = this.f13650b.getResources().getDimension(R.dimen.extend_dipatch_sel_text_size_month);
        this.k = this.f13650b.getResources().getString(R.string.days_string);
        this.j = this.f13650b.getResources().getString(R.string.day_string);
        this.l = this.f13650b.getResources().getString(R.string.days_extended_string);
        this.f13654f = Calendar.getInstance();
        try {
            this.f13654f.setTime(new SimpleDateFormat(this.f13656h).parse(this.f13655g));
        } catch (Exception unused) {
            this.f13649a = true;
        }
        this.y = 3;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lyt_extend_date_frag_ft, viewGroup, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.CustomAnimations_slide_in);
        getDialog().getWindow().getAttributes().gravity = 87;
        this.n = (TextView) inflate.findViewById(R.id.done_button);
        this.o = (TextView) inflate.findViewById(R.id.current_date);
        this.p = (TextView) inflate.findViewById(R.id.extended_date);
        this.B = (ViewPager) inflate.findViewById(R.id.date_view_pager);
        this.B.setAdapter(new a(this.f13650b, this.f13654f, this.A, this.p));
        this.B.addOnPageChangeListener(this.C);
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("item_id", d.this.r);
                StringBuilder sb = new StringBuilder();
                sb.append(d.this.z);
                hashMap.put("numberOfDays", sb.toString());
                hashMap.put("order_id", d.this.q);
                d.this.f13651c.a(d.this.f13653e, d.this.f13652d, hashMap, "");
                d.this.getDialog().dismiss();
            }
        });
        this.o.setText(this.m + " " + i.a(this.f13655g, this.f13656h, this.f13657i));
        TextView textView = this.p;
        StringBuilder sb = new StringBuilder();
        sb.append(this.A);
        textView.setText(sb.toString());
        this.B.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                d.this.C.onPageSelected(0);
                d.this.B.removeOnLayoutChangeListener(this);
            }
        });
        inflate.findViewById(R.id.close_icon).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.getDialog().dismiss();
            }
        });
        return inflate;
    }

    static class a extends androidx.viewpager.widget.a {

        /* renamed from: a  reason: collision with root package name */
        private Activity f13662a;

        /* renamed from: b  reason: collision with root package name */
        private int f13663b;

        /* renamed from: c  reason: collision with root package name */
        private Calendar f13664c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f13665d;

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<String> f13666e = new ArrayList<>();

        /* renamed from: f  reason: collision with root package name */
        private ArrayList<String> f13667f = new ArrayList<>();

        /* renamed from: g  reason: collision with root package name */
        private LayoutInflater f13668g;

        public final float getPageWidth(int i2) {
            return 0.14f;
        }

        /* renamed from: net.one97.paytm.fastag.dependencies.d$a$a  reason: collision with other inner class name */
        static class C0187a {

            /* renamed from: a  reason: collision with root package name */
            TextView f13669a;

            /* renamed from: b  reason: collision with root package name */
            TextView f13670b;

            C0187a(TextView textView, TextView textView2) {
                this.f13669a = textView;
                this.f13670b = textView2;
            }
        }

        public a(Activity activity, Calendar calendar, int i2, TextView textView) {
            this.f13662a = activity;
            this.f13664c = calendar;
            this.f13663b = i2;
            this.f13668g = LayoutInflater.from(this.f13662a);
            this.f13665d = textView;
            b();
        }

        private void a() {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f13666e.add("");
                this.f13667f.add("");
            }
        }

        private void b() {
            a();
            for (int i2 = 1; i2 <= this.f13663b; i2++) {
                this.f13664c.add(5, 1);
                ArrayList<String> arrayList = this.f13666e;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f13664c.get(5));
                arrayList.add(sb.toString());
                this.f13667f.add(this.f13664c.getDisplayName(2, 2, Locale.getDefault()));
            }
            a();
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        public final int getCount() {
            ArrayList<String> arrayList = this.f13666e;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            View inflate = this.f13668g.inflate(R.layout.lyt_pager_date_container_ft, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.id.date);
            TextView textView2 = (TextView) inflate.findViewById(R.id.month);
            inflate.setTag(new C0187a(textView, textView2));
            textView.setText(this.f13666e.get(i2));
            textView2.setText(this.f13667f.get(i2));
            viewGroup.addView(inflate);
            return inflate;
        }

        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            View view = (View) obj;
            if (view instanceof RelativeLayout) {
                ((RelativeLayout) view).removeAllViews();
            }
            view.setOnClickListener((View.OnClickListener) null);
            view.removeCallbacks((Runnable) null);
            viewGroup.removeView(view);
        }
    }

    static /* synthetic */ void a(d dVar, a.C0187a aVar, boolean z2) {
        TextView textView = aVar.f13670b;
        TextView textView2 = aVar.f13669a;
        if (z2) {
            textView.setTextSize(dVar.x);
            textView.setTextColor(dVar.v);
            textView2.setTextSize(dVar.w);
            textView2.setTextColor(dVar.v);
            return;
        }
        textView.setTextSize(dVar.u);
        textView.setTextColor(dVar.s);
        textView2.setTextSize(dVar.t);
        textView2.setTextColor(dVar.s);
    }
}
