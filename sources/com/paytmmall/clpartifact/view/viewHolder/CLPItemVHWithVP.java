package com.paytmmall.clpartifact.view.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CirclePageIndicator;
import com.paytmmall.clpartifact.listeners.IGAClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.IParentListener;
import com.paytmmall.clpartifact.listeners.ITimerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.utils.SFTimerTask;
import com.paytmmall.clpartifact.view.SFCustomPager;
import com.paytmmall.clpartifact.view.actions.IResetListener;
import com.paytmmall.clpartifact.view.adapter.SliderViewPagerAdapter;
import com.paytmmall.clpartifact.view.adapter.SlidingViewPager;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Timer;

public class CLPItemVHWithVP extends ClickableRVChildViewHolder implements ITimerListener {
    public static final String TAG = CLPItemVHWithVP.class.getName();
    private final int DEFAULT_POSITION = -1;
    /* access modifiers changed from: private */
    public int PAGER_ANIM_TIME = H5PullContainer.DEFALUT_DURATION;
    private CustomAction customAction;
    private long defaultDuration = 6000;
    private Handler handler = new Handler();
    private int lastposition = -1;
    private ViewDataBinding mDataBinding;
    protected List<Item> mItems;
    private SliderViewPagerAdapter mViewPagerAdapter;
    /* access modifiers changed from: private */
    public CirclePageIndicator pageIndicator;
    protected ViewPager pager;
    private long swipeDuration = 6000;
    /* access modifiers changed from: private */
    public Timer timer;

    /* access modifiers changed from: protected */
    public boolean isInfiniteCarouselEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void setPagerMargin(ViewPager viewPager) {
    }

    public CLPItemVHWithVP(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        this.mDataBinding = viewDataBinding;
        this.pager = (ViewPager) this.mDataBinding.getRoot().findViewById(R.id.mall_image_pager);
        this.customAction = customAction2;
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        super.doBinding(view);
        this.pageIndicator = (CirclePageIndicator) this.mDataBinding.getRoot().findViewById(R.id.slider_page_indicator);
        this.mItems = view.getItems();
        ViewPager viewPager = this.pager;
        if (viewPager instanceof SFCustomPager) {
            ((SFCustomPager) viewPager).setAutoScrollingEnabled(isAutoSwipeEnabled(view));
        }
        createAdapter(view);
    }

    private void createAdapter(View view) {
        View view2 = view;
        int i2 = 0;
        if (this.mViewPagerAdapter == null || isMallSingleItem(this.pager, view2)) {
            this.mViewPagerAdapter = new SliderViewPagerAdapter(this.mItems, view.getType(), view.getId(), isInfiniteCarouselEnabled(), gaHelper(), new IParentListener() {
                public final boolean isCLPListenerAvailable() {
                    return CLPItemVHWithVP.this.lambda$createAdapter$0$CLPItemVHWithVP();
                }
            }, this.customAction);
            setPagerMargin(this.pager);
            this.pager.setAdapter(this.mViewPagerAdapter);
            this.pageIndicator.setViewPager(this.pager, getBannerMiddleIndex());
            this.pageIndicator.setSnap(true);
            setupStartPositionForBanner(-1);
            initAutoScroll(view);
            modifyPagerScrollingSpeed();
            fireGAImpressionForItem(this.mItems.size() == 1, 0);
            this.pager.addOnPageChangeListener(new ViewPager.e() {
                public void onPageScrolled(int i2, float f2, int i3) {
                }

                public void onPageSelected(int i2) {
                    CLPItemVHWithVP.this.pageIndicator.setCurrentItem(i2);
                    CLPItemVHWithVP cLPItemVHWithVP = CLPItemVHWithVP.this;
                    cLPItemVHWithVP.fireGAImpressionForItem(cLPItemVHWithVP.getAbsolutePosition(i2) < CLPItemVHWithVP.this.mItems.size(), CLPItemVHWithVP.this.getAbsolutePosition(i2));
                }

                public void onPageScrollStateChanged(int i2) {
                    if (i2 == 1 && CLPUtils.isHomeClient(CLPItemVHWithVP.this.getIgaHandlerListener()) && CLPItemVHWithVP.this.timer != null) {
                        LogUtils.d(CLPItemVHWithVP.TAG, "Disabling timer as user interacted manually.");
                        CLPItemVHWithVP.this.timer.cancel();
                        Timer unused = CLPItemVHWithVP.this.timer = null;
                    }
                }
            });
            setPagerIndicatorCosmetics(this.pageIndicator);
        } else if (getIgaHandlerListener() == null || CLPUtils.isHomeClient(getIgaHandlerListener())) {
            this.mViewPagerAdapter.setData(view2.mItems, view.getType(), view.getId(), new IResetListener(view2) {
                private final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void onReset() {
                    CLPItemVHWithVP.this.lambda$createAdapter$2$CLPItemVHWithVP(this.f$1);
                }
            });
        } else {
            this.pager.setAdapter(new SliderViewPagerAdapter(this.mItems, view.getType(), view.getId(), isInfiniteCarouselEnabled(), gaHelper(), new IParentListener() {
                public final boolean isCLPListenerAvailable() {
                    return CLPItemVHWithVP.this.lambda$createAdapter$1$CLPItemVHWithVP();
                }
            }, this.customAction));
        }
        CirclePageIndicator circlePageIndicator = this.pageIndicator;
        if (this.mViewPagerAdapter.getCount() <= 1) {
            i2 = 4;
        }
        circlePageIndicator.setVisibility(i2);
    }

    public /* synthetic */ boolean lambda$createAdapter$0$CLPItemVHWithVP() {
        return isClpImplementationAvailable();
    }

    public /* synthetic */ boolean lambda$createAdapter$1$CLPItemVHWithVP() {
        return isClpImplementationAvailable();
    }

