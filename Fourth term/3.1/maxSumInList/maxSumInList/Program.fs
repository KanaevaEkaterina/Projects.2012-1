open System

let rec sumOfElementsInList (list: List<int>) sum index : int = 
    match list with
    | lst when lst.Length <= 2 -> index
    | head::second::tail -> 
                            let newSum =   if (head + tail.Head > sum) 
                                            then
                                                head + tail.Head
                                            else 
                                                sum
                            let index = if (head + tail.Head > sum)
                                            then
                                                if (index = 0)
                                                    then
                                                        index + 2
                                                    else
                                                        index + 1
                                            else
                                                index
                            sumOfElementsInList list.Tail newSum index 

let printList (a : list<int>)  = 
    List.iter (fun x -> printf "%A " x) a

let list = [2; 5; 3; 6; 1]

let maxIndex = sumOfElementsInList list 0 0

Console.Write("Element with maximum sum of neighbours in list ")
printList(list)
Console.Write(" is on position ")
Console.WriteLine(maxIndex)
Console.Read() |> ignore
