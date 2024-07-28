package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.core.h.a;
import androidx.core.h.a.c;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w;

@Deprecated
public final class j extends w {

    /* renamed from: a  reason: collision with root package name */
    final RecyclerView f30896a;

    /* renamed from: b  reason: collision with root package name */
    final a f30897b = super.a();

    /* renamed from: c  reason: collision with root package name */
    final a f30898c = new a() {
        public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
            Preference a2;
            j.this.f30897b.onInitializeAccessibilityNodeInfo(view, cVar);
            int childAdapterPosition = j.this.f30896a.getChildAdapterPosition(view);
            RecyclerView.a adapter = j.this.f30896a.getAdapter();
            if ((adapter instanceof h) && (a2 = ((h) adapter).a(childAdapterPosition)) != null) {
                a2.a(cVar);
            }
        }

        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return j.this.f30897b.performAccessibilityAction(view, i2, bundle);
        }
    };

    public j(RecyclerView recyclerView) {
        super(recyclerView);
        this.f30896a = recyclerView;
    }

    public final a a() {
        return this.f30898c;
    }
}
