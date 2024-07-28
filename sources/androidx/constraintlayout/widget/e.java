package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    int f2575a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f2576b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2577c = -1;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<a> f2578d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<c> f2579e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private d f2580f = null;

    public e(Context context, XmlPullParser xmlPullParser) {
        a(context, xmlPullParser);
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.StateSet_defaultState) {
                this.f2575a = obtainStyledAttributes.getResourceId(index, this.f2575a);
            }
        }
        obtainStyledAttributes.recycle();
        a aVar = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    char c2 = 65535;
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    if (!(c2 == 0 || c2 == 1)) {
                        if (c2 == 2) {
                            aVar = new a(context, xmlPullParser);
                            this.f2578d.put(aVar.f2581a, aVar);
                        } else if (c2 == 3) {
                            b bVar = new b(context, xmlPullParser);
                            if (aVar != null) {
                                aVar.f2582b.add(bVar);
                            }
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public final int a(int i2) {
        a aVar;
        int a2;
        if (-1 == i2) {
            if (i2 == -1) {
                aVar = this.f2578d.valueAt(0);
            } else {
                aVar = this.f2578d.get(this.f2576b);
            }
            if (aVar == null) {
                return -1;
            }
            if ((this.f2577c == -1 || !aVar.f2582b.get(-1).a()) && -1 != (a2 = aVar.a())) {
                return a2 == -1 ? aVar.f2583c : aVar.f2582b.get(a2).f2589e;
            }
            return -1;
        }
        a aVar2 = this.f2578d.get(i2);
        if (aVar2 == null) {
            return -1;
        }
        int a3 = aVar2.a();
        return a3 == -1 ? aVar2.f2583c : aVar2.f2582b.get(a3).f2589e;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2581a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<b> f2582b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public int f2583c = -1;

        /* renamed from: d  reason: collision with root package name */
        boolean f2584d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f2584d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.State_android_id) {
                    this.f2581a = obtainStyledAttributes.getResourceId(index, this.f2581a);
                } else if (index == R.styleable.State_constraints) {
                    this.f2583c = obtainStyledAttributes.getResourceId(index, this.f2583c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2583c);
                    context.getResources().getResourceName(this.f2583c);
                    if (Item.KEY_LAYOUT.equals(resourceTypeName)) {
                        this.f2584d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final int a() {
            for (int i2 = 0; i2 < this.f2582b.size(); i2++) {
                if (this.f2582b.get(i2).a()) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        float f2585a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f2586b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f2587c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f2588d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        public int f2589e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f2590f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f2590f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Variant_constraints) {
                    this.f2589e = obtainStyledAttributes.getResourceId(index, this.f2589e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2589e);
                    context.getResources().getResourceName(this.f2589e);
                    if (Item.KEY_LAYOUT.equals(resourceTypeName)) {
                        this.f2590f = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f2588d = obtainStyledAttributes.getDimension(index, this.f2588d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f2586b = obtainStyledAttributes.getDimension(index, this.f2586b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f2587c = obtainStyledAttributes.getDimension(index, this.f2587c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f2585a = obtainStyledAttributes.getDimension(index, this.f2585a);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final boolean a() {
            if (!Float.isNaN(this.f2585a) && -1.0f < this.f2585a) {
                return false;
            }
            if (!Float.isNaN(this.f2586b) && -1.0f < this.f2586b) {
                return false;
            }
            if (!Float.isNaN(this.f2587c) && -1.0f > this.f2587c) {
                return false;
            }
            if (Float.isNaN(this.f2588d) || -1.0f <= this.f2588d) {
                return true;
            }
            return false;
        }
    }
}
