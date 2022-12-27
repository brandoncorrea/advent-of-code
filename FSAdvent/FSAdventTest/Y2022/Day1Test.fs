module FSAdventTest.Y2022.Day1Test
open FSAdvent.Y2022
open FSAdventTest
open NUnit.Framework

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
    Assert.AreEqual(24000, Day1.part1(TestData.sample 2022 1))

[<Test>]
let Part1InputData() =
    Assert.AreEqual(72511, Day1.part1(TestData.input 2022 1))

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
    Assert.AreEqual(45000, Day1.part2(TestData.sample 2022 1))

[<Test>]
let Part2InputData() =
    Assert.AreEqual(212117, Day1.part2(TestData.input 2022 1))
