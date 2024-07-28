package net.one97.paytm.paymentsBank.slfd.interestprojection.a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.activity.FdPostTransactionActivity;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionItem;
import net.one97.paytm.paymentsBank.slfd.interestprojection.FDPostTransactionActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.c.a;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f19173a;

    /* renamed from: b  reason: collision with root package name */
    private List<SlfdTransactionItem> f19174b = new ArrayList();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        if (this.f19174b.size() > 0) {
            if (!a.C0336a.IBL_FD_CREATION.toString().equalsIgnoreCase(this.f19174b.get(i2).getTxnType())) {
                if (a.C0336a.IBL_FD_REDEMPTION.toString().equalsIgnoreCase(this.f19174b.get(i2).getTxnType())) {
                    aVar.f19175a.setBackground(this.f19173a.getResources().getDrawable(R.drawable.fixed_deposit_history_grey_icon));
                    TextView textView = aVar.f19176b;
                    textView.setText(" on " + net.one97.paytm.paymentsBank.slfd.b.a.a.a("dd MMM yyyy", "dd MMM yyyy", this.f19174b.get(i2).getTxnDate().longValue()));
                    aVar.f19179e.setText(this.f19173a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(this.f19174b.get(i2).getAmount())}));
                    switch (this.f19174b.get(i2).getStatus().intValue()) {
                        case 1182:
                            aVar.f19177c.setText(this.f19173a.getString(R.string.pb_transferred));
                            aVar.f19182h.setVisibility(0);
                            aVar.f19178d.setVisibility(0);
                            aVar.f19182h.setText(this.f19173a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(this.f19174b.get(i2).getProjectedInterest())}));
                            if (this.f19174b.get(i2).getNetTds().doubleValue() > 0.0d) {
                                aVar.k.setVisibility(0);
                                aVar.j.setVisibility(0);
                                aVar.k.setText(this.f19173a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(this.f19174b.get(i2).getNetTds())}));
                            } else {
                                aVar.k.setVisibility(8);
                                aVar.j.setVisibility(8);
                            }
                            aVar.f19180f.setVisibility(8);
                            aVar.f19181g.setVisibility(8);
                            aVar.f19183i.setVisibility(8);
                            break;
                        case 1183:
                            aVar.f19177c.setText(this.f19173a.getString(R.string.pb_transfer));
                            aVar.f19182h.setVisibility(8);
                            aVar.f19178d.setVisibility(8);
                            aVar.k.setVisibility(8);
                            aVar.j.setVisibility(8);
                            aVar.f19180f.setVisibility(8);
                            aVar.f19181g.setVisibility(0);
                            aVar.f19181g.setText(this.f19173a.getString(R.string.pb_processing));
                            aVar.f19181g.setTextColor(this.f19173a.getResources().getColor(net.one97.paytm.common.assets.R.color.color_ffa400));
                            aVar.f19183i.setVisibility(8);
                            break;
                        case 1184:
                            aVar.f19177c.setText(this.f19173a.getString(R.string.pb_transfer));
                            aVar.f19182h.setVisibility(8);
                            aVar.f19178d.setVisibility(8);
                            aVar.k.setVisibility(8);
                            aVar.j.setVisibility(8);
                            aVar.f19180f.setVisibility(8);
                            aVar.f19181g.setVisibility(0);
                            aVar.f19181g.setText(this.f19173a.getString(R.string.fd_failed));
                            aVar.f19181g.setTextColor(this.f19173a.getResources().getColor(net.one97.paytm.common.assets.R.color.color_fd5c5c));
                            aVar.f19183i.setVisibility(8);
                            break;
                        case 1185:
                            aVar.f19177c.setText(this.f19173a.getString(R.string.pb_transfer));
                            aVar.f19182h.setVisibility(8);
                            aVar.f19178d.setVisibility(8);
                            aVar.k.setVisibility(8);
                            aVar.j.setVisibility(8);
                            aVar.f19180f.setVisibility(8);
                            aVar.f19181g.setVisibility(0);
                            aVar.f19181g.setText(this.f19173a.getString(R.string.pb_processing));
                            aVar.f19181g.setTextColor(this.f19173a.getResources().getColor(net.one97.paytm.common.assets.R.color.color_ffa400));
                            aVar.f19183i.setVisibility(8);
                            break;
                        case 1186:
                            aVar.f19177c.setText(this.f19173a.getString(R.string.pb_transferred));
                            aVar.f19182h.setVisibility(0);
                            aVar.f19178d.setVisibility(0);
                            aVar.f19180f.setVisibility(0);
                            aVar.f19183i.setVisibility(0);
                            aVar.f19182h.setText(this.f19173a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(this.f19174b.get(i2).getProjectedInterest())}));
                            if (this.f19174b.get(i2).getNetTds().doubleValue() > 0.0d) {
                                aVar.k.setVisibility(0);
                                aVar.j.setVisibility(0);
                                aVar.k.setText(this.f19173a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(this.f19174b.get(i2).getNetTds())}));
                            } else {
                                aVar.k.setVisibility(8);
                                aVar.j.setVisibility(8);
                            }
                            aVar.f19181g.setVisibility(8);
                            Double amount = this.f19174b.get(i2).getAmount();
                            aVar.f19179e.setText(this.f19173a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(this.f19174b.get(i2).getAmount().doubleValue() - this.f19174b.get(i2).getFailedAmount().doubleValue()))}));
                            String c2 = net.one97.paytm.bankCommon.mapping.a.c(amount);
                            String c3 = net.one97.paytm.bankCommon.mapping.a.c(this.f19174b.get(i2).getFailedAmount());
                            TextView textView2 = aVar.f19183i;
                            SpannableString spannableString = new SpannableString(this.f19173a.getString(net.one97.paytm.common.assets.R.string.rs_str, new Object[]{c3}));
                            spannableString.setSpan(new ForegroundColorSpan(this.f19173a.getResources().getColor(net.one97.paytm.common.assets.R.color.color_fd5c5c)), 0, spannableString.length(), 33);
                            textView2.setText(spannableString);
                            SpannableString spannableString2 = new SpannableString("/".concat(String.valueOf(c2)));
                            spannableString2.setSpan(new ForegroundColorSpan(this.f19173a.getResources().getColor(R.color.color_222222)), 0, spannableString2.length(), 33);
                            textView2.append(spannableString2);
                            break;
                    }
                }
            } else {
                aVar.f19175a.setBackground(this.f19173a.getResources().getDrawable(R.drawable.fixed_deposit_history_green_icon));
                TextView textView3 = aVar.f19176b;
                textView3.setText(" on " + net.one97.paytm.paymentsBank.slfd.b.a.a.a("dd MMM yyyy", "dd MMM yyyy", this.f19174b.get(i2).getTxnDate().longValue()));
                aVar.f19177c.setText(this.f19173a.getString(R.string.pb_created));
                aVar.f19179e.setText(this.f19173a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(this.f19174b.get(i2).getAmount())}));
                aVar.f19182h.setVisibility(8);
                aVar.f19178d.setVisibility(8);
                aVar.k.setVisibility(8);
                aVar.j.setVisibility(8);
                aVar.f19180f.setVisibility(8);
                aVar.f19181g.setVisibility(8);
                aVar.f19183i.setVisibility(8);
                if (this.f19174b.get(i2).getStatus().intValue() == 1183) {
                    aVar.f19181g.setVisibility(0);
                } else {
                    aVar.f19181g.setVisibility(8);
                }
            }
            aVar.itemView.setOnClickListener(new View.OnClickListener(i2) {
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    c.this.a(this.f$1, view);
                }
            });
        }
    }

    public c(Context context, List<SlfdTransactionItem> list) {
        this.f19173a = context;
        this.f19174b.addAll(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, View view) {
        if (a.C0336a.IBL_FD_CREATION.toString().equalsIgnoreCase(this.f19174b.get(i2).getTxnType())) {
            Intent intent = new Intent(this.f19173a, FdPostTransactionActivity.class);
            b.a aVar = b.f18186a;
            intent.putExtra(b.f18190e, this.f19174b.get(i2).getOrderId());
            b.a aVar2 = b.f18186a;
            intent.putExtra(b.f18191f, "₹ " + net.one97.paytm.bankCommon.mapping.a.a(this.f19174b.get(i2).getAmount().doubleValue()));
            b.a aVar3 = b.f18186a;
            String e2 = b.f18192g;
            b.a aVar4 = b.f18186a;
            intent.putExtra(e2, b.n);
            this.f19173a.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f19173a, FDPostTransactionActivity.class);
        intent2.putExtra("order_id", this.f19174b.get(i2).getOrderId());
        intent2.putExtra("is_from_impulse", true);
        b.a aVar5 = b.f18186a;
        String e3 = b.f18192g;
        b.a aVar6 = b.f18186a;
        intent2.putExtra(e3, b.n);
        this.f19173a.startActivity(intent2);
    }

    public final int getItemCount() {
        return this.f19174b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f19175a;

        /* renamed from: b  reason: collision with root package name */
        TextView f19176b;

        /* renamed from: c  reason: collision with root package name */
        TextView f19177c;

        /* renamed from: d  reason: collision with root package name */
        TextView f19178d;

        /* renamed from: e  reason: collision with root package name */
        TextView f19179e;

        /* renamed from: f  reason: collision with root package name */
        TextView f19180f;

        /* renamed from: g  reason: collision with root package name */
        TextView f19181g;

        /* renamed from: h  reason: collision with root package name */
        TextView f19182h;

        /* renamed from: i  reason: collision with root package name */
        TextView f19183i;
        TextView j;
        TextView k;

        public a(View view) {
            super(view);
            this.f19175a = (ImageView) view.findViewById(R.id.iv_rndm_icon);
            this.f19176b = (TextView) view.findViewById(R.id.tv_time);
            this.f19177c = (TextView) view.findViewById(R.id.tv_transfer);
            this.f19178d = (TextView) view.findViewById(R.id.tv_interest_earned);
            this.f19179e = (TextView) view.findViewById(R.id.tv_fd_amount);
            this.f19180f = (TextView) view.findViewById(R.id.tv_failed_to_transfer);
            this.f19181g = (TextView) view.findViewById(R.id.tv_processing);
            this.f19182h = (TextView) view.findViewById(R.id.tv_interest_earned_amount);
            this.f19183i = (TextView) view.findViewById(R.id.tv_failed_to_transfer_amount);
            this.j = (TextView) view.findViewById(R.id.tv_tds);
            this.k = (TextView) view.findViewById(R.id.tv_tds_amount);
        }
    }

    public final void a(List<SlfdTransactionItem> list) {
        ArrayList arrayList = new ArrayList(this.f19174b);
        if (list != null && list.size() > 0) {
            List<SlfdTransactionItem> a2 = a((List<SlfdTransactionItem>) arrayList, list);
            this.f19174b.clear();
            this.f19174b.addAll(a2);
            notifyItemRangeChanged(0, getItemCount());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x000c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionItem> a(java.util.List<net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionItem> r5, java.util.List<net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionItem> r6) {
        /*
            if (r6 == 0) goto L_0x0053
            int r0 = r6.size()
            if (r0 <= 0) goto L_0x0053
            java.util.Iterator r6 = r6.iterator()
        L_0x000c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0053
            java.lang.Object r0 = r6.next()
            net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionItem r0 = (net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionItem) r0
            int r1 = r5.size()
            if (r1 <= 0) goto L_0x004c
            java.util.Iterator r1 = r5.iterator()
        L_0x0022:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004c
            java.lang.Object r2 = r1.next()
            net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionItem r2 = (net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionItem) r2
            java.lang.String r3 = r0.getOrderId()
            java.lang.String r4 = r2.getOrderId()
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0022
            java.lang.String r3 = r0.getFdId()
            java.lang.String r2 = r2.getFdId()
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0022
            r1 = 1
            goto L_0x004d
        L_0x004c:
            r1 = 0
        L_0x004d:
            if (r1 != 0) goto L_0x000c
            r5.add(r0)
            goto L_0x000c
        L_0x0053:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.slfd.interestprojection.a.c.a(java.util.List, java.util.List):java.util.List");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_fixed_deposit_history, viewGroup, false));
    }
}
