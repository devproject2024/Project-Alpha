package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import net.one97.paytm.upi.R;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f66902a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f66903b;

    /* renamed from: c  reason: collision with root package name */
    public final CardView f66904c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f66905d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f66906e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f66907f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f66908g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f66909h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f66910i;
    public final ImageView j;
    public final TextView k;
    public final LottieAnimationView l;
    public final ImageView m;
    public final TextView n;
    public final ImageView o;
    public final TextView p;
    public final ScrollView q;
    public final ImageView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    private final ConstraintLayout v;

    private u(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, CardView cardView, ImageView imageView2, TextView textView, TextView textView2, RelativeLayout relativeLayout, ImageView imageView3, TextView textView3, ImageView imageView4, TextView textView4, LottieAnimationView lottieAnimationView, ImageView imageView5, TextView textView5, ImageView imageView6, TextView textView6, ScrollView scrollView, ImageView imageView7, TextView textView7, TextView textView8, TextView textView9) {
        this.v = constraintLayout;
        this.f66902a = imageView;
        this.f66903b = recyclerView;
        this.f66904c = cardView;
        this.f66905d = imageView2;
        this.f66906e = textView;
        this.f66907f = textView2;
        this.f66908g = relativeLayout;
        this.f66909h = imageView3;
        this.f66910i = textView3;
        this.j = imageView4;
        this.k = textView4;
        this.l = lottieAnimationView;
        this.m = imageView5;
        this.n = textView5;
        this.o = imageView6;
        this.p = textView6;
        this.q = scrollView;
        this.r = imageView7;
        this.s = textView7;
        this.t = textView8;
        this.u = textView9;
    }

    public static u a(View view) {
        String str;
        View view2 = view;
        ImageView imageView = (ImageView) view2.findViewById(R.id.back);
        if (imageView != null) {
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.bannerRecyclerView);
            if (recyclerView != null) {
                CardView cardView = (CardView) view2.findViewById(R.id.cardView);
                if (cardView != null) {
                    ImageView imageView2 = (ImageView) view2.findViewById(R.id.checkBalanceImage);
                    if (imageView2 != null) {
                        TextView textView = (TextView) view2.findViewById(R.id.checkBalanceMessage);
                        if (textView != null) {
                            TextView textView2 = (TextView) view2.findViewById(R.id.linkAccount);
                            if (textView2 != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.loader_container);
                                if (relativeLayout != null) {
                                    ImageView imageView3 = (ImageView) view2.findViewById(R.id.motif);
                                    if (imageView3 != null) {
                                        TextView textView3 = (TextView) view2.findViewById(R.id.noWalletKyc);
                                        if (textView3 != null) {
                                            ImageView imageView4 = (ImageView) view2.findViewById(R.id.payOnlineImage);
                                            if (imageView4 != null) {
                                                TextView textView4 = (TextView) view2.findViewById(R.id.payOnlineMessage);
                                                if (textView4 != null) {
                                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R.id.progress_loader);
                                                    if (lottieAnimationView != null) {
                                                        ImageView imageView5 = (ImageView) view2.findViewById(R.id.receiveMoneyImage);
                                                        if (imageView5 != null) {
                                                            TextView textView5 = (TextView) view2.findViewById(R.id.receiveMoneyMessage);
                                                            if (textView5 != null) {
                                                                ImageView imageView6 = (ImageView) view2.findViewById(R.id.scanImage);
                                                                if (imageView6 != null) {
                                                                    TextView textView6 = (TextView) view2.findViewById(R.id.scanMessage);
                                                                    if (textView6 != null) {
                                                                        ScrollView scrollView = (ScrollView) view2.findViewById(R.id.scrollView);
                                                                        if (scrollView != null) {
                                                                            ImageView imageView7 = (ImageView) view2.findViewById(R.id.sendMoneyImage);
                                                                            if (imageView7 != null) {
                                                                                TextView textView7 = (TextView) view2.findViewById(R.id.sendMoneyMessage);
                                                                                if (textView7 != null) {
                                                                                    TextView textView8 = (TextView) view2.findViewById(R.id.skip);
                                                                                    if (textView8 != null) {
                                                                                        TextView textView9 = (TextView) view2.findViewById(R.id.title);
                                                                                        if (textView9 != null) {
                                                                                            return new u((ConstraintLayout) view2, imageView, recyclerView, cardView, imageView2, textView, textView2, relativeLayout, imageView3, textView3, imageView4, textView4, lottieAnimationView, imageView5, textView5, imageView6, textView6, scrollView, imageView7, textView7, textView8, textView9);
                                                                                        }
                                                                                        str = "title";
                                                                                    } else {
                                                                                        str = "skip";
                                                                                    }
                                                                                } else {
                                                                                    str = "sendMoneyMessage";
                                                                                }
                                                                            } else {
                                                                                str = "sendMoneyImage";
                                                                            }
                                                                        } else {
                                                                            str = "scrollView";
                                                                        }
                                                                    } else {
                                                                        str = "scanMessage";
                                                                    }
                                                                } else {
                                                                    str = "scanImage";
                                                                }
                                                            } else {
                                                                str = "receiveMoneyMessage";
                                                            }
                                                        } else {
                                                            str = "receiveMoneyImage";
                                                        }
                                                    } else {
                                                        str = "progressLoader";
                                                    }
                                                } else {
                                                    str = "payOnlineMessage";
                                                }
                                            } else {
                                                str = "payOnlineImage";
                                            }
                                        } else {
                                            str = "noWalletKyc";
                                        }
                                    } else {
                                        str = "motif";
                                    }
                                } else {
                                    str = "loaderContainer";
                                }
                            } else {
                                str = "linkAccount";
                            }
                        } else {
                            str = "checkBalanceMessage";
                        }
                    } else {
                        str = "checkBalanceImage";
                    }
                } else {
                    str = "cardView";
                }
            } else {
                str = "bannerRecyclerView";
            }
        } else {
            str = H5Param.DEFAULT_LONG_BACK_BEHAVIOR;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
