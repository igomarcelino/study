package io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns;

public enum TipoSexo {
    M("masculino"),
    F("feminino"),
    O("outros");

    private final String descricao;
    TipoSexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
