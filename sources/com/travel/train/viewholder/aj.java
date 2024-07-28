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

public final class aj extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f27803a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f27804b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f27805c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainCancellationItem f27806d;

    public aj(View view) {
        super(view);
        this.f27804b = (TextView) view.findViewById(R.id.tv_title);
        this.f27805c = (TextView) view.findViewById(R.id.tv_sub_title);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27803a = context;
        this.f27806d = (CJRTrainCancellationItem) iJRDataModel;
        if (!TextUtils.isEmpty(this.f27806d.getTitle())) {
            this.f27804b.setText(this.f27806d.getTitle());
            this.f27804b.setVisibility(0);
        } else {
            this.f27804b.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.f27806d.getDescription())) {
            this.f27805c.setText(this.f27806d.getDescription());
            this.f27805c.setVisibility(0);
            return;
        }
        this.f27805c.setVisibility(4);
    }
}
