package net.one97.paytm.locale.b;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

final class h extends LayoutInflater {

    /* renamed from: a  reason: collision with root package name */
    private static final Boolean f53111a = Boolean.valueOf(Build.VERSION.SDK_INT > 28);

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f53112e = {"android.widget.", "androidx.appcompat.widget.", "android.webkit.", "android.app."};

    /* renamed from: b  reason: collision with root package name */
    private boolean f53113b = false;

    /* renamed from: c  reason: collision with root package name */
    private Field f53114c = null;

    /* renamed from: d  reason: collision with root package name */
    private n f53115d;

    h(LayoutInflater layoutInflater, Context context, n nVar) {
        super(layoutInflater, context);
        this.f53115d = nVar;
    }

    public final LayoutInflater cloneInContext(Context context) {
        return new h(this, context, this.f53115d);
    }

    public final void setFactory(LayoutInflater.Factory factory) {
        if (!(factory instanceof b)) {
            super.setFactory(new b(factory));
        } else {
            super.setFactory(factory);
        }
    }

    public final void setFactory2(LayoutInflater.Factory2 factory2) {
        if (!(factory2 instanceof c)) {
            super.setFactory2(new c(factory2));
        } else {
            super.setFactory2(factory2);
        }
    }

    /* access modifiers changed from: protected */
    public final View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        String[] strArr = f53112e;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                View createView = createView(str, strArr[i2], attributeSet);
                if (createView != null) {
                    return a(createView, attributeSet);
                }
                i2++;
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.onCreateView(str, attributeSet);
    }

    /* access modifiers changed from: private */
    public View a(View view, AttributeSet attributeSet) {
        return this.f53115d.a(view, attributeSet);
    }

    class b implements LayoutInflater.Factory {

        /* renamed from: b  reason: collision with root package name */
        private LayoutInflater.Factory f53119b;

        b(LayoutInflater.Factory factory) {
            this.f53119b = factory;
        }

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return h.this.a(this.f53119b.onCreateView(str, context, attributeSet), attributeSet);
        }
    }

    class c implements LayoutInflater.Factory2 {

        /* renamed from: b  reason: collision with root package name */
        private LayoutInflater.Factory2 f53121b;

        c(LayoutInflater.Factory2 factory2) {
            this.f53121b = factory2;
        }

        public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return h.this.a(this.f53121b.onCreateView(view, str, context, attributeSet), attributeSet);
        }

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return h.this.a(this.f53121b.onCreateView(str, context, attributeSet), attributeSet);
        }
    }

    /* access modifiers changed from: private */
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        if (view != null || str.indexOf(46) < 0) {
            return view;
        }
        if (f53111a.booleanValue()) {
            try {
                return cloneInContext(context).createView(str, (String) null, attributeSet);
            } catch (ClassNotFoundException unused) {
                return view;
            }
        } else {
            if (this.f53114c == null) {
                this.f53114c = d.a(LayoutInflater.class, "mConstructorArgs");
            }
            Object[] objArr = (Object[]) d.a(this.f53114c, (Object) this);
            Object obj = objArr[0];
            objArr[0] = context;
            d.a(this.f53114c, (Object) this, (Object) objArr);
            try {
                view = createView(str, (String) null, attributeSet);
                objArr[0] = obj;
            } catch (ClassNotFoundException unused2) {
                objArr[0] = obj;
            } catch (Throwable th) {
                objArr[0] = obj;
                d.a(this.f53114c, (Object) this, (Object) objArr);
                throw th;
            }
            d.a(this.f53114c, (Object) this, (Object) objArr);
            return view;
        }
    }

    class a implements LayoutInflater.Factory2 {

        /* renamed from: b  reason: collision with root package name */
        private LayoutInflater.Factory2 f53117b;

        public a(LayoutInflater.Factory2 factory2) {
            this.f53117b = factory2;
        }

        public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return h.this.a(h.this.a(this.f53117b.onCreateView(view, str, context, attributeSet), str, context, attributeSet), attributeSet);
        }

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return h.this.a(h.this.a(this.f53117b.onCreateView(str, context, attributeSet), str, context, attributeSet), attributeSet);
        }
    }

    public final View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        Method b2;
        if (!this.f53113b) {
            if ((getContext() instanceof LayoutInflater.Factory2) && (b2 = d.b(LayoutInflater.class, "setPrivateFactory")) != null) {
                d.a((Object) this, b2, new a((LayoutInflater.Factory2) getContext()));
            }
            this.f53113b = true;
        }
        return super.inflate(xmlPullParser, viewGroup, z);
    }
}
