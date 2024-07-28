package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainGstDetails;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryBody;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import net.one97.paytm.common.entity.IJRDataModel;

public final class at extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f27872a;

    /* renamed from: b  reason: collision with root package name */
    private CJRTrainSummaryItem f27873b;

    /* renamed from: c  reason: collision with root package name */
    private ab f27874c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainGstDetails f27875d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f27876e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f27877f;

    public at(View view, ab abVar) {
        super(view);
        this.f27874c = abVar;
        this.f27876e = (TextView) view.findViewById(R.id.gst_number);
        this.f27877f = (TextView) view.findViewById(R.id.name_in_gst);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27872a = context;
        this.f27873b = (CJRTrainSummaryItem) iJRDataModel;
        this.f27875d = ((CJRTrainOrderSummaryBody) this.f27873b.getItem()).getGstDetails();
        CJRTrainGstDetails cJRTrainGstDetails = this.f27875d;
        if (cJRTrainGstDetails != null) {
            String nameOnGst = cJRTrainGstDetails.getNameOnGst();
            String gstIn = this.f27875d.getGstIn();
            if (nameOnGst != null && !TextUtils.isEmpty(nameOnGst)) {
                this.f27877f.setText(nameOnGst);
            }
            if (gstIn != null && !TextUtils.isEmpty(gstIn)) {
                this.f27876e.setText(gstIn);
            }
        }
    }
}
