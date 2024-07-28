package net.one97.paytm.paymentsBank.si.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.paymentsBank.R;

public final class ChipsView extends ViewGroup {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b<? super a, x> f18904a;

    /* renamed from: b  reason: collision with root package name */
    private int f18905b;

    /* renamed from: c  reason: collision with root package name */
    private View f18906c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f18907d = 0;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<a> f18908e = new ArrayList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipsView(Context context) {
        super(context);
        k.c(context, "context");
        this.f18905b = context.getResources().getDimensionPixelOffset(R.dimen.dimen_10dp);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attr");
        this.f18905b = context.getResources().getDimensionPixelOffset(R.dimen.dimen_15dp);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        k.c(attributeSet, "attr");
        this.f18905b = context.getResources().getDimensionPixelOffset(R.dimen.dimen_10dp);
    }

    public final int getMargin() {
        return this.f18905b;
    }

    public final void setMargin(int i2) {
        this.f18905b = i2;
    }

    public final View getSelectedView() {
        return this.f18906c;
    }

    public final void setSelectedView(View view) {
        this.f18906c = view;
    }

    public final int getItemResourceId() {
        return this.f18907d;
    }

    public final void setItemResourceId(int i2) {
        this.f18907d = i2;
    }

    public final ArrayList<a> getData() {
        return this.f18908e;
    }

    public final void setData(ArrayList<a> arrayList) {
        k.c(arrayList, "<set-?>");
        this.f18908e = arrayList;
    }

    public final void setArrayData(ArrayList<a> arrayList, String str) {
        k.c(arrayList, "data");
        k.c(str, "selectedText");
        this.f18908e = arrayList;
        Iterator<a> it2 = this.f18908e.iterator();
        while (true) {
            int i2 = 0;
            if (it2.hasNext()) {
                a next = it2.next();
                View inflate = View.inflate(getContext(), getResourceId(), (ViewGroup) null);
                if (inflate != null) {
                    TextView textView = (TextView) inflate;
                    textView.setText(next.f18939b);
                    textView.setTag(next);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    textView.setOnClickListener(new a(this, textView));
                    int i3 = this.f18905b;
                    layoutParams.setMargins(0, i3, i3, i3);
                    addView(textView, layoutParams);
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
            } else {
                if (TextUtils.isEmpty(str)) {
                    this.f18906c = getChildAt(0);
                } else {
                    int size = arrayList.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            a aVar = arrayList.get(i2);
                            k.a((Object) aVar, "data.get(index)");
                            if (!aVar.f18938a.equals(str)) {
                                if (i2 == size) {
                                    break;
                                }
                                i2++;
                            } else {
                                this.f18906c = getChildAt(i2);
                                break;
                            }
                        }
                    }
                }
                View view = this.f18906c;
                if (view != null) {
                    view.setSelected(true);
                    return;
                }
                return;
            }
        }
    }

    public final void setSelectListener(b<? super a, x> bVar) {
        k.c(bVar, "listener");
        this.f18904a = bVar;
    }

    public final void setResouceId(int i2) {
        this.f18907d = i2;
    }

    public final int getResourceId() {
        return this.f18907d;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChipsView f18909a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f18910b;

        a(ChipsView chipsView, TextView textView) {
            this.f18909a = chipsView;
            this.f18910b = textView;
        }

        public final void onClick(View view) {
            Object tag;
            b a2;
            View selectedView = this.f18909a.getSelectedView();
            if (selectedView != null) {
                selectedView.setSelected(false);
            }
            this.f18910b.setSelected(true);
            this.f18909a.setSelectedView(this.f18910b);
            View selectedView2 = this.f18909a.getSelectedView();
            if (selectedView2 != null && (tag = selectedView2.getTag()) != null && (a2 = this.f18909a.f18904a) != null) {
                if (tag != null) {
                    a2.invoke((a) tag);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.si.view.ChipsViewData");
            }
        }
    }

    public final Object getSelectedValue() {
        View view = this.f18906c;
        Object obj = null;
        if ((view != null ? view.getTag() : null) instanceof Object) {
            View view2 = this.f18906c;
            if (view2 != null) {
                obj = view2.getTag();
            }
            if (obj == null) {
                throw new u("null cannot be cast to non-null type java.lang.Object");
            }
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i4 = paddingTop;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                View childAt = getChildAt(i5);
                childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, 0));
                k.a((Object) childAt, "child");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i6 += measuredWidth;
                    if (i6 > size) {
                        i4 += i7;
                        int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin;
                        if (i5 == childCount) {
                            i4 += measuredHeight;
                        }
                        i7 = measuredHeight;
                        i6 = measuredWidth;
                    } else {
                        i7 = Math.max(i7, childAt.getMeasuredHeight() + marginLayoutParams.topMargin);
                        if (i5 == childCount) {
                            i4 += i7;
                        }
                    }
                    if (i5 == childCount) {
                        paddingTop = i4;
                        break;
                    }
                    i5++;
                } else {
                    throw new u("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            }
        }
        setMeasuredDimension(i2, View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824));
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                View childAt = getChildAt(i6);
                k.a((Object) childAt, "child");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    int i10 = i7 + measuredWidth;
                    if (i10 > i4) {
                        i8 += i9;
                        int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin;
                        childAt.layout(0, i8, childAt.getMeasuredWidth() + 0, childAt.getMeasuredHeight() + i8);
                        i9 = measuredHeight;
                        i7 = measuredWidth;
                    } else {
                        childAt.layout(i7, i8, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + i8);
                        i9 = Math.max(i9, childAt.getMeasuredHeight() + marginLayoutParams.topMargin);
                        i7 = i10;
                    }
                    if (i6 != childCount) {
                        i6++;
                    } else {
                        return;
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            }
        }
    }
}
