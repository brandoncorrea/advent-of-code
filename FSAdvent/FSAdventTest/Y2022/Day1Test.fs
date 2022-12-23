module FSAdventTest.Y2022

open NUnit.Framework
open System.IO
open FSAdvent.Y2022

module TestData =
    let sample = "1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000"
    let input() = File.ReadAllText("../../../../../input/2022/day_01.txt")

[<Test>]
[<TestCase("", 0)>]
[<TestCase("1", 1)>]
[<TestCase("2", 2)>]
[<TestCase("2\n3", 5)>]
[<TestCase("1\n\n2", 2)>]
[<TestCase("1\n\n2\n5", 7)>]
let Part1 (input, expected) =
    Assert.AreEqual(expected, Day1.part1 input)

[<Test>]
let Part1SampleData() =
    Assert.AreEqual(24000, Day1.part1 TestData.sample)

[<Test>]
let Part1InputData() =
    Assert.AreEqual(72511, Day1.part1(TestData.input()))

[<Test>]
[<TestCase("", 0)>]
[<TestCase("1", 1)>]
[<TestCase("2\n3", 5)>]
[<TestCase("2\n3\n\n4", 9)>]
[<TestCase("2\n3\n\n4\n\n5", 14)>]
[<TestCase("2\n3\n\n3\n\n4\n\n5", 14)>]
let Part2 (input, expected) =
    Assert.AreEqual(expected, Day1.part2 input)

[<Test>]
let Part2SampleData() =
    Assert.AreEqual(45000, Day1.part2 TestData.sample)

[<Test>]
let Part2InputData() =
    Assert.AreEqual(212117, Day1.part2(TestData.input()))
