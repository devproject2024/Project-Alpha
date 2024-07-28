package com.travel.citybus.brts.citybus;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.citybus.R;
import kotlin.g.b.k;

public final class d extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    final RoboTextView f23280a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view) {
        super(view);
        k.c(view, "itemView");
        View findViewById = view.findViewById(R.id.dp_name);
        k.a((Object) findViewById, "itemView.findViewById(R.id.dp_name)");
        this.f23280a = (RoboTextView) findViewById;
    }
}
