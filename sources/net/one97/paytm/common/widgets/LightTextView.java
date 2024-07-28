package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.paytm.utility.w;
import com.paytmmall.clpartifact.utils.CLPConstants;

public class LightTextView extends AppCompatTextView {
    public LightTextView(Context context) {
        super(context);
        a();
    }

    public LightTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        a(context, attributeSet);
    }

    public LightTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
        a(context, attributeSet);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r2, android.util.AttributeSet r3) {
        /*
            r1 = this;
            int[] r0 = net.one97.paytm.common.widgets.R.styleable.RoboTextView
            android.content.res.TypedArray r2 = r2.obtainStyledAttributes(r3, r0)
            int r3 = net.one97.paytm.common.widgets.R.styleable.RoboTextView_fontType     // Catch:{ all -> 0x00d0 }
            r0 = 0
            int r3 = r2.getInteger(r3, r0)     // Catch:{ all -> 0x00d0 }
            r2.recycle()
            if (r3 == 0) goto L_0x00cf
            r2 = 1
            if (r3 == r2) goto L_0x00a4
            r2 = 2
            if (r3 == r2) goto L_0x0078
            r2 = 3
            if (r3 == r2) goto L_0x004c
            r2 = 4
            if (r3 == r2) goto L_0x0020
            goto L_0x00cf
        L_0x0020:
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r3 = "Roboto-Bold.ttf"
            if (r2 == 0) goto L_0x0040
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{ Exception -> 0x00cf }
            if (r2 == 0) goto L_0x004b
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{ Exception -> 0x00cf }
            android.content.Context r0 = r1.getContext()     // Catch:{ Exception -> 0x00cf }
            android.graphics.Typeface r0 = com.paytm.utility.w.a(r0, r3)     // Catch:{ Exception -> 0x00cf }
            boolean r2 = r2.equals(r0)     // Catch:{ Exception -> 0x00cf }
            if (r2 != 0) goto L_0x004b
        L_0x0040:
            android.content.Context r2 = r1.getContext()     // Catch:{ Exception -> 0x00cf }
            android.graphics.Typeface r2 = com.paytm.utility.w.a(r2, r3)     // Catch:{ Exception -> 0x00cf }
            r1.setTypeface(r2)     // Catch:{ Exception -> 0x00cf }
        L_0x004b:
            return
        L_0x004c:
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r3 = "Roboto-Medium.ttf"
            if (r2 == 0) goto L_0x006c
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{ Exception -> 0x0077 }
            if (r2 == 0) goto L_0x0077
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{ Exception -> 0x0077 }
            android.content.Context r0 = r1.getContext()     // Catch:{ Exception -> 0x0077 }
            android.graphics.Typeface r0 = com.paytm.utility.w.a(r0, r3)     // Catch:{ Exception -> 0x0077 }
            boolean r2 = r2.equals(r0)     // Catch:{ Exception -> 0x0077 }
            if (r2 != 0) goto L_0x0077
        L_0x006c:
            android.content.Context r2 = r1.getContext()     // Catch:{ Exception -> 0x0077 }
            android.graphics.Typeface r2 = com.paytm.utility.w.a(r2, r3)     // Catch:{ Exception -> 0x0077 }
            r1.setTypeface(r2)     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            return
        L_0x0078:
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r3 = "Roboto-Regular.ttf"
            if (r2 == 0) goto L_0x0098
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{ Exception -> 0x00a3 }
            if (r2 == 0) goto L_0x00a3
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{ Exception -> 0x00a3 }
            android.content.Context r0 = r1.getContext()     // Catch:{ Exception -> 0x00a3 }
            android.graphics.Typeface r0 = com.paytm.utility.w.a(r0, r3)     // Catch:{ Exception -> 0x00a3 }
            boolean r2 = r2.equals(r0)     // Catch:{ Exception -> 0x00a3 }
            if (r2 != 0) goto L_0x00a3
        L_0x0098:
            android.content.Context r2 = r1.getContext()     // Catch:{ Exception -> 0x00a3 }
            android.graphics.Typeface r2 = com.paytm.utility.w.a(r2, r3)     // Catch:{ Exception -> 0x00a3 }
            r1.setTypeface(r2)     // Catch:{ Exception -> 0x00a3 }
        L_0x00a3:
            return
        L_0x00a4:
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{  }
            java.lang.String r3 = "Roboto-Light.ttf"
            if (r2 == 0) goto L_0x00c4
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{  }
            if (r2 == 0) goto L_0x00cf
            android.graphics.Typeface r2 = r1.getTypeface()     // Catch:{  }
            android.content.Context r0 = r1.getContext()     // Catch:{  }
            android.graphics.Typeface r0 = com.paytm.utility.w.a(r0, r3)     // Catch:{  }
            boolean r2 = r2.equals(r0)     // Catch:{  }
            if (r2 != 0) goto L_0x00cf
        L_0x00c4:
            android.content.Context r2 = r1.getContext()     // Catch:{  }
            android.graphics.Typeface r2 = com.paytm.utility.w.a(r2, r3)     // Catch:{  }
            r1.setTypeface(r2)     // Catch:{  }
        L_0x00cf:
            return
        L_0x00d0:
            r3 = move-exception
            r2.recycle()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.widgets.LightTextView.a(android.content.Context, android.util.AttributeSet):void");
    }

    private void a() {
        if (!isInEditMode()) {
            try {
                if (getTypeface() != null) {
                    if (getTypeface() == null || getTypeface().equals(w.a(getContext(), CLPConstants.FONT_ROBOTO_LIGHT))) {
                        return;
                    }
                }
                setTypeface(w.a(getContext(), CLPConstants.FONT_ROBOTO_LIGHT));
            } catch (Exception unused) {
            }
        }
    }
}
