package com.example.solosgui.backend.model;

public interface Conversao<T, R> {

    public R converte(T valor);
}
