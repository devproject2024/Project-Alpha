package com.travel.train.viewholder;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.e;

public final class m extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public Context f28159a;

    /* renamed from: b  reason: collision with root package name */
    e f28160b;

    /* renamed from: c  reason: collision with root package name */
    String f28161c;

    /* renamed from: d  reason: collision with root package name */
    float f28162d;

    /* renamed from: e  reason: collision with root package name */
    public CountDownTimer f28163e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f28164f;

    /* renamed from: g  reason: collision with root package name */
    String f28165g = "CJRIternaryTimerViewHolder";

    public m(View view, e eVar) {
        super(view);
        this.f28159a = view.getContext();
        this.f28160b = eVar;
        this.f28164f = (RelativeLayout) view.findViewById(R.id.timer_lyt);
        this.f28161c = this.f28159a.getString(R.string.train_countdown_timer_count);
    }
}
