package com.paytmmall.clpartifact.widgets.component.smarticongrid.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CirclePageIndicator;
import com.paytmmall.clpartifact.databinding.SfGridPopupLayoutBinding;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.CategoryImpressionAndApiHandler;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.SFCustomPager;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.GTMDataController;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.GroupGridLayoutDataModel;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.SmartIconGridConstants;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SmartIconListFragment;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.viewmodel.SFSmartIconFragmentViewModel;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.viewmodel.SmartGridDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import kotlin.g.b.k;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.x;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.LayoutType;
import net.one97.paytm.i.g;
import net.one97.paytm.upi.util.UpiConstants;

public final class SFSmartIconFragment extends g implements SmartIconListFragment.ItemListListner {
    static final /* synthetic */ i[] $$delegatedProperties = {y.a((v) new w(y.b(SFSmartIconFragment.class), "smartIconPagerAdapter", "getSmartIconPagerAdapter()Lcom/paytmmall/clpartifact/widgets/component/smarticongrid/view/SFSmartIconFragment$SmartIconPagerAdapter;"))};
    public static final Companion Companion = new Companion((kotlin.g.b.g) null);
    private HashMap _$_findViewCache;
    public SfGridPopupLayoutBinding dataBinding;
    private SmartGridDataModel dataModel = new SmartGridDataModel();
    /* access modifiers changed from: private */
    public ArrayList<GroupGridLayoutDataModel> finalList = new ArrayList<>();
    /* access modifiers changed from: private */
    public OnItemClickListner itemClickListner;
    /* access modifiers changed from: private */
    public int mCurrentPosition;
    /* access modifiers changed from: private */
    public int mScrollState;
    private String mViewType = "";
    /* access modifiers changed from: private */
    public String promotionName = "";
    private final kotlin.g smartIconPagerAdapter$delegate = h.a(new SFSmartIconFragment$smartIconPagerAdapter$2(this));
    public SFSmartIconFragmentViewModel viewModel;

    public interface OnItemClickListner {
        void onItemClick(int i2, Item item, int i3);

        void onTickerItemClick(int i2, Item item);
    }

    private final SmartIconPagerAdapter getSmartIconPagerAdapter() {
        return (SmartIconPagerAdapter) this.smartIconPagerAdapter$delegate.getValue();
    }

