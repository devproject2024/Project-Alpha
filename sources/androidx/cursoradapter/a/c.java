package androidx.cursoradapter.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f3219a;
    private int k;
    private LayoutInflater l;

    @Deprecated
    public c(Context context, int i2) {
        super(context);
        this.k = i2;
        this.f3219a = i2;
        this.l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.f3219a, viewGroup, false);
    }

    public final View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.k, viewGroup, false);
    }
}
