open System

let rec searchElem (l:list<int>) elem pos (flag: bool) : int = 
    match l with
    | head::tail -> if flag then
                       pos
                    else 
                        let flag = 
                                    if (head = elem) then
                                        true
                                    else
                                        false
                        let pos = pos + 1
                        searchElem tail elem pos flag 
    | [] -> if flag then 
                pos
            else
                0
        

let printList (a : list<int>)  = 
    List.iter (fun x -> printf "%A " x) a

let list1 = [1; 4; 2; 5; 7]

Console.Write("List: ")
printList list1
Console.WriteLine()
Console.Write("Write element for searching: ")
let element = Console.Read()-48
let result = searchElem list1 element 0 false
Console.Write("Position of this element is ");
Console.WriteLine(result)
Console.ReadLine() |> ignore
