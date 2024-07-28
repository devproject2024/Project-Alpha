package net.one97.paytm.upi.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.util.CircularImageView;

public final class a {
    public final TextView A;
    public final TextView B;
    public final View C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final Group G;
    public final TextView H;
    public final TextView I;
    public final View J;
    public final EditText K;
    public final View L;
    public final TextView M;
    public final ScrollView N;
    public final TextView O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    public final View S;
    public final TextView T;
    public final TextView U;
    public final TextView V;
    public final RadioGroup W;
    private final ScrollView X;

    /* renamed from: a  reason: collision with root package name */
    public final CustomAmountTextInputEditText f66716a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66717b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f66718c;

    /* renamed from: d  reason: collision with root package name */
    public final CheckBox f66719d;

    /* renamed from: e  reason: collision with root package name */
    public final View f66720e;

    /* renamed from: f  reason: collision with root package name */
    public final View f66721f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f66722g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f66723h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f66724i;
    public final Group j;
    public final View k;
    public final TextView l;
    public final View m;
    public final TextView n;
    public final View o;
    public final TextView p;
    public final TextView q;
    public final LottieAnimationView r;
    public final ImageView s;
    public final TextView t;
    public final EditText u;
    public final View v;
    public final TextView w;
    public final x x;
    public final Group y;
    public final CircularImageView z;

    private a(ScrollView scrollView, CustomAmountTextInputEditText customAmountTextInputEditText, TextView textView, TextView textView2, CheckBox checkBox, View view, View view2, ImageView imageView, TextView textView3, TextView textView4, Group group, View view3, TextView textView5, View view4, TextView textView6, View view5, TextView textView7, TextView textView8, LottieAnimationView lottieAnimationView, ImageView imageView2, TextView textView9, EditText editText, View view6, TextView textView10, x xVar, Group group2, CircularImageView circularImageView, TextView textView11, TextView textView12, View view7, TextView textView13, TextView textView14, TextView textView15, Group group3, TextView textView16, TextView textView17, View view8, EditText editText2, View view9, TextView textView18, ScrollView scrollView2, TextView textView19, TextView textView20, TextView textView21, TextView textView22, View view10, TextView textView23, TextView textView24, TextView textView25, RadioGroup radioGroup) {
        this.X = scrollView;
        this.f66716a = customAmountTextInputEditText;
        this.f66717b = textView;
        this.f66718c = textView2;
        this.f66719d = checkBox;
        this.f66720e = view;
        this.f66721f = view2;
        this.f66722g = imageView;
        this.f66723h = textView3;
        this.f66724i = textView4;
        this.j = group;
        this.k = view3;
        this.l = textView5;
        this.m = view4;
        this.n = textView6;
        this.o = view5;
        this.p = textView7;
        this.q = textView8;
        this.r = lottieAnimationView;
        this.s = imageView2;
        this.t = textView9;
        this.u = editText;
        this.v = view6;
        this.w = textView10;
        this.x = xVar;
        this.y = group2;
        this.z = circularImageView;
        this.A = textView11;
        this.B = textView12;
        this.C = view7;
        this.D = textView13;
        this.E = textView14;
        this.F = textView15;
        this.G = group3;
        this.H = textView16;
        this.I = textView17;
        this.J = view8;
        this.K = editText2;
        this.L = view9;
        this.M = textView18;
        this.N = scrollView2;
        this.O = textView19;
        this.P = textView20;
        this.Q = textView21;
        this.R = textView22;
        this.S = view10;
        this.T = textView23;
        this.U = textView24;
        this.V = textView25;
        this.W = radioGroup;
    }

    public final ScrollView a() {
        return this.X;
    }

