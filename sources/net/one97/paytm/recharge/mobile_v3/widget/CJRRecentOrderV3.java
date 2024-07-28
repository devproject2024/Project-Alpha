package net.one97.paytm.recharge.mobile_v3.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.bj;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.common.widget.CJRBaseHeaderListLayoutV8;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;

public final class CJRRecentOrderV3 extends CJRBaseHeaderListLayoutV8 {

    /* renamed from: e  reason: collision with root package name */
    private p f63961e;

    /* renamed from: f  reason: collision with root package name */
    private Context f63962f;

    /* renamed from: g  reason: collision with root package name */
    private final CJRRecentOrderV8.a f63963g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f63964h;

    public final View b(int i2) {
        if (this.f63964h == null) {
            this.f63964h = new HashMap();
        }
        View view = (View) this.f63964h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f63964h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final Context getActivity() {
        return this.f63962f;
    }

    public final CJRRecentOrderV8.a getOptions() {
        return this.f63963g;
    }

    public final void setActivity(Context context) {
        this.f63962f = context;
    }

    public final int getLayoutResId() {
        return R.layout.v3_content_promos_view;
    }

    public final void b(String str) {
        if (CJRRecentOrderV8.a.a(this.f63963g.m).ordinal() == CJRRecentOrderV8.b.MOBILE_V3.ordinal()) {
            TextView textView = (TextView) b(R.id.txt_viewall);
            k.a((Object) textView, "txt_viewall");
            textView.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                RelativeLayout relativeLayout = (RelativeLayout) b(R.id.view_all_container_mobile);
                k.a((Object) relativeLayout, "view_all_container_mobile");
                relativeLayout.setVisibility(0);
                ((TextView) b(R.id.view_all_tv_mobile)).setOnClickListener(new a(this));
                return;
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) b(R.id.view_all_container_mobile);
            k.a((Object) relativeLayout2, "view_all_container_mobile");
            relativeLayout2.setVisibility(8);
            return;
        }
        super.b(str);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRRecentOrderV3 f63965a;

        a(CJRRecentOrderV3 cJRRecentOrderV3) {
            this.f63965a = cJRRecentOrderV3;
        }

        public final void onClick(View view) {
            p.a aVar = this.f63965a.getOptions().f61927e;
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    public final void a(String str) {
        if (CJRRecentOrderV8.a.a(this.f63963g.m).ordinal() == CJRRecentOrderV8.b.MOBILE_V3.ordinal()) {
            TextView textView = (TextView) b(R.id.txt_title);
            k.a((Object) textView, "txt_title");
            textView.setVisibility(8);
            if (str == null || !g.c(str)) {
                TextView textView2 = (TextView) b(R.id.txt_mobile_title);
                k.a((Object) textView2, "txt_mobile_title");
                textView2.setVisibility(8);
                return;
            }
            TextView textView3 = (TextView) b(R.id.txt_mobile_title);
            k.a((Object) textView3, "txt_mobile_title");
            textView3.setVisibility(0);
            return;
        }
        super.a(str);
    }

    public final void getNotifyAdapterDataChange() {
        boolean z;
        if (kotlin.m.p.a(this.f63963g.f61926d, "", false)) {
            a("");
        } else if (!kotlin.m.p.a(this.f63963g.f61926d, "", false)) {
            a(this.f63963g.f61926d);
        }
        getOrNotifyTitleWithViewAll();
        if (this.f63963g.l) {
            a(R.color.color_b8c2cb);
            setTitleBackgroundTransparent();
        }
        this.f63961e = new p(this.f63963g);
        RecyclerView recyclerView = (RecyclerView) b(R.id.recycler_view);
        k.a((Object) recyclerView, "recycler_view");
        recyclerView.setAdapter(this.f63961e);
        if (this.f63963g.n) {
            try {
                ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_lyt);
                if (shimmerFrameLayout != null) {
                    shimmerFrameLayout.a();
                }
            } catch (Exception unused) {
            }
        }
        if (this.f63962f != null) {
            String str = this.f63963g.o;
            if (str == null || !g.c(str)) {
                z = true;
            } else {
                ax.a aVar = ax.f61521a;
                Context context = getContext();
                k.a((Object) context, "context");
                Context applicationContext = context.getApplicationContext();
                k.a((Object) applicationContext, "context.applicationContext");
                com.paytm.b.a.a a2 = ax.a.a(applicationContext);
                String str2 = this.f63963g.o;
                if (str2 == null) {
                    k.a();
                }
                z = a2.b(str2, true, true);
            }
        } else {
            z = false;
        }
        if (z && this.f63963g.f61930h) {
            bj bjVar = new bj();
            bjVar.a();
            this.f63963g.a(bjVar);
            p pVar = this.f63961e;
            if (pVar == null) {
                k.a();
            }
            pVar.a();
            String str3 = this.f63963g.o;
            if ((str3 == null || g.c(str3)) && this.f63962f != null) {
                ax.a aVar2 = ax.f61521a;
                Context context2 = getContext();
                k.a((Object) context2, "context");
                Context applicationContext2 = context2.getApplicationContext();
                k.a((Object) applicationContext2, "context.applicationContext");
                com.paytm.b.a.a a3 = ax.a.a(applicationContext2);
                String str4 = this.f63963g.o;
                if (str4 != null) {
                    a3.a(str4, false, true);
                }
            }
        }
    }

    public final void getOrNotifyTitleWithViewAll() {
        List<CJRFrequentOrder> list = this.f63963g.f61931i;
        if (list == null || !list.isEmpty()) {
            List<CJRFrequentOrder> list2 = this.f63963g.f61931i;
            if ((list2 != null ? list2.size() : 0) > 3) {
                String string = getContext().getString(R.string.action_view_all);
                k.a((Object) string, "context.getString(R.string.action_view_all)");
                p pVar = this.f63961e;
                if (pVar != null && pVar.f60648a) {
                    string = getContext().getString(R.string.action_view_less);
                    k.a((Object) string, "context.getString(R.string.action_view_less)");
                }
                b(string);
                return;
            }
        } else {
            a("");
        }
        b("");
    }

    public final int getShimmerLayoutId() {
        return R.layout.content_shimmer_contact_item_v8;
    }

    public final boolean d() {
        boolean d2 = super.d();
        p.a aVar = this.f63963g.f61927e;
        if (aVar != null) {
            aVar.f();
        }
        if (d2) {
            p pVar = this.f63961e;
            if (pVar != null) {
                pVar.b();
            }
        } else {
            p pVar2 = this.f63961e;
            if (pVar2 != null) {
                pVar2.c();
            }
        }
        return d2;
    }

    public final RecyclerView.h a(CJRBaseHeaderListLayoutV8.a aVar) {
        k.c(aVar, "mBaseOption");
        if (((aVar instanceof CJRRecentOrderV8.a) && CJRRecentOrderV8.a.a(((CJRRecentOrderV8.a) aVar).m).ordinal() == CJRRecentOrderV8.b.MOBILE_V3.ordinal()) || CJRRecentOrderV8.a.a(this.f63963g.m).ordinal() == CJRRecentOrderV8.b.MOBILE_V3.ordinal()) {
            return null;
        }
        Context context = getContext();
        k.a((Object) context, "context");
        return new net.one97.paytm.recharge.common.utils.p(context, aVar.f61848a, false);
    }
}
