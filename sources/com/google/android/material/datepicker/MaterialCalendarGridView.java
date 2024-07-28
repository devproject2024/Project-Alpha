package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.g.d;
import androidx.core.h.a;
import androidx.core.h.a.c;
import androidx.core.h.u;
import com.google.android.material.R;
import java.util.Calendar;

final class MaterialCalendarGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f36152a;

    public MaterialCalendarGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f36152a = o.b();
        if (g.a(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        u.a((View) this, (a) new a() {
            public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                cVar.a((Object) null);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((i) super.getAdapter()).notifyDataSetChanged();
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((i) super.getAdapter()).f36245b.b()) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(((i) super.getAdapter()).f36245b.b());
        return true;
    }

    public final i a() {
        return (i) super.getAdapter();
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof i) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), i.class.getCanonicalName()}));
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        i iVar = (i) super.getAdapter();
        DateSelector<?> dateSelector = iVar.f36246c;
        b bVar = iVar.f36247d;
        Long a2 = iVar.getItem(iVar.f36245b.b());
        Long a3 = iVar.getItem(iVar.a());
        for (d next : dateSelector.d()) {
            if (!(next.f2964a == null || next.f2965b == null)) {
                long longValue = ((Long) next.f2964a).longValue();
                long longValue2 = ((Long) next.f2965b).longValue();
                Long valueOf = Long.valueOf(longValue);
                Long valueOf2 = Long.valueOf(longValue2);
                int i6 = 1;
                if (!(a2 == null || a3 == null || valueOf == null || valueOf2 == null || valueOf.longValue() > a3.longValue() || valueOf2.longValue() < a2.longValue())) {
                    if (longValue < a2.longValue()) {
                        i3 = iVar.f36245b.b();
                        i2 = i3 % iVar.f36245b.f36158e == 0 ? 0 : materialCalendarGridView.getChildAt(i3 - 1).getRight();
                    } else {
                        materialCalendarGridView.f36152a.setTimeInMillis(longValue);
                        i3 = iVar.b(materialCalendarGridView.f36152a.get(5));
                        i2 = a(materialCalendarGridView.getChildAt(i3));
                    }
                    if (longValue2 > a3.longValue()) {
                        i5 = Math.min(iVar.a(), getChildCount() - 1);
                        if ((i5 + 1) % iVar.f36245b.f36158e == 0) {
                            i4 = getWidth();
                        } else {
                            i4 = materialCalendarGridView.getChildAt(i5).getRight();
                        }
                    } else {
                        materialCalendarGridView.f36152a.setTimeInMillis(longValue2);
                        i5 = iVar.b(materialCalendarGridView.f36152a.get(5));
                        i4 = a(materialCalendarGridView.getChildAt(i5));
                    }
                    int itemId = (int) iVar.getItemId(i3);
                    int itemId2 = (int) iVar.getItemId(i5);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - i6;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect((float) (numColumns > i3 ? 0 : i2), (float) (childAt.getTop() + bVar.f36184a.f36178a.top), (float) (i5 > numColumns2 ? getWidth() : i4), (float) (childAt.getBottom() - bVar.f36184a.f36178a.bottom), bVar.f36191h);
                        itemId++;
                        i6 = 1;
                        materialCalendarGridView = this;
                    }
                } else {
                    return;
                }
            }
            materialCalendarGridView = this;
        }
    }

    private static int a(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    public final void setSelection(int i2) {
        if (i2 < ((i) super.getAdapter()).f36245b.b()) {
            super.setSelection(((i) super.getAdapter()).f36245b.b());
        } else {
            super.setSelection(i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void onFocusChanged(boolean z, int i2, Rect rect) {
        if (!z) {
            super.onFocusChanged(false, i2, rect);
        } else if (i2 == 33) {
            setSelection(((i) super.getAdapter()).a());
        } else if (i2 == 130) {
            setSelection(((i) super.getAdapter()).f36245b.b());
        } else {
            super.onFocusChanged(true, i2, rect);
        }
    }
}
