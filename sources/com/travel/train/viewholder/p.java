package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;

public final class p extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public Context f28196a;

    /* renamed from: b  reason: collision with root package name */
    public CJRTrainDetailsBody f28197b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f28198c;

    /* renamed from: d  reason: collision with root package name */
    public RoboTextView f28199d;

    public p(View view, CJRTrainDetailsBody cJRTrainDetailsBody) {
        super(view);
        this.f28196a = view.getContext();
        this.f28197b = cJRTrainDetailsBody;
        this.f28199d = (RoboTextView) view.findViewById(R.id.email_txt);
        this.f28198c = (LinearLayout) view.findViewById(R.id.email_lyt);
    }
}
