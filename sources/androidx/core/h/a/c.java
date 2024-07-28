package androidx.core.h.a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R;
import androidx.core.h.a.f;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class c {

    /* renamed from: d  reason: collision with root package name */
    private static int f3040d;

    /* renamed from: a  reason: collision with root package name */
    public final AccessibilityNodeInfo f3041a;

    /* renamed from: b  reason: collision with root package name */
    public int f3042b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f3043c = -1;

    private static String b(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS /*256*/:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case TarConstants.EOF_BLOCK /*1024*/:
                return "ACTION_NEXT_HTML_ELEMENT";
            case EmiUtil.EMI_PLAN_REQUEST_CODE /*2048*/:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i2) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static class a {
        public static final a A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (f) null, (Class<? extends f.a>) null);
        public static final a B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (f) null, (Class<? extends f.a>) null);
        public static final a C = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, (f) null, (Class<? extends f.a>) null);
        public static final a D = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, (f) null, (Class<? extends f.a>) null);
        public static final a E = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, (f) null, (Class<? extends f.a>) null);
        public static final a F = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, (f) null, (Class<? extends f.a>) null);
        public static final a G;
        public static final a H;
        public static final a I = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (f) null, f.d.class);
        public static final a J = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (f) null, (Class<? extends f.a>) null);
        public static final a K = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, (f) null, (Class<? extends f.a>) null);

        /* renamed from: a  reason: collision with root package name */
        public static final a f3044a = new a(1);

        /* renamed from: b  reason: collision with root package name */
        public static final a f3045b = new a(2);

        /* renamed from: c  reason: collision with root package name */
        public static final a f3046c = new a(4);

        /* renamed from: d  reason: collision with root package name */
        public static final a f3047d = new a(8);

        /* renamed from: e  reason: collision with root package name */
        public static final a f3048e = new a(16);

        /* renamed from: f  reason: collision with root package name */
        public static final a f3049f = new a(32);

        /* renamed from: g  reason: collision with root package name */
        public static final a f3050g = new a(64);

        /* renamed from: h  reason: collision with root package name */
        public static final a f3051h = new a(128);

        /* renamed from: i  reason: collision with root package name */
        public static final a f3052i = new a(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, f.b.class);
        public static final a j = new a(512, f.b.class);
        public static final a k = new a(TarConstants.EOF_BLOCK, f.c.class);
        public static final a l = new a(EmiUtil.EMI_PLAN_REQUEST_CODE, f.c.class);
        public static final a m = new a(4096);
        public static final a n = new a((int) FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        public static final a o = new a(16384);
        public static final a p = new a(32768);
        public static final a q = new a(65536);
        public static final a r = new a(131072, f.g.class);
        public static final a s = new a(262144);
        public static final a t = new a(524288);
        public static final a u = new a(1048576);
        public static final a v = new a(2097152, f.h.class);
        public static final a w;
        public static final a x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (f) null, f.e.class);
        public static final a y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (f) null, (Class<? extends f.a>) null);
        public static final a z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (f) null, (Class<? extends f.a>) null);
        final Object L;
        public final int M;
        public final Class<? extends f.a> N;
        protected final f O;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
            } else {
                accessibilityAction = null;
            }
            w = new a(accessibilityAction, 16908342, (f) null, (Class<? extends f.a>) null);
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
            } else {
                accessibilityAction2 = null;
            }
            G = new a(accessibilityAction2, 16908348, (f) null, (Class<? extends f.a>) null);
            if (Build.VERSION.SDK_INT >= 24) {
                accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            } else {
                accessibilityAction3 = null;
            }
            H = new a(accessibilityAction3, 16908349, (f) null, f.C0047f.class);
        }

        public a(int i2) {
            this((Object) null, i2, (f) null, (Class<? extends f.a>) null);
        }

        a(Object obj) {
            this(obj, 0, (f) null, (Class<? extends f.a>) null);
        }

        private a(int i2, Class<? extends f.a> cls) {
            this((Object) null, i2, (f) null, cls);
        }

        public a(Object obj, int i2, f fVar, Class<? extends f.a> cls) {
            this.M = i2;
            this.O = fVar;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.L = obj;
            } else {
                this.L = new AccessibilityNodeInfo.AccessibilityAction(i2, (CharSequence) null);
            }
            this.N = cls;
        }

        public final int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getId();
            }
            return 0;
        }

        public final CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getLabel();
            }
            return null;
        }

        public final boolean a(View view, Bundle bundle) {
            if (this.O == null) {
                return false;
            }
            Class<? extends f.a> cls = this.N;
            if (cls != null) {
                try {
                    ((f.a) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).f3059a = bundle;
                } catch (Exception unused) {
                    Class<? extends f.a> cls2 = this.N;
                    if (cls2 != null) {
                        cls2.getName();
                    }
                }
            }
            return this.O.a(view);
        }

        public final int hashCode() {
            Object obj = this.L;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.L;
            if (obj2 == null) {
                if (aVar.L != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(aVar.L)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f3053a;

        public static b a(int i2, int i3, boolean z, int i4) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z, i4));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z));
            }
            return new b((Object) null);
        }

        public b(Object obj) {
            this.f3053a = obj;
        }
    }

    /* renamed from: androidx.core.h.a.c$c  reason: collision with other inner class name */
    public static class C0046c {

        /* renamed from: a  reason: collision with root package name */
        public final Object f3054a;

        public static C0046c a(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new C0046c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new C0046c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z));
            }
            return new C0046c((Object) null);
        }

        public C0046c(Object obj) {
            this.f3054a = obj;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final Object f3055a;

        public d(Object obj) {
            this.f3055a = obj;
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f3041a = accessibilityNodeInfo;
    }

    public static c a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static c a(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    public static c a() {
        return a(AccessibilityNodeInfo.obtain());
    }

    public static c a(c cVar) {
        return a(AccessibilityNodeInfo.obtain(cVar.f3041a));
    }

    public final void b(View view) {
        this.f3043c = -1;
        this.f3041a.setSource(view);
    }

    public final void a(View view, int i2) {
        this.f3043c = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3041a.setSource(view, i2);
        }
    }

    public final void c(View view) {
        this.f3041a.addChild(view);
    }

    public final void b(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3041a.addChild(view, i2);
        }
    }

    public final void a(int i2) {
        this.f3041a.addAction(i2);
    }

    public final List<Integer> a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f3041a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f3041a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3041a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
    }

    public final boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f3041a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
        return false;
    }

    public final void d(View view) {
        this.f3042b = -1;
        this.f3041a.setParent(view);
    }

    public final void e(View view) {
        this.f3042b = -1;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3041a.setParent(view, -1);
        }
    }

    @Deprecated
    public final void a(Rect rect) {
        this.f3041a.getBoundsInParent(rect);
    }

    @Deprecated
    public final void b(Rect rect) {
        this.f3041a.setBoundsInParent(rect);
    }

    public final void c(Rect rect) {
        this.f3041a.getBoundsInScreen(rect);
    }

    public final void d(Rect rect) {
        this.f3041a.setBoundsInScreen(rect);
    }

    public final void a(boolean z) {
        this.f3041a.setCheckable(z);
    }

    public final void b(boolean z) {
        this.f3041a.setFocusable(z);
    }

    public final void c(boolean z) {
        this.f3041a.setFocused(z);
    }

    public final boolean b() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f3041a.isVisibleToUser();
        }
        return false;
    }

    public final void d(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3041a.setVisibleToUser(z);
        }
    }

    public final boolean c() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f3041a.isAccessibilityFocused();
        }
        return false;
    }

    public final void e(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3041a.setAccessibilityFocused(z);
        }
    }

    public final void f(boolean z) {
        this.f3041a.setSelected(z);
    }

    public final void g(boolean z) {
        this.f3041a.setClickable(z);
    }

    public final void h(boolean z) {
        this.f3041a.setLongClickable(z);
    }

    public final void i(boolean z) {
        this.f3041a.setEnabled(z);
    }

    public final void j(boolean z) {
        this.f3041a.setScrollable(z);
    }

    public final void a(CharSequence charSequence) {
        this.f3041a.setPackageName(charSequence);
    }

    public final void b(CharSequence charSequence) {
        this.f3041a.setClassName(charSequence);
    }

    public final void c(CharSequence charSequence) {
        this.f3041a.setText(charSequence);
    }

    public static SparseArray<WeakReference<ClickableSpan>> f(View view) {
        return (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
    }

    public static ClickableSpan[] d(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i2).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = f3040d;
        f3040d = i3 + 1;
        return i3;
    }

    public final void e(CharSequence charSequence) {
        this.f3041a.setContentDescription(charSequence);
    }

    public final void a(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.f3041a;
            if (obj == null) {
                collectionInfo = null;
            } else {
                collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f3053a;
            }
            accessibilityNodeInfo.setCollectionInfo(collectionInfo);
        }
    }

    public final void b(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.f3041a;
            if (obj == null) {
                collectionItemInfo = null;
            } else {
                collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((C0046c) obj).f3054a;
            }
            accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
        }
    }

    private List<a> f() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f3041a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new a((Object) actionList.get(i2)));
        }
        return arrayList;
    }

    public final void f(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3041a.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f3041a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public final Bundle e() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f3041a.getExtras();
        }
        return new Bundle();
    }

    public final void k(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3041a.setDismissable(z);
        }
    }

    public final void g(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3041a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3041a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3041a;
        if (accessibilityNodeInfo == null) {
            if (cVar.f3041a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f3041a)) {
            return false;
        }
        return this.f3043c == cVar.f3043c && this.f3042b == cVar.f3042b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: ".concat(String.valueOf(rect)));
        c(rect);
        sb.append("; boundsInScreen: ".concat(String.valueOf(rect)));
        sb.append("; packageName: ");
        sb.append(this.f3041a.getPackageName());
        sb.append("; className: ");
        sb.append(this.f3041a.getClassName());
        sb.append("; text: ");
        sb.append(d());
        sb.append("; contentDescription: ");
        sb.append(this.f3041a.getContentDescription());
        sb.append("; viewId: ");
        sb.append(Build.VERSION.SDK_INT >= 18 ? this.f3041a.getViewIdResourceName() : null);
        sb.append("; checkable: ");
        sb.append(this.f3041a.isCheckable());
        sb.append("; checked: ");
        sb.append(this.f3041a.isChecked());
        sb.append("; focusable: ");
        sb.append(this.f3041a.isFocusable());
        sb.append("; focused: ");
        sb.append(this.f3041a.isFocused());
        sb.append("; selected: ");
        sb.append(this.f3041a.isSelected());
        sb.append("; clickable: ");
        sb.append(this.f3041a.isClickable());
        sb.append("; longClickable: ");
        sb.append(this.f3041a.isLongClickable());
        sb.append("; enabled: ");
        sb.append(this.f3041a.isEnabled());
        sb.append("; password: ");
        sb.append(this.f3041a.isPassword());
        sb.append("; scrollable: " + this.f3041a.isScrollable());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> f2 = f();
            for (int i2 = 0; i2 < f2.size(); i2++) {
                a aVar = f2.get(i2);
                String b2 = b(aVar.a());
                if (b2.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    b2 = aVar.b().toString();
                }
                sb.append(b2);
                if (i2 != f2.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int actions = this.f3041a.getActions();
            while (actions != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
                actions &= ~numberOfTrailingZeros;
                sb.append(b(numberOfTrailingZeros));
                if (actions != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final void a(int i2, boolean z) {
        Bundle e2 = e();
        if (e2 != null) {
            int i3 = e2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i2);
            if (!z) {
                i2 = 0;
            }
            e2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }

    public final CharSequence d() {
        if (!(!a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty())) {
            return this.f3041a.getText();
        }
        List<Integer> a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f3041a.getText(), 0, this.f3041a.getText().length()));
        for (int i2 = 0; i2 < a2.size(); i2++) {
            spannableString.setSpan(new a(a5.get(i2).intValue(), this, e().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a2.get(i2).intValue(), a3.get(i2).intValue(), a4.get(i2).intValue());
        }
        return spannableString;
    }
}
