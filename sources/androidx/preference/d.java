package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    Set<String> f30841a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    boolean f30842b;

    /* renamed from: c  reason: collision with root package name */
    CharSequence[] f30843c;

    /* renamed from: d  reason: collision with root package name */
    CharSequence[] f30844d;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) b();
            if (multiSelectListPreference.f30779g == null || multiSelectListPreference.f30780h == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.f30841a.clear();
            this.f30841a.addAll(multiSelectListPreference.f30781i);
            this.f30842b = false;
            this.f30843c = multiSelectListPreference.f30779g;
            this.f30844d = multiSelectListPreference.f30780h;
            return;
        }
        this.f30841a.clear();
        this.f30841a.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.f30842b = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.f30843c = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.f30844d = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList(this.f30841a));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f30842b);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f30843c);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f30844d);
    }

    /* access modifiers changed from: protected */
    public final void a(c.a aVar) {
        super.a(aVar);
        int length = this.f30844d.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.f30841a.contains(this.f30844d[i2].toString());
        }
        CharSequence[] charSequenceArr = this.f30843c;
        AnonymousClass1 r2 = new DialogInterface.OnMultiChoiceClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                if (z) {
                    d dVar = d.this;
                    dVar.f30842b = d.this.f30841a.add(d.this.f30844d[i2].toString()) | dVar.f30842b;
                    return;
                }
                d dVar2 = d.this;
                dVar2.f30842b = d.this.f30841a.remove(d.this.f30844d[i2].toString()) | dVar2.f30842b;
            }
        };
        aVar.f1095a.v = charSequenceArr;
        aVar.f1095a.J = r2;
        aVar.f1095a.F = zArr;
        aVar.f1095a.G = true;
    }

    public final void a(boolean z) {
        if (z && this.f30842b) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) b();
            if (multiSelectListPreference.l()) {
                multiSelectListPreference.a(this.f30841a);
            }
        }
        this.f30842b = false;
    }
}
