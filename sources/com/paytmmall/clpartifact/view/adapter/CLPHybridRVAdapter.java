package com.paytmmall.clpartifact.view.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.listeners.CLPHybridAdapterListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;
import kotlin.g.b.k;

public final class CLPHybridRVAdapter extends CLPItemRVAdapter {
    private final CustomAction customAction;
    private final CLPHybridAdapterListener hybridAdapterListner;
    private final long id;
    private final IGAHandlerListener igaHandlerListener;
    private final List<Item> mItemList;
    private final View view;

    public final CustomAction getCustomAction() {
        return this.customAction;
    }

    public final long getId() {
        return this.id;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CLPHybridRVAdapter(View view2, List<? extends Item> list, IGAHandlerListener iGAHandlerListener, CLPHybridAdapterListener cLPHybridAdapterListener, long j, CustomAction customAction2) {
        super(view2, list, iGAHandlerListener, Long.valueOf(j), customAction2);
        k.c(view2, "view");
        this.view = view2;
        this.mItemList = list;
        this.igaHandlerListener = iGAHandlerListener;
        this.hybridAdapterListner = cLPHybridAdapterListener;
        this.id = j;
        this.customAction = customAction2;
    }

    public final CLPItemRVViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        CLPItemRVViewHolder cLPItemRVViewHolder = ViewHolderFactory.getCLPItemRVViewHolder(viewGroup, getItemViewTypeInString(i2), this.igaHandlerListener, this.customAction, "");
        k.a((Object) cLPItemRVViewHolder, "ViewHolderFactory.getCLP…stener, customAction, \"\")");
        return cLPItemRVViewHolder;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a2 A[SYNTHETIC, Splitter:B:66:0x01a2] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder r14, int r15) {
        /*
            r13 = this;
            java.lang.String r0 = "clpBaseViewHolder"
            kotlin.g.b.k.c(r14, r0)
            super.onBindViewHolder((com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder) r14, (int) r15)
            java.util.List<com.paytmmall.clpartifact.modal.clpCommon.Item> r0 = r13.mItemList
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0019
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            if (r0 != 0) goto L_0x003f
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r13.view
            java.lang.String r0 = r0.getType()
            boolean r0 = com.paytmmall.clpartifact.utils.ViewHolderFactory.isTiWidgetFamily(r0)
            if (r0 == 0) goto L_0x003f
            java.util.List<com.paytmmall.clpartifact.modal.clpCommon.Item> r0 = r13.mItemList
            int r0 = r0.size()
            int r0 = r0 - r2
            if (r15 != r0) goto L_0x003f
            android.view.View r0 = r14.itemView
            int r3 = com.paytmmall.clpartifact.R.id.dividerView
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x003f
            r3 = 4
            r0.setVisibility(r3)
        L_0x003f:
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r13.view
            java.lang.String r0 = r0.getType()
            java.lang.String r3 = "list-small-ti"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0227
            android.view.View r14 = r14.itemView
            int r0 = com.paytmmall.clpartifact.R.id.rootLayout
            android.view.View r14 = r14.findViewById(r0)
            java.lang.String r0 = "clpBaseViewHolder.itemVi…tLayout>(R.id.rootLayout)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x0227
            androidx.constraintlayout.widget.c r0 = new androidx.constraintlayout.widget.c
            r0.<init>()
            r0.b((androidx.constraintlayout.widget.ConstraintLayout) r14)
            com.paytmmall.clpartifact.modal.clpCommon.View r3 = r13.view
            r9 = 0
            if (r3 == 0) goto L_0x0070
            java.util.List r3 = r3.getItems()
            goto L_0x0071
        L_0x0070:
            r3 = r9
        L_0x0071:
            java.lang.Object r3 = r3.get(r15)
            java.lang.String r10 = "view?.items[position]"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r10)
            com.paytmmall.clpartifact.modal.clpCommon.Item r3 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r3
            java.lang.String r3 = r3.getItemSubtitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x008e
            int r3 = r3.length()
            if (r3 != 0) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            r3 = 0
            goto L_0x008f
        L_0x008e:
            r3 = 1
        L_0x008f:
            r11 = 38
            if (r3 == 0) goto L_0x011f
            com.paytmmall.clpartifact.modal.clpCommon.View r3 = r13.view
            if (r3 == 0) goto L_0x009c
            java.util.List r3 = r3.getItems()
            goto L_0x009d
        L_0x009c:
            r3 = r9
        L_0x009d:
            java.lang.Object r3 = r3.get(r15)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r10)
            com.paytmmall.clpartifact.modal.clpCommon.Item r3 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r3
            java.lang.String r3 = r3.getTitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x00b7
            int r3 = r3.length()
            if (r3 != 0) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r3 = 0
            goto L_0x00b8
        L_0x00b7:
            r3 = 1
        L_0x00b8:
            if (r3 == 0) goto L_0x011f
            com.paytmmall.clpartifact.modal.clpCommon.View r3 = r13.view
            if (r3 == 0) goto L_0x00c3
            java.util.List r3 = r3.getItems()
            goto L_0x00c4
        L_0x00c3:
            r3 = r9
        L_0x00c4:
            java.lang.Object r3 = r3.get(r15)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r10)
            com.paytmmall.clpartifact.modal.clpCommon.Item r3 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r3
            java.lang.String r3 = r3.getAltImageUrl()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x00de
            int r3 = r3.length()
            if (r3 != 0) goto L_0x00dc
            goto L_0x00de
        L_0x00dc:
            r3 = 0
            goto L_0x00df
        L_0x00de:
            r3 = 1
        L_0x00df:
            if (r3 == 0) goto L_0x011f
            int r4 = com.paytmmall.clpartifact.R.id.icon
            r5 = 3
            int r6 = com.paytmmall.clpartifact.R.id.rootLayout
            r7 = 3
            r8 = 0
            r3 = r0
            r3.a(r4, r5, r6, r7, r8)
            int r4 = com.paytmmall.clpartifact.R.id.icon
            r5 = 4
            int r6 = com.paytmmall.clpartifact.R.id.rootLayout
            r7 = 4
            r3.a(r4, r5, r6, r7, r8)
            int r3 = com.paytmmall.clpartifact.R.id.icon
            int r4 = com.paytmmall.clpartifact.R.id.rootLayout
            r5 = 6
            r0.a((int) r3, (int) r5, (int) r4, (int) r5)
            int r4 = com.paytmmall.clpartifact.R.id.name
            r5 = 3
            int r6 = com.paytmmall.clpartifact.R.id.rootLayout
            r7 = 3
            r3 = r0
            r3.a(r4, r5, r6, r7, r8)
            int r4 = com.paytmmall.clpartifact.R.id.name
            r5 = 4
            int r6 = com.paytmmall.clpartifact.R.id.rootLayout
            r7 = 4
            r3.a(r4, r5, r6, r7, r8)
            int r4 = com.paytmmall.clpartifact.R.id.name
            r5 = 7
            int r6 = com.paytmmall.clpartifact.R.id.rootLayout
            r7 = 7
            int r8 = com.paytm.utility.b.c((int) r11)
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x018f
        L_0x011f:
            int r4 = com.paytmmall.clpartifact.R.id.icon
            r5 = 3
            int r6 = com.paytmmall.clpartifact.R.id.rootLayout
            r7 = 3
            r12 = 20
            int r8 = com.paytm.utility.b.c((int) r12)
            r3 = r0
            r3.a(r4, r5, r6, r7, r8)
            int r4 = com.paytmmall.clpartifact.R.id.icon
            r5 = 6
            int r6 = com.paytmmall.clpartifact.R.id.rootLayout
            r7 = 6
            r3 = 16
            int r8 = com.paytm.utility.b.c((int) r3)
            r3 = r0
            r3.a(r4, r5, r6, r7, r8)
            int r4 = com.paytmmall.clpartifact.R.id.name
            r5 = 3
            int r6 = com.paytmmall.clpartifact.R.id.rootLayout
            r7 = 3
            int r8 = com.paytm.utility.b.c((int) r12)
            r3.a(r4, r5, r6, r7, r8)
            int r4 = com.paytmmall.clpartifact.R.id.name
            r5 = 6
            int r6 = com.paytmmall.clpartifact.R.id.icon
            r7 = 7
            r3 = 18
            int r8 = com.paytm.utility.b.c((int) r3)
            r3 = r0
            r3.a(r4, r5, r6, r7, r8)
            com.paytmmall.clpartifact.modal.clpCommon.View r3 = r13.view
            if (r3 == 0) goto L_0x0165
            java.util.List r3 = r3.getItems()
            goto L_0x0166
        L_0x0165:
            r3 = r9
        L_0x0166:
            java.lang.Object r3 = r3.get(r15)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r10)
            com.paytmmall.clpartifact.modal.clpCommon.Item r3 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r3
            com.paytmmall.clpartifact.modal.clpCommon.Item$LayoutData r3 = r3.getLayout()
            if (r3 == 0) goto L_0x0178
            java.lang.String r3 = r3.mLabel
            goto L_0x0179
        L_0x0178:
            r3 = r9
        L_0x0179:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x018f
            int r4 = com.paytmmall.clpartifact.R.id.name
            r5 = 7
            int r6 = com.paytmmall.clpartifact.R.id.rootLayout
            r7 = 7
            int r8 = com.paytm.utility.b.c((int) r11)
            r3 = r0
            r3.a(r4, r5, r6, r7, r8)
        L_0x018f:
            r0.c((androidx.constraintlayout.widget.ConstraintLayout) r14)
            r0 = 32
            com.paytmmall.clpartifact.modal.clpCommon.View r3 = r13.view
            java.lang.String r3 = r3.getContainerSize()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x01b4
            com.paytmmall.clpartifact.modal.clpCommon.View r3 = r13.view     // Catch:{ Exception -> 0x01b3 }
            java.lang.String r3 = r3.getContainerSize()     // Catch:{ Exception -> 0x01b3 }
            java.lang.String r4 = "view.containerSize"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x01b3 }
            int r0 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x01b3 }
            goto L_0x01b4
        L_0x01b3:
        L_0x01b4:
            float r0 = (float) r0
            android.content.Context r3 = r14.getContext()
            int r0 = com.paytmmall.clpartifact.common.ViewUtils.convertDpToPixel(r0, r3)
            r13.setIconSize(r14, r0)
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r13.view
            if (r0 == 0) goto L_0x01c9
            java.util.List r0 = r0.getItems()
            goto L_0x01ca
        L_0x01c9:
            r0 = r9
        L_0x01ca:
            java.lang.Object r0 = r0.get(r15)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
            com.paytmmall.clpartifact.modal.clpCommon.Item r0 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r0
            java.lang.String r0 = r0.getAltImageUrl()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x01e4
            int r0 = r0.length()
            if (r0 != 0) goto L_0x01e2
            goto L_0x01e4
        L_0x01e2:
            r0 = 0
            goto L_0x01e5
        L_0x01e4:
            r0 = 1
        L_0x01e5:
            if (r0 == 0) goto L_0x0227
            int r0 = com.paytmmall.clpartifact.R.id.altIcon
            android.view.View r0 = r14.findViewById(r0)
            java.lang.String r3 = "rootLayout.findViewById<….view.View>(R.id.altIcon)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r3 = 8
            r0.setVisibility(r3)
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r13.view
            if (r0 == 0) goto L_0x01ff
            java.util.List r9 = r0.getItems()
        L_0x01ff:
            java.lang.Object r15 = r9.get(r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            com.paytmmall.clpartifact.modal.clpCommon.Item r15 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r15
            java.lang.String r15 = r15.getTitle()
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            if (r15 == 0) goto L_0x0216
            int r15 = r15.length()
            if (r15 != 0) goto L_0x0217
        L_0x0216:
            r1 = 1
        L_0x0217:
            if (r1 == 0) goto L_0x0227
            int r15 = com.paytmmall.clpartifact.R.id.title
            android.view.View r14 = r14.findViewById(r15)
            java.lang.String r15 = "rootLayout.findViewById<…id.view.View>(R.id.title)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)
            r14.setVisibility(r3)
        L_0x0227:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.adapter.CLPHybridRVAdapter.onBindViewHolder(com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder, int):void");
    }

    private final void setIconSize(ConstraintLayout constraintLayout, int i2) {
        ImageView imageView = (ImageView) constraintLayout.findViewById(R.id.icon);
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams.width != i2 && layoutParams.height != i2) {
                layoutParams.width = i2;
                layoutParams.height = i2;
                imageView.setLayoutParams(layoutParams);
            }
        }
    }

    private final String getItemViewTypeInString(int i2) {
        String itemViewTypeInString;
        CLPHybridAdapterListener cLPHybridAdapterListener = this.hybridAdapterListner;
        if (cLPHybridAdapterListener != null && (itemViewTypeInString = cLPHybridAdapterListener.getItemViewTypeInString(i2)) != null) {
            return itemViewTypeInString;
        }
        String type = this.view.getType();
        k.a((Object) type, "view.type");
        return type;
    }

    public final int getItemViewType(int i2) {
        Integer itemViewType;
        CLPHybridAdapterListener cLPHybridAdapterListener = this.hybridAdapterListner;
        if (cLPHybridAdapterListener == null || (itemViewType = cLPHybridAdapterListener.getItemViewType(i2)) == null) {
            return super.getItemViewType(i2);
        }
        return itemViewType.intValue();
    }

    public final int getItemCount() {
        List<Item> list = this.mItemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
