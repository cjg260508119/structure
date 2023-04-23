package com.pinan.list;

import java.util.Arrays;

/**
 * @ClassName:ArrayList
 * @Auther: 26050
 * @Description:
 * @Date: 2023/4/20 22:28
 * @Version: v1.0
 */
public class ArrayList<T> {

    /**
     * 默认大小
     */
    public static final int DEFAULT_SIZE = 10;

    /**
     * 存储元素
     */
    Object[] elements = new Object[DEFAULT_SIZE];

    /**
     * 数组大小
     */
    int size;

    public ArrayList(){

    }

    public ArrayList(int length){
        elements = new Object[length];
    }

    public static void main(String[] args){
        /*ArrayList<String> arry = new ArrayList<>();
        for(int i=0; i<11; i++){
            arry.add(new String(i + ""));
        }
        for(int i=0; i<11; i++){
            System.out.println(arry.get(i));
        }*/
    }

    public void add(T t){
        ensureCapacity();
        elements[size] = t;
        size = size + 1;
    }

    public void add(T t, int idx){
        ensureCapacity();
        //从idx之后的元素全部往后移动
        System.arraycopy(elements, idx, elements, idx+1, size-idx);
    }

    public T get(int idx){
        if(idx < 0 || idx >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) elements[idx];
    }

    public void ensureCapacity(){
        if(size  >= elements.length){
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
    }


}
