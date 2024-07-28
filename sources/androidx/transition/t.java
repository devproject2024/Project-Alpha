package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import androidx.a.a;
import androidx.core.content.b.g;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?>[] f4834a = {Context.class, AttributeSet.class};

    /* renamed from: b  reason: collision with root package name */
    private static final a<String, Constructor<?>> f4835b = new a<>();

    /* renamed from: c  reason: collision with root package name */
    private final Context f4836c;

    private t(Context context) {
        this.f4836c = context;
    }

    public static t a(Context context) {
        return new t(context);
    }

    public final Transition a(int i2) {
        XmlResourceParser xml = this.f4836c.getResources().getXml(i2);
        try {
            Transition a2 = a((XmlPullParser) xml, Xml.asAttributeSet(xml), (Transition) null);
            xml.close();
            return a2;
        } catch (XmlPullParserException e2) {
            throw new InflateException(e2.getMessage(), e2);
        } catch (IOException e3) {
            throw new InflateException(xml.getPositionDescription() + ": " + e3.getMessage(), e3);
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    private Transition a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        Transition transition2;
        int depth = xmlPullParser.getDepth();
        TransitionSet transitionSet = transition instanceof TransitionSet ? (TransitionSet) transition : null;
        loop0:
        while (true) {
            transition2 = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    if (next == 2) {
                        String name = xmlPullParser.getName();
                        if ("fade".equals(name)) {
                            transition2 = new Fade(this.f4836c, attributeSet);
                        } else if ("changeBounds".equals(name)) {
                            transition2 = new ChangeBounds(this.f4836c, attributeSet);
                        } else if ("slide".equals(name)) {
                            transition2 = new Slide(this.f4836c, attributeSet);
                        } else if ("explode".equals(name)) {
                            transition2 = new Explode(this.f4836c, attributeSet);
                        } else if ("changeImageTransform".equals(name)) {
                            transition2 = new ChangeImageTransform(this.f4836c, attributeSet);
                        } else if ("changeTransform".equals(name)) {
                            transition2 = new ChangeTransform(this.f4836c, attributeSet);
                        } else if ("changeClipBounds".equals(name)) {
                            transition2 = new ChangeClipBounds(this.f4836c, attributeSet);
                        } else if ("autoTransition".equals(name)) {
                            transition2 = new AutoTransition(this.f4836c, attributeSet);
                        } else if ("changeScroll".equals(name)) {
                            transition2 = new ChangeScroll(this.f4836c, attributeSet);
                        } else if ("transitionSet".equals(name)) {
                            transition2 = new TransitionSet(this.f4836c, attributeSet);
                        } else if ("transition".equals(name)) {
                            transition2 = (Transition) a(attributeSet, (Class<?>) Transition.class, "transition");
                        } else if ("targets".equals(name)) {
                            b(xmlPullParser, attributeSet, transition);
                        } else if ("arcMotion".equals(name)) {
                            if (transition != null) {
                                transition.a((PathMotion) new ArcMotion(this.f4836c, attributeSet));
                            } else {
                                throw new RuntimeException("Invalid use of arcMotion element");
                            }
                        } else if ("pathMotion".equals(name)) {
                            if (transition != null) {
                                transition.a((PathMotion) a(attributeSet, (Class<?>) PathMotion.class, "pathMotion"));
                            } else {
                                throw new RuntimeException("Invalid use of pathMotion element");
                            }
                        } else if (!"patternPathMotion".equals(name)) {
                            throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                        } else if (transition != null) {
                            transition.a((PathMotion) new PatternPathMotion(this.f4836c, attributeSet));
                        } else {
                            throw new RuntimeException("Invalid use of patternPathMotion element");
                        }
                        if (transition2 == null) {
                            continue;
                        } else {
                            if (!xmlPullParser.isEmptyElementTag()) {
                                a(xmlPullParser, attributeSet, transition2);
                            }
                            if (transitionSet != null) {
                                break;
                            } else if (transition != null) {
                                throw new InflateException("Could not add transition to another transition.");
                            }
                        }
                    }
                }
            }
            transitionSet.a(transition2);
        }
        return transition2;
    }

    private Object a(AttributeSet attributeSet, Class<?> cls, String str) {
        Object newInstance;
        Class<? extends U> asSubclass;
        String attributeValue = attributeSet.getAttributeValue((String) null, Item.KEY_CLASS);
        if (attributeValue != null) {
            try {
                synchronized (f4835b) {
                    Constructor<? extends U> constructor = f4835b.get(attributeValue);
                    if (constructor == null && (asSubclass = Class.forName(attributeValue, false, this.f4836c.getClassLoader()).asSubclass(cls)) != null) {
                        constructor = asSubclass.getConstructor(f4834a);
                        constructor.setAccessible(true);
                        f4835b.put(attributeValue, constructor);
                    }
                    newInstance = constructor.newInstance(new Object[]{this.f4836c, attributeSet});
                }
                return newInstance;
            } catch (Exception e2) {
                throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e2);
            }
        } else {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
    }

    private void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (xmlPullParser.getName().equals("target")) {
                    TypedArray obtainStyledAttributes = this.f4836c.obtainStyledAttributes(attributeSet, s.f4825a);
                    int b2 = g.b(obtainStyledAttributes, xmlPullParser, "targetId", 1);
                    if (b2 != 0) {
                        transition.a(b2);
                    } else {
                        int b3 = g.b(obtainStyledAttributes, xmlPullParser, "excludeId", 2);
                        if (b3 != 0) {
                            transition.a(b3, true);
                        } else {
                            String c2 = g.c(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                            if (c2 != null) {
                                transition.a(c2);
                            } else {
                                String c3 = g.c(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                                if (c3 != null) {
                                    transition.a(c3, true);
                                } else {
                                    String c4 = g.c(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                    if (c4 != null) {
                                        try {
                                            transition.a(Class.forName(c4), true);
                                        } catch (ClassNotFoundException e2) {
                                            obtainStyledAttributes.recycle();
                                            throw new RuntimeException("Could not create ".concat(String.valueOf(c4)), e2);
                                        }
                                    } else {
                                        String c5 = g.c(obtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                        if (c5 != null) {
                                            transition.a(Class.forName(c5));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    obtainStyledAttributes.recycle();
                } else {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
            }
        }
    }
}
