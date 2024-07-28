package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.mobile.h5container.api.H5Param;
import net.one97.paytm.upi.R;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66753a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f66754b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f66755c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f66756d;

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f66757e;

    /* renamed from: f  reason: collision with root package name */
    public final View f66758f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f66759g;

    private af(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, ProgressBar progressBar, ConstraintLayout constraintLayout2, View view) {
        this.f66759g = constraintLayout;
        this.f66753a = textView;
        this.f66754b = imageView;
        this.f66755c = textView2;
        this.f66756d = progressBar;
        this.f66757e = constraintLayout2;
        this.f66758f = view;
    }

    public static af a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.fetchAccounts);
        if (textView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_bank_icon);
            if (imageView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.polling_timer);
                if (textView2 != null) {
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);
                    if (progressBar != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.progressLayout);
                        if (constraintLayout != null) {
                            View findViewById = view.findViewById(R.id.view);
                            if (findViewById != null) {
                                return new af((ConstraintLayout) view, textView, imageView, textView2, progressBar, constraintLayout, findViewById);
                            }
                            str = "view";
                        } else {
                            str = "progressLayout";
                        }
                    } else {
                        str = H5Param.PROGRESS;
                    }
                } else {
                    str = "pollingTimer";
                }
            } else {
                str = "ivBankIcon";
            }
        } else {
            str = "fetchAccounts";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
