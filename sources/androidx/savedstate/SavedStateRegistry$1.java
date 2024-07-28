package androidx.savedstate;

import androidx.lifecycle.i;
import androidx.lifecycle.k;
import androidx.lifecycle.q;

class SavedStateRegistry$1 implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4511a;

    SavedStateRegistry$1(a aVar) {
        this.f4511a = aVar;
    }

    public final void a(q qVar, k.a aVar) {
        if (aVar == k.a.ON_START) {
            this.f4511a.f4512a = true;
        } else if (aVar == k.a.ON_STOP) {
            this.f4511a.f4512a = false;
        }
    }
}
