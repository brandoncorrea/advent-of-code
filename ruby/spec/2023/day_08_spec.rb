require '2023/day_08'

# https://adventofcode.com/2023/day/8

input_data = input_data 2023, 8
sample_data = sample_data 2023, 8

describe "Advent 2023 Day 8" do
  let(:advent) { Year_2023_Day_8 }

  context "Part 1" do
    it "one step" do
      input = "L

AAA = (ZZZ, ZZZ)
ZZZ = (ZZZ, ZZZ)"
      expect(advent.part_1 input).to eq 1
    end

    it "two steps" do
      input = "L\n\nAAA = (BBB, BBB)\nBBB = (ZZZ, ZZZ)\nZZZ = (ZZZ, ZZZ)"
      expect(advent.part_1 input).to eq 2
    end

    it "two steps with lots of fuzz" do
      input = "LR

AAA = (CCC, BBB)
BBB = (BBB, BBB)
CCC = (AAA, ZZZ)
DDD = (AAA, FFF)
ZZZ = (ZZZ, ZZZ)"
      expect(advent.part_1 input).to eq 2
    end

    it "repeats steps twice" do
      input = "LLR

AAA = (BBB, BBB)
BBB = (AAA, ZZZ)
ZZZ = (ZZZ, ZZZ)"
      expect(advent.part_1 input).to eq 6
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 2
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 13301
    end
  end

  context "Part 2" do
    # it "Solves Part 2" do
    #   expect(advent.part_2 "").to eq -1
    # end

    it "sample data" do
      input = "LR

11A = (11B, XXX)
11B = (XXX, 11Z)
11Z = (11B, XXX)
22A = (22B, XXX)
22B = (22C, 22C)
22C = (22Z, 22Z)
22Z = (22B, 22B)
XXX = (XXX, XXX)"
      expect(advent.part_2 input).to eq 6
    end

    it "input data" do
      # expect(advent.part_2 input_data).to eq -1
    end
  end
end
