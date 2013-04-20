open System

let rec repetetiveElements (list : List<int>) exist = 
    match list with
    | [] -> exist
    | head::tail -> 
                    let exist =  if (List.exists (fun elem -> elem = list.Head) list.Tail) 
                                    then 
                                        true
                                    else 
                                        exist
                    repetetiveElements list.Tail exist

let no boolean = 
    if boolean then false
    else true
      
let listExample = [1; 3; 5; 2; 6];
let noRepetetiveElementsInList list = no <| repetetiveElements list false
Console.Write(noRepetetiveElementsInList listExample)
Console.Read() |> ignore