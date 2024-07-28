package net.one97.paytm.passbook.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import net.one97.paytm.passbook.R;

public class ToggleStatusButton extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ToggleButton f57199a;

    public ToggleStatusButton(Context context, String str) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.pass_search_toggle_button, this, false);
        this.f57199a = (ToggleButton) inflate.findViewById(R.id.tb_pb_search);
        this.f57199a.setTextOn(str);
        this.f57199a.setTextOff(str);
        this.f57199a.setText(str);
        super.addView(inflate);
    }

    public boolean isSelected() {
        return this.f57199a.isChecked();
    }

    public void setChecked(boolean z) {
        this.f57199a.setChecked(z);
    }

    public ToggleButton getToggleBtn() {
        return this.f57199a;
    }

    public void addView(View view) {
        throw new IllegalArgumentException("View addition not allowed here");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(this);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f57199a.setOnClickListener(new View.OnClickListener(onClickListener) {
            private final /* synthetic */ View.OnClickListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ToggleStatusButton.this.a(this.f$1, view);
            }
        });
    }
}
