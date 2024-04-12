package com.victor.HelpDesk.domain.enums;

@SuppressWarnings({"unused", "UnnecessaryModifier"})
public enum Prioridade {

    BAIXA (0, "BAIXA"), MEDIA (1, "MEDIA"), ALTA (2, "ALTA");

    private final int codigo;
    private final String descricao;

    private Prioridade(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer cod) throws IllegalAccessException {
        if(cod == null) {
            return null;
        }
        for (Prioridade x: Prioridade.values()){
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalAccessException("Prioridade inválida");
    }
}


