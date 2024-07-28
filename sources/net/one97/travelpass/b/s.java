package net.one97.travelpass.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.travelpass.ui.a.b;

public abstract class s extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f30281a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f30282b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f30283c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f30284d;

    /* renamed from: e  reason: collision with root package name */
    protected b f30285e;

    public abstract void a(b bVar);

    protected s(Object obj, View view, ImageView imageView, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, 0);
        this.f30281a = imageView;
        this.f30282b = constraintLayout;
        this.f30283c = recyclerView;
        this.f30284d = textView;
    }
}
