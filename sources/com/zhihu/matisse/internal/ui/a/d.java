package com.zhihu.matisse.internal.ui.a;

import android.database.Cursor;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;

public abstract class d<VH extends RecyclerView.v> extends RecyclerView.a<VH> {

    /* renamed from: a  reason: collision with root package name */
    private Cursor f45827a;

    /* renamed from: b  reason: collision with root package name */
    private int f45828b;

    /* access modifiers changed from: protected */
    public abstract int a(Cursor cursor);

    /* access modifiers changed from: protected */
    public abstract void a(VH vh, Cursor cursor);

    d() {
        setHasStableIds(true);
        b((Cursor) null);
    }

    public void onBindViewHolder(VH vh, int i2) {
        if (!c(this.f45827a)) {
            throw new IllegalStateException("Cannot bind view holder when cursor is in invalid state.");
        } else if (this.f45827a.moveToPosition(i2)) {
            a(vh, this.f45827a);
        } else {
            throw new IllegalStateException("Could not move cursor to position " + i2 + " when trying to bind view holder");
        }
    }

    public int getItemViewType(int i2) {
        if (this.f45827a.moveToPosition(i2)) {
            return a(this.f45827a);
        }
        throw new IllegalStateException("Could not move cursor to position " + i2 + " when trying to get item view type.");
    }

    public int getItemCount() {
        if (c(this.f45827a)) {
            return this.f45827a.getCount();
        }
        return 0;
    }

    public long getItemId(int i2) {
        if (!c(this.f45827a)) {
            throw new IllegalStateException("Cannot lookup item id when cursor is in invalid state.");
        } else if (this.f45827a.moveToPosition(i2)) {
            return this.f45827a.getLong(this.f45828b);
        } else {
            throw new IllegalStateException("Could not move cursor to position " + i2 + " when trying to get an item id");
        }
    }

    public final void b(Cursor cursor) {
        if (cursor != this.f45827a) {
            if (cursor != null) {
                this.f45827a = cursor;
                this.f45828b = this.f45827a.getColumnIndexOrThrow("_id");
                notifyDataSetChanged();
                return;
            }
            notifyItemRangeRemoved(0, getItemCount());
            this.f45827a = null;
            this.f45828b = -1;
        }
    }

    private static boolean c(Cursor cursor) {
        return cursor != null && !cursor.isClosed();
    }
}
