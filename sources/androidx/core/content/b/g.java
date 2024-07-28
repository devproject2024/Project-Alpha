package androidx.core.content.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import net.one97.paytm.nativesdk.otp.view.PinEntryEditText;
import org.xmlpull.v1.XmlPullParser;

public final class g {
    public static boolean a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue(PinEntryEditText.XML_NAMESPACE_ANDROID, str) != null;
    }

    public static float a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, float f2) {
        if (!a(xmlPullParser, str)) {
            return f2;
        }
        return typedArray.getFloat(i2, f2);
    }

    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, boolean z) {
        if (!a(xmlPullParser, str)) {
            return z;
        }
        return typedArray.getBoolean(i2, z);
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        if (!a(xmlPullParser, str)) {
            return i3;
        }
        return typedArray.getInt(i2, i3);
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (!a(xmlPullParser, str)) {
            return 0;
        }
        return typedArray.getColor(i2, 0);
    }

    public static b a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2) {
        if (a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return b.a(typedValue.data);
            }
            b a2 = b.a(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            if (a2 != null) {
                return a2;
            }
        }
        return b.a(0);
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (!a(xmlPullParser, str)) {
            return 0;
        }
        return typedArray.getResourceId(i2, 0);
    }

    public static String c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (!a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i2);
    }

    public static TypedValue a(TypedArray typedArray, XmlPullParser xmlPullParser, String str) {
        if (!a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(0);
    }

    public static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static boolean a(TypedArray typedArray, int i2, int i3, boolean z) {
        return typedArray.getBoolean(i2, typedArray.getBoolean(i3, z));
    }

    public static int a(TypedArray typedArray, int i2, int i3) {
        return typedArray.getInt(i2, typedArray.getInt(i3, Integer.MAX_VALUE));
    }

    public static int a(TypedArray typedArray, int i2, int i3, int i4) {
        return typedArray.getResourceId(i2, typedArray.getResourceId(i3, i4));
    }

    public static String b(TypedArray typedArray, int i2, int i3) {
        String string = typedArray.getString(i2);
        return string == null ? typedArray.getString(i3) : string;
    }

    public static CharSequence c(TypedArray typedArray, int i2, int i3) {
        CharSequence text = typedArray.getText(i2);
        return text == null ? typedArray.getText(i3) : text;
    }

    public static CharSequence[] d(TypedArray typedArray, int i2, int i3) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        return textArray == null ? typedArray.getTextArray(i3) : textArray;
    }

    public static int a(Context context, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId != 0 ? i2 : i3;
    }
}
