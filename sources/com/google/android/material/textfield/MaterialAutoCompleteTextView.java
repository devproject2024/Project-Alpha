package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R;
import com.google.android.material.internal.c;
import com.google.android.material.internal.k;
import com.google.android.material.theme.a.a;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ListPopupWindow f36774a;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityManager f36775b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f36776c;

    public MaterialAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(a.a(context, attributeSet, i2, 0), attributeSet, i2);
        this.f36776c = new Rect();
        Context context2 = getContext();
        TypedArray a2 = k.a(context2, attributeSet, R.styleable.MaterialAutoCompleteTextView, i2, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (a2.hasValue(R.styleable.MaterialAutoCompleteTextView_android_inputType) && a2.getInt(R.styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener((KeyListener) null);
        }
        this.f36775b = (AccessibilityManager) context2.getSystemService("accessibility");
        this.f36774a = new ListPopupWindow(context2);
        this.f36774a.i();
        ListPopupWindow listPopupWindow = this.f36774a;
        listPopupWindow.k = this;
        listPopupWindow.j();
        this.f36774a.a(getAdapter());
        this.f36774a.l = new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object obj;
                View view2 = null;
                if (i2 < 0) {
                    ListPopupWindow a2 = MaterialAutoCompleteTextView.this.f36774a;
                    obj = !a2.p.isShowing() ? null : a2.f1557e.getSelectedItem();
                } else {
                    obj = MaterialAutoCompleteTextView.this.getAdapter().getItem(i2);
                }
                MaterialAutoCompleteTextView.a(MaterialAutoCompleteTextView.this, obj);
                AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i2 < 0) {
                        ListPopupWindow a3 = MaterialAutoCompleteTextView.this.f36774a;
                        if (a3.p.isShowing()) {
                            view2 = a3.f1557e.getSelectedView();
                        }
                        view = view2;
                        i2 = MaterialAutoCompleteTextView.this.f36774a.m();
                        ListPopupWindow a4 = MaterialAutoCompleteTextView.this.f36774a;
                        if (!a4.p.isShowing()) {
                            j = Long.MIN_VALUE;
                        } else {
                            j = a4.f1557e.getSelectedItemId();
                        }
                    }
                    onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f36774a.f1557e, view, i2, j);
                }
                MaterialAutoCompleteTextView.this.f36774a.d();
            }
        };
        a2.recycle();
    }

    public void showDropDown() {
        AccessibilityManager accessibilityManager;
        if (getInputType() != 0 || (accessibilityManager = this.f36775b) == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f36774a.a_();
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f36774a.a(getAdapter());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout a2 = a();
        if (a2 != null && a2.f36783c && super.getHint() == null && c.a()) {
            setHint("");
        }
    }

    public CharSequence getHint() {
        TextInputLayout a2 = a();
        if (a2 == null || !a2.f36783c) {
            return super.getHint();
        }
        return a2.getHint();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout a2 = a();
            int i4 = 0;
            if (!(adapter == null || a2 == null)) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                int min = Math.min(adapter.getCount(), Math.max(0, this.f36774a.m()) + 15);
                View view = null;
                int i5 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i4) {
                        view = null;
                        i4 = itemViewType;
                    }
                    view = adapter.getView(max, view, a2);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i5 = Math.max(i5, view.getMeasuredWidth());
                }
                Drawable background = this.f36774a.p.getBackground();
                if (background != null) {
                    background.getPadding(this.f36776c);
                    i5 += this.f36776c.left + this.f36776c.right;
                }
                i4 = i5 + a2.getEndIconView().getMeasuredWidth();
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i4), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    private TextInputLayout a() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    static /* synthetic */ void a(MaterialAutoCompleteTextView materialAutoCompleteTextView, Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            materialAutoCompleteTextView.setText(materialAutoCompleteTextView.convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = materialAutoCompleteTextView.getAdapter();
        materialAutoCompleteTextView.setAdapter((ListAdapter) null);
        materialAutoCompleteTextView.setText(materialAutoCompleteTextView.convertSelectionToString(obj));
        materialAutoCompleteTextView.setAdapter(adapter);
    }
}
