package com.lanyan.util;

public class ArrayUtils{
    public static boolean hasSize(Object o){
        if(ObjectUtils.isNotNull(o)&& o.getClass().isArray()){
            if(o instanceof int[]){
                int[] array= (int[])o;
                return array.length> 0;
            }
            else if(o instanceof Long[]){
                long[] array= (long[])o;
                return array.length> 0;
            }
            else if(o instanceof short[]){
                short[] array= (short[])o;
                return array.length> 0;
            }
            else if(o instanceof float[]){
                float[] array= (float[])o;
                return array.length> 0;
            }
            else if(o instanceof double[]){
                double[] array= (double[])o;
                return array.length> 0;
            }
            else if(o instanceof byte[]){
                byte[] array= (byte[])o;
                return array.length> 0;
            }
            else{
                Object[] array= (Object[])o;
                return array.length> 0;
            }
        }
        return false;
    }
}
