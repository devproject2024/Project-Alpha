package kotlinx.coroutines;

import net.one97.paytm.nativesdk.Constants.SDKConstants;

final class Empty implements Incomplete {
    private final boolean isActive;

    public final NodeList getList() {
        return null;
    }

    public Empty(boolean z) {
        this.isActive = z;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(isActive() ? "Active" : SDKConstants.GA_KEY_NEW);
        sb.append('}');
        return sb.toString();
    }
}
