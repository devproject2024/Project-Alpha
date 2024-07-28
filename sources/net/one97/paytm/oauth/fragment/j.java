package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.c;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.oauth.utils.TerminalPageState;

public class j implements c {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f56600a = new HashMap();

    private j() {
    }

    public static j fromBundle(Bundle bundle) {
        j jVar = new j();
        bundle.setClassLoader(j.class.getClassLoader());
        if (bundle.containsKey("isAccountBlockCase")) {
            jVar.f56600a.put("isAccountBlockCase", Boolean.valueOf(bundle.getBoolean("isAccountBlockCase")));
        }
        if (bundle.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
            if (Parcelable.class.isAssignableFrom(TerminalPageState.class) || Serializable.class.isAssignableFrom(TerminalPageState.class)) {
                TerminalPageState terminalPageState = (TerminalPageState) bundle.get("net.one97.paytm.oauth.utils.TerminalPageState");
                if (terminalPageState != null) {
                    jVar.f56600a.put("net.one97.paytm.oauth.utils.TerminalPageState", terminalPageState);
                } else {
                    throw new IllegalArgumentException("Argument \"net.one97.paytm.oauth.utils.TerminalPageState\" is marked as non-null but was passed a null value.");
                }
            } else {
                throw new UnsupportedOperationException(TerminalPageState.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
        }
        return jVar;
    }

    public final boolean a() {
        return ((Boolean) this.f56600a.get("isAccountBlockCase")).booleanValue();
    }

    public final TerminalPageState b() {
        return (TerminalPageState) this.f56600a.get("net.one97.paytm.oauth.utils.TerminalPageState");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f56600a.containsKey("isAccountBlockCase") == jVar.f56600a.containsKey("isAccountBlockCase") && a() == jVar.a() && this.f56600a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState") == jVar.f56600a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
            return b() == null ? jVar.b() == null : b().equals(jVar.b());
        }
        return false;
    }

    public int hashCode() {
        return (((a() ? 1 : 0) + true) * 31) + (b() != null ? b().hashCode() : 0);
    }

    public String toString() {
        return "AccountBlockUnblockTerminalFragmentArgs{isAccountBlockCase=" + a() + ", netOne97PaytmOauthUtilsTerminalPageState=" + b() + "}";
    }
}
