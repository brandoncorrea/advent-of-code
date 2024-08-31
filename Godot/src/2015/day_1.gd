class_name Day1Year2015

var Util = preload("res://src/util.gd")

func part_1(n):
  return Util.sum_by(direction, n)

func part_2(n):
  var position = 0
  var floor = 0

  for c in n:
    position += 1
    floor += direction(c)
    if in_basement(floor):
      return position

  return -1

func in_basement(floor):
  return floor == -1

func direction(parenthese):
  match parenthese:
    "(":
      return 1
    ")":
      return -1
    _:
      return 0
