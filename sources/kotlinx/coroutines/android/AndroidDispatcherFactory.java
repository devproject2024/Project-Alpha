package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;

public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    public final int getLoadPriority() {
        return 1073741823;
    }

    public final String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public final HandlerContext createDispatcher(List<? extends MainDispatcherFactory> list) {
        return new HandlerContext(HandlerDispatcherKt.asHandler(Looper.getMainLooper(), true), "Main");
    }
}
