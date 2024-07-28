package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.legacy.catalog.widget.CustomRadioGroupBaseV2;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public class GroupItemCustomRadioGroup extends LinearLayout implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f62105a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f62106b;

    /* renamed from: c  reason: collision with root package name */
    private final String f62107c;

    /* renamed from: d  reason: collision with root package name */
    private final int f62108d;

    /* renamed from: e  reason: collision with root package name */
    private final b f62109e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f62110f;

    public interface b {
        void a(int i2, String str, int i3);
    }

    private View a(int i2) {
        if (this.f62110f == null) {
            this.f62110f = new HashMap();
        }
        View view = (View) this.f62110f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f62110f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final String getGroupName() {
        return this.f62107c;
    }

    public final int getPosition() {
        return this.f62108d;
    }

    public final b getGroupItemRadioButtonCustomListners() {
        return this.f62109e;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupItemCustomRadioGroup(Context context, String str, int i2, List<CJRAggsItem> list, b bVar) {
        super(context);
        Object obj;
        k.c(str, "groupName");
        k.c(list, "aggsList");
        this.f62107c = str;
        this.f62108d = i2;
        this.f62109e = bVar;
        LayoutInflater.from(context).inflate(R.layout.radio_group_custom_view, this, true);
        ((CustomRadioGroupBaseV2) a(R.id.custom_type_radio_group)).removeAllViews();
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, Integer.valueOf(this.f62108d));
        arrayList.add(1, this.f62107c);
        CustomRadioGroupBaseV2 customRadioGroupBaseV2 = (CustomRadioGroupBaseV2) a(R.id.custom_type_radio_group);
        k.a((Object) customRadioGroupBaseV2, "custom_type_radio_group");
        customRadioGroupBaseV2.setTag(arrayList);
        setTag(arrayList);
        View a2 = a(R.id.payment_underline);
        k.a((Object) a2, "payment_underline");
        ai.b(a2);
        int f2 = com.paytm.utility.b.f(context);
        int size = list.size();
        int i3 = 0;
        while (true) {
            obj = null;
            if (i3 >= size) {
                break;
            }
            RadioButton radioButton = new RadioButton(context);
            radioButton.setId(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                radioButton.setTextAppearance(R.style.radioButtonUnselectedStyle);
            } else {
                Context context2 = radioButton.getContext();
                if (context2 == null) {
                    k.a();
                }
                radioButton.setTextAppearance(context2, R.style.radioButtonUnselectedStyle);
            }
            radioButton.setButtonDrawable(R.drawable.btn_radio_holo_light);
            radioButton.setOnTouchListener(new a(this));
            k.c(radioButton, "radioButton");
            radioButton.setPadding(f2 / 2, 0, f2, 0);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
            CJRAggsItem cJRAggsItem = list.get(i3);
            radioButton.setTag(Integer.valueOf(i3));
            if (cJRAggsItem != null) {
                obj = cJRAggsItem.getDisplayValue();
            }
            radioButton.setText((CharSequence) obj);
            radioButton.setTextColor(androidx.core.content.b.c(radioButton.getContext(), R.color.financial_key_value));
            radioButton.setTextSize(12.0f);
            ((CustomRadioGroupBaseV2) a(R.id.custom_type_radio_group)).addView(radioButton, layoutParams);
            i3++;
        }
        ((CustomRadioGroupBaseV2) a(R.id.custom_type_radio_group)).setOnCheckedChangeListener(this);
        int i4 = f2 / 2;
        ((CustomRadioGroupBaseV2) a(R.id.custom_type_radio_group)).setPadding(0, i4, 0, i4);
        CustomRadioGroupBaseV2 customRadioGroupBaseV22 = (CustomRadioGroupBaseV2) a(R.id.custom_type_radio_group);
        k.a((Object) customRadioGroupBaseV22, "custom_type_radio_group");
        if (customRadioGroupBaseV22.getChildCount() > 0) {
            CustomRadioGroupBaseV2 customRadioGroupBaseV23 = (CustomRadioGroupBaseV2) a(R.id.custom_type_radio_group);
            RadioButton radioButton2 = (RadioButton) (customRadioGroupBaseV23 != null ? customRadioGroupBaseV23.getChildAt(0) : obj);
            if (radioButton2 != null) {
                radioButton2.setChecked(true);
            }
        }
    }

    public final boolean getRemoveAllViews() {
        return this.f62105a;
    }

    public final void setRemoveAllViews(boolean z) {
        this.f62105a = z;
    }

    public final void setViewSelectedByUser(boolean z) {
        this.f62106b = z;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i2) {
        T t;
        x.e eVar = new x.e();
        CustomRadioGroupBaseV2 customRadioGroupBaseV2 = (CustomRadioGroupBaseV2) a(R.id.custom_type_radio_group);
        k.a((Object) customRadioGroupBaseV2, "custom_type_radio_group");
        int childCount = customRadioGroupBaseV2.getChildCount();
        int i3 = 0;
        while (true) {
            t = null;
            if (i3 >= childCount) {
                break;
            }
            CustomRadioGroupBaseV2 customRadioGroupBaseV22 = (CustomRadioGroupBaseV2) a(R.id.custom_type_radio_group);
            if (customRadioGroupBaseV22 != null) {
                t = customRadioGroupBaseV22.getChildAt(i3);
            }
            eVar.element = (RadioButton) t;
            if (((RadioButton) eVar.element) != null) {
                RadioButton radioButton = (RadioButton) eVar.element;
                if (radioButton == null || !radioButton.isChecked()) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        RadioButton radioButton2 = (RadioButton) eVar.element;
                        if (radioButton2 != null) {
                            radioButton2.setTextAppearance(R.style.radioButtonUnselectedStyle);
                        }
                    } else {
                        RadioButton radioButton3 = (RadioButton) eVar.element;
                        if (radioButton3 != null) {
                            radioButton3.setTextAppearance(getContext(), R.style.radioButtonUnselectedStyle);
                        }
                    }
                } else if (Build.VERSION.SDK_INT >= 23) {
                    RadioButton radioButton4 = (RadioButton) eVar.element;
                    if (radioButton4 != null) {
                        radioButton4.setTextAppearance(R.style.radioButtonSelectedStyle);
                    }
                } else {
                    RadioButton radioButton5 = (RadioButton) eVar.element;
                    if (radioButton5 != null) {
                        radioButton5.setTextAppearance(getContext(), R.style.radioButtonSelectedStyle);
                    }
                }
            }
            i3++;
        }
        T findViewById = radioGroup != null ? radioGroup.findViewById(i2) : null;
        if (findViewById != null) {
            eVar.element = (RadioButton) findViewById;
            RadioButton radioButton6 = (RadioButton) eVar.element;
            if (radioButton6 != null) {
                t = radioButton6.getTag();
            }
            if (t != null) {
                int intValue = ((Integer) t).intValue();
                b bVar = this.f62109e;
                if (bVar != null) {
                    bVar.a(this.f62108d, this.f62107c, intValue);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
        throw new u("null cannot be cast to non-null type android.widget.RadioButton");
    }

    static final class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GroupItemCustomRadioGroup f62111a;

        a(GroupItemCustomRadioGroup groupItemCustomRadioGroup) {
            this.f62111a = groupItemCustomRadioGroup;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.f62111a.setViewSelectedByUser(true);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ((CustomRadioGroupBaseV2) a(R.id.custom_type_radio_group)).setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
        super.onDetachedFromWindow();
    }
}
