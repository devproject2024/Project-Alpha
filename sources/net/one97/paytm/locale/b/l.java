package net.one97.paytm.locale.b;

import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.locale.b.n;

final class l implements n.a {
    l() {
    }

    public final Class<? extends View> a() {
        return TextView.class;
    }

    public final View a(View view, AttributeSet attributeSet) {
        String attributeValue;
        if (view != null && TextView.class.isInstance(view)) {
            Resources resources = view.getContext().getResources();
            for (int i2 = 0; i2 < attributeSet.getAttributeCount(); i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                char c2 = 65535;
                switch (attributeName.hashCode()) {
                    case -1026185038:
                        if (attributeName.equals("android:hint")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1025831080:
                        if (attributeName.equals("android:text")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3202695:
                        if (attributeName.equals("hint")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3556653:
                        if (attributeName.equals(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX)) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 == 0 || c2 == 1) {
                    String attributeValue2 = attributeSet.getAttributeValue(i2);
                    if (attributeValue2 != null && attributeValue2.startsWith("@")) {
                        ((TextView) view).setText(resources.getString(attributeSet.getAttributeResourceValue(i2, 0)));
                    }
                } else if ((c2 == 2 || c2 == 3) && (attributeValue = attributeSet.getAttributeValue(i2)) != null && attributeValue.startsWith("@")) {
                    ((TextView) view).setHint(resources.getString(attributeSet.getAttributeResourceValue(i2, 0)));
                }
            }
        }
        return view;
    }
}
