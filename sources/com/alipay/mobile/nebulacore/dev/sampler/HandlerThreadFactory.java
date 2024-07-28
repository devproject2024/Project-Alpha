package com.alipay.mobile.nebulacore.dev.sampler;

import android.os.Handler;
import android.os.HandlerThread;

final class HandlerThreadFactory {
    private static HandlerThreadWrapper sLoopThread = new HandlerThreadWrapper("loop");
    private static HandlerThreadWrapper sWriteLogThread = new HandlerThreadWrapper("writer");

    private HandlerThreadFactory() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static Handler getTimerThreadHandler() {
        return sLoopThread.getHandler();
    }

    public static Handler getWriteLogThreadHandler() {
        return sWriteLogThread.getHandler();
    }

    static class HandlerThreadWrapper {
        private Handler handler = null;

        public HandlerThreadWrapper(String str) {
            HandlerThread handlerThread = new HandlerThread("Nebula-".concat(String.valueOf(str)));
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper());
        }

        public Handler getHandler() {
            return this.handler;
        }
    }
}
