package com.paytmmall.clpartifact.view.viewHolder;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.databinding.ParentStandardRvBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.ITimerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.utils.DotsIndicatorDecoration;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.utils.SFTimerTask;
import com.paytmmall.clpartifact.view.adapter.BannerItemRVAdapter;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewbindings.AddviewBindings;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;
import java.util.Timer;

public class BannerVHWithRV extends CLPItemVHWithRV implements ITimerListener {
    private static final int DEFAULT_SWIPE_DURATION_MS = 6000;
    /* access modifiers changed from: private */
    public static final String TAG = BannerVHWithRV.class.getName();
    private CustomAction customAction;
    private Handler handler = new Handler();
    private RecyclerView recyclerView;
    private long swipeDuration = 6000;
    /* access modifiers changed from: private */
    public Timer timer;

    /* access modifiers changed from: protected */
    public boolean shouldRemoveFling() {
        return false;
    }

    public BannerVHWithRV(ParentStandardRvBinding parentStandardRvBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(parentStandardRvBinding, iGAHandlerListener, customAction2);
        this.customAction = customAction2;
        this.recyclerView = parentStandardRvBinding.rvThinBanner;
        this.recyclerView.addOnScrollListener(new RecyclerView.l() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1 && CLPUtils.isHomeClient(BannerVHWithRV.this.getIgaHandlerListener()) && BannerVHWithRV.this.timer != null) {
                    LogUtils.d(BannerVHWithRV.TAG, "Disabling timer as user interacted manually.");
                    BannerVHWithRV.this.timer.cancel();
                    Timer unused = BannerVHWithRV.this.timer = null;
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
            }
        });
        LogUtils.d(TAG, "Constructor Created for Banner VH");
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        super.doBinding(view);
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        if (layoutManager != null && isLastPosInRange(view.getLastItemPosition(), getItems(view))) {
            layoutManager.scrollToPosition(view.getLastItemPosition());
        }
        String str = TAG;
        LogUtils.d(str, "Banner VH Binding for " + view.getType() + " with pages" + view.getItems());
        if (view != null) {
            initAutoScroll(view);
        }
    }

    private boolean isLastPosInRange(int i2, List<Item> list) {
        return (list == null || i2 == -1 || i2 >= list.size()) ? false : true;
    }

    /* access modifiers changed from: protected */
    public CLPItemRVAdapter getAdapter(View view) {
        view.setGaData(getGAData());
        return new BannerItemRVAdapter(view, getItems(view), getIgaHandlerListener(), view.getId(), this.customAction);
    }

    /* access modifiers changed from: protected */
    public DotsIndicatorDecoration getDotIndicator() {
        int dimensionPixelSize = this.mViewDataBinding.getRoot().getContext().getResources().getDimensionPixelSize(R.dimen.radius_banner);
        return new DotsIndicatorDecoration(dimensionPixelSize, dimensionPixelSize * 2, ViewUtils.convertDpToPixel(2.0f, this.itemView.getContext()), b.c(this.mViewDataBinding.getRoot().getContext(), R.color.filter_gray_color), b.c(this.mViewDataBinding.getRoot().getContext(), R.color.blue), ViewUtils.convertDpToPixel(14.0f, this.mViewDataBinding.getRoot().getContext()));
    }

    public void onViewDetachedFromWindow(CLPBaseViewHolder cLPBaseViewHolder, View view) {
        LogUtils.d(TAG, "Banner VH Detached to Window");
        super.onViewDetachedFromWindow(cLPBaseViewHolder, view);
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        if (view != null && getItems(view) != null && getItems(view).size() > 0 && (layoutManager instanceof LinearLayoutManager)) {
            view.setLastItemPosition(((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() % getItems(view).size());
        }
    }

    private void initAutoScroll(View view) {
        LogUtils.d(TAG, "init auto scroll called.");
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
        this.swipeDuration = getSwipeDuration(view);
        if (!isAutoSwipeEnabled(view)) {
            String str = TAG;
            LogUtils.d(str, "SWIPING disabled for" + view.getId());
            return;
        }
        this.timer = new Timer();
        String str2 = TAG;
        LogUtils.d(str2, "swiping enabled" + view.getId() + "swipeDuration " + this.swipeDuration);
        Timer timer3 = this.timer;
        SFTimerTask sFTimerTask = new SFTimerTask(this);
        long j = this.swipeDuration;
        timer3.schedule(sFTimerTask, j, j);
    }

    private long getSwipeDuration(View view) {
        if (view == null || view.getDwellTime() <= 0.0f) {
            return 6000;
        }
        return ((long) view.getDwellTime()) * 1000;
    }

    private boolean isAutoSwipeEnabled(View view) {
        return this.swipeDuration > 0 && isScrollRequire(view);
    }

    private boolean isScrollRequire(View view) {
        return view != null && !TextUtils.isEmpty(view.getAuto_scroll()) && "true".equalsIgnoreCase(view.getAuto_scroll());
    }

    public void onTick() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.post(new Runnable() {
                public final void run() {
                    BannerVHWithRV.this.doRunnableWork();
                }
            });
        }
    }

    public Activity getView() {
        CustomAction customAction2 = this.customAction;
        if (customAction2 != null && customAction2.getActivityListener() != null) {
            return this.customAction.getActivityListener().getHostActivity();
        }
        if (this.recyclerView.getContext() instanceof Activity) {
            return (Activity) this.recyclerView.getContext();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void doRunnableWork() {
        int findFirstVisibleItemPosition;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null && (recyclerView2.getLayoutManager() instanceof LinearLayoutManager) && (findFirstVisibleItemPosition = ((LinearLayoutManager) this.recyclerView.getLayoutManager()).findFirstVisibleItemPosition()) != -1) {
            this.recyclerView.post(new Runnable(findFirstVisibleItemPosition) {
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    BannerVHWithRV.this.lambda$doRunnableWork$0$BannerVHWithRV(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$doRunnableWork$0$BannerVHWithRV(int i2) {
        RecyclerView recyclerView2 = this.recyclerView;
        recyclerView2.smoothScrollToPosition((i2 + 1) % getItemCount(recyclerView2.getAdapter()));
    }

    private int getItemCount(RecyclerView.a aVar) {
        if (aVar != null) {
            return aVar.getItemCount();
        }
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    public void handleSnapForPosition(View view, int i2) {
        android.view.View findViewByPosition;
        super.lambda$setSnapHelper$0$CLPItemVHWithRV(view, i2);
        LinearLayoutManager linearLayoutManager = this.recyclerView.getLayoutManager() instanceof LinearLayoutManager ? (LinearLayoutManager) this.recyclerView.getLayoutManager() : null;
        List<Item> items = getItems(view);
        if (linearLayoutManager != null && items != null && items.size() > 0 && (findViewByPosition = linearLayoutManager.findViewByPosition(i2 % items.size())) != null) {
            android.view.View findViewById = findViewByPosition.findViewById(R.id.avatar);
            if (findViewById instanceof PaytmAdView) {
                AddviewBindings.setAddView((PaytmAdView) findViewById, items.get(i2 % items.size()), getRequestId());
            }
        }
    }

    public String getRequestId() {
        if (getIgaHandlerListener() != null) {
            return getIgaHandlerListener().getClientRequestID();
        }
        return CLPArtifact.isCLPListenerAvailable() ? CLPArtifact.getInstance().getCommunicationListener().getClientRequestID() : "";
    }
}
