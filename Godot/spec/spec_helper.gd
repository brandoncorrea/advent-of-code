class_name SpecHelper

static func puzzle_input(year, day):
  var path = "../input/%d/day_%02d.txt" % [year, day]
  return FileAccess.open(path, FileAccess.READ).get_as_text()
