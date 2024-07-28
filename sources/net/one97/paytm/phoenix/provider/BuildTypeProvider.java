package net.one97.paytm.phoenix.provider;

import net.one97.paytm.verifier.a.c;

public final class BuildTypeProvider implements PaytmBuildTypeProvider {
    public final boolean isStagingApp() {
        return c.a();
    }
}
