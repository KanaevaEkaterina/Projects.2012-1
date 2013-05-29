open System.IO
open System

let add (name : string) (number: string) (book: list<string * string>) = 
    let newPair = name, number
    newPair::book

let rec searchByName (newName: string) (book: list<string * string>) : string = 
    match book with
    | head::tail -> match head with
                    | (name, number) when name = newName -> number
                    | _ -> searchByName newName tail
    | [] -> "No such name in the telephone book"

let rec searchByNumber (newNumber: string) (book: list<string * string>) : string = 
    match book with
    | head::tail -> match head with
                    | (name, number) when number = newNumber -> name
                    | _ -> searchByNumber newNumber tail
    | [] -> "No such number in the telephone book"

let rec saveToFile (book: list<string * string>) (file: StreamWriter) =
    match book with
    | head::tail -> match head with
                    | (name, number) -> file.WriteLine(name + " - " + number)

let separate (line: string) : string * string = 
    let first = line.Substring(0, line.IndexOf('-'))
    let second = line.Substring(line.IndexOf('-')+1, 7)
    (first, second)

let rec loadFromFile (fileName: string): list<string * string> =
   let file = new StreamReader(fileName)
   let seqOfLines = seq { while not file.EndOfStream do yield file.ReadLine() }
   let listOfLines = List.ofSeq seqOfLines
   let phoneList : list<string * string> = List.map(fun i -> separate i) listOfLines
   phoneList


let telephoneNumbers = [];
let fileName = "telephoneNumbers"
let file = new StreamWriter(fileName)

let rec run flag telephoneNumbers file = 
    if flag then
        Console.Write("Enter number: ")
        let num = Console.ReadLine()
        match num with
        |"0" -> run false telephoneNumbers file
        |"1" -> Console.Write("Enter name: ")
                let name = Console.ReadLine()
                Console.Write("Enter number (7 chars): ")
                let number = Console.ReadLine()
                let telephoneNumbers = add name number telephoneNumbers
                ()
                run true telephoneNumbers file
        |"2" -> Console.Write("Enter name: ")
                let name = Console.ReadLine()
                Console.WriteLine(searchByName name telephoneNumbers)
                run true telephoneNumbers file
        |"3" -> Console.Write("Enter number: ")
                let number = Console.ReadLine()
                Console.WriteLine(searchByNumber number telephoneNumbers)
                run true telephoneNumbers file
        |"4" -> saveToFile telephoneNumbers file
                Console.WriteLine("Saved to file " + fileName)
                run true telephoneNumbers file
        |"5" -> Console.Write("Enter name of the file ")
                let existFileName = Console.ReadLine()
                let telephoneNumbers = loadFromFile existFileName
                ()
                run true telephoneNumbers file
    else Console.Write("Exit")

run true telephoneNumbers file