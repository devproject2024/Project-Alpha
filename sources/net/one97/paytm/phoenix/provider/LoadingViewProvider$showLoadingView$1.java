package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.paytm_finance.R;

final class LoadingViewProvider$showLoadingView$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ LoadingViewProvider this$0;

    LoadingViewProvider$showLoadingView$1(LoadingViewProvider loadingViewProvider, Activity activity) {
        this.this$0 = loadingViewProvider;
        this.$activity = activity;
    }

    public final void run() {
        View view;
        LottieAnimationView lottieAnimationView;
        View view2;
        if (this.this$0.lastActivityInstance == null || (!k.a((Object) this.$activity.toString(), (Object) this.this$0.lastActivityInstance))) {
            try {
                this.this$0.inflatedView = new WeakReference(this.$activity.getLayoutInflater().inflate(R.layout.app_loading_view, (ViewGroup) null));
                WeakReference access$getInflatedView$p = this.this$0.inflatedView;
                if (!(access$getInflatedView$p == null || (view2 = (View) access$getInflatedView$p.get()) == null)) {
                    FrameLayout frameLayout = (FrameLayout) this.$activity.findViewById(16908290);
                    if (frameLayout != null) {
                        frameLayout.addView(view2);
                    }
                    this.this$0.view = new WeakReference(view2.findViewById(R.id.progress_loading));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.this$0.lastActivityInstance = this.$activity.toString();
        }
        WeakReference access$getView$p = this.this$0.view;
        if (!(access$getView$p == null || (lottieAnimationView = (LottieAnimationView) access$getView$p.get()) == null)) {
            a.a(lottieAnimationView);
        }
        WeakReference access$getInflatedView$p2 = this.this$0.inflatedView;
        if (access$getInflatedView$p2 != null && (view = (View) access$getInflatedView$p2.get()) != null) {
            view.post(new LoadingViewProvider$showLoadingView$1$$special$$inlined$apply$lambda$1(view, this));
        }
    }
}
