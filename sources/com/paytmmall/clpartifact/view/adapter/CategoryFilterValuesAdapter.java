package com.paytmmall.clpartifact.view.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemFilterCategoryBinding;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilterItem;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import java.util.ArrayList;
import java.util.List;

public class CategoryFilterValuesAdapter extends RecyclerView.a<CategoryFilterValuesItemHolder> {
    private static final String TAG = CategoryFilterValuesAdapter.class.getSimpleName();
    private List<CJRFrontEndFilterItem> mFilterValueList;
    /* access modifiers changed from: private */
    public IOnFilterClickListener mOnFilterChildClickListener;

    public CategoryFilterValuesAdapter(List<CJRFrontEndFilterItem> list, IOnFilterClickListener iOnFilterClickListener) {
        this.mFilterValueList = list;
        this.mOnFilterChildClickListener = iOnFilterClickListener;
    }

    public CategoryFilterValuesItemHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new CategoryFilterValuesItemHolder((ItemFilterCategoryBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_filter_category));
    }

    public void onBindViewHolder(CategoryFilterValuesItemHolder categoryFilterValuesItemHolder, int i2) {
        categoryFilterValuesItemHolder.bind(this.mFilterValueList.get(i2), Integer.valueOf(i2));
    }

    public int getItemCount() {
        List<CJRFrontEndFilterItem> list = this.mFilterValueList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class CategoryFilterValuesItemHolder extends RecyclerView.v {
        private ItemFilterCategoryBinding mItemViewBinding;

        public CategoryFilterValuesItemHolder(ItemFilterCategoryBinding itemFilterCategoryBinding) {
            super(itemFilterCategoryBinding.getRoot());
            this.mItemViewBinding = itemFilterCategoryBinding;
        }

        public void bind(CJRFrontEndFilterItem cJRFrontEndFilterItem, Integer num) {
            this.mItemViewBinding.categoryName.setTextColor(this.mItemViewBinding.getRoot().getContext().getResources().getColor(cJRFrontEndFilterItem.getFontColor()));
            this.mItemViewBinding.selectedImage.setImageResource(cJRFrontEndFilterItem.getImageSrc());
            this.mItemViewBinding.setItem(cJRFrontEndFilterItem);
            this.mItemViewBinding.setPosition(num);
            this.mItemViewBinding.setHandler(this);
        }

        private boolean isParent(ArrayList<CJRFrontEndFilterItem> arrayList) {
            return arrayList != null && arrayList.size() > 0;
        }

        public void onFilterSelected(CJRFrontEndFilterItem cJRFrontEndFilterItem, boolean z) {
            String str;
            cJRFrontEndFilterItem.setSelected(!cJRFrontEndFilterItem.isSelected());
            if (isParent(cJRFrontEndFilterItem.getFrontEndFilterItemList())) {
                str = cJRFrontEndFilterItem.isSelected() ? cJRFrontEndFilterItem.getID() : cJRFrontEndFilterItem.getParentId();
            } else {
                str = cJRFrontEndFilterItem.getID();
                CategoryFilterValuesAdapter.this.setSelectedTextColor(cJRFrontEndFilterItem.isSelected(), this.mItemViewBinding);
            }
            if (CategoryFilterValuesAdapter.this.mOnFilterChildClickListener != null) {
                CategoryFilterValuesAdapter.this.mOnFilterChildClickListener.onCategoryFilterClick(str, isParent(cJRFrontEndFilterItem.getFrontEndFilterItemList()), cJRFrontEndFilterItem.isSelected(), cJRFrontEndFilterItem.getParentId());
            }
        }
    }

    /* access modifiers changed from: private */
    public void setSelectedTextColor(boolean z, ItemFilterCategoryBinding itemFilterCategoryBinding) {
        itemFilterCategoryBinding.categoryName.setTextColor(itemFilterCategoryBinding.getRoot().getResources().getColor(z ? R.color.clp_color_2222222 : R.color.filter_text_color));
    }
}