    public static a a(LayoutInflater layoutInflater) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.activity_create_mandate, (ViewGroup) null, false);
        CustomAmountTextInputEditText customAmountTextInputEditText = (CustomAmountTextInputEditText) inflate.findViewById(R.id.amountEditText);
        if (customAmountTextInputEditText != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.amountError);
            if (textView != null) {
                TextView textView2 = (TextView) inflate.findViewById(R.id.amountInWords);
                if (textView2 != null) {
                    CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.amountRuleCheckbox);
                    if (checkBox != null) {
                        View findViewById = inflate.findViewById(R.id.amountUnderLine);
                        if (findViewById != null) {
                            View findViewById2 = inflate.findViewById(R.id.bankDivider);
                            if (findViewById2 != null) {
                                ImageView imageView = (ImageView) inflate.findViewById(R.id.bankImage);
                                if (imageView != null) {
                                    TextView textView3 = (TextView) inflate.findViewById(R.id.bankName);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) inflate.findViewById(R.id.bankPlaceHolder);
                                        if (textView4 != null) {
                                            Group group = (Group) inflate.findViewById(R.id.dailyPaymentFrequencyHidingGroup);
                                            if (group != null) {
                                                View findViewById3 = inflate.findViewById(R.id.divider1);
                                                if (findViewById3 != null) {
                                                    TextView textView5 = (TextView) inflate.findViewById(R.id.endDate);
                                                    if (textView5 != null) {
                                                        View findViewById4 = inflate.findViewById(R.id.endDateDivider);
                                                        if (findViewById4 != null) {
                                                            TextView textView6 = (TextView) inflate.findViewById(R.id.endDateError);
                                                            if (textView6 != null) {
                                                                View findViewById5 = inflate.findViewById(R.id.frequencyDivider);
                                                                if (findViewById5 != null) {
                                                                    TextView textView7 = (TextView) inflate.findViewById(R.id.frequencyTextView);
                                                                    if (textView7 != null) {
                                                                        TextView textView8 = (TextView) inflate.findViewById(R.id.importantMessage);
                                                                        if (textView8 != null) {
                                                                            LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.lottieLoader);
                                                                            if (lottieAnimationView != null) {
                                                                                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.motif);
                                                                                if (imageView2 != null) {
                                                                                    TextView textView9 = (TextView) inflate.findViewById(R.id.nameInitials);
                                                                                    if (textView9 != null) {
                                                                                        EditText editText = (EditText) inflate.findViewById(R.id.nameOfPayment);
                                                                                        if (editText != null) {
                                                                                            View findViewById6 = inflate.findViewById(R.id.nameOfPaymentPlaceDivider);
                                                                                            if (findViewById6 != null) {
                                                                                                TextView textView10 = (TextView) inflate.findViewById(R.id.nameOfPaymentPlaceHolder);
                                                                                                if (textView10 != null) {
                                                                                                    View findViewById7 = inflate.findViewById(R.id.noBankSupportedLayout);
                                                                                                    if (findViewById7 != null) {
                                                                                                        x a2 = x.a(findViewById7);
                                                                                                        Group group2 = (Group) inflate.findViewById(R.id.noBanksGroup);
                                                                                                        if (group2 != null) {
                                                                                                            CircularImageView circularImageView = (CircularImageView) inflate.findViewById(R.id.payeeImage);
                                                                                                            if (circularImageView != null) {
                                                                                                                TextView textView11 = (TextView) inflate.findViewById(R.id.payeeName);
                                                                                                                if (textView11 != null) {
                                                                                                                    TextView textView12 = (TextView) inflate.findViewById(R.id.payeeVpa);
                                                                                                                    if (textView12 != null) {
                                                                                                                        View findViewById8 = inflate.findViewById(R.id.paymentDayDivider);
                                                                                                                        if (findViewById8 != null) {
                                                                                                                            TextView textView13 = (TextView) inflate.findViewById(R.id.paymentDayError);
                                                                                                                            if (textView13 != null) {
                                                                                                                                TextView textView14 = (TextView) inflate.findViewById(R.id.paymentDayPlaceholder);
                                                                                                                                if (textView14 != null) {
                                                                                                                                    TextView textView15 = (TextView) inflate.findViewById(R.id.paymentDayValue);
                                                                                                                                    if (textView15 != null) {
                                                                                                                                        Group group3 = (Group) inflate.findViewById(R.id.paymentFrequencyGroup);
                                                                                                                                        if (group3 != null) {
                                                                                                                                            TextView textView16 = (TextView) inflate.findViewById(R.id.paymentFrequencyPlaceHolder);
                                                                                                                                            if (textView16 != null) {
                                                                                                                                                TextView textView17 = (TextView) inflate.findViewById(R.id.proceedButton);
                                                                                                                                                if (textView17 != null) {
                                                                                                                                                    View findViewById9 = inflate.findViewById(R.id.recurrenceTypeDivider);
                                                                                                                                                    if (findViewById9 != null) {
                                                                                                                                                        EditText editText2 = (EditText) inflate.findViewById(R.id.remarks);
                                                                                                                                                        if (editText2 != null) {
                                                                                                                                                            View findViewById10 = inflate.findViewById(R.id.remarksDivider);
                                                                                                                                                            if (findViewById10 != null) {
                                                                                                                                                                TextView textView18 = (TextView) inflate.findViewById(R.id.remarksPlaceHolder);
                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                    ScrollView scrollView = (ScrollView) inflate.findViewById(R.id.root_layout);
                                                                                                                                                                    if (scrollView != null) {
                                                                                                                                                                        TextView textView19 = (TextView) inflate.findViewById(R.id.rupeePrefix);
                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                            TextView textView20 = (TextView) inflate.findViewById(R.id.schedulePaymentPlaceHolder);
                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                TextView textView21 = (TextView) inflate.findViewById(R.id.schedulePaymentType);
                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                    TextView textView22 = (TextView) inflate.findViewById(R.id.startDate);
                                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                                        View findViewById11 = inflate.findViewById(R.id.startDateDivider);
                                                                                                                                                                                        if (findViewById11 != null) {
                                                                                                                                                                                            TextView textView23 = (TextView) inflate.findViewById(R.id.startDateError);
                                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                                TextView textView24 = (TextView) inflate.findViewById(R.id.tenurePlaceHolder);
                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                    TextView textView25 = (TextView) inflate.findViewById(R.id.tvImportantLabel);
                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.typeRadioGroup);
                                                                                                                                                                                                        if (radioGroup != null) {
                                                                                                                                                                                                            return new a((ScrollView) inflate, customAmountTextInputEditText, textView, textView2, checkBox, findViewById, findViewById2, imageView, textView3, textView4, group, findViewById3, textView5, findViewById4, textView6, findViewById5, textView7, textView8, lottieAnimationView, imageView2, textView9, editText, findViewById6, textView10, a2, group2, circularImageView, textView11, textView12, findViewById8, textView13, textView14, textView15, group3, textView16, textView17, findViewById9, editText2, findViewById10, textView18, scrollView, textView19, textView20, textView21, textView22, findViewById11, textView23, textView24, textView25, radioGroup);
                                                                                                                                                                                                        }
                                                                                                                                                                                                        str = "typeRadioGroup";
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        str = "tvImportantLabel";
                                                                                                                                                                                                    }
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    str = "tenurePlaceHolder";
                                                                                                                                                                                                }
                                                                                                                                                                                            } else {
                                                                                                                                                                                                str = "startDateError";
                                                                                                                                                                                            }
                                                                                                                                                                                        } else {
                                                                                                                                                                                            str = "startDateDivider";
                                                                                                                                                                                        }
                                                                                                                                                                                    } else {
                                                                                                                                                                                        str = "startDate";
                                                                                                                                                                                    }
                                                                                                                                                                                } else {
                                                                                                                                                                                    str = "schedulePaymentType";
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                str = "schedulePaymentPlaceHolder";
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            str = "rupeePrefix";
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        str = "rootLayout";
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    str = "remarksPlaceHolder";
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                str = "remarksDivider";
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str = "remarks";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "recurrenceTypeDivider";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = "proceedButton";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "paymentFrequencyPlaceHolder";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "paymentFrequencyGroup";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "paymentDayValue";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "paymentDayPlaceholder";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "paymentDayError";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "paymentDayDivider";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "payeeVpa";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "payeeName";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "payeeImage";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "noBanksGroup";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "noBankSupportedLayout";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "nameOfPaymentPlaceHolder";
                                                                                                }
                                                                                            } else {
                                                                                                str = "nameOfPaymentPlaceDivider";
                                                                                            }
                                                                                        } else {
                                                                                            str = "nameOfPayment";
                                                                                        }
                                                                                    } else {
                                                                                        str = "nameInitials";
                                                                                    }
                                                                                } else {
                                                                                    str = "motif";
                                                                                }
                                                                            } else {
                                                                                str = "lottieLoader";
                                                                            }
                                                                        } else {
                                                                            str = "importantMessage";
                                                                        }
                                                                    } else {
                                                                        str = "frequencyTextView";
                                                                    }
                                                                } else {
                                                                    str = "frequencyDivider";
                                                                }
                                                            } else {
                                                                str = "endDateError";
                                                            }
                                                        } else {
                                                            str = "endDateDivider";
                                                        }
                                                    } else {
                                                        str = "endDate";
                                                    }
                                                } else {
                                                    str = "divider1";
                                                }
                                            } else {
                                                str = "dailyPaymentFrequencyHidingGroup";
                                            }
                                        } else {
                                            str = "bankPlaceHolder";
                                        }
                                    } else {
                                        str = "bankName";
                                    }
                                } else {
                                    str = "bankImage";
                                }
                            } else {
                                str = "bankDivider";
                            }
                        } else {
                            str = "amountUnderLine";
                        }
                    } else {
                        str = "amountRuleCheckbox";
                    }
                } else {
                    str = "amountInWords";
                }
            } else {
                str = "amountError";
            }
        } else {
            str = "amountEditText";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
