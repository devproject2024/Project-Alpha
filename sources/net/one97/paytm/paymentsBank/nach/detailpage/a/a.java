package net.one97.paytm.paymentsBank.nach.detailpage.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.b;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.a.d;
import net.one97.paytm.paymentsBank.model.nach.MontranTransactionDataList;

public final class a extends d<MontranTransactionDataList> {
    public final /* synthetic */ void a(Object obj, d.b bVar, int i2) {
        MontranTransactionDataList montranTransactionDataList = (MontranTransactionDataList) obj;
        TextView textView = (TextView) bVar.a(R.id.transStatusTv);
        Context context = this.f17309a;
        int i3 = R.string.pb_nach_rupee;
        StringBuilder sb = new StringBuilder();
        sb.append(montranTransactionDataList.getAmount());
        ((TextView) bVar.a(R.id.transRupeeTv)).setText(context.getString(i3, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(sb.toString())}));
        ((TextView) bVar.a(R.id.transDateTv)).setText(montranTransactionDataList.getCreatedData());
        String transactionStatus = montranTransactionDataList.getTransactionStatus();
        if (!TextUtils.isEmpty(transactionStatus)) {
            if ("SUCCESS".equalsIgnoreCase(transactionStatus)) {
                textView.setTextColor(b.c(this.f17309a, R.color.green));
            } else {
                textView.setTextColor(b.c(this.f17309a, R.color.red));
            }
            textView.setText(transactionStatus.substring(0, 1).toUpperCase() + transactionStatus.substring(1).toLowerCase());
            return;
        }
        textView.setText("");
    }

    public a(Context context) {
        super(context);
    }

    public final View a(Context context, ViewGroup viewGroup, int i2) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.pb_nach_detail_transaction_list_item, viewGroup, false);
    }
}
