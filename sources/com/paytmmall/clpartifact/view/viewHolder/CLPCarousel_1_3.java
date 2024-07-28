package com.paytmmall.clpartifact.view.viewHolder;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.v;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.databinding.Carousel13Binding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.SFSColorUtils;
import com.paytmmall.clpartifact.view.adapter.HomeCarousel_1_3Adapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.Timer;
import java.util.TimerTask;

public class CLPCarousel_1_3 extends ClickableRVChildViewHolder {
    private static final int DEFAULT_SCROLL_DURATION_MS = 6000;
    private Timer autoScrollTimer;
    private Carousel13Binding binding;
    private HomeCarousel_1_3Adapter carousel_1_3Adapter;
    private CustomAction customAction;
    private LinearLayoutManager layoutManager;
    private IGAHandlerListener listener;
    private int scrollCount = -1;
    private View view;

    public CLPCarousel_1_3(Carousel13Binding carousel13Binding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(carousel13Binding, iGAHandlerListener, customAction2);
        this.binding = carousel13Binding;
        this.listener = iGAHandlerListener;
        this.customAction = customAction2;
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view2) {
        setGAData(view2.getGaData());
        this.binding.setVariable(BR.view, view2);
        this.binding.setVariable(BR.handler, this);
        this.binding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
        this.view = view2;
        this.binding.executePendingBindings();
        setBackgroundColor(view2);
        setRecyclerView(this.binding.carousel13Rv);
    }

    public void onViewAttachedToWindow(CLPBaseViewHolder cLPBaseViewHolder, View view2) {
        super.onViewAttachedToWindow(cLPBaseViewHolder, view2);
        initAutoScroll(this.binding.carousel13Rv);
    }

    public void onViewDetachedFromWindow(CLPBaseViewHolder cLPBaseViewHolder, View view2) {
        super.onViewDetachedFromWindow(cLPBaseViewHolder, view2);
        cancelTimer();
    }

    private void initAutoScroll(final RecyclerView recyclerView) {
        this.scrollCount = this.layoutManager.findFirstVisibleItemPosition();
        this.autoScrollTimer = new Timer();
        long dwellTime = this.view.getDwellTime() > 0.0f ? (long) (this.view.getDwellTime() * 1000.0f) : 6000;
        if ("true".equalsIgnoreCase(this.view.getAuto_scroll())) {
            final $$Lambda$CLPCarousel_1_3$sv73ruP3W8e_b9apHAWrLIr85Jo r1 = new Runnable(recyclerView, new p(recyclerView.getContext()) {
                public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 75.0f / ((float) displayMetrics.densityDpi);
                }
            }) {
                private final /* synthetic */ RecyclerView f$1;
                private final /* synthetic */ p f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    CLPCarousel_1_3.this.lambda$initAutoScroll$0$CLPCarousel_1_3(this.f$1, this.f$2);
                }
            };
            this.autoScrollTimer.schedule(new TimerTask() {
                public void run() {
                    recyclerView.post(r1);
                }
            }, 0, dwellTime);
        }
    }

    public /* synthetic */ void lambda$initAutoScroll$0$CLPCarousel_1_3(RecyclerView recyclerView, p pVar) {
        int i2 = this.scrollCount + 1;
        this.scrollCount = i2;
        int itemCount = i2 % this.carousel_1_3Adapter.getItemCount();
        recyclerView.smoothScrollToPosition(itemCount);
        pVar.setTargetPosition(itemCount);
        this.layoutManager.startSmoothScroll(pVar);
        if (this.scrollCount == this.carousel_1_3Adapter.getItemCount() - 1) {
            this.scrollCount = -1;
        }
    }

    private void setRecyclerView(RecyclerView recyclerView) {
        recyclerView.setNestedScrollingEnabled(false);
        this.carousel_1_3Adapter = new HomeCarousel_1_3Adapter(this.view.mItems, this.view, this.listener, this.binding.getRoot().getContext(), this.customAction);
        recyclerView.setAdapter(this.carousel_1_3Adapter);
        this.layoutManager = new LinearLayoutManager(this.binding.getRoot().getContext(), 0, false);
        recyclerView.setLayoutManager(this.layoutManager);
        recyclerView.setOnFlingListener((RecyclerView.j) null);
        new v().attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.l() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    CLPCarousel_1_3.this.cancelTimer();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void cancelTimer() {
        Timer timer = this.autoScrollTimer;
        if (timer != null) {
            timer.cancel();
            this.autoScrollTimer = null;
        }
    }

    private void setBackgroundColor(View view2) {
        this.binding.carousel13Rv.setBackgroundColor(SFSColorUtils.getParsedColor((view2.getmMetaLayout() == null || TextUtils.isEmpty(view2.getmMetaLayout().getBgColor())) ? "#fff" : view2.getmMetaLayout().getBgColor(), this.binding.getRoot().getContext()));
    }
}
