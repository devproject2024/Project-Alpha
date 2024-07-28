package net.one97.paytm.common.utility;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;

public class RadioGridGroup extends TableLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RadioButton f49591a;

    /* renamed from: b  reason: collision with root package name */
    private a f49592b;

    public interface a {
        void onCheckChange(View view);
    }

    public RadioGridGroup(Context context) {
        super(context);
    }

    public RadioGridGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onClick(View view) {
        a aVar = this.f49592b;
        if (aVar != null) {
            aVar.onCheckChange(view);
        }
        RadioButton radioButton = (RadioButton) view;
        RadioButton radioButton2 = this.f49591a;
        if (radioButton2 != null) {
            radioButton2.setChecked(false);
        }
        if (radioButton != null) {
            radioButton.setChecked(true);
            this.f49591a = radioButton;
        }
    }

    public void setCheckChangeListener(a aVar) {
        this.f49592b = aVar;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        setChildrenOnClickListener((TableRow) view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        setChildrenOnClickListener((TableRow) view);
    }

    private void setChildrenOnClickListener(TableRow tableRow) {
        int childCount = tableRow.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = tableRow.getChildAt(i2);
            if (childAt instanceof RadioButton) {
                childAt.setOnClickListener(this);
            }
        }
    }

    public int getCheckedRadioButtonId() {
        RadioButton radioButton = this.f49591a;
        if (radioButton != null) {
            return radioButton.getId();
        }
        return -1;
    }
}
