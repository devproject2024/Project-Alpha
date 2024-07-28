package net.one97.paytm.moneytransfer.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<UpiTransactionModelV2> f54230a;

    /* renamed from: b  reason: collision with root package name */
    b f54231b;

    /* renamed from: c  reason: collision with root package name */
    private Context f54232c;

    public interface b {
        void a(UpiTransactionModelV2 upiTransactionModelV2);
    }

    public c(ArrayList<UpiTransactionModelV2> arrayList, Context context, b bVar) {
        this.f54230a = arrayList;
        this.f54232c = context;
        this.f54231b = bVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        if (this.f54230a != null) {
            TextView textView = aVar.f54233a;
            ArrayList<UpiTransactionModelV2> arrayList = this.f54230a;
            if (arrayList == null) {
                k.a();
            }
            UpiTransactionModelV2 upiTransactionModelV2 = arrayList.get(i2);
            k.a((Object) upiTransactionModelV2, "txnsList!![position]");
            textView.setText(upiTransactionModelV2.getNarration());
            TextView textView2 = aVar.f54234b;
            ArrayList<UpiTransactionModelV2> arrayList2 = this.f54230a;
            if (arrayList2 == null) {
                k.a();
            }
            UpiTransactionModelV2 upiTransactionModelV22 = arrayList2.get(i2);
            k.a((Object) upiTransactionModelV22, "txnsList!![position]");
            textView2.setText(upiTransactionModelV22.getDate());
            ArrayList<UpiTransactionModelV2> arrayList3 = this.f54230a;
            if (arrayList3 == null) {
                k.a();
            }
            UpiTransactionModelV2 upiTransactionModelV23 = arrayList3.get(i2);
            k.a((Object) upiTransactionModelV23, "txnsList!![position]");
            String str = null;
            if (p.a(upiTransactionModelV23.getTxnType(), "DEBIT", true)) {
                aVar.f54236d.setText("-");
                TextView textView3 = aVar.f54235c;
                Context context = this.f54232c;
                if (context != null) {
                    str = context.getString(R.string.rupee_symbol);
                }
                ArrayList<UpiTransactionModelV2> arrayList4 = this.f54230a;
                if (arrayList4 == null) {
                    k.a();
                }
                UpiTransactionModelV2 upiTransactionModelV24 = arrayList4.get(i2);
                k.a((Object) upiTransactionModelV24, "txnsList!![position]");
                textView3.setText(k.a(str, (Object) upiTransactionModelV24.getAmount()));
                return;
            }
            ArrayList<UpiTransactionModelV2> arrayList5 = this.f54230a;
            if (arrayList5 == null) {
                k.a();
            }
            UpiTransactionModelV2 upiTransactionModelV25 = arrayList5.get(i2);
            k.a((Object) upiTransactionModelV25, "txnsList!![position]");
            if (p.a(upiTransactionModelV25.getTxnType(), "CREDIT", true)) {
                aVar.f54236d.setText("+");
                TextView textView4 = aVar.f54235c;
                Context context2 = this.f54232c;
                if (context2 != null) {
                    str = context2.getString(R.string.rupee_symbol);
                }
                ArrayList<UpiTransactionModelV2> arrayList6 = this.f54230a;
                if (arrayList6 == null) {
                    k.a();
                }
                UpiTransactionModelV2 upiTransactionModelV26 = arrayList6.get(i2);
                k.a((Object) upiTransactionModelV26, "txnsList!![position]");
                textView4.setText(k.a(str, (Object) upiTransactionModelV26.getAmount()));
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_user_history_money_transfer, viewGroup, false));
        aVar.itemView.setOnClickListener(new C0972c(this, aVar));
        return aVar;
    }

    /* renamed from: net.one97.paytm.moneytransfer.view.a.c$c  reason: collision with other inner class name */
    static final class C0972c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f54237a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f54238b;

        C0972c(c cVar, a aVar) {
            this.f54237a = cVar;
            this.f54238b = aVar;
        }

        public final void onClick(View view) {
            c cVar = this.f54237a;
            int adapterPosition = this.f54238b.getAdapterPosition();
            b bVar = cVar.f54231b;
            if (bVar != null) {
                ArrayList<UpiTransactionModelV2> arrayList = cVar.f54230a;
                UpiTransactionModelV2 upiTransactionModelV2 = arrayList != null ? arrayList.get(adapterPosition) : null;
                if (upiTransactionModelV2 == null) {
                    k.a();
                }
                k.a((Object) upiTransactionModelV2, "txnsList?.get(position)!!");
                bVar.a(upiTransactionModelV2);
            }
        }
    }

    public final int getItemCount() {
        ArrayList<UpiTransactionModelV2> arrayList = this.f54230a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f54233a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f54234b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f54235c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f54236d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            if (view == null) {
                k.a();
            }
            View findViewById = view.findViewById(R.id.text_view_money_status);
            k.a((Object) findViewById, "itemView!!.findViewById(…d.text_view_money_status)");
            this.f54233a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.text_view_date_time);
            k.a((Object) findViewById2, "itemView!!.findViewById(R.id.text_view_date_time)");
            this.f54234b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.text_view_amount);
            k.a((Object) findViewById3, "itemView!!.findViewById(R.id.text_view_amount)");
            this.f54235c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.textViewSign);
            k.a((Object) findViewById4, "itemView!!.findViewById(R.id.textViewSign)");
            this.f54236d = (TextView) findViewById4;
        }
    }
}
