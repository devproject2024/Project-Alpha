package net.one97.paytm.passbook.transactionDetail.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.i.f;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.ExtendedTxnInfo;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.transactionDetail.a.a;

public class e extends f {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f59070a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f59071b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f59072c;

    /* renamed from: d  reason: collision with root package name */
    private int f59073d = 0;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<ExtendedTxnInfo> f59074e;

    /* renamed from: f  reason: collision with root package name */
    private a f59075f;

    public e() {
    }

    public e(ArrayList<ExtendedTxnInfo> arrayList) {
        this.f59074e = arrayList;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pass_dialog_gv_details_list, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f59070a = (RecyclerView) view.findViewById(R.id.data_rv);
        this.f59070a.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f59075f = new a();
        this.f59071b = (TextView) view.findViewById(R.id.header_tv);
        this.f59072c = (RelativeLayout) view.findViewById(R.id.loader_rl);
        view.findViewById(R.id.cross_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.a(view);
            }
        });
        this.f59070a.setFocusable(false);
        this.f59070a.setAdapter(this.f59075f);
        net.one97.paytm.passbook.mapping.f b2 = d.b();
        getContext();
        String x = b2.x();
        TextView textView = this.f59071b;
        textView.setText(getString(R.string.no_of) + " " + x + ": " + this.f59074e.size());
        this.f59075f.f59010a = this.f59074e;
        try {
            ((View) view.getParent()).setBackgroundColor(getResources().getColor(17170445));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }
}
