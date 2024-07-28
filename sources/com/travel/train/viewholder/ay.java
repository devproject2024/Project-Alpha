package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.s;

public final class ay extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f27893a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27894b;

    /* renamed from: c  reason: collision with root package name */
    public s f27895c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27896d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27897e;

    public ay(View view, Context context, s sVar) {
        super(view);
        this.f27894b = context;
        this.f27895c = sVar;
        this.f27893a = (LinearLayout) view.findViewById(R.id.main_lyt);
        this.f27896d = (TextView) view.findViewById(R.id.txt1);
        this.f27897e = (TextView) view.findViewById(R.id.txt2);
    }
}
