package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainCancellationCharges;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import net.one97.paytm.common.entity.IJRDataModel;

public final class bd extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private ab f27941a;

    /* renamed from: b  reason: collision with root package name */
    private CJRTrainCancellationCharges f27942b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f27943c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f27944d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f27945e;

    /* renamed from: f  reason: collision with root package name */
    private CJRTrainSummaryItem f27946f;

    public bd(View view, ab abVar) {
        super(view);
        this.f27941a = abVar;
        this.f27943c = (RelativeLayout) view.findViewById(R.id.cancellation_container);
        this.f27944d = (TextView) view.findViewById(R.id.cancellation_label);
        this.f27945e = (TextView) view.findViewById(R.id.cancellation_value);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27946f = (CJRTrainSummaryItem) iJRDataModel;
        this.f27942b = (CJRTrainCancellationCharges) this.f27946f.getItem();
        CJRTrainCancellationCharges cJRTrainCancellationCharges = this.f27942b;
        if (cJRTrainCancellationCharges != null && cJRTrainCancellationCharges.getEnabled()) {
            this.f27943c.setVisibility(0);
            if (!TextUtils.isEmpty(this.f27942b.getLabel())) {
                this.f27944d.setVisibility(0);
                this.f27944d.setText(this.f27942b.getLabel());
            }
            if (!TextUtils.isEmpty(this.f27942b.getCharges())) {
                this.f27945e.setVisibility(0);
                this.f27945e.setText(this.f27942b.getCharges());
            }
        }
    }
}
