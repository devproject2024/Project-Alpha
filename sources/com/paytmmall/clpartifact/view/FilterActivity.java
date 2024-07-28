package com.paytmmall.clpartifact.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.StringUtils;
import com.paytmmall.clpartifact.databinding.ActivityFilterBinding;
import com.paytmmall.clpartifact.listeners.IFilterValueListener;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.modal.grid.CJRFilterValue;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilter;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.FilterWidgetUtils;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.utils.UrlUtils;
import com.paytmmall.clpartifact.utils.Utils;
import com.paytmmall.clpartifact.view.adapter.FilterRecyclerViewAdapter;
import com.paytmmall.clpartifact.view.adapter.IOnFilterClickListener;
import com.paytmmall.clpartifact.view.fragment.FilterCategoryTreeFragment;
import com.paytmmall.clpartifact.view.fragment.FilterDetailFragment;
import com.paytmmall.clpartifact.view.fragment.FilterLinearRectFragment;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.paytmmall.clpartifact.view.viewmodel.InfiniteGridViewModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.one97.paytm.activity.PaytmActivity;

public class FilterActivity extends PaytmActivity implements IOnFilterClickListener {
    public static final String TAG = FilterActivity.class.getSimpleName();
    private ActivityFilterBinding mActivityFilterBinding;
    private String mAppliedFilter;
    private Fragment mCurrentFragment;
    private List<FilterDetailFragment> mFilterDetailFragmentList;
    private List<CJRFilterItem> mFilterList;
    private List<CJRFrontEndFilter> mFrontendFilter;
    private CJRGrid mGridResponse;
    private String mGridUrl;
    private String mInitialUrl;
    private InfiniteGridViewModel mViewModel;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_filter);
        setStatusBarColor();
        this.mActivityFilterBinding = (ActivityFilterBinding) f.a(this, R.layout.activity_filter);
        this.mViewModel = (InfiniteGridViewModel) am.a((FragmentActivity) this).a(InfiniteGridViewModel.class);
        Intent intent = getIntent();
        this.mFilterList = getFilterList(intent);
        this.mGridUrl = getGridUrl(intent);
        this.mInitialUrl = getInitialUrl(intent);
        setupRecyclerView();
        this.mActivityFilterBinding.setHandler(this);
    }

    private void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 23) {
            Utils.setStatusBarColor(this, getColor(R.color.status_color_paytm));
        } else {
            Utils.setStatusBarColor(this, -1);
        }
    }

    private String getInitialUrl(Intent intent) {
        if (intent.hasExtra(CLPConstants.INTENT_KEY_GRID_INTIAL_URL)) {
            return intent.getStringExtra(CLPConstants.INTENT_KEY_GRID_INTIAL_URL);
        }
        return null;
    }

    private void setupRecyclerView() {
        int position = getPosition(getIntent());
        if (position > 0) {
            position--;
        }
        for (int size = this.mFilterList.size() - 1; size >= 0; size--) {
            if (this.mFilterList.get(size).getTitle().equals("Sort")) {
                this.mFilterList.remove(size);
            }
        }
        FilterWidgetUtils.filterToggle(position, this.mFilterList);
        this.mFilterDetailFragmentList = getFilterDetailFragmentList(this.mFilterList);
        this.mActivityFilterBinding.rvFilter.setAdapter(new FilterRecyclerViewAdapter(this.mFilterList, this.mFilterDetailFragmentList, this, position));
        this.mActivityFilterBinding.rvFilter.setLayoutManager(new LinearLayoutManager(this));
    }

    private int getPosition(Intent intent) {
        if (intent.hasExtra(CLPConstants.ARGUMENT_KEY_POSITION)) {
            return intent.getIntExtra(CLPConstants.ARGUMENT_KEY_POSITION, 0);
        }
        return 0;
    }

    private List<FilterDetailFragment> getFilterDetailFragmentList(List<CJRFilterItem> list) {
        ArrayList arrayList = new ArrayList();
        for (CJRFilterItem detailFragment : list) {
            arrayList.add(getDetailFragment(detailFragment));
        }
        return arrayList;
    }

    private String getGridUrl(Intent intent) {
        if (intent.hasExtra(CLPConstants.INTENT_KEY_GRID_URL)) {
            return intent.getStringExtra(CLPConstants.INTENT_KEY_GRID_URL);
        }
        return null;
    }

    private List<CJRFilterItem> getFilterList(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra(CLPConstants.INTENT_KEY_GRID_DATA);
        if (!(serializableExtra instanceof CJRGrid)) {
            return new ArrayList();
        }
        this.mGridResponse = (CJRGrid) serializableExtra;
        return this.mGridResponse.getFilterList();
    }

    public void onFilterItemClick(int i2, CJRFilterItem cJRFilterItem, FilterDetailFragment filterDetailFragment, boolean z) {
        if (!z) {
            applyFilters(i2, false);
        }
        filterDetailFragment.setOnFilterChildClickListener(this);
        this.mCurrentFragment = filterDetailFragment;
        getSupportFragmentManager().a().b(R.id.lyt_filter_detail, this.mCurrentFragment, (String) null).b();
    }

    public void onCategoryFilterClick(String str, boolean z, boolean z2, String str2) {
        String str3;
        String queryParameter = UrlUtils.getQueryParameter(this.mGridUrl, "category");
        if (!TextUtils.isEmpty(str2) && z2) {
            queryParameter = getSanitizedExisting(queryParameter, str2);
        }
        if (z) {
            str3 = addCategoryId(str, z, queryParameter);
        } else {
            str3 = z2 ? addCategoryId(str, z, queryParameter) : removeCategoryId(str, z, queryParameter, str2);
        }
        onUrlUpdate(-1, true, UrlUtils.getUpdatedUrl(this.mGridUrl, "category", str3), false);
    }

    private String getSanitizedExisting(String str, String str2) {
        if (str == null) {
            return str;
        }
        if (str.equalsIgnoreCase(str2)) {
            return null;
        }
        if (!str.contains(str2)) {
            return str;
        }
        return str.replace(str2 + AppConstants.COMMA, " ").trim();
    }

    private String removeCategoryId(String str, boolean z, String str2, String str3) {
        if (str2 == null || z || !str2.contains(str)) {
            return "";
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(str2.split(AppConstants.COMMA)));
        arrayList.remove(str);
        if (arrayList.size() == 0) {
            arrayList.add(str3);
        }
        return Utils.getCSVValue(arrayList);
    }

    private String addCategoryId(String str, boolean z, String str2) {
        if (str2 == null || z) {
            return str;
        }
        return str2 + AppConstants.COMMA + str;
    }

    private void applyFilters(int i2, boolean z) {
        Pair<String, String> selectedFilter = getSelectedFilter();
        if (selectedFilter != null) {
            String updatedUrl = UrlUtils.getUpdatedUrl(this.mGridUrl, (String) selectedFilter.first, (String) selectedFilter.second);
            this.mAppliedFilter = (String) selectedFilter.second;
            if (!this.mAppliedFilter.equals(CLPConstants.INVALID_FILTER_VALUE)) {
                onUrlUpdate(i2, false, updatedUrl, z);
            }
        } else if (z) {
            closeActivity();
        }
    }

    private Pair<String, String> getSelectedFilter() {
        Fragment fragment = this.mCurrentFragment;
        if (fragment instanceof IFilterValueListener) {
            return ((IFilterValueListener) fragment).getUpdatedFilterValues();
        }
        return null;
    }

    public void handleClearAll() {
        GaHandler.getInstance().fireClearFilterEvent();
        hitClearAllApi();
    }

    public void handleClose() {
        finish();
    }

    public void handleApplyAll() {
        fireFilterApplyEvent();
        Pair<String, String> selectedFilter = getSelectedFilter();
        if (selectedFilter != null) {
            String str = (String) selectedFilter.second;
            if (str.equals(this.mAppliedFilter)) {
                closeActivity();
            } else if (!str.equals(CLPConstants.INVALID_FILTER_VALUE)) {
                applyFilters(-1, true);
            }
        } else {
            applyFilters(-1, true);
        }
    }

    private void fireFilterApplyEvent() {
        if (this.mActivityFilterBinding.rvFilter != null && this.mActivityFilterBinding.rvFilter.getAdapter() != null && (this.mActivityFilterBinding.rvFilter.getAdapter() instanceof FilterRecyclerViewAdapter)) {
            int selectedPosition = ((FilterRecyclerViewAdapter) this.mActivityFilterBinding.rvFilter.getAdapter()).getSelectedPosition();
            List<CJRFilterItem> list = this.mFilterList;
            if (list != null && selectedPosition < list.size()) {
                GaHandler.getInstance().fireGridFilterAppliedEvent(this.mFilterList.get(selectedPosition).getTitle());
            }
        }
    }

    private void closeActivity() {
        Intent intent = new Intent(CLPConstants.BROADCAST_ACTION_UPDATE_GRID);
        intent.putExtra(CLPConstants.INTENT_KEY_GRID_DATA, this.mGridResponse);
        intent.putExtra(CLPConstants.INTENT_KEY_GRID_URL, this.mGridUrl);
        setResult(-1, intent);
        finish();
    }

    public void onUrlUpdate(int i2, boolean z, String str, boolean z2) {
        if (!str.equals(this.mGridUrl)) {
            this.mGridUrl = str;
            hitApi(i2, z, z2);
        } else if (this.mGridUrl.equalsIgnoreCase(this.mInitialUrl)) {
            handleClearLocally(this.mFilterList, z2);
        }
    }

    private void handleClearLocally(List<CJRFilterItem> list, boolean z) {
        int i2 = 0;
        for (FilterDetailFragment onClear : this.mFilterDetailFragmentList) {
            onClear.onClear(list.get(i2));
            i2++;
        }
        if (z) {
            closeActivity();
        }
    }

    private void hitApi(int i2, boolean z, boolean z2) {
        this.mActivityFilterBinding.progressBar.setVisibility(0);
        this.mViewModel.fetchGridResponse(this, this.mGridUrl).observe(this, new z(i2, z, z2) {
            private final /* synthetic */ int f$1;
            private final /* synthetic */ boolean f$2;
            private final /* synthetic */ boolean f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onChanged(Object obj) {
                FilterActivity.this.lambda$hitApi$0$FilterActivity(this.f$1, this.f$2, this.f$3, (CJRGrid) obj);
            }
        });
    }

    public /* synthetic */ void lambda$hitApi$0$FilterActivity(int i2, boolean z, boolean z2, CJRGrid cJRGrid) {
        this.mActivityFilterBinding.progressBar.setVisibility(8);
        if (cJRGrid != null) {
            handleSuccessResponse(i2, z, cJRGrid, z2);
        } else {
            LogUtils.e(TAG, "Failed to load data");
        }
    }

    private void hitClearAllApi() {
        if (!this.mGridUrl.equals(this.mInitialUrl)) {
            this.mGridUrl = this.mInitialUrl;
            hitApi(0, false, false);
        }
    }

    private FilterDetailFragment getDetailFragment(CJRFilterItem cJRFilterItem) {
        if (cJRFilterItem != null && CLPConstants.FILTER_LINEAR_RECT.equals(cJRFilterItem.getType())) {
            return FilterLinearRectFragment.getInstance(cJRFilterItem);
        }
        if (cJRFilterItem != null && CLPConstants.FILTER_RANGE_SLIDER.equals(cJRFilterItem.getType())) {
            return FilterPriceSliderFragment.getInstance(cJRFilterItem);
        }
        if (cJRFilterItem == null || !CLPConstants.FILTER_TREE.equals(cJRFilterItem.getType())) {
            return null;
        }
        return FilterCategoryTreeFragment.getInstance(this.mGridResponse.getFrontEndFilterList().get(0));
    }

    private void handleSuccessResponse(int i2, boolean z, CJRGrid cJRGrid, boolean z2) {
        this.mGridUrl = getSanitizedGridUrl(this.mGridUrl, cJRGrid.getFilterList(), cJRGrid.getFrontEndFilterList());
        this.mGridResponse = cJRGrid;
        this.mFrontendFilter = cJRGrid.getFrontEndFilterList();
        if (z2) {
            closeActivity();
            return;
        }
        this.mFilterList = getModifiedFilterList(i2);
        this.mFilterDetailFragmentList = getFilterDetailFragmentList(this.mFilterList);
        RecyclerView recyclerView = this.mActivityFilterBinding.rvFilter;
        List<CJRFilterItem> list = this.mFilterList;
        List<FilterDetailFragment> list2 = this.mFilterDetailFragmentList;
        if (z) {
            i2 = getCategoryTreePosition(list2);
        }
        recyclerView.setAdapter(new FilterRecyclerViewAdapter(list, list2, this, i2));
    }

    private String getSanitizedGridUrl(String str, ArrayList<CJRFilterItem> arrayList, ArrayList<CJRFrontEndFilter> arrayList2) {
        Object obj;
        Set<String> queryParameterNames;
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap();
        if (!(parse == null || (queryParameterNames = parse.getQueryParameterNames()) == null)) {
            for (String next : queryParameterNames) {
                hashMap.put(next, parse.getQueryParameter(next));
            }
        }
        HashMap hashMap2 = new HashMap();
        if (arrayList != null) {
            Iterator<CJRFilterItem> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRFilterItem next2 = it2.next();
                ArrayList<CJRFilterValue> filterApplied = next2.getFilterApplied();
                String filterParam = next2.getFilterParam();
                if (!TextUtils.isEmpty(filterParam)) {
                    ArrayList arrayList3 = new ArrayList();
                    if (filterParam.equalsIgnoreCase("price")) {
                        CJRFilterValue filterAppliedRange = next2.getFilterAppliedRange();
                        if (filterAppliedRange != null) {
                            arrayList3.add(String.valueOf(filterAppliedRange.getAbsoluteMin()));
                            arrayList3.add(String.valueOf(filterAppliedRange.getAbsoluteMax()));
                        }
                    } else if (filterApplied != null) {
                        for (CJRFilterValue next3 : filterApplied) {
                            if (!TextUtils.isEmpty(next3.getID())) {
                                arrayList3.add(next3.getID());
                            }
                        }
                    }
                    hashMap2.put(filterParam, StringUtils.join(arrayList3, AppConstants.COMMA));
                }
            }
        }
        if (arrayList2 != null) {
            Iterator<CJRFrontEndFilter> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                CJRFrontEndFilter next4 = it3.next();
                ArrayList<CJRFilterValue> appliedFrontEndFiltersList = next4.getAppliedFrontEndFiltersList();
                String filterParam2 = next4.getFilterParam();
                if (!TextUtils.isEmpty(filterParam2)) {
                    ArrayList arrayList4 = new ArrayList();
                    if (appliedFrontEndFiltersList != null) {
                        for (CJRFilterValue next5 : appliedFrontEndFiltersList) {
                            if (!TextUtils.isEmpty(next5.getID())) {
                                arrayList4.add(next5.getID());
                            }
                        }
                    }
                    hashMap2.put(filterParam2, StringUtils.join(arrayList4, AppConstants.COMMA));
                }
            }
        }
        if (parse == null) {
            return str;
        }
        Uri.Builder clearQuery = parse.buildUpon().clearQuery();
        for (String str2 : hashMap.keySet()) {
            if (hashMap2.containsKey(str2)) {
                obj = hashMap2.get(str2);
            } else {
                obj = hashMap.get(str2);
            }
            clearQuery = clearQuery.appendQueryParameter(str2, (String) obj);
        }
        return clearQuery.build().toString();
    }

    private int getCategoryTreePosition(List<FilterDetailFragment> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) instanceof FilterCategoryTreeFragment) {
                this.mFilterList.get(i2).setToggleChecked(true);
                return i2;
            }
        }
        return -1;
    }

    private List<CJRFilterItem> getModifiedFilterList(int i2) {
        String categoryDisplayName = FilterWidgetUtils.getCategoryDisplayName(this, this.mFrontendFilter);
        ArrayList<CJRFilterItem> filterList = this.mGridResponse.getFilterList();
        filterList.retainAll(FilterWidgetUtils.VALID_FILTER_ITEMS);
        FilterWidgetUtils.sanitizeFilterUtils(filterList);
        FilterWidgetUtils.appendCategory(this.mGridResponse.getFrontEndFilterList(), filterList, categoryDisplayName);
        return FilterWidgetUtils.filterToggle(i2, filterList);
    }

    public void onBackPressed() {
        finish();
    }
}
