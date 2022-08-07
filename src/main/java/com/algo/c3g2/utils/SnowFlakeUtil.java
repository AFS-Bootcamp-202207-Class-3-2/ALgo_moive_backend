package com.algo.c3g2.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class SnowFlakeUtil implements IdentifierGenerator {
    private static Snowflake snowflake = IdUtil.createSnowflake(0,0);
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return snowflake.nextIdStr();
    }
    public String getNextId() {
        return snowflake.nextIdStr();
    }
}
