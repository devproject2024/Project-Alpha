package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.util.CircularImageView;

public final class af {
    public final Guideline A;
    public final TextView B;
    public final ImageView C;
    private final NestedScrollView D;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53627a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53628b;

    /* renamed from: c  reason: collision with root package name */
    public final Group f53629c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f53630d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53631e;

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f53632f;

    /* renamed from: g  reason: collision with root package name */
    public final Barrier f53633g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f53634h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f53635i;
    public final TextView j;
    public final TextView k;
    public final View l;
    public final ImageView m;
    public final ImageView n;
    public final CircularImageView o;
    public final TextView p;
    public final ConstraintLayout q;
    public final LottieAnimationView r;
    public final TextView s;
    public final View t;
    public final TextView u;
    public final LottieAnimationView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private af(NestedScrollView nestedScrollView, TextView textView, View view, Group group, ImageView imageView, TextView textView2, RecyclerView recyclerView, Barrier barrier, TextView textView3, ImageView imageView2, TextView textView4, TextView textView5, View view2, ImageView imageView3, ImageView imageView4, CircularImageView circularImageView, TextView textView6, ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, TextView textView7, View view3, TextView textView8, LottieAnimationView lottieAnimationView2, TextView textView9, TextView textView10, TextView textView11, TextView textView12, Guideline guideline, TextView textView13, ImageView imageView5) {
        this.D = nestedScrollView;
        this.f53627a = textView;
        this.f53628b = view;
        this.f53629c = group;
        this.f53630d = imageView;
        this.f53631e = textView2;
        this.f53632f = recyclerView;
        this.f53633g = barrier;
        this.f53634h = textView3;
        this.f53635i = imageView2;
        this.j = textView4;
        this.k = textView5;
        this.l = view2;
        this.m = imageView3;
        this.n = imageView4;
        this.o = circularImageView;
        this.p = textView6;
        this.q = constraintLayout;
        this.r = lottieAnimationView;
        this.s = textView7;
        this.t = view3;
        this.u = textView8;
        this.v = lottieAnimationView2;
        this.w = textView9;
        this.x = textView10;
        this.y = textView11;
        this.z = textView12;
        this.A = guideline;
        this.B = textView13;
        this.C = imageView5;
    }

