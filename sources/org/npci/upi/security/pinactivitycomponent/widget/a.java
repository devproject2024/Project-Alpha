package org.npci.upi.security.pinactivitycomponent.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface a {
    void a(String str, Drawable drawable, View.OnClickListener onClickListener, int i2, boolean z, boolean z2);

    boolean a();

    boolean b();

    Object getFormDataTag();

    String getInputValue();

    void setText(String str);
}
