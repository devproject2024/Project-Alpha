package com.j256.ormlite.db;

import com.business.merchant_payments.common.utility.AppUtility;
import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public abstract class BaseDatabaseType implements DatabaseType {
    protected static String DEFAULT_SEQUENCE_SUFFIX = "_id_seq";
    protected Driver driver;

    private void appendCanBeNull(StringBuilder sb, FieldType fieldType) {
    }

    public void appendCreateTableSuffix(StringBuilder sb) {
    }

    public void appendSelectNextValFromSequence(StringBuilder sb, String str) {
    }

    /* access modifiers changed from: protected */
    public void configureId(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3) {
    }

    public void dropColumnArg(FieldType fieldType, List<String> list, List<String> list2) {
    }

    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean generatedIdSqlAtEnd() {
        return true;
    }

    public String getCommentLinePrefix() {
        return "-- ";
    }

    public DataPersister getDataPersister(DataPersister dataPersister, FieldType fieldType) {
        return dataPersister;
    }

    /* access modifiers changed from: protected */
    public abstract String getDriverClassName();

    public FieldConverter getFieldConverter(DataPersister dataPersister, FieldType fieldType) {
        return dataPersister;
    }

    public String getPingStatement() {
        return "SELECT 1";
    }

    public boolean isAllowGeneratedIdInsertSupported() {
        return true;
    }

    public boolean isBatchUseTransaction() {
        return false;
    }

    public boolean isCreateIfNotExistsSupported() {
        return false;
    }

    public boolean isCreateTableReturnsNegative() {
        return false;
    }

    public boolean isCreateTableReturnsZero() {
        return true;
    }

    public boolean isEntityNamesMustBeUpCase() {
        return false;
    }

    public boolean isIdSequenceNeeded() {
        return false;
    }

    public boolean isLimitAfterSelect() {
        return false;
    }

    public boolean isLimitSqlSupported() {
        return true;
    }

    public boolean isNestedSavePointsSupported() {
        return true;
    }

    public boolean isOffsetLimitArgument() {
        return false;
    }

    public boolean isOffsetSqlSupported() {
        return true;
    }

    public boolean isSelectSequenceBeforeInsert() {
        return false;
    }

    public boolean isTruncateSupported() {
        return false;
    }

    public boolean isVarcharFieldWidthSupported() {
        return true;
    }

    public void loadDriver() throws SQLException {
        String driverClassName = getDriverClassName();
        if (driverClassName != null) {
            try {
                Class.forName(driverClassName);
            } catch (ClassNotFoundException e2) {
                throw SqlExceptionUtil.create("Driver class was not found for " + getDatabaseName() + " database.  Missing jar with class " + driverClassName + AppUtility.CENTER_DOT, e2);
            }
        }
    }

    public void setDriver(Driver driver2) {
        this.driver = driver2;
    }

    public void appendColumnArg(String str, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) throws SQLException {
        StringBuilder sb2 = sb;
        FieldType fieldType2 = fieldType;
        appendEscapedEntityName(sb, fieldType.getColumnName());
        sb.append(' ');
        DataPersister dataPersister = fieldType.getDataPersister();
        int width = fieldType.getWidth();
        if (width == 0) {
            width = dataPersister.getDefaultWidth();
        }
        switch (dataPersister.getSqlType()) {
            case STRING:
                appendStringType(sb, fieldType, width);
                break;
            case LONG_STRING:
                appendLongStringType(sb, fieldType, width);
                break;
            case BOOLEAN:
                appendBooleanType(sb, fieldType, width);
                break;
            case DATE:
                appendDateType(sb, fieldType, width);
                break;
            case CHAR:
                appendCharType(sb, fieldType, width);
                break;
            case BYTE:
                appendByteType(sb, fieldType, width);
                break;
            case BYTE_ARRAY:
                appendByteArrayType(sb, fieldType, width);
                break;
            case SHORT:
                appendShortType(sb, fieldType, width);
                break;
            case INTEGER:
                appendIntegerType(sb, fieldType, width);
                break;
            case LONG:
                appendLongType(sb, fieldType, width);
                break;
            case FLOAT:
                appendFloatType(sb, fieldType, width);
                break;
            case DOUBLE:
                appendDoubleType(sb, fieldType, width);
                break;
            case SERIALIZABLE:
                appendSerializableType(sb, fieldType, width);
                break;
            case BIG_DECIMAL:
                appendBigDecimalNumericType(sb, fieldType, width);
                break;
            case UUID:
                appendUuidNativeType(sb, fieldType, width);
                break;
            case OTHER:
                String sqlOtherType = dataPersister.getSqlOtherType();
                if (sqlOtherType != null) {
                    sb.append(sqlOtherType);
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown SQL-type " + dataPersister.getSqlType());
        }
        sb.append(' ');
        if (fieldType.isGeneratedIdSequence() && !fieldType.isSelfGeneratedId()) {
            configureGeneratedIdSequence(sb, fieldType, list2, list, list4);
        } else if (fieldType.isGeneratedId() && !fieldType.isSelfGeneratedId()) {
            configureGeneratedId(str, sb, fieldType, list2, list3, list, list4);
        } else if (fieldType.isId()) {
            configureId(sb, fieldType, list2, list, list4);
        }
        if (!fieldType.isGeneratedId()) {
            Object defaultValue = fieldType.getDefaultValue();
            if (defaultValue != null) {
                sb.append("DEFAULT ");
                appendDefaultValue(sb, fieldType, defaultValue);
                sb.append(' ');
            }
            if (fieldType.isCanBeNull()) {
                appendCanBeNull(sb, fieldType);
            } else {
                sb.append("NOT NULL ");
            }
            if (fieldType.isUnique()) {
                addSingleUnique(sb, fieldType, list, list3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void appendStringType(StringBuilder sb, FieldType fieldType, int i2) {
        if (isVarcharFieldWidthSupported()) {
            sb.append("VARCHAR(");
            sb.append(i2);
            sb.append(')');
            return;
        }
        sb.append("VARCHAR");
    }

    /* access modifiers changed from: protected */
    public void appendUuidNativeType(StringBuilder sb, FieldType fieldType, int i2) {
        throw new UnsupportedOperationException("UUID is not supported by this database type");
    }

    /* access modifiers changed from: protected */
    public void appendLongStringType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("TEXT");
    }

    /* access modifiers changed from: protected */
    public void appendDateType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("TIMESTAMP");
    }

    /* access modifiers changed from: protected */
    public void appendBooleanType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("BOOLEAN");
    }

    /* access modifiers changed from: protected */
    public void appendCharType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("CHAR");
    }

    /* access modifiers changed from: protected */
    public void appendByteType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("TINYINT");
    }

    /* access modifiers changed from: protected */
    public void appendShortType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("SMALLINT");
    }

    private void appendIntegerType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("INTEGER");
    }

    /* access modifiers changed from: protected */
    public void appendLongType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("BIGINT");
    }

    private void appendFloatType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("FLOAT");
    }

    private void appendDoubleType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("DOUBLE PRECISION");
    }

    /* access modifiers changed from: protected */
    public void appendByteArrayType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("BLOB");
    }

    /* access modifiers changed from: protected */
    public void appendSerializableType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("BLOB");
    }

    /* access modifiers changed from: protected */
    public void appendBigDecimalNumericType(StringBuilder sb, FieldType fieldType, int i2) {
        sb.append("NUMERIC");
    }

    private void appendDefaultValue(StringBuilder sb, FieldType fieldType, Object obj) {
        if (fieldType.isEscapedDefaultValue()) {
            appendEscapedWord(sb, obj.toString());
        } else {
            sb.append(obj);
        }
    }

    /* access modifiers changed from: protected */
    public void configureGeneratedIdSequence(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3) throws SQLException {
        throw new SQLException("GeneratedIdSequence is not supported by database " + getDatabaseName() + " for field " + fieldType);
    }

    /* access modifiers changed from: protected */
    public void configureGeneratedId(String str, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        throw new IllegalStateException("GeneratedId is not supported by database " + getDatabaseName() + " for field " + fieldType);
    }

    public void addPrimaryKeySql(FieldType[] fieldTypeArr, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        StringBuilder sb = null;
        for (FieldType fieldType : fieldTypeArr) {
            if ((!fieldType.isGeneratedId() || generatedIdSqlAtEnd() || fieldType.isSelfGeneratedId()) && fieldType.isId()) {
                if (sb == null) {
                    sb = new StringBuilder(48);
                    sb.append("PRIMARY KEY (");
                } else {
                    sb.append(',');
                }
                appendEscapedEntityName(sb, fieldType.getColumnName());
            }
        }
        if (sb != null) {
            sb.append(") ");
            list.add(sb.toString());
        }
    }

    public void addUniqueComboSql(FieldType[] fieldTypeArr, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        StringBuilder sb = null;
        for (FieldType fieldType : fieldTypeArr) {
            if (fieldType.isUniqueCombo()) {
                if (sb == null) {
                    sb = new StringBuilder(48);
                    sb.append("UNIQUE (");
                } else {
                    sb.append(',');
                }
                appendEscapedEntityName(sb, fieldType.getColumnName());
            }
        }
        if (sb != null) {
            sb.append(") ");
            list.add(sb.toString());
        }
    }

    public void appendEscapedWord(StringBuilder sb, String str) {
        sb.append('\'');
        sb.append(str);
        sb.append('\'');
    }

    public void appendEscapedEntityName(StringBuilder sb, String str) {
        sb.append('`');
        int indexOf = str.indexOf(46);
        if (indexOf > 0) {
            sb.append(str.substring(0, indexOf));
            sb.append("`.`");
            sb.append(str.substring(indexOf + 1));
        } else {
            sb.append(str);
        }
        sb.append('`');
    }

    public String generateIdSequenceName(String str, FieldType fieldType) {
        String str2 = str + DEFAULT_SEQUENCE_SUFFIX;
        return isEntityNamesMustBeUpCase() ? upCaseEntityName(str2) : str2;
    }

    public void appendLimitValue(StringBuilder sb, long j, Long l) {
        sb.append("LIMIT ");
        sb.append(j);
        sb.append(' ');
    }

    public void appendOffsetValue(StringBuilder sb, long j) {
        sb.append("OFFSET ");
        sb.append(j);
        sb.append(' ');
    }

    public String upCaseEntityName(String str) {
        return str.toUpperCase(Locale.ENGLISH);
    }

    public boolean isCreateIndexIfNotExistsSupported() {
        return isCreateIfNotExistsSupported();
    }

    public void appendInsertNoColumns(StringBuilder sb) {
        sb.append("() VALUES ()");
    }

    private void addSingleUnique(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" UNIQUE (");
        appendEscapedEntityName(sb2, fieldType.getColumnName());
        sb2.append(')');
        list.add(sb2.toString());
    }

    protected static class BooleanNumberFieldConverter extends BaseFieldConverter {
        protected BooleanNumberFieldConverter() {
        }

        public SqlType getSqlType() {
            return SqlType.BOOLEAN;
        }

        public Object parseDefaultString(FieldType fieldType, String str) {
            byte b2;
            if (Boolean.parseBoolean(str)) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            return Byte.valueOf(b2);
        }

        public Object javaToSqlArg(FieldType fieldType, Object obj) {
            return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
        }

        public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException {
            return Byte.valueOf(databaseResults.getByte(i2));
        }

        public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) {
            return ((Byte) obj).byteValue() == 1 ? Boolean.TRUE : Boolean.FALSE;
        }

        public Object resultStringToJava(FieldType fieldType, String str, int i2) {
            return sqlArgToJava(fieldType, Byte.valueOf(Byte.parseByte(str)), i2);
        }
    }
}
