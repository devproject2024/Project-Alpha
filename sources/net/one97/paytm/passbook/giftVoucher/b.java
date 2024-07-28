package net.one97.paytm.passbook.giftVoucher;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.SubwalletStatusResponseList;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.utility.q;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<SubwalletStatusResponseList> f57531a;

    /* renamed from: b  reason: collision with root package name */
    C1083b f57532b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f57533c = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    /* renamed from: net.one97.paytm.passbook.giftVoucher.b$b  reason: collision with other inner class name */
    public interface C1083b {
        void a(SubwalletStatusResponseList subwalletStatusResponseList);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        String str = this.f57533c.get(i2 % 10);
        final SubwalletStatusResponseList subwalletStatusResponseList = this.f57531a.get(i2);
        String str2 = "";
        String issuerName = !TextUtils.isEmpty(subwalletStatusResponseList.getIssuerName()) ? subwalletStatusResponseList.getIssuerName() : str2;
        if (!TextUtils.isEmpty(issuerName)) {
            issuerName = issuerName.trim();
            String[] split = issuerName.split(" ");
            String upperCase = String.valueOf(split[0].charAt(0)).toUpperCase();
            if (split != null && split.length > 1) {
                try {
                    str2 = String.valueOf(split[1].charAt(0)).toUpperCase();
                } catch (Exception unused) {
                }
            }
            str2 = upperCase + str2;
        } else if (!TextUtils.isEmpty(subwalletStatusResponseList.getIssuerPhoneNo())) {
            str2 = String.valueOf(subwalletStatusResponseList.getIssuerPhoneNo().substring(0, 2)).toUpperCase();
            issuerName = subwalletStatusResponseList.getIssuerPhoneNo();
        }
        String string = d.b().b().getString(R.string.wallet_rs);
        String format = new DecimalFormat(q.a(Double.parseDouble(subwalletStatusResponseList.getTxnAmount())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(subwalletStatusResponseList.getTxnAmount()));
        aVar.f57537b.setText(String.format(d.b().b().getString(R.string.gv_from), new Object[]{issuerName}));
        if (!TextUtils.isEmpty(str2)) {
            aVar.f57536a.setText(str2);
            aVar.f57536a.setBackgroundColor(Color.parseColor(str));
        }
        if (!TextUtils.isEmpty(subwalletStatusResponseList.getCreateTimestamp())) {
            aVar.f57538c.setText(String.format(d.b().b().getString(R.string.gv_expiry), new Object[]{q.a("dd-MM-yyyy", "dd MMM yyyy", subwalletStatusResponseList.getCreateTimestamp())}));
        }
        aVar.f57539d.setText(String.format(string, new Object[]{format}));
        aVar.f57540e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.f57532b.a(subwalletStatusResponseList);
            }
        });
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f57536a;

        /* renamed from: b  reason: collision with root package name */
        TextView f57537b;

        /* renamed from: c  reason: collision with root package name */
        TextView f57538c;

        /* renamed from: d  reason: collision with root package name */
        TextView f57539d;

        /* renamed from: e  reason: collision with root package name */
        TextView f57540e;

        public a(View view) {
            super(view);
            this.f57536a = (TextView) view.findViewById(R.id.gvImageTitle);
            this.f57537b = (TextView) view.findViewById(R.id.tvGvFrom);
            this.f57538c = (TextView) view.findViewById(R.id.gvExpires);
            this.f57539d = (TextView) view.findViewById(R.id.tvRedeemAmount);
            this.f57540e = (TextView) view.findViewById(R.id.tvGvRedeem);
        }
    }

    public b(ArrayList<SubwalletStatusResponseList> arrayList, C1083b bVar) {
        this.f57531a = arrayList;
        this.f57532b = bVar;
    }

    public final int getItemCount() {
        return this.f57531a.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_gv_redeem_item, viewGroup, false));
    }
}
