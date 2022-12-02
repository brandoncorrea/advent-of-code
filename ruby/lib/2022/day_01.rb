def rations_to_calories(rations)
  rations.split("\n").map(&:to_i).sum
end

def elves_to_calories(elves)
  elves
    .split("\n\n")
    .map &method(:rations_to_calories)
end

def part_1(elves)
  return 0 if elves.empty?
  elves_to_calories(elves).max
end

def part_2(elves)
  return 0 if elves.empty?
  elves_to_calories(elves)
    .sort_by {|calories| -calories}
    .take(3)
    .sum
end
