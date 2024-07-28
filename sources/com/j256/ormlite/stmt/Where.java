package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.query.Between;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.Exists;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.stmt.query.InSubQuery;
import com.j256.ormlite.stmt.query.IsNotNull;
import com.j256.ormlite.stmt.query.IsNull;
import com.j256.ormlite.stmt.query.ManyClause;
import com.j256.ormlite.stmt.query.NeedsFutureClause;
import com.j256.ormlite.stmt.query.Not;
import com.j256.ormlite.stmt.query.Raw;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Where<T, ID> {
    private static final int CLAUSE_STACK_START_SIZE = 4;
    private Clause[] clauseStack = new Clause[4];
    private int clauseStackLevel;
    private final DatabaseType databaseType;
    private final String idColumnName;
    private final FieldType idFieldType;
    private NeedsFutureClause needsFuture = null;
    private final StatementBuilder<T, ID> statementBuilder;
    private final TableInfo<T, ID> tableInfo;

    Where(TableInfo<T, ID> tableInfo2, StatementBuilder<T, ID> statementBuilder2, DatabaseType databaseType2) {
        this.tableInfo = tableInfo2;
        this.statementBuilder = statementBuilder2;
        this.idFieldType = tableInfo2.getIdField();
        FieldType fieldType = this.idFieldType;
        if (fieldType == null) {
            this.idColumnName = null;
        } else {
            this.idColumnName = fieldType.getColumnName();
        }
        this.databaseType = databaseType2;
    }

    public Where<T, ID> and() {
        ManyClause manyClause = new ManyClause(pop("AND"), "AND");
        push(manyClause);
        addNeedsFuture(manyClause);
        return this;
    }

    public Where<T, ID> and(Where<T, ID> where, Where<T, ID> where2, Where<T, ID>... whereArr) {
        Clause[] buildClauseArray = buildClauseArray(whereArr, "AND");
        addClause(new ManyClause(pop("AND"), pop("AND"), buildClauseArray, "AND"));
        return this;
    }

    public Where<T, ID> and(int i2) {
        if (i2 != 0) {
            Clause[] clauseArr = new Clause[i2];
            while (true) {
                i2--;
                if (i2 >= 0) {
                    clauseArr[i2] = pop("AND");
                } else {
                    addClause(new ManyClause(clauseArr, "AND"));
                    return this;
                }
            }
        } else {
            throw new IllegalArgumentException("Must have at least one clause in and(numClauses)");
        }
    }

    public Where<T, ID> between(String str, Object obj, Object obj2) throws SQLException {
        addClause(new Between(str, findColumnFieldType(str), obj, obj2));
        return this;
    }

    public Where<T, ID> eq(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, "="));
        return this;
    }

    public Where<T, ID> ge(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION));
        return this;
    }

    public Where<T, ID> gt(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.GREATER_THAN_OPERATION));
        return this;
    }

    public Where<T, ID> in(String str, Iterable<?> iterable) throws SQLException {
        addClause(new In(str, findColumnFieldType(str), iterable, true));
        return this;
    }

    public Where<T, ID> notIn(String str, Iterable<?> iterable) throws SQLException {
        addClause(new In(str, findColumnFieldType(str), iterable, false));
        return this;
    }

    public Where<T, ID> in(String str, Object... objArr) throws SQLException {
        return in(true, str, objArr);
    }

    public Where<T, ID> notIn(String str, Object... objArr) throws SQLException {
        return in(false, str, objArr);
    }

    public Where<T, ID> in(String str, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        return in(true, str, queryBuilder);
    }

    public Where<T, ID> notIn(String str, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        return in(false, str, queryBuilder);
    }

    public Where<T, ID> exists(QueryBuilder<?, ?> queryBuilder) {
        queryBuilder.enableInnerQuery();
        addClause(new Exists(new QueryBuilder.InternalQueryBuilderWrapper(queryBuilder)));
        return this;
    }

    public Where<T, ID> isNull(String str) throws SQLException {
        addClause(new IsNull(str, findColumnFieldType(str)));
        return this;
    }

    public Where<T, ID> isNotNull(String str) throws SQLException {
        addClause(new IsNotNull(str, findColumnFieldType(str)));
        return this;
    }

    public Where<T, ID> le(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION));
        return this;
    }

    public Where<T, ID> lt(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.LESS_THAN_OPERATION));
        return this;
    }

    public Where<T, ID> like(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.LIKE_OPERATION));
        return this;
    }

    public Where<T, ID> ne(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.NOT_EQUAL_TO_OPERATION));
        return this;
    }

    public Where<T, ID> not() {
        Not not = new Not();
        addClause(not);
        addNeedsFuture(not);
        return this;
    }

    public Where<T, ID> not(Where<T, ID> where) {
        addClause(new Not(pop("NOT")));
        return this;
    }

    public Where<T, ID> or() {
        ManyClause manyClause = new ManyClause(pop("OR"), "OR");
        push(manyClause);
        addNeedsFuture(manyClause);
        return this;
    }

    public Where<T, ID> or(Where<T, ID> where, Where<T, ID> where2, Where<T, ID>... whereArr) {
        Clause[] buildClauseArray = buildClauseArray(whereArr, "OR");
        addClause(new ManyClause(pop("OR"), pop("OR"), buildClauseArray, "OR"));
        return this;
    }

    public Where<T, ID> or(int i2) {
        if (i2 != 0) {
            Clause[] clauseArr = new Clause[i2];
            while (true) {
                i2--;
                if (i2 >= 0) {
                    clauseArr[i2] = pop("OR");
                } else {
                    addClause(new ManyClause(clauseArr, "OR"));
                    return this;
                }
            }
        } else {
            throw new IllegalArgumentException("Must have at least one clause in or(numClauses)");
        }
    }

    public Where<T, ID> idEq(ID id) throws SQLException {
        String str = this.idColumnName;
        if (str != null) {
            addClause(new SimpleComparison(str, this.idFieldType, id, "="));
            return this;
        }
        throw new SQLException("Object has no id column specified");
    }

    public <OD> Where<T, ID> idEq(Dao<OD, ?> dao, OD od) throws SQLException {
        String str = this.idColumnName;
        if (str != null) {
            addClause(new SimpleComparison(str, this.idFieldType, dao.extractId(od), "="));
            return this;
        }
        throw new SQLException("Object has no id column specified");
    }

    public Where<T, ID> raw(String str, ArgumentHolder... argumentHolderArr) {
        for (ArgumentHolder argumentHolder : argumentHolderArr) {
            String columnName = argumentHolder.getColumnName();
            if (columnName != null) {
                argumentHolder.setMetaInfo(findColumnFieldType(columnName));
            } else if (argumentHolder.getSqlType() == null) {
                throw new IllegalArgumentException("Either the column name or SqlType must be set on each argument");
            }
        }
        addClause(new Raw(str, argumentHolderArr));
        return this;
    }

    public Where<T, ID> rawComparison(String str, String str2, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, str2));
        return this;
    }

    public PreparedQuery<T> prepare() throws SQLException {
        return this.statementBuilder.prepareStatement((Long) null, false);
    }

    public List<T> query() throws SQLException {
        return checkQueryBuilderMethod("query()").query();
    }

    public GenericRawResults<String[]> queryRaw() throws SQLException {
        return checkQueryBuilderMethod("queryRaw()").queryRaw();
    }

    public T queryForFirst() throws SQLException {
        return checkQueryBuilderMethod("queryForFirst()").queryForFirst();
    }

    public String[] queryRawFirst() throws SQLException {
        return checkQueryBuilderMethod("queryRawFirst()").queryRawFirst();
    }

    public long countOf() throws SQLException {
        return checkQueryBuilderMethod("countOf()").countOf();
    }

    public CloseableIterator<T> iterator() throws SQLException {
        return checkQueryBuilderMethod("iterator()").iterator();
    }

    public Where<T, ID> reset() {
        for (int i2 = 0; i2 < this.clauseStackLevel; i2++) {
            this.clauseStack[i2] = null;
        }
        this.clauseStackLevel = 0;
        return this;
    }

    public String getStatement() throws SQLException {
        StringBuilder sb = new StringBuilder();
        appendSql((String) null, sb, new ArrayList());
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void appendSql(String str, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        int i2 = this.clauseStackLevel;
        if (i2 == 0) {
            throw new IllegalStateException("No where clauses defined.  Did you miss a where operation?");
        } else if (i2 != 1) {
            throw new IllegalStateException("Both the \"left-hand\" and \"right-hand\" clauses have been defined.  Did you miss an AND or OR?");
        } else if (this.needsFuture == null) {
            peek().appendSql(this.databaseType, str, sb, list);
        } else {
            throw new IllegalStateException("The SQL statement has not been finished since there are previous operations still waiting for clauses.");
        }
    }

    public String toString() {
        if (this.clauseStackLevel == 0) {
            return "empty where clause";
        }
        return "where clause: ".concat(String.valueOf(peek()));
    }

    private QueryBuilder<T, ID> checkQueryBuilderMethod(String str) throws SQLException {
        StatementBuilder<T, ID> statementBuilder2 = this.statementBuilder;
        if (statementBuilder2 instanceof QueryBuilder) {
            return (QueryBuilder) statementBuilder2;
        }
        throw new SQLException("Cannot call " + str + " on a statement of type " + this.statementBuilder.getType());
    }

    private Where<T, ID> in(boolean z, String str, Object... objArr) throws SQLException {
        if (objArr.length == 1) {
            String str2 = "IN";
            if (objArr[0].getClass().isArray()) {
                StringBuilder sb = new StringBuilder("Object argument to ");
                if (!z) {
                    str2 = "notId";
                }
                sb.append(str2);
                sb.append(" seems to be an array within an array");
                throw new IllegalArgumentException(sb.toString());
            } else if (objArr[0] instanceof Where) {
                StringBuilder sb2 = new StringBuilder("Object argument to ");
                if (!z) {
                    str2 = "notId";
                }
                sb2.append(str2);
                sb2.append(" seems to be a Where object, did you mean the QueryBuilder?");
                throw new IllegalArgumentException(sb2.toString());
            } else if (objArr[0] instanceof PreparedStmt) {
                StringBuilder sb3 = new StringBuilder("Object argument to ");
                if (!z) {
                    str2 = "notId";
                }
                sb3.append(str2);
                sb3.append(" seems to be a prepared statement, did you mean the QueryBuilder?");
                throw new IllegalArgumentException(sb3.toString());
            }
        }
        addClause(new In(str, findColumnFieldType(str), objArr, z));
        return this;
    }

    private Where<T, ID> in(boolean z, String str, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        if (queryBuilder.getSelectColumnCount() == 1) {
            queryBuilder.enableInnerQuery();
            addClause(new InSubQuery(str, findColumnFieldType(str), new QueryBuilder.InternalQueryBuilderWrapper(queryBuilder), z));
            return this;
        } else if (queryBuilder.getSelectColumnCount() == 0) {
            throw new SQLException("Inner query must have only 1 select column specified instead of *");
        } else {
            throw new SQLException("Inner query must have only 1 select column specified instead of " + queryBuilder.getSelectColumnCount() + ": " + queryBuilder.getSelectColumnsAsString());
        }
    }

    private Clause[] buildClauseArray(Where<T, ID>[] whereArr, String str) {
        if (whereArr.length == 0) {
            return null;
        }
        Clause[] clauseArr = new Clause[whereArr.length];
        for (int length = whereArr.length - 1; length >= 0; length--) {
            clauseArr[length] = pop(str);
        }
        return clauseArr;
    }

    private void addNeedsFuture(NeedsFutureClause needsFutureClause) {
        if (this.needsFuture == null) {
            this.needsFuture = needsFutureClause;
            return;
        }
        throw new IllegalStateException(this.needsFuture + " is already waiting for a future clause, can't add: " + needsFutureClause);
    }

    private void addClause(Clause clause) {
        NeedsFutureClause needsFutureClause = this.needsFuture;
        if (needsFutureClause == null) {
            push(clause);
            return;
        }
        needsFutureClause.setMissingClause(clause);
        this.needsFuture = null;
    }

    private FieldType findColumnFieldType(String str) {
        return this.tableInfo.getFieldTypeByColumnName(str);
    }

    private void push(Clause clause) {
        int i2 = this.clauseStackLevel;
        if (i2 == this.clauseStack.length) {
            Clause[] clauseArr = new Clause[(i2 * 2)];
            for (int i3 = 0; i3 < this.clauseStackLevel; i3++) {
                Clause[] clauseArr2 = this.clauseStack;
                clauseArr[i3] = clauseArr2[i3];
                clauseArr2[i3] = null;
            }
            this.clauseStack = clauseArr;
        }
        Clause[] clauseArr3 = this.clauseStack;
        int i4 = this.clauseStackLevel;
        this.clauseStackLevel = i4 + 1;
        clauseArr3[i4] = clause;
    }

    private Clause pop(String str) {
        int i2 = this.clauseStackLevel;
        if (i2 != 0) {
            Clause[] clauseArr = this.clauseStack;
            int i3 = i2 - 1;
            this.clauseStackLevel = i3;
            Clause clause = clauseArr[i3];
            clauseArr[this.clauseStackLevel] = null;
            return clause;
        }
        throw new IllegalStateException("Expecting there to be a clause already defined for '" + str + "' operation");
    }

    private Clause peek() {
        return this.clauseStack[this.clauseStackLevel - 1];
    }
}
