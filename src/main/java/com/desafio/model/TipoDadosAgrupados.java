package com.desafio.model;

public enum TipoDadosAgrupados {

    DISTRIBUIDORA{
        @Override
        public DadosAgrupados obterTipoDadosAgrupados() {
            return new DadosAgrupadosDistribuidora();
        }
    },
    DATA_COLETA{
        @Override
        public DadosAgrupados obterTipoDadosAgrupados() {
            return new DadosAgrupadosDataColeta();
        }
    };

    public abstract DadosAgrupados obterTipoDadosAgrupados();

}
