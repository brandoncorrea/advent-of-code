﻿module FSAdvent.Y2022.Day1
open FSAdvent.Core
open FSAdvent.Core.Extensions
open FSAdvent.Core.Functions

let intOrDefault s =
    try toi s
    with _ -> 0

let elfToCalories (s:string) =
    s.Lines |> Seq.sumBy intOrDefault

let topElfCalories n (s:string) =
    s.Split "\n\n"
    |> Seq.map elfToCalories
    |> Seq.sortDescending
    |> Seq.truncate n
    |> Seq.sum

let part1 = topElfCalories 1
let part2 = topElfCalories 3
