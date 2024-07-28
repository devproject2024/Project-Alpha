package androidx.preference;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class k extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    boolean f30900a;

    /* renamed from: b  reason: collision with root package name */
    boolean f30901b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<View> f30902c = new SparseArray<>(4);

    k(View view) {
        super(view);
        this.f30902c.put(16908310, view.findViewById(16908310));
        this.f30902c.put(16908304, view.findViewById(16908304));
        this.f30902c.put(16908294, view.findViewById(16908294));
        this.f30902c.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        this.f30902c.put(16908350, view.findViewById(16908350));
    }

    public final View a(int i2) {
        View view = this.f30902c.get(i2);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i2);
        if (findViewById != null) {
            this.f30902c.put(i2, findViewById);
        }
        return findViewById;
    }
}
