module FSAdvent.Y2022.Day1
open System

let intOrDefault s =
    try Int32.Parse s
    with _ -> 0
    
let elfToCalories (s:string) =
    s.Split "\n"
    |> Seq.map intOrDefault
    |> Seq.sum

let topElfCalories (n:int) (s:string) =
    s.Split "\n\n"
    |> Seq.map elfToCalories
    |> Seq.sortDescending
    |> Seq.truncate n
    |> Seq.sum

let part1 = topElfCalories 1
let part2 = topElfCalories 3
