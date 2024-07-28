package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import net.one97.paytm.moneytransfer.R;

public final class d {
    public final TextView A;
    public final TextView B;
    public final ImageView C;
    private final FrameLayout D;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53725a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53726b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f53727c;

    /* renamed from: d  reason: collision with root package name */
    public final View f53728d;

    /* renamed from: e  reason: collision with root package name */
    public final View f53729e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f53730f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f53731g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f53732h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f53733i;
    public final ImageView j;
    public final TextView k;
    public final ImageView l;
    public final ImageView m;
    public final ImageView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final View t;
    public final View u;
    public final ImageView v;
    public final ImageView w;
    public final ConstraintLayout x;
    public final NestedScrollView y;
    public final TextView z;

    private d(FrameLayout frameLayout, TextView textView, TextView textView2, ImageView imageView, View view, View view2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView3, ImageView imageView7, ImageView imageView8, ImageView imageView9, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view3, View view4, ImageView imageView10, ImageView imageView11, ConstraintLayout constraintLayout, NestedScrollView nestedScrollView, TextView textView9, TextView textView10, TextView textView11, ImageView imageView12) {
        this.D = frameLayout;
        this.f53725a = textView;
        this.f53726b = textView2;
        this.f53727c = imageView;
        this.f53728d = view;
        this.f53729e = view2;
        this.f53730f = imageView2;
        this.f53731g = imageView3;
        this.f53732h = imageView4;
        this.f53733i = imageView5;
        this.j = imageView6;
        this.k = textView3;
        this.l = imageView7;
        this.m = imageView8;
        this.n = imageView9;
        this.o = textView4;
        this.p = textView5;
        this.q = textView6;
        this.r = textView7;
        this.s = textView8;
        this.t = view3;
        this.u = view4;
        this.v = imageView10;
        this.w = imageView11;
        this.x = constraintLayout;
        this.y = nestedScrollView;
        this.z = textView9;
        this.A = textView10;
        this.B = textView11;
        this.C = imageView12;
    }

