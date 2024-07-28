package androidx.loader.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.a;
import androidx.core.d.j;
import androidx.loader.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class b extends a<Cursor> {

    /* renamed from: a  reason: collision with root package name */
    final c<Cursor>.a f3710a = new c.a();

    /* renamed from: b  reason: collision with root package name */
    Uri f3711b;

    /* renamed from: c  reason: collision with root package name */
    String[] f3712c;

    /* renamed from: d  reason: collision with root package name */
    String f3713d;

    /* renamed from: e  reason: collision with root package name */
    String[] f3714e;

    /* renamed from: f  reason: collision with root package name */
    String f3715f;

    /* renamed from: g  reason: collision with root package name */
    Cursor f3716g;

    /* renamed from: h  reason: collision with root package name */
    androidx.core.d.b f3717h;

    public /* synthetic */ void onCanceled(Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    /* renamed from: a */
    public Cursor loadInBackground() {
        Cursor a2;
        synchronized (this) {
            if (!isLoadInBackgroundCanceled()) {
                this.f3717h = new androidx.core.d.b();
            } else {
                throw new j();
            }
        }
        try {
            a2 = a.a(getContext().getContentResolver(), this.f3711b, this.f3712c, this.f3713d, this.f3714e, this.f3715f, this.f3717h);
            if (a2 != null) {
                a2.getCount();
                a2.registerContentObserver(this.f3710a);
            }
            synchronized (this) {
                this.f3717h = null;
            }
            return a2;
        } catch (RuntimeException e2) {
            a2.close();
            throw e2;
        } catch (Throwable th) {
            synchronized (this) {
                this.f3717h = null;
                throw th;
            }
        }
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            if (this.f3717h != null) {
                this.f3717h.b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void deliverResult(Cursor cursor) {
        if (!isReset()) {
            Cursor cursor2 = this.f3716g;
            this.f3716g = cursor;
            if (isStarted()) {
                super.deliverResult(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public b(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f3711b = uri;
        this.f3712c = strArr;
        this.f3713d = str;
        this.f3714e = strArr2;
        this.f3715f = str2;
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
        Cursor cursor = this.f3716g;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.f3716g == null) {
            forceLoad();
        }
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
        cancelLoad();
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor = this.f3716g;
        if (cursor != null && !cursor.isClosed()) {
            this.f3716g.close();
        }
        this.f3716g = null;
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f3711b);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f3712c));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f3713d);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f3714e));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f3715f);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f3716g);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }
}
