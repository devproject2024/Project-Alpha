package net.one97.paytm.recharge.mobile.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.common.widget.CustomRadioGroup;
import net.one97.paytm.recharge.model.v4.CJRRelatedCategory;
import net.one97.paytm.upi.util.UpiConstants;

public class CJRMobileRadioGroupV8<T> extends CustomRadioGroup<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRMobileRadioGroupV8(Context context, List<? extends T> list) {
        super(context, list, (RadioGroup.OnCheckedChangeListener) null, (CustomRadioGroup.a) null);
        k.c(list, "radioButtons");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRMobileRadioGroupV8(Context context, List<? extends T> list, byte b2) {
        this(context, list);
        k.c(list, "radioButtons");
    }

    public final void a(Map<String, String> map) {
        String value;
        String value2;
        k.c(map, "deepLinkParams");
        RadioGroup custom_type_radio_group = getCustom_type_radio_group();
        int childCount = custom_type_radio_group != null ? custom_type_radio_group.getChildCount() : 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            RadioGroup custom_type_radio_group2 = getCustom_type_radio_group();
            Object obj = null;
            RadioButton radioButton = (RadioButton) (custom_type_radio_group2 != null ? custom_type_radio_group2.getChildAt(i2) : null);
            if (radioButton != null) {
                obj = radioButton.getTag();
            }
            if (obj instanceof CJRRelatedCategory) {
                Object tag = radioButton.getTag();
                if (tag != null) {
                    CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) tag;
                    if (map.containsKey("prepaid_on")) {
                        String str = map.get("prepaid_on");
                        if (TextUtils.isEmpty(str)) {
                            continue;
                        } else {
                            if (p.a(str, UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true) && (value2 = cJRRelatedCategory.getValue()) != null) {
                                if (value2 != null) {
                                    String lowerCase = value2.toLowerCase();
                                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                                    if (lowerCase != null) {
                                        String lowerCase2 = BaseViewModel.PaymentType.POSTPAID.toLowerCase();
                                        k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                                        if (p.a((CharSequence) lowerCase, (CharSequence) lowerCase2, false)) {
                                            if (!radioButton.isChecked()) {
                                                CustomRadioGroup.a mRadioButtonCustomListners = getMRadioButtonCustomListners();
                                                if (mRadioButtonCustomListners != null) {
                                                    mRadioButtonCustomListners.a(cJRRelatedCategory);
                                                }
                                                radioButton.setChecked(true);
                                                return;
                                            }
                                            CustomRadioGroup.a mRadioButtonCustomListners2 = getMRadioButtonCustomListners();
                                            if (mRadioButtonCustomListners2 != null) {
                                                mRadioButtonCustomListners2.I();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                            if (p.a(str, "Y", true) && (value = cJRRelatedCategory.getValue()) != null) {
                                if (value != null) {
                                    String lowerCase3 = value.toLowerCase();
                                    k.a((Object) lowerCase3, "(this as java.lang.String).toLowerCase()");
                                    if (lowerCase3 != null) {
                                        String lowerCase4 = "prepaid".toLowerCase();
                                        k.a((Object) lowerCase4, "(this as java.lang.String).toLowerCase()");
                                        if (p.a((CharSequence) lowerCase3, (CharSequence) lowerCase4, false)) {
                                            if (!radioButton.isChecked()) {
                                                CustomRadioGroup.a mRadioButtonCustomListners3 = getMRadioButtonCustomListners();
                                                if (mRadioButtonCustomListners3 != null) {
                                                    mRadioButtonCustomListners3.a(cJRRelatedCategory);
                                                }
                                                radioButton.setChecked(true);
                                                return;
                                            }
                                            CustomRadioGroup.a mRadioButtonCustomListners4 = getMRadioButtonCustomListners();
                                            if (mRadioButtonCustomListners4 != null) {
                                                mRadioButtonCustomListners4.I();
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        continue;
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
                }
            }
        }
        super.a(map);
    }
}
