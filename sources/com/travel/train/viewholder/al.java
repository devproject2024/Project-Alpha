package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainCancellationItem;
import net.one97.paytm.common.entity.IJRDataModel;

public final class al extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f27811a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f27812b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f27813c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainCancellationItem f27814d;

    public al(View view) {
        super(view);
        this.f27812b = (TextView) view.findViewById(R.id.tv_serial_no);
        this.f27813c = (TextView) view.findViewById(R.id.tv_description);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27811a = context;
        this.f27814d = (CJRTrainCancellationItem) iJRDataModel;
        if (!TextUtils.isEmpty(this.f27814d.getTitle())) {
            this.f27812b.setText(this.f27814d.getTitle());
            this.f27812b.setVisibility(0);
        } else {
            this.f27812b.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.f27814d.getDescription())) {
            this.f27813c.setText(this.f27814d.getDescription());
            this.f27813c.setVisibility(0);
            return;
        }
        this.f27813c.setVisibility(4);
    }
}
