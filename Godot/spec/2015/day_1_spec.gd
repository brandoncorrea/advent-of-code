extends "res://addons/gspec/gspec.gd"

var Sut = preload("res://src/2015/day_1.gd")
var SpecHelper = preload("res://spec/spec_helper.gd")

func part_1(input):
	return Sut.new().part_1(input)

func test_going_nowhere():
	should_eq(0, part_1(""))

func test_goes_up_one_floor():
	should_eq(1, part_1("("))

func test_goes_down_one_floor():
	should_eq(-1, part_1(")"))

func test_goes_up_two_floors():
	should_eq(2, part_1("(("))

func test_garbage_is_skipped():
	should_eq(-1, part_1("(ab ))"))

func test_puzzle_input():
	var input = SpecHelper.puzzle_input(2015, 1)
	should_eq(232, part_1(input))
