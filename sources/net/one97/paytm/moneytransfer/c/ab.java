package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.moneytransfer.R;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f53608a;

    private ab(ConstraintLayout constraintLayout) {
        this.f53608a = constraintLayout;
    }

    public final ConstraintLayout a() {
        return this.f53608a;
    }

    public static ab a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.mt_v4_beneficiary_view_all, viewGroup, false);
        if (inflate != null) {
            return new ab((ConstraintLayout) inflate);
        }
        throw new NullPointerException("rootView");
    }
}
