package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.ah;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryFooter;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryResponse;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ap extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    CJRTrainSummaryItem f27839a;

    /* renamed from: b  reason: collision with root package name */
    ab f27840b;

    /* renamed from: c  reason: collision with root package name */
    private Context f27841c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f27842d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f27843e;

    /* renamed from: f  reason: collision with root package name */
    private CJRTrainOrderSummaryResponse f27844f;

    /* renamed from: g  reason: collision with root package name */
    private CJRTrainOrderSummaryFooter f27845g;

    public ap(final View view, ab abVar) {
        super(view);
        this.f27840b = abVar;
        this.f27842d = (TextView) view.findViewById(R.id.contact_details);
        this.f27843e = (TextView) view.findViewById(R.id.contact_description);
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ap.this.f27840b.a(ap.this.f27839a, ah.CONTACT_US_CLICK);
            }
        });
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27841c = context;
        this.f27839a = (CJRTrainSummaryItem) iJRDataModel;
        CJRTrainSummaryItem cJRTrainSummaryItem = this.f27839a;
        if (cJRTrainSummaryItem != null && cJRTrainSummaryItem.getItem() != null) {
            this.f27844f = (CJRTrainOrderSummaryResponse) this.f27839a.getItem();
            if (this.f27844f.getBody().getFooter() != null) {
                this.f27845g = this.f27844f.getBody().getFooter();
                if (!TextUtils.isEmpty(this.f27845g.getHeader())) {
                    this.f27842d.setText(this.f27845g.getHeader());
                }
                if (!TextUtils.isEmpty(this.f27845g.getDescription())) {
                    this.f27843e.setText(this.f27845g.getDescription());
                }
            }
        }
    }
}
