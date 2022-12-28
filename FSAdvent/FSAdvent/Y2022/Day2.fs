module FSAdvent.Y2022.Day2
open FSAdvent.Core.Extensions

let part1Scores =
    ["A X", 4;
     "A Y", 8;
     "A Z", 3;
     "B X", 1;
     "B Y", 5;
     "B Z", 9;
     "C X", 7;
     "C Y", 2;
     "C Z", 6]
    |> Map.ofList

let part2Scores =
    ["A X", 3;
     "A Y", 4;
     "A Z", 8;
     "B X", 1;
     "B Y", 5;
     "B Z", 9;
     "C X", 2;
     "C Y", 6;
     "C Z", 7]
    |> Map.ofList

let rpcScore (scores:Map<string, int>) (s:string) =
    s.Lines
    |> Seq.choose scores.TryFind
    |> Seq.sum

let part1 = rpcScore part1Scores
let part2 = rpcScore part2Scores
