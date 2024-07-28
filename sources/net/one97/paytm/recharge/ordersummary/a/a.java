package net.one97.paytm.recharge.ordersummary.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.core.h.u;
import androidx.recyclerview.widget.RecyclerView;
import com.sendbird.android.constant.StringSet;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class a extends RecyclerView.a<C1253a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f63969a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f63970b;

    /* renamed from: c  reason: collision with root package name */
    private final int f63971c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1253a aVar = (C1253a) vVar;
        k.c(aVar, "holder");
        View view = aVar.f63972a;
        View view2 = aVar.itemView;
        k.a((Object) view2, "holder.itemView");
        u.a(view, b.b(view2.getContext(), this.f63971c));
        aVar.f63973b.setText(this.f63970b.get(i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f63969a).inflate(R.layout.recharge_order_summary_message_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…sage_item, parent, false)");
        return new C1253a(inflate);
    }

    public a(Context context, List<String> list, int i2) {
        k.c(context, "context");
        k.c(list, StringSet.messages);
        this.f63969a = context;
        this.f63970b = list;
        this.f63971c = i2;
    }

    public final int getItemCount() {
        return this.f63970b.size();
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.a.a$a  reason: collision with other inner class name */
    public static final class C1253a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final View f63972a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f63973b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1253a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.bullet);
            if (findViewById != null) {
                this.f63972a = findViewById;
                View findViewById2 = view.findViewById(R.id.message);
                if (findViewById2 != null) {
                    this.f63973b = (TextView) findViewById2;
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new kotlin.u("null cannot be cast to non-null type android.view.View");
        }
    }
}
