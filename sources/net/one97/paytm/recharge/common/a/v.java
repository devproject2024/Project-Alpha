package net.one97.paytm.recharge.common.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.common.d.b;
import net.one97.paytm.recharge.common.d.f;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;

public final class v extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<CJRBrowsePlanProductList> f60697a;

    /* renamed from: b  reason: collision with root package name */
    private final int f60698b;

    /* renamed from: c  reason: collision with root package name */
    private final int f60699c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final w.b f60700d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f60701e;

    /* renamed from: f  reason: collision with root package name */
    private final f.a f60702f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f60703g;

    /* renamed from: h  reason: collision with root package name */
    private final String f60704h;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRBrowsePlanProductList cJRBrowsePlanProductList = this.f60697a.get(i2);
        k.a((Object) cJRBrowsePlanProductList, "productList[position]");
        aVar.a(cJRBrowsePlanProductList);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a aVar;
        Object obj;
        Object obj2;
        k.c(viewGroup, "viewGroup");
        if (i2 == this.f60698b) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v3_browse_plan_adapter_layout_data_and_validity, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(view…lidity, viewGroup, false)");
            w.b bVar = this.f60700d;
            List list = this.f60697a;
            f.a aVar2 = this.f60702f;
            Object obj3 = this.f60703g;
            if (obj3 == null) {
                obj2 = "";
            } else {
                obj2 = obj3;
            }
            aVar = new f(inflate, bVar, list, aVar2, obj2, this.f60704h);
        } else {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v3_browse_plan_adapter_layout, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(view…layout, viewGroup, false)");
            w.b bVar2 = this.f60700d;
            List list2 = this.f60697a;
            Object obj4 = this.f60703g;
            if (obj4 == null) {
                obj = "";
            } else {
                obj = obj4;
            }
            aVar = new b(inflate2, bVar2, list2, obj, this.f60704h);
        }
        return aVar;
    }

    public v(ArrayList<CJRBrowsePlanProductList> arrayList, w.b bVar, boolean z, f.a aVar, Object obj, String str) {
        k.c(arrayList, "productList");
        k.c(bVar, "itemClickListner");
        this.f60697a = arrayList;
        this.f60700d = bVar;
        this.f60701e = z;
        this.f60702f = aVar;
        this.f60703g = obj;
        this.f60704h = str;
    }

    public final int getItemCount() {
        return this.f60697a.size();
    }

    public final int getItemViewType(int i2) {
        String productType;
        CJRBrowsePlanProductList cJRBrowsePlanProductList = this.f60697a.get(i2);
        k.a((Object) cJRBrowsePlanProductList, "productList[position]");
        CJRBrowsePlanProductList cJRBrowsePlanProductList2 = cJRBrowsePlanProductList;
        boolean z = false;
        boolean z2 = cJRBrowsePlanProductList2.getData() == null || TextUtils.isEmpty(cJRBrowsePlanProductList2.getData()) || p.a(cJRBrowsePlanProductList2.getData(), "NA", true);
        if (cJRBrowsePlanProductList2.getValidity() == null || TextUtils.isEmpty(cJRBrowsePlanProductList2.getValidity()) || p.a(cJRBrowsePlanProductList2.getValidity(), "NA", true)) {
            z = true;
        }
        if (this.f60701e || (z2 && z && ((productType = cJRBrowsePlanProductList2.getProductType()) == null || !p.a(productType, "topup", true)))) {
            return this.f60699c;
        }
        return this.f60698b;
    }

    public static abstract class a extends RecyclerView.v {
        public abstract void a(CJRBrowsePlanProductList cJRBrowsePlanProductList);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}
