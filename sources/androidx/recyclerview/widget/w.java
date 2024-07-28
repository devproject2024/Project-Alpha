package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.c;
import androidx.core.h.a.d;
import java.util.Map;
import java.util.WeakHashMap;

public class w extends androidx.core.h.a {

    /* renamed from: a  reason: collision with root package name */
    private final a f4360a;

    /* renamed from: d  reason: collision with root package name */
    final RecyclerView f4361d;

    public w(RecyclerView recyclerView) {
        this.f4361d = recyclerView;
        androidx.core.h.a a2 = a();
        if (a2 == null || !(a2 instanceof a)) {
            this.f4360a = new a(this);
        } else {
            this.f4360a = (a) a2;
        }
    }

    public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        if (super.performAccessibilityAction(view, i2, bundle)) {
            return true;
        }
        if (this.f4361d.hasPendingAdapterUpdates() || this.f4361d.getLayoutManager() == null) {
            return false;
        }
        return this.f4361d.getLayoutManager().performAccessibilityAction(i2, bundle);
    }

    public void onInitializeAccessibilityNodeInfo(View view, c cVar) {
        super.onInitializeAccessibilityNodeInfo(view, cVar);
        if (!this.f4361d.hasPendingAdapterUpdates() && this.f4361d.getLayoutManager() != null) {
            this.f4361d.getLayoutManager().onInitializeAccessibilityNodeInfo(cVar);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !this.f4361d.hasPendingAdapterUpdates()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public androidx.core.h.a a() {
        return this.f4360a;
    }

    public static class a extends androidx.core.h.a {

        /* renamed from: a  reason: collision with root package name */
        final w f4362a;

        /* renamed from: b  reason: collision with root package name */
        Map<View, androidx.core.h.a> f4363b = new WeakHashMap();

        public a(w wVar) {
            this.f4362a = wVar;
        }

        /* access modifiers changed from: package-private */
        public final androidx.core.h.a a(View view) {
            return this.f4363b.remove(view);
        }

        public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
            if (this.f4362a.f4361d.hasPendingAdapterUpdates() || this.f4362a.f4361d.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                return;
            }
            this.f4362a.f4361d.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, cVar);
            androidx.core.h.a aVar = this.f4363b.get(view);
            if (aVar != null) {
                aVar.onInitializeAccessibilityNodeInfo(view, cVar);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
            }
        }

        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (this.f4362a.f4361d.hasPendingAdapterUpdates() || this.f4362a.f4361d.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i2, bundle);
            }
            androidx.core.h.a aVar = this.f4363b.get(view);
            if (aVar != null) {
                if (aVar.performAccessibilityAction(view, i2, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            return this.f4362a.f4361d.getLayoutManager().performAccessibilityActionForItem(view, i2, bundle);
        }

        public final void sendAccessibilityEvent(View view, int i2) {
            androidx.core.h.a aVar = this.f4363b.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEvent(view, i2);
            } else {
                super.sendAccessibilityEvent(view, i2);
            }
        }

        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a aVar = this.f4363b.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a aVar = this.f4363b.get(view);
            if (aVar != null) {
                return aVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a aVar = this.f4363b.get(view);
            if (aVar != null) {
                aVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a aVar = this.f4363b.get(view);
            if (aVar != null) {
                aVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a aVar = this.f4363b.get(viewGroup);
            if (aVar != null) {
                return aVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public final d getAccessibilityNodeProvider(View view) {
            androidx.core.h.a aVar = this.f4363b.get(view);
            if (aVar != null) {
                return aVar.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }
    }
}
