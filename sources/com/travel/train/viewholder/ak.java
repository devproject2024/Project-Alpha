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

public final class ak extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f27807a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f27808b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f27809c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainCancellationItem f27810d;

    public ak(View view) {
        super(view);
        this.f27808b = (TextView) view.findViewById(R.id.tv_title);
        this.f27809c = (TextView) view.findViewById(R.id.tv_sub_title);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27807a = context;
        this.f27810d = (CJRTrainCancellationItem) iJRDataModel;
        if (!TextUtils.isEmpty(this.f27810d.getTitle())) {
            this.f27808b.setText(this.f27810d.getTitle());
            this.f27808b.setVisibility(0);
        } else {
            this.f27808b.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.f27810d.getDescription())) {
            this.f27809c.setText(this.f27810d.getDescription());
            this.f27809c.setVisibility(0);
            return;
        }
        this.f27809c.setVisibility(4);
    }
}
