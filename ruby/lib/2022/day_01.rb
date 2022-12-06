require 'numeric'

class Year_2022_Day_1
  class << self
    def part_1(elves) top_calories 1, elves end
    def part_2(elves) top_calories 3, elves end

    def top_calories(n, elves)
      elves
        .split("\n\n")
        .map(&method(:rations_to_calories))
        .sort_by(&:negate)
        .take(n)
        .sum
    end

    def rations_to_calories(rations)
      rations.lines.map(&:to_i).sum
    end
  end
end
