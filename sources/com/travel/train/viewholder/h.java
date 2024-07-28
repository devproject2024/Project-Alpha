package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.e;

public final class h extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    Context f28123a;

    /* renamed from: b  reason: collision with root package name */
    e f28124b;

    /* renamed from: c  reason: collision with root package name */
    String f28125c = "CJRIternaryOldCancellationInsuranceViewHolder";

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f28126d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f28127e;

    public h(View view, e eVar) {
        super(view);
        this.f28123a = view.getContext();
        this.f28124b = eVar;
        this.f28126d = (LinearLayout) view.findViewById(R.id.cancellation_container);
        this.f28127e = (CheckBox) view.findViewById(R.id.cancel_insurance_checkbox);
    }

    public final boolean a() {
        CheckBox checkBox = this.f28127e;
        if (checkBox != null) {
            return checkBox.isChecked();
        }
        return false;
    }
}
