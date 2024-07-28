package net.one97.paytm.games.view.pfg.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.q;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.a.c;
import net.one97.paytm.games.e.a.f;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.model.pfg.Banner;
import net.one97.paytm.games.view.pfg.banner.CycleViewPager;

public class CycleViewPager extends FrameLayout implements ViewPager.e {

    /* renamed from: a  reason: collision with root package name */
    final Runnable f35729a = new Runnable() {
        public final void run() {
            if (CycleViewPager.this.f35730b != null && CycleViewPager.this.m) {
                if (System.currentTimeMillis() - CycleViewPager.this.p > ((long) (CycleViewPager.this.n - 500))) {
                    CycleViewPager.this.f35734f.sendEmptyMessage(CycleViewPager.this.f35735g);
                } else {
                    CycleViewPager.this.f35734f.sendEmptyMessage(CycleViewPager.this.f35736h);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f35730b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f35731c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f35732d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f35733e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Handler f35734f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f35735g = 100;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f35736h = 101;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public List<View> f35737i = new ArrayList();
    private ImageView[] j;
    /* access modifiers changed from: private */
    public boolean k = false;
    private boolean l = true;
    /* access modifiers changed from: private */
    public boolean m = true;
    /* access modifiers changed from: private */
    public int n = 4000;
    /* access modifiers changed from: private */
    public int o = 0;
    /* access modifiers changed from: private */
    public long p = 0;
    private b q;
    /* access modifiers changed from: private */
    public a r;
    /* access modifiers changed from: private */
    public List<Banner> s;
    private int t;
    private int u;
    private c v;

    public interface a {
    }

    public void onPageScrolled(int i2, float f2, int i3) {
    }

    public CycleViewPager(Context context) {
        super(context);
        a(context);
    }

    public CycleViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CycleViewPager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.f35730b = g.a().c().wrapContext(context);
        LayoutInflater.from(this.f35730b).inflate(R.layout.layout_cycle_view, this, true);
        this.f35731c = (ViewPager) findViewById(R.id.cycle_view_pager);
        this.f35732d = (TextView) findViewById(R.id.cycle_title);
        this.f35733e = (LinearLayout) findViewById(R.id.cycle_indicator);
        ViewPager viewPager = this.f35731c;
        f fVar = f.f35598a;
        viewPager.setPageMargin(f.a(this.f35730b, 12));
        this.f35731c.setPageTransformer(false, new a());
        a();
        this.f35734f = new Handler() {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == CycleViewPager.this.f35735g && CycleViewPager.this.f35737i.size() > 0) {
                    if (!CycleViewPager.this.k) {
                        CycleViewPager.this.f35731c.setCurrentItem((CycleViewPager.this.o + 1) % CycleViewPager.this.f35737i.size(), true);
                    }
                    long unused = CycleViewPager.this.p = System.currentTimeMillis();
                    CycleViewPager.this.f35734f.removeCallbacks(CycleViewPager.this.f35729a);
                    CycleViewPager.this.f35734f.postDelayed(CycleViewPager.this.f35729a, (long) CycleViewPager.this.n);
                } else if (message.what == CycleViewPager.this.f35736h && CycleViewPager.this.f35737i.size() > 0) {
                    CycleViewPager.this.f35734f.removeCallbacks(CycleViewPager.this.f35729a);
                    CycleViewPager.this.f35734f.postDelayed(CycleViewPager.this.f35729a, (long) CycleViewPager.this.n);
                }
            }
        };
    }

    public void setIndicators(int i2, int i3) {
        this.t = i2;
        this.u = i3;
    }

    public void setData(List<Banner> list, a aVar) {
        setData(list, aVar, 0);
    }

    public void setMargin(int i2) {
        ViewPager viewPager = this.f35731c;
        f fVar = f.f35598a;
        viewPager.setPageMargin(f.a(this.f35730b, i2));
    }

    public void setPadding(int i2) {
        ViewPager viewPager = this.f35731c;
        f fVar = f.f35598a;
        int a2 = f.a(this.f35730b, i2);
        f fVar2 = f.f35598a;
        viewPager.setPadding(a2, 0, f.a(this.f35730b, i2), 0);
    }

    public void setPaddingPx(int i2) {
        this.f35731c.setPadding(i2, 0, i2, 0);
    }

    public void setData(List<Banner> list, a aVar, int i2) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        this.f35737i.clear();
        this.s = list;
        if (this.l) {
            List<View> list2 = this.f35737i;
            Context context = this.f35730b;
            List<Banner> list3 = this.s;
            list2.add(a(context, list3.get(list3.size() - 1).getPicUrl()));
            for (int i3 = 0; i3 < this.s.size(); i3++) {
                this.f35737i.add(a(this.f35730b, this.s.get(i3).getPicUrl()));
            }
            this.f35737i.add(a(this.f35730b, this.s.get(0).getPicUrl()));
        } else {
            for (int i4 = 0; i4 < this.s.size(); i4++) {
                this.f35737i.add(a(this.f35730b, this.s.get(i4).getPicUrl()));
            }
        }
        List<View> list4 = this.f35737i;
        if (list4 == null || list4.size() == 0) {
            setVisibility(8);
            return;
        }
        this.r = aVar;
        int size = this.f35737i.size();
        this.j = new ImageView[size];
        if (this.l) {
            this.j = new ImageView[(size - 2)];
        }
        this.f35733e.removeAllViews();
        int i5 = 0;
        while (true) {
            ImageView[] imageViewArr = this.j;
            if (i5 >= imageViewArr.length) {
                break;
            }
            imageViewArr[i5] = new ImageView(this.f35730b);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(10, 0, 10, 0);
            this.j[i5].setLayoutParams(layoutParams);
            this.f35733e.addView(this.j[i5]);
            i5++;
        }
        this.q = new b(this, (byte) 0);
        setIndicator(0);
        this.f35731c.setOffscreenPageLimit(3);
        this.f35731c.setOnPageChangeListener(this);
        this.f35731c.setAdapter(this.q);
        if (i2 < 0 || i2 >= this.f35737i.size()) {
            i2 = 0;
        }
        if (this.l) {
            i2++;
        }
        this.f35731c.setCurrentItem(i2);
        setWheel(true);
    }

