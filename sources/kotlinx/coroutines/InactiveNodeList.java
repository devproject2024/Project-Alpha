package kotlinx.coroutines;

import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class InactiveNodeList implements Incomplete {
    private final NodeList list;

    public final boolean isActive() {
        return false;
    }

    public InactiveNodeList(NodeList nodeList) {
        this.list = nodeList;
    }

    public final NodeList getList() {
        return this.list;
    }

    public final String toString() {
        return DebugKt.getDEBUG() ? getList().getString(SDKConstants.GA_KEY_NEW) : super.toString();
    }
}
