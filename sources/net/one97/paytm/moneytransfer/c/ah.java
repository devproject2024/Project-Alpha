package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.one97.paytm.moneytransfer.R;

public final class ah {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f53645a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53646b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f53647c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53648d;

    /* renamed from: e  reason: collision with root package name */
    public final RadioButton f53649e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53650f;

    /* renamed from: g  reason: collision with root package name */
    private final RelativeLayout f53651g;

    private ah(RelativeLayout relativeLayout, ImageView imageView, TextView textView, RelativeLayout relativeLayout2, TextView textView2, RadioButton radioButton, TextView textView3) {
        this.f53651g = relativeLayout;
        this.f53645a = imageView;
        this.f53646b = textView;
        this.f53647c = relativeLayout2;
        this.f53648d = textView2;
        this.f53649e = radioButton;
        this.f53650f = textView3;
    }

    public final RelativeLayout a() {
        return this.f53651g;
    }

    public static ah a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.bankImage);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.heading);
            if (textView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.leadRoot);
                if (relativeLayout != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.offer);
                    if (textView2 != null) {
                        RadioButton radioButton = (RadioButton) view.findViewById(R.id.radio_button);
                        if (radioButton != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.subheading);
                            if (textView3 != null) {
                                return new ah((RelativeLayout) view, imageView, textView, relativeLayout, textView2, radioButton, textView3);
                            }
                            str = "subheading";
                        } else {
                            str = "radioButton";
                        }
                    } else {
                        str = "offer";
                    }
                } else {
                    str = "leadRoot";
                }
            } else {
                str = "heading";
            }
        } else {
            str = "bankImage";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
