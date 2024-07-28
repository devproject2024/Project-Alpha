package com.paytmmall.clpartifact.view.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemFilterLinearRectBinding;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.modal.grid.CJRFilterValue;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FilterValuesAdapter extends RecyclerView.a<FilterValuesItemHolder> {
    /* access modifiers changed from: private */
    public static final String TAG = FilterValuesAdapter.class.getSimpleName();
    private CJRFilterItem mFilterItem;
    /* access modifiers changed from: private */
    public String mFilterParam;
    /* access modifiers changed from: private */
    public List<CJRFilterValue> mFilterValueList;
    private List<CJRFilterValue> mSearchedList;
    /* access modifiers changed from: private */
    public Set<String> mSelectedIDs;
    private boolean showBrandSection;

    private String getMultiColorUrl() {
        return "https://assetscdn1.paytm.com/dexter/weex/images/multi-color.jpg?placeholderRequired=false";
    }

    public FilterValuesAdapter(CJRFilterItem cJRFilterItem, Set<String> set, String str) {
        sortFilterValues(cJRFilterItem);
        this.mFilterValueList = cJRFilterItem.getFilterValues();
        this.mFilterItem = cJRFilterItem;
        this.mSelectedIDs = set;
        this.mSearchedList = cJRFilterItem.getFilterValues();
        this.mFilterParam = str;
    }

    private void sortFilterValues(CJRFilterItem cJRFilterItem) {
        ArrayList<CJRFilterValue> filterValues;
        if (cJRFilterItem != null && !TextUtils.isEmpty(cJRFilterItem.getFilterParam()) && CLPConstants.BRAND_PARAMS.equalsIgnoreCase(cJRFilterItem.getFilterParam()) && (filterValues = cJRFilterItem.getFilterValues()) != null && !filterValues.isEmpty()) {
            Collections.sort(filterValues, $$Lambda$FilterValuesAdapter$GqlXJ4Yyb8V2Cfs3G2wnfE6QvM.INSTANCE);
            this.showBrandSection = filterValues.get(0).isPopular();
        }
    }

    static /* synthetic */ int lambda$sortFilterValues$0(CJRFilterValue cJRFilterValue, CJRFilterValue cJRFilterValue2) {
        if (cJRFilterValue.isPopular() == cJRFilterValue2.isPopular()) {
            return 0;
        }
        return (!cJRFilterValue.isPopular() || cJRFilterValue2.isPopular()) ? 1 : -1;
    }

    public FilterValuesItemHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FilterValuesItemHolder((ItemFilterLinearRectBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_filter_linear_rect));
    }

    public void onBindViewHolder(FilterValuesItemHolder filterValuesItemHolder, int i2) {
        filterValuesItemHolder.bind(this.mFilterValueList.get(i2), Integer.valueOf(i2));
        boolean isBrandVisible = isBrandVisible(i2);
        int i3 = 0;
        filterValuesItemHolder.mItemViewBinding.brandLabel.setVisibility(isBrandVisible ? 0 : 8);
        View view = filterValuesItemHolder.mItemViewBinding.brandDivider;
        if (!isBrandVisible) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private boolean isBrandVisible(int i2) {
        return this.showBrandSection && (i2 == 0 || this.mFilterValueList.get(i2).isPopular() != this.mFilterValueList.get(i2 - 1).isPopular());
    }

    public int getItemCount() {
        List<CJRFilterValue> list = this.mFilterValueList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class FilterValuesItemHolder extends RecyclerView.v {
        public ItemFilterLinearRectBinding mItemViewBinding;

        FilterValuesItemHolder(ItemFilterLinearRectBinding itemFilterLinearRectBinding) {
            super(itemFilterLinearRectBinding.getRoot());
            this.mItemViewBinding = itemFilterLinearRectBinding;
        }

        public void bind(CJRFilterValue cJRFilterValue, Integer num) {
            if (!(FilterValuesAdapter.this.mFilterParam == null || !FilterValuesAdapter.this.mFilterParam.equals("color_filter") || cJRFilterValue.getmColorCode() == null)) {
                ImageView imageView = (ImageView) this.mItemViewBinding.getRoot().findViewById(R.id.colorImageView);
                imageView.setVisibility(0);
                FilterValuesAdapter.this.setColor(cJRFilterValue, imageView);
            }
            boolean isChecked = cJRFilterValue.isChecked();
            if (isChecked) {
                FilterValuesAdapter.this.setSelectedTextColor(this.mItemViewBinding);
            } else {
                FilterValuesAdapter.this.changeTypeface(this.mItemViewBinding);
            }
            this.mItemViewBinding.brandLabel.setText(this.itemView.getResources().getString(cJRFilterValue.isPopular() ? R.string.popular_brands : R.string.other_brands));
            this.mItemViewBinding.setIsApplied(Boolean.valueOf(isChecked));
            setSelected(cJRFilterValue.getID(), isChecked);
            this.mItemViewBinding.setItem(cJRFilterValue);
            this.mItemViewBinding.setPosition(num);
            this.mItemViewBinding.setHandler(this);
        }

        public void onFilterSelected(int i2, CJRFilterValue cJRFilterValue) {
            String access$400 = FilterValuesAdapter.TAG;
            LogUtils.d(access$400, "onFilterSelected: position [" + i2 + "] name [" + cJRFilterValue.getName() + "]");
            boolean isChecked = cJRFilterValue.isChecked() ^ true;
            setSelected(cJRFilterValue.getID(), isChecked);
            ((CJRFilterValue) FilterValuesAdapter.this.mFilterValueList.get(i2)).setChecked(isChecked);
            FilterValuesAdapter filterValuesAdapter = FilterValuesAdapter.this;
            filterValuesAdapter.notifyItemChanged(i2, filterValuesAdapter.mFilterValueList);
        }

        private void setSelected(String str, boolean z) {
            if (z) {
                FilterValuesAdapter.this.mSelectedIDs.add(str);
            } else {
                FilterValuesAdapter.this.mSelectedIDs.remove(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void changeTypeface(ItemFilterLinearRectBinding itemFilterLinearRectBinding) {
        try {
            TextView textView = itemFilterLinearRectBinding.filterName;
            TextView textView2 = itemFilterLinearRectBinding.numberCount;
            textView.setTypeface((Typeface) null, 0);
            textView2.setTypeface((Typeface) null, 0);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void setSelectedTextColor(ItemFilterLinearRectBinding itemFilterLinearRectBinding) {
        try {
            TextView textView = itemFilterLinearRectBinding.filterName;
            textView.setTextColor(itemFilterLinearRectBinding.getRoot().getResources().getColor(R.color.clp_color_2222222));
            textView.setTypeface(textView.getTypeface(), 1);
            TextView textView2 = itemFilterLinearRectBinding.numberCount;
            textView2.setTextColor(itemFilterLinearRectBinding.getRoot().getResources().getColor(R.color.clp_color_2222222));
            textView2.setTypeface(textView2.getTypeface(), 1);
        } catch (Exception unused) {
        }
    }

    public void updateFilterValueList(List<CJRFilterValue> list) {
        this.mFilterValueList = list;
        notifyDataSetChanged();
    }

    public void updateData(CJRFilterItem cJRFilterItem) {
        this.mFilterValueList = cJRFilterItem.getFilterValues();
        this.mFilterItem = cJRFilterItem;
        this.mSelectedIDs = this.mSelectedIDs;
        this.mSearchedList = cJRFilterItem.getFilterValues();
        this.mFilterParam = cJRFilterItem.getFilterParam();
        notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|10|(2:12|13)(1:16)) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if ("multicolor".equalsIgnoreCase(r3.getmColorCode()) != false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        com.paytmmall.clpartifact.utils.ImageUtility.getInstance().setBitmapDrawable(r4, getMultiColorUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r4.setBackground(new android.graphics.drawable.ColorDrawable(com.paytmmall.clpartifact.R.color.clp_white));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setColor(com.paytmmall.clpartifact.modal.grid.CJRFilterValue r3, android.widget.ImageView r4) {
        /*
            r2 = this;
            java.lang.String r0 = r3.getmColorCode()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x003a
            if (r4 == 0) goto L_0x003a
            android.graphics.drawable.Drawable r0 = r2.getParsedColor(r3)     // Catch:{ Exception -> 0x0014 }
            r4.setBackground(r0)     // Catch:{ Exception -> 0x0014 }
            return
        L_0x0014:
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable     // Catch:{ Exception -> 0x001f }
            int r1 = com.paytmmall.clpartifact.R.color.clp_white     // Catch:{ Exception -> 0x001f }
            r0.<init>(r1)     // Catch:{ Exception -> 0x001f }
            r4.setBackground(r0)     // Catch:{ Exception -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0023:
            java.lang.String r3 = r3.getmColorCode()
            java.lang.String r0 = "multicolor"
            boolean r3 = r0.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x003a
            com.paytmmall.clpartifact.utils.ImageUtility r3 = com.paytmmall.clpartifact.utils.ImageUtility.getInstance()
            java.lang.String r0 = r2.getMultiColorUrl()
            r3.setBitmapDrawable(r4, r0)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.adapter.FilterValuesAdapter.setColor(com.paytmmall.clpartifact.modal.grid.CJRFilterValue, android.widget.ImageView):void");
    }

    private Drawable getParsedColor(CJRFilterValue cJRFilterValue) {
        return new ColorDrawable(Color.parseColor(cJRFilterValue.getmColorCode()));
    }
}
