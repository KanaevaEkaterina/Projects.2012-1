open System
open Microsoft.FSharp.Core.Operators

let searchElem (l:list<int>, elem:int): int = 
    let mutable flag = true
    let mutable index = 0;
    while flag && (index < l.Length) do
        if l.Item(index) = elem then flag <- false
        else index <- index + 1
    index + 1

let printList (a : list<int>)  = 
    List.iter (fun x -> printf "%A " x) a

let list1 = [1; 4; 2; 5; 7]

Console.Write("List: ")
printList list1
Console.WriteLine()
Console.Write("Write element for searching: ")
let element = int(Console.ReadLine()) - 48
let result = searchElem (list1, element)
Console.Write("Position of this element is ");
Console.Write(result);
Console.Read()

