package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.p;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class g extends MenuInflater {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?>[] f1230a;

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f1231b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f1232c;

    /* renamed from: d  reason: collision with root package name */
    final Object[] f1233d = this.f1232c;

    /* renamed from: e  reason: collision with root package name */
    Context f1234e;

    /* renamed from: f  reason: collision with root package name */
    Object f1235f;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            r2 = 0
            r0[r2] = r1
            f1230a = r0
            f1231b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.g.<clinit>():void");
    }

    public g(Context context) {
        super(context);
        this.f1234e = context;
        this.f1232c = new Object[]{context};
    }

    public final void inflate(int i2, Menu menu) {
        if (!(menu instanceof androidx.core.b.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f1234e.getResources().getLayout(i2);
            a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(String.valueOf(name)));
                }
            }
        }
        int i2 = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            bVar.a();
                        } else if (name2.equals("item")) {
                            if (!bVar.f1239a) {
                                if (bVar.f1240b == null || !bVar.f1240b.c()) {
                                    bVar.b();
                                } else {
                                    bVar.c();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.a(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.b(attributeSet);
                    } else if (name3.equals("menu")) {
                        a(xmlPullParser, attributeSet, bVar.c());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                i2 = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    static Object a(Object obj) {
        while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            obj = ((ContextWrapper) obj).getBaseContext();
        }
        return obj;
    }

    static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private static final Class<?>[] f1236a = {MenuItem.class};

        /* renamed from: b  reason: collision with root package name */
        private Object f1237b;

        /* renamed from: c  reason: collision with root package name */
        private Method f1238c;

        public a(Object obj, String str) {
            this.f1237b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1238c = cls.getMethod(str, f1236a);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1238c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1238c.invoke(this.f1237b, new Object[]{menuItem})).booleanValue();
                }
                this.f1238c.invoke(this.f1237b, new Object[]{menuItem});
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;

        /* renamed from: a  reason: collision with root package name */
        boolean f1239a;

        /* renamed from: b  reason: collision with root package name */
        androidx.core.h.b f1240b;

        /* renamed from: d  reason: collision with root package name */
        private Menu f1242d;

        /* renamed from: e  reason: collision with root package name */
        private int f1243e;

        /* renamed from: f  reason: collision with root package name */
        private int f1244f;

        /* renamed from: g  reason: collision with root package name */
        private int f1245g;

        /* renamed from: h  reason: collision with root package name */
        private int f1246h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f1247i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(Menu menu) {
            this.f1242d = menu;
            a();
        }

        public final void a() {
            this.f1243e = 0;
            this.f1244f = 0;
            this.f1245g = 0;
            this.f1246h = 0;
            this.f1247i = true;
            this.j = true;
        }

        public final void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f1234e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f1243e = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f1244f = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f1245g = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f1246h = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f1247i = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.j = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public final void b(AttributeSet attributeSet) {
            ac a2 = ac.a(g.this.f1234e, attributeSet, R.styleable.MenuItem);
            this.k = a2.g(R.styleable.MenuItem_android_id, 0);
            this.l = (a2.a(R.styleable.MenuItem_android_menuCategory, this.f1244f) & -65536) | (a2.a(R.styleable.MenuItem_android_orderInCategory, this.f1245g) & 65535);
            this.m = a2.c(R.styleable.MenuItem_android_title);
            this.n = a2.c(R.styleable.MenuItem_android_titleCondensed);
            this.o = a2.g(R.styleable.MenuItem_android_icon, 0);
            this.p = a(a2.d(R.styleable.MenuItem_android_alphabeticShortcut));
            this.q = a2.a(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.r = a(a2.d(R.styleable.MenuItem_android_numericShortcut));
            this.s = a2.a(R.styleable.MenuItem_numericModifiers, 4096);
            if (a2.g(R.styleable.MenuItem_android_checkable)) {
                this.t = a2.a(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.t = this.f1246h;
            }
            this.u = a2.a(R.styleable.MenuItem_android_checked, false);
            this.v = a2.a(R.styleable.MenuItem_android_visible, this.f1247i);
            this.w = a2.a(R.styleable.MenuItem_android_enabled, this.j);
            this.x = a2.a(R.styleable.MenuItem_showAsAction, -1);
            this.B = a2.d(R.styleable.MenuItem_android_onClick);
            this.y = a2.g(R.styleable.MenuItem_actionLayout, 0);
            this.z = a2.d(R.styleable.MenuItem_actionViewClass);
            this.A = a2.d(R.styleable.MenuItem_actionProviderClass);
            if ((this.A != null) && this.y == 0 && this.z == null) {
                this.f1240b = (androidx.core.h.b) a(this.A, g.f1231b, g.this.f1233d);
            } else {
                this.f1240b = null;
            }
            this.C = a2.c(R.styleable.MenuItem_contentDescription);
            this.D = a2.c(R.styleable.MenuItem_tooltipText);
            if (a2.g(R.styleable.MenuItem_iconTintMode)) {
                this.F = p.a(a2.a(R.styleable.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (a2.g(R.styleable.MenuItem_iconTint)) {
                this.E = a2.e(R.styleable.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            a2.f1669a.recycle();
            this.f1239a = false;
        }

        private static char a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t > 0).setTitleCondensed(this.n).setIcon(this.o);
            int i2 = this.x;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.B != null) {
                if (!g.this.f1234e.isRestricted()) {
                    g gVar = g.this;
                    if (gVar.f1235f == null) {
                        gVar.f1235f = g.a(gVar.f1234e);
                    }
                    menuItem.setOnMenuItemClickListener(new a(gVar.f1235f, this.B));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.t >= 2) {
                if (menuItem instanceof i) {
                    ((i) menuItem).a(true);
                } else if (menuItem instanceof j) {
                    j jVar = (j) menuItem;
                    try {
                        if (jVar.f1359e == null) {
                            jVar.f1359e = jVar.f1358d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        jVar.f1359e.invoke(jVar.f1358d, new Object[]{Boolean.TRUE});
                    } catch (Exception unused) {
                    }
                }
            }
            String str = this.z;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.f1230a, g.this.f1232c));
                z2 = true;
            }
            int i3 = this.y;
            if (i3 > 0 && !z2) {
                menuItem.setActionView(i3);
            }
            androidx.core.h.b bVar = this.f1240b;
            if (bVar != null && (menuItem instanceof androidx.core.b.a.b)) {
                ((androidx.core.b.a.b) menuItem).a(bVar);
            }
            CharSequence charSequence = this.C;
            boolean z3 = menuItem instanceof androidx.core.b.a.b;
            if (z3) {
                ((androidx.core.b.a.b) menuItem).a(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.D;
            if (z3) {
                ((androidx.core.b.a.b) menuItem).b(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c2 = this.p;
            int i4 = this.q;
            if (z3) {
                ((androidx.core.b.a.b) menuItem).setAlphabeticShortcut(c2, i4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c2, i4);
            }
            char c3 = this.r;
            int i5 = this.s;
            if (z3) {
                ((androidx.core.b.a.b) menuItem).setNumericShortcut(c3, i5);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c3, i5);
            }
            PorterDuff.Mode mode = this.F;
            if (mode != null) {
                if (z3) {
                    ((androidx.core.b.a.b) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.E;
            if (colorStateList == null) {
                return;
            }
            if (z3) {
                ((androidx.core.b.a.b) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintList(colorStateList);
            }
        }

        public final void b() {
            this.f1239a = true;
            a(this.f1242d.add(this.f1243e, this.k, this.l, this.m));
        }

        public final SubMenu c() {
            this.f1239a = true;
            SubMenu addSubMenu = this.f1242d.addSubMenu(this.f1243e, this.k, this.l, this.m);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f1234e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
