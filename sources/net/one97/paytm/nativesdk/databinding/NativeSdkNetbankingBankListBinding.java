package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.AllNetBankingListViewModel;

public abstract class NativeSdkNetbankingBankListBinding extends ViewDataBinding {
    public final ImageView imgEdtCross;
    public final ImageView imgSearch;
    public final ImageView ivBackArrow;
    public final View listEmptyLayoutContainer;
    protected AllNetBankingListViewModel mAllNetBankingViewModel;
    public final ProgressBar pbProgress;
    public final IndexFastScrollRecyclerView rvBankList;
    public final EditText searchView;
    public final TextView tvToolbarTitle;

    public abstract void setAllNetBankingViewModel(AllNetBankingListViewModel allNetBankingListViewModel);

    protected NativeSdkNetbankingBankListBinding(Object obj, View view, int i2, ImageView imageView, ImageView imageView2, ImageView imageView3, View view2, ProgressBar progressBar, IndexFastScrollRecyclerView indexFastScrollRecyclerView, EditText editText, TextView textView) {
        super(obj, view, i2);
        this.imgEdtCross = imageView;
        this.imgSearch = imageView2;
        this.ivBackArrow = imageView3;
        this.listEmptyLayoutContainer = view2;
        this.pbProgress = progressBar;
        this.rvBankList = indexFastScrollRecyclerView;
        this.searchView = editText;
        this.tvToolbarTitle = textView;
    }

    public AllNetBankingListViewModel getAllNetBankingViewModel() {
        return this.mAllNetBankingViewModel;
    }

    public static NativeSdkNetbankingBankListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativeSdkNetbankingBankListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativeSdkNetbankingBankListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.native_sdk_netbanking_bank_list, viewGroup, z, obj);
    }

    public static NativeSdkNetbankingBankListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativeSdkNetbankingBankListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativeSdkNetbankingBankListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.native_sdk_netbanking_bank_list, (ViewGroup) null, false, obj);
    }

    public static NativeSdkNetbankingBankListBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativeSdkNetbankingBankListBinding bind(View view, Object obj) {
        return (NativeSdkNetbankingBankListBinding) bind(obj, view, R.layout.native_sdk_netbanking_bank_list);
    }
}