    private static View a(Context context, String str) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.banner_item_padding, (ViewGroup) null);
        c.a aVar = net.one97.paytm.games.e.a.c.f35593a;
        c.a.a();
        net.one97.paytm.games.e.a.c.b(context, str, (ImageView) inflate.findViewById(R.id.banner_image));
        return inflate;
    }

    private void setIndicator(int i2) {
        setText(this.f35732d, this.s.get(i2).getTitle());
        int i3 = 0;
        while (i3 < this.j.length) {
            try {
                this.j[i3].setBackgroundResource(this.u);
                i3++;
            } catch (Exception unused) {
                return;
            }
        }
        if (this.j.length > i2) {
            this.j[i2].setBackgroundResource(this.t);
        }
    }

    class b extends androidx.viewpager.widget.a {
        public final int getItemPosition(Object obj) {
            return -2;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private b() {
        }

        /* synthetic */ b(CycleViewPager cycleViewPager, byte b2) {
            this();
        }

        public final int getCount() {
            return CycleViewPager.this.f35737i.size();
        }

        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            a unused = CycleViewPager.this.r;
            CycleViewPager.this.s.get(CycleViewPager.this.o - 1);
            int unused2 = CycleViewPager.this.o;
        }

        public final /* synthetic */ Object instantiateItem(ViewGroup viewGroup, int i2) {
            View view = (View) CycleViewPager.this.f35737i.get(i2);
            if (CycleViewPager.this.r != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        CycleViewPager.b.this.a(view);
                    }
                });
            }
            viewGroup.addView(view);
            return view;
        }
    }

    public void onPageSelected(int i2) {
        int size = this.f35737i.size() - 1;
        this.o = i2;
        if (this.l) {
            if (i2 == 0) {
                this.o = size - 1;
            } else if (i2 == size) {
                this.o = 1;
            }
            i2 = this.o - 1;
        }
        setIndicator(i2);
    }

    public void onPageScrollStateChanged(int i2) {
        if (i2 == 1) {
            this.k = true;
            return;
        }
        if (i2 == 0) {
            this.p = System.currentTimeMillis();
            this.f35731c.setCurrentItem(this.o, false);
        }
        this.k = false;
    }

    public static void setText(TextView textView, String str) {
        if (str != null && textView != null) {
            textView.setText(str);
        }
    }

    public static void setText(TextView textView, int i2) {
        if (textView != null) {
            setText(textView, String.valueOf(i2));
        }
    }

    public void setCycle(boolean z) {
        this.l = z;
    }

    public void setWheel(boolean z) {
        this.m = z;
        this.l = true;
        if (z) {
            this.f35734f.postDelayed(this.f35729a, (long) this.n);
        }
    }

    public void setDelay(int i2) {
        this.n = i2;
    }

    public static class c extends Scroller {

        /* renamed from: a  reason: collision with root package name */
        private int f35741a = 500;

        public c(Context context) {
            super(context);
        }

        public final void startScroll(int i2, int i3, int i4, int i5) {
            super.startScroll(i2, i3, i4, i5, this.f35741a);
        }

        public final void startScroll(int i2, int i3, int i4, int i5, int i6) {
            super.startScroll(i2, i3, i4, i5, this.f35741a);
        }
    }

    private void a() {
        try {
            Field declaredField = Class.forName("androidx.viewpager.widget.ViewPager").getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            this.v = new c(this.f35730b);
            declaredField.set(this.f35731c, this.v);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }
}
