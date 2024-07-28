package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.j.d;
import kotlin.j.e;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.r;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.bj;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.common.widget.CJRBaseHeaderListLayoutV8;
import net.one97.paytm.recharge.mobile_v3.d.c;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class CJRRecentOrderV8 extends CJRBaseHeaderListLayoutV8 {

    /* renamed from: e  reason: collision with root package name */
    public p f61920e;

    /* renamed from: f  reason: collision with root package name */
    public final a f61921f;

    /* renamed from: g  reason: collision with root package name */
    private Context f61922g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f61923h;

    public final View b(int i2) {
        if (this.f61923h == null) {
            this.f61923h = new HashMap();
        }
        View view = (View) this.f61923h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f61923h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final Context getActivity() {
        return this.f61922g;
    }

    public final a getOptions() {
        return this.f61921f;
    }

    public final void setActivity(Context context) {
        this.f61922g = context;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRRecentOrderV8(Context context, a aVar) {
        super(context, aVar);
        k.c(aVar, "options");
        this.f61922g = context;
        this.f61921f = aVar;
        List<CJRFrequentOrder> list = this.f61921f.f61931i;
        if ((list != null ? list.size() : 0) > 0) {
            a(this.f61921f.f61926d);
            b();
            RecyclerView recyclerView = (RecyclerView) b(R.id.recycler_view);
            k.a((Object) recyclerView, "recycler_view");
            recyclerView.setVisibility(0);
            FrameLayout frameLayout = (FrameLayout) b(R.id.no_network_container_promo);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            getNotifyAdapterDataChange();
        }
    }

    public enum b {
        MOBILE(0),
        DTH(1),
        MOBILE_V3(2);

        private b(int i2) {
        }
    }

    public final void e() {
        this.f61922g = null;
        a aVar = this.f61921f;
        aVar.f61926d = null;
        aVar.f61927e = null;
        aVar.f61929g = null;
        aVar.f61931i = null;
        aVar.j = null;
        aVar.k = null;
        aVar.p = null;
    }

    public final void getNotifyAdapterDataChange() {
        boolean z;
        if (kotlin.m.p.a(this.f61921f.f61926d, "", false)) {
            a("");
        } else if (!kotlin.m.p.a(this.f61921f.f61926d, "", false)) {
            a(this.f61921f.f61926d);
        }
        getOrNotifyTitleWithViewAll();
        if (this.f61921f.l) {
            a(R.color.color_b8c2cb);
            setTitleBackgroundTransparent();
        }
        if (a.a(this.f61921f.m).ordinal() == b.MOBILE_V3.ordinal()) {
            setTitleBackgroundColor(R.color.v3_promo_title_bg);
            a(R.color.v3_text_2);
            TextView textView = (TextView) b(R.id.txt_viewall);
            if (textView != null) {
                textView.setBackgroundResource(R.color.v3_promo_title_bg);
            }
            TextView textView2 = (TextView) b(R.id.txt_viewall);
            k.a((Object) textView2, "txt_viewall");
            textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        }
        this.f61920e = new p(this.f61921f);
        RecyclerView recyclerView = (RecyclerView) b(R.id.recycler_view);
        k.a((Object) recyclerView, "recycler_view");
        recyclerView.setAdapter(this.f61920e);
        if (this.f61921f.n) {
            try {
                ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_lyt);
                if (shimmerFrameLayout != null) {
                    shimmerFrameLayout.a();
                }
            } catch (Exception unused) {
            }
        }
        String str = this.f61921f.o;
        if (str == null || !g.c(str)) {
            z = true;
        } else {
            ax.a aVar = ax.f61521a;
            Context context = getContext();
            k.a((Object) context, "context");
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            com.paytm.b.a.a a2 = ax.a.a(applicationContext);
            String str2 = this.f61921f.o;
            if (str2 == null) {
                k.a();
            }
            z = a2.b(str2, true, true);
        }
        if (z && this.f61921f.f61930h) {
            bj bjVar = new bj();
            bjVar.a();
            this.f61921f.a(bjVar);
            p pVar = this.f61920e;
            if (pVar == null) {
                k.a();
            }
            pVar.a();
            String str3 = this.f61921f.o;
            if (str3 == null || g.c(str3)) {
                ax.a aVar2 = ax.f61521a;
                Context context2 = getContext();
                k.a((Object) context2, "context");
                Context applicationContext2 = context2.getApplicationContext();
                k.a((Object) applicationContext2, "context.applicationContext");
                com.paytm.b.a.a a3 = ax.a.a(applicationContext2);
                String str4 = this.f61921f.o;
                if (str4 != null) {
                    a3.a(str4, false, true);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        r0 = r0.getContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getOrNotifyTitleWithViewAll() {
        /*
            r5 = this;
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$a r0 = r5.f61921f
            java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r0 = r0.f61931i
            java.lang.String r1 = ""
            r2 = 1
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.isEmpty()
            if (r0 != r2) goto L_0x0013
            r5.a((java.lang.String) r1)
            return
        L_0x0013:
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$a r0 = r5.f61921f
            java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r0 = r0.f61931i
            if (r0 == 0) goto L_0x001e
            int r0 = r0.size()
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$a r3 = r5.f61921f
            int r3 = r3.f61924b
            if (r0 <= r3) goto L_0x00b8
            int r0 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r0 = r5.b(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r1 = 0
            if (r0 == 0) goto L_0x003d
            android.content.Context r0 = r0.getContext()
            if (r0 == 0) goto L_0x003d
            int r3 = net.one97.paytm.recharge.R.string.action_view_all
            java.lang.String r0 = r0.getString(r3)
            goto L_0x003e
        L_0x003d:
            r0 = r1
        L_0x003e:
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$a r3 = r5.f61921f
            java.lang.Integer r3 = r3.m
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$b r3 = net.one97.paytm.recharge.common.widget.CJRRecentOrderV8.a.a((java.lang.Integer) r3)
            int r3 = r3.ordinal()
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$b r4 = net.one97.paytm.recharge.common.widget.CJRRecentOrderV8.b.MOBILE_V3
            int r4 = r4.ordinal()
            if (r3 != r4) goto L_0x006a
            int r0 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r0 = r5.b(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            if (r0 == 0) goto L_0x0069
            android.content.Context r0 = r0.getContext()
            if (r0 == 0) goto L_0x0069
            int r3 = net.one97.paytm.recharge.R.string.v3_action_view_all
            java.lang.String r0 = r0.getString(r3)
            goto L_0x006a
        L_0x0069:
            r0 = r1
        L_0x006a:
            net.one97.paytm.recharge.common.a.p r3 = r5.f61920e
            if (r3 == 0) goto L_0x00b4
            boolean r3 = r3.f60648a
            if (r3 != r2) goto L_0x00b4
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$a r0 = r5.f61921f
            java.lang.Integer r0 = r0.m
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$b r0 = net.one97.paytm.recharge.common.widget.CJRRecentOrderV8.a.a((java.lang.Integer) r0)
            int r0 = r0.ordinal()
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$b r2 = net.one97.paytm.recharge.common.widget.CJRRecentOrderV8.b.MOBILE_V3
            int r2 = r2.ordinal()
            if (r0 != r2) goto L_0x009d
            int r0 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r0 = r5.b(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            if (r0 == 0) goto L_0x00b3
            android.content.Context r0 = r0.getContext()
            if (r0 == 0) goto L_0x00b3
            int r1 = net.one97.paytm.recharge.R.string.v3_action_view_less
            java.lang.String r1 = r0.getString(r1)
            goto L_0x00b3
        L_0x009d:
            int r0 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r0 = r5.b(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            if (r0 == 0) goto L_0x00b3
            android.content.Context r0 = r0.getContext()
            if (r0 == 0) goto L_0x00b3
            int r1 = net.one97.paytm.recharge.R.string.action_view_less
            java.lang.String r1 = r0.getString(r1)
        L_0x00b3:
            r0 = r1
        L_0x00b4:
            r5.b((java.lang.String) r0)
            return
        L_0x00b8:
            r5.b((java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CJRRecentOrderV8.getOrNotifyTitleWithViewAll():void");
    }

    public final void a(Integer num, String str) {
        RecyclerView.v vVar;
        k.c(str, "status");
        p pVar = this.f61920e;
        boolean z = false;
        d a2 = e.a(0, pVar != null ? pVar.getItemCount() : 0);
        if (num != null && a2.a(num.intValue())) {
            z = true;
        }
        if (z) {
            RecyclerView recyclerView = (RecyclerView) b(R.id.recycler_view);
            if (recyclerView != null) {
                if (num == null) {
                    k.a();
                }
                vVar = recyclerView.findViewHolderForLayoutPosition(num.intValue());
            } else {
                vVar = null;
            }
            if (vVar instanceof p.d) {
                ((p.d) vVar).a();
                int hashCode = str.hashCode();
                if (hashCode != -807981780) {
                    if (hashCode != 1640594766 || !str.equals("is_refresh_needed")) {
                        return;
                    }
                } else if (!str.equals("key_is_delete_automatic")) {
                    return;
                }
                r rVar = this.f61921f.p;
                if (rVar != null) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    rVar.c("bill_consent_notification_status", (ai) null, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.RECENT_SUBSCRIPTION_STATUS, ERROR_TYPE.UNDEFINED));
                }
            }
        }
    }

    public final int getShimmerLayoutId() {
        return R.layout.content_shimmer_contact_item_v8;
    }

    /* access modifiers changed from: protected */
    public final boolean d() {
        boolean d2 = super.d();
        p.a aVar = this.f61921f.f61927e;
        if (aVar != null) {
            aVar.f();
        }
        if (d2) {
            p pVar = this.f61920e;
            if (pVar != null) {
                pVar.b();
            }
            if (a.a(this.f61921f.m).ordinal() == b.MOBILE_V3.ordinal()) {
                ((TextView) b(R.id.txt_viewall)).setText(R.string.v3_action_view_less);
            }
        } else {
            p pVar2 = this.f61920e;
            if (pVar2 != null) {
                pVar2.c();
            }
            if (a.a(this.f61921f.m).ordinal() == b.MOBILE_V3.ordinal()) {
                ((TextView) b(R.id.txt_viewall)).setText(R.string.v3_action_view_all);
            }
        }
        return d2;
    }

    public static final class a extends CJRBaseHeaderListLayoutV8.a {

        /* renamed from: b  reason: collision with root package name */
        public int f61924b = 3;

        /* renamed from: c  reason: collision with root package name */
        public int f61925c = 10;

        /* renamed from: d  reason: collision with root package name */
        public String f61926d;

        /* renamed from: e  reason: collision with root package name */
        public p.a f61927e;

        /* renamed from: f  reason: collision with root package name */
        public p.c f61928f;

        /* renamed from: g  reason: collision with root package name */
        public p.b f61929g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f61930h;

        /* renamed from: i  reason: collision with root package name */
        public List<CJRFrequentOrder> f61931i;
        List<? extends ContactItemModel> j;
        public bj k;
        public boolean l;
        public Integer m;
        public boolean n;
        public String o;
        public r p;
        public boolean q;
        public j r;
        public c s;

        public static b a(Integer num) {
            if (num != null && num.intValue() == 0) {
                return b.MOBILE;
            }
            if (num != null && num.intValue() == 1) {
                return b.DTH;
            }
            if (num != null && num.intValue() == 2) {
                return b.MOBILE_V3;
            }
            return b.MOBILE;
        }

        public final a a(j jVar) {
            k.c(jVar, "fragmentManager");
            this.r = jVar;
            return this;
        }

        public final a a(String str) {
            k.c(str, "title");
            this.f61926d = str;
            return this;
        }

        public final a a(List<? extends CJRFrequentOrder> list) {
            List<CJRFrequentOrder> arrayList = new ArrayList<>();
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f61931i = arrayList;
            return this;
        }

        public final a a(bj bjVar) {
            k.c(bjVar, "bindHelper");
            this.k = bjVar;
            return this;
        }

        public final a a(int i2) {
            this.m = Integer.valueOf(i2);
            return this;
        }

        public final a a(r rVar) {
            k.c(rVar, "viewModel");
            this.p = rVar;
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final RecyclerView.h a(CJRBaseHeaderListLayoutV8.a aVar) {
        k.c(aVar, "mBaseOption");
        Context context = getContext();
        k.a((Object) context, "context");
        return new net.one97.paytm.recharge.common.utils.p(context, aVar.f61848a, false);
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, int i2) {
        k.c(cJRFrequentOrder, "item");
        p pVar = this.f61920e;
        if (pVar != null) {
            k.c(cJRFrequentOrder, "item");
            List<CJRFrequentOrder> list = pVar.f60649b.f61931i;
            if (list != null) {
                list.remove(cJRFrequentOrder);
            }
            pVar.notifyItemRemoved(i2);
        }
        getOrNotifyTitleWithViewAll();
    }
}
