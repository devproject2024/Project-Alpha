package net.one97.paytm.upi.registration.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.registration.a.g;
import net.one97.paytm.upi.util.SwipeRevealLayout;

public final class f extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final y f68845a = new y();

    /* renamed from: b  reason: collision with root package name */
    g.a f68846b;

    /* renamed from: c  reason: collision with root package name */
    public Context f68847c;

    /* renamed from: d  reason: collision with root package name */
    public String f68848d;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        y yVar = this.f68845a;
        SwipeRevealLayout swipeRevealLayout = aVar.f68857h;
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.getAdapterPosition());
        yVar.a(swipeRevealLayout, sb.toString());
        aVar.setIsRecyclable(false);
        this.f68846b.a(i2, aVar);
    }

    public f(g.a aVar, Context context, String str) {
        this.f68846b = aVar;
        this.f68847c = context;
        this.f68845a.f69090b = true;
        this.f68848d = str;
    }

    public final int getItemCount() {
        return this.f68846b.b();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f68850a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f68851b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f68852c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f68853d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f68854e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f68855f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f68856g;

        /* renamed from: h  reason: collision with root package name */
        SwipeRevealLayout f68857h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f68858i;
        private TextView k;

        a(View view) {
            super(view);
            this.f68858i = (RelativeLayout) view.findViewById(R.id.beneficiary_item);
            this.f68857h = (SwipeRevealLayout) view.findViewById(R.id.swipe_layout_2);
            this.f68850a = (TextView) view.findViewById(R.id.bank_name);
            this.f68851b = (TextView) view.findViewById(R.id.bank_account_no);
            this.f68852c = (TextView) view.findViewById(R.id.check_balance_tv);
            this.k = (TextView) view.findViewById(R.id.default_acc_tv);
            this.f68853d = (TextView) view.findViewById(R.id.make_default_tv);
            this.f68854e = (TextView) view.findViewById(R.id.delete_tv);
            this.f68855f = (ImageView) view.findViewById(R.id.beneficiary_no_name_icon);
            this.f68856g = (ImageView) view.findViewById(R.id.info_icon);
        }

        public final void a(boolean z) {
            if (z) {
                this.k.setVisibility(0);
                this.f68853d.setVisibility(8);
                return;
            }
            this.k.setVisibility(8);
            this.f68853d.setVisibility(0);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f68847c).inflate(R.layout.upi_linked_account_list_item, viewGroup, false));
    }
}
