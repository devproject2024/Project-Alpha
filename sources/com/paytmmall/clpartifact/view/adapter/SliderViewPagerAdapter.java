package com.paytmmall.clpartifact.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.a;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.IParentListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.actions.IResetListener;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;
import java.util.List;

public class SliderViewPagerAdapter extends a {
    private static final String TAG = SliderViewPagerAdapter.class.getSimpleName();
    private int LIST_MULTIPLIER;
    private CustomAction customAction;
    private IGAHandlerListener igaHandlerListener;
    private int listSize;
    private List<Item> mItems;
    private ViewDataBinding mViewDataBinding;
    private String mtype;
    private IParentListener parentListener;
    private Long viewId;

    private SliderViewPagerAdapter(List<Item> list, String str, Long l) {
        this.LIST_MULTIPLIER = 100;
        this.mItems = list;
        List<Item> list2 = this.mItems;
        this.listSize = list2 == null ? 0 : list2.size();
        this.mtype = str;
        this.viewId = l;
    }

    public SliderViewPagerAdapter(List<Item> list, String str, Long l, boolean z, IGAHandlerListener iGAHandlerListener, IParentListener iParentListener, CustomAction customAction2) {
        this(list, str, l);
        this.igaHandlerListener = iGAHandlerListener;
        if (!z) {
            this.LIST_MULTIPLIER = 1;
        }
        this.parentListener = iParentListener;
        this.customAction = customAction2;
    }

    public int getCount() {
        if (this.mItems == null) {
            return 0;
        }
        if (getActualCount() > 1) {
            return getActualCount() * this.LIST_MULTIPLIER;
        }
        return 1;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        int actualCount = i2 % (getActualCount() != 0 ? getActualCount() : 1);
        Item item = this.mItems.get(actualCount);
        if (this.mtype.equals(ViewHolderFactory.TYPE_H1_BANNER)) {
            bindH1Banner(viewGroup);
        } else if (this.mtype.equals(ViewHolderFactory.TYPE_H1_FULL_BANNER)) {
            bindH1FullBanner(viewGroup);
        }
        item.setPosition(actualCount);
        setupViewData(item);
        View root = this.mViewDataBinding.getRoot();
        viewGroup.addView(root);
        return root;
    }

    private void setupViewData(Item item) {
        this.mViewDataBinding.setVariable(BR.item, item);
        this.mViewDataBinding.setVariable(BR.handler, this);
        this.mViewDataBinding.executePendingBindings();
    }

    public void handleDeepLink(Item item) {
        IParentListener iParentListener = this.parentListener;
        if (iParentListener != null && iParentListener.isCLPListenerAvailable()) {
            IGAHandlerListener iGAHandlerListener = this.igaHandlerListener;
            if (iGAHandlerListener == null || !iGAHandlerListener.IsClickEnable()) {
                GaHandler.getInstance().fireClickEvent(item, this.mItems.indexOf(item));
            } else {
                this.igaHandlerListener.OnItemClick(item, this.mItems.indexOf(item));
            }
            CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(CustomActionHelper.INSTANCE.getHostActivity(this.mViewDataBinding.getRoot().getContext(), this.customAction), item);
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view = (View) obj;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).removeAllViews();
        }
        view.setOnClickListener((View.OnClickListener) null);
        view.removeCallbacks((Runnable) null);
        viewGroup.removeView(view);
    }

    public int getActualCount() {
        return this.listSize;
    }

    public void setData(List<Item> list, String str, Long l, IResetListener iResetListener) {
        this.mtype = str;
        this.mItems = list;
        this.viewId = l;
        List<Item> list2 = this.mItems;
        this.listSize = list2 != null ? list2.size() : 0;
        notifyDataSetChanged();
        iResetListener.onReset();
    }

    public PaytmAdView.a getAdClickListener(final Item item) {
        return new PaytmAdView.a() {
            public void onAdClick(View view) {
                SliderViewPagerAdapter.this.handleDeepLink(item);
            }
        };
    }

    private void bindH1Banner(ViewGroup viewGroup) {
        this.mViewDataBinding = DataBindingUtils.getViewBinding(viewGroup, R.layout.item_vp_h1_banner_home);
    }

    private void bindH1FullBanner(ViewGroup viewGroup) {
        this.mViewDataBinding = DataBindingUtils.getViewBinding(viewGroup, R.layout.item_h1_full_banner);
    }

    public String getRequestId() {
        IGAHandlerListener iGAHandlerListener = this.igaHandlerListener;
        if (iGAHandlerListener == null || TextUtils.isEmpty(iGAHandlerListener.getClientRequestID())) {
            return CLPArtifact.isCLPListenerAvailable() ? CLPArtifact.getInstance().getCommunicationListener().getClientRequestID() : "";
        }
        return this.igaHandlerListener.getClientRequestID();
    }

    public Context getContext() {
        CustomAction customAction2 = this.customAction;
        if (customAction2 == null || customAction2.getActivityListener() == null) {
            return this.mViewDataBinding.getRoot().getContext();
        }
        return this.customAction.getActivityListener().getHostActivity();
    }
}
