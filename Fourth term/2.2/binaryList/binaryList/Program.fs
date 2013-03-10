open System
let binaryList n : list<float> =
    let list = [for i in 1.0 .. 5.0 -> 2.0**(n+i)]
    list
let printList (a : list<float>)  = 
    List.iter (fun x -> printf "%A " x) a
let printBinaryList n = 
    printList(binaryList n)
    
Console.WriteLine("Write number for the first power")
let x : float = float (Console.Read()) - 48.0
Console.ReadLine()
printBinaryList(x)
Console.Read()

