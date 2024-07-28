package a.a.a.a.a.d;

import a.a.a.a.a.d.a;
import a.a.a.a.a.e.b;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f733a = new int[2];

    private void a(ViewGroup viewGroup, JSONObject jSONObject, a.C0001a aVar) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            aVar.a(viewGroup.getChildAt(i2), this, jSONObject);
        }
    }

    public final JSONObject a(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f733a);
        int[] iArr = this.f733a;
        return b.a(iArr[0], iArr[1], width, height);
    }

    public final void a(View view, JSONObject jSONObject, a.C0001a aVar, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                a(viewGroup, jSONObject, aVar);
                return;
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
                }
                arrayList.add(childAt);
            }
            ArrayList arrayList2 = new ArrayList(hashMap.keySet());
            Collections.sort(arrayList2);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((ArrayList) hashMap.get((Float) it2.next())).iterator();
                while (it3.hasNext()) {
                    aVar.a((View) it3.next(), this, jSONObject);
                }
            }
        }
    }
}
