package com.gthncz.mymarketclient.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.gthncz.mymarketclient.greendao.User;
import com.gthncz.mymarketclient.greendao.UserLevel;
import com.gthncz.mymarketclient.greendao.UserToken;

import com.gthncz.mymarketclient.greendao.UserDao;
import com.gthncz.mymarketclient.greendao.UserLevelDao;
import com.gthncz.mymarketclient.greendao.UserTokenDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig userLevelDaoConfig;
    private final DaoConfig userTokenDaoConfig;

    private final UserDao userDao;
    private final UserLevelDao userLevelDao;
    private final UserTokenDao userTokenDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        userLevelDaoConfig = daoConfigMap.get(UserLevelDao.class).clone();
        userLevelDaoConfig.initIdentityScope(type);

        userTokenDaoConfig = daoConfigMap.get(UserTokenDao.class).clone();
        userTokenDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        userLevelDao = new UserLevelDao(userLevelDaoConfig, this);
        userTokenDao = new UserTokenDao(userTokenDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(UserLevel.class, userLevelDao);
        registerDao(UserToken.class, userTokenDao);
    }
    
    public void clear() {
        userDaoConfig.clearIdentityScope();
        userLevelDaoConfig.clearIdentityScope();
        userTokenDaoConfig.clearIdentityScope();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public UserLevelDao getUserLevelDao() {
        return userLevelDao;
    }

    public UserTokenDao getUserTokenDao() {
        return userTokenDao;
    }

}
