package org.npci.upi.security.pinactivitycomponent;

class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GetCredential f72996a;

    n(GetCredential getCredential) {
        this.f72996a = getCredential;
    }

    public void run() {
        boolean unused = this.f72996a.doubleBackToExitPressedOnce = false;
    }
}
