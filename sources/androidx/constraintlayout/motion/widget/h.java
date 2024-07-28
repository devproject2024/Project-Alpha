package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.a;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    static HashMap<String, Constructor<? extends c>> f2337a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, ArrayList<c>> f2338b = new HashMap<>();

    static {
        try {
            f2337a.put("KeyAttribute", d.class.getConstructor(new Class[0]));
            f2337a.put("KeyPosition", i.class.getConstructor(new Class[0]));
            f2337a.put("KeyCycle", f.class.getConstructor(new Class[0]));
            f2337a.put("KeyTimeCycle", k.class.getConstructor(new Class[0]));
            f2337a.put("KeyTrigger", l.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException unused) {
        }
    }

    public h(Context context, XmlPullParser xmlPullParser) {
        c cVar = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        if (f2337a.containsKey(name)) {
                            try {
                                c cVar2 = (c) f2337a.get(name).newInstance(new Object[0]);
                                try {
                                    cVar2.a(context, Xml.asAttributeSet(xmlPullParser));
                                    if (!this.f2338b.containsKey(Integer.valueOf(cVar2.f2301c))) {
                                        this.f2338b.put(Integer.valueOf(cVar2.f2301c), new ArrayList());
                                    }
                                    this.f2338b.get(Integer.valueOf(cVar2.f2301c)).add(cVar2);
                                } catch (Exception unused) {
                                }
                                cVar = cVar2;
                            } catch (Exception unused2) {
                            }
                        } else if (!(!name.equalsIgnoreCase("CustomAttribute") || cVar == null || cVar.f2304f == null)) {
                            a.a(context, xmlPullParser, cVar.f2304f);
                        }
                    } else if (eventType == 3) {
                        if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                            return;
                        }
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public final void a(n nVar) {
        ArrayList arrayList = this.f2338b.get(Integer.valueOf(nVar.f2361b));
        if (arrayList != null) {
            nVar.p.addAll(arrayList);
        }
        ArrayList arrayList2 = this.f2338b.get(-1);
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                String str = ((ConstraintLayout.LayoutParams) nVar.f2360a.getLayoutParams()).V;
                if ((cVar.f2302d == null || str == null) ? false : str.matches(cVar.f2302d)) {
                    nVar.p.add(cVar);
                }
            }
        }
    }
}
