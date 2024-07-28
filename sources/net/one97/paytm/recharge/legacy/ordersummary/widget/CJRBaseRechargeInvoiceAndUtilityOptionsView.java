package net.one97.paytm.recharge.legacy.ordersummary.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.widgets.g;
import net.one97.paytm.recharge.R;

public class CJRBaseRechargeInvoiceAndUtilityOptionsView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f63074a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f63075b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Integer> f63076c;

    /* renamed from: d  reason: collision with root package name */
    private final View.OnClickListener f63077d;

    public final List<Integer> getOptionIcons() {
        return this.f63076c;
    }

    public final List<String> getOptions() {
        return this.f63075b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRBaseRechargeInvoiceAndUtilityOptionsView(Context context, List<String> list, List<Integer> list2, View.OnClickListener onClickListener) {
        super(context);
        k.c(context, "context");
        this.f63075b = list;
        this.f63076c = list2;
        this.f63077d = onClickListener;
        setBackgroundColor(-1);
        setPadding(com.paytm.utility.b.c(20), com.paytm.utility.b.c(20), com.paytm.utility.b.c(5), com.paytm.utility.b.c(11));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        k.c(layoutParams, "params");
        setLayoutParams(layoutParams);
        this.f63074a = new RecyclerView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        RecyclerView recyclerView = this.f63074a;
        if (recyclerView != null) {
            recyclerView.setLayoutParams(layoutParams2);
        }
        RecyclerView recyclerView2 = this.f63074a;
        if (recyclerView2 != null) {
            recyclerView2.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView3 = this.f63074a;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(new LinearLayoutManager(context));
        }
        addView(this.f63074a);
        RecyclerView recyclerView4 = this.f63074a;
        if (recyclerView4 == null) {
            k.a();
        }
        k.c(recyclerView4, "recyclerView");
        recyclerView4.setAdapter(new b(this));
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable != null) {
            dividerDrawable.setColorFilter(androidx.core.content.b.c(getContext(), R.color.color_f3f7f8), PorterDuff.Mode.SRC_IN);
        }
        recyclerView4.addItemDecoration(new g(dividerDrawable, true));
    }

    public final View.OnClickListener getOnItemSelectListener() {
        return this.f63077d;
    }

    /* access modifiers changed from: protected */
    public final RecyclerView getRecyclerView() {
        return this.f63074a;
    }

    /* access modifiers changed from: protected */
    public final void setRecyclerView(RecyclerView recyclerView) {
        this.f63074a = recyclerView;
    }

    /* access modifiers changed from: protected */
    public Drawable getDividerDrawable() {
        return androidx.core.content.b.a(getContext(), R.drawable.passbook_divider);
    }

    /* access modifiers changed from: protected */
    public int getAdapterItem() {
        return R.layout.content_base_recharge_order_extra_option_item;
    }

    public static final class b extends RecyclerView.a<a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseRechargeInvoiceAndUtilityOptionsView f63082a;

        b(CJRBaseRechargeInvoiceAndUtilityOptionsView cJRBaseRechargeInvoiceAndUtilityOptionsView) {
            this.f63082a = cJRBaseRechargeInvoiceAndUtilityOptionsView;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            a aVar = (a) vVar;
            k.c(aVar, "holder");
            ImageView imageView = aVar.f63078a;
            List<Integer> optionIcons = this.f63082a.getOptionIcons();
            if (optionIcons == null) {
                k.a();
            }
            imageView.setImageResource(optionIcons.get(i2).intValue());
            TextView textView = aVar.f63079b;
            List<String> options = this.f63082a.getOptions();
            if (options == null) {
                k.a();
            }
            textView.setText(options.get(i2));
            View view = aVar.itemView;
            k.a((Object) view, "holder.itemView");
            view.setId(this.f63082a.getOptionIcons().get(i2).intValue());
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            CJRBaseRechargeInvoiceAndUtilityOptionsView cJRBaseRechargeInvoiceAndUtilityOptionsView = this.f63082a;
            View inflate = LayoutInflater.from(cJRBaseRechargeInvoiceAndUtilityOptionsView.getContext()).inflate(this.f63082a.getAdapterItem(), viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…terItem(), parent, false)");
            return new a(cJRBaseRechargeInvoiceAndUtilityOptionsView, inflate);
        }

        public final int getItemCount() {
            List<String> options = this.f63082a.getOptions();
            if (options != null) {
                return options.size();
            }
            return 0;
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f63078a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f63079b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRBaseRechargeInvoiceAndUtilityOptionsView f63080c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f63081d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CJRBaseRechargeInvoiceAndUtilityOptionsView cJRBaseRechargeInvoiceAndUtilityOptionsView, View view) {
            super(view);
            k.c(view, "itemView");
            this.f63080c = cJRBaseRechargeInvoiceAndUtilityOptionsView;
            View findViewById = view.findViewById(R.id.icon);
            if (findViewById != null) {
                this.f63078a = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.option);
                if (findViewById2 != null) {
                    this.f63079b = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.textView57);
                    if (findViewById3 != null) {
                        this.f63081d = (ImageView) findViewById3;
                        view.setOnClickListener(cJRBaseRechargeInvoiceAndUtilityOptionsView.getOnItemSelectListener());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }
}
