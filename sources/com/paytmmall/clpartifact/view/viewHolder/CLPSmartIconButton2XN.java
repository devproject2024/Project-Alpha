package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemSmartIconButton2xnRootBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CLPSmartIconButton2XN extends CLPItemVHWithRV {
    public static final Companion Companion = new Companion((g) null);
    private static final int DEFAULT_SPAN_SIZE = 2;
    private final CustomAction customAction;
    private int spanCount;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CLPSmartIconButton2XN(ItemSmartIconButton2xnRootBinding itemSmartIconButton2xnRootBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(itemSmartIconButton2xnRootBinding, iGAHandlerListener, customAction2);
        k.c(itemSmartIconButton2xnRootBinding, "itemSmartIconButton2xnRootBinding");
        this.customAction = customAction2;
    }

    public final CustomAction getCustomAction() {
        return this.customAction;
    }

    /* access modifiers changed from: protected */
    public final void doBinding(View view) {
        k.c(view, "view");
        this.spanCount = getSpanCount(view);
        super.doBinding(view);
    }

    private final int getSpanCount(View view) {
        List<Item> items;
        if (!(view == null || view.getItems().size() % 2 == 0 || view.getItems().size() == 1 || (items = view.getItems()) == null)) {
            items.remove(view.getItems().size() - 1);
        }
        return (view == null || view.getItems().size() != 1) ? 2 : 1;
    }

    /* access modifiers changed from: protected */
    public final RecyclerView.LayoutManager getLayoutManager(String str) {
        k.c(str, "type");
        ViewDataBinding viewDataBinding = this.mViewDataBinding;
        k.a((Object) viewDataBinding, "mViewDataBinding");
        android.view.View root = viewDataBinding.getRoot();
        k.a((Object) root, "mViewDataBinding.root");
        return new GridLayoutManager(root.getContext(), this.spanCount);
    }

    /* access modifiers changed from: protected */
    public final void addItemDecoration(RecyclerView recyclerView) {
        k.c(recyclerView, "recyclerView");
        if (recyclerView.getItemDecorationCount() == 0) {
            Drawable a2 = b.a(recyclerView.getContext(), R.drawable.rv_divider);
            if (a2 == null) {
                k.a();
            }
            k.a((Object) a2, "ContextCompat.getDrawabl… R.drawable.rv_divider)!!");
            VerticalDividerItemDecorator verticalDividerItemDecorator = new VerticalDividerItemDecorator(a2);
            Drawable a3 = b.a(recyclerView.getContext(), R.drawable.rv_divider);
            if (a3 == null) {
                k.a();
            }
            k.a((Object) a3, "ContextCompat.getDrawabl… R.drawable.rv_divider)!!");
            HorizontalDividerItemDecorator horizontalDividerItemDecorator = new HorizontalDividerItemDecorator(a3, 2);
            recyclerView.addItemDecoration(verticalDividerItemDecorator);
            recyclerView.addItemDecoration(horizontalDividerItemDecorator);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
}
