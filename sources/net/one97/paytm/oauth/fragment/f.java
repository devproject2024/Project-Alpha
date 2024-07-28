package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.l;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.TerminalPageState;

public final class f {
    public static a a() {
        return new a((byte) 0);
    }

    public static b b() {
        return new b((byte) 0);
    }

    public static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56591a;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f56591a = new HashMap();
        }

        public final a a(String str) {
            this.f56591a.put("state", str);
            return this;
        }

        public final a c() {
            this.f56591a.put("logout", Boolean.TRUE);
            return this;
        }

        public final a b(String str) {
            this.f56591a.put("mobile", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56591a.containsKey("meta")) {
                bundle.putString("meta", (String) this.f56591a.get("meta"));
            }
            if (this.f56591a.containsKey("state")) {
                bundle.putString("state", (String) this.f56591a.get("state"));
            }
            if (this.f56591a.containsKey("logout")) {
                bundle.putBoolean("logout", ((Boolean) this.f56591a.get("logout")).booleanValue());
            }
            if (this.f56591a.containsKey("mobile")) {
                bundle.putString("mobile", (String) this.f56591a.get("mobile"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionAccountBlockReason;
        }

        private String d() {
            return (String) this.f56591a.get("meta");
        }

        private String e() {
            return (String) this.f56591a.get("state");
        }

        private boolean f() {
            return ((Boolean) this.f56591a.get("logout")).booleanValue();
        }

        private String g() {
            return (String) this.f56591a.get("mobile");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f56591a.containsKey("meta") != aVar.f56591a.containsKey("meta")) {
                return false;
            }
            if (d() == null ? aVar.d() != null : !d().equals(aVar.d())) {
                return false;
            }
            if (this.f56591a.containsKey("state") != aVar.f56591a.containsKey("state")) {
                return false;
            }
            if (e() == null ? aVar.e() != null : !e().equals(aVar.e())) {
                return false;
            }
            if (this.f56591a.containsKey("logout") != aVar.f56591a.containsKey("logout") || f() != aVar.f() || this.f56591a.containsKey("mobile") != aVar.f56591a.containsKey("mobile")) {
                return false;
            }
            if (g() == null ? aVar.g() != null : !g().equals(aVar.g())) {
                return false;
            }
            int i2 = R.id.navActionAccountBlockReason;
            return true;
        }

        public final int hashCode() {
            int i2 = 0;
            int hashCode = ((((((d() != null ? d().hashCode() : 0) + 31) * 31) + (e() != null ? e().hashCode() : 0)) * 31) + (f() ? 1 : 0)) * 31;
            if (g() != null) {
                i2 = g().hashCode();
            }
            return ((hashCode + i2) * 31) + R.id.navActionAccountBlockReason;
        }

        public final String toString() {
            return "NavActionAccountBlockReason(actionId=" + R.id.navActionAccountBlockReason + "){meta=" + d() + ", state=" + e() + ", logout=" + f() + ", mobile=" + g() + "}";
        }
    }

    public static class b implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56592a;

        /* synthetic */ b(byte b2) {
            this();
        }

        private b() {
            this.f56592a = new HashMap();
        }

        public final b c() {
            this.f56592a.put("isAccountBlockCase", Boolean.TRUE);
            return this;
        }

        public final b a(TerminalPageState terminalPageState) {
            if (terminalPageState != null) {
                this.f56592a.put("net.one97.paytm.oauth.utils.TerminalPageState", terminalPageState);
                return this;
            }
            throw new IllegalArgumentException("Argument \"net.one97.paytm.oauth.utils.TerminalPageState\" is marked as non-null but was passed a null value.");
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56592a.containsKey("isAccountBlockCase")) {
                bundle.putBoolean("isAccountBlockCase", ((Boolean) this.f56592a.get("isAccountBlockCase")).booleanValue());
            }
            if (this.f56592a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
                TerminalPageState terminalPageState = (TerminalPageState) this.f56592a.get("net.one97.paytm.oauth.utils.TerminalPageState");
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
            return ((Boolean) this.f56592a.get("isAccountBlockCase")).booleanValue();
        }

        private TerminalPageState e() {
            return (TerminalPageState) this.f56592a.get("net.one97.paytm.oauth.utils.TerminalPageState");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f56592a.containsKey("isAccountBlockCase") != bVar.f56592a.containsKey("isAccountBlockCase") || d() != bVar.d() || this.f56592a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState") != bVar.f56592a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
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
