package androidx.databinding;

import androidx.databinding.h;

abstract class b extends a {
    public b() {
    }

    public b(h... hVarArr) {
        if (hVarArr != null && hVarArr.length != 0) {
            a aVar = new a();
            for (h addOnPropertyChangedCallback : hVarArr) {
                addOnPropertyChangedCallback.addOnPropertyChangedCallback(aVar);
            }
        }
    }

    class a extends h.a {
        a() {
        }

        public final void onPropertyChanged(h hVar, int i2) {
            b.this.notifyChange();
        }
    }
}
