open System
type Tree = 
    | Tree of int * Tree * Tree
    | Node of int option

let rec treeHeight (tree:Tree) height : int = 
    match tree with
    | Node(_) -> height
    | Tree(_, left, right) ->   if (treeHeight left height) >= (treeHeight right height)
                                    then
                                        treeHeight left height + height
                                    else
                                        treeHeight right height + height

let tree = Tree(5, Tree(4, Node(Some(3)), Node(None)), Tree(7, Node(Some(6)), Tree(9, Node(Some(8)), Tree(11, Node(None), Node(Some(12))))))
let height = treeHeight tree 1
Console.Write(height)
Console.Read() |> ignore
