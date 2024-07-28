package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.l;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.TerminalPageState;

public final class h {
    public static a a() {
        return new a((byte) 0);
    }

    public static b b() {
        return new b((byte) 0);
    }

    public static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56594a;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f56594a = new HashMap();
        }

        public final a a(boolean z) {
            this.f56594a.put("logout", Boolean.valueOf(z));
            return this;
        }

        public final a a(String str) {
            this.f56594a.put("mobile", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56594a.containsKey("meta")) {
                bundle.putString("meta", (String) this.f56594a.get("meta"));
            }
            if (this.f56594a.containsKey("logout")) {
                bundle.putBoolean("logout", ((Boolean) this.f56594a.get("logout")).booleanValue());
            }
            if (this.f56594a.containsKey("mobile")) {
                bundle.putString("mobile", (String) this.f56594a.get("mobile"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionAccountBlockConfirmed;
        }

        private String c() {
            return (String) this.f56594a.get("meta");
        }

        private boolean d() {
            return ((Boolean) this.f56594a.get("logout")).booleanValue();
        }

        private String e() {
            return (String) this.f56594a.get("mobile");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f56594a.containsKey("meta") != aVar.f56594a.containsKey("meta")) {
                return false;
            }
            if (c() == null ? aVar.c() != null : !c().equals(aVar.c())) {
                return false;
            }
            if (this.f56594a.containsKey("logout") != aVar.f56594a.containsKey("logout") || d() != aVar.d() || this.f56594a.containsKey("mobile") != aVar.f56594a.containsKey("mobile")) {
                return false;
            }
            if (e() == null ? aVar.e() != null : !e().equals(aVar.e())) {
                return false;
            }
            int i2 = R.id.navActionAccountBlockConfirmed;
            return true;
        }

        public final int hashCode() {
            int i2 = 0;
            int hashCode = ((((c() != null ? c().hashCode() : 0) + 31) * 31) + (d() ? 1 : 0)) * 31;
            if (e() != null) {
                i2 = e().hashCode();
            }
            return ((hashCode + i2) * 31) + R.id.navActionAccountBlockConfirmed;
        }

        public final String toString() {
            return "NavActionAccountBlockConfirmed(actionId=" + R.id.navActionAccountBlockConfirmed + "){meta=" + c() + ", logout=" + d() + ", mobile=" + e() + "}";
        }
    }

    public static class b implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56595a;

        /* synthetic */ b(byte b2) {
            this();
        }

        private b() {
            this.f56595a = new HashMap();
        }

        public final b c() {
            this.f56595a.put("isAccountBlockCase", Boolean.TRUE);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56595a.containsKey("isAccountBlockCase")) {
                bundle.putBoolean("isAccountBlockCase", ((Boolean) this.f56595a.get("isAccountBlockCase")).booleanValue());
            }
            if (this.f56595a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
                TerminalPageState terminalPageState = (TerminalPageState) this.f56595a.get("net.one97.paytm.oauth.utils.TerminalPageState");
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
            return ((Boolean) this.f56595a.get("isAccountBlockCase")).booleanValue();
        }

        private TerminalPageState e() {
            return (TerminalPageState) this.f56595a.get("net.one97.paytm.oauth.utils.TerminalPageState");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f56595a.containsKey("isAccountBlockCase") != bVar.f56595a.containsKey("isAccountBlockCase") || d() != bVar.d() || this.f56595a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState") != bVar.f56595a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
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
