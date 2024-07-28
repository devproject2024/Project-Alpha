package com.paytmmall.clpartifact.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ClpVoucherItemBinding;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.actions.ILoadMoreListener;
import com.paytmmall.clpartifact.view.viewHolder.CLPVoucherRVViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.ProgressViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;

public class CLPVoucherAdapter extends RecyclerView.a<RecyclerView.v> {
    public static final int STATIC_2XN_SIZE = 10;
    private CustomAction customAction;
    private boolean isCollapsed;
    private boolean isLoadingMore = false;
    private ILoadMoreListener loadMoreListener;
    private ArrayList<CJRGridProduct> mVouchers;

    public CLPVoucherAdapter(ArrayList<CJRGridProduct> arrayList, CustomAction customAction2) {
        this.mVouchers = arrayList;
        this.customAction = customAction2;
    }

    public int getItemViewType(int i2) {
        return i2 == this.mVouchers.size() ? CLPConstants.ITEM_TYPE_LOADER : CLPConstants.ITEM_TYPE_VOUCHER;
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 372) {
            return new ProgressViewHolder(f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.clp_item_progressbar, viewGroup, false));
        }
        CLPVoucherRVViewHolder cLPVoucherRVViewHolder = new CLPVoucherRVViewHolder((ClpVoucherItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.clp_voucher_item, viewGroup, false), this.customAction);
        cLPVoucherRVViewHolder.setAdapter(this.loadMoreListener);
        return cLPVoucherRVViewHolder;
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof CLPVoucherRVViewHolder) {
            CLPVoucherRVViewHolder cLPVoucherRVViewHolder = (CLPVoucherRVViewHolder) vVar;
            CJRGridProduct cJRGridProduct = this.mVouchers.get(i2);
            boolean z = true;
            if (!this.isCollapsed || i2 != getItemCount() - 1) {
                z = false;
            }
            cLPVoucherRVViewHolder.bind(cJRGridProduct, z);
        }
    }

    public int getItemCount() {
        int size = this.mVouchers.size();
        if (!this.isCollapsed || size <= 10) {
            return size + (this.isLoadingMore ? 1 : 0);
        }
        return 10;
    }

    public void addLoader() {
        if (!this.isLoadingMore) {
            this.isLoadingMore = true;
            notifyItemInserted(this.mVouchers.size());
        }
    }

    public void removeLoader() {
        if (this.isLoadingMore) {
            this.isLoadingMore = false;
            notifyItemRemoved(this.mVouchers.size());
        }
    }

    public void updateVoucherList(Resource<ArrayList<CJRGridProduct>> resource) {
        if (resource != null && resource.getData() != null) {
            removeLoader();
            ArrayList data = resource.getData();
            if (resource.getRequestType() == RequestType.REFRESH || resource.getRequestType() == RequestType.FRESH) {
                this.mVouchers.clear();
                this.mVouchers.addAll(data);
                notifyDataSetChanged();
                return;
            }
            int size = this.mVouchers.size();
            this.mVouchers.addAll(data);
            notifyItemRangeInserted(size, data.size());
        }
    }

    public void updateState(Boolean bool) {
        this.isCollapsed = bool.booleanValue();
        notifyItemRangeChanged(8, getItemCount());
    }

    public void setOnLoadMoreListener(ILoadMoreListener iLoadMoreListener) {
        this.loadMoreListener = iLoadMoreListener;
    }
}
