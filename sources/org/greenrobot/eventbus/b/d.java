package org.greenrobot.eventbus.b;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import org.greenrobot.eventbus.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static b<?> f72838a;

    public static class a extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f72839a;

        /* renamed from: b  reason: collision with root package name */
        protected Bundle f72840b;

        /* renamed from: c  reason: collision with root package name */
        private c f72841c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f72842d;

        /* renamed from: e  reason: collision with root package name */
        private Object f72843e;

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f72841c = d.f72838a.f72835a.a();
            this.f72841c.a((Object) this);
            this.f72842d = true;
        }

        public void onResume() {
            super.onResume();
            if (this.f72842d) {
                this.f72842d = false;
                return;
            }
            this.f72841c = d.f72838a.f72835a.a();
            this.f72841c.a((Object) this);
        }

        public void onPause() {
            this.f72841c.b(this);
            super.onPause();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r1 = r6.f72847c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onEventMainThread(org.greenrobot.eventbus.b.f r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.f72843e
                if (r6 == 0) goto L_0x0010
                java.lang.Object r1 = r6.f72847c
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
                org.greenrobot.eventbus.b.d.a()
                androidx.fragment.app.j r0 = r5.getFragmentManager()
                r0.b()
                java.lang.String r1 = "de.greenrobot.eventbus.error_dialog"
                androidx.fragment.app.Fragment r2 = r0.c((java.lang.String) r1)
                androidx.fragment.app.b r2 = (androidx.fragment.app.b) r2
                if (r2 == 0) goto L_0x002b
                r2.dismiss()
            L_0x002b:
                org.greenrobot.eventbus.b.b<?> r2 = org.greenrobot.eventbus.b.d.f72838a
                boolean r3 = r5.f72839a
                android.os.Bundle r4 = r5.f72840b
                java.lang.Object r6 = r2.a(r6, r3, r4)
                androidx.fragment.app.b r6 = (androidx.fragment.app.b) r6
                if (r6 == 0) goto L_0x003c
                r6.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
            L_0x003c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.b.d.a.onEventMainThread(org.greenrobot.eventbus.b.f):void");
        }
    }

    protected static void a() {
        if (f72838a.f72835a.f72831f && f72838a.f72835a.f72832g == null) {
            String str = c.f72848a;
        }
    }
}
