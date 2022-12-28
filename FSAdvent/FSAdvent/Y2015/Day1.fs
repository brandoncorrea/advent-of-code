module FSAdvent.Y2015.Day1
open FSAdvent.Core.Functions

let operationScore operation =
    match operation with
    | '(' -> 1
    | ')' -> -1
    | _ -> 0

let step floor operation =
    floor + operationScore(operation)

let part1 (n:string) =
    n.ToCharArray() |> Seq.fold step 0

let stepIndexed (index, floor) operation =
    (inc index, step floor operation)

let part2 (n:string) =
    n.ToCharArray()
    |> Seq.scan stepIndexed (0, 0)
    |> Seq.find (snd >> isNegative)
    |> fst
