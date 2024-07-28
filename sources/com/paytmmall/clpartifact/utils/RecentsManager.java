package com.paytmmall.clpartifact.utils;

import android.content.Context;
import com.google.gson.f;
import com.google.gson.m;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.d.d;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlin.u;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class RecentsManager {
    static final /* synthetic */ i[] $$delegatedProperties;
    public static final RecentsManager INSTANCE = new RecentsManager();
    private static final int MAX_RECENT_LIST_SIZE = 12;
    private static final g gson$delegate = h.a(RecentsManager$gson$2.INSTANCE);
    private static final g recentSearches$delegate = h.a(RecentsManager$recentSearches$2.INSTANCE);

    private final f getGson() {
        return (f) gson$delegate.getValue();
    }

    private final ArrayList<String> getRecentSearches() {
        return (ArrayList) recentSearches$delegate.getValue();
    }

    static {
        Class<RecentsManager> cls = RecentsManager.class;
        $$delegatedProperties = new i[]{y.a((v) new w(y.b(cls), "recentSearches", "getRecentSearches()Ljava/util/ArrayList;")), y.a((v) new w(y.b(cls), "gson", "getGson()Lcom/google/gson/Gson;"))};
    }

    private RecentsManager() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0043 A[Catch:{ JSONException -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066 A[Catch:{ JSONException -> 0x0076 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> getRecentList() {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.paytm.b.a.a$a r1 = com.paytm.b.a.a.f42641a
            com.paytmmall.clpartifact.common.CLPArtifact r1 = com.paytmmall.clpartifact.common.CLPArtifact.getInstance()
            java.lang.String r2 = "CLPArtifact.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.content.Context r1 = r1.getContext()
            java.lang.String r2 = "CLPArtifact.getInstance().context"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r2 = "CLPArtifact.getInstance(…ontext.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            com.paytm.network.a$c r2 = com.paytm.network.a.c.HOME
            com.paytm.b.a.a r1 = com.paytm.b.a.a.C0708a.a((android.content.Context) r1, (com.paytm.network.a.c) r2)
            r2 = 1
            java.lang.String r3 = "selected_utility"
            java.lang.String r4 = ""
            java.lang.String r1 = r1.b((java.lang.String) r3, (java.lang.String) r4, (boolean) r2)
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ JSONException -> 0x0076 }
            r4 = 0
            if (r3 == 0) goto L_0x0040
            int r3 = r3.length()     // Catch:{ JSONException -> 0x0076 }
            if (r3 != 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r3 = 0
            goto L_0x0041
        L_0x0040:
            r3 = 1
        L_0x0041:
            if (r3 != 0) goto L_0x005c
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0076 }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x0076 }
            int r1 = r3.length()     // Catch:{ JSONException -> 0x0076 }
        L_0x004c:
            if (r4 >= r1) goto L_0x005c
            java.lang.Object r5 = r3.get(r4)     // Catch:{ JSONException -> 0x0076 }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x0076 }
            r0.add(r5)     // Catch:{ JSONException -> 0x0076 }
            int r4 = r4 + 1
            goto L_0x004c
        L_0x005c:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ JSONException -> 0x0076 }
            boolean r1 = r1.isEmpty()     // Catch:{ JSONException -> 0x0076 }
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x0076
            java.util.ArrayList r1 = r6.getRecentSearches()     // Catch:{ JSONException -> 0x0076 }
            r1.clear()     // Catch:{ JSONException -> 0x0076 }
            java.util.ArrayList r1 = r6.getRecentSearches()     // Catch:{ JSONException -> 0x0076 }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ JSONException -> 0x0076 }
            r1.addAll(r0)     // Catch:{ JSONException -> 0x0076 }
        L_0x0076:
            java.util.ArrayList r0 = r6.getRecentSearches()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r0 = kotlin.a.k.e(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.RecentsManager.getRecentList():java.util.List");
    }

    public final void addItemInRecents(String str) {
        k.c(str, "itemName");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (kotlin.d.f) null, (CoroutineStart) null, new RecentsManager$addItemInRecents$1(str, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void addItemInRecentsBG(String str) {
        String str2;
        a.C0708a aVar = a.f42641a;
        CLPArtifact instance = CLPArtifact.getInstance();
        k.a((Object) instance, "CLPArtifact.getInstance()");
        Context context = instance.getContext();
        k.a((Object) context, "CLPArtifact.getInstance().context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "CLPArtifact.getInstance(…ontext.applicationContext");
        a a2 = a.C0708a.a(applicationContext, a.c.HOME);
        try {
            str2 = recentItems(str);
        } catch (m unused) {
            str2 = "";
        }
        if (str2 != null) {
            if (str2.length() > 0) {
                a2.a(CLPConstants.PREF_SELECTED_RECHARGE_UTILITY, str2, true);
            }
        }
    }

    private final String recentItems(String str) {
        int isItemExists = isItemExists(str);
        if (str != null && isItemExists != -1) {
            k.a((Object) getRecentSearches().remove(isItemExists), "recentSearches.removeAt(itemExistPosition)");
        } else if (getRecentSearches().size() == 12) {
            getRecentSearches().remove(getRecentSearches().size() - 1);
        }
        getRecentSearches().add(0, str);
        if (!getRecentSearches().isEmpty()) {
            return getGson().a((Object) getRecentSearches(), new RecentsManager$recentItems$1().getType());
        }
        return null;
    }

    private final int isItemExists(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            int i2 = 0;
            Iterator it2 = getRecentSearches().iterator();
            while (it2.hasNext()) {
                it2.next();
                String str2 = getRecentSearches().get(i2);
                k.a((Object) str2, "recentSearches[i]");
                String str3 = str2;
                if (str3 != null) {
                    String lowerCase2 = str3.toLowerCase();
                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                    if (k.a((Object) lowerCase2, (Object) lowerCase)) {
                        return i2;
                    }
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            return -1;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final List<Item> getFilteredRecents(View view) {
        k.c(view, "view");
        ArrayList arrayList = new ArrayList();
        for (String next : getRecentList()) {
            if (next != null) {
                String lowerCase = next.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                int i2 = 0;
                List<Item> list = view.mItems;
                k.a((Object) list, "view.mItems");
                Iterator it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        it2.next();
                        Item item = view.mItems.get(i2);
                        k.a((Object) item, "view.mItems[j]");
                        String name = item.getName();
                        k.a((Object) name, "view.mItems[j].name");
                        if (name != null) {
                            String lowerCase2 = name.toLowerCase();
                            k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                            if (k.a((Object) lowerCase2, (Object) lowerCase)) {
                                arrayList.add(view.mItems.get(i2));
                            }
                            i2++;
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        return arrayList;
    }

    public final void flushRecentsOnLanguageChange() {
        a.C0708a aVar = com.paytm.b.a.a.f42641a;
        CLPArtifact instance = CLPArtifact.getInstance();
        k.a((Object) instance, "CLPArtifact.getInstance()");
        Context context = instance.getContext();
        k.a((Object) context, "CLPArtifact.getInstance().context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "CLPArtifact.getInstance(…ontext.applicationContext");
        a.C0708a.a(applicationContext, a.c.HOME).a(CLPConstants.PREF_SELECTED_RECHARGE_UTILITY, "", true);
        getRecentSearches().clear();
    }
}
