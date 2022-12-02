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

def total_scoring(score_map, rounds)
  rounds
    .split("\n")
    .map(&score_map)
    .sum
end

def part_1(n)
  total_scoring PART_1_SCORING, n
end

def part_2(n)
  total_scoring PART_2_SCORING, n
end
