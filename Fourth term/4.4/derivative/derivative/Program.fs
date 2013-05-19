open System

type Expression = 
    | Plus of Expression * Expression
    | Minus of Expression * Expression
    | Multiplication of Expression * Expression
    | Devision of Expression * Expression
    | Const of int
    | Variable of char

let rec derivativeOfExpr (expr: Expression) =
    match expr with
    | Plus(expr1, expr2) -> Plus(derivativeOfExpr(expr1), derivativeOfExpr(expr2))
    | Minus(expr1, expr2) -> Minus(derivativeOfExpr(expr1), derivativeOfExpr(expr2))
    | Multiplication(expr1, expr2) -> Plus(Multiplication(derivativeOfExpr(expr1), expr2), Multiplication(derivativeOfExpr(expr2),expr1))
    | Devision(expr1, expr2) -> Devision(Plus(Multiplication(derivativeOfExpr(expr1), expr2),Multiplication(derivativeOfExpr(expr2), expr1)), Multiplication(expr2, expr2))
    | Const(num) -> Const(0)
    | Variable(var) -> Const(1)

let rec expressionInString (expr: Expression) : string = 
    match expr with
    | Plus(expr1, expr2) -> "(" + expressionInString expr1 + "+" + expressionInString expr2 + ")"
    | Minus(expr1, expr2) -> "(" + expressionInString expr1 + "-" + expressionInString expr2 + ")"
    | Multiplication(expr1, expr2) -> expressionInString expr1 + "*" + expressionInString expr2
    | Devision(expr1, expr2) -> expressionInString expr1 + "/" + expressionInString expr2
    | Const(num) -> Convert.ToString(num)
    | Variable(var) -> Convert.ToString(var)

let expr = Multiplication(Plus(Variable('x'), Const(2)), Variable('x'))
Console.Write("Expression: ")
Console.WriteLine(expressionInString expr)
Console.Write("Derivative: ")
Console.Write(expressionInString <| derivativeOfExpr expr)
Console.Read() |> ignore
