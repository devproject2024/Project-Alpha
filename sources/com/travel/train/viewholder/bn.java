package com.travel.train.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryBody;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import net.one97.paytm.common.entity.IJRDataModel;

public final class bn extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f28037a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f28038b;

    /* renamed from: c  reason: collision with root package name */
    private CJRTrainSummaryItem f28039c;

    /* renamed from: d  reason: collision with root package name */
    private ab f28040d;

    public bn(View view, ab abVar) {
        super(view);
        this.f28038b = (LinearLayout) view.findViewById(R.id.travellers_main_lyt);
        this.f28040d = abVar;
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f28037a = context;
        this.f28039c = (CJRTrainSummaryItem) iJRDataModel;
        CJRTrainOrderSummaryBody cJRTrainOrderSummaryBody = (CJRTrainOrderSummaryBody) this.f28039c.getItem();
        this.f28038b.removeAllViews();
        if (cJRTrainOrderSummaryBody != null && cJRTrainOrderSummaryBody.getPaxInfo() != null && cJRTrainOrderSummaryBody.getPaxInfo().size() > 0) {
            for (int i3 = 0; i3 < cJRTrainOrderSummaryBody.getPaxInfo().size(); i3++) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.pre_t_train_os_traveller_ticket_status_item, (ViewGroup) null);
                inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                br brVar = new br(inflate, this.f28040d);
                brVar.a(context, cJRTrainOrderSummaryBody.getPaxInfo().get(i3));
                if (i3 == cJRTrainOrderSummaryBody.getPaxInfo().size() - 1) {
                    brVar.f28052b.setVisibility(8);
                } else {
                    brVar.f28052b.setVisibility(0);
                }
                this.f28038b.addView(inflate);
            }
        }
    }
}
