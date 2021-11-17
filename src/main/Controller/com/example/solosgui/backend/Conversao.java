package com.example.solosgui.backend;

public interface Conversao<T, R> {

    public R converte(T valor);
}
