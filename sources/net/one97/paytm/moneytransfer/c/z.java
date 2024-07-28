package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import net.one97.paytm.moneytransfer.R;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f53885a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53886b;

    /* renamed from: c  reason: collision with root package name */
    public final View f53887c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53888d;

    /* renamed from: e  reason: collision with root package name */
    public final AppCompatImageView f53889e;

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f53890f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f53891g;

    /* renamed from: h  reason: collision with root package name */
    public final Group f53892h;

    /* renamed from: i  reason: collision with root package name */
    public final Group f53893i;
    private final ConstraintLayout j;

    private z(ConstraintLayout constraintLayout, ImageView imageView, View view, View view2, TextView textView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, TextView textView2, Group group, Group group2) {
        this.j = constraintLayout;
        this.f53885a = imageView;
        this.f53886b = view;
        this.f53887c = view2;
        this.f53888d = textView;
        this.f53889e = appCompatImageView;
        this.f53890f = constraintLayout2;
        this.f53891g = textView2;
        this.f53892h = group;
        this.f53893i = group2;
    }

    public final ConstraintLayout a() {
        return this.j;
    }

    public static z a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.bankImage);
        if (imageView != null) {
            View findViewById = view.findViewById(R.id.bankImageOutline);
            if (findViewById != null) {
                View findViewById2 = view.findViewById(R.id.beneficiaryBackgroundColor);
                if (findViewById2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.beneficiaryInitials);
                    if (textView != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.beneficiaryInitialsBackground);
                        if (appCompatImageView != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.beneficiaryItemParent);
                            if (constraintLayout != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.beneficiaryName);
                                if (textView2 != null) {
                                    Group group = (Group) view.findViewById(R.id.otherBankGroup);
                                    if (group != null) {
                                        Group group2 = (Group) view.findViewById(R.id.upiGroup);
                                        if (group2 != null) {
                                            return new z((ConstraintLayout) view, imageView, findViewById, findViewById2, textView, appCompatImageView, constraintLayout, textView2, group, group2);
                                        }
                                        str = "upiGroup";
                                    } else {
                                        str = "otherBankGroup";
                                    }
                                } else {
                                    str = "beneficiaryName";
                                }
                            } else {
                                str = "beneficiaryItemParent";
                            }
                        } else {
                            str = "beneficiaryInitialsBackground";
                        }
                    } else {
                        str = "beneficiaryInitials";
                    }
                } else {
                    str = "beneficiaryBackgroundColor";
                }
            } else {
                str = "bankImageOutline";
            }
        } else {
            str = "bankImage";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
