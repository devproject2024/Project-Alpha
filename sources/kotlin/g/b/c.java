package kotlin.g.b;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.k.b;
import kotlin.k.d;
import kotlin.k.l;
import kotlin.k.m;

public abstract class c implements Serializable, b {
    public static final Object NO_RECEIVER = a.INSTANCE;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient b reflected;
    private final String signature;

    /* access modifiers changed from: protected */
    public abstract b computeReflected();

    static class a implements Serializable {
        /* access modifiers changed from: private */
        public static final a INSTANCE = new a();

        private a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }
    }

    public c() {
        this(NO_RECEIVER);
    }

    protected c(Object obj) {
        this(obj, (Class) null, (String) null, (String) null, false);
    }

    protected c(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public b compute() {
        b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        b computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    /* access modifiers changed from: protected */
    public b getReflected() {
        b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new kotlin.g.b();
    }

    public d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? y.a(cls) : y.b(cls);
    }

    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return this.signature;
    }

    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public l getReturnType() {
        return getReflected().getReturnType();
    }

    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public m getVisibility() {
        return getReflected().getVisibility();
    }

    public boolean isFinal() {
        return getReflected().isFinal();
    }

    public boolean isOpen() {
        return getReflected().isOpen();
    }

    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
