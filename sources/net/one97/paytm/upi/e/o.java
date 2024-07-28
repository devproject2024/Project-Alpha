package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import net.one97.paytm.upi.R;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f66863a;

    /* renamed from: b  reason: collision with root package name */
    public final RadioGroup f66864b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f66865c;

    private o(LinearLayout linearLayout, ImageView imageView, RadioGroup radioGroup) {
        this.f66865c = linearLayout;
        this.f66863a = imageView;
        this.f66864b = radioGroup;
    }

    public static o a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.closeButton);
        if (imageView != null) {
            RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.typeRadioGroup);
            if (radioGroup != null) {
                return new o((LinearLayout) view, imageView, radioGroup);
            }
            str = "typeRadioGroup";
        } else {
            str = "closeButton";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
