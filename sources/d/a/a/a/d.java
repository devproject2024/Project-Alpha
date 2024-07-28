package d.a.a.a;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import d.a.a.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static b<?> f45929a;

    public static class a extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f45930a;

        /* renamed from: b  reason: collision with root package name */
        protected Bundle f45931b;

        /* renamed from: c  reason: collision with root package name */
        private c f45932c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f45933d;

        /* renamed from: e  reason: collision with root package name */
        private Object f45934e;

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f45932c = d.f45929a.f45926a.a();
            this.f45932c.a((Object) this, false);
            this.f45933d = true;
        }

        public void onResume() {
            super.onResume();
            if (this.f45933d) {
                this.f45933d = false;
                return;
            }
            this.f45932c = d.f45929a.f45926a.a();
            this.f45932c.a((Object) this, false);
        }

        public void onPause() {
            this.f45932c.b(this);
            super.onPause();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r1 = r6.f45938c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onEventMainThread(d.a.a.a.f r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.f45934e
                if (r6 == 0) goto L_0x0010
                java.lang.Object r1 = r6.f45938c
                if (r1 == 0) goto L_0x0010
                boolean r0 = r1.equals(r0)
                if (r0 != 0) goto L_0x0010
                r0 = 0
                goto L_0x0011
            L_0x0010:
                r0 = 1
            L_0x0011:
                if (r0 != 0) goto L_0x0014
                return
            L_0x0014:
                d.a.a.a.d.a()
                androidx.fragment.app.j r0 = r5.getFragmentManager()
                r0.b()
                java.lang.String r1 = "de.greenrobot.eventbus.error_dialog"
                androidx.fragment.app.Fragment r2 = r0.c((java.lang.String) r1)
                androidx.fragment.app.b r2 = (androidx.fragment.app.b) r2
                if (r2 == 0) goto L_0x002b
                r2.dismiss()
            L_0x002b:
                d.a.a.a.b<?> r2 = d.a.a.a.d.f45929a
                boolean r3 = r5.f45930a
                android.os.Bundle r4 = r5.f45931b
                java.lang.Object r6 = r2.a(r6, r3, r4)
                androidx.fragment.app.b r6 = (androidx.fragment.app.b) r6
                if (r6 == 0) goto L_0x003c
                r6.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
            L_0x003c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d.a.a.a.d.a.onEventMainThread(d.a.a.a.f):void");
        }
    }

    protected static void a() {
        if (f45929a.f45926a.f45922f && f45929a.f45926a.f45923g == null) {
            String str = c.f45942a;
        }
    }
}
