package net.one97.paytm.transport.iocl.b;

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
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl.activity.IOCLBaseActivity;
import net.one97.paytm.transport.iocl.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl.data.IOCLCommonResponse;

public final class d extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<net.one97.paytm.transport.iocl.data.a> f14281a;

    /* renamed from: b  reason: collision with root package name */
    Context f14282b;

    /* renamed from: c  reason: collision with root package name */
    public String f14283c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f14284d;

    /* renamed from: e  reason: collision with root package name */
    private b f14285e;

    public interface b {
        void b();
    }

    public d(Context context, b bVar) {
        this.f14282b = context;
        this.f14285e = bVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (this.f14284d == null) {
            this.f14284d = LayoutInflater.from(viewGroup.getContext());
        }
        if (i2 == 0) {
            return new c(this.f14284d.inflate(R.layout.iocl_date_header_item, viewGroup, false));
        }
        if (i2 == 1) {
            return new a(this.f14284d.inflate(R.layout.transaction_item_iocl, (ViewGroup) null));
        }
        return null;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            net.one97.paytm.transport.iocl.data.a aVar2 = this.f14281a.get(i2);
            aVar.f14288c.setText(String.format("%.1f", new Object[]{aVar2.f14321g}));
            aVar.f14287b.setText(new SimpleDateFormat("HH:mm a").format(new Date(aVar2.f14319e.longValue())));
            if ("PENDING".equalsIgnoreCase(aVar2.f14318d)) {
                aVar.f14289d.setTextColor(androidx.core.content.b.c(this.f14282b, R.color.color_ffa400));
                aVar.f14289d.setText(this.f14282b.getString(R.string.iocl_pending));
                aVar.f14289d.setVisibility(0);
            } else if ("FAILURE".equalsIgnoreCase(aVar2.f14318d)) {
                aVar.f14289d.setTextColor(androidx.core.content.b.c(this.f14282b, R.color.color_fd5c5c));
                aVar.f14289d.setText(this.f14282b.getString(R.string.iocl_failed));
                aVar.f14289d.setVisibility(0);
            } else {
                aVar.f14289d.setVisibility(8);
            }
            aVar.f14286a.setText(aVar2.f14316b);
            aVar.f14290e = aVar2;
        } else if (vVar instanceof c) {
            c cVar = (c) vVar;
            cVar.f14292a.setText(this.f14281a.get(i2).f14322h);
            if (i2 != 0) {
                cVar.f14293b.setVisibility(8);
                return;
            }
            cVar.f14293b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.this.a(view);
                }
            });
            cVar.f14293b.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f14285e.b();
    }

    public final int getItemCount() {
        ArrayList<net.one97.paytm.transport.iocl.data.a> arrayList = this.f14281a;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.f14281a.size();
    }

    public final int getItemViewType(int i2) {
        return !TextUtils.isEmpty(this.f14281a.get(i2).f14322h) ? 0 : 1;
    }

    public final void a(ArrayList<net.one97.paytm.transport.iocl.data.a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            ArrayList<net.one97.paytm.transport.iocl.data.a> arrayList2 = new ArrayList<>();
            arrayList2.add(new net.one97.paytm.transport.iocl.data.a(a(Long.valueOf(Calendar.getInstance().getTimeInMillis()))));
            this.f14281a = arrayList2;
            return;
        }
        ArrayList<net.one97.paytm.transport.iocl.data.a> arrayList3 = new ArrayList<>();
        this.f14283c = a(arrayList.get(0).f14319e);
        arrayList3.add(new net.one97.paytm.transport.iocl.data.a(this.f14283c));
        arrayList3.add(arrayList.get(0));
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            if (!this.f14283c.equalsIgnoreCase(a(arrayList.get(i2).f14319e))) {
                arrayList3.add(new net.one97.paytm.transport.iocl.data.a(a(arrayList.get(i2).f14319e)));
                this.f14283c = a(arrayList.get(i2).f14319e);
            }
            arrayList3.add(arrayList.get(i2));
        }
        this.f14281a = arrayList3;
        notifyDataSetChanged();
    }

    public final String a(Long l) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        Date date = new Date(l.longValue());
        if (DateUtils.isToday(date.getTime())) {
            return this.f14282b.getString(R.string.today_btn) + ", " + simpleDateFormat.format(date);
        } else if (!DateUtils.isToday(date.getTime() + TimeUnit.DAYS.toMillis(1))) {
            return simpleDateFormat.format(date);
        } else {
            return this.f14282b.getString(R.string.yesterday) + ", " + simpleDateFormat.format(date);
        }
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f14292a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f14293b;

        public c(View view) {
            super(view);
            this.f14292a = (TextView) view.findViewById(R.id.date);
            this.f14293b = (TextView) view.findViewById(R.id.tv_filter);
        }
    }

    class a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f14286a;

        /* renamed from: b  reason: collision with root package name */
        TextView f14287b;

        /* renamed from: c  reason: collision with root package name */
        TextView f14288c;

        /* renamed from: d  reason: collision with root package name */
        TextView f14289d;

        /* renamed from: e  reason: collision with root package name */
        net.one97.paytm.transport.iocl.data.a f14290e;

        public a(View view) {
            super(view);
            this.f14286a = (TextView) view.findViewById(R.id.passbook_send_receive_type_tv);
            this.f14287b = (TextView) view.findViewById(R.id.passbook_send_receive_time);
            this.f14288c = (TextView) view.findViewById(R.id.passbook_sender_receiver_amount_tv);
            this.f14289d = (TextView) view.findViewById(R.id.passbook_sender_receiver_txn_status_tv);
            view.setOnClickListener(this);
        }

        public final void onClick(View view) {
            IOCLBaseModel iOCLBaseModel = new IOCLBaseModel();
            iOCLBaseModel.setResponse(new IOCLCommonResponse());
            iOCLBaseModel.getResponse().setPrimaryMessage(this.f14290e.f14315a);
            iOCLBaseModel.getResponse().setRedeemStatus(this.f14290e.f14318d);
            iOCLBaseModel.getResponse().setTransactionAmount(this.f14290e.f14317c);
            iOCLBaseModel.getResponse().setTransactionTime(this.f14290e.f14319e);
            iOCLBaseModel.getResponse().setEarnedOrRedeemed(this.f14290e.f14316b);
            if (!TextUtils.isEmpty(this.f14290e.f14320f)) {
                iOCLBaseModel.getResponse().setIoclTxnNo(this.f14290e.f14320f);
            }
            iOCLBaseModel.getResponse().setTransactionPoints(this.f14290e.f14321g);
            ((IOCLBaseActivity) d.this.f14282b).a((Object) iOCLBaseModel);
        }
    }
}
