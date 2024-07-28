package net.one97.paytm.o2o.movies.utils;

import com.google.gson.b.a;
import com.google.gson.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;

public final class g {

    /* renamed from: c  reason: collision with root package name */
    private static g f75923c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRFoodBeverageItemV2> f75924a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRFoodBeverageItemV2> f75925b;

    public static g a() {
        g gVar = f75923c;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g();
        f75923c = gVar2;
        return gVar2;
    }

    public final void b() {
        f fVar = new f();
        this.f75925b = (ArrayList) fVar.a(fVar.b(this.f75924a), new a<ArrayList<CJRFoodBeverageItemV2>>() {
        }.getType());
    }

    public final void c() {
        this.f75924a = this.f75925b;
    }

    public final void d() {
        ArrayList<CJRFoodBeverageItemV2> arrayList = this.f75924a;
        if (arrayList != null) {
            arrayList.clear();
            this.f75924a = null;
        }
        ArrayList<CJRFoodBeverageItemV2> arrayList2 = this.f75925b;
        if (arrayList2 != null) {
            arrayList2.clear();
            this.f75925b = null;
        }
        f75923c = null;
    }

    public final ArrayList<CJRFoodBeverageItemV2> a(boolean z) {
        ArrayList<CJRFoodBeverageItemV2> arrayList = new ArrayList<>();
        if (this.f75924a == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.f75924a.size(); i2++) {
            if (this.f75924a.get(i2).getmFoodQauntitySelected() > 0) {
                arrayList.add(0, this.f75924a.get(i2));
            }
        }
        if (z) {
            a(this.f75924a);
        }
        return arrayList;
    }

    private void a(ArrayList<CJRFoodBeverageItemV2> arrayList) {
        Collections.sort(arrayList, new Comparator<CJRFoodBeverageItemV2>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                CJRFoodBeverageItemV2 cJRFoodBeverageItemV2 = (CJRFoodBeverageItemV2) obj;
                CJRFoodBeverageItemV2 cJRFoodBeverageItemV22 = (CJRFoodBeverageItemV2) obj2;
                if (cJRFoodBeverageItemV22.getItemSelectionTimeStamp().compareTo(cJRFoodBeverageItemV2.getItemSelectionTimeStamp()) <= 0 || cJRFoodBeverageItemV22.getmFoodQauntitySelected() <= 0) {
                    return cJRFoodBeverageItemV22.getItemSelectionTimeStamp().compareTo(cJRFoodBeverageItemV2.getItemSelectionTimeStamp()) == 0 ? 0 : -1;
                }
                return 1;
            }
        });
    }
}
