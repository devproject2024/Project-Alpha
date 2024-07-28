package net.one97.travelpass.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import com.one97.travelpass.custom.SlidingViewPager;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.ui.c.j;

public final class s extends RecyclerView.v implements c, d {

    /* renamed from: a  reason: collision with root package name */
    private SlidingViewPager f30416a;

    /* renamed from: b  reason: collision with root package name */
    private TabLayout f30417b;

    /* renamed from: c  reason: collision with root package name */
    private j f30418c;

    /* renamed from: d  reason: collision with root package name */
    private c f30419d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        SlidingViewPager slidingViewPager = (SlidingViewPager) view.findViewById(R.id.viewpager_image);
        if (slidingViewPager != null) {
            this.f30416a = slidingViewPager;
            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.viewpager_dots);
            if (tabLayout != null) {
                this.f30417b = tabLayout;
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
        }
        throw new u("null cannot be cast to non-null type com.one97.travelpass.custom.SlidingViewPager");
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        SlidingViewPager slidingViewPager;
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        this.f30418c = jVar;
        this.f30419d = cVar;
        net.one97.travelpass.a.a aVar = new net.one97.travelpass.a.a(context, jVar, this);
        SlidingViewPager slidingViewPager2 = this.f30416a;
        if (slidingViewPager2 != null) {
            slidingViewPager2.setAdapter(aVar);
        }
        if (jVar.a().size() > 1) {
            TabLayout tabLayout = this.f30417b;
            if (tabLayout != null) {
                tabLayout.setVisibility(0);
            }
            TabLayout tabLayout2 = this.f30417b;
            if (tabLayout2 != null) {
                tabLayout2.setupWithViewPager(this.f30416a, true);
            }
        } else {
            TabLayout tabLayout3 = this.f30417b;
            if (tabLayout3 != null) {
                tabLayout3.setVisibility(4);
            }
        }
        TabLayout tabLayout4 = this.f30417b;
        if (tabLayout4 != null) {
            tabLayout4.setSelectedTabIndicator((Drawable) null);
        }
        if (!(jVar.j() == -1 || (slidingViewPager = this.f30416a) == null)) {
            slidingViewPager.setCurrentItem(jVar.j());
        }
        SlidingViewPager slidingViewPager3 = this.f30416a;
        if (slidingViewPager3 != null) {
            slidingViewPager3.setOnPageChangeListener(new a(cVar, jVar));
        }
    }

    public static final class a implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30420a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30421b;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        a(c cVar, j jVar) {
            this.f30420a = cVar;
            this.f30421b = jVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r1 = r1.a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPageSelected(int r4) {
            /*
                r3 = this;
                com.one97.travelpass.a.c r0 = r3.f30420a
                net.one97.travelpass.ui.c.j r1 = r3.f30421b
                if (r1 == 0) goto L_0x0013
                java.util.ArrayList r1 = r1.a()
                if (r1 == 0) goto L_0x0013
                java.lang.Object r1 = r1.get(r4)
                net.one97.travelpass.ui.c.j r1 = (net.one97.travelpass.ui.c.j) r1
                goto L_0x0014
            L_0x0013:
                r1 = 0
            L_0x0014:
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                net.one97.travelpass.ui.a r2 = net.one97.travelpass.ui.a.f30575a
                int r2 = net.one97.travelpass.ui.a.c()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r0.onItemClickedItem(r1, r4, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.f.s.a.onPageSelected(int):void");
        }
    }

    public final void onItemClickedItem(j jVar, Integer num, Integer num2) {
        c cVar = this.f30419d;
        if (cVar != null) {
            net.one97.travelpass.ui.a aVar = net.one97.travelpass.ui.a.f30575a;
            cVar.onItemClickedItem(jVar, num, Integer.valueOf(net.one97.travelpass.ui.a.b()));
        }
    }
}
