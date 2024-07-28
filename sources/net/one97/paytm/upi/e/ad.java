package net.one97.paytm.upi.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.upi.R;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f66741a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66742b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f66743c;

    private ad(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.f66743c = constraintLayout;
        this.f66741a = imageView;
        this.f66742b = textView;
    }

    public final ConstraintLayout a() {
        return this.f66743c;
    }

    public static ad a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.upi_account_provider_grid_item, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bankImage);
        if (imageView != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.bankName);
            if (textView != null) {
                return new ad((ConstraintLayout) inflate, imageView, textView);
            }
            str = "bankName";
        } else {
            str = "bankImage";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
