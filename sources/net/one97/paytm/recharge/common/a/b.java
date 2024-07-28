package net.one97.paytm.recharge.common.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<Character> f60472a;

    /* renamed from: b  reason: collision with root package name */
    private final C1169b f60473b;

    /* renamed from: net.one97.paytm.recharge.common.a.b$b  reason: collision with other inner class name */
    public interface C1169b {
        void a(char c2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        aVar.f60474a.setText(String.valueOf(this.f60472a.get(i2).charValue()));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v3_alphabet_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…abet_item, parent, false)");
        return new a(this, inflate, this.f60473b, this.f60472a);
    }

    public b(List<Character> list, C1169b bVar) {
        k.c(list, "alphabetsList");
        k.c(bVar, "itemClickListener");
        this.f60472a = list;
        this.f60473b = bVar;
    }

    public final int getItemCount() {
        return this.f60472a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f60474a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f60475b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view, final C1169b bVar2, final List<Character> list) {
            super(view);
            k.c(view, "itemView");
            k.c(bVar2, "itemClickListener");
            k.c(list, "alphabetsList");
            this.f60475b = bVar;
            View findViewById = view.findViewById(R.id.letterTV);
            if (findViewById != null) {
                this.f60474a = (TextView) findViewById;
                this.f60474a.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f60476a;

                    {
                        this.f60476a = r1;
                    }

                    public final void onClick(View view) {
                        bVar2.a(((Character) list.get(this.f60476a.getAdapterPosition())).charValue());
                    }
                });
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }
}
