package net.one97.paytm.paymentsBank.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.paymentsBank.R;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public List<net.one97.paytm.paymentsBank.f.b.a> f18312a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.paymentsBank.h.b<net.one97.paytm.paymentsBank.f.b.a> f18313b;

    /* renamed from: c  reason: collision with root package name */
    private Context f18314c;

    public a(Context context, List<net.one97.paytm.paymentsBank.f.b.a> list) {
        this.f18314c = context;
        this.f18312a = list;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new C0313a(LayoutInflater.from(this.f18314c).inflate(R.layout.layout_acc_header_item, viewGroup, false));
        }
        if (i2 == 2) {
            return new b(LayoutInflater.from(this.f18314c).inflate(R.layout.layout_menu_main_item, viewGroup, false));
        }
        return null;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        net.one97.paytm.paymentsBank.f.b.a aVar = this.f18312a.get(i2);
        if (vVar instanceof C0313a) {
            ((C0313a) vVar).f18315a.setText(aVar.f18338b);
        } else if (vVar instanceof b) {
            b bVar = (b) vVar;
            bVar.f18328c.setImageResource(R.drawable.drawer_know_your_bank);
            bVar.f18326a.setText(aVar.f18338b);
            bVar.f18327b.setText(aVar.f18339c);
            bVar.f18329d.setImageResource(aVar.f18343g ? R.drawable.ic_check_green_18dp : 0);
            if (i2 >= this.f18312a.size() - 1 || this.f18312a.get(i2 + 1).f18337a != 2) {
                bVar.f18330e.setVisibility(4);
            } else {
                bVar.f18330e.setVisibility(0);
            }
        }
    }

    public final int getItemCount() {
        List<net.one97.paytm.paymentsBank.f.b.a> list = this.f18312a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final int getItemViewType(int i2) {
        return this.f18312a.get(i2).f18337a;
    }

    /* renamed from: net.one97.paytm.paymentsBank.f.a$a  reason: collision with other inner class name */
    class C0313a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f18315a;

        C0313a(View view) {
            super(view);
            this.f18315a = (TextView) view.findViewById(R.id.tv_header);
        }
    }

    class b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f18326a;

        /* renamed from: b  reason: collision with root package name */
        TextView f18327b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f18328c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f18329d;

        /* renamed from: e  reason: collision with root package name */
        View f18330e;

        b(View view) {
            super(view);
            this.f18326a = (TextView) view.findViewById(R.id.tv_heading_1);
            this.f18327b = (TextView) view.findViewById(R.id.tv_heading_2);
            this.f18328c = (ImageView) view.findViewById(R.id.iv_icon);
            this.f18329d = (ImageView) view.findViewById(R.id.arrow);
            this.f18330e = view.findViewById(R.id.v_seperator);
            view.setOnClickListener(this);
        }

        public final void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition >= 0 && a.this.f18313b != null) {
                a.this.f18313b.onClick(view, adapterPosition, a.this.f18312a.get(adapterPosition));
            }
        }
    }
}
