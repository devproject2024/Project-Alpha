package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.b.ak;
import com.travel.train.i.ab;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryAction;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryBody;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public final class bc extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f27935a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f27936b;

    /* renamed from: c  reason: collision with root package name */
    private CJRTrainSummaryItem f27937c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainOrderSummaryBody f27938d;

    /* renamed from: e  reason: collision with root package name */
    private ak f27939e;

    /* renamed from: f  reason: collision with root package name */
    private ab f27940f;

    public bc(View view, ab abVar) {
        super(view);
        this.f27935a = view.getContext();
        this.f27940f = abVar;
        this.f27936b = (RecyclerView) view.findViewById(R.id.horizontal_list_view_train_download_ticket);
        this.f27936b.setLayoutManager(new LinearLayoutManager(this.f27935a, 0, false));
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        if (context != null && iJRDataModel != null) {
            this.f27935a = context;
            this.f27937c = (CJRTrainSummaryItem) iJRDataModel;
            this.f27938d = (CJRTrainOrderSummaryBody) this.f27937c.getItem();
            ArrayList<CJRTrainOrderSummaryAction> orderActions = this.f27938d.getOrderActions();
            if (orderActions != null && orderActions.size() > 0) {
                this.f27939e = new ak(context, this.f27940f, orderActions);
                this.f27936b.setAdapter(this.f27939e);
                this.f27939e.notifyDataSetChanged();
            }
        }
    }
}
