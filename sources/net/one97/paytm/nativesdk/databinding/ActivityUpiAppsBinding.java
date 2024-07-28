package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.AllNetBankingListViewModel;

public abstract class ActivityUpiAppsBinding extends ViewDataBinding {
    public final ImageView imgEdtCross;
    public final ImageView imgSearch;
    public final ImageView ivBackArrow;
    public final View listEmptyLayoutContainer;
    protected AllNetBankingListViewModel mAllNetBankingViewModel;
    public final RecyclerView rvAppsList;
    public final EditText searchView;
    public final TextView tvToolbarTitle;

    public abstract void setAllNetBankingViewModel(AllNetBankingListViewModel allNetBankingListViewModel);

    protected ActivityUpiAppsBinding(Object obj, View view, int i2, ImageView imageView, ImageView imageView2, ImageView imageView3, View view2, RecyclerView recyclerView, EditText editText, TextView textView) {
        super(obj, view, i2);
        this.imgEdtCross = imageView;
        this.imgSearch = imageView2;
        this.ivBackArrow = imageView3;
        this.listEmptyLayoutContainer = view2;
        this.rvAppsList = recyclerView;
        this.searchView = editText;
        this.tvToolbarTitle = textView;
    }

    public AllNetBankingListViewModel getAllNetBankingViewModel() {
        return this.mAllNetBankingViewModel;
    }

    public static ActivityUpiAppsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static ActivityUpiAppsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityUpiAppsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_upi_apps, viewGroup, z, obj);
    }

    public static ActivityUpiAppsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static ActivityUpiAppsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityUpiAppsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_upi_apps, (ViewGroup) null, false, obj);
    }

    public static ActivityUpiAppsBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static ActivityUpiAppsBinding bind(View view, Object obj) {
        return (ActivityUpiAppsBinding) bind(obj, view, R.layout.activity_upi_apps);
    }
}
