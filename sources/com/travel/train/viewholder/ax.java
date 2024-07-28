package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.travel.train.R;
import com.travel.train.i.n;

public final class ax {

    /* renamed from: a  reason: collision with root package name */
    public TextView f27886a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27887b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintLayout f27888c;

    /* renamed from: d  reason: collision with root package name */
    n f27889d;

    /* renamed from: e  reason: collision with root package name */
    private Context f27890e;

    public ax(Context context, n nVar, View view) {
        this.f27890e = context;
        this.f27889d = nVar;
        this.f27888c = (ConstraintLayout) view.findViewById(R.id.main_lyt);
        this.f27887b = (TextView) view.findViewById(R.id.train_name_txt);
        this.f27886a = (TextView) view.findViewById(R.id.train_no_txt);
    }
}
