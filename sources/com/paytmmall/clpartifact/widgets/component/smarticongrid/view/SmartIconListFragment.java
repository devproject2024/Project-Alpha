package com.paytmmall.clpartifact.widgets.component.smarticongrid.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.FragmentSmartIconListBinding;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.SmartIconGridConstants;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.viewmodel.SmartIconListViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.h;

public final class SmartIconListFragment extends h {
    private final int GRIDSPANCOUNT = 3;
    private HashMap _$_findViewCache;
    private FragmentSmartIconListBinding binding;
    private ArrayList<Item> itemList;
    private int position;
    public SmartIconListViewModel viewModel;

    public interface ItemListListner {
        ArrayList<Item> getItemList(int i2);

        void itemClick(int i2, Item item, int i3);
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

    public final SmartIconListViewModel getViewModel() {
        SmartIconListViewModel smartIconListViewModel = this.viewModel;
        if (smartIconListViewModel == null) {
            k.a("viewModel");
        }
        return smartIconListViewModel;
    }

    public final void setViewModel(SmartIconListViewModel smartIconListViewModel) {
        k.c(smartIconListViewModel, "<set-?>");
        this.viewModel = smartIconListViewModel;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ai a2 = am.a((Fragment) this).a(SmartIconListViewModel.class);
        k.a((Object) a2, "ViewModelProviders.of(th…istViewModel::class.java)");
        this.viewModel = (SmartIconListViewModel) a2;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        ViewDataBinding a2 = f.a(layoutInflater, R.layout.fragment_smart_icon_list, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate<…n_list, container, false)");
        this.binding = (FragmentSmartIconListBinding) a2;
        FragmentSmartIconListBinding fragmentSmartIconListBinding = this.binding;
        if (fragmentSmartIconListBinding == null) {
            k.a("binding");
        }
        View root = fragmentSmartIconListBinding.getRoot();
        k.a((Object) root, "binding.root");
        return root;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        Bundle arguments = getArguments();
        int i2 = 0;
        if (arguments != null) {
            i2 = arguments.getInt(SmartIconGridConstants.KEY_HOME_POSITION, 0);
        }
        this.position = i2;
        SmartIconListViewModel smartIconListViewModel = this.viewModel;
        if (smartIconListViewModel == null) {
            k.a("viewModel");
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            smartIconListViewModel.setItemListener((ItemListListner) parentFragment);
            SmartIconListViewModel smartIconListViewModel2 = this.viewModel;
            if (smartIconListViewModel2 == null) {
                k.a("viewModel");
            }
            this.itemList = smartIconListViewModel2.getItemList(this.position);
            FragmentSmartIconListBinding fragmentSmartIconListBinding = this.binding;
            if (fragmentSmartIconListBinding == null) {
                k.a("binding");
            }
            RecyclerView recyclerView = fragmentSmartIconListBinding.recyclerViewItem;
            if (recyclerView != null) {
                recyclerView.setHasFixedSize(true);
                Context context = recyclerView.getContext();
                ArrayList<Item> arrayList = this.itemList;
                SmartIconListViewModel smartIconListViewModel3 = this.viewModel;
                if (smartIconListViewModel3 == null) {
                    k.a("viewModel");
                }
                ItemListListner itemListener = smartIconListViewModel3.getItemListener();
                if (itemListener != null) {
                    recyclerView.setAdapter(new SmartIconListAdapter(context, arrayList, itemListener));
                    recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), this.GRIDSPANCOUNT));
                    return;
                }
                throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SmartIconListFragment.ItemListListner");
            }
            return;
        }
        throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SmartIconListFragment.ItemListListner");
    }
}
