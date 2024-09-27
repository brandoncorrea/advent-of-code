module FSAdventTest.Y2015.Day3Test
open FSAdvent.Y2015
open NUnit.Framework
open FSAdventTest

[<Test>]
[<TestCase("", 0)>]
[<TestCase("\n \n\n", 0)>]
[<TestCase("1x1x1", 7)>]
[<TestCase("2x2x2", 28)>]
[<TestCase("1x1x1\n2x2x2", 35)>]
[<TestCase("2x3x4", 58)>]
[<TestCase("1x1x10", 43)>]
let Part1 (input, expected) =
    Assert.AreEqual(expected, Day2.part1(input))

[<Test>]
let Part1InputData() =
    Assert.AreEqual(1588178, Day2.part1(TestData.input 2015 2))
