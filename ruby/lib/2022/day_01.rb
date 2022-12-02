def rations_to_calories(rations)
  rations.split("\n").map(&:to_i).sum
end

def elves_to_calories(elves)
  elves
    .split("\n\n")
    .map{|elf_rations| rations_to_calories elf_rations}
end

def day_1_part_1(elves)
  return 0 if elves.empty?
  elves_to_calories(elves).max
end

def day_1_part_2(elves)
  return 0 if elves.empty?
  elves_to_calories(elves)
    .sort_by {|calories| -calories}
    .take(3)
    .sum
end
