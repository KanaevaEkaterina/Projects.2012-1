open System
let listConversion (l:list<int>) : list<int> = 
    let l2 = [for i in 0 .. l.Length-1 -> l.Item(l.Length-1-i)]
    l2
let printList (a : list<int>)  = 
    List.iter (fun x -> printf "%A " x) a
let list1 = [1; 2; 3; 4; 5]

Console.WriteLine("List: ")
printList(list1)
Console.WriteLine();
Console.WriteLine("List after conversion: ")
printList(listConversion(list1))
Console.Read()

