package androidx.cursoradapter.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.cursoradapter.a.b;

public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: b  reason: collision with root package name */
    protected boolean f3208b = false;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f3209c = true;

    /* renamed from: d  reason: collision with root package name */
    protected Cursor f3210d = null;

    /* renamed from: e  reason: collision with root package name */
    protected Context f3211e;

    /* renamed from: f  reason: collision with root package name */
    protected int f3212f;

    /* renamed from: g  reason: collision with root package name */
    protected C0051a f3213g;

    /* renamed from: h  reason: collision with root package name */
    protected DataSetObserver f3214h;

    /* renamed from: i  reason: collision with root package name */
    protected b f3215i;
    protected FilterQueryProvider j;

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void a(View view, Cursor cursor);

    public boolean hasStableIds() {
        return true;
    }

    public a(Context context) {
        this.f3211e = context;
        this.f3212f = -1;
        this.f3213g = new C0051a();
        this.f3214h = new b();
    }

    public final Cursor a() {
        return this.f3210d;
    }

    public int getCount() {
        Cursor cursor;
        if (!this.f3208b || (cursor = this.f3210d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f3208b || (cursor = this.f3210d) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f3210d;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.f3208b || (cursor = this.f3210d) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.f3210d.getLong(this.f3212f);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f3208b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f3210d.moveToPosition(i2)) {
            if (view == null) {
                view = a(this.f3211e, this.f3210d, viewGroup);
            }
            a(view, this.f3210d);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(i2)));
        }
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f3208b) {
            return null;
        }
        this.f3210d.moveToPosition(i2);
        if (view == null) {
            view = b(this.f3211e, this.f3210d, viewGroup);
        }
        a(view, this.f3210d);
        return view;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public CharSequence b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor a(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.j;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.f3210d;
    }

    public Filter getFilter() {
        if (this.f3215i == null) {
            this.f3215i = new b(this);
        }
        return this.f3215i;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        Cursor cursor;
        if (this.f3209c && (cursor = this.f3210d) != null && !cursor.isClosed()) {
            this.f3208b = this.f3210d.requery();
        }
    }

    /* renamed from: androidx.cursoradapter.a.a$a  reason: collision with other inner class name */
    class C0051a extends ContentObserver {
        public final boolean deliverSelfNotifications() {
            return true;
        }

        C0051a() {
            super(new Handler());
        }

        public final void onChange(boolean z) {
            a.this.b();
        }
    }

    class b extends DataSetObserver {
        b() {
        }

        public final void onChanged() {
            a aVar = a.this;
            aVar.f3208b = true;
            aVar.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            a aVar = a.this;
            aVar.f3208b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public void a(Cursor cursor) {
        Cursor cursor2 = this.f3210d;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0051a aVar = this.f3213g;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.f3214h;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.f3210d = cursor;
            if (cursor != null) {
                C0051a aVar2 = this.f3213g;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.f3214h;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f3212f = cursor.getColumnIndexOrThrow("_id");
                this.f3208b = true;
                notifyDataSetChanged();
            } else {
                this.f3212f = -1;
                this.f3208b = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }
}
