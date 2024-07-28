package net.one97.travelpass.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.utility.RoboTextView;

public abstract class i extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f30245a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f30246b;

    /* renamed from: c  reason: collision with root package name */
    public final CollapsingToolbarLayout f30247c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f30248d;

    /* renamed from: e  reason: collision with root package name */
    public final ProgressBar f30249e;

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f30250f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f30251g;

    /* renamed from: h  reason: collision with root package name */
    public final Toolbar f30252h;

    protected i(Object obj, View view, AppBarLayout appBarLayout, ImageView imageView, CollapsingToolbarLayout collapsingToolbarLayout, RoboTextView roboTextView, ProgressBar progressBar, RecyclerView recyclerView, ImageView imageView2, Toolbar toolbar) {
        super(obj, view, 0);
        this.f30245a = appBarLayout;
        this.f30246b = imageView;
        this.f30247c = collapsingToolbarLayout;
        this.f30248d = roboTextView;
        this.f30249e = progressBar;
        this.f30250f = recyclerView;
        this.f30251g = imageView2;
        this.f30252h = toolbar;
    }
}
