package io.branch.indexing;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.TextView;
import io.branch.indexing.b;
import io.branch.referral.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static a m;

    /* renamed from: a  reason: collision with root package name */
    public Handler f46381a = new Handler();

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f46382b;

    /* renamed from: c  reason: collision with root package name */
    String f46383c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f46384d;

    /* renamed from: e  reason: collision with root package name */
    int f46385e;

    /* renamed from: f  reason: collision with root package name */
    int f46386f = 15;

    /* renamed from: g  reason: collision with root package name */
    b f46387g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, WeakReference<ViewTreeObserver>> f46388h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f46389i = new ArrayList<>();
    public Runnable j = new Runnable() {
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x013f */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x010d A[Catch:{ Exception -> 0x0179 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0165 A[ADDED_TO_REGION, Catch:{ Exception -> 0x0179 }] */
        /* JADX WARNING: Removed duplicated region for block: B:58:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r9 = this;
                io.branch.indexing.a r0 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                int r1 = r0.f46385e     // Catch:{ Exception -> 0x0179 }
                r2 = 1
                int r1 = r1 + r2
                r0.f46385e = r1     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r0 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.b r0 = r0.f46387g     // Catch:{ Exception -> 0x0179 }
                boolean r0 = r0.f46399f     // Catch:{ Exception -> 0x0179 }
                if (r0 == 0) goto L_0x0179
                io.branch.indexing.a r0 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                java.lang.ref.WeakReference<android.app.Activity> r0 = r0.f46382b     // Catch:{ Exception -> 0x0179 }
                if (r0 == 0) goto L_0x0179
                io.branch.indexing.a r0 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                java.lang.ref.WeakReference<android.app.Activity> r0 = r0.f46382b     // Catch:{ Exception -> 0x0179 }
                java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0179 }
                if (r0 == 0) goto L_0x0179
                io.branch.indexing.a r0 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                java.lang.ref.WeakReference<android.app.Activity> r0 = r0.f46382b     // Catch:{ Exception -> 0x0179 }
                java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0179 }
                android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r1 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0179 }
                r3.<init>()     // Catch:{ Exception -> 0x0179 }
                r1.f46384d = r3     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r1 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                org.json.JSONObject r1 = r1.f46384d     // Catch:{ Exception -> 0x0179 }
                java.lang.String r3 = "ts"
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0179 }
                r1.put(r3, r4)     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r1 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                java.lang.String r1 = r1.f46383c     // Catch:{ Exception -> 0x0179 }
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0179 }
                if (r1 != 0) goto L_0x0058
                io.branch.indexing.a r1 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                org.json.JSONObject r1 = r1.f46384d     // Catch:{ Exception -> 0x0179 }
                java.lang.String r3 = "rl"
                io.branch.indexing.a r4 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                java.lang.String r4 = r4.f46383c     // Catch:{ Exception -> 0x0179 }
                r1.put(r3, r4)     // Catch:{ Exception -> 0x0179 }
            L_0x0058:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0179 }
                java.lang.String r3 = "/"
                r1.<init>(r3)     // Catch:{ Exception -> 0x0179 }
                java.lang.Class r3 = r0.getClass()     // Catch:{ Exception -> 0x0179 }
                java.lang.String r3 = r3.getSimpleName()     // Catch:{ Exception -> 0x0179 }
                r1.append(r3)     // Catch:{ Exception -> 0x0179 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r3 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                org.json.JSONObject r3 = r3.f46384d     // Catch:{ Exception -> 0x0179 }
                java.lang.String r4 = "v"
                r3.put(r4, r1)     // Catch:{ Exception -> 0x0179 }
                r3 = 16908290(0x1020002, float:2.3877235E-38)
                android.view.View r3 = r0.findViewById(r3)     // Catch:{ Exception -> 0x0179 }
                android.view.ViewGroup r3 = (android.view.ViewGroup) r3     // Catch:{ Exception -> 0x0179 }
                if (r3 == 0) goto L_0x0179
                io.branch.indexing.a r4 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.b r4 = r4.f46387g     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.b$a r4 = r4.a((android.app.Activity) r0)     // Catch:{ Exception -> 0x0179 }
                r5 = 0
                r6 = 0
                if (r4 == 0) goto L_0x00a4
                boolean r5 = r4.f46403b     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r7 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                org.json.JSONObject r7 = r7.f46384d     // Catch:{ Exception -> 0x0179 }
                java.lang.String r8 = "h"
                if (r5 != 0) goto L_0x009a
                goto L_0x009b
            L_0x009a:
                r2 = 0
            L_0x009b:
                r7.put(r8, r2)     // Catch:{ Exception -> 0x0179 }
                org.json.JSONArray r2 = r4.a()     // Catch:{ Exception -> 0x0179 }
                r8 = r5
                goto L_0x00a6
            L_0x00a4:
                r2 = r5
                r8 = 0
            L_0x00a6:
                java.lang.String r4 = "ck"
                if (r2 == 0) goto L_0x00d2
                int r5 = r2.length()     // Catch:{ Exception -> 0x0179 }
                if (r5 <= 0) goto L_0x00d2
                org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ Exception -> 0x0179 }
                r6.<init>()     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r3 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                org.json.JSONObject r3 = r3.f46384d     // Catch:{ Exception -> 0x0179 }
                r3.put(r4, r6)     // Catch:{ Exception -> 0x0179 }
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x0179 }
                r5.<init>()     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r3 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                org.json.JSONObject r3 = r3.f46384d     // Catch:{ Exception -> 0x0179 }
                java.lang.String r4 = "cd"
                r3.put(r4, r5)     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r3 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                r4 = r2
                r7 = r0
                io.branch.indexing.a.a(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0179 }
                goto L_0x00f1
            L_0x00d2:
                io.branch.indexing.a r5 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                java.util.ArrayList<java.lang.String> r5 = r5.f46389i     // Catch:{ Exception -> 0x0179 }
                boolean r5 = r5.contains(r1)     // Catch:{ Exception -> 0x0179 }
                if (r5 != 0) goto L_0x00f1
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x0179 }
                r5.<init>()     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r6 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                org.json.JSONObject r6 = r6.f46384d     // Catch:{ Exception -> 0x0179 }
                r6.put(r4, r5)     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r4 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                android.content.res.Resources r6 = r0.getResources()     // Catch:{ Exception -> 0x0179 }
                r4.a(r3, r5, r6)     // Catch:{ Exception -> 0x0179 }
            L_0x00f1:
                io.branch.indexing.a r3 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                java.util.ArrayList<java.lang.String> r3 = r3.f46389i     // Catch:{ Exception -> 0x0179 }
                r3.add(r1)     // Catch:{ Exception -> 0x0179 }
                io.branch.referral.q.a((android.content.Context) r0)     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r1 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                org.json.JSONObject r1 = r1.f46384d     // Catch:{ Exception -> 0x0179 }
                java.lang.String r3 = "bnc_session_id"
                java.lang.String r3 = io.branch.referral.q.d(r3)     // Catch:{ Exception -> 0x0179 }
                java.lang.String r4 = "bnc_no_value"
                boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0179 }
                if (r4 != 0) goto L_0x013f
                org.json.JSONObject r4 = io.branch.referral.q.f46563c     // Catch:{ Exception -> 0x0179 }
                if (r4 != 0) goto L_0x0117
                org.json.JSONObject r4 = io.branch.referral.q.i()     // Catch:{ Exception -> 0x0179 }
                io.branch.referral.q.f46563c = r4     // Catch:{ Exception -> 0x0179 }
            L_0x0117:
                org.json.JSONObject r4 = io.branch.referral.q.f46563c     // Catch:{ JSONException -> 0x013f }
                boolean r4 = r4.has(r3)     // Catch:{ JSONException -> 0x013f }
                if (r4 == 0) goto L_0x0126
                org.json.JSONObject r4 = io.branch.referral.q.f46563c     // Catch:{ JSONException -> 0x013f }
                org.json.JSONArray r3 = r4.getJSONArray(r3)     // Catch:{ JSONException -> 0x013f }
                goto L_0x0131
            L_0x0126:
                org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x013f }
                r4.<init>()     // Catch:{ JSONException -> 0x013f }
                org.json.JSONObject r5 = io.branch.referral.q.f46563c     // Catch:{ JSONException -> 0x013f }
                r5.put(r3, r4)     // Catch:{ JSONException -> 0x013f }
                r3 = r4
            L_0x0131:
                r3.put(r1)     // Catch:{ JSONException -> 0x013f }
                java.lang.String r1 = "bnc_branch_analytical_data"
                org.json.JSONObject r3 = io.branch.referral.q.f46563c     // Catch:{ JSONException -> 0x013f }
                java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x013f }
                io.branch.referral.q.a((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ JSONException -> 0x013f }
            L_0x013f:
                io.branch.indexing.a r1 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.b r1 = r1.f46387g     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.b$a r1 = r1.a((android.app.Activity) r0)     // Catch:{ Exception -> 0x0179 }
                int r1 = r1.f46404c     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r3 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r4 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.b r4 = r4.f46387g     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.b$a r0 = r4.a((android.app.Activity) r0)     // Catch:{ Exception -> 0x0179 }
                int r0 = r0.f46405d     // Catch:{ Exception -> 0x0179 }
                r3.f46386f = r0     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r0 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                int r0 = r0.f46385e     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r3 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                int r3 = r3.f46386f     // Catch:{ Exception -> 0x0179 }
                if (r0 >= r3) goto L_0x0179
                r0 = 500(0x1f4, float:7.0E-43)
                if (r1 < r0) goto L_0x0179
                if (r2 == 0) goto L_0x0179
                int r0 = r2.length()     // Catch:{ Exception -> 0x0179 }
                if (r0 <= 0) goto L_0x0179
                io.branch.indexing.a r0 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                android.os.Handler r0 = r0.f46381a     // Catch:{ Exception -> 0x0179 }
                io.branch.indexing.a r2 = io.branch.indexing.a.this     // Catch:{ Exception -> 0x0179 }
                java.lang.Runnable r2 = r2.j     // Catch:{ Exception -> 0x0179 }
                long r3 = (long) r1     // Catch:{ Exception -> 0x0179 }
                r0.postDelayed(r2, r3)     // Catch:{ Exception -> 0x0179 }
            L_0x0179:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.indexing.a.AnonymousClass1.run():void");
        }
    };
    public ViewTreeObserver.OnScrollChangedListener k = new ViewTreeObserver.OnScrollChangedListener() {
        public final void onScrollChanged() {
            a.this.f46381a.removeCallbacks(a.this.l);
            if (a.this.f46386f > a.this.f46385e) {
                a.this.f46381a.postDelayed(a.this.l, 1500);
            }
        }
    };
    Runnable l = new Runnable() {
        public final void run() {
            a.this.j.run();
        }
    };
    private final c n = new c();

    public static a a() {
        if (m == null) {
            m = new a();
        }
        return m;
    }

    private a() {
    }

    public final void a(Activity activity, String str) {
        this.f46387g = b.a((Context) activity);
        this.f46383c = str;
        b.a a2 = this.f46387g.a(activity);
        if (a2 != null) {
            JSONArray a3 = a2.a();
            if (!(a3 != null && a3.length() == 0)) {
                a(activity);
            }
        } else if (!TextUtils.isEmpty(this.f46383c)) {
            a(activity);
        }
    }

    private void a(Activity activity) {
        this.f46385e = 0;
        if (this.f46389i.size() < this.f46387g.f46397d) {
            this.f46381a.removeCallbacks(this.j);
            this.f46382b = new WeakReference<>(activity);
            this.f46381a.postDelayed(this.j, 1000);
        }
    }

    /* access modifiers changed from: private */
    public void a(ViewGroup viewGroup, JSONArray jSONArray, Resources resources) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                if ((childAt instanceof AbsListView) || childAt.getClass().getSimpleName().equals("RecyclerView")) {
                    ViewGroup viewGroup2 = (ViewGroup) childAt;
                    JSONObject jSONObject = new JSONObject();
                    if (viewGroup2 != null && viewGroup2.getChildCount() >= 0) {
                        int i3 = 1;
                        if (viewGroup2.getChildCount() <= 1) {
                            i3 = 0;
                        }
                        View childAt2 = viewGroup2.getChildAt(i3);
                        if (childAt2 != null) {
                            JSONArray jSONArray2 = new JSONArray();
                            try {
                                jSONObject.put(a((View) viewGroup2, resources), jSONArray2);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            if (childAt2 instanceof ViewGroup) {
                                a((ViewGroup) childAt2, jSONArray2, resources);
                            } else if (childAt2 instanceof TextView) {
                                jSONArray2.put(a(childAt2, resources));
                            }
                            if (jSONObject.length() > 0) {
                                jSONArray.put("$".concat(String.valueOf(jSONObject)));
                            }
                        }
                    }
                } else if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, jSONArray, resources);
                } else if (childAt instanceof TextView) {
                    jSONArray.put(a(childAt, resources));
                }
            }
        }
    }

    private static String a(View view, Resources resources) {
        try {
            return resources.getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return String.valueOf(view.getId());
        }
    }

    private String a(View view, boolean z) {
        TextView textView = (TextView) view;
        if (textView.getText() == null) {
            return null;
        }
        String substring = textView.getText().toString().substring(0, Math.min(textView.getText().toString().length(), this.f46387g.f46396c));
        if (z) {
            return substring;
        }
        c cVar = this.n;
        if (cVar.f46407a == null) {
            return "";
        }
        cVar.f46407a.reset();
        cVar.f46407a.update(substring.getBytes());
        return new String(cVar.f46407a.digest());
    }

    public final JSONObject a(Context context) {
        JSONObject jSONObject;
        q.a(context);
        JSONObject i2 = q.i();
        if (i2.length() <= 0 || i2.toString().length() >= this.f46387g.f46398e) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("mv", b.a(context).a()).put("e", i2);
                if (context != null) {
                    jSONObject.put("p", context.getPackageName());
                    jSONObject.put("p", context.getPackageName());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        q.a(context);
        q.f46563c = null;
        q.a("bnc_branch_analytical_data", "");
        return jSONObject;
    }

    static /* synthetic */ void a(a aVar, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, Activity activity, boolean z) {
        String str;
        JSONArray jSONArray4;
        Activity activity2;
        JSONArray jSONArray5;
        int i2;
        a aVar2 = aVar;
        JSONArray jSONArray6 = jSONArray;
        JSONArray jSONArray7 = jSONArray2;
        JSONArray jSONArray8 = jSONArray3;
        Activity activity3 = activity;
        boolean z2 = z;
        String str2 = "$";
        int i3 = 0;
        while (i3 < jSONArray.length()) {
            try {
                String string = jSONArray6.getString(i3);
                if (string.startsWith(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONArray8.put(string);
                    jSONArray7.put(jSONObject);
                    String replace = string.replace(str2, "");
                    try {
                        JSONObject jSONObject2 = new JSONObject(replace);
                        if (jSONObject2.length() > 0) {
                            String next = jSONObject2.keys().next();
                            int identifier = activity.getResources().getIdentifier(next, "id", activity.getPackageName());
                            View findViewById = activity.getCurrentFocus() != null ? activity.getCurrentFocus().findViewById(identifier) : null;
                            if (findViewById == null) {
                                findViewById = activity3.findViewById(identifier);
                            }
                            if (findViewById != null && (findViewById instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) findViewById;
                                JSONArray jSONArray9 = jSONObject2.getJSONArray(next);
                                int[] iArr = new int[jSONArray9.length()];
                                str = str2;
                                int i4 = 0;
                                while (i4 < jSONArray9.length()) {
                                    try {
                                        iArr[i4] = activity.getResources().getIdentifier(jSONArray9.getString(i4), "id", activity.getPackageName());
                                        i4++;
                                        JSONArray jSONArray10 = jSONArray2;
                                        Activity activity4 = activity;
                                    } catch (JSONException e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        jSONArray4 = jSONArray2;
                                        jSONArray5 = jSONArray3;
                                        activity2 = activity;
                                        i3++;
                                        str2 = str;
                                        Activity activity5 = activity2;
                                        jSONArray8 = jSONArray5;
                                        jSONArray7 = jSONArray4;
                                        activity3 = activity5;
                                    }
                                }
                                int firstVisiblePosition = viewGroup instanceof AbsListView ? ((AbsListView) viewGroup).getFirstVisiblePosition() : 0;
                                int i5 = 0;
                                while (i5 < viewGroup.getChildCount()) {
                                    if (viewGroup.getChildAt(i5) != null) {
                                        JSONObject jSONObject3 = new JSONObject();
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(i5 + firstVisiblePosition);
                                        jSONObject.put(sb.toString(), jSONObject3);
                                        int i6 = 0;
                                        while (i6 < iArr.length) {
                                            if (viewGroup.getChildAt(i5) != null) {
                                                i2 = firstVisiblePosition;
                                                View findViewById2 = viewGroup.getChildAt(i5).findViewById(iArr[i6]);
                                                if (findViewById2 instanceof TextView) {
                                                    jSONObject3.put(jSONArray9.getString(i6), aVar2.a(findViewById2, z2));
                                                }
                                            } else {
                                                i2 = firstVisiblePosition;
                                            }
                                            i6++;
                                            firstVisiblePosition = i2;
                                        }
                                    }
                                    i5++;
                                    firstVisiblePosition = firstVisiblePosition;
                                }
                                if ((jSONObject2.has("bnc_esw") && jSONObject2.getBoolean("bnc_esw")) && !aVar2.f46388h.containsKey(replace)) {
                                    viewGroup.getViewTreeObserver().addOnScrollChangedListener(aVar2.k);
                                    aVar2.f46388h.put(replace, new WeakReference(viewGroup.getViewTreeObserver()));
                                }
                                jSONArray4 = jSONArray2;
                                jSONArray5 = jSONArray3;
                                activity2 = activity;
                            }
                        }
                        str = str2;
                    } catch (JSONException e3) {
                        e = e3;
                        str = str2;
                        e.printStackTrace();
                        jSONArray4 = jSONArray2;
                        jSONArray5 = jSONArray3;
                        activity2 = activity;
                        i3++;
                        str2 = str;
                        Activity activity52 = activity2;
                        jSONArray8 = jSONArray5;
                        jSONArray7 = jSONArray4;
                        activity3 = activity52;
                    }
                    jSONArray4 = jSONArray2;
                    jSONArray5 = jSONArray3;
                    activity2 = activity;
                } else {
                    str = str2;
                    activity2 = activity;
                    View findViewById3 = activity2.findViewById(activity.getResources().getIdentifier(jSONArray6.getString(i3), "id", activity.getPackageName()));
                    if (findViewById3 instanceof TextView) {
                        jSONArray4 = jSONArray2;
                        jSONArray4.put(aVar2.a(findViewById3, z2));
                        jSONArray5 = jSONArray3;
                        jSONArray5.put(string);
                    } else {
                        jSONArray4 = jSONArray2;
                        jSONArray5 = jSONArray3;
                    }
                }
                i3++;
                str2 = str;
                Activity activity522 = activity2;
                jSONArray8 = jSONArray5;
                jSONArray7 = jSONArray4;
                activity3 = activity522;
            } catch (JSONException unused) {
                return;
            }
        }
    }
}
