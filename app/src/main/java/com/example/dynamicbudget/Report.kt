package com.example.dynamicbudget

data class Report (
    public var expensesCount : Int = 0,
    public var expensesTotal: Float = 0.00F,
    public var grossPay: Float = 0.00F,
    public var takeHomePay: Float = 0.00F,
    public var leftOverPay: Float = 0.00F,
    public var investment: Float = 0.00F,

    public val investmentPercentCut: Float = .15F,


        )