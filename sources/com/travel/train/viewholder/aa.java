package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.travel.train.R;
import com.travel.train.i.aj;
import com.travel.train.i.g;

public final class aa extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f27749a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f27750b;

    /* renamed from: c  reason: collision with root package name */
    public RoboTextView f27751c;

    /* renamed from: d  reason: collision with root package name */
    private g f27752d;

    public aa(View view, g gVar) {
        super(view);
        this.f27749a = view.getContext();
        this.f27752d = gVar;
        this.f27750b = (RelativeLayout) view.findViewById(R.id.user_id_container);
        this.f27751c = (RoboTextView) view.findViewById(R.id.user_id_text);
        String W = b.W(this.f27749a);
        if (W != null && !TextUtils.isEmpty(W)) {
            this.f27751c.setText(W);
        }
        this.f27750b.setOnClickListener(this);
    }

    public final void onClick(View view) {
        this.f27752d.a(aj.USER_ID_EDIT_CLICK);
    }
}
