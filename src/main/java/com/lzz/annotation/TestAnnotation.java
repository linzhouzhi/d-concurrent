package com.lzz.annotation;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by lzz on 2018/4/20.
 */
public class TestAnnotation {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) throws NoSuchFieldException {
        Parent c = new Child();
        List<SortableField> list = c.init();//获取泛型中类里面的注解
        //输出结果
        for(SortableField l : list){
            System.out.println("字段名称："+l.getName()+"\t字段类型："+l.getType()+
                    "\t注解名称："+l.getMeta().name()+"\t注解描述："+l.getMeta().description());
        }

        Class claz = Anno.class;
        Field[]  fieldsDecrs=claz.getDeclaredFields();
        for(Field field:fieldsDecrs){
            System.out.println( field.getName() );
            FieldMeta meta = field.getAnnotation(FieldMeta.class);
            System.out.println( meta.name() );

        }

        Field fieldP = claz.getDeclaredField("name");
        FieldMeta meta = fieldP.getAnnotation(FieldMeta.class);
        System.out.println( meta.name());

    }
}
