extends "res://addons/gspec/gspec.gd"

var SpecHelper = preload("res://spec/spec_helper.gd")
var puzzle_input = SpecHelper.puzzle_input(2015, 1)
var sut = preload("res://src/2015/day_1.gd").new()

func test_going_nowhere():
	should_eq(0, sut.part_1(""))

func test_goes_up_one_floor():
	should_eq(1, sut.part_1("("))

func test_goes_down_one_floor():
	should_eq(-1, sut.part_1(")"))

func test_goes_up_two_floors():
	should_eq(2, sut.part_1("(("))

func test_garbage_is_skipped():
	should_eq(-1, sut.part_1("(ab ))"))

func test_puzzle_input():
	should_eq(232, sut.part_1(puzzle_input))
