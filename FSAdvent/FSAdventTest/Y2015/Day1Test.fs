module FSAdventTest.Y2015.Day1Test
open FSAdvent.Y2015
open FSAdvent.Core.Extensions
open FSAdventTest
open NUnit.Framework

[<Test>]
[<TestCase("", 0)>]
[<TestCase("(", 1)>]
[<TestCase("((", 2)>]
[<TestCase("(()", 1)>]
[<TestCase("(())", 0)>]
[<TestCase("()()", 0)>]
[<TestCase("(((", 3)>]
[<TestCase("(()(()(", 3)>]
[<TestCase("))(((((", 3)>]
[<TestCase("())", -1)>]
[<TestCase("))(", -1)>]
[<TestCase(")))", -3)>]
[<TestCase(")())())", -3)>]
let Part1 (input, expected) =
    Assert.AreEqual(expected, Day1.part1 input)

[<Test>]
let Part1Input() =
    Assert.AreEqual(232, Day1.part1(TestData.input 2015 1))

[<Test>]
[<TestCase("))(((((", 1)>]
[<TestCase("())", 3)>]
[<TestCase("))(", 1)>]
[<TestCase(")))", 1)>]
[<TestCase(")())())", 1)>]
let Part2 (input, expected) =
    Assert.AreEqual(expected, Day1.part2 input)

[<Test>]
let Part2Input() =
    Assert.AreEqual(1783, Day1.part2(TestData.input 2015 1))
