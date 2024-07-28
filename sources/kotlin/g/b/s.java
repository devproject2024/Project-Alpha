package kotlin.g.b;

import kotlin.k.b;
import kotlin.k.i;

public abstract class s extends c implements i {
    public s() {
    }

    public s(Object obj) {
        super(obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
    }

    /* access modifiers changed from: protected */
    public i getReflected() {
        return (i) super.getReflected();
    }

    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public boolean isConst() {
        return getReflected().isConst();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            return getOwner().equals(sVar.getOwner()) && getName().equals(sVar.getName()) && getSignature().equals(sVar.getSignature()) && k.a(getBoundReceiver(), sVar.getBoundReceiver());
        } else if (obj instanceof i) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
