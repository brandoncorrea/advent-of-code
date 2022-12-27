module FSAdventTest.Y2022.Day2Test
open FSAdvent.Y2022
open FSAdventTest
open NUnit.Framework

[<Test>]
[<TestCase("", 0)>]
[<TestCase("A X", 4)>]
[<TestCase("A Y", 8)>]
[<TestCase("A Z", 3)>]
[<TestCase("B X", 1)>]
[<TestCase("B Y", 5)>]
[<TestCase("B Z", 9)>]
[<TestCase("C X", 7)>]
[<TestCase("C Y", 2)>]
[<TestCase("C Z", 6)>]
let Part1 (input, expected) =
    Assert.AreEqual(expected, Day2.part1 input)

[<Test>]
let Part1SampleData() =
    Assert.AreEqual(15, Day2.part1(TestData.sample 2022 2))

[<Test>]
let Part1InputData() =
    Assert.AreEqual(12772, Day2.part1(TestData.input 2022 2))

[<Test>]
[<TestCase("", 0)>]
[<TestCase("A X", 3)>]
[<TestCase("A Y", 4)>]
[<TestCase("A Z", 8)>]
[<TestCase("B X", 1)>]
[<TestCase("B Y", 5)>]
[<TestCase("B Z", 9)>]
[<TestCase("C X", 2)>]
[<TestCase("C Y", 6)>]
[<TestCase("C Z", 7)>]
let Part2 (input, expected) =
    Assert.AreEqual(expected, Day2.part2 input)

[<Test>]
let Part2SampleData() =
    Assert.AreEqual(12, Day2.part2(TestData.sample 2022 2))

[<Test>]
let Part2InputData() =
    Assert.AreEqual(11618, Day2.part2(TestData.input 2022 2))
