package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.one97.paytm.moneytransfer.R;

public final class ap {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f53707a;

    private ap(TextView textView) {
        this.f53707a = textView;
    }

    public final TextView a() {
        return this.f53707a;
    }

    public static ap a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.transfer_to_bank_acc_title_item_view, viewGroup, false);
        if (inflate != null) {
            return new ap((TextView) inflate);
        }
        throw new NullPointerException("rootView");
    }
}
