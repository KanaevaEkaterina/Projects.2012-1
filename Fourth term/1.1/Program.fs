open System
 
let rec factorial n =
    if n < 1 then 1
    else n * factorial (n - 1)
     
Console.WriteLine("Write number")
let x : int = int (Console.Read()) - 48
Console.ReadLine()
Console.Write(factorial x)
Console.Read()

