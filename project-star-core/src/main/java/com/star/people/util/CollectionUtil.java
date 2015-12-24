package com.star.people.util;

import java.util.Collection;

/**
 * Created by zuhai.jiang on 2015/11/6.
 */
public class CollectionUtil {

    public static <T> boolean any(Iterable<T> col, Predictor<T> predictor) {
        for (T item : col) {
            if (predictor.predict(item)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean any(T[] col, Predictor<T> predictor) {
        for (T item : col) {
            if (predictor.predict(item)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean all(Iterable<T> col, Predictor<T> predictor) {
        for (T item : col) {
            if (!predictor.predict(item)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean all(T[] col, Predictor<T> predictor) {
        for (T item : col) {
            if (!predictor.predict(item)) {
                return false;
            }
        }
        return true;
    }

    public static <T> T findFirst(Iterable<T> col, Predictor<T> predictor) {
        for (T item : col) {
            if (predictor.predict(item)) {
                return item;
            }
        }
        return null;
    }

    public static <T> T findFirst(T[] col, Predictor<T> predictor) {
        for (T item : col) {
            if (predictor.predict(item)) {
                return item;
            }
        }
        return null;
    }

    public static <T, E extends Collection<T>> E filter(Collection<T> col, Predictor<T> predictor, E container) {
        for (T item : col) {
            if (predictor.predict(item)) {
                container.add(item);
            }
        }
        return container;
    }

    public static <E extends Collection<T>, T> E filter(E col, Predictor<T> predictor) {
        E container = null;
        try {
             container = (E) col.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return filter(col, predictor, container);
    }

    public static <T1, T2, E extends Collection<T2>> E map(Collection<T1> col, Mapper<T1, T2> mapper, E container) {
        for (T1 item : col) {
            container.add(mapper.map(item));
        }
        return container;
    }

    public static <T1, T2, E extends Collection<T2>> E map(Collection<T1> col, Mapper<T1, T2> mapper) {
        E container = null;
        try {
            container = (E) col.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map(col, mapper, container);
    }

    public static <T1, T2, E extends Collection<T2>> E map(T1[] col, Mapper<T1, T2> mapper, E container) {
        for (T1 item : col) {
            container.add(mapper.map(item));
        }
        return container;
    }

    public static <T1, T2> T2[] map(T1[] col, Mapper<T1, T2> mapper, T2[] container) {
        for (int i = 0; i < col.length; i++) {
            container[i] = mapper.map(col[i]);
        }
        return container;
    }

    public interface Predictor<T> {
        boolean predict(T item);
    }

    public interface Mapper<T1, T2> {
        T2 map(T1 item);
    }

}
