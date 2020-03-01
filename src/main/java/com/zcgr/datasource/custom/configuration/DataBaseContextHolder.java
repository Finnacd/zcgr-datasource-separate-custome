package com.zcgr.datasource.custom.configuration;

/**
 * @author kevin
 */
public class DataBaseContextHolder {

    public enum DataBaseType {
        MASTER, SLAVE
    }

    private static final ThreadLocal<DataBaseType> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDataBaseType(DataBaseType dataBaseType) {
        if (dataBaseType == null) {
            throw new NullPointerException();
        }
        CONTEXT_HOLDER.set(dataBaseType);
    }

    public static DataBaseType getDataBaseType() {
        return CONTEXT_HOLDER.get() == null ? DataBaseType.MASTER : CONTEXT_HOLDER.get();
    }

    public static void clearDataBaseType() {
        CONTEXT_HOLDER.remove();
    }

}
