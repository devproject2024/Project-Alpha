package androidx.databinding;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.h;
import androidx.databinding.j;
import androidx.databinding.k;
import androidx.databinding.library.R;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public abstract class ViewDataBinding extends a {
    private static final int BINDING_NUMBER_START = 8;
    public static final String BINDING_TAG_PREFIX = "binding_";
    private static final a CREATE_LIST_LISTENER = new a() {
        public final g a(ViewDataBinding viewDataBinding, int i2) {
            return new f(viewDataBinding, i2).f3254a;
        }
    };
    private static final a CREATE_LIVE_DATA_LISTENER = new a() {
        public final g a(ViewDataBinding viewDataBinding, int i2) {
            return new c(viewDataBinding, i2).f3252a;
        }
    };
    private static final a CREATE_MAP_LISTENER = new a() {
        public final g a(ViewDataBinding viewDataBinding, int i2) {
            return new h(viewDataBinding, i2).f3258a;
        }
    };
    private static final a CREATE_PROPERTY_LISTENER = new a() {
        public final g a(ViewDataBinding viewDataBinding, int i2) {
            return new i(viewDataBinding, i2).f3259a;
        }
    };
    private static final int HALTED = 2;
    private static final int REBIND = 1;
    private static final c.a<l, ViewDataBinding, Void> REBIND_NOTIFIER = new c.a<l, ViewDataBinding, Void>() {
        public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2, int i2) {
        }
    };
    private static final int REBOUND = 3;
    /* access modifiers changed from: private */
    public static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER;
    static int SDK_INT = Build.VERSION.SDK_INT;
    private static final boolean USE_CHOREOGRAPHER = (SDK_INT >= 16);
    /* access modifiers changed from: private */
    public static final ReferenceQueue<ViewDataBinding> sReferenceQueue = new ReferenceQueue<>();
    protected final e mBindingComponent;
    private Choreographer mChoreographer;
    private ViewDataBinding mContainingBinding;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mInLiveDataRegisterObserver;
    private boolean mIsExecutingPendingBindings;
    private q mLifecycleOwner;
    private g[] mLocalFieldObservers;
    private OnStartListener mOnStartListener;
    /* access modifiers changed from: private */
    public boolean mPendingRebind;
    private c<l, ViewDataBinding, Void> mRebindCallbacks;
    /* access modifiers changed from: private */
    public boolean mRebindHalted;
    /* access modifiers changed from: private */
    public final Runnable mRebindRunnable;
    /* access modifiers changed from: private */
    public final View mRoot;
    private Handler mUIThreadHandler;

    interface a {
        g a(ViewDataBinding viewDataBinding, int i2);
    }

    interface d<T> {
        void a(q qVar);

        void a(T t);

        void b(T t);
    }

    protected static abstract class e extends h.a implements g {
    }

    /* access modifiers changed from: protected */
    public abstract void executeBindings();

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    /* access modifiers changed from: protected */
    public abstract boolean onFieldChange(int i2, Object obj, int i3);

    public abstract boolean setVariable(int i2, Object obj);

    static {
        if (Build.VERSION.SDK_INT < 19) {
            ROOT_REATTACHED_LISTENER = null;
        } else {
            ROOT_REATTACHED_LISTENER = new View.OnAttachStateChangeListener() {
                public final void onViewDetachedFromWindow(View view) {
                }

                public final void onViewAttachedToWindow(View view) {
                    ViewDataBinding.getBinding(view).mRebindRunnable.run();
                    view.removeOnAttachStateChangeListener(this);
                }
            };
        }
    }

    protected ViewDataBinding(e eVar, View view, int i2) {
        this.mRebindRunnable = new Runnable() {
            public final void run() {
                synchronized (this) {
                    boolean unused = ViewDataBinding.this.mPendingRebind = false;
                }
                ViewDataBinding.processReferenceQueue();
                if (Build.VERSION.SDK_INT < 19 || ViewDataBinding.this.mRoot.isAttachedToWindow()) {
                    ViewDataBinding.this.executePendingBindings();
                    return;
                }
                ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
            }
        };
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = eVar;
        this.mLocalFieldObservers = new g[i2];
        this.mRoot = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        } else if (USE_CHOREOGRAPHER) {
            this.mChoreographer = Choreographer.getInstance();
            this.mFrameCallback = new Choreographer.FrameCallback() {
                public final void doFrame(long j) {
                    ViewDataBinding.this.mRebindRunnable.run();
                }
            };
        } else {
            this.mFrameCallback = null;
            this.mUIThreadHandler = new Handler(Looper.myLooper());
        }
    }

    protected ViewDataBinding(Object obj, View view, int i2) {
        this(checkAndCastToBindingComponent(obj), view, i2);
    }

    private static e checkAndCastToBindingComponent(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof e) {
            return (e) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    /* access modifiers changed from: protected */
    public void setRootTag(View view) {
        view.setTag(R.id.dataBinding, this);
    }

    /* access modifiers changed from: protected */
    public void setRootTag(View[] viewArr) {
        for (View tag : viewArr) {
            tag.setTag(R.id.dataBinding, this);
        }
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    public void setLifecycleOwner(q qVar) {
        q qVar2 = this.mLifecycleOwner;
        if (qVar2 != qVar) {
            if (qVar2 != null) {
                qVar2.getLifecycle().b(this.mOnStartListener);
            }
            this.mLifecycleOwner = qVar;
            if (qVar != null) {
                if (this.mOnStartListener == null) {
                    this.mOnStartListener = new OnStartListener(this, (byte) 0);
                }
                qVar.getLifecycle().a(this.mOnStartListener);
            }
            for (g gVar : this.mLocalFieldObservers) {
                if (gVar != null) {
                    gVar.a(qVar);
                }
            }
        }
    }

    public q getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public void addOnRebindCallback(l lVar) {
        if (this.mRebindCallbacks == null) {
            this.mRebindCallbacks = new c<>(REBIND_NOTIFIER);
        }
        this.mRebindCallbacks.a(lVar);
    }

    public void removeOnRebindCallback(l lVar) {
        c<l, ViewDataBinding, Void> cVar = this.mRebindCallbacks;
        if (cVar != null) {
            cVar.b(lVar);
        }
    }

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
        } else if (hasPendingBindings()) {
            this.mIsExecutingPendingBindings = true;
            this.mRebindHalted = false;
            c<l, ViewDataBinding, Void> cVar = this.mRebindCallbacks;
            if (cVar != null) {
                cVar.a(this, 1);
                if (this.mRebindHalted) {
                    this.mRebindCallbacks.a(this, 2);
                }
            }
            if (!this.mRebindHalted) {
                executeBindings();
                c<l, ViewDataBinding, Void> cVar2 = this.mRebindCallbacks;
                if (cVar2 != null) {
                    cVar2.a(this, 3);
                }
            }
            this.mIsExecutingPendingBindings = false;
        }
    }

    protected static void executeBindingsOn(ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    /* access modifiers changed from: package-private */
    public void forceExecuteBindings() {
        executeBindings();
    }

    public void unbind() {
        for (g gVar : this.mLocalFieldObservers) {
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    static ViewDataBinding getBinding(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R.id.dataBinding);
        }
        return null;
    }

    public View getRoot() {
        return this.mRoot;
    }

    /* access modifiers changed from: private */
    public void handleFieldChange(int i2, Object obj, int i3) {
        if (!this.mInLiveDataRegisterObserver && onFieldChange(i2, obj, i3)) {
            requestRebind();
        }
    }

    /* access modifiers changed from: protected */
    public boolean unregisterFrom(int i2) {
        g gVar = this.mLocalFieldObservers[i2];
        if (gVar != null) {
            return gVar.a();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        if (USE_CHOREOGRAPHER == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        r2.mChoreographer.postFrameCallback(r2.mFrameCallback);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        r2.mUIThreadHandler.post(r2.mRebindRunnable);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void requestRebind() {
        /*
            r2 = this;
            androidx.databinding.ViewDataBinding r0 = r2.mContainingBinding
            if (r0 == 0) goto L_0x0008
            r0.requestRebind()
            return
        L_0x0008:
            androidx.lifecycle.q r0 = r2.mLifecycleOwner
            if (r0 == 0) goto L_0x001d
            androidx.lifecycle.k r0 = r0.getLifecycle()
            androidx.lifecycle.k$b r0 = r0.a()
            androidx.lifecycle.k$b r1 = androidx.lifecycle.k.b.STARTED
            boolean r0 = r0.isAtLeast(r1)
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            monitor-enter(r2)
            boolean r0 = r2.mPendingRebind     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0024
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            return
        L_0x0024:
            r0 = 1
            r2.mPendingRebind = r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            boolean r0 = USE_CHOREOGRAPHER
            if (r0 == 0) goto L_0x0034
            android.view.Choreographer r0 = r2.mChoreographer
            android.view.Choreographer$FrameCallback r1 = r2.mFrameCallback
            r0.postFrameCallback(r1)
            return
        L_0x0034:
            android.os.Handler r0 = r2.mUIThreadHandler
            java.lang.Runnable r1 = r2.mRebindRunnable
            r0.post(r1)
            return
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.requestRebind():void");
    }

    /* access modifiers changed from: protected */
    public Object getObservedField(int i2) {
        g gVar = this.mLocalFieldObservers[i2];
        if (gVar == null) {
            return null;
        }
        return gVar.f3257c;
    }

    private boolean updateRegistration(int i2, Object obj, a aVar) {
        if (obj == null) {
            return unregisterFrom(i2);
        }
        g gVar = this.mLocalFieldObservers[i2];
        if (gVar == null) {
            registerTo(i2, obj, aVar);
            return true;
        } else if (gVar.f3257c == obj) {
            return false;
        } else {
            unregisterFrom(i2);
            registerTo(i2, obj, aVar);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean updateRegistration(int i2, h hVar) {
        return updateRegistration(i2, hVar, CREATE_PROPERTY_LISTENER);
    }

    /* access modifiers changed from: protected */
    public boolean updateRegistration(int i2, j jVar) {
        return updateRegistration(i2, jVar, CREATE_LIST_LISTENER);
    }

    /* access modifiers changed from: protected */
    public boolean updateRegistration(int i2, k kVar) {
        return updateRegistration(i2, kVar, CREATE_MAP_LISTENER);
    }

    /* access modifiers changed from: protected */
    public boolean updateLiveDataRegistration(int i2, LiveData<?> liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            return updateRegistration(i2, liveData, CREATE_LIVE_DATA_LISTENER);
        } finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    /* access modifiers changed from: protected */
    public void ensureBindingComponentIsNotNull(Class<?> cls) {
        if (this.mBindingComponent == null) {
            throw new IllegalStateException("Required DataBindingComponent is null in class " + getClass().getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
        }
    }

    /* access modifiers changed from: protected */
    public void registerTo(int i2, Object obj, a aVar) {
        if (obj != null) {
            g gVar = this.mLocalFieldObservers[i2];
            if (gVar == null) {
                gVar = aVar.a(this, i2);
                this.mLocalFieldObservers[i2] = gVar;
                q qVar = this.mLifecycleOwner;
                if (qVar != null) {
                    gVar.a(qVar);
                }
            }
            gVar.a();
            gVar.f3257c = obj;
            if (gVar.f3257c != null) {
                gVar.f3255a.b(gVar.f3257c);
            }
        }
    }

    public static ViewDataBinding bind(Object obj, View view, int i2) {
        return f.a(checkAndCastToBindingComponent(obj), view, i2);
    }

    protected static Object[] mapBindings(e eVar, View view, int i2, b bVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        mapBindings(eVar, view, objArr, bVar, sparseIntArray, true);
        return objArr;
    }

    protected static boolean parse(String str, boolean z) {
        return str == null ? z : Boolean.parseBoolean(str);
    }

    protected static byte parse(String str, byte b2) {
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b2;
        }
    }

    protected static short parse(String str, short s) {
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    protected static int parse(String str, int i2) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    protected static long parse(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    protected static float parse(String str, float f2) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f2;
        }
    }

    protected static double parse(String str, double d2) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d2;
        }
    }

    protected static char parse(String str, char c2) {
        return (str == null || str.isEmpty()) ? c2 : str.charAt(0);
    }

    protected static int getColorFromResource(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColor(i2);
        }
        return view.getResources().getColor(i2);
    }

    protected static ColorStateList getColorStateListFromResource(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColorStateList(i2);
        }
        return view.getResources().getColorStateList(i2);
    }

    protected static Drawable getDrawableFromResource(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getContext().getDrawable(i2);
        }
        return view.getResources().getDrawable(i2);
    }

    protected static <T> T getFromArray(T[] tArr, int i2) {
        if (tArr == null || i2 < 0 || i2 >= tArr.length) {
            return null;
        }
        return tArr[i2];
    }

    protected static <T> void setTo(T[] tArr, int i2, T t) {
        if (tArr != null && i2 >= 0 && i2 < tArr.length) {
            tArr[i2] = t;
        }
    }

    protected static boolean getFromArray(boolean[] zArr, int i2) {
        if (zArr == null || i2 < 0 || i2 >= zArr.length) {
            return false;
        }
        return zArr[i2];
    }

    protected static void setTo(boolean[] zArr, int i2, boolean z) {
        if (zArr != null && i2 >= 0 && i2 < zArr.length) {
            zArr[i2] = z;
        }
    }

    protected static byte getFromArray(byte[] bArr, int i2) {
        if (bArr == null || i2 < 0 || i2 >= bArr.length) {
            return 0;
        }
        return bArr[i2];
    }

    protected static void setTo(byte[] bArr, int i2, byte b2) {
        if (bArr != null && i2 >= 0 && i2 < bArr.length) {
            bArr[i2] = b2;
        }
    }

    protected static short getFromArray(short[] sArr, int i2) {
        if (sArr == null || i2 < 0 || i2 >= sArr.length) {
            return 0;
        }
        return sArr[i2];
    }

    protected static void setTo(short[] sArr, int i2, short s) {
        if (sArr != null && i2 >= 0 && i2 < sArr.length) {
            sArr[i2] = s;
        }
    }

    protected static char getFromArray(char[] cArr, int i2) {
        if (cArr == null || i2 < 0 || i2 >= cArr.length) {
            return 0;
        }
        return cArr[i2];
    }

    protected static void setTo(char[] cArr, int i2, char c2) {
        if (cArr != null && i2 >= 0 && i2 < cArr.length) {
            cArr[i2] = c2;
        }
    }

    protected static int getFromArray(int[] iArr, int i2) {
        if (iArr == null || i2 < 0 || i2 >= iArr.length) {
            return 0;
        }
        return iArr[i2];
    }

    protected static void setTo(int[] iArr, int i2, int i3) {
        if (iArr != null && i2 >= 0 && i2 < iArr.length) {
            iArr[i2] = i3;
        }
    }

    protected static long getFromArray(long[] jArr, int i2) {
        if (jArr == null || i2 < 0 || i2 >= jArr.length) {
            return 0;
        }
        return jArr[i2];
    }

    protected static void setTo(long[] jArr, int i2, long j) {
        if (jArr != null && i2 >= 0 && i2 < jArr.length) {
            jArr[i2] = j;
        }
    }

    protected static float getFromArray(float[] fArr, int i2) {
        if (fArr == null || i2 < 0 || i2 >= fArr.length) {
            return 0.0f;
        }
        return fArr[i2];
    }

    protected static void setTo(float[] fArr, int i2, float f2) {
        if (fArr != null && i2 >= 0 && i2 < fArr.length) {
            fArr[i2] = f2;
        }
    }

    protected static double getFromArray(double[] dArr, int i2) {
        if (dArr == null || i2 < 0 || i2 >= dArr.length) {
            return 0.0d;
        }
        return dArr[i2];
    }

    protected static void setTo(double[] dArr, int i2, double d2) {
        if (dArr != null && i2 >= 0 && i2 < dArr.length) {
            dArr[i2] = d2;
        }
    }

    protected static <T> T getFromList(List<T> list, int i2) {
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    protected static <T> void setTo(List<T> list, int i2, T t) {
        if (list != null && i2 >= 0 && i2 < list.size()) {
            list.set(i2, t);
        }
    }

    protected static <T> T getFromList(SparseArray<T> sparseArray, int i2) {
        if (sparseArray == null || i2 < 0) {
            return null;
        }
        return sparseArray.get(i2);
    }

    protected static <T> void setTo(SparseArray<T> sparseArray, int i2, T t) {
        if (sparseArray != null && i2 >= 0 && i2 < sparseArray.size()) {
            sparseArray.put(i2, t);
        }
    }

    protected static <T> T getFromList(LongSparseArray<T> longSparseArray, int i2) {
        if (longSparseArray == null || i2 < 0) {
            return null;
        }
        return longSparseArray.get((long) i2);
    }

    protected static <T> void setTo(LongSparseArray<T> longSparseArray, int i2, T t) {
        if (longSparseArray != null && i2 >= 0 && i2 < longSparseArray.size()) {
            longSparseArray.put((long) i2, t);
        }
    }

    protected static <T> void setTo(androidx.a.d<T> dVar, int i2, T t) {
        if (dVar != null && i2 >= 0 && i2 < dVar.b()) {
            dVar.b((long) i2, t);
        }
    }

    protected static boolean getFromList(SparseBooleanArray sparseBooleanArray, int i2) {
        if (sparseBooleanArray == null || i2 < 0) {
            return false;
        }
        return sparseBooleanArray.get(i2);
    }

    protected static void setTo(SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        if (sparseBooleanArray != null && i2 >= 0 && i2 < sparseBooleanArray.size()) {
            sparseBooleanArray.put(i2, z);
        }
    }

    protected static int getFromList(SparseIntArray sparseIntArray, int i2) {
        if (sparseIntArray == null || i2 < 0) {
            return 0;
        }
        return sparseIntArray.get(i2);
    }

    protected static void setTo(SparseIntArray sparseIntArray, int i2, int i3) {
        if (sparseIntArray != null && i2 >= 0 && i2 < sparseIntArray.size()) {
            sparseIntArray.put(i2, i3);
        }
    }

    protected static long getFromList(SparseLongArray sparseLongArray, int i2) {
        if (sparseLongArray == null || i2 < 0) {
            return 0;
        }
        return sparseLongArray.get(i2);
    }

    protected static void setTo(SparseLongArray sparseLongArray, int i2, long j) {
        if (sparseLongArray != null && i2 >= 0 && i2 < sparseLongArray.size()) {
            sparseLongArray.put(i2, j);
        }
    }

    protected static <K, T> T getFrom(Map<K, T> map, K k) {
        if (map == null) {
            return null;
        }
        return map.get(k);
    }

    protected static <K, T> void setTo(Map<K, T> map, K k, T t) {
        if (map != null) {
            map.put(k, t);
        }
    }

    protected static void setBindingInverseListener(ViewDataBinding viewDataBinding, g gVar, e eVar) {
        if (gVar != eVar) {
            if (gVar != null) {
                viewDataBinding.removeOnPropertyChangedCallback((e) gVar);
            }
            if (eVar != null) {
                viewDataBinding.addOnPropertyChangedCallback(eVar);
            }
        }
    }

    protected static int safeUnbox(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    protected static long safeUnbox(Long l) {
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    protected static short safeUnbox(Short sh) {
        if (sh == null) {
            return 0;
        }
        return sh.shortValue();
    }

    protected static byte safeUnbox(Byte b2) {
        if (b2 == null) {
            return 0;
        }
        return b2.byteValue();
    }

    protected static char safeUnbox(Character ch) {
        if (ch == null) {
            return 0;
        }
        return ch.charValue();
    }

    protected static double safeUnbox(Double d2) {
        if (d2 == null) {
            return 0.0d;
        }
        return d2.doubleValue();
    }

    protected static float safeUnbox(Float f2) {
        if (f2 == null) {
            return 0.0f;
        }
        return f2.floatValue();
    }

    protected static boolean safeUnbox(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    public void setContainedBinding(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    protected static Object[] mapBindings(e eVar, View[] viewArr, int i2, b bVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        for (View mapBindings : viewArr) {
            mapBindings(eVar, mapBindings, objArr, bVar, sparseIntArray, true);
        }
        return objArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r7 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        if (r7 == null) goto L_0x005d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0107 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void mapBindings(androidx.databinding.e r16, android.view.View r17, java.lang.Object[] r18, androidx.databinding.ViewDataBinding.b r19, android.util.SparseIntArray r20, boolean r21) {
        /*
            r6 = r16
            r0 = r17
            r7 = r19
            r8 = r20
            androidx.databinding.ViewDataBinding r1 = getBinding(r17)
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Object r1 = r17.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x001a
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            java.lang.String r9 = "layout"
            r2 = -1
            r11 = 1
            if (r21 == 0) goto L_0x0045
            if (r1 == 0) goto L_0x0045
            boolean r3 = r1.startsWith(r9)
            if (r3 == 0) goto L_0x0045
            r3 = 95
            int r3 = r1.lastIndexOf(r3)
            if (r3 <= 0) goto L_0x0061
            int r3 = r3 + r11
            boolean r4 = isNumeric(r1, r3)
            if (r4 == 0) goto L_0x0061
            int r1 = parseTagInt(r1, r3)
            r3 = r18[r1]
            if (r3 != 0) goto L_0x0042
            r18[r1] = r0
        L_0x0042:
            if (r7 != 0) goto L_0x005e
            goto L_0x005d
        L_0x0045:
            if (r1 == 0) goto L_0x0061
            java.lang.String r3 = "binding_"
            boolean r3 = r1.startsWith(r3)
            if (r3 == 0) goto L_0x0061
            int r3 = BINDING_NUMBER_START
            int r1 = parseTagInt(r1, r3)
            r3 = r18[r1]
            if (r3 != 0) goto L_0x005b
            r18[r1] = r0
        L_0x005b:
            if (r7 != 0) goto L_0x005e
        L_0x005d:
            r1 = -1
        L_0x005e:
            r12 = r1
            r1 = 1
            goto L_0x0063
        L_0x0061:
            r1 = 0
            r12 = -1
        L_0x0063:
            if (r1 != 0) goto L_0x0079
            int r1 = r17.getId()
            if (r1 <= 0) goto L_0x0079
            if (r8 == 0) goto L_0x0079
            int r1 = r8.get(r1, r2)
            if (r1 < 0) goto L_0x0079
            r2 = r18[r1]
            if (r2 != 0) goto L_0x0079
            r18[r1] = r0
        L_0x0079:
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x010f
            r13 = r0
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13
            int r14 = r13.getChildCount()
            r0 = 0
            r1 = 0
        L_0x0086:
            if (r0 >= r14) goto L_0x010f
            android.view.View r2 = r13.getChildAt(r0)
            if (r12 < 0) goto L_0x00f5
            java.lang.Object r3 = r2.getTag()
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x00f5
            java.lang.Object r3 = r2.getTag()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "_0"
            boolean r4 = r3.endsWith(r4)
            if (r4 == 0) goto L_0x00f5
            boolean r4 = r3.startsWith(r9)
            if (r4 == 0) goto L_0x00f5
            r4 = 47
            int r4 = r3.indexOf(r4)
            if (r4 <= 0) goto L_0x00f5
            int r3 = findIncludeIndex(r3, r1, r7, r12)
            if (r3 < 0) goto L_0x00f5
            int r1 = r3 + 1
            int[][] r4 = r7.f3250b
            r4 = r4[r12]
            r4 = r4[r3]
            int[][] r5 = r7.f3251c
            r5 = r5[r12]
            r3 = r5[r3]
            int r5 = findLastMatching(r13, r0)
            if (r5 != r0) goto L_0x00d5
            androidx.databinding.ViewDataBinding r3 = androidx.databinding.f.a((androidx.databinding.e) r6, (android.view.View) r2, (int) r3)
            r18[r4] = r3
            r10 = r0
            r15 = r1
            goto L_0x00f8
        L_0x00d5:
            int r5 = r5 - r0
            int r5 = r5 + r11
            android.view.View[] r15 = new android.view.View[r5]
            r10 = 0
        L_0x00da:
            if (r10 >= r5) goto L_0x00e8
            int r11 = r0 + r10
            android.view.View r11 = r13.getChildAt(r11)
            r15[r10] = r11
            int r10 = r10 + 1
            r11 = 1
            goto L_0x00da
        L_0x00e8:
            androidx.databinding.ViewDataBinding r3 = androidx.databinding.f.a((androidx.databinding.e) r6, (android.view.View[]) r15, (int) r3)
            r18[r4] = r3
            int r5 = r5 + -1
            int r0 = r0 + r5
            r10 = r0
            r15 = r1
            r11 = 1
            goto L_0x00f8
        L_0x00f5:
            r10 = r0
            r15 = r1
            r11 = 0
        L_0x00f8:
            if (r11 != 0) goto L_0x0107
            r5 = 0
            r0 = r16
            r1 = r2
            r2 = r18
            r3 = r19
            r4 = r20
            mapBindings(r0, r1, r2, r3, r4, r5)
        L_0x0107:
            r0 = 1
            int r1 = r10 + 1
            r0 = r1
            r1 = r15
            r11 = 1
            goto L_0x0086
        L_0x010f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.mapBindings(androidx.databinding.e, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$b, android.util.SparseIntArray, boolean):void");
    }

    private static int findIncludeIndex(String str, int i2, b bVar, int i3) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = bVar.f3249a[i3];
        int length = strArr.length;
        while (i2 < length) {
            if (TextUtils.equals(subSequence, strArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static int findLastMatching(ViewGroup viewGroup, int i2) {
        String str = (String) viewGroup.getChildAt(i2).getTag();
        String substring = str.substring(0, str.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i3 = i2 + 1; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(substring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i2;
                }
                if (isNumeric(str2, length)) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    private static boolean isNumeric(String str, int i2) {
        int length = str.length();
        if (length == i2) {
            return false;
        }
        while (i2 < length) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private static int parseTagInt(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            i3 = (i3 * 10) + (str.charAt(i2) - '0');
            i2++;
        }
        return i3;
    }

    /* access modifiers changed from: private */
    public static void processReferenceQueue() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = sReferenceQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof g) {
                ((g) poll).a();
            }
        }
    }

    public static <T extends ViewDataBinding> T inflateInternal(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, boolean z, Object obj) {
        return f.a(layoutInflater, i2, viewGroup, z, checkAndCastToBindingComponent(obj));
    }

    static class g<T> extends WeakReference<ViewDataBinding> {

        /* renamed from: a  reason: collision with root package name */
        final d<T> f3255a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f3256b;

        /* renamed from: c  reason: collision with root package name */
        T f3257c;

        public g(ViewDataBinding viewDataBinding, int i2, d<T> dVar) {
            super(viewDataBinding, ViewDataBinding.sReferenceQueue);
            this.f3256b = i2;
            this.f3255a = dVar;
        }

        public final void a(q qVar) {
            this.f3255a.a(qVar);
        }

        public final boolean a() {
            boolean z;
            T t = this.f3257c;
            if (t != null) {
                this.f3255a.a(t);
                z = true;
            } else {
                z = false;
            }
            this.f3257c = null;
            return z;
        }

        /* access modifiers changed from: protected */
        public final ViewDataBinding b() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) get();
            if (viewDataBinding == null) {
                a();
            }
            return viewDataBinding;
        }
    }

    static class i extends h.a implements d<h> {

        /* renamed from: a  reason: collision with root package name */
        final g<h> f3259a;

        public final void a(q qVar) {
        }

        public final /* synthetic */ void a(Object obj) {
            ((h) obj).removeOnPropertyChangedCallback(this);
        }

        public final /* synthetic */ void b(Object obj) {
            ((h) obj).addOnPropertyChangedCallback(this);
        }

        public i(ViewDataBinding viewDataBinding, int i2) {
            this.f3259a = new g<>(viewDataBinding, i2, this);
        }

        public final void onPropertyChanged(h hVar, int i2) {
            ViewDataBinding b2 = this.f3259a.b();
            if (b2 != null && ((h) this.f3259a.f3257c) == hVar) {
                b2.handleFieldChange(this.f3259a.f3256b, hVar, i2);
            }
        }
    }

    static class f extends j.a implements d<j> {

        /* renamed from: a  reason: collision with root package name */
        final g<j> f3254a;

        public final void a(q qVar) {
        }

        public final /* bridge */ /* synthetic */ void a(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void b(Object obj) {
        }

        public f(ViewDataBinding viewDataBinding, int i2) {
            this.f3254a = new g<>(viewDataBinding, i2, this);
        }
    }

    static class h extends k.a implements d<k> {

        /* renamed from: a  reason: collision with root package name */
        final g<k> f3258a;

        public final void a(q qVar) {
        }

        public final /* bridge */ /* synthetic */ void a(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void b(Object obj) {
        }

        public h(ViewDataBinding viewDataBinding, int i2) {
            this.f3258a = new g<>(viewDataBinding, i2, this);
        }
    }

    static class c implements d<LiveData<?>>, z {

        /* renamed from: a  reason: collision with root package name */
        final g<LiveData<?>> f3252a;

        /* renamed from: b  reason: collision with root package name */
        q f3253b;

        public final /* synthetic */ void a(Object obj) {
            ((LiveData) obj).removeObserver(this);
        }

        public final /* synthetic */ void b(Object obj) {
            LiveData liveData = (LiveData) obj;
            q qVar = this.f3253b;
            if (qVar != null) {
                liveData.observe(qVar, this);
            }
        }

        public c(ViewDataBinding viewDataBinding, int i2) {
            this.f3252a = new g<>(viewDataBinding, i2, this);
        }

        public final void a(q qVar) {
            LiveData liveData = (LiveData) this.f3252a.f3257c;
            if (liveData != null) {
                if (this.f3253b != null) {
                    liveData.removeObserver(this);
                }
                if (qVar != null) {
                    liveData.observe(qVar, this);
                }
            }
            this.f3253b = qVar;
        }

        public final void onChanged(Object obj) {
            ViewDataBinding b2 = this.f3252a.b();
            if (b2 != null) {
                b2.handleFieldChange(this.f3252a.f3256b, this.f3252a.f3257c, 0);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String[][] f3249a;

        /* renamed from: b  reason: collision with root package name */
        public final int[][] f3250b;

        /* renamed from: c  reason: collision with root package name */
        public final int[][] f3251c;

        public b(int i2) {
            this.f3249a = new String[i2][];
            this.f3250b = new int[i2][];
            this.f3251c = new int[i2][];
        }

        public final void a(int i2, String[] strArr, int[] iArr, int[] iArr2) {
            this.f3249a[i2] = strArr;
            this.f3250b[i2] = iArr;
            this.f3251c[i2] = iArr2;
        }
    }

    static class OnStartListener implements p {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<ViewDataBinding> f3248a;

        /* synthetic */ OnStartListener(ViewDataBinding viewDataBinding, byte b2) {
            this(viewDataBinding);
        }

        private OnStartListener(ViewDataBinding viewDataBinding) {
            this.f3248a = new WeakReference<>(viewDataBinding);
        }

        @aa(a = k.a.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) this.f3248a.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }
    }

    protected static <T> T getFromList(androidx.a.d<T> dVar, int i2) {
        if (dVar == null || i2 < 0) {
            return null;
        }
        return dVar.a((long) i2, null);
    }
}
