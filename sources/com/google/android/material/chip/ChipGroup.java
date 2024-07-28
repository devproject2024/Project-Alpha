package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.h.a.c;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.k;
import java.util.ArrayList;
import java.util.List;

public class ChipGroup extends FlowLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f36093a = R.style.Widget_MaterialComponents_ChipGroup;

    /* renamed from: b  reason: collision with root package name */
    private int f36094b;

    /* renamed from: c  reason: collision with root package name */
    private int f36095c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f36096d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f36097e;

    /* renamed from: f  reason: collision with root package name */
    private b f36098f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final a f36099g;

    /* renamed from: h  reason: collision with root package name */
    private c f36100h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f36101i;
    /* access modifiers changed from: private */
    public boolean j;

    public interface b {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams() {
            super(-2, -2);
        }
    }

    public ChipGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f36093a), attributeSet, i2);
        this.f36099g = new a(this, (byte) 0);
        this.f36100h = new c(this, (byte) 0);
        this.f36101i = -1;
        this.j = false;
        TypedArray a2 = k.a(getContext(), attributeSet, R.styleable.ChipGroup, i2, f36093a, new int[0]);
        int dimensionPixelOffset = a2.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(a2.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(a2.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(a2.getBoolean(R.styleable.ChipGroup_singleLine, false));
        setSingleSelection(a2.getBoolean(R.styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(a2.getBoolean(R.styleable.ChipGroup_selectionRequired, false));
        int resourceId = a2.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.f36101i = resourceId;
        }
        a2.recycle();
        super.setOnHierarchyChangeListener(this.f36100h);
        u.c((View) this, 1);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.h.a.c.a(accessibilityNodeInfo).a((Object) c.b.a(getRowCount(), super.a() ? getChipCount() : -1, false, this.f36096d ? 1 : 2));
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ViewGroup.OnHierarchyChangeListener unused = this.f36100h.f36104b = onHierarchyChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f36101i;
        if (i2 != -1) {
            a(i2, true);
            setCheckedId(this.f36101i);
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i3 = this.f36101i;
                if (i3 != -1 && this.f36096d) {
                    a(i3, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i2, layoutParams);
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public int getCheckedChipId() {
        if (this.f36096d) {
            return this.f36101i;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f36096d) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public void setOnCheckedChangeListener(b bVar) {
        this.f36098f = bVar;
    }

    /* access modifiers changed from: private */
    public void a(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof Chip) {
            this.j = true;
            ((Chip) findViewById).setChecked(z);
            this.j = false;
        }
    }

    private int getChipCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof Chip) {
                i2++;
            }
        }
        return i2;
    }

    public void setChipSpacing(int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingResource(int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public int getChipSpacingHorizontal() {
        return this.f36094b;
    }

    public void setChipSpacingHorizontal(int i2) {
        if (this.f36094b != i2) {
            this.f36094b = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public int getChipSpacingVertical() {
        return this.f36095c;
    }

    public void setChipSpacingVertical(int i2) {
        if (this.f36095c != i2) {
            this.f36095c = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    public final boolean a() {
        return super.a();
    }

    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleLine(int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    public void setSingleSelection(boolean z) {
        if (this.f36096d != z) {
            this.f36096d = z;
            this.j = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof Chip) {
                    ((Chip) childAt).setChecked(false);
                }
            }
            this.j = false;
            setCheckedId(-1);
        }
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    public void setSelectionRequired(boolean z) {
        this.f36097e = z;
    }

    class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        /* synthetic */ a(ChipGroup chipGroup, byte b2) {
            this();
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!ChipGroup.this.j) {
                if (!ChipGroup.this.getCheckedChipIds().isEmpty() || !ChipGroup.this.f36097e) {
                    int id = compoundButton.getId();
                    if (z) {
                        if (!(ChipGroup.this.f36101i == -1 || ChipGroup.this.f36101i == id || !ChipGroup.this.f36096d)) {
                            ChipGroup chipGroup = ChipGroup.this;
                            chipGroup.a(chipGroup.f36101i, false);
                        }
                        ChipGroup.this.setCheckedId(id);
                    } else if (ChipGroup.this.f36101i == id) {
                        ChipGroup.this.setCheckedId(-1);
                    }
                } else {
                    ChipGroup.this.a(compoundButton.getId(), true);
                    ChipGroup.this.f36101i = compoundButton.getId();
                }
            }
        }
    }

    class c implements ViewGroup.OnHierarchyChangeListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup.OnHierarchyChangeListener f36104b;

        private c() {
        }

        /* synthetic */ c(ChipGroup chipGroup, byte b2) {
            this();
        }

        public final void onChildViewAdded(View view, View view2) {
            int i2;
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        i2 = View.generateViewId();
                    } else {
                        i2 = view2.hashCode();
                    }
                    view2.setId(i2);
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.f36099g);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f36104b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal((CompoundButton.OnCheckedChangeListener) null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f36104b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setCheckedId(int i2) {
        this.f36101i = i2;
    }
}
