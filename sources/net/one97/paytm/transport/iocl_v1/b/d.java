package net.one97.paytm.transport.iocl_v1.b;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity;
import net.one97.paytm.transport.iocl_v1.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse;

public final class d extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<net.one97.paytm.transport.iocl_v1.data.a> f14417a;

    /* renamed from: b  reason: collision with root package name */
    Context f14418b;

    /* renamed from: c  reason: collision with root package name */
    public String f14419c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f14420d;

    public d(Context context) {
        this.f14418b = context;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (this.f14420d == null) {
            this.f14420d = LayoutInflater.from(viewGroup.getContext());
        }
        if (i2 == 0) {
            return new b(this.f14420d.inflate(R.layout.iocl_date_header_item_v1, viewGroup, false));
        }
        if (i2 == 1) {
            return new a(this.f14420d.inflate(R.layout.transaction_item_iocl, (ViewGroup) null));
        }
        return null;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            net.one97.paytm.transport.iocl_v1.data.a aVar2 = this.f14417a.get(i2);
            aVar.f14423c.setText(String.format("%.0f", new Object[]{aVar2.f14453g}));
            aVar.f14422b.setText(new SimpleDateFormat("HH:mm a").format(new Date(aVar2.f14451e.longValue())));
            if ("PENDING".equalsIgnoreCase(aVar2.f14450d)) {
                aVar.f14424d.setTextColor(androidx.core.content.b.c(this.f14418b, R.color.color_ffa400));
                aVar.f14424d.setText(this.f14418b.getString(R.string.iocl_pending));
                aVar.f14424d.setVisibility(0);
            } else if ("FAILURE".equalsIgnoreCase(aVar2.f14450d)) {
                aVar.f14424d.setTextColor(androidx.core.content.b.c(this.f14418b, R.color.color_fd5c5c));
                aVar.f14424d.setText(this.f14418b.getString(R.string.iocl_failed));
                aVar.f14424d.setVisibility(0);
            } else {
                aVar.f14424d.setVisibility(8);
            }
            aVar.f14421a.setText(aVar2.f14448b);
            aVar.f14425e = aVar2;
        } else if (vVar instanceof b) {
            ((b) vVar).f14427a.setText(this.f14417a.get(i2).f14454h);
        }
    }

    public final int getItemCount() {
        ArrayList<net.one97.paytm.transport.iocl_v1.data.a> arrayList = this.f14417a;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.f14417a.size();
    }

    public final int getItemViewType(int i2) {
        return !TextUtils.isEmpty(this.f14417a.get(i2).f14454h) ? 0 : 1;
    }

    public final void a(ArrayList<net.one97.paytm.transport.iocl_v1.data.a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (!this.f14419c.equalsIgnoreCase(a(arrayList.get(i2).f14451e))) {
                    arrayList2.add(new net.one97.paytm.transport.iocl_v1.data.a(a(arrayList.get(i2).f14451e)));
                    this.f14419c = a(arrayList.get(i2).f14451e);
                }
                arrayList2.add(arrayList.get(i2));
            }
            this.f14417a.addAll(arrayList2);
            notifyDataSetChanged();
        }
    }

    public final String a(Long l) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        Date date = new Date(l.longValue());
        if (DateUtils.isToday(date.getTime())) {
            return this.f14418b.getString(R.string.today_btn) + ", " + simpleDateFormat.format(date);
        } else if (!DateUtils.isToday(date.getTime() + TimeUnit.DAYS.toMillis(1))) {
            return simpleDateFormat.format(date);
        } else {
            return this.f14418b.getString(R.string.yesterday) + ", " + simpleDateFormat.format(date);
        }
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f14427a;

        public b(View view) {
            super(view);
            this.f14427a = (TextView) view.findViewById(R.id.date);
        }
    }

    class a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f14421a;

        /* renamed from: b  reason: collision with root package name */
        TextView f14422b;

        /* renamed from: c  reason: collision with root package name */
        TextView f14423c;

        /* renamed from: d  reason: collision with root package name */
        TextView f14424d;

        /* renamed from: e  reason: collision with root package name */
        net.one97.paytm.transport.iocl_v1.data.a f14425e;

        public a(View view) {
            super(view);
            this.f14421a = (TextView) view.findViewById(R.id.passbook_send_receive_type_tv);
            this.f14422b = (TextView) view.findViewById(R.id.passbook_send_receive_time);
            this.f14423c = (TextView) view.findViewById(R.id.passbook_sender_receiver_amount_tv);
            this.f14424d = (TextView) view.findViewById(R.id.passbook_sender_receiver_txn_status_tv);
            view.setOnClickListener(this);
        }

        public final void onClick(View view) {
            IOCLBaseModel iOCLBaseModel = new IOCLBaseModel();
            iOCLBaseModel.setResponse(new IOCLCommonResponse());
            iOCLBaseModel.getResponse().setPrimaryMessage(this.f14425e.f14447a);
            iOCLBaseModel.getResponse().setRedeemStatus(this.f14425e.f14450d);
            iOCLBaseModel.getResponse().setTransactionAmount(this.f14425e.f14449c);
            iOCLBaseModel.getResponse().setTransactionTime(this.f14425e.f14451e);
            if (!TextUtils.isEmpty(this.f14425e.f14452f)) {
                iOCLBaseModel.getResponse().setIoclTxnNo(this.f14425e.f14452f);
            }
            iOCLBaseModel.getResponse().setTransactionPoints(this.f14425e.f14453g);
            ((IOCLBaseActivity) d.this.f14418b).a((Object) iOCLBaseModel);
        }
    }
}
