package com.paytmmall.clpartifact.view.viewHolder;

import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.databinding.ItemRecoMainLytBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.AnimationUtil;
import com.paytmmall.clpartifact.utils.RecoReverseItemDecorator;
import com.paytmmall.clpartifact.view.adapter.CLPRecoListAdapter;
import com.paytmmall.clpartifact.view.adapter.HomeRecoItemAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CLPRecoListVH extends ClickableRVChildViewHolder {
    private int VIEW_THRESHOLD = 200;
    private CLPRecoListAdapter adapter;
    private ItemRecoMainLytBinding binding;
    private CustomAction customAction;
    private HomeRecoItemAdapter expandRvAdapter;
    private IGAHandlerListener listener;
    private View view;

    public CLPRecoListVH(ItemRecoMainLytBinding itemRecoMainLytBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(itemRecoMainLytBinding, iGAHandlerListener, customAction2);
        this.binding = itemRecoMainLytBinding;
        this.listener = iGAHandlerListener;
        this.customAction = customAction2;
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view2) {
        setGAData(view2.getGaData());
        this.binding.setVariable(BR.view, view2);
        this.binding.setVariable(BR.handler, this);
        this.binding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
        this.binding.setVariable(BR.isCollapsed, Boolean.TRUE);
        this.view = view2;
        List<Item> collapsedItemList = getCollapsedItemList(view2.getItem_images() != null ? view2.getItem_images() : new ArrayList());
        if (collapsedItemList.size() > 0) {
            setMargin(7);
            Collections.reverse(collapsedItemList);
            CLPRecoListAdapter cLPRecoListAdapter = this.adapter;
            if (cLPRecoListAdapter == null) {
                this.binding.recoRv.addItemDecoration(new RecoReverseItemDecorator(-50));
                this.adapter = new CLPRecoListAdapter(collapsedItemList, this.listener, view2, this.customAction);
                this.binding.setGroupAdapter(this.adapter);
            } else {
                cLPRecoListAdapter.setItem(collapsedItemList);
                this.adapter.notifyItemChanged(0, collapsedItemList);
                eraseOldStateofRv(view2);
            }
        } else {
            setMargin(0);
        }
        this.binding.executePendingBindings();
    }

    private void setMargin(int i2) {
        ((ViewGroup.MarginLayoutParams) this.binding.textLayout.getLayoutParams()).topMargin = a.a(i2);
        this.binding.textLayout.setGravity(16);
    }

    private void eraseOldStateofRv(View view2) {
        if (!view2.isViewExpanded() && this.binding.expandGroup.getVisibility() == 0) {
            this.binding.expandGroup.setVisibility(8);
            this.binding.recoRv.setVisibility(0);
        }
    }

    private List<Item> getCollapsedItemList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Item item = new Item();
                if (!TextUtils.isEmpty(list.get(i2))) {
                    item.setImageUrl(list.get(i2));
                    arrayList.add(item);
                    item.setGaAdded(true);
                }
            }
        }
        return arrayList;
    }

    public void handleClick() {
        RecyclerView recyclerView = this.binding.expandGroup;
        if (recyclerView == null || recyclerView.getVisibility() != 8) {
            collapseRv(recyclerView);
        } else {
            expandRecyclerview(recyclerView);
        }
    }

    private void expandRecyclerview(RecyclerView recyclerView) {
        this.view.setExpanded(true);
        AnimationUtil.expand(recyclerView);
        setExpandedRv(recyclerView);
        new Handler().postDelayed(new Runnable(recyclerView) {
            private final /* synthetic */ RecyclerView f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CLPRecoListVH.this.lambda$expandRecyclerview$0$CLPRecoListVH(this.f$1);
            }
        }, (long) this.VIEW_THRESHOLD);
    }

    public /* synthetic */ void lambda$expandRecyclerview$0$CLPRecoListVH(RecyclerView recyclerView) {
        if (this.binding.recoRv != null && this.binding.recoRv.getVisibility() == 0) {
            this.binding.recoRv.setVisibility(8);
            this.binding.setVariable(BR.isCollapsed, Boolean.FALSE);
            recyclerView.setVisibility(0);
        }
    }

    private void collapseRv(RecyclerView recyclerView) {
        this.view.setExpanded(false);
        this.binding.textLayout.setGravity(16);
        AnimationUtil.collapse(recyclerView);
        new Handler().postDelayed(new Runnable(recyclerView) {
            private final /* synthetic */ RecyclerView f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CLPRecoListVH.this.lambda$collapseRv$1$CLPRecoListVH(this.f$1);
            }
        }, 1);
    }

    public /* synthetic */ void lambda$collapseRv$1$CLPRecoListVH(RecyclerView recyclerView) {
        recyclerView.setVisibility(8);
        if (this.binding.recoRv != null && this.binding.recoRv.getVisibility() == 8) {
            this.binding.recoRv.setVisibility(0);
            this.binding.setVariable(BR.isCollapsed, Boolean.TRUE);
            CLPRecoListAdapter cLPRecoListAdapter = this.adapter;
            if (cLPRecoListAdapter != null) {
                cLPRecoListAdapter.notifyItemChanged(0, getCollapsedItemList(this.view.getItem_images() != null ? this.view.getItem_images() : new ArrayList()));
            }
        }
    }

    private void setExpandedRv(RecyclerView recyclerView) {
        recyclerView.setAdapter(new HomeRecoItemAdapter(this.view.mItems, this.view, this.listener, this.customAction));
        recyclerView.setLayoutManager(new GridLayoutManager(this.binding.getRoot().getContext(), 3));
    }
}
