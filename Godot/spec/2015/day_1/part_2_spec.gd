extends "res://addons/gspec/gspec.gd"

var SpecHelper = preload("res://spec/spec_helper.gd")

var sut = preload("res://src/2015/day_1.gd").new()

func test_empty_input():
	should_eq(-1, sut.part_2(""))

func test_never_enters_basement():
	should_eq(-1, sut.part_2("((("))

func test_enters_basement_on_first_move():
	should_eq(1, sut.part_2(")"))

func test_enters_basement_on_third_move():
	should_eq(3, sut.part_2("())"))

func test_puzzle_input():
	var input = SpecHelper.puzzle_input(2015, 1)
	should_eq(1783, sut.part_2(input))
