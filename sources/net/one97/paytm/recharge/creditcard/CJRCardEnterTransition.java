package net.one97.paytm.recharge.creditcard;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;

public final class CJRCardEnterTransition extends Transition implements Animator.AnimatorListener {

    /* renamed from: c  reason: collision with root package name */
    public static final a f62332c = new a((byte) 0);
    private static final String l = l;
    private static final String m = m;
    private static final String[] n = {l, m};

    /* renamed from: a  reason: collision with root package name */
    boolean f62333a;

    /* renamed from: b  reason: collision with root package name */
    CJRCreditCardModelV8 f62334b;

    /* renamed from: d  reason: collision with root package name */
    private View f62335d;

    /* renamed from: e  reason: collision with root package name */
    private View f62336e;

    /* renamed from: f  reason: collision with root package name */
    private View f62337f;

    /* renamed from: g  reason: collision with root package name */
    private View f62338g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f62339h;

    /* renamed from: i  reason: collision with root package name */
    private float f62340i;
    private float j;
    private float k;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public CJRCardEnterTransition() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRCardEnterTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
    }

    public final String[] getTransitionProperties() {
        return n;
    }

    public final void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues, true);
    }

    public final void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues, false);
    }

    private static void a(TransitionValues transitionValues, boolean z) {
        View view;
        if (transitionValues != null && (view = transitionValues.view) != null && view.getId() == R.id.cc_card_view) {
            View view2 = transitionValues.view;
            if (view2 != null) {
                Map map = transitionValues.values;
                k.a((Object) map, "transitionValues.values");
                map.put(l, (CardView) view2);
                Map map2 = transitionValues.values;
                k.a((Object) map2, "transitionValues.values");
                map2.put(m, Boolean.valueOf(z));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.cardview.widget.CardView");
        }
    }

    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        CharSequence charSequence;
        String displayCardNumber;
        CharSequence charSequence2;
        CharSequence charSequence3;
        String displayCardNumber2;
        String displayCardNumber3;
        ViewGroup viewGroup2 = viewGroup;
        TransitionValues transitionValues3 = transitionValues;
        if (viewGroup2 == null || transitionValues3 == null || transitionValues2 == null) {
            return null;
        }
        Object obj = transitionValues3.values.get(l);
        if (obj != null) {
            CardView cardView = (CardView) obj;
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.appbar_layout);
            if (this.f62333a) {
                TextView textView = (TextView) cardView.findViewById(R.id.etCreditCard);
                k.a((Object) textView, SDKConstants.CARD_NUMBER);
                CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62334b;
                if (cJRCreditCardModelV8 == null || (displayCardNumber3 = cJRCreditCardModelV8.getDisplayCardNumber()) == null) {
                    charSequence2 = "";
                } else {
                    charSequence2 = displayCardNumber3;
                }
                textView.setText(charSequence2);
                TextView textView2 = (TextView) cardView.findViewById(R.id.etCreditCardHint);
                k.a((Object) textView2, "cardHint");
                CJRCreditCardModelV8 cJRCreditCardModelV82 = this.f62334b;
                if (cJRCreditCardModelV82 == null || (displayCardNumber2 = cJRCreditCardModelV82.getDisplayCardNumber()) == null) {
                    charSequence3 = "";
                } else {
                    charSequence3 = displayCardNumber2;
                }
                textView2.setText(charSequence3);
            }
            this.f62339h = (TextView) cardView.findViewById(R.id.txt_card_number);
            TextView textView3 = this.f62339h;
            if (textView3 == null) {
                k.a();
            }
            CJRCreditCardModelV8 cJRCreditCardModelV83 = this.f62334b;
            if (cJRCreditCardModelV83 == null || (displayCardNumber = cJRCreditCardModelV83.getDisplayCardNumber()) == null) {
                charSequence = "";
            } else {
                charSequence = displayCardNumber;
            }
            textView3.setText(charSequence);
            ImageView imageView = (ImageView) cardView.findViewById(R.id.img_bank);
            ImageView imageView2 = (ImageView) cardView.findViewById(R.id.cardtypeView);
            Rect rect = new Rect();
            cardView.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            this.f62335d = cardView.findViewById(R.id.creditcardnumber_get_view);
            View view = this.f62335d;
            if (view == null) {
                k.a();
            }
            view.getGlobalVisibleRect(rect2);
            Rect rect3 = new Rect();
            this.f62336e = cardView.findViewById(R.id.creditcardnumber_set_view);
            View view2 = this.f62336e;
            if (view2 == null) {
                k.a();
            }
            view2.getGlobalVisibleRect(rect3);
            Rect rect4 = new Rect();
            this.f62338g = cardView.findViewById(R.id.amount_view);
            View view3 = this.f62338g;
            if (view3 == null) {
                k.a();
            }
            view3.getGlobalVisibleRect(rect4);
            this.f62337f = cardView.findViewById(R.id.rupee_view);
            this.f62340i = (float) (Math.abs(rect2.top - rect.top) / 2);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f62335d, View.TRANSLATION_Y, new float[]{-this.f62340i});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f62335d, View.ALPHA, new float[]{1.0f, 0.0f});
            k.a((Object) ofFloat2, "animCCGetViewAlpha");
            ofFloat2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.j = (float) (Math.abs(rect2.top - rect.top) / 2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f62336e, View.TRANSLATION_Y, new float[]{this.f62340i, 0.0f});
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f62336e, View.ALPHA, new float[]{0.0f, 1.0f});
            k.a((Object) ofFloat4, "animCCSetViewAlpha");
            ofFloat4.setInterpolator(new AccelerateDecelerateInterpolator());
            this.k = (float) Math.abs(rect.bottom);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f62338g, View.TRANSLATION_Y, new float[]{this.k, 0.0f});
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f62338g, View.ALPHA, new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f62338g, View.SCALE_Y, new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f62337f, View.TRANSLATION_Y, new float[]{this.k, 0.0f});
            ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.f62337f, View.ALPHA, new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.f62337f, View.SCALE_Y, new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat11 = viewGroup3 != null ? ObjectAnimator.ofFloat(viewGroup3, View.ALPHA, new float[]{0.0f, 1.0f}) : null;
            ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(imageView, View.SCALE_X, new float[]{0.0f, 1.0f});
            ObjectAnimator objectAnimator = ofFloat10;
            ObjectAnimator ofFloat13 = ObjectAnimator.ofFloat(imageView, View.SCALE_Y, new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat14 = ObjectAnimator.ofFloat(imageView2, View.SCALE_X, new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat15 = ObjectAnimator.ofFloat(imageView2, View.SCALE_Y, new float[]{0.0f, 1.0f});
            ArrayList arrayList = new ArrayList();
            if (ofFloat11 != null) {
                arrayList.add(ofFloat11);
            }
            if (!this.f62333a) {
                arrayList.add(ofFloat);
                arrayList.add(ofFloat2);
            } else {
                arrayList.add(ofFloat12);
                arrayList.add(ofFloat13);
                arrayList.add(ofFloat14);
                arrayList.add(ofFloat15);
            }
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            arrayList.add(ofFloat5);
            arrayList.add(ofFloat6);
            arrayList.add(ofFloat7);
            arrayList.add(ofFloat8);
            arrayList.add(ofFloat9);
            arrayList.add(objectAnimator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.addListener(this);
            return animatorSet;
        }
        throw new u("null cannot be cast to non-null type androidx.cardview.widget.CardView");
    }

    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f62339h;
        if (textView != null) {
            textView.setVisibility(0);
        }
        View view = this.f62336e;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.f62337f;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.f62338g;
        if (view3 != null) {
            view3.setVisibility(0);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        View view = this.f62335d;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
