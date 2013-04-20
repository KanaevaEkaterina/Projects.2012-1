open System

let listConversion (l:list<char>) : list<char> = 
    let l2 = [for i in 0 .. l.Length-1 -> l.Item(l.Length-1-i)]
    l2

let palindrome (str:string): bool =
    let list = Seq.toList(str)
    if (listConversion(list) = list) then true
    else false

Console.WriteLine("Hello")
Console.WriteLine(palindrome("Hello"))
Console.WriteLine("level")
Console.WriteLine(palindrome("level"))
Console.Read()|> ignore

