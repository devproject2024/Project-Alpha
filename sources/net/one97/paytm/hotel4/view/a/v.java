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
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;
import net.one97.paytm.hotels2.R;

public final class v extends c<AutoSearchDataItem> {

    /* renamed from: b  reason: collision with root package name */
    public String f28744b = "";

    /* renamed from: c  reason: collision with root package name */
    a f28745c;

    /* renamed from: d  reason: collision with root package name */
    public List<AutoSearchDataItem> f28746d;

    /* renamed from: e  reason: collision with root package name */
    public List<AutoSearchDataItem> f28747e;

    /* renamed from: f  reason: collision with root package name */
    public List<AutoSearchDataItem> f28748f;

    /* renamed from: g  reason: collision with root package name */
    private Context f28749g;

    /* renamed from: h  reason: collision with root package name */
    private String f28750h = "uniqueID";

    /* renamed from: i  reason: collision with root package name */
    private a f28751i;
    private Context j;

    public interface a {
        void autoSuggestOnItemClick(AutoSearchDataItem autoSearchDataItem, int i2, String str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b3, code lost:
        if (r10 != r0.size()) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d9, code lost:
        if (r10 == (r0 + r1.size())) goto L_0x00db;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(androidx.databinding.ViewDataBinding r8, java.lang.Object r9, int r10) {
        /*
            r7 = this;
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r9 = (net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem) r9
            java.lang.String r0 = "binding"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "item"
            kotlin.g.b.k.c(r9, r0)
            boolean r0 = r8 instanceof net.one97.paytm.hotels2.b.fe
            if (r0 == 0) goto L_0x0165
            net.one97.paytm.hotels2.b.fe r8 = (net.one97.paytm.hotels2.b.fe) r8
            r8.a((net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem) r9)
            java.lang.Integer r0 = r9.getViewType()
            java.lang.String r1 = "\n"
            r2 = 0
            r3 = 2
            r4 = 0
            r5 = 1
            if (r0 != 0) goto L_0x0022
            goto L_0x0059
        L_0x0022:
            int r0 = r0.intValue()
            if (r0 != r3) goto L_0x0059
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.List r6 = r9.getDisplay()
            if (r6 != 0) goto L_0x0036
            kotlin.g.b.k.a()
        L_0x0036:
            java.lang.Object r6 = r6.get(r2)
            java.lang.String r6 = (java.lang.String) r6
            r0.append(r6)
            r0.append(r1)
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r1 = r9.getSearchParams()
            if (r1 == 0) goto L_0x004d
            java.lang.String r1 = r1.getCity()
            goto L_0x004e
        L_0x004d:
            r1 = r4
        L_0x004e:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.b(r0)
            goto L_0x008c
        L_0x0059:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.List r6 = r9.getDisplay()
            if (r6 != 0) goto L_0x0067
            kotlin.g.b.k.a()
        L_0x0067:
            java.lang.Object r6 = r6.get(r2)
            java.lang.String r6 = (java.lang.String) r6
            r0.append(r6)
            r0.append(r1)
            java.util.List r1 = r9.getDisplay()
            if (r1 != 0) goto L_0x007c
            kotlin.g.b.k.a()
        L_0x007c:
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.b(r0)
        L_0x008c:
            java.lang.Integer r0 = r9.getViewType()
            if (r0 != 0) goto L_0x0093
            goto L_0x009b
        L_0x0093:
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x009b
            if (r10 == 0) goto L_0x00db
        L_0x009b:
            java.lang.Integer r0 = r9.getViewType()
            if (r0 != 0) goto L_0x00a2
            goto L_0x00b5
        L_0x00a2:
            int r0 = r0.intValue()
            if (r0 != r5) goto L_0x00b5
            java.util.List<net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem> r0 = r7.f28746d
            if (r0 != 0) goto L_0x00af
            kotlin.g.b.k.a()
        L_0x00af:
            int r0 = r0.size()
            if (r10 == r0) goto L_0x00db
        L_0x00b5:
            java.lang.Integer r0 = r9.getViewType()
            if (r0 != 0) goto L_0x00bc
            goto L_0x00dc
        L_0x00bc:
            int r0 = r0.intValue()
            if (r0 != r3) goto L_0x00dc
            java.util.List<net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem> r0 = r7.f28746d
            if (r0 != 0) goto L_0x00c9
            kotlin.g.b.k.a()
        L_0x00c9:
            int r0 = r0.size()
            java.util.List<net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem> r1 = r7.f28747e
            if (r1 != 0) goto L_0x00d4
            kotlin.g.b.k.a()
        L_0x00d4:
            int r1 = r1.size()
            int r0 = r0 + r1
            if (r10 != r0) goto L_0x00dc
        L_0x00db:
            r2 = 1
        L_0x00dc:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r8.a((java.lang.Boolean) r0)
            java.lang.Integer r0 = r9.getViewType()
            if (r0 != 0) goto L_0x00ea
            goto L_0x010a
        L_0x00ea:
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x010a
            java.lang.String r0 = "City"
            r8.a((java.lang.String) r0)
            android.content.Context r0 = r7.f28749g
            if (r0 != 0) goto L_0x00fc
            kotlin.g.b.k.a()
        L_0x00fc:
            android.content.res.Resources r0 = r0.getResources()
            int r1 = net.one97.paytm.hotels2.R.drawable.h4_ic_city
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.f.a((android.content.res.Resources) r0, (int) r1, (android.content.res.Resources.Theme) r4)
            r8.a((android.graphics.drawable.Drawable) r0)
            goto L_0x0157
        L_0x010a:
            java.lang.Integer r0 = r9.getViewType()
            if (r0 != 0) goto L_0x0111
            goto L_0x0131
        L_0x0111:
            int r0 = r0.intValue()
            if (r0 != r5) goto L_0x0131
            java.lang.String r0 = "Locality"
            r8.a((java.lang.String) r0)
            android.content.Context r0 = r7.f28749g
            if (r0 != 0) goto L_0x0123
            kotlin.g.b.k.a()
        L_0x0123:
            android.content.res.Resources r0 = r0.getResources()
            int r1 = net.one97.paytm.hotels2.R.drawable.h4_ic_locality
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.f.a((android.content.res.Resources) r0, (int) r1, (android.content.res.Resources.Theme) r4)
            r8.a((android.graphics.drawable.Drawable) r0)
            goto L_0x0157
        L_0x0131:
            java.lang.Integer r0 = r9.getViewType()
            if (r0 != 0) goto L_0x0138
            goto L_0x0157
        L_0x0138:
            int r0 = r0.intValue()
            if (r0 != r3) goto L_0x0157
            java.lang.String r0 = "Hotels"
            r8.a((java.lang.String) r0)
            android.content.Context r0 = r7.f28749g
            if (r0 != 0) goto L_0x014a
            kotlin.g.b.k.a()
        L_0x014a:
            android.content.res.Resources r0 = r0.getResources()
            int r1 = net.one97.paytm.hotels2.R.drawable.h4_ic_noimg_icon
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.f.a((android.content.res.Resources) r0, (int) r1, (android.content.res.Resources.Theme) r4)
            r8.a((android.graphics.drawable.Drawable) r0)
        L_0x0157:
            android.view.View r8 = r8.getRoot()
            net.one97.paytm.hotel4.view.a.v$b r0 = new net.one97.paytm.hotel4.view.a.v$b
            r0.<init>(r7, r9, r10)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
        L_0x0165:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.a.v.a(androidx.databinding.ViewDataBinding, java.lang.Object, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(a aVar, Context context) {
        super(new h.c<AutoSearchDataItem>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                AutoSearchDataItem autoSearchDataItem = (AutoSearchDataItem) obj;
                AutoSearchDataItem autoSearchDataItem2 = (AutoSearchDataItem) obj2;
                k.c(autoSearchDataItem, "oldItemSRP");
                k.c(autoSearchDataItem2, "newItemSRP");
                return k.a((Object) autoSearchDataItem, (Object) autoSearchDataItem2);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                AutoSearchDataItem autoSearchDataItem = (AutoSearchDataItem) obj;
                AutoSearchDataItem autoSearchDataItem2 = (AutoSearchDataItem) obj2;
                k.c(autoSearchDataItem, "oldItemSRP");
                k.c(autoSearchDataItem2, "newItemSRP");
                return k.a((Object) autoSearchDataItem, (Object) autoSearchDataItem2);
            }
        });
        k.c(context, "cntxt");
        this.f28751i = aVar;
        this.j = context;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28749g = this.j;
        this.f28745c = this.f28751i;
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_auto_search_item, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f28752a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AutoSearchDataItem f28753b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f28754c;

        b(v vVar, AutoSearchDataItem autoSearchDataItem, int i2) {
            this.f28752a = vVar;
            this.f28753b = autoSearchDataItem;
            this.f28754c = i2;
        }

        public final void onClick(View view) {
            a aVar = this.f28752a.f28745c;
            if (aVar == null) {
                k.a();
            }
            aVar.autoSuggestOnItemClick(this.f28753b, this.f28754c, String.valueOf(this.f28752a.f28744b));
        }
    }
}
