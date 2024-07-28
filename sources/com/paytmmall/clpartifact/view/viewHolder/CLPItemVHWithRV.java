package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;
import androidx.recyclerview.widget.v;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.FlashSaleView;
import com.paytmmall.clpartifact.common.TimeUtils;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.ISnapPositionChangeListener;
import com.paytmmall.clpartifact.listeners.SnapOnScrollListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.DotsIndicatorDecoration;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ValidateViewResponse;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;
import java.util.List;

public class CLPItemVHWithRV extends ClickableRVChildViewHolder {
    private CLPItemRVAdapter adapter;
    private View colorBackground = this.mViewDataBinding.getRoot().findViewById(R.id.color_background);
    private CustomAction customAction;
    private DotsIndicatorDecoration dotsIndicator = getDotIndicator();
    private View flashSaleContainer = this.mViewDataBinding.getRoot().findViewById(R.id.flash_sale_container);
    private FlashSaleView flashSaleTextView = ((FlashSaleView) this.mViewDataBinding.getRoot().findViewById(R.id.timer_view));
    private IGAHandlerListener gaListener;
    private RecyclerView.LayoutManager layoutManager;
    private ISnapPositionChangeListener listener;
    protected ViewDataBinding mViewDataBinding;
    protected RecyclerView recyclerView;
    private SnapOnScrollListener snapOnScrollListener;
    private TextView textView;

    /* access modifiers changed from: protected */
    public void addItemDecoration(RecyclerView recyclerView2) {
    }

    /* access modifiers changed from: protected */
    public ClickableRVChildViewHolder getHandler() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean shouldRemoveFling() {
        return true;
    }

    public CLPItemVHWithRV(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        this.mViewDataBinding = viewDataBinding;
        this.gaListener = iGAHandlerListener;
        this.recyclerView = (RecyclerView) this.mViewDataBinding.getRoot().findViewById(R.id.rvThinBanner);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setNestedScrollingEnabled(false);
        this.textView = (TextView) this.mViewDataBinding.getRoot().findViewById(R.id.viewAll);
        this.customAction = customAction2;
    }

    /* access modifiers changed from: protected */
    public DotsIndicatorDecoration getDotIndicator() {
        int dimensionPixelSize = this.mViewDataBinding.getRoot().getContext().getResources().getDimensionPixelSize(R.dimen.radius);
        return new DotsIndicatorDecoration(dimensionPixelSize, dimensionPixelSize * 4, ViewUtils.convertDpToPixel(6.0f, this.itemView.getContext()), b.c(this.mViewDataBinding.getRoot().getContext(), R.color.filter_gray_color), b.c(this.mViewDataBinding.getRoot().getContext(), R.color.filter_text_color));
    }

    /* access modifiers changed from: protected */
    public CLPItemRVAdapter getAdapter(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        view.setGaData(getGAData());
        return new CLPItemRVAdapter(view, getItems(view), getIgaHandlerListener(), view.getId(), this.customAction);
    }

    /* access modifiers changed from: protected */
    public String getType(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        return view.getType();
    }

    /* access modifiers changed from: protected */
    public List<Item> getItems(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        return view.getItems();
    }

