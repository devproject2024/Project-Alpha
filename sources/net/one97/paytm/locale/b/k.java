package net.one97.paytm.locale.b;

import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import net.one97.paytm.locale.b.n;

final class k implements n.a {
    k() {
    }

    public final Class<? extends View> a() {
        return Toolbar.class;
    }

    public final View a(View view, AttributeSet attributeSet) {
        String attributeValue;
        if (view != null && Toolbar.class.isInstance(view)) {
            Resources resources = view.getContext().getResources();
            for (int i2 = 0; i2 < attributeSet.getAttributeCount(); i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                char c2 = 65535;
                int hashCode = attributeName.hashCode();
                if (hashCode != 110371416) {
                    if (hashCode == 783864767 && attributeName.equals("app:title")) {
                        c2 = 0;
                    }
                } else if (attributeName.equals("title")) {
                    c2 = 1;
                }
                if ((c2 == 0 || c2 == 1) && (attributeValue = attributeSet.getAttributeValue(i2)) != null && attributeValue.startsWith("@")) {
                    ((Toolbar) view).setTitle((CharSequence) resources.getString(attributeSet.getAttributeResourceValue(i2, 0)));
                }
            }
        }
        return view;
    }
}
