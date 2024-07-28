package net.one97.paytm.addmoney.togv.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.togv.e.a;

public final class a extends RecyclerView.a<C0855a> {

    /* renamed from: a  reason: collision with root package name */
    public int f48668a = -1;

    /* renamed from: b  reason: collision with root package name */
    b f48669b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f48670c;

    public interface b {
        void a(int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0855a aVar = (C0855a) vVar;
        k.c(aVar, "holder");
        List<String> list = this.f48670c;
        String str = list != null ? list.get(i2) : null;
        if (str != null) {
            a.C0858a aVar2 = net.one97.paytm.addmoney.togv.e.a.f48722a;
            String a2 = a.C0858a.a(str);
            TextView textView = aVar.f48671a;
            if (textView != null) {
                textView.setText(a2);
            }
            CheckBox checkBox = aVar.f48672b;
            if (checkBox != null) {
                checkBox.setChecked(this.f48668a == i2);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.uam_gv_amount_select_item, (ViewGroup) null, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…select_item, null, false)");
        return new C0855a(this, inflate);
    }

    public a(List<String> list, b bVar) {
        k.c(list, "amountList");
        k.c(bVar, "listener");
        this.f48670c = list;
        this.f48669b = bVar;
    }

    public final int getItemCount() {
        List<String> list = this.f48670c;
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        if (valueOf == null) {
            k.a();
        }
        return valueOf.intValue();
    }

    /* renamed from: net.one97.paytm.addmoney.togv.a.a$a  reason: collision with other inner class name */
    public final class C0855a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f48671a;

        /* renamed from: b  reason: collision with root package name */
        CheckBox f48672b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f48673c;

        /* renamed from: d  reason: collision with root package name */
        private CardView f48674d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0855a(a aVar, View view) {
            super(view);
            k.c(view, "view");
            this.f48673c = aVar;
            this.f48671a = (TextView) view.findViewById(R.id.tv_amount);
            this.f48672b = (CheckBox) view.findViewById(R.id.cb_selected);
            this.f48674d = (CardView) view.findViewById(R.id.parent);
            CardView cardView = this.f48674d;
            if (cardView != null) {
                cardView.setOnClickListener(this);
            }
            CheckBox checkBox = this.f48672b;
            if (checkBox != null) {
                checkBox.setOnClickListener(this);
            }
        }

        public final void onClick(View view) {
            b bVar = this.f48673c.f48669b;
            if (bVar != null) {
                CheckBox checkBox = this.f48672b;
                Boolean valueOf = checkBox != null ? Boolean.valueOf(checkBox.isChecked()) : null;
                if (valueOf == null) {
                    k.a();
                }
                valueOf.booleanValue();
                bVar.a(getAdapterPosition());
            }
        }
    }

    public final String a(int i2) {
        List<String> list = this.f48670c;
        if (list != null) {
            return list.get(i2);
        }
        return null;
    }

    public final void b(int i2) {
        int i3 = this.f48668a;
        if (i2 != i3) {
            this.f48668a = i2;
            if (i3 != -1) {
                notifyItemChanged(i3);
            }
            int i4 = this.f48668a;
            if (i4 != -1) {
                notifyItemChanged(i4);
            }
        }
    }
}
