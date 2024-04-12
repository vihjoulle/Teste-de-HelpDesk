package com.victor.HelpDesk.domain.enums;

@SuppressWarnings({"unused", "UnnecessaryModifier"})
public enum Status {

    ABERTO (0, "ABERTO"), ANDAMENTO (1, "ANDAMENTO"), ENCERRADO (2, "ENCERRADO");

    private final int codigo;
    private final String descricao;

    private Status(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod) throws IllegalAccessException {
        if(cod == null) {
            return null;
        }
        for (Status x: Status.values()){
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalAccessException("Status inválido");
    }
}


