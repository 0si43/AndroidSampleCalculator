package com.example.androidsamplecalculator

enum class Operator(val symbol: String) {
    PLUS("+") {
        override fun calculate(lhs: Int, rhs: Int): Int {
            return lhs + rhs
        }
    },
    MINUS("-"){
        override fun calculate(lhs: Int, rhs: Int): Int {
            return lhs - rhs
        }
    },
    MULTIPLY("*"){
        override fun calculate(lhs: Int, rhs: Int): Int {
            return lhs * rhs
        }
    },
    DIVIDE("/"){
        override fun calculate(lhs: Int, rhs: Int): Int {
            return lhs / rhs
        }
    };

    abstract fun calculate(lhs: Int, rhs: Int): Int
}