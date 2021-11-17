package com.example.solosgui.util.exceptions;

public class InvalidEntryException extends Exception{
    public InvalidEntryException(){
        super("Entrada nao encontrada nos dados do programa");
    }
}
