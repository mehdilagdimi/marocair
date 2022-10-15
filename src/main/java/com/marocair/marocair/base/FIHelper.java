package com.marocair.marocair.base;

import com.marocair.marocair.model.Client;


import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.stream.IntStream;

public abstract class FIHelper {


    public static<T, T2> T[] getFromModel (T2 model, ModelGetFI[] arrOfLamdas, Class<T> impl) {
//        Constructor<? extends T> classConstructor = impl.getConstructor();
        T[] data = (T[]) Array.newInstance(impl, arrOfLamdas.length);

//        Object[] data =  new Object[arrOfLamdas.length];
        IntStream.range(0, arrOfLamdas.length).forEachOrdered((i) -> data[i] = (T)arrOfLamdas[i].run(model));

        return data;
    }

    public static<T, T2> void setIntoModel (T2 model, ModelSetFI[] arrOfLamdas, T...data){
        IntStream.range(0, arrOfLamdas.length).forEachOrdered(
                i -> arrOfLamdas[i].run(model, data[i])
        );
    }
}
