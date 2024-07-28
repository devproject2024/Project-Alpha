package net.one97.paytm.recharge.mobile_v3.widget;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8;
import net.one97.paytm.recharge.model.v4.CJRRelatedCategory;

public final class CJRRcRadioGroupV3<T> extends CJRMobileRadioGroupV8<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private CJRRcRadioGroupV3(Context context, List<? extends T> list) {
        super(context, list);
        k.c(list, "radioButtons");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRRcRadioGroupV3(Context context, List<? extends T> list, byte b2) {
        this(context, list);
        k.c(list, "radioButtons");
    }

    public final void a() {
        RadioButton radioButton;
        LayoutInflater.from(getContext()).inflate(R.layout.v3_related_category_radio, this, true);
        setCustom_type_radio_group((RadioGroup) findViewById(R.id.custom_type_radio_group));
        int size = getRadioButtons().size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = null;
            try {
                RadioGroup custom_type_radio_group = getCustom_type_radio_group();
                View childAt = custom_type_radio_group != null ? custom_type_radio_group.getChildAt(i2) : null;
                if (!(childAt instanceof RadioButton)) {
                    childAt = null;
                }
                radioButton = (RadioButton) childAt;
            } catch (Exception unused) {
                radioButton = null;
            }
            if (radioButton != null) {
                radioButton.setId(i2);
            }
            if (radioButton != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    radioButton.setTextAppearance(R.style.radioButtonUnselectedStyleV3);
                } else {
                    Context context = radioButton.getContext();
                    if (context == null) {
                        k.a();
                    }
                    radioButton.setTextAppearance(context, R.style.radioButtonUnselectedStyleV3);
                }
                radioButton.setOnTouchListener(new a(this));
            }
            if (getRadioButtons().get(i2) instanceof CJRRelatedCategory) {
                CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) getRadioButtons().get(i2);
                if (radioButton != null) {
                    radioButton.setTag(cJRRelatedCategory);
                    if (cJRRelatedCategory != null) {
                        str = cJRRelatedCategory.getLabel();
                    }
                    radioButton.setText(str);
                }
            }
        }
        RadioGroup custom_type_radio_group2 = getCustom_type_radio_group();
        if (custom_type_radio_group2 != null) {
            custom_type_radio_group2.setOnCheckedChangeListener(getRadioCheckedChangedListener());
        }
    }

    static final class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRRcRadioGroupV3 f63960a;

        a(CJRRcRadioGroupV3 cJRRcRadioGroupV3) {
            this.f63960a = cJRRcRadioGroupV3;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.f63960a.setViewSelectedByUser(true);
            return false;
        }
    }

    public final int getSelectedRadioStyle() {
        return R.style.radioButtonSelectedStyleV3;
    }

    public final int getUnSelectedRadioStyle() {
        return R.style.radioButtonUnselectedStyleV3;
    }
}
