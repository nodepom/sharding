package com.sharding.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName: TestInterceptor
 * @Description: 测试插件
 * @Author: wl
 * @Date: 2019-10-17 18:01
 */
@Intercepts({
        //执行参数接口，method为接口名称，args为参数对象（注意：不同版本个数不同，该版本：5.0.0）
        @Signature(type=ParameterHandler.class, method="setParameters", args={PreparedStatement.class})
})
@Slf4j
public class TestInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
     /*   ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
        PreparedStatement ps = (PreparedStatement) invocation.getArgs()[0];
        // 反射获取 BoundSql 对象，此对象包含生成的sql和sql的参数map映射
        Field boundSqlField = parameterHandler.getClass().getDeclaredField("boundSql");
        boundSqlField.setAccessible(true);
        BoundSql boundSql = (BoundSql) boundSqlField.get(parameterHandler);
        List<String> paramNames = new ArrayList<>();
        // 【敏感信息加密】表是否存在SQL语句中
        boolean hasTab = CommonEntity.checkTable(boundSql.getSql());
        if (!hasTab) {
            return invocation.proceed();
        }
        Field parameterField = parameterHandler.getClass().getDeclaredField("parameterObject");
        Field mappedStatement = parameterHandler.getClass().getDeclaredField("mappedStatement");
        parameterField.setAccessible(true);
        mappedStatement.setAccessible(true);
        Object parameterObject = parameterField.get(parameterHandler);
        MappedStatement ms = (MappedStatement)mappedStatement.get(parameterHandler);

        // 【关键】：改写参数（注：这里只要拿到这个参数，可以自行处理，CommonEntity只是作者本人的加解密思路）
        parameterObject = CommonEntity.processColumn(parameterObject, paramNames, boundSql.getParameterMappings(), ms.getSqlCommandType().name());
        // 改写的参数设置到原parameterHandler对象
        parameterField.set(parameterHandler, parameterObject);
        parameterHandler.setParameters(ps);*/
        log.info("执行拦截器插件");
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
