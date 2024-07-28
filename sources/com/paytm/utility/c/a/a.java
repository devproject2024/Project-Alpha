package com.paytm.utility.c.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paytm.utility.R;
import com.paytm.utility.g;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;

public final class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public static final C0751a f43769a = new C0751a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private c f43770b;

    /* renamed from: c  reason: collision with root package name */
    private b f43771c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f43772d;

    public interface b {
    }

    /* renamed from: com.paytm.utility.c.a.a$a  reason: collision with other inner class name */
    public static final class C0751a {
        private C0751a() {
        }

        public /* synthetic */ C0751a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q.d("onCreate: permission fragment created");
    }

    public final void a() {
        if (this.f43770b != null) {
            this.f43770b = null;
            this.f43771c = null;
            return;
        }
        q.c();
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        q.d("passing callback");
        a(strArr, iArr);
    }

    private final void a(String[] strArr, int[] iArr) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z2 = false;
        if (strArr.length == 0) {
            q.c();
            return;
        }
        b bVar = b.f43777a;
        if (b.a(getContext(), strArr)) {
            c cVar = this.f43770b;
            if (cVar != null) {
                cVar.a(new String[0]);
            }
            a();
            return;
        }
        b bVar2 = b.f43777a;
        String[] a2 = b.a(strArr, iArr);
        c cVar2 = this.f43770b;
        if (cVar2 != null) {
            cVar2.a(a2);
        }
        int length = a2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (!shouldShowRequestPermissionRationale(a2[i2])) {
                z = false;
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        c cVar3 = this.f43770b;
        if (cVar3 == null || !cVar3.f43780c || !z2) {
            c cVar4 = this.f43770b;
            if (cVar4 == null || !cVar4.f43779b || !z) {
                a();
                return;
            }
            c cVar5 = this.f43770b;
            if (cVar5 == null || cVar5.f43782e == null) {
                Context context = getContext();
                c cVar6 = this.f43770b;
                if (cVar6 != null) {
                    str = cVar6.f43781d;
                } else {
                    str = null;
                }
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                g.a(context, str2, getString(R.string.open_settings), getString(R.string.cancel), new e(this), new f(this));
                return;
            }
            return;
        }
        c cVar7 = this.f43770b;
        if (cVar7 == null || cVar7.f43783f == null) {
            Context context2 = getContext();
            c cVar8 = this.f43770b;
            if (cVar8 != null) {
                str3 = cVar8.f43781d;
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str4 = "";
            } else {
                str4 = str3;
            }
            g.a(context2, str4, getString(R.string.open_settings), getString(R.string.cancel), new c(this), new d(this));
            return;
        }
        c cVar9 = this.f43770b;
        if (cVar9 != null) {
            b bVar3 = b.f43777a;
            cVar9.b(b.a(this, strArr, iArr));
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43773a;

        c(a aVar) {
            this.f43773a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f43773a.b();
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43774a;

        d(a aVar) {
            this.f43774a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f43774a.a();
        }
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43775a;

        e(a aVar) {
            this.f43775a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f43775a.b();
        }
    }

    static final class f implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43776a;

        f(a aVar) {
            this.f43776a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f43776a.a();
        }
    }

    public final void b() {
        if (this.f43770b != null) {
            FragmentActivity activity = getActivity();
            startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", activity != null ? activity.getPackageName() : null, (String) null)), 199);
            return;
        }
        q.c();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        String[] strArr;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 199) {
            c cVar = this.f43770b;
            int i4 = 0;
            if (cVar == null || (strArr = cVar.f43778a) == null) {
                strArr = new String[0];
            }
            int[] iArr = new int[strArr.length];
            int length = strArr.length;
            int i5 = 0;
            while (i4 < length) {
                String str = strArr[i4];
                int i6 = i5 + 1;
                Context context = getContext();
                iArr[i5] = context != null ? androidx.core.app.a.a(context, str) : -1;
                i4++;
                i5 = i6;
            }
            a(strArr, iArr);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f43772d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
