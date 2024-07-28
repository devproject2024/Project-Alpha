package com.paytmmall.clpartifact.view.viewHolder;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.paytmmall.clpartifact.databinding.ItemFullWidthRootRvSmallTiBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.view.adapter.CLPHybridRVAdapter;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CLPCTAListViewHolder extends CLPItemVHWithRV {
    public static final Companion Companion = new Companion((g) null);
    public static final int TI_ITEM = 0;
    private final CustomAction customAction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CLPCTAListViewHolder(ItemFullWidthRootRvSmallTiBinding itemFullWidthRootRvSmallTiBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(itemFullWidthRootRvSmallTiBinding, iGAHandlerListener, customAction2);
        k.c(itemFullWidthRootRvSmallTiBinding, "thinBannerBinding");
        this.customAction = customAction2;
        if (CLPUtils.isHomeClient(iGAHandlerListener) || CLPUtils.isFlyoutClient(iGAHandlerListener)) {
            LinearLayout linearLayout = itemFullWidthRootRvSmallTiBinding.llParent;
            k.a((Object) linearLayout, "thinBannerBinding.llParent");
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.bottomMargin = 0;
            }
        } else if (CLPUtils.isRechargeClient(iGAHandlerListener) || CLPUtils.isShowMoreClient(iGAHandlerListener)) {
            LinearLayout linearLayout2 = itemFullWidthRootRvSmallTiBinding.llParent;
            k.a((Object) linearLayout2, "thinBannerBinding.llParent");
            ViewGroup.LayoutParams layoutParams2 = linearLayout2.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
            }
        }
    }

    public final CustomAction getCustomAction() {
        return this.customAction;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final CLPItemRVAdapter getAdapter(View view) {
        k.c(view, "view");
        Long id = view.getId();
        k.a((Object) id, "view.id");
        return new CLPHybridRVAdapter(view, view.getItems(), getIgaHandlerListener(), new CLPCTAListViewHolder$getAdapter$1(view), id.longValue(), this.customAction);
    }
}
