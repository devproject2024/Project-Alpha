package net.one97.paytm.recharge.creditcard;

import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import kotlin.g.b.k;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f62350a = new a();

    private a() {
    }

    public static Transition a(Context context, CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z) {
        k.c(context, "context");
        k.c(cJRCreditCardModelV8, "cardDetails");
        TransitionSet transitionSet = new TransitionSet();
        if (!z) {
            transitionSet.addTransition(new Fade());
        }
        transitionSet.excludeTarget(16908336, true);
        transitionSet.excludeTarget(16908335, true);
        return transitionSet;
    }

    public static Transition b(Context context, CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z) {
        k.c(context, "context");
        k.c(cJRCreditCardModelV8, "cardDetails");
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.setDuration(370);
        transitionSet.setInterpolator(new DecelerateInterpolator(2.0f));
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new ChangeClipBounds());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTransition(new ChangeImageTransform());
        CJRCardEnterTransition cJRCardEnterTransition = new CJRCardEnterTransition();
        cJRCardEnterTransition.f62334b = cJRCreditCardModelV8;
        cJRCardEnterTransition.f62333a = z;
        transitionSet.addTransition(cJRCardEnterTransition);
        return transitionSet;
    }

    public static Transition c(Context context, CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z) {
        k.c(context, "context");
        k.c(cJRCreditCardModelV8, "cardDetails");
        if (z) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new Fade());
        transitionSet.excludeTarget(16908336, true);
        transitionSet.excludeTarget(16908335, true);
        return transitionSet;
    }

    public static Transition d(Context context, CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z) {
        k.c(context, "context");
        k.c(cJRCreditCardModelV8, "cardDetails");
        if (z) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.setDuration(370);
        transitionSet.setInterpolator(new AccelerateInterpolator(2.0f));
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new ChangeClipBounds());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTransition(new ChangeImageTransform());
        CJRCardReturnTransition cJRCardReturnTransition = new CJRCardReturnTransition();
        cJRCardReturnTransition.f62343b = cJRCreditCardModelV8;
        cJRCardReturnTransition.f62342a = z;
        transitionSet.addTransition(cJRCardReturnTransition);
        return transitionSet;
    }
}
