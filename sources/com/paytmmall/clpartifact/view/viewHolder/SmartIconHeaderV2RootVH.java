package com.paytmmall.clpartifact.view.viewHolder;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.a.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.databinding.ItemSmartIconHeaderV2RootBinding;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.SnapOnScrollListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.RecoUtils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.activity.RecoExpandActivity;
import com.paytmmall.clpartifact.view.adapter.CLPNewSmartHeaderRVAdapter;
import com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter;
import com.paytmmall.clpartifact.view.decoration.SnapToBlock;
import com.paytmmall.clpartifact.view.decoration.StackItemDecoration;
import com.paytmmall.clpartifact.widgets.callback.ActivityListener;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public final class SmartIconHeaderV2RootVH extends CLPItemRVViewHolder {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public final int HEADER_ICON_MAX_SIZE = 4;
    private final int ITEM_COUNT = 4;
    private final ItemSmartIconHeaderV2RootBinding binding = this.viewBinding;
    private final CustomAction customAction;
    /* access modifiers changed from: private */
    public ArrayList<Item> filteredList;
    private IGAHandlerListener gaListener;
    private BroadcastReceiver listener;
    private List<? extends Item> mItemsForReference;
    /* access modifiers changed from: private */
    public View mView;
    /* access modifiers changed from: private */
    public HomeReco4XAdapter recoRVAdapter;
    /* access modifiers changed from: private */
    public View recoView;
    private SnapOnScrollListener snapOnScrollListener;
    private final ItemSmartIconHeaderV2RootBinding viewBinding;

    public static final int getStaticImages(Item item, int i2) {
        return Companion.getStaticImages(item, i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartIconHeaderV2RootVH(ItemSmartIconHeaderV2RootBinding itemSmartIconHeaderV2RootBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(itemSmartIconHeaderV2RootBinding, iGAHandlerListener, customAction2);
        k.c(itemSmartIconHeaderV2RootBinding, "viewBinding");
        this.viewBinding = itemSmartIconHeaderV2RootBinding;
        this.gaListener = iGAHandlerListener;
        this.customAction = customAction2;
    }

    public static final /* synthetic */ ArrayList access$getFilteredList$p(SmartIconHeaderV2RootVH smartIconHeaderV2RootVH) {
        ArrayList<Item> arrayList = smartIconHeaderV2RootVH.filteredList;
        if (arrayList == null) {
            k.a("filteredList");
        }
        return arrayList;
    }

    public static final /* synthetic */ View access$getRecoView$p(SmartIconHeaderV2RootVH smartIconHeaderV2RootVH) {
        View view = smartIconHeaderV2RootVH.recoView;
        if (view == null) {
            k.a("recoView");
        }
        return view;
    }

    public final CustomAction getCustomAction() {
        return this.customAction;
    }

    public final IGAHandlerListener getGaListener() {
        return this.gaListener;
    }

    public final ItemSmartIconHeaderV2RootBinding getViewBinding() {
        return this.viewBinding;
    }

    public final void setGaListener(IGAHandlerListener iGAHandlerListener) {
        this.gaListener = iGAHandlerListener;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final int getStaticImages(Item item, int i2) {
            k.c(item, "item");
            if (i2 == 0) {
                return R.drawable.ic_scan_and_pay;
            }
            if (i2 == 1) {
                return R.drawable.ic_sf_send_money_bundle;
            }
            if (i2 == 2) {
                return R.drawable.sf_recharge_bundle;
            }
            return R.drawable.ic_passbok;
        }
    }

    /* access modifiers changed from: protected */
    public final void doBinding(View view) {
        super.doBinding(modifyView(view));
        this.mItemsForReference = getItems(view);
        this.mView = view;
        this.viewBinding.setVariable(BR.view, view);
        this.viewBinding.setVariable(BR.handler, this);
        setMainlytBackground(view);
        setTransparentBannerImage(view);
        setHeaderUI(view);
        setRecoCollapseListener();
        setCarouselUI(view != null ? view.getmView() : null);
    }

    private final void setRecoCollapseListener() {
        this.listener = new SmartIconHeaderV2RootVH$setRecoCollapseListener$1(this);
    }

    public final void onViewAttachedToWindow(CLPBaseViewHolder cLPBaseViewHolder, View view) {
        k.c(cLPBaseViewHolder, "holder");
        super.onViewAttachedToWindow(cLPBaseViewHolder, view);
        android.view.View view2 = this.itemView;
        k.a((Object) view2, "itemView");
        android.view.View rootView = view2.getRootView();
        k.a((Object) rootView, "itemView.rootView");
        a a2 = a.a(rootView.getContext());
        BroadcastReceiver broadcastReceiver = this.listener;
        if (broadcastReceiver == null) {
            k.a("listener");
        }
        a2.a(broadcastReceiver, new IntentFilter(CLPConstants.RECO_LOCALBROADCAST));
    }

    private final void setCarouselUI(View view) {
        List<Item> items;
        RecyclerView recyclerView = this.viewBinding.recoRv;
        k.a((Object) recyclerView, "viewBinding.recoRv");
        recyclerView.setNestedScrollingEnabled(false);
        setGAData(view != null ? view.getGaData() : null);
        if (!(view == null || (items = view.getItems()) == null)) {
            Collection collection = items;
            if (!(collection == null || collection.isEmpty())) {
                RecoUtils recoUtils = new RecoUtils();
                List<Item> list = view.mItems;
                if (list != null) {
                    this.filteredList = recoUtils.getFilteredItemList((ArrayList) list);
                    ArrayList<Item> arrayList = this.filteredList;
                    if (arrayList == null) {
                        k.a("filteredList");
                    }
                    if (arrayList.size() == 0) {
                        Group group = this.viewBinding.topLayoutGroup;
                        k.a((Object) group, "viewBinding.topLayoutGroup");
                        group.setVisibility(0);
                        RecyclerView recyclerView2 = this.viewBinding.recoRv;
                        k.a((Object) recyclerView2, "viewBinding.recoRv");
                        recyclerView2.setVisibility(4);
                        return;
                    }
                    Group group2 = this.viewBinding.topLayoutGroup;
                    k.a((Object) group2, "viewBinding.topLayoutGroup");
                    group2.setVisibility(4);
                    RecyclerView recyclerView3 = this.viewBinding.recoRv;
                    k.a((Object) recyclerView3, "viewBinding.recoRv");
                    recyclerView3.setVisibility(0);
                    ItemSmartIconHeaderV2RootBinding itemSmartIconHeaderV2RootBinding = this.viewBinding;
                    ArrayList<Item> arrayList2 = this.filteredList;
                    if (arrayList2 == null) {
                        k.a("filteredList");
                    }
                    setRecoRV(itemSmartIconHeaderV2RootBinding, arrayList2, view);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.Item> /* = java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.Item> */");
            }
        }
        Group group3 = this.viewBinding.topLayoutGroup;
        k.a((Object) group3, "viewBinding.topLayoutGroup");
        group3.setVisibility(0);
        RecyclerView recyclerView4 = this.viewBinding.recoRv;
        k.a((Object) recyclerView4, "viewBinding.recoRv");
        recyclerView4.setVisibility(4);
    }

    private final void setRecoRV(ItemSmartIconHeaderV2RootBinding itemSmartIconHeaderV2RootBinding, ArrayList<Item> arrayList, View view) {
        if (this.recoRVAdapter == null) {
            itemSmartIconHeaderV2RootBinding.recoRv.addItemDecoration(new StackItemDecoration());
        }
        android.view.View root = this.binding.getRoot();
        k.a((Object) root, "binding.root");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        View view2 = view;
        this.recoRVAdapter = new HomeReco4XAdapter(arrayList, view2, getIgaHandlerListener(), this.customAction, new SmartIconHeaderV2RootVH$setRecoRV$clickListener$1(this, view), Boolean.FALSE, layoutManager, true);
        RecyclerView recyclerView = itemSmartIconHeaderV2RootBinding.recoRv;
        k.a((Object) recyclerView, "viewBinding.recoRv");
        recyclerView.setLayoutManager(layoutManager);
        itemSmartIconHeaderV2RootBinding.recoRv.setChildDrawingOrderCallback(new BackwardsDrawingOrderCallback());
        RecyclerView recyclerView2 = itemSmartIconHeaderV2RootBinding.recoRv;
        k.a((Object) recyclerView2, "viewBinding.recoRv");
        recyclerView2.setAdapter(this.recoRVAdapter);
    }

    /* access modifiers changed from: private */
    public final void itemClick(android.view.View view, View view2) {
        ActivityListener activityListener;
        Activity hostActivity;
        List<Item> items;
        android.view.View findViewById = view.getRootView().findViewById(R.id.container);
        k.a((Object) findViewById, "itemView.rootView.findViewById(R.id.container)");
        Bitmap bitmapFromView = getBitmapFromView(findViewById);
        String bitmapSave = bitmapFromView != null ? bitmapSave(bitmapFromView) : null;
        if (getAdapterPosition() >= 0) {
            if (getAdapterPosition() < ((view2 == null || (items = view2.getItems()) == null) ? 0 : items.size())) {
                GaHandler.getInstance().fireRecoState(view2.mItems.get(getAdapterPosition()), getAdapterPosition(), CLPConstants.COLLAPSED);
            }
        }
        Intent intent = new Intent(view.getContext(), RecoExpandActivity.class);
        intent.putExtra(CLPConstants.RECO_VIEW, view2);
        intent.putExtra(CLPConstants.RECO_IMAGE, bitmapSave);
        CustomAction customAction2 = this.customAction;
        Context context = (customAction2 == null || (activityListener = customAction2.getActivityListener()) == null || (hostActivity = activityListener.getHostActivity()) == null) ? view.getContext() : hostActivity;
        if (context instanceof FragmentActivity) {
            context.startActivity(intent);
            ((FragmentActivity) context).overridePendingTransition(0, 0);
        }
    }

    private final String bitmapSave(Bitmap bitmap) {
        try {
            android.view.View view = this.itemView;
            k.a((Object) view, "itemView");
            FileOutputStream openFileOutput = view.getContext().openFileOutput("bitmap.png", 0);
            k.a((Object) openFileOutput, "itemView.context.openFil…me, Context.MODE_PRIVATE)");
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, openFileOutput);
            openFileOutput.close();
            bitmap.recycle();
            return "bitmap.png";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private final Bitmap getBitmapFromView(android.view.View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* access modifiers changed from: private */
    public final void closeCountText() {
        ArrayList<Item> arrayList = this.filteredList;
        if (arrayList == null) {
            k.a("filteredList");
        }
        if (arrayList.size() == 0) {
            RecyclerView recyclerView = this.binding.recoRv;
            k.a((Object) recyclerView, "binding.recoRv");
            recyclerView.setVisibility(4);
            Group group = this.binding.topLayoutGroup;
            k.a((Object) group, "binding.topLayoutGroup");
            group.setVisibility(0);
            android.view.View view = this.itemView;
            k.a((Object) view, "itemView");
            android.view.View rootView = view.getRootView();
            k.a((Object) rootView, "itemView.rootView");
            a a2 = a.a(rootView.getContext());
            BroadcastReceiver broadcastReceiver = this.listener;
            if (broadcastReceiver == null) {
                k.a("listener");
            }
            a2.a(broadcastReceiver);
        }
    }

    private final void setTransparentBannerImage(View view) {
        Collection collection = view != null ? view.getmViewItems() : null;
        if (!(collection == null || collection.isEmpty())) {
            List<Item> list = view != null ? view.getmViewItems() : null;
            if (list == null) {
                k.a();
            }
            if (list.size() > 0) {
                Item item = view.getmViewItems().get(0);
                k.a((Object) item, "item");
                item.setParentType(view.getType());
                setGAImpression(item, this.mView, 0, this.gaListener);
                SmartIconHeaderV2RootVH.class.getSimpleName();
                q.a("context = " + getContext());
                b.a aVar = b.f43744a;
                Context context = getContext();
                k.a((Object) context, "context");
                b.a.C0750a a2 = b.a.a(context);
                a2.f43753a = item.getImageUrl();
                b.a.C0750a a3 = a2.a(com.paytm.utility.b.b.a.ALL);
                a3.M = false;
                a3.a((ImageView) null, (com.paytm.utility.b.b.b<?>) new SmartIconHeaderV2RootVH$setTransparentBannerImage$1(this));
            }
        }
    }

    public final void handleBannerClick() {
        List<Item> list;
        View view = this.mView;
        Item item = null;
        Collection collection = view != null ? view.getmViewItems() : null;
        if (!(collection == null || collection.isEmpty())) {
            View view2 = this.mView;
            if (!(view2 == null || (list = view2.getmViewItems()) == null)) {
                item = list.get(0);
            }
            handleDeepLink(item, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        if ((r2.length == 0) != false) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setMainlytBackground(com.paytmmall.clpartifact.modal.clpCommon.View r6) {
        /*
            r5 = this;
            r5.setDefaultGradient()
            com.paytmmall.clpartifact.databinding.ItemSmartIconHeaderV2RootBinding r0 = r5.viewBinding
            androidx.constraintlayout.widget.Group r0 = r0.topLayoutGroup
            java.lang.String r1 = "viewBinding.topLayoutGroup"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            r0.setVisibility(r1)
            r0 = 0
            if (r6 == 0) goto L_0x0019
            com.paytmmall.clpartifact.modal.clpCommon.MetaLayout r2 = r6.getmMetaLayout()
            goto L_0x001a
        L_0x0019:
            r2 = r0
        L_0x001a:
            if (r2 == 0) goto L_0x0093
            com.paytmmall.clpartifact.modal.clpCommon.MetaLayout r2 = r6.getmMetaLayout()
            java.lang.String r2 = r2.getmBgImage()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 1
            if (r2 == 0) goto L_0x0032
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r2 = 0
            goto L_0x0033
        L_0x0032:
            r2 = 1
        L_0x0033:
            if (r2 != 0) goto L_0x004b
            com.paytmmall.clpartifact.databinding.ItemSmartIconHeaderV2RootBinding r0 = r5.viewBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.mainLayout
            android.view.View r0 = (android.view.View) r0
            android.content.Context r1 = r5.getContext()
            com.paytmmall.clpartifact.modal.clpCommon.MetaLayout r6 = r6.getmMetaLayout()
            java.lang.String r6 = r6.getmBgImage()
            com.paytmmall.clpartifact.utils.ImageUtility.loadBackgroundDrawableAsync((android.view.View) r0, (android.content.Context) r1, (java.lang.String) r6)
            return
        L_0x004b:
            if (r6 == 0) goto L_0x0052
            com.paytmmall.clpartifact.modal.clpCommon.MetaLayout r2 = r6.getmMetaLayout()
            goto L_0x0053
        L_0x0052:
            r2 = r0
        L_0x0053:
            java.lang.String r4 = "view?.getmMetaLayout()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String[] r2 = r2.getMBgGradient()
            if (r2 == 0) goto L_0x0067
            int r2 = r2.length
            if (r2 != 0) goto L_0x0064
            r2 = 1
            goto L_0x0065
        L_0x0064:
            r2 = 0
        L_0x0065:
            if (r2 == 0) goto L_0x0068
        L_0x0067:
            r1 = 1
        L_0x0068:
            if (r1 != 0) goto L_0x0093
            if (r6 == 0) goto L_0x0071
            com.paytmmall.clpartifact.modal.clpCommon.MetaLayout r1 = r6.getmMetaLayout()
            goto L_0x0072
        L_0x0071:
            r1 = r0
        L_0x0072:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String[] r1 = r1.getMBgGradient()
            int r1 = r1.length
            r2 = 3
            if (r1 < r2) goto L_0x0093
            if (r6 == 0) goto L_0x0083
            com.paytmmall.clpartifact.modal.clpCommon.MetaLayout r0 = r6.getmMetaLayout()
        L_0x0083:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.String[] r6 = r0.getMBgGradient()
            java.lang.String r0 = "view?.getmMetaLayout().mBgGradient"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            r5.setGradientBackground(r6)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.viewHolder.SmartIconHeaderV2RootVH.setMainlytBackground(com.paytmmall.clpartifact.modal.clpCommon.View):void");
    }

    private final void setDefaultGradient() {
        setGradientBackground(new String[]{"#FFFFFF", "#FFFFFF", "#80D9FF"});
    }

    private final void setGradientBackground(String[] strArr) {
        List arrayList = new ArrayList();
        int i2 = 0;
        for (String str : strArr) {
            if (i2 > 0) {
                arrayList.add(Integer.valueOf(Color.parseColor(str)));
            }
            i2++;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, kotlin.a.k.b(arrayList));
        gradientDrawable.setCornerRadius(0.0f);
        ConstraintLayout constraintLayout = this.viewBinding.mainLayout;
        k.a((Object) constraintLayout, "viewBinding.mainLayout");
        constraintLayout.setBackground(gradientDrawable);
    }

    private final void setHeaderUI(View view) {
        setGAData(view != null ? view.getGaData() : null);
        RecyclerView recyclerView = this.viewBinding.smartIconsV2Rv;
        k.a((Object) recyclerView, "viewBinding.smartIconsV2Rv");
        recyclerView.setLayoutManager(new SmartIconHeaderV2RootVH$setHeaderUI$1(this, view, getContext(), 0, false));
        ArrayList<Item> newItem = newItem(view);
        if (newItem.size() > this.HEADER_ICON_MAX_SIZE) {
            int size = newItem.size();
            int i2 = this.HEADER_ICON_MAX_SIZE;
            if (size % i2 != 0) {
                int size2 = i2 - (newItem.size() % this.HEADER_ICON_MAX_SIZE);
                for (int i3 = 0; i3 < size2; i3++) {
                    newItem.add(new Item());
                }
            }
        }
        RecyclerView recyclerView2 = this.viewBinding.smartIconsV2Rv;
        k.a((Object) recyclerView2, "viewBinding.smartIconsV2Rv");
        IGAHandlerListener igaHandlerListener = getIgaHandlerListener();
        k.a((Object) igaHandlerListener, "igaHandlerListener");
        recyclerView2.setAdapter(new CLPNewSmartHeaderRVAdapter(view, newItem, igaHandlerListener, this.customAction));
        RecyclerView recyclerView3 = this.viewBinding.smartIconsV2Rv;
        k.a((Object) recyclerView3, "viewBinding.smartIconsV2Rv");
        recyclerView3.setOnFlingListener((RecyclerView.j) null);
        RecyclerView recyclerView4 = this.viewBinding.smartIconsV2Rv;
        k.a((Object) recyclerView4, "viewBinding.smartIconsV2Rv");
        recyclerView4.setNestedScrollingEnabled(false);
        RecyclerView recyclerView5 = this.viewBinding.smartIconsV2Rv;
        k.a((Object) recyclerView5, "viewBinding.smartIconsV2Rv");
        setSnapHelper(view, recyclerView5);
    }

    public final ArrayList<Item> newItem(View view) {
        List<Item> items = view != null ? view.getItems() : null;
        if (items != null) {
            return (ArrayList) items;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.Item> /* = java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.Item> */");
    }

    public final List<Item> getItems(View view) {
        TreeMap<Integer, List<Item>> smartItems = view != null ? view.getSmartItems() : null;
        ArrayList arrayList = new ArrayList();
        if (smartItems != null) {
            int size = smartItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                Item item = new Item();
                try {
                    StringBuilder sb = new StringBuilder();
                    CLPArtifact instance = CLPArtifact.getInstance();
                    k.a((Object) instance, "CLPArtifact.getInstance()");
                    ICLPCommunicationListener communicationListener = instance.getCommunicationListener();
                    k.a((Object) communicationListener, "CLPArtifact.getInstance().communicationListener");
                    sb.append(communicationListener.getClientRequestID());
                    sb.append(i2);
                    item.setmId(sb.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    item.setmId(String.valueOf(i2));
                }
                item.setItems(smartItems.get(Integer.valueOf(i2)));
                item.setParentType(ViewHolderFactory.LAYOUT_SMART_ICON_HEADER);
                arrayList.add(item);
            }
        }
        return arrayList;
    }

    private final void setSnapHelper(View view, RecyclerView recyclerView) {
        SnapToBlock snapToBlock = new SnapToBlock(this.ITEM_COUNT);
        snapToBlock.attachToRecyclerView(recyclerView);
        if (view != null && this.snapOnScrollListener == null) {
            this.snapOnScrollListener = new SnapOnScrollListener(snapToBlock, SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL, new SmartIconHeaderV2RootVH$setSnapHelper$$inlined$let$lambda$1(this, snapToBlock, recyclerView));
            SnapOnScrollListener snapOnScrollListener2 = this.snapOnScrollListener;
            if (snapOnScrollListener2 == null) {
                k.a();
            }
            recyclerView.addOnScrollListener(snapOnScrollListener2);
        }
    }

    private final View modifyView(View view) {
        TreeMap<Integer, List<Item>> walletStripMapData = setWalletStripMapData(view != null ? view.getItems() : null);
        if (view != null) {
            view.setSmartItems(walletStripMapData);
        }
        return view;
    }

    private final TreeMap<Integer, List<Item>> setWalletStripMapData(List<? extends Item> list) {
        TreeMap<Integer, List<Item>> treeMap = new TreeMap<>();
        if (list != null && !list.isEmpty()) {
            treeMap.clear();
            int i2 = 0;
            int i3 = 0;
            while (i2 < list.size()) {
                int i4 = this.ITEM_COUNT + i2;
                ArrayList arrayList = new ArrayList();
                int i5 = i2;
                while (i5 < list.size() && i5 < i4) {
                    arrayList.add(list.get(i5));
                    i5++;
                }
                Integer valueOf = Integer.valueOf(i3);
                i3++;
                treeMap.put(valueOf, arrayList);
                i2 += this.ITEM_COUNT;
            }
        }
        return treeMap;
    }

    /* access modifiers changed from: private */
    public final Item getItemForGa(int i2) {
        List<? extends Item> list = this.mItemsForReference;
        if (list == null) {
            k.a("mItemsForReference");
        }
        if (i2 == -1 || i2 >= list.size()) {
            return null;
        }
        return (Item) list.get(i2);
    }

    /* access modifiers changed from: private */
    public final void setGAImpression(Item item, View view, int i2, IGAHandlerListener iGAHandlerListener) {
        if (item != null) {
            AsyncTask.SERIAL_EXECUTOR.execute(new SmartIconHeaderV2RootVH$setGAImpression$$inlined$Runnable$1(this, view, item, i2, iGAHandlerListener));
        }
    }

    /* access modifiers changed from: private */
    public final void handleGAImpression(View view, Item item, int i2, IGAHandlerListener iGAHandlerListener) {
        if (iGAHandlerListener != null) {
            Map<String, Object> map = null;
            item.setParentPosition(view != null ? view.getGaData() : null);
            if (view != null) {
                map = view.getGaData();
            }
            item.setGaData(map);
            iGAHandlerListener.fireImpression(item, i2);
        } else if (isClpImplementationAvailable()) {
            GaHandler.getInstance().fireImpression(item, i2);
        }
    }
}
