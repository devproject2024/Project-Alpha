package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class i extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f4273a = {16843284};

    /* renamed from: b  reason: collision with root package name */
    private Drawable f4274b;

    /* renamed from: c  reason: collision with root package name */
    private int f4275c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f4276d = new Rect();

    public i(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f4273a);
        this.f4274b = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        if (i2 == 0 || i2 == 1) {
            this.f4275c = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    public final void a(Drawable drawable) {
        if (drawable != null) {
            this.f4274b = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (recyclerView.getLayoutManager() != null && this.f4274b != null) {
            int i6 = 0;
            if (this.f4275c == 1) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i4 = recyclerView.getPaddingLeft();
                    i5 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i4, recyclerView.getPaddingTop(), i5, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    i5 = recyclerView.getWidth();
                    i4 = 0;
                }
                int childCount = recyclerView.getChildCount();
                while (i6 < childCount) {
                    View childAt = recyclerView.getChildAt(i6);
                    recyclerView.getDecoratedBoundsWithMargins(childAt, this.f4276d);
                    int round = this.f4276d.bottom + Math.round(childAt.getTranslationY());
                    this.f4274b.setBounds(i4, round - this.f4274b.getIntrinsicHeight(), i5, round);
                    this.f4274b.draw(canvas);
                    i6++;
                }
                canvas.restore();
                return;
            }
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i2 = recyclerView.getPaddingTop();
                i3 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), i3);
            } else {
                i3 = recyclerView.getHeight();
                i2 = 0;
            }
            int childCount2 = recyclerView.getChildCount();
            while (i6 < childCount2) {
                View childAt2 = recyclerView.getChildAt(i6);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, this.f4276d);
                int round2 = this.f4276d.right + Math.round(childAt2.getTranslationX());
                this.f4274b.setBounds(round2 - this.f4274b.getIntrinsicWidth(), i2, round2, i3);
                this.f4274b.draw(canvas);
                i6++;
            }
            canvas.restore();
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        Drawable drawable = this.f4274b;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f4275c == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }
}
