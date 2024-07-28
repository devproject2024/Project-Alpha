package net.one97.paytm.moneytransfer.view.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.R;

public final class g extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    List<String> f54272a;

    /* renamed from: b  reason: collision with root package name */
    a f54273b;

    public interface a {
        void b(String str);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        List<String> list = this.f54272a;
        String str = list != null ? list.get(i2) : null;
        if (!TextUtils.isEmpty(str)) {
            TextView textView = bVar.f54274a;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = bVar.f54274a;
            if (textView2 != null) {
                textView2.setText("@".concat(String.valueOf(str)));
                return;
            }
            return;
        }
        TextView textView3 = bVar.f54274a;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_upi_id_tag, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…pi_id_tag, parent, false)");
        b bVar = new b(inflate);
        TextView textView = bVar.f54274a;
        if (textView != null) {
            textView.setOnClickListener(new c(this, bVar));
        }
        return bVar;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f54275a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f54276b;

        c(g gVar, b bVar) {
            this.f54275a = gVar;
            this.f54276b = bVar;
        }

        public final void onClick(View view) {
            String str;
            a aVar;
            g gVar = this.f54275a;
            int layoutPosition = this.f54276b.getLayoutPosition();
            List<String> list = gVar.f54272a;
            if (list != null && (str = list.get(layoutPosition)) != null && (aVar = gVar.f54273b) != null) {
                aVar.b(str);
            }
        }
    }

    public final int getItemCount() {
        List<String> list = this.f54272a;
        if (list == null) {
            return 0;
        }
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        if (valueOf == null) {
            k.a();
        }
        return valueOf.intValue();
    }

    public final void a(a aVar) {
        k.c(aVar, "listener");
        this.f54273b = aVar;
    }

    public final void a(List<String> list) {
        k.c(list, "newList");
        List<String> list2 = this.f54272a;
        if (list2 == null || (list2 != null && list2.size() == 0)) {
            this.f54272a = list;
            notifyItemRangeInserted(0, list.size());
            return;
        }
        this.f54272a = list;
        notifyDataSetChanged();
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f54274a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "view");
            this.f54274a = (TextView) view.findViewById(R.id.tv_upi_id_tag_title);
        }
    }
}
