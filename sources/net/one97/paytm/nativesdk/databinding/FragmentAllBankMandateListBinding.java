package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.view.IndexFastScrollRecyclerView;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class FragmentAllBankMandateListBinding extends ViewDataBinding {
    public final ImageView imgEdtCross;
    public final ImageView imgSearch;
    public final ImageView ivBackArrow;
    public final IndexFastScrollRecyclerView rvBankList;
    public final EditText searchView;
    public final RoboTextView tvToolbarTitle;

    protected FragmentAllBankMandateListBinding(Object obj, View view, int i2, ImageView imageView, ImageView imageView2, ImageView imageView3, IndexFastScrollRecyclerView indexFastScrollRecyclerView, EditText editText, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.imgEdtCross = imageView;
        this.imgSearch = imageView2;
        this.ivBackArrow = imageView3;
        this.rvBankList = indexFastScrollRecyclerView;
        this.searchView = editText;
        this.tvToolbarTitle = roboTextView;
    }

    public static FragmentAllBankMandateListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static FragmentAllBankMandateListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentAllBankMandateListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_all_bank_mandate_list, viewGroup, z, obj);
    }

    public static FragmentAllBankMandateListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static FragmentAllBankMandateListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentAllBankMandateListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_all_bank_mandate_list, (ViewGroup) null, false, obj);
    }

    public static FragmentAllBankMandateListBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static FragmentAllBankMandateListBinding bind(View view, Object obj) {
        return (FragmentAllBankMandateListBinding) bind(obj, view, R.layout.fragment_all_bank_mandate_list);
    }
}
