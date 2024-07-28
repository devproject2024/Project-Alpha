package net.one97.paytm.recharge.mobile.b;

import android.content.Context;
import android.view.View;
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

public final class b extends a implements q {

    /* renamed from: d  reason: collision with root package name */
    private final SwipeLayoutHelperV8 f63685d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f63686e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f63687f;

    /* renamed from: net.one97.paytm.recharge.mobile.b.b$b  reason: collision with other inner class name */
    static final class C1241b<T> implements g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final C1241b f63695a = new C1241b();

        C1241b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class c implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f63696a = new c();

        c() {
        }

        public final void run() {
        }
    }

    public final void a(boolean z) {
    }

    static final class a<T> implements g<List<? extends CJRAutomaticSubscriptionItemModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63692a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f63693b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRFrequentOrder f63694c;

        a(b bVar, int i2, CJRFrequentOrder cJRFrequentOrder) {
            this.f63692a = bVar;
            this.f63693b = i2;
            this.f63694c = cJRFrequentOrder;
        }

        public final /* synthetic */ void accept(Object obj) {
            List list = (List) obj;
            b bVar = this.f63692a;
            CJRFrequentOrder cJRFrequentOrder = this.f63694c;
            k.a((Object) list, "it");
            bVar.a(cJRFrequentOrder, list, this.f63692a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, final CJRRecentOrderV8.a aVar) {
        super(view, aVar);
        k.c(view, "itemView");
        k.c(aVar, "options");
        View findViewById = view.findViewById(R.id.parent_layout);
        if (findViewById != null) {
            this.f63685d = (SwipeLayoutHelperV8) findViewById;
            View findViewById2 = view.findViewById(R.id.set_up_automatic);
            if (findViewById2 != null) {
                this.f63686e = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.delete_tv_recharge);
                if (findViewById3 != null) {
                    this.f63687f = (TextView) findViewById3;
                    this.f63687f.setOnClickListener(new View.OnClickListener(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ b f63688a;

                        {
                            this.f63688a = r1;
                        }

                        public final void onClick(View view) {
                            CJRFrequentOrder cJRFrequentOrder;
                            p.a aVar;
                            e eVar = e.INSTANCE;
                            k.a((Object) view, "it");
                            Context context = view.getContext();
                            k.a((Object) context, "it.context");
                            if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && (cJRFrequentOrder = this.f63688a.f63677c) != null && (aVar = aVar.f61927e) != null) {
                                aVar.a(cJRFrequentOrder, this.f63688a.getAdapterPosition());
                            }
                        }
                    });
                    this.f63686e.setOnClickListener(new View.OnClickListener(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ b f63690a;

                        {
                            this.f63690a = r1;
                        }

                        public final void onClick(View view) {
                            p.a aVar;
                            e eVar = e.INSTANCE;
                            k.a((Object) view, "it");
                            Context context = view.getContext();
                            k.a((Object) context, "it.context");
                            if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && this.f63690a.f63677c != null) {
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
                                        CJRFrequentOrder cJRFrequentOrder = this.f63690a.f63677c;
                                        if (cJRFrequentOrder == null) {
                                            k.a();
                                        }
                                        aVar2.b(cJRFrequentOrder, this.f63690a.getAdapterPosition());
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
                                    CJRFrequentOrder cJRFrequentOrder2 = this.f63690a.f63677c;
                                    if (cJRFrequentOrder2 == null) {
                                        k.a();
                                    }
                                    aVar.a(cJRFrequentOrder2, cJRAutomaticSubscriptionItemModel, this.f63690a.getAdapterPosition());
                                }
                            }
                        }
                    });
                    a(this.f63685d);
                    return;
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
        final /* synthetic */ b f63697a;

        d(b bVar) {
            this.f63697a = bVar;
        }

        public final void onClick(View view) {
            CJRFrequentOrder cJRFrequentOrder;
            p.a aVar;
            e eVar = e.INSTANCE;
            k.a((Object) view, "it");
            Context context = view.getContext();
            k.a((Object) context, "it.context");
            if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && (cJRFrequentOrder = this.f63697a.f63677c) != null && (aVar = this.f63697a.f60653b.f61927e) != null) {
                aVar.c(cJRFrequentOrder, this.f63697a.getAdapterPosition());
            }
        }
    }

    public final void a(int i2, CJRFrequentOrder cJRFrequentOrder) {
        io.reactivex.rxjava3.j.c<List<CJRAutomaticSubscriptionItemModel>> f2;
        k.c(cJRFrequentOrder, "recent");
        super.a(i2, cJRFrequentOrder);
        this.f63685d.b(false);
        bj bjVar = this.f60653b.k;
        bj bjVar2 = this.f60653b.k;
        if (bjVar2 != null) {
            SwipeLayoutHelperV8 swipeLayoutHelperV8 = this.f63685d;
            StringBuilder sb = new StringBuilder();
            sb.append(getAdapterPosition());
            bjVar2.a(swipeLayoutHelperV8, sb.toString());
        }
        this.f63686e.setVisibility(8);
        r rVar = this.f60653b.p;
        if (rVar != null && (f2 = rVar.f()) != null) {
            f2.subscribe(new a(this, i2, cJRFrequentOrder), C1241b.f63695a, c.f63696a);
        }
    }

    public final void a() {
        this.f63685d.b(false);
        this.f63685d.setLockDrag(true);
    }

    public final void b() {
        TextView textView = this.f63686e;
        textView.setText(textView.getResources().getString(R.string.recent_action_setup_automatic));
        HashMap hashMap = new HashMap();
        hashMap.put("tag.set.automatic.exists", Boolean.FALSE);
        this.f63686e.setTag(hashMap);
        this.f63686e.setVisibility(0);
        this.f63685d.setLockDrag(false);
    }

    public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        TextView textView = this.f63686e;
        textView.setText(textView.getResources().getString(R.string.recent_action_manage_automatic));
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("tag.set.automatic.exists", Boolean.TRUE);
        map.put("subscription_item_model", cJRAutomaticSubscriptionItemModel);
        this.f63686e.setTag(hashMap);
        this.f63686e.setVisibility(0);
        this.f63685d.setLockDrag(false);
    }
}
