namespace FSAdvent.Core
open System

module Functions =
    let inc n = n + 1
    let isNegative n = n < 0
    let multiply (a, b) = a * b
    let toi obj = Int32.Parse obj

module Seq =

    let remove pred = Seq.filter (not << pred)
    let every pred coll =
        let defector = Seq.tryFind (not << pred) coll
        defector.IsNone

    let cycle seq =
        let coll = Seq.toArray seq
        Seq.initInfinite (fun i -> coll.[i % coll.Length])

    // Taken from Nathan B Evans: https://gist.github.com/nbevans/9429542
    let toChunks n (s:seq<'t>) = seq {
        let pos = ref 0
        let buffer = Array.zeroCreate<'t> n
    
        for x in s do
            buffer.[!pos] <- x
            if !pos = n - 1 then
                yield buffer |> Array.copy
                pos := 0
            else
                incr pos
    
        if !pos > 0 then
            yield Array.sub buffer 0 !pos
    }

module Extensions =
    type String with
        member this.Lines = this.Split '\n'
        member this.SplitAt index =
            [|this.Substring(0, index); this.Substring(index)|]

    type Int32 with
        member this.Between lower upper =
            lower <= this && this <= upper

    type Char with
        member this.Ascii = int this
        member this.IsUpperCase =
            this.Ascii.Between 65 90
