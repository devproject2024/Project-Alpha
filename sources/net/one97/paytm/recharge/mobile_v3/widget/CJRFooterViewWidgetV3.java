package net.one97.paytm.recharge.mobile_v3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.i;
import net.one97.paytm.recharge.common.e.g;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.mobile_v3.c.b;
import net.one97.paytm.recharge.mobile_v3.model.CJRFooterRecyclerItemModelV3;

public final class CJRFooterViewWidgetV3 extends LinearLayout implements g<b> {

    /* renamed from: a  reason: collision with root package name */
    private Object f63947a;

    /* renamed from: b  reason: collision with root package name */
    private String f63948b = "";

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRFooterRecyclerItemModelV3> f63949c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private HashMap f63950d;

    private View b(int i2) {
        if (this.f63950d == null) {
            this.f63950d = new HashMap();
        }
        View view = (View) this.f63950d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f63950d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final long c_(int i2) {
        return (long) i2;
    }

    public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v3_footer_view_recycler_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…cler_item, parent, false)");
        return new b(inflate);
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        boolean z = true;
        if (i2 != getItemCount() - 1) {
            z = false;
        }
        CJRFooterRecyclerItemModelV3 cJRFooterRecyclerItemModelV3 = this.f63949c.get(i2);
        k.a((Object) cJRFooterRecyclerItemModelV3, "itemList[position]");
        CJRFooterRecyclerItemModelV3 cJRFooterRecyclerItemModelV32 = cJRFooterRecyclerItemModelV3;
        Object obj = this.f63947a;
        if (obj == null) {
            obj = "";
        }
        k.c(cJRFooterRecyclerItemModelV32, "item");
        k.c(obj, "eventCategory");
        TextView textView = bVar.f63890b;
        if (textView != null) {
            String title = cJRFooterRecyclerItemModelV32.getTitle();
            textView.setText(title != null ? title : "");
        }
        if (cJRFooterRecyclerItemModelV32.getIconResourceId() != null) {
            ImageView imageView = bVar.f63889a;
            if (imageView != null) {
                Integer iconResourceId = cJRFooterRecyclerItemModelV32.getIconResourceId();
                if (iconResourceId == null) {
                    k.a();
                }
                imageView.setImageResource(iconResourceId.intValue());
            }
            ImageView imageView2 = bVar.f63889a;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        } else {
            ImageView imageView3 = bVar.f63889a;
            if (imageView3 != null) {
                imageView3.setVisibility(4);
            }
        }
        if (z) {
            View view = bVar.f63891c;
            if (view != null) {
                view.setVisibility(4);
            }
        } else {
            View view2 = bVar.f63891c;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        View view3 = bVar.itemView;
        k.a((Object) view3, "itemView");
        view3.setTag(cJRFooterRecyclerItemModelV32);
        bVar.itemView.setOnClickListener(bVar);
        bVar.f63892d = obj;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRFooterViewWidgetV3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.v3_footer_view, this, true);
        a();
        RecyclerView recyclerView = (RecyclerView) b(R.id.recycler_view);
        k.a((Object) recyclerView, "recycler_view");
        recyclerView.setAdapter(new i(this));
    }

    private final void a() {
        this.f63949c.clear();
        az azVar = az.f61525a;
        if (az.a(getContext(), this.f63948b, "isScratchCardFooterItemVisible")) {
            String string = getContext().getString(R.string.recharge_footer_item_scratch_cards_and_offers);
            Integer valueOf = Integer.valueOf(R.drawable.v3_menu_icon_cash_back);
            c cVar = c.f62654a;
            this.f63949c.add(new CJRFooterRecyclerItemModelV3(string, valueOf, c.bD(), b.a.SCRATCH_CARD));
        }
        az azVar2 = az.f61525a;
        if (az.a(getContext(), this.f63948b, "isSetupAutomaticPaymentsVisible")) {
            String string2 = getContext().getString(R.string.recharge_footer_item_setup_automatic_payments);
            Integer valueOf2 = Integer.valueOf(R.drawable.v3_menu_icon_setup_automatic);
            c cVar2 = c.f62654a;
            this.f63949c.add(new CJRFooterRecyclerItemModelV3(string2, valueOf2, c.bF(), b.a.AUTO_PAY));
        }
        az azVar3 = az.f61525a;
        if (az.a(getContext(), this.f63948b, "isFreqAskedQuestVisible")) {
            String string3 = getContext().getString(R.string.recharge_footer_item_frequently_asked_questions);
            Integer valueOf3 = Integer.valueOf(R.drawable.v3_menu_icon_faq);
            c cVar3 = c.f62654a;
            this.f63949c.add(new CJRFooterRecyclerItemModelV3(string3, valueOf3, c.bE(), b.a.FAQ));
        }
        az azVar4 = az.f61525a;
        if (az.a(getContext(), this.f63948b, "isHelpAndSupportVisible")) {
            String string4 = getContext().getString(R.string.recharge_footer_item_help_and_support);
            Integer valueOf4 = Integer.valueOf(R.drawable.v3_menu_icon_help);
            c cVar4 = c.f62654a;
            this.f63949c.add(new CJRFooterRecyclerItemModelV3(string4, valueOf4, c.bC(), b.a.SUPPORT));
        }
    }

    public final int getItemCount() {
        return this.f63949c.size();
    }

    public final void setEventCategory(Object obj) {
        k.c(obj, "category");
        this.f63947a = obj;
    }

    public final void setCategory(String str) {
        k.c(str, "category");
        this.f63948b = str;
        a();
        RecyclerView recyclerView = (RecyclerView) b(R.id.recycler_view);
        k.a((Object) recyclerView, "recycler_view");
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
