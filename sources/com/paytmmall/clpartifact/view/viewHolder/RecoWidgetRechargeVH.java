package com.paytmmall.clpartifact.view.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.localbroadcastmanager.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemReco4xRvBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.utils.DeeplLinkHandler;
import com.paytmmall.clpartifact.view.actions.RecoRvClick;
import com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class RecoWidgetRechargeVH extends CLPCarousel4X {
    private final ItemReco4xRvBinding binding;
    private final CustomAction customAction;

    public final boolean isStackViewNeeded() {
        return false;
    }

    public final ItemReco4xRvBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecoWidgetRechargeVH(ItemReco4xRvBinding itemReco4xRvBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(itemReco4xRvBinding, iGAHandlerListener, customAction2);
        k.c(itemReco4xRvBinding, "binding");
        k.c(iGAHandlerListener, "listener");
        this.binding = itemReco4xRvBinding;
        this.customAction = customAction2;
        CLPUtils.setHomeMargins(this.binding.mainLayout);
    }

    public final CustomAction getCustomAction() {
        return this.customAction;
    }

    /* access modifiers changed from: protected */
    public final void doBinding(View view) {
        k.c(view, "view");
        super.doBinding(view);
        AppCompatTextView appCompatTextView = this.binding.showMore;
        k.a((Object) appCompatTextView, "binding.showMore");
        HomeReco4XAdapter expandRvAdapter = getExpandRvAdapter();
        int i2 = 0;
        if ((expandRvAdapter != null ? expandRvAdapter.getActualCount() : 0) <= 2) {
            i2 = 8;
        }
        appCompatTextView.setVisibility(i2);
        AppCompatTextView appCompatTextView2 = this.binding.showMore;
        k.a((Object) appCompatTextView2, "binding.showMore");
        setMoreText(appCompatTextView2, view.isViewExpanded());
    }

    public final void handleMoreClick(android.view.View view) {
        k.c(view, "textView");
        View view2 = getView();
        boolean z = !(view2 != null ? view2.isViewExpanded() : false);
        View view3 = getView();
        if (view3 != null) {
            view3.setExpanded(z);
        }
        if (view instanceof TextView) {
            setMoreText((TextView) view, z);
        }
        HomeReco4XAdapter expandRvAdapter = getExpandRvAdapter();
        if (expandRvAdapter != null) {
            expandRvAdapter.setMaxValue(z ? Integer.MAX_VALUE : 2);
        }
        HomeReco4XAdapter expandRvAdapter2 = getExpandRvAdapter();
        if (expandRvAdapter2 != null) {
            expandRvAdapter2.notifyDataSetChanged();
        }
    }

    private final void setMoreText(TextView textView, boolean z) {
        Context context = textView.getContext();
        String string = context.getString(R.string.see_all);
        String string2 = context.getString(R.string.show_less);
        int c2 = b.c(z ? 13 : 20);
        if (z) {
            string = string2;
        }
        textView.setText(string);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a(context, z ? R.drawable.reco_show_less_up_arrow : R.drawable.reco_show_more_down_arrow), (Drawable) null);
        textView.setPadding(c2, textView.getPaddingTop(), c2, textView.getPaddingBottom());
    }

    public final RecoRvClick getRecoClickListner() {
        return new RecoWidgetRechargeVH$getRecoClickListner$1(this);
    }

    /* access modifiers changed from: private */
    public final void closeCountHandle(int i2) {
        if (i2 == 0) {
            RecyclerView recyclerView = this.binding.expandGroup4x;
            k.a((Object) recyclerView, "binding.expandGroup4x");
            recyclerView.setVisibility(8);
            ConstraintLayout constraintLayout = this.binding.mainLayout;
            k.a((Object) constraintLayout, "binding.mainLayout");
            constraintLayout.setVisibility(8);
        }
        HomeReco4XAdapter expandRvAdapter = getExpandRvAdapter();
        if ((expandRvAdapter != null ? expandRvAdapter.getActualCount() : 0) <= 2) {
            AppCompatTextView appCompatTextView = this.binding.showMore;
            k.a((Object) appCompatTextView, "binding.showMore");
            appCompatTextView.setVisibility(8);
        }
        CustomActionHelper customActionHelper = CustomActionHelper.INSTANCE;
        android.view.View root = this.binding.getRoot();
        Activity hostActivity = customActionHelper.getHostActivity(root != null ? root.getContext() : null, getCustomAction());
        if (hostActivity != null) {
            a a2 = a.a((Context) hostActivity);
            k.a((Object) a2, "LocalBroadcastManager.getInstance(it)");
            a2.a(new Intent(CLPConstants.RECO_LOCALBROADCAST));
        }
    }

    /* access modifiers changed from: private */
    public final void onItemClosed(int i2) {
        List<Item> list;
        List<Item> items;
        View view = getView();
        if (!(view == null || (items = view.getItems()) == null)) {
            items.remove(i2);
        }
        HomeReco4XAdapter expandRvAdapter = getExpandRvAdapter();
        if (expandRvAdapter != null) {
            View view2 = getView();
            if (view2 == null || (list = view2.getItems()) == null) {
                list = new ArrayList<>();
            }
            expandRvAdapter.setItem(getFilteredList(list));
        }
        HomeReco4XAdapter expandRvAdapter2 = getExpandRvAdapter();
        if (expandRvAdapter2 != null) {
            expandRvAdapter2.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void onRecoItemClick(android.view.View view, int i2) {
        List<Item> items;
        Item item;
        Activity hostActivity;
        View view2 = getView();
        if (view2 != null && (items = view2.getItems()) != null && (item = (Item) kotlin.a.k.a(items, i2)) != null && (hostActivity = CustomActionHelper.INSTANCE.getHostActivity(view.getContext(), getCustomAction())) != null) {
            DeeplLinkHandler.Companion.handleDeepLink(hostActivity, item);
        }
    }
}
