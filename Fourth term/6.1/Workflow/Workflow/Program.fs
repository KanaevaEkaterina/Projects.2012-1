open System

type Builder(prec: int) =
    
    member this.Bind((x: float), (rest: float -> float)) =
        rest (Math.Round(x, prec)) 
                       
    member this.Return(x: float) =
        Math.Round(x, prec)

let rounding prec = Builder(prec)
let prec = 3
let result =     
    rounding prec {
        let! a = 2.0 / 12.0
        let b = 3.5
        return (a / b)
    }

Console.Write("Result with precision " + prec.ToString() + " is " + result.ToString())
Console.Read()|>ignore