module FSAdvent.Y2022.Day3
open System
open FSAdvent.Core
open FSAdvent.Core.Extensions

let isCommon (rucksacks:seq<string>) (c:char) =
    rucksacks |> Seq.every (fun s -> s.Contains(c))

let commonChar (rucksacks:seq<string>) =
    Seq.head(rucksacks).ToCharArray()
    |> Seq.find(isCommon(Seq.tail rucksacks))

let charScore (c:char) =
    c.Ascii - (if c.IsUpperCase then 38 else 96)
let rucksackScore = commonChar >> charScore
let splitRucksack (s:string) = s.SplitAt(s.Length / 2)

let scoreRucksacks partitionRucksacks (n:string) =
    n.Lines
    |> Seq.remove String.IsNullOrWhiteSpace
    |> partitionRucksacks
    |> Seq.sumBy rucksackScore

let part1 = scoreRucksacks (Seq.map splitRucksack)
let part2 = scoreRucksacks (Seq.toChunks 3)
