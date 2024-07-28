package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.b.v;
import com.travel.train.i.ae;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainCancellationItem;
import com.travel.train.model.trainticket.CJRTrainCancellationTemplate;
import net.one97.paytm.common.entity.IJRDataModel;

public final class am extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f27815a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f27816b;

    /* renamed from: c  reason: collision with root package name */
    private View f27817c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f27818d;

    /* renamed from: e  reason: collision with root package name */
    private CJRTrainCancellationTemplate f27819e;

    /* renamed from: f  reason: collision with root package name */
    private v f27820f;

    public am(View view) {
        super(view);
        this.f27816b = (TextView) view.findViewById(R.id.tv_title);
        this.f27817c = view.findViewById(R.id.v_title_divider);
        this.f27818d = (RecyclerView) view.findViewById(R.id.recycler_view);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27815a = context;
        this.f27819e = (CJRTrainCancellationTemplate) iJRDataModel;
        CJRTrainCancellationTemplate cJRTrainCancellationTemplate = this.f27819e;
        if (cJRTrainCancellationTemplate != null) {
            if (!TextUtils.isEmpty(cJRTrainCancellationTemplate.getTitle())) {
                this.f27816b.setText(this.f27819e.getTitle());
                this.f27816b.setVisibility(0);
            } else {
                this.f27816b.setVisibility(8);
            }
            if (this.f27819e.getItems() != null && this.f27819e.getItems().size() > 0) {
                if (ae.fromName(this.f27819e.getItems().get(0).getLayoutType()) == ae.HEADER_TYPE) {
                    this.f27817c.setVisibility(8);
                } else {
                    this.f27817c.setVisibility(0);
                }
                for (int i3 = 0; i3 < this.f27819e.getItems().size(); i3++) {
                    CJRTrainCancellationItem cJRTrainCancellationItem = this.f27819e.getItems().get(i3);
                    if (ae.fromName(cJRTrainCancellationItem.getLayoutType()) == ae.INS_TYPE) {
                        cJRTrainCancellationItem.setTitle("# ".concat(String.valueOf(i3)));
                    }
                }
            }
        }
        this.f27818d.setLayoutManager(new LinearLayoutManager(context.getApplicationContext()));
        this.f27820f = new v(context, this.f27819e.getItems());
        this.f27818d.setAdapter(this.f27820f);
    }
}
