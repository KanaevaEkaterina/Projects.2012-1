open System

let intSqrt x =
    x |> float |> sqrt |> int

let isPrime x = 
    if x < 2 then
        false
    else
        seq { for a in 2 .. intSqrt x do yield a} 
        |> Seq.forall(fun checker -> x % checker <> 0)

let primeSeqWithEmptyPlaces = Seq.initInfinite (fun index -> 
                                                if isPrime index then
                                                    index
                                                else
                                                    0)

let primeSeq = Seq.filter(fun x -> x <> 0) primeSeqWithEmptyPlaces

Console.WriteLine("Enter length of sequence")
let l = Convert.ToInt32(Console.ReadLine())
Seq.iter(printf "%A ") <| Seq.take l primeSeq
Console.Read() |> ignore