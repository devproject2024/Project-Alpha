package net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import net.one97.paytm.moneytransfer.R;

public class TooltipActionView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f55127a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f55128b;

    /* renamed from: c  reason: collision with root package name */
    private MenuItem f55129c;

    /* renamed from: d  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f55130d;

    public TooltipActionView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TooltipActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843480);
    }

    public TooltipActionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setClickable(true);
        setLongClickable(true);
        getResources().getDimensionPixelSize(R.dimen.dimen_40dp);
        getResources().getDimensionPixelSize(R.dimen.dimen_4dp);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2, 17);
        this.f55127a = new TextView(context);
        this.f55128b = new ImageView(context);
        this.f55127a.setDuplicateParentStateEnabled(true);
        this.f55128b.setDuplicateParentStateEnabled(true);
        addView(this.f55127a, layoutParams);
        addView(this.f55128b, layoutParams);
    }

    public void setEnabled(boolean z) {
        MenuItem menuItem = this.f55129c;
        if (menuItem != null) {
            menuItem.setEnabled(z);
        }
        super.setEnabled(z);
    }

    public boolean performClick() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f55130d;
        if (onMenuItemClickListener != null) {
            onMenuItemClickListener.onMenuItemClick(this.f55129c);
        }
        return super.performClick();
    }

    public boolean performLongClick() {
        MenuItem menuItem = this.f55129c;
        if (menuItem != null && !TextUtils.isEmpty(menuItem.getTitle())) {
            int[] iArr = new int[2];
            Rect rect = new Rect();
            getLocationOnScreen(iArr);
            getWindowVisibleDisplayFrame(rect);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i2 = iArr[1] + (height / 2);
            int i3 = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f55129c.getTitle(), 0);
            if (i2 < rect.height()) {
                makeText.setGravity(8388661, (i3 - iArr[0]) - (width / 2), height);
            } else {
                makeText.setGravity(81, 0, height);
            }
            makeText.show();
        }
        return super.performLongClick();
    }

    public void setVisible(boolean z) {
        MenuItem menuItem = this.f55129c;
        if (menuItem != null) {
            menuItem.setVisible(z);
        }
        setVisibility(z ? 0 : 8);
    }

    public MenuItem getMenuItem() {
        return this.f55129c;
    }

    public void setMenuItem(MenuItem menuItem) {
        if (this.f55129c != menuItem) {
            this.f55129c = menuItem;
            View actionView = menuItem.getActionView();
            if (actionView == null) {
                menuItem.setActionView(this);
                actionView = this;
            }
            if (actionView == this) {
                super.setEnabled(menuItem.isEnabled());
                setVisible(menuItem.isVisible());
                if (menuItem.getIcon() != null) {
                    this.f55128b.setImageDrawable(menuItem.getIcon());
                } else if (menuItem.getTitle() != null) {
                    this.f55127a.setText(menuItem.getTitle());
                }
            }
        }
    }

    public void setOnMenuItemClick(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f55130d = onMenuItemClickListener;
    }
}
