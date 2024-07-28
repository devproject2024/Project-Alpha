package com.zhihu.matisse.internal.ui.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.FastClickUtil;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.c;
import com.zhihu.matisse.internal.ui.widget.MediaGrid;

public final class a extends d<RecyclerView.v> implements MediaGrid.a {

    /* renamed from: a  reason: collision with root package name */
    public b f45814a;

    /* renamed from: b  reason: collision with root package name */
    public d f45815b;

    /* renamed from: c  reason: collision with root package name */
    private final com.zhihu.matisse.internal.b.c f45816c;

    /* renamed from: d  reason: collision with root package name */
    private final Drawable f45817d;

    /* renamed from: e  reason: collision with root package name */
    private com.zhihu.matisse.internal.entity.c f45818e = c.a.f45787a;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f45819f;

    /* renamed from: g  reason: collision with root package name */
    private int f45820g;

    public interface b {
        void b();
    }

    public interface d {
        void a(Item item, int i2);
    }

    public interface e {
        void d();
    }

    public a(Context context, com.zhihu.matisse.internal.b.c cVar, RecyclerView recyclerView) {
        this.f45816c = cVar;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.item_placeholder});
        this.f45817d = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        this.f45819f = recyclerView;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            C0765a aVar = new C0765a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_photo_capture_item, viewGroup, false));
            aVar.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (FastClickUtil.isFastClick() && (view.getContext() instanceof e)) {
                        ((e) view.getContext()).d();
                    }
                }
            });
            return aVar;
        } else if (i2 == 2) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_media_grid_item, viewGroup, false));
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(RecyclerView.v vVar, Cursor cursor) {
        Drawable.ConstantState constantState;
        if (vVar instanceof C0765a) {
            C0765a aVar = (C0765a) vVar;
            Drawable[] compoundDrawables = aVar.f45822a.getCompoundDrawables();
            TypedArray obtainStyledAttributes = vVar.itemView.getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.capture_textColor});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            for (int i2 = 0; i2 < compoundDrawables.length; i2++) {
                Drawable drawable = compoundDrawables[i2];
                if (!(drawable == null || (constantState = drawable.getConstantState()) == null)) {
                    Drawable mutate = constantState.newDrawable().mutate();
                    mutate.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                    mutate.setBounds(drawable.getBounds());
                    compoundDrawables[i2] = mutate;
                }
            }
            aVar.f45822a.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        } else if (vVar instanceof c) {
            c cVar = (c) vVar;
            Item a2 = Item.a(cursor);
            MediaGrid mediaGrid = cVar.f45823a;
            Context context = cVar.f45823a.getContext();
            if (this.f45820g == 0) {
                int spanCount = ((GridLayoutManager) this.f45819f.getLayoutManager()).getSpanCount();
                this.f45820g = (context.getResources().getDisplayMetrics().widthPixels - (context.getResources().getDimensionPixelSize(R.dimen.media_grid_spacing) * (spanCount - 1))) / spanCount;
                this.f45820g = (int) (((float) this.f45820g) * this.f45818e.o);
            }
            mediaGrid.f45871g = new MediaGrid.b(this.f45820g, this.f45817d, this.f45818e.f45783f, vVar);
            MediaGrid mediaGrid2 = cVar.f45823a;
            mediaGrid2.f45870f = a2;
            mediaGrid2.f45867c.setVisibility(com.zhihu.matisse.b.isGif(mediaGrid2.f45870f.f45764b) ? 0 : 8);
            mediaGrid2.f45866b.setCountable(mediaGrid2.f45871g.f45876c);
            if (com.zhihu.matisse.b.isGif(mediaGrid2.f45870f.f45764b)) {
                c.a.f45787a.p.b(mediaGrid2.getContext(), mediaGrid2.f45871g.f45874a, mediaGrid2.f45871g.f45875b, mediaGrid2.f45865a, mediaGrid2.f45870f.f45765c);
            } else {
                c.a.f45787a.p.a(mediaGrid2.getContext(), mediaGrid2.f45871g.f45874a, mediaGrid2.f45871g.f45875b, mediaGrid2.f45865a, mediaGrid2.f45870f.f45765c);
            }
            if (com.zhihu.matisse.b.isVideo(mediaGrid2.f45870f.f45764b)) {
                mediaGrid2.f45869e.setVisibility(0);
                mediaGrid2.f45868d.setVisibility(0);
                mediaGrid2.f45868d.setText(DateUtils.formatElapsedTime(mediaGrid2.f45870f.f45767e / 1000));
            } else {
                mediaGrid2.f45868d.setVisibility(8);
                mediaGrid2.f45869e.setVisibility(8);
            }
            cVar.f45823a.setOnMediaGridClickListener(this);
            MediaGrid mediaGrid3 = cVar.f45823a;
            if (this.f45818e.f45783f) {
                int e2 = this.f45816c.e(a2);
                if (e2 > 0 || !this.f45816c.e()) {
                    mediaGrid3.setCheckEnabled(true);
                    mediaGrid3.setCheckedNum(e2);
                    return;
                }
                mediaGrid3.setCheckEnabled(false);
                mediaGrid3.setCheckedNum(Integer.MIN_VALUE);
            } else if (this.f45816c.c(a2)) {
                mediaGrid3.setCheckEnabled(true);
                mediaGrid3.setChecked(true);
            } else if (this.f45816c.e()) {
                mediaGrid3.setCheckEnabled(false);
                mediaGrid3.setChecked(false);
            } else {
                mediaGrid3.setCheckEnabled(true);
                mediaGrid3.setChecked(false);
            }
        }
    }

    public final void a(Item item, RecyclerView.v vVar) {
        d dVar;
        if (this.f45818e.w) {
            int f2 = this.f45816c.f();
            c(item, vVar);
            if (f2 <= 0 && (dVar = this.f45815b) != null) {
                dVar.a(item, vVar.getAdapterPosition());
                return;
            }
            return;
        }
        c(item, vVar);
    }

    public final void b(Item item, RecyclerView.v vVar) {
        c(item, vVar);
        this.f45816c.f();
    }

    private void c(Item item, RecyclerView.v vVar) {
        if (this.f45818e.f45783f) {
            if (this.f45816c.e(item) != Integer.MIN_VALUE) {
                this.f45816c.b(item);
                a();
            } else if (a(vVar.itemView.getContext(), item)) {
                this.f45816c.a(item);
                a();
            }
        } else if (this.f45816c.c(item)) {
            this.f45816c.b(item);
            a();
        } else if (a(vVar.itemView.getContext(), item)) {
            this.f45816c.a(item);
            a();
        }
    }

    private void a() {
        notifyDataSetChanged();
        b bVar = this.f45814a;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final int a(Cursor cursor) {
        return (Item.a(cursor).f45763a > -1 ? 1 : (Item.a(cursor).f45763a == -1 ? 0 : -1)) == 0 ? 1 : 2;
    }

    private boolean a(Context context, Item item) {
        com.zhihu.matisse.internal.entity.b d2 = this.f45816c.d(item);
        com.zhihu.matisse.internal.entity.b.a(context, d2);
        return d2 == null;
    }

    static class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        MediaGrid f45823a;

        c(View view) {
            super(view);
            this.f45823a = (MediaGrid) view;
        }
    }

    /* renamed from: com.zhihu.matisse.internal.ui.a.a$a  reason: collision with other inner class name */
    static class C0765a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f45822a;

        C0765a(View view) {
            super(view);
            this.f45822a = (TextView) view.findViewById(R.id.hint);
        }
    }
}
