package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.a.h;
import androidx.navigation.common.R;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Class> f3917a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private String f3918b;

    /* renamed from: c  reason: collision with root package name */
    final String f3919c;

    /* renamed from: d  reason: collision with root package name */
    m f3920d;

    /* renamed from: e  reason: collision with root package name */
    public int f3921e;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<i> f3922f;

    /* renamed from: g  reason: collision with root package name */
    h<b> f3923g;

    /* renamed from: h  reason: collision with root package name */
    HashMap<String, f> f3924h;

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f3925i;

    /* access modifiers changed from: package-private */
    public boolean a() {
        return true;
    }

    static class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        final k f3926a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f3927b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f3928c;

        a(k kVar, Bundle bundle, boolean z) {
            this.f3926a = kVar;
            this.f3927b = bundle;
            this.f3928c = z;
        }

        /* renamed from: a */
        public final int compareTo(a aVar) {
            if (this.f3928c && !aVar.f3928c) {
                return 1;
            }
            if (this.f3928c || !aVar.f3928c) {
                return this.f3927b.size() - aVar.f3927b.size();
            }
            return -1;
        }
    }

    protected static <C> Class<? extends C> a(Context context, String str, Class<? extends C> cls) {
        if (str.charAt(0) == '.') {
            str = context.getPackageName() + str;
        }
        Class<?> cls2 = f3917a.get(str);
        if (cls2 == null) {
            try {
                cls2 = Class.forName(str, true, context.getClassLoader());
                f3917a.put(str, cls2);
            } catch (ClassNotFoundException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        if (cls.isAssignableFrom(cls2)) {
            return cls2;
        }
        throw new IllegalArgumentException(str + " must be a subclass of " + cls);
    }

    static String a(Context context, int i2) {
        try {
            return context.getResources().getResourceName(i2);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i2);
        }
    }

    public k(s<? extends k> sVar) {
        this(t.a((Class<? extends s>) sVar.getClass()));
    }

    private k(String str) {
        this.f3919c = str;
    }

    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.Navigator);
        this.f3921e = obtainAttributes.getResourceId(R.styleable.Navigator_android_id, 0);
        this.f3918b = null;
        this.f3918b = a(context, this.f3921e);
        this.f3925i = obtainAttributes.getText(R.styleable.Navigator_android_label);
        obtainAttributes.recycle();
    }

    public final int b() {
        return this.f3921e;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        if (this.f3918b == null) {
            this.f3918b = Integer.toString(this.f3921e);
        }
        return this.f3918b;
    }

    /* access modifiers changed from: package-private */
    public a a(Uri uri) {
        Map<String, f> map;
        ArrayList<i> arrayList = this.f3922f;
        a aVar = null;
        if (arrayList == null) {
            return null;
        }
        Iterator<i> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i next = it2.next();
            HashMap<String, f> hashMap = this.f3924h;
            if (hashMap == null) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(hashMap);
            }
            Bundle a2 = next.a(uri, map);
            if (a2 != null) {
                a aVar2 = new a(this, a2, next.f3910a);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final int[] d() {
        ArrayDeque arrayDeque = new ArrayDeque();
        m mVar = this;
        while (true) {
            m mVar2 = mVar.f3920d;
            if (mVar2 == null || mVar2.f3930b != mVar.f3921e) {
                arrayDeque.addFirst(mVar);
            }
            if (mVar2 == null) {
                break;
            }
            mVar = mVar2;
        }
        int[] iArr = new int[arrayDeque.size()];
        int i2 = 0;
        Iterator it2 = arrayDeque.iterator();
        while (it2.hasNext()) {
            iArr[i2] = ((k) it2.next()).f3921e;
            i2++;
        }
        return iArr;
    }

    public final b a(int i2) {
        k kVar = this;
        do {
            h<b> hVar = kVar.f3923g;
            b a2 = hVar == null ? null : hVar.a(i2, null);
            if (a2 != null) {
                return a2;
            }
            kVar = kVar.f3920d;
        } while (kVar != null);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        HashMap<String, f> hashMap = this.f3924h;
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                ((f) next.getValue()).a((String) next.getKey(), bundle2);
            }
        }
        if (bundle == null && bundle2.isEmpty()) {
            return null;
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, f> hashMap2 = this.f3924h;
            if (hashMap2 != null) {
                for (Map.Entry next2 : hashMap2.entrySet()) {
                    if (!((f) next2.getValue()).b((String) next2.getKey(), bundle)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + ((String) next2.getKey()) + "' in argument bundle. " + ((f) next2.getValue()).f3876a.a() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }
}
