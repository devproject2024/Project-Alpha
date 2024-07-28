package net.one97.paytm.upi.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.a.c;

public final class a extends RecyclerView.a<C1337a> {

    /* renamed from: a  reason: collision with root package name */
    final List<c.a> f66492a;

    /* renamed from: b  reason: collision with root package name */
    final m<String, String, x> f66493b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1337a aVar = (C1337a) vVar;
        k.c(aVar, "holder");
        c.a aVar2 = this.f66492a.get(i2);
        k.c(aVar2, "option");
        if (aVar.getAdapterPosition() == aVar.f66497d.f66492a.size() - 1) {
            aVar.f66494a.setVisibility(8);
        } else {
            aVar.f66494a.setVisibility(0);
        }
        aVar.f66495b.setText(aVar2.f66526a);
        w.a().a(aVar2.f66527b).a(aVar.f66496c);
        aVar.itemView.setOnClickListener(new C1337a.C1338a(aVar, aVar2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_bank_acc_bottom_sheet_item_view, viewGroup, false);
        k.a((Object) inflate, "v");
        return new C1337a(this, inflate);
    }

    public a(List<c.a> list, m<? super String, ? super String, x> mVar) {
        k.c(list, "list");
        k.c(mVar, "onOptionItemClick");
        this.f66492a = list;
        this.f66493b = mVar;
    }

    public final int getItemCount() {
        return this.f66492a.size();
    }

    /* renamed from: net.one97.paytm.upi.a.a$a  reason: collision with other inner class name */
    public final class C1337a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final View f66494a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f66495b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f66496c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f66497d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1337a(a aVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f66497d = aVar;
            View findViewById = view.findViewById(R.id.divider);
            k.a((Object) findViewById, "itemView.findViewById(R.id.divider)");
            this.f66494a = findViewById;
            View findViewById2 = view.findViewById(R.id.serviceTextView);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.serviceTextView)");
            this.f66495b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.serviceImageView);
            k.a((Object) findViewById3, "itemView.findViewById(R.id.serviceImageView)");
            this.f66496c = (ImageView) findViewById3;
        }

        /* renamed from: net.one97.paytm.upi.a.a$a$a  reason: collision with other inner class name */
        static final class C1338a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1337a f66498a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c.a f66499b;

            C1338a(C1337a aVar, c.a aVar2) {
                this.f66498a = aVar;
                this.f66499b = aVar2;
            }

            public final void onClick(View view) {
                this.f66498a.f66497d.f66493b.invoke(this.f66499b.f66528c, this.f66499b.f66526a);
            }
        }
    }
}
