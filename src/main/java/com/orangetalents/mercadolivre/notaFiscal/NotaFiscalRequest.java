package com.orangetalents.mercadolivre.notaFiscal;

import com.orangetalents.mercadolivre.comms.anotations.ExistisId;
import com.orangetalents.mercadolivre.compra.Compra;
import com.orangetalents.mercadolivre.usuario.Usuario;

public class NotaFiscalRequest {

    @ExistisId(classe = Compra.class, acceptedNull = false)
    private Long idCompra;

    @ExistisId(classe = Usuario.class, acceptedNull = false)
    private Long idUsuario;

    public NotaFiscalRequest(Long idCompra, Long idUsuario) {
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "NotaFiscalRequest{" +
                "idCompra=" + idCompra +
                ", idUsuario=" + idUsuario +
                '}';
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }
}
