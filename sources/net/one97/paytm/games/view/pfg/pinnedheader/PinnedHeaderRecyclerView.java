package net.one97.paytm.games.view.pfg.pinnedheader;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public class PinnedHeaderRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    private a f35743a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f35744b;

    public interface a {
        void onPinnedHeaderClick(int i2);
    }

    public PinnedHeaderRecyclerView(Context context) {
        super(context);
    }

    public PinnedHeaderRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PinnedHeaderRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnPinnedHeaderClickListener(a aVar) {
        this.f35743a = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f35743a == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        a pinnedHeaderDecoration = getPinnedHeaderDecoration();
        if (pinnedHeaderDecoration == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        Rect a2 = pinnedHeaderDecoration.a();
        int b2 = pinnedHeaderDecoration.b();
        if (a2 == null || b2 == -1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && a2.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        if (r2 != 3) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            net.one97.paytm.games.view.pfg.pinnedheader.PinnedHeaderRecyclerView$a r0 = r7.f35743a
            if (r0 != 0) goto L_0x0009
            boolean r8 = super.onTouchEvent(r8)
            return r8
        L_0x0009:
            net.one97.paytm.games.view.pfg.pinnedheader.a r0 = r7.getPinnedHeaderDecoration()
            if (r0 != 0) goto L_0x0014
            boolean r8 = super.onTouchEvent(r8)
            return r8
        L_0x0014:
            android.graphics.Rect r1 = r0.a()
            int r0 = r0.b()
            if (r1 == 0) goto L_0x0098
            r2 = -1
            if (r0 != r2) goto L_0x0023
            goto L_0x0098
        L_0x0023:
            int r2 = r8.getAction()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x007e
            if (r2 == r4) goto L_0x005f
            r5 = 2
            r6 = 3
            if (r2 == r5) goto L_0x0034
            if (r2 == r6) goto L_0x005f
            goto L_0x0093
        L_0x0034:
            boolean r0 = r7.f35744b
            if (r0 == 0) goto L_0x0093
            float r0 = r8.getX()
            int r0 = (int) r0
            float r2 = r8.getY()
            int r2 = (int) r2
            boolean r0 = r1.contains(r0, r2)
            if (r0 != 0) goto L_0x005e
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r8)
            r0.setAction(r6)
            super.dispatchTouchEvent(r0)
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r8)
            r8.setAction(r3)
            boolean r8 = super.dispatchTouchEvent(r8)
            return r8
        L_0x005e:
            return r4
        L_0x005f:
            float r2 = r8.getX()
            float r5 = r8.getY()
            boolean r6 = r7.f35744b
            if (r6 == 0) goto L_0x007b
            int r2 = (int) r2
            int r5 = (int) r5
            boolean r1 = r1.contains(r2, r5)
            if (r1 == 0) goto L_0x007b
            net.one97.paytm.games.view.pfg.pinnedheader.PinnedHeaderRecyclerView$a r8 = r7.f35743a
            r8.onPinnedHeaderClick(r0)
            r7.f35744b = r3
            return r4
        L_0x007b:
            r7.f35744b = r3
            goto L_0x0093
        L_0x007e:
            r7.f35744b = r3
            float r0 = r8.getX()
            int r0 = (int) r0
            float r2 = r8.getY()
            int r2 = (int) r2
            boolean r0 = r1.contains(r0, r2)
            if (r0 == 0) goto L_0x0093
            r7.f35744b = r4
            return r4
        L_0x0093:
            boolean r8 = super.onTouchEvent(r8)
            return r8
        L_0x0098:
            boolean r8 = super.onTouchEvent(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.view.pfg.pinnedheader.PinnedHeaderRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public a getPinnedHeaderDecoration() {
        RecyclerView.h itemDecorationAt;
        int i2 = 0;
        do {
            itemDecorationAt = getItemDecorationAt(i2);
            if (itemDecorationAt instanceof a) {
                return (a) itemDecorationAt;
            }
            i2++;
        } while (itemDecorationAt != null);
        return null;
    }
}
