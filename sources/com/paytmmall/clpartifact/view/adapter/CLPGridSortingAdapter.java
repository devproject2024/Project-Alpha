package com.paytmmall.clpartifact.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IGridResponseUpdateListener;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.modal.grid.CJRSortingKeys;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.view.FilterActivity;
import com.paytmmall.clpartifact.view.viewHolder.CLPSortingViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;

public class CLPGridSortingAdapter extends RecyclerView.a<CLPSortingViewHolder> {
    private CustomAction customAction;
    private Activity mActivity;
    private CJRGrid mGridResponse;
    private IGridResponseUpdateListener mGridResponseUpdateListener;
    private String mGridUrl;
    private String mIntialUrl;
    private ArrayList<CJRFilterItem> mItemList;
    private ArrayList<CJRSortingKeys> mSortingKeys;

    public CLPGridSortingAdapter(IGridResponseUpdateListener iGridResponseUpdateListener, FragmentActivity fragmentActivity, CJRGrid cJRGrid, String str, String str2, CustomAction customAction2) {
        this.mGridResponseUpdateListener = iGridResponseUpdateListener;
        this.mActivity = fragmentActivity;
        this.mGridResponse = cJRGrid;
        this.mGridUrl = str;
        this.mIntialUrl = str2;
        this.mItemList = cJRGrid.getFilterList();
        this.mSortingKeys = modifySelectedKey(cJRGrid.getSortingKeys());
        this.customAction = customAction2;
    }

    private ArrayList<CJRSortingKeys> modifySelectedKey(ArrayList<CJRSortingKeys> arrayList) {
        ArrayList<CJRSortingKeys> addPriceSortingItems = addPriceSortingItems(arrayList);
        boolean z = false;
        int i2 = -1;
        for (int i3 = 0; i3 < addPriceSortingItems.size(); i3++) {
            CJRSortingKeys cJRSortingKeys = addPriceSortingItems.get(i3);
            if (cJRSortingKeys.getName().equals("Popular")) {
                i2 = i3;
            }
            if (this.mGridUrl.contains(cJRSortingKeys.getDefault()) && !z) {
                cJRSortingKeys.setSelected(true);
                z = true;
            }
        }
        if (!z && i2 != -1) {
            addPriceSortingItems.get(i2).setSelected(true);
        }
        return addPriceSortingItems;
    }

    private ArrayList<CJRSortingKeys> addPriceSortingItems(ArrayList<CJRSortingKeys> arrayList) {
        if (arrayList == null) {
            return arrayList;
        }
        ArrayList<CJRSortingKeys> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            CJRSortingKeys cJRSortingKeys = arrayList.get(i2);
            if (cJRSortingKeys.getName().equals("Price")) {
                CJRSortingKeys cJRSortingKeys2 = new CJRSortingKeys();
                cJRSortingKeys2.setName(CLPConstants.LOW_TO_HIGH);
                cJRSortingKeys2.setDefault("sort_price=0");
                CJRSortingKeys cJRSortingKeys3 = new CJRSortingKeys();
                cJRSortingKeys3.setName(CLPConstants.HIGH_TO_LOW);
                cJRSortingKeys3.setDefault("sort_price=1");
                arrayList2.add(cJRSortingKeys2);
                arrayList2.add(cJRSortingKeys3);
            } else {
                arrayList2.add(cJRSortingKeys);
            }
        }
        return arrayList2;
    }

    public CLPSortingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new CLPSortingViewHolder(this.mGridResponseUpdateListener, f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.item_filter, viewGroup, false), this.customAction);
    }

    public void onBindViewHolder(CLPSortingViewHolder cLPSortingViewHolder, int i2) {
        fireInlineFilterGA(this.mItemList.get(i2));
        ArrayList<CJRFilterItem> arrayList = this.mItemList;
        if (arrayList != null) {
            cLPSortingViewHolder.bind(arrayList.get(i2), this.mSortingKeys, this.mGridResponse.getName());
        }
        cLPSortingViewHolder.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CLPGridSortingAdapter.this.lambda$onBindViewHolder$0$CLPGridSortingAdapter(this.f$1, view);
            }
        });
        setItemEndMargin(cLPSortingViewHolder.itemView, i2);
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$CLPGridSortingAdapter(int i2, View view) {
        openFilters(i2);
    }

    private void setItemEndMargin(View view, int i2) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        boolean z = true;
        int i3 = 0;
        if (i2 != getItemCount() - 1) {
            z = false;
        }
        if (z) {
            i3 = (int) view.getResources().getDimension(R.dimen.dimen_10dp);
        }
        layoutParams.rightMargin = i3;
    }

    private void openFilters(int i2) {
        Intent intent = new Intent(this.mActivity, FilterActivity.class);
        intent.putExtra(CLPConstants.INTENT_KEY_GRID_URL, this.mGridUrl);
        intent.putExtra(CLPConstants.INTENT_KEY_GRID_INTIAL_URL, this.mIntialUrl);
        intent.putExtra(CLPConstants.INTENT_KEY_GRID_DATA, this.mGridResponse);
        intent.putExtra(CLPConstants.ARGUMENT_KEY_POSITION, i2);
        IGridResponseUpdateListener iGridResponseUpdateListener = this.mGridResponseUpdateListener;
        if (iGridResponseUpdateListener instanceof Fragment) {
            ((Fragment) iGridResponseUpdateListener).startActivityForResult(intent, 122);
        }
    }

    public int getItemCount() {
        ArrayList<CJRFilterItem> arrayList = this.mItemList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void setItem(ArrayList<CJRFilterItem> arrayList) {
        this.mItemList = arrayList;
    }

    private void fireInlineFilterGA(CJRFilterItem cJRFilterItem) {
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        Activity activity = this.mActivity;
        communicationListener.sendCustomGTMEvents(activity, "clp", "inline_filters_loaded", cJRFilterItem.getType() + "(" + GAUtil.getGakey() + ")", (String) null, "grid screen", GAUtil.MARKET_PLACE);
    }
}
