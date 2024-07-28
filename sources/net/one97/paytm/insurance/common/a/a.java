package net.one97.paytm.insurance.common.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.widgets.g;
import net.one97.paytm.i.f;
import net.one97.paytm.insurance.R;
import net.one97.paytm.m;

public final class a extends f implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final C0191a f13991c = new C0191a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    Dialog f13992a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.insurance.H5.b f13993b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CJROrderSummary f13994d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<? extends Object> f13995e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.a<?> f13996f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f13997g;

    /* renamed from: net.one97.paytm.insurance.common.a.a$a  reason: collision with other inner class name */
    public static final class C0191a {
        private C0191a() {
        }

        public /* synthetic */ C0191a(byte b2) {
            this();
        }

        public static a a(CJROrderSummary cJROrderSummary) {
            k.c(cJROrderSummary, "orderSummary");
            a aVar = new a();
            aVar.f13994d = cJROrderSummary;
            aVar.f13995e = aVar.a();
            return aVar;
        }
    }

    public final List<Object> a() {
        ArrayList<CJROrderedCart> orderedCartList;
        List<? extends Object> list = this.f13995e;
        if (list != null) {
            ArrayList arrayList = (ArrayList) list;
            arrayList.clear();
            CJROrderSummary cJROrderSummary = this.f13994d;
            if (!(cJROrderSummary == null || (orderedCartList = cJROrderSummary.getOrderedCartList()) == null)) {
                for (CJROrderedCart cJROrderedCart : orderedCartList) {
                    k.a((Object) cJROrderedCart, "it");
                    arrayList.add(cJROrderedCart.getName());
                }
            }
            return this.f13995e;
        }
        throw new u("null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>");
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.InsCustomBottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.insurance_need_help_bottomsheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        ImageView imageView = (ImageView) view.findViewById(R.id.close_button);
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        this.f13996f = new d(this);
        if (recyclerView != null) {
            recyclerView.setAdapter(this.f13996f);
        }
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        Drawable a2 = androidx.core.content.b.a(context, R.drawable.ins_list_divider);
        if (a2 != null) {
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            a2.setColorFilter(androidx.core.content.b.c(context2, R.color.ins_color_f3f7f8), PorterDuff.Mode.SRC_IN);
        }
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new g(a2, true));
        }
    }

    public static final class d extends RecyclerView.a<b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f14003a;

        d(a aVar) {
            this.f14003a = aVar;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            b bVar = (b) vVar;
            k.c(bVar, "holder");
            bVar.f13998a.setText(this.f14003a.f13995e.get(i2).toString());
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            a aVar = this.f14003a;
            View inflate = LayoutInflater.from(aVar.getContext()).inflate(R.layout.ins_need_help_option_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…tion_item, parent, false)");
            return new b(aVar, inflate);
        }

        public final int getItemCount() {
            return this.f14003a.f13995e.size();
        }
    }

    public static final class c implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f14002a;

        c(a aVar) {
            this.f14002a = aVar;
        }

        public final void dismiss() {
            Dialog dialog;
            a aVar = this.f14002a;
            try {
                if (aVar.f13992a != null) {
                    Dialog dialog2 = aVar.f13992a;
                    Boolean valueOf = dialog2 != null ? Boolean.valueOf(dialog2.isShowing()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    if (valueOf.booleanValue() && (dialog = aVar.f13992a) != null) {
                        dialog.dismiss();
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }

        public final void show() {
            Dialog dialog;
            a aVar = this.f14002a;
            try {
                if (aVar.f13992a == null) {
                    aVar.f13992a = net.one97.paytm.insurance.b.c.a().getWalletStyleProgressDialog(aVar.getActivity());
                }
                if (aVar.f13992a != null) {
                    Dialog dialog2 = aVar.f13992a;
                    Boolean valueOf = dialog2 != null ? Boolean.valueOf(dialog2.isShowing()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    if (!valueOf.booleanValue() && (dialog = aVar.f13992a) != null) {
                        dialog.show();
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(Context context, Integer num) {
        net.one97.paytm.insurance.a.a a2 = net.one97.paytm.insurance.b.c.a();
        CJROrderSummary cJROrderSummary = this.f13994d;
        m cVar = new c(this);
        if (num == null) {
            k.a();
        }
        a2.invokeCstModule(context, cJROrderSummary, cVar, num);
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        net.one97.paytm.insurance.H5.b bVar = this.f13993b;
        if (bVar != null && bVar != null) {
            bVar.a();
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.close_button;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismiss();
            net.one97.paytm.insurance.H5.b bVar = this.f13993b;
            if (bVar != null && bVar != null) {
                bVar.a();
            }
        }
    }

    public final void a(Context context, j jVar) {
        if (context != null) {
            if (this.f13995e.size() == 1) {
                net.one97.paytm.insurance.H5.b bVar = this.f13993b;
                if (!(bVar == null || bVar == null)) {
                    bVar.a();
                }
                a(context, (Integer) 0);
                return;
            }
            RecyclerView.a<?> aVar = this.f13996f;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            if (!isAdded() && !isVisible() && jVar != null) {
                String tag = getTag();
                if (tag == null) {
                    tag = a.class.getSimpleName();
                }
                super.show(jVar, tag);
            }
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f13998a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f13999b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageView f14000c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f13999b = aVar;
            View findViewById = view.findViewById(R.id.icon);
            if (findViewById != null) {
                this.f14000c = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.option);
                if (findViewById2 != null) {
                    this.f13998a = (TextView) findViewById2;
                    this.f14000c.setVisibility(8);
                    view.setOnClickListener(new View.OnClickListener(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ b f14001a;

                        {
                            this.f14001a = r1;
                        }

                        public final void onClick(View view) {
                            this.f14001a.f13999b.a(this.f14001a.f13999b.getContext(), Integer.valueOf(this.f14001a.getAdapterPosition()));
                        }
                    });
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f13997g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
