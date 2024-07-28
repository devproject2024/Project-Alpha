package com.paytmmall.clpartifact.view.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.databinding.NewGroupGridRvBinding;
import com.paytmmall.clpartifact.listeners.IClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.utils.ValidateViewResponse;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.adapter.SmartGroupGridAdapter;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;
import java.util.ArrayList;
import java.util.List;

public class NewSmartGroupVh extends ClickableRVChildViewHolder implements IClickListener {
    private static final int DEFAULT_MULTIPLIER = 3;
    private SmartGroupGridAdapter adapter;
    private NewGroupGridRvBinding binding;
    private CustomAction customAction;
    private IGAHandlerListener listener;
    private View mView;
    private LongSparseArray<Boolean> map = new LongSparseArray<>();

    public NewSmartGroupVh(NewGroupGridRvBinding newGroupGridRvBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(newGroupGridRvBinding, iGAHandlerListener, customAction2);
        this.binding = newGroupGridRvBinding;
        this.listener = iGAHandlerListener;
        this.customAction = customAction2;
        if (CLPUtils.isHomeClient(iGAHandlerListener)) {
            CLPUtils.setHomeMargins(newGroupGridRvBinding.llParent);
        }
    }

    public void doBinding(View view) {
        this.mView = view;
        setGAData(view.getGaData());
        enableItemClick();
        if (shoudlShowMore(view)) {
            this.adapter = new SmartGroupGridAdapter(getList(view), view, this.listener, this, this.customAction);
        } else if (isStateExpanded(view)) {
            this.adapter = new SmartGroupGridAdapter(getExpandedList(this.binding.getRoot().getContext(), view), view, this.listener, this, this.customAction);
        } else {
            this.adapter = new SmartGroupGridAdapter(getCollapsedList(view), view, this.listener, this, this.customAction);
        }
        setLayoutManager();
        this.binding.setVariable(BR.view, view);
        this.binding.setGroupAdapter(this.adapter);
        this.binding.executePendingBindings();
    }

    private List<Item> getList(View view) {
        if (view.getItems() == null || view.getItems().size() == 0) {
            this.binding.getRoot().setVisibility(8);
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        int size = view.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(view.mItems.get(i2));
        }
        if (size % 3 != 0 && shoudlShowMore(view)) {
            this.binding.showMore.setVisibility(8);
            Item moreItem = ValidateViewResponse.getMoreItem(this.binding.getRoot().getContext(), view);
            moreItem.setMore(true);
            arrayList.add(size, moreItem);
        } else if (shoudlShowMore(view)) {
            this.binding.showMore.setVisibility(0);
        }
        return arrayList;
    }

    private boolean shoudlShowMore(View view) {
        return !TextUtils.isEmpty(view.getSubtitle()) || !TextUtils.isEmpty(view.getSeourl());
    }

    private void setLayoutManager() {
        RecyclerView recyclerView = this.binding.expandGroup;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(this.binding.getRoot().getContext(), 3));
            recyclerView.setNestedScrollingEnabled(false);
        }
    }

    public void handleMoreDeeplink() {
        Item item = new Item();
        String str = "";
        String subtitle = !TextUtils.isEmpty(this.mView.getSubtitle()) ? this.mView.getSubtitle() : str;
        if (!TextUtils.isEmpty(this.mView.getSeourl())) {
            subtitle = this.mView.getSeourl();
        }
        item.setUrl(subtitle);
        item.setUrlType(CLPConstants.URL_TYPE_EMBED);
        item.setId(this.mView.getId() + this.mView.getShow_more_label());
        item.setParentType(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID);
        item.setMore(true);
        item.setAddedtoGA(Boolean.TRUE);
        if (!TextUtils.isEmpty(this.mView.getShow_more_label())) {
            str = this.mView.getShow_more_label();
        }
        item.setName(str);
        CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(CustomActionHelper.INSTANCE.getHostActivity(this.binding.getRoot().getContext(), this.customAction), item);
        fireMoreButtonGa(item);
    }

    private void fireMoreButtonGa(Item item) {
        IGAHandlerListener iGAHandlerListener = this.listener;
        if (iGAHandlerListener != null) {
            iGAHandlerListener.OnItemClick(item, 0, true);
        } else {
            CLPArtifact.getInstance().getCommunicationListener().sendCustomGTMEvents(this.binding.getRoot().getContext(), this.binding.getRoot().getContext().getString(R.string.show_more), !TextUtils.isEmpty(item.getName()) ? item.getName() : "_clicked", (String) null, (String) null, "/", this.binding.getRoot().getContext().getString(R.string.verticalId));
        }
    }

    private List<Item> getCollapsedList(View view) {
        int i2;
        int i3;
        if (view.getItems() == null || view.getItems().size() == 0) {
            this.binding.getRoot().setVisibility(8);
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        int max_items_shown = view.getMax_items_shown();
        boolean z = true;
        if (max_items_shown == 0 || (i3 = max_items_shown * 3) >= view.mItems.size()) {
            i2 = view.mItems.size();
            z = false;
        } else {
            i2 = i3 - 1;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            arrayList.add(view.mItems.get(i4));
        }
        if (z) {
            arrayList.add(ValidateViewResponse.getMoreItem(this.binding.getRoot().getContext(), view));
        }
        return arrayList;
    }

    private List<Item> getExpandedList(Context context, View view) {
        String str = "";
        String show_less_label = !TextUtils.isEmpty(view.getShow_less_label()) ? view.getShow_less_label() : str;
        if (!TextUtils.isEmpty(view.getShow_less_image_url())) {
            str = view.getShow_less_image_url();
        }
        ArrayList arrayList = new ArrayList(view.getItems());
        arrayList.add(ValidateViewResponse.getShowLessItem(context, show_less_label, str, view.getId()));
        return arrayList;
    }

    private boolean isStateExpanded(View view) {
        if (view == null || view.getId() == null || this.map.get(view.getId().longValue()) == null) {
            return false;
        }
        return this.map.get(view.getId().longValue()).booleanValue();
    }

    public void onMoreItemCliked(Integer num, View view) {
        String seourl = !TextUtils.isEmpty(view.getSeourl()) ? view.getSeourl() : view.getSubtitle();
        if (!TextUtils.isEmpty(seourl)) {
            handleDeepLink(constructItem(seourl), num.intValue());
            return;
        }
        this.adapter.setItems(getExpandedList(this.binding.getRoot().getContext(), view));
        if (view.getId() != null) {
            this.map.put((long) view.getId().intValue(), Boolean.TRUE);
        }
    }

    private Item constructItem(String str) {
        Item item = new Item();
        item.setUrlType(CLPConstants.URL_TYPE_EMBED);
        item.setUrl(str);
        return item;
    }

    public void onLessItemCliked(Integer num, View view) {
        this.adapter.setItems(getCollapsedList(view));
        if (view.getId() != null) {
            this.map.put((long) view.getId().intValue(), Boolean.FALSE);
        }
    }
}
