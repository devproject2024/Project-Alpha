package net.one97.paytm.locale.b;

import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toolbar;
import net.one97.paytm.locale.b.n;

final class m implements n.a {
    m() {
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
                if (hashCode != -1735877235) {
                    if (hashCode == 110371416 && attributeName.equals("title")) {
                        c2 = 1;
                    }
                } else if (attributeName.equals("android:title")) {
                    c2 = 0;
                }
                if ((c2 == 0 || c2 == 1) && (attributeValue = attributeSet.getAttributeValue(i2)) != null && attributeValue.startsWith("@")) {
                    ((Toolbar) view).setTitle(resources.getString(attributeSet.getAttributeResourceValue(i2, 0)));
                }
            }
        }
        return view;
    }
}
