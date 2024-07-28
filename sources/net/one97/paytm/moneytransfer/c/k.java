package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.moneytransfer.R;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f53771a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f53772b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f53773c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f53774d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f53775e;

    private k(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, ImageView imageView2, EditText editText) {
        this.f53775e = constraintLayout;
        this.f53771a = imageView;
        this.f53772b = recyclerView;
        this.f53773c = imageView2;
        this.f53774d = editText;
    }

    public static k a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.backArrow);
        if (imageView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.beneficiaryRecyclerView);
            if (recyclerView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.clearSearch);
                if (imageView2 != null) {
                    EditText editText = (EditText) view.findViewById(R.id.searchEditText);
                    if (editText != null) {
                        return new k((ConstraintLayout) view, imageView, recyclerView, imageView2, editText);
                    }
                    str = "searchEditText";
                } else {
                    str = "clearSearch";
                }
            } else {
                str = "beneficiaryRecyclerView";
            }
        } else {
            str = "backArrow";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
