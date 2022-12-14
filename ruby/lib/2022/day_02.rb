require 'string'

class Year_2022_Day_2
  PART_1_SCORING = { 'A X' => 4,
                     'A Y' => 8,
                     'A Z' => 3,
                     'B X' => 1,
                     'B Y' => 5,
                     'B Z' => 9,
                     'C X' => 7,
                     'C Y' => 2,
                     'C Z' => 6 }

  PART_2_SCORING = { 'A X' => 3,
                     'A Y' => 4,
                     'A Z' => 8,
                     'B X' => 1,
                     'B Y' => 5,
                     'B Z' => 9,
                     'C X' => 2,
                     'C Y' => 6,
                     'C Z' => 7 }

  class << self
    def part_1(n) total_scoring PART_1_SCORING, n end
    def part_2(n) total_scoring PART_2_SCORING, n end

    def total_scoring(score_map, rounds)
      rounds.chomp_lines.map(&score_map).sum
    end
  end
end
