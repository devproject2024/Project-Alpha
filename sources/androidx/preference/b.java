package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.a.a.a;
import java.util.ArrayList;
import java.util.List;

final class b extends Preference {

    /* renamed from: a  reason: collision with root package name */
    private long f30836a;

    b(Context context, List<Preference> list, long j) {
        super(context);
        this.v = R.layout.expand_button;
        int i2 = R.drawable.ic_arrow_down_24dp;
        a(a.b(this.j, i2));
        this.o = i2;
        b((CharSequence) this.j.getString(R.string.expand_button_title));
        if (999 != this.m) {
            this.m = 999;
            if (this.x != null) {
                this.x.a();
            }
        }
        CharSequence charSequence = null;
        ArrayList arrayList = new ArrayList();
        for (Preference next : list) {
            CharSequence charSequence2 = next.n;
            boolean z = next instanceof PreferenceGroup;
            if (z && !TextUtils.isEmpty(charSequence2)) {
                arrayList.add((PreferenceGroup) next);
            }
            if (arrayList.contains(next.y)) {
                if (z) {
                    arrayList.add((PreferenceGroup) next);
                }
            } else if (!TextUtils.isEmpty(charSequence2)) {
                if (charSequence == null) {
                    charSequence = charSequence2;
                } else {
                    charSequence = this.j.getString(R.string.summary_collapsed_preference_list, new Object[]{charSequence, charSequence2});
                }
            }
        }
        a(charSequence);
        this.f30836a = j + 1000000;
    }

    public final void a(k kVar) {
        super.a(kVar);
        kVar.f30900a = false;
    }

    /* access modifiers changed from: package-private */
    public final long e() {
        return this.f30836a;
    }
}
