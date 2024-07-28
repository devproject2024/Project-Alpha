package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import net.one97.paytm.moneytransfer.R;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f53762a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f53763b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f53764c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f53765d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f53766e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53767f;

    /* renamed from: g  reason: collision with root package name */
    public final FrameLayout f53768g;

    /* renamed from: h  reason: collision with root package name */
    public final CoordinatorLayout f53769h;

    /* renamed from: i  reason: collision with root package name */
    public final q f53770i;
    private final CoordinatorLayout j;

    private j(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, RecyclerView recyclerView, FrameLayout frameLayout, ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, FrameLayout frameLayout2, CoordinatorLayout coordinatorLayout2, q qVar) {
        this.j = coordinatorLayout;
        this.f53762a = appBarLayout;
        this.f53763b = recyclerView;
        this.f53764c = frameLayout;
        this.f53765d = constraintLayout;
        this.f53766e = linearLayout;
        this.f53767f = textView;
        this.f53768g = frameLayout2;
        this.f53769h = coordinatorLayout2;
        this.f53770i = qVar;
    }

    public static j a(View view) {
        View view2 = view;
        AppBarLayout appBarLayout = (AppBarLayout) view2.findViewById(R.id.appBarLayout);
        String str = "topPaymentCardLayout";
        if (appBarLayout != null) {
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.beneficiaryHistoryRecyclerView);
            if (recyclerView != null) {
                FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.bottomSheetLayout);
                if (frameLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.enterAmountLayout);
                    if (constraintLayout != null) {
                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.noHistoryLayout);
                        if (linearLayout != null) {
                            TextView textView = (TextView) view2.findViewById(R.id.noHistoryText);
                            if (textView != null) {
                                FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.paymentContainer);
                                if (frameLayout2 != null) {
                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view2.findViewById(R.id.rootCoordinatorLayout);
                                    if (coordinatorLayout != null) {
                                        View findViewById = view2.findViewById(R.id.topPaymentCardLayout);
                                        if (findViewById != null) {
                                            ImageView imageView = (ImageView) findViewById.findViewById(R.id.backButton);
                                            if (imageView != null) {
                                                ImageView imageView2 = (ImageView) findViewById.findViewById(R.id.bankImage);
                                                if (imageView2 != null) {
                                                    ImageView imageView3 = (ImageView) findViewById.findViewById(R.id.bankImageView);
                                                    if (imageView3 != null) {
                                                        TextView textView2 = (TextView) findViewById.findViewById(R.id.bankName);
                                                        if (textView2 != null) {
                                                            TextView textView3 = (TextView) findViewById.findViewById(R.id.contactInitials);
                                                            if (textView3 != null) {
                                                                View findViewById2 = findViewById.findViewById(R.id.divider);
                                                                if (findViewById2 != null) {
                                                                    ImageView imageView4 = (ImageView) findViewById.findViewById(R.id.ivVerificationLogo);
                                                                    if (imageView4 != null) {
                                                                        ImageView imageView5 = (ImageView) findViewById.findViewById(R.id.motif);
                                                                        if (imageView5 != null) {
                                                                            ImageView imageView6 = (ImageView) findViewById.findViewById(R.id.options);
                                                                            if (imageView6 != null) {
                                                                                TextView textView4 = (TextView) findViewById.findViewById(R.id.receiverName);
                                                                                if (textView4 != null) {
                                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById.findViewById(R.id.topPaymentCardLayout);
                                                                                    if (constraintLayout2 != null) {
                                                                                        TextView textView5 = (TextView) findViewById.findViewById(R.id.tvbhimUpi);
                                                                                        if (textView5 != null) {
                                                                                            return new j((CoordinatorLayout) view2, appBarLayout, recyclerView, frameLayout, constraintLayout, linearLayout, textView, frameLayout2, coordinatorLayout, new q((ConstraintLayout) findViewById, imageView, imageView2, imageView3, textView2, textView3, findViewById2, imageView4, imageView5, imageView6, textView4, constraintLayout2, textView5));
                                                                                        }
                                                                                        str = "tvbhimUpi";
                                                                                    }
                                                                                } else {
                                                                                    str = "receiverName";
                                                                                }
                                                                            } else {
                                                                                str = "options";
                                                                            }
                                                                        } else {
                                                                            str = "motif";
                                                                        }
                                                                    } else {
                                                                        str = "ivVerificationLogo";
                                                                    }
                                                                } else {
                                                                    str = "divider";
                                                                }
                                                            } else {
                                                                str = "contactInitials";
                                                            }
                                                        } else {
                                                            str = "bankName";
                                                        }
                                                    } else {
                                                        str = "bankImageView";
                                                    }
                                                } else {
                                                    str = "bankImage";
                                                }
                                            } else {
                                                str = "backButton";
                                            }
                                            throw new NullPointerException("Missing required view with ID: ".concat(str));
                                        }
                                    } else {
                                        str = "rootCoordinatorLayout";
                                    }
                                } else {
                                    str = "paymentContainer";
                                }
                            } else {
                                str = "noHistoryText";
                            }
                        } else {
                            str = "noHistoryLayout";
                        }
                    } else {
                        str = "enterAmountLayout";
                    }
                } else {
                    str = "bottomSheetLayout";
                }
            } else {
                str = "beneficiaryHistoryRecyclerView";
            }
        } else {
            str = "appBarLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
