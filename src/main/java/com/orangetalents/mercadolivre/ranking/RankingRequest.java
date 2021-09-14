package com.orangetalents.mercadolivre.ranking;

import com.orangetalents.mercadolivre.comms.anotations.ExistisId;
import com.orangetalents.mercadolivre.compra.Compra;
import com.orangetalents.mercadolivre.usuario.Usuario;

public class RankingRequest {

    @ExistisId(classe = Compra.class, acceptedNull = false)
    private Long idCompra;

    @ExistisId(classe = Usuario.class, acceptedNull = false)
    private Long idVendedor;

    public RankingRequest(Long idCompra, Long idVendedor) {
        this.idCompra = idCompra;
        this.idVendedor = idVendedor;
    }

    @Override
    public String toString() {
        return "RankingRequest{" +
                "idCompra=" + idCompra +
                ", idVendedor=" + idVendedor +
                '}';
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }
}