    public static final void sendImpressionEvent(ArrayList<Item> arrayList, Context context, String str, String str2, int i2, String str3) {
        Companion.sendImpressionEvent(arrayList, context, str, str2, i2, str3);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final SfGridPopupLayoutBinding getDataBinding() {
        SfGridPopupLayoutBinding sfGridPopupLayoutBinding = this.dataBinding;
        if (sfGridPopupLayoutBinding == null) {
            k.a("dataBinding");
        }
        return sfGridPopupLayoutBinding;
    }

    public final void setDataBinding(SfGridPopupLayoutBinding sfGridPopupLayoutBinding) {
        k.c(sfGridPopupLayoutBinding, "<set-?>");
        this.dataBinding = sfGridPopupLayoutBinding;
    }

    public final SFSmartIconFragmentViewModel getViewModel() {
        SFSmartIconFragmentViewModel sFSmartIconFragmentViewModel = this.viewModel;
        if (sFSmartIconFragmentViewModel == null) {
            k.a("viewModel");
        }
        return sFSmartIconFragmentViewModel;
    }

    public final void setViewModel(SFSmartIconFragmentViewModel sFSmartIconFragmentViewModel) {
        k.c(sFSmartIconFragmentViewModel, "<set-?>");
        this.viewModel = sFSmartIconFragmentViewModel;
    }

    public final SmartGridDataModel getDataModel() {
        return this.dataModel;
    }

    public final void setDataModel(SmartGridDataModel smartGridDataModel) {
        k.c(smartGridDataModel, "<set-?>");
        this.dataModel = smartGridDataModel;
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (getActivity() == null) {
            dismiss();
        }
        ai a2 = am.a((Fragment) this).a(SFSmartIconFragmentViewModel.class);
        k.a((Object) a2, "ViewModelProviders.of(th…entViewModel::class.java)");
        this.viewModel = (SFSmartIconFragmentViewModel) a2;
        SFSmartIconFragmentViewModel sFSmartIconFragmentViewModel = this.viewModel;
        if (sFSmartIconFragmentViewModel == null) {
            k.a("viewModel");
        }
        Bundle arguments = getArguments();
        ArrayList<String> arrayList = null;
        ArrayList<String> stringArrayList = arguments != null ? arguments.getStringArrayList(SmartIconGridConstants.KEY_HOME_ICON_VIEW_ID) : null;
        if (stringArrayList != null) {
            sFSmartIconFragmentViewModel.setIconViewIds(stringArrayList);
            SFSmartIconFragmentViewModel sFSmartIconFragmentViewModel2 = this.viewModel;
            if (sFSmartIconFragmentViewModel2 == null) {
                k.a("viewModel");
            }
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                arrayList = arguments2.getStringArrayList(SmartIconGridConstants.KEY_HOME_TICKER_ID);
            }
            if (arrayList != null) {
                sFSmartIconFragmentViewModel2.setTickerViewIds(arrayList);
                Bundle arguments3 = getArguments();
                if (arguments3 == null || (str = arguments3.getString(SmartIconGridConstants.VIEW_TYPE)) == null) {
                    str = "";
                }
                this.mViewType = str;
                if (p.a(LayoutType.LAYOUT_SMART_ICON_GROUP_GRID.getName(), this.mViewType, true)) {
                    this.promotionName = CLPConstants.SMART_ICON_GROUP_GRID_DRAWER;
                } else if (p.a(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID_4XN, this.mViewType, true)) {
                    this.promotionName = CLPConstants.SMART_ICON_GRID_4XN_DRAWER;
                } else {
                    this.promotionName = this.mViewType + CLPConstants.DRAWER_POSTFIX;
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            }
        } else {
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            dialog.setCanceledOnTouchOutside(true);
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setLayout(-2, -2);
            }
        }
        ViewDataBinding a2 = f.a(layoutInflater, R.layout.sf_grid_popup_layout, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…layout, container, false)");
        this.dataBinding = (SfGridPopupLayoutBinding) a2;
        SfGridPopupLayoutBinding sfGridPopupLayoutBinding = this.dataBinding;
        if (sfGridPopupLayoutBinding == null) {
            k.a("dataBinding");
        }
        return sfGridPopupLayoutBinding.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        SfGridPopupLayoutBinding sfGridPopupLayoutBinding = this.dataBinding;
        if (sfGridPopupLayoutBinding == null) {
            k.a("dataBinding");
        }
        SFCustomPager sFCustomPager = sfGridPopupLayoutBinding.gridViewPager;
        k.a((Object) sFCustomPager, "dataBinding.gridViewPager");
        sFCustomPager.setAdapter(getSmartIconPagerAdapter());
        SfGridPopupLayoutBinding sfGridPopupLayoutBinding2 = this.dataBinding;
        if (sfGridPopupLayoutBinding2 == null) {
            k.a("dataBinding");
        }
        CirclePageIndicator circlePageIndicator = sfGridPopupLayoutBinding2.indicator;
        SfGridPopupLayoutBinding sfGridPopupLayoutBinding3 = this.dataBinding;
        if (sfGridPopupLayoutBinding3 == null) {
            k.a("dataBinding");
        }
        SFCustomPager sFCustomPager2 = sfGridPopupLayoutBinding3.gridViewPager;
        k.a((Object) sFCustomPager2, "dataBinding.gridViewPager");
        setupPagerIndicator(circlePageIndicator, sFCustomPager2);
        SfGridPopupLayoutBinding sfGridPopupLayoutBinding4 = this.dataBinding;
        if (sfGridPopupLayoutBinding4 == null) {
            k.a("dataBinding");
        }
        sfGridPopupLayoutBinding4.setDataModel(this.dataModel);
        SFSmartIconFragmentViewModel sFSmartIconFragmentViewModel = this.viewModel;
        if (sFSmartIconFragmentViewModel == null) {
            k.a("viewModel");
        }
        sFSmartIconFragmentViewModel.loadData().observe(getViewLifecycleOwner(), new SFSmartIconFragment$onViewCreated$1(this));
        SfGridPopupLayoutBinding sfGridPopupLayoutBinding5 = this.dataBinding;
        if (sfGridPopupLayoutBinding5 == null) {
            k.a("dataBinding");
        }
        setupViewPager(sfGridPopupLayoutBinding5.gridViewPager);
        SfGridPopupLayoutBinding sfGridPopupLayoutBinding6 = this.dataBinding;
        if (sfGridPopupLayoutBinding6 == null) {
            k.a("dataBinding");
        }
        ConstraintLayout constraintLayout = sfGridPopupLayoutBinding6.popupLayout;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new SFSmartIconFragment$onViewCreated$2(this));
        }
    }

    private final void setupPagerIndicator(CirclePageIndicator circlePageIndicator, ViewPager viewPager) {
        if (circlePageIndicator != null) {
            circlePageIndicator.setViewPager(viewPager);
            circlePageIndicator.setStrokeWidth(1.0f);
            circlePageIndicator.setStrokeColor(b.c(circlePageIndicator.getContext(), R.color.white));
            circlePageIndicator.setFillColor(b.c(circlePageIndicator.getContext(), R.color.blue));
        }
    }

    /* access modifiers changed from: private */
    public final void handleResponseList(List<GroupGridLayoutDataModel> list) {
        this.finalList = new ArrayList<>(list);
        this.dataModel.setfinalList(this.finalList);
        getSmartIconPagerAdapter().notifyDataSetChanged();
    }

    private final void setupViewPager(ViewPager viewPager) {
        x.a aVar = new x.a();
        aVar.element = true;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new SFSmartIconFragment$setupViewPager$$inlined$apply$lambda$1(viewPager, this, aVar));
        }
    }

    /* access modifiers changed from: private */
    public final void handleScrollState(ViewPager viewPager, int i2) {
        if (i2 == 0 && this.mScrollState == 1) {
            setNextItemIfNeeded(viewPager);
        }
    }

    private final void setNextItemIfNeeded(ViewPager viewPager) {
        if (!isScrollStateSettling()) {
            handleSetNextItem(viewPager);
        }
    }

    private final boolean isScrollStateSettling() {
        return this.mScrollState == 2;
    }

    private final void handleSetNextItem(ViewPager viewPager) {
        int count = getSmartIconPagerAdapter().getCount() - 1;
        int i2 = this.mCurrentPosition;
        if (i2 == 0) {
            viewPager.setCurrentItem(count, true);
        } else if (i2 == count) {
            viewPager.setCurrentItem(0, true);
        }
    }

    public final void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.sf_dialog_animation_fade);
        }
    }

    public final class SmartIconPagerAdapter extends m {
        final /* synthetic */ SFSmartIconFragment this$0;

        public final int getItemPosition(Object obj) {
            k.c(obj, "object");
            return -2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SmartIconPagerAdapter(SFSmartIconFragment sFSmartIconFragment, j jVar) {
            super(jVar);
            k.c(jVar, "fm");
            this.this$0 = sFSmartIconFragment;
        }

        public final Fragment getItem(int i2) {
            return getSmartIconListFragment(i2);
        }

        private final SmartIconListFragment getSmartIconListFragment(int i2) {
            SmartIconListFragment smartIconListFragment = new SmartIconListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(SmartIconGridConstants.KEY_HOME_POSITION, i2);
            smartIconListFragment.setArguments(bundle);
            setTickerClickListner(i2);
            return smartIconListFragment;
        }

        public final int getCount() {
            return this.this$0.finalList.size();
        }

        private final void setTickerClickListner(int i2) {
            LinearLayout linearLayout = this.this$0.getDataBinding().tickerLayout;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new SFSmartIconFragment$SmartIconPagerAdapter$setTickerClickListner$1(this, i2));
            }
        }

        /* access modifiers changed from: private */
        public final Item constructItem(String str) {
            Item item = new Item();
            item.setUrlType(UpiConstants.URL_TYPE_CASH_WALLET);
            item.setUrl(str);
            return item;
        }
    }

    public final void setItemClickListner(OnItemClickListner onItemClickListner) {
        this.itemClickListner = onItemClickListner;
    }

    public final ArrayList<Item> getItemList(int i2) {
        return this.finalList.size() > i2 ? this.finalList.get(i2).getMGridItemlist() : new ArrayList<>();
    }

    public final void itemClick(int i2, Item item, int i3) {
        k.c(item, "item");
        if (!isStateSaved()) {
            OnItemClickListner onItemClickListner = this.itemClickListner;
            if (onItemClickListner != null) {
                onItemClickListner.onItemClick(i2, item, i3);
            }
            dismiss();
        }
    }

    public final void showProgressbar(boolean z) {
        SfGridPopupLayoutBinding sfGridPopupLayoutBinding = this.dataBinding;
        if (sfGridPopupLayoutBinding == null) {
            k.a("dataBinding");
        }
        LottieAnimationView lottieAnimationView = sfGridPopupLayoutBinding.progressLottie;
        if (lottieAnimationView == null) {
            return;
        }
        if (z) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.playAnimation();
            return;
        }
        lottieAnimationView.setVisibility(8);
        lottieAnimationView.cancelAnimation();
    }

    public final void onApiSuccess(HomeResponse homeResponse) {
        k.c(homeResponse, "dataModel");
        SFSmartIconFragmentViewModel sFSmartIconFragmentViewModel = this.viewModel;
        if (sFSmartIconFragmentViewModel == null) {
            k.a("viewModel");
        }
        sFSmartIconFragmentViewModel.handleApiResponse(homeResponse).observe(getViewLifecycleOwner(), new SFSmartIconFragment$onApiSuccess$1(this));
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.g.b.g gVar) {
            this();
        }

        private final void addDataInGTMController(Item item, int i2, String str, Context context, String str2, String str3, int i3) {
            String str4;
            Context context2;
            List arrayList = new ArrayList();
            GTMDataController.Companion companion = GTMDataController.Companion;
            String id = item.getId();
            String gaCategory = item.getGaCategory();
            String name = item.getName();
            int parentBindPosition = item.getParentBindPosition() + 1;
            Item.LayoutData layout = item.getLayout();
            TreeMap<String, String> mappedItemsForGA = companion.getMappedItemsForGA(id, str, gaCategory, name, i2, "", parentBindPosition, str2, layout != null ? layout.mLabel : null, i3);
            if (mappedItemsForGA == null) {
                mappedItemsForGA = new TreeMap<>();
            }
            arrayList.add(mappedItemsForGA);
            GTMDataController.Companion companion2 = GTMDataController.Companion;
            if (str3 == null) {
                str4 = "";
                context2 = context;
            } else {
                context2 = context;
                str4 = str3;
            }
            companion2.addToQueue(arrayList, context2, str4);
        }

        public static /* synthetic */ void sendImpressionEvent$default(Companion companion, ArrayList arrayList, Context context, String str, String str2, int i2, String str3, int i3, Object obj) {
            int i4 = (i3 & 16) != 0 ? -1 : i2;
            if ((i3 & 32) != 0) {
                str3 = null;
            }
            companion.sendImpressionEvent(arrayList, context, str, str2, i4, str3);
        }

        public final void sendImpressionEvent(ArrayList<Item> arrayList, Context context, String str, String str2, int i2, String str3) {
            String str4 = str2;
            k.c(context, "context");
            k.c(str4, "name");
            if (arrayList != null) {
                int i3 = 0;
                for (Item item : arrayList) {
                    if (!item.getAddedtoGA().booleanValue()) {
                        Companion companion = SFSmartIconFragment.Companion;
                        String id = item.getId();
                        k.a((Object) id, "item.id");
                        if (companion.isSendImpressionElligible(id, str4)) {
                            item.setParentBindPosition(i2);
                            HomeUtils.d("Impression Fired + " + item.getName(), false);
                            SFSmartIconFragment.Companion.addDataInGTMController(item, i3, str2, context, str == null ? item.getContainerinstatnceid() : str, str3, arrayList.size());
                            item.setAddedtoGA(Boolean.TRUE);
                            Companion companion2 = SFSmartIconFragment.Companion;
                            String id2 = item.getId();
                            k.a((Object) id2, "item.id");
                            companion2.addImpressionDataToCommonMap(id2, str4);
                            i3++;
                        }
                    }
                    int i4 = i2;
                    i3++;
                }
            }
        }

        private final boolean isSendImpressionElligible(String str, String str2) {
            if (CLPConstants.SMART_ICON_LIST_MORE.equals(str2) && CategoryImpressionAndApiHandler.INSTANCE.getShowMoreImpressionsData().contains(str)) {
                return false;
            }
            if (!p.a((CharSequence) str2, (CharSequence) CLPConstants.DRAWER_POSTFIX, false) || !CategoryImpressionAndApiHandler.INSTANCE.getCategoryPopupImpressionsData().contains(str)) {
                return true;
            }
            return false;
        }

        private final void addImpressionDataToCommonMap(String str, String str2) {
            if (CLPConstants.SMART_ICON_LIST_MORE.equals(str2)) {
                CategoryImpressionAndApiHandler.INSTANCE.getShowMoreImpressionsData().add(str);
            } else if (p.a((CharSequence) str2, (CharSequence) CLPConstants.DRAWER_POSTFIX, false)) {
                CategoryImpressionAndApiHandler.INSTANCE.getCategoryPopupImpressionsData().add(str);
            }
        }
    }
}
