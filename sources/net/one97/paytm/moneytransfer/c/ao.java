package net.one97.paytm.moneytransfer.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.util.CircularImageView;

public final class ao {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f53700a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53701b;

    /* renamed from: c  reason: collision with root package name */
    public final CircularImageView f53702c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53703d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53704e;

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f53705f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f53706g;

    private ao(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, CircularImageView circularImageView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2) {
        this.f53706g = constraintLayout;
        this.f53700a = imageView;
        this.f53701b = textView;
        this.f53702c = circularImageView;
        this.f53703d = textView2;
        this.f53704e = textView3;
        this.f53705f = constraintLayout2;
    }

    public static ao a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.transfer_to_bank_acc_beneficiary_item_view, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bank_logo);
        if (imageView != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.beneficiary_account_details);
            if (textView != null) {
                CircularImageView circularImageView = (CircularImageView) inflate.findViewById(R.id.beneficiary_icon);
                if (circularImageView != null) {
                    TextView textView2 = (TextView) inflate.findViewById(R.id.beneficiary_initials);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) inflate.findViewById(R.id.beneficiary_name);
                        if (textView3 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.root);
                            if (constraintLayout != null) {
                                return new ao((ConstraintLayout) inflate, imageView, textView, circularImageView, textView2, textView3, constraintLayout);
                            }
                            str = "root";
                        } else {
                            str = "beneficiaryName";
                        }
                    } else {
                        str = "beneficiaryInitials";
                    }
                } else {
                    str = "beneficiaryIcon";
                }
            } else {
                str = "beneficiaryAccountDetails";
            }
        } else {
            str = "bankLogo";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