    /* access modifiers changed from: protected */
    public void doBinding(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        View findViewById;
        super.doBinding(view);
        if (ValidateViewResponse.validateData(view, this.mViewDataBinding)) {
            this.recyclerView.setOnFlingListener((RecyclerView.j) null);
            setSnapHelper(view, this.recyclerView);
            addItemDecoration(this.recyclerView);
            view.setGaData(getGAData());
            this.adapter = getAdapter(view);
            this.recyclerView.setAdapter(this.adapter);
            if (shouldRemoveFling()) {
                this.recyclerView.setOnFlingListener((RecyclerView.j) null);
            }
            this.layoutManager = getLayoutManager(getType(view));
            this.recyclerView.setLayoutManager(this.layoutManager);
            this.mViewDataBinding.setVariable(BR.layoutManager, this.layoutManager);
            this.mViewDataBinding.setVariable(BR.adapter, this.adapter);
            this.mViewDataBinding.setVariable(BR.view, view);
            this.mViewDataBinding.setVariable(BR.handler, getHandler());
            this.mViewDataBinding.setVariable(BR.title, Boolean.valueOf(showTitle(view)));
            this.mViewDataBinding.executePendingBindings();
            if (!TextUtils.isEmpty(view.getmSeeAllUrl()) || !TextUtils.isEmpty(view.getmSeeAllSeoUrl())) {
                setViewAllTextVisibility(view);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                setBackgroundColor(getType(view));
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.recyclerView.getLayoutManager();
            int i2 = 8;
            if (linearLayoutManager != null) {
                try {
                    if (linearLayoutManager.getChildCount() == getAdapterPosition() + 1 && (findViewById = this.mViewDataBinding.getRoot().findViewById(R.id.separator)) != null) {
                        findViewById.setVisibility(8);
                    }
                } catch (Exception unused) {
                }
            }
            View view2 = this.flashSaleContainer;
            if (view2 != null) {
                if (isFlashSaleWidget(view)) {
                    i2 = 0;
                }
                view2.setVisibility(i2);
                FlashSaleView flashSaleView = this.flashSaleTextView;
                if (flashSaleView != null) {
                    flashSaleView.setRemainingTime(TimeUtils.getTimeDiff(view.getEndTime()));
                }
            }
        }
    }

    public boolean shouldShowBackgroundImage(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        if (view == null) {
            return false;
        }
        return ViewHolderFactory.TYPE_CAROUSEL_BS2.equalsIgnoreCase(view.getType());
    }

    private boolean isFlashSaleWidget(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        return view != null && ViewHolderFactory.TYPE_ROW_BS1.equalsIgnoreCase(view.getType()) && !TextUtils.isEmpty(view.getEndTime()) && TimeUtils.getTimeDiff(view.getEndTime()) > 0;
    }

    /* access modifiers changed from: protected */
    public boolean showTitle(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        if (view != null && !TextUtils.isEmpty(view.getTitle()) && !view.getType().equals(ViewHolderFactory.TYPE_THIN_BANNER) && !view.getType().equals(ViewHolderFactory.TYPE_C1_SQUARE_BANNER) && !view.getType().equals(ViewHolderFactory.TYPE_H1_MERCHANT_BANNER) && !view.getType().equals(ViewHolderFactory.TYPE_THIN_SMALL_BANNER) && !view.getType().equals(ViewHolderFactory.TYPE_CAROUSEL_BS2) && !view.getType().equals(ViewHolderFactory.LAYOUT_SMART_ICON_HEADER) && !view.getType().equals(ViewHolderFactory.LAYOUT_SMART_ICON_BUTTON) && !view.getType().equals(ViewHolderFactory.TYPE_LIST_SMALL_TI) && !view.getType().equals(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID) && !view.getType().equals(ViewHolderFactory.TYPE_BANNER_2) && !view.getType().equals(ViewHolderFactory.TYPE_BANNER_3)) {
            return true;
        }
        return false;
    }

    private void setBackgroundColor(String str) {
        if (str.equalsIgnoreCase(ViewHolderFactory.TYPE_ROW_BS1)) {
            this.recyclerView.setBackground(this.mViewDataBinding.getRoot().getContext().getResources().getDrawable(R.drawable.clp_layout_background));
            TextView textView2 = (TextView) this.mViewDataBinding.getRoot().findViewById(R.id.mainLayout);
            if (textView2 != null) {
                textView2.setPadding(24, 0, 30, 0);
            }
            View view = this.colorBackground;
            if (view != null) {
                view.setBackground(getBackgroundDrawable(str));
            }
        }
    }

    private Drawable getBackgroundDrawable(String str) {
        return str.equalsIgnoreCase(ViewHolderFactory.TYPE_CAROUSEL_BS2) ? this.itemView.getResources().getDrawable(R.drawable.clp_layout_background) : new ColorDrawable(-1);
    }

    private void setViewAllTextVisibility(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        if (this.textView == null) {
            return;
        }
        if (view.getType().equals(ViewHolderFactory.TYPE_ROW_2XN) || view.getType().equals(ViewHolderFactory.TYPE_ROW) || view.getType().equals(ViewHolderFactory.TYPE_ROW_BS2) || view.getType().equals(ViewHolderFactory.TYPE_ROW_1XN) || view.getType().equals(ViewHolderFactory.TYPE_CAROUSEL_BS1) || view.getType().equals(ViewHolderFactory.TYPE_CAROUSEL_2) || view.getType().equals(ViewHolderFactory.TYPE_SMART_ICON_GRID) || view.getType().equals(ViewHolderFactory.TYPE_ROW_BS1)) {
            this.textView.setVisibility(0);
        } else {
            this.textView.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void setSnapHelper(com.paytmmall.clpartifact.modal.clpCommon.View view, RecyclerView recyclerView2) {
        DotsIndicatorDecoration dotsIndicatorDecoration;
        DotsIndicatorDecoration dotsIndicatorDecoration2;
        if (view == null || view.getItems() == null || view.getItems().isEmpty() || view.getItems().size() <= 1) {
            new q().attachToRecyclerView(recyclerView2);
            if (recyclerView2 != null && recyclerView2.getItemDecorationCount() > 0 && (recyclerView2.getItemDecorationAt(0) instanceof DotsIndicatorDecoration)) {
                recyclerView2.removeItemDecorationAt(0);
            }
        } else {
            String type = view.getType();
            if (ViewHolderFactory.TYPE_THIN_BANNER.equals(type) || ViewHolderFactory.TYPE_THIN_SMALL_BANNER.equals(type)) {
                if (recyclerView2.getItemDecorationCount() == 0 && (dotsIndicatorDecoration2 = this.dotsIndicator) != null) {
                    recyclerView2.addItemDecoration(dotsIndicatorDecoration2);
                }
                new v().attachToRecyclerView(recyclerView2);
            }
            if (ViewHolderFactory.LAYOUT_SMART_ICON_HEADER.equals(type) || ViewHolderFactory.TYPE_BANNER_3.equals(type) || ViewHolderFactory.TYPE_BANNER_2.equalsIgnoreCase(type) || ViewHolderFactory.TYPE_H1_BANNER.equalsIgnoreCase(type) || ViewHolderFactory.TYPE_H1_FULL_BANNER.equalsIgnoreCase(type)) {
                if (recyclerView2.getItemDecorationCount() == 0 && (dotsIndicatorDecoration = this.dotsIndicator) != null) {
                    recyclerView2.addItemDecoration(dotsIndicatorDecoration);
                }
                v vVar = new v();
                vVar.attachToRecyclerView(recyclerView2);
                this.listener = new ISnapPositionChangeListener(view) {
                    private final /* synthetic */ com.paytmmall.clpartifact.modal.clpCommon.View f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onSnapPositionChange(int i2) {
                        CLPItemVHWithRV.this.lambda$setSnapHelper$0$CLPItemVHWithRV(this.f$1, i2);
                    }
                };
                SnapOnScrollListener snapOnScrollListener2 = this.snapOnScrollListener;
                if (snapOnScrollListener2 == null) {
                    this.snapOnScrollListener = new SnapOnScrollListener(vVar, SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL, this.listener);
                    recyclerView2.addOnScrollListener(this.snapOnScrollListener);
                } else {
                    snapOnScrollListener2.setOnSnapPositionChangeListener(this.listener);
                }
            }
        }
        List<Item> items = getItems(view);
        if (items != null && items.size() > 0) {
            lambda$setSnapHelper$0$CLPItemVHWithRV(view, 0);
        }
    }

    private Item getItemsForGa(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        List<Item> items = getItems(view);
        if (i2 == -1 || i2 >= items.size()) {
            return null;
        }
        return items.get(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: handleSnapForPosition */
    public void lambda$setSnapHelper$0$CLPItemVHWithRV(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        handleGAImpression(getItemsForGa(view, i2), i2);
    }

    /* access modifiers changed from: protected */
    public RecyclerView.LayoutManager getLayoutManager(String str) {
        if (str.equals(ViewHolderFactory.TYPE_BANNER_2XN) || str.equals(ViewHolderFactory.TYPE_ROW_2XN)) {
            return new GridLayoutManager(this.mViewDataBinding.getRoot().getContext(), 2);
        }
        if (str.equals(ViewHolderFactory.TYPE_BANNER_3XN) || ViewHolderFactory.TYPE_BANNER_3XN_HOME.equalsIgnoreCase(str)) {
            return new GridLayoutManager(this.mViewDataBinding.getRoot().getContext(), 3, 1, false);
        }
        if (str.equals(ViewHolderFactory.TYPE_ROW_1XN) || str.equals(ViewHolderFactory.TYPE_TREE_3)) {
            return new GridLayoutManager(this.mViewDataBinding.getRoot().getContext(), 1);
        }
        if (str.equals(ViewHolderFactory.TYPE_ROW_3XN)) {
            return new GridLayoutManager(this.mViewDataBinding.getRoot().getContext(), 3);
        }
        if (str.equals(ViewHolderFactory.TYPE_SMART_ICON_GRID)) {
            return new GridLayoutManager(this.mViewDataBinding.getRoot().getContext(), 4, 1, false);
        }
        if (ViewHolderFactory.isTiWidgetFamily(str)) {
            return new LinearLayoutManager(this.mViewDataBinding.getRoot().getContext(), 1, false);
        }
        if (str.equals(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID)) {
            return new GridLayoutManager(this.mViewDataBinding.getRoot().getContext(), 3, 1, false);
        }
        return new LinearLayoutManager(this.mViewDataBinding.getRoot().getContext(), 0, false);
    }

    public void handleViewAllClick(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        if (view != null && isClpImplementationAvailable()) {
            String str = view.getmSeeAllUrl() != null ? view.getmSeeAllUrl() : view.getmSeeAllSeoUrl();
            Item item = new Item();
            item.setUrl(str);
            item.setUrlType(view.getUrlType());
            item.setGaData(getGAData());
            if (view.getItems() != null && !view.getItems().isEmpty() && getAdapterPosition() < view.getItems().size()) {
                Item item2 = view.getItems().get(getAdapterPosition());
                item2.setGaData(getGAData());
                IGAHandlerListener iGAHandlerListener = this.gaListener;
                if (iGAHandlerListener == null || !iGAHandlerListener.IsClickEnable()) {
                    GaHandler.getInstance().fireClickEvent(item2, getAdapterPosition());
                } else {
                    this.gaListener.OnItemClick(item2, getAdapterPosition());
                }
            }
            CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(CustomActionHelper.INSTANCE.getHostActivity(this.mViewDataBinding.getRoot().getContext(), this.customAction), item);
        }
    }
}
