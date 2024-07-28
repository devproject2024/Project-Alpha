package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.view.adapter.InfiniteGridViewPagerAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InfiniteGridRowViewHolder extends ClickableRVChildViewHolder {
    private CustomAction customAction;
    private boolean isTabbed2;
    private InfiniteGridViewPagerAdapter mAdapter;
    private j mFragmentManager;
    private ViewDataBinding mViewDataBinding;
    private ViewPager mViewPager;
    private TextView singelTab;
    TabLayout tabLayout;

    static /* synthetic */ View lambda$getFragmentList$2(View view) {
        return view;
    }

    static /* synthetic */ void lambda$initViews$0(int i2) {
    }

    public InfiniteGridRowViewHolder(ViewDataBinding viewDataBinding, j jVar, boolean z, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        this.isTabbed2 = z;
        this.customAction = customAction2;
        initViews(viewDataBinding, jVar);
    }

    private void initViews(final ViewDataBinding viewDataBinding, j jVar) {
        CustomAction customAction2;
        this.mViewDataBinding = viewDataBinding;
        this.mFragmentManager = jVar;
        setViewHolderHeight();
        if (this.isTabbed2) {
            CLPConstants.INFINITE_GRID_HEIGHT_RUNNABLE = new Runnable() {
                public final void run() {
                    InfiniteGridRowViewHolder.this.setViewHolderHeight();
                }
            };
        }
        this.tabLayout = (TabLayout) this.mViewDataBinding.getRoot().findViewById(R.id.tabs);
        this.singelTab = (TextView) this.mViewDataBinding.getRoot().findViewById(R.id.single_tab);
        this.mViewPager = (ViewPager) this.mViewDataBinding.getRoot().findViewById(R.id.infinite_grid);
        j jVar2 = this.mFragmentManager;
        if (jVar2 != null) {
            this.mAdapter = new InfiniteGridViewPagerAdapter(jVar2, new ArrayList(), $$Lambda$InfiniteGridRowViewHolder$G6lldQLZEA1Jlijg_czTT_sI2ro.INSTANCE, getIgaHandlerListener(), this.customAction);
            this.mViewPager.setAdapter(this.mAdapter);
            this.tabLayout.setupWithViewPager(this.mViewPager);
            this.tabLayout.setSelectedTabIndicatorColor(this.mViewDataBinding.getRoot().getContext().getResources().getColor(R.color.primaryBlue));
            this.tabLayout.a((TabLayout.b) new TabLayout.c() {
                public void onTabReselected(TabLayout.f fVar) {
                }

                public void onTabUnselected(TabLayout.f fVar) {
                }

                public void onTabSelected(TabLayout.f fVar) {
                    String str;
                    if (fVar.f36763c == null) {
                        str = "";
                    } else {
                        str = fVar.f36763c.toString();
                    }
                    InfiniteGridRowViewHolder.this.getGAData().put(GAUtil.KEY_CATEGORY_TAB_NAME, str);
                    CLPArtifact.getInstance().getCommunicationListener().sendCustomGTMEvents(viewDataBinding.getRoot().getContext(), "clp", " tabbed_widget_ " + str + "_clicked", "homescreen(" + GAUtil.getGakey() + ")", (String) null, CLPConstants.GA_CHANNEL_NAME, GAUtil.MARKET_PLACE);
                }
            });
            if ((this.tabLayout.getContext() instanceof FragmentActivity) && (customAction2 = this.customAction) != null && customAction2.getMallSdkVHListener() != null) {
                this.customAction.getMallSdkVHListener().getReDirector().observe((FragmentActivity) this.tabLayout.getContext(), new z() {
                    public final void onChanged(Object obj) {
                        InfiniteGridRowViewHolder.this.lambda$initViews$1$InfiniteGridRowViewHolder((RedirectorModel) obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$initViews$1$InfiniteGridRowViewHolder(RedirectorModel redirectorModel) {
        handleRedirection(this.mAdapter, redirectorModel);
    }

    /* access modifiers changed from: private */
    public void setViewHolderHeight() {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
        layoutParams.height = getViewHolderHeight();
        this.itemView.setLayoutParams(layoutParams);
    }

    private int getViewHolderHeight() {
        if (this.isTabbed2) {
            return (this.itemView.getResources().getDisplayMetrics().heightPixels - getStatusBarHeight()) - CLPConstants.STORE_BANNER_HEIGHT;
        }
        return -1;
    }

    public int getStatusBarHeight() {
        int identifier = this.mViewDataBinding.getRoot().getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.mViewDataBinding.getRoot().getContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void changeSearchTabForStorelet(List<Item> list) {
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 != null && tabLayout2.getTabCount() > 0 && this.tabLayout.a(0) != null) {
            TabLayout.f a2 = this.tabLayout.a(0);
            android.view.View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.storelet_first_tab_view, (ViewGroup) null, false);
            ((TextView) inflate.findViewById(R.id.tab_text)).setText((list == null || list.isEmpty()) ? "" : list.get(0).getName());
            a2.a(inflate);
            LogUtils.d(TAG, "changeSearchTabForStorelet: ");
        }
    }

    private void handleRedirection(InfiniteGridViewPagerAdapter infiniteGridViewPagerAdapter, RedirectorModel redirectorModel) {
        if (infiniteGridViewPagerAdapter != null) {
            infiniteGridViewPagerAdapter.handleRedirection(redirectorModel);
        }
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        CustomAction customAction2 = this.customAction;
        if (!(customAction2 == null || customAction2.getMallSdkVHListener() == null || this.customAction.getMallSdkVHListener().getFlashView() == null)) {
            view = this.customAction.getMallSdkVHListener().getFlashView();
        }
        super.doBinding(view);
        setBackgroundColor();
        getFragmentList(view);
        appendGAData(view);
        InfiniteGridViewPagerAdapter infiniteGridViewPagerAdapter = this.mAdapter;
        if (infiniteGridViewPagerAdapter != null) {
            infiniteGridViewPagerAdapter.setGAData(getGAData());
        }
    }

    private void setBackgroundColor() {
        this.itemView.setBackground(new ColorDrawable(-1));
    }

    private void appendGAData(View view) {
        try {
            Map<String, Object> gAData = getGAData();
            gAData.put(GAUtil.KEY_RECO_ID, view.getDataSources().get(0).getContainerInstanceId());
            view.setGaData(gAData);
        } catch (Exception e2) {
            LogUtils.printStackTrace(e2);
        }
    }

    private void getFragmentList(View view) {
        ViewPager viewPager;
        if (view != null) {
            List<Item> items = view.getItems();
            this.mAdapter.updateData(items, getAdapterPosition(), new InfiniteGridViewPagerAdapter.IStoreDataProvider() {
                public final View getStoreData() {
                    return InfiniteGridRowViewHolder.lambda$getFragmentList$2(View.this);
                }
            }, new InfiniteGridViewPagerAdapter.IPageChangeRequestListener() {
                public final void pageChange(int i2) {
                    InfiniteGridRowViewHolder.this.lambda$getFragmentList$3$InfiniteGridRowViewHolder(i2);
                }
            }, view.isShowProductPrice());
            if (this.isTabbed2) {
                changeSearchTabForStorelet(items);
            }
            if (this.isTabbed2 && items != null && items.size() > 1 && (viewPager = this.mViewPager) != null && viewPager.getCurrentItem() == 0) {
                this.mViewPager.setCurrentItem(1);
            }
            if (items != null && items.size() == 1) {
                String name = items.get(0).getName();
                this.singelTab.setText(name);
                this.singelTab.setVisibility(0);
                this.tabLayout.setVisibility(8);
                getGAData().put(GAUtil.KEY_CATEGORY_TAB_NAME, name);
            }
        }
    }

    public /* synthetic */ void lambda$getFragmentList$3$InfiniteGridRowViewHolder(int i2) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i2);
        }
    }

    public void reloadAdapterContents(View view, boolean z) {
        InfiniteGridViewPagerAdapter infiniteGridViewPagerAdapter;
        if (view != null && (infiniteGridViewPagerAdapter = this.mAdapter) != null) {
            infiniteGridViewPagerAdapter.reloadFragments(view.getItems(), z);
            if (this.tabLayout.getChildCount() > 0 && this.tabLayout.a(0) != null) {
                this.tabLayout.a(0).d();
                this.tabLayout.setScrollX(0);
            }
        }
    }
}
