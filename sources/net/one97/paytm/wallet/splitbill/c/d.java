package net.one97.paytm.wallet.splitbill.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupInfoBaseResponse;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupSnapshot;
import net.one97.paytm.wallet.splitbill.model.NonGroupExpensesAPIResponse.SBRequestHistory;

public class d extends h {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f72127a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.wallet.splitbill.a.d f72128b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f72129c;

    /* renamed from: d  reason: collision with root package name */
    private int f72130d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<SBRequestHistory> f72131e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<SBRequestHistory> f72132f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private SBGroupInfoBaseResponse f72133g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<SBGroupSnapshot> f72134h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<SBGroupSnapshot> f72135i = new ArrayList<>();

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f72129c = (Activity) context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sb_bill_settlement_fragment, (ViewGroup) null);
        if (getArguments() != null) {
            this.f72130d = getArguments().getInt("fragment_position");
            this.f72133g = (SBGroupInfoBaseResponse) getArguments().getSerializable("sb_response_get_group_info");
            this.f72131e = (ArrayList) getArguments().getSerializable("to_pay_list");
            this.f72132f = (ArrayList) getArguments().getSerializable("to_receive_list");
        }
        this.f72127a = (RecyclerView) inflate.findViewById(R.id.settlementList);
        this.f72127a.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        for (SBGroupSnapshot next : this.f72133g.getResponse().getGroupSnapshots()) {
            if (Float.parseFloat(next.getAmount()) < 0.0f) {
                this.f72134h.add(next);
            } else {
                this.f72135i.add(next);
            }
        }
        this.f72128b = new net.one97.paytm.wallet.splitbill.a.d(this.f72129c, this.f72130d);
        if (this.f72130d == 0) {
            this.f72128b.f71781a = this.f72134h;
        } else {
            this.f72128b.f71781a = this.f72135i;
        }
        this.f72127a.setAdapter(this.f72128b);
        return inflate;
    }
}
