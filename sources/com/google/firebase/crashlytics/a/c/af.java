package com.google.firebase.crashlytics.a.c;

import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.f;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    private static final FilenameFilter f38163a = new FilenameFilter() {
        public final boolean accept(File file, String str) {
            return true;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f38164b = u.a("awaitEvenIfOnMainThread task continuation executor");

    static int a(File file, File file2, int i2, Comparator<File> comparator) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        File[] listFiles2 = file2.listFiles(f38163a);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        if (listFiles2 == null) {
            listFiles2 = new File[0];
        }
        arrayList.addAll(Arrays.asList(listFiles));
        arrayList.addAll(Arrays.asList(listFiles2));
        return a((List<File>) arrayList, i2, comparator);
    }

    static int a(File file, int i2, Comparator<File> comparator) {
        return a(file, f38163a, i2, comparator);
    }

    static int a(File file, FilenameFilter filenameFilter, int i2, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles == null) {
            return 0;
        }
        return a((List<File>) Arrays.asList(listFiles), i2, comparator);
    }

    private static int a(List<File> list, int i2, Comparator<File> comparator) {
        int size = list.size();
        Collections.sort(list, comparator);
        for (File next : list) {
            if (size <= i2) {
                return size;
            }
            a(next);
            size--;
        }
        return size;
    }

    public static <T> Task<T> a(Task<T> task, Task<T> task2) {
        final f fVar = new f();
        AnonymousClass2 r1 = new a<T, Void>() {
            public final /* synthetic */ Object a(Task task) throws Exception {
                if (task.b()) {
                    f.this.b(task.d());
                    return null;
                }
                f.this.b(task.e());
                return null;
            }
        };
        task.a((a<T, TContinuationResult>) r1);
        task2.a((a<T, TContinuationResult>) r1);
        return fVar.a();
    }

    public static <T> Task<T> a(Executor executor, final Callable<Task<T>> callable) {
        final f fVar = new f();
        executor.execute(new Runnable() {
            public final void run() {
                try {
                    ((Task) callable.call()).a(new a<T, Void>() {
                        public final /* synthetic */ Object a(Task task) throws Exception {
                            if (task.b()) {
                                fVar.a(task.d());
                                return null;
                            }
                            fVar.a(task.e());
                            return null;
                        }
                    });
                } catch (Exception e2) {
                    fVar.a(e2);
                }
            }
        });
        return fVar.a();
    }

    public static <T> T a(Task<T> task) throws InterruptedException, TimeoutException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.a((Executor) f38164b, (a<T, TContinuationResult>) new a<T, Object>() {
            public final Object a(Task<T> task) throws Exception {
                countDownLatch.countDown();
                return null;
            }
        });
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (task.a()) {
            return task.d();
        }
        throw new TimeoutException();
    }

    private static void a(File file) {
        if (file.isDirectory()) {
            for (File a2 : file.listFiles()) {
                a(a2);
            }
        }
        file.delete();
    }
}
