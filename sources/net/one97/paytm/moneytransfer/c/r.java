package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.CircularProgressBar;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f53827a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f53828b;

    /* renamed from: c  reason: collision with root package name */
    public final CircularProgressBar f53829c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f53830d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53831e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53832f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f53833g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f53834h;

    private r(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, CircularProgressBar circularProgressBar, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        this.f53834h = constraintLayout;
        this.f53827a = constraintLayout2;
        this.f53828b = imageView;
        this.f53829c = circularProgressBar;
        this.f53830d = relativeLayout;
        this.f53831e = textView;
        this.f53832f = textView2;
        this.f53833g = textView3;
    }

    public final ConstraintLayout a() {
        return this.f53834h;
    }

    public static r a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.mt_search_contact_item_view, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.cl_parent);
        if (constraintLayout != null) {
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_profile_pic);
            if (imageView != null) {
                CircularProgressBar circularProgressBar = (CircularProgressBar) inflate.findViewById(R.id.progress_bar);
                if (circularProgressBar != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rlImageContainer);
                    if (relativeLayout != null) {
                        TextView textView = (TextView) inflate.findViewById(R.id.tv_contact_name);
                        if (textView != null) {
                            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_contact_number);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) inflate.findViewById(R.id.tv_initials);
                                if (textView3 != null) {
                                    return new r((ConstraintLayout) inflate, constraintLayout, imageView, circularProgressBar, relativeLayout, textView, textView2, textView3);
                                }
                                str = "tvInitials";
                            } else {
                                str = "tvContactNumber";
                            }
                        } else {
                            str = "tvContactName";
                        }
                    } else {
                        str = "rlImageContainer";
                    }
                } else {
                    str = "progressBar";
                }
            } else {
                str = "ivProfilePic";
            }
        } else {
            str = "clParent";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
