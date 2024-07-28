package com.business.merchant_payments.common;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.listener.ChangeBankListener;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CommonConfirmationBottomSheet extends CustomBottomSheetDialogFragment {
    public static final String BUTTON_TEXT = "BUTTON_TEXT";
    public static final String COLOR_FILTER = "COLOR_FILTER";
    public static final Companion Companion = new Companion((g) null);
    public static final String DRAWABLE = "DRAWABLE";
    public static final String HEADER = "HEADER";
    public static final String SUB_HEADER = "SUB_HEADER";
    public HashMap _$_findViewCache;
    public String buttonText;
    public Integer color;
    public Integer drawable;
    public String headerText;
    public ChangeBankListener listener;
    public String subHeaderText;
    public Integer subHeadingFontColor;
    public Typeface subHeadingFontFace;

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

    public final Typeface getSubHeadingFontFace() {
        return this.subHeadingFontFace;
    }

    public final void setSubHeadingFontFace(Typeface typeface) {
        this.subHeadingFontFace = typeface;
    }

    public final Integer getSubHeadingFontColor() {
        return this.subHeadingFontColor;
    }

    public final void setSubHeadingFontColor(Integer num) {
        this.subHeadingFontColor = num;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Integer num = null;
        this.headerText = arguments != null ? arguments.getString("HEADER") : null;
        this.subHeaderText = arguments != null ? arguments.getString(SUB_HEADER) : null;
        this.buttonText = arguments != null ? arguments.getString(BUTTON_TEXT) : null;
        this.drawable = arguments != null ? Integer.valueOf(arguments.getInt(DRAWABLE)) : null;
        if (arguments != null) {
            num = Integer.valueOf(arguments.getInt(COLOR_FILTER));
        }
        this.color = num;
    }

    public final void setListener(ChangeBankListener changeBankListener) {
        k.d(changeBankListener, "listener");
        this.listener = changeBankListener;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.mp_common_confirmation_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.d(view, "view");
        super.onViewCreated(view, bundle);
        CustomTextView customTextView = (CustomTextView) view.findViewById(R.id.tvHeader);
        k.b(customTextView, "tvHeader");
        customTextView.setText(this.headerText);
        if (!TextUtils.isEmpty(this.subHeaderText)) {
            CustomTextView customTextView2 = (CustomTextView) view.findViewById(R.id.tvSubHeader);
            k.b(customTextView2, "tvSubHeader");
            customTextView2.setVisibility(0);
            CustomTextView customTextView3 = (CustomTextView) view.findViewById(R.id.tvSubHeader);
            k.b(customTextView3, "tvSubHeader");
            customTextView3.setText(this.subHeaderText);
        } else {
            CustomTextView customTextView4 = (CustomTextView) view.findViewById(R.id.tvSubHeader);
            k.b(customTextView4, "tvSubHeader");
            customTextView4.setVisibility(8);
        }
        if (this.subHeadingFontFace != null) {
            CustomTextView customTextView5 = (CustomTextView) view.findViewById(R.id.tvSubHeader);
            k.b(customTextView5, "tvSubHeader");
            customTextView5.setTypeface(this.subHeadingFontFace);
        }
        if (this.subHeadingFontColor != null) {
            Integer num = this.subHeadingFontColor;
            k.a((Object) num);
            ((CustomTextView) view.findViewById(R.id.tvSubHeader)).setTextColor(num.intValue());
        }
        if (!TextUtils.isEmpty(this.buttonText)) {
            CustomTextView customTextView6 = (CustomTextView) view.findViewById(R.id.btnGo);
            k.b(customTextView6, "btnGo");
            customTextView6.setVisibility(0);
            CustomTextView customTextView7 = (CustomTextView) view.findViewById(R.id.btnGo);
            k.b(customTextView7, "btnGo");
            customTextView7.setText(this.buttonText);
        } else {
            CustomTextView customTextView8 = (CustomTextView) view.findViewById(R.id.btnGo);
            k.b(customTextView8, "btnGo");
            customTextView8.setVisibility(8);
        }
        Integer num2 = this.drawable;
        if (num2 == null || num2.intValue() != Integer.MIN_VALUE) {
            ImageView imageView = (ImageView) view.findViewById(R.id.ivTopRight);
            k.b(imageView, "ivTopRight");
            imageView.setVisibility(0);
            Integer num3 = this.drawable;
            k.a((Object) num3);
            ((ImageView) view.findViewById(R.id.ivTopRight)).setImageResource(num3.intValue());
        }
        ((CustomTextView) view.findViewById(R.id.btnGo)).setOnClickListener(new CommonConfirmationBottomSheet$onViewCreated$$inlined$apply$lambda$1(this));
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final CommonConfirmationBottomSheet getInstance(String str, String str2, String str3, Integer num, Integer num2) {
            CommonConfirmationBottomSheet commonConfirmationBottomSheet = new CommonConfirmationBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString("HEADER", str);
            bundle.putString(CommonConfirmationBottomSheet.SUB_HEADER, str2);
            bundle.putString(CommonConfirmationBottomSheet.BUTTON_TEXT, str3);
            int i2 = Integer.MIN_VALUE;
            bundle.putInt(CommonConfirmationBottomSheet.DRAWABLE, num != null ? num.intValue() : Integer.MIN_VALUE);
            if (num2 != null) {
                i2 = num2.intValue();
            }
            bundle.putInt(CommonConfirmationBottomSheet.COLOR_FILTER, i2);
            commonConfirmationBottomSheet.setArguments(bundle);
            return commonConfirmationBottomSheet;
        }
    }
}
