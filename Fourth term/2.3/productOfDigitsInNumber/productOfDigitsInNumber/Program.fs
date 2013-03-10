open System
let rec productOfDigits n : int = 
    if n >= 10 then
        (productOfDigits (n / 10)) * (n % 10)
    else
        n

Console.Write("Enter number: ");
let num = int(Console.ReadLine()) 
Console.Write("Product of digits = ")
Console.Write(productOfDigits num)
Console.Read()
        


