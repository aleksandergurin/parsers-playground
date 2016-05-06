package com.example

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker


fun main(args: Array<String>) {
    val lexer = ArithmeticLexer(ANTLRInputStream("x = 2 * (3 + 4)"))
    val parser = ArithmeticParser(CommonTokenStream(lexer))
    val walker = ParseTreeWalker()

    walker.walk(
            object : ArithmeticBaseListener() {
                override fun enterExpression(ctx: ArithmeticParser.ExpressionContext) {
                    println("$ctx text: ${ctx.text}")
                }
            },
            parser.equation()
    )

    //    println("${SyntaxChecker.parse(System.`in`)}")
}
