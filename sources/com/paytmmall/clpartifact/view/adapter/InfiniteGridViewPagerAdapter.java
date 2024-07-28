package com.paytmmall.clpartifact.view.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.fragment.InfiniteFragment;
import com.paytmmall.clpartifact.view.fragment.RatingsReviewFragment;
import com.paytmmall.clpartifact.view.fragment.SearchFragment;
import com.paytmmall.clpartifact.view.fragment.StoresDetailFragment;
import com.paytmmall.clpartifact.view.fragment.VoucherFragment;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfiniteGridViewPagerAdapter extends o {
    private static final String URLTYPE_GRID = "grid";
    private static final String URLTYPE_HOME_PAGE = "homepage";
    private static final String URLTYPE_RATINGS_REVIEW = "review_and_rating";
    private static final String URLTYPE_SEARCH = "search";
    private static final String URL_TYPE_STORES = "stores";
    private static final String VIEW_TYPE_VOUCHER = "vouchers";
    private static HashMap<Integer, String> map = new HashMap<Integer, String>() {
        {
            put(1009, InfiniteGridViewPagerAdapter.URL_TYPE_STORES);
            put(1008, InfiniteGridViewPagerAdapter.URLTYPE_RATINGS_REVIEW);
        }
    };
    private CustomAction customAction;
    private j fragmentManager;
    private IPageChangeRequestListener iPageChangeRequestListener;
    private IStoreDataProvider iStoreDataProvider;
    private ITabVisibilityListener iTabVisibilityListener;
    private int mAdapterPosition;
    private Map<String, Object> mGAData;
    private IGAHandlerListener mGAHandlerListener;
    private List<Item> mItems;
    private boolean reloadFragments;
    private boolean showProductPrice = true;

    public interface IPageChangeRequestListener {
        void pageChange(int i2);
    }

    public interface IStoreDataProvider {
        View getStoreData();
    }

    public interface ITabVisibilityListener {
        void onVisbilityChange(int i2);
    }

    /* access modifiers changed from: package-private */
    public boolean getHardResetValue() {
        return false;
    }

    public InfiniteGridViewPagerAdapter(j jVar, List<Item> list, ITabVisibilityListener iTabVisibilityListener2, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(jVar);
        this.fragmentManager = jVar;
        this.mItems = list;
        this.iTabVisibilityListener = iTabVisibilityListener2;
        this.mGAHandlerListener = iGAHandlerListener;
        this.customAction = customAction2;
    }

    public void setGAData(Map<String, Object> map2) {
        this.mGAData = map2;
    }

    public Fragment getItem(int i2) {
        return getInfiniteFragment(i2);
    }

    private Fragment getInfiniteFragment(int i2) {
        List<Item> list = this.mItems;
        String str = "";
        if (list == null || list.get(i2) == null) {
            InfiniteFragment instance = InfiniteFragment.getInstance(str, this.mAdapterPosition, this.showProductPrice);
            instance.setGAData(this.mGAHandlerListener, this.mGAData);
            return instance;
        } else if (TextUtils.isEmpty(this.mItems.get(i2).getUrlType())) {
            InfiniteFragment instance2 = InfiniteFragment.getInstance(this.mItems.get(i2).getSeourl(), this.mAdapterPosition, this.showProductPrice);
            instance2.setGAData(this.mGAHandlerListener, this.mGAData);
            return instance2;
        } else {
            String urlType = this.mItems.get(i2).getUrlType();
            char c2 = 65535;
            switch (urlType.hashCode()) {
                case -906336856:
                    if (urlType.equals("search")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -892066894:
                    if (urlType.equals(URL_TYPE_STORES)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -485371922:
                    if (urlType.equals("homepage")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3181382:
                    if (urlType.equals("grid")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 707173452:
                    if (urlType.equals(URLTYPE_RATINGS_REVIEW)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    return RatingsReviewFragment.getInstance(this.mItems.get(i2), this.mAdapterPosition, this.iStoreDataProvider.getStoreData());
                }
                if (c2 == 2) {
                    if (!(this.iStoreDataProvider.getStoreData() == null || this.iStoreDataProvider.getStoreData().getStoreInfo() == null || TextUtils.isEmpty(this.iStoreDataProvider.getStoreData().getStoreInfo().getName()))) {
                        str = this.iStoreDataProvider.getStoreData().getStoreInfo().getName();
                    }
                    return StoresDetailFragment.getInstance(this.mItems.get(i2), this.mAdapterPosition, str);
                } else if (c2 == 3) {
                    return getClpFragment(this.mItems.get(i2), this.mAdapterPosition);
                } else {
                    if (c2 != 4) {
                        InfiniteFragment instance3 = InfiniteFragment.getInstance(this.mItems.get(i2).getSeourl(), this.mAdapterPosition, this.showProductPrice);
                        instance3.setGAData(this.mGAHandlerListener, this.mGAData);
                        return instance3;
                    }
                    SearchFragment instance4 = SearchFragment.getInstance(this, this.iStoreDataProvider.getStoreData(), this.mItems.get(i2));
                    instance4.setCustomAction(this.customAction);
                    return instance4;
                }
            } else if (VIEW_TYPE_VOUCHER.equalsIgnoreCase(this.mItems.get(i2).getType())) {
                return getVoucherFragment(this.mItems.get(i2), this.mAdapterPosition);
            } else {
                InfiniteFragment instance5 = InfiniteFragment.getInstance(this.mItems.get(i2).getSeourl(), this.mAdapterPosition, this.showProductPrice);
                instance5.setGAData(this.mGAHandlerListener, this.mGAData);
                return instance5;
            }
        }
    }

    private Fragment getClpFragment(Item item, int i2) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(CLPConstants.CLP_RESPONSE, item.getChildItems());
        bundle.putBoolean(CLPConstants.ARGUMENT_IS_BOTTOM_TAB, false);
        bundle.putBoolean(CLPConstants.CAN_CLP_SCROLL, true);
        bundle.putBoolean(CLPConstants.IS_NESTED, true);
        CustomAction customAction2 = this.customAction;
        if (customAction2 == null || customAction2.getMallSdkVHListener() == null) {
            return new Fragment();
        }
        return this.customAction.getMallSdkVHListener().getCLPFragment((String) null, i2, bundle, this.iTabVisibilityListener);
    }

    private Fragment getVoucherFragment(Item item, int i2) {
        VoucherFragment voucherFragment = new VoucherFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CLPConstants.GRID_URL, item.getSeourl());
        bundle.putInt(CLPConstants.ARG_POSITION, i2);
        voucherFragment.setArguments(bundle);
        voucherFragment.setCustomAction(this.customAction);
        return voucherFragment;
    }

    public int getCount() {
        List<Item> list = this.mItems;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public CharSequence getPageTitle(int i2) {
        List<Item> list = this.mItems;
        return list == null ? "" : list.get(i2).getName();
    }

    public void updateData(List<Item> list, int i2, IStoreDataProvider iStoreDataProvider2, IPageChangeRequestListener iPageChangeRequestListener2, boolean z) {
        this.mItems = list;
        this.mAdapterPosition = i2;
        this.iStoreDataProvider = iStoreDataProvider2;
        this.iPageChangeRequestListener = iPageChangeRequestListener2;
        this.showProductPrice = z;
        notifyDataSetChanged();
    }

    public void setViewPager(int i2) {
        IPageChangeRequestListener iPageChangeRequestListener2 = this.iPageChangeRequestListener;
        if (iPageChangeRequestListener2 != null) {
            iPageChangeRequestListener2.pageChange(i2);
        }
    }

    public int getItemPosition(Object obj) {
        if (this.reloadFragments || getHardResetValue()) {
            return -2;
        }
        return super.getItemPosition(obj);
    }

    public void handleRedirection(RedirectorModel redirectorModel) {
        List<Item> list;
        String str = map.get(Integer.valueOf(redirectorModel.getRequest()));
        if (str != null && (list = this.mItems) != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                if (str.equalsIgnoreCase(this.mItems.get(i2).getUrlType())) {
                    setViewPager(i2);
                    return;
                }
            }
        }
    }

    public void reloadFragments(List<Item> list, boolean z) {
        this.mItems = list;
        this.showProductPrice = z;
        this.reloadFragments = true;
        notifyDataSetChanged();
        this.reloadFragments = false;
    }
}
