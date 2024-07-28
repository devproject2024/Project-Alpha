package com.paytmmall.clpartifact.view.viewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.IGridResponseUpdateListener;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.modal.grid.CJRFilterValue;
import com.paytmmall.clpartifact.modal.grid.CJRSortingKeys;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.view.fragment.CLPSortFilterFragment;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.Iterator;

public class CLPSortingViewHolder extends ClickableRVChildViewHolder {
    private IGridResponseUpdateListener mGridResponseUpdateListener;
    private View.OnClickListener mOnItemClickListener;
    private ArrayList<CJRSortingKeys> mSortingKeys;
    private ViewDataBinding mViewDataBinding;

    public CLPSortingViewHolder(IGridResponseUpdateListener iGridResponseUpdateListener, ViewDataBinding viewDataBinding, CustomAction customAction) {
        super(viewDataBinding, (IGAHandlerListener) null, customAction);
        this.mGridResponseUpdateListener = iGridResponseUpdateListener;
        this.mViewDataBinding = viewDataBinding;
    }

    public void bind(CJRFilterItem cJRFilterItem, ArrayList<CJRSortingKeys> arrayList, String str) {
        this.mSortingKeys = arrayList;
        TextView textView = (TextView) this.mViewDataBinding.getRoot().findViewById(R.id.filterTxtValue2);
        if (!(textView == null || cJRFilterItem == null)) {
            if (cJRFilterItem.getTitle().contains("Sort")) {
                textView.setText(getSelectedSortingKey(arrayList));
            }
            if (cJRFilterItem.getTitle().equals("Category")) {
                textView.setText(cJRFilterItem.getDisplayValue());
            }
            if (cJRFilterItem.getFilterValues() != null && cJRFilterItem.getTitle().equals("Price") && cJRFilterItem.getFilterAppliedRange().getAbsoluteMin() > 0) {
                textView.setText(cJRFilterItem.getFilterAppliedRange().getAbsoluteMin() + "-" + cJRFilterItem.getFilterAppliedRange().getAbsoluteMax());
            }
            if (!TextUtils.isEmpty(str) && cJRFilterItem.getType() != null && cJRFilterItem.getType().equals(CLPConstants.FILTER_RANGE_SLIDER) && str.equalsIgnoreCase("Under Rs.99 | Budget Store")) {
                textView.setText(R.string.price_under99);
            }
            ArrayList<CJRFilterValue> filterApplied = cJRFilterItem.getFilterApplied();
            if (filterApplied != null && !filterApplied.isEmpty()) {
                if (filterApplied.size() == 1) {
                    textView.setText(filterApplied.get(0).getName());
                } else {
                    textView.setText("(" + filterApplied.size() + ")");
                }
            }
        }
        enableItemClick();
        this.mViewDataBinding.setVariable(BR.item, cJRFilterItem);
        this.mViewDataBinding.setVariable(BR.handler, this);
        this.mViewDataBinding.executePendingBindings();
    }

    private String getSelectedSortingKey(ArrayList<CJRSortingKeys> arrayList) {
        Iterator<CJRSortingKeys> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRSortingKeys next = it2.next();
            if (next.isSelected()) {
                return next.getName();
            }
        }
        return "Popular";
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnItemClickListener = onClickListener;
    }

    public void handleFilterClick(CJRFilterItem cJRFilterItem) {
        fireInlineFilterGA(cJRFilterItem);
        if (cJRFilterItem.getTitle().contains("Sort")) {
            GaHandler.getInstance().fireSortMenuClickEvent();
            CLPSortFilterFragment cLPSortFilterFragment = new CLPSortFilterFragment();
            cLPSortFilterFragment.setArguments(CLPSortFilterFragment.getDataBundle(this.mSortingKeys));
            cLPSortFilterFragment.setItemClickListener(this.mGridResponseUpdateListener);
            if (this.mSortingKeys != null) {
                cLPSortFilterFragment.show(((FragmentActivity) this.mViewDataBinding.getRoot().getContext()).getSupportFragmentManager(), cLPSortFilterFragment.getTag());
                return;
            }
            return;
        }
        View.OnClickListener onClickListener = this.mOnItemClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this.mViewDataBinding.getRoot());
        }
    }

    private void fireInlineFilterGA(CJRFilterItem cJRFilterItem) {
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        Context context = this.mViewDataBinding.getRoot().getContext();
        communicationListener.sendCustomGTMEvents(context, "clp", "inline filters selected", cJRFilterItem.getType() + "(" + GAUtil.getGakey() + ")", (String) null, "grid screen", GAUtil.MARKET_PLACE);
    }
}
