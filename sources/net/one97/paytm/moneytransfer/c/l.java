package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.contacts.FastScrollerLinearLayout;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final TextInputEditText f53776a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f53777b;

    /* renamed from: c  reason: collision with root package name */
    public final View f53778c;

    /* renamed from: d  reason: collision with root package name */
    public final FastScrollerLinearLayout f53779d;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f53780e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f53781f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f53782g;

    /* renamed from: h  reason: collision with root package name */
    public final LottieAnimationView f53783h;

    /* renamed from: i  reason: collision with root package name */
    public final FrameLayout f53784i;
    public final ConstraintLayout j;
    public final TextView k;
    public final LottieAnimationView l;
    public final TextView m;
    public final RecyclerView n;
    private final ConstraintLayout o;

    private l(ConstraintLayout constraintLayout, TextInputEditText textInputEditText, RecyclerView recyclerView, View view, FastScrollerLinearLayout fastScrollerLinearLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, TextView textView, LottieAnimationView lottieAnimationView2, TextView textView2, RecyclerView recyclerView2) {
        this.o = constraintLayout;
        this.f53776a = textInputEditText;
        this.f53777b = recyclerView;
        this.f53778c = view;
        this.f53779d = fastScrollerLinearLayout;
        this.f53780e = frameLayout;
        this.f53781f = imageView;
        this.f53782g = imageView2;
        this.f53783h = lottieAnimationView;
        this.f53784i = frameLayout2;
        this.j = constraintLayout2;
        this.k = textView;
        this.l = lottieAnimationView2;
        this.m = textView2;
        this.n = recyclerView2;
    }

    public static l a(View view) {
        String str;
        View view2 = view;
        TextInputEditText textInputEditText = (TextInputEditText) view2.findViewById(R.id.contactEditText);
        if (textInputEditText != null) {
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.contactsRecyclerView);
            if (recyclerView != null) {
                View findViewById = view2.findViewById(R.id.divider);
                if (findViewById != null) {
                    FastScrollerLinearLayout fastScrollerLinearLayout = (FastScrollerLinearLayout) view2.findViewById(R.id.fast_scroller);
                    if (fastScrollerLinearLayout != null) {
                        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.inviteContainer);
                        if (frameLayout != null) {
                            ImageView imageView = (ImageView) view2.findViewById(R.id.iv_back);
                            if (imageView != null) {
                                ImageView imageView2 = (ImageView) view2.findViewById(R.id.iv_cross_search);
                                if (imageView2 != null) {
                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.money_transfer_loader);
                                    if (lottieAnimationView != null) {
                                        FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.money_transfer_loader_container);
                                        if (frameLayout2 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.rl_contacts);
                                            if (constraintLayout != null) {
                                                TextView textView = (TextView) view2.findViewById(R.id.searchError);
                                                if (textView != null) {
                                                    LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view2.findViewById(R.id.top_success_anim_view);
                                                    if (lottieAnimationView2 != null) {
                                                        TextView textView2 = (TextView) view2.findViewById(R.id.tv_btn_proceed);
                                                        if (textView2 != null) {
                                                            RecyclerView recyclerView2 = (RecyclerView) view2.findViewById(R.id.vpaRecyclerView);
                                                            if (recyclerView2 != null) {
                                                                return new l((ConstraintLayout) view2, textInputEditText, recyclerView, findViewById, fastScrollerLinearLayout, frameLayout, imageView, imageView2, lottieAnimationView, frameLayout2, constraintLayout, textView, lottieAnimationView2, textView2, recyclerView2);
                                                            }
                                                            str = "vpaRecyclerView";
                                                        } else {
                                                            str = "tvBtnProceed";
                                                        }
                                                    } else {
                                                        str = "topSuccessAnimView";
                                                    }
                                                } else {
                                                    str = "searchError";
                                                }
                                            } else {
                                                str = "rlContacts";
                                            }
                                        } else {
                                            str = "moneyTransferLoaderContainer";
                                        }
                                    } else {
                                        str = "moneyTransferLoader";
                                    }
                                } else {
                                    str = "ivCrossSearch";
                                }
                            } else {
                                str = "ivBack";
                            }
                        } else {
                            str = "inviteContainer";
                        }
                    } else {
                        str = "fastScroller";
                    }
                } else {
                    str = "divider";
                }
            } else {
                str = "contactsRecyclerView";
            }
        } else {
            str = "contactEditText";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
