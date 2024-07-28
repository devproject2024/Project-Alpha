package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    final String f2793a;

    /* renamed from: b  reason: collision with root package name */
    final CharSequence f2794b;

    /* renamed from: c  reason: collision with root package name */
    final CharSequence[] f2795c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f2796d;

    /* renamed from: e  reason: collision with root package name */
    final Bundle f2797e;

    /* renamed from: f  reason: collision with root package name */
    final Set<String> f2798f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2799g;

    static RemoteInput[] a(m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[mVarArr.length];
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            m mVar = mVarArr[i2];
            RemoteInput.Builder addExtras = new RemoteInput.Builder(mVar.f2793a).setLabel(mVar.f2794b).setChoices(mVar.f2795c).setAllowFreeFormInput(mVar.f2796d).addExtras(mVar.f2797e);
            if (Build.VERSION.SDK_INT >= 29) {
                addExtras.setEditChoicesBeforeSending(mVar.f2799g);
            }
            remoteInputArr[i2] = addExtras.build();
        }
        return remoteInputArr;
    }
}
