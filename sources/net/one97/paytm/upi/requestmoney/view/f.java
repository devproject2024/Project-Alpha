package net.one97.paytm.upi.requestmoney.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.requestmoney.a.c;

public class f extends h implements View.OnClickListener, c.C1401c {

    /* renamed from: a  reason: collision with root package name */
    private TextView f69437a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f69438b;

    /* renamed from: c  reason: collision with root package name */
    private e f69439c;

    /* renamed from: d  reason: collision with root package name */
    private c.a f69440d;

    /* renamed from: e  reason: collision with root package name */
    private Context f69441e;

    /* renamed from: f  reason: collision with root package name */
    private a f69442f;

    public interface a {
        void a(UpiDBTransactionModel upiDBTransactionModel);

        void b(ArrayList<UpiDBTransactionModel> arrayList);

        void n();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f69442f = (a) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_request_money_recent_txns_v2, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f69441e = view.getContext();
        this.f69437a = (TextView) view.findViewById(R.id.tv_view_all);
        this.f69438b = (RecyclerView) view.findViewById(R.id.rv_recent_txn_list);
        this.f69440d = new net.one97.paytm.upi.requestmoney.presenter.c(this, g.c());
        this.f69440d.a();
        this.f69439c = new e(this.f69441e, this.f69440d);
        this.f69438b.setLayoutManager(new LinearLayoutManager(this.f69441e));
        this.f69438b.setAdapter(this.f69439c);
        this.f69437a.setOnClickListener(this);
    }

    public final void a(ArrayList<UpiDBTransactionModel> arrayList) {
        if (!arrayList.isEmpty()) {
            e eVar = this.f69439c;
            eVar.f69427a.a(arrayList);
            eVar.notifyDataSetChanged();
            return;
        }
        a aVar = this.f69442f;
        if (aVar != null) {
            aVar.n();
        }
    }

    public final void a(UpiDBTransactionModel upiDBTransactionModel) {
        this.f69442f.a(upiDBTransactionModel);
    }

    public final void b(ArrayList<UpiDBTransactionModel> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            this.f69440d.b(arrayList);
            this.f69439c.notifyItemRangeInserted(this.f69440d.b() + 1, size);
        }
        this.f69437a.setVisibility(8);
    }

    public final void a(boolean z) {
        if (z) {
            this.f69437a.setVisibility(0);
        } else {
            this.f69437a.setVisibility(8);
        }
    }

    public final void c(ArrayList<UpiDBTransactionModel> arrayList) {
        a aVar = this.f69442f;
        if (aVar != null) {
            aVar.b(arrayList);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_view_all) {
            this.f69440d.c();
        }
    }
}
