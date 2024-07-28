package net.one97.paytm.games.a.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.games.R;
import net.one97.paytm.games.model.pfg.Bean;
import net.one97.paytm.games.view.pfg.a.c;

public final class b extends c<String, Bean, RecyclerView.v> {
    public final void a(int i2) {
        net.one97.paytm.games.view.pfg.a.b bVar = (net.one97.paytm.games.view.pfg.a.b) this.f35727a.get(((net.one97.paytm.games.view.pfg.a.a) this.f35728b.get(i2)).f35721a);
        bVar.f35726c = !bVar.f35726c;
        notifyDataSetChanged();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 != 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_expand_order_sub, viewGroup, false));
        }
        C0592b bVar = new C0592b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_expand_order_title, viewGroup, false));
        bVar.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                net.one97.paytm.games.view.pfg.a.b bVar = (net.one97.paytm.games.view.pfg.a.b) view.getTag();
                bVar.f35726c = !bVar.f35726c;
                b.this.notifyDataSetChanged();
            }
        });
        return bVar;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (getItemViewType(i2) == 0) {
            int i3 = ((net.one97.paytm.games.view.pfg.a.a) this.f35728b.get(i2)).f35721a;
            C0592b bVar = (C0592b) vVar;
            bVar.itemView.setTag(this.f35727a.get(i3));
            bVar.f35445a.setText((CharSequence) ((net.one97.paytm.games.view.pfg.a.b) this.f35727a.get(i3)).f35724a);
            return;
        }
        a aVar = (a) vVar;
        int i4 = ((net.one97.paytm.games.view.pfg.a.a) this.f35728b.get(i2)).f35721a;
        Bean bean = (Bean) ((net.one97.paytm.games.view.pfg.a.b) this.f35727a.get(i4)).f35725b.get(((net.one97.paytm.games.view.pfg.a.a) this.f35728b.get(i2)).f35722b);
        aVar.itemView.setTag(bean);
        if (bean.getTransaction_type().equals("EARN")) {
            if (bean.isOld()) {
                aVar.f35441a.setImageResource(R.drawable.icon_beans_earn_old);
            } else {
                aVar.f35441a.setImageResource(R.drawable.icon_beans_earn);
            }
            TextView textView = aVar.f35444d;
            textView.setText("+ " + bean.getAmount());
            aVar.f35444d.setTextColor(androidx.core.content.b.c(aVar.f35444d.getContext(), R.color.green_0eb912));
        } else {
            if (bean.isOld()) {
                aVar.f35441a.setImageResource(R.drawable.icon_beans_spent_old);
            } else if (bean.getUser_action() == null || !bean.getUser_action().equals("beans_debit_for_points")) {
                aVar.f35441a.setImageResource(R.drawable.icon_beans_spent);
            } else {
                aVar.f35441a.setImageResource(R.drawable.icon_beans_spent_old);
            }
            TextView textView2 = aVar.f35444d;
            textView2.setText("- " + bean.getAmount());
            aVar.f35444d.setTextColor(androidx.core.content.b.c(aVar.f35444d.getContext(), R.color.red_e81111));
        }
        if ("redeem_refund" == bean.getUser_action() || "refund".equals(bean.getUser_action())) {
            String[] split = bean.getDescription().split(AppConstants.COLON);
            if (split == null || split.length != 2) {
                aVar.f35443c.setText(bean.getDescription());
            } else {
                aVar.f35443c.setText(split[1]);
            }
        } else {
            aVar.f35443c.setText(bean.getDescription());
        }
        aVar.f35442b.setText(bean.getTimes());
    }

    /* renamed from: net.one97.paytm.games.a.a.b$b  reason: collision with other inner class name */
    static class C0592b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f35445a;

        C0592b(View view) {
            super(view);
            this.f35445a = (TextView) view.findViewById(R.id.text_time);
        }
    }

    static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f35441a;

        /* renamed from: b  reason: collision with root package name */
        TextView f35442b;

        /* renamed from: c  reason: collision with root package name */
        TextView f35443c;

        /* renamed from: d  reason: collision with root package name */
        TextView f35444d;

        a(View view) {
            super(view);
            this.f35441a = (ImageView) view.findViewById(R.id.image_game);
            this.f35442b = (TextView) view.findViewById(R.id.times);
            this.f35443c = (TextView) view.findViewById(R.id.des);
            this.f35444d = (TextView) view.findViewById(R.id.amount);
        }
    }
}
