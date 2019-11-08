package com.advance.academy.adventure.books.system.repository;


public interface GetReference {
    public <T> T getReference(Class<T> tClass, Integer id);
}
