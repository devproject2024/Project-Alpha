package androidx.loader.b;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class c<D> {
    boolean mAbandoned = false;
    boolean mContentChanged = false;
    Context mContext;
    int mId;
    C0059c<D> mListener;
    b<D> mOnLoadCanceledListener;
    boolean mProcessingChange = false;
    boolean mReset = true;
    boolean mStarted = false;

    public interface b<D> {
    }

    /* renamed from: androidx.loader.b.c$c  reason: collision with other inner class name */
    public interface C0059c<D> {
        void a(D d2);
    }

    public void deliverCancellation() {
    }

    /* access modifiers changed from: protected */
    public void onAbandon() {
    }

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
    }

    public final class a extends ContentObserver {
        public final boolean deliverSelfNotifications() {
            return true;
        }

        public a() {
            super(new Handler());
        }

        public final void onChange(boolean z) {
            c.this.onContentChanged();
        }
    }

    public c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void deliverResult(D d2) {
        C0059c<D> cVar = this.mListener;
        if (cVar != null) {
            cVar.a(d2);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public void registerListener(int i2, C0059c<D> cVar) {
        if (this.mListener == null) {
            this.mListener = cVar;
            this.mId = i2;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void unregisterListener(C0059c<D> cVar) {
        C0059c<D> cVar2 = this.mListener;
        if (cVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (cVar2 == cVar) {
            this.mListener = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public void registerOnLoadCanceledListener(b<D> bVar) {
        if (this.mOnLoadCanceledListener == null) {
            this.mOnLoadCanceledListener = bVar;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void unregisterOnLoadCanceledListener(b<D> bVar) {
        b<D> bVar2 = this.mOnLoadCanceledListener;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (bVar2 == bVar) {
            this.mOnLoadCanceledListener = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void forceLoad() {
        onForceLoad();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    public String dataToString(D d2) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.g.a.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.g.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }
}
