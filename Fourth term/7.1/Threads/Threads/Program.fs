open System

let mutable result = 0
let array = Array.init 1000000 (fun x -> 1)
let isWorkerFinished = Array.init 100 (fun x -> false)

for i = 0 to 99 do      
    let worker = new System.ComponentModel.BackgroundWorker()
    worker.DoWork.Add(fun args -> for j = 0 to 9999 do result <- result + array.[i * 10000 + j])
    worker.RunWorkerCompleted.Add(fun args -> isWorkerFinished.[i] <- true)
    worker.RunWorkerAsync()

while not (Array.forall (fun b -> b = true) isWorkerFinished) do ()
    
Console.Write(result)
Console.ReadLine() |> ignore