package com.paytmmall.clpartifact.view.adapter;

import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.LytCategorySelectedBinding;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.view.actions.ICategoryClickListener;
import com.paytmmall.clpartifact.view.actions.ICategoryGaListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class SFCategoryAdapter extends RecyclerView.a<RecyclerView.v> {
    private ArrayList<String> categoryList = new ArrayList<>();
    private final ICategoryClickListener clickListener;
    private final ICategoryGaListener gaListener;
    private int selectedPosition;

    public SFCategoryAdapter(ICategoryClickListener iCategoryClickListener, ICategoryGaListener iCategoryGaListener) {
        k.c(iCategoryClickListener, "clickListener");
        k.c(iCategoryGaListener, "gaListener");
        this.clickListener = iCategoryClickListener;
        this.gaListener = iCategoryGaListener;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ViewDataBinding viewBinding = DataBindingUtils.getViewBinding(viewGroup, R.layout.lyt_category_selected);
        k.a((Object) viewBinding, "DataBindingUtils.getView…ut.lyt_category_selected)");
        return new SelectedCatergoryVH((LytCategorySelectedBinding) viewBinding, this.clickListener, this.gaListener);
    }

    public final int getItemCount() {
        return this.categoryList.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        SelectedCatergoryVH selectedCatergoryVH = (SelectedCatergoryVH) vVar;
        String str = this.categoryList.get(i2);
        k.a((Object) str, "categoryList[position]");
        selectedCatergoryVH.bindView(str, i2 == this.selectedPosition, i2);
    }

    public static final class SelectedCatergoryVH extends RecyclerView.v {
        private final LytCategorySelectedBinding binding;
        private final ICategoryClickListener clickListener;
        private final ICategoryGaListener gaListener;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectedCatergoryVH(LytCategorySelectedBinding lytCategorySelectedBinding, ICategoryClickListener iCategoryClickListener, ICategoryGaListener iCategoryGaListener) {
            super(lytCategorySelectedBinding.getRoot());
            k.c(lytCategorySelectedBinding, "binding");
            k.c(iCategoryClickListener, "clickListener");
            k.c(iCategoryGaListener, "gaListener");
            this.binding = lytCategorySelectedBinding;
            this.clickListener = iCategoryClickListener;
            this.gaListener = iCategoryGaListener;
        }

        public final void bindView(String str, boolean z, int i2) {
            k.c(str, "category");
            this.binding.setIsSelected(Boolean.valueOf(z));
            this.binding.setCategory(str);
            this.binding.setHandler(this.clickListener);
            this.binding.setPosition(Integer.valueOf(i2));
            this.binding.executePendingBindings();
            if (z) {
                TextView textView = this.binding.txvCategory;
                k.a((Object) textView, "binding.txvCategory");
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                return;
            }
            TextView textView2 = this.binding.txvCategory;
            k.a((Object) textView2, "binding.txvCategory");
            textView2.setTypeface(Typeface.DEFAULT);
        }
    }

    public final void updateList(List<String> list) {
        k.c(list, "list");
        this.categoryList.clear();
        this.categoryList.addAll(list);
        notifyDataSetChanged();
    }

    public final void updateSelectedPosition(int i2) {
        if (i2 != this.selectedPosition && i2 < this.categoryList.size()) {
            int i3 = this.selectedPosition;
            this.selectedPosition = i2;
            notifyItemChanged(i3);
            notifyItemChanged(i2);
        }
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }
}
