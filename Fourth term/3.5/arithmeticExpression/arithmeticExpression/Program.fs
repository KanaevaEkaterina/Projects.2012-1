open System

type Expression =
    | Plus of Expression * Expression
    | Minus of Expression * Expression
    | Multiplication of Expression * Expression
    | Devision of Expression * Expression
    | Const of float

let rec calculate (expr: Expression) : float =
    match expr with
    | Plus(expr1, expr2) -> calculate expr1 + calculate expr2
    | Minus(expr1, expr2) -> calculate expr1 - calculate expr2
    | Multiplication(expr1, expr2) -> calculate expr1 * calculate expr2
    | Devision(expr1, expr2) -> calculate expr1 / calculate expr2
    | Const(num) -> num

let expr =  Plus(Multiplication(Const(3.0), Const(4.0)), Minus(Const(5.0), Devision(Const(6.0), Const(3.0))))

let rec expressionInString (expr: Expression) : string = 
    match expr with
    | Plus(expr1, expr2) -> expressionInString expr1 + "+" + expressionInString expr2
    | Minus(expr1, expr2) -> expressionInString expr1 + "-" + expressionInString expr2
    | Multiplication(expr1, expr2) -> expressionInString expr1 + "*" + expressionInString expr2
    | Devision(expr1, expr2) -> expressionInString expr1 + "/" + expressionInString expr2
    | Const(num) -> Convert.ToString(num)

Console.WriteLine("Expression:")
Console.Write(expressionInString expr)
Console.Write("=")
Console.Write(Convert.ToString(calculate expr))
Console.Read() |> ignore