    public static d a(View view) {
        String str;
        View view2 = view;
        TextView textView = (TextView) view2.findViewById(R.id.answer1);
        if (textView != null) {
            TextView textView2 = (TextView) view2.findViewById(R.id.answer2);
            if (textView2 != null) {
                ImageView imageView = (ImageView) view2.findViewById(R.id.crossButton);
                if (imageView != null) {
                    View findViewById = view2.findViewById(R.id.divider1);
                    if (findViewById != null) {
                        View findViewById2 = view2.findViewById(R.id.divider2);
                        if (findViewById2 != null) {
                            ImageView imageView2 = (ImageView) view2.findViewById(R.id.downArrow1);
                            if (imageView2 != null) {
                                ImageView imageView3 = (ImageView) view2.findViewById(R.id.downArrow2);
                                if (imageView3 != null) {
                                    ImageView imageView4 = (ImageView) view2.findViewById(R.id.greenTick1);
                                    if (imageView4 != null) {
                                        ImageView imageView5 = (ImageView) view2.findViewById(R.id.greenTick2);
                                        if (imageView5 != null) {
                                            ImageView imageView6 = (ImageView) view2.findViewById(R.id.greenTick3);
                                            if (imageView6 != null) {
                                                TextView textView3 = (TextView) view2.findViewById(R.id.heading);
                                                if (textView3 != null) {
                                                    ImageView imageView7 = (ImageView) view2.findViewById(R.id.oval1);
                                                    if (imageView7 != null) {
                                                        ImageView imageView8 = (ImageView) view2.findViewById(R.id.oval2);
                                                        if (imageView8 != null) {
                                                            ImageView imageView9 = (ImageView) view2.findViewById(R.id.oval3);
                                                            if (imageView9 != null) {
                                                                TextView textView4 = (TextView) view2.findViewById(R.id.point1);
                                                                if (textView4 != null) {
                                                                    TextView textView5 = (TextView) view2.findViewById(R.id.point2);
                                                                    if (textView5 != null) {
                                                                        TextView textView6 = (TextView) view2.findViewById(R.id.point3);
                                                                        if (textView6 != null) {
                                                                            TextView textView7 = (TextView) view2.findViewById(R.id.question1);
                                                                            if (textView7 != null) {
                                                                                TextView textView8 = (TextView) view2.findViewById(R.id.question2);
                                                                                if (textView8 != null) {
                                                                                    View findViewById3 = view2.findViewById(R.id.questionClickArea1);
                                                                                    if (findViewById3 != null) {
                                                                                        View findViewById4 = view2.findViewById(R.id.questionClickArea2);
                                                                                        if (findViewById4 != null) {
                                                                                            ImageView imageView10 = (ImageView) view2.findViewById(R.id.questionMark1);
                                                                                            if (imageView10 != null) {
                                                                                                ImageView imageView11 = (ImageView) view2.findViewById(R.id.questionMark2);
                                                                                                if (imageView11 != null) {
                                                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.questionsContainer);
                                                                                                    if (constraintLayout != null) {
                                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) view2.findViewById(R.id.root);
                                                                                                        if (nestedScrollView != null) {
                                                                                                            TextView textView9 = (TextView) view2.findViewById(R.id.subPoint1);
                                                                                                            if (textView9 != null) {
                                                                                                                TextView textView10 = (TextView) view2.findViewById(R.id.subPoint2);
                                                                                                                if (textView10 != null) {
                                                                                                                    TextView textView11 = (TextView) view2.findViewById(R.id.subPoint3);
                                                                                                                    if (textView11 != null) {
                                                                                                                        ImageView imageView12 = (ImageView) view2.findViewById(R.id.walletImage);
                                                                                                                        if (imageView12 != null) {
                                                                                                                            return new d((FrameLayout) view2, textView, textView2, imageView, findViewById, findViewById2, imageView2, imageView3, imageView4, imageView5, imageView6, textView3, imageView7, imageView8, imageView9, textView4, textView5, textView6, textView7, textView8, findViewById3, findViewById4, imageView10, imageView11, constraintLayout, nestedScrollView, textView9, textView10, textView11, imageView12);
                                                                                                                        }
                                                                                                                        str = "walletImage";
                                                                                                                    } else {
                                                                                                                        str = "subPoint3";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "subPoint2";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "subPoint1";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "root";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "questionsContainer";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "questionMark2";
                                                                                                }
                                                                                            } else {
                                                                                                str = "questionMark1";
                                                                                            }
                                                                                        } else {
                                                                                            str = "questionClickArea2";
                                                                                        }
                                                                                    } else {
                                                                                        str = "questionClickArea1";
                                                                                    }
                                                                                } else {
                                                                                    str = "question2";
                                                                                }
                                                                            } else {
                                                                                str = "question1";
                                                                            }
                                                                        } else {
                                                                            str = "point3";
                                                                        }
                                                                    } else {
                                                                        str = "point2";
                                                                    }
                                                                } else {
                                                                    str = "point1";
                                                                }
                                                            } else {
                                                                str = "oval3";
                                                            }
                                                        } else {
                                                            str = "oval2";
                                                        }
                                                    } else {
                                                        str = "oval1";
                                                    }
                                                } else {
                                                    str = "heading";
                                                }
                                            } else {
                                                str = "greenTick3";
                                            }
                                        } else {
                                            str = "greenTick2";
                                        }
                                    } else {
                                        str = "greenTick1";
                                    }
                                } else {
                                    str = "downArrow2";
                                }
                            } else {
                                str = "downArrow1";
                            }
                        } else {
                            str = "divider2";
                        }
                    } else {
                        str = "divider1";
                    }
                } else {
                    str = "crossButton";
                }
            } else {
                str = "answer2";
            }
        } else {
            str = "answer1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
