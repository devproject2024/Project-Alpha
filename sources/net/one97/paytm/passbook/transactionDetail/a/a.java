package net.one97.paytm.passbook.transactionDetail.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.ExtendedTxnInfo;

public final class a extends RecyclerView.a<C1136a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ExtendedTxnInfo> f59010a;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1136a aVar = (C1136a) vVar;
        ExtendedTxnInfo extendedTxnInfo = this.f59010a.get(i2);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.itemView.getContext().getString(R.string.rs));
        double amount = extendedTxnInfo.getAmount();
        sb.append(b.a(amount, amount % 1.0d != 0.0d ? "##,##,##,##,###.00" : AppConstants.PRICE_PATTERN));
        String sb2 = sb.toString();
        aVar.f59011a.setText(extendedTxnInfo.getWalletId());
        aVar.f59012b.setText(sb2);
    }

    public final int getItemCount() {
        ArrayList<ExtendedTxnInfo> arrayList = this.f59010a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: net.one97.paytm.passbook.transactionDetail.a.a$a  reason: collision with other inner class name */
    class C1136a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f59011a;

        /* renamed from: b  reason: collision with root package name */
        TextView f59012b;

        public C1136a(View view) {
            super(view);
            this.f59011a = (TextView) view.findViewById(R.id.gvIdTV);
            this.f59012b = (TextView) view.findViewById(R.id.amountTV);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C1136a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_gv_list_item, (ViewGroup) null));
    }
}
