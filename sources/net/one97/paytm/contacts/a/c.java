package net.one97.paytm.contacts.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.contacts.e;
import net.one97.paytm.wallet.R;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f50024a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f50025b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    e f50026c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f50027d;

    public c(Context context, e eVar) {
        k.c(context, "context");
        k.c(eVar, "listner");
        this.f50026c = eVar;
        this.f50027d = context;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vpa_row, viewGroup, false);
        k.a((Object) inflate, "v");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f50024a.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        a aVar = (a) vVar;
        String str = this.f50024a.get(i2);
        k.a((Object) str, "filterList[position]");
        String str2 = str;
        k.c(str2, "item");
        aVar.f50028a.setText("@".concat(String.valueOf(str2)));
        aVar.f50028a.setOnClickListener(new a.C0898a(aVar, str2));
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f50028a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f50029b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, View view) {
            super(view);
            k.c(view, "v");
            this.f50029b = cVar;
            TextView textView = (TextView) view.findViewById(R.id.tv_upi_row);
            k.a((Object) textView, "v.tv_upi_row");
            this.f50028a = textView;
        }

        /* renamed from: net.one97.paytm.contacts.a.c$a$a  reason: collision with other inner class name */
        static final class C0898a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f50030a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f50031b;

            C0898a(a aVar, String str) {
                this.f50030a = aVar;
                this.f50031b = str;
            }

            public final void onClick(View view) {
                this.f50030a.f50029b.f50024a.clear();
                this.f50030a.f50029b.f50024a.add(this.f50031b);
                this.f50030a.f50029b.notifyDataSetChanged();
                this.f50030a.f50029b.f50026c.b(this.f50031b);
            }
        }
    }
}
