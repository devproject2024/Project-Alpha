package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.l;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.TerminalPageState;

public final class n {
    public static a a() {
        return new a((byte) 0);
    }

    public static b b() {
        return new b((byte) 0);
    }

    public static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56605a;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f56605a = new HashMap();
        }

        public final a c() {
            this.f56605a.put("isAccountBlockCase", Boolean.FALSE);
            return this;
        }

        public final a a(TerminalPageState terminalPageState) {
            if (terminalPageState != null) {
                this.f56605a.put("net.one97.paytm.oauth.utils.TerminalPageState", terminalPageState);
                return this;
            }
            throw new IllegalArgumentException("Argument \"net.one97.paytm.oauth.utils.TerminalPageState\" is marked as non-null but was passed a null value.");
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56605a.containsKey("isAccountBlockCase")) {
                bundle.putBoolean("isAccountBlockCase", ((Boolean) this.f56605a.get("isAccountBlockCase")).booleanValue());
            }
            if (this.f56605a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
                TerminalPageState terminalPageState = (TerminalPageState) this.f56605a.get("net.one97.paytm.oauth.utils.TerminalPageState");
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
            return ((Boolean) this.f56605a.get("isAccountBlockCase")).booleanValue();
        }

        private TerminalPageState e() {
            return (TerminalPageState) this.f56605a.get("net.one97.paytm.oauth.utils.TerminalPageState");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f56605a.containsKey("isAccountBlockCase") != aVar.f56605a.containsKey("isAccountBlockCase") || d() != aVar.d() || this.f56605a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState") != aVar.f56605a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
                return false;
            }
            if (e() == null ? aVar.e() != null : !e().equals(aVar.e())) {
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

    public static class b implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56606a;

        /* synthetic */ b(byte b2) {
            this();
        }

        private b() {
            this.f56606a = new HashMap();
        }

        public final b a(String str) {
            this.f56606a.put("mobile", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56606a.containsKey("mobile")) {
                bundle.putString("mobile", (String) this.f56606a.get("mobile"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionAccountUnblockSuccessFragment;
        }

        private String c() {
            return (String) this.f56606a.get("mobile");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f56606a.containsKey("mobile") != bVar.f56606a.containsKey("mobile")) {
                return false;
            }
            if (c() == null ? bVar.c() != null : !c().equals(bVar.c())) {
                return false;
            }
            int i2 = R.id.navActionAccountUnblockSuccessFragment;
            return true;
        }

        public final int hashCode() {
            return (((c() != null ? c().hashCode() : 0) + 31) * 31) + R.id.navActionAccountUnblockSuccessFragment;
        }

        public final String toString() {
            return "NavActionAccountUnblockSuccessFragment(actionId=" + R.id.navActionAccountUnblockSuccessFragment + "){mobile=" + c() + "}";
        }
    }
}
