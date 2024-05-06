package io.github.igomarcelino.clientes.dominio.enums;

public enum TipoSexo {
    M("masculino"),
    F("feminino"),
    O("outros");

    private final String tipoSexo;
    TipoSexo(String tipoSexo) {

        this.tipoSexo = tipoSexo;
    }

    public String getTipoSexo() {
        return tipoSexo;
    }
}
