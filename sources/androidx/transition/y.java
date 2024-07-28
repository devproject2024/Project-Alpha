package androidx.transition;

import android.view.View;
import com.business.merchant_payments.utility.StringUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f4850a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f4851b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Transition> f4852c = new ArrayList<>();

    @Deprecated
    public y() {
    }

    public y(View view) {
        this.f4851b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f4851b == yVar.f4851b && this.f4850a.equals(yVar.f4850a);
    }

    public final int hashCode() {
        return (this.f4851b.hashCode() * 31) + this.f4850a.hashCode();
    }

    public final String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f4851b + StringUtility.NEW_LINE) + "    values:";
        for (String next : this.f4850a.keySet()) {
            str = str + "    " + next + ": " + this.f4850a.get(next) + StringUtility.NEW_LINE;
        }
        return str;
    }
}
