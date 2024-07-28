package com.business.merchant_payments.common.view;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.business.merchant_payments.common.fragment.BaseDialogFragment;
import com.business.merchant_payments.databinding.MpCommonOverlayDialogBinding;
import com.business.merchant_payments.widget.MpRoboTextView;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CommonOverlayDialogFragment extends BaseDialogFragment {
    public static final String BUTTON_TXT_BUNDLE = "buttonData";
    public static final Companion Companion = new Companion((g) null);
    public static final String DESCRIPTION_BUNDLE = "descriptionData";
    public static final String TITLE_BUNDLE = "titleData";
    public HashMap _$_findViewCache;
    public MpCommonOverlayDialogBinding binding;
    public final CommonOverlayDialogListener listener;

    public interface CommonOverlayDialogListener {
        void onDialogButtonClick();
    }

    public static final CommonOverlayDialogFragment newInstance(String str, String str2, String str3, CommonOverlayDialogListener commonOverlayDialogListener) {
        return Companion.newInstance(str, str2, str3, commonOverlayDialogListener);
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

    public CommonOverlayDialogFragment(CommonOverlayDialogListener commonOverlayDialogListener) {
        k.d(commonOverlayDialogListener, "listener");
        this.listener = commonOverlayDialogListener;
    }

    public final CommonOverlayDialogListener getListener() {
        return this.listener;
    }

    public final MpCommonOverlayDialogBinding getBinding() {
        MpCommonOverlayDialogBinding mpCommonOverlayDialogBinding = this.binding;
        if (mpCommonOverlayDialogBinding == null) {
            k.a("binding");
        }
        return mpCommonOverlayDialogBinding;
    }

    public final void setBinding(MpCommonOverlayDialogBinding mpCommonOverlayDialogBinding) {
        k.d(mpCommonOverlayDialogBinding, "<set-?>");
        this.binding = mpCommonOverlayDialogBinding;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Window window2;
        k.d(layoutInflater, "inflater");
        MpCommonOverlayDialogBinding inflate = MpCommonOverlayDialogBinding.inflate(layoutInflater, viewGroup, false);
        k.b(inflate, "MpCommonOverlayDialogBin…inflater,container,false)");
        this.binding = inflate;
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            k.a((Object) dialog);
            k.b(dialog, "dialog!!");
            if (dialog.getWindow() != null) {
                Dialog dialog2 = getDialog();
                if (!(dialog2 == null || (window2 = dialog2.getWindow()) == null)) {
                    window2.setBackgroundDrawable(new ColorDrawable(0));
                }
                Dialog dialog3 = getDialog();
                if (!(dialog3 == null || (window = dialog3.getWindow()) == null)) {
                    window.requestFeature(1);
                }
            }
        }
        MpCommonOverlayDialogBinding mpCommonOverlayDialogBinding = this.binding;
        if (mpCommonOverlayDialogBinding == null) {
            k.a("binding");
        }
        return mpCommonOverlayDialogBinding.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.d(view, "view");
        super.onViewCreated(view, bundle);
        MpCommonOverlayDialogBinding mpCommonOverlayDialogBinding = this.binding;
        if (mpCommonOverlayDialogBinding == null) {
            k.a("binding");
        }
        MpRoboTextView mpRoboTextView = mpCommonOverlayDialogBinding.title;
        k.b(mpRoboTextView, "binding.title");
        Bundle arguments = getArguments();
        String str = null;
        mpRoboTextView.setText(arguments != null ? arguments.getString(TITLE_BUNDLE) : null);
        MpCommonOverlayDialogBinding mpCommonOverlayDialogBinding2 = this.binding;
        if (mpCommonOverlayDialogBinding2 == null) {
            k.a("binding");
        }
        MpRoboTextView mpRoboTextView2 = mpCommonOverlayDialogBinding2.description;
        k.b(mpRoboTextView2, "binding.description");
        Bundle arguments2 = getArguments();
        mpRoboTextView2.setText(arguments2 != null ? arguments2.getString(DESCRIPTION_BUNDLE) : null);
        MpCommonOverlayDialogBinding mpCommonOverlayDialogBinding3 = this.binding;
        if (mpCommonOverlayDialogBinding3 == null) {
            k.a("binding");
        }
        MpRoboTextView mpRoboTextView3 = mpCommonOverlayDialogBinding3.btnTxt;
        k.b(mpRoboTextView3, "binding.btnTxt");
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str = arguments3.getString(BUTTON_TXT_BUNDLE);
        }
        mpRoboTextView3.setText(str);
        MpCommonOverlayDialogBinding mpCommonOverlayDialogBinding4 = this.binding;
        if (mpCommonOverlayDialogBinding4 == null) {
            k.a("binding");
        }
        mpCommonOverlayDialogBinding4.btnTxt.setOnClickListener(new CommonOverlayDialogFragment$onViewCreated$1(this));
        MpCommonOverlayDialogBinding mpCommonOverlayDialogBinding5 = this.binding;
        if (mpCommonOverlayDialogBinding5 == null) {
            k.a("binding");
        }
        mpCommonOverlayDialogBinding5.crossBtn.setOnClickListener(new CommonOverlayDialogFragment$onViewCreated$2(this));
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final CommonOverlayDialogFragment newInstance(String str, String str2, String str3, CommonOverlayDialogListener commonOverlayDialogListener) {
            k.d(str, "title");
            k.d(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            k.d(str3, "buttonTxt");
            k.d(commonOverlayDialogListener, "listener");
            CommonOverlayDialogFragment commonOverlayDialogFragment = new CommonOverlayDialogFragment(commonOverlayDialogListener);
            Bundle bundle = new Bundle();
            bundle.putString(CommonOverlayDialogFragment.TITLE_BUNDLE, str);
            bundle.putString(CommonOverlayDialogFragment.DESCRIPTION_BUNDLE, str2);
            bundle.putString(CommonOverlayDialogFragment.BUTTON_TXT_BUNDLE, str3);
            commonOverlayDialogFragment.setArguments(bundle);
            return commonOverlayDialogFragment;
        }
    }
}
