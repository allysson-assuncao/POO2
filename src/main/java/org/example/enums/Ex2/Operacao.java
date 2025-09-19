package org.example.enums.Ex2;

public enum Operacao {
    SOMA {
        @Override
        public double executar(double a, double b) {
            return a + b;
        }
    },
    SUBTRACAO {
        @Override
        public double executar(double a, double b) {
            return a - b;
        }
    },
    MULTIPLICACAO {
        @Override
        public double executar(double a, double b) {
            return a * b;
        }
    },
    DIVISAO {
        @Override
        public double executar(double a, double b) {
            return a / b;
        }
    };

    public abstract double executar(double a, double b);
}
