open System

type Expression = 
    | Plus of Expression * Expression
    | Minus of Expression * Expression
    | Multiplication of Expression * Expression
    | Division of Expression * Expression
    | Const of int
    | Variable of char

let rec derivativeOfExpr (expr: Expression) =
    match expr with
    | Plus(expr1, expr2) -> Plus(derivativeOfExpr(expr1), derivativeOfExpr(expr2))
    | Minus(expr1, expr2) -> Minus(derivativeOfExpr(expr1), derivativeOfExpr(expr2))
    | Multiplication(expr1, expr2) -> Plus(Multiplication(derivativeOfExpr(expr1), expr2), Multiplication(derivativeOfExpr(expr2),expr1))
    | Division(expr1, expr2) -> Division(Plus(Multiplication(derivativeOfExpr(expr1), expr2),Multiplication(derivativeOfExpr(expr2), expr1)), Multiplication(expr2, expr2))
    | Const(num) -> Const(0)
    | Variable(var) -> Const(1)

let rec expressionInString (expr: Expression) : string = 
    match expr with
    | Plus(expr1, expr2) -> "(" + expressionInString expr1 + "+" + expressionInString expr2 + ")"
    | Minus(expr1, expr2) -> "(" + expressionInString expr1 + "-" + expressionInString expr2 + ")"
    | Multiplication(expr1, expr2) -> expressionInString expr1 + "*" + expressionInString expr2
    | Division(expr1, expr2) -> expressionInString expr1 + "/" + expressionInString expr2
    | Const(num) -> Convert.ToString(num)
    | Variable(var) -> Convert.ToString(var)

let rec multiplicationSimplification (expr: Expression) =
    match expr with
    | Multiplication(expr1, Const(1)) | Multiplication(Const(1), expr1) -> multiplicationSimplification expr1
    | Multiplication(expr1, Const(0)) | Multiplication(Const(0), expr1) -> Const(0)
    | Plus(expr1, expr2) -> Plus(multiplicationSimplification(expr1), multiplicationSimplification(expr2))
    | Minus(expr1, expr2) -> Minus(multiplicationSimplification(expr1), multiplicationSimplification(expr2))
    | Multiplication(expr1, expr2) -> Multiplication(multiplicationSimplification(expr1), multiplicationSimplification(expr2))
    | Division(expr1, expr2) -> Division(multiplicationSimplification(expr1), multiplicationSimplification(expr2))
    | Const(num) -> Const(num)
    | Variable(var) -> Variable(var)

let rec divisionSimplification (expr: Expression) =
    match expr with
    | Division(expr1, Const(1)) -> divisionSimplification expr1
    | Plus(expr1, expr2) -> Plus(divisionSimplification(expr1), divisionSimplification(expr2))
    | Minus(expr1, expr2) -> Minus(divisionSimplification(expr1), divisionSimplification(expr2))
    | Multiplication(expr1, expr2) -> Multiplication(divisionSimplification(expr1), divisionSimplification(expr2))
    | Division(expr1, expr2) -> Division(divisionSimplification(expr1), divisionSimplification(expr2))
    | Const(num) -> Const(num)
    | Variable(var) -> Variable(var)

let rec plusSimplification (expr: Expression) = 
    match expr with
    | Plus(expr1, Const(0)) | Plus(Const(0), expr1) -> plusSimplification expr1
    | Plus(expr1, expr2) -> Plus(plusSimplification(expr1), plusSimplification(expr2))
    | Minus(expr1, expr2) -> Minus(plusSimplification(expr1), plusSimplification(expr2))
    | Multiplication(expr1, expr2) -> Multiplication(plusSimplification(expr1), plusSimplification(expr2))
    | Division(expr1, expr2) -> Division(plusSimplification(expr1), plusSimplification(expr2))
    | Const(num) -> Const(num)
    | Variable(var) -> Variable(var)

let simplificationOfExpression (expr: Expression) =
    divisionSimplification << multiplicationSimplification <| plusSimplification expr 

let expr = Multiplication(Plus(Variable('x'), Const(2)), Variable('x'))
Console.Write("Expression: ")
Console.WriteLine(expressionInString expr)
Console.Write("Derivative: ")
Console.WriteLine(expressionInString <| derivativeOfExpr expr)
Console.Write("Derivative after simplification: ")
let simpleExpr = simplificationOfExpression <| derivativeOfExpr expr
Console.Write(expressionInString << simplificationOfExpression <| derivativeOfExpr expr)
Console.Read() |> ignore
