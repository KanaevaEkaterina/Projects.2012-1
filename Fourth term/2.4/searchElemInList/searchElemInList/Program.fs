open System
open Microsoft.FSharp.Core.Operators

let rec searchElem (l:list<int>) elem pos bool : int = 
    match l with
    | head::tail -> if bool then
                       pos
                    else searchElem tail elem pos+1 bool 

let printList (a : list<int>)  = 
    List.iter (fun x -> printf "%A " x) a

let list1 = [1; 4; 2; 5; 7]

Console.Write("List: ")
printList list1
Console.WriteLine()
Console.Write("Write element for searching: ")
let element = int(Console.ReadLine()) - 48
let result = searchElem list1 element 0 false
Console.Write("Position of this element is ");
Console.Write(result)
Console.Read() |> ignore

