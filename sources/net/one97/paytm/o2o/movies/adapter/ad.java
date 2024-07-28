package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.b;
import com.paytm.utility.t;
import com.squareup.picasso.aa;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.utils.n;

public final class ad extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    int f74274a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f74275b = 0;

    /* renamed from: c  reason: collision with root package name */
    a f74276c;

    /* renamed from: d  reason: collision with root package name */
    private final String f74277d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f74278e;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f74279f;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager f74280g;

    /* renamed from: h  reason: collision with root package name */
    private CJRHomePageLayoutV2 f74281h;

    public interface a {
        void a(IJRDataModel iJRDataModel);
    }

    public ad(CJRHomePageLayoutV2 cJRHomePageLayoutV2, ViewPager viewPager, String str) {
        this.f74280g = viewPager;
        this.f74281h = cJRHomePageLayoutV2;
        this.f74277d = str;
        this.f74278e = viewPager.getContext();
        this.f74279f = LayoutInflater.from(this.f74278e);
    }

    public final int getCount() {
        if (this.f74281h.getHomePageItemList() == null) {
            return 0;
        }
        if (this.f74281h.getHomePageItemList().size() == 1) {
            return 1;
        }
        return this.f74281h.getHomePageItemList().size() + (this.f74281h.getHomePageItemList().size() * 1000);
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        Drawable drawable;
        try {
            this.f74278e.getResources().getLayout(R.layout.movie_view_pager_item);
            View inflate = this.f74279f.inflate(R.layout.movie_view_pager_item, viewGroup, false);
            int size = i2 % this.f74281h.getHomePageItemList().size();
            this.f74278e.getApplicationContext();
            String a2 = b.a(this.f74281h.getHomePageItemList().get(size).getImageUrl(), this.f74275b, this.f74274a);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.viewpager_image);
            try {
                drawable = androidx.core.content.b.a(this.f74278e, R.drawable.movie_home_top_banner_placeholder);
            } catch (Throwable unused) {
                drawable = null;
            }
            if (drawable == null) {
                drawable = new ColorDrawable(androidx.core.content.b.c(this.f74278e, R.color.white_smoke));
            }
            aa a3 = w.a().a(a2);
            a3.f45353b = true;
            a3.b(drawable).a(drawable).a((ah) new t.b(n.a(6, this.f74278e), 0, true)).a(imageView, (e) null);
            inflate.setOnClickListener(new View.OnClickListener(inflate, size) {
                private final /* synthetic */ View f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    ad.this.a(this.f$1, this.f$2, view);
                }
            });
            viewGroup.addView(inflate);
            return inflate;
        } catch (Exception unused2) {
            return new View(this.f74278e);
        }
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

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|(1:4)(1:5)|6|7|8|10|(2:12|13)(1:14)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0058 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(android.view.View r7, int r8, android.view.View r9) {
        /*
            r6 = this;
            net.one97.paytm.o2o.movies.common.a.e.b(r7)
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r7 = r6.f74281h     // Catch:{ Exception -> 0x0058 }
            java.util.ArrayList r7 = r7.getHomePageItemList()     // Catch:{ Exception -> 0x0058 }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x0058 }
            r1 = r7
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r1     // Catch:{ Exception -> 0x0058 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0058 }
            java.lang.String r9 = "-"
            r7.<init>(r9)     // Catch:{ Exception -> 0x0058 }
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r9 = r6.f74281h     // Catch:{ Exception -> 0x0058 }
            java.lang.String r9 = r9.getName()     // Catch:{ Exception -> 0x0058 }
            r7.append(r9)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0058 }
            r1.setParentItem(r7)     // Catch:{ Exception -> 0x0058 }
            net.one97.paytm.o2o.movies.common.c.b r7 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x0058 }
            net.one97.paytm.o2o.movies.common.c.c r7 = r7.f75033b     // Catch:{ Exception -> 0x0058 }
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r9 = r6.f74281h     // Catch:{ Exception -> 0x0058 }
            java.lang.String r7 = r7.getContainerInstanceId(r9)     // Catch:{ Exception -> 0x0058 }
            if (r7 == 0) goto L_0x0037
            r1.setmContainerInstanceID(r7)     // Catch:{ Exception -> 0x0058 }
            goto L_0x003c
        L_0x0037:
            java.lang.String r7 = ""
            r1.setmContainerInstanceID(r7)     // Catch:{ Exception -> 0x0058 }
        L_0x003c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0058 }
            java.lang.String r9 = "/movies/"
            r7.<init>(r9)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r9 = r6.f74277d     // Catch:{ Exception -> 0x0058 }
            r7.append(r9)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0058 }
            net.one97.paytm.o2o.movies.common.c.b r7 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x0058 }
            net.one97.paytm.o2o.movies.common.c.c r0 = r7.f75033b     // Catch:{ Exception -> 0x0058 }
            android.content.Context r2 = r6.f74278e     // Catch:{ Exception -> 0x0058 }
            java.lang.String r4 = ""
            r3 = r8
            r0.sendPromotionClick(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0058 }
        L_0x0058:
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r7 = r6.f74281h     // Catch:{ Exception -> 0x00c9 }
            java.util.ArrayList r7 = r7.getHomePageItemList()     // Catch:{ Exception -> 0x00c9 }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x00c9 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r7 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r7     // Catch:{ Exception -> 0x00c9 }
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ Exception -> 0x00c9 }
            r9.<init>()     // Catch:{ Exception -> 0x00c9 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x00c9 }
            r0.<init>()     // Catch:{ Exception -> 0x00c9 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x00c9 }
            r1.<init>()     // Catch:{ Exception -> 0x00c9 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x00c9 }
            r2.<init>()     // Catch:{ Exception -> 0x00c9 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x00c9 }
            r3.<init>()     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r4 = "id"
            java.lang.String r5 = r7.getItemID()     // Catch:{ Exception -> 0x00c9 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r4 = "name"
            java.lang.String r5 = r7.getName()     // Catch:{ Exception -> 0x00c9 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r4 = "creative"
            java.lang.String r7 = r7.getImageUrl()     // Catch:{ Exception -> 0x00c9 }
            r3.put(r4, r7)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r7 = "position"
            int r8 = r8 + 1
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00c9 }
            r3.put(r7, r8)     // Catch:{ Exception -> 0x00c9 }
            r2.add(r3)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r7 = "promotions"
            r1.put(r7, r2)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r7 = "promoClick"
            r0.put(r7, r1)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r7 = "ecommerce"
            r9.put(r7, r0)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r7 = "vertical_name"
            java.lang.String r8 = "Entertainment - Movies"
            r9.put(r7, r8)     // Catch:{ Exception -> 0x00c9 }
            net.one97.paytm.o2o.movies.common.c.b r7 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x00c9 }
            net.one97.paytm.o2o.movies.common.c.c r7 = r7.f75033b     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r8 = "promotionClick"
            android.content.Context r0 = r6.f74278e     // Catch:{ Exception -> 0x00c9 }
            r7.sendEnhancedEcommerceEvent(r8, r9, r0)     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00ca
        L_0x00c9:
        L_0x00ca:
            net.one97.paytm.o2o.movies.adapter.ad$a r7 = r6.f74276c
            if (r7 == 0) goto L_0x00fc
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r8 = r6.f74281h
            java.util.ArrayList r8 = r8.getHomePageItemList()
            androidx.viewpager.widget.ViewPager r9 = r6.f74280g
            int r9 = r9.getCurrentItem()
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r0 = r6.f74281h
            java.util.ArrayList r0 = r0.getHomePageItemList()
            int r0 = r0.size()
            int r9 = r9 % r0
            java.lang.Object r8 = r8.get(r9)
            net.one97.paytm.common.entity.IJRDataModel r8 = (net.one97.paytm.common.entity.IJRDataModel) r8
            androidx.viewpager.widget.ViewPager r9 = r6.f74280g
            r9.getCurrentItem()
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r9 = r6.f74281h
            java.util.ArrayList r9 = r9.getHomePageItemList()
            r9.size()
            r7.a(r8)
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.adapter.ad.a(android.view.View, int, android.view.View):void");
    }
}
