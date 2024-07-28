package net.one97.paytm.phoenix.viewmodel;

import androidx.lifecycle.z;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.x;

public final class EventObserver<T> implements z<Event<? extends T>> {
    private final b<T, x> onEventUnhandledContent;

    public EventObserver(b<? super T, x> bVar) {
        k.c(bVar, "onEventUnhandledContent");
        this.onEventUnhandledContent = bVar;
    }

    public final void onChanged(Event<? extends T> event) {
        Object contentIfNotHandled;
        if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
            this.onEventUnhandledContent.invoke(contentIfNotHandled);
        }
    }
}