    public static af a(View view) {
        String str;
        View view2 = view;
        TextView textView = (TextView) view2.findViewById(R.id.amount);
        if (textView != null) {
            View findViewById = view2.findViewById(R.id.background);
            if (findViewById != null) {
                Group group = (Group) view2.findViewById(R.id.bankGroup);
                if (group != null) {
                    ImageView imageView = (ImageView) view2.findViewById(R.id.bankImageView);
                    if (imageView != null) {
                        TextView textView2 = (TextView) view2.findViewById(R.id.bankName);
                        if (textView2 != null) {
                            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.bankRecyclerView);
                            if (recyclerView != null) {
                                Barrier barrier = (Barrier) view2.findViewById(R.id.barrier);
                                if (barrier != null) {
                                    TextView textView3 = (TextView) view2.findViewById(R.id.checkBalance);
                                    if (textView3 != null) {
                                        ImageView imageView2 = (ImageView) view2.findViewById(R.id.close);
                                        if (imageView2 != null) {
                                            TextView textView4 = (TextView) view2.findViewById(R.id.contactInitials);
                                            if (textView4 != null) {
                                                TextView textView5 = (TextView) view2.findViewById(R.id.declineButton);
                                                if (textView5 != null) {
                                                    View findViewById2 = view2.findViewById(R.id.divider);
                                                    if (findViewById2 != null) {
                                                        ImageView imageView3 = (ImageView) view2.findViewById(R.id.dotted);
                                                        if (imageView3 != null) {
                                                            ImageView imageView4 = (ImageView) view2.findViewById(R.id.downArrow);
                                                            if (imageView4 != null) {
                                                                CircularImageView circularImageView = (CircularImageView) view2.findViewById(R.id.image);
                                                                if (circularImageView != null) {
                                                                    TextView textView6 = (TextView) view2.findViewById(R.id.importantMessage);
                                                                    if (textView6 != null) {
                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.layoutBanksExpanded);
                                                                        if (constraintLayout != null) {
                                                                            LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.lottieLoader);
                                                                            if (lottieAnimationView != null) {
                                                                                TextView textView7 = (TextView) view2.findViewById(R.id.message);
                                                                                if (textView7 != null) {
                                                                                    View findViewById3 = view2.findViewById(R.id.paddedView);
                                                                                    if (findViewById3 != null) {
                                                                                        TextView textView8 = (TextView) view2.findViewById(R.id.payFrom);
                                                                                        if (textView8 != null) {
                                                                                            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view2.findViewById(R.id.pay_loader);
                                                                                            if (lottieAnimationView2 != null) {
                                                                                                TextView textView9 = (TextView) view2.findViewById(R.id.payeeName);
                                                                                                if (textView9 != null) {
                                                                                                    TextView textView10 = (TextView) view2.findViewById(R.id.payeeVpa);
                                                                                                    if (textView10 != null) {
                                                                                                        TextView textView11 = (TextView) view2.findViewById(R.id.proceedButton);
                                                                                                        if (textView11 != null) {
                                                                                                            TextView textView12 = (TextView) view2.findViewById(R.id.spam);
                                                                                                            if (textView12 != null) {
                                                                                                                Guideline guideline = (Guideline) view2.findViewById(R.id.top);
                                                                                                                if (guideline != null) {
                                                                                                                    TextView textView13 = (TextView) view2.findViewById(R.id.tvImportantLabel);
                                                                                                                    if (textView13 != null) {
                                                                                                                        ImageView imageView5 = (ImageView) view2.findViewById(R.id.upArrow);
                                                                                                                        if (imageView5 != null) {
                                                                                                                            return new af((NestedScrollView) view2, textView, findViewById, group, imageView, textView2, recyclerView, barrier, textView3, imageView2, textView4, textView5, findViewById2, imageView3, imageView4, circularImageView, textView6, constraintLayout, lottieAnimationView, textView7, findViewById3, textView8, lottieAnimationView2, textView9, textView10, textView11, textView12, guideline, textView13, imageView5);
                                                                                                                        }
                                                                                                                        str = "upArrow";
                                                                                                                    } else {
                                                                                                                        str = "tvImportantLabel";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "top";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "spam";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "proceedButton";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "payeeVpa";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "payeeName";
                                                                                                }
                                                                                            } else {
                                                                                                str = "payLoader";
                                                                                            }
                                                                                        } else {
                                                                                            str = "payFrom";
                                                                                        }
                                                                                    } else {
                                                                                        str = "paddedView";
                                                                                    }
                                                                                } else {
                                                                                    str = "message";
                                                                                }
                                                                            } else {
                                                                                str = "lottieLoader";
                                                                            }
                                                                        } else {
                                                                            str = "layoutBanksExpanded";
                                                                        }
                                                                    } else {
                                                                        str = "importantMessage";
                                                                    }
                                                                } else {
                                                                    str = H5ResourceHandlerUtil.IMAGE;
                                                                }
                                                            } else {
                                                                str = "downArrow";
                                                            }
                                                        } else {
                                                            str = "dotted";
                                                        }
                                                    } else {
                                                        str = "divider";
                                                    }
                                                } else {
                                                    str = "declineButton";
                                                }
                                            } else {
                                                str = "contactInitials";
                                            }
                                        } else {
                                            str = "close";
                                        }
                                    } else {
                                        str = "checkBalance";
                                    }
                                } else {
                                    str = "barrier";
                                }
                            } else {
                                str = "bankRecyclerView";
                            }
                        } else {
                            str = "bankName";
                        }
                    } else {
                        str = "bankImageView";
                    }
                } else {
                    str = "bankGroup";
                }
            } else {
                str = "background";
            }
        } else {
            str = "amount";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
