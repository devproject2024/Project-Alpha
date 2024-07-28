package net.one97.paytm.common.widgets;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ViewAnimator;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.common.widgets.h;

public final class a {

    /* renamed from: net.one97.paytm.common.widgets.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f49880a = new int[C0884a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                net.one97.paytm.common.widgets.a$a[] r0 = net.one97.paytm.common.widgets.a.C0884a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f49880a = r0
                int[] r0 = f49880a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.common.widgets.a$a r1 = net.one97.paytm.common.widgets.a.C0884a.LEFT_RIGHT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f49880a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.common.widgets.a$a r1 = net.one97.paytm.common.widgets.a.C0884a.TOP_BOTTOM     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f49880a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.common.widgets.a$a r1 = net.one97.paytm.common.widgets.a.C0884a.RIGHT_LEFT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f49880a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.common.widgets.a$a r1 = net.one97.paytm.common.widgets.a.C0884a.BOTTOM_TOP     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.widgets.a.AnonymousClass1.<clinit>():void");
        }
    }

    /* renamed from: net.one97.paytm.common.widgets.a$a  reason: collision with other inner class name */
    public enum C0884a {
        LEFT_RIGHT,
        RIGHT_LEFT,
        TOP_BOTTOM,
        BOTTOM_TOP;

        public final float getEndDegreeForSecondView() {
            return 0.0f;
        }

        public final float getStartDegreeForFirstView() {
            return 0.0f;
        }

        public final float getStartDegreeForSecondView() {
            int i2 = AnonymousClass1.f49880a[ordinal()];
            if (i2 == 1 || i2 == 2) {
                return -90.0f;
            }
            return (i2 == 3 || i2 == 4) ? 90.0f : 0.0f;
        }

        public final float getEndDegreeForFirstView() {
            int i2 = AnonymousClass1.f49880a[ordinal()];
            if (i2 == 1 || i2 == 2) {
                return 90.0f;
            }
            return (i2 == 3 || i2 == 4) ? -90.0f : 0.0f;
        }

        public final C0884a theOtherDirection() {
            int i2 = AnonymousClass1.f49880a[ordinal()];
            if (i2 == 1) {
                return RIGHT_LEFT;
            }
            if (i2 == 2) {
                return BOTTOM_TOP;
            }
            if (i2 == 3) {
                return LEFT_RIGHT;
            }
            if (i2 != 4) {
                return null;
            }
            return TOP_BOTTOM;
        }
    }

    public static void a(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    public static void b(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public static void c(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public static void a(ViewAnimator viewAnimator, C0884a aVar) {
        C0884a aVar2;
        ViewAnimator viewAnimator2 = viewAnimator;
        View currentView = viewAnimator.getCurrentView();
        int displayedChild = viewAnimator.getDisplayedChild();
        int childCount = (displayedChild + 1) % viewAnimator.getChildCount();
        View childAt = viewAnimator2.getChildAt(childCount);
        if (childCount < displayedChild) {
            aVar2 = aVar.theOtherDirection();
        } else {
            aVar2 = aVar;
        }
        Animation[] animationArr = new Animation[2];
        h hVar = new h(aVar2.getStartDegreeForFirstView(), aVar2.getEndDegreeForFirstView(), ((float) currentView.getWidth()) / 2.0f, ((float) currentView.getHeight()) / 2.0f, h.a.SCALE_DOWN);
        hVar.setDuration(300);
        hVar.setFillAfter(true);
        hVar.setInterpolator(new AccelerateInterpolator());
        if (aVar2 == C0884a.BOTTOM_TOP || aVar2 == C0884a.TOP_BOTTOM) {
            hVar.f49909a = 0;
        } else {
            hVar.f49909a = 1;
        }
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(hVar);
        animationArr[0] = animationSet;
        h hVar2 = new h(aVar2.getStartDegreeForSecondView(), aVar2.getEndDegreeForSecondView(), ((float) childAt.getWidth()) / 2.0f, ((float) childAt.getHeight()) / 2.0f, h.a.SCALE_UP);
        hVar2.setDuration(300);
        hVar2.setFillAfter(true);
        hVar2.setInterpolator(new AccelerateInterpolator());
        hVar2.setStartOffset(300);
        if (aVar2 == C0884a.BOTTOM_TOP || aVar2 == C0884a.TOP_BOTTOM) {
            hVar2.f49909a = 0;
        } else {
            hVar2.f49909a = 1;
        }
        AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.addAnimation(hVar2);
        animationArr[1] = animationSet2;
        viewAnimator2.setOutAnimation(animationArr[0]);
        viewAnimator2.setInAnimation(animationArr[1]);
        viewAnimator.showNext();
    }
}
