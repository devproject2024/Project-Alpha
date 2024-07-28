package com.paytmmall.clpartifact.view.viewHolder;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.databinding.ItemReco4xRvBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ValidateViewResponse;
import com.paytmmall.clpartifact.view.actions.RecoRvClick;
import com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.k;

public class CLPCarousel4X extends ClickableRVChildViewHolder {
    private final ItemReco4xRvBinding binding;
    private final CustomAction customAction;
    private HomeReco4XAdapter expandRvAdapter;
    private final IGAHandlerListener listener;
    private View view;

    public void handleMoreClick(android.view.View view2) {
        k.c(view2, "textView");
    }

    public boolean isStackViewNeeded() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CLPCarousel4X(ItemReco4xRvBinding itemReco4xRvBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(itemReco4xRvBinding, iGAHandlerListener, customAction2);
        k.c(itemReco4xRvBinding, "binding");
        k.c(iGAHandlerListener, "listener");
        this.binding = itemReco4xRvBinding;
        this.listener = iGAHandlerListener;
        this.customAction = customAction2;
    }

    public CustomAction getCustomAction() {
        return this.customAction;
    }

    public final HomeReco4XAdapter getExpandRvAdapter() {
        return this.expandRvAdapter;
    }

    public final void setExpandRvAdapter(HomeReco4XAdapter homeReco4XAdapter) {
        this.expandRvAdapter = homeReco4XAdapter;
    }

    /* access modifiers changed from: protected */
    public final View getView() {
        return this.view;
    }

