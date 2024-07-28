package com.business.merchant_payments.common.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import com.business.common_module.view.widget.CustomTextInputEditText;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class OtpEditBoxesCommonFragment extends h {
    public HashMap _$_findViewCache;
    public int index = 1;
    public MpFragmentOtpEditboxesLytBinding mLayoutBinding;
    public final OtpEditBoxesCommonFragment$onKeyListener$1 onKeyListener = new OtpEditBoxesCommonFragment$onKeyListener$1(this);
    public final OtpEditBoxesCommonFragment$passcodeChange$1 passcodeChange = new OtpEditBoxesCommonFragment$passcodeChange$1(this);

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

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        MpFragmentOtpEditboxesLytBinding inflate = MpFragmentOtpEditboxesLytBinding.inflate(layoutInflater, viewGroup, false);
        this.mLayoutBinding = inflate;
        if (inflate != null) {
            return inflate.getRoot();
        }
        return null;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        CustomTextInputEditText customTextInputEditText;
        CustomTextInputEditText customTextInputEditText2;
        CustomTextInputEditText customTextInputEditText3;
        CustomTextInputEditText customTextInputEditText4;
        CustomTextInputEditText customTextInputEditText5;
        CustomTextInputEditText customTextInputEditText6;
        CustomTextInputEditText customTextInputEditText7;
        CustomTextInputEditText customTextInputEditText8;
        CustomTextInputEditText customTextInputEditText9;
        CustomTextInputEditText customTextInputEditText10;
        CustomTextInputEditText customTextInputEditText11;
        CustomTextInputEditText customTextInputEditText12;
        CustomTextInputEditText customTextInputEditText13;
        k.d(view, "view");
        super.onViewCreated(view, bundle);
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding == null || (customTextInputEditText13 = mpFragmentOtpEditboxesLytBinding.editOtpChar1) == null)) {
            customTextInputEditText13.addTextChangedListener(this.passcodeChange);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding2 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding2 == null || (customTextInputEditText12 = mpFragmentOtpEditboxesLytBinding2.editOtpChar2) == null)) {
            customTextInputEditText12.addTextChangedListener(this.passcodeChange);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding3 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding3 == null || (customTextInputEditText11 = mpFragmentOtpEditboxesLytBinding3.editOtpChar3) == null)) {
            customTextInputEditText11.addTextChangedListener(this.passcodeChange);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding4 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding4 == null || (customTextInputEditText10 = mpFragmentOtpEditboxesLytBinding4.editOtpChar4) == null)) {
            customTextInputEditText10.addTextChangedListener(this.passcodeChange);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding5 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding5 == null || (customTextInputEditText9 = mpFragmentOtpEditboxesLytBinding5.editOtpChar5) == null)) {
            customTextInputEditText9.addTextChangedListener(this.passcodeChange);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding6 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding6 == null || (customTextInputEditText8 = mpFragmentOtpEditboxesLytBinding6.editOtpChar6) == null)) {
            customTextInputEditText8.addTextChangedListener(this.passcodeChange);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding7 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding7 == null || (customTextInputEditText7 = mpFragmentOtpEditboxesLytBinding7.editOtpChar1) == null)) {
            customTextInputEditText7.setOnKeyListener(this.onKeyListener);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding8 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding8 == null || (customTextInputEditText6 = mpFragmentOtpEditboxesLytBinding8.editOtpChar2) == null)) {
            customTextInputEditText6.setOnKeyListener(this.onKeyListener);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding9 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding9 == null || (customTextInputEditText5 = mpFragmentOtpEditboxesLytBinding9.editOtpChar3) == null)) {
            customTextInputEditText5.setOnKeyListener(this.onKeyListener);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding10 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding10 == null || (customTextInputEditText4 = mpFragmentOtpEditboxesLytBinding10.editOtpChar4) == null)) {
            customTextInputEditText4.setOnKeyListener(this.onKeyListener);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding11 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding11 == null || (customTextInputEditText3 = mpFragmentOtpEditboxesLytBinding11.editOtpChar5) == null)) {
            customTextInputEditText3.setOnKeyListener(this.onKeyListener);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding12 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding12 == null || (customTextInputEditText2 = mpFragmentOtpEditboxesLytBinding12.editOtpChar6) == null)) {
            customTextInputEditText2.setOnKeyListener(this.onKeyListener);
        }
        MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding13 = this.mLayoutBinding;
        if (!(mpFragmentOtpEditboxesLytBinding13 == null || (customTextInputEditText = mpFragmentOtpEditboxesLytBinding13.editOtpChar1) == null)) {
            customTextInputEditText.requestFocus();
        }
        this.index = 1;
        setBlueBackground(1);
    }

    public final void onStart() {
        super.onStart();
        setFocus(this.index);
    }

    private final void setFocus(int i2) {
        CustomTextInputEditText customTextInputEditText;
        CustomTextInputEditText customTextInputEditText2;
        CustomTextInputEditText customTextInputEditText3;
        CustomTextInputEditText customTextInputEditText4;
        CustomTextInputEditText customTextInputEditText5;
        CustomTextInputEditText customTextInputEditText6;
        CustomTextInputEditText customTextInputEditText7;
        CustomTextInputEditText customTextInputEditText8;
        CustomTextInputEditText customTextInputEditText9;
        CustomTextInputEditText customTextInputEditText10;
        CustomTextInputEditText customTextInputEditText11;
        CustomTextInputEditText customTextInputEditText12;
        CustomTextInputEditText customTextInputEditText13;
        CustomTextInputEditText customTextInputEditText14;
        CustomTextInputEditText customTextInputEditText15;
        if (getView() == null) {
            return;
        }
        if (i2 == 1) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding == null || (customTextInputEditText15 = mpFragmentOtpEditboxesLytBinding.editOtpChar1) == null)) {
                customTextInputEditText15.requestFocus();
            }
            setBlueBackground(1);
        } else if (i2 == 2) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding2 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding2 == null || (customTextInputEditText14 = mpFragmentOtpEditboxesLytBinding2.editOtpChar2) == null)) {
                customTextInputEditText14.requestFocus();
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding3 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding3 == null || (customTextInputEditText13 = mpFragmentOtpEditboxesLytBinding3.editOtpChar1) == null)) {
                customTextInputEditText13.setEnabled(false);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding4 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding4 == null || (customTextInputEditText12 = mpFragmentOtpEditboxesLytBinding4.editOtpChar3) == null)) {
                customTextInputEditText12.setEnabled(true);
            }
            setBlueBackground(2);
        } else if (i2 == 3) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding5 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding5 == null || (customTextInputEditText11 = mpFragmentOtpEditboxesLytBinding5.editOtpChar3) == null)) {
                customTextInputEditText11.requestFocus();
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding6 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding6 == null || (customTextInputEditText10 = mpFragmentOtpEditboxesLytBinding6.editOtpChar2) == null)) {
                customTextInputEditText10.setEnabled(false);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding7 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding7 == null || (customTextInputEditText9 = mpFragmentOtpEditboxesLytBinding7.editOtpChar4) == null)) {
                customTextInputEditText9.setEnabled(true);
            }
            setBlueBackground(3);
        } else if (i2 == 4) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding8 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding8 == null || (customTextInputEditText8 = mpFragmentOtpEditboxesLytBinding8.editOtpChar4) == null)) {
                customTextInputEditText8.requestFocus();
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding9 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding9 == null || (customTextInputEditText7 = mpFragmentOtpEditboxesLytBinding9.editOtpChar3) == null)) {
                customTextInputEditText7.setEnabled(false);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding10 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding10 == null || (customTextInputEditText6 = mpFragmentOtpEditboxesLytBinding10.editOtpChar5) == null)) {
                customTextInputEditText6.setEnabled(true);
            }
            setBlueBackground(4);
        } else if (i2 == 5) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding11 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding11 == null || (customTextInputEditText5 = mpFragmentOtpEditboxesLytBinding11.editOtpChar5) == null)) {
                customTextInputEditText5.requestFocus();
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding12 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding12 == null || (customTextInputEditText4 = mpFragmentOtpEditboxesLytBinding12.editOtpChar4) == null)) {
                customTextInputEditText4.setEnabled(false);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding13 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding13 == null || (customTextInputEditText3 = mpFragmentOtpEditboxesLytBinding13.editOtpChar6) == null)) {
                customTextInputEditText3.setEnabled(true);
            }
            setBlueBackground(5);
        } else if (i2 == 6) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding14 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding14 == null || (customTextInputEditText2 = mpFragmentOtpEditboxesLytBinding14.editOtpChar6) == null)) {
                customTextInputEditText2.requestFocus();
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding15 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding15 == null || (customTextInputEditText = mpFragmentOtpEditboxesLytBinding15.editOtpChar5) == null)) {
                customTextInputEditText.setEnabled(false);
            }
            setBlueBackground(6);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r1 = r1.editOtpChar1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getOtpCombined() {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            boolean r1 = r3.checkValidation()
            if (r1 == 0) goto L_0x0090
            android.view.View r1 = r3.getView()
            if (r1 == 0) goto L_0x0090
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
            r2 = 0
            if (r1 == 0) goto L_0x0021
            com.business.common_module.view.widget.CustomTextInputEditText r1 = r1.editOtpChar1
            if (r1 == 0) goto L_0x0021
            android.text.Editable r1 = r1.getText()
            goto L_0x0022
        L_0x0021:
            r1 = r2
        L_0x0022:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.append(r1)
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
            if (r1 == 0) goto L_0x0036
            com.business.common_module.view.widget.CustomTextInputEditText r1 = r1.editOtpChar2
            if (r1 == 0) goto L_0x0036
            android.text.Editable r1 = r1.getText()
            goto L_0x0037
        L_0x0036:
            r1 = r2
        L_0x0037:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.append(r1)
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
            if (r1 == 0) goto L_0x004b
            com.business.common_module.view.widget.CustomTextInputEditText r1 = r1.editOtpChar3
            if (r1 == 0) goto L_0x004b
            android.text.Editable r1 = r1.getText()
            goto L_0x004c
        L_0x004b:
            r1 = r2
        L_0x004c:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.append(r1)
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
            if (r1 == 0) goto L_0x0060
            com.business.common_module.view.widget.CustomTextInputEditText r1 = r1.editOtpChar4
            if (r1 == 0) goto L_0x0060
            android.text.Editable r1 = r1.getText()
            goto L_0x0061
        L_0x0060:
            r1 = r2
        L_0x0061:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.append(r1)
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
            if (r1 == 0) goto L_0x0075
            com.business.common_module.view.widget.CustomTextInputEditText r1 = r1.editOtpChar5
            if (r1 == 0) goto L_0x0075
            android.text.Editable r1 = r1.getText()
            goto L_0x0076
        L_0x0075:
            r1 = r2
        L_0x0076:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.append(r1)
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
            if (r1 == 0) goto L_0x0089
            com.business.common_module.view.widget.CustomTextInputEditText r1 = r1.editOtpChar6
            if (r1 == 0) goto L_0x0089
            android.text.Editable r2 = r1.getText()
        L_0x0089:
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r0.append(r1)
        L_0x0090:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.common.fragment.OtpEditBoxesCommonFragment.getOtpCombined():java.lang.String");
    }

    public final void setOtpCombined(String str) {
        CustomTextInputEditText customTextInputEditText;
        CustomTextInputEditText customTextInputEditText2;
        CustomTextInputEditText customTextInputEditText3;
        CustomTextInputEditText customTextInputEditText4;
        CustomTextInputEditText customTextInputEditText5;
        CustomTextInputEditText customTextInputEditText6;
        k.d(str, "otp");
        if (!TextUtils.isEmpty(str) && str.length() == 6) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding == null || (customTextInputEditText6 = mpFragmentOtpEditboxesLytBinding.editOtpChar1) == null)) {
                customTextInputEditText6.setText(String.valueOf(str.charAt(0)));
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding2 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding2 == null || (customTextInputEditText5 = mpFragmentOtpEditboxesLytBinding2.editOtpChar2) == null)) {
                customTextInputEditText5.setText(String.valueOf(str.charAt(1)));
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding3 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding3 == null || (customTextInputEditText4 = mpFragmentOtpEditboxesLytBinding3.editOtpChar3) == null)) {
                customTextInputEditText4.setText(String.valueOf(str.charAt(2)));
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding4 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding4 == null || (customTextInputEditText3 = mpFragmentOtpEditboxesLytBinding4.editOtpChar4) == null)) {
                customTextInputEditText3.setText(String.valueOf(str.charAt(3)));
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding5 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding5 == null || (customTextInputEditText2 = mpFragmentOtpEditboxesLytBinding5.editOtpChar5) == null)) {
                customTextInputEditText2.setText(String.valueOf(str.charAt(4)));
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding6 = this.mLayoutBinding;
            if (mpFragmentOtpEditboxesLytBinding6 != null && (customTextInputEditText = mpFragmentOtpEditboxesLytBinding6.editOtpChar6) != null) {
                customTextInputEditText.setText(String.valueOf(str.charAt(5)));
            }
        }
    }

    public final void setOtpError(String str) {
        k.d(str, "errorMsg");
        CustomTextView customTextView = (CustomTextView) _$_findCachedViewById(R.id.error_otp_tv);
        k.b(customTextView, "error_otp_tv");
        customTextView.setVisibility(0);
        ((CustomTextView) _$_findCachedViewById(R.id.error_otp_tv)).setText(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = r0.editOtpChar1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean checkValidation() {
        /*
            r3 = this;
            android.view.View r0 = r3.getView()
            if (r0 == 0) goto L_0x00c6
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            r1 = 0
            if (r0 == 0) goto L_0x0014
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r0.editOtpChar1
            if (r0 == 0) goto L_0x0014
            android.text.Editable r0 = r0.getText()
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r0 == 0) goto L_0x0028
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0027
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x0027
            r0.setVisibility(r2)
        L_0x0027:
            return r2
        L_0x0028:
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0035
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r0.editOtpChar2
            if (r0 == 0) goto L_0x0035
            android.text.Editable r0 = r0.getText()
            goto L_0x0036
        L_0x0035:
            r0 = r1
        L_0x0036:
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0048
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0047
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x0047
            r0.setVisibility(r2)
        L_0x0047:
            return r2
        L_0x0048:
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0055
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r0.editOtpChar3
            if (r0 == 0) goto L_0x0055
            android.text.Editable r0 = r0.getText()
            goto L_0x0056
        L_0x0055:
            r0 = r1
        L_0x0056:
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0068
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0067
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x0067
            r0.setVisibility(r2)
        L_0x0067:
            return r2
        L_0x0068:
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0075
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r0.editOtpChar4
            if (r0 == 0) goto L_0x0075
            android.text.Editable r0 = r0.getText()
            goto L_0x0076
        L_0x0075:
            r0 = r1
        L_0x0076:
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0088
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0087
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x0087
            r0.setVisibility(r2)
        L_0x0087:
            return r2
        L_0x0088:
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0095
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r0.editOtpChar5
            if (r0 == 0) goto L_0x0095
            android.text.Editable r0 = r0.getText()
            goto L_0x0096
        L_0x0095:
            r0 = r1
        L_0x0096:
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00a8
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x00a7
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x00a7
            r0.setVisibility(r2)
        L_0x00a7:
            return r2
        L_0x00a8:
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x00b4
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r0.editOtpChar6
            if (r0 == 0) goto L_0x00b4
            android.text.Editable r1 = r0.getText()
        L_0x00b4:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L_0x00c6
            com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x00c5
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x00c5
            r0.setVisibility(r2)
        L_0x00c5:
            return r2
        L_0x00c6:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.common.fragment.OtpEditBoxesCommonFragment.checkValidation():boolean");
    }

    /* access modifiers changed from: private */
    public final boolean handleDeleteKey(EditText editText, EditText editText2) {
        if (!String.valueOf(editText != null ? editText.getText() : null).equals("")) {
            if (editText != null) {
                editText.setText("");
            }
            return true;
        }
        if (editText2 != null) {
            editText2.setText("");
            editText2.setEnabled(true);
            editText2.requestFocus();
        }
        return true;
    }

    public final void setBlueBackground(int i2) {
        CustomTextInputEditText customTextInputEditText;
        CustomTextInputEditText customTextInputEditText2;
        CustomTextInputEditText customTextInputEditText3;
        CustomTextInputEditText customTextInputEditText4;
        CustomTextInputEditText customTextInputEditText5;
        CustomTextInputEditText customTextInputEditText6;
        CustomTextInputEditText customTextInputEditText7;
        CustomTextInputEditText customTextInputEditText8;
        CustomTextInputEditText customTextInputEditText9;
        CustomTextInputEditText customTextInputEditText10;
        CustomTextInputEditText customTextInputEditText11;
        CustomTextInputEditText customTextInputEditText12;
        CustomTextInputEditText customTextInputEditText13;
        CustomTextInputEditText customTextInputEditText14;
        CustomTextInputEditText customTextInputEditText15;
        CustomTextInputEditText customTextInputEditText16;
        CustomTextInputEditText customTextInputEditText17;
        CustomTextInputEditText customTextInputEditText18;
        CustomTextInputEditText customTextInputEditText19;
        CustomTextInputEditText customTextInputEditText20;
        CustomTextInputEditText customTextInputEditText21;
        CustomTextInputEditText customTextInputEditText22;
        CustomTextInputEditText customTextInputEditText23;
        CustomTextInputEditText customTextInputEditText24;
        CustomTextInputEditText customTextInputEditText25;
        CustomTextInputEditText customTextInputEditText26;
        CustomTextInputEditText customTextInputEditText27;
        CustomTextInputEditText customTextInputEditText28;
        CustomTextInputEditText customTextInputEditText29;
        CustomTextInputEditText customTextInputEditText30;
        CustomTextInputEditText customTextInputEditText31;
        CustomTextInputEditText customTextInputEditText32;
        CustomTextInputEditText customTextInputEditText33;
        CustomTextInputEditText customTextInputEditText34;
        CustomTextInputEditText customTextInputEditText35;
        CustomTextInputEditText customTextInputEditText36;
        int i3 = R.drawable.mp_otp_boxes_selector_blue;
        int i4 = R.drawable.mp_otp_boxes_selector;
        FragmentActivity activity = getActivity();
        k.a((Object) activity);
        Drawable a2 = b.a((Context) activity, i3);
        FragmentActivity activity2 = getActivity();
        k.a((Object) activity2);
        Drawable a3 = b.a((Context) activity2, i4);
        if (getView() == null) {
            return;
        }
        if (i2 == 1) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding == null || (customTextInputEditText36 = mpFragmentOtpEditboxesLytBinding.editOtpChar1) == null)) {
                customTextInputEditText36.setBackground(a2);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding2 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding2 == null || (customTextInputEditText35 = mpFragmentOtpEditboxesLytBinding2.editOtpChar2) == null)) {
                customTextInputEditText35.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding3 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding3 == null || (customTextInputEditText34 = mpFragmentOtpEditboxesLytBinding3.editOtpChar3) == null)) {
                customTextInputEditText34.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding4 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding4 == null || (customTextInputEditText33 = mpFragmentOtpEditboxesLytBinding4.editOtpChar4) == null)) {
                customTextInputEditText33.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding5 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding5 == null || (customTextInputEditText32 = mpFragmentOtpEditboxesLytBinding5.editOtpChar5) == null)) {
                customTextInputEditText32.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding6 = this.mLayoutBinding;
            if (mpFragmentOtpEditboxesLytBinding6 != null && (customTextInputEditText31 = mpFragmentOtpEditboxesLytBinding6.editOtpChar6) != null) {
                customTextInputEditText31.setBackground(a3);
            }
        } else if (i2 == 2) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding7 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding7 == null || (customTextInputEditText30 = mpFragmentOtpEditboxesLytBinding7.editOtpChar1) == null)) {
                customTextInputEditText30.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding8 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding8 == null || (customTextInputEditText29 = mpFragmentOtpEditboxesLytBinding8.editOtpChar2) == null)) {
                customTextInputEditText29.setBackground(a2);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding9 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding9 == null || (customTextInputEditText28 = mpFragmentOtpEditboxesLytBinding9.editOtpChar3) == null)) {
                customTextInputEditText28.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding10 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding10 == null || (customTextInputEditText27 = mpFragmentOtpEditboxesLytBinding10.editOtpChar4) == null)) {
                customTextInputEditText27.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding11 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding11 == null || (customTextInputEditText26 = mpFragmentOtpEditboxesLytBinding11.editOtpChar5) == null)) {
                customTextInputEditText26.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding12 = this.mLayoutBinding;
            if (mpFragmentOtpEditboxesLytBinding12 != null && (customTextInputEditText25 = mpFragmentOtpEditboxesLytBinding12.editOtpChar6) != null) {
                customTextInputEditText25.setBackground(a3);
            }
        } else if (i2 == 3) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding13 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding13 == null || (customTextInputEditText24 = mpFragmentOtpEditboxesLytBinding13.editOtpChar1) == null)) {
                customTextInputEditText24.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding14 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding14 == null || (customTextInputEditText23 = mpFragmentOtpEditboxesLytBinding14.editOtpChar2) == null)) {
                customTextInputEditText23.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding15 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding15 == null || (customTextInputEditText22 = mpFragmentOtpEditboxesLytBinding15.editOtpChar3) == null)) {
                customTextInputEditText22.setBackground(a2);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding16 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding16 == null || (customTextInputEditText21 = mpFragmentOtpEditboxesLytBinding16.editOtpChar4) == null)) {
                customTextInputEditText21.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding17 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding17 == null || (customTextInputEditText20 = mpFragmentOtpEditboxesLytBinding17.editOtpChar5) == null)) {
                customTextInputEditText20.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding18 = this.mLayoutBinding;
            if (mpFragmentOtpEditboxesLytBinding18 != null && (customTextInputEditText19 = mpFragmentOtpEditboxesLytBinding18.editOtpChar6) != null) {
                customTextInputEditText19.setBackground(a3);
            }
        } else if (i2 == 4) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding19 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding19 == null || (customTextInputEditText18 = mpFragmentOtpEditboxesLytBinding19.editOtpChar1) == null)) {
                customTextInputEditText18.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding20 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding20 == null || (customTextInputEditText17 = mpFragmentOtpEditboxesLytBinding20.editOtpChar2) == null)) {
                customTextInputEditText17.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding21 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding21 == null || (customTextInputEditText16 = mpFragmentOtpEditboxesLytBinding21.editOtpChar3) == null)) {
                customTextInputEditText16.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding22 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding22 == null || (customTextInputEditText15 = mpFragmentOtpEditboxesLytBinding22.editOtpChar4) == null)) {
                customTextInputEditText15.setBackground(a2);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding23 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding23 == null || (customTextInputEditText14 = mpFragmentOtpEditboxesLytBinding23.editOtpChar5) == null)) {
                customTextInputEditText14.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding24 = this.mLayoutBinding;
            if (mpFragmentOtpEditboxesLytBinding24 != null && (customTextInputEditText13 = mpFragmentOtpEditboxesLytBinding24.editOtpChar6) != null) {
                customTextInputEditText13.setBackground(a3);
            }
        } else if (i2 == 5) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding25 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding25 == null || (customTextInputEditText12 = mpFragmentOtpEditboxesLytBinding25.editOtpChar1) == null)) {
                customTextInputEditText12.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding26 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding26 == null || (customTextInputEditText11 = mpFragmentOtpEditboxesLytBinding26.editOtpChar2) == null)) {
                customTextInputEditText11.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding27 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding27 == null || (customTextInputEditText10 = mpFragmentOtpEditboxesLytBinding27.editOtpChar3) == null)) {
                customTextInputEditText10.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding28 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding28 == null || (customTextInputEditText9 = mpFragmentOtpEditboxesLytBinding28.editOtpChar4) == null)) {
                customTextInputEditText9.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding29 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding29 == null || (customTextInputEditText8 = mpFragmentOtpEditboxesLytBinding29.editOtpChar5) == null)) {
                customTextInputEditText8.setBackground(a2);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding30 = this.mLayoutBinding;
            if (mpFragmentOtpEditboxesLytBinding30 != null && (customTextInputEditText7 = mpFragmentOtpEditboxesLytBinding30.editOtpChar6) != null) {
                customTextInputEditText7.setBackground(a3);
            }
        } else if (i2 == 6) {
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding31 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding31 == null || (customTextInputEditText6 = mpFragmentOtpEditboxesLytBinding31.editOtpChar1) == null)) {
                customTextInputEditText6.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding32 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding32 == null || (customTextInputEditText5 = mpFragmentOtpEditboxesLytBinding32.editOtpChar2) == null)) {
                customTextInputEditText5.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding33 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding33 == null || (customTextInputEditText4 = mpFragmentOtpEditboxesLytBinding33.editOtpChar3) == null)) {
                customTextInputEditText4.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding34 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding34 == null || (customTextInputEditText3 = mpFragmentOtpEditboxesLytBinding34.editOtpChar4) == null)) {
                customTextInputEditText3.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding35 = this.mLayoutBinding;
            if (!(mpFragmentOtpEditboxesLytBinding35 == null || (customTextInputEditText2 = mpFragmentOtpEditboxesLytBinding35.editOtpChar5) == null)) {
                customTextInputEditText2.setBackground(a3);
            }
            MpFragmentOtpEditboxesLytBinding mpFragmentOtpEditboxesLytBinding36 = this.mLayoutBinding;
            if (mpFragmentOtpEditboxesLytBinding36 != null && (customTextInputEditText = mpFragmentOtpEditboxesLytBinding36.editOtpChar6) != null) {
                customTextInputEditText.setBackground(a2);
            }
        }
    }
}
