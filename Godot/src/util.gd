class_name Util

static func sum_by(f, coll):
  var total = 0
  for i in coll:
    total += f.call(i)
  return total

static func is_whitespace(s):
  var re = RegEx.new()
  re.compile("[^\\s]")
  return re.search(s) == null

static func is_not_whitespace(s):
  return !is_whitespace(s)
