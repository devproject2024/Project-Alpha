package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {
    private Context mAppContext;
    private boolean mRunInForeground;
    private volatile boolean mStopped;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    public void onStopped() {
    }

    public abstract com.google.b.a.a.a<a> startWork();

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.mAppContext = context;
            this.mWorkerParams = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public final UUID getId() {
        return this.mWorkerParams.f5042a;
    }

    public final e getInputData() {
        return this.mWorkerParams.f5043b;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.f5044c;
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.f5045d.f5052b;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.f5045d.f5051a;
    }

    public final Network getNetwork() {
        return this.mWorkerParams.f5045d.f5053c;
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.f5046e;
    }

    public final com.google.b.a.a.a<Void> setProgressAsync(e eVar) {
        return this.mWorkerParams.f5050i.updateProgress(getApplicationContext(), getId(), eVar);
    }

    public final com.google.b.a.a.a<Void> setForegroundAsync(h hVar) {
        this.mRunInForeground = true;
        return this.mWorkerParams.j.setForegroundAsync(getApplicationContext(), getId(), hVar);
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.f5047f;
    }

    public androidx.work.impl.utils.b.a getTaskExecutor() {
        return this.mWorkerParams.f5048g;
    }

    public x getWorkerFactory() {
        return this.mWorkerParams.f5049h;
    }

    public static abstract class a {
        public static a a() {
            return new c();
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new C0076a();
        }

        a() {
        }

        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            public final e f5040a;

            public c() {
                this(e.f5092a);
            }

            public c(e eVar) {
                this.f5040a = eVar;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.f5040a.equals(((c) obj).f5040a);
            }

            public final int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.f5040a.hashCode();
            }

            public final String toString() {
                return "Success {mOutputData=" + this.f5040a + '}';
            }
        }

        /* renamed from: androidx.work.ListenableWorker$a$a  reason: collision with other inner class name */
        public static final class C0076a extends a {

            /* renamed from: a  reason: collision with root package name */
            public final e f5039a;

            public C0076a() {
                this(e.f5092a);
            }

            private C0076a(e eVar) {
                this.f5039a = eVar;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.f5039a.equals(((C0076a) obj).f5039a);
            }

            public final int hashCode() {
                return (C0076a.class.getName().hashCode() * 31) + this.f5039a.hashCode();
            }

            public final String toString() {
                return "Failure {mOutputData=" + this.f5039a + '}';
            }
        }

        public static final class b extends a {
            public final String toString() {
                return "Retry";
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            public final int hashCode() {
                return b.class.getName().hashCode();
            }
        }
    }
}
