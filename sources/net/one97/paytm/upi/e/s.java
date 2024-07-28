package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.CircularImageView;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66884a;

    /* renamed from: b  reason: collision with root package name */
    public final MaterialCardView f66885b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f66886c;

    /* renamed from: d  reason: collision with root package name */
    public final CircularImageView f66887d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f66888e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f66889f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f66890g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f66891h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f66892i;
    private final FrameLayout j;

    private s(FrameLayout frameLayout, TextView textView, MaterialCardView materialCardView, ImageView imageView, CircularImageView circularImageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.j = frameLayout;
        this.f66884a = textView;
        this.f66885b = materialCardView;
        this.f66886c = imageView;
        this.f66887d = circularImageView;
        this.f66888e = textView2;
        this.f66889f = textView3;
        this.f66890g = textView4;
        this.f66891h = textView5;
        this.f66892i = textView6;
    }

    public static s a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.amount);
        if (textView != null) {
            MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.cardView);
            if (materialCardView != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.clockImage);
                if (imageView != null) {
                    CircularImageView circularImageView = (CircularImageView) view.findViewById(R.id.logoImage);
                    if (circularImageView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.nameInitials);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.payeeName);
                            if (textView3 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.payeeVpa);
                                if (textView4 != null) {
                                    TextView textView5 = (TextView) view.findViewById(R.id.updatePlaceHolder);
                                    if (textView5 != null) {
                                        TextView textView6 = (TextView) view.findViewById(R.id.validity);
                                        if (textView6 != null) {
                                            return new s((FrameLayout) view, textView, materialCardView, imageView, circularImageView, textView2, textView3, textView4, textView5, textView6);
                                        }
                                        str = "validity";
                                    } else {
                                        str = "updatePlaceHolder";
                                    }
                                } else {
                                    str = "payeeVpa";
                                }
                            } else {
                                str = "payeeName";
                            }
                        } else {
                            str = "nameInitials";
                        }
                    } else {
                        str = "logoImage";
                    }
                } else {
                    str = "clockImage";
                }
            } else {
                str = "cardView";
            }
        } else {
            str = "amount";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