    /* access modifiers changed from: protected */
    public final void setView(View view2) {
        this.view = view2;
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view2) {
        k.c(view2, "view");
        setGAData(view2.getGaData());
        this.binding.setVariable(BR.view, view2);
        this.binding.setVariable(BR.handler, this);
        this.binding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
        this.binding.setVariable(BR.isCollapsed, Boolean.valueOf(!view2.isViewExpanded()));
        this.view = view2;
        this.binding.executePendingBindings();
        if (view2.getItems() == null || view2.getItems().size() <= 0 || view2.isSmartHeaderV2()) {
            ConstraintLayout constraintLayout = this.binding.mainLayout;
            k.a((Object) constraintLayout, "binding.mainLayout");
            constraintLayout.setVisibility(8);
        } else {
            ConstraintLayout constraintLayout2 = this.binding.mainLayout;
            k.a((Object) constraintLayout2, "binding.mainLayout");
            constraintLayout2.setVisibility(0);
            RecyclerView recyclerView = this.binding.expandGroup4x;
            k.a((Object) recyclerView, "binding.expandGroup4x");
            setExpandedRv(recyclerView);
        }
        if (isStackViewNeeded()) {
            AppCompatTextView appCompatTextView = this.binding.showMore;
            k.a((Object) appCompatTextView, "binding.showMore");
            appCompatTextView.setVisibility(8);
            return;
        }
        AppCompatTextView appCompatTextView2 = this.binding.showMore;
        k.a((Object) appCompatTextView2, "binding.showMore");
        appCompatTextView2.setVisibility(0);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001a: MOVE  (r2v5 java.util.Collection) = 
          (r3v0 java.util.List<com.paytmmall.clpartifact.modal.clpCommon.Item>)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    private final void setExpandedRv(androidx.recyclerview.widget.RecyclerView r12) {
        /*
            r11 = this;
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r11.view
            if (r0 != 0) goto L_0x0007
            kotlin.g.b.k.a()
        L_0x0007:
            java.util.List r0 = r0.getItems()
            java.lang.String r1 = "view!!.items"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.util.List r3 = r11.getFilteredList(r0)
            r0 = 0
            r1 = 1
            if (r3 == 0) goto L_0x0026
            r2 = r3
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x0026
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            if (r1 == 0) goto L_0x006a
            boolean r1 = r11 instanceof com.paytmmall.clpartifact.view.viewHolder.RecoWidgetRechargeVH
            if (r1 == 0) goto L_0x006a
            r12 = r11
            com.paytmmall.clpartifact.view.viewHolder.RecoWidgetRechargeVH r12 = (com.paytmmall.clpartifact.view.viewHolder.RecoWidgetRechargeVH) r12
            com.paytmmall.clpartifact.databinding.ItemReco4xRvBinding r1 = r12.getBinding()
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.mainLayout
            java.lang.String r2 = "binding.mainLayout"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r2 = 8
            r1.setVisibility(r2)
            com.paytmmall.clpartifact.databinding.ItemReco4xRvBinding r1 = r12.getBinding()
            androidx.recyclerview.widget.RecyclerView r1 = r1.expandGroup4x
            java.lang.String r3 = "binding.expandGroup4x"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r1.setVisibility(r2)
            com.paytmmall.clpartifact.databinding.ItemReco4xRvBinding r12 = r12.getBinding()
            androidx.constraintlayout.widget.ConstraintLayout r12 = r12.mainLayout
            android.view.ViewGroup$LayoutParams r12 = r12.getLayoutParams()
            if (r12 == 0) goto L_0x0062
            android.view.ViewGroup$MarginLayoutParams r12 = (android.view.ViewGroup.MarginLayoutParams) r12
            int r0 = com.paytm.utility.a.a((int) r0)
            r12.bottomMargin = r0
            return
        L_0x0062:
            kotlin.u r12 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
            r12.<init>(r0)
            throw r12
        L_0x006a:
            com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter r0 = r11.expandRvAdapter
            if (r0 != 0) goto L_0x00c4
            com.paytmmall.clpartifact.view.actions.RecoRvClick r7 = r11.getRecoClickListner()
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            com.paytmmall.clpartifact.databinding.ItemReco4xRvBinding r1 = r11.binding
            android.view.View r1 = r1.getRoot()
            java.lang.String r2 = "binding.root"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.content.Context r1 = r1.getContext()
            r0.<init>(r1)
            com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter r1 = new com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter
            com.paytmmall.clpartifact.modal.clpCommon.View r4 = r11.view
            com.paytmmall.clpartifact.listeners.IGAHandlerListener r5 = r11.listener
            com.paytmmall.clpartifact.widgets.callback.CustomAction r6 = r11.getCustomAction()
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
            boolean r10 = r11.isStackViewNeeded()
            r2 = r1
            r9 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r11.expandRvAdapter = r1
            boolean r1 = r11.isStackViewNeeded()
            if (r1 == 0) goto L_0x00b9
            com.paytmmall.clpartifact.view.decoration.StackItemDecoration r1 = new com.paytmmall.clpartifact.view.decoration.StackItemDecoration
            r1.<init>()
            androidx.recyclerview.widget.RecyclerView$h r1 = (androidx.recyclerview.widget.RecyclerView.h) r1
            r12.addItemDecoration(r1)
            com.paytmmall.clpartifact.view.viewHolder.BackwardsDrawingOrderCallback r1 = new com.paytmmall.clpartifact.view.viewHolder.BackwardsDrawingOrderCallback
            r1.<init>()
            androidx.recyclerview.widget.RecyclerView$d r1 = (androidx.recyclerview.widget.RecyclerView.d) r1
            r12.setChildDrawingOrderCallback(r1)
        L_0x00b9:
            r12.setLayoutManager(r0)
            com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter r0 = r11.expandRvAdapter
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r12.setAdapter(r0)
            return
        L_0x00c4:
            if (r0 == 0) goto L_0x00c9
            r0.setItem(r3)
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.viewHolder.CLPCarousel4X.setExpandedRv(androidx.recyclerview.widget.RecyclerView):void");
    }

    public RecoRvClick getRecoClickListner() {
        return new CLPCarousel4X$getRecoClickListner$1(this);
    }

    /* access modifiers changed from: private */
    public final void closeCountText(int i2) {
        if (i2 == 0) {
            RecyclerView recyclerView = this.binding.expandGroup4x;
            k.a((Object) recyclerView, "binding.expandGroup4x");
            recyclerView.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public final List<Item> getFilteredList(List<? extends Item> list) {
        k.c(list, "itemList");
        Set<String> recoDisallowedSet = ValidateViewResponse.getRecoDisallowedSet();
        List<Item> arrayList = new ArrayList<>();
        if (!list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                String id = ((Item) list.get(i2)).getId();
                k.a((Object) id, "itemList[i].getId()");
                if (!recoDisallowedSet.contains(id)) {
                    arrayList.add(list.get(i2));
                }
            }
        }
        return arrayList;
    }
}
