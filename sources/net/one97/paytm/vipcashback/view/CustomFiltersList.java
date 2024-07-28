package net.one97.paytm.vipcashback.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterItem;

public final class CustomFiltersList extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f21030a = 5;

    /* renamed from: b  reason: collision with root package name */
    private Paint f21031b = new Paint();

    public final Paint getPaint() {
        return this.f21031b;
    }

    public final void setPaint(Paint paint) {
        this.f21031b = paint;
    }

    public final void setVisibleCount(int i2) {
        this.f21030a = i2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomFiltersList(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        k.c(context, "context");
        k.c(attributeSet, "attr");
        Paint paint = this.f21031b;
        if (paint != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                i3 = resources.getColor(R.color.color_001d4d);
            } else {
                i3 = Color.parseColor("#ff0000");
            }
            paint.setColor(i3);
        }
        Paint paint2 = this.f21031b;
        if (paint2 != null) {
            paint2.setStyle(Paint.Style.STROKE);
        }
        Paint paint3 = this.f21031b;
        if (paint3 != null) {
            paint3.setStrokeWidth(2.0f);
        }
        Paint paint4 = this.f21031b;
        if (paint4 != null) {
            paint4.setAntiAlias(true);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomFiltersList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        k.c(context, "context");
        k.c(attributeSet, "attr");
        Paint paint = this.f21031b;
        if (paint != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                i2 = resources.getColor(R.color.color_001d4d);
            } else {
                i2 = Color.parseColor("#ff0000");
            }
            paint.setColor(i2);
        }
        Paint paint2 = this.f21031b;
        if (paint2 != null) {
            paint2.setStyle(Paint.Style.STROKE);
        }
        Paint paint3 = this.f21031b;
        if (paint3 != null) {
            paint3.setStrokeWidth(2.0f);
        }
        Paint paint4 = this.f21031b;
        if (paint4 != null) {
            paint4.setAntiAlias(true);
        }
    }

    public final void a(ArrayList<VoucherFilterItem> arrayList) {
        k.c(arrayList, "items");
        int size = arrayList.size() - 1;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                Context context = getContext();
                k.a((Object) context, "context");
                VoucherFilterItem voucherFilterItem = arrayList.get(i2);
                k.a((Object) voucherFilterItem, "items.get(i)");
                VoucherCheckBox voucherCheckBox = new VoucherCheckBox(context, voucherFilterItem);
                voucherCheckBox.setTag(arrayList.get(i2));
                addView(voucherCheckBox);
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        requestLayout();
    }

    public final int getSelectedCount() {
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                getChildAt(i2);
                if (i2 == childCount) {
                    break;
                }
                i2++;
            }
        }
        return 0;
    }

    public final ArrayList<VoucherFilterItem> getSelectedFilter() {
        ArrayList<VoucherFilterItem> arrayList = new ArrayList<>();
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                View childAt = getChildAt(i2);
                if (childAt instanceof VoucherCheckBox) {
                    Object tag = childAt.getTag();
                    if (tag != null) {
                        VoucherFilterItem voucherFilterItem = (VoucherFilterItem) tag;
                        CheckBox checkBox = (CheckBox) childAt.findViewById(net.one97.paytm.vipcashback.R.id.checkbox);
                        k.a((Object) checkBox, "childAt.checkbox");
                        voucherFilterItem.setSelected(checkBox.isChecked());
                        if (voucherFilterItem.isSelected()) {
                            arrayList.add(voucherFilterItem);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.vipcashback.VoucherFilterItem");
                    }
                }
                if (i2 == childCount) {
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    public final void a() {
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                View childAt = getChildAt(i2);
                if (childAt instanceof VoucherCheckBox) {
                    CheckBox checkBox = (CheckBox) childAt.findViewById(net.one97.paytm.vipcashback.R.id.checkbox);
                    k.a((Object) checkBox, "childAt.checkbox");
                    if (checkBox.isChecked()) {
                        CheckBox checkBox2 = (CheckBox) childAt.findViewById(net.one97.paytm.vipcashback.R.id.checkbox);
                        k.a((Object) checkBox2, "childAt.checkbox");
                        checkBox2.setChecked(false);
                    }
                }
                if (i2 != childCount) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
