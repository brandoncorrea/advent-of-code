module FSAdventTest.Y2022.Day3Test
open FSAdvent.Y2022
open FSAdventTest
open NUnit.Framework

[<Test>]
[<TestCase("", 0)>]
[<TestCase("aa", 1)>]
[<TestCase("bb", 2)>]
[<TestCase("AA", 27)>]
[<TestCase("ABBa", 28)>]
[<TestCase("ABBa\nbulb", 30)>]
let Part1 (input, expected) =
    Assert.AreEqual(expected, Day3.part1 input)

[<Test>]
let Part1SampleData() =
    Assert.AreEqual(157, Day3.part1(TestData.sample 2022 3))

[<Test>]
let Part1InputData() =
    Assert.AreEqual(8243, Day3.part1(TestData.input 2022 3))

[<Test>]
[<TestCase("", 0)>]
[<TestCase("aa\nab", 1)>]
[<TestCase("bb\nab", 2)>]
[<TestCase("AA\nAB", 27)>]
[<TestCase("ABBa\nBxyz", 28)>]
[<TestCase("ABBa\nBulb\nBroccoli", 28)>]
let Part2 (input, expected) =
    Assert.AreEqual(expected, Day3.part2 input)

[<Test>]
let Part2SampleData() =
    Assert.AreEqual(70, Day3.part2(TestData.sample 2022 3))

[<Test>]
let Part2InputData() =
    Assert.AreEqual(2631, Day3.part2(TestData.input 2022 3))
