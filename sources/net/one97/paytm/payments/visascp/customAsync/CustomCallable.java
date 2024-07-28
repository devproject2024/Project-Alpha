package net.one97.paytm.payments.visascp.customAsync;

import java.util.concurrent.Callable;

public interface CustomCallable<T> extends Callable<T> {
    void onPostExecuteData(T t);

    void onPreExecuteData();
}
