package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.h.a.c;
import androidx.core.h.h;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.k;
import com.google.android.material.internal.q;
import com.google.android.material.k.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36031a = MaterialButtonToggleGroup.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final int f36032b = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f36033c;

    /* renamed from: d  reason: collision with root package name */
    private final a f36034d;

    /* renamed from: e  reason: collision with root package name */
    private final c f36035e;

    /* renamed from: f  reason: collision with root package name */
    private final LinkedHashSet<Object> f36036f;

    /* renamed from: g  reason: collision with root package name */
    private final Comparator<MaterialButton> f36037g;

    /* renamed from: h  reason: collision with root package name */
    private Integer[] f36038h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f36039i;
    /* access modifiers changed from: private */
    public boolean j;
    private boolean k;
    /* access modifiers changed from: private */
    public int l;

    public MaterialButtonToggleGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f36032b), attributeSet, i2);
        this.f36033c = new ArrayList();
        this.f36034d = new a(this, (byte) 0);
        this.f36035e = new c(this, (byte) 0);
        this.f36036f = new LinkedHashSet<>();
        this.f36037g = new Comparator<MaterialButton>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
            }
        };
        this.f36039i = false;
        TypedArray a2 = k.a(getContext(), attributeSet, R.styleable.MaterialButtonToggleGroup, i2, f36032b, new int[0]);
        setSingleSelection(a2.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.l = a2.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.k = a2.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        a2.recycle();
        u.c((View) this, 1);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.l;
        if (i2 != -1) {
            a(i2, true);
            b(i2, true);
            setCheckedId(i2);
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i2, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            if (materialButton.isChecked()) {
                b(materialButton.getId(), true);
                setCheckedId(materialButton.getId());
            }
            m shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.f36033c.add(new b(shapeAppearanceModel.f36554f, shapeAppearanceModel.f36557i, shapeAppearanceModel.f36555g, shapeAppearanceModel.f36556h));
            u.a((View) materialButton, (androidx.core.h.a) new androidx.core.h.a() {
                public final void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.c cVar) {
                    super.onInitializeAccessibilityNodeInfo(view, cVar);
                    cVar.b((Object) c.C0046c.a(0, 1, MaterialButtonToggleGroup.a(MaterialButtonToggleGroup.this, view), 1, false, ((MaterialButton) view).isChecked()));
                }
            });
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.f36025a.remove(this.f36034d);
            materialButton.setOnPressedChangeListenerInternal((MaterialButton.b) null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f36033c.remove(indexOfChild);
        }
        b();
        a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        b();
        a();
        super.onMeasure(i2, i3);
    }

    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.h.a.c.a(accessibilityNodeInfo).a((Object) c.b.a(1, getVisibleButtonCount(), false, this.j ? 1 : 2));
    }

    public int getCheckedButtonId() {
        if (this.j) {
            return this.l;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton a2 = a(i2);
            if (a2.isChecked()) {
                arrayList.add(Integer.valueOf(a2.getId()));
            }
        }
        return arrayList;
    }

    public void setSingleSelection(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.f36039i = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                MaterialButton a2 = a(i2);
                a2.setChecked(false);
                a2.getId();
                c();
            }
            this.f36039i = false;
            setCheckedId(-1);
        }
    }

    public void setSelectionRequired(boolean z) {
        this.k = z;
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    private void a(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.f36039i = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.f36039i = false;
        }
    }

    private void setCheckedId(int i2) {
        this.l = i2;
        c();
    }

    private void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
                MaterialButton a2 = a(i2);
                int min = Math.min(a2.getStrokeWidth(), a(i2 - 1).getStrokeWidth());
                LinearLayout.LayoutParams a3 = a((View) a2);
                if (getOrientation() == 0) {
                    h.b(a3, 0);
                    h.a(a3, -min);
                } else {
                    a3.bottomMargin = 0;
                    a3.topMargin = -min;
                }
                a2.setLayoutParams(a3);
            }
            b(firstVisibleChildIndex);
        }
    }

    private MaterialButton a(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    private void b(int i2) {
        if (getChildCount() != 0 && i2 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a(i2).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            h.b(layoutParams, 0);
            h.a(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void b() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton a2 = a(i2);
            if (a2.getVisibility() != 8) {
                m.a b2 = a2.getShapeAppearanceModel().b();
                a(b2, a(i2, firstVisibleChildIndex, lastVisibleChildIndex));
                a2.setShapeAppearanceModel(b2.a());
            }
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (c(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private boolean c(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && c(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private b a(int i2, int i3, int i4) {
        b bVar = this.f36033c.get(i2);
        if (i3 == i4) {
            return bVar;
        }
        boolean z = getOrientation() == 0;
        if (i2 == i3) {
            return z ? b.a(bVar, this) : b.a(bVar);
        }
        if (i2 == i4) {
            return z ? b.b(bVar, this) : b.b(bVar);
        }
        return null;
    }

    private static void a(m.a aVar, b bVar) {
        if (bVar == null) {
            aVar.a(0.0f);
            return;
        }
        aVar.f36562e = bVar.f36044a;
        aVar.f36565h = bVar.f36047d;
        aVar.f36563f = bVar.f36045b;
        aVar.f36564g = bVar.f36046c;
    }

    /* access modifiers changed from: private */
    public boolean b(int i2, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (!this.k || !checkedButtonIds.isEmpty()) {
            if (z && this.j) {
                checkedButtonIds.remove(Integer.valueOf(i2));
                for (Integer intValue : checkedButtonIds) {
                    a(intValue.intValue(), false);
                    c();
                }
            }
            return true;
        }
        a(i2, true);
        this.l = i2;
        return false;
    }

    /* access modifiers changed from: private */
    public void c() {
        Iterator it2 = this.f36036f.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(u.a());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.f36025a.add(this.f36034d);
        materialButton.setOnPressedChangeListenerInternal(this.f36035e);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private static LinearLayout.LayoutParams a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f36038h;
        return (numArr == null || i3 >= numArr.length) ? i3 : numArr[i3].intValue();
    }

    class a implements MaterialButton.a {
        private a() {
        }

        /* synthetic */ a(MaterialButtonToggleGroup materialButtonToggleGroup, byte b2) {
            this();
        }

        public final void a(MaterialButton materialButton, boolean z) {
            if (!MaterialButtonToggleGroup.this.f36039i) {
                if (MaterialButtonToggleGroup.this.j) {
                    int unused = MaterialButtonToggleGroup.this.l = z ? materialButton.getId() : -1;
                }
                if (MaterialButtonToggleGroup.this.b(materialButton.getId(), z)) {
                    MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
                    materialButton.getId();
                    materialButton.isChecked();
                    materialButtonToggleGroup.c();
                }
                MaterialButtonToggleGroup.this.invalidate();
            }
        }
    }

    class c implements MaterialButton.b {
        private c() {
        }

        /* synthetic */ c(MaterialButtonToggleGroup materialButtonToggleGroup, byte b2) {
            this();
        }

        public final void a() {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    static class b {

        /* renamed from: e  reason: collision with root package name */
        private static final com.google.android.material.k.c f36043e = new com.google.android.material.k.a(0.0f);

        /* renamed from: a  reason: collision with root package name */
        com.google.android.material.k.c f36044a;

        /* renamed from: b  reason: collision with root package name */
        com.google.android.material.k.c f36045b;

        /* renamed from: c  reason: collision with root package name */
        com.google.android.material.k.c f36046c;

        /* renamed from: d  reason: collision with root package name */
        com.google.android.material.k.c f36047d;

        b(com.google.android.material.k.c cVar, com.google.android.material.k.c cVar2, com.google.android.material.k.c cVar3, com.google.android.material.k.c cVar4) {
            this.f36044a = cVar;
            this.f36045b = cVar3;
            this.f36046c = cVar4;
            this.f36047d = cVar2;
        }

        public static b a(b bVar, View view) {
            return q.a(view) ? d(bVar) : c(bVar);
        }

        public static b b(b bVar, View view) {
            return q.a(view) ? c(bVar) : d(bVar);
        }

        private static b c(b bVar) {
            com.google.android.material.k.c cVar = bVar.f36044a;
            com.google.android.material.k.c cVar2 = bVar.f36047d;
            com.google.android.material.k.c cVar3 = f36043e;
            return new b(cVar, cVar2, cVar3, cVar3);
        }

        private static b d(b bVar) {
            com.google.android.material.k.c cVar = f36043e;
            return new b(cVar, cVar, bVar.f36045b, bVar.f36046c);
        }

        public static b a(b bVar) {
            com.google.android.material.k.c cVar = bVar.f36044a;
            com.google.android.material.k.c cVar2 = f36043e;
            return new b(cVar, cVar2, bVar.f36045b, cVar2);
        }

        public static b b(b bVar) {
            com.google.android.material.k.c cVar = f36043e;
            return new b(cVar, bVar.f36047d, cVar, bVar.f36046c);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f36037g);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(a(i2), Integer.valueOf(i2));
        }
        this.f36038h = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    static /* synthetic */ int a(MaterialButtonToggleGroup materialButtonToggleGroup, View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < materialButtonToggleGroup.getChildCount(); i3++) {
            if (materialButtonToggleGroup.getChildAt(i3) == view) {
                return i2;
            }
            if ((materialButtonToggleGroup.getChildAt(i3) instanceof MaterialButton) && materialButtonToggleGroup.c(i3)) {
                i2++;
            }
        }
        return -1;
    }
}
