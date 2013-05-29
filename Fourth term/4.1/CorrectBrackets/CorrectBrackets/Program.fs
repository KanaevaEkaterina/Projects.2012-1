open System

let boolToInt flag : int =
    if flag then
        1
    else
        0

let intToBool num: bool = 
    if (num = 1) then
        true
    else
        false

let no boolean = 
    if boolean then false
    else true

let rec correctBracketsInList (list : List<char>) (stack : List<char>) (flag : bool): bool =
    match list with
    | [] -> if (stack.Length = 0) then
                flag
            else
                false
    | head::tail ->   
                    let bracket = list.Head
                    let intFlag =   if (bracket.Equals '{' || bracket.Equals '[' || bracket.Equals '(') then
                                        boolToInt(flag)
                                    elif (no(stack.Length = 0)) then
                                        if (bracket.Equals '}') then
                                            if (no (stack.Head.Equals '{')) then
                                                0
                                            else
                                                boolToInt(flag)
                                        elif (bracket.Equals ']') then
                                            if (no (stack.Head.Equals '[')) then
                                               0
                                            else
                                                boolToInt(flag)
                                        else 
                                            if (no (stack.Head.Equals '(')) then
                                                0
                                            else
                                                boolToInt(flag)
                                    else 0

                    let stack = if (bracket.Equals '{' || bracket.Equals '[' || bracket.Equals '(') then
                                    bracket::stack
                                elif (no(stack.Length = 0)) then
                                    if (bracket.Equals '}') then
                                        if (no (stack.Head.Equals '{')) then
                                            stack
                                        else
                                            stack.Tail
                                    elif (bracket.Equals ']') then
                                        if (no (stack.Head.Equals '[')) then
                                           stack
                                        else
                                            stack.Tail
                                    else 
                                        if (no (stack.Head.Equals '(')) then
                                            stack
                                        else
                                            stack.Tail
                                else stack

                    correctBracketsInList list.Tail stack <|intToBool(intFlag)
    
let correctBracketsInString str : bool = 
    let list = Seq.toList(str)
    let stack = []
    correctBracketsInList list stack true


Console.WriteLine("Enter sequence of breckets")
let brackets = Console.ReadLine();
Console.WriteLine(correctBracketsInString brackets)
Console.ReadLine() |> ignore


