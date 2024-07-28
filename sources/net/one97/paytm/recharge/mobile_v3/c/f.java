package net.one97.paytm.recharge.mobile_v3.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.reactivex.rxjava3.d.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.e.q;
import net.one97.paytm.recharge.common.e.r;
import net.one97.paytm.recharge.common.utils.SwipeLayoutHelperV8;
import net.one97.paytm.recharge.common.utils.bj;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.widgets.c.e;

public final class f extends d implements q {

    /* renamed from: e  reason: collision with root package name */
    private final SwipeLayoutHelperV8 f63925e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f63926f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f63927g;

    /* renamed from: h  reason: collision with root package name */
    private final LinearLayout f63928h;

    static final class b<T> implements g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f63936a = new b();

        b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class c implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f63937a = new c();

        c() {
        }

        public final void run() {
        }
    }

    public final void a(boolean z) {
    }

    static final class a<T> implements g<List<? extends CJRAutomaticSubscriptionItemModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63933a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f63934b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRFrequentOrder f63935c;

        a(f fVar, int i2, CJRFrequentOrder cJRFrequentOrder) {
            this.f63933a = fVar;
            this.f63934b = i2;
            this.f63935c = cJRFrequentOrder;
        }

        public final /* synthetic */ void accept(Object obj) {
            List list = (List) obj;
            f fVar = this.f63933a;
            CJRFrequentOrder cJRFrequentOrder = this.f63935c;
            k.a((Object) list, "it");
            fVar.a(cJRFrequentOrder, list, this.f63933a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view, final CJRRecentOrderV8.a aVar) {
        super(view, aVar);
        k.c(view, "itemView");
        k.c(aVar, "options");
        View findViewById = view.findViewById(R.id.parent_layout);
        if (findViewById != null) {
            this.f63925e = (SwipeLayoutHelperV8) findViewById;
            View findViewById2 = view.findViewById(R.id.set_up_automatic);
            if (findViewById2 != null) {
                this.f63926f = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.delete_tv_recharge);
                if (findViewById3 != null) {
                    this.f63927g = (TextView) findViewById3;
                    View findViewById4 = view.findViewById(R.id.menuOptionsLL);
                    if (findViewById4 != null) {
                        this.f63928h = (LinearLayout) findViewById4;
                        this.f63927g.setOnClickListener(new View.OnClickListener(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ f f63929a;

                            {
                                this.f63929a = r1;
                            }

                            public final void onClick(View view) {
                                CJRFrequentOrder cJRFrequentOrder;
                                p.a aVar;
                                e eVar = e.INSTANCE;
                                k.a((Object) view, "it");
                                Context context = view.getContext();
                                k.a((Object) context, "it.context");
                                if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && (cJRFrequentOrder = this.f63929a.f63901d) != null && (aVar = aVar.f61927e) != null) {
                                    aVar.d(cJRFrequentOrder, this.f63929a.getAdapterPosition());
                                }
                            }
                        });
                        this.f63926f.setOnClickListener(new View.OnClickListener(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ f f63931a;

                            {
                                this.f63931a = r1;
                            }

                            public final void onClick(View view) {
                                p.a aVar;
                                e eVar = e.INSTANCE;
                                k.a((Object) view, "it");
                                Context context = view.getContext();
                                k.a((Object) context, "it.context");
                                if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && this.f63931a.f63901d != null) {
                                    Object tag = view.getTag();
                                    if (!(tag instanceof HashMap)) {
                                        tag = null;
                                    }
                                    HashMap hashMap = (HashMap) tag;
                                    Object obj = hashMap != null ? hashMap.get("tag.set.automatic.exists") : null;
                                    if (!(obj instanceof Boolean)) {
                                        obj = null;
                                    }
                                    if (!k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                                        p.a aVar2 = aVar.f61927e;
                                        if (aVar2 != null) {
                                            CJRFrequentOrder cJRFrequentOrder = this.f63931a.f63901d;
                                            if (cJRFrequentOrder == null) {
                                                k.a();
                                            }
                                            aVar2.b(cJRFrequentOrder, this.f63931a.getAdapterPosition());
                                            return;
                                        }
                                        return;
                                    }
                                    Object obj2 = hashMap.get("subscription_item_model");
                                    if (!(obj2 instanceof CJRAutomaticSubscriptionItemModel)) {
                                        obj2 = null;
                                    }
                                    CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = (CJRAutomaticSubscriptionItemModel) obj2;
                                    if (cJRAutomaticSubscriptionItemModel != null && (aVar = aVar.f61927e) != null) {
                                        CJRFrequentOrder cJRFrequentOrder2 = this.f63931a.f63901d;
                                        if (cJRFrequentOrder2 == null) {
                                            k.a();
                                        }
                                        aVar.a(cJRFrequentOrder2, cJRAutomaticSubscriptionItemModel, this.f63931a.getAdapterPosition());
                                    }
                                }
                            }
                        });
                        a(this.f63925e);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.utils.SwipeLayoutHelperV8");
    }

    /* access modifiers changed from: protected */
    public final void c() {
        this.itemView.findViewById(R.id.swipe_top_container).setOnClickListener(new d(this));
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63938a;

        d(f fVar) {
            this.f63938a = fVar;
        }

        public final void onClick(View view) {
            CJRFrequentOrder cJRFrequentOrder;
            e eVar = e.INSTANCE;
            k.a((Object) view, "it");
            Context context = view.getContext();
            k.a((Object) context, "it.context");
            if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && (cJRFrequentOrder = this.f63938a.f63901d) != null) {
                this.f63938a.d();
                p.a aVar = this.f63938a.f60653b.f61927e;
                if (aVar != null) {
                    aVar.c(cJRFrequentOrder, this.f63938a.getAdapterPosition());
                }
            }
        }
    }

    public final void a(int i2, CJRFrequentOrder cJRFrequentOrder) {
        io.reactivex.rxjava3.j.c<List<CJRAutomaticSubscriptionItemModel>> f2;
        k.c(cJRFrequentOrder, "recent");
        super.a(i2, cJRFrequentOrder);
        this.f63925e.b(false);
        this.f63925e.a();
        bj bjVar = this.f60653b.k;
        bj bjVar2 = this.f60653b.k;
        if (bjVar2 != null) {
            SwipeLayoutHelperV8 swipeLayoutHelperV8 = this.f63925e;
            StringBuilder sb = new StringBuilder();
            sb.append(getAdapterPosition());
            bjVar2.a(swipeLayoutHelperV8, sb.toString());
        }
        this.f63926f.setVisibility(8);
        r rVar = this.f60653b.p;
        if (!(rVar == null || (f2 = rVar.f()) == null)) {
            f2.subscribe(new a(this, i2, cJRFrequentOrder), b.f63936a, c.f63937a);
        }
        ViewGroup.LayoutParams layoutParams = this.f63928h.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -2;
        this.f63928h.setLayoutParams(layoutParams);
    }

    public final void a() {
        this.f63925e.b(false);
        this.f63925e.setLockDrag(true);
    }

    public final void b() {
        TextView textView = this.f63926f;
        textView.setText(textView.getResources().getString(R.string.recent_action_setup_automatic));
        HashMap hashMap = new HashMap();
        hashMap.put("tag.set.automatic.exists", Boolean.FALSE);
        this.f63926f.setTag(hashMap);
        this.f63926f.setVisibility(0);
        this.f63925e.setLockDrag(false);
    }

    public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        TextView textView = this.f63926f;
        textView.setText(textView.getResources().getString(R.string.recent_action_manage_automatic));
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("tag.set.automatic.exists", Boolean.TRUE);
        map.put("subscription_item_model", cJRAutomaticSubscriptionItemModel);
        this.f63926f.setTag(hashMap);
        this.f63926f.setVisibility(0);
        this.f63925e.setLockDrag(false);
    }
}
