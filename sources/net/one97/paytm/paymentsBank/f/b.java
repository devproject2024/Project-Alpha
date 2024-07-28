package net.one97.paytm.paymentsBank.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.paymentsBank.R;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public List<net.one97.paytm.paymentsBank.f.b.b> f18332a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.paymentsBank.h.b<net.one97.paytm.paymentsBank.f.b.b> f18333b;

    /* renamed from: c  reason: collision with root package name */
    private Context f18334c;

    public b(Context context, List<net.one97.paytm.paymentsBank.f.b.b> list) {
        this.f18334c = context;
        this.f18332a = list;
    }

    public final void a(net.one97.paytm.paymentsBank.f.b.b bVar, int i2) {
        if (this.f18332a.size() > i2) {
            net.one97.paytm.paymentsBank.f.b.b bVar2 = this.f18332a.get(i2);
            if (!TextUtils.isEmpty(bVar2.f18352c) && bVar2.f18352c.equalsIgnoreCase(bVar.f18352c)) {
                return;
            }
        }
        for (net.one97.paytm.paymentsBank.f.b.b next : this.f18332a) {
            if (next.f18350a == 2 && bVar.f18352c.equalsIgnoreCase(next.f18352c)) {
                return;
            }
        }
        this.f18332a.add(i2, bVar);
        notifyDataSetChanged();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new a(LayoutInflater.from(this.f18334c).inflate(R.layout.layout_menu_header_item, viewGroup, false));
        }
        if (i2 == 2) {
            return new C0314b(LayoutInflater.from(this.f18334c).inflate(R.layout.layout_menu_main_item, viewGroup, false));
        }
        if (i2 == 3) {
            return new c(LayoutInflater.from(this.f18334c).inflate(R.layout.layout_menu_logout_item, viewGroup, false));
        }
        if (i2 == 4) {
            return new d(LayoutInflater.from(this.f18334c).inflate(R.layout.layout_menu_seperator_item, viewGroup, false));
        }
        return null;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        net.one97.paytm.paymentsBank.f.b.b bVar = this.f18332a.get(i2);
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            aVar.f18335a.setText(bVar.f18352c);
            if (bVar.f18356g > 0) {
                aVar.f18335a.setTextColor(androidx.core.content.b.c(this.f18334c, bVar.f18356g));
            }
        } else if (vVar instanceof C0314b) {
            C0314b bVar2 = (C0314b) vVar;
            bVar2.f18344a.setText(bVar.f18352c);
            bVar2.f18345b.setText(bVar.f18353d);
            bVar2.f18346c.setImageDrawable(androidx.core.content.b.a(this.f18334c, bVar.f18355f));
            if (bVar.f18354e) {
                bVar2.f18348e.setVisibility(0);
            } else {
                bVar2.f18348e.setVisibility(8);
            }
            if (i2 >= this.f18332a.size() - 1 || this.f18332a.get(i2 + 1).f18350a != 2) {
                bVar2.f18347d.setVisibility(4);
            } else {
                bVar2.f18347d.setVisibility(0);
            }
        }
    }

    public final int getItemCount() {
        List<net.one97.paytm.paymentsBank.f.b.b> list = this.f18332a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final int getItemViewType(int i2) {
        return this.f18332a.get(i2).f18350a;
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f18335a;

        a(View view) {
            super(view);
            this.f18335a = (TextView) view.findViewById(R.id.tv_heading_menu_item);
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.f.b$b  reason: collision with other inner class name */
    class C0314b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f18344a;

        /* renamed from: b  reason: collision with root package name */
        TextView f18345b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f18346c;

        /* renamed from: d  reason: collision with root package name */
        View f18347d;

        /* renamed from: e  reason: collision with root package name */
        AppCompatImageView f18348e;

        C0314b(View view) {
            super(view);
            this.f18344a = (TextView) view.findViewById(R.id.tv_heading_1);
            this.f18345b = (TextView) view.findViewById(R.id.tv_heading_2);
            this.f18346c = (ImageView) view.findViewById(R.id.iv_icon);
            this.f18347d = view.findViewById(R.id.v_seperator);
            this.f18348e = (AppCompatImageView) view.findViewById(R.id.new_iv);
            view.setOnClickListener(this);
        }

        public final void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition >= 0 && b.this.f18333b != null) {
                b.this.f18333b.onClick(view, adapterPosition, b.this.f18332a.get(adapterPosition));
            }
        }
    }

    class c extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f18357a;

        c(View view) {
            super(view);
            this.f18357a = (TextView) view.findViewById(R.id.tv_logout_button);
            this.f18357a.setOnClickListener(this);
        }

        public final void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition >= 0 && b.this.f18333b != null) {
                b.this.f18333b.onClick(view, adapterPosition, b.this.f18332a.get(adapterPosition));
            }
        }
    }

    class d extends RecyclerView.v {
        d(View view) {
            super(view);
        }
    }

    public final void a(List<net.one97.paytm.paymentsBank.f.b.b> list) {
        this.f18332a = list;
        notifyDataSetChanged();
    }
}
