package com.book.library.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.cglib.beans.BeanMap;

import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.stream.Collectors;

public class BeanUtils {

    public static <T> T transform(Object src, Class<T> clazz) {
        if (src == null) {
            return null;
        } else {
            Object instance = null;

            try {
                instance = clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            org.springframework.beans.BeanUtils.copyProperties(src, instance, getNullPropertyNames(src));
            return (T) instance;
        }
    }

    public static void transform(Object src, Object target, Boolean ignoreNull) {
        if (src == null) {
            return;
        } else {
            if (ignoreNull) {
                org.springframework.beans.BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
            } else {
                org.springframework.beans.BeanUtils.copyProperties(src, target);
            }

        }
    }

    private static String[] getNullPropertyNames(Object source) {
        BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = (Set) Arrays.stream(pds).filter((pd) -> {
            return src.getPropertyValue(pd.getName()) == null;
        }).map(FeatureDescriptor::getName).distinct().collect(Collectors.toSet());
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
    }

    public static <T> List<T> batchTransform(Class<T> clazz, List<? extends Object> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        } else {
            List<T> result = new ArrayList<>(list.size());
            Iterator var3 = list.iterator();

            while (var3.hasNext()) {
                Object srcObject = var3.next();
                result.add(transform(srcObject, clazz));
            }
            return result;
        }
    }

    /**
     * ??????????????????map
     *
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                if (beanMap.get(key) instanceof LocalDateTime) {
                    map.put(key.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format((TemporalAccessor) beanMap.get(key)));
                } else {
                    map.put(key.toString(), beanMap.get(key));
                }
            }
        }
        return map;
    }


    /**
     * ???List<T>?????????List<Map<String, Object>>
     *
     * @param objList
     * @return
     */
    public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
        List<Map<String, Object>> list = Lists.newArrayList();
        if (objList != null && objList.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0, size = objList.size(); i < size; i++) {
                bean = objList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }


    /**
     * @param bean: ???????????????bean??????
     * @Description: bean?????????null???""
     */
    public static <T> void nullToEmpty(T bean) {
        Field[] field = bean.getClass().getDeclaredFields();
        //??????????????????
        for (int j = 0; j < field.length; j++) {
            //?????????????????????
            String name = field[j].getName();
            //??????????????????????????????????????????get???set??????
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            //?????????????????????
            String type = field[j].getGenericType().toString();
            //??????type??????????????????????????????"class "??????????????????
            if (type.equals("class java.lang.String")) {
                try {
                    Method mGet = bean.getClass().getMethod("get" + name);
                    //??????getter?????????????????????
                    String value = (String) mGet.invoke(bean);
                    if (value == null || "".equals(value)) {
                        Method mSet = bean.getClass().getMethod("set" + name, new Class[]{String.class});
                        mSet.invoke(bean, new Object[]{new String("")});
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
