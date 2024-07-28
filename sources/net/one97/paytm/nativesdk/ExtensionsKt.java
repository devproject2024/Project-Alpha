package net.one97.paytm.nativesdk;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.Collection;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.nativesdk.Utils.InvalidLifeCycleOwner;
import net.one97.paytm.nativesdk.Utils.ShimmerFrameLayout;

public final class ExtensionsKt {
    public static final /* synthetic */ <T extends ai> T getViewModel(ao aoVar, al.b bVar) {
        k.c(aoVar, "$this$getViewModel");
        k.c(bVar, "viewModelFactory");
        al alVar = new al(aoVar, bVar);
        k.b();
        T a2 = alVar.a(ai.class);
        k.a((Object) a2, "ViewModelProvider(this, …elFactory)[T::class.java]");
        return a2;
    }

    public static final <E, T extends Collection<? extends E>> void isNotNullNotEmpty(T t, b<? super T, x> bVar) {
        k.c(bVar, H5Param.FUNC);
        if (t != null && (!t.isEmpty())) {
            bVar.invoke(t);
        }
    }

    public static final <E, T extends Collection<? extends E>> boolean isNotNullNotEmpty(T t) {
        return t != null && (t.isEmpty() ^ true);
    }

    public static final boolean isNotNullNotBlank(String str) {
        if (str != null) {
            if (str.length() > 0) {
                return true;
            }
        }
        return false;
    }

    public static final String getStringIfNotBlank(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }

    public static final boolean ifNotNullNotBlank(String str, b<? super String, x> bVar) {
        k.c(bVar, H5Param.FUNC);
        if (str != null) {
            if (str.length() > 0) {
                bVar.invoke(str);
                return true;
            }
        }
        return false;
    }

    public static final <E, T extends Enum<E>> String nameToLowercase(T t) {
        k.c(t, "$this$nameToLowercase");
        String name = t.name();
        if (name != null) {
            String lowerCase = name.toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public static final void setAllOnClickListener(Group group, View.OnClickListener onClickListener) {
        k.c(group, "$this$setAllOnClickListener");
        k.c(onClickListener, "listener");
        int[] referencedIds = group.getReferencedIds();
        k.a((Object) referencedIds, "referencedIds");
        for (int findViewById : referencedIds) {
            group.getRootView().findViewById(findViewById).setOnClickListener(onClickListener);
        }
    }

    public static final void visible(View view) {
        k.c(view, "$this$visible");
        view.setVisibility(0);
    }

    public static final void gone(View view) {
        k.c(view, "$this$gone");
        view.setVisibility(8);
    }

    public static final void startLoaderAnimation(LottieAnimationView lottieAnimationView) {
        k.c(lottieAnimationView, "$this$startLoaderAnimation");
        visible(lottieAnimationView);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    public static /* synthetic */ void startLoaderAnimation$default(LottieAnimationView lottieAnimationView, int i2, float f2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f2 = 1.0f;
        }
        startLoaderAnimation(lottieAnimationView, i2, f2);
    }

    public static final void startLoaderAnimation(LottieAnimationView lottieAnimationView, int i2, float f2) {
        k.c(lottieAnimationView, "$this$startLoaderAnimation");
        visible(lottieAnimationView);
        lottieAnimationView.setAnimation(i2);
        lottieAnimationView.loop(false);
        lottieAnimationView.setSpeed(f2);
        lottieAnimationView.playAnimation();
    }

    public static final void stopLoaderAnimation(LottieAnimationView lottieAnimationView) {
        k.c(lottieAnimationView, "$this$stopLoaderAnimation");
        gone(lottieAnimationView);
        lottieAnimationView.cancelAnimation();
    }

    public static final void startAnimation(ShimmerFrameLayout shimmerFrameLayout) {
        k.c(shimmerFrameLayout, "$this$startAnimation");
        visible(shimmerFrameLayout);
        shimmerFrameLayout.startShimmerAnimation();
    }

    public static final void stopAnimation(ShimmerFrameLayout shimmerFrameLayout) {
        k.c(shimmerFrameLayout, "$this$stopAnimation");
        gone(shimmerFrameLayout);
        shimmerFrameLayout.stopShimmerAnimation();
    }

    public static final void isNotNullNotBlank(String str, b<? super String, x> bVar) {
        k.c(bVar, "function");
        if (isNotNullNotBlank(str)) {
            if (str == null) {
                k.a();
            }
            bVar.invoke(str);
        }
    }

    public static final void setVisibility(View view, boolean z) {
        k.c(view, "$this$setVisibility");
        if (z) {
            visible(view);
        } else {
            gone(view);
        }
    }

    public static /* synthetic */ void toggleVisibility$default(View view, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        toggleVisibility(view, bool);
    }

    public static final void toggleVisibility(View view, Boolean bool) {
        k.c(view, "$this$toggleVisibility");
        if (view.getVisibility() == 0) {
            gone(view);
            if (k.a((Object) bool, (Object) Boolean.TRUE)) {
                view.animate().setDuration(300).alpha(0.0f);
                return;
            }
            return;
        }
        visible(view);
        if (k.a((Object) bool, (Object) Boolean.TRUE)) {
            view.animate().setDuration(300).alpha(1.0f);
        }
    }

    public static final void safeBlock(a<x> aVar) {
        k.c(aVar, "function");
        try {
            aVar.invoke();
        } catch (Exception unused) {
        }
    }

    public static final void attachToLifecycleOwner(p pVar, Context context) {
        k.c(pVar, "$this$attachToLifecycleOwner");
        k.c(context, "context");
        if (context instanceof q) {
            ((q) context).getLifecycle().a(pVar);
            return;
        }
        throw new InvalidLifeCycleOwner("Context should be instance of Lifecycle Owner");
    }

    public static final <E, T extends Collection<? extends E>> boolean hasIndex(T t, int i2) {
        k.c(t, "$this$hasIndex");
        return i2 >= 0 && (t.isEmpty() ^ true) && i2 < t.size();
    }

    public static final void safeBlockWithLogging(String str, String str2, a<x> aVar) {
        k.c(str, "classname");
        k.c(str2, "label");
        k.c(aVar, "function");
        try {
            aVar.invoke();
        } catch (Exception e2) {
            if (PaytmSDK.getCallbackListener() != null) {
                PaytmSDK.getCallbackListener().logException(str, str2, e2);
            }
        }
    }

    public static final /* synthetic */ <T extends ai> T withViewModel(ao aoVar, al.b bVar, b<? super T, x> bVar2) {
        k.c(aoVar, "$this$withViewModel");
        k.c(bVar, "viewModelFactory");
        k.c(bVar2, "body");
        al alVar = new al(aoVar, bVar);
        k.b();
        T a2 = alVar.a(ai.class);
        k.a((Object) a2, "ViewModelProvider(this, …elFactory)[T::class.java]");
        bVar2.invoke(a2);
        return a2;
    }
}
