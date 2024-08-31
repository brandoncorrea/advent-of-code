class_name Util

static func sum_by(f, coll):
  var total = 0
  for i in coll:
    total += f.call(i)
  return total
