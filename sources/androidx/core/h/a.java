package androidx.core.h;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R;
import androidx.core.h.a.c;
import androidx.core.h.a.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    /* renamed from: androidx.core.h.a$a  reason: collision with other inner class name */
    static final class C0045a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final a f3036a;

        C0045a(a aVar) {
            this.f3036a = aVar;
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f3036a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f3036a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            View view2 = view;
            c a2 = c.a(accessibilityNodeInfo);
            boolean P = u.P(view);
            if (Build.VERSION.SDK_INT >= 28) {
                a2.f3041a.setScreenReaderFocusable(P);
            } else {
                a2.a(1, P);
            }
            boolean R = u.R(view);
            if (Build.VERSION.SDK_INT >= 28) {
                a2.f3041a.setHeading(R);
            } else {
                a2.a(2, R);
            }
            CharSequence Q = u.Q(view);
            if (Build.VERSION.SDK_INT >= 28) {
                a2.f3041a.setPaneTitle(Q);
            } else if (Build.VERSION.SDK_INT >= 19) {
                a2.f3041a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", Q);
            }
            this.f3036a.onInitializeAccessibilityNodeInfo(view2, a2);
            CharSequence text = accessibilityNodeInfo.getText();
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 26) {
                if (Build.VERSION.SDK_INT >= 19) {
                    a2.f3041a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                    a2.f3041a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                    a2.f3041a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                    a2.f3041a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                }
                SparseArray<WeakReference<ClickableSpan>> f2 = c.f(view);
                if (f2 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < f2.size(); i2++) {
                        if (f2.valueAt(i2).get() == null) {
                            arrayList.add(Integer.valueOf(i2));
                        }
                    }
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        f2.remove(((Integer) arrayList.get(i3)).intValue());
                    }
                }
                ClickableSpan[] d2 = c.d(text);
                if (d2 != null && d2.length > 0) {
                    a2.e().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                    SparseArray<WeakReference<ClickableSpan>> f3 = c.f(view);
                    if (f3 == null) {
                        f3 = new SparseArray<>();
                        view2.setTag(R.id.tag_accessibility_clickable_spans, f3);
                    }
                    int i4 = 0;
                    while (d2 != null && i4 < d2.length) {
                        int a3 = c.a(d2[i4], f3);
                        f3.put(a3, new WeakReference(d2[i4]));
                        ClickableSpan clickableSpan = d2[i4];
                        Spanned spanned = (Spanned) text;
                        a2.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
                        a2.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
                        a2.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
                        a2.a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(a3));
                        i4++;
                    }
                }
            }
            List<c.a> actionList = a.getActionList(view);
            for (int i5 = 0; i5 < actionList.size(); i5++) {
                a2.a(actionList.get(i5));
            }
        }

        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f3036a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f3036a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public final void sendAccessibilityEvent(View view, int i2) {
            this.f3036a.sendAccessibilityEvent(view, i2);
        }

        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f3036a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }

        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            d accessibilityNodeProvider = this.f3036a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.f3056a;
            }
            return null;
        }

        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f3036a.performAccessibilityAction(view, i2, bundle);
        }
    }

    public a() {
        this(DEFAULT_DELEGATE);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new C0045a(this);
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View view, int i2) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i2);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, c cVar) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, cVar.f3041a);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public d getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new d(accessibilityNodeProvider);
    }

    public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        List<c.a> actionList = getActionList(view);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= actionList.size()) {
                break;
            }
            c.a aVar = actionList.get(i3);
            if (aVar.a() == i2) {
                z = aVar.a(view, bundle);
                break;
            }
            i3++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.mOriginalDelegate.performAccessibilityAction(view, i2, bundle);
        }
        return (z || i2 != R.id.accessibility_action_clickable_span) ? z : performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean performClickableSpanAction(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!isSpanStillValid(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] d2 = c.d(view.createAccessibilityNodeInfo().getText());
            int i2 = 0;
            while (d2 != null && i2 < d2.length) {
                if (clickableSpan.equals(d2[i2])) {
                    return true;
                }
                i2++;
            }
        }
        return false;
    }

    static List<c.a> getActionList(View view) {
        List<c.a> list = (List) view.getTag(R.id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }
}
