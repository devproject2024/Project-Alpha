package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.c;

public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    int f30837a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence[] f30838b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence[] f30839c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ListPreference listPreference = (ListPreference) b();
            if (listPreference.f30774g == null || listPreference.f30775h == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.f30837a = listPreference.b(listPreference.f30776i);
            this.f30838b = listPreference.f30774g;
            this.f30839c = listPreference.f30775h;
            return;
        }
        this.f30837a = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.f30838b = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.f30839c = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f30837a);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f30838b);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f30839c);
    }

    /* access modifiers changed from: protected */
    public final void a(c.a aVar) {
        super.a(aVar);
        CharSequence[] charSequenceArr = this.f30838b;
        int i2 = this.f30837a;
        AnonymousClass1 r2 = new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                c cVar = c.this;
                cVar.f30837a = i2;
                cVar.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        };
        aVar.f1095a.v = charSequenceArr;
        aVar.f1095a.x = r2;
        aVar.f1095a.I = i2;
        aVar.f1095a.H = true;
        aVar.a((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    public final void a(boolean z) {
        int i2;
        if (z && (i2 = this.f30837a) >= 0) {
            String charSequence = this.f30839c[i2].toString();
            ListPreference listPreference = (ListPreference) b();
            if (listPreference.l()) {
                listPreference.a(charSequence);
            }
        }
    }
}
