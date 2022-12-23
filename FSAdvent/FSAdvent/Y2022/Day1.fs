namespace FSAdvent.Y2022

open System

module Day1 =

    let intOrDefault (s:string) =
        match Int32.TryParse s with
            | _, i -> i
            | _ -> 0

    let elfToCalories (s:string) =
        s.Split("\n")
        |> Seq.map intOrDefault
        |> Seq.sum

    let topElfCalories (n:int) (s:string) =
        s.Split("\n\n")
        |> Seq.map elfToCalories
        |> Seq.sortDescending
        |> Seq.truncate n
        |> Seq.sum

    let part1 = topElfCalories 1
    let part2 = topElfCalories 3
