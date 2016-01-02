package com.star.people.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * Created by zuhai.jiang on 2015/12/23.
 */
public class ObjectUtil {

    public static <T> void fromMap(Map<String, Object> map, T obj){
        for (Map.Entry<String, Object> ent:map.entrySet()) {
            String key = ent.getKey();
            try {
                Field field = obj.getClass().getDeclaredField(key);
                field.setAccessible(true);
                field.set(obj, ent.getValue());
            } catch (NoSuchFieldException e) {
                continue;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> void fromMap(Map<String, Object> map, T obj, Collection<String> ignore){
        for (Map.Entry<String, Object> ent:map.entrySet()) {
            String key = ent.getKey();
            if (ignore.contains(key)) {
                continue;
            }
            try {
                Field field = obj.getClass().getDeclaredField(key);
                field.setAccessible(true);
                field.set(obj, ent.getValue());
            } catch (NoSuchFieldException e) {
                continue;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> Object fromMap(Map<String, Object> map, Class<T> c) throws IllegalAccessException, InstantiationException {
        T obj = c.newInstance();
        fromMap(map, obj);
        return obj;
    }

    public static String[] getFields(Class c){
        String[] fields = null;
        Field[] f = c.getDeclaredFields();
        fields = CollectionUtil.map(f, new CollectionUtil.Mapper<Field, String>() {
            @Override
            public String map(Field item) {
                return item.getName();
            }
        }, new String[f.length]);
        return fields;
    }

}
