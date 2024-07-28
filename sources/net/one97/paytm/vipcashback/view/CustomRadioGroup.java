package net.one97.paytm.vipcashback.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterItem;
import net.one97.paytm.vipcashback.R;

public final class CustomRadioGroup extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f21032a = -1;

    /* renamed from: b  reason: collision with root package name */
    private b<? super Integer, x> f21033b = new a(this);

    static final class a extends l implements b<Integer, x> {
        final /* synthetic */ CustomRadioGroup this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CustomRadioGroup customRadioGroup) {
            super(1);
            this.this$0 = customRadioGroup;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).intValue());
            return x.f47997a;
        }

        public final void invoke(int i2) {
            this.this$0.a(i2);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomRadioGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        k.c(attributeSet, "attr");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attr");
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
                VoucherRadioBox voucherRadioBox = new VoucherRadioBox(context, voucherFilterItem);
                voucherRadioBox.setTag(arrayList.get(i2));
                VoucherFilterItem voucherFilterItem2 = arrayList.get(i2);
                k.a((Object) voucherFilterItem2, "items.get(i)");
                String id = voucherFilterItem2.getId();
                k.a((Object) id, "items.get(i).id");
                voucherRadioBox.setId(Integer.parseInt(id));
                b<? super Integer, x> bVar = this.f21033b;
                k.c(bVar, "listner");
                voucherRadioBox.f21041a = bVar;
                addView(voucherRadioBox);
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        requestLayout();
    }

    public final b<Integer, x> getClickListener() {
        return this.f21033b;
    }

    public final void setClickListener(b<? super Integer, x> bVar) {
        k.c(bVar, "<set-?>");
        this.f21033b = bVar;
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
                    CheckBox checkBox = (CheckBox) childAt.findViewById(R.id.checkbox);
                    k.a((Object) checkBox, "childAt.checkbox");
                    if (checkBox.isChecked()) {
                        Object tag = childAt.getTag();
                        if (tag != null) {
                            arrayList.add((VoucherFilterItem) tag);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.vipcashback.VoucherFilterItem");
                        }
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

    public final void a(int i2) {
        VoucherRadioBox voucherRadioBox = (VoucherRadioBox) findViewById(i2);
        if (voucherRadioBox != null) {
            int i3 = this.f21032a;
            if (i3 != -1) {
                ((VoucherRadioBox) findViewById(i3)).a(false);
            }
            voucherRadioBox.a(true);
            this.f21032a = i2;
        }
    }
}
