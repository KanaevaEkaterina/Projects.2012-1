open System

let isEven num = 
    num % 2 = 0
    
let rec counter list num i = 
    match list with
    | head::tail -> if head = num then 
                        counter tail num i+1
                    else
                        counter tail num i
    | [] -> i

let PlusIfEven acc num = 
    if (isEven num) then
        acc + 1
    else
        acc

let NumberOfEvenWithFilter (list: list<int>) = 
    let onlyEvenList = List.filter (isEven) list
    onlyEvenList.Length

let NumberOfEvenWithMap (list: list<int>) = 
    let identifyEvenList = List.map (fun i -> isEven i) list
    counter identifyEvenList true 0

let NumberOfEvenWithFold (list: list<int>) = 
    List.fold (fun acc x -> PlusIfEven acc x) 0 list
    
 