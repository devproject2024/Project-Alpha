package net.one97.paytm.autoaddmoney.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    List<String> f49113a;

    /* renamed from: b  reason: collision with root package name */
    C0868a f49114b;

    /* renamed from: c  reason: collision with root package name */
    private int f49115c = -1;

    /* renamed from: net.one97.paytm.autoaddmoney.a.a$a  reason: collision with other inner class name */
    public interface C0868a {
        void a(String str);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        TextView textView = bVar.f49116a;
        textView.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + AddMoneyUtils.d(this.f49113a.get(i2)));
        if (i2 == this.f49115c) {
            TextView textView2 = bVar.f49116a;
            View view = bVar.itemView;
            k.a((Object) view, "holder.itemView");
            textView2.setBackground(androidx.core.content.b.a(view.getContext(), R.drawable.blue_button_bg_rounded_addmoney));
            TextView textView3 = bVar.f49116a;
            View view2 = bVar.itemView;
            k.a((Object) view2, "holder.itemView");
            textView3.setTextColor(androidx.core.content.b.c(view2.getContext(), R.color.white));
            return;
        }
        TextView textView4 = bVar.f49116a;
        View view3 = bVar.itemView;
        k.a((Object) view3, "holder.itemView");
        textView4.setBackground(androidx.core.content.b.a(view3.getContext(), R.drawable.white_background_with_border_addmoney));
        TextView textView5 = bVar.f49116a;
        View view4 = bVar.itemView;
        k.a((Object) view4, "holder.itemView");
        textView5.setTextColor(androidx.core.content.b.c(view4.getContext(), R.color.color_506d85));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_amount_suggestion, (ViewGroup) null, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…_suggestion, null, false)");
        return new b(this, inflate);
    }

    public a(List<String> list, C0868a aVar) {
        k.c(list, "list");
        k.c(aVar, "listener");
        this.f49113a = list;
        this.f49114b = aVar;
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f49116a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f49117b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, View view) {
            super(view);
            k.c(view, "view");
            this.f49117b = aVar;
            View findViewById = view.findViewById(R.id.tv_amount);
            k.a((Object) findViewById, "view.findViewById(R.id.tv_amount)");
            this.f49116a = (TextView) findViewById;
            this.f49116a.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f49118a;

                {
                    this.f49118a = r1;
                }

                public final void onClick(View view) {
                    this.f49118a.f49117b.a(this.f49118a.getAdapterPosition());
                    this.f49118a.f49117b.f49114b.a(this.f49118a.f49117b.f49113a.get(this.f49118a.getAdapterPosition()));
                }
            });
        }
    }

    public final int getItemCount() {
        List<String> list = this.f49113a;
        return (list != null ? Integer.valueOf(list.size()) : null).intValue();
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        int i3 = this.f49115c;
        if (i2 != i3) {
            this.f49115c = i2;
            if (i3 != -1) {
                notifyItemChanged(i3);
            }
            int i4 = this.f49115c;
            if (i4 != -1) {
                notifyItemChanged(i4);
            }
        }
    }

    public final void a(String str) {
        k.c(str, "value");
        a(this.f49113a.indexOf(str));
    }
}
