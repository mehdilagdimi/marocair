package com.marocair.marocair.base;

@FunctionalInterface
public interface ModelSetFI<T1, T2> {
    void run (T1 model, T2 data);
}
