package com.paytmmall.clpartifact.view.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.core.content.b;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.databinding.SmartGroupGrid4xnRvBinding;
import com.paytmmall.clpartifact.listeners.IClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.SFSColorUtils;
import com.paytmmall.clpartifact.utils.ValidateViewResponse;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.adapter.SmartGroupGridAdapter;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.HorizontalDividerItemDecorator;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;
import java.util.ArrayList;
import java.util.List;

public class SmartGroupGrid4XNVH extends ClickableRVChildViewHolder implements IClickListener {
    private static final int DEFAULT_MULTIPLIER = 4;
    public static int ROW_COUNT = 4;
    private SmartGroupGridAdapter adapter;
    private SmartGroupGrid4xnRvBinding binding;
    private CustomAction customAction;
    private IGAHandlerListener listener;
    private View mView;
    private LongSparseArray<Boolean> map = new LongSparseArray<>();

    public SmartGroupGrid4XNVH(SmartGroupGrid4xnRvBinding smartGroupGrid4xnRvBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(smartGroupGrid4xnRvBinding, iGAHandlerListener, customAction2);
        this.binding = smartGroupGrid4xnRvBinding;
        this.listener = iGAHandlerListener;
        this.customAction = customAction2;
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
        setBackgroundColor(view);
        addDecoration(this.binding.expandGroup, view.isGreyLineSeperator());
        this.binding.setVariable(BR.view, view);
        this.binding.setGroupAdapter(this.adapter);
        this.binding.executePendingBindings();
    }

    private void addDecoration(RecyclerView recyclerView, boolean z) {
        if (recyclerView.getItemDecorationCount() == 0 && z) {
            recyclerView.addItemDecoration(new HorizontalDividerItemDecorator(b.a(recyclerView.getContext(), R.drawable.rv_divider), 4));
        } else if (!z && recyclerView.getItemDecorationCount() > 0) {
            recyclerView.removeItemDecorationAt(0);
        }
    }

    private boolean isStateExpanded(View view) {
        if (view == null || view.getId() == null || this.map.get(view.getId().longValue()) == null) {
            return false;
        }
        return this.map.get(view.getId().longValue()).booleanValue();
    }

    private void setBackgroundColor(View view) {
        this.binding.llParent.setBackgroundColor(SFSColorUtils.getParsedColor((view.getmMetaLayout() == null || TextUtils.isEmpty(view.getmMetaLayout().getBgColor())) ? "#00000000" : view.getmMetaLayout().getBgColor(), this.binding.getRoot().getContext()));
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
        if (size % 4 != 0 && shoudlShowMore(view)) {
            this.binding.showMore.setVisibility(8);
            Item moreItem = ValidateViewResponse.getMoreItem(this.binding.getRoot().getContext(), view);
            moreItem.setMore(true);
            arrayList.add(size, moreItem);
        } else if (shoudlShowMore(view)) {
            this.binding.showMore.setVisibility(0);
        } else {
            this.binding.showMore.setVisibility(8);
        }
        return arrayList;
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
        if (max_items_shown == 0 || (i3 = max_items_shown * 4) >= view.mItems.size()) {
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

    private void setLayoutManager() {
        RecyclerView recyclerView = this.binding.expandGroup;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(this.binding.getRoot().getContext(), ROW_COUNT));
            recyclerView.setNestedScrollingEnabled(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean shoudlShowMore(View view) {
        return !TextUtils.isEmpty(view.getSubtitle()) || !TextUtils.isEmpty(view.getSeourl());
    }

    public void handleAllClick() {
        Item item = new Item();
        String str = "";
        String subtitle = !TextUtils.isEmpty(this.mView.getSubtitle()) ? this.mView.getSubtitle() : str;
        if (!TextUtils.isEmpty(this.mView.getSeourl())) {
            subtitle = this.mView.getSeourl();
        }
        item.setUrl(subtitle);
        item.setUrlType(CLPConstants.URL_TYPE_EMBED);
        item.setId(this.mView.getId() + this.mView.getShow_more_label());
        item.setParentType(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID_4XN);
        if (!TextUtils.isEmpty(this.mView.getShow_more_label())) {
            str = this.mView.getShow_more_label();
        }
        item.setName(str);
        item.setMore(true);
        item.setAddedtoGA(Boolean.TRUE);
        CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(CustomActionHelper.INSTANCE.getHostActivity(this.binding.getRoot().getContext(), this.customAction), item);
        fireMoreButtonGa(item);
    }

    private void fireMoreButtonGa(Item item) {
        IGAHandlerListener iGAHandlerListener = this.listener;
        if (iGAHandlerListener != null) {
            iGAHandlerListener.OnItemClick(item, 0, true);
        } else {
            CLPArtifact.getInstance().getCommunicationListener().sendCustomGTMEvents(this.binding.getRoot().getContext(), this.binding.getRoot().getContext().getString(R.string.menu_widget), !TextUtils.isEmpty(item.getName()) ? item.getName() : "_clicked", (String) null, (String) null, "/", this.binding.getRoot().getContext().getString(R.string.verticalId));
        }
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
