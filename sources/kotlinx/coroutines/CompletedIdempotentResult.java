package kotlinx.coroutines;

final class CompletedIdempotentResult {
    public final Object idempotentResume;
    public final Object result;

    public CompletedIdempotentResult(Object obj, Object obj2) {
        this.idempotentResume = obj;
        this.result = obj2;
    }

    public final String toString() {
        return "CompletedIdempotentResult[" + this.result + ']';
    }
}