    private boolean isMallSingleItem(ViewPager viewPager, View view) {
        return (viewPager instanceof SlidingViewPager) && view != null && view.getItems() != null && view.getItems().size() == 1;
    }

    /* access modifiers changed from: private */
    public void fireGAImpressionForItem(boolean z, int i2) {
        List<Item> list;
        if (z && (list = this.mItems) != null && list.size() > i2) {
            handleGAImpression(this.mItems.get(i2), i2);
        }
    }

    /* access modifiers changed from: private */
    public int getAbsolutePosition(int i2) {
        List<Item> list = this.mItems;
        return (list == null || list.size() <= 0) ? i2 : i2 % this.mItems.size();
    }

    private IGAHandlerListener gaHelper() {
        final IGAHandlerListener igaHandlerListener = getIgaHandlerListener();
        return igaHandlerListener != null ? new IGAHandlerListener() {
            public /* synthetic */ void OnItemClick(Item item, int i2, boolean z) {
                IGAClickListener.CC.$default$OnItemClick(this, item, i2, z);
            }

            public void fireImpression(Item item, int i2) {
                igaHandlerListener.fireImpression(item, i2);
            }

            public void fireImpression(View view, int i2) {
                igaHandlerListener.fireImpression(view, i2);
            }

            public void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
                igaHandlerListener.fireInfiniteGridProductImpression(cJRGridProduct, i2);
            }

            public void OnItemClick(Item item, int i2) {
                item.setParentPosition(CLPItemVHWithVP.this.getGAData());
                igaHandlerListener.OnItemClick(item, i2);
            }

            public boolean IsClickEnable() {
                return igaHandlerListener.IsClickEnable();
            }

            public int getClient() {
                return igaHandlerListener.getClient();
            }

            public String getClientRequestID() {
                return igaHandlerListener.getClientRequestID();
            }
        } : igaHandlerListener;
    }

    /* access modifiers changed from: protected */
    public void setPagerIndicatorCosmetics(CirclePageIndicator circlePageIndicator) {
        circlePageIndicator.setStrokeWidth(1.0f);
        try {
            circlePageIndicator.setStrokeColor(Color.parseColor("#ffffff"));
            circlePageIndicator.setFillColor(Color.parseColor("#dde5ed"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onResetPager */
    public void lambda$createAdapter$2$CLPItemVHWithVP(View view) {
        if (view != null) {
            setupStartPositionForBanner(view.getLastItemPosition());
            initAutoScroll(view);
        }
    }

    private void setupStartPositionForBanner(int i2) {
        int i3;
        if (i2 == -1) {
            try {
                i3 = getBannerMiddleIndex();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } else {
            i3 = i2;
        }
        if (i3 > this.mViewPagerAdapter.getActualCount()) {
            i3 %= this.mViewPagerAdapter.getActualCount();
        }
        this.pager.setCurrentItem(i3, i2 != -1);
    }

    private int getBannerMiddleIndex() {
        if (isInfiniteCarouselEnabled()) {
            return getBannerEndIndex() / 2;
        }
        return 0;
    }

    private int getBannerEndIndex() {
        SliderViewPagerAdapter sliderViewPagerAdapter = this.mViewPagerAdapter;
        if (sliderViewPagerAdapter != null) {
            return sliderViewPagerAdapter.getCount();
        }
        return 0;
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
            return this.defaultDuration;
        }
        return ((long) view.getDwellTime()) * 1000;
    }

    public void onViewAttachedToWindow(CLPBaseViewHolder cLPBaseViewHolder, View view) {
        super.onViewAttachedToWindow(cLPBaseViewHolder, view);
        if (view != null) {
            initAutoScroll(view);
        }
    }

    public void onViewDetachedFromWindow(CLPBaseViewHolder cLPBaseViewHolder, View view) {
        super.onViewDetachedFromWindow(cLPBaseViewHolder, view);
        if (view != null) {
            view.setLastItemPosition(this.pager.getCurrentItem());
        }
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
    }

    /* access modifiers changed from: private */
    public void doRunnableWork() {
        ViewPager viewPager = this.pager;
        if (viewPager != null) {
            int currentItem = viewPager.getCurrentItem() + 1;
            if (this.mViewPagerAdapter != null && isEndOfRoad(currentItem)) {
                currentItem = getBannerMiddleIndex();
            }
            this.pager.setCurrentItem(currentItem);
        }
    }

    private boolean isEndOfRoad(int i2) {
        return i2 == getBannerEndIndex();
    }

    private void modifyPagerScrollingSpeed() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.pager, new FixedSpeedScroller(this.pager.getContext(), new DecelerateInterpolator()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onTick() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.post(new Runnable() {
                public final void run() {
                    CLPItemVHWithVP.this.doRunnableWork();
                }
            });
        }
    }

    public Activity getView() {
        return CustomActionHelper.INSTANCE.getHostActivity(this.mDataBinding.getRoot().getContext(), this.customAction);
    }

    public class FixedSpeedScroller extends Scroller {
        FixedSpeedScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public void startScroll(int i2, int i3, int i4, int i5, int i6) {
            super.startScroll(i2, i3, i4, i5, CLPItemVHWithVP.this.PAGER_ANIM_TIME);
        }

        public void startScroll(int i2, int i3, int i4, int i5) {
            super.startScroll(i2, i3, i4, i5, CLPItemVHWithVP.this.PAGER_ANIM_TIME);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isAutoSwipeEnabled(View view) {
        return this.swipeDuration > 0 && isScrollRequire(view);
    }

    private boolean isScrollRequire(View view) {
        return view != null && !TextUtils.isEmpty(view.getAuto_scroll()) && view.getAuto_scroll().equalsIgnoreCase("true");
    }
}
