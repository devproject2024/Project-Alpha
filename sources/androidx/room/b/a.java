package androidx.room.b;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Lock> f4382e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final File f4383a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f4384b = a(this.f4383a.getAbsolutePath());

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4385c;

    /* renamed from: d  reason: collision with root package name */
    public FileChannel f4386d;

    public a(String str, File file, boolean z) {
        this.f4383a = new File(file, str + ".lck");
        this.f4385c = z;
    }

    public final void a() {
        FileChannel fileChannel = this.f4386d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f4384b.unlock();
    }

    private static Lock a(String str) {
        Lock lock;
        synchronized (f4382e) {
            lock = f4382e.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f4382e.put(str, lock);
            }
        }
        return lock;
    }
}
