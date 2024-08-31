class_name Day1Year2015

var Util = preload("res://src/util.gd")

func part_1(n):
  return Util.sum_by(direction, n)

func direction(parenthese):
  match parenthese:
    "(":
      return 1
    ")":
      return -1
    _:
      return 0
