package com.travel.train.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.travel.train.R;
import com.travel.train.i.v;

public final class az {

    /* renamed from: a  reason: collision with root package name */
    public TextView f27900a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27901b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintLayout f27902c;

    /* renamed from: d  reason: collision with root package name */
    v f27903d;

    public az(v vVar, View view) {
        this.f27903d = vVar;
        this.f27902c = (ConstraintLayout) view.findViewById(R.id.main_lyt);
        this.f27901b = (TextView) view.findViewById(R.id.train_name_txt);
        this.f27900a = (TextView) view.findViewById(R.id.train_no_txt);
    }
}
