package net.one97.paytm.upi.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.upi.R;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f66866a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66867b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f66868c;

    private p(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.f66868c = constraintLayout;
        this.f66866a = imageView;
        this.f66867b = textView;
    }

    public final ConstraintLayout a() {
        return this.f66868c;
    }

    public static p a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.collect_unsupported_bank_item_view, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bankImage);
        if (imageView != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.bankName);
            if (textView != null) {
                return new p((ConstraintLayout) inflate, imageView, textView);
            }
            str = "bankName";
        } else {
            str = "bankImage";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
