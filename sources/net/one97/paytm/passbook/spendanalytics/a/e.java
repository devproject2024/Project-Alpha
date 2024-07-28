package net.one97.paytm.passbook.spendanalytics.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity;

public final class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f58512a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRTransaction> f58513b = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        a aVar = (a) vVar;
        CJRTransaction cJRTransaction = this.f58513b.get(i2);
        try {
            str = new SimpleDateFormat("dd MMM, hh:mm a").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(cJRTransaction.getTxnDate()));
        } catch (ParseException unused) {
            str = null;
        }
        if (i2 == 0) {
            aVar.f58520g.setPadding(0, net.one97.paytm.passbook.mapping.a.c(19), 0, 0);
        } else if (i2 == this.f58513b.size() - 1) {
            aVar.f58520g.setPadding(0, 0, 0, net.one97.paytm.passbook.mapping.a.c(19));
        } else {
            aVar.f58520g.setPadding(0, 0, 0, 0);
        }
        aVar.f58514a.setText(str);
        TextView textView = aVar.f58515b;
        textView.setText(this.f58512a.getString(R.string.pass_rs_symbol) + cJRTransaction.getTxnAmount().replace(".00", ""));
        aVar.f58518e.setVisibility(0);
        int i3 = 8;
        aVar.f58517d.setVisibility(this.f58513b.size() + -1 == i2 ? 8 : 0);
        aVar.f58516c.setVisibility(getItemCount() + -1 == i2 ? 4 : 0);
        View view = aVar.f58519f;
        if (i2 != 0) {
            i3 = 0;
        }
        view.setVisibility(i3);
        aVar.f58520g.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                e.this.a(this.f$1, view);
            }
        });
    }

    public e(Context context, ArrayList<CJRTransaction> arrayList) {
        this.f58512a = context;
        this.f58513b = arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, View view) {
        Intent intent = new Intent(this.f58512a, PassbookTransactionDetailsActivity.class);
        intent.putExtra("passbook_detail_data", this.f58513b.get(i2));
        this.f58512a.startActivity(intent);
    }

    public final int getItemCount() {
        ArrayList<CJRTransaction> arrayList = this.f58513b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f58514a;

        /* renamed from: b  reason: collision with root package name */
        TextView f58515b;

        /* renamed from: c  reason: collision with root package name */
        View f58516c;

        /* renamed from: d  reason: collision with root package name */
        View f58517d;

        /* renamed from: e  reason: collision with root package name */
        View f58518e;

        /* renamed from: f  reason: collision with root package name */
        View f58519f;

        /* renamed from: g  reason: collision with root package name */
        public ConstraintLayout f58520g;

        public a(View view) {
            super(view);
            this.f58520g = (ConstraintLayout) view.findViewById(R.id.clRoot);
            this.f58514a = (TextView) view.findViewById(R.id.dateTime);
            this.f58515b = (TextView) view.findViewById(R.id.amount);
            this.f58516c = view.findViewById(R.id.separator);
            this.f58517d = view.findViewById(R.id.timelineView2);
            this.f58518e = view.findViewById(R.id.circleView);
            this.f58519f = view.findViewById(R.id.timelineView3);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_item_row_category_history_l3, viewGroup, false));
    }
}
