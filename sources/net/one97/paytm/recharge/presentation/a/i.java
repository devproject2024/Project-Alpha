package net.one97.paytm.recharge.presentation.a;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.presentation.d.e;
import net.one97.paytm.recharge.presentation.f.l;

public final class i extends RecyclerView.a<l> {

    /* renamed from: a  reason: collision with root package name */
    int f64616a = -1;

    /* renamed from: b  reason: collision with root package name */
    final e f64617b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<String> f64618c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final String f64619d;

    public i(e eVar, String str) {
        k.c(eVar, "rechargeDaySelectListener");
        k.c(str, "preSelectedVal");
        this.f64617b = eVar;
        this.f64619d = str;
        this.f64618c.add("7");
        this.f64618c.add("10");
        this.f64618c.add("15");
        this.f64618c.add("20");
        this.f64618c.add("30");
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        l lVar = (l) vVar;
        k.c(lVar, "holder");
        String str = this.f64618c.get(i2);
        boolean a2 = k.a((Object) this.f64619d, (Object) this.f64618c.get(i2));
        if (str != null) {
            if (a2) {
                ((TextView) lVar.f64917a.findViewById(R.id.txt_days)).setTypeface((Typeface) null, 1);
                View findViewById = lVar.f64917a.findViewById(R.id.ic_radio_btn);
                k.a((Object) findViewById, "mItemView.findViewById<R…utton>(R.id.ic_radio_btn)");
                ((RadioButton) findViewById).setChecked(true);
            } else {
                View findViewById2 = lVar.f64917a.findViewById(R.id.txt_days);
                k.a((Object) findViewById2, "mItemView.findViewById<TextView>(R.id.txt_days)");
                ((TextView) findViewById2).setText(lVar.f64917a.getContext().getString(R.string.recharge_days_select, new Object[]{str}));
                View findViewById3 = lVar.f64917a.findViewById(R.id.ic_radio_btn);
                k.a((Object) findViewById3, "mItemView.findViewById<R…utton>(R.id.ic_radio_btn)");
                ((RadioButton) findViewById3).setChecked(false);
            }
            ((TextView) lVar.f64917a.findViewById(R.id.txt_days)).setTypeface((Typeface) null, 0);
            lVar.f64917a.setOnClickListener(new l.a(lVar, str));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_recharge_days, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…arge_days, parent, false)");
        return new l(inflate, new a(this));
    }

    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f64620a;

        a(i iVar) {
            this.f64620a = iVar;
        }

        public final void a(int i2, String str) {
            k.c(str, "selectedDay");
            if (this.f64620a.f64616a != i2) {
                if (!(this.f64620a.f64616a == -1 || this.f64620a.f64616a == i2)) {
                    i iVar = this.f64620a;
                    iVar.notifyItemChanged(iVar.f64616a);
                }
                i iVar2 = this.f64620a;
                iVar2.f64616a = i2;
                iVar2.f64617b.a(i2, str);
            }
        }
    }

    public final int getItemCount() {
        if (this.f64618c.isEmpty()) {
            return 0;
        }
        return this.f64618c.size();
    }
}
