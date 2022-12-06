require '2022/day_03'

# https://adventofcode.com/2022/day/3

input_data = input_data 2022, 3
sample_data = "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\nPmmdzqPrVvPwwTWBwg\nwMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\nttgJtRGJQctTZtZT\nCrZsJsPPZsGzwwsLwLmpwMDw"

describe "Advent 2022 Day 3" do
  let(:advent) { Year_2022_Day_3 }

  context "Part 1" do
    it "Solves Part 1" do
      expect(advent.part_1 "aa").to eq 1
      expect(advent.part_1 "AA").to eq 27
      expect(advent.part_1 "bb").to eq 2
      expect(advent.part_1 "XbYb").to eq 2
      expect(advent.part_1 "vJrwpWtwJgWrhcsFMMfFFhFp").to eq 16
      expect(advent.part_1 "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL").to eq 54
      expect(advent.part_1 sample_data).to eq 157
      expect(advent.part_1 input_data).to eq 8243
    end
  end

  context "Part 2" do
    it "Solves Part 2" do
      expect(advent.part_2 "a\na\na").to eq 1
      expect(advent.part_2 "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\nPmmdzqPrVvPwwTWBwg").to eq 18
      expect(advent.part_2 "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\nttgJtRGJQctTZtZT\nCrZsJsPPZsGzwwsLwLmpwMDw").to eq 52
      expect(advent.part_2 sample_data).to eq 70
      expect(advent.part_2 input_data).to eq 2631
    end
  end
end
