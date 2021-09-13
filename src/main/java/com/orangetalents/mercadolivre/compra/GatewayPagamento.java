package com.orangetalents.mercadolivre.compra;

public enum GatewayPagamento {
    PAGSEGURO{
        @Override
        String url(Long id) {
            return "pagseguro.com?returnId="+ id.toString()+"&redirectUrl=http://localhost:8080/pag-seguro";
        }
    },
    PAYPAL{
        @Override
        String url(Long id) {
            return "paypal.com?buyerId="+ id.toString()+"&redirectUrl=http://localhost:8080/pag-seguro";
        }
    };

    abstract String url(Long id);

}
