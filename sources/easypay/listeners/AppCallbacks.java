package easypay.listeners;

public interface AppCallbacks {
    void onApiError(String str);

    void onNetworkError(String str);

    void smsReceivedCallback(String str, boolean z);
}
