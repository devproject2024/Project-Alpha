package com.paytm.business.merchantprofile.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.widget.RadioCheckable;
import java.util.HashMap;

public class CustomRadioGroup extends LinearLayout {
    public int mCheckedId = -1;
    public RadioCheckable.OnCheckedChangeListener mChildOnCheckedChangeListener;
    public HashMap<Integer, View> mChildViewsMap = new HashMap<>();
    public OnCheckedChangeListener mOnCheckedChangeListener;
    public PassThroughHierarchyChangeListener mPassThroughListener;
    public boolean mProtectFromCheckedChange = false;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(View view, View view2, boolean z, int i2);
    }

    public CustomRadioGroup(Context context) {
        super(context);
        setupView();
    }

    public CustomRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttributes(attributeSet);
        setupView();
    }

    public CustomRadioGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        parseAttributes(attributeSet);
        setupView();
    }

    public CustomRadioGroup(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        parseAttributes(attributeSet);
        setupView();
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomRadioGroup, 0, 0);
        try {
            this.mCheckedId = obtainStyledAttributes.getResourceId(R.styleable.CustomRadioGroup_RadioCheckedId, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void setupView() {
        setOrientation(1);
        this.mChildOnCheckedChangeListener = new CheckedStateTracker();
        PassThroughHierarchyChangeListener passThroughHierarchyChangeListener = new PassThroughHierarchyChangeListener();
        this.mPassThroughListener = passThroughHierarchyChangeListener;
        super.setOnHierarchyChangeListener(passThroughHierarchyChangeListener);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if ((view instanceof RadioCheckable) && ((RadioCheckable) view).isChecked()) {
            this.mProtectFromCheckedChange = true;
            int i3 = this.mCheckedId;
            if (i3 != -1) {
                setCheckedStateForView(i3, false);
            }
            this.mProtectFromCheckedChange = false;
            setCheckedId(view.getId(), true);
        }
        super.addView(view, i2, layoutParams);
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ViewGroup.OnHierarchyChangeListener unused = this.mPassThroughListener.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.mCheckedId;
        if (i2 != -1) {
            this.mProtectFromCheckedChange = true;
            setCheckedStateForView(i2, true);
            this.mProtectFromCheckedChange = false;
            setCheckedId(this.mCheckedId, true);
        }
    }

    /* access modifiers changed from: private */
    public void setCheckedId(int i2, boolean z) {
        this.mCheckedId = i2;
        OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, this.mChildViewsMap.get(Integer.valueOf(i2)), z, this.mCheckedId);
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearCheck() {
        check(-1);
    }

    public void check(int i2) {
        if (i2 == -1 || i2 != this.mCheckedId) {
            int i3 = this.mCheckedId;
            if (i3 != -1) {
                setCheckedStateForView(i3, false);
            }
            if (i2 != -1) {
                setCheckedStateForView(i2, true);
            }
            setCheckedId(i2, true);
        }
    }

    public void checkAtIndex(int i2) {
        check(getChildAt(i2).getId());
    }

    /* access modifiers changed from: private */
    public void setCheckedStateForView(int i2, boolean z) {
        View view = this.mChildViewsMap.get(Integer.valueOf(i2));
        if (view == null && (view = findViewById(i2)) != null) {
            this.mChildViewsMap.put(Integer.valueOf(i2), view);
        }
        if (view != null && (view instanceof RadioCheckable)) {
            ((RadioCheckable) view).setChecked(z);
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
    }

    public OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.mOnCheckedChangeListener;
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(int i2, int i3, float f2) {
            super(i2, i3, f2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public void setBaseAttributes(TypedArray typedArray, int i2, int i3) {
            if (typedArray.hasValue(i2)) {
                this.width = typedArray.getLayoutDimension(i2, "layout_width");
            } else {
                this.width = -2;
            }
            if (typedArray.hasValue(i3)) {
                this.height = typedArray.getLayoutDimension(i3, "layout_height");
            } else {
                this.height = -2;
            }
        }
    }

    public class CheckedStateTracker implements RadioCheckable.OnCheckedChangeListener {
        public CheckedStateTracker() {
        }

        public void onCheckedChanged(View view, boolean z) {
            if (!CustomRadioGroup.this.mProtectFromCheckedChange) {
                boolean unused = CustomRadioGroup.this.mProtectFromCheckedChange = true;
                if (CustomRadioGroup.this.mCheckedId != -1) {
                    CustomRadioGroup customRadioGroup = CustomRadioGroup.this;
                    customRadioGroup.setCheckedStateForView(customRadioGroup.mCheckedId, false);
                }
                boolean unused2 = CustomRadioGroup.this.mProtectFromCheckedChange = false;
                CustomRadioGroup.this.setCheckedId(view.getId(), true);
            }
        }
    }

    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;

        public PassThroughHierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == CustomRadioGroup.this && (view2 instanceof RadioCheckable)) {
                int id = view2.getId();
                if (id == -1) {
                    id = View.generateViewId();
                    view2.setId(id);
                }
                ((RadioCheckable) view2).addOnCheckChangeListener(CustomRadioGroup.this.mChildOnCheckedChangeListener);
                CustomRadioGroup.this.mChildViewsMap.put(Integer.valueOf(id), view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CustomRadioGroup customRadioGroup = CustomRadioGroup.this;
            if (view == customRadioGroup && (view2 instanceof RadioCheckable)) {
                ((RadioCheckable) view2).removeOnCheckChangeListener(customRadioGroup.mChildOnCheckedChangeListener);
            }
            CustomRadioGroup.this.mChildViewsMap.remove(Integer.valueOf(view2.getId()));
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }
}
