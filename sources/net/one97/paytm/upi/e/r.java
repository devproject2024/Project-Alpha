package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.upi.R;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f66878a;

    /* renamed from: b  reason: collision with root package name */
    public final ac f66879b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f66880c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f66881d;

    /* renamed from: e  reason: collision with root package name */
    public final View f66882e;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f66883f;

    private r(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ac acVar, RecyclerView recyclerView, ImageView imageView, View view) {
        this.f66883f = constraintLayout;
        this.f66878a = constraintLayout2;
        this.f66879b = acVar;
        this.f66880c = recyclerView;
        this.f66881d = imageView;
        this.f66882e = view;
    }

    public static r a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.accountOpenContainer);
        if (constraintLayout != null) {
            View findViewById = view.findViewById(R.id.accountSwitch);
            if (findViewById != null) {
                ac a2 = ac.a(findViewById);
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.favBanksRecycler);
                if (recyclerView != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.ppbl_banner);
                    if (imageView != null) {
                        View findViewById2 = view.findViewById(R.id.separator1);
                        if (findViewById2 != null) {
                            return new r((ConstraintLayout) view, constraintLayout, a2, recyclerView, imageView, findViewById2);
                        }
                        str = "separator1";
                    } else {
                        str = "ppblBanner";
                    }
                } else {
                    str = "favBanksRecycler";
                }
            } else {
                str = "accountSwitch";
            }
        } else {
            str = "accountOpenContainer";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
