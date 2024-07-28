package kotlinx.coroutines;

import kotlin.d.d;
import kotlin.p;
import kotlin.x;

final class ResumeOnCompletion extends JobNode<Job> {
    private final d<x> continuation;

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public ResumeOnCompletion(Job job, d<? super x> dVar) {
        super(job);
        this.continuation = dVar;
    }

    public final void invoke(Throwable th) {
        d<x> dVar = this.continuation;
        x xVar = x.f47997a;
        p.a aVar = p.Companion;
        dVar.resumeWith(p.m530constructorimpl(xVar));
    }

    public final String toString() {
        return "ResumeOnCompletion[" + this.continuation + ']';
    }
}
