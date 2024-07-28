package com.paytmmall.clpartifact.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.viewmodel.RatingVHViewModel;
import java.util.HashMap;

public class RatingChartAdapter extends RecyclerView.a<ChartViewHolder> {
    /* access modifiers changed from: private */
    public HashMap<Integer, Integer> chartMap;
    /* access modifiers changed from: private */
    public int size;
    /* access modifiers changed from: private */
    public int totalRatings;
    /* access modifiers changed from: private */
    public RatingVHViewModel viewModel;

    public RatingChartAdapter(HashMap<Integer, Integer> hashMap, int i2, RatingVHViewModel ratingVHViewModel) {
        this.chartMap = hashMap;
        this.size = hashMap != null ? hashMap.size() : 0;
        this.totalRatings = i2;
        this.viewModel = ratingVHViewModel;
    }

    public ChartViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ChartViewHolder(f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.clp_item_chart, viewGroup, false));
    }

    public void onBindViewHolder(ChartViewHolder chartViewHolder, int i2) {
        chartViewHolder.bind(i2);
    }

    public int getItemCount() {
        return this.size;
    }

    class ChartViewHolder extends RecyclerView.v {
        private ViewDataBinding viewBinding;

        ChartViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewBinding = viewDataBinding;
        }

        public void bind(int i2) {
            int access$000 = RatingChartAdapter.this.size - i2;
            RatingChartAdapter ratingChartAdapter = RatingChartAdapter.this;
            this.viewBinding.setVariable(BR.ratingData, Integer.valueOf((ratingChartAdapter.getProgressNumerator(ratingChartAdapter.chartMap, Integer.valueOf(access$000)).intValue() * 100) / RatingChartAdapter.this.totalRatings));
            this.viewBinding.setVariable(BR.viewModel, RatingChartAdapter.this.viewModel);
            ViewDataBinding viewDataBinding = this.viewBinding;
            int i3 = BR.ratingTotal;
            RatingChartAdapter ratingChartAdapter2 = RatingChartAdapter.this;
            viewDataBinding.setVariable(i3, String.valueOf(ratingChartAdapter2.getProgressNumerator(ratingChartAdapter2.chartMap, Integer.valueOf(access$000))));
            this.viewBinding.setVariable(BR.starNumber, String.valueOf(access$000));
            this.viewBinding.executePendingBindings();
        }
    }

    /* access modifiers changed from: private */
    public Integer getProgressNumerator(HashMap<Integer, Integer> hashMap, Integer num) {
        if (hashMap == null || num == null || !hashMap.containsKey(num)) {
            return 0;
        }
        return hashMap.get(num);
    }
}
