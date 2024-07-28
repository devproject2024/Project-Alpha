package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.g;
import kotlin.g.b.k;

public abstract class BaseViewHolder<V> extends RecyclerView.v implements View.OnClickListener {
    public static final Companion Companion = new Companion((g) null);
    private final Context mContext;
    private View.OnClickListener mOnClickListener;
    private final View mView;

    public abstract void bindView(V v);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(Context context, View view) {
        super(view);
        k.c(context, "mContext");
        k.c(view, "itemView");
        this.mContext = context;
        this.mView = view;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final View getMView() {
        return this.mView;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final View getView(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…resLayout, parent, false)");
            return inflate;
        }
    }

    public final View.OnClickListener getMOnClickListener() {
        return this.mOnClickListener;
    }

    public final void setMOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        k.c(onClickListener, "listener");
        this.mOnClickListener = onClickListener;
    }

    public void onClick(View view) {
        k.c(view, "v");
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null && onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
