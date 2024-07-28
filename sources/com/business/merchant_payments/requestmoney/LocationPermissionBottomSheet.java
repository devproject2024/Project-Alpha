package com.business.merchant_payments.requestmoney;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class LocationPermissionBottomSheet extends CustomBottomSheetDialogFragment {
    public HashMap _$_findViewCache;
    public CustomTextView buttonAllow;
    public IShowLocationPrompt iShowLocationPrompt;
    public View mLayoutView;

    public interface IShowLocationPrompt {
        void showLocationPrompt();
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

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.mp_location_permission_bottomsheet, viewGroup, false);
        this.mLayoutView = inflate;
        return inflate;
    }

    public final void onActivityCreated(Bundle bundle) {
        View view;
        TextView textView;
        super.onActivityCreated(bundle);
        initUI();
        Bundle arguments = getArguments();
        String str = null;
        if (!((arguments != null ? arguments.getString(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX) : null) == null || (view = this.mLayoutView) == null || (textView = (TextView) view.findViewById(R.id.pfbTextView_msg)) == null)) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            }
            textView.setText(str);
        }
        setOnClickListeners();
    }

    public final void onAttach(Context context) {
        k.d(context, "context");
        super.onAttach(context);
        Fragment c2 = ((FragmentActivity) context).getSupportFragmentManager().c(R.id.fragment_container);
        if (c2 instanceof PaymentLinkFragment) {
            this.iShowLocationPrompt = (IShowLocationPrompt) c2;
        }
    }

    private final void initUI() {
        CustomTextView customTextView = (CustomTextView) _$_findCachedViewById(R.id.allow_button);
        k.b(customTextView, "allow_button");
        this.buttonAllow = customTextView;
    }

    private final void setOnClickListeners() {
        CustomTextView customTextView = this.buttonAllow;
        if (customTextView == null) {
            k.a("buttonAllow");
        }
        customTextView.setOnClickListener(new LocationPermissionBottomSheet$setOnClickListeners$1(this));
    }

    /* access modifiers changed from: private */
    public final void showLocationPrompt() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        FragmentActivity activity = getActivity();
        intent.setData(Uri.fromParts("package", activity != null ? activity.getPackageName() : null, (String) null));
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.startActivity(intent);
        }
    }
}
