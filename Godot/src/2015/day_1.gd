class_name Day1Year2015

func part_1(n):
  return sum_by(direction, n)

func direction(parenthese):
  match parenthese:
    "(":
      return 1
    ")":
      return -1
    _:
      return 0

func sum_by(f, coll):
  var total = 0
  for i in coll:
    total += f.call(i)
  return total
