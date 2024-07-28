package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import net.one97.paytm.upi.R;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f66851a;

    /* renamed from: b  reason: collision with root package name */
    public final RadioGroup f66852b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f66853c;

    private m(LinearLayout linearLayout, ImageView imageView, RadioGroup radioGroup) {
        this.f66853c = linearLayout;
        this.f66851a = imageView;
        this.f66852b = radioGroup;
    }

    public static m a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.closeButton);
        if (imageView != null) {
            RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.typeRadioGroup);
            if (radioGroup != null) {
                return new m((LinearLayout) view, imageView, radioGroup);
            }
            str = "typeRadioGroup";
        } else {
            str = "closeButton";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
