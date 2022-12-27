module FSAdventTest.TestData
open System.IO

let readDateFile folder (year:int) (day:int) =
    $"../../../../../{folder}/{year}/day_{day:D2}.txt"
    |> File.ReadAllText

let sample = readDateFile "sample"
let input = readDateFile "input"
