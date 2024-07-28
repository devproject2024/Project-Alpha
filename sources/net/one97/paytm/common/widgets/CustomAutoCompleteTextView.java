package net.one97.paytm.common.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import com.paytm.utility.b;
import com.paytm.utility.q;

public class CustomAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* renamed from: a  reason: collision with root package name */
    boolean f49758a = false;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f49759b = getResources().getDrawable(R.drawable.cross_grey);

    /* renamed from: c  reason: collision with root package name */
    private Context f49760c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f49761d;

    /* renamed from: e  reason: collision with root package name */
    private a f49762e = new a() {
        public final void a() {
            CustomAutoCompleteTextView.this.setText("");
            CustomAutoCompleteTextView.this.a();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f49763f = this.f49762e;

    public interface a {
        void a();
    }

    public boolean enoughToFilter() {
        return true;
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f49760c = context;
        a(context, attributeSet);
        b();
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49760c = context;
        a(context, attributeSet);
        b();
    }

    public CustomAutoCompleteTextView(Context context) {
        super(context);
        this.f49760c = context;
        b();
    }

    private void a(Context context, AttributeSet attributeSet) {
        try {
            this.f49761d = context.obtainStyledAttributes(attributeSet, R.styleable.CustomAutoCompleteTextView).getBoolean(R.styleable.CustomAutoCompleteTextView_isMobile, false);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        int count;
        super.onFocusChanged(z, i2, rect);
        if (z && getFilter() != null && (count = getAdapter().getCount()) > 0) {
            setDropDownHeight(count >= 3 ? getRowHeight() * 3 : -2);
            showDropDown();
        }
    }

    public int getRowHeight() {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.auto_complete_list_item_padding);
        new TypedValue();
        new DisplayMetrics();
        return (dimensionPixelSize * 2) + getContext().getResources().getDimensionPixelSize(R.dimen.auto_complete_preferred_item_height);
    }

    public boolean onTextContextMenuItem(int i2) {
        String str;
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        if (i2 == 16908322) {
            try {
                int i3 = 0;
                if (Build.VERSION.SDK_INT < 11) {
                    str = ((ClipboardManager) this.f49760c.getSystemService("clipboard")).getText().toString();
                } else {
                    str = ((android.content.ClipboardManager) this.f49760c.getSystemService("clipboard")).getPrimaryClip().getItemAt(0).getText().toString();
                }
                String replaceAll = str.replaceAll(" ", "").replaceAll("-", "");
                if (this.f49761d) {
                    if (replaceAll.startsWith(this.f49760c.getString(R.string.mobile_number_prefix_91))) {
                        i3 = 3;
                    } else if (replaceAll.startsWith(this.f49760c.getString(R.string.mobile_number_prefix_0))) {
                        i3 = 1;
                    }
                }
                setText(replaceAll.substring(i3, replaceAll.length()).trim());
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        return onTextContextMenuItem;
    }

    private void b() {
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f49759b, (Drawable) null);
        setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                CustomAutoCompleteTextView customAutoCompleteTextView = CustomAutoCompleteTextView.this;
                if (customAutoCompleteTextView.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((customAutoCompleteTextView.getWidth() - customAutoCompleteTextView.getPaddingRight()) - CustomAutoCompleteTextView.this.f49759b.getIntrinsicWidth()))) {
                    CustomAutoCompleteTextView.this.f49763f.a();
                    CustomAutoCompleteTextView.this.f49758a = true;
                }
                return false;
            }
        });
        a();
    }

    public void setOnClearListener(a aVar) {
        this.f49763f = aVar;
    }

    public final void a() {
        setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
