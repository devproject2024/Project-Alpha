package com.j256.ormlite.android;

import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.LoggerFactory;

public class AndroidLog implements Log {
    private static final String ALL_LOGS_NAME = "ORMLite";
    private static final int MAX_TAG_LENGTH = 23;
    private static final int REFRESH_LEVEL_CACHE_EVERY = 200;
    private String className;
    private final boolean[] levelCache;
    private volatile int levelCacheC = 0;

    public AndroidLog(String str) {
        this.className = LoggerFactory.getSimpleClassName(str);
        int length = this.className.length();
        if (length > 23) {
            this.className = this.className.substring(length - 23, length);
        }
        int i2 = 0;
        for (Log.Level levelToAndroidLevel : Log.Level.values()) {
            int levelToAndroidLevel2 = levelToAndroidLevel(levelToAndroidLevel);
            if (levelToAndroidLevel2 > i2) {
                i2 = levelToAndroidLevel2;
            }
        }
        this.levelCache = new boolean[(i2 + 1)];
        refreshLevelCache();
    }

    public boolean isLevelEnabled(Log.Level level) {
        int i2 = this.levelCacheC + 1;
        this.levelCacheC = i2;
        if (i2 >= 200) {
            refreshLevelCache();
            this.levelCacheC = 0;
        }
        int levelToAndroidLevel = levelToAndroidLevel(level);
        boolean[] zArr = this.levelCache;
        if (levelToAndroidLevel < zArr.length) {
            return zArr[levelToAndroidLevel];
        }
        return isLevelEnabledInternal(levelToAndroidLevel);
    }

    public void log(Log.Level level, String str) {
        int[] iArr = AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level;
        level.ordinal();
    }

    public void log(Log.Level level, String str, Throwable th) {
        int[] iArr = AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level;
        level.ordinal();
    }

    private void refreshLevelCache() {
        for (Log.Level levelToAndroidLevel : Log.Level.values()) {
            int levelToAndroidLevel2 = levelToAndroidLevel(levelToAndroidLevel);
            boolean[] zArr = this.levelCache;
            if (levelToAndroidLevel2 < zArr.length) {
                zArr[levelToAndroidLevel2] = isLevelEnabledInternal(levelToAndroidLevel2);
            }
        }
    }

    private boolean isLevelEnabledInternal(int i2) {
        return android.util.Log.isLoggable(this.className, i2) || android.util.Log.isLoggable(ALL_LOGS_NAME, i2);
    }

    private int levelToAndroidLevel(Log.Level level) {
        switch (level) {
            case TRACE:
                return 2;
            case DEBUG:
                return 3;
            case INFO:
                return 4;
            case WARNING:
                return 5;
            case ERROR:
            case FATAL:
                return 6;
            default:
                return 4;
        }
    }
}
