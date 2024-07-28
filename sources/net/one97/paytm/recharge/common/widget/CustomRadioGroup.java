package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRRelatedCategory;

public class CustomRadioGroup<T> extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62091a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62092b;

    /* renamed from: c  reason: collision with root package name */
    public final List<T> f62093c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f62094d;

    /* renamed from: e  reason: collision with root package name */
    private View f62095e;

    /* renamed from: f  reason: collision with root package name */
    private RadioGroup f62096f;

    /* renamed from: g  reason: collision with root package name */
    private final RadioGroup.OnCheckedChangeListener f62097g;

    /* renamed from: h  reason: collision with root package name */
    private RadioGroup.OnCheckedChangeListener f62098h;

    /* renamed from: i  reason: collision with root package name */
    private a f62099i;

    public interface a {
        void I();

        void a(CJRRelatedCategory cJRRelatedCategory);
    }

    /* access modifiers changed from: protected */
    public final List<T> getRadioButtons() {
        return this.f62093c;
    }

    /* access modifiers changed from: protected */
    public final RadioGroup.OnCheckedChangeListener getMCheckedChangedListener() {
        return this.f62098h;
    }

    /* access modifiers changed from: protected */
    public final void setMCheckedChangedListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.f62098h = onCheckedChangeListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomRadioGroup(Context context, List<? extends T> list, RadioGroup.OnCheckedChangeListener onCheckedChangeListener, a aVar) {
        super(context);
        k.c(list, "radioButtons");
        this.f62093c = list;
        this.f62098h = onCheckedChangeListener;
        this.f62099i = aVar;
        this.f62097g = new c(this, context);
        a();
    }

    /* access modifiers changed from: protected */
    public final a getMRadioButtonCustomListners() {
        return this.f62099i;
    }

    /* access modifiers changed from: protected */
    public final void setMRadioButtonCustomListners(a aVar) {
        this.f62099i = aVar;
    }

    public final boolean getRemoveAllViews() {
        return this.f62094d;
    }

    public final void setRemoveAllViews(boolean z) {
        this.f62094d = z;
    }

    public final void setViewSelectedByUser(boolean z) {
        this.f62091a = z;
    }

    public final TextView getPayment_title() {
        return this.f62092b;
    }

    public final void setPayment_title(TextView textView) {
        this.f62092b = textView;
    }

    public final View getPayment_underline() {
        return this.f62095e;
    }

    public final void setPayment_underline(View view) {
        this.f62095e = view;
    }

    public final RadioGroup getCustom_type_radio_group() {
        return this.f62096f;
    }

    public final void setCustom_type_radio_group(RadioGroup radioGroup) {
        this.f62096f = radioGroup;
    }

    static final class c implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomRadioGroup f62101a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f62102b;

        c(CustomRadioGroup customRadioGroup, Context context) {
            this.f62101a = customRadioGroup;
            this.f62102b = context;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            x.e eVar = new x.e();
            RadioGroup custom_type_radio_group = this.f62101a.getCustom_type_radio_group();
            int childCount = custom_type_radio_group != null ? custom_type_radio_group.getChildCount() : 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                RadioGroup custom_type_radio_group2 = this.f62101a.getCustom_type_radio_group();
                Object obj = null;
                eVar.element = (RadioButton) (custom_type_radio_group2 != null ? custom_type_radio_group2.getChildAt(i3) : null);
                if (((RadioButton) eVar.element) != null) {
                    if (((RadioButton) eVar.element).isChecked()) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            ((RadioButton) eVar.element).setTextAppearance(this.f62101a.getSelectedRadioStyle());
                        } else {
                            ((RadioButton) eVar.element).setTextAppearance(this.f62102b, this.f62101a.getSelectedRadioStyle());
                        }
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        ((RadioButton) eVar.element).setTextAppearance(this.f62101a.getUnSelectedRadioStyle());
                    } else {
                        ((RadioButton) eVar.element).setTextAppearance(this.f62102b, this.f62101a.getUnSelectedRadioStyle());
                    }
                }
                RadioButton radioButton = (RadioButton) eVar.element;
                if (radioButton != null) {
                    obj = radioButton.getTag();
                }
                if (obj instanceof CJRRelatedCategory) {
                    Object tag = ((RadioButton) eVar.element).getTag();
                    if (tag != null) {
                        CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) tag;
                        if (((RadioButton) eVar.element).getId() == i2) {
                            cJRRelatedCategory.setSelected(true);
                        } else {
                            cJRRelatedCategory.setSelected(false);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
                    }
                }
            }
            RadioGroup.OnCheckedChangeListener mCheckedChangedListener = this.f62101a.getMCheckedChangedListener();
            if (mCheckedChangedListener != null) {
                mCheckedChangedListener.onCheckedChanged(radioGroup, i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final RadioGroup.OnCheckedChangeListener getRadioCheckedChangedListener() {
        return this.f62097g;
    }

    public void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.radio_group_custom_view, this, true);
        this.f62096f = (RadioGroup) findViewById(R.id.custom_type_radio_group);
        this.f62092b = (TextView) findViewById(R.id.payment_title);
        this.f62095e = findViewById(R.id.payment_underline);
        RadioGroup radioGroup = this.f62096f;
        if (radioGroup != null) {
            radioGroup.removeAllViews();
        }
        View view = this.f62095e;
        if (view != null) {
            ai.b(view);
        }
        int f2 = com.paytm.utility.b.f(getContext());
        int size = this.f62093c.size();
        for (int i2 = 0; i2 < size; i2++) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setId(i2);
            if (Build.VERSION.SDK_INT >= 23) {
                radioButton.setTextAppearance(getUnSelectedRadioStyle());
            } else {
                Context context = radioButton.getContext();
                if (context == null) {
                    k.a();
                }
                radioButton.setTextAppearance(context, getUnSelectedRadioStyle());
            }
            radioButton.setButtonDrawable(R.drawable.btn_radio_holo_light);
            radioButton.setOnTouchListener(new b(this));
            a(radioButton, f2);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
            T t = this.f62093c.get(i2);
            String str = null;
            if (t instanceof CJRRelatedCategory) {
                CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) this.f62093c.get(i2);
                radioButton.setTag(cJRRelatedCategory);
                if (cJRRelatedCategory != null) {
                    str = cJRRelatedCategory.getLabel();
                }
                radioButton.setText(str);
                layoutParams.weight = 0.5f;
                RadioGroup radioGroup2 = this.f62096f;
                if (radioGroup2 != null) {
                    radioGroup2.addView(radioButton, layoutParams);
                }
            } else if (t instanceof CJRAggsItem) {
                CJRAggsItem cJRAggsItem = (CJRAggsItem) this.f62093c.get(i2);
                radioButton.setTag(Integer.valueOf(i2));
                if (cJRAggsItem != null) {
                    str = cJRAggsItem.getDisplayValue();
                }
                radioButton.setText(str);
                radioButton.setTextColor(androidx.core.content.b.c(radioButton.getContext(), R.color.financial_key_value));
                radioButton.setTextSize(12.0f);
                RadioGroup radioGroup3 = this.f62096f;
                if (radioGroup3 != null) {
                    radioGroup3.addView(radioButton, layoutParams);
                }
            }
        }
        RadioGroup radioGroup4 = this.f62096f;
        if (radioGroup4 != null) {
            radioGroup4.setOnCheckedChangeListener(this.f62097g);
        }
        RadioGroup radioGroup5 = this.f62096f;
        if (radioGroup5 != null) {
            int i3 = f2 / 2;
            radioGroup5.setPadding(0, i3, 0, i3);
        }
    }

    static final class b implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomRadioGroup f62100a;

        b(CustomRadioGroup customRadioGroup) {
            this.f62100a = customRadioGroup;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.f62100a.setViewSelectedByUser(true);
            return false;
        }
    }

    public int getSelectedRadioStyle() {
        return R.style.radioButtonSelectedStyle;
    }

    public int getUnSelectedRadioStyle() {
        return R.style.radioButtonUnselectedStyle;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f62098h = null;
        RadioGroup radioGroup = this.f62096f;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
        }
        this.f62099i = null;
        super.onDetachedFromWindow();
    }

    public void a(Map<String, String> map) {
        String value;
        k.c(map, "deepLinkParams");
        RadioGroup radioGroup = this.f62096f;
        int childCount = radioGroup != null ? radioGroup.getChildCount() : 0;
        int i2 = 0;
        while (true) {
            Object obj = null;
            if (i2 < childCount) {
                RadioGroup radioGroup2 = this.f62096f;
                RadioButton radioButton = (RadioButton) (radioGroup2 != null ? radioGroup2.getChildAt(i2) : null);
                if (radioButton != null) {
                    obj = radioButton.getTag();
                }
                if (obj instanceof CJRRelatedCategory) {
                    Object tag = radioButton.getTag();
                    if (tag != null) {
                        CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) tag;
                        if (map.containsKey("service") && (value = cJRRelatedCategory.getValue()) != null) {
                            if (value != null) {
                                String lowerCase = value.toLowerCase();
                                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                                if (lowerCase != null) {
                                    CharSequence charSequence = lowerCase;
                                    String str = map.get("service");
                                    if (str == null) {
                                        k.a();
                                    }
                                    String str2 = str;
                                    if (str2 != null) {
                                        String lowerCase2 = str2.toLowerCase();
                                        k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                                        if (p.a(charSequence, (CharSequence) lowerCase2, false)) {
                                            if (!radioButton.isChecked()) {
                                                a aVar = this.f62099i;
                                                if (aVar != null) {
                                                    aVar.a(cJRRelatedCategory);
                                                }
                                                radioButton.setChecked(true);
                                                return;
                                            }
                                            a aVar2 = this.f62099i;
                                            if (aVar2 != null) {
                                                aVar2.I();
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        throw new u("null cannot be cast to non-null type java.lang.String");
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
                    }
                }
                i2++;
            } else {
                RadioGroup radioGroup3 = this.f62096f;
                int childCount2 = radioGroup3 != null ? radioGroup3.getChildCount() : 0;
                for (int i3 = 0; i3 < childCount2; i3++) {
                    RadioGroup radioGroup4 = this.f62096f;
                    RadioButton radioButton2 = (RadioButton) (radioGroup4 != null ? radioGroup4.getChildAt(i3) : null);
                    if ((radioButton2 != null ? radioButton2.getTag() : null) instanceof CJRRelatedCategory) {
                        Object tag2 = radioButton2.getTag();
                        if (tag2 != null) {
                            CJRRelatedCategory cJRRelatedCategory2 = (CJRRelatedCategory) tag2;
                            if (cJRRelatedCategory2.isSelected()) {
                                if (!radioButton2.isChecked()) {
                                    a aVar3 = this.f62099i;
                                    if (aVar3 != null) {
                                        aVar3.a(cJRRelatedCategory2);
                                    }
                                    radioButton2.setChecked(true);
                                    return;
                                }
                                a aVar4 = this.f62099i;
                                if (aVar4 != null) {
                                    aVar4.I();
                                    return;
                                }
                                return;
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
                        }
                    }
                }
                RadioGroup radioGroup5 = this.f62096f;
                if ((radioGroup5 != null ? radioGroup5.getChildCount() : 0) > 0) {
                    RadioGroup radioGroup6 = this.f62096f;
                    if (radioGroup6 != null) {
                        obj = radioGroup6.getChildAt(0);
                    }
                    RadioButton radioButton3 = (RadioButton) obj;
                    if (radioButton3 != null) {
                        radioButton3.setChecked(true);
                    }
                }
                a aVar5 = this.f62099i;
                if (aVar5 != null) {
                    aVar5.I();
                    return;
                }
                return;
            }
        }
    }

    public final String b(Map<String, String> map) {
        String value;
        String c2;
        k.c(map, "deepLinkParams");
        RadioGroup radioGroup = this.f62096f;
        int childCount = radioGroup != null ? radioGroup.getChildCount() : 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            RadioGroup radioGroup2 = this.f62096f;
            RadioButton radioButton = (RadioButton) (radioGroup2 != null ? radioGroup2.getChildAt(i2) : null);
            if ((radioButton != null ? radioButton.getTag() : null) instanceof CJRRelatedCategory) {
                Object tag = radioButton.getTag();
                if (tag != null) {
                    CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) tag;
                    if (map.containsKey("service") && (value = cJRRelatedCategory.getValue()) != null) {
                        if (value != null) {
                            String lowerCase = value.toLowerCase();
                            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                            if (lowerCase != null) {
                                CharSequence charSequence = lowerCase;
                                String str = map.get("service");
                                if (str == null) {
                                    k.a();
                                }
                                String str2 = str;
                                if (str2 != null) {
                                    String lowerCase2 = str2.toLowerCase();
                                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                                    if (p.a(charSequence, (CharSequence) lowerCase2, false)) {
                                        String url = cJRRelatedCategory.getUrl();
                                        if (url == null || (c2 = p.c(url, "category/", "")) == null) {
                                            return null;
                                        }
                                        return c2;
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                }
                            } else {
                                continue;
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
                }
            }
        }
        return null;
    }

    public final void setCheckedChangedListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        k.c(onCheckedChangeListener, "checkedChangedListener");
        this.f62098h = onCheckedChangeListener;
    }

    public final void setRadioButtonCustomListener(a aVar) {
        this.f62099i = aVar;
    }

    public final RadioGroup getRadioGroup() {
        return this.f62096f;
    }

    public final void setSelectedAtIndex(int i2) {
        try {
            RadioGroup radioGroup = this.f62096f;
            if (radioGroup == null) {
                k.a();
            }
            View findViewWithTag = radioGroup.findViewWithTag(Integer.valueOf(i2));
            RadioGroup radioGroup2 = this.f62096f;
            if (radioGroup2 == null) {
                k.a();
            }
            if (findViewWithTag == null) {
                k.a();
            }
            radioGroup2.check(findViewWithTag.getId());
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }

    public void a(RadioButton radioButton, int i2) {
        k.c(radioButton, "radioButton");
        radioButton.setPadding(i2 / 2, 0, i2, 0);
    }

    public final CJRRelatedCategory getRelatedCategoryOfSelectedRadioButton() {
        RadioGroup radioGroup = this.f62096f;
        int i2 = 0;
        int childCount = radioGroup != null ? radioGroup.getChildCount() : 0;
        while (true) {
            Object obj = null;
            if (i2 >= childCount) {
                return null;
            }
            RadioGroup radioGroup2 = this.f62096f;
            RadioButton radioButton = (RadioButton) (radioGroup2 != null ? radioGroup2.getChildAt(i2) : null);
            if (radioButton != null) {
                obj = radioButton.getTag();
            }
            if (!(obj instanceof CJRRelatedCategory) || !radioButton.isChecked()) {
                i2++;
            } else {
                Object tag = radioButton.getTag();
                if (tag != null) {
                    return (CJRRelatedCategory) tag;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
            }
        }
    }
}
