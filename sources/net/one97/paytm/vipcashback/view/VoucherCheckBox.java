package net.one97.paytm.vipcashback.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterItem;
import net.one97.paytm.vipcashback.R;

public final class VoucherCheckBox extends LinearLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoucherCheckBox(Context context, VoucherFilterItem voucherFilterItem) {
        super(context);
        k.c(context, "context");
        k.c(voucherFilterItem, "item");
        final View inflate = LayoutInflater.from(context).inflate(R.layout.voucher_filter_item, (ViewGroup) null, false);
        k.a((Object) inflate, "inflate");
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        k.a((Object) textView, "inflate.title");
        textView.setText(voucherFilterItem.getDisplayName());
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkbox);
        k.a((Object) checkBox, "inflate.checkbox");
        checkBox.setChecked(voucherFilterItem.isSelected());
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                View view2 = inflate;
                k.a((Object) view2, "inflate");
                CheckBox checkBox = (CheckBox) view2.findViewById(R.id.checkbox);
                k.a((Object) checkBox, "inflate.checkbox");
                View view3 = inflate;
                k.a((Object) view3, "inflate");
                CheckBox checkBox2 = (CheckBox) view3.findViewById(R.id.checkbox);
                k.a((Object) checkBox2, "inflate.checkbox");
                checkBox.setChecked(!checkBox2.isChecked());
                inflate.invalidate();
            }
        });
        addView(inflate);
    }
}
