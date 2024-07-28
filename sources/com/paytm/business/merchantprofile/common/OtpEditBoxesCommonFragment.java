package com.paytm.business.merchantprofile.common;

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
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class OtpEditBoxesCommonFragment extends h {
    public HashMap _$_findViewCache;
    public int index = 1;
    public PrFragmentOtpEditboxesLytBinding mLayoutBinding;
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
        PrFragmentOtpEditboxesLytBinding inflate = PrFragmentOtpEditboxesLytBinding.inflate(layoutInflater, viewGroup, false);
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
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding == null || (customTextInputEditText13 = prFragmentOtpEditboxesLytBinding.editOtpChar1) == null)) {
            customTextInputEditText13.addTextChangedListener(this.passcodeChange);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding2 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding2 == null || (customTextInputEditText12 = prFragmentOtpEditboxesLytBinding2.editOtpChar2) == null)) {
            customTextInputEditText12.addTextChangedListener(this.passcodeChange);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding3 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding3 == null || (customTextInputEditText11 = prFragmentOtpEditboxesLytBinding3.editOtpChar3) == null)) {
            customTextInputEditText11.addTextChangedListener(this.passcodeChange);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding4 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding4 == null || (customTextInputEditText10 = prFragmentOtpEditboxesLytBinding4.editOtpChar4) == null)) {
            customTextInputEditText10.addTextChangedListener(this.passcodeChange);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding5 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding5 == null || (customTextInputEditText9 = prFragmentOtpEditboxesLytBinding5.editOtpChar5) == null)) {
            customTextInputEditText9.addTextChangedListener(this.passcodeChange);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding6 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding6 == null || (customTextInputEditText8 = prFragmentOtpEditboxesLytBinding6.editOtpChar6) == null)) {
            customTextInputEditText8.addTextChangedListener(this.passcodeChange);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding7 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding7 == null || (customTextInputEditText7 = prFragmentOtpEditboxesLytBinding7.editOtpChar1) == null)) {
            customTextInputEditText7.setOnKeyListener(this.onKeyListener);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding8 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding8 == null || (customTextInputEditText6 = prFragmentOtpEditboxesLytBinding8.editOtpChar2) == null)) {
            customTextInputEditText6.setOnKeyListener(this.onKeyListener);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding9 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding9 == null || (customTextInputEditText5 = prFragmentOtpEditboxesLytBinding9.editOtpChar3) == null)) {
            customTextInputEditText5.setOnKeyListener(this.onKeyListener);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding10 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding10 == null || (customTextInputEditText4 = prFragmentOtpEditboxesLytBinding10.editOtpChar4) == null)) {
            customTextInputEditText4.setOnKeyListener(this.onKeyListener);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding11 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding11 == null || (customTextInputEditText3 = prFragmentOtpEditboxesLytBinding11.editOtpChar5) == null)) {
            customTextInputEditText3.setOnKeyListener(this.onKeyListener);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding12 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding12 == null || (customTextInputEditText2 = prFragmentOtpEditboxesLytBinding12.editOtpChar6) == null)) {
            customTextInputEditText2.setOnKeyListener(this.onKeyListener);
        }
        PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding13 = this.mLayoutBinding;
        if (!(prFragmentOtpEditboxesLytBinding13 == null || (customTextInputEditText = prFragmentOtpEditboxesLytBinding13.editOtpChar1) == null)) {
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
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding == null || (customTextInputEditText15 = prFragmentOtpEditboxesLytBinding.editOtpChar1) == null)) {
                customTextInputEditText15.requestFocus();
            }
            setBlueBackground(1);
        } else if (i2 == 2) {
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding2 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding2 == null || (customTextInputEditText14 = prFragmentOtpEditboxesLytBinding2.editOtpChar2) == null)) {
                customTextInputEditText14.requestFocus();
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding3 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding3 == null || (customTextInputEditText13 = prFragmentOtpEditboxesLytBinding3.editOtpChar1) == null)) {
                customTextInputEditText13.setEnabled(false);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding4 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding4 == null || (customTextInputEditText12 = prFragmentOtpEditboxesLytBinding4.editOtpChar3) == null)) {
                customTextInputEditText12.setEnabled(true);
            }
            setBlueBackground(2);
        } else if (i2 == 3) {
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding5 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding5 == null || (customTextInputEditText11 = prFragmentOtpEditboxesLytBinding5.editOtpChar3) == null)) {
                customTextInputEditText11.requestFocus();
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding6 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding6 == null || (customTextInputEditText10 = prFragmentOtpEditboxesLytBinding6.editOtpChar2) == null)) {
                customTextInputEditText10.setEnabled(false);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding7 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding7 == null || (customTextInputEditText9 = prFragmentOtpEditboxesLytBinding7.editOtpChar4) == null)) {
                customTextInputEditText9.setEnabled(true);
            }
            setBlueBackground(3);
        } else if (i2 == 4) {
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding8 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding8 == null || (customTextInputEditText8 = prFragmentOtpEditboxesLytBinding8.editOtpChar4) == null)) {
                customTextInputEditText8.requestFocus();
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding9 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding9 == null || (customTextInputEditText7 = prFragmentOtpEditboxesLytBinding9.editOtpChar3) == null)) {
                customTextInputEditText7.setEnabled(false);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding10 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding10 == null || (customTextInputEditText6 = prFragmentOtpEditboxesLytBinding10.editOtpChar5) == null)) {
                customTextInputEditText6.setEnabled(true);
            }
            setBlueBackground(4);
        } else if (i2 == 5) {
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding11 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding11 == null || (customTextInputEditText5 = prFragmentOtpEditboxesLytBinding11.editOtpChar5) == null)) {
                customTextInputEditText5.requestFocus();
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding12 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding12 == null || (customTextInputEditText4 = prFragmentOtpEditboxesLytBinding12.editOtpChar4) == null)) {
                customTextInputEditText4.setEnabled(false);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding13 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding13 == null || (customTextInputEditText3 = prFragmentOtpEditboxesLytBinding13.editOtpChar6) == null)) {
                customTextInputEditText3.setEnabled(true);
            }
            setBlueBackground(5);
        } else if (i2 == 6) {
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding14 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding14 == null || (customTextInputEditText2 = prFragmentOtpEditboxesLytBinding14.editOtpChar6) == null)) {
                customTextInputEditText2.requestFocus();
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding15 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding15 == null || (customTextInputEditText = prFragmentOtpEditboxesLytBinding15.editOtpChar5) == null)) {
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r1 = r3.mLayoutBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment.getOtpCombined():java.lang.String");
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
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding == null || (customTextInputEditText6 = prFragmentOtpEditboxesLytBinding.editOtpChar1) == null)) {
                customTextInputEditText6.setText(String.valueOf(str.charAt(0)));
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding2 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding2 == null || (customTextInputEditText5 = prFragmentOtpEditboxesLytBinding2.editOtpChar2) == null)) {
                customTextInputEditText5.setText(String.valueOf(str.charAt(1)));
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding3 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding3 == null || (customTextInputEditText4 = prFragmentOtpEditboxesLytBinding3.editOtpChar3) == null)) {
                customTextInputEditText4.setText(String.valueOf(str.charAt(2)));
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding4 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding4 == null || (customTextInputEditText3 = prFragmentOtpEditboxesLytBinding4.editOtpChar4) == null)) {
                customTextInputEditText3.setText(String.valueOf(str.charAt(3)));
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding5 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding5 == null || (customTextInputEditText2 = prFragmentOtpEditboxesLytBinding5.editOtpChar5) == null)) {
                customTextInputEditText2.setText(String.valueOf(str.charAt(4)));
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding6 = this.mLayoutBinding;
            if (prFragmentOtpEditboxesLytBinding6 != null && (customTextInputEditText = prFragmentOtpEditboxesLytBinding6.editOtpChar6) != null) {
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0027
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x0027
            r0.setVisibility(r2)
        L_0x0027:
            return r2
        L_0x0028:
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0047
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x0047
            r0.setVisibility(r2)
        L_0x0047:
            return r2
        L_0x0048:
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0067
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x0067
            r0.setVisibility(r2)
        L_0x0067:
            return r2
        L_0x0068:
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x0087
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x0087
            r0.setVisibility(r2)
        L_0x0087:
            return r2
        L_0x0088:
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
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
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x00a7
            com.business.common_module.view.widget.CustomTextView r0 = r0.errorOtpTv
            if (r0 == 0) goto L_0x00a7
            r0.setVisibility(r2)
        L_0x00a7:
            return r2
        L_0x00a8:
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
            if (r0 == 0) goto L_0x00b4
            com.business.common_module.view.widget.CustomTextInputEditText r0 = r0.editOtpChar6
            if (r0 == 0) goto L_0x00b4
            android.text.Editable r1 = r0.getText()
        L_0x00b4:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L_0x00c6
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r0 = r3.mLayoutBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment.checkValidation():boolean");
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
        int i3 = R.drawable.pr_otp_boxes_selector_blue;
        int i4 = R.drawable.pr_otp_boxes_selector;
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
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding == null || (customTextInputEditText36 = prFragmentOtpEditboxesLytBinding.editOtpChar1) == null)) {
                customTextInputEditText36.setBackground(a2);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding2 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding2 == null || (customTextInputEditText35 = prFragmentOtpEditboxesLytBinding2.editOtpChar2) == null)) {
                customTextInputEditText35.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding3 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding3 == null || (customTextInputEditText34 = prFragmentOtpEditboxesLytBinding3.editOtpChar3) == null)) {
                customTextInputEditText34.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding4 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding4 == null || (customTextInputEditText33 = prFragmentOtpEditboxesLytBinding4.editOtpChar4) == null)) {
                customTextInputEditText33.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding5 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding5 == null || (customTextInputEditText32 = prFragmentOtpEditboxesLytBinding5.editOtpChar5) == null)) {
                customTextInputEditText32.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding6 = this.mLayoutBinding;
            if (prFragmentOtpEditboxesLytBinding6 != null && (customTextInputEditText31 = prFragmentOtpEditboxesLytBinding6.editOtpChar6) != null) {
                customTextInputEditText31.setBackground(a3);
            }
        } else if (i2 == 2) {
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding7 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding7 == null || (customTextInputEditText30 = prFragmentOtpEditboxesLytBinding7.editOtpChar1) == null)) {
                customTextInputEditText30.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding8 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding8 == null || (customTextInputEditText29 = prFragmentOtpEditboxesLytBinding8.editOtpChar2) == null)) {
                customTextInputEditText29.setBackground(a2);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding9 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding9 == null || (customTextInputEditText28 = prFragmentOtpEditboxesLytBinding9.editOtpChar3) == null)) {
                customTextInputEditText28.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding10 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding10 == null || (customTextInputEditText27 = prFragmentOtpEditboxesLytBinding10.editOtpChar4) == null)) {
                customTextInputEditText27.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding11 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding11 == null || (customTextInputEditText26 = prFragmentOtpEditboxesLytBinding11.editOtpChar5) == null)) {
                customTextInputEditText26.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding12 = this.mLayoutBinding;
            if (prFragmentOtpEditboxesLytBinding12 != null && (customTextInputEditText25 = prFragmentOtpEditboxesLytBinding12.editOtpChar6) != null) {
                customTextInputEditText25.setBackground(a3);
            }
        } else if (i2 == 3) {
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding13 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding13 == null || (customTextInputEditText24 = prFragmentOtpEditboxesLytBinding13.editOtpChar1) == null)) {
                customTextInputEditText24.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding14 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding14 == null || (customTextInputEditText23 = prFragmentOtpEditboxesLytBinding14.editOtpChar2) == null)) {
                customTextInputEditText23.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding15 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding15 == null || (customTextInputEditText22 = prFragmentOtpEditboxesLytBinding15.editOtpChar3) == null)) {
                customTextInputEditText22.setBackground(a2);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding16 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding16 == null || (customTextInputEditText21 = prFragmentOtpEditboxesLytBinding16.editOtpChar4) == null)) {
                customTextInputEditText21.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding17 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding17 == null || (customTextInputEditText20 = prFragmentOtpEditboxesLytBinding17.editOtpChar5) == null)) {
                customTextInputEditText20.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding18 = this.mLayoutBinding;
            if (prFragmentOtpEditboxesLytBinding18 != null && (customTextInputEditText19 = prFragmentOtpEditboxesLytBinding18.editOtpChar6) != null) {
                customTextInputEditText19.setBackground(a3);
            }
        } else if (i2 == 4) {
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding19 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding19 == null || (customTextInputEditText18 = prFragmentOtpEditboxesLytBinding19.editOtpChar1) == null)) {
                customTextInputEditText18.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding20 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding20 == null || (customTextInputEditText17 = prFragmentOtpEditboxesLytBinding20.editOtpChar2) == null)) {
                customTextInputEditText17.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding21 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding21 == null || (customTextInputEditText16 = prFragmentOtpEditboxesLytBinding21.editOtpChar3) == null)) {
                customTextInputEditText16.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding22 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding22 == null || (customTextInputEditText15 = prFragmentOtpEditboxesLytBinding22.editOtpChar4) == null)) {
                customTextInputEditText15.setBackground(a2);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding23 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding23 == null || (customTextInputEditText14 = prFragmentOtpEditboxesLytBinding23.editOtpChar5) == null)) {
                customTextInputEditText14.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding24 = this.mLayoutBinding;
            if (prFragmentOtpEditboxesLytBinding24 != null && (customTextInputEditText13 = prFragmentOtpEditboxesLytBinding24.editOtpChar6) != null) {
                customTextInputEditText13.setBackground(a3);
            }
        } else if (i2 == 5) {
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding25 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding25 == null || (customTextInputEditText12 = prFragmentOtpEditboxesLytBinding25.editOtpChar1) == null)) {
                customTextInputEditText12.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding26 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding26 == null || (customTextInputEditText11 = prFragmentOtpEditboxesLytBinding26.editOtpChar2) == null)) {
                customTextInputEditText11.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding27 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding27 == null || (customTextInputEditText10 = prFragmentOtpEditboxesLytBinding27.editOtpChar3) == null)) {
                customTextInputEditText10.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding28 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding28 == null || (customTextInputEditText9 = prFragmentOtpEditboxesLytBinding28.editOtpChar4) == null)) {
                customTextInputEditText9.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding29 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding29 == null || (customTextInputEditText8 = prFragmentOtpEditboxesLytBinding29.editOtpChar5) == null)) {
                customTextInputEditText8.setBackground(a2);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding30 = this.mLayoutBinding;
            if (prFragmentOtpEditboxesLytBinding30 != null && (customTextInputEditText7 = prFragmentOtpEditboxesLytBinding30.editOtpChar6) != null) {
                customTextInputEditText7.setBackground(a3);
            }
        } else if (i2 == 6) {
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding31 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding31 == null || (customTextInputEditText6 = prFragmentOtpEditboxesLytBinding31.editOtpChar1) == null)) {
                customTextInputEditText6.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding32 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding32 == null || (customTextInputEditText5 = prFragmentOtpEditboxesLytBinding32.editOtpChar2) == null)) {
                customTextInputEditText5.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding33 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding33 == null || (customTextInputEditText4 = prFragmentOtpEditboxesLytBinding33.editOtpChar3) == null)) {
                customTextInputEditText4.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding34 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding34 == null || (customTextInputEditText3 = prFragmentOtpEditboxesLytBinding34.editOtpChar4) == null)) {
                customTextInputEditText3.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding35 = this.mLayoutBinding;
            if (!(prFragmentOtpEditboxesLytBinding35 == null || (customTextInputEditText2 = prFragmentOtpEditboxesLytBinding35.editOtpChar5) == null)) {
                customTextInputEditText2.setBackground(a3);
            }
            PrFragmentOtpEditboxesLytBinding prFragmentOtpEditboxesLytBinding36 = this.mLayoutBinding;
            if (prFragmentOtpEditboxesLytBinding36 != null && (customTextInputEditText = prFragmentOtpEditboxesLytBinding36.editOtpChar6) != null) {
                customTextInputEditText.setBackground(a2);
            }
        }
    }
}
