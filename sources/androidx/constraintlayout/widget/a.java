package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    String f2507a;

    /* renamed from: b  reason: collision with root package name */
    public C0034a f2508b;

    /* renamed from: c  reason: collision with root package name */
    boolean f2509c;

    /* renamed from: d  reason: collision with root package name */
    private int f2510d;

    /* renamed from: e  reason: collision with root package name */
    private float f2511e;

    /* renamed from: f  reason: collision with root package name */
    private String f2512f;

    /* renamed from: g  reason: collision with root package name */
    private int f2513g;

    /* renamed from: androidx.constraintlayout.widget.a$a  reason: collision with other inner class name */
    public enum C0034a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    private static int a(int i2) {
        int i3 = (i2 & (~(i2 >> 31))) - 255;
        return (i3 & (i3 >> 31)) + PriceRangeSeekBar.INVALID_POINTER_ID;
    }

    public final int a() {
        int i2 = AnonymousClass1.f2514a[this.f2508b.ordinal()];
        return (i2 == 1 || i2 == 2) ? 4 : 1;
    }

    public final float b() {
        switch (this.f2508b) {
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case INT_TYPE:
                return (float) this.f2510d;
            case FLOAT_TYPE:
                return this.f2511e;
            case STRING_TYPE:
                throw new RuntimeException("Cannot interpolate String");
            case BOOLEAN_TYPE:
                return this.f2509c ? 1.0f : 0.0f;
            case DIMENSION_TYPE:
                return this.f2511e;
            default:
                return Float.NaN;
        }
    }

    public final void a(float[] fArr) {
        switch (this.f2508b) {
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                int i2 = this.f2513g;
                int i3 = (i2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID;
                int i4 = (i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID;
                int i5 = (i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID;
                int i6 = i2 & PriceRangeSeekBar.INVALID_POINTER_ID;
                float pow = (float) Math.pow((double) (((float) i4) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) i5) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) i6) / 255.0f), 2.2d);
                fArr[3] = ((float) i3) / 255.0f;
                return;
            case INT_TYPE:
                fArr[0] = (float) this.f2510d;
                return;
            case FLOAT_TYPE:
                fArr[0] = this.f2511e;
                return;
            case STRING_TYPE:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case BOOLEAN_TYPE:
                fArr[0] = this.f2509c ? 1.0f : 0.0f;
                return;
            case DIMENSION_TYPE:
                fArr[0] = this.f2511e;
                return;
            default:
                return;
        }
    }

    private a(String str, C0034a aVar, Object obj) {
        this.f2507a = str;
        this.f2508b = aVar;
        a(obj);
    }

    private a(a aVar, Object obj) {
        this.f2507a = aVar.f2507a;
        this.f2508b = aVar.f2508b;
        a(obj);
    }

    private void a(Object obj) {
        switch (this.f2508b) {
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                this.f2513g = ((Integer) obj).intValue();
                return;
            case INT_TYPE:
                this.f2510d = ((Integer) obj).intValue();
                return;
            case FLOAT_TYPE:
                this.f2511e = ((Float) obj).floatValue();
                return;
            case STRING_TYPE:
                this.f2512f = (String) obj;
                return;
            case BOOLEAN_TYPE:
                this.f2509c = ((Boolean) obj).booleanValue();
                return;
            case DIMENSION_TYPE:
                this.f2511e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public static HashMap<String, a> a(HashMap<String, a> hashMap, View view) {
        HashMap<String, a> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            a aVar = hashMap.get(next);
            try {
                if (next.equals("BackgroundColor")) {
                    hashMap2.put(next, new a(aVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(next, new a(aVar, cls.getMethod("getMap".concat(String.valueOf(next)), new Class[0]).invoke(view, new Object[0])));
                }
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void a(View view, HashMap<String, a> hashMap) {
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            a aVar = hashMap.get(next);
            String concat = "set".concat(String.valueOf(next));
            try {
                switch (aVar.f2508b) {
                    case COLOR_TYPE:
                        cls.getMethod(concat, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(aVar.f2513g)});
                        break;
                    case COLOR_DRAWABLE_TYPE:
                        Method method = cls.getMethod(concat, new Class[]{Drawable.class});
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(aVar.f2513g);
                        method.invoke(view, new Object[]{colorDrawable});
                        break;
                    case INT_TYPE:
                        cls.getMethod(concat, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(aVar.f2510d)});
                        break;
                    case FLOAT_TYPE:
                        cls.getMethod(concat, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(aVar.f2511e)});
                        break;
                    case STRING_TYPE:
                        cls.getMethod(concat, new Class[]{CharSequence.class}).invoke(view, new Object[]{aVar.f2512f});
                        break;
                    case BOOLEAN_TYPE:
                        cls.getMethod(concat, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(aVar.f2509c)});
                        break;
                    case DIMENSION_TYPE:
                        cls.getMethod(concat, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(aVar.f2511e)});
                        break;
                }
            } catch (NoSuchMethodException e2) {
                e2.getMessage();
                StringBuilder sb = new StringBuilder(" Custom Attribute \"");
                sb.append(next);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls.getName());
                sb2.append(" must have a method ");
                sb2.append(concat);
            } catch (IllegalAccessException e3) {
                StringBuilder sb3 = new StringBuilder(" Custom Attribute \"");
                sb3.append(next);
                sb3.append("\" not found on ");
                sb3.append(cls.getName());
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                StringBuilder sb4 = new StringBuilder(" Custom Attribute \"");
                sb4.append(next);
                sb4.append("\" not found on ");
                sb4.append(cls.getName());
                e4.printStackTrace();
            }
        }
    }

    public final void a(View view, float[] fArr) {
        View view2 = view;
        Class<?> cls = view.getClass();
        String str = "set" + this.f2507a;
        try {
            boolean z = true;
            switch (this.f2508b) {
                case COLOR_TYPE:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view2, new Object[]{Integer.valueOf((a((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f)))});
                    return;
                case COLOR_DRAWABLE_TYPE:
                    Method method = cls.getMethod(str, new Class[]{Drawable.class});
                    int a2 = a((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
                    int a3 = a((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((a2 << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a3 << 8) | a((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f)));
                    method.invoke(view2, new Object[]{colorDrawable});
                    return;
                case INT_TYPE:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view2, new Object[]{Integer.valueOf((int) fArr[0])});
                    return;
                case FLOAT_TYPE:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view2, new Object[]{Float.valueOf(fArr[0])});
                    return;
                case STRING_TYPE:
                    throw new RuntimeException("unable to interpolate strings " + this.f2507a);
                case BOOLEAN_TYPE:
                    Method method2 = cls.getMethod(str, new Class[]{Boolean.TYPE});
                    Object[] objArr = new Object[1];
                    if (fArr[0] <= 0.5f) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    method2.invoke(view2, objArr);
                    return;
                case DIMENSION_TYPE:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view2, new Object[]{Float.valueOf(fArr[0])});
                    return;
                default:
                    return;
            }
        } catch (NoSuchMethodException e2) {
            StringBuilder sb = new StringBuilder("no method ");
            sb.append(str);
            sb.append("on View \"");
            sb.append(androidx.constraintlayout.motion.widget.a.a(view));
            sb.append("\"");
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            StringBuilder sb2 = new StringBuilder("cannot access method ");
            sb2.append(str);
            sb2.append("on View \"");
            sb2.append(androidx.constraintlayout.motion.widget.a.a(view));
            sb2.append("\"");
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public static void a(Context context, XmlPullParser xmlPullParser, HashMap<String, a> hashMap) {
        C0034a aVar;
        Object string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        C0034a aVar2 = null;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                aVar2 = C0034a.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    aVar = C0034a.COLOR_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    aVar = C0034a.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    aVar = C0034a.DIMENSION_TYPE;
                    string = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    aVar = C0034a.DIMENSION_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    aVar = C0034a.FLOAT_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    aVar = C0034a.INT_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    aVar = C0034a.STRING_TYPE;
                    string = obtainStyledAttributes.getString(index);
                }
                Object obj2 = string;
                aVar2 = aVar;
                obj = obj2;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new a(str, aVar2, obj));
        }
        obtainStyledAttributes.recycle();
    }
}
