package net.one97.paytm.upi.util;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ViewAnimator;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.FlipAnimation;

public class AnimationFactory {
    private static final int DEFAULT_FLIP_TRANSITION_DURATION = 300;

    private AnimationFactory() {
    }

    /* renamed from: net.one97.paytm.upi.util.AnimationFactory$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f69494a = new int[FlipDirection.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                net.one97.paytm.upi.util.AnimationFactory$FlipDirection[] r0 = net.one97.paytm.upi.util.AnimationFactory.FlipDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f69494a = r0
                int[] r0 = f69494a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.upi.util.AnimationFactory$FlipDirection r1 = net.one97.paytm.upi.util.AnimationFactory.FlipDirection.LEFT_RIGHT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f69494a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.upi.util.AnimationFactory$FlipDirection r1 = net.one97.paytm.upi.util.AnimationFactory.FlipDirection.TOP_BOTTOM     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f69494a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.upi.util.AnimationFactory$FlipDirection r1 = net.one97.paytm.upi.util.AnimationFactory.FlipDirection.RIGHT_LEFT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f69494a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.upi.util.AnimationFactory$FlipDirection r1 = net.one97.paytm.upi.util.AnimationFactory.FlipDirection.BOTTOM_TOP     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.util.AnimationFactory.AnonymousClass4.<clinit>():void");
        }
    }

    public enum FlipDirection {
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
            int i2 = AnonymousClass4.f69494a[ordinal()];
            if (i2 == 1 || i2 == 2) {
                return -90.0f;
            }
            return (i2 == 3 || i2 == 4) ? 90.0f : 0.0f;
        }

        public final float getEndDegreeForFirstView() {
            int i2 = AnonymousClass4.f69494a[ordinal()];
            if (i2 == 1 || i2 == 2) {
                return 90.0f;
            }
            return (i2 == 3 || i2 == 4) ? -90.0f : 0.0f;
        }

        public final FlipDirection theOtherDirection() {
            int i2 = AnonymousClass4.f69494a[ordinal()];
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

    public static Animation[] flipAnimation(View view, View view2, FlipDirection flipDirection, long j, Interpolator interpolator) {
        FlipDirection flipDirection2 = flipDirection;
        long j2 = j;
        Animation[] animationArr = new Animation[2];
        float width = ((float) view.getWidth()) / 2.0f;
        float height = ((float) view.getHeight()) / 2.0f;
        FlipAnimation flipAnimation = new FlipAnimation(flipDirection.getStartDegreeForFirstView(), flipDirection.getEndDegreeForFirstView(), width, height, 0.75f, FlipAnimation.ScaleUpDownEnum.SCALE_DOWN);
        flipAnimation.setDuration(j2);
        flipAnimation.setFillAfter(true);
        flipAnimation.setInterpolator(interpolator == null ? new AccelerateInterpolator() : interpolator);
        if (flipDirection2 == FlipDirection.BOTTOM_TOP || flipDirection2 == FlipDirection.TOP_BOTTOM) {
            flipAnimation.setDirection(0);
        } else {
            flipAnimation.setDirection(1);
        }
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(flipAnimation);
        animationArr[0] = animationSet;
        FlipAnimation flipAnimation2 = new FlipAnimation(flipDirection.getStartDegreeForSecondView(), flipDirection.getEndDegreeForSecondView(), width, height, 0.75f, FlipAnimation.ScaleUpDownEnum.SCALE_UP);
        flipAnimation2.setDuration(j2);
        flipAnimation2.setFillAfter(true);
        flipAnimation2.setInterpolator(interpolator == null ? new AccelerateInterpolator() : interpolator);
        flipAnimation2.setStartOffset(j2);
        if (flipDirection2 == FlipDirection.BOTTOM_TOP || flipDirection2 == FlipDirection.TOP_BOTTOM) {
            flipAnimation2.setDirection(0);
        } else {
            flipAnimation2.setDirection(1);
        }
        AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.addAnimation(flipAnimation2);
        animationArr[1] = animationSet2;
        return animationArr;
    }

    public static void flipTransition(ViewAnimator viewAnimator, FlipDirection flipDirection) {
        flipTransition(viewAnimator, flipDirection, 300);
    }

    public static void flipTransition(ViewAnimator viewAnimator, FlipDirection flipDirection, long j) {
        View currentView = viewAnimator.getCurrentView();
        int displayedChild = viewAnimator.getDisplayedChild();
        int childCount = (displayedChild + 1) % viewAnimator.getChildCount();
        View childAt = viewAnimator.getChildAt(childCount);
        if (childCount < displayedChild) {
            flipDirection = flipDirection.theOtherDirection();
        }
        Animation[] flipAnimation = flipAnimation(currentView, childAt, flipDirection, j, (Interpolator) null);
        viewAnimator.setOutAnimation(flipAnimation[0]);
        viewAnimator.setInAnimation(flipAnimation[1]);
        viewAnimator.showNext();
    }

    public static Animation inFromLeftAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation outToRightAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation inFromRightAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation outToLeftAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation inFromTopAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -1.0f, 2, 0.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation outToTopAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation fadeInAnimation(long j, long j2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(j);
        alphaAnimation.setStartOffset(j2);
        return alphaAnimation;
    }

    public static Animation fadeOutAnimation(long j, long j2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setStartOffset(j2);
        alphaAnimation.setDuration(j);
        return alphaAnimation;
    }

    public static Animation fadeInAnimation(long j, final View view) {
        Animation fadeInAnimation = fadeInAnimation(500, 0);
        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(0);
            }

            public final void onAnimationStart(Animation animation) {
                view.setVisibility(8);
            }
        });
        return fadeInAnimation;
    }

    public static Animation fadeOutAnimation(long j, final View view) {
        Animation fadeOutAnimation = fadeOutAnimation(500, 0);
        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
            }

            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        return fadeOutAnimation;
    }

    public static Animation[] fadeInThenOutAnimation(long j, long j2) {
        return new Animation[]{fadeInAnimation(j, 0), fadeOutAnimation(j, j2 + j)};
    }

    public static void fadeOut(View view) {
        if (view != null) {
            view.startAnimation(fadeOutAnimation(500, view));
        }
    }

    public static void fadeIn(View view) {
        if (view != null) {
            view.startAnimation(fadeInAnimation(500, view));
        }
    }

    public static void fadeInThenOut(final View view, long j) {
        if (view != null) {
            view.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            Animation[] fadeInThenOutAnimation = fadeInThenOutAnimation(500, j);
            animationSet.addAnimation(fadeInThenOutAnimation[0]);
            animationSet.addAnimation(fadeInThenOutAnimation[1]);
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    view.setVisibility(8);
                }

                public final void onAnimationStart(Animation animation) {
                    view.setVisibility(0);
                }
            });
            view.startAnimation(animationSet);
        }
    }

    public static void startWalletLoader(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation(R.raw.payments_loader);
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
        }
    }

    public static void stopWalletLoader(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }
}
