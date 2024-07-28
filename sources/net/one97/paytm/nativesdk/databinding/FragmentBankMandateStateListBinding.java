package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class FragmentBankMandateStateListBinding extends ViewDataBinding {
    public final ImageView imgEdtCross;
    public final ImageView imgSearch;
    public final ImageView ivBackArrow;
    public final RecyclerView rvStateList;
    public final EditText searchViewState;
    public final RoboTextView tvToolbarTitle;

    protected FragmentBankMandateStateListBinding(Object obj, View view, int i2, ImageView imageView, ImageView imageView2, ImageView imageView3, RecyclerView recyclerView, EditText editText, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.imgEdtCross = imageView;
        this.imgSearch = imageView2;
        this.ivBackArrow = imageView3;
        this.rvStateList = recyclerView;
        this.searchViewState = editText;
        this.tvToolbarTitle = roboTextView;
    }

    public static FragmentBankMandateStateListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static FragmentBankMandateStateListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentBankMandateStateListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_bank_mandate_state_list, viewGroup, z, obj);
    }

    public static FragmentBankMandateStateListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static FragmentBankMandateStateListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentBankMandateStateListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_bank_mandate_state_list, (ViewGroup) null, false, obj);
    }

    public static FragmentBankMandateStateListBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static FragmentBankMandateStateListBinding bind(View view, Object obj) {
        return (FragmentBankMandateStateListBinding) bind(obj, view, R.layout.fragment_bank_mandate_state_list);
    }
}
