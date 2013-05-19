type Tree =
    | Tree of int*Tree*Tree
    | Node of int 

let rec mapForTree (tree: Tree) (func: int->int) : Tree = 
    match tree with
    | Tree(node, l, r) ->   let newTree = Tree(func node, mapForTree l func, mapForTree r func) 
                            newTree
    | Node(node) -> let newNode = Node(func node)
                    newNode

let tree = Tree(5, Node(3), Tree(7, Node(6), Node(9)))
let inc x = x + 1
let newTree = mapForTree tree inc 