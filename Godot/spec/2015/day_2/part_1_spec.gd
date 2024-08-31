extends "res://addons/gspec/gspec.gd"

var SpecHelper = preload("res://spec/spec_helper.gd")
var puzzle_input = SpecHelper.puzzle_input(2015, 2)
var sut = preload("res://src/2015/day_2.gd").new()

func test_no_gifts():
  should_eq(0, sut.part_1(""))

func test_1x1x1():
  should_eq(7, sut.part_1("1x1x1"))

func test_2x1x1():
  should_eq(11, sut.part_1("2x1x1"))

func test_2x1x3():
  should_eq(24, sut.part_1("2x1x3"))

func test_multiple_boxes():
  should_eq(35, sut.part_1("2x1x3\n2x1x1"))

func test_puzzle_input():
  should_eq(1588178, sut.part_1(puzzle_input))
