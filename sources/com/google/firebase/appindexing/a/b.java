package com.google.firebase.appindexing.a;

import android.os.Bundle;
import com.google.android.gms.common.internal.s;
import com.google.firebase.appindexing.a.b;
import com.google.firebase.appindexing.g;
import com.google.firebase.appindexing.internal.Thing;
import com.google.firebase.appindexing.internal.v;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.Arrays;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class b<T extends b<?>> {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f37999a = new Bundle();

    /* renamed from: b  reason: collision with root package name */
    private final String f38000b;

    /* renamed from: c  reason: collision with root package name */
    private Thing.zza f38001c;

    /* renamed from: d  reason: collision with root package name */
    private String f38002d;

    protected b(String str) {
        s.a(str);
        s.a(str);
        this.f38000b = str;
    }

    private T a(String str, String... strArr) {
        Bundle bundle = this.f37999a;
        s.a(str);
        s.a(strArr);
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, 1);
        if (strArr2.length > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < Math.min(strArr2.length, 100); i3++) {
                strArr2[i2] = strArr2[i3];
                if (strArr2[i3] == null) {
                    StringBuilder sb = new StringBuilder(59);
                    sb.append("String at ");
                    sb.append(i3);
                    sb.append(" is null and is ignored by put method.");
                    v.a(sb.toString());
                } else {
                    if (strArr2[i2].length() > 20000) {
                        StringBuilder sb2 = new StringBuilder(53);
                        sb2.append("String at ");
                        sb2.append(i3);
                        sb2.append(" is too long, truncating string.");
                        v.a(sb2.toString());
                        String str2 = strArr2[i2];
                        if (str2.length() > 20000) {
                            int i4 = 19999;
                            if (!Character.isHighSurrogate(str2.charAt(19999)) || !Character.isLowSurrogate(str2.charAt(FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT))) {
                                i4 = FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT;
                            }
                            str2 = str2.substring(0, i4);
                        }
                        strArr2[i2] = str2;
                    }
                    i2++;
                }
            }
            if (i2 > 0) {
                Object[] objArr = (String[]) Arrays.copyOfRange(strArr2, 0, i2);
                if (objArr.length >= 100) {
                    v.a("Input Array of elements is too big, cutting off.");
                    objArr = Arrays.copyOf(objArr, 100);
                }
                bundle.putStringArray(str, (String[]) objArr);
            }
        } else {
            v.a("String array is empty and is ignored by put method.");
        }
        return this;
    }

    public final T a(String str) {
        s.a(str);
        return a("name", str);
    }

    public final T b(String str) {
        s.a(str);
        this.f38002d = str;
        return this;
    }

    public final T c(String str) {
        s.a(str);
        return a(RequestConfirmationDialogFragment.KEY_DESCRIPTION, str);
    }

    public final g a() {
        Bundle bundle = new Bundle(this.f37999a);
        Thing.zza zza = this.f38001c;
        if (zza == null) {
            g.b.a aVar = new g.b.a();
            zza = new Thing.zza(aVar.f38007a, aVar.f38008b, aVar.f38009c, aVar.f38010d);
        }
        return new Thing(bundle, zza, this.f38002d, this.f38000b);
    }
}
