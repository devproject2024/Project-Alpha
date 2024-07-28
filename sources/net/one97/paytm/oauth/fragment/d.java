package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.l;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.TerminalPageState;

public final class d {
    public static a a() {
        return new a((byte) 0);
    }

    public static b b() {
        return new b((byte) 0);
    }

    public static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56588a;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f56588a = new HashMap();
        }

        public final a a(String str) {
            this.f56588a.put("verifierId", str);
            return this;
        }

        public final a b(String str) {
            this.f56588a.put("accountEncryptPublicKey", str);
            return this;
        }

        public final a c(String str) {
            this.f56588a.put("accountEncryptSalt", str);
            return this;
        }

        public final a d(String str) {
            this.f56588a.put("state", str);
            return this;
        }

        public final a e(String str) {
            this.f56588a.put("mobile", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56588a.containsKey("verifierId")) {
                bundle.putString("verifierId", (String) this.f56588a.get("verifierId"));
            }
            if (this.f56588a.containsKey("accountEncryptPublicKey")) {
                bundle.putString("accountEncryptPublicKey", (String) this.f56588a.get("accountEncryptPublicKey"));
            }
            if (this.f56588a.containsKey("accountEncryptSalt")) {
                bundle.putString("accountEncryptSalt", (String) this.f56588a.get("accountEncryptSalt"));
            }
            if (this.f56588a.containsKey("state")) {
                bundle.putString("state", (String) this.f56588a.get("state"));
            }
            if (this.f56588a.containsKey("mobile")) {
                bundle.putString("mobile", (String) this.f56588a.get("mobile"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionAccountBlockEnterPasscode;
        }

        private String c() {
            return (String) this.f56588a.get("verifierId");
        }

        private String d() {
            return (String) this.f56588a.get("accountEncryptPublicKey");
        }

        private String e() {
            return (String) this.f56588a.get("accountEncryptSalt");
        }

        private String f() {
            return (String) this.f56588a.get("state");
        }

        private String g() {
            return (String) this.f56588a.get("mobile");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f56588a.containsKey("verifierId") != aVar.f56588a.containsKey("verifierId")) {
                return false;
            }
            if (c() == null ? aVar.c() != null : !c().equals(aVar.c())) {
                return false;
            }
            if (this.f56588a.containsKey("accountEncryptPublicKey") != aVar.f56588a.containsKey("accountEncryptPublicKey")) {
                return false;
            }
            if (d() == null ? aVar.d() != null : !d().equals(aVar.d())) {
                return false;
            }
            if (this.f56588a.containsKey("accountEncryptSalt") != aVar.f56588a.containsKey("accountEncryptSalt")) {
                return false;
            }
            if (e() == null ? aVar.e() != null : !e().equals(aVar.e())) {
                return false;
            }
            if (this.f56588a.containsKey("state") != aVar.f56588a.containsKey("state")) {
                return false;
            }
            if (f() == null ? aVar.f() != null : !f().equals(aVar.f())) {
                return false;
            }
            if (this.f56588a.containsKey("mobile") != aVar.f56588a.containsKey("mobile")) {
                return false;
            }
            if (g() == null ? aVar.g() != null : !g().equals(aVar.g())) {
                return false;
            }
            int i2 = R.id.navActionAccountBlockEnterPasscode;
            return true;
        }

        public final int hashCode() {
            int i2 = 0;
            int hashCode = ((((((((c() != null ? c().hashCode() : 0) + 31) * 31) + (d() != null ? d().hashCode() : 0)) * 31) + (e() != null ? e().hashCode() : 0)) * 31) + (f() != null ? f().hashCode() : 0)) * 31;
            if (g() != null) {
                i2 = g().hashCode();
            }
            return ((hashCode + i2) * 31) + R.id.navActionAccountBlockEnterPasscode;
        }

        public final String toString() {
            return "NavActionAccountBlockEnterPasscode(actionId=" + R.id.navActionAccountBlockEnterPasscode + "){verifierId=" + c() + ", accountEncryptPublicKey=" + d() + ", accountEncryptSalt=" + e() + ", state=" + f() + ", mobile=" + g() + "}";
        }
    }

    public static class b implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56589a;

        /* synthetic */ b(byte b2) {
            this();
        }

        private b() {
            this.f56589a = new HashMap();
        }

        public final b c() {
            this.f56589a.put("isAccountBlockCase", Boolean.TRUE);
            return this;
        }

        public final b a(TerminalPageState terminalPageState) {
            if (terminalPageState != null) {
                this.f56589a.put("net.one97.paytm.oauth.utils.TerminalPageState", terminalPageState);
                return this;
            }
            throw new IllegalArgumentException("Argument \"net.one97.paytm.oauth.utils.TerminalPageState\" is marked as non-null but was passed a null value.");
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56589a.containsKey("isAccountBlockCase")) {
                bundle.putBoolean("isAccountBlockCase", ((Boolean) this.f56589a.get("isAccountBlockCase")).booleanValue());
            }
            if (this.f56589a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
                TerminalPageState terminalPageState = (TerminalPageState) this.f56589a.get("net.one97.paytm.oauth.utils.TerminalPageState");
                if (Parcelable.class.isAssignableFrom(TerminalPageState.class) || terminalPageState == null) {
                    bundle.putParcelable("net.one97.paytm.oauth.utils.TerminalPageState", Parcelable.class.cast(terminalPageState));
                } else if (Serializable.class.isAssignableFrom(TerminalPageState.class)) {
                    bundle.putSerializable("net.one97.paytm.oauth.utils.TerminalPageState", Serializable.class.cast(terminalPageState));
                } else {
                    throw new UnsupportedOperationException(TerminalPageState.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionAccountBlockTerminal;
        }

        private boolean d() {
            return ((Boolean) this.f56589a.get("isAccountBlockCase")).booleanValue();
        }

        private TerminalPageState e() {
            return (TerminalPageState) this.f56589a.get("net.one97.paytm.oauth.utils.TerminalPageState");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f56589a.containsKey("isAccountBlockCase") != bVar.f56589a.containsKey("isAccountBlockCase") || d() != bVar.d() || this.f56589a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState") != bVar.f56589a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
                return false;
            }
            if (e() == null ? bVar.e() != null : !e().equals(bVar.e())) {
                return false;
            }
            int i2 = R.id.navActionAccountBlockTerminal;
            return true;
        }

        public final int hashCode() {
            return (((((d() ? 1 : 0) + true) * 31) + (e() != null ? e().hashCode() : 0)) * 31) + R.id.navActionAccountBlockTerminal;
        }

        public final String toString() {
            return "NavActionAccountBlockTerminal(actionId=" + R.id.navActionAccountBlockTerminal + "){isAccountBlockCase=" + d() + ", netOne97PaytmOauthUtilsTerminalPageState=" + e() + "}";
        }
    }
}
