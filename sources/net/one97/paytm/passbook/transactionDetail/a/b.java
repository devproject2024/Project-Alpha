package net.one97.paytm.passbook.transactionDetail.a;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5Param;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity;
import net.one97.paytm.passbook.utility.c;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRTransaction> f59014a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    final RecentTransactionsActivity.a f59015b;

    public b(RecentTransactionsActivity.a aVar) {
        this.f59015b = aVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRTransaction cJRTransaction = this.f59014a.get(i2);
        k.a((Object) cJRTransaction, "mTransactionList[position]");
        CJRTransaction cJRTransaction2 = cJRTransaction;
        k.c(cJRTransaction2, "transaction");
        String a2 = c.a(cJRTransaction2.getTxnAmount());
        aa aaVar = aa.f47921a;
        View view = aVar.itemView;
        k.a((Object) view, "itemView");
        String string = view.getContext().getString(R.string.simple_amount);
        k.a((Object) string, "itemView.context.getString(R.string.simple_amount)");
        String format = String.format(string, Arrays.copyOf(new Object[]{a2}, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        if (p.a(H5Param.DELAY_RENDER, cJRTransaction2.getTxnType(), true)) {
            View view2 = aVar.itemView;
            k.a((Object) view2, "itemView");
            TextView textView = (TextView) view2.findViewById(R.id.amountTv);
            k.a((Object) textView, "itemView.amountTv");
            textView.setText("- ".concat(String.valueOf(format)));
            View view3 = aVar.itemView;
            k.a((Object) view3, "itemView");
            ((TextView) view3.findViewById(R.id.amountTv)).setTextColor(Color.parseColor("#222222"));
        } else {
            View view4 = aVar.itemView;
            k.a((Object) view4, "itemView");
            TextView textView2 = (TextView) view4.findViewById(R.id.amountTv);
            k.a((Object) textView2, "itemView.amountTv");
            textView2.setText("+ ".concat(String.valueOf(format)));
            View view5 = aVar.itemView;
            k.a((Object) view5, "itemView");
            View view6 = aVar.itemView;
            k.a((Object) view6, "itemView");
            ((TextView) view5.findViewById(R.id.amountTv)).setTextColor(androidx.core.content.b.c(view6.getContext(), R.color.passbook_row_status_refundsuccess_color));
        }
        String txnDate = cJRTransaction2.getTxnDate();
        k.a((Object) txnDate, "transaction.txnDate");
        String a3 = a.a(txnDate, "yyyy-MM-dd hh:mm:ss", "dd MMM, hh:mm a");
        View view7 = aVar.itemView;
        k.a((Object) view7, "itemView");
        TextView textView3 = (TextView) view7.findViewById(R.id.dateTv);
        k.a((Object) textView3, "itemView.dateTv");
        textView3.setText(a3);
        if (!TextUtils.isEmpty(cJRTransaction2.getRecentListingName())) {
            View view8 = aVar.itemView;
            k.a((Object) view8, "itemView");
            TextView textView4 = (TextView) view8.findViewById(R.id.title_tv);
            k.a((Object) textView4, "itemView.title_tv");
            textView4.setText(cJRTransaction2.getNarration() + cJRTransaction2.getRecentListingName());
        } else {
            View view9 = aVar.itemView;
            k.a((Object) view9, "itemView");
            TextView textView5 = (TextView) view9.findViewById(R.id.title_tv);
            k.a((Object) textView5, "itemView.title_tv");
            textView5.setText(cJRTransaction2.getNarration());
        }
        aVar.itemView.setOnClickListener(new a.C1137a(aVar, cJRTransaction2));
        if (this.f59014a.size() == i2 + 1) {
            View view10 = aVar.itemView;
            k.a((Object) view10, "holder.itemView");
            View findViewById = view10.findViewById(R.id.timelineView2);
            k.a((Object) findViewById, "holder.itemView.timelineView2");
            findViewById.setVisibility(8);
            return;
        }
        View view11 = aVar.itemView;
        k.a((Object) view11, "holder.itemView");
        View findViewById2 = view11.findViewById(R.id.timelineView2);
        k.a((Object) findViewById2, "holder.itemView.timelineView2");
        findViewById2.setVisibility(0);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_recent_transaction_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        ArrayList<CJRTransaction> arrayList = this.f59014a;
        return (arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f59016a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f59016a = bVar;
        }

        /* renamed from: net.one97.paytm.passbook.transactionDetail.a.b$a$a  reason: collision with other inner class name */
        static final class C1137a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f59017a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CJRTransaction f59018b;

            C1137a(a aVar, CJRTransaction cJRTransaction) {
                this.f59017a = aVar;
                this.f59018b = cJRTransaction;
            }

            public final void onClick(View view) {
                RecentTransactionsActivity.a aVar = this.f59017a.f59016a.f59015b;
                if (aVar != null) {
                    aVar.a(this.f59018b);
                }
            }
        }

        public static String a(String str, String str2, String str3) {
            k.c(str, "time");
            k.c(str2, "formatFrom");
            k.c(str3, "formatTo");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.ENGLISH);
            try {
                String format = new SimpleDateFormat(str3).format(simpleDateFormat.parse(str));
                k.a((Object) format, "sdfTo.format(date)");
                return format;
            } catch (ParseException unused) {
                return "";
            }
        }
    }
}
