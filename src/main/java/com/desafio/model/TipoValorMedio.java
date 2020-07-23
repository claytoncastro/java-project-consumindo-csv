package com.desafio.model;

public enum TipoValorMedio {

    MUNICIPIO{
        @Override
        public ValorMedio obterValorMedio() {
            return new ValorMedioCompraVendaMunicipio();
        }
    },
    BANDEIRA{
        @Override
        public ValorMedio obterValorMedio() {
            return new ValorMedioCompraVendaBandeira();
        }
    };

    public abstract ValorMedio obterValorMedio();

}
