
var Util = preload("res://src/util.gd")

func part_1(input):
	var boxes = Array(input.split("\n")).filter(Util.is_not_whitespace)
	return Util.sum_by(paper_for, boxes)

func paper_for(s):
	var dimensions = create_dimensions(s)
	var area_a = dimensions.length * dimensions.width
	var area_b = dimensions.length * dimensions.height
	var area_c = dimensions.width * dimensions.height
	return 2 * (area_a + area_b + area_c) + min(area_a, area_b, area_c)

func create_dimensions(s):
	var parts = s.split("x")
	return {
		"length": parts[0].to_int(),
		"width": parts[1].to_int(),
		"height": parts[2].to_int()
	}
