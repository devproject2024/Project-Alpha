package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.b;
import androidx.cursoradapter.a.c;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

final class x extends c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    int f1822a = 1;
    private final SearchView k;
    private final SearchableInfo l;
    private final Context m;
    private final WeakHashMap<String, Drawable.ConstantState> n;
    private final int o;
    private boolean p = false;
    private ColorStateList q;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;

    public final boolean hasStableIds() {
        return false;
    }

    public x(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.k = searchView;
        this.l = searchableInfo;
        this.o = searchView.getSuggestionCommitIconResId();
        this.m = context;
        this.n = weakHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079 A[Catch:{ RuntimeException -> 0x007d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.database.Cursor a(java.lang.CharSequence r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            if (r11 != 0) goto L_0x0006
            r11 = r0
            goto L_0x000a
        L_0x0006:
            java.lang.String r11 = r11.toString()
        L_0x000a:
            androidx.appcompat.widget.SearchView r1 = r10.k
            int r1 = r1.getVisibility()
            r2 = 0
            if (r1 != 0) goto L_0x007d
            androidx.appcompat.widget.SearchView r1 = r10.k
            int r1 = r1.getWindowVisibility()
            if (r1 == 0) goto L_0x001c
            goto L_0x007d
        L_0x001c:
            android.app.SearchableInfo r1 = r10.l     // Catch:{ RuntimeException -> 0x007d }
            if (r1 != 0) goto L_0x0022
        L_0x0020:
            r11 = r2
            goto L_0x0077
        L_0x0022:
            java.lang.String r3 = r1.getSuggestAuthority()     // Catch:{ RuntimeException -> 0x007d }
            if (r3 != 0) goto L_0x0029
            goto L_0x0020
        L_0x0029:
            android.net.Uri$Builder r4 = new android.net.Uri$Builder     // Catch:{ RuntimeException -> 0x007d }
            r4.<init>()     // Catch:{ RuntimeException -> 0x007d }
            java.lang.String r5 = "content"
            android.net.Uri$Builder r4 = r4.scheme(r5)     // Catch:{ RuntimeException -> 0x007d }
            android.net.Uri$Builder r3 = r4.authority(r3)     // Catch:{ RuntimeException -> 0x007d }
            android.net.Uri$Builder r3 = r3.query(r0)     // Catch:{ RuntimeException -> 0x007d }
            android.net.Uri$Builder r0 = r3.fragment(r0)     // Catch:{ RuntimeException -> 0x007d }
            java.lang.String r3 = r1.getSuggestPath()     // Catch:{ RuntimeException -> 0x007d }
            if (r3 == 0) goto L_0x0049
            r0.appendEncodedPath(r3)     // Catch:{ RuntimeException -> 0x007d }
        L_0x0049:
            java.lang.String r3 = "search_suggest_query"
            r0.appendPath(r3)     // Catch:{ RuntimeException -> 0x007d }
            java.lang.String r7 = r1.getSuggestSelection()     // Catch:{ RuntimeException -> 0x007d }
            if (r7 == 0) goto L_0x005c
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ RuntimeException -> 0x007d }
            r3 = 0
            r1[r3] = r11     // Catch:{ RuntimeException -> 0x007d }
            r8 = r1
            goto L_0x0060
        L_0x005c:
            r0.appendPath(r11)     // Catch:{ RuntimeException -> 0x007d }
            r8 = r2
        L_0x0060:
            java.lang.String r11 = "limit"
            java.lang.String r1 = "50"
            r0.appendQueryParameter(r11, r1)     // Catch:{ RuntimeException -> 0x007d }
            android.net.Uri r5 = r0.build()     // Catch:{ RuntimeException -> 0x007d }
            android.content.Context r11 = r10.f3211e     // Catch:{ RuntimeException -> 0x007d }
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch:{ RuntimeException -> 0x007d }
            r6 = 0
            r9 = 0
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ RuntimeException -> 0x007d }
        L_0x0077:
            if (r11 == 0) goto L_0x007d
            r11.getCount()     // Catch:{ RuntimeException -> 0x007d }
            return r11
        L_0x007d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x.a(java.lang.CharSequence):android.database.Cursor");
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        c(a());
    }

    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        c(a());
    }

    private static void c(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    public final void a(Cursor cursor) {
        if (!this.p) {
            try {
                super.a(cursor);
                if (cursor != null) {
                    this.r = cursor.getColumnIndex("suggest_text_1");
                    this.s = cursor.getColumnIndex("suggest_text_2");
                    this.t = cursor.getColumnIndex("suggest_text_2_url");
                    this.u = cursor.getColumnIndex("suggest_icon_1");
                    this.v = cursor.getColumnIndex("suggest_icon_2");
                    this.w = cursor.getColumnIndex("suggest_flags");
                }
            } catch (Exception unused) {
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public final View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a2 = super.a(context, cursor, viewGroup);
        a2.setTag(new a(a2));
        ((ImageView) a2.findViewById(R.id.edit_query)).setImageResource(this.o);
        return a2;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1823a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1824b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1825c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1826d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1827e;

        public a(View view) {
            this.f1823a = (TextView) view.findViewById(16908308);
            this.f1824b = (TextView) view.findViewById(16908309);
            this.f1825c = (ImageView) view.findViewById(16908295);
            this.f1826d = (ImageView) view.findViewById(16908296);
            this.f1827e = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: android.text.SpannableString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r18, android.database.Cursor r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            java.lang.Object r2 = r18.getTag()
            androidx.appcompat.widget.x$a r2 = (androidx.appcompat.widget.x.a) r2
            int r3 = r0.w
            r4 = -1
            r5 = 0
            if (r3 == r4) goto L_0x0015
            int r3 = r1.getInt(r3)
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.widget.TextView r6 = r2.f1823a
            if (r6 == 0) goto L_0x0025
            int r6 = r0.r
            java.lang.String r6 = a((android.database.Cursor) r1, (int) r6)
            android.widget.TextView r7 = r2.f1823a
            a((android.widget.TextView) r7, (java.lang.CharSequence) r6)
        L_0x0025:
            android.widget.TextView r6 = r2.f1824b
            r7 = 2
            r8 = 1
            if (r6 == 0) goto L_0x00a2
            int r6 = r0.t
            java.lang.String r6 = a((android.database.Cursor) r1, (int) r6)
            if (r6 == 0) goto L_0x0074
            android.content.res.ColorStateList r9 = r0.q
            if (r9 != 0) goto L_0x0055
            android.util.TypedValue r9 = new android.util.TypedValue
            r9.<init>()
            android.content.Context r10 = r0.f3211e
            android.content.res.Resources$Theme r10 = r10.getTheme()
            int r11 = androidx.appcompat.R.attr.textColorSearchUrl
            r10.resolveAttribute(r11, r9, r8)
            android.content.Context r10 = r0.f3211e
            android.content.res.Resources r10 = r10.getResources()
            int r9 = r9.resourceId
            android.content.res.ColorStateList r9 = r10.getColorStateList(r9)
            r0.q = r9
        L_0x0055:
            android.text.SpannableString r9 = new android.text.SpannableString
            r9.<init>(r6)
            android.text.style.TextAppearanceSpan r15 = new android.text.style.TextAppearanceSpan
            r11 = 0
            r12 = 0
            r13 = 0
            android.content.res.ColorStateList r14 = r0.q
            r16 = 0
            r10 = r15
            r4 = r15
            r15 = r16
            r10.<init>(r11, r12, r13, r14, r15)
            int r6 = r6.length()
            r10 = 33
            r9.setSpan(r4, r5, r6, r10)
            goto L_0x007a
        L_0x0074:
            int r4 = r0.s
            java.lang.String r9 = a((android.database.Cursor) r1, (int) r4)
        L_0x007a:
            boolean r4 = android.text.TextUtils.isEmpty(r9)
            if (r4 == 0) goto L_0x008f
            android.widget.TextView r4 = r2.f1823a
            if (r4 == 0) goto L_0x009d
            android.widget.TextView r4 = r2.f1823a
            r4.setSingleLine(r5)
            android.widget.TextView r4 = r2.f1823a
            r4.setMaxLines(r7)
            goto L_0x009d
        L_0x008f:
            android.widget.TextView r4 = r2.f1823a
            if (r4 == 0) goto L_0x009d
            android.widget.TextView r4 = r2.f1823a
            r4.setSingleLine(r8)
            android.widget.TextView r4 = r2.f1823a
            r4.setMaxLines(r8)
        L_0x009d:
            android.widget.TextView r4 = r2.f1824b
            a((android.widget.TextView) r4, (java.lang.CharSequence) r9)
        L_0x00a2:
            android.widget.ImageView r4 = r2.f1825c
            r6 = 0
            if (r4 == 0) goto L_0x0106
            android.widget.ImageView r4 = r2.f1825c
            int r9 = r0.u
            r10 = -1
            if (r9 != r10) goto L_0x00b0
            r9 = r6
            goto L_0x0102
        L_0x00b0:
            java.lang.String r9 = r1.getString(r9)
            android.graphics.drawable.Drawable r9 = r0.a((java.lang.String) r9)
            if (r9 == 0) goto L_0x00bb
            goto L_0x0102
        L_0x00bb:
            android.app.SearchableInfo r9 = r0.l
            android.content.ComponentName r9 = r9.getSearchActivity()
            java.lang.String r10 = r9.flattenToShortString()
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r11 = r0.n
            boolean r11 = r11.containsKey(r10)
            if (r11 == 0) goto L_0x00e4
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r9 = r0.n
            java.lang.Object r9 = r9.get(r10)
            android.graphics.drawable.Drawable$ConstantState r9 = (android.graphics.drawable.Drawable.ConstantState) r9
            if (r9 != 0) goto L_0x00d9
            r9 = r6
            goto L_0x00f5
        L_0x00d9:
            android.content.Context r10 = r0.m
            android.content.res.Resources r10 = r10.getResources()
            android.graphics.drawable.Drawable r9 = r9.newDrawable(r10)
            goto L_0x00f5
        L_0x00e4:
            android.graphics.drawable.Drawable r9 = r0.a((android.content.ComponentName) r9)
            if (r9 != 0) goto L_0x00ec
            r11 = r6
            goto L_0x00f0
        L_0x00ec:
            android.graphics.drawable.Drawable$ConstantState r11 = r9.getConstantState()
        L_0x00f0:
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r12 = r0.n
            r12.put(r10, r11)
        L_0x00f5:
            if (r9 == 0) goto L_0x00f8
            goto L_0x0102
        L_0x00f8:
            android.content.Context r9 = r0.f3211e
            android.content.pm.PackageManager r9 = r9.getPackageManager()
            android.graphics.drawable.Drawable r9 = r9.getDefaultActivityIcon()
        L_0x0102:
            r10 = 4
            a((android.widget.ImageView) r4, (android.graphics.drawable.Drawable) r9, (int) r10)
        L_0x0106:
            android.widget.ImageView r4 = r2.f1826d
            r9 = 8
            if (r4 == 0) goto L_0x011f
            android.widget.ImageView r4 = r2.f1826d
            int r10 = r0.v
            r11 = -1
            if (r10 != r11) goto L_0x0114
            goto L_0x011c
        L_0x0114:
            java.lang.String r1 = r1.getString(r10)
            android.graphics.drawable.Drawable r6 = r0.a((java.lang.String) r1)
        L_0x011c:
            a((android.widget.ImageView) r4, (android.graphics.drawable.Drawable) r6, (int) r9)
        L_0x011f:
            int r1 = r0.f1822a
            if (r1 == r7) goto L_0x0130
            if (r1 != r8) goto L_0x012a
            r1 = r3 & 1
            if (r1 == 0) goto L_0x012a
            goto L_0x0130
        L_0x012a:
            android.widget.ImageView r1 = r2.f1827e
            r1.setVisibility(r9)
            return
        L_0x0130:
            android.widget.ImageView r1 = r2.f1827e
            r1.setVisibility(r5)
            android.widget.ImageView r1 = r2.f1827e
            android.widget.TextView r3 = r2.f1823a
            java.lang.CharSequence r3 = r3.getText()
            r1.setTag(r3)
            android.widget.ImageView r1 = r2.f1827e
            r1.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x.a(android.view.View, android.database.Cursor):void");
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.k.setQuery((CharSequence) tag);
        }
    }

    private static void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private static void a(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final CharSequence b(Cursor cursor) {
        String a2;
        String a3;
        if (cursor == null) {
            return null;
        }
        String a4 = a(cursor, "suggest_intent_query");
        if (a4 != null) {
            return a4;
        }
        if (this.l.shouldRewriteQueryFromData() && (a3 = a(cursor, "suggest_intent_data")) != null) {
            return a3;
        }
        if (!this.l.shouldRewriteQueryFromText() || (a2 = a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return a2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            View a2 = a(this.f3211e, this.f3210d, viewGroup);
            if (a2 != null) {
                ((a) a2.getTag()).f1823a.setText(e2.toString());
            }
            return a2;
        }
    }

    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            View b2 = b(this.f3211e, this.f3210d, viewGroup);
            if (b2 != null) {
                ((a) b2.getTag()).f1823a.setText(e2.toString());
            }
            return b2;
        }
    }

    private Drawable a(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.m.getPackageName() + "/" + parseInt;
            Drawable b2 = b(str2);
            if (b2 != null) {
                return b2;
            }
            Drawable a2 = b.a(this.m, parseInt);
            a(str2, a2);
            return a2;
        } catch (NumberFormatException unused) {
            Drawable b3 = b(str);
            if (b3 != null) {
                return b3;
            }
            Drawable a3 = a(Uri.parse(str));
            a(str, a3);
            return a3;
        } catch (Resources.NotFoundException unused2) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:19|20|21|22|23|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|14|15|16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: ".concat(java.lang.String.valueOf(r5)));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0046 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0014 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0046=Splitter:B:22:0x0046, B:16:0x0038=Splitter:B:16:0x0038, B:4:0x000f=Splitter:B:4:0x000f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(android.net.Uri r5) {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing icon stream for "
            r1 = 0
            java.lang.String r2 = r5.getScheme()     // Catch:{ FileNotFoundException -> 0x005f }
            java.lang.String r3 = "android.resource"
            boolean r2 = r3.equals(r2)     // Catch:{ FileNotFoundException -> 0x005f }
            if (r2 == 0) goto L_0x0024
            android.graphics.drawable.Drawable r5 = r4.b((android.net.Uri) r5)     // Catch:{ NotFoundException -> 0x0014 }
            return r5
        L_0x0014:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x005f }
            java.lang.String r2 = "Resource does not exist: "
            java.lang.String r3 = java.lang.String.valueOf(r5)     // Catch:{ FileNotFoundException -> 0x005f }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ FileNotFoundException -> 0x005f }
            r0.<init>(r2)     // Catch:{ FileNotFoundException -> 0x005f }
            throw r0     // Catch:{ FileNotFoundException -> 0x005f }
        L_0x0024:
            android.content.Context r2 = r4.m     // Catch:{ FileNotFoundException -> 0x005f }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ FileNotFoundException -> 0x005f }
            java.io.InputStream r2 = r2.openInputStream(r5)     // Catch:{ FileNotFoundException -> 0x005f }
            if (r2 == 0) goto L_0x004f
            android.graphics.drawable.Drawable r3 = android.graphics.drawable.Drawable.createFromStream(r2, r1)     // Catch:{ all -> 0x0041 }
            r2.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x0040
        L_0x0038:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x005f }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x005f }
            r2.append(r5)     // Catch:{ FileNotFoundException -> 0x005f }
        L_0x0040:
            return r3
        L_0x0041:
            r3 = move-exception
            r2.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004e
        L_0x0046:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x005f }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x005f }
            r2.append(r5)     // Catch:{ FileNotFoundException -> 0x005f }
        L_0x004e:
            throw r3     // Catch:{ FileNotFoundException -> 0x005f }
        L_0x004f:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x005f }
            java.lang.String r2 = "Failed to open "
            java.lang.String r3 = java.lang.String.valueOf(r5)     // Catch:{ FileNotFoundException -> 0x005f }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ FileNotFoundException -> 0x005f }
            r0.<init>(r2)     // Catch:{ FileNotFoundException -> 0x005f }
            throw r0     // Catch:{ FileNotFoundException -> 0x005f }
        L_0x005f:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Icon not found: "
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r5 = ", "
            r2.append(r5)
            java.lang.String r5 = r0.getMessage()
            r2.append(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x.a(android.net.Uri):android.graphics.drawable.Drawable");
    }

    private Drawable b(String str) {
        Drawable.ConstantState constantState = this.n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.n.put(str, drawable.getConstantState());
        }
    }

    private Drawable a(ComponentName componentName) {
        PackageManager packageManager = this.f3211e.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder sb = new StringBuilder("Invalid icon resource ");
            sb.append(iconResource);
            sb.append(" for ");
            sb.append(componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static String a(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception unused) {
            return null;
        }
    }

    private Drawable b(Uri uri) throws FileNotFoundException {
        int i2;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f3211e.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i2 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: ".concat(String.valueOf(uri)));
                        }
                    } else if (size == 2) {
                        i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: ".concat(String.valueOf(uri)));
                    }
                    if (i2 != 0) {
                        return resourcesForApplication.getDrawable(i2);
                    }
                    throw new FileNotFoundException("No resource found for: ".concat(String.valueOf(uri)));
                }
                throw new FileNotFoundException("No path: ".concat(String.valueOf(uri)));
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: ".concat(String.valueOf(uri)));
            }
        } else {
            throw new FileNotFoundException("No authority: ".concat(String.valueOf(uri)));
        }
    }
}
