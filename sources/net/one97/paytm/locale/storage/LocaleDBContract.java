package net.one97.paytm.locale.storage;

import com.paytm.utility.v;

public class LocaleDBContract {
    public static final int BENGALI = 5;
    public static final int ENGLISH = 0;
    public static final int GUJARATI = 2;
    public static final int HINDI = 1;
    public static final int KANNADA = 7;
    public static final int MALAYALAM = 8;
    public static final int MARATHI = 3;
    public static final int ODIA = 10;
    public static final int PUNJABI = 9;
    public static final int TAMIL = 6;
    public static final int TELUGU = 4;

    interface BaseTable {
        public static final String KEY = "key_name";
        public static final String MESSAGE = "message";
        public static final String _ID = "id";
    }

    interface TABLE_BENGALI extends BaseTable {
        public static final String INDEX = "be_titles";
        public static final String TABLE_NAME = "bengali";
    }

    interface TABLE_ENGLISH extends BaseTable {
        public static final String INDEX = "en_titles";
        public static final String TABLE_NAME = "english";
    }

    interface TABLE_GUJARATI extends BaseTable {
        public static final String INDEX = "gu_titles";
        public static final String TABLE_NAME = "gujarati";
    }

    interface TABLE_HINDI extends BaseTable {
        public static final String INDEX = "hi_titles";
        public static final String TABLE_NAME = "hindi";
    }

    interface TABLE_KANNADA extends BaseTable {
        public static final String INDEX = "ka_titles";
        public static final String TABLE_NAME = "kannada";
    }

    interface TABLE_MALAYALAM extends BaseTable {
        public static final String INDEX = "mal_titles";
        public static final String TABLE_NAME = "malayalam";
    }

    interface TABLE_MARATHI extends BaseTable {
        public static final String INDEX = "mar_titles";
        public static final String TABLE_NAME = "marathi";
    }

    interface TABLE_ODIA extends BaseTable {
        public static final String INDEX = "od_titles";
        public static final String TABLE_NAME = "odia";
    }

    interface TABLE_PUNJABI extends BaseTable {
        public static final String INDEX = "pu_titles";
        public static final String TABLE_NAME = "punjabi";
    }

    interface TABLE_TAMIL extends BaseTable {
        public static final String INDEX = "ta_titles";
        public static final String TABLE_NAME = "tamil";
    }

    interface TABLE_TELUGU extends BaseTable {
        public static final String INDEX = "te_titles";
        public static final String TABLE_NAME = "telugu";
    }

    public static String getTableIndex(int i2) {
        switch (i2) {
            case 0:
                return TABLE_ENGLISH.INDEX;
            case 1:
                return TABLE_HINDI.INDEX;
            case 2:
                return TABLE_GUJARATI.INDEX;
            case 3:
                return TABLE_MARATHI.INDEX;
            case 4:
                return TABLE_TELUGU.INDEX;
            case 5:
                return TABLE_BENGALI.INDEX;
            case 6:
                return TABLE_TAMIL.INDEX;
            case 7:
                return TABLE_KANNADA.INDEX;
            case 8:
                return TABLE_MALAYALAM.INDEX;
            case 9:
                return TABLE_PUNJABI.INDEX;
            case 10:
                return TABLE_ODIA.INDEX;
            default:
                return TABLE_ENGLISH.INDEX;
        }
    }

    public static String getTableName(int i2) {
        switch (i2) {
            case 0:
                return TABLE_ENGLISH.TABLE_NAME;
            case 1:
                return TABLE_HINDI.TABLE_NAME;
            case 2:
                return TABLE_GUJARATI.TABLE_NAME;
            case 3:
                return TABLE_MARATHI.TABLE_NAME;
            case 4:
                return TABLE_TELUGU.TABLE_NAME;
            case 5:
                return TABLE_BENGALI.TABLE_NAME;
            case 6:
                return TABLE_TAMIL.TABLE_NAME;
            case 7:
                return TABLE_KANNADA.TABLE_NAME;
            case 8:
                return TABLE_MALAYALAM.TABLE_NAME;
            case 9:
                return TABLE_PUNJABI.TABLE_NAME;
            case 10:
                return TABLE_ODIA.TABLE_NAME;
            default:
                return TABLE_ENGLISH.TABLE_NAME;
        }
    }

    public static String getTempTableName(int i2) {
        switch (i2) {
            case 0:
                return "english_temp";
            case 1:
                return "hindi_temp";
            case 2:
                return "gujarati_temp";
            case 3:
                return "marathi_temp";
            case 4:
                return "telugu_temp";
            case 5:
                return "bengali_temp";
            case 6:
                return "tamil_temp";
            case 7:
                return "kannada_temp";
            case 8:
                return "malayalam_temp";
            case 9:
                return "punjabi_temp";
            case 10:
                return "odia_temp";
            default:
                return "english_temp";
        }
    }

    static boolean isIndexingEnabled() {
        return true;
    }

    public static String SQL_CREATE_TABLE(int i2) {
        String tableName = getTableName(i2);
        return "CREATE TABLE " + tableName + " (id INTEGER PRIMARY KEY, key_name TEXT, message TEXT, UNIQUE (key_name) ON CONFLICT REPLACE )";
    }

    public static String SQL_CREATE_TEMP_TABLE(int i2) {
        String tempTableName = getTempTableName(i2);
        return "CREATE TABLE " + tempTableName + " (id INTEGER PRIMARY KEY, key_name TEXT, message TEXT, UNIQUE (key_name) ON CONFLICT REPLACE )";
    }

    public static String SQL_CREATE_LOCALE_TABLE_INDEX(int i2) {
        return "CREATE INDEX " + getTableIndex(i2) + " ON " + getTableName(i2) + " (key_name)";
    }

    public static String SQL_DROP_LOCALE_TABLE_INDEX(int i2) {
        return "DROP INDEX IF EXISTS " + getTableIndex(i2);
    }

    static String LocaleToLangColumnName(String str) {
        if (v.a(str)) {
            return str;
        }
        return str.replace("-", "_");
    }

    public static int getLanguageIdFromLocale(String str) {
        if (str == null || "en-in".startsWith(str)) {
            return 0;
        }
        if ("hi-in".startsWith(str)) {
            return 1;
        }
        if ("gu-in".startsWith(str)) {
            return 2;
        }
        if ("mr-in".startsWith(str)) {
            return 3;
        }
        if ("te-in".startsWith(str)) {
            return 4;
        }
        if ("bn-in".startsWith(str)) {
            return 5;
        }
        if ("ta-in".startsWith(str)) {
            return 6;
        }
        if ("kn-in".startsWith(str)) {
            return 7;
        }
        if ("ml-in".startsWith(str)) {
            return 8;
        }
        if ("pa-in".startsWith(str)) {
            return 9;
        }
        if ("or-in".startsWith(str)) {
            return 10;
        }
        return 0;
    }
}
