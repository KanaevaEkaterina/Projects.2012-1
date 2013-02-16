open System

let rec fibNum f =
    if f <= 2 then 1
    else fibNum (f - 1) + fibNum (f - 2)

Console.WriteLine("Write number")
let x : int = int (Console.Read()) - 48
Console.ReadLine()
Console.Write(fibNum x)
Console.Read()

