module FSAdvent.Y2015.Day2
open System
open FSAdvent.Core
open FSAdvent.Core.Functions
open FSAdvent.Core.Extensions

let sidesOf (box:string) =
    box.Split("x")
    |> Seq.map toi
    |> Seq.cycle
    |> Seq.pairwise
    |> Seq.take 3
    |> Seq.map multiply

let paperFor box =
    let sides = sidesOf(box)
    2 * (Seq.sum sides) + Seq.reduce min sides

let part1 (dimensions:string) =
    dimensions.Lines
    |> Seq.remove String.IsNullOrWhiteSpace
    |> Seq.sumBy paperFor
