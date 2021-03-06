package com.gthncz.mymarketclient.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_LEVEL".
*/
public class UserLevelDao extends AbstractDao<UserLevel, Long> {

    public static final String TABLENAME = "USER_LEVEL";

    /**
     * Properties of entity UserLevel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, long.class, "_id", true, "id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Count = new Property(2, int.class, "count", false, "COUNT");
        public final static Property Status = new Property(3, int.class, "status", false, "STATUS");
    }


    public UserLevelDao(DaoConfig config) {
        super(config);
    }
    
    public UserLevelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_LEVEL\" (" + //
                "\"id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE ," + // 0: _id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"COUNT\" INTEGER NOT NULL ," + // 2: count
                "\"STATUS\" INTEGER NOT NULL );"); // 3: status
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_LEVEL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserLevel entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.get_id());
        stmt.bindString(2, entity.getName());
        stmt.bindLong(3, entity.getCount());
        stmt.bindLong(4, entity.getStatus());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserLevel entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.get_id());
        stmt.bindString(2, entity.getName());
        stmt.bindLong(3, entity.getCount());
        stmt.bindLong(4, entity.getStatus());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public UserLevel readEntity(Cursor cursor, int offset) {
        UserLevel entity = new UserLevel( //
            cursor.getLong(offset + 0), // _id
            cursor.getString(offset + 1), // name
            cursor.getInt(offset + 2), // count
            cursor.getInt(offset + 3) // status
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserLevel entity, int offset) {
        entity.set_id(cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setCount(cursor.getInt(offset + 2));
        entity.setStatus(cursor.getInt(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(UserLevel entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(UserLevel entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(UserLevel entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
