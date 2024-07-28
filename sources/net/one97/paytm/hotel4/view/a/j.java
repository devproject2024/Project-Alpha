package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;
import net.one97.paytm.hotels2.R;

public final class j extends c<Object> {

    /* renamed from: b  reason: collision with root package name */
    public List<AutoSearchDataItem> f28694b;

    /* renamed from: c  reason: collision with root package name */
    public String f28695c = "";

    /* renamed from: d  reason: collision with root package name */
    a f28696d;

    /* renamed from: e  reason: collision with root package name */
    private Context f28697e;

    /* renamed from: f  reason: collision with root package name */
    private a f28698f;

    /* renamed from: g  reason: collision with root package name */
    private Context f28699g;

    public interface a {
        void trendingRecentOnItemClick(Object obj, int i2, String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(a aVar, Context context) {
        super(new h.c<Object>() {
            public final boolean a(Object obj, Object obj2) {
                k.c(obj, "oldItemSRP");
                k.c(obj2, "newItemSRP");
                return k.a(obj, obj2);
            }

            public final boolean b(Object obj, Object obj2) {
                k.c(obj, "oldItemSRP");
                k.c(obj2, "newItemSRP");
                return k.a(obj, obj2);
            }
        });
        k.c(context, "cntxt");
        this.f28698f = aVar;
        this.f28699g = context;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28696d = this.f28698f;
        this.f28697e = this.f28699g;
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_popular_search, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.databinding.ViewDataBinding r7, java.lang.Object r8, int r9) {
        /*
            r6 = this;
            java.lang.String r0 = "binding"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "item"
            kotlin.g.b.k.c(r8, r0)
            boolean r0 = r7 instanceof net.one97.paytm.hotels2.b.fs
            if (r0 == 0) goto L_0x0115
            kotlin.g.b.x$e r0 = new kotlin.g.b.x$e
            r0.<init>()
            r0.element = r8
            T r8 = r0.element
            boolean r8 = r8 instanceof net.one97.paytm.hotel4.service.model.PopularRecentDataItem
            r1 = 1
            r2 = 0
            r3 = 0
            if (r8 == 0) goto L_0x005a
            r8 = r7
            net.one97.paytm.hotels2.b.fs r8 = (net.one97.paytm.hotels2.b.fs) r8
            java.lang.String r4 = "Popular Searches Around You"
            r8.b(r4)
            android.content.Context r4 = r6.f28697e
            if (r4 != 0) goto L_0x002d
            kotlin.g.b.k.a()
        L_0x002d:
            android.content.res.Resources r4 = r4.getResources()
            int r5 = net.one97.paytm.hotels2.R.drawable.h4_ic_trending
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.f.a((android.content.res.Resources) r4, (int) r5, (android.content.res.Resources.Theme) r3)
            r8.a((android.graphics.drawable.Drawable) r3)
            T r3 = r0.element
            net.one97.paytm.hotel4.service.model.PopularRecentDataItem r3 = (net.one97.paytm.hotel4.service.model.PopularRecentDataItem) r3
            java.lang.String r3 = r3.getName()
            r8.a((java.lang.String) r3)
            java.util.List<net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem> r3 = r6.f28694b
            if (r3 == 0) goto L_0x0050
            int r3 = r3.size()
            if (r9 != r3) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r1 = 0
        L_0x0051:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r8.a((java.lang.Boolean) r1)
            goto L_0x00fc
        L_0x005a:
            T r8 = r0.element
            if (r8 == 0) goto L_0x010d
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r8 = (net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem) r8
            r0.element = r8
            r8 = r7
            net.one97.paytm.hotels2.b.fs r8 = (net.one97.paytm.hotels2.b.fs) r8
            java.lang.String r4 = "Recent Searches"
            r8.b(r4)
            android.content.Context r4 = r6.f28697e
            if (r4 != 0) goto L_0x0071
            kotlin.g.b.k.a()
        L_0x0071:
            android.content.res.Resources r4 = r4.getResources()
            int r5 = net.one97.paytm.hotels2.R.drawable.h4_ic_recent
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.f.a((android.content.res.Resources) r4, (int) r5, (android.content.res.Resources.Theme) r3)
            r8.a((android.graphics.drawable.Drawable) r4)
            T r4 = r0.element
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r4 = (net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem) r4
            java.util.List r4 = r4.getDisplay()
            if (r4 == 0) goto L_0x00de
            T r4 = r0.element
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r4 = (net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem) r4
            java.util.List r4 = r4.getDisplay()
            if (r4 == 0) goto L_0x009b
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x009c
        L_0x009b:
            r4 = r3
        L_0x009c:
            if (r4 != 0) goto L_0x00a1
            kotlin.g.b.k.a()
        L_0x00a1:
            int r4 = r4.intValue()
            if (r4 <= r1) goto L_0x00de
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            T r5 = r0.element
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r5 = (net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem) r5
            java.util.List r5 = r5.getDisplay()
            if (r5 == 0) goto L_0x00bd
            java.lang.Object r5 = r5.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x00be
        L_0x00bd:
            r5 = r3
        L_0x00be:
            r4.append(r5)
            java.lang.String r5 = ", "
            r4.append(r5)
            T r5 = r0.element
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r5 = (net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem) r5
            java.util.List r5 = r5.getDisplay()
            if (r5 == 0) goto L_0x00d6
            java.lang.Object r3 = r5.get(r1)
            java.lang.String r3 = (java.lang.String) r3
        L_0x00d6:
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            goto L_0x00ee
        L_0x00de:
            T r4 = r0.element
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r4 = (net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem) r4
            java.util.List r4 = r4.getDisplay()
            if (r4 == 0) goto L_0x00ee
            java.lang.Object r3 = r4.get(r2)
            java.lang.String r3 = (java.lang.String) r3
        L_0x00ee:
            r8.a((java.lang.String) r3)
            if (r9 != 0) goto L_0x00f4
            goto L_0x00f5
        L_0x00f4:
            r1 = 0
        L_0x00f5:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r8.a((java.lang.Boolean) r1)
        L_0x00fc:
            net.one97.paytm.hotels2.b.fs r7 = (net.one97.paytm.hotels2.b.fs) r7
            android.view.View r7 = r7.getRoot()
            net.one97.paytm.hotel4.view.a.j$b r8 = new net.one97.paytm.hotel4.view.a.j$b
            r8.<init>(r6, r0, r9)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r7.setOnClickListener(r8)
            goto L_0x0115
        L_0x010d:
            kotlin.u r7 = new kotlin.u
            java.lang.String r8 = "null cannot be cast to non-null type net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem"
            r7.<init>(r8)
            throw r7
        L_0x0115:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.a.j.a(androidx.databinding.ViewDataBinding, java.lang.Object, int):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f28700a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f28701b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f28702c;

        b(j jVar, x.e eVar, int i2) {
            this.f28700a = jVar;
            this.f28701b = eVar;
            this.f28702c = i2;
        }

        public final void onClick(View view) {
            a aVar;
            String str = this.f28700a.f28695c;
            if (str != null && (aVar = this.f28700a.f28696d) != null) {
                aVar.trendingRecentOnItemClick(this.f28701b.element, this.f28702c, str);
            }
        }
    }
}